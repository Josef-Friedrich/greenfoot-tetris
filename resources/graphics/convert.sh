#! /bin/sh

mkdir out

INPUT="$1"

convert "${INPUT}" -fill green -colorize 30% -sample 400% "out/${INPUT}"
