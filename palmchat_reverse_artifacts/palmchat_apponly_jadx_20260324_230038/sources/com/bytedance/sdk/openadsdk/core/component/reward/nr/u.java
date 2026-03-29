package com.bytedance.sdk.openadsdk.core.component.reward.nr;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.l.b.fx;
import com.bytedance.sdk.openadsdk.core.l.n;
import com.bytedance.sdk.openadsdk.core.multipro.nr.u;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.y.jp;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private TTBaseVideoActivity b;
    private String iz;
    private bc pn;
    com.bytedance.sdk.openadsdk.core.l.nr.fx u;
    private String x;
    View nr = null;
    final Map<String, com.bytedance.sdk.openadsdk.core.l.nr.fx> fx = DesugarCollections.synchronizedMap(new HashMap());
    private long n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5242a = 0;
    private long jk = 0;
    private long t = 0;
    private long l = 0;
    private long mv = 0;
    private boolean k = true;
    private final fx my = new fx();
    private boolean s = false;

    /* JADX INFO: compiled from: SearchBox */
    public class fx implements DownloadListener {
        private boolean nr = true;

        public fx() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            u(this.nr);
            u.this.u(str, true);
            u.this.b.u(1);
        }

        public void u(boolean z) {
            this.nr = z;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        void fx(boolean z, long j, long j2, String str, String str2);

        void nr(boolean z, long j, long j2, String str, String str2);

        void u(boolean z);

        void u(boolean z, long j, long j2, String str, String str2);

        void u(boolean z, long j, String str, String str2);

        void u(boolean z, String str, String str2);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.reward.nr.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0248u {
        void u(View view, jk jkVar);

        void u(String str, JSONObject jSONObject);
    }

    public u(TTBaseVideoActivity tTBaseVideoActivity) {
        this.b = tTBaseVideoActivity;
    }

    private void n() {
        bc bcVar = this.pn;
        if (bcVar == null || bcVar.qf() != 4) {
            return;
        }
        this.u = n.u((Context) this.b, this.pn, this.iz, false);
    }

    public fx x() {
        return this.my;
    }

    public void b() {
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.u(this.b);
            this.u.u();
        }
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.l.nr.fx> entry : this.fx.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().u();
            }
        }
    }

    public boolean fx() {
        return this.u != null;
    }

    public void iz() {
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.nr();
        }
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.l.nr.fx> entry : this.fx.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().nr();
            }
        }
        try {
            u(this.x);
        } catch (Throwable th) {
            k.u("RewardFullDownloadManager", "remove from ITTAppDownloadListener throw Exception : ", th);
        }
    }

    public com.bytedance.sdk.openadsdk.core.l.nr.fx nr() {
        return this.u;
    }

    public void pn() {
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.l.nr.fx> entry : this.fx.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue();
            }
        }
    }

    public void u(bc bcVar, String str, String str2) {
        if (this.s) {
            return;
        }
        this.s = true;
        this.pn = bcVar;
        this.iz = str;
        n();
        this.x = str2;
    }

    public void u() {
        bc bcVar;
        if (this.u == null && (bcVar = this.pn) != null && bcVar.qf() == 4) {
            this.u = n.u((Context) this.b, this.pn, this.iz, false);
        }
    }

    private void u(final String str) {
        x.nr(new a("executeMultiProcessAppDownloadCallBack") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.u.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    u.this.u(3).u(str, "recycleRes", 0L, 0L, "", "");
                } catch (Throwable th) {
                    k.u("RewardFullDownloadManager", "executeAppDownloadCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    public s u(int i) {
        return s.u.u(com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u(dw.getContext()).u(i));
    }

    public void u(final nr nrVar) {
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.u;
        if (fxVar == null) {
            return;
        }
        fxVar.u(new com.bytedance.sdk.openadsdk.core.l.nr.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.u.2
            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void fx(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - u.this.t > NativeExpressView.bg) {
                    u.this.t = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                nr nrVar2 = nrVar;
                if (nrVar2 != null) {
                    nrVar2.fx(z, j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void nr(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - u.this.f5242a > NativeExpressView.bg) {
                    u.this.f5242a = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                nr nrVar2 = nrVar;
                if (nrVar2 != null) {
                    nrVar2.nr(z, j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u() {
                boolean z;
                if (System.currentTimeMillis() - u.this.n > NativeExpressView.bg) {
                    u.this.n = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                nr nrVar2 = nrVar;
                if (nrVar2 != null) {
                    nrVar2.u(z);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - u.this.jk > NativeExpressView.bg) {
                    u.this.jk = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                nr nrVar2 = nrVar;
                if (nrVar2 != null) {
                    nrVar2.u(z, j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(long j, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - u.this.l > NativeExpressView.bg) {
                    u.this.l = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                nr nrVar2 = nrVar;
                if (nrVar2 != null) {
                    nrVar2.u(z, j, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.l.nr.u
            public void u(String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - u.this.mv > NativeExpressView.bg) {
                    u.this.mv = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                nr nrVar2 = nrVar;
                if (nrVar2 != null) {
                    nrVar2.u(z, str, str2);
                }
            }
        });
    }

    public void u(String str, boolean z) {
        if (this.fx.containsKey(str)) {
            com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.fx.get(str);
            if (fxVar != null) {
                if (z) {
                    fxVar.u(com.bytedance.sdk.openadsdk.core.l.fx.jk.u(this.pn));
                }
                if (fxVar instanceof com.bytedance.sdk.openadsdk.core.l.fx.pn) {
                    ((com.bytedance.sdk.openadsdk.core.l.fx.pn) fxVar).n().u(this.k);
                } else if (fxVar instanceof com.bytedance.sdk.openadsdk.core.l.fx.n) {
                    ((com.bytedance.sdk.openadsdk.core.l.fx.n) fxVar).iz().u(this.k);
                }
                fxVar.u(jp.dw(this.pn), false);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVarU = n.u(this.b, str, this.pn, this.iz);
        if (z) {
            fxVarU.u(com.bytedance.sdk.openadsdk.core.l.fx.jk.u(this.pn));
        }
        if (fxVarU instanceof com.bytedance.sdk.openadsdk.core.l.fx.pn) {
            ((com.bytedance.sdk.openadsdk.core.l.fx.pn) fxVarU).n().u(this.k);
        } else if (fxVarU instanceof com.bytedance.sdk.openadsdk.core.l.fx.n) {
            ((com.bytedance.sdk.openadsdk.core.l.fx.n) fxVarU).iz().u(this.k);
        }
        this.fx.put(str, fxVarU);
        fxVarU.u(jp.dw(this.pn), false);
    }

    public void u(final InterfaceC0248u interfaceC0248u) {
        this.u.u(1, new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.u.3
            @Override // com.bytedance.sdk.openadsdk.core.l.b.fx.u
            public boolean u(int i, String str, String str2, String str3, Object obj) {
                if (i == 1 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if ((str2.equals("rewarded_video") || str2.equals("fullscreen_interstitial_ad")) && str3.equals("click_start")) {
                        interfaceC0248u.u(u.this.nr, new jk());
                        u.this.nr = null;
                        return true;
                    }
                    if (str2.equals("fullscreen_interstitial_ad") || str2.equals("rewarded_video")) {
                        str3.hashCode();
                        if (str3.equals("click_continue")) {
                            com.bytedance.sdk.openadsdk.core.s.b.nr(u.this.pn, str2, "click_play_continue", (Map<String, Object>) null);
                        } else if (str3.equals("click_pause")) {
                            com.bytedance.sdk.openadsdk.core.s.b.nr(u.this.pn, str2, "click_play_pause", (Map<String, Object>) null);
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            }
        });
    }

    public void u(View view, InterfaceC0248u interfaceC0248u, jk jkVar) {
        if (this.u != null && view != null) {
            if (view.getId() == 2114387609) {
                interfaceC0248u.u("click_play_star_level", (JSONObject) null);
                return;
            }
            if (view.getId() == 2114387630) {
                interfaceC0248u.u("click_play_star_nums", (JSONObject) null);
                return;
            } else if (view.getId() == 2114387875) {
                interfaceC0248u.u("click_play_source", (JSONObject) null);
                return;
            } else {
                if (view.getId() == 2114387793) {
                    interfaceC0248u.u("click_play_logo", (JSONObject) null);
                    return;
                }
                return;
            }
        }
        interfaceC0248u.u(view, jkVar);
    }

    public void u(u.InterfaceC0273u interfaceC0273u) {
        com.bytedance.sdk.openadsdk.core.l.nr.fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.u(interfaceC0273u);
        }
    }
}
