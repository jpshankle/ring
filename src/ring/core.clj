(ns ring.core
  (:gen-class)
  (require [scad-clj.scad :refer :all]
           [scad-clj.model :refer :all]))

(def standardSize {
  :squareone 1.5
  :squaretwo 7
  :translation [12, 0, 0]})

(defn oneRing
  "One ring that goes with more rings"
  [{:keys [squareone squaretwo translation]} rotation]
  (->>
    (square squareone squaretwo)
    (translate translation)
    (extrude-rotate)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def twodring
    (oneRing standardSize 0))
  (spit "dist/2dring.scad" (write-scad twodring)))
