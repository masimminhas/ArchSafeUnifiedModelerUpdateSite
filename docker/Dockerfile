# ──────────────────────────────────────────────────────────────────────────────
# Stage 1: Build
# ──────────────────────────────────────────────────────────────────────────────
FROM eclipse-temurin:17-jdk AS builder

LABEL org.opencontainers.image.title="ArchSafe Unified Modeler – Builder"
LABEL org.opencontainers.image.source="https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite"

# Maven
ARG MAVEN_VERSION=3.9.6
RUN apt-get update -qq && apt-get install -y --no-install-recommends curl ca-certificates xvfb \
 && curl -fsSL "https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz" \
    | tar -xzC /opt \
 && ln -s "/opt/apache-maven-${MAVEN_VERSION}/bin/mvn" /usr/local/bin/mvn \
 && rm -rf /var/lib/apt/lists/*

WORKDIR /build
COPY . .

# Build: update site + RCP products
RUN xvfb-run --auto-servernum --server-args="-screen 0 1024x768x24" \
    mvn -B -ntp clean verify \
        -Dtycho.disableP2Mirrors=false \
        -Dmaven.test.skip=true

# ──────────────────────────────────────────────────────────────────────────────
# Stage 2: Runtime – headless Eclipse RCP on Linux/GTK
# ──────────────────────────────────────────────────────────────────────────────
# ✅ Pin to jammy (Ubuntu 22.04) explicitly and use webkit2gtk-4.1
FROM eclipse-temurin:17-jre-jammy AS runtime

LABEL org.opencontainers.image.title="ArchSafe Unified Modeler"
LABEL org.opencontainers.image.description="Headless ArchSafe Unified Modeler Eclipse RCP"
LABEL org.opencontainers.image.source="https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite"

RUN apt-get update -qq \
 && apt-get install -y --no-install-recommends \
      libgtk-3-0 \
      # ✅ webkit2gtk-4.0-37 removed in Ubuntu 22.04 — use 4.1 instead
      libwebkit2gtk-4.1-0 \
      libglib2.0-0 \
      libx11-6 \
      libxext6 \
      libxrender1 \
      libxtst6 \
      libxi6 \
      libxrandr2 \
      xvfb \
 && rm -rf /var/lib/apt/lists/*

# Copy materialised Linux GTK product from builder
COPY --from=builder \
  /build/releng/edu.kit.sdq.dsis.product/target/products/edu.kit.sdq.dsis.product/linux/gtk/x86_64 \
  /opt/archsafe

RUN chmod +x /opt/archsafe/ArchSafeUnifiedModeler

# Entry point: start headless via Xvfb or accept a real DISPLAY
ENV DISPLAY=:99
EXPOSE 0

ENTRYPOINT ["sh", "-c", "Xvfb :99 -screen 0 1024x768x24 & exec /opt/archsafe/ArchSafeUnifiedModeler \"$@\"", "--"]
CMD ["--help"]