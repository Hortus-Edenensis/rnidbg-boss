package com.baidu.xclient.gdid.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.a.c;
import com.baidu.mshield.b.f.d;
import com.baidu.mshield.b.f.e;
import com.baidu.xclient.gdid.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4311a;
    public String b = f.f4310a;

    public b(Context context) {
    }

    public static synchronized b a(Context context) {
        return new b(context);
    }

    public final void b() {
        try {
            f4311a = new String(d.a(Base64.decode(this.b, 0), com.baidu.mshield.b.f.a.a(16)));
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }

    public final String a() {
        if (TextUtils.isEmpty(f4311a)) {
            b();
        }
        return f4311a;
    }

    public String a(String str, String str2) {
        String str3 = com.baidu.xclient.gdid.d.c;
        String str4 = com.baidu.xclient.gdid.d.d;
        String strA = "";
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        try {
            strA = a(str3, str4, jCurrentTimeMillis);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
        sb.append(a());
        sb.append(str);
        sb.append(250);
        sb.append("/");
        sb.append(str3);
        sb.append("/");
        sb.append(jCurrentTimeMillis);
        sb.append("/");
        sb.append(strA);
        sb.append("?skey=");
        sb.append(str2);
        return sb.toString();
    }

    public String a(String str, String str2, long j) {
        try {
            return e.a(str + j + str2);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
            return "";
        }
    }

    public byte[] a(byte[] bArr, String str) {
        byte[] bArrA;
        try {
            bArrA = c.a(str.getBytes("utf-8"));
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
            bArrA = null;
        }
        return d.b(bArrA, bArr);
    }
}
