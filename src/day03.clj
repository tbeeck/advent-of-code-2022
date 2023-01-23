(ns day03)

(defn parse-line
  "Parse single line of input"
  [line]
  line)

(defn read-stdin
  "Read all lines from stdin"
  []
  (loop [input (read-line) acc []]
    (if (= nil input)
      acc
      (recur
       (read-line)
       (conj acc (parse-line input))))))

(defn solve
  [rucksack]
  rucksack)

(defn run [opts]
  (def all-games (read-stdin))
  (println (solve (read-stdin)))
