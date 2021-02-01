(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I am a little teapot"))

(defn greeting [greet]
  (str greet "Hello World!"))

(greeting "Hello")
(println "Cleanliness is next to godliness")

(defn train
  []
  (println "Choo Choo!"))


