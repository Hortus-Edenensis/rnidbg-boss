package com.bytedance.sdk.openadsdk.core.component.reward.nr;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl;
import com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl;
import com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.widget.TopProxyLayout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.top.pn f5241a;
    private TextView b;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.u fx;
    private com.bytedance.sdk.openadsdk.core.nr.nr iz;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.b n;
    private bc nr;
    private UgenBanner pn;
    private final TTBaseVideoActivity u;
    private com.bytedance.sdk.openadsdk.core.component.reward.top.iz x;

    public pn(TTBaseVideoActivity tTBaseVideoActivity) {
        this.u = tTBaseVideoActivity;
    }

    private void n() {
        TopProxyLayout topProxyLayout = (TopProxyLayout) this.u.findViewById(2114387721);
        if (topProxyLayout != null) {
            u(topProxyLayout);
        }
        this.b = (TextView) this.u.findViewById(2114387801);
        this.pn = (UgenBanner) this.u.findViewById(2114387901);
    }

    public void b(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            uVar.setSoundMute(z);
        }
    }

    public void fx(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            uVar.setDislikeLeft(z);
        }
    }

    public void iz(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            uVar.setShowBack(z);
        }
    }

    public void nr(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            uVar.setShowDislike(z);
        }
    }

    public void pn(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            uVar.setShowSound(z);
        }
    }

    public void x(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            uVar.setShowAgain(z);
        }
    }

    public void u(bc bcVar, nr nrVar, boolean z, com.bytedance.sdk.openadsdk.core.nr.nr nrVar2) {
        this.nr = bcVar;
        this.iz = nrVar2;
        n();
        this.x = new com.bytedance.sdk.openadsdk.core.component.reward.top.iz(this.u, this.nr, nrVar, this, z);
        this.f5241a = new com.bytedance.sdk.openadsdk.core.component.reward.top.pn(this.u, this.nr, nrVar, this, z);
        this.n = new com.bytedance.sdk.openadsdk.core.component.reward.top.b(this.u, this.nr, nrVar, this, z);
        u(1);
    }

    public View b() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            return uVar.getCloseButton();
        }
        return null;
    }

    public void fx() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            uVar.fx();
        }
    }

    public void iz() {
        UgenBanner ugenBanner = this.pn;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.u(this.nr, this.iz);
    }

    public void nr() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            uVar.nr();
        }
    }

    public boolean pn() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            return uVar.getSkipOrCloseVisible();
        }
        return false;
    }

    public void x() {
        UgenBanner ugenBanner = this.pn;
        if (ugenBanner == null) {
            return;
        }
        ugenBanner.u();
    }

    public void nr(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
            this.b.setVisibility(0);
            this.b.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.pn.1
                @Override // java.lang.Runnable
                public void run() {
                    pn.this.b.setVisibility(8);
                }
            }, 3000L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.View, com.bytedance.sdk.openadsdk.core.component.reward.top.u] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.sdk.openadsdk.core.component.reward.nr.pn] */
    public void u(TopProxyLayout topProxyLayout) {
        ?? U;
        if (bg.t(this.nr)) {
            U = new RewardBrowserMixTopLayoutImpl(topProxyLayout.getContext()).u(this.nr);
        } else {
            U = new TopLayoutImpl(topProxyLayout.getContext()).u(this.nr);
        }
        if (U != 0) {
            this.fx = U;
        } else {
            k.nr("RewardFullTopProxyManager", "view not implements ITopLayout interface");
        }
        ViewParent parent = topProxyLayout.getParent();
        if (parent instanceof ViewGroup) {
            u(topProxyLayout, U, (ViewGroup) parent);
        }
    }

    private void u(TopProxyLayout topProxyLayout, View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(topProxyLayout);
        viewGroup.removeViewInLayout(topProxyLayout);
        ViewGroup.LayoutParams layoutParams = topProxyLayout.getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    public void u(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            uVar.setVisible(z);
        }
    }

    public void u(boolean z, String str, String str2, boolean z2, boolean z3) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            uVar.u(z, str, str2, z2, z3);
        }
    }

    public void u(String str, String str2, boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            uVar.u(str, str2, z);
        }
    }

    public void u() {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            uVar.u();
        }
    }

    public void u(int i) {
        if (i == 2) {
            u(this.n);
        } else if (i != 4) {
            u(this.x);
        } else {
            u(this.f5241a);
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.component.reward.top.nr nrVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            uVar.setListener(nrVar);
        }
    }

    public void u(String str) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.u uVar = this.fx;
        if (uVar != null) {
            uVar.setPlayAgainEntranceText(str);
        }
    }

    public void u(bc bcVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.top.iz izVar = this.x;
        if (izVar != null) {
            izVar.u(bcVar);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.top.b bVar = this.n;
        if (bVar != null) {
            bVar.u(bcVar);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.top.pn pnVar = this.f5241a;
        if (pnVar != null) {
            pnVar.u(bcVar);
        }
    }
}
