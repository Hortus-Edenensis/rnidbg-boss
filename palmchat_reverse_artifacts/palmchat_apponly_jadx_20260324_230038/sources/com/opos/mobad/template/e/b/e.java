package com.opos.mobad.template.e.b;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e extends a {
    public final int D;
    public final int E;
    public final int F;

    public e(com.opos.mobad.template.d.b bVar) {
        super(bVar);
        int i = a.p;
        int i2 = a.q;
        int i3 = a.C;
        try {
            i = bVar.D;
            i2 = bVar.E;
            String strA = a(bVar, "EXT_PARAM_KEY_SHAKE_SENSOR_ANGLE");
            if (!TextUtils.isEmpty(strA)) {
                i3 = Integer.parseInt(strA);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ShakeInteractiveInfo", "ShakeInteractiveInfo", e);
        }
        this.D = Math.max(i, a.c);
        this.E = Math.max(i2, a.d);
        this.F = i3 <= 0 ? 0 : Math.max(i3, a.o);
        com.opos.cmn.an.f.a.b("ShakeInteractiveInfo", "shakeTime: " + i + ",shakeDiff: " + i2 + ",shakeAngle: " + i3);
    }
}
