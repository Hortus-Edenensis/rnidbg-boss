package com.opos.mobad.template.e.b;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g extends a {
    public final int D;
    public final int E;
    public final boolean F;

    public g(com.opos.mobad.template.d.b bVar) {
        super(bVar);
        int i = a.r;
        int i2 = a.s;
        boolean z = a.t;
        try {
            String strA = a(bVar, "EXT_PARAM_KEY_TILT_DEGREE");
            i = TextUtils.isEmpty(strA) ? i : Integer.parseInt(strA);
            String strA2 = a(bVar, "EXT_PARAM_KEY_TILT_TIME");
            i2 = TextUtils.isEmpty(strA2) ? i2 : Integer.parseInt(strA2);
            String strA3 = a(bVar, "EXT_PARAM_KEY_TILT_TWOWAY");
            if (!TextUtils.isEmpty(strA3)) {
                z = Boolean.parseBoolean(strA3);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("TiltInteractiveInfo", "TiltInteractiveInfo", e);
        }
        this.E = Math.max(i, a.e);
        this.D = Math.max(i2, a.f);
        this.F = z;
        com.opos.cmn.an.f.a.b("TiltInteractiveInfo", "tiltDegree: " + i + ",tiltTime: " + i2);
    }
}
