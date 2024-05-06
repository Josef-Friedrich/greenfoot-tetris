build:
	rgbasm -l -o main.o main.asm
	rgblink -o tetris.gb main.o

clean:
	rm main.o
	rm -f tetris.gb

.PHONY: build clean
