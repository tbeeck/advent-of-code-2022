(ns day01)

(defn read-stdin
  []
  (loop [input (read-line) acc []]
    (if (= nil input)
      acc
      (recur (read-line) (conj acc input)))))

(defn elf-totals
  [cal-list]
  (1 2 100 39210390 9))

(defn most-calories 
  [cal-list]
  (apply max (elf-totals cal-list)))

(defn run [opts]
  (println (most-calories (read-stdin))))
