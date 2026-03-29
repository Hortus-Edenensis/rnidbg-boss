package com.tencent.turingfd.sdk.ams.ad;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Norma {
    public static String a(byte[] bArr) {
        byte[] bArrDigest;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            bArrDigest = messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            bArrDigest = null;
        }
        return Damson.a(bArrDigest);
    }
}
