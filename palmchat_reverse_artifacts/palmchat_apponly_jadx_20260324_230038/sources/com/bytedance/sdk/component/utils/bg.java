package com.bytedance.sdk.component.utils;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class bg {
    private static void nr(String str) {
        throw new IllegalArgumentException(str);
    }

    public static void u(Object obj, String str) {
        if (obj == null) {
            nr(str);
        }
    }

    public static void u(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            nr(str2);
        }
    }

    public static void u(boolean z, String str) {
        if (z) {
            return;
        }
        nr(str);
    }

    public static void u(String str) {
        nr(str);
    }
}
