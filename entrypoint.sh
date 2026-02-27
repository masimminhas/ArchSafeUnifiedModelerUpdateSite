#!/bin/bash
set -e

echo "=========================================="
echo "  ArchSafe Unified Modeler"
echo "  VNC  → port ${VNC_PORT}"
echo "  noVNC → http://localhost:${NOVNC_PORT}/vnc.html"
echo "  VNC password: ${VNC_PW}"
echo "=========================================="

mkdir -p /home/archsafe/workspace

# ✅ Run supervisord as root - no privilege drop needed
exec /usr/bin/supervisord -n -c /etc/supervisor/conf.d/supervisord.conf