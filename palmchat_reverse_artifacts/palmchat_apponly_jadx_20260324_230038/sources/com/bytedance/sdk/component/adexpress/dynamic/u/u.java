package com.bytedance.sdk.component.adexpress.dynamic.u;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.b.pn;
import com.bytedance.sdk.component.adexpress.dynamic.b.n;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.dynamic.fx.iz;
import com.bytedance.sdk.component.adexpress.fx;
import com.bytedance.sdk.component.adexpress.nr.b;
import com.bytedance.sdk.component.adexpress.nr.mv;
import com.bytedance.sdk.component.adexpress.nr.s;
import com.bytedance.sdk.component.adexpress.nr.t;
import com.bytedance.sdk.component.adexpress.nr.x;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.utils.jk;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements b<DynamicRootView>, t {
    private x b;
    private Context fx;
    private mv iz;
    private n nr;
    private com.bytedance.sdk.component.adexpress.nr.n pn;
    private DynamicRootView u;
    private ScheduledFuture<?> x;
    private AtomicBoolean n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f5096a = false;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class RunnableC0205u implements Runnable {
        private int nr;

        public RunnableC0205u(int i) {
            this.nr = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.nr == 2) {
                u.this.u.u(u.this.nr instanceof com.bytedance.sdk.component.adexpress.dynamic.b.x ? 127 : 117, (String) null);
            }
        }
    }

    public u(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, n nVar, mv mvVar, com.bytedance.sdk.component.adexpress.dynamic.pn.u uVar) {
        this.fx = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z, mvVar, uVar);
        this.u = dynamicRootView;
        this.nr = nVar;
        this.iz = mvVar;
        dynamicRootView.setRenderListener(this);
        this.iz = mvVar;
    }

    private boolean a() {
        DynamicRootView dynamicRootView = this.u;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk() {
        try {
            ScheduledFuture<?> scheduledFuture = this.x;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.x.cancel(false);
            this.x = null;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.iz.x().nr(fx());
        JSONObject jSONObjectPn = this.iz.pn();
        if (com.bytedance.sdk.component.adexpress.u.nr.nr.u(jSONObjectPn)) {
            this.nr.u(new com.bytedance.sdk.component.adexpress.dynamic.pn.nr() { // from class: com.bytedance.sdk.component.adexpress.dynamic.u.u.3
                @Override // com.bytedance.sdk.component.adexpress.dynamic.pn.nr
                public void u(final com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar) {
                    u.this.jk();
                    u.this.iz.x().fx(u.this.fx());
                    u.this.u(nVar);
                    u.this.nr(nVar);
                    if (u.this.f5096a) {
                        u.this.fx(nVar);
                    } else {
                        jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.u.u.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                u.this.fx(nVar);
                            }
                        });
                    }
                    if (u.this.u == null || nVar == null) {
                        return;
                    }
                    u.this.u.setBgColor(nVar.u());
                    u.this.u.setBgMaterialCenterCalcColor(nVar.nr());
                }
            });
            this.nr.u(this.iz);
            return;
        }
        int i = this.nr instanceof com.bytedance.sdk.component.adexpress.dynamic.b.x ? 123 : 113;
        DynamicRootView dynamicRootView = this.u;
        StringBuilder sb = new StringBuilder("data null is ");
        sb.append(jSONObjectPn == null);
        dynamicRootView.u(i, sb.toString());
    }

    public void b() {
        this.u.u();
    }

    public DynamicRootView iz() {
        return this.u;
    }

    public void pn() {
        this.u.nr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar) {
        float fX;
        float fIz;
        List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> listT;
        if (nVar == null) {
            return;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> listT2 = nVar.t();
        if (listT2 == null || listT2.size() <= 0) {
            fX = 0.0f;
        } else {
            fX = 0.0f;
            for (com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar2 : listT2) {
                if (nVar2.x() > nVar.x() - nVar2.a() || (listT = nVar2.t()) == null || listT.size() <= 0) {
                    fIz = 0.0f;
                } else {
                    fIz = 0.0f;
                    for (com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar3 : listT) {
                        if (nVar3.jk().getType().equals("logo-union")) {
                            fIz = nVar3.jk().iz();
                            fX = (((-fIz) + nVar.x()) - nVar2.x()) + nVar2.jk().pn().gb();
                        }
                    }
                }
                nr(nVar2);
                if (fIz <= -15.0f) {
                    nVar2.iz(nVar2.a() - fIz);
                    nVar2.b(nVar2.x() + fIz);
                    for (com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar4 : nVar2.t()) {
                        nVar4.b(nVar4.x() - fIz);
                    }
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.fx.n nVarL = nVar.l();
        if (nVarL == null) {
            return;
        }
        float fIz2 = nVar.iz() - nVarL.iz();
        float fX2 = nVar.x() - nVarL.x();
        nVar.fx(fIz2);
        nVar.b(fX2);
        if (fX > 0.0f) {
            nVar.b(nVar.x() - fX);
            nVar.iz(nVar.a() + fX);
            for (com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar5 : nVar.t()) {
                nVar5.b(nVar5.x() + fX);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.b
    public int fx() {
        return this.nr instanceof com.bytedance.sdk.component.adexpress.dynamic.b.x ? 3 : 2;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.b
    public void u(x xVar) {
        this.b = xVar;
        int iN = this.iz.n();
        if (iN < 0) {
            int i = this.nr instanceof com.bytedance.sdk.component.adexpress.dynamic.b.x ? 127 : 117;
            this.u.u(i, "time is " + iN);
            return;
        }
        this.x = pn.u(new RunnableC0205u(2), iN, TimeUnit.MILLISECONDS);
        if (this.f5096a) {
            jk.fx().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.u.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.n();
                }
            }, this.iz.l());
        } else if (Looper.getMainLooper() == Looper.myLooper() && this.iz.l() <= 0) {
            n();
        } else {
            jk.nr().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.u.u.2
                @Override // java.lang.Runnable
                public void run() {
                    u.this.n();
                }
            }, this.iz.l());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar) {
        if (nVar == null) {
            this.u.u(this.nr instanceof com.bytedance.sdk.component.adexpress.dynamic.b.x ? 123 : 113, "layoutUnit is null");
            return;
        }
        this.iz.x().b(fx());
        try {
            this.u.u(nVar, fx());
        } catch (Exception e) {
            int i = this.nr instanceof com.bytedance.sdk.component.adexpress.dynamic.b.x ? 128 : 118;
            this.u.u(i, "exception is " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar) {
        List<com.bytedance.sdk.component.adexpress.dynamic.fx.n> listT;
        if (nVar == null || (listT = nVar.t()) == null || listT.size() <= 0) {
            return;
        }
        Collections.sort(listT, new Comparator<com.bytedance.sdk.component.adexpress.dynamic.fx.n>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.u.u.4
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar2, com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar3) {
                iz izVarPn = nVar2.jk().pn();
                iz izVarPn2 = nVar3.jk().pn();
                if (izVarPn == null || izVarPn2 == null) {
                    return 0;
                }
                return izVarPn.ua() >= izVarPn2.ua() ? 1 : -1;
            }
        });
        for (com.bytedance.sdk.component.adexpress.dynamic.fx.n nVar2 : listT) {
            if (nVar2 != null) {
                u(nVar2);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.b
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public DynamicRootView x() {
        return iz();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void u(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                u(viewGroup.getChildAt(i));
                i++;
            }
        }
        if (view instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.pn) {
            ((com.bytedance.sdk.component.adexpress.dynamic.dynamicview.pn) view).nr();
        }
    }

    public void nr() {
        u(x());
    }

    public void nr(boolean z) {
        this.f5096a = z;
    }

    public void u(boolean z) {
        this.u.setSoundMute(z);
    }

    public void u(com.bytedance.sdk.component.adexpress.nr.n nVar) {
        this.pn = nVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.t
    public void u(s sVar) {
        if (this.n.get()) {
            return;
        }
        this.n.set(true);
        if (sVar.fx() && a()) {
            this.u.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.b.u(x(), sVar);
            return;
        }
        this.b.u(sVar.t(), sVar.jk());
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.t
    public void u(View view, int i, fx fxVar) {
        com.bytedance.sdk.component.adexpress.nr.n nVar = this.pn;
        if (nVar != null) {
            nVar.u(view, i, fxVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.nr.t
    public void u(View view, int i, fx fxVar, int i2) {
        com.bytedance.sdk.component.adexpress.nr.n nVar = this.pn;
        if (nVar != null) {
            nVar.u(view, i, fxVar, i2);
        }
    }
}
