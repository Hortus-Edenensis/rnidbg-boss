package com.alipay.apmobilesecuritysdk.b;

import defpackage.w87;
import defpackage.xu6;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static a b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2559a = 0;

    public static a a() {
        return b;
    }

    public final int b() {
        return this.f2559a;
    }

    public final String c() {
        String str;
        String strB = w87.b();
        if (xu6.f(strB)) {
            return strB;
        }
        int i = this.f2559a;
        if (i == 1) {
            str = "://mobilegw.stable.alipay.net/mgw.htm";
        } else {
            if (i == 2) {
                return "https://mobilegwpre.alipay.com/mgw.htm";
            }
            if (i == 3) {
                str = "://mobilegw-1-64.test.alipay.net/mgw.htm";
            } else {
                if (i != 4) {
                    return "https://mobilegw.alipay.com/mgw.htm";
                }
                str = "://mobilegw.aaa.alipay.net/mgw.htm";
            }
        }
        return a(HttpHost.DEFAULT_SCHEME_NAME, str);
    }

    public static String a(String str, String str2) {
        return str + str2;
    }

    public final void a(int i) {
        this.f2559a = i;
    }
}
