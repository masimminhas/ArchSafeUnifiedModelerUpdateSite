# ──────────────────────────────────────────────────────────────────────────────
# Stage 1: Build
# ──────────────────────────────────────────────────────────────────────────────
FROM eclipse-temurin:17-jdk-jammy AS builder

LABEL org.opencontainers.image.title="ArchSafe Unified Modeler – Builder"
LABEL org.opencontainers.image.source="https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite"

ARG MAVEN_VERSION=3.9.6
RUN apt-get update -qq && apt-get install -y --no-install-recommends curl ca-certificates xvfb \
 && curl -fsSL "https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz" \
    | tar -xzC /opt \
 && ln -s "/opt/apache-maven-${MAVEN_VERSION}/bin/mvn" /usr/local/bin/mvn \
 && rm -rf /var/lib/apt/lists/*

WORKDIR /build
COPY . .

RUN xvfb-run --auto-servernum --server-args="-screen 0 1024x768x24" \
    mvn -B -ntp clean verify \
        -Dtycho.disableP2Mirrors=false \
        -Dmaven.test.skip=true

# ──────────────────────────────────────────────────────────────────────────────
# Stage 2: Runtime
# ──────────────────────────────────────────────────────────────────────────────
FROM eclipse-temurin:17-jre-jammy AS runtime

LABEL org.opencontainers.image.title="ArchSafe Unified Modeler"
LABEL org.opencontainers.image.description="Headless ArchSafe Unified Modeler Eclipse RCP"
LABEL org.opencontainers.image.source="https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite"

RUN apt-get update -qq \
 && apt-get install -y --no-install-recommends \
      libgtk-3-0 \
      libwebkit2gtk-4.1-0 \
      libglib2.0-0 \
      libx11-6 libxext6 libxrender1 libxtst6 libxi6 libxrandr2 \
      xvfb \
      supervisor \
      x11vnc \
      xfce4 xfce4-terminal \
      wget \
      git \
      python3-websockify \
 && wget -qO- https://github.com/novnc/noVNC/archive/refs/tags/v1.4.0.tar.gz \
    | tar -xzC /opt && mv /opt/noVNC-1.4.0 /opt/novnc \
 && ln -s /opt/novnc/vnc.html /opt/novnc/index.html \
 && rm -rf /var/lib/apt/lists/*

# Copy RCP product
COPY --from=builder \
  /build/releng/edu.kit.sdq.dsis.product/target/products/edu.kit.sdq.dsis.product/linux/gtk/x86_64 \
  /opt/archsafe

RUN chmod +x /opt/archsafe/ArchSafeUnifiedModeler

# Copy supervisord config and entrypoint
COPY docker/supervisord.conf /etc/supervisor/conf.d/supervisord.conf
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# ✅ Must run as ROOT so supervisord can manage child processes
USER root

ENV DISPLAY=:99
ENV VNC_PORT=5900
ENV NOVNC_PORT=6080
ENV VNC_PW=archsafe

EXPOSE 5900 6080

ENTRYPOINT ["/entrypoint.sh"]
