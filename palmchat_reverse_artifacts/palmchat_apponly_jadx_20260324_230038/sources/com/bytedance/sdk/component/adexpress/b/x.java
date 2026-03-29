package com.bytedance.sdk.component.adexpress.b;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x {
    public static boolean nr(String str) {
        return com.bytedance.sdk.component.adexpress.b.u() && u(str);
    }

    public static boolean u(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }
}
