package com.kwad.components.core.page.widget.halfContainer;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.ex;
import com.kwad.components.core.s.r;
import com.kwad.components.core.s.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class e implements f {
    private static boolean aM(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Boolean.parseBoolean(str);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    @Override // com.kwad.components.core.page.widget.halfContainer.f
    public final d aL(String str) {
        d dVar = new d();
        if (TextUtils.isEmpty(str)) {
            return dVar;
        }
        Uri uri = Uri.parse(str);
        dVar.YW = r.a(u.a(uri, "heightRatio", "0"), 0.0f);
        dVar.YX = r.a(u.a(uri, "absoluteHeight", "0"), 0.0f);
        dVar.YZ = r.m(u.a(uri, "topRadius", "0"), 0);
        dVar.YY = r.a(u.a(uri, "maskAlpha", "0"), 0.0f);
        dVar.Za = aM(u.a(uri, "disableClickOutsideDismiss", ex.V));
        dVar.Zb = aM(u.a(uri, "enableDragHalfToFull", ex.V));
        dVar.Zc = aM(u.a(uri, "showStatusBar", ex.V));
        dVar.Ze = aM(u.a(uri, "isAdjustKeyBoard", ex.Code));
        dVar.Zg = u.a(uri);
        return dVar;
    }
}
