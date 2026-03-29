package com.opos.cmn.biz.web.c.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.opos.cmn.an.d.b;
import com.ss.android.downloadad.api.constant.AdBaseConstants;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static int a() {
        return 201;
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return com.opos.cmn.an.h.c.a.d(context) ? com.opos.cmn.an.h.c.a.h(context) : "nonet";
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("JSUtils", "", e);
            return "";
        }
    }

    public static boolean a(Context context, String str) {
        if (context != null) {
            try {
                if (b.a(str)) {
                    return false;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(268435456);
                intent.setDataAndType(Uri.parse(str), AdBaseConstants.MIME_APK);
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("JSUtils", "", e);
                return false;
            }
        }
        return false;
    }
}
