#! /bin/sh

convert "$1" -fill green -colorize 30% -sample 400% "${1}_gb.png"
