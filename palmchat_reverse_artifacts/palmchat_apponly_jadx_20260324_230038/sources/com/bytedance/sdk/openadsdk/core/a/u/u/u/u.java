package com.bytedance.sdk.openadsdk.core.a.u.u.u;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bq;
import com.bytedance.sdk.openadsdk.core.l.a;
import com.bytedance.sdk.openadsdk.core.l.fx.jk;
import com.bytedance.sdk.openadsdk.core.qq;
import com.bytedance.sdk.openadsdk.core.y.wq;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u implements com.bytedance.sdk.openadsdk.core.a.u.u.u {
    protected com.bytedance.sdk.openadsdk.core.l.fx.fx.fx b;
    protected String fx;
    protected boolean iz;
    private bq jk;
    private volatile boolean l;
    private com.bytedance.sdk.openadsdk.core.a.u.u.u mv;
    protected DownloadStatusChangeListener n;
    protected Context nr;
    protected String pn;
    protected bc u;
    protected volatile boolean x = false;
    private int t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Function<SparseArray<Object>, Object> f5204a = com.bytedance.sdk.openadsdk.core.n.o().y();

    public static int fx(Map<String, Object> map) {
        if (map == null) {
            return 0;
        }
        Object obj = map.get("download_manager_hash_code");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    private boolean iz(Map<String, Object> map) {
        if (this.f5204a == null) {
            return true;
        }
        bq bqVar = this.jk;
        if (bqVar != null && bqVar.pn() == 1) {
            return true;
        }
        if (dw.nr().je()) {
            String str = "已下载%d%%，可在通知栏暂停或取消";
            try {
                DownloadStatusChangeListener downloadStatusChangeListener = this.n;
                if (downloadStatusChangeListener instanceof com.bytedance.sdk.openadsdk.core.l.u.fx) {
                    str = String.format("已下载%d%%，可在通知栏暂停或取消", Integer.valueOf(((com.bytedance.sdk.openadsdk.core.l.u.fx) downloadStatusChangeListener).getCurrentPercent()));
                }
            } catch (Exception unused) {
            }
            return u(map, str, true);
        }
        bq bqVar2 = this.jk;
        if (bqVar2 == null || !bqVar2.fx()) {
            return u(map, "应用正在下载...", false);
        }
        return true;
    }

    private void pn(Map<String, Object> map) {
        int iFx = fx(map);
        u(this.l, iFx);
        if (this.nr == null || TextUtils.isEmpty(this.pn) || !iz(map)) {
            return;
        }
        this.b.u(nr(iFx), this.u);
        wq<String, Object> wqVarU = new wq().u("downloadUrl", this.pn);
        wqVarU.put("is_feed_register_direct_download", map.get("is_feed_register_direct_download"));
        wqVarU.put("download_manager_hash_code", map.get("download_manager_hash_code"));
        com.bytedance.sdk.openadsdk.core.l.u.nr nrVarB = b(wqVarU);
        if (nrVarB == null || u((com.bytedance.sdk.openadsdk.core.kj.b) null, nrVarB, wqVarU)) {
            return;
        }
        u(true, iFx);
        u(wqVarU, nrVarB);
    }

    private void x(Map<String, Object> map) {
        if (this.f5204a != null) {
            int iFx = fx(map);
            if (map != null) {
                map.put("hashCode", Integer.valueOf(iFx));
            }
            this.f5204a.apply(com.bytedance.sdk.openadsdk.my.b.u().u(16).u(Void.class).u(0, map).nr());
        }
    }

    public abstract com.bytedance.sdk.openadsdk.core.l.u.nr b(Map<String, Object> map);

    public abstract boolean fx(int i);

    public abstract void nr(boolean z, int i);

    public boolean nr(Map<String, Object> map) {
        if (this.u.ar() || TextUtils.isEmpty(this.pn)) {
            return false;
        }
        if (o.fx(this.nr) != 0) {
            pn(map);
            return true;
        }
        try {
            Context context = this.nr;
            h.u(context, q.u(context, "tt_no_network"), 0);
        } catch (Exception unused) {
        }
        return true;
    }

    public abstract com.bytedance.sdk.openadsdk.core.l.u.pn u(Map<String, Object> map, wq<String, Object> wqVar);

    @Override // com.bytedance.sdk.openadsdk.core.a.u.u.u
    public boolean u(Map<String, Object> map) {
        if (u()) {
            return nr(map);
        }
        return false;
    }

    public boolean u() {
        return (this.u == null || this.nr == null || this.f5204a == null || TextUtils.isEmpty(this.pn) || TextUtils.isEmpty(this.fx) || this.b == null) ? false : true;
    }

    private void nr(com.bytedance.sdk.openadsdk.core.l.u.nr nrVar, Map<String, Object> map) {
        if (this.f5204a == null) {
            return;
        }
        wq<String, Object> wqVarU = new wq().u("itemClickListener", null).u("downloadButtonClickListener", com.bytedance.sdk.openadsdk.my.fx.b.u(nrVar)).u("hashCode", Integer.valueOf(fx(map))).u(map);
        wqVarU.put("itemClickListener", com.bytedance.sdk.openadsdk.my.fx.b.u(u(map, wqVarU)));
        this.f5204a.apply(com.bytedance.sdk.openadsdk.my.b.u().u(17).u(Void.class).u(0, wqVarU).nr());
    }

    private boolean u(Map<String, Object> map, final String str, final boolean z) {
        Object objApply = this.f5204a.apply(com.bytedance.sdk.openadsdk.my.b.u().u(6).u(Boolean.class).u(0, new wq().u("hashCode", Integer.valueOf(fx(map))).u("downloadUrl", this.pn)).nr());
        if (objApply == null || !((Boolean) objApply).booleanValue()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.u.1
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    h.nr(u.this.nr, str, 0, 17, 0, 0);
                } else {
                    h.u(u.this.nr, str, 0);
                }
            }
        });
        return false;
    }

    public com.bytedance.sdk.openadsdk.core.l.fx.fx.u nr(int i) {
        if (fx(i)) {
            return new com.bytedance.sdk.openadsdk.core.l.fx.fx.pn();
        }
        if (this.x) {
            return new com.bytedance.sdk.openadsdk.core.l.fx.fx.b();
        }
        return new com.bytedance.sdk.openadsdk.core.l.fx.fx.nr();
    }

    public void nr(boolean z) {
        this.iz = z;
    }

    private com.bytedance.sdk.openadsdk.core.l.u.nr nr(final com.bytedance.sdk.openadsdk.core.kj.b bVar, final Map<String, Object> map) {
        return new com.bytedance.sdk.openadsdk.core.l.u.nr() { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.u.5
            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z) {
                if (z && u.this.u(bVar, (com.bytedance.sdk.openadsdk.core.l.u.nr) null, map)) {
                    return;
                }
                u.this.u((com.bytedance.sdk.openadsdk.core.l.u.nr) null, map);
            }

            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
            }
        };
    }

    public boolean u(com.bytedance.sdk.openadsdk.core.kj.b bVar, final com.bytedance.sdk.openadsdk.core.l.u.nr nrVar, final Map<String, Object> map) {
        boolean zU = com.bytedance.sdk.openadsdk.core.a.u.b.u.u(map);
        final int iFx = fx(map);
        if (!this.b.b(zU)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.a.u.u.u uVar = this.mv;
        if (uVar != null && uVar.u(new HashMap())) {
            return true;
        }
        this.b.u(bVar, this.fx, this.pn, new com.bytedance.sdk.openadsdk.core.l.fx.u.nr() { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.u.2
            @Override // com.bytedance.sdk.openadsdk.core.l.fx.u.nr
            public void u() {
                if (!u.this.fx(iFx)) {
                    u.this.u(nrVar, map);
                } else {
                    u.this.u(true, iFx);
                    u.this.u((Map<String, Object>) map, nrVar);
                }
            }
        });
        return true;
    }

    public void u(boolean z, int i) {
        if (d.fx >= 5400 && fx(i)) {
            nr(z, i);
        }
    }

    public void u(boolean z) {
        this.x = z;
    }

    public void u(DownloadStatusChangeListener downloadStatusChangeListener) {
        this.n = downloadStatusChangeListener;
    }

    public void u(bq bqVar) {
        this.jk = bqVar;
    }

    public void u(int i) {
        this.t = i;
    }

    public void u(com.bytedance.sdk.openadsdk.core.a.u.u.u uVar) {
        this.mv = uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.l.u.nr nrVar) {
        a.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.u.3
            @Override // java.lang.Runnable
            public void run() {
                u.this.u(nrVar, map);
            }
        }, this.u);
        this.l = false;
    }

    public void u(com.bytedance.sdk.openadsdk.core.l.u.nr nrVar, Map<String, Object> map) {
        try {
            if (nrVar == null) {
                x(map);
                this.l = false;
            } else {
                nr(nrVar, map);
                this.l = false;
            }
        } catch (Throwable unused) {
        }
    }

    public void u(final Map<String, Object> map, final boolean z) {
        int i = this.t;
        if (i == 1) {
            jk.u(dw.getContext());
            return;
        }
        if (i == 2) {
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.a.u.u.u.u.4
                @Override // java.lang.Runnable
                public void run() {
                    qq<com.bytedance.sdk.openadsdk.core.s.u> qqVarU = dw.u();
                    u uVar = u.this;
                    com.bytedance.sdk.openadsdk.core.kj.b bVarU = qqVarU.u(uVar.u, uVar.pn);
                    if (bVarU == null || !bVarU.pn()) {
                        jk.u(dw.getContext());
                    } else if (z) {
                        u.this.u(bVarU, (Map<String, Object>) map);
                    } else {
                        u.this.u((com.bytedance.sdk.openadsdk.core.l.u.nr) null, map);
                    }
                }
            });
        } else if (z) {
            u((com.bytedance.sdk.openadsdk.core.kj.b) null, map);
        } else {
            u((com.bytedance.sdk.openadsdk.core.l.u.nr) null, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.bytedance.sdk.openadsdk.core.kj.b bVar, Map<String, Object> map) {
        u(nr(bVar, map), map);
    }
}
