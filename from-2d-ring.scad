module ringLayer(rotate) {
     rotate(rotate)
     rotate_extrude($fn = 10) {
          translate([11.6, 0, 0]) {
               square([1.4,2.5]);
          }
     }
}

for(i = [
         [8, 1, 0],
         [0, 8, 1],
         [1, 0, 8],
         [16, 0, 0],
         [0, 16, 0],
         [0, 0, 16],
         [24, 2, 0],
         [0, 24, 2],
         [2, 0, 24]
   ]) {
     ringLayer(i);
}
 
