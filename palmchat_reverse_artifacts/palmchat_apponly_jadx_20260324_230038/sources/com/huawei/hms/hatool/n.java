package com.huawei.hms.hatool;

import android.util.Pair;
import defpackage.g8;
import defpackage.k8;
import defpackage.oh2;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f6779a = Charset.forName("UTF-8");

    public static Pair<byte[], String> a(String str, int i) {
        if (str == null || str.length() < i) {
            return new Pair<>(new byte[0], str);
        }
        String strSubstring = str.substring(0, i);
        return new Pair<>(oh2.b(strSubstring), str.substring(i));
    }

    public static String b(String str, String str2) {
        return oh2.a(g8.l(str.getBytes(f6779a), oh2.b(str2)));
    }

    public static String a(String str, String str2) {
        Pair<byte[], String> pairA = a(str, 32);
        return new String(g8.i(oh2.b((String) pairA.second), oh2.b(str2), (byte[]) pairA.first), f6779a);
    }

    public static String a(byte[] bArr, String str) {
        String str2;
        if (bArr == null || bArr.length == 0 || str == null) {
            str2 = "cbc encrypt(byte) param is not right";
        } else {
            byte[] bArrB = oh2.b(str);
            if (bArrB.length >= 16) {
                return oh2.a(k8.b(bArr, bArrB));
            }
            str2 = "key length is not right";
        }
        v.b("AesCipher", str2);
        return "";
    }
}
