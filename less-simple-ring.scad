$fa = .1;
$fs = .1;

width = 12.6;

module ringLayer(layerTranslate, layerHeight=2, outerWidth=width+1, innerWidth=width) {
    o = layerTranslate % 2 == 0 ? outerWidth : innerWidth;
    i = layerTranslate % 2 == 0 ? innerWidth : outerWidth;

    translate([0, 0, layerTranslate * layerHeight])
          cylinder (h=layerHeight, r=i, r2=o);
}

difference () {
        union () {
            ringLayer(0);
            ringLayer(1);
            ringLayer(2);
            ringLayer(3);
    }
    translate([0,0,-1])
        cylinder (h=10, r=width-1);
}
