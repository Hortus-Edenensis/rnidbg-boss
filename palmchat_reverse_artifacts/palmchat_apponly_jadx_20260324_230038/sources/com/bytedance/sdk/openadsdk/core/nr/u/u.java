package com.bytedance.sdk.openadsdk.core.nr.u;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u {
    protected View b;
    protected jk fx;
    protected Context nr;
    protected bc u;

    public abstract int u(Map<String, Object> map, fx fxVar);

    public void u(jk jkVar) {
        this.fx = jkVar;
    }

    public void u(View view) {
        this.b = view;
    }
}
