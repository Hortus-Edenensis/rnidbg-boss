package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.wq;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.pb;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class z implements SSWebView.nr {
    private ja fx;
    private bc nr;
    private SSWebView u;

    public z(SSWebView sSWebView, ja jaVar, bc bcVar) {
        this.u = sSWebView;
        this.nr = bcVar;
        this.fx = jaVar;
    }

    private boolean u() {
        SSWebView sSWebView = this.u;
        if (sSWebView == null) {
            return false;
        }
        return wq.nr(sSWebView, 50, jp.jk(this.nr));
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView.nr
    public void u(final int i) {
        if (u()) {
            if (com.bytedance.sdk.openadsdk.core.dw.nr().k()) {
                SSWebView sSWebView = this.u;
                if (sSWebView != null) {
                    pb.u((WeakReference<ViewGroup>) new WeakReference((ViewGroup) sSWebView.getParent()), new com.bytedance.sdk.openadsdk.core.nr.fx() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.z.1
                        @Override // com.bytedance.sdk.openadsdk.core.nr.fx
                        public void u() {
                            if (z.this.fx != null) {
                                z.this.fx.u(i);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            ja jaVar = this.fx;
            if (jaVar != null) {
                jaVar.u(i);
            }
        }
    }
}
