(ns day01)

(defn parse-line
  [line]
  (try
    (read-string line)
    (catch Exception e nil)))

(defn read-stdin
  []
  (loop [input (read-line) acc []]
    (if (= nil input)
      acc
      (recur
       (read-line)
       (conj acc (parse-line input))))))

(defn partition-calories
  "Parse lines into groups of numbers and filter dividers"
  [lines]
  (apply list (filter #(not= '(nil) %) (partition-by number? lines))))

(defn max-calories-from-groups
  "Get max calories from groups"
  [calorie-groups]
  (if (empty? calorie-groups)
    0
    (max
     (apply + (peek calorie-groups))
     (max-calories-from-groups (pop calorie-groups)))))

(defn run [opts]
  (println
   (max-calories-from-groups
    (partition-calories (read-stdin)))))
