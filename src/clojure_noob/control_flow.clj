(ns clojure-noob.control-flow)

; Control Flow

; if-else statement
(if true
  "By Zeus's hammer!"
  "By Aquaman's trident!")
; => "By Zeus's hammer!"

(if false
  "By Zeus's hammer!"
  "By Aquaman's trident!")
; => "By Aquaman's trident!"

; if without else
(if true
  "do this"
  )

; do operator
(if true
  (do (println "success!")
      "By Zeus's Hammer")
  (do (println "failure!")
      "By Aquaman's Trident."))

; when operator
(when true
  (println "Success!")
  "abra cadabra")

;; multiple assignments

(defn error-message
  "Dynamic Assignment of values"
  [severity]
  (str "OH GOD! It's a disaster! We're "
       (if (= severity :mild)
         "mildly inconvenienced."
         "doomed.")))



