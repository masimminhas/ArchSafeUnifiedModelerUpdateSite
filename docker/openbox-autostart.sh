#!/bin/bash
# Openbox autostart – runs when Openbox window manager starts.
# Sets background colour and cursor to make the desktop look clean
# for reviewers accessing via noVNC.

# Set a neutral dark-blue background (ArchSafeUnified brand colour)
xsetroot -solid "#1F4E79" &

# Remove the default X cursor cross
xsetroot -cursor_name left_ptr &

# Disable screen saver and power management
xset s off &
xset -dpms &
xset s noblank &
