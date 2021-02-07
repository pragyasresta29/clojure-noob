(ns clojure-noob.infinite-sequences)

; repeat creates a seq whose every member is the argument we pass
(concat (take 8 (repeat "na")) ["Batman!"])

; repeatedly
; repeatedly calls a function to generate element in the seq
(take 3 (repeatedly (fn [] (rand-int 10))))

(defn even-numbers
  ([] (even-numbers 0))
  ([n] (cons n (lazy-seq (even-numbers (+ n 2))))))

(take 10 (even-numbers))

; cons returns a new list with an element appended to the given list
(cons 0 '(2 4 6))
; => (0 2 4 6)

