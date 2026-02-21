#!/bin/bash
# ╔══════════════════════════════════════════════════════════════╗
# ║  ArchSafeUnified Modeling Workbench – Docker Entrypoint                          ║
# ║                                                            ║
# ║  Start order:                                              ║
# ║    1. Xvfb       (virtual display)                        ║
# ║    2. Openbox    (window manager — keeps Eclipse alive)    ║
# ║    3. x11vnc     (VNC server on display :1)               ║
# ║    4. websockify (WebSocket bridge for noVNC)              ║
# ║    5. Eclipse    (the ArchSafeUnified Modeling Workbench)            ║
# ║                                                            ║
# ║  Browser URL:  http://localhost:6080                       ║
# ║  VNC password: ${VNC_PASSWORD}  (default: dsis2024)       ║
# ╚══════════════════════════════════════════════════════════════╝

set -euo pipefail

echo "═══════════════════════════════════════════════════════"
echo "  ArchSafeUnified Modeling Workbench"
echo "  Open your browser at:  http://localhost:6080"
echo "  VNC password:           ${VNC_PASSWORD}"
echo "═══════════════════════════════════════════════════════"

# ── 1. Start virtual display ─────────────────────────────────
echo "[1/5] Starting Xvfb virtual display ${DISPLAY} (${SCREEN_WIDTH}x${SCREEN_HEIGHT}x${SCREEN_DEPTH})..."
Xvfb ${DISPLAY} \
    -screen 0 "${SCREEN_WIDTH}x${SCREEN_HEIGHT}x${SCREEN_DEPTH}" \
    -ac \
    +extension GLX \
    +render \
    -noreset \
    &
XVFB_PID=$!
# Give Xvfb time to initialise
sleep 2

# ── 2. Start Openbox window manager ──────────────────────────
echo "[2/5] Starting Openbox window manager..."
DISPLAY=${DISPLAY} openbox-session &
sleep 1

# ── 3. Start x11vnc VNC server ───────────────────────────────
echo "[3/5] Starting x11vnc..."
x11vnc \
    -display ${DISPLAY} \
    -passwd "${VNC_PASSWORD}" \
    -forever \
    -shared \
    -rfbport 5900 \
    -noxdamage \
    -quiet \
    &
sleep 1

# ── 4. Start websockify (noVNC bridge) ───────────────────────
echo "[4/5] Starting noVNC websockify on port 6080..."
websockify \
    --web /opt/novnc \
    --wrap-mode=ignore \
    6080 localhost:5900 \
    &
sleep 1

# ── 5. Launch ArchSafeUnified (Eclipse RCP) ─────────────────────
echo "[5/5] [5/5] Launching ArchSafeUnified Modeling Workbench..."
echo "      Workspace: ${TOOL_WORKSPACE}"

# Set GTK theme to a clean, simple theme suitable for screenshots
export GTK_THEME=Adwaita

DISPLAY=${DISPLAY} /opt/ArchSafe-Unified/ArchSafe-unified \
    -data "${TOOL_WORKSPACE}" \
    -vmargs \
    -Xms256m \
    -Xmx1024m \
    -XX:+UseG1GC \
    -Dfile.encoding=UTF-8 \
    &
ECLIPSE_PID=$!

echo ""
echo "✓ All services started."
echo "  → Open http://localhost:6080 in your browser"
echo "  → noVNC password: ${VNC_PASSWORD}"
echo ""

# ── Wait for Eclipse to exit (keeps container alive) ─────────
wait $ECLIPSE_PID
echo "Eclipse exited. Container stopping."
