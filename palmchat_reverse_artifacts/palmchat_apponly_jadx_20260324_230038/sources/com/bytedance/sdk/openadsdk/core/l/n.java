package com.bytedance.sdk.openadsdk.core.l;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {
    public static com.bytedance.sdk.openadsdk.core.l.nr.b nr(Context context, bc bcVar, String str, boolean z) {
        return jp.nr(context) ? new com.bytedance.sdk.openadsdk.core.l.fx.b(context, bcVar, str, z) : new com.bytedance.sdk.openadsdk.core.l.fx.u(context, bcVar, str, z);
    }

    public static com.bytedance.sdk.openadsdk.core.l.nr.fx u(Context context, bc bcVar, String str, boolean z) {
        return new com.bytedance.sdk.openadsdk.core.l.fx.x(context, bcVar, str, z);
    }

    public static com.bytedance.sdk.openadsdk.core.l.nr.fx u(Context context, String str, bc bcVar, String str2) {
        return new com.bytedance.sdk.openadsdk.core.l.fx.a(context, str, bcVar, str2, jp.kj(bcVar));
    }
}
