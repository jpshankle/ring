(ns ring.core
  (:gen-class)
  (require [scad-clj.scad :refer :all]
           [scad-clj.model :refer :all]
           [clojure.data.json :as json]))

(def shapes
 (json/read-str
   (slurp "src/ring/shapes.json") :key-fn keyword))

(defn oneRing
  "One ring that goes with more rings"
  [{:keys [square-one square-two translation]} [outertranslation rotation]]
  (translate outertranslation
  (rotatec rotation
    (extrude-rotate
      (translate translation
        (square square-one square-two))))))

(defn twodring
  "creates a ring from size and a vector of rings"
  [size rings]
  (map #(oneRing size %) rings))

(defn -main
  "creates a ring scad file"
  [& args]
  (spit "dist/2dring.scad"
    (write-scad
      (twodring (:size shapes) (:shapes shapes)))))
