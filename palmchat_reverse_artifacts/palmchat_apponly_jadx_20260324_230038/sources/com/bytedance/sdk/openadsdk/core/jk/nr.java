package com.bytedance.sdk.openadsdk.core.jk;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr {
    private Context nr;
    private b u;

    public nr(Context context, String str) {
        try {
            this.nr = context == null ? dw.getContext() : context.getApplicationContext();
            if (this.u == null) {
                this.u = new b(this.nr, str);
            }
        } catch (Throwable unused) {
        }
    }

    public b u() {
        return this.u;
    }

    public static boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.hashCode();
        switch (str) {
        }
        return false;
    }
}
