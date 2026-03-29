package com.baidu.platform.comapi.util;

import android.graphics.Color;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class d {
    public static int[] a(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return null;
        }
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = Color.argb(Color.alpha(iArr[i]), Color.blue(iArr[i]), Color.green(iArr[i]), Color.red(iArr[i]));
        }
        return iArr2;
    }
}
