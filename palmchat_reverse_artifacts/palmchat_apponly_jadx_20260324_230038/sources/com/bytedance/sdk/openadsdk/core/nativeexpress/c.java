package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.l.nr.u;
import com.bytedance.sdk.openadsdk.core.nativeexpress.nr;
import com.bytedance.sdk.openadsdk.core.nr.u.fx.fx;
import com.bytedance.sdk.openadsdk.core.wq;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.rh;
import com.bytedance.sdk.openadsdk.core.y.xg;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class c extends nr {
    private pn bg;
    private final com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fx c;
    private final FrameLayout dw;
    protected bc fx;
    private u iz;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.nr jk;
    private boolean kj;
    protected final Context nr;
    protected WeakReference<mv> pn;
    private EmptyView qq;
    private iz sx;
    private com.bytedance.sdk.openadsdk.core.l.nr.fx t;
    protected NativeExpressView u;
    private com.bytedance.sdk.openadsdk.core.l.nr.u x;
    private final com.bytedance.sdk.openadsdk.core.s.pn z;
    protected String b = "embeded_ad";
    private Double l = null;
    private boolean mv = false;
    private boolean s = false;
    private AtomicBoolean k = new AtomicBoolean(false);
    private AtomicBoolean my = new AtomicBoolean(false);
    private AtomicBoolean o = new AtomicBoolean(false);
    private volatile boolean bq = false;
    private final ViewGroup q = new FrameLayout(com.bytedance.sdk.openadsdk.core.dw.getContext());
    private final u gi = new u() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.c.1
        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
        public void nr(View view, int i) {
            boolean zVp = com.bytedance.sdk.openadsdk.core.dw.nr().vp();
            if (c.this.iz != null && (!c.this.o.getAndSet(true) || zVp)) {
                c.this.iz.nr(c.this.q, i);
                com.bytedance.sdk.openadsdk.core.kj.my myVarKv = c.this.fx.kv();
                if (c.this.fx.fx() && myVarKv != null) {
                    com.bytedance.sdk.openadsdk.core.o.u.u().u(c.this.nr, myVarKv.nr());
                }
            }
            if (c.this.c == null || c.this.c.u() == null) {
                return;
            }
            c.this.c.u().b();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
        public void u(View view, int i) {
            if (c.this.iz != null) {
                c.this.iz.u(c.this.q, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
        public void u(View view, String str, int i) {
            if (c.this.iz != null) {
                c.this.iz.u(c.this.q, str, i);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
        public void u(View view, float f, float f2) {
            c cVar = c.this;
            if (cVar.u != null && cVar.c != null) {
                c cVar2 = c.this;
                cVar2.u.setEasyPlayableSender(cVar2.c.u());
                c.this.c.u(c.this.u.getEasyPlayableLayout(), c.this.u.getVideoContainer());
            }
            c.this.q.removeAllViews();
            c.this.q.addView(view);
            c.this.q.addView(c.this.dw, new FrameLayout.LayoutParams((int) f, (int) f2));
            if (c.this.iz != null) {
                c.this.iz.u(c.this.q, f, f2);
            }
        }
    };

    public c(Context context, final bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        this.kj = false;
        this.nr = context;
        this.fx = bcVar;
        this.kj = com.bytedance.sdk.openadsdk.core.dw.nr().ms() || com.bytedance.sdk.openadsdk.core.dw.nr().im();
        u(context, bcVar, nrVar);
        this.dw = new FrameLayout(context);
        this.z = new com.bytedance.sdk.openadsdk.core.s.pn(this.fx, this.b);
        this.c = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fx(bcVar, false, new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.c.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void b() {
                NativeExpressView nativeExpressView = c.this.u;
                if (nativeExpressView != null) {
                    nativeExpressView.b();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void fx(int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void iz() {
                NativeExpressView nativeExpressView = c.this.u;
                if (nativeExpressView != null) {
                    nativeExpressView.iz();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public int nr() {
                NativeExpressView nativeExpressView = c.this.u;
                if (nativeExpressView != null) {
                    return nativeExpressView.nr();
                }
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void pn() {
                NativeExpressView nativeExpressView = c.this.u;
                if (nativeExpressView != null) {
                    nativeExpressView.pn();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void setPauseFromExpressView(boolean z) {
                NativeExpressView nativeExpressView = c.this.u;
                if (nativeExpressView != null) {
                    nativeExpressView.setPauseFromExpressView(z);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
            public void u(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public int fx() {
                NativeExpressView nativeExpressView = c.this.u;
                if (nativeExpressView != null) {
                    return nativeExpressView.fx();
                }
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void u(int i) {
                NativeExpressView nativeExpressView = c.this.u;
                if (nativeExpressView != null) {
                    nativeExpressView.u(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void nr(int i) {
                NativeExpressView nativeExpressView = c.this.u;
                if (nativeExpressView != null) {
                    nativeExpressView.nr(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public long u() {
                NativeExpressView nativeExpressView = c.this.u;
                if (nativeExpressView != null) {
                    return nativeExpressView.u();
                }
                return 0L;
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
            public void nr(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar) {
                NativeExpressView nativeExpressView = c.this.u;
                if (nativeExpressView != null) {
                    nativeExpressView.u(view, i, fxVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void u(int i, String str) {
                NativeExpressView nativeExpressView = c.this.u;
                if (nativeExpressView != null) {
                    nativeExpressView.u(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void u(float f) {
                NativeExpressView nativeExpressView = c.this.u;
                if (nativeExpressView != null) {
                    nativeExpressView.u(f);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
            public void u(View view) {
                c.this.gi.u(view, bcVar.qf());
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a.u(bcVar, true, 2, 3, (JSONObject) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
            public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar) {
                NativeExpressView nativeExpressView = c.this.u;
                if (nativeExpressView != null) {
                    nativeExpressView.u(view, i, fxVar);
                }
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a.u(bcVar, false, 1, fxVar instanceof com.bytedance.sdk.openadsdk.core.kj.q ? ((com.bytedance.sdk.openadsdk.core.kj.q) fxVar).u().optBoolean("isLottieInternalClick", false) : false ? 2 : 1, (JSONObject) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv() {
        if (!this.bq) {
            this.bq = true;
            if (this.fx.qf() == 4) {
                com.bytedance.sdk.openadsdk.gi.x.u(new com.bytedance.sdk.component.jk.a("native_register_download") { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.c.3
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVar = c.this;
                        cVar.t = com.bytedance.sdk.openadsdk.core.l.n.u(cVar.nr, cVar.fx, cVar.b, false);
                        if (c.this.sx != null) {
                            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) c.this.sx.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(c.this.t);
                        }
                        if (c.this.bg != null) {
                            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) c.this.bg.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(c.this.t);
                        }
                        c cVar2 = c.this;
                        if (cVar2.nr instanceof Activity) {
                            cVar2.t.u((Activity) c.this.nr);
                        }
                        c cVar3 = c.this;
                        cVar3.u(cVar3.t, c.this.u);
                        c.this.t.u(false);
                        c.this.t.u(c.this.n);
                    }
                });
                return;
            }
            return;
        }
        if (this.t != null) {
            iz izVar = this.sx;
            if (izVar != null) {
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) izVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.t);
            }
            pn pnVar = this.bg;
            if (pnVar != null) {
                ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) pnVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.t);
            }
            try {
                u(this.t, this.u);
                this.t.u(false);
                this.t.u(this.n);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> s() {
        HashMap map = new HashMap();
        kj.u(map, this.fx, this.u);
        return map;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b a() {
        return new MediationNativeManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public int b() {
        bc bcVar = this.fx;
        if (bcVar == null) {
            return -1;
        }
        return bcVar.qf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public com.bytedance.sdk.openadsdk.my.fx.nr.b fx() {
        bc bcVar = this.fx;
        if (bcVar == null || bcVar.vz() == null) {
            return null;
        }
        this.fx.vz().nr(this.b);
        return new com.bytedance.sdk.openadsdk.core.dislike.fx.u(this.fx.vz());
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void iz() {
        super.iz();
        NativeExpressView nativeExpressView = this.u;
        if (nativeExpressView != null) {
            nativeExpressView.mv();
        }
        this.z.u(wq.nr(this.u), 16);
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.t;
        if (fxVar != null) {
            fxVar.nr();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fx fxVar2 = this.c;
        if (fxVar2 != null) {
            fxVar2.nr();
        }
        bc bcVar = this.fx;
        xg.nr(bcVar != null ? bcVar.n() : 0);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void jk() {
        NativeExpressView nativeExpressView = this.u;
        if (nativeExpressView != null) {
            nativeExpressView.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public Map<String, Object> n() {
        bc bcVar = this.fx;
        if (bcVar != null) {
            return bcVar.sj();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public int nr() {
        bc bcVar = this.fx;
        if (bcVar == null) {
            return -1;
        }
        return bcVar.ol();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void pn() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = this.jk;
        if (nrVar != null) {
            nrVar.u(this.u);
        }
        this.u.o();
        com.bytedance.sdk.openadsdk.core.x.b.u().u(this.fx);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr
    public bc x() {
        return this.fx;
    }

    private void nr(Activity activity, com.bytedance.sdk.openadsdk.bg.u.nr.u.u uVar) {
        if (this.jk == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.nr(activity, this.fx.vz(), this.b, false, com.bytedance.sdk.openadsdk.n.nr.u());
            this.jk = nrVar;
            com.bytedance.sdk.openadsdk.core.dislike.fx.u(activity, this.fx, nrVar);
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar2 = this.jk;
        if (nrVar2 != null) {
            nrVar2.u(this.u);
        }
        this.jk.u(uVar);
        NativeExpressView nativeExpressView = this.u;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.jk);
        }
    }

    public void u(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(context, bcVar, nrVar, this.b);
        this.u = nativeExpressView;
        this.q.addView(nativeExpressView);
        u(this.u, this.fx);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public View u() {
        com.bytedance.sdk.openadsdk.core.x.b.u().u(this.fx);
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(com.bytedance.sdk.openadsdk.kj.u.nr.u.nr nrVar) {
        this.iz = u.u(nrVar);
        this.u.setExpressInteractionListener(this.gi);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(com.bytedance.sdk.openadsdk.kj.u.nr.u.u uVar) {
        this.iz = u.u(uVar);
        this.u.setExpressInteractionListener(this.gi);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void nr(Double d) {
        this.l = d;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar) {
        com.bytedance.sdk.openadsdk.core.l.nr.u uVarU = u.C0270u.u(fxVar);
        this.x = uVarU;
        nr.u uVar = this.n;
        if (uVar != null) {
            uVar.u(uVarU);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(Activity activity, com.bytedance.sdk.openadsdk.bg.u.nr.u.u uVar) {
        if (uVar == null || activity == null) {
            return;
        }
        nr(activity, uVar);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(String str) {
        com.bytedance.sdk.openadsdk.core.s.b.nr(this.fx, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr
    public void u(Dialog dialog) {
        if (dialog == null) {
            com.bytedance.sdk.component.utils.k.u("dialog is null, please check");
            return;
        }
        NativeExpressView nativeExpressView = this.u;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(dialog);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public com.bytedance.sdk.openadsdk.my.fx.nr.x u(Activity activity) {
        if (this.jk == null) {
            nr(activity, null);
        }
        return this.jk;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(JSONObject jSONObject) {
        NativeExpressView nativeExpressView = this.u;
        if (nativeExpressView != null) {
            nativeExpressView.u(jSONObject);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void u(final NativeExpressView nativeExpressView, final bc bcVar) {
        this.fx = bcVar;
        nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.nr.fx() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.c.4
            @Override // com.bytedance.sdk.component.adexpress.nr.fx
            public boolean u(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).bg();
                    mv mvVar = new mv(viewGroup.getContext());
                    com.bytedance.sdk.openadsdk.core.video.b.u.u(Integer.valueOf(bcVar.hashCode()), c.this);
                    c cVar = c.this;
                    mvVar.u(cVar.fx, (NativeExpressView) viewGroup, cVar.t);
                    mvVar.setDislikeInner(c.this.jk);
                    mvVar.setDislikeOuter(c.this.f5343a);
                    c cVar2 = c.this;
                    bc bcVar2 = cVar2.fx;
                    if (bcVar2 != null) {
                        cVar2.u(bcVar2.vz());
                    }
                    c.this.pn = new WeakReference<>(mvVar);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.s.b.u(bcVar);
        EmptyView emptyViewU = u(nativeExpressView);
        this.qq = emptyViewU;
        if (emptyViewU == null) {
            EmptyView emptyView = new EmptyView(this.nr, nativeExpressView, bcVar != null ? bcVar.re() : 1000);
            this.qq = emptyView;
            emptyView.u(this.fx, this.b);
            nativeExpressView.addView(this.qq);
        }
        this.qq.setCallback(new EmptyView.u() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.c.5
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void nr() {
                WeakReference<Activity> weakReferenceU;
                Activity activity;
                if (c.this.t != null) {
                    c.this.t.nr();
                }
                c.this.z.u(wq.nr(nativeExpressView), 15);
                c.this.k.set(false);
                c.this.my.set(false);
                if (!jp.fx(c.this.fx) || (weakReferenceU = com.bytedance.sdk.openadsdk.core.n.o().b().u()) == null || (activity = weakReferenceU.get()) == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.k.u.fx.u().nr(activity.getWindow(), c.this.fx, true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u(boolean z) {
                Activity activity;
                WeakReference<Activity> weakReferenceU;
                Activity activity2;
                if (c.this.t != null) {
                    if (z) {
                        c.this.t.u();
                    } else {
                        com.bytedance.sdk.openadsdk.core.l.nr.fx unused = c.this.t;
                    }
                }
                c.this.z.u(wq.nr(nativeExpressView), z ? 12 : 13);
                if (jp.fx(c.this.fx)) {
                    if (!z) {
                        WeakReference<Activity> weakReferenceU2 = com.bytedance.sdk.openadsdk.core.n.o().b().u();
                        if (weakReferenceU2 == null || (activity = weakReferenceU2.get()) == null) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.core.k.u.fx.u().nr((Context) activity, c.this.fx, true);
                        return;
                    }
                    if (!jp.fx(c.this.fx) || (weakReferenceU = com.bytedance.sdk.openadsdk.core.n.o().b().u()) == null || (activity2 = weakReferenceU.get()) == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.k.u.fx fxVarU = com.bytedance.sdk.openadsdk.core.k.u.fx.u();
                    Window window = activity2.getWindow();
                    bc bcVar2 = c.this.fx;
                    fxVarU.u(window, bcVar2, jp.qq(bcVar2));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u() {
                WeakReference<Activity> weakReferenceU;
                Activity activity;
                c.this.mv();
                c.this.z.u(wq.nr(nativeExpressView), 14);
                if (!jp.fx(c.this.fx) || (weakReferenceU = com.bytedance.sdk.openadsdk.core.n.o().b().u()) == null || (activity = weakReferenceU.get()) == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.k.u.fx fxVarU = com.bytedance.sdk.openadsdk.core.k.u.fx.u();
                Window window = activity.getWindow();
                bc bcVar2 = c.this.fx;
                fxVarU.u(window, bcVar2, jp.qq(bcVar2));
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u(View view, Map<String, Object> map) {
                c.this.mv();
                c.this.z.u(wq.nr(view), 11);
                Map mapS = c.this.s();
                mapS.put("is_repeat", Boolean.valueOf(c.this.o.get()));
                if (map != null && map.containsKey("show_send_type")) {
                    mapS.put("show_send_type", map.get("show_send_type"));
                }
                mapS.put("is_repeat", Boolean.valueOf(c.this.o.get()));
                c.this.k.set(true);
                if (!c.this.my.get()) {
                    c.this.my.set(true);
                    bc bcVar2 = bcVar;
                    c cVar = c.this;
                    com.bytedance.sdk.openadsdk.core.s.b.u(bcVar2, cVar.b, (Map<String, Object>) mapS, cVar.l);
                    com.bytedance.sdk.openadsdk.core.bf.u.u().b();
                    bc bcVar3 = bcVar;
                    xg.u(bcVar3 != null ? bcVar3.n() : 0);
                }
                c.this.gi.nr(view, bcVar.qf());
                NativeExpressView nativeExpressView2 = c.this.u;
                if (nativeExpressView2 != null) {
                    nativeExpressView2.sx();
                    c.this.u.my();
                }
            }
        });
        Context context = this.nr;
        String str = this.b;
        iz izVar = new iz(context, bcVar, str, jp.nr(str));
        this.sx = izVar;
        u((com.bytedance.sdk.openadsdk.core.nr.u.fx.fx) izVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class));
        this.sx.u(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.sx.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this);
        this.u.setClickListener(this.sx);
        Context context2 = this.nr;
        String str2 = this.b;
        pn pnVar = new pn(context2, bcVar, str2, jp.nr(str2));
        this.bg = pnVar;
        u((com.bytedance.sdk.openadsdk.core.nr.u.fx.fx) pnVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class));
        this.bg.u(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.bg.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this);
        this.u.setClickCreativeListener(this.bg);
        if (this.kj) {
            return;
        }
        this.qq.setNeedCheckingShow(true);
    }

    public void u(final com.bytedance.sdk.openadsdk.core.nr.u.fx.fx fxVar) {
        fxVar.u(new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.c.6
            @Override // com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.u
            public boolean u() {
                fxVar.u(c.this.qq);
                fxVar.u(c.this.s());
                fxVar.u(c.this.b);
                fxVar.u(c.this.l);
                return c.this.k.get();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar, NativeExpressView nativeExpressView) {
        if (fxVar == null || nativeExpressView == null) {
            return;
        }
        bc bcVar = this.fx;
        nr.u uVar = new nr.u(this.x, bcVar != null ? bcVar.lk() : "");
        this.n = uVar;
        fxVar.u(uVar);
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

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(Double d) {
        if (this.mv) {
            return;
        }
        rh.u(this.fx, d);
        this.mv = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(Double d, String str, String str2) {
        if (this.s) {
            return;
        }
        rh.u(this.fx, d, str, str2);
        this.s = true;
    }
}
