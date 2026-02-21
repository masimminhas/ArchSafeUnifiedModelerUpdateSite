# ArchSafeUnified Modeling Workbench

**ISO 26262 functional safety modeling for Eclipse**  


[![Build](https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite/actions/workflows/release.yml/badge.svg)](https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite/actions)
[![License: EPL-2.0](https://img.shields.io/badge/License-EPL%202.0-blue.svg)](https://www.eclipse.org/legal/epl-2.0/)
[![Eclipse](https://img.shields.io/badge/Eclipse-2024--03-orange)](https://www.eclipse.org/downloads/)
[![Sirius](https://img.shields.io/badge/Sirius-7.3-brightgreen)](https://www.eclipse.org/sirius/)

---

## Quick Install

### Reviewers — fastest option (zero installation)

```bash
docker run -p 6080:6080 ghcr.io/masimminhas/ArchSafeUnifiedModelerUpdateSite:latest
# Open http://localhost:6080  |  Password: dsis2024
```

### Eclipse users — update site

1. **Help → Install New Software → Add...**
2. URL: `https://masimminhas.github.io/ArchSafeUnifiedModelerUpdateSite/updatesite/`
3. Select **ArchSafeUnified Modeling Workbench** → Install → Restart

### Standalone download (no Eclipse required)

| Platform | Download |
|---|---|
| Windows x64 | [dsis-unified-win32.win32.x86_64.zip](https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite/releases/latest) |
| Linux x64 | [dsis-unified-linux.gtk.x86_64.tar.gz](https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite/releases/latest) |
| macOS Intel | [dsis-unified-macosx.cocoa.x86_64.tar.gz](https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite/releases/latest) |
| macOS Apple Silicon | [dsis-unified-macosx.cocoa.aarch64.tar.gz](https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite/releases/latest) |

---

## Project Structure

```
ArchSafeUnifiedModelerUpdateSite/
├── pom.xml                                      ← Root parent POM (Tycho build)
│
├── plugins/
│   ├── edu.kit.sdq.dsis.metamodel.unified/      ← EMF metamodel plugin
│   └── edu.kit.sdq.dsis.metamodel.unified.design/ ← Sirius odesign + Java actions
│
├── releng/
│   ├── edu.kit.sdq.dsis.unified.target/         ← Target platform (Eclipse+Sirius versions)
│   ├── edu.kit.sdq.dsis.unified.feature/        ← Eclipse Feature (installable unit)
│   ├── edu.kit.sdq.dsis.unified.repository/     ← P2 update site
│   └── edu.kit.sdq.dsis.unified.product/        ← Standalone RCP product
│
├── docker/
│   ├── Dockerfile                               ← Browser-accessible Docker image
│   ├── docker-compose.yml                       ← One-command reviewer launch
│   └── entrypoint.sh                            ← Container startup script
│
├── docs/
│   └── index.html                               ← GitHub Pages landing page
│
└── .github/
    └── workflows/
        └── release.yml                          ← CI/CD pipeline
```

---

## Building from Source

### Prerequisites

| Tool | Version |
|---|---|
| Java JDK | 17+ |
| Maven | 3.9+ |
| Internet access | Required (downloads Eclipse/Sirius) |

### Build everything

```bash
git clone https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite.git
cd ArchSafeUnifiedModelerUpdateSite
mvn clean package
```

**Output:**

| Artifact | Location |
|---|---|
| P2 update site | `releng/edu.kit.sdq.dsis.unified.repository/target/repository/` |
| Windows zip | `releng/edu.kit.sdq.dsis.unified.product/target/products/dsis-unified-win32.win32.x86_64.zip` |
| Linux tar.gz | `releng/edu.kit.sdq.dsis.unified.product/target/products/dsis-unified-linux.gtk.x86_64.tar.gz` |
| macOS tar.gz | `releng/edu.kit.sdq.dsis.unified.product/target/products/dsis-unified-macosx.cocoa.*.tar.gz` |

### Build only the update site

```bash
mvn clean package -pl releng/edu.kit.sdq.dsis.unified.repository -am
```

### Build and run Docker locally

```bash
# Build image from source
docker build -f docker/Dockerfile -t dsis-unified:local .

# Run it
docker run -p 6080:6080 dsis-unified:local

# Or with docker compose
cd docker && docker compose up
```

---

## Releasing a New Version

1. Update version numbers across all POMs:
   ```bash
   mvn tycho-versions:set-version -DnewVersion=1.1.0
   git add -A && git commit -m "chore: bump version to 1.1.0"
   ```

2. Create and push a version tag:
   ```bash
   git tag v1.1.0
   git push origin v1.1.0
   ```

3. GitHub Actions automatically:
   - Builds all artifacts
   - Publishes the P2 update site to GitHub Pages
   - Creates a GitHub Release with all download assets
   - Builds and pushes the Docker image to `ghcr.io`

---

## Supported Diagrams

| Diagram | ISO 26262 Reference |
|---|---|
| Architecture Diagram | ISO 26262-4 §6 |
| Safety Diagram | ISO 26262-3 §7 |
| FMEA Diagram | ISO 26262-8 §7 |
| Requirements Diagram | ISO 26262-4 §6.4 |
| Traceability Diagram | ISO 26262-2 §6.4 |
| Failure Propagation Simulation | ISO 26262-9 §7 |
| Metrics Dashboard | — |
| Metrics Table | — |
| FMEA Table | ISO 26262-8 §7 |

---

## License

Eclipse Public License 2.0 — see [LICENSE](LICENSE).  
Free for academic and research use.  
See [NOTICE](NOTICE) for third-party acknowledgements.
