package com.bytedance.sdk.component.n.nr.u.u;

import com.bytedance.sdk.component.n.u.pn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static String u = "com.bytedance.openadsdk";
    private static String nr = "content://" + u + ".TTMultiProvider";

    public static String u(pn pnVar) {
        if (pnVar.getContext() != null) {
            u = pnVar.getContext().getPackageName();
            nr = "content://" + u + ".TTMultiProvider";
        }
        return nr;
    }
}
