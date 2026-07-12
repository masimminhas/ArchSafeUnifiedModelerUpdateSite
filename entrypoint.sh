#!/bin/bash
set -e

# VNC auth: passwordless by default (local demo). Set VNC_PW to require a
# password (native VNC clients on port 5900; noVNC will prompt for it).
if [ -n "${VNC_PW}" ]; then
  export X11VNC_AUTH="-passwd ${VNC_PW}"
  PW_INFO="${VNC_PW}"
else
  export X11VNC_AUTH="-nopw"
  PW_INFO="(none - local demo mode)"
fi

echo "=========================================="
echo "  ArchSafe Unified Modeler"
echo "  Open   -> http://localhost:${NOVNC_PORT}"
echo "  VNC    -> port ${VNC_PORT} (optional, for native VNC clients)"
echo "  VNC password: ${PW_INFO}"
echo "=========================================="

mkdir -p /home/archsafe/workspace

# noVNC landing page: connect immediately, scale to the browser window, and
# reconnect automatically if the connection (or the app) restarts.
NOVNC_PARAMS="autoconnect=true&resize=scale&reconnect=true&reconnect_delay=2000"
rm -f /opt/novnc/index.html
cat > /opt/novnc/index.html <<EOF
<!DOCTYPE html>
<html>
<head><meta http-equiv="refresh" content="0; url=vnc.html?${NOVNC_PARAMS}"></head>
<body><a href="vnc.html?${NOVNC_PARAMS}">Connecting to ArchSafe Unified Modeler ...</a></body>
</html>
EOF

exec /usr/bin/supervisord -n -c /etc/supervisor/conf.d/supervisord.conf
