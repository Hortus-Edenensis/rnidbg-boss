package com.bytedance.sdk.openadsdk.core.multipro;

import com.bytedance.sdk.openadsdk.core.y.bf;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static boolean nr;
    public static boolean u;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        static final com.bytedance.sdk.component.b.nr.fx u = bf.u("sp_multi_info");
    }

    public static boolean fx() {
        if (!nr) {
            u = u.u.get("is_support_multi_process", false);
            nr = true;
        }
        return u;
    }

    public static void nr() {
        if (nr) {
            u.u.put("is_support_multi_process", false);
        }
        u = false;
    }

    public static void u() {
        if (!nr) {
            u.u.put("is_support_multi_process", true);
        }
        u = true;
        nr = true;
    }
}
