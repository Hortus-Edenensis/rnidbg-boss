package com.opos.mobad.template.e.b;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d extends a {
    public final int D;
    public final int E;
    public final int F;
    public final int G;

    public d(com.opos.mobad.template.d.b bVar) {
        super(bVar);
        int i = a.y;
        int i2 = a.z;
        int i3 = a.A;
        int i4 = a.C;
        try {
            String strA = a(bVar, "EXT_PARAM_KEY_SHAKE_UP_SLIDE_SENSOR_TIME");
            i = TextUtils.isEmpty(strA) ? i : Integer.parseInt(strA);
            String strA2 = a(bVar, "EXT_PARAM_KEY_SHAKE_UP_SLIDE_SENSOR_DIFF");
            i2 = TextUtils.isEmpty(strA2) ? i2 : Integer.parseInt(strA2);
            String strA3 = a(bVar, "EXT_PARAM_KEY_SHAKE_UP_SLIDE_DISTANCE");
            i3 = TextUtils.isEmpty(strA3) ? i3 : Integer.parseInt(strA3);
            String strA4 = a(bVar, "EXT_PARAM_KEY_SHAKE_SENSOR_ANGLE");
            if (!TextUtils.isEmpty(strA4)) {
                i4 = Integer.parseInt(strA4);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ShakeAndUpSlideInteractiveInfo", "ShakeAndUpSlideInteractiveInfo", e);
        }
        this.D = Math.max(i, a.k);
        this.E = Math.max(i2, a.l);
        this.F = Math.max(i3, a.m);
        this.G = i4 <= 0 ? 0 : Math.max(i4, a.o);
        com.opos.cmn.an.f.a.b("ShakeAndUpSlideInteractiveInfo", "shakeAndUpSlideSensorTime: " + i + ",shakeAndUpSlideSensorDiff: " + i2 + ",shakeAndUpSlideDistance: " + i3 + ",shakeAndUpSlideSensorAngle: " + i4);
    }
}
