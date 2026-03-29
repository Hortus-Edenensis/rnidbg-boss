package defpackage;

import android.content.Context;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cw2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Integer f16935a;

    public static String a(Context context) {
        long jN = fv2.n(context);
        return jN > 0 ? n45.h(jN) : n45.h(b());
    }

    public static int b() {
        Integer num = f16935a;
        if (num != null) {
            return num.intValue();
        }
        Integer numValueOf = Integer.valueOf(Math.abs(new SecureRandom().nextInt()));
        f16935a = numValueOf;
        return numValueOf.intValue();
    }

    public static byte[] c(Context context, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length - 24;
        byte[] bArr2 = new byte[24];
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, 24);
        System.arraycopy(bArr, 24, bArr3, 0, length);
        String strA = a(context);
        try {
            byte b = tv2.k;
            k63.a("CorePackage", "encryptBuf algorithm=" + ((int) b) + ", key=" + strA);
            byte[] bArrJ = b == 2 ? new c05().j(bArr3, strA) : n45.a(bArr3, strA, strA.substring(0, 16), true);
            int length2 = bArrJ.length + 24;
            byte[] bArr4 = new byte[length2];
            System.arraycopy(bArr2, 0, bArr4, 0, 24);
            System.arraycopy(bArrJ, 0, bArr4, 24, bArrJ.length);
            byte b2 = (byte) ((length2 >>> 8) & 255);
            bArr4[0] = b2;
            bArr4[1] = (byte) (length2 & 255);
            bArr4[0] = (byte) (b2 | ByteCompanionObject.MIN_VALUE);
            bArr4[4] = b;
            return bArr4;
        } catch (Exception e) {
            k63.l("CorePackage", "e:" + e);
            k63.n("CorePackage", "encrpt data failed");
            return null;
        }
    }

    public static String d(ByteBuffer byteBuffer) throws Throwable {
        byte[] bArr = new byte[byteBuffer.getShort()];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "UTF-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] e(long j, String str, long[] jArr) {
        ia4 ia4Var = new ia4(20480);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", str);
            JSONArray jSONArray = new JSONArray();
            if (jArr != null) {
                jSONArray.put(j);
                for (long j2 : jArr) {
                    jSONArray.put(j2);
                }
            }
            jSONObject.put("uids", jSONArray);
            k63.a("CorePackage", "attach uids:" + jSONArray.toString());
            ia4Var.g(jSONObject.toString());
            return ia4Var.d();
        } catch (Throwable th) {
            k63.l("CorePackage", "packageAttachInfo:" + th);
            return null;
        }
    }

    public static byte[] f(String str, long[] jArr) {
        ia4 ia4Var = new ia4(20480);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", str);
            JSONArray jSONArray = new JSONArray();
            if (jArr != null) {
                for (long j : jArr) {
                    jSONArray.put(j);
                }
            }
            jSONObject.put("uids", jSONArray);
            ia4Var.g(jSONObject.toString());
            return ia4Var.d();
        } catch (Throwable th) {
            k63.l("CorePackage", "packageDetachInfo:" + th);
            return null;
        }
    }

    public static byte[] g(long j, int i, long j2, short s, int i2) {
        ia4 ia4Var = new ia4(20480);
        ia4Var.h(0);
        ia4Var.l(6);
        ia4Var.l(2);
        ia4Var.k(j);
        ia4Var.j(i);
        ia4Var.k(j2);
        ia4Var.j(s);
        ia4Var.l(i2);
        ia4Var.i(ia4Var.b(), 0);
        return ia4Var.d();
    }

    public static byte[] h(long j, long j2, String str, String str2, String str3, long j3, byte b, int i, String str4, String str5, String str6, String str7, int i2) {
        ia4 ia4Var = new ia4(20480);
        ia4Var.h(0);
        ia4Var.l(24);
        ia4Var.l(1);
        ia4Var.k(j);
        ia4Var.j(0L);
        ia4Var.k(j2);
        ia4Var.l(97);
        ia4Var.l(0);
        ia4Var.h(0);
        ia4Var.g(str);
        ia4Var.g(str3);
        ia4Var.g(str2);
        ia4Var.l(0);
        ia4Var.j(j3);
        ia4Var.l(b);
        ia4Var.l(i);
        ia4Var.g(str4);
        ia4Var.g(str5);
        ia4Var.g(str6);
        ia4Var.g(str7);
        ia4Var.l(i2);
        ia4Var.i(ia4Var.b(), 0);
        return ia4Var.d();
    }

    public static byte[] i(int i, byte b, long j, String str) {
        ia4 ia4Var = new ia4(20480);
        ia4Var.h(i);
        ia4Var.l(b);
        ia4Var.k(j);
        ia4Var.g(str);
        return ia4Var.d();
    }

    public static byte[] j(long j, String str, String str2, String str3, String str4, long j2, String str5) {
        int iB = b();
        ia4 ia4Var = new ia4(20480);
        ia4Var.h(0);
        ia4Var.l(24);
        ia4Var.l(0);
        ia4Var.k(j);
        ia4Var.j(iB);
        ia4Var.k(0L);
        ia4Var.g(str);
        ia4Var.g(str2);
        ia4Var.g(str3);
        ia4Var.l(0);
        ia4Var.g(str4);
        ia4Var.j(j2);
        ia4Var.g(str5);
        ia4Var.i(ia4Var.b(), 0);
        return ia4Var.d();
    }

    public static byte[] k(Context context, int i, int i2, long j, byte[] bArr, long j2) {
        ia4 ia4Var = new ia4(20480);
        ia4Var.h(0);
        ia4Var.l(i2);
        ia4Var.l(i);
        ia4Var.k(j);
        ia4Var.j(tv2.l);
        k63.a("CorePackage", "packageSendData uid:" + j2);
        if (j2 == 0) {
            j2 = fv2.n(context);
            k63.a("CorePackage", "use mine uid:" + j2);
        }
        ia4Var.k(j2);
        ia4Var.e(bArr);
        ia4Var.i(ia4Var.b(), 0);
        return c(context, ia4Var.d());
    }

    public static byte[] l(short s, short s2, String str) {
        ia4 ia4Var = new ia4(20480);
        ia4Var.l(s);
        ia4Var.l(s2);
        ia4Var.g(str);
        return ia4Var.d();
    }
}
