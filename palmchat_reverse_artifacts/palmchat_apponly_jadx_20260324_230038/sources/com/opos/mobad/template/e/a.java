package com.opos.mobad.template.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public enum a {
    UNKNOWN,
    CLICK,
    SHAKE,
    UP_SLIDE,
    FORWARD,
    TWIST,
    TILT,
    FULLSCREEN_SLIDE,
    SHAKE_AND_UP_SLIDE,
    SLIDE_LAYER;

    public static a a(int i) {
        switch (i) {
            case 2:
                return SHAKE;
            case 3:
                return UP_SLIDE;
            case 4:
                return FORWARD;
            case 5:
            default:
                return UNKNOWN;
            case 6:
                return TILT;
            case 7:
                return FULLSCREEN_SLIDE;
            case 8:
                return SHAKE_AND_UP_SLIDE;
            case 9:
                return SLIDE_LAYER;
        }
    }
}
