(ns clojure-noob.lazy-sequences)

; LAZY SEQUENCES

(def vampire-database
  {0 {:makes-blood-puns? false, :has-pulse? true :name "McFishwich"}
   1 {:makes-blood-puns? false, :has-pulse? true :name "McMackson"}
   2 {:makes-blood-puns? true, :has-pulse? false :name "Damon Salvatore"}
   3 {:makes-blood-puns? true, :has-pulse? true :name "Mickey Mouse"}})

(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))

(defn vampire?
  [record]
  (and (:makes-blood-puns? record)
       (not (:has-pulse? record))
       record))

(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire?
                 (map vampire-related-details social-security-numbers))))

(time (vampire-related-details 0))

; returns lazy seq, so the function vampire-related-details is not called
; instead [(vampire-related-details 0) (vampire-related-details 1) ...]
; is returned
(time (def mapped-details (map vampire-related-details (range 0 1000000))))
;"Elapsed time: 0.097542 msecs"

; here map returns lazy seq but println accesses the seq, so
; it evaluates each expression of
; [(vampire-related-details 0) (vampire-related-details 1) ...]
; hence taking actual time.
(time (println (map vampire-related-details (range 0 10))))
; "Elapsed time: 10039.571292 msecs"

; here mapped-details is unrealized.
; Once you try to access a member of mapped-details, it will use its recipe
; to generate the element we’ve requested, and we’ll incur the
; one-second-per-database-lookup cost
(time (first mapped-details))

;This operation took about 32 seconds.
; That’s much better than one million seconds, but it’s still 31 seconds more
; than we would have expected. After all, we’re only trying to access
; the very first element, so it should have taken only one second.
; The reason it took 32 seconds is that Clojure chunks its lazy sequences,
; which just means that whenever Clojure has to realize an element,
; it preemptively realizes some of the next elements as well.
; In this example, we wanted only the very first element of mapped-details,
; but Clojure went ahead and prepared the next 31 as well.
; Clojure does this because it almost always results in better performance.

; since 32 elements were already realized from the above the expression.
; if we run the expression again it will take less than a second.
(time (first mapped-details))

(time (identify-vampire (range 0 1000000)))