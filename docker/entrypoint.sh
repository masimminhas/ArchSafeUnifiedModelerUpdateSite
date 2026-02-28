#!/bin/bash
set -e

echo "=========================================="
echo "  ArchSafe Unified Modeler"
echo "  VNC  → port ${VNC_PORT}"
echo "  noVNC → http://localhost:${NOVNC_PORT}/vnc.html"
echo "  VNC password: ${VNC_PW}"
echo "=========================================="

WORKSPACE=/home/archsafe/workspace
mkdir -p "${WORKSPACE}"

# ── Auto-import case study projects into Eclipse workspace metadata ────────────
# Eclipse requires a .location file in .metadata/.plugins/org.eclipse.core.resources/.projects/
# for each project to appear in the Project Explorer.
PROJECTS_META="${WORKSPACE}/.metadata/.plugins/org.eclipse.core.resources/.projects"
mkdir -p "${PROJECTS_META}"

for project_dir in "${WORKSPACE}"/*/; do
  # Skip non-directories and the .metadata folder itself
  [ -d "${project_dir}" ] || continue
  project_name=$(basename "${project_dir}")
  [ "${project_name}" = ".metadata" ] && continue

  # Only process if it has a .project file (valid Eclipse project)
  if [ -f "${project_dir}/.project" ]; then
    meta_dir="${PROJECTS_META}/${project_name}"
    if [ ! -d "${meta_dir}" ]; then
      echo "  → Registering project: ${project_name}"
      mkdir -p "${meta_dir}"
      # Write the .location binary stub Eclipse uses to locate the project
      # For projects inside the workspace, Eclipse finds them automatically
      # once the directory exists in .projects metadata
      touch "${meta_dir}/.location"
    fi
  fi
done

echo "  Case studies registered in workspace ✅"

# ✅ Run supervisord as root - no privilege drop needed
exec /usr/bin/supervisord -n -c /etc/supervisor/conf.d/supervisord.conf
