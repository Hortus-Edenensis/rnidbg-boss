package com.bytedance.sdk.openadsdk.core.jk;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends nr {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile fx u;

    private fx(Context context) {
        super(context, "ttopensdk.db");
    }

    public static fx u(Context context) {
        if (u == null) {
            synchronized (fx.class) {
                if (u == null) {
                    u = new fx(context);
                }
            }
        }
        return u;
    }
}
