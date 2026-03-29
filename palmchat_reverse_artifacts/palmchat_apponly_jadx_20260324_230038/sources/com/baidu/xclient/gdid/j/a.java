package com.baidu.xclient.gdid.j;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static String a(Context context) {
        try {
            String strC = com.baidu.mshield.b.b.a.c(context);
            return TextUtils.isEmpty(strC) ? com.baidu.mshield.b.b.a.b(context) : strC;
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }
}
