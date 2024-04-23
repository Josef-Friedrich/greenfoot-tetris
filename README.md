# Tetris auf dem Gameboy

## Bildschirmauflösung

Der Bildschirmausschnitt des Gameboys ist `160x144` (Breite `x` Höhe)
Pixel. Ein Block hat die Größe `8x8`. Der Bildschirmausschnitt lässt
sich als mit `20x18` Blöcken ausfüllen. Wir verwenden Bilder, die um den
Faktor `4` vergrößert wurden. Der ganze Bildschirm hat dann also
`640x576` Pixel und ein Block `32x32`.

## Hauptmodi

Es gibt zwei Hauptmodi: _„A-Type“_ und _„B-Type“_.

Im _„A-Type“_-Modus muss eine möglichst hohe Punktzahl zu erreicht, indem
Blockreihen auflöst werden, während die Tetriminos schneller und
schneller fallen.

Im _„B-Type“_-Modus müssen 25 Reihen beseitigt werden, um den Sieg
zu erringen. Der Schwierigkeitsgrad kann erhöht, indem
die Fallgeschwindigkeit heraufsetzt und mehr Zufalls-Tetriminos
einstellt wird.[^nitendo.com]

## Farben

4 Farben

![](https://github.com/Josef-Friedrich/tetris-like-game/blob/main/resources/graphics/Colors.svg)

| deutsch | englisch | hex grün[^gimp-color-picker] |
|---------|-------|--------|
| weiß    | white | 7f7c15 |
| hell    | light | 5b703e |
| dunkel  | dark  | 5d5949 |
| schwarz | black | 344d40 |

https://en.wikipedia.org/wiki/List_of_video_game_console_palettes#Game_Boy

## Bildschirme (`screens`)

`CopyrightScreen`

![](https://github.com/Josef-Friedrich/tetris-like-game/blob/main/resources/graphics/screenshots/CopyrightScreen.png)

`TitleScreen`

![](https://github.com/Josef-Friedrich/tetris-like-game/blob/main/resources/graphics/screenshots/TitleScreen.png)

`MainMenuScreen`

![](https://github.com/Josef-Friedrich/tetris-like-game/blob/main/resources/graphics/screenshots/MainMenuScreen.png)

`LevelSelectScreen`

![](https://github.com/Josef-Friedrich/tetris-like-game/blob/main/resources/graphics/screenshots/LevelSelectScreen.png)

`IngameScreen`

![](https://github.com/Josef-Friedrich/tetris-like-game/blob/main/resources/graphics/screenshots/IngameScreen.png)

`GameOverScreen`

![](https://github.com/Josef-Friedrich/tetris-like-game/blob/main/resources/graphics/screenshots/GameOverScreen.png)

`RussianDancersScreen`

![](https://github.com/Josef-Friedrich/tetris-like-game/blob/main/resources/graphics/screenshots/RussianDancersScreen.gif)

## Emulation

Es gibt eine Vielzahl sogenannter Emulatoren, mit denen der Gameboy
simuliert werden kann. Der Emulator
[mGBA](https://mgba.io/downloads.html) (mini Game Boy Advance) läuft auf
allen gängigen Desktop-Betriebssystemen und auf einigen Spielekonsolen.
_mGBA_ ist freie Software und wird unter der [Mozilla Public License
2.0](https://github.com/mgba-emu/mgba/blob/master/LICENSE)
veröffentlicht. Der Quellcode ist über
[Github](https://github.com/mgba-emu/mgba) abrufbar.

Um das Spiel in einem Emulator laufen zu lassen, ist eine sogenanntes
ROM notwendig, z. B. von
[emulatorgames.net](https://www.emulatorgames.net/roms/gameboy/tetris-jue-v11/).

## Allgemeine Informationen über das Spiel

- [englische Wikipedia](<https://en.wikipedia.org/wiki/Tetris_(Game_Boy_video_game)>)
- [harddrop.com (Tetris Wiki created by Tetris fans for Tetris fans)](https://harddrop.com/wiki/Tetris_%28Game_Boy%29)
- [Video Game Music Preservation Foundation](<http://www.vgmpf.com/Wiki/index.php?title=Tetris_(GB)>)

## Youtube-Videos

- [Playthrough 16 Minuten, Gameboy-Display wurde abgefilmt](https://www.youtube.com/watch?v=BQwohHgrk2s)
- [Longplay 52 Minuten (schwarz-weiß Emulator)](https://www.youtube.com/watch?v=VNbo1AGqKrI)
- [short](https://www.youtube.com/shorts/30vVpKAMu6g)

## Klone

- [canvas_tetris (javascript)](https://github.com/andyp123/canvas_tetris)
- [js-tetris](https://github.com/az23/js-tetris) (eventuell nicht fertig gestellt)

[^nitendo.com]: https://www.nintendo.com/de-de/Spiele/Game-Boy/TETRIS--275924.html
[^gimp-color-picker]: Ermittelt mit dem GIMP Color Picker mittels eines Bildschirmfotos des Videos https://www.youtube.com/watch?v=BQwohHgrk2s
