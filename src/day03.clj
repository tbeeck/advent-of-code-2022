(ns day03
  (:require [clojure.set :as set]))

(defn parse-line
  "transform single line of input"
  [line]
  (split-at 
    (quot (count line) 2) 
    line))

(defn read-stdin
  "Read all lines from stdin"
  []
  (loop [input (read-line) acc []]
    (if (= nil input)
      acc
      (recur
       (read-line)
       (conj acc (parse-line input))))))

(defn common-item
  [compartments]
  (first (set/intersection 
    (set (first compartments)) 
    (set (second compartments)))))

(defn priority-value
  [item]
  (if (>= (int item) 97)
    (- (int item) 96)
    (- (int item) 38)))

(defn solve
  [rucksacks]
  (if (= rucksacks [])
    0
    (+
      (priority-value (common-item (peek rucksacks)))
      (solve (pop rucksacks)))))

(defn run [opts]
  (def rucksacks (read-stdin))
  (println (int \a) (int \A))
  (println (map common-item rucksacks))
  (println (map priority-value (map common-item rucksacks)))
  (println (solve rucksacks)))
