package com.opos.mobad.template.e.b;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class h extends a {
    public final String D;
    public final int E;

    public h(com.opos.mobad.template.d.b bVar) {
        super(bVar);
        this.D = !TextUtils.isEmpty(bVar.j) ? bVar.j : null;
        int i = a.w;
        try {
            String strA = a(bVar, "EXT_PARAM_KEY_UP_SLIDE_DISTANCE");
            if (!TextUtils.isEmpty(strA)) {
                i = Integer.parseInt(strA);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("UpSlideInteractiveInfo", "UpSlideInteractiveInfo", e);
        }
        this.E = Math.max(i, a.i);
        com.opos.cmn.an.f.a.b("UpSlideInteractiveInfo", "upSlideDistance: " + i);
    }
}
