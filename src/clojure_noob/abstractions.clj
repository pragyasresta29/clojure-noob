(ns clojure-noob.abstractions)

(defn titleize
  [topic]
  (str topic " for the Brave and True")
  )

(map titleize ["Hamsters", "Ragnarok"])                     ; map with vectors
(map titleize '("Empathy", "Decorating"))                   ; map with lists
(map titleize #{"Elbows", "Soap Carvings"})                 ; map with sets
(map #(titleize (second %)) {:uncomfortable-thing "Winking"}) ; map with map

; first, rest and cons

(seq '(1 2 3))
; => (1 2 3)

(seq [1 2 3])
; => (1 2 3)

(seq #{1 2 3})
; => (1 2 3)

(seq {:name "Bill Compton" :occupation "Dead mopey guy"})
; => ([:name "Bill Compton"] [:occupation "Dead mopey guy"])

; convert the seq back into a map by using into
(into {} (seq {:a 1 :b 2 :c 3}))
; => {:a 1, :c 3, :b 2}

; When you pass map multiple collections, the elements of the first collection
; (["a" "b" "c"]) will be passed as the first argument of the mapping function
; (str), the elements of the second collection (["A" "B" "C"]) will be passed
; as the second argument, and so on.
(map str ["a" "b" "c"] ["A" "B" "C"])
; => ("aA" "bB" "cC")

(def human-consumption [8.1 7.3 6.6 5.0])
(def critter-consumption [0.0 0.2 0.3 1.1])
(defn unify-diet-data
  [human critter]
  {:human human :critter critter})

(map unify-diet-data human-consumption critter-consumption)

(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))

(stats [3 4 10])
; => (17 3 17/3)

(stats [80 1 44 13 6])
; => (144 5 144/5)

(def my-func #(%1 %2))
(my-func sum [1 2 3])
(my-func count [1 2 3])

(map my-func [sum count avg] [[3 4 10] [3 4 10] [3 4 10]])
(map #(my-func % [3 4 10]) [sum count avg])
(map #(% [3 4 10]) [sum count avg])

(def identities
  [{:alias "Batman" :real "Bruce Wayne"}
   {:alias "Spider-Man" :real "Peter Parker"}
   {:alias "Santa" :real "Your mom"}
   {:alias "Easter Bunny" :real "Your dad"}])

(map :real identities)
; => ("Bruce Wayne" "Peter Parker" "Your mom" "Your dad")

(assoc {} :a 1)
(assoc {:a 1} :b 2)

(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max 30 :min 10 :hello 1})

(reduce (fn [new-map [key val]]
          (if (> val 4)
            (assoc new-map key val)
            new-map))
        {}
        {:human   4.1
         :critter 3.9})

;take, drop, take-while, and drop-while

(take 3 [1 2 3 4 5 6 7 8 9 10])
; => (1 2 3)

(drop 3 [1 2 3 4 5 6 7 8 9 10])
; => (4 5 6 7 8 9 10)

(def food-journal
  [{:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}])

(take-while #(<= (:month %) 2) food-journal)
(take-while #(< (:month %) 1) food-journal)

(drop-while #(< (:month %) 3) food-journal)

(filter #(= (:month %) 3) food-journal)

(some #(> (:critter %) 5) food-journal)
(some #(> (:critter %) 3) food-journal)
(some #(and (> (:critter %) 3) %) food-journal)

; sort
; sort in asc order
(sort [3 1 2])

(sort-by count ["aaa" "c" "bb"])

(sort ["aaa", "c", "bbb"])

; concat
; concats one seq to another
(concat [1 2] [3 4])



