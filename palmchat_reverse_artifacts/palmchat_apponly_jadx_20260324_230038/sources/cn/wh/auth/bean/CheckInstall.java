package cn.wh.auth.bean;

import android.app.Activity;
import android.content.Context;
import android.content.pm.Signature;
import com.fort.andJni.JniLib1716343241;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class CheckInstall {
    private static final String TAG = "CheckInstall";

    public CheckInstall() {
        JniLib1716343241.cV(this, 11);
    }

    public static String getAppSignature(Context context, String str) {
        return (String) JniLib1716343241.cL(context, str, 12);
    }

    private static String getSHA1(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
        messageDigest.update(bArr);
        byte[] bArrDigest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    public static boolean isAppInstalled(Activity activity) {
        return JniLib1716343241.cZ(activity, 13);
    }

    public static boolean isIntentExisting(Context context, String str) {
        return JniLib1716343241.cZ(context, str, 14);
    }

    public static boolean verifyAppSignature(Context context, String str) {
        StringBuilder sb;
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(signatureArr[0].toByteArray());
            byte[] bArrDigest = messageDigest.digest();
            sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
        } catch (Exception unused) {
        }
        return "76db302749c810ef6c1788295259a43da8ecaac6".equalsIgnoreCase(sb.toString());
    }
}
