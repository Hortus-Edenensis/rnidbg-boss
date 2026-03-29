package com.opos.cmn.an.b;

import android.util.Base64;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static String a(String str) {
        return !com.opos.cmn.an.d.b.a(str) ? b(str.getBytes()) : "";
    }

    public static String b(byte[] bArr) {
        return bArr != null ? new String(Base64.decode(bArr, 2)) : "";
    }

    public static byte[] c(byte[] bArr) {
        if (bArr != null) {
            return Base64.encode(bArr, 2);
        }
        return null;
    }

    public static byte[] d(byte[] bArr) {
        if (bArr != null) {
            return Base64.decode(bArr, 2);
        }
        return null;
    }

    public static String a(byte[] bArr) {
        return bArr != null ? Base64.encodeToString(bArr, 2) : "";
    }
}
