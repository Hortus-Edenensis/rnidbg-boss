package com.bytedance.sdk.component.t.n;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt < 'A' || cCharAt > 'Z') {
                    sb.append(cCharAt);
                } else {
                    if (sb.length() > 0) {
                        sb.append('_');
                    }
                    sb.append((char) (cCharAt + ' '));
                }
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String u(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (z) {
            str = str.substring(1);
        }
        return u(str);
    }
}
