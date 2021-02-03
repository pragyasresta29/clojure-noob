(ns clojure-noob.exercises)

; CHAPTER_3
; Write a function that takes a number and adds 100 to it.
(defn add-hundred
  "Write a function that takes a number and adds 100 to it."
  [num]
  (+ num 100)
  )

(add-hundred 10)

; Write a function, dec-maker, that works exactly like the function inc-maker
; except with subtraction:

(defn dec-maker
  "docstring"
  [dec-by]
  ; returning a function that takes a number and subtracts it by dec-by
  #(- % dec-by)

  ; can be written as
  ;(fn [num] (- num dec-by))
  )

(def dec9 (dec-maker 9))
(dec9 10)

; Write a function, mapset, that works like map except the return value is a set:
(defn mapset
  "Write a function, mapset, that works like map except the return value is a set:"
  [custom-func collection]
  (loop [result []
         remaining-list collection]
    (if (empty? remaining-list)
      (set result)
      (let [[initial & remaining] remaining-list]
        (recur (into result (list (custom-func initial)))
               remaining))
      )
    )
  )

; CHAPTER_4
