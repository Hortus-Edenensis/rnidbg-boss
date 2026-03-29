package defpackage;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class yz4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22304a = "SHA";
    public static final String[] b = {x.dW, "SHA-384", "SHA-512"};

    public static boolean a(String str) {
        for (String str2 : b) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String b(String str) {
        return c(str, x.dW);
    }

    public static String c(String str, String str2) {
        byte[] bytes;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            g17.c(f22304a, "content or algorithm is null.");
            return "";
        }
        if (!a(str2)) {
            g17.c(f22304a, "algorithm is not safe or legal");
            return "";
        }
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bytes = new byte[0];
            g17.c(f22304a, "Error in generate SHA UnsupportedEncodingException");
        }
        return oh2.a(d(bytes, str2));
    }

    public static byte[] d(byte[] bArr, String str) {
        if (bArr == null || TextUtils.isEmpty(str)) {
            g17.c(f22304a, "content or algorithm is null.");
            return new byte[0];
        }
        if (!a(str)) {
            g17.c(f22304a, "algorithm is not safe or legal");
            return new byte[0];
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            g17.c(f22304a, "Error in generate SHA NoSuchAlgorithmException");
            return new byte[0];
        }
    }
}
