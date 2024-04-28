# Imagemagick commands

## Overlay with colorized transparent layer

    convert input.png -fill green -colorize 30% output.png

## Resize without interpolation

    convert input.png -sample 400% output.png
