package com.bytedance.sdk.openadsdk.my.u.u;

import android.util.SparseArray;
import defpackage.wc7;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class k {
    public static Function<SparseArray<Object>, Object> u(Object obj) {
        return obj instanceof Function ? (Function) obj : wc7.e;
    }

    public static Integer[] u(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }
}
