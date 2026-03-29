package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.z;
import com.bytedance.sdk.openadsdk.core.y.xg;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends nr {
    private PlayableFeedWebView b;
    private final iz iz;
    private final com.bytedance.sdk.openadsdk.core.z.u pn;

    public pn(bc bcVar, boolean z, u uVar) {
        super(bcVar, uVar);
        this.iz = new iz() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.pn.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void b() {
                if (z.u() && pn.this.pn != null) {
                    pn.this.pn.u(pn.this.u);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void fx() {
                pn.this.b.n();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void nr() {
                if (pn.this.b != null) {
                    pn.this.b.x();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void u() {
                if (pn.this.b != null) {
                    pn.this.b.iz();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void u(boolean z2) {
                if (pn.this.b != null) {
                    pn.this.b.u(z2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void pn() {
            }
        };
        this.pn = new com.bytedance.sdk.openadsdk.core.z.u(bcVar);
        this.fx = z;
    }

    public void b() {
        PlayableFeedWebView playableFeedWebView = this.b;
        if (playableFeedWebView != null) {
            playableFeedWebView.destroy();
        }
    }

    public boolean fx() {
        return z.nr(this.u);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.nr
    public int u() {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.nr
    public iz nr() {
        return this.iz;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.nr
    public boolean u(int i, int i2) {
        return true;
    }

    public void u(final ViewGroup viewGroup, final View view, final boolean z) {
        a.u(this.u, true, u(), 0);
        PlayableFeedWebView playableFeedWebView = new PlayableFeedWebView(this.pn, viewGroup);
        this.b = playableFeedWebView;
        this.pn.u(playableFeedWebView);
        this.b.setMaterialMeta(xg.u(this.u));
        this.b.setEasyPlayableListener(this.nr);
        viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.pn.2
            @Override // java.lang.Runnable
            public void run() {
                pn pnVar = pn.this;
                a.u(pnVar.u, true, pnVar.u(), (Map<String, Object>) null);
                pn pnVar2 = pn.this;
                pnVar2.u(viewGroup, view, pnVar2.b, z, true, null, null);
            }
        });
    }

    public void u(com.bytedance.sdk.openadsdk.qq.u.nr.u.nr nrVar) {
        this.pn.u(nrVar);
    }
}
