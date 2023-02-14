(ns day05)

(defn parse-nested-ints
	[node]
	(if (string? node)
		(Integer/parseInt node)
		(map parse-nested-ints node)))

(defn parse-first-chunk-line
	[line, stacks]
	)

(defn parse-second-chunk-line
	[line]
	(parse-nested-ints
		(drop 1
			(re-matches 
				#"move (\d+) from (\d+) to (\d+)" 
				line))))

(defn read-first-chunk
  []
  (loop [input (read-line) stacks {}]
    (if (= "" input)
      (reverse-values stacks)
      (recur
       (read-line)
       (parse-first-chunk-line input stacks)))))

(defn read-second-chunk
	[]
	(loop [input (read-line) acc []]
		(if (= nil input)
			acc
			(recur
				(read-line)
				(conj acc (parse-second-chunk-line input))))))

(defn apply-instruction
	[stacks, instruction]
	)

(defn solve
	[stacks, instructions]
	(loop [ins instructions s stacks]
		(if (= ins '[])
			s
			(recur
				(pop ins)
				(apply-instruction s (peek ins))))))

(defn run [opts]
    (def stacks (read-first-chunk))
    (def instructions (read-second-chunk))
	(println stacks)
    (println (solve stacks instructions)))
