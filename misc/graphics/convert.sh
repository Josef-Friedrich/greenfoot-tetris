#! /bin/bash

for FILE in $(find sprites -iname "*.png"); do
  OUTPUT="${FILE/sprites/out}"
  mkdir -p "$(dirname ${OUTPUT})"
  convert "${FILE}" -fill green -colorize 30% -sample 400% "${OUTPUT}"
done
