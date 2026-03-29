package com.bytedance.sdk.openadsdk.core.l.fx;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.pb;
import com.bytedance.sdk.openadsdk.core.qq;
import com.bytedance.sdk.openadsdk.core.y.wq;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends pn {
    public iz(Context context, bc bcVar, String str, boolean z) {
        super(context, bcVar, str, z);
    }

    private void iz(JSONObject jSONObject, final boolean z) {
        o();
        if (getContext() == null || this.b == null || !mv()) {
            return;
        }
        String str = this.iz;
        com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(str, str, jSONObject, x());
        final wq<String, Object> wqVarU = new wq().u("downloadUrl", this.b.nr()).u("hashCode", Integer.valueOf(x())).u("action_type_button", 2);
        bc bcVar = this.pn;
        if (bcVar != null && !TextUtils.isEmpty(bcVar.lk())) {
            wqVarU.u("id", Long.valueOf(Double.valueOf(this.pn.lk()).longValue()));
        }
        if (!fx()) {
            u(wqVarU, z);
            return;
        }
        com.bytedance.sdk.openadsdk.core.l.u.nr nrVar = new com.bytedance.sdk.openadsdk.core.l.u.nr() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.iz.1
            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
                if (wqVarU == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(0, iz.this.x());
                iz.this.n().u(iz.this.s());
                wqVarU.remove("downloadButtonClickListener");
                if (iz.this.u((com.bytedance.sdk.openadsdk.core.kj.b) null, (com.bytedance.sdk.openadsdk.core.l.u.nr) null, wqVarU, z)) {
                    return;
                }
                iz.this.nr(wqVarU);
            }

            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z2) {
            }
        };
        com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(wqVarU, nrVar);
        if (u((com.bytedance.sdk.openadsdk.core.kj.b) null, nrVar, wqVarU, z)) {
            return;
        }
        fx(true);
        u(wqVarU, nrVar);
    }

    private void nr(com.bytedance.sdk.openadsdk.core.l.u.nr nrVar, Map<String, Object> map) {
        if (this.c == null) {
            return;
        }
        final wq<String, Object> wqVarU = new wq().u("itemClickListener", null).u("downloadButtonClickListener", com.bytedance.sdk.openadsdk.my.fx.b.u(nrVar)).u("hashCode", Integer.valueOf(x())).u(map);
        wqVarU.put("itemClickListener", com.bytedance.sdk.openadsdk.my.fx.b.u(new com.bytedance.sdk.openadsdk.core.l.u.pn() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.iz.3
            @Override // com.bytedance.sdk.openadsdk.core.l.u.pn
            public void onItemClick() {
                if (iz.this.o || iz.this.pn.hl()) {
                    com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.nr(1, iz.this.x());
                    wqVarU.remove("itemClickListener");
                    iz.this.c.apply(com.bytedance.sdk.openadsdk.my.b.u().u(17).u(Void.class).u(0, wqVarU).nr());
                } else {
                    Context context = iz.this.getContext();
                    String strJf = iz.this.pn.jf();
                    iz izVar = iz.this;
                    pb.u(context, strJf, izVar.pn, izVar.iz);
                }
            }
        }));
        this.c.apply(com.bytedance.sdk.openadsdk.my.b.u().u(17).u(Void.class).u(0, wqVarU).nr());
    }

    private void o() {
        if (d.fx >= 5400 && fx() && !this.q) {
            com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(false, (com.bytedance.sdk.openadsdk.core.l.u.b) null, x());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void b() {
        if (this.b == null) {
            return;
        }
        this.jk.set(false);
        Function<SparseArray<Object>, Object> function = this.c;
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.my.b.u().u(8).u(Void.class).u(0, new wq().u("force", Boolean.TRUE).u("hashCode", Integer.valueOf(x()))).nr());
        }
        my();
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn, com.bytedance.sdk.openadsdk.core.l.nr.fx
    public boolean fx() {
        Function<SparseArray<Object>, Object> function = this.c;
        return function != null && com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(function, x()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn
    public synchronized void my() {
        if (this.b == null) {
            return;
        }
        this.jk.set(true);
        if (this.c != null) {
            this.c.apply(com.bytedance.sdk.openadsdk.my.b.u().u(5).u(Void.class).u(0, new wq().u("hashCode", Integer.valueOf(x())).u("downloadStatusChangeListener", com.bytedance.sdk.openadsdk.my.fx.b.u(this.kj))).nr());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn
    public void n(boolean z) {
        com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(this.iz, this.pn, (JSONObject) null, x());
        com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(this.pn, x(), z);
        com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(this.iz, x());
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.fx.pn
    public synchronized void t() {
        if (this.b == null) {
            return;
        }
        if (this.c != null && d.fx >= 6400 && !d.x()) {
            com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u((com.bytedance.sdk.openadsdk.core.l.u.b) null, x());
        }
        AtomicBoolean atomicBoolean = this.jk;
        if (atomicBoolean != null && atomicBoolean.get()) {
            this.jk.set(false);
            if (this.c != null) {
                this.c.apply(com.bytedance.sdk.openadsdk.my.b.u().u(4).u(Void.class).u(0, new wq().u("hashCode", Integer.valueOf(x()))).nr());
            }
        }
        jk();
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void fx(boolean z) {
        if (d.fx >= 5400 && z) {
            this.q = true;
            if (fx()) {
                try {
                    com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(true, com.bytedance.sdk.openadsdk.core.l.fx.nr.fx.u(this.pn, this.qq), x());
                } catch (Throwable th) {
                    k.u("xgcdl", "throwable", th);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.nr.fx
    public void u(JSONObject jSONObject, boolean z) {
        iz(jSONObject, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.l.u.nr nrVar) {
        com.bytedance.sdk.openadsdk.core.l.a.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.iz.2
            @Override // java.lang.Runnable
            public void run() {
                iz.this.u(nrVar, (Map<String, Object>) map);
            }
        }, this.pn);
        this.q = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(final Map<String, Object> map) {
        int i = this.dw;
        if (i == 1) {
            return;
        }
        if (i == 2) {
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("tt_market_download_check") { // from class: com.bytedance.sdk.openadsdk.core.l.fx.iz.5
                @Override // java.lang.Runnable
                public void run() {
                    qq<com.bytedance.sdk.openadsdk.core.s.u> qqVarU = dw.u();
                    iz izVar = iz.this;
                    com.bytedance.sdk.openadsdk.core.kj.b bVarU = qqVarU.u(izVar.pn, izVar.b.nr());
                    if (bVarU == null || !bVarU.pn()) {
                        return;
                    }
                    bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.iz.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            iz.this.u((com.bytedance.sdk.openadsdk.core.l.u.nr) null, (Map<String, Object>) map);
                        }
                    });
                }
            });
        } else {
            u((com.bytedance.sdk.openadsdk.core.l.u.nr) null, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.l.u.nr nrVar, Map<String, Object> map) {
        try {
            if (nrVar == null) {
                u(map);
                this.q = false;
            } else {
                nr(nrVar, map);
                this.q = false;
            }
        } catch (Throwable unused) {
        }
    }

    private void u(final Map<String, Object> map, final boolean z) {
        int i = this.dw;
        if (i == 1) {
            jk.u(dw.getContext());
        } else if (i != 2) {
            u((com.bytedance.sdk.openadsdk.core.kj.b) null, map, z);
        } else {
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.l.fx.iz.4
                @Override // java.lang.Runnable
                public void run() {
                    qq<com.bytedance.sdk.openadsdk.core.s.u> qqVarU = dw.u();
                    iz izVar = iz.this;
                    com.bytedance.sdk.openadsdk.core.kj.b bVarU = qqVarU.u(izVar.pn, izVar.b.nr());
                    if (bVarU == null || !bVarU.pn()) {
                        jk.u(dw.getContext());
                    } else {
                        iz.this.u(bVarU, (Map<String, Object>) map, z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final com.bytedance.sdk.openadsdk.core.kj.b bVar, final Map<String, Object> map, final boolean z) {
        u(new com.bytedance.sdk.openadsdk.core.l.u.nr() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.iz.6
            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z2) {
                if (z2 && iz.this.u(bVar, (com.bytedance.sdk.openadsdk.core.l.u.nr) null, (Map<String, Object>) map, z)) {
                    return;
                }
                iz.this.u((com.bytedance.sdk.openadsdk.core.l.u.nr) null, (Map<String, Object>) map);
            }

            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
            }
        }, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(com.bytedance.sdk.openadsdk.core.kj.b bVar, final com.bytedance.sdk.openadsdk.core.l.u.nr nrVar, final Map<String, Object> map, boolean z) {
        com.bytedance.sdk.openadsdk.core.l.fx.fx.fx fxVarN = n();
        if (!fxVarN.b(z)) {
            return false;
        }
        if (u(getContext(), this.pn, this.iz)) {
            return true;
        }
        fxVarN.u(bVar, this.iz, this.b.nr(), new com.bytedance.sdk.openadsdk.core.l.fx.u.nr() { // from class: com.bytedance.sdk.openadsdk.core.l.fx.iz.7
            @Override // com.bytedance.sdk.openadsdk.core.l.fx.u.nr
            public void u() {
                if (!iz.this.fx()) {
                    iz.this.u(nrVar, (Map<String, Object>) map);
                } else {
                    iz.this.fx(true);
                    iz.this.u((Map<String, Object>) map, nrVar);
                }
            }
        });
        return true;
    }
}
