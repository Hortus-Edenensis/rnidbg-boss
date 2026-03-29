package com.xiaomi.push;

import android.content.Context;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f11398a = "0123456789ABCDEF".toCharArray();

    public static boolean a(Context context) {
        return aa.f11397a;
    }

    public static String a(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2 * 2);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i + i3] & UByte.MAX_VALUE;
            char[] cArr = f11398a;
            sb.append(cArr[i4 >> 4]);
            sb.append(cArr[i4 & 15]);
        }
        return sb.toString();
    }
}
