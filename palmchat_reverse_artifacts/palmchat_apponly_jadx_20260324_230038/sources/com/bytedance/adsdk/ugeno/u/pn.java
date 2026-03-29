package com.bytedance.adsdk.ugeno.u;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.cdo.oaps.ad.OapsKey;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public enum pn {
    TRANSLATE("translate", "translation", OapsKey.KEY_POINT),
    TRANSLATE_X("translateX", "translationX", "float"),
    TRANSLATE_Y("translateY", "translationY", "float"),
    ROTATE_X("rotateX", "rotationX", "float"),
    ROTATE_Y("rotateY", "rotationY", "float"),
    ROTATE_Z("rotateZ", MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, "float"),
    SCALE("scale", "scale", OapsKey.KEY_POINT),
    SCALE_X("scaleX", "scaleX", "float"),
    SCALE_Y("scaleY", "scaleY", "float"),
    ALPHA("opacity", "alpha", "float"),
    BACKGROUND_COLOR("backgroundColor", "backgroundColor", "int"),
    BORDER_RADIUS("borderRadius", "borderRadius", "float"),
    RIPPLE("ripple", "ripple", "float"),
    SHINE("shine", "shine", "float");

    private final String k;
    private final String my;
    private final String o;

    pn(String str, String str2, String str3) {
        this.k = str;
        this.my = str2;
        this.o = str3;
    }

    public String fx() {
        return this.o;
    }

    public String nr() {
        return this.my;
    }

    public String u() {
        return this.k;
    }

    public static pn u(String str) {
        str.hashCode();
        switch (str) {
            case "translateX":
                return TRANSLATE_X;
            case "translateY":
                return TRANSLATE_Y;
            case "opacity":
                return ALPHA;
            case "ripple":
                return RIPPLE;
            case "scaleX":
                return SCALE_X;
            case "scaleY":
                return SCALE_Y;
            case "scale":
                return SCALE;
            case "translate":
                return TRANSLATE;
            case "backgroundColor":
                return BACKGROUND_COLOR;
            case "borderRadius":
                return BORDER_RADIUS;
            case "rotateX":
                return ROTATE_X;
            case "rotateY":
                return ROTATE_Y;
            case "rotateZ":
                return ROTATE_Z;
            default:
                return TRANSLATE_X;
        }
    }
}
