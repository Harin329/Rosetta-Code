; Question
; https://rosettacode.org/wiki/Mandelbrot_set#Clojure

; Usage
; clojure -M mandelbrot.clj

(defn complex-add
  [[a0 b0] [a1 b1]]
  [(+ a0 a1) (+ b0 b1)])

(defn complex-square
  [[a b]]
  [(- (* a a) (* b b)) (* 2 a b)])

(defn complex-abs
  [[a b]]
  (Math/sqrt (+ (* a a) (* b b))))

(defn f
  [z c]
  (complex-add z (complex-square c)))

(defn mandelbrot?
  [z]
  (> 2 (complex-abs (nth (iterate (partial f z) [0 0]) 20))))

(doseq [y (range 1 -1 -0.02)]
  (doseq [x (range -2 2 0.01)]
    (print (if (mandelbrot? [(double x) (double y)]) "*" " ")))
  (println ""))