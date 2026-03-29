package com.bytedance.sdk.openadsdk.api;

import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    public static boolean u() {
        if (Build.VERSION.SDK_INT >= 24) {
            return false;
        }
        iz.fx("csj sdk only support android os >= android 7.0（API-24）");
        return true;
    }
}
