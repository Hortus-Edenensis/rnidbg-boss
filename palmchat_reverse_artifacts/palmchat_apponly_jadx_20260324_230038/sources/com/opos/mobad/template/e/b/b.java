package com.opos.mobad.template.e.b;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b extends a {
    public final int D;
    public final int E;

    public b(com.opos.mobad.template.d.b bVar) {
        super(bVar);
        int i = a.u;
        int i2 = a.v;
        try {
            String strA = a(bVar, "EXT_PARAM_KEY_FORWARD_DEGREE");
            i = TextUtils.isEmpty(strA) ? i : Integer.parseInt(strA);
            String strA2 = a(bVar, "EXT_PARAM_KEY_FORWARD_TIME");
            if (!TextUtils.isEmpty(strA2)) {
                i2 = Integer.parseInt(strA2);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("ForwardInteractiveInfo", "ForwardInteractiveInfo", e);
        }
        this.E = Math.max(i, a.g);
        this.D = Math.max(i2, a.h);
        com.opos.cmn.an.f.a.b("ForwardInteractiveInfo", "forwardTime: " + i2 + ",forwardDegree: " + i);
    }
}
