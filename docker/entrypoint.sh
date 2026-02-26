#!/bin/bash
set -e

echo "=========================================="
echo "  ArchSafe Unified Modeler"
echo "  VNC  → port ${VNC_PORT}"
echo "  noVNC → http://localhost:${NOVNC_PORT}/vnc.html"
echo "  VNC password: ${VNC_PW}"
echo "=========================================="

# Create workspace directory if it doesn't exist
mkdir -p /home/archsafe/workspace

# Hand off to supervisord which manages all sub-processes
exec /usr/bin/supervisord -n -c /etc/supervisor/conf.d/supervisord.conf
