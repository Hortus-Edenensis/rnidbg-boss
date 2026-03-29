package com.bytedance.sdk.openadsdk.core.multipro;

import com.bytedance.sdk.openadsdk.core.dw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    public static String u = "com.bytedance.openadsdk";
    public static String nr = "content://" + u + ".TTMultiProvider";

    static {
        u();
    }

    public static void u() {
        if (dw.getContext() != null) {
            u = dw.getContext().getPackageName();
            nr = "content://" + u + ".TTMultiProvider";
        }
    }
}
