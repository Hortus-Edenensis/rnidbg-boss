package com.opos.mobad.template.e.b;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f extends a {
    public final int D;

    public f(com.opos.mobad.template.d.b bVar) {
        super(bVar);
        int i = a.B;
        try {
            String strA = a(bVar, "EXT_PARAM_KEY_SLIDE_LAYER_DISTANCE");
            if (!TextUtils.isEmpty(strA)) {
                i = Integer.parseInt(strA);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("SlideLayerInteractiveInfo", "SlideLayerInteractiveInfo", e);
        }
        this.D = Math.max(i, a.n);
        com.opos.cmn.an.f.a.b("SlideLayerInteractiveInfo", "slideLayerDistance: " + i);
    }
}
