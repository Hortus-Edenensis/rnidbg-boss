package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.nr.s;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.bg.u;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.multipro.nr.u;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.t;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FullRewardExpressView f5237a;
    private bc iz;
    private ViewGroup n;
    private final TTBaseVideoActivity pn;
    com.bytedance.sdk.openadsdk.core.l.nr.fx u;
    private String x;
    boolean nr = false;
    boolean fx = false;
    boolean b = false;

    public pn(TTBaseVideoActivity tTBaseVideoActivity) {
        this.pn = tTBaseVideoActivity;
    }

    public int a() {
        FullRewardExpressView fullRewardExpressView = this.f5237a;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getDynamicShowType();
        }
        return 0;
    }

    public void b() {
        FullRewardExpressView fullRewardExpressView = this.f5237a;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.mv();
        }
    }

    public boolean fx() {
        return this.fx;
    }

    public boolean iz() {
        FullRewardExpressView fullRewardExpressView = this.f5237a;
        return (fullRewardExpressView == null || fullRewardExpressView.dw()) ? false : true;
    }

    public boolean jk() {
        FullRewardExpressView fullRewardExpressView = this.f5237a;
        if (fullRewardExpressView == null) {
            return true;
        }
        return fullRewardExpressView.s();
    }

    public FullRewardExpressView l() {
        return this.f5237a;
    }

    public void mv() {
        FullRewardExpressView fullRewardExpressView = this.f5237a;
        if (fullRewardExpressView != null && fullRewardExpressView.getJsObject() != null) {
            this.f5237a.getJsObject().x(true);
        }
        u("isVerifyReward", (JSONObject) null);
    }

    public void n() {
        FullRewardExpressView fullRewardExpressView = this.f5237a;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.o();
            this.f5237a.sx();
        }
    }

    public boolean nr() {
        return this.nr;
    }

    public void pn() {
        FullRewardExpressView fullRewardExpressView = this.f5237a;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.sx();
        }
    }

    public s t() {
        FullRewardExpressView fullRewardExpressView = this.f5237a;
        if (fullRewardExpressView == null) {
            return null;
        }
        return fullRewardExpressView.getRenderResult();
    }

    public void x() {
        FullRewardExpressView fullRewardExpressView = this.f5237a;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.my();
    }

    public void fx(boolean z) {
        ViewGroup viewGroup = this.n;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    public void nr(boolean z) {
        this.fx = z;
    }

    public void u(bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, String str, boolean z, String str2) {
        if (this.b) {
            return;
        }
        this.b = true;
        this.iz = bcVar;
        this.x = str;
        this.f5237a = new FullRewardExpressView(this.pn, bcVar, nrVar, str, z, str2);
        FrameLayout expressFrameContainer = this.pn.bf().getExpressFrameContainer();
        this.n = expressFrameContainer;
        expressFrameContainer.addView(this.f5237a, new FrameLayout.LayoutParams(-2, -2));
        this.f5237a.setEasyPlayableContainer(this.pn.bf().getEasyPlayableContainer());
    }

    public void u(CharSequence charSequence, int i, int i2, boolean z) {
        if (this.f5237a == null || !iz()) {
            return;
        }
        this.f5237a.u(charSequence, i, i2, z);
    }

    public FrameLayout u() {
        FullRewardExpressView fullRewardExpressView = this.f5237a;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getVideoFrameLayout();
        }
        return null;
    }

    public void u(boolean z) {
        this.nr = z;
    }

    public void u(com.bytedance.sdk.openadsdk.core.nativeexpress.iz izVar, com.bytedance.sdk.openadsdk.core.nativeexpress.pn pnVar) {
        bc bcVar;
        if (this.f5237a == null || (bcVar = this.iz) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarU = u(bcVar);
        this.u = fxVarU;
        if (fxVarU != null) {
            fxVarU.u();
            if (this.f5237a.getContext() != null && (this.f5237a.getContext() instanceof Activity)) {
                this.u.u((Activity) this.f5237a.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.core.s.b.u(this.iz);
        EmptyView emptyViewU = u((ViewGroup) this.f5237a);
        if (emptyViewU == null) {
            bc bcVar2 = this.iz;
            EmptyView emptyView = new EmptyView(this.pn, this.f5237a, bcVar2 != null ? bcVar2.re() : 1000);
            emptyView.u(this.iz, this.x);
            this.f5237a.addView(emptyView);
            emptyViewU = emptyView;
        }
        emptyViewU.setNeedCheckingShow(false);
        emptyViewU.setCallback(new EmptyView.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.pn.1
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void nr() {
                com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = pn.this.u;
                if (fxVar != null) {
                    fxVar.nr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u(View view, Map<String, Object> map) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u(boolean z) {
                com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = pn.this.u;
                if (fxVar == null || !z) {
                    return;
                }
                fxVar.u();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u() {
                com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = pn.this.u;
                if (fxVar != null) {
                    fxVar.u(false);
                }
            }
        });
        izVar.u(this.f5237a);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) izVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.u);
        this.f5237a.setClickListener(izVar);
        pnVar.u(this.f5237a);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) pnVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.u);
        this.f5237a.setClickCreativeListener(pnVar);
        emptyViewU.setNeedCheckingShow(false);
        u(this.u, this.f5237a);
    }

    private void u(com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar, NativeExpressView nativeExpressView) {
        if (fxVar == null || nativeExpressView == null) {
            return;
        }
        bc bcVar = this.iz;
        final String strLk = bcVar != null ? bcVar.lk() : "";
        fxVar.u(new com.bytedance.sdk.openadsdk.core.l.nr.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.pn.2
            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void fx(long j, long j2, String str, String str2) {
                pn.this.pn.u("下载失败");
                if (j > 0) {
                    u.C0239u.u(strLk, 4, (int) ((j2 * 100) / j));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void nr(long j, long j2, String str, String str2) {
                pn.this.pn.u("下载暂停");
                if (j > 0) {
                    u.C0239u.u(strLk, 2, (int) ((j2 * 100) / j));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u() {
                pn.this.pn.u("点击开始下载");
                u.C0239u.u(strLk, 1, 0);
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(long j, long j2, String str, String str2) {
                if (j > 0) {
                    int i = (int) ((j2 * 100) / j);
                    pn.this.pn.u("已下载" + i + "%");
                    u.C0239u.u(strLk, 3, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(long j, String str, String str2) {
                pn.this.pn.u("点击安装");
                u.C0239u.u(strLk, 5, 100);
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(String str, String str2) {
                pn.this.pn.u("点击打开");
                u.C0239u.u(strLk, 6, 100);
            }
        });
    }

    private com.bytedance.sdk.openadsdk.core.l.nr.fx u(bc bcVar) {
        if (bcVar.qf() == 4) {
            return com.bytedance.sdk.openadsdk.core.l.n.u((Context) this.pn, bcVar, this.x, false);
        }
        return null;
    }

    private EmptyView u(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void u(t tVar) {
        FullRewardExpressView fullRewardExpressView = this.f5237a;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressVideoListenerProxy(tVar);
    }

    public void u(com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar) {
        FullRewardExpressView fullRewardExpressView = this.f5237a;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressInteractionListener(uVar);
    }

    public void u(com.bykv.vk.openvk.component.video.api.b.fx fxVar) {
        FullRewardExpressView fullRewardExpressView = this.f5237a;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.setVideoController(fxVar);
        }
    }

    public void u(String str, JSONObject jSONObject) {
        ja jsObject;
        FullRewardExpressView fullRewardExpressView = this.f5237a;
        if (fullRewardExpressView == null || (jsObject = fullRewardExpressView.getJsObject()) == null || this.pn.isFinishing()) {
            return;
        }
        jsObject.nr(str, jSONObject);
    }

    public void u(u.InterfaceC0273u interfaceC0273u) {
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.u(interfaceC0273u);
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.component.reward.pn.fx fxVar) {
        if (this.f5237a != null) {
            this.f5237a.u((int) (fxVar.u() / 1000), fxVar.pn(), fxVar.nr(), fxVar.b());
        }
    }
}
