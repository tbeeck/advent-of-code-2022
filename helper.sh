#!/usr/bin/env bash
day="$(printf "%02d" $2)"
command="cat ./test-data/$day-$1.txt | clojure -X day$day/run"
eval "$command"
