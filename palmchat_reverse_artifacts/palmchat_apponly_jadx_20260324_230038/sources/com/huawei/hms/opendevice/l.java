package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.hms.openid.R$string;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import defpackage.mo6;
import defpackage.pm1;
import defpackage.rn2;
import defpackage.rq;
import defpackage.ty4;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6808a = "l";
    private static Map<String, String> b = new HashMap();
    private static final Object c = new Object();

    private static String a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    private static byte[] b() {
        return a(d(), e(), c(), g());
    }

    public static void c(Context context) {
        synchronized (c) {
            d(context.getApplicationContext());
            if (i()) {
                HMSLog.i(f6808a, "The local secret is already in separate file mode.");
                return;
            }
            File file = new File(e.c(context.getApplicationContext()) + "/shared_prefs/LocalAvengers.xml");
            if (file.exists()) {
                rn2.a(file);
                HMSLog.i(f6808a, "destroy C, delete file LocalAvengers.xml.");
            }
            byte[] bArrC = pm1.c(32);
            byte[] bArrC2 = pm1.c(32);
            byte[] bArrC3 = pm1.c(32);
            byte[] bArrC4 = pm1.c(32);
            String strA = d.a(bArrC);
            String strA2 = d.a(bArrC2);
            String strA3 = d.a(bArrC3);
            String strA4 = d.a(bArrC4);
            a(strA, strA2, strA3, strA4, mo6.c(d.a(pm1.c(32)), a(strA, strA2, strA3, strA4)), context);
            HMSLog.i(f6808a, "generate D.");
        }
    }

    private static void d(Context context) throws Throwable {
        if (i()) {
            HMSLog.i(f6808a, "secretKeyCache not empty.");
            return;
        }
        b.clear();
        String strC = e.c(context);
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        String strA = m.a(strC + "/files/math/m");
        String strA2 = m.a(strC + "/files/panda/p");
        String strA3 = m.a(strC + "/files/panda/d");
        String strA4 = m.a(strC + "/files/math/t");
        String strA5 = m.a(strC + "/files/s");
        if (n.a(strA, strA2, strA3, strA4, strA5)) {
            b.put("m", strA);
            b.put("p", strA2);
            b.put("d", strA3);
            b.put("t", strA4);
            b.put("s", strA5);
        }
    }

    private static synchronized String e(Context context) {
        String strB = mo6.b(f(), b());
        if (n.a(strB)) {
            HMSLog.i(f6808a, "keyS has been upgraded, no require operate again.");
            return strB;
        }
        String strA = mo6.a(f(), h());
        if (n.a(strA)) {
            HMSLog.i(f6808a, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");
            a(mo6.c(strA, b()), context);
            return strA;
        }
        String strB2 = mo6.b(f(), rq.e(d(), e(), c(), g(), 32, false));
        if (!n.a(strB2)) {
            HMSLog.e(f6808a, "all mode unable to decrypt root key.");
            return "";
        }
        HMSLog.i(f6808a, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");
        a(mo6.c(strB2, b()), context);
        return strB2;
    }

    private static String f() {
        return a("s");
    }

    private static String g() {
        return a("t");
    }

    private static ty4 h() {
        return ty4.d(d(), e(), c(), g());
    }

    private static boolean i() {
        return !TextUtils.isEmpty(f());
    }

    private static byte[] a(String str, String str2, String str3, String str4) {
        return Build.VERSION.SDK_INT >= 26 ? rq.e(str, str2, str3, str4, 32, true) : rq.e(str, str2, str3, str4, 32, false);
    }

    public static String b(Context context) {
        if (!i()) {
            HMSLog.i(f6808a, "work key is empty, execute init.");
            c(context);
        }
        String strB = mo6.b(f(), b());
        return n.a(strB) ? strB : e(context);
    }

    public static byte[] a(Context context) {
        byte[] bArrA = d.a(context.getString(R$string.push_cat_head));
        byte[] bArrA2 = d.a(context.getString(R$string.push_cat_body));
        return a(a(a(bArrA, bArrA2), d.a(a())));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        if (length != bArr2.length) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    private static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] >> 2);
        }
        return bArr;
    }

    private static void a(String str, String str2, String str3, String str4, String str5, Context context) throws Throwable {
        String strC = e.c(context.getApplicationContext());
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        try {
            a("m", str, strC + "/files/math/m");
            a("p", str2, strC + "/files/panda/p");
            a("d", str3, strC + "/files/panda/d");
            a("t", str4, strC + "/files/math/t");
            a("s", str5, strC + "/files/s");
        } catch (IOException unused) {
            HMSLog.e(f6808a, "save key IOException.");
        }
    }

    private static String d() {
        return a("m");
    }

    private static String e() {
        return a("p");
    }

    private static String c() {
        return a("d");
    }

    private static void a(String str, Context context) throws Throwable {
        String strC = e.c(context.getApplicationContext());
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        try {
            a("s", str, strC + "/files/s");
        } catch (IOException unused) {
            HMSLog.e(f6808a, "save keyS IOException.");
        }
    }

    private static void a(String str, String str2, String str3) throws Throwable {
        OutputStreamWriter outputStreamWriter;
        HMSLog.i(f6808a, "save local secret key.");
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(str3);
            m.a(file);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(outputStreamWriter);
                try {
                    bufferedWriter2.write(str2);
                    bufferedWriter2.flush();
                    b.put(str, str2);
                    IOUtils.closeQuietly((Writer) outputStreamWriter);
                    IOUtils.closeQuietly((Writer) bufferedWriter2);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    IOUtils.closeQuietly((Writer) outputStreamWriter);
                    IOUtils.closeQuietly((Writer) bufferedWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStreamWriter = null;
        }
    }

    private static String a(String str) {
        String str2 = b.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
