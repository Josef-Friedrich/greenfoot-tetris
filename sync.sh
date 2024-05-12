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
    cp -v "$MASTER_REPO/$2" "$BASE/$1/$2"
}

_commit() {
    echo
    echo "$1"
    cd "$BASE/$1"
    git add -Av
    git commit -m 'Auto commit'
    git push
}

_sync eb_al
_sync ho_da
_sync ri_ni
_sync tetris_github
_sync tetris_pgn

# README
_copy tetris_pgn README.md

_commit eb_al
_commit ho_da
_commit ri_ni
_commit tetris_pgn
_commit tetris_github
