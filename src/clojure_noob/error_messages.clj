(ns clojure-noob.error-messages)

; ClassCastException java.lang.String cannot be cast to clojure.lang.IFn
; example
("test" 2 3 4)
; reason: trying to use something as a function when it’s not.

