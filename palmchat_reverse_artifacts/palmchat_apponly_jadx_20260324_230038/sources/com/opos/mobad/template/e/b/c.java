package com.opos.mobad.template.e.b;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c extends a {
    public final int D;

    public c(com.opos.mobad.template.d.b bVar) {
        super(bVar);
        int i = a.x;
        try {
            String strA = a(bVar, "EXT_PARAM_KEY_FULL_SCREEN_SLIDE_DISTANCE");
            if (!TextUtils.isEmpty(strA)) {
                i = Integer.parseInt(strA);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("FullSlideInteractiveInfo", "FullSlideInteractiveInfo", e);
        }
        this.D = Math.max(i, a.j);
        com.opos.cmn.an.f.a.b("FullSlideInteractiveInfo", "fullScreenSlideDistance: " + i);
    }
}
