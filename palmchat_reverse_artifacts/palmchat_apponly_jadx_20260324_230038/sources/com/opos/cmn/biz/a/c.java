package com.opos.cmn.biz.a;

import android.content.Context;
import com.ss.android.download.api.constant.BaseConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7820a = "com." + com.opos.cmn.an.b.a.c + ".market";
    private static final String b = "com." + com.opos.cmn.an.b.a.f7732a + ".market";
    private static final String c = "com." + com.opos.cmn.an.b.a.d + ".browser";

    public static String a(Context context) {
        if (com.opos.cmn.an.h.d.a.d(context, "com.heytap.market")) {
            return "com.heytap.market";
        }
        String str = f7820a;
        if (com.opos.cmn.an.h.d.a.d(context, str)) {
            return str;
        }
        String str2 = b;
        return com.opos.cmn.an.h.d.a.d(context, str2) ? str2 : "";
    }

    public static String b(Context context) {
        if (com.opos.cmn.an.h.d.a.d(context, BaseConstants.KLLK_PROMOTION_HEYTAP_PKG_INFO)) {
            return BaseConstants.KLLK_PROMOTION_HEYTAP_PKG_INFO;
        }
        String str = c;
        return com.opos.cmn.an.h.d.a.d(context, str) ? str : com.opos.cmn.an.h.d.a.d(context, "com.nearme.browser") ? "com.nearme.browser" : com.opos.cmn.an.h.d.a.d(context, BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO) ? BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO : "";
    }
}
