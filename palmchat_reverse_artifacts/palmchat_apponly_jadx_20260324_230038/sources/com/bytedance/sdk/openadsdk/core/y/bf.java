package com.bytedance.sdk.openadsdk.core.y;

import android.annotation.SuppressLint;
import com.bytedance.sdk.component.x.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class bf {
    private static volatile boolean u = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        @SuppressLint({"StaticFieldLeak"})
        static final b.u u = bf.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b.u b() {
        com.bytedance.sdk.openadsdk.core.pb.t tVarNr = com.bytedance.sdk.openadsdk.core.dw.nr();
        tVarNr.bj();
        return new b.u().u(com.bytedance.sdk.openadsdk.core.dw.getContext()).u(1).nr(tVarNr.ir()).u(u);
    }

    public static int nr() {
        return 3;
    }

    public static com.bytedance.sdk.component.b.nr.fx u(String str) {
        return u.u.u(nr(str)).u();
    }

    private static String nr(String str) {
        if (u || com.bytedance.sdk.component.utils.bq.u(com.bytedance.sdk.openadsdk.core.dw.getContext())) {
            return str;
        }
        return str + com.bytedance.sdk.component.utils.bq.nr(com.bytedance.sdk.openadsdk.core.dw.getContext());
    }

    public static void u() {
        u = true;
    }
}
