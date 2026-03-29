package com.bytedance.sdk.openadsdk.core.l.fx;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.multipro.nr.u;
import com.bytedance.sdk.openadsdk.core.pb;
import com.bytedance.sdk.openadsdk.core.y.jp;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fx implements com.bytedance.sdk.openadsdk.core.l.nr.fx {
    protected WeakReference<u.InterfaceC0273u> nr;
    protected boolean u = true;

    private String iz() {
        u.InterfaceC0273u interfaceC0273u;
        com.bytedance.sdk.openadsdk.core.multipro.nr.u uVarR_;
        WeakReference<u.InterfaceC0273u> weakReference = this.nr;
        if (weakReference == null || (interfaceC0273u = weakReference.get()) == null || (uVarR_ = interfaceC0273u.r_()) == null) {
            return null;
        }
        return uVarR_.u().toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void nr(boolean z) {
        this.u = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(u.InterfaceC0273u interfaceC0273u) {
        this.nr = new WeakReference<>(interfaceC0273u);
    }

    public int x() {
        return hashCode();
    }

    public boolean u(Context context, bc bcVar, String str) {
        if (!this.u || !com.bytedance.sdk.openadsdk.core.y.iz.u(bcVar) || !pb.u(context, bcVar, jp.nr(str), str, iz())) {
            return false;
        }
        TTNativePageActivity.u(this);
        return true;
    }
}
