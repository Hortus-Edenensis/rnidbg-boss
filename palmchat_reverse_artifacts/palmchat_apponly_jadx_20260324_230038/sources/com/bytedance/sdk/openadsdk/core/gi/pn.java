package com.bytedance.sdk.openadsdk.core.gi;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.sdk.component.a.u;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.gi.u;
import com.bytedance.sdk.openadsdk.core.kj.bf;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile pn u;
    private final com.bytedance.sdk.component.a.u b;
    private com.bytedance.sdk.openadsdk.mv.u.u fx;
    private Context nr;

    private pn(Context context) {
        this.nr = context == null ? dw.getContext() : context.getApplicationContext();
        u.C0203u c0203u = new u.C0203u();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        com.bytedance.sdk.component.a.u uVarU = c0203u.u(10000L, timeUnit).nr(10000L, timeUnit).fx(10000L, timeUnit).u(new u.C0260u()).u(bf.u()).u(bf.nr()).u(true).u();
        this.b = uVarU;
        com.bytedance.sdk.component.nr.u.b bVarU = uVarU.iz().u();
        if (bVarU != null) {
            bVarU.u(32);
            bVarU.nr(com.bytedance.sdk.openadsdk.core.fx.fx.u().pn());
        }
    }

    private void b() {
        if (this.fx == null) {
            this.fx = new com.bytedance.sdk.openadsdk.mv.u.u();
        }
    }

    public static pn u() {
        if (u == null) {
            synchronized (pn.class) {
                if (u == null) {
                    com.bytedance.sdk.component.nr.u.u.u.u().u(com.bytedance.sdk.openadsdk.core.fx.fx.u().iz() != 2);
                    u = new pn(dw.getContext());
                }
            }
        }
        return u;
    }

    public com.bytedance.sdk.openadsdk.mv.u.u fx() {
        b();
        return this.fx;
    }

    public com.bytedance.sdk.component.a.u nr() {
        return this.b;
    }
}
