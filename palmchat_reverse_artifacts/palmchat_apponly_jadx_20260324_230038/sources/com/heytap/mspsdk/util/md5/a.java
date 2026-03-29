package com.heytap.mspsdk.util.md5;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    public static String a(String str) throws IOException {
        MessageDigest messageDigestB = b("MD5");
        messageDigestB.update(str.getBytes());
        return a(messageDigestB.digest());
    }

    public static MessageDigest b(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String a(byte[] bArr) {
        return String.format("%032x", new BigInteger(1, bArr));
    }
}
