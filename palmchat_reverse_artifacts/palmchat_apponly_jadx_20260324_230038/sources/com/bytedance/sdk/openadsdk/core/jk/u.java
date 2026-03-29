package com.bytedance.sdk.openadsdk.core.jk;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends nr {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile u u;

    private u(Context context) {
        super(context, "ttopensdk2.db");
    }

    public static u u(Context context) {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u(context);
                }
            }
        }
        return u;
    }
}
