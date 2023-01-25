(ns day04
	(:require [clojure.string :as str]))

(defn parse-nested-ints
	[node]
	(if (string? node)
		(Integer/parseInt node)
		(map parse-nested-ints node)))

(defn parse-line
  "transform single line of input"
  [line]
  (parse-nested-ints
  	(map #(str/split % #"-") (str/split line #","))))

(defn read-stdin
  "Read all lines from stdin"
  []
  (loop [input (read-line) acc []]
    (if (= nil input)
      acc
      (recur
       (read-line)
       (conj acc (parse-line input))))))

(defn contains
	"Check if range A contains range B"
	[rangeA, rangeB]
	(and
		(<= (first rangeA) (first rangeB))
		(>= (second rangeA) (second rangeB))))

(defn either-contains
	[rangeA, rangeB]
	(or 
		(contains rangeA rangeB)
		(contains rangeB rangeA)))

(defn solve 
	[ranges]
	(if (= ranges [])
		0
		(+
			(solve (pop ranges))
			(if (either-contains 
				(first (peek ranges)) 
				(second (peek ranges)))
				1
				0))))

(defn run [opts]
  (def ranges (read-stdin))
  (println (solve ranges))) 
