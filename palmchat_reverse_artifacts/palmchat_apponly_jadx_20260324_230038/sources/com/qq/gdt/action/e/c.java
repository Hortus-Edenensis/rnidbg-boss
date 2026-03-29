package com.qq.gdt.action.e;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
final class c {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strA = f.a(str.toLowerCase(), "UTF-8");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return strA.toLowerCase();
    }
}
