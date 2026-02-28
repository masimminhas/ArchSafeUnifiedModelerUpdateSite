# ArchSafe Unified Modeler – Case Studies

This folder contains example modeling projects that are automatically
pre-loaded into the workspace when running the Docker image.

## Included Case Studies

| Project | Description |
|---------|-------------|
| `automotive-brake-system/` | ISO 26262 safety analysis of an automotive brake system |
| `autonomous-driving/` | Architecture and FMEA for an autonomous driving system |

## How to Use

### Via Docker (automatic)
All projects are pre-loaded in the workspace. Just run:
```bash
docker run -d -p 6080:6080 -p 5900:5900 \
  --name archsafe-modeler \
  ghcr.io/masimminhas/archsafeunifiedmodeler:latest
```
Open **http://localhost:6080/vnc.html** → the projects are already in the workspace.

### Via Eclipse Update Site
1. Install the tool from `https://masimminhas.github.io/ArchSafeUnifiedModelerUpdateSite/`
2. Download this folder and import the projects:
   **File → Import → General → Existing Projects into Workspace**
