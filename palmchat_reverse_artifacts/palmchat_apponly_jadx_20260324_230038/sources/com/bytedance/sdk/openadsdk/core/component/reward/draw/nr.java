package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.pn.u;
import com.bytedance.sdk.openadsdk.core.bg.u;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.kj.wi;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.l.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.iz;
import com.bytedance.sdk.openadsdk.core.nativeexpress.kj;
import com.bytedance.sdk.openadsdk.core.video.nr.u;
import com.bytedance.sdk.openadsdk.core.y.h;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.xg;
import com.bytedance.sdk.openadsdk.core.y.y;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.nr.u f5229a;
    public boolean b;
    protected final String fx;
    private int iz;
    private com.bytedance.sdk.openadsdk.core.l.nr.fx jk;
    private final boolean k;
    private boolean l;
    private long mv;
    private boolean my;
    private com.bytedance.sdk.openadsdk.core.nativeexpress.pn n;
    protected final bc nr;
    private FullRewardExpressView o;
    private ViewGroup t;
    protected final TTBaseVideoActivity u;
    private iz x;
    private final AtomicBoolean s = new AtomicBoolean(false);
    boolean pn = false;

    public nr(final TTBaseVideoActivity tTBaseVideoActivity, bc bcVar, String str, boolean z, boolean z2) {
        this.jk = null;
        this.u = tTBaseVideoActivity;
        this.nr = bcVar;
        this.fx = str;
        this.k = z;
        this.my = z2;
        iz izVar = new iz(tTBaseVideoActivity, bcVar, str, jp.nr(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.nr.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.iz, com.bytedance.sdk.openadsdk.core.nr.nr, com.bytedance.sdk.openadsdk.core.nr.b
            public void u(View view, jk jkVar) {
                super.u(view, jkVar);
                tTBaseVideoActivity.u(2);
            }
        };
        this.x = izVar;
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) izVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(tTBaseVideoActivity.u(bcVar));
        com.bytedance.sdk.openadsdk.core.nativeexpress.pn pnVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.pn(tTBaseVideoActivity, bcVar, str, jp.nr(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.nr.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.pn, com.bytedance.sdk.openadsdk.core.nr.nr, com.bytedance.sdk.openadsdk.core.nr.b
            public void u(View view, jk jkVar) {
                super.u(view, jkVar);
                com.bytedance.sdk.openadsdk.core.nr.u.nr nrVar = (com.bytedance.sdk.openadsdk.core.nr.u.nr) this.n.u(com.bytedance.sdk.openadsdk.core.nr.u.nr.class);
                if (nrVar == null || !nrVar.nr(view)) {
                    return;
                }
                tTBaseVideoActivity.u(2);
            }
        };
        this.n = pnVar;
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) pnVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(tTBaseVideoActivity.u(bcVar));
        com.bytedance.sdk.openadsdk.core.nr.u uVar = new com.bytedance.sdk.openadsdk.core.nr.u(tTBaseVideoActivity, bcVar, str, 7);
        this.f5229a = uVar;
        tTBaseVideoActivity.u((com.bytedance.sdk.openadsdk.core.nr.u.fx.fx) uVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class));
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) this.f5229a.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(tTBaseVideoActivity.u(bcVar));
        if (bcVar.qf() == 4) {
            this.jk = n.u((Context) tTBaseVideoActivity, bcVar, str, false);
            final String strLk = u().lk();
            this.jk.u(new com.bytedance.sdk.openadsdk.core.l.nr.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.nr.3
                @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                public void fx(long j, long j2, String str2, String str3) {
                    if (j > 0) {
                        u.C0239u.u(strLk, 4, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                public void nr(long j, long j2, String str2, String str3) {
                    if (j > 0) {
                        u.C0239u.u(strLk, 2, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                public void u() {
                    u.C0239u.u(strLk, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                public void u(long j, long j2, String str2, String str3) {
                    if (j > 0) {
                        u.C0239u.u(strLk, 3, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                public void u(long j, String str2, String str3) {
                    u.C0239u.u(strLk, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
                public void u(String str2, String str3) {
                    u.C0239u.u(strLk, 6, 100);
                }
            });
        }
    }

    public void a() {
        if (this.k) {
            this.u.u(this.nr, this.f5229a);
        }
    }

    public int b() {
        if (!wi.jk(this.nr)) {
            return 1;
        }
        if (this.l) {
            int iNr = wi.nr(this.nr) - this.iz;
            this.iz = wi.nr(this.nr);
            return iNr;
        }
        if (this.iz >= wi.nr(this.nr)) {
            return 0;
        }
        this.iz++;
        return 1;
    }

    public com.bytedance.sdk.openadsdk.core.nr.u fx() {
        return this.f5229a;
    }

    public boolean iz() {
        return this.b;
    }

    public com.bykv.vk.openvk.component.video.api.fx.iz jk() {
        com.bykv.vk.openvk.component.video.api.fx.iz izVarU = zx.u(1, this.nr);
        izVarU.nr(this.nr.lk());
        izVarU.nr(100);
        izVarU.fx(100);
        izVarU.fx(this.nr.ap());
        izVarU.nr(this.b);
        return izVarU;
    }

    public void l() {
        if (this.my) {
            return;
        }
        this.my = true;
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVarU = h.u(7);
        if (zx.k(this.nr) != null) {
            com.bykv.vk.openvk.component.video.api.fx.iz izVarU = zx.u(1, this.nr);
            izVarU.u("material_meta", this.nr);
            izVarU.u("ad_slot", Integer.valueOf(nrVarU != null ? nrVarU.bq() : 0));
            com.bytedance.sdk.openadsdk.core.video.b.nr.u(izVarU, new u.InterfaceC0155u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.nr.5
                @Override // com.bykv.vk.openvk.component.video.api.pn.u.InterfaceC0155u
                public void u(com.bykv.vk.openvk.component.video.api.fx.iz izVar, int i) {
                    izVar.my();
                    izVar.iz();
                }

                @Override // com.bykv.vk.openvk.component.video.api.pn.u.InterfaceC0155u
                public void u(com.bykv.vk.openvk.component.video.api.fx.iz izVar, int i, String str) {
                    izVar.my();
                    izVar.iz();
                }

                @Override // com.bykv.vk.openvk.component.video.api.pn.u.InterfaceC0155u
                public void nr(com.bykv.vk.openvk.component.video.api.fx.iz izVar, int i) {
                }
            });
        }
    }

    public void n() {
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.jk;
        if (fxVar != null) {
            fxVar.nr();
        }
        FullRewardExpressView fullRewardExpressView = this.o;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.mv();
        }
        bc bcVar = this.nr;
        xg.nr(bcVar != null ? bcVar.n() : 0);
    }

    public String nr() {
        return this.fx;
    }

    public u.InterfaceC0302u pn() {
        return new u.InterfaceC0302u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.nr.4
            @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
            public void nr() {
                nr.this.x();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
            public void u() {
                nr.this.l = true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
            public void u(int i, String str) {
                nr.this.x();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
            public void u(long j, long j2) {
                y.u((View) nr.this.t, 8);
                nr.this.mv = j;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
            public void fx() {
            }
        };
    }

    public long t() {
        return this.mv;
    }

    public void x() {
        y.u((View) this.t, 0);
        this.u.mv();
    }

    public void nr(boolean z) {
        this.nr.l(z);
    }

    public FullRewardExpressView nr(float f, float f2) {
        if (this.o == null) {
            u(f, f2);
        }
        return this.o;
    }

    public bc u() {
        return this.nr;
    }

    public void u(ViewGroup viewGroup, ViewGroup viewGroup2, FullRewardExpressView fullRewardExpressView) {
        this.t = viewGroup2;
        if (viewGroup == null || fullRewardExpressView == null || u() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.jk;
        if (fxVar != null) {
            fxVar.u();
            if (fullRewardExpressView.getContext() != null && (fullRewardExpressView.getContext() instanceof Activity)) {
                this.jk.u((Activity) fullRewardExpressView.getContext());
            }
        }
        this.x.u(fullRewardExpressView);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.x.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.jk);
        fullRewardExpressView.setClickListener(this.x);
        this.n.u(fullRewardExpressView);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.n.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.jk);
        fullRewardExpressView.setClickCreativeListener(this.n);
        this.f5229a.u(viewGroup);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.f5229a.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.jk);
        ImageView imageView = new ImageView(this.u);
        com.bytedance.sdk.openadsdk.n.nr.u(this.nr.zu().get(0)).to(imageView);
        this.t.addView(imageView);
    }

    public void u(boolean z) {
        this.b = z;
    }

    public void u(NativeExpressView nativeExpressView) {
        if (this.s.getAndSet(true)) {
            return;
        }
        Map<String, Object> mapU = this.u.u(this.nr);
        kj.u(mapU, this.nr, nativeExpressView);
        com.bytedance.sdk.openadsdk.core.s.b.u(this.nr, this.fx, mapU, this.u.oa());
        com.bytedance.sdk.openadsdk.core.bf.u.u().b();
        bc bcVar = this.nr;
        xg.u(bcVar != null ? bcVar.n() : 0);
    }

    public void u(float f, float f2) {
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this.u, u(), h.u(7, String.valueOf(jp.t(u())), f, f2), nr(), false, null);
        this.o = fullRewardExpressView;
        fullRewardExpressView.getAdShowTime().u(true);
        this.o.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.nr.6
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
            public void u(View view, float f3, float f4) {
                nr.this.pn = true;
            }
        });
        this.o.o();
    }
}
