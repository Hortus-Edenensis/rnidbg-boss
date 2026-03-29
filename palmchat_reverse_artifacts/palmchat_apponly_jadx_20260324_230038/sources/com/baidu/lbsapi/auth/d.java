package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.huawei.openalliance.ad.constant.x;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class d {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        public static String a(byte[] bArr) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (int i = 0; i < bArr.length; i++) {
                sb.append(cArr[(bArr[i] & 240) >> 4]);
                sb.append(cArr[bArr[i] & 15]);
            }
            return sb.toString();
        }
    }

    public static String a() {
        return Locale.getDefault().getLanguage();
    }

    public static String[] b(Context context) {
        String packageName = context.getPackageName();
        String[] strArrB = b(context, packageName);
        if (strArrB == null || strArrB.length <= 0) {
            return null;
        }
        int length = strArrB.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = strArrB[i] + x.aQ + packageName;
            if (b.f3368a) {
                b.a("mcode" + strArr[i]);
            }
        }
        return strArr;
    }

    public static String a(Context context) {
        String packageName = context.getPackageName();
        return a(context, packageName) + x.aQ + packageName;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String[] b(Context context, String str) {
        String[] strArr;
        StringBuilder sb;
        int i;
        Signature[] apkContentsSigners;
        SigningInfo signingInfo;
        String[] strArr2 = null;
        try {
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            strArr = null;
        } catch (CertificateException e2) {
            e = e2;
            strArr = null;
        }
        if (Build.VERSION.SDK_INT >= 28 && (signingInfo = context.getPackageManager().getPackageInfo(str, 134217728).signingInfo) != null) {
            apkContentsSigners = signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
            if (apkContentsSigners != null) {
                strArr = null;
            }
            if (strArr != null) {
                strArr2 = new String[strArr.length];
                while (i < strArr.length) {
                }
            }
            return strArr2;
        }
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
        apkContentsSigners = packageInfo.signatures;
        if (apkContentsSigners != null || apkContentsSigners.length <= 0) {
            strArr = null;
        } else {
            strArr = new String[apkContentsSigners.length];
            for (int i2 = 0; i2 < apkContentsSigners.length; i2++) {
                try {
                    strArr[i2] = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(apkContentsSigners[i2].toByteArray())));
                } catch (PackageManager.NameNotFoundException e3) {
                    e = e3;
                    sb = new StringBuilder();
                    sb.append("getFingerPrint：");
                    sb.append(e.toString());
                    b.a(sb.toString());
                } catch (CertificateException e4) {
                    e = e4;
                    sb = new StringBuilder();
                    sb.append("getFingerPrint：");
                    sb.append(e.toString());
                    b.a(sb.toString());
                }
            }
        }
        if (strArr != null && strArr.length > 0) {
            strArr2 = new String[strArr.length];
            for (i = 0; i < strArr.length; i++) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i3 = 0; i3 < strArr[i].length(); i3++) {
                    stringBuffer.append(strArr[i].charAt(i3));
                    if (i3 > 0 && i3 % 2 == 1 && i3 < strArr[i].length() - 1) {
                        stringBuffer.append(":");
                    }
                }
                strArr2[i] = stringBuffer.toString();
            }
        }
        return strArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009a A[LOOP:0: B:23:0x009a->B:32:0x00ba, LOOP_START, PHI: r1
      0x009a: PHI (r1v1 int) = (r1v0 int), (r1v2 int) binds: [B:22:0x0098, B:32:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Context context, String str) {
        StringBuilder sb;
        String strA;
        Signature[] apkContentsSigners;
        SigningInfo signingInfo;
        try {
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            sb = new StringBuilder();
            sb.append("getFingerPrint：");
            sb.append(e.toString());
            b.a(sb.toString());
            strA = "";
        } catch (CertificateException e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("getFingerPrint：");
            sb.append(e.toString());
            b.a(sb.toString());
            strA = "";
        }
        if (Build.VERSION.SDK_INT >= 28 && (signingInfo = context.getPackageManager().getPackageInfo(str, 134217728).signingInfo) != null) {
            apkContentsSigners = signingInfo.hasMultipleSigners() ? context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.getApkContentsSigners() : context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.getSigningCertificateHistory();
            strA = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(apkContentsSigners[0].toByteArray())));
            StringBuffer stringBuffer = new StringBuffer();
            if (strA != null) {
            }
            return stringBuffer.toString();
        }
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
        apkContentsSigners = packageInfo.signatures;
        strA = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(apkContentsSigners[0].toByteArray())));
        StringBuffer stringBuffer2 = new StringBuffer();
        if (strA != null) {
            for (int i = 0; i < strA.length(); i++) {
                stringBuffer2.append(strA.charAt(i));
                if (i > 0 && i % 2 == 1 && i < strA.length() - 1) {
                    stringBuffer2.append(":");
                }
            }
        }
        return stringBuffer2.toString();
    }

    public static String a(X509Certificate x509Certificate) {
        try {
            return a.a(a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException e) {
            b.a("getFingerprintAs：" + e.toString());
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            b.a("generateSHA1：" + e.toString());
            return null;
        }
    }
}
