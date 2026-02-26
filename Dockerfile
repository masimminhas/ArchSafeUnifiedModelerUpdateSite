# ============================================================
# Stage 1 – build the update site + RCP product with Tycho
# ============================================================
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /build

# Copy the full source tree
COPY . .

# Run the Tycho build (headless – Xvfb not needed for build stage)
RUN mvn -B -f pom.xml clean verify \
    -Dtycho.disableP2Mirrors=false \
    -Dmaven.test.skip=true \
    --no-transfer-progress

# ============================================================
# Stage 2 – lightweight runtime image with VNC + the RCP app
# ============================================================
FROM ubuntu:22.04

LABEL maintainer="KIT SDQ Group <sdq@kit.edu>"
LABEL description="ArchSafe Unified Modeler – Eclipse RCP running inside a VNC/noVNC container"
LABEL org.opencontainers.image.source="https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite"

ENV DEBIAN_FRONTEND=noninteractive
ENV DISPLAY=:1
ENV VNC_PORT=5900
ENV NOVNC_PORT=6080
ENV VNC_RESOLUTION=1600x900
ENV VNC_DEPTH=24
ENV VNC_PW=archsafe

# ── system dependencies ───────────────────────────────────────
RUN apt-get update && apt-get install -y --no-install-recommends \
    # Java runtime
    openjdk-17-jre-headless \
    # Virtual display
    xvfb \
    x11vnc \
    xterm \
    openbox \
    # noVNC web-based VNC client
    novnc \
    websockify \
    # SWT / GTK dependencies
    libgtk-3-0 \
    libwebkit2gtk-4.0-37 \
    libcanberra-gtk-module \
    libcanberra-gtk3-module \
    libglu1-mesa \
    mesa-utils \
    # utility
    wget curl ca-certificates supervisor \
    && rm -rf /var/lib/apt/lists/*

# ── copy built RCP product from builder stage ─────────────────
COPY --from=builder \
    /build/releng/edu.kit.sdq.dsis.product/target/products/edu.kit.sdq.dsis.product/linux/gtk/x86_64/ \
    /opt/ArchSafeUnifiedModeler/

RUN chmod +x /opt/ArchSafeUnifiedModeler/ArchSafeUnifiedModeler

# ── supervisord configuration ─────────────────────────────────
COPY docker/supervisord.conf /etc/supervisor/conf.d/supervisord.conf

# ── startup script ────────────────────────────────────────────
COPY docker/entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# ── create a non-root user ────────────────────────────────────
RUN useradd -m -s /bin/bash archsafe
USER archsafe
WORKDIR /home/archsafe

# ── ports ─────────────────────────────────────────────────────
# 5900 → VNC  |  6080 → noVNC (browser-based)
EXPOSE 5900 6080

ENTRYPOINT ["/entrypoint.sh"]
