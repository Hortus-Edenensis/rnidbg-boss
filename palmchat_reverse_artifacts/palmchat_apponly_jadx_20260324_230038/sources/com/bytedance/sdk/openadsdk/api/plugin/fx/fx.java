package com.bytedance.sdk.openadsdk.api.plugin.fx;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    public static boolean fx() {
        iz.fx("isOA8A: false");
        return false;
    }

    public static boolean nr() {
        return fx() && !u();
    }

    public static boolean u() {
        String[] strArr = Build.SUPPORTED_ABIS;
        StringBuilder sb = new StringBuilder("abi-support: ");
        sb.append(strArr == null ? com.igexin.push.core.b.m : strArr.toString());
        iz.u(sb.toString());
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("arm64-v8a")) {
                return true;
            }
        }
        return false;
    }
}
