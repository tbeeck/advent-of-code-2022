(ns day05)

(defn parse-nested-ints
	[node]
	(if (string? node)
		(Integer/parseInt node)
		(map parse-nested-ints node)))

(defn parse-first-chunk-line
	[line, stacks]
	(conj stacks {(count line) line}))

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
      stacks
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
	[stacks instructions]
	[stacks, instructions]
	(loop [s stacks remaining-instrs instructions]
		(if (= remaining-instrs '[])
			s
			(recur
				(apply-instruction (peek remaining-instrs s))
				(pop remaining-instrs)))))

(defn run [opts]
  (def stacks (read-first-chunk))
  (def instructions (read-second-chunk))
  (println (solve stacks instructions)))
