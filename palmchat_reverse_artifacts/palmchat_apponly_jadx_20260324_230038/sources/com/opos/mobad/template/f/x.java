package com.opos.mobad.template.f;

import android.content.Context;
import com.opos.mobad.template.cmn.af;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x {
    public static final e a(Context context) {
        return new o(context);
    }

    public static final e a(Context context, int i, int i2, com.opos.mobad.d.a aVar, boolean z) {
        if ((i2 == 2 || i2 == 1) && af.b(context) && i == 0) {
            com.opos.cmn.an.f.a.b("插屏图片", "竖屏");
            return new u(context, i2, aVar, z);
        }
        if (af.a(context, 2.12f) < 0 || i == 1) {
            com.opos.cmn.an.f.a.b("插屏图片", "横屏");
            return new r(context, i, i2, aVar, z);
        }
        com.opos.cmn.an.f.a.b("插屏图片", "竖屏");
        return new u(context, i2, aVar, z);
    }

    public static final e a(Context context, int i, boolean z, com.opos.mobad.d.a aVar, int i2) {
        return a(context, i, z, aVar, false, i2);
    }

    public static final e a(Context context, int i, boolean z, com.opos.mobad.d.a aVar, boolean z2) {
        return a(context, i, z, aVar, z2, -1);
    }

    public static final e a(Context context, int i, boolean z, com.opos.mobad.d.a aVar, boolean z2, int i2) {
        if (z && af.b(context) && i == 0) {
            com.opos.cmn.an.f.a.b("插屏视频", "竖屏");
            return new u(context, z, aVar, z2, i2);
        }
        if (af.a(context, 2.12f) < 0 || i == 1) {
            com.opos.cmn.an.f.a.b("插屏视频", "横屏");
            return new r(context, i, z, aVar, z2, i2);
        }
        com.opos.cmn.an.f.a.b("插屏视频", "竖屏");
        return new u(context, z, aVar, z2, i2);
    }
}
