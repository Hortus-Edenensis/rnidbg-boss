package com.zm.fda.O52OZ;

import android.os.Build;
import java.util.Random;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class O2O5Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Random f16625a = new Random();

    public static String a(Object obj) {
        return obj == null ? "" : String.valueOf(obj);
    }

    public static long b() {
        return (System.currentTimeMillis() * 1000) + ((long) f16625a.nextInt(1000));
    }

    public static String c() {
        String str = Build.MANUFACTURER;
        return (str == null || str.length() <= 0) ? "unknown" : str.toLowerCase();
    }

    public static boolean d() {
        String strC = c();
        return strC.contains("oce") || strC.contains("huawei") || strC.contains("honor");
    }

    public static String a() {
        return UUID.randomUUID().toString() + (System.currentTimeMillis() / 1000);
    }

    public static byte[] a(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return new byte[0];
        }
        if (bArr.length <= 1) {
            return bArr;
        }
        int length = bArr.length - 1;
        while (i < bArr.length / 2) {
            byte b = bArr[i];
            bArr[i] = bArr[length];
            bArr[length] = b;
            i++;
            length--;
        }
        return bArr;
    }
}
