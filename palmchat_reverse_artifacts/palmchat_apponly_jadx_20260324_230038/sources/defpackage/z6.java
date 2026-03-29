package defpackage;

import android.text.TextUtils;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class z6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile z6 f22358a;

    public static z6 d() {
        if (f22358a == null) {
            synchronized (z6.class) {
                if (f22358a == null) {
                    f22358a = new z6();
                }
            }
        }
        return f22358a;
    }

    public void a(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public String b(String str) {
        return new BigInteger(e(str.getBytes())).abs().toString(36);
    }

    public String c(String str, boolean z) {
        File file = new File(pu1.r, b(str));
        String path = file.getPath();
        if (!z) {
            return path;
        }
        if (!file.exists() || file.length() == 0) {
            return null;
        }
        return path;
    }

    public final byte[] e(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            n03.a(e);
            return null;
        }
    }

    public String f() {
        return new File(pu1.r, xn3.a()).getPath();
    }

    public void g(String str, String str2) throws Throwable {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String strC = c(str, false);
        File file = new File(str2);
        if (!file.exists() || file.length() == 0) {
            return;
        }
        pu1.f(file, new File(strC));
    }
}
