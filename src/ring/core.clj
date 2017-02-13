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
  [{:keys [squareone squaretwo translation]} outertranslation rotation]
  (translate outertranslation
  (rotatec rotation
    (extrude-rotate
      (translate translation
        (square squareone squaretwo))))))

(def twodring
  (union
    (oneRing standardSize
      [0 0 0]
      [-0.15 0 0])
    (oneRing standardSize
      [0.7 0 0]
      [0.15 0 0])
    (oneRing standardSize
      [0 0.7 0]
      [0 0.15 0])))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (spit "dist/2dring.scad" (write-scad twodring)))
