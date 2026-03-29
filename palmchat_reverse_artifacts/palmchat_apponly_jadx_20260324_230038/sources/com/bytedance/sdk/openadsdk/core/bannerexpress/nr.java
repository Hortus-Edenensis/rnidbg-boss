package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import com.bytedance.sdk.openadsdk.core.l.n;
import com.bytedance.sdk.openadsdk.core.l.nr.u;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.iz;
import com.bytedance.sdk.openadsdk.core.nativeexpress.kj;
import com.bytedance.sdk.openadsdk.core.nativeexpress.nr;
import com.bytedance.sdk.openadsdk.core.nativeexpress.pn;
import com.bytedance.sdk.openadsdk.core.nr.u.fx.fx;
import com.bytedance.sdk.openadsdk.core.qq;
import com.bytedance.sdk.openadsdk.core.y.xg;
import com.bytedance.sdk.openadsdk.gi.x;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends com.bytedance.sdk.openadsdk.core.nativeexpress.nr implements rh.u {
    protected com.bytedance.sdk.openadsdk.my.fx.fx.nr b;
    protected bc fx;
    private boolean gi;
    protected com.bytedance.sdk.openadsdk.core.l.nr.u iz;
    private com.bytedance.sdk.openadsdk.core.l.nr.fx jk;
    private pn kj;
    private rh l;
    private int mv;
    protected final Context nr;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.u pn;
    private volatile View q;
    private iz qq;
    private com.bytedance.sdk.openadsdk.bg.u.nr.u.u s;
    private com.bytedance.sdk.openadsdk.core.dislike.ui.nr t;
    protected u u;
    protected WeakReference<BannerExpressBackupView> x;
    private NativeExpressView z;
    private String k = "banner_ad";
    private final Queue<Long> my = new LinkedList();
    private Double o = null;
    private boolean sx = false;
    private boolean bg = false;
    private AtomicBoolean bq = new AtomicBoolean(false);
    private AtomicBoolean dw = new AtomicBoolean(false);
    private AtomicBoolean c = new AtomicBoolean(false);

    public nr(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        this.gi = false;
        this.nr = context;
        this.fx = bcVar;
        this.b = nrVar;
        this.gi = dw.nr().ms() || dw.nr().im();
        u(context, bcVar, nrVar);
        u(this.u.getCurView(), this.fx, false);
    }

    private void my() {
        oa oaVar = new oa();
        oaVar.iz = 2;
        dw.u().u(this.b, oaVar, 1, new com.bytedance.sdk.openadsdk.core.u.u(new qq.nr() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.nr.6
            @Override // com.bytedance.sdk.openadsdk.core.qq.nr
            public void u(int i, String str, com.bytedance.sdk.openadsdk.core.kj.nr nrVar) {
                nr.this.s();
            }

            @Override // com.bytedance.sdk.openadsdk.core.qq.nr
            public void u(com.bytedance.sdk.openadsdk.core.kj.u uVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(uVar.nr());
                if (copyOnWriteArrayList.isEmpty()) {
                    nr.this.s();
                    return;
                }
                bc bcVar = (bc) copyOnWriteArrayList.get(0);
                nr nrVar2 = nr.this;
                nrVar2.u.u(bcVar, nrVar2.b);
                nr.this.u(bcVar);
                nr.this.u.fx();
            }
        }));
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void jk() {
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        rh rhVar = this.l;
        if (rhVar != null) {
            rhVar.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mv() {
        if (this.fx.qf() == 4) {
            x.u(new a("banner_express_register_download") { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.nr.1
                @Override // java.lang.Runnable
                public void run() {
                    if (nr.this.fx.qf() == 4) {
                        nr nrVar = nr.this;
                        nrVar.jk = n.u(nrVar.nr, nrVar.fx, nrVar.k, false);
                        nr.this.jk.u();
                        nr nrVar2 = nr.this;
                        if (nrVar2.nr instanceof Activity) {
                            nrVar2.jk.u((Activity) nr.this.nr);
                        }
                        if (nr.this.qq != null) {
                            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) nr.this.qq.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(nr.this.jk);
                        }
                        if (nr.this.kj != null) {
                            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) nr.this.kj.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(nr.this.jk);
                        }
                        nr nrVar3 = nr.this;
                        nrVar3.u(nrVar3.jk, nr.this.z);
                        nr.this.jk.u(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        rh rhVar;
        if (this.q == null || !this.q.isShown() || (rhVar = this.l) == null) {
            return;
        }
        rhVar.removeCallbacksAndMessages(null);
        this.l.sendEmptyMessageDelayed(112201, this.mv);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public b a() {
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
        this.fx.vz().nr(this.k);
        return new com.bytedance.sdk.openadsdk.core.dislike.fx.u(this.fx.vz());
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void iz() {
        super.iz();
        u uVar = this.u;
        if (uVar != null) {
            uVar.b();
        }
        rh rhVar = this.l;
        if (rhVar != null) {
            rhVar.removeCallbacksAndMessages(null);
            this.l = null;
        }
        bc bcVar = this.fx;
        xg.nr(bcVar != null ? bcVar.n() : 0);
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
    public void pn() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = this.t;
        if (nrVar != null) {
            nrVar.u(this.u);
        }
        this.u.pn();
        com.bytedance.sdk.openadsdk.core.x.b.u().u(this.fx).u(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr
    public bc x() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public int nr() {
        bc bcVar = this.fx;
        if (bcVar == null) {
            return -1;
        }
        return bcVar.ol();
    }

    private void nr(Activity activity, com.bytedance.sdk.openadsdk.bg.u.nr.u.u uVar) {
        if (this.t == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.nr(activity, this.fx.vz(), this.k, false, com.bytedance.sdk.openadsdk.n.nr.u());
            this.t = nrVar;
            com.bytedance.sdk.openadsdk.core.dislike.fx.u(activity, this.fx, nrVar);
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar2 = this.t;
        if (nrVar2 != null) {
            nrVar2.u(this.u);
        }
        this.t.u(uVar);
        u uVar2 = this.u;
        if (uVar2 == null || uVar2.getCurView() == null) {
            return;
        }
        this.u.getCurView().setDislike(this.t);
    }

    public void u(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        if (context == null) {
            return;
        }
        this.u = new u(context, bcVar, nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public View u() {
        com.bytedance.sdk.openadsdk.core.x.b.u().u(this.fx).u(1);
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(com.bytedance.sdk.openadsdk.kj.u.nr.u.nr nrVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.u uVarU = com.bytedance.sdk.openadsdk.core.nativeexpress.u.u(nrVar);
        this.pn = uVarU;
        this.u.setExpressInteractionListener(uVarU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(bc bcVar) {
        Queue<Long> queue = this.my;
        if (queue == null || queue.size() <= 0 || bcVar == null) {
            return;
        }
        try {
            long jLongValue = this.my.poll().longValue();
            if (jLongValue > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(SystemClock.elapsedRealtime() - jLongValue);
                String string = sb.toString();
                com.bytedance.sdk.openadsdk.core.s.pn pnVar = new com.bytedance.sdk.openadsdk.core.s.pn(this.fx, this.k);
                pnVar.u(1.0f);
                com.bytedance.sdk.openadsdk.core.s.b.u(string, bcVar, this.k, 15, pnVar.nr());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(com.bytedance.sdk.openadsdk.kj.u.nr.u.u uVar) {
        com.bytedance.sdk.openadsdk.core.nativeexpress.u uVarU = com.bytedance.sdk.openadsdk.core.nativeexpress.u.u(uVar);
        this.pn = uVarU;
        this.u.setExpressInteractionListener(uVarU);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar) {
        com.bytedance.sdk.openadsdk.core.l.nr.u uVarU = u.C0270u.u(fxVar);
        this.iz = uVarU;
        nr.u uVar = this.n;
        if (uVar != null) {
            uVar.u(uVarU);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void nr(Double d) {
        this.o = d;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(Activity activity, com.bytedance.sdk.openadsdk.bg.u.nr.u.u uVar) {
        if (uVar == null || activity == null) {
            return;
        }
        this.s = uVar;
        nr(activity, uVar);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(String str) {
        com.bytedance.sdk.openadsdk.core.s.b.nr(this.fx, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr
    public void u(Dialog dialog) {
        if (dialog == null) {
            k.u("dialog is null, please check");
            return;
        }
        u uVar = this.u;
        if (uVar == null || uVar.getCurView() == null) {
            return;
        }
        this.u.getCurView().setOuterDislike(dialog);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public com.bytedance.sdk.openadsdk.my.fx.nr.x u(Activity activity) {
        if (this.t == null) {
            nr(activity, (com.bytedance.sdk.openadsdk.bg.u.nr.u.u) null);
        }
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(bc bcVar) {
        if (this.u.getNextView() == null || !this.u.nr()) {
            return;
        }
        u(this.u.getNextView(), bcVar.vz());
        this.c.set(false);
        u(this.u.getNextView(), bcVar, true);
    }

    private void u(NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.dislike.fx.nr nrVar) {
        if (nrVar == null) {
            return;
        }
        if (this.s != null) {
            this.t.u(nrVar);
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.t);
            }
        }
        if (this.f5343a != null) {
            u(nrVar);
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(this.f5343a);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void u(final NativeExpressView nativeExpressView, final bc bcVar, boolean z) {
        if (nativeExpressView == null || bcVar == null) {
            return;
        }
        this.z = nativeExpressView;
        bc bcVar2 = this.fx;
        if (bcVar2 != null) {
            xg.nr(bcVar2.n());
        }
        this.fx = bcVar;
        nativeExpressView.setBackupListener(new com.bytedance.sdk.component.adexpress.nr.fx() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.nr.2
            @Override // com.bytedance.sdk.component.adexpress.nr.fx
            public boolean u(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).bg();
                    BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(viewGroup.getContext());
                    nr nrVar = nr.this;
                    bannerExpressBackupView.u(nrVar.fx, (NativeExpressView) viewGroup, nrVar.jk);
                    bannerExpressBackupView.setDislikeInner(nr.this.t);
                    bannerExpressBackupView.setDislikeOuter(((com.bytedance.sdk.openadsdk.core.nativeexpress.nr) nr.this).f5343a);
                    nr nrVar2 = nr.this;
                    if (nrVar2.fx != null) {
                        nrVar2.u(bcVar.vz());
                    }
                    nr.this.x = new WeakReference<>(bannerExpressBackupView);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.s.b.u(bcVar);
        EmptyView emptyViewU = u(nativeExpressView);
        if (emptyViewU == null) {
            EmptyView emptyView = new EmptyView(this.nr, nativeExpressView, bcVar.re());
            emptyView.u(this.fx, this.k);
            nativeExpressView.addView(emptyView);
            emptyViewU = emptyView;
        }
        this.q = emptyViewU;
        emptyViewU.setCallback(new EmptyView.u() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.nr.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void nr() {
                if (nr.this.jk != null) {
                    nr.this.jk.nr();
                }
                nr.this.nr(bcVar);
                nr.this.bq.set(false);
                nr.this.dw.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u(boolean z2) {
                String unused = nr.this.k;
                if (nr.this.jk != null) {
                    if (z2) {
                        nr.this.jk.u();
                    } else {
                        com.bytedance.sdk.openadsdk.core.l.nr.fx unused2 = nr.this.jk;
                    }
                }
                if (z2) {
                    nr.this.s();
                } else {
                    nr.this.k();
                }
                nr.this.u(z2, bcVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u() {
                nr.this.mv();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.u
            public void u(View view, Map<String, Object> map) {
                if (nr.this.my != null) {
                    nr.this.my.offer(Long.valueOf(SystemClock.elapsedRealtime()));
                }
                Map mapU = nr.this.u(nativeExpressView, bcVar);
                if (map != null && map.containsKey("show_send_type")) {
                    mapU.put("show_send_type", map.get("show_send_type"));
                }
                mapU.put("is_repeat", Boolean.valueOf(nr.this.c.get()));
                nr.this.bq.set(true);
                if (!nr.this.dw.get()) {
                    nr.this.dw.set(true);
                    com.bytedance.sdk.openadsdk.core.s.b.u(bcVar, nr.this.k, (Map<String, Object>) mapU, nr.this.o);
                    com.bytedance.sdk.openadsdk.core.bf.u.u().b();
                    bc bcVar3 = bcVar;
                    xg.u(bcVar3 != null ? bcVar3.n() : 0);
                }
                boolean zVp = dw.nr().vp();
                nr nrVar = nr.this;
                if (nrVar.pn != null && (!nrVar.c.getAndSet(true) || zVp)) {
                    nr.this.pn.nr(view, bcVar.qf());
                    if (bcVar.fx() && bcVar.kv() != null) {
                        com.bytedance.sdk.openadsdk.core.o.u.u().u(nr.this.nr, bcVar.kv().nr());
                    }
                }
                nr.this.s();
                u uVar = nr.this.u;
                if (uVar == null || uVar.getCurView() == null) {
                    return;
                }
                nr.this.u.getCurView().sx();
                nr.this.u.getCurView().my();
            }
        });
        iz izVar = new iz(this.nr, bcVar, this.k, 2);
        this.qq = izVar;
        final com.bytedance.sdk.openadsdk.core.nr.u.fx.fx fxVar = (com.bytedance.sdk.openadsdk.core.nr.u.fx.fx) izVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class);
        final EmptyView emptyView2 = emptyViewU;
        fxVar.u(new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.nr.4
            @Override // com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.u
            public boolean u() {
                fxVar.u(emptyView2);
                fxVar.u(nr.this.u(nativeExpressView, bcVar));
                fxVar.u(nr.this.k);
                fxVar.u(nr.this.o);
                return nr.this.bq.get();
            }
        });
        this.qq.u(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.qq.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this);
        nativeExpressView.setClickListener(this.qq);
        pn pnVar = new pn(this.nr, bcVar, this.k, 2);
        this.kj = pnVar;
        final com.bytedance.sdk.openadsdk.core.nr.u.fx.fx fxVar2 = (com.bytedance.sdk.openadsdk.core.nr.u.fx.fx) pnVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class);
        fxVar2.u(new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.nr.5
            @Override // com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.u
            public boolean u() {
                fxVar2.u(emptyView2);
                fxVar2.u(nr.this.u(nativeExpressView, bcVar));
                fxVar2.u(nr.this.k);
                fxVar2.u(nr.this.o);
                return nr.this.bq.get();
            }
        });
        this.kj.u(nativeExpressView);
        ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.kj.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this);
        nativeExpressView.setClickCreativeListener(this.kj);
        if (!this.gi) {
            emptyViewU.setNeedCheckingShow(true);
        }
        if (z) {
            mv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> u(NativeExpressView nativeExpressView, bc bcVar) {
        HashMap map = new HashMap();
        kj.u(map, this.fx, nativeExpressView);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar, NativeExpressView nativeExpressView) {
        if (fxVar == null || nativeExpressView == null) {
            return;
        }
        bc bcVar = this.fx;
        nr.u uVar = new nr.u(this.iz, bcVar != null ? bcVar.lk() : "");
        this.n = uVar;
        fxVar.u(uVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(boolean z, bc bcVar) {
        Queue<Long> queue = this.my;
        if (queue == null) {
            return;
        }
        try {
            if (z) {
                queue.offer(Long.valueOf(SystemClock.elapsedRealtime()));
                return;
            }
            if (queue.size() > 0) {
                long jLongValue = this.my.poll().longValue();
                StringBuilder sb = new StringBuilder();
                sb.append(SystemClock.elapsedRealtime() - jLongValue);
                String string = sb.toString();
                com.bytedance.sdk.openadsdk.core.s.pn pnVar = new com.bytedance.sdk.openadsdk.core.s.pn(this.fx, this.k);
                pnVar.u(1.0f);
                com.bytedance.sdk.openadsdk.core.s.b.u(string, bcVar, this.k, 13, pnVar.nr());
            }
        } catch (Exception unused) {
        }
    }

    private EmptyView u(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            try {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof EmptyView) {
                    return (EmptyView) childAt;
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.s
    public void u(int i) {
        if (i <= 0) {
            return;
        }
        this.k = "slide_banner_ad";
        u(this.u.getCurView(), this.fx, false);
        this.u.setDuration(1000);
        if (i < 30000) {
            i = 30000;
        } else if (i > 120000) {
            i = 120000;
        }
        this.mv = i;
        this.l = new rh(Looper.getMainLooper(), this);
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        if (message.what == 112201 && this.q != null && this.q.isShown()) {
            my();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(Double d) {
        if (this.sx) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.rh.u(this.fx, d);
        this.sx = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.nr, com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(Double d, String str, String str2) {
        if (this.bg) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.rh.u(this.fx, d, str, str2);
        this.bg = true;
    }
}
