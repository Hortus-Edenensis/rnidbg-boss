package com.bytedance.sdk.openadsdk.core.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.nr;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoLandscapeActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.b.b;
import com.bytedance.sdk.openadsdk.core.component.reward.u.n;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.w;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.l.nr.u;
import com.bytedance.sdk.openadsdk.core.s.u;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.q;
import com.bytedance.sdk.openadsdk.core.y.rh;
import com.bytedance.sdk.openadsdk.gi.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationRewardManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.pn;
import com.bytedance.sdk.openadsdk.my.fx.nr.k;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.z.u.nr.u.u f5233a;
    private final com.bytedance.sdk.openadsdk.my.fx.fx.nr fx;
    private long iz;
    private com.bytedance.sdk.openadsdk.z.u.nr.u.nr jk;
    private boolean kj;
    private String l;
    private int mv;
    private String my;
    private com.bytedance.sdk.openadsdk.z.u.nr.u.u n;
    private final bc nr;
    private String o;
    private String pn;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.fx qq;
    private boolean s;
    private boolean sx;
    private com.bytedance.sdk.openadsdk.core.l.nr.u t;
    private final Context u;
    private final AtomicBoolean x = new AtomicBoolean(false);
    private int k = 1;
    private int bg = -1;
    private Double bq = null;
    private boolean dw = false;
    private boolean c = false;
    private long q = System.currentTimeMillis();
    private boolean b = false;

    public fx(Context context, bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        this.u = context;
        this.nr = bcVar;
        this.fx = nrVar;
        this.l = bcVar.hashCode() + bcVar.xx() + hashCode();
    }

    private void a() {
        com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar = this.n;
        if (uVar != null) {
            u.u(this.l, uVar);
        }
        if (this.f5233a != null) {
            u.u(w.u(this.l), this.f5233a);
        }
        if (this.jk != null) {
            fx(true);
            u.u(w.nr(this.l), this.jk);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.k
    public long b() {
        return this.iz;
    }

    public void iz() {
        if (this.nr == null || this.fx == null || this.s || this.kj || dw.nr().si() != 0) {
            return;
        }
        try {
            if (this.b) {
                n.u().u(this.fx);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.k
    public pn pn() {
        return new MediationRewardManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.k
    public Map<String, Object> x() {
        bc bcVar = this.nr;
        if (bcVar == null) {
            return null;
        }
        Map<String, Object> mapSj = bcVar.sj();
        mapSj.put("expireTimestamp", Long.valueOf(b()));
        mapSj.put("adSceneType", Integer.valueOf(b.u(this.nr)));
        return mapSj;
    }

    public void fx(int i) {
        this.bg = i;
    }

    public void nr(int i) {
        this.k = i;
    }

    public void u(boolean z) {
        this.kj = z;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.k
    public int fx() {
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

    public void nr(String str) {
        this.o = str;
    }

    public void u(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.fx fxVar) {
        this.qq = fxVar;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.k
    public void nr(com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar) {
        if (this.x.get()) {
            u.u(w.u(this.l), uVar);
        } else {
            this.f5233a = uVar;
        }
    }

    public void u() {
        if (this.x.get()) {
            return;
        }
        this.b = true;
    }

    public void u(int i) {
        this.mv = i;
    }

    public void fx(String str) {
        this.l = str;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.k
    public int nr() {
        bc bcVar = this.nr;
        if (bcVar == null) {
            return -1;
        }
        return bcVar.qf();
    }

    public void u(String str) {
        this.my = str;
    }

    public void fx(boolean z) {
        this.sx = z;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.k
    public void u(com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar) {
        if (this.x.get()) {
            u.u(this.l, uVar);
        } else {
            this.n = uVar;
        }
    }

    public void nr(boolean z) {
        this.s = z;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void nr(Double d) {
        this.bq = d;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.k
    public void u(com.bytedance.sdk.openadsdk.z.u.nr.u.nr nrVar) {
        if (this.x.get()) {
            fx(true);
            u.u(w.nr(this.l), nrVar);
        } else {
            this.jk = nrVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.k
    public void u(com.bytedance.sdk.openadsdk.my.fx.u.fx fxVar) {
        this.t = u.C0270u.u(fxVar);
    }

    public void u(long j) {
        this.iz = j;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.k
    public void u(Activity activity) {
        Intent intent;
        bc bcVar = this.nr;
        String strAp = bcVar != null ? bcVar.ap() : "";
        bc bcVar2 = this.nr;
        new u.C0284u().pn(bcVar2 != null ? bcVar2.lk() : "0").u("rewarded_video").nr("show_start").b(strAp).u((com.bytedance.sdk.openadsdk.iz.u.u) null);
        if (activity != null && activity.isFinishing()) {
            com.bytedance.sdk.component.utils.k.nr("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.x.get()) {
            return;
        }
        this.x.set(true);
        bc bcVar3 = this.nr;
        if (bcVar3 == null || zx.k(bcVar3) == null) {
            return;
        }
        if (nr() == 4) {
            x.u(new a("reward_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.fx.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.l.n.u(fx.this.u, fx.this.nr, "rewarded_video", false).u(fx.this.t);
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.nr.u().put("reward_video_show_time", System.currentTimeMillis());
        Context context = activity == null ? this.u : activity;
        if (context == null) {
            context = dw.getContext();
        }
        a();
        if (this.nr.sv() == 2) {
            intent = new Intent(context, (Class<?>) TTRewardVideoLandscapeActivity.class);
        } else {
            intent = new Intent(context, (Class<?>) TTRewardVideoActivity.class);
        }
        if (activity == null) {
            intent.addFlags(268435456);
        }
        if (this.s) {
            intent.putExtra("is_play_again", true);
            intent.putExtra("play_again_count", this.k);
        } else {
            this.mv = jp.t(this.nr);
        }
        if (this.kj) {
            intent.putExtra("is_second_page", true);
        }
        intent.putExtra("source_rit_id", this.mv);
        intent.putExtra("custom_play_again", this.sx);
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar = this.fx;
        if (nrVar != null) {
            intent.putExtra("media_extra", nrVar.mv());
            intent.putExtra("userData", this.fx.c());
            intent.putExtra("user_id", this.fx.s());
            intent.putExtra(MediationConstant.REWARD_NAME, this.fx.qq());
            intent.putExtra(MediationConstant.REWARD_AMOUNT, this.fx.kj());
            intent.putExtra("is_adm", !TextUtils.isEmpty(this.fx.dw()));
        }
        if (this.s && !TextUtils.isEmpty(this.my) && !TextUtils.isEmpty(this.o)) {
            intent.putExtra("reward_again_name", this.my);
            intent.putExtra("reward_again_amount", this.o);
        }
        intent.putExtra("is_preload", this.b);
        intent.putExtra("object_create_ts", this.q);
        Double d = this.bq;
        intent.putExtra("_client_bidding_aution_price", d != null ? String.valueOf(d) : "");
        if (!TextUtils.isEmpty(this.pn)) {
            intent.putExtra("rit_scene", this.pn);
        }
        int i = this.bg;
        if (i != -1) {
            intent.putExtra("key_video_cache_callback", i);
        }
        jp.u(intent, this.nr);
        intent.putExtra("multi_process_key", this.l);
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.fx fxVar = this.qq;
        if (fxVar != null) {
            intent.putExtra("insert_ad_bundle", fxVar.a().toString());
        }
        u(context, intent);
        com.bytedance.sdk.openadsdk.core.x.b.u().u(this.nr).u(7);
    }

    private void u(Context context, Intent intent) {
        com.bytedance.sdk.component.utils.nr.u(context, intent, new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.fx.2
            @Override // com.bytedance.sdk.component.utils.nr.u
            public void u() {
            }

            @Override // com.bytedance.sdk.component.utils.nr.u
            public void u(Throwable th) {
                com.bytedance.sdk.component.utils.k.u("TTRewardVideoAdImpl", "show reward video error: ", th);
            }
        });
        if (this.fx == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.u.u.u uVarU = com.bytedance.sdk.openadsdk.core.component.reward.u.u.u.u();
        com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar = this.fx;
        uVarU.u(nrVar, nrVar.b());
        if (w.u(this.nr)) {
            com.bytedance.sdk.openadsdk.core.component.reward.u.u.u.u().nr(this.fx, w.b(this.nr));
        }
        com.bytedance.sdk.openadsdk.core.component.reward.u.pn.u(true, this.s, this.kj).u(this.nr);
        iz();
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.k
    public void u(Activity activity, Object obj, String str) {
        if (obj == null) {
            com.bytedance.sdk.component.utils.k.nr("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        String strU = com.bytedance.sdk.openadsdk.core.bc.u.fx.u(obj);
        if ("customize_scenes".equalsIgnoreCase(strU)) {
            this.pn = str;
        } else {
            this.pn = strU;
        }
        u(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(Double d) {
        if (this.dw) {
            return;
        }
        rh.u(this.nr, d);
        this.dw = true;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(Double d, String str, String str2) {
        if (this.c) {
            return;
        }
        rh.u(this.nr, d, str, str2);
        this.c = true;
    }

    @Override // com.bytedance.sdk.openadsdk.my.fx.nr.n
    public void u(com.bytedance.sdk.openadsdk.my.fx.u.nr nrVar) {
        bc bcVar = this.nr;
        if (bcVar != null) {
            c.u(bcVar.dv(), nrVar, com.bytedance.sdk.openadsdk.my.fx.u.nr.class);
        }
    }
}
