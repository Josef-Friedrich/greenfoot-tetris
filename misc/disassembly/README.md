To debug use https://emulicious.net/

https://github.com/alexsteb/tetris_disassembly

# tetris_disassembly

Disassembly of Tetris for the Gameboy.

Compiles 1:1 to the official Tetris (World) GB ROM.

To-dos:

- finish code annotation
- annotate data sections (and solve discrepancies)

To build, simply use RGBDS:

Linux:

```
  rgbasm -o main.o main.asm
  rgblink -o tetris.gb main.o
```

Windows:

```
  rgbasm.exe -o main.o main.asm
  rgblink.exe -o tetris.gb main.o
```

http://stebtech.com/gameboy-tetris-disassembly/

In this project I attempted to understand the inner workings of a simple gameboy game.

    (https://github.com/alexsteb/tetris_disassembly)

Introduction

With a ROM size of only 32 kb, the game of Tetris is a perfect candidate to delve into the art of designing a video game with limited available space.

A classic gameboy’s CPU has an addressable space from $0000 to $FFFF (64 kb). Half of that is occupied by the inserted game cartridge and the other half is divided into video, audio, sprite and multipurpose RAM as well as other direct hardware registers (buttons, serial cable etc.).

The 32 kb of ROM space was hardly enough to fit most games. Super Mario Land as a launch title already required more space than that. Therefore the gameboy system uses a feature called “bank switching”, where by writing a number in a specific RAM location will cause the game cartridge to serve up a different memory bank (16 kb each) into the address space $4000 to $7FFF. Tetris however with a size of only 32 kb doesn’t need this.

The Interesting Bit

Contents of the vast majority of old game cartridges have been collected and backed up into files that can be read with a working gameboy emulator. These .gb-files contain the entire ROM of those cartridges. Since the CPU of the gameboy is a modified z80 chip, its instruction set is very simple to understand and ideal for learning the assembly language.

By using a (my) tool called Gameboy Disassembler (github.com/alexsteb/GB-Disassembler) I “translated” the entire list of bytes of the tetris.gb file into human readable assembly code. This looks e.g. like this:

1.  add a, a
2.  pop hl
3.  ld e, a
4.  ld d, $00
5.  add hl, de
6.  ld e, [hl]
7.  inc hl
8.  ld d, [hl]
9.  push de
10. pop hl
11. jp [hl]

Translation:

a, d, e, de and hl are registers. Special variables that can hold 1 or 2 bytes of data and reside very close to the CPU and are used for most calculations and instructions.

The code adds a to a (doubles it), loads two bytes from the top of stack (works like a stack of paper) into hl, puts a into e and zero into d (so that de equals a, but now is two bytes and can be added to hl), adds de to hl, loads the byte at address hl into e, increases hl by one, loads the next byte into d, saves this together (de) to the stack and picks it up immediately to put into hl. Finally this code jumps to the address of hl.

This obviously is incredibly hard to follow if you 1.) have no experience with Assembly and 2.) don’t know the context of this piece of code.

This short piece of code basically functions as a switch statement depending on the value of a.

There are many places in the Tetris code that all call this short function. They will save the current game status (different menus, in-game, link play, etc.) into variable a and call this function to then jump to a location based on the value of a. Whenever this function call is performed, a list of target addresses for every possible value of a have to exist right after the function call instruction.

When a function call is performed, the next to-be executed line is saved on the stack, so to know where to jump back later, when instruction ‘return’ is executed. This is why in line 2 the last address can be loaded into hl.

Line 1 doubles a, i.e. the game status, and lines 3 to 5 add them to the address of the call instruction. This makes sense, because we require a two-byte jump destination and game statuses have values 0, 1, 2, 3 and so on. If e.g. the function gets called from address $8000, the next instruction (or in this case data value) is saved at $8002, the stack would contain $8002 and a the game status, e.g. is 1. In this case the function will double 1, add it to the $8002 (= $8004) and retrieve the two byte jump instruction corresponding to game status 1 from there.

Conclusion

This method of understanding how a gameboy game was programmed is interesting in many ways. First, it furthers your understanding of the Assembly language in general, secondly it gives you a direct view into the thought processes of developers 20 to 30 years ago and finally it is great fun consisting of new puzzles and mysteries behind every function.
