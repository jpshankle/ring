(ns ring.core
  (:gen-class)
  (require [scad-clj.scad :refer :all]
           [scad-clj.model :refer :all]))

(def standardSize {
  :squareone 1.5
  :squaretwo 3
  :translation [12.2, 0, 0]})

(def ringShapes [
  [[0 0 0]   [-0.15 0 0]]
  [[0.7 0 0] [0.15 0 0]]
  [[0 0.7 0] [0 0.15 0]]
  [[0 0 5]   [-0.15 0 5]]
  [[0.7 0 5] [0.15 0 5]]
  [[0 0.7 5] [0 0.15 5]]
  ])

(defn oneRing
  "One ring that goes with more rings"
  [{:keys [squareone squaretwo translation]} [outertranslation rotation]]
  (translate outertranslation
  (rotatec rotation
    (extrude-rotate
      (translate translation
        (square squareone squaretwo))))))

(defn twodring
  "creates a ring from a size and a vector of rings"
  [size rings]
  (map #(oneRing size %) rings))

(defn -main
  "creates a ring scad file"
  [& args]
  (spit "dist/2dring.scad"
    (write-scad
      (twodring standardSize ringShapes))))
