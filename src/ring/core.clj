(ns ring.core
  (:gen-class)
  (require [scad-clj.scad :refer :all]
           [scad-clj.model :refer :all]
           [clojure.data.json :as json]))

(def shapes-file "src/ring/shapes.json")

(defn shapes
  "take a filename and create the needed shapes"
  [filename]
 (json/read-str
   (slurp filename) :key-fn keyword))

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
  (def two-d-shapes (shapes shapes-file))
  (spit "dist/2dring.scad"
    (write-scad
      (twodring (:size two-d-shapes) (:shapes two-d-shapes)))))
