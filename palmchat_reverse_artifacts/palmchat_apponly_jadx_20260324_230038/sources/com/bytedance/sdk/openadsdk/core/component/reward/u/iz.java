package com.bytedance.sdk.openadsdk.core.component.reward.u;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.kj.oa;
import com.bytedance.sdk.openadsdk.core.kj.ob;
import com.bytedance.sdk.openadsdk.core.kj.rh;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.w;
import com.bytedance.sdk.openadsdk.core.kj.wi;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.pn.nr;
import com.bytedance.sdk.openadsdk.core.qq;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.s.u;
import com.bytedance.sdk.openadsdk.core.ugeno.jk;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.q;
import com.bytedance.sdk.openadsdk.gi.t;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class iz<T> extends com.bytedance.sdk.openadsdk.core.pn.nr<T> {
    public iz(com.bytedance.sdk.openadsdk.core.pn.pn.nr nrVar) {
        super(nrVar);
    }

    public abstract void nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list, T t);

    @Override // com.bytedance.sdk.openadsdk.core.pn.nr, com.bytedance.sdk.openadsdk.core.pn.u.u
    public void u(int i, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, bc bcVar) {
    }

    public abstract void u(T t);

    public abstract boolean u();

    public abstract boolean u(com.bytedance.sdk.openadsdk.core.kj.u uVar);

    private void nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final bc bcVar, final com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVar) {
        if (zx.k(bcVar) == null) {
            return;
        }
        com.bykv.vk.openvk.component.video.api.fx.iz izVarU = zx.u(1, bcVar);
        izVarU.u("material_meta", bcVar);
        izVarU.u("ad_slot", nrVar);
        com.bytedance.sdk.openadsdk.core.video.b.nr.u(izVarU, new com.bykv.vk.openvk.component.video.api.pn.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.iz.3
            @Override // com.bykv.vk.openvk.component.video.api.pn.u.InterfaceC0155u
            public void u(com.bykv.vk.openvk.component.video.api.fx.iz izVar, int i) {
                com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVar2 = fxVar;
                if (fxVar2 != null) {
                    fxVar2.nr();
                }
            }

            @Override // com.bykv.vk.openvk.component.video.api.pn.u.InterfaceC0155u
            public void u(com.bykv.vk.openvk.component.video.api.fx.iz izVar, int i, String str) {
                com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVar2;
                if (zx.mv(bcVar) && (fxVar2 = fxVar) != null) {
                    fxVar2.nr();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.nr, com.bytedance.sdk.openadsdk.core.pn.u.u
    public boolean u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list) {
        bc bcVar = list.get(0);
        if (!com.bytedance.sdk.openadsdk.core.pn.pn.u(nrVar, bcVar, u())) {
            return false;
        }
        new u.C0284u().pn(bcVar.lk()).u(u() ? "rewarded_video" : "fullscreen_interstitial_ad").b(bcVar.ap()).nr("get_preload_ad").u(new com.bytedance.sdk.openadsdk.iz.u.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.iz.1
            @Override // com.bytedance.sdk.openadsdk.iz.u.u
            public void u(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                if (nrVar.q() != null) {
                    int iU = com.bytedance.sdk.openadsdk.core.bc.u.b.u(nrVar.q());
                    if (iU == 1) {
                        jSONObject2.put("req_type", 1);
                    } else if (iU != 3) {
                        jSONObject2.put("req_type", -1);
                    } else {
                        jSONObject2.put("req_type", 3);
                    }
                }
                jSONObject2.put("preload_ad_type", 2);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.nr, com.bytedance.sdk.openadsdk.core.pn.u.u
    public void u(int i, final List<bc> list, final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, final com.bytedance.sdk.openadsdk.core.pn.pn.pn<T> pnVar, Bundle bundle, final com.bytedance.sdk.openadsdk.core.pn.pn.x xVar) {
        final boolean z = bundle.getBoolean("is_cache", false);
        final boolean z2 = bundle.getBoolean("is_playAgain", false);
        final long j = bundle.getLong(f.p);
        final boolean z3 = bundle.getBoolean("is_second_page_ad", false);
        final bc bcVar = list.get(0);
        u(nrVar, list, (nr.u) new nr.u<T>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.iz.2
            @Override // com.bytedance.sdk.openadsdk.core.pn.nr.u
            public void u(final T t) {
                for (bc bcVar2 : list) {
                    bcVar2.pm().nr();
                    bcVar2.n(z);
                    bcVar2.oa(z ? 101 : 102);
                }
                iz.this.nr(nrVar, list, t);
                com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVar = new com.bytedance.sdk.openadsdk.core.pn.pn.fx() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.iz.2.1
                    private final AtomicBoolean fx = new AtomicBoolean(false);

                    @Override // com.bytedance.sdk.openadsdk.core.pn.pn.fx
                    public void fx() {
                        if (this.fx.compareAndSet(false, true)) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            iz.this.u(z, nrVar, (List<bc>) list);
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.bytedance.sdk.openadsdk.core.pn.pn.fx
                    public void nr() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (j != 0) {
                            com.bytedance.sdk.openadsdk.core.s.b.nr(bcVar, jp.nr(iz.this.u() ? 7 : 8), j);
                        }
                        iz.this.u(t);
                        com.bytedance.sdk.openadsdk.core.pn.pn.pn pnVar2 = pnVar;
                        if (pnVar2 != 0) {
                            pnVar2.u(t);
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.bytedance.sdk.openadsdk.core.pn.pn.fx
                    public void u() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (!z2 && !z3) {
                            iz.this.u(nrVar, (List<bc>) list, t);
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("is_play_again", z2);
                            jSONObject.put("is_second_page_ad", z3);
                            jSONObject.put("is_from_cache", z);
                            jSONObject.put("is_adm", !TextUtils.isEmpty(nrVar.dw()));
                            jSONObject.put("cache_strategy", pn.u(iz.this.u()));
                            jSONObject.put("src_req_id", bcVar.ls());
                            jSONObject.put("is_map", bcVar.la());
                            jSONObject.put("load_duration", System.currentTimeMillis() - j);
                            jSONObject.put("reward_full_scene_type", com.bytedance.sdk.openadsdk.core.component.reward.b.b.u(bcVar));
                        } catch (JSONException unused) {
                        }
                        s.u().u(bcVar, "stats_reward_full_ad_loaded", jSONObject);
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        com.bytedance.sdk.openadsdk.core.pn.pn.pn pnVar2 = pnVar;
                        if (pnVar2 != 0) {
                            pnVar2.u(t, z);
                        }
                        AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                        iz.this.u(nrVar, bcVar, this);
                    }
                };
                com.bytedance.sdk.openadsdk.core.pn.pn.x xVar2 = xVar;
                if (xVar2 != null) {
                    xVar2.u(fxVar);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.nr, com.bytedance.sdk.openadsdk.core.pn.u.u
    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, int i, String str, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2) {
        if (nrVar != null) {
            u(nrVar.b(), i, str, nrVar2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.nr, com.bytedance.sdk.openadsdk.core.pn.u.u
    public void u(int i, com.bytedance.sdk.openadsdk.core.kj.u uVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar, oa oaVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar2, com.bytedance.sdk.openadsdk.core.pn.pn.pn pnVar, com.bytedance.sdk.openadsdk.core.pn.pn.x xVar) {
        if (uVar.nr() == null || uVar.nr().isEmpty()) {
            if (xVar != null) {
                xVar.u(-3);
                return;
            }
            return;
        }
        Bundle bundle = oaVar == null ? null : oaVar.k;
        boolean z = bundle != null && bundle.getBoolean("is_preload", false);
        boolean z2 = bundle != null && bundle.getBoolean("is_playAgain", false);
        long j = bundle != null ? bundle.getLong(f.p, 0L) : 0L;
        boolean z3 = bundle != null && bundle.getBoolean("is_second_page_ad", false);
        uVar.nr().size();
        bc bcVar = uVar.nr().get(0);
        if (u(nrVar2.b(), bcVar)) {
            return;
        }
        if (!bcVar.fq() || u(uVar)) {
            if (xVar != null) {
                xVar.u(-4);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (uVar.nr().size() > 1 && com.bytedance.sdk.openadsdk.core.kj.n.u(i).u("mix_ad", nrVar2, uVar.nr().get(0))) {
            com.bytedance.sdk.openadsdk.core.u.u(uVar.nr());
            arrayList.add(uVar.nr().get(0));
        } else {
            arrayList.addAll(uVar.nr());
        }
        if (z) {
            com.bytedance.sdk.openadsdk.core.pn.pn.nr nrVar3 = this.u;
            if (nrVar3 != null) {
                nrVar3.u().u(nrVar2, bcVar);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cache_strategy", pn.u(u()));
                jSONObject.put("src_req_id", bcVar.ls());
                jSONObject.put("is_map", bcVar.la());
                jSONObject.put("reward_full_scene_type", com.bytedance.sdk.openadsdk.core.component.reward.b.b.u(bcVar));
            } catch (Exception unused) {
            }
            s.u().u(bcVar, "stats_reward_full_preload", jSONObject);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong(f.p, j);
        bundle2.putBoolean("is_playAgain", z2);
        bundle2.putBoolean("is_cache", false);
        bundle2.putBoolean("is_second_page_ad", z3);
        u(i, arrayList, nrVar2, pnVar, bundle2, xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, int i, String str2, com.bytedance.sdk.openadsdk.core.kj.nr nrVar) {
        nrVar.u(i);
        nrVar.nr(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cache_strategy", pn.u(u()));
            jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.n.o().c());
            jSONObject.put("rit", str);
        } catch (Exception unused) {
        }
        nrVar.u(jSONObject);
        com.bytedance.sdk.openadsdk.core.kj.nr.u(nrVar);
    }

    public void u(bc bcVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        nrVar.b();
        try {
            rh rhVarDd = bcVar.dd();
            if (rhVarDd != null && !TextUtils.isEmpty(rhVarDd.u())) {
                com.bytedance.sdk.openadsdk.core.gi.fx fxVar = new com.bytedance.sdk.openadsdk.core.gi.fx(true);
                fxVar.u(nrVar.b());
                fxVar.u(8);
                fxVar.fx(bcVar.lk());
                fxVar.b(bcVar.ap());
                fxVar.nr(jp.k(bcVar));
                com.bytedance.sdk.openadsdk.n.nr.u(rhVarDd).to(fxVar);
            }
        } catch (Throwable unused) {
        }
        if (tk.jk(bcVar) && tk.iz(bcVar) != null) {
            jk.u(tk.iz(bcVar).a(), tk.iz(bcVar).jk(), (com.bytedance.sdk.openadsdk.core.ugeno.fx) null);
        }
        if (u()) {
            for (ob obVar : yd.bq(bcVar)) {
                jk.u(obVar.b(), obVar.pn(), (com.bytedance.sdk.openadsdk.core.ugeno.fx) null);
            }
            for (ob obVar2 : w.pn(bcVar)) {
                jk.u(obVar2.b(), obVar2.pn(), (com.bytedance.sdk.openadsdk.core.ugeno.fx) null);
            }
        }
        if (TextUtils.isEmpty(wi.t(bcVar))) {
            return;
        }
        jk.u(wi.t(bcVar), wi.l(bcVar), (com.bytedance.sdk.openadsdk.core.ugeno.fx) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.nr
    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list, T t) {
        bc bcVar = list.get(0);
        com.bytedance.sdk.openadsdk.core.pn.pn.nr nrVar2 = this.u;
        if (nrVar2 != null) {
            nrVar2.u().u(nrVar, bcVar, t, bcVar.ah());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u.u
    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, bc bcVar, com.bytedance.sdk.openadsdk.core.pn.pn.fx fxVar) {
        u(bcVar, nrVar);
        if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(bcVar)) {
            com.bytedance.sdk.openadsdk.core.video.fx.u.nr(bcVar);
            fxVar.nr();
            return;
        }
        if (!yd.fx(bcVar, true)) {
            fxVar.nr();
            return;
        }
        if (q.fx(bcVar)) {
            if (bg.u(bcVar) && t.u(bcVar)) {
                nr(nrVar, bcVar, fxVar);
                return;
            } else {
                fxVar.nr();
                return;
            }
        }
        if (!bc.nr(bcVar) && !t.u(bcVar)) {
            fxVar.nr();
        } else {
            nr(nrVar, bcVar, fxVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(String str, bc bcVar) {
        if (!dw.nr().nr(str) || bcVar == null) {
            return false;
        }
        int i = u() ? 7 : 8;
        bc bcVarNr = com.bytedance.sdk.openadsdk.core.component.reward.u.u.u.u().nr(u(), str);
        if (bcVarNr == null) {
            return false;
        }
        if (bcVarNr.bc() + bcVarNr.gi() < System.currentTimeMillis()) {
            com.bytedance.sdk.openadsdk.core.pn.b.pn.u(i).u(str);
            return true;
        }
        if (!TextUtils.equals(bcVarNr.m(), bcVar.m())) {
            if (com.bytedance.sdk.openadsdk.core.u.u(bcVar, u() ? 7 : 8) != 200) {
                return true;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(bcVar.xg());
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.get(next);
                bcVarNr.tq().put(next, jSONObject.get(next));
            }
            bcVarNr.q(bcVarNr.tq().toString());
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.u.u
    public void u(final com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        if (dw.nr().nr(nrVar.b())) {
            oa oaVar = new oa();
            oaVar.u = 2;
            if (dw.nr().a(nrVar.b()) || nrVar.n() > 0.0f) {
                oaVar.iz = 2;
            }
            dw.u().nr(nrVar, oaVar, u() ? 7 : 8, new qq.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.iz.4
                @Override // com.bytedance.sdk.openadsdk.core.qq.nr
                public void u(int i, String str, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2) {
                    nrVar2.u(i);
                    nrVar2.nr(str);
                    com.bytedance.sdk.openadsdk.core.kj.nr.u(nrVar2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.qq.nr
                public void u(com.bytedance.sdk.openadsdk.core.kj.u uVar, com.bytedance.sdk.openadsdk.core.kj.nr nrVar2) {
                    if (uVar.nr() == null || uVar.nr().isEmpty()) {
                        iz.this.u(nrVar.b(), -3, com.bytedance.sdk.openadsdk.core.x.u(-3), nrVar2);
                        return;
                    }
                    bc bcVar = uVar.nr().get(0);
                    if (iz.this.u(nrVar.b(), bcVar)) {
                        return;
                    }
                    if (!bcVar.fq() || iz.this.u(uVar)) {
                        iz.this.u(nrVar.b(), -4, com.bytedance.sdk.openadsdk.core.x.u(-4), nrVar2);
                        return;
                    }
                    if (uVar.nr().size() > 1) {
                        if (com.bytedance.sdk.openadsdk.core.kj.n.u(iz.this.u() ? 7 : 8).u("mix_ad", nrVar, bcVar)) {
                            com.bytedance.sdk.openadsdk.core.u.u(uVar.nr());
                        }
                    }
                    if (((com.bytedance.sdk.openadsdk.core.pn.nr) iz.this).u != null) {
                        ((com.bytedance.sdk.openadsdk.core.pn.nr) iz.this).u.u().u(nrVar, bcVar);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("cache_strategy", pn.u(iz.this.u()));
                        jSONObject.put("src_req_id", bcVar.ls());
                        jSONObject.put("is_map", bcVar.la());
                    } catch (Exception unused) {
                    }
                    s.u().u(bcVar, "stats_reward_full_preload", jSONObject);
                }
            });
        }
    }
}
