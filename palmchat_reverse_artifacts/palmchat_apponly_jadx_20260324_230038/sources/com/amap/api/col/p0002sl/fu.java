package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fu {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        String A;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f2801a;
        String b;
        String c;
        String d;
        String e;
        String f;
        String g;
        String h;
        String i;
        String j;
        String k;
        String l;
        String m;
        String n;
        String o;
        String p;
        String q;
        String r;
        String s;
        String t;
        String u;
        String v;
        String w;
        String x;
        String y;
        String z;

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            return fz.a(fr.e(context) + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            ha.a(th, "CI", "Sco");
            return null;
        }
    }

    public static String b(Context context) {
        return c(context);
    }

    private static String c(Context context) {
        try {
            return a(b(context, false, false));
        } catch (Throwable th) {
            ha.a(th, "CI", "gCXi");
            return null;
        }
    }

    private static byte[] b(byte[] bArr) throws BadPaddingException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException, NullPointerException {
        PublicKey publicKeyD = ge.d();
        if (bArr.length <= 117) {
            return fw.a(bArr, publicKeyD);
        }
        byte[] bArr2 = new byte[117];
        System.arraycopy(bArr, 0, bArr2, 0, 117);
        byte[] bArrA = fw.a(bArr2, publicKeyD);
        byte[] bArr3 = new byte[(bArr.length + 128) - 117];
        System.arraycopy(bArrA, 0, bArr3, 0, 128);
        System.arraycopy(bArr, 117, bArr3, 128, bArr.length - 117);
        return bArr3;
    }

    public static String a() {
        try {
            String strValueOf = String.valueOf(System.currentTimeMillis());
            String str = fr.a() ? "1" : "0";
            int length = strValueOf.length();
            return strValueOf.substring(0, length - 2) + str + strValueOf.substring(length - 1);
        } catch (Throwable th) {
            ha.a(th, "CI", "TS");
            return null;
        }
    }

    public static String a(Context context) {
        try {
            a aVar = new a((byte) 0);
            aVar.d = fr.c(context);
            aVar.i = fr.d(context);
            return a(aVar);
        } catch (Throwable th) {
            ha.a(th, "CI", "IX");
            return null;
        }
    }

    private static byte[] b(a aVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                a(byteArrayOutputStream, aVar.f2801a);
                a(byteArrayOutputStream, aVar.b);
                a(byteArrayOutputStream, aVar.c);
                a(byteArrayOutputStream, aVar.d);
                a(byteArrayOutputStream, aVar.e);
                a(byteArrayOutputStream, aVar.f);
                a(byteArrayOutputStream, aVar.g);
                a(byteArrayOutputStream, aVar.h);
                a(byteArrayOutputStream, aVar.i);
                a(byteArrayOutputStream, aVar.j);
                a(byteArrayOutputStream, aVar.k);
                a(byteArrayOutputStream, aVar.l);
                a(byteArrayOutputStream, aVar.m);
                a(byteArrayOutputStream, aVar.n);
                a(byteArrayOutputStream, aVar.o);
                a(byteArrayOutputStream, aVar.p);
                a(byteArrayOutputStream, aVar.q);
                a(byteArrayOutputStream, aVar.r);
                a(byteArrayOutputStream, aVar.s);
                a(byteArrayOutputStream, aVar.t);
                a(byteArrayOutputStream, aVar.u);
                a(byteArrayOutputStream, aVar.v);
                a(byteArrayOutputStream, aVar.w);
                a(byteArrayOutputStream, aVar.x);
                a(byteArrayOutputStream, aVar.y);
                a(byteArrayOutputStream, aVar.z);
                a(byteArrayOutputStream, aVar.A);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                new String(byteArray);
                byte[] bArrB = b(ge.b(byteArray));
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return bArrB;
            } catch (Throwable th2) {
                th = th2;
                try {
                    ha.a(th, "CI", "gzx");
                    return null;
                } finally {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] a(byte[] bArr) throws BadPaddingException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException, NullPointerException {
        return fw.a(bArr);
    }

    public static byte[] a(Context context, boolean z, boolean z2) {
        try {
            return b(b(context, z, z2));
        } catch (Throwable th) {
            ha.a(th, "CI", "gz");
            return null;
        }
    }

    private static String a(a aVar) {
        return fw.b(b(aVar));
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            ge.a(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, ge.a(str));
        } else {
            ge.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    private static a b(Context context, boolean z, boolean z2) {
        a aVar = new a((byte) 0);
        aVar.f2801a = fv.k();
        aVar.b = fv.h();
        String strF = fv.f(context);
        if (strF == null) {
            strF = "";
        }
        aVar.c = strF;
        aVar.d = fr.c(context);
        aVar.e = Build.MODEL;
        aVar.f = Build.MANUFACTURER;
        aVar.g = Build.DEVICE;
        aVar.h = fr.b(context);
        aVar.i = fr.d(context);
        aVar.j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.k = fv.n();
        aVar.l = fv.m(context);
        StringBuilder sb = new StringBuilder();
        sb.append(fv.j(context));
        aVar.m = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(fv.i(context));
        aVar.n = sb2.toString();
        aVar.o = fv.s(context);
        aVar.p = fv.h(context);
        aVar.q = "";
        aVar.r = "";
        if (z) {
            aVar.s = "";
            aVar.t = "";
        } else {
            String[] strArrI = fv.i();
            aVar.s = strArrI[0];
            aVar.t = strArrI[1];
        }
        aVar.w = fv.a();
        String strA = fv.a(context);
        if (!TextUtils.isEmpty(strA)) {
            aVar.x = strA;
        } else {
            aVar.x = "";
        }
        aVar.y = "aid=" + fv.g();
        if ((z2 && go.d) || go.e) {
            String strE = fv.e(context);
            if (!TextUtils.isEmpty(strE)) {
                aVar.y += "|oaid=" + strE;
            }
        }
        String strJ = fv.j();
        if (!TextUtils.isEmpty(strJ)) {
            aVar.y += "|multiImeis=" + strJ;
        }
        String strM = fv.m();
        if (!TextUtils.isEmpty(strM)) {
            aVar.y += "|meid=" + strM;
        }
        aVar.y += "|serial=" + fv.f();
        String strB = fv.b();
        if (!TextUtils.isEmpty(strB)) {
            aVar.y += "|adiuExtras=" + strB;
        }
        aVar.y += "|storage=" + fv.o() + "|ram=" + fv.r(context) + "|arch=" + fv.p();
        String strB2 = gz.a().b();
        if (!TextUtils.isEmpty(strB2)) {
            aVar.z = strB2;
        } else {
            aVar.z = "";
        }
        if (z) {
            String strA2 = gk.a(context).a();
            if (!TextUtils.isEmpty(strA2)) {
                aVar.A = strA2;
            }
        }
        return aVar;
    }
}
