package com.huawei.hms.ads.uiengineloader;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6618a = "Sha256Util";

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance(com.huawei.openalliance.ad.constant.x.dW).digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            af.d(f6618a, "sha256 NoSuchAlgorithmException");
            return new byte[0];
        }
    }
}
