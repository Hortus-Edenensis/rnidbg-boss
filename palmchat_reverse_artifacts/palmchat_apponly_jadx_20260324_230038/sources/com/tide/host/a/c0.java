package com.tide.host.a;

import android.text.TextUtils;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class c0 {
    public static boolean a(String str, String str2) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        byte[] bArr;
        String string;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        Object string2 = "";
        try {
            fileInputStream = new FileInputStream(str);
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                bArr = new byte[1024];
            } catch (Throwable th) {
                th = th;
            }
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i);
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
            string = new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        try {
            StringBuilder sb = new StringBuilder(string);
            while (sb.length() < 32) {
                sb.insert(0, "0");
            }
            string2 = sb.toString();
            fileInputStream.close();
            return str2.equals(string2);
        } catch (Throwable th4) {
            string2 = string;
            th = th4;
            fileInputStream.close();
            throw th;
        }
    }
}
