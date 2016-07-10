module ringLayer(t) {
     translate(t[0])
         rotate(t[1])
         rotate_extrude($fn = 50) {
         translate([12, 0, 0]) {
              square([1, 5]);
         }
    }
}

for(t = [
         [[0, 0, 0], [0, 0, 0]],
         [[.6, 0, 2], [9, 0, 9]],
         [[-.6, 0, 4], [0, 9, 18]]
   ]) {
     ringLayer(t);
}
