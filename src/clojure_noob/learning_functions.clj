(ns clojure-noob.learning-functions)

; Calling functions
; function can be called similarly to using operators
(println "Calling (str) function - " (str "Calling" " function"))

; function can be expression or return another functions
(println "Returning operator using (or) - " (or + -))

; using functional expression as operator for another expression)
(println "Using functional expression as operator - " ((or + -) 1 2 3))

; Function flexibility doesn’t end with the function expression!
; Syntactically, functions can take any expressions as arguments— including other
; functions. Functions that can either take a function as an argument
; or return a function are called higher-order functions.
; Programming languages with higher-order functions are said to support
; first-class functions because you can treat functions as values
; in the same way you treat more familiar data types like numbers and vectors.

; example (map) function
; (map) function takes a function and collection as an argument and
; applies the function to the collection
(println "I am using (map) - " (map inc [0 1 2 3]))

; clojure evaluates the function in an expression recursively before
; passing them to another function
; example
;(+ (inc 199) (/ 100 (- 7 2)))
;(+ 200 (/ 100 (- 7 2))) ; evaluated "(inc 199)"
;(+ 200 (/ 100 5)) ; evaluated (- 7 2)
;(+ 200 20) ; evaluated (/ 100 5)
;220 ; final evaluation

; Special-forms
; if statement

; creating/ defining functions
(defn too-enthusiastic
  "Return a cheer that might be a bit too enthusiastic"
  [name]
  (str "OH. MY. GOD! " name " YOU ARE MOST DEFINITELY LIKE THE BEST "
       "MAN/WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE"))

(println (too-enthusiastic "Zelda"))

; using doc-string to document code
; parameters can be zero, one or more
; [] - 0 param
; [x] - 1 param
; [x y] - 2 param

; arity overloading
; we can control the behavior of the function based on the no. of params
; example
(defn multi-arity
  ;; 3-arity arguments and body
  ([first-arg second-arg third-arg]
   (str first-arg second-arg third-arg))
  ;; 2-arity arguments and body
  ([first-arg second-arg]
   (str first-arg second-arg))
  ;; 1-arity arguments and body
  ([first-arg]
   (str first-arg)))

(println "I am using arity overloading")
(println "- with 1 arg" (multi-arity "one"))
(println "- with 2 arg" (multi-arity "one" "two"))
(println "- with 3 arg" (multi-arity "one" "two" "three"))

; providing default values to function using arity overloading
(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

(println "Using default value - " (x-chop "jackie"))
(println "Without default value - " (x-chop "jackie" "chop"))

; Rest parameter "&"
; Clojure also allows you to define variable-arity functions by
; including a rest parameter, as in “put the rest of these arguments in a list
; with the following name.” The rest parameter is indicated by an ampersand (&),
; example
(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))

(println "Rest \"&\" example - " (favorite-things "Doreen" "gum" "shoes" "kara-te"))

; Destructuring
; The basic idea behind destructuring is that it lets you
; concisely bind names to values within a collection
; example
;; Return the first element of a collection
(defn my-first
  [[first-thing]]                                           ; Notice that first-thing is within a vector
  first-thing)

(println (my-first ["oven" "bike" "war-axe"]))
; => "oven"

; When destructuring a vector or list, you can name as many elements as you want
; and also use rest parameters
(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices. "
                "Here they are in case you need to cry over them: "
                (clojure.string/join ", " unimportant-choices))))

(println (chooser ["Marmalade", "Handsome Jack", "Pigpen", "Aquaman"]))

; destructuring maps
(defn location
  [{address :address city :city}]
  (println "Address: " address)
  (println "City: " city))

(println (location {:address "123 Street" :city "Kathmandu"}))

; shortcut of destructuring maps by binding key and to variables
(defn location
  [{:keys [address city]}]
  (println "Address: " address)
  (println "City: " city))

(println (location {:city "Kathmandu" :address "123 Street"}))

; Function Body
; The function body can contain forms of any kind.
; Clojure automatically returns the last form evaluated.
; This function body contains just three forms, and when you call the function,
; it spits out the last form, "joe"

(defn illustrative-function
  []
  (+ 1 304)
  30
  "joe")

(illustrative-function)
; => "joe"

(defn my-if-function-body
  "Returning using if expression"
  [x]
  (if (> x 6)
    "Oh my gosh! What a big number!"
    "That number's OK, I guess")
  )

(println (my-if-function-body 100))
(println (my-if-function-body 1))

; Anonymous functions
; creating anonymous function using (fn)
((fn [name]
   (println "Hi" name "! from anonymous function. :D")) "Noob")

(map (fn [name] (str "Hi, " name))
     ["Darth Vader" "Mr. Magoo"])
; => ("Hi, Darth Vader" "Hi, Mr. Magoo")

((fn [x] (* x 3)) 8)

; associating anonymous function to a variable
(def sum (fn [nums] (map inc nums)))

(sum [1 2 3])

; creating anonymous functions using "#"
(#(* % 3) 8)

(map #(str "Hi, " %)
     ["Darth Vader" "Mr. Magoo"])

; passing multiple args while creating fns through "#"

(#(str "Argument 1: " %1 " Argument 2: " %2 " Argument 3: " %3) "OH" "MY" "GOD")

; Returning functions
(defn inc-maker
  "Create a custom incrementer"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 7)

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Accepts seqs of map with keys :name and :size"
  [parts]
  (loop [remaining-parts parts final-parts []]
    (if (empty? remaining-parts)
      final-parts
      (let [[part & remaining] remaining-parts]
        (recur remaining
               (into final-parts
                     (set [part (matching-part part)]))))))
  )

(symmetrize-body-parts asym-hobbit-body-parts)

; implementing above function using reduce
(defn my-reduce
  ; accept matching part function, sym list and asym list
  ([create-matching-part initial remaining-list]
   (loop [result initial
          remaining remaining-list]
     (if (empty? remaining)
       result
       (recur (create-matching-part result (first remaining)) (rest remaining)))))

  ; accept matching part function, destructure asym list to
  ; initial & remaining values
  ([create-matching-part asym-list]
   (my-reduce create-matching-part [] asym-list)))

(my-reduce
  (fn [final-body-parts part]
    (into final-body-parts (set [part (matching-part part)])))
  asym-hobbit-body-parts)

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))

(better-symmetrize-body-parts asym-hobbit-body-parts)
; iteration using loop
(loop [i 0]
  (println "i=" i)
  (if (> i 3)
    (println "Goodbye!")
    (recur (inc i)))
  )

; reduce to sum values
(reduce + [1 2 3])
; reduce takes an operator and list as argument
; it applies the operator to 1st and 2nd element
; then if applies the operator to the result and next element(3rd element) and so on

; reduce with initial value
(reduce + 5 [1 2 3])
; equivalent to 5+1+2+3

;let binds value to a variable within the scope of (let )

(defn hit
  [asym-body-parts]
  ; bind sym-body-parts to sym-parts
  ; bind sum of size of sym-parts to body-part-size-sum
  ; bind random number within the range of 0-sum to target
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))

(loop [x 1]
  (println x)
  (if (> x 4)
    (println "goodbye")
    (recur (inc x)))
  )

