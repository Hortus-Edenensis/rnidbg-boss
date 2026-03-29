package com.opos.cmn.i;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class j {
    public static boolean a(Context context, String[] strArr) {
        if (context != null && strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!com.opos.cmn.an.h.d.a.a(context, str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("don't have permission=");
                    if (str == null) {
                        str = com.igexin.push.core.b.m;
                    }
                    sb.append(str);
                    com.opos.cmn.an.f.a.c("PermissionUtils", sb.toString());
                    return false;
                }
            }
        }
        return true;
    }
}
