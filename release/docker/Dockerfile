# ╔══════════════════════════════════════════════════════════════════╗
# ║  ArchSafeUnified Modeling Workbench  –  Docker Image            ║
# ║  ArchSafeUnified Modeling Workbench                                              ║
# ║                                                                ║
# ║  Provides a fully running Eclipse + ArchSafeUnified Modeling Tool║
# ║  accessible via any web browser — zero installation required.  ║
# ║                                                                ║
# ║  Usage:                                                        ║
# ║    docker run -p 6080:6080 ghcr.io/masimminhas/ArchSafeUnifiedModelerUpdateSite:latest   ║
# ║    → Open http://localhost:6080 in your browser                ║
# ║                                                                ║
# ║  Stack:  Ubuntu 22.04 · Xvfb · Openbox · x11vnc · noVNC       ║
# ║          OpenJDK 17 · Eclipse 2024-03 + ArchSafeUnified Modeling Workbench plugin    ║
# ╚══════════════════════════════════════════════════════════════════╝

# ── Stage 1: Build the RCP product ──────────────────────────────────
FROM maven:3.9.6-eclipse-temurin-17 AS builder

LABEL stage=builder

WORKDIR /build

# Copy the entire Maven/Tycho project
COPY . .

# Build update site + RCP product for Linux
# -T 1C  = parallel build using one thread per CPU core
# -B     = batch mode (no color, no progress bars — cleaner CI logs)
RUN mvn clean package \
      -T 1C -B \
      -pl releng/edu.kit.sdq.dsis.unified.product \
      -am \
      --no-transfer-progress \
      -Denvironments="linux,gtk,x86_64"

# ── Stage 2: Runtime image ───────────────────────────────────────────
FROM ubuntu:22.04

LABEL org.opencontainers.image.title="ArchSafe Unified Modeling Tool"
LABEL org.opencontainers.image.description="ISO 26262 safety modeling for Eclipse – browser accessible via noVNC"
LABEL org.opencontainers.image.url="https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite"
LABEL org.opencontainers.image.source="https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite"
LABEL org.opencontainers.image.licenses="EPL-2.0"
LABEL org.opencontainers.image.vendor="ArchSafeUnified Project"

# ── System dependencies ──────────────────────────────────────────────
ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update && apt-get install -y --no-install-recommends \
    # Virtual display
    xvfb \
    # Lightweight window manager (Openbox)
    openbox \
    # VNC server
    x11vnc \
    # noVNC web client dependencies
    websockify \
    python3 \
    python3-pip \
    # Java 17 runtime (the RCP product includes JustJ but this is a fallback)
    openjdk-17-jre-headless \
    # GTK3 for Eclipse SWT on Linux
    libgtk-3-0 \
    libwebkit2gtk-4.0-37 \
    libglib2.0-0 \
    libx11-6 \
    libxext6 \
    libxrender1 \
    libxtst6 \
    libxi6 \
    libglu1-mesa \
    # Fonts (Eclipse needs at least one font family)
    fonts-dejavu-core \
    fonts-liberation \
    # File utilities
    wget \
    unzip \
    curl \
    && rm -rf /var/lib/apt/lists/*

# ── Install noVNC ────────────────────────────────────────────────────
ENV NOVNC_VERSION=1.4.0
RUN wget -q https://github.com/novnc/noVNC/archive/refs/tags/v${NOVNC_VERSION}.tar.gz \
      -O /tmp/novnc.tar.gz \
    && tar -xzf /tmp/novnc.tar.gz -C /opt \
    && mv /opt/noVNC-${NOVNC_VERSION} /opt/novnc \
    && ln -s /opt/novnc/vnc.html /opt/novnc/index.html \
    && rm /tmp/novnc.tar.gz

# ── Copy the built RCP product from the builder stage ────────────────
COPY --from=builder \
    /build/releng/edu.kit.sdq.dsis.unified.product/target/products/edu.kit.sdq.dsis.unified.product/linux/gtk/x86_64/ \
    /opt/ArchSafe-unified/

# ── Copy the example model into a pre-configured workspace ───────────
# The example model ships with the repo under examples/
# It is placed so the tool opens it immediately on first launch.
COPY docker/example-workspace/ /root/archsafe-unified-workspace/

# ── Copy runtime scripts ─────────────────────────────────────────────
COPY docker/entrypoint.sh /entrypoint.sh
COPY docker/openbox-autostart.sh /etc/xdg/openbox/autostart
RUN chmod +x /entrypoint.sh /opt/archsafe-unified/archsafe-unified

# ── Environment variables ─────────────────────────────────────────────
ENV DISPLAY=:1
ENV SCREEN_WIDTH=1600
ENV SCREEN_HEIGHT=900
ENV SCREEN_DEPTH=24
ENV VNC_PASSWORD=dsis2024
ENV TOOL_WORKSPACE=/root/dsis-unified-workspace

# ── Port: noVNC web interface ─────────────────────────────────────────
EXPOSE 6080

# ── Healthcheck ──────────────────────────────────────────────────────
HEALTHCHECK --interval=15s --timeout=5s --start-period=30s --retries=3 \
    CMD curl -f http://localhost:6080/ || exit 1

ENTRYPOINT ["/entrypoint.sh"]
