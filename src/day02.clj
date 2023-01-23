(ns day02
  (:require [clojure.string :as str]))

(def beats {
  :rock :scisors
  :paper :rock
  :scisors :paper})

(def choice-values {
  :rock 1
  :paper 2
  :scisors 3})

(def outcome-values {
  :win 6
  :tie 3
  :loss 0})

(defn parse-line
  "Parse single line of input"
  [line]
  (replace {"A" :rock, "B" :paper, "C" :scisors}
    (replace {"X" "A", "Y" "B", "Z", "C"} 
      (str/split line #" "))))

(defn read-stdin
  "Read all lines from stdin"
  []
  (loop [input (read-line) acc []]
    (if (= nil input)
      acc
      (recur
       (read-line)
       (conj acc (parse-line input))))))

(defn get-outcome
  "Get outcome for a game"
  [game]
  (if (= (second game) (first game))
    :tie
    (if (= (get beats (second game)) (first game))
      :win
      :loss)))

(defn score-for-game
  "Get score for a given game"
  [game]
  (+
    (get choice-values (second game))
    (get outcome-values (get-outcome game))))

(defn score-all-games
  [games]
  (if (= games [])
    0
    (+
      (score-for-game (peek games))
      (score-all-games (pop games)))))

(defn run [opts]
  (def all-games (read-stdin))
  (println (map get-outcome all-games))
  (println (map score-for-game all-games))
  (println (score-all-games all-games)))
