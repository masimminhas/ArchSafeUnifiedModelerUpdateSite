# ArchSafe Unified Modeler – Update Site & Distribution

> **Metamodel:** `nsURI="http://edu.kit.sdq.dsis.metamodel/unified"`
> **Source:** <https://github.com/masimminhas/ArchSafeUnifiedModelerUpdateSite>

## Project Structure

```
ArchSafeUnifiedModelerUpdateSite/
├── pom.xml                                       ← Root Tycho / Maven POM
│
├── edu.kit.sdq.dsis.metamodel.unified/           ← Core metamodel plug-in
├── edu.kit.sdq.dsis.metamodel.unified.edit/      ← EMF Edit plug-in
├── edu.kit.sdq.dsis.metamodel.unified.editor/    ← Tree/form editor plug-in
├── edu.kit.sdq.dsis.metamodel.unified.design/    ← Sirius .odesign plug-in
│
├── releng/
│   ├── edu.kit.sdq.dsis.target/                  ← Tycho target platform
│   ├── edu.kit.sdq.dsis.updatesite/              ← P2 update site (category.xml)
│   ├── edu.kit.sdq.dsis.rcp/                     ← RCP feature
│   └── edu.kit.sdq.dsis.product/                 ← .product + director config
│
├── docker/
│   ├── Dockerfile                                ← Multi-stage build → runtime
│   └── docker-compose.yml
│
└── .github/
    └── workflows/
        └── build.yml                             ← CI: build + release + docker
```

## GitHub Actions Outputs

| Job | Artefact | Description |
|-----|----------|-------------|
| `build` | `update-site` | P2 repository (install via *Help › Install New Software…*) |
| `build` | `rcp-linux-gtk-x86_64` | Standalone tool – Linux |
| `build` | `rcp-win32-x86_64` | Standalone tool – Windows |
| `build` | `rcp-macos-x86_64` | Standalone tool – macOS Intel |
| `build` | `rcp-macos-aarch64` | Standalone tool – macOS Apple Silicon |
| `docker` | `ghcr.io/<owner>/archsafeunifiedmodeler` | Container image |
| `release` | GitHub Release assets | Tagged ZIPs attached to release |

### Trigger a release

```bash
git tag v1.0.0 && git push origin v1.0.0
```

## Local Build

```bash
# Prerequisites: JDK 17+, Maven 3.9+, Xvfb (Linux/macOS)
mvn -B clean verify
```

## Docker

```bash
# Pull latest image
docker pull ghcr.io/masimminhas/archsafeunifiedmodeler:latest

# Run headless with your workspace mounted
docker run --rm \
  -v "$PWD/workspace:/workspace" \
  ghcr.io/masimminhas/archsafeunifiedmodeler:latest \
  --data /workspace

# Or use Docker Compose
cd docker && docker compose up
```

## Installing via Update Site

1. Open Eclipse / ArchSafe Unified Modeler
2. *Help › Install New Software…*
3. Add: `https://masimminhas.github.io/ArchSafeUnifiedModelerUpdateSite/` *(if GitHub Pages is configured)*
   or paste the locally built `releng/edu.kit.sdq.dsis.updatesite/target/repository/` path.

## Contributing

Import all four plug-in projects plus the `releng/` modules into an Eclipse IDE with Tycho support.
