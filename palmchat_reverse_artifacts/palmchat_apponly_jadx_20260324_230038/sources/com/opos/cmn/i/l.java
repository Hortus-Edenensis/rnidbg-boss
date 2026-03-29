package com.opos.cmn.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f8031a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PackageInfo f8032a;
        public final Signature[] b;

        public a(PackageInfo packageInfo, Signature[] signatureArr) {
            this.f8032a = packageInfo;
            this.b = signatureArr;
        }
    }

    public static final a a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217856);
                if (packageInfo == null) {
                    return null;
                }
                return new a(packageInfo, packageInfo.signingInfo.getApkContentsSigners());
            }
            PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 192);
            if (packageInfo2 == null) {
                return null;
            }
            return new a(packageInfo2, packageInfo2.signatures);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return null;
        }
    }

    public static final String a(String str) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("sha256");
        messageDigest.update(str.getBytes());
        return a(messageDigest.digest());
    }

    public static final String a(String str, Signature signature) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(signature.toByteArray());
        return a(messageDigest.digest());
    }

    public static final String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 2;
            char[] cArr2 = f8031a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static final Signature[] a(Context context) {
        a aVarA = a(context, context.getPackageName());
        if (aVarA != null) {
            return aVarA.b;
        }
        return null;
    }
}
