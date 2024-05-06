#! /bin/sh

BASE="/home/jf/repos/tetris"

_sync() {
    cd "$BASE/$1"
    git pull
}

_sync eb_al
_sync ho_da
_sync ri_ni
_sync tetris_github
_sync tetris_pgn
_sync tetris_simple
