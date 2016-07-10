module ringLayer(t) {
     translate(t[0])
         rotate(t[1])
         rotate_extrude($fn = 50) {
         translate([12, 0, 0]) {
              square([1, 4]);
         }
    }
}

for(t = [
         [[0, 0, 0], [-8, 0, 0]],
         [[.7, 0, 0], [8, 0, 0]],
         [[0, .7, 0], [0, 8, 0]]
   ]) {
     ringLayer(t);
}
