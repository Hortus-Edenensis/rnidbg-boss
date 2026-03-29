package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class z {
    private static volatile String u;

    public static String u() {
        if (!TextUtils.isEmpty(u)) {
            return u;
        }
        String str = Build.MODEL;
        u = str;
        return str;
    }
}
