package com.bytedance.sdk.openadsdk.core.m;

import java.security.MessageDigest;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    public static String u(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return jk.u(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }
}
