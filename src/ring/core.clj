(ns ring.core
  (:gen-class)
  (require [scad-clj.scad :refer :all]
           [scad-clj.model :refer :all]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def twodring
    (->>
      (square 2 7)
      (translate [12, 0, 0])
      (extrude-rotate)))
  (spit "dist/2dring.scad" (write-scad twodring)))
