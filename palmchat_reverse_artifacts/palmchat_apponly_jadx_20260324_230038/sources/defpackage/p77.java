package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class p77 {
    public static p77 j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19957a;
    public ua7 c;
    public String d;
    public String e;
    public ku6 f;
    public ku6 g;
    public static final Object i = new Object();
    public static final String k = ".UTSystemConfig" + File.separator + "Global";
    public String b = null;
    public Pattern h = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public p77(Context context) {
        this.f19957a = null;
        this.c = null;
        this.d = "xx_utdid_key";
        this.e = "xx_utdid_domain";
        this.f = null;
        this.g = null;
        this.f19957a = context;
        this.g = new ku6(context, k, "Alvin2", false, true);
        this.f = new ku6(context, ".DataStorage", "ContextData", false, true);
        this.c = new ua7();
        this.d = String.format("K_%d", Integer.valueOf(kc7.a(this.d)));
        this.e = String.format("D_%d", Integer.valueOf(kc7.a(this.e)));
    }

    public static p77 a(Context context) {
        if (context != null && j == null) {
            synchronized (i) {
                if (j == null) {
                    p77 p77Var = new p77(context);
                    j = p77Var;
                    p77Var.i();
                }
            }
        }
        return j;
    }

    public static String c(byte[] bArr) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(sa7.b(new byte[]{69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93}), mac.getAlgorithm()));
        return a07.e(mac.doFinal(bArr), 2);
    }

    public synchronized String b() {
        String strG = g();
        this.b = strG;
        if (!TextUtils.isEmpty(strG)) {
            return this.b;
        }
        try {
            byte[] bArrJ = j();
            if (bArrJ != null) {
                String strE = a07.e(bArrJ, 2);
                this.b = strE;
                f(strE);
                String strB = this.c.b(bArrJ);
                if (strB != null) {
                    h(strB);
                }
                return this.b;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public final boolean d(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.h.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    public synchronized String e() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        return b();
    }

    public final void f(String str) {
        ku6 ku6Var;
        if (d(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (ku6Var = this.g) == null) {
                return;
            }
            ku6Var.b("UTDID2", str);
            this.g.c();
        }
    }

    public synchronized String g() {
        String strK = k();
        if (d(strK)) {
            h(this.c.a(strK));
            this.b = strK;
            return strK;
        }
        String strA = this.f.a(this.d);
        if (!kc7.b(strA)) {
            String strA2 = new lc7().a(strA);
            if (!d(strA2)) {
                strA2 = this.c.c(strA);
            }
            if (d(strA2) && !kc7.b(strA2)) {
                this.b = strA2;
                f(strA2);
                return this.b;
            }
        }
        return null;
    }

    public final void h(String str) {
        ku6 ku6Var;
        if (str == null || (ku6Var = this.f) == null || str.equals(ku6Var.a(this.d))) {
            return;
        }
        this.f.b(this.d, str);
        this.f.c();
    }

    public final void i() {
        boolean z;
        ku6 ku6Var = this.g;
        if (ku6Var != null) {
            if (kc7.b(ku6Var.a("UTDID2"))) {
                String strA = this.g.a("UTDID");
                if (!kc7.b(strA)) {
                    f(strA);
                }
            }
            boolean z2 = true;
            if (kc7.b(this.g.a("DID"))) {
                z = false;
            } else {
                this.g.e("DID");
                z = true;
            }
            if (!kc7.b(this.g.a("EI"))) {
                this.g.e("EI");
                z = true;
            }
            if (kc7.b(this.g.a("SI"))) {
                z2 = z;
            } else {
                this.g.e("SI");
            }
            if (z2) {
                this.g.c();
            }
        }
    }

    public final byte[] j() throws Exception {
        String strB;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNextInt = new Random().nextInt();
        byte[] bArrA = h37.a(iCurrentTimeMillis);
        byte[] bArrA2 = h37.a(iNextInt);
        byteArrayOutputStream.write(bArrA, 0, 4);
        byteArrayOutputStream.write(bArrA2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            strB = n77.b(this.f19957a);
        } catch (Exception unused) {
            strB = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(h37.a(kc7.a(strB)), 0, 4);
        byteArrayOutputStream.write(h37.a(kc7.a(c(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    public final String k() {
        ku6 ku6Var = this.g;
        if (ku6Var == null) {
            return null;
        }
        String strA = ku6Var.a("UTDID2");
        if (kc7.b(strA) || this.c.a(strA) == null) {
            return null;
        }
        return strA;
    }
}
