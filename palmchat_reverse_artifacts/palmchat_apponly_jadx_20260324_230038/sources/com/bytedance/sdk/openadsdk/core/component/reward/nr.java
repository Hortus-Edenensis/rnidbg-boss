package com.bytedance.sdk.openadsdk.core.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.nr;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoLandscapeActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.b.b;
import com.bytedance.sdk.openadsdk.core.component.reward.u.pn;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.l.n;
import com.bytedance.sdk.openadsdk.core.l.nr.u;
import com.bytedance.sdk.openadsdk.core.s.u;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.q;
import com.bytedance.sdk.openadsdk.core.y.rh;
import com.bytedance.sdk.openadsdk.gi.x;
import com.bytedance.sdk.openadsdk.mediation.MediationFullScreenManagerDefault;
import com.bytedance.sdk.openadsdk.my.fx.nr.t;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends t {
    private String b;
    private com.bytedance.sdk.openadsdk.core.l.nr.u k;
    private com.bytedance.sdk.openadsdk.my.fx.fx.nr mv;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.fx my;
    private final bc nr;
    private boolean o;
    private long pn;
    private com.bytedance.sdk.openadsdk.q.u.nr.u.u s;
    private final Context u;
    private final String x;
    private final AtomicBoolean iz = new AtomicBoolean(false);
    private int n = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Double f5238a = null;
    private boolean jk = false;
    private boolean t = false;
    private long l = System.currentTimeMillis();
    private boolean fx = false;

    public nr(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        this.u = context;
        this.nr = bcVar;
        this.mv = nrVar;
        this.x = bcVar.hashCode() + bcVar.xx() + hashCode();
    }

    private void a() {
        com.bytedance.sdk.openadsdk.q.u.nr.u.u uVar = this.s;
        if (uVar != null) {
            u.u(this.x, uVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.t
    public Map<String, Object> b() {
        bc bcVar = this.nr;
        if (bcVar == null) {
            return null;
        }
        Map<String, Object> mapSj = bcVar.sj();
        mapSj.put("expireTimestamp", Long.valueOf(iz()));
        mapSj.put("adSceneType", Integer.valueOf(b.u(this.nr)));
        return mapSj;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.t
    public long iz() {
        return this.pn;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.t
    public int pn() {
        bc bcVar = this.nr;
        if (bcVar == null) {
            return -1;
        }
        if (q.fx(bcVar)) {
            return 2;
        }
        if (q.b(this.nr)) {
            return 1;
        }
        return com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.nr) ? 3 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.t
    public com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.fx x() {
        return new MediationFullScreenManagerDefault();
    }

    public void fx() {
        if (this.nr == null || this.mv == null || this.o || dw.nr().si() != 0) {
            return;
        }
        try {
            boolean z = this.fx;
            if (this.mv == null || !z) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.component.reward.u.nr.u().u(this.mv);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.t
    public int nr() {
        bc bcVar = this.nr;
        if (bcVar == null) {
            return -1;
        }
        return bcVar.qf();
    }

    public void u(boolean z) {
        this.o = z;
    }

    public void u(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.fx fxVar) {
        this.my = fxVar;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void nr(Double d) {
        this.f5238a = d;
    }

    public void u() {
        if (this.iz.get()) {
            return;
        }
        this.fx = true;
    }

    public void u(int i) {
        this.n = i;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.t
    public void u(com.bytedance.sdk.openadsdk.q.u.nr.u.u uVar) {
        if (this.iz.get()) {
            u.u(this.x, uVar);
        }
        this.s = uVar;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.t
    public void u(com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar) {
        this.k = u.C0270u.u(fxVar);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.t
    public void u(Activity activity) {
        Intent intent;
        bc bcVar = this.nr;
        String strAp = bcVar != null ? bcVar.ap() : "";
        bc bcVar2 = this.nr;
        new u.C0284u().pn(bcVar2 != null ? bcVar2.lk() : "0").u("fullscreen_interstitial_ad").nr("show_start").b(strAp).u((com.bytedance.sdk.openadsdk.iz.u.u) null);
        if (activity != null && activity.isFinishing()) {
            k.nr("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.iz.get()) {
            return;
        }
        this.iz.set(true);
        bc bcVar3 = this.nr;
        if (bcVar3 != null) {
            if (zx.k(bcVar3) == null && this.nr.zu() == null) {
                return;
            }
            if (nr() == 4) {
                x.u(new a("full_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.u(nr.this.u, nr.this.nr, "fullscreen_interstitial_ad", false).u(nr.this.k);
                    }
                });
            }
            com.bytedance.sdk.openadsdk.core.nr.u().get("full_video_show_time", System.currentTimeMillis());
            Context context = activity == null ? this.u : activity;
            if (context == null) {
                context = dw.getContext();
            }
            a();
            if (this.nr.sv() == 2) {
                intent = new Intent(context, (Class<?>) TTFullScreenVideoLandscapeActivity.class);
            } else {
                intent = new Intent(context, (Class<?>) TTFullScreenVideoActivity.class);
            }
            if (activity == null) {
                intent.addFlags(268435456);
            }
            if (this.mv != null) {
                intent.putExtra("is_adm", !TextUtils.isEmpty(r7.dw()));
            }
            intent.putExtra("is_preload", this.fx);
            intent.putExtra("object_create_ts", this.l);
            Double d = this.f5238a;
            intent.putExtra("_client_bidding_aution_price", d != null ? String.valueOf(d) : "");
            if (!TextUtils.isEmpty(this.b)) {
                intent.putExtra("rit_scene", this.b);
            }
            int i = this.n;
            if (i != -1) {
                intent.putExtra("key_video_cache_callback", i);
            }
            if (this.o) {
                intent.putExtra("is_second_page", true);
            }
            jp.u(intent, this.nr);
            intent.putExtra("multi_process_key", this.x);
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.fx fxVar = this.my;
            if (fxVar != null) {
                intent.putExtra("insert_ad_bundle", fxVar.a().toString());
            }
            u(context, intent);
            com.bytedance.sdk.openadsdk.core.x.b.u().u(this.nr).u(8);
        }
    }

    private void u(Context context, Intent intent) {
        com.bytedance.sdk.component.utils.nr.u(context, intent, new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.2
            @Override // com.bytedance.sdk.component.utils.nr.u
            public void u() {
            }

            @Override // com.bytedance.sdk.component.utils.nr.u
            public void u(Throwable th) {
                k.u("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
            }
        });
        if (this.mv == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.u.u.u uVarU = com.bytedance.sdk.openadsdk.core.component.reward.u.u.u.u();
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar = this.mv;
        uVarU.u(nrVar, nrVar.b());
        pn.u(false, false, this.o).u(this.nr);
        fx();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.t
    public void u(Activity activity, Object obj, String str) {
        if (obj == null) {
            k.nr("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        String strU = com.bytedance.sdk.openadsdk.core.bc.u.fx.u(obj);
        if ("customize_scenes".equalsIgnoreCase(strU)) {
            this.b = str;
        } else {
            this.b = strU;
        }
        u(activity);
    }

    public void u(long j) {
        this.pn = j;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(Double d) {
        if (this.jk) {
            return;
        }
        rh.u(this.nr, d);
        this.jk = true;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(Double d, String str, String str2) {
        if (this.t) {
            return;
        }
        rh.u(this.nr, d, str, str2);
        this.t = true;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(com.bytedance.sdk.openadsdk.my.fx.u.nr nrVar) {
        bc bcVar = this.nr;
        if (bcVar != null) {
            c.u(bcVar.dv(), nrVar, com.bytedance.sdk.openadsdk.my.fx.u.nr.class);
        }
    }
}
