#! /bin/sh

BASE="/home/jf/repos/tetris"

MASTER_REPO="$BASE/tetris_github"

_sync() {
    echo
    echo
    echo "$1"
    cd "$BASE/$1"
    git pull
    mvn formatter:format
}

_copy() {
    cp "$MASTER_REPO/$2" "$BASE/$1/$2"
}

_sync eb_al
_sync ho_da
_sync ri_ni
_sync tetris_github
_sync tetris_pgn
_sync tetris_simple
