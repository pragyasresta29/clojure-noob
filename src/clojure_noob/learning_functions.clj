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

