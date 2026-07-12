#!/bin/bash
# One-shot: wait for the workbench main window (titled "workspace - ArchSafe
# Unified Modeler", unlike the splash and internal helper windows), then size
# it to the full virtual desktop. Cosmetic only — always exits 0.
export DISPLAY="${DISPLAY:-:99}"

until [ -S "/tmp/.X11-unix/X${DISPLAY#:}" ]; do sleep 0.2; done

for _ in $(seq 1 300); do
  id=$(xdotool search --onlyvisible --name '^workspace - ArchSafe Unified Modeler' 2>/dev/null | head -1)
  if [ -n "$id" ]; then
    xdotool windowsize "$id" 100% 100%
    exit 0
  fi
  sleep 1
done
exit 0
