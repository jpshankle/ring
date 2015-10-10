$fa = .6;
$fs = .6;

module ringLayer(layerTranslate, layerHeight=2, outerWidth=13.4, innerWidth=12.4) {
    o = layerTranslate % 2 == 0 ? outerWidth : innerWidth;
    i = layerTranslate % 2 == 0 ? innerWidth : outerWidth;

    translate([0, 0, layerTranslate * layerHeight])
          cylinder (h=layerHeight, r=o, r2=i);
}

difference () {
    union () {
        ringLayer(0);
        ringLayer(1);
        ringLayer(2);
        ringLayer(3);
    }
    translate([0,0,-1])
        cylinder (h=10, r=11);
}