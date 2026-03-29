package com.wifi.ad.core.utils;

import android.text.TextUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class MD5Util {
    private static String toHex(byte[] bArr) {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(charArray[(bArr[i] >> 4) & 15]);
            sb.append(charArray[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static String toMD5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return toHex(MessageDigest.getInstance("MD5").digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
