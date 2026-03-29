package com.bytedance.sdk.component.x.fx.u;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    public static String u = "com.bytedance.openadsdk";
    public static String nr = "content://" + u + ".TTMultiProvider";

    static {
        u();
    }

    public static void u() {
        Context context = nr.getContext();
        if (context != null) {
            u = context.getPackageName();
            nr = "content://" + u + ".TTMultiProvider";
        }
    }
}
