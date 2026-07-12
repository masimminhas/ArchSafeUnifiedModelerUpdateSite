#!/bin/bash
# Keep the ArchSafe workbench reachable inside the browser (noVNC) session.
#
# The container runs a bare xfwm4: no panel, no taskbar, no desktop. That is
# fine until the workbench window is minimised — at which point nothing is left
# on screen to click, the reviewer is staring at an empty grey desktop, and
# there is no way to bring the tool back without a shell inside the container.
# The reasonable conclusion is that the tool crashed.
#
# This watchdog restores the window whenever it is iconified, which turns the
# minimise button into a harmless no-op rather than a dead end. It is cosmetic
# only: every call is guarded and the loop never exits non-zero.
#
# Matching on the suffix 'ArchSafe Unified Modeler' rather than the full
# startup title is deliberate: Eclipse rewrites the title as soon as an editor
# is opened (for example "workspace - automotive.unified - ArchSafe Unified
# Modeler"), so a stricter pattern would stop matching the moment a reviewer
# opens a model — exactly when they are most likely to minimise it.
set -u
export DISPLAY="${DISPLAY:-:99}"

TITLE='ArchSafe Unified Modeler'
POLL_SECONDS=2

# Wait for the X server before touching any window.
until [ -S "/tmp/.X11-unix/X${DISPLAY#:}" ]; do sleep 0.2; done

while true; do
  # A minimised window is still returned by `search`, but not by
  # `search --onlyvisible`. The difference between the two is what we restore.
  visible="$(xdotool search --onlyvisible --name "$TITLE" 2>/dev/null || true)"

  for id in $(xdotool search --name "$TITLE" 2>/dev/null || true); do
    if ! printf '%s\n' "$visible" | grep -qx "$id"; then
      xdotool windowmap      "$id" >/dev/null 2>&1 || true
      xdotool windowactivate "$id" >/dev/null 2>&1 || true
    fi
  done

  sleep "$POLL_SECONDS"
done
