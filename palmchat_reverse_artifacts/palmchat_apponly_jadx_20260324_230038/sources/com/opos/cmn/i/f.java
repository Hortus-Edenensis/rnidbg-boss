package com.opos.cmn.i;

import android.content.Context;
import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f8027a = "getCryptByKey";
    private static String b;

    public static final String a() {
        return UUID.randomUUID().toString();
    }

    private static final String b() {
        String strA = m.a("sys.serialnumber");
        return TextUtils.isEmpty(strA) ? m.a("ril.serialnumber") : strA;
    }

    private static final String c() {
        return m.a("gsm.serial");
    }

    private static final String d() {
        return m.a("vendor.gsm.serial");
    }

    public static final String a(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            String strC = c();
            if (TextUtils.isEmpty(strC)) {
                strC = d();
            }
            if (TextUtils.isEmpty(strC)) {
                strC = b();
            }
            if (TextUtils.isEmpty(strC)) {
                return "";
            }
            b = strC;
            return strC;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("", "", e);
            return "";
        }
    }
}
