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

# Only the window manager (xfwm4), not the full xfce4 desktop meta-package —
# that alone saves several hundred MB of image size. dbus is required by
# xfwm4 (xfconf) and GTK/dconf; adwaita-icon-theme + librsvg2-common +
# shared-mime-info give GTK its icons and SVG pixbuf loader.
RUN apt-get update -qq \
 && apt-get install -y --no-install-recommends \
      libgtk-3-0 \
      libwebkit2gtk-4.1-0 \
      libglib2.0-0 \
      libx11-6 libxext6 libxrender1 libxtst6 libxi6 libxrandr2 \
      xvfb \
      supervisor \
      x11vnc \
      xfwm4 \
      xdotool \
      dbus dbus-x11 \
      adwaita-icon-theme librsvg2-common shared-mime-info \
      fonts-dejavu-core \
      procps \
      wget \
      python3-websockify \
 && wget -qO- https://github.com/novnc/noVNC/archive/refs/tags/v1.4.0.tar.gz \
    | tar -xzC /opt && mv /opt/noVNC-1.4.0 /opt/novnc \
 && dbus-uuidgen --ensure \
 && rm -rf /var/lib/apt/lists/*

# Copy RCP product
COPY --from=builder \
  /build/releng/edu.kit.sdq.dsis.product/target/products/edu.kit.sdq.dsis.product/linux/gtk/x86_64 \
  /opt/archsafe

RUN chmod +x /opt/archsafe/ArchSafeUnifiedModeler

# Modest heap bounds so startup is predictable regardless of host RAM
RUN printf -- '-vmargs\n-Xms512m\n-Xmx2g\n' \
      >> /opt/archsafe/ArchSafeUnifiedModeler/ArchSafeUnifiedModeler.ini

# Bake the one-time OSGi/p2 configuration initialization into the image so
# the first container start does not pay for it (this is what -initialize
# does; it must NOT be part of the runtime command — it exits without a GUI).
RUN /opt/archsafe/ArchSafeUnifiedModeler/ArchSafeUnifiedModeler \
      -nosplash -initialize -data /tmp/init-ws \
 && rm -rf /tmp/init-ws

# ── Copy case study models into the default workspace ──────────────────────────
COPY casestudies/ /home/archsafe/workspace/

# Copy supervisord config and entrypoint
COPY docker/supervisord.conf /etc/supervisor/conf.d/supervisord.conf
COPY docker/maximize.sh /usr/local/bin/archsafe-maximize.sh
COPY docker/keep-visible.sh /usr/local/bin/archsafe-keep-visible.sh
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh \
             /usr/local/bin/archsafe-maximize.sh \
             /usr/local/bin/archsafe-keep-visible.sh

# ✅ Must run as ROOT so supervisord can manage child processes
USER root

ENV DISPLAY=:99
ENV VNC_PORT=5900
ENV NOVNC_PORT=6080
# Passwordless by default: the browser connects with zero clicks. Set
# VNC_PW at `docker run -e VNC_PW=...` to require a password instead.
ENV VNC_PW=""

EXPOSE 5900 6080

# Healthy = noVNC answers AND the modeler process is alive
HEALTHCHECK --interval=15s --timeout=5s --start-period=120s --retries=3 \
  CMD pgrep -f 'ArchSafeUnifiedModeler' >/dev/null \
   && wget -q -O /dev/null http://localhost:${NOVNC_PORT}/ || exit 1

ENTRYPOINT ["/entrypoint.sh"]
