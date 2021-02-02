(ns clojure-noob.data-structures)

; Clojure data-structures are immutable- similar to final list in java

; Numbers

;integer
(println "integer: 12")

;float
(println "float: 1.2")

;ratio
(println "ratio: 1/5")

; Strings
(println "Lord Voldemort")
(println "I am a string with \"quotes\"")

; String concatenation using str
(def doe "Chewbacca")
(println (str "\"Ugglugglgugglglll\" - " doe))

; Maps
(def emptymap {})
(def filledmap {:firstname "John" :lastname "Doe"})
(def nestedmap {:name {:first "John" :middle "Mayer" :last "Doe"}})

(println (str "I am a empty map - " emptymap))
(println (str "I am a normal map - " filledmap))
(println (str "I am a nested map - " nestedmap))

; You can use {} to create maps or use the hash-map function
(def hashmap (hash-map :a 1 :b 2))
(println (str "I am created from (hash-map) - " hashmap))

; LookUp values in map using (get)
(println "Lookup using (get) - " (get nestedmap :name))
(println "Lookup using (get) with default value - " (get nestedmap :dfkjf "NOOB?"))

; Lookup nested values using (get-in)
(println "Lookup nested values using (get-in) - " (get-in nestedmap [:name :first]))

; Keywords
; Lookup values in map using keywords
(println "Lookup value using key - " (:name nestedmap))

; Vectors
; Vectors are similar to array i.e. 0-indexed collection
(println "[1 2 3] - I am a vector")
(def me-vector [1 2 3])
; getting elements of vector by index
(println "Indexing through 0th element of vector - " (get me-vector 0))

; Creating vectors with (vector)

(println "I am made from (vector) - " (vector ["creepy" "full" "moon"]))

; (conj) function
; can be used to add elements at the end of the vector

(println "Add new element to vector - " (conj me-vector "IAmNewElement"))

; List
; List are similar to vectors but (get) can't be used to retrieve values
(println "Creating list using \"'\" symbol - " '(1 2 3 4))
(def me-list '(1 2 3 4))

; use (nth) to retrieve elements from a list
(println "Fetch 0th element of list using (nth) - " (nth me-list 0))

; (nth) is slower than (get) in vector
; because Clojure has to traverse all n elements of a list to get to the nth,
; whereas it only takes a few hops at most to access a vector element by its index.

(println "Creating list using (list) - " (list 1 2 3 4))

; (conj) on list adds element at the beginning of th list
(println "Adding elements to beginning of list using (conj) - "
         (conj me-list "IAmANewElement"))

; Sets
; two types of set: hash set and sorted set
(println "Literal notation of hash-set - " #{1 2 3})
(println "Creating hashset using (hash-set) - " (hash-set 1 1 2 3))

(def me-hashset #{1 2 3})
; using (conj to add value to a set)
(println "Adding elements to hashset - " (conj me-hashset "newElement"))

; Creating sets from vectors using (set)
(println "I am a set from vector- " (set [1 2 1 4 6]))

; checking for set membership using (contains? )
(println "Checking set membership - " (contains? me-hashset "IAmNew"))




