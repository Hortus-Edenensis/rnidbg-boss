package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.baidu.location.LocationConst;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.rh;
import com.bytedance.sdk.openadsdk.a.u.nr;
import com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.component.reward.b.n;
import com.bytedance.sdk.openadsdk.core.component.reward.b.x;
import com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.fx;
import com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u;
import com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardAuthToastLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardFullBaseLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.nr.b;
import com.bytedance.sdk.openadsdk.core.component.reward.nr.fx;
import com.bytedance.sdk.openadsdk.core.component.reward.nr.iz;
import com.bytedance.sdk.openadsdk.core.component.reward.nr.pn;
import com.bytedance.sdk.openadsdk.core.component.reward.nr.u;
import com.bytedance.sdk.openadsdk.core.component.reward.view.saas.SaasAuthRewardDialog;
import com.bytedance.sdk.openadsdk.core.dislike.ui.nr;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.a;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.kj.gi;
import com.bytedance.sdk.openadsdk.core.kj.ja;
import com.bytedance.sdk.openadsdk.core.kj.jk;
import com.bytedance.sdk.openadsdk.core.kj.q;
import com.bytedance.sdk.openadsdk.core.kj.w;
import com.bytedance.sdk.openadsdk.core.kj.wi;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.multipro.nr.u;
import com.bytedance.sdk.openadsdk.core.n.nr;
import com.bytedance.sdk.openadsdk.core.nativeexpress.kj;
import com.bytedance.sdk.openadsdk.core.nr.u.fx.fx;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.s.u;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.a;
import com.bytedance.sdk.openadsdk.core.video.nr.u;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.xg;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.gi.t;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.huawei.openalliance.ad.constant.be;
import com.ss.bytertc.engine.type.ErrorCode;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class TTBaseVideoActivity extends BaseThemeActivity implements rh.u, nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final AtomicBoolean f5219a;
    protected u.InterfaceC0302u ay;
    protected final ConcurrentHashMap<Integer, Boolean> b;
    protected TTBaseVideoActivity bc;
    pn bf;
    protected final AtomicBoolean bg;
    protected final AtomicBoolean bq;
    protected boolean c;
    protected String cj;
    RewardFullBaseLayout d;
    private long dc;
    private AtomicBoolean dj;
    protected final AtomicBoolean dw;
    protected final com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u eh;
    private long f;
    protected final AtomicBoolean fx;
    protected final com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u gc;
    private u.InterfaceC0248u ge;
    protected int gi;
    com.bytedance.sdk.openadsdk.core.component.reward.layout.nr h;
    private com.bytedance.sdk.openadsdk.gi.u i;
    protected final ConcurrentHashMap<Integer, Boolean> iz;
    AbstractEndCardFrameLayout ja;
    protected final AtomicBoolean jk;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    protected fx f5220jp;
    private int ju;
    private int jw;
    protected final AtomicBoolean k;
    protected long kj;
    private int kw;
    protected final AtomicBoolean l;
    protected final com.bytedance.sdk.openadsdk.core.component.reward.business.fx.u lf;
    b m;
    protected com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fx mh;
    private final AtomicBoolean mk;
    protected final AtomicBoolean mv;
    protected final AtomicBoolean my;
    protected final AtomicBoolean n;
    protected final com.bytedance.sdk.openadsdk.core.component.reward.business.fx.nr nb;
    protected final rh nr;
    protected final AtomicBoolean o;
    protected int oa;
    private float ob;
    private boolean p;
    com.bytedance.sdk.openadsdk.core.component.reward.nr.u pb;
    protected boolean q;
    private final u.InterfaceC0273u qe;
    protected boolean qq;
    private nr.u rg;
    com.bytedance.sdk.openadsdk.core.component.reward.layout.pn rh;
    private u.nr rv;
    protected final AtomicBoolean s;
    private com.bytedance.sdk.openadsdk.core.component.reward.pn.b sf;
    protected com.bytedance.sdk.openadsdk.core.nr.pn su;
    protected final AtomicBoolean sx;
    protected final AtomicBoolean t;
    protected com.bytedance.sdk.openadsdk.core.dislike.ui.nr tk;
    private com.bytedance.sdk.openadsdk.core.nr.nr tm;
    protected final String u;
    private long ua;
    private Double uq;
    protected com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u v;
    protected String w;
    protected int wi;
    com.bytedance.sdk.openadsdk.core.component.reward.nr.nr wq;
    public final AtomicBoolean x;
    iz xg;
    protected com.bytedance.sdk.openadsdk.core.component.reward.pn.fx xw;
    protected com.bytedance.sdk.openadsdk.core.component.reward.b.u y;
    protected com.bytedance.sdk.openadsdk.core.playable.nr.nr yd;
    protected boolean z;
    private long za;
    private int zx;

    public TTBaseVideoActivity() {
        this.u = kj() ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.nr = new rh(Looper.getMainLooper(), this);
        this.fx = new AtomicBoolean(false);
        this.b = new ConcurrentHashMap<>();
        this.iz = new ConcurrentHashMap<>();
        this.x = new AtomicBoolean(false);
        this.n = new AtomicBoolean(false);
        this.f5219a = new AtomicBoolean(false);
        this.mk = new AtomicBoolean(false);
        this.jk = new AtomicBoolean(false);
        this.t = new AtomicBoolean(false);
        this.l = new AtomicBoolean(false);
        this.mv = new AtomicBoolean(false);
        this.s = new AtomicBoolean(false);
        this.k = new AtomicBoolean(false);
        this.my = new AtomicBoolean(false);
        this.o = new AtomicBoolean(false);
        this.sx = new AtomicBoolean(false);
        this.bg = new AtomicBoolean(false);
        this.bq = new AtomicBoolean(false);
        this.dw = new AtomicBoolean(false);
        this.gi = -1;
        this.f = 0L;
        this.za = 0L;
        this.ju = 1;
        this.uq = null;
        this.dc = 0L;
        this.ay = new u.InterfaceC0302u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
            public void fx() {
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fx fxVar = TTBaseVideoActivity.this.mh;
                if (fxVar == null || fxVar.u() == null) {
                    return;
                }
                TTBaseVideoActivity.this.mh.u().u();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
            public void nr() {
                TTBaseVideoActivity.this.nr.removeMessages(300);
                TTBaseVideoActivity.this.my();
                TTBaseVideoActivity.this.u(false, false);
                TTBaseVideoActivity.this.xg.u(6);
                TTBaseVideoActivity.this.xg.a();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
            public void u() {
                TTBaseVideoActivity.this.nr.removeMessages(300);
                TTBaseVideoActivity.this.my();
                if (!TTBaseVideoActivity.this.xg.l()) {
                    iz izVar = TTBaseVideoActivity.this.xg;
                    izVar.nr(izVar.rh() + 1000);
                }
                if (TTBaseVideoActivity.this.y.iz() && !TTBaseVideoActivity.this.xg.l()) {
                    TTBaseVideoActivity.this.rh.nr(true);
                }
                TTBaseVideoActivity.this.gc();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
            public void u(int i, String str) {
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                if (tTBaseVideoActivity.q) {
                    tTBaseVideoActivity.nr.removeMessages(300);
                    TTBaseVideoActivity.this.mv();
                    TTBaseVideoActivity.this.xg.u(5);
                    TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                    tTBaseVideoActivity2.nr(tTBaseVideoActivity2.xg.nr());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.u.InterfaceC0302u
            public void u(long j, long j2) {
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                if (!tTBaseVideoActivity.q && tTBaseVideoActivity.xg.nr()) {
                    TTBaseVideoActivity.this.xg.u((Map<String, Object>) null);
                }
                boolean z = true;
                if (TTBaseVideoActivity.this.wq.pb()) {
                    TTBaseVideoActivity.this.xg.fx(true);
                    return;
                }
                TTBaseVideoActivity.this.nr.removeMessages(300);
                if (j != TTBaseVideoActivity.this.xg.rh()) {
                    TTBaseVideoActivity.this.my();
                }
                if (TTBaseVideoActivity.this.xg.nr() || j2 == j) {
                    TTBaseVideoActivity.this.xg.nr(j);
                    if (TTBaseVideoActivity.this.i()) {
                        TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                        com.bytedance.sdk.openadsdk.core.component.reward.layout.pn pnVar = tTBaseVideoActivity2.rh;
                        String strValueOf = String.valueOf(tTBaseVideoActivity2.xg.h());
                        int iRh = (int) (TTBaseVideoActivity.this.xg.rh() / 1000);
                        if (j != j2 && !TTBaseVideoActivity.this.xg.bf()) {
                            z = false;
                        }
                        pnVar.u(strValueOf, iRh, 0, z);
                    }
                    TTBaseVideoActivity.this.fx(0);
                    TTBaseVideoActivity.this.w();
                    TTBaseVideoActivity.this.y.bq();
                }
            }
        };
        this.v = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.12
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void b() {
                TTBaseVideoActivity.this.y.cj().b();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public int fx() {
                return TTBaseVideoActivity.this.y.cj().fx();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void iz() {
                TTBaseVideoActivity.this.y.cj().iz();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public int nr() {
                return TTBaseVideoActivity.this.y.cj().nr();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void pn() {
                TTBaseVideoActivity.this.y.cj().pn();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void setPauseFromExpressView(boolean z) {
                TTBaseVideoActivity.this.y.cj().setPauseFromExpressView(z);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
            public void u(ViewGroup viewGroup) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void fx(int i) {
                TTBaseVideoActivity.this.fx(i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void nr(int i) {
                TTBaseVideoActivity.this.y.cj().nr(i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void u(int i) {
                TTBaseVideoActivity.this.y.cj().u(i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
            public void nr(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar) {
                jk jkVar;
                if ((i == 1 || i == 2) && (fxVar instanceof q)) {
                    q qVar = (q) fxVar;
                    jkVar = new jk();
                    jkVar.u(qVar.u);
                    jkVar.nr(qVar.nr);
                    jkVar.fx(qVar.fx);
                    jkVar.b(qVar.b);
                    jkVar.u(qVar.pn);
                    jkVar.nr(qVar.iz);
                    jkVar.nr(qVar.k);
                } else {
                    jkVar = null;
                }
                if (i == 2) {
                    TTBaseVideoActivity.this.su.u(view, jkVar);
                }
                if (i == 1) {
                    TTBaseVideoActivity.this.su.u(view, jkVar);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public long u() {
                return TTBaseVideoActivity.this.y.cj().u();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void u(int i, String str) {
                TTBaseVideoActivity.this.y.cj().u(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
            public void u(float f) {
                TTBaseVideoActivity.this.y.cj().u(f);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
            public void u(View view) {
                TTBaseVideoActivity.this.u(2);
                a.u(((BaseThemeActivity) TTBaseVideoActivity.this).pn, true, 2, 3, (JSONObject) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.u
            public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar) {
                boolean zOptBoolean;
                jk jkVar;
                if (TTBaseVideoActivity.this.su != null) {
                    if (fxVar instanceof q) {
                        q qVar = (q) fxVar;
                        jkVar = new jk();
                        jkVar.u(qVar.u);
                        jkVar.nr(qVar.nr);
                        jkVar.fx(qVar.fx);
                        jkVar.b(qVar.b);
                        jkVar.u(qVar.pn);
                        jkVar.nr(qVar.iz);
                        jkVar.nr(qVar.k);
                        zOptBoolean = qVar.u().optBoolean("isLottieInternalClick", false);
                    } else {
                        jkVar = null;
                        zOptBoolean = false;
                    }
                    TTBaseVideoActivity.this.su.u(view, jkVar);
                } else {
                    zOptBoolean = false;
                }
                a.u(((BaseThemeActivity) TTBaseVideoActivity.this).pn, false, 1, zOptBoolean ? 2 : 1, (JSONObject) null);
            }
        };
        this.qe = new u.InterfaceC0273u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.16
            @Override // com.bytedance.sdk.openadsdk.core.multipro.nr.u.InterfaceC0273u
            public boolean m_() {
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.multipro.nr.u.InterfaceC0273u
            public com.bytedance.sdk.openadsdk.core.multipro.nr.u r_() {
                com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar = new com.bytedance.sdk.openadsdk.core.multipro.nr.u();
                iz izVar = TTBaseVideoActivity.this.xg;
                if (izVar != null) {
                    uVar.x = izVar.my();
                    uVar.u = TTBaseVideoActivity.this.xg.u();
                    uVar.n = TTBaseVideoActivity.this.c;
                }
                return uVar;
            }
        };
        this.eh = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.nr(new u.InterfaceC0244u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.17
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u.InterfaceC0244u
            public boolean a() {
                return TTBaseVideoActivity.this.y.su();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u.InterfaceC0244u
            public boolean b() {
                return TTBaseVideoActivity.this.p;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u.InterfaceC0244u
            public bc fx() {
                return ((BaseThemeActivity) TTBaseVideoActivity.this).pn;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u.InterfaceC0244u
            public TTBaseVideoActivity getActivity() {
                return TTBaseVideoActivity.this.bc;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u.InterfaceC0244u
            public int iz() {
                return TTBaseVideoActivity.this.y.iz(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u.InterfaceC0244u
            public void jk() {
                com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = TTBaseVideoActivity.this.y;
                if (uVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.b.jk) {
                    ((com.bytedance.sdk.openadsdk.core.component.reward.b.jk) uVar).ge();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u.InterfaceC0244u
            public boolean n() {
                return TTBaseVideoActivity.this.ay();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u.InterfaceC0244u
            public boolean nr() {
                return TTBaseVideoActivity.this.kj();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u.InterfaceC0244u
            public int pn() {
                return TTBaseVideoActivity.this.y.gi();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u.InterfaceC0244u
            public void t() {
                com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = TTBaseVideoActivity.this.y;
                if (uVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.b.jk) {
                    ((com.bytedance.sdk.openadsdk.core.component.reward.b.jk) uVar).ob();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u.InterfaceC0244u
            public RewardFullBaseLayout u() {
                return TTBaseVideoActivity.this.d;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u.InterfaceC0244u
            public boolean x() {
                return TTBaseVideoActivity.this.bq.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u.InterfaceC0244u
            public void u(int i, int i2) {
                if (i == 3) {
                    TTBaseVideoActivity.this.s(2);
                }
                TTBaseVideoActivity.this.u(i, i2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.u.InterfaceC0244u
            public void u(int i) {
                if (i == 3) {
                    TTBaseVideoActivity.this.k(2);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.component.reward.business.fx.u uVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.fx.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.18
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.fx.u
            public Activity getActivity() {
                return TTBaseVideoActivity.this.bc;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.fx.u
            public void nr() {
                com.bytedance.sdk.openadsdk.core.nr.pn pnVar = TTBaseVideoActivity.this.su;
                if (pnVar != null) {
                    pnVar.u(null, null);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.fx.u
            public bc u() {
                return ((BaseThemeActivity) TTBaseVideoActivity.this).pn;
            }
        };
        this.lf = uVar;
        this.nb = new com.bytedance.sdk.openadsdk.core.component.reward.business.fx.nr(uVar);
        this.gc = new com.bytedance.sdk.openadsdk.core.component.reward.business.nr.nr(new u.InterfaceC0245u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.19
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.InterfaceC0245u
            public void b() {
                TTBaseVideoActivity.this.y();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.InterfaceC0245u
            public void fx() {
                TTBaseVideoActivity.this.finish();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.InterfaceC0245u
            public Activity getActivity() {
                return TTBaseVideoActivity.this.bc;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.InterfaceC0245u
            public String nr() {
                return TTBaseVideoActivity.this.w;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.InterfaceC0245u
            public void pn() {
                iz izVar = TTBaseVideoActivity.this.xg;
                if (izVar != null) {
                    izVar.x();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.InterfaceC0245u
            public bc u() {
                return ((BaseThemeActivity) TTBaseVideoActivity.this).pn;
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.InterfaceC0245u
            public void u(int i, TTProgressBar tTProgressBar) {
                try {
                    TTBaseVideoActivity.this.d.u(i, tTProgressBar);
                } catch (Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.nr.u.InterfaceC0245u
            public void u(boolean z, String str, String str2) {
                if (com.bytedance.sdk.openadsdk.core.y.q.fx(((BaseThemeActivity) TTBaseVideoActivity.this).pn)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(MapBundleKey.MapObjKey.OBJ_SL_VISI, z);
                    jSONObject.put("entrance_text", w.u(((BaseThemeActivity) TTBaseVideoActivity.this).pn, str, str2));
                } catch (JSONException unused) {
                }
                TTBaseVideoActivity.this.rh.u("showPlayAgainEntrance", jSONObject);
                TTBaseVideoActivity.this.wq.u(jSONObject);
                if (TTBaseVideoActivity.this.wq.pb()) {
                    return;
                }
                TTBaseVideoActivity.this.bf.x(z);
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.bf.u(w.u(((BaseThemeActivity) tTBaseVideoActivity).pn, str, str2));
            }
        });
        this.dj = new AtomicBoolean(true);
    }

    private boolean dc() {
        nr.u uVar = this.rg;
        return uVar != null && uVar.b();
    }

    private void ge() {
        bc bcVar = this.pn;
        if (bcVar == null || this.d == null) {
            return;
        }
        String strQp = bcVar.qp();
        if (TextUtils.isEmpty(strQp)) {
            return;
        }
        try {
            int iOptInt = new JSONObject(strQp).optInt("auth_reward_gold");
            if (iOptInt > 0) {
                this.d.addView(new RewardAuthToastLayout(this.bc, iOptInt));
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return (this.pn.ol() == 180 && yd.o(this.pn) && t.u(this.pn) && this.rh.a() == 7) ? false : true;
    }

    private boolean ju() {
        com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = this.y;
        if (uVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.b.jk) {
            return true;
        }
        return uVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.b.fx;
    }

    private void jw() {
        final View decorView;
        bc bcVar = this.pn;
        if (bcVar == null || !bcVar.x()) {
            final int iFi = dw.nr().fi();
            try {
                requestWindowFeature(1);
                getWindow().addFlags(16777216);
                getWindow().addFlags(128);
                dw.u(this.bc);
                if (!this.y.w()) {
                    getWindow().addFlags(1024);
                    if (iFi == 1) {
                        if (Build.VERSION.SDK_INT >= 30) {
                            getWindow().setDecorFitsSystemWindows(true);
                        }
                        getWindow().getDecorView().setFitsSystemWindows(true);
                    }
                }
            } catch (Throwable unused) {
            }
            if (iFi == 1) {
                return;
            }
            try {
                decorView = getWindow().getDecorView();
            } catch (Throwable unused2) {
                decorView = null;
            }
            if (decorView == null) {
                return;
            }
            decorView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (y.nr() && TTBaseVideoActivity.this.ju == 1 && TTBaseVideoActivity.this.bc.getResources().getConfiguration().orientation == 1) {
                            int height = TTBaseVideoActivity.this.getWindow().getDecorView().getHeight();
                            if (iFi == 1) {
                                Rect rect = new Rect();
                                TTBaseVideoActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                                height = rect.bottom - rect.top;
                            }
                            if (Math.abs(y.a((Context) TTBaseVideoActivity.this.bc) - height) == 0 && decorView.isAttachedToWindow()) {
                                View view = decorView;
                                view.setPadding(view.getPaddingLeft(), (int) (decorView.getPaddingTop() + y.t((Context) TTBaseVideoActivity.this.bc)), decorView.getPaddingRight(), decorView.getPaddingBottom());
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                }
            });
        }
    }

    private void ob() {
        com.bytedance.sdk.openadsdk.core.s.b.u(this.pn, getClass().getName());
        this.oa = jp.t(this.pn);
        this.ob = this.pn.ba();
        this.ju = this.pn.sv();
        yd.u(this.pn, false);
        yd.nr(this.pn, false);
        com.bytedance.sdk.openadsdk.core.n.b.fx = false;
        com.bytedance.sdk.openadsdk.core.n.b.nr = 0;
        com.bytedance.sdk.openadsdk.core.n.b.u = 0;
        com.bytedance.sdk.openadsdk.core.n.b.b = false;
    }

    private void rg() {
        final View decorView;
        try {
            decorView = getWindow().getDecorView();
        } catch (Throwable unused) {
            decorView = null;
        }
        if (decorView == null) {
            return;
        }
        decorView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    decorView.findViewById(R.id.statusBarBackground).setVisibility(8);
                } catch (Exception unused2) {
                }
            }
        });
        decorView.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    decorView.findViewById(R.id.statusBarBackground).setVisibility(8);
                } catch (Exception unused2) {
                }
            }
        }, 300L);
    }

    private void rv() {
        com.bytedance.sdk.openadsdk.core.component.reward.b.u uVarU = com.bytedance.sdk.openadsdk.core.component.reward.b.b.u(this.bc, this.pn);
        this.y = uVarU;
        if (uVarU == null) {
            k.nr("TTBaseVideoActivity", "initAdType failed , finish activity");
            finish();
            return;
        }
        uVarU.getClass();
        if (!ja.nr(kj(), this.pn, true)) {
            this.c = this.pn.jn() == 1;
        }
        this.y.u(this.bf, this.xg, this.wq, this.m, this.pb);
        com.bytedance.sdk.openadsdk.core.component.reward.pn.fx fxVar = new com.bytedance.sdk.openadsdk.core.component.reward.pn.fx(kj(), this.pn, this.xg, this.y);
        this.xw = fxVar;
        fxVar.nr(this.kw);
        this.y.u(this.u, this.c, kj(), this.xw);
        this.y.n();
    }

    private void sf() {
        if (bg.b(this.pn)) {
            this.xg.y();
            return;
        }
        l();
        if (yd.o(this.pn) || this.y.n(false)) {
            cj();
        } else {
            fx(0);
            this.bf.u(false, null, null, true, true);
        }
        if (yd.x(this.pn) && this.xg.dw() >= yd.jk(this.pn)) {
            fx(2);
        }
        this.y.wq();
    }

    private void tm() {
        this.d = new RewardFullBaseLayout(this.bc);
        this.bf = new pn(this.bc);
        this.wq = new com.bytedance.sdk.openadsdk.core.component.reward.nr.nr(this.bc);
        this.pb = new com.bytedance.sdk.openadsdk.core.component.reward.nr.u(this.bc);
        this.xg = new iz(this.bc);
        this.m = new b(this.bc);
        this.f5220jp = new fx(this.bc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ua() {
        if (qq()) {
            uq();
            this.xg.u(false, this);
        }
    }

    private void uq() {
        if (this.wq.pb() || !this.q || v() || !this.y.nb() || this.xg.jp()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = this.y;
        if ((uVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.b.fx) || (uVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.b.jk)) {
            return;
        }
        this.nr.removeMessages(300);
        this.nr.sendEmptyMessageDelayed(300, 5000L);
    }

    private boolean za() {
        if (this.pn != null && com.bytedance.sdk.openadsdk.core.live.nr.u().nr(this.pn)) {
            String strQp = this.pn.qp();
            if (TextUtils.isEmpty(strQp)) {
                return false;
            }
            try {
                if (new JSONObject(strQp).optInt("saas_play_time_type") == 1) {
                    return true;
                }
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    private void zx() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = this.y;
            if (uVar != null) {
                jSONObject.put("reward_full_scene_type", uVar.rh());
            }
        } catch (Exception unused) {
        }
        s.u().u(this.pn, "stats_reward_full_destroy", jSONObject);
        com.bytedance.sdk.openadsdk.core.n.b.fx = false;
        com.bytedance.sdk.openadsdk.core.n.b.nr = 0;
        com.bytedance.sdk.openadsdk.core.n.b.u = 0;
        com.bytedance.sdk.openadsdk.core.n.b.b = false;
        this.nr.removeCallbacksAndMessages(null);
        this.xg.kj();
        this.pb.iz();
        this.wq.x();
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fx fxVar = this.mh;
        if (fxVar != null) {
            fxVar.nr();
        }
        fx(true);
        z();
        b("recycleRes");
        bc bcVar = this.pn;
        if (bcVar != null) {
            c.u(bcVar.dv());
            xg.nr(this.pn.n());
        }
    }

    public boolean ay() {
        return this.b.containsKey(0);
    }

    public void b(int i) {
    }

    public abstract void b(String str);

    public void bc() {
        k(0);
    }

    public RewardFullBaseLayout bf() {
        return this.d;
    }

    public void cj() {
        if (this.l.getAndSet(true)) {
            return;
        }
        iz(1);
    }

    public int d() {
        return 0;
    }

    public void eh() {
        this.bf.iz();
    }

    public boolean f() {
        return this.t.get();
    }

    @Override // android.app.Activity
    public void finish() {
        Map<String, Object> mapXw = xw();
        com.bytedance.sdk.openadsdk.core.component.reward.nr.nr nrVar = this.wq;
        if (nrVar != null) {
            nrVar.u(mapXw);
            this.wq.pn();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = this.y;
        if (uVar != null) {
            uVar.nr(mapXw);
        }
        com.bytedance.sdk.openadsdk.core.s.b.iz(this.pn, this.u, "click_close", mapXw);
        z();
        super.finish();
    }

    public void fx(int i) {
    }

    public abstract void fx(boolean z);

    public void gc() {
        if (!this.xg.bf() && !this.xg.l()) {
            sf();
        }
        iz(1);
    }

    public boolean gi() {
        return false;
    }

    public String h() {
        return "";
    }

    public String ja() {
        return "";
    }

    public void jp() {
        this.nr.removeMessages(600);
    }

    public abstract boolean kj();

    public void kw() {
        this.eh.u(this.d);
    }

    public void lf() {
        this.bq.set(true);
    }

    public int m() {
        return Math.max(this.y.wi() - (((int) (this.xg.rh() / 1000)) + this.y.tk()), 0);
    }

    public fx mh() {
        return this.f5220jp;
    }

    public void mk() {
        this.eh.nr(false);
    }

    public void n(int i) {
    }

    public void nb() {
        this.eh.fx();
    }

    public Double oa() {
        return this.uq;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        y.nr((Activity) this.bc);
        try {
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.9
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0) {
                        com.bytedance.sdk.openadsdk.core.playable.nr.nr nrVar = TTBaseVideoActivity.this.yd;
                        if (nrVar != null) {
                            nrVar.u();
                        }
                        try {
                            if (TTBaseVideoActivity.this.isFinishing()) {
                                return;
                            }
                            if (TTBaseVideoActivity.this.ju == 2) {
                                TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.9.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        y.u((Activity) TTBaseVideoActivity.this.bc);
                                    }
                                }, 2500L);
                            } else {
                                TTBaseVideoActivity.this.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.9.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        y.nr((Activity) TTBaseVideoActivity.this.bc);
                                    }
                                }, 500L);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        bc bcVar = this.pn;
        if (bcVar == null) {
            return;
        }
        if (bc.fx(bcVar) || this.pn.gs() == 1 || (this.y instanceof n)) {
            this.wq.my();
        }
        com.bytedance.sdk.openadsdk.core.playable.nr.nr nrVar = this.yd;
        if ((nrVar == null || !nrVar.nr(this.bc, this.pn)) && bg.t(this.pn)) {
            jk();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bc = this;
        tm();
        u(getIntent());
        nr(bundle);
        nr(getIntent());
        if (u(bundle)) {
            ob();
            rv();
            jw();
            a();
            this.y.u(this.zx, this.jw);
            setContentView(this.d);
            b();
            this.y.nr();
            com.bytedance.sdk.openadsdk.core.component.reward.layout.pn pnVar = this.rh;
            if (pnVar != null) {
                pnVar.u(this.qe);
            }
            if (za()) {
                this.sf = new com.bytedance.sdk.openadsdk.core.component.reward.pn.b();
            }
            SaasAuthRewardDialog saasAuthRewardDialog = (SaasAuthRewardDialog) findViewById(2114387968);
            if (saasAuthRewardDialog != null) {
                saasAuthRewardDialog.u(this.pn, this.u, kj() ? 7 : 5);
            }
            if (ja.nr(kj(), this.pn, true)) {
                bf().getSceneFrameContainer().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.20
                    @Override // java.lang.Runnable
                    public void run() {
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, TTBaseVideoActivity.this.bf().getSceneFrameContainer().getHeight(), 0.0f);
                        translateAnimation.setDuration(300L);
                        translateAnimation.setFillAfter(true);
                        TTBaseVideoActivity.this.bf().getSceneFrameContainer().startAnimation(translateAnimation);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = this.y;
        if (uVar != null) {
            uVar.k();
        }
        if (!ju()) {
            this.f5220jp.pn().u(16);
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = this.tk;
        if (nrVar != null) {
            nrVar.nr();
        }
        zx();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.bytedance.sdk.openadsdk.core.playable.nr.nr nrVar = this.yd;
        if (nrVar != null) {
            nrVar.u(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f > 0) {
            this.za += System.currentTimeMillis() - this.f;
            this.f = 0L;
        }
        if (this.nb.nr()) {
            Bundle bundle = new Bundle();
            bundle.putLong("foreground_time", this.za);
            com.bytedance.sdk.openadsdk.core.component.reward.business.fx.fx.u().u(this.oa, bundle);
        }
        y();
        this.q = false;
        com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = this.y;
        if (uVar != null) {
            uVar.s();
        }
        this.pb.pn();
        this.wq.pn();
        com.bytedance.sdk.openadsdk.core.component.reward.pn.b bVar = this.sf;
        if (bVar != null) {
            bVar.fx();
        }
        this.nr.removeMessages(1300);
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (kj() && this.gc.nr()) {
            nr();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Bundle bundleU;
        super.onResume();
        this.f = System.currentTimeMillis();
        if (this.eh.pn()) {
            nr();
            return;
        }
        if (this.nb.fx() && (bundleU = com.bytedance.sdk.openadsdk.core.component.reward.business.fx.fx.u().u(this.oa)) != null) {
            u(Math.round((bundleU.getLong("foreground_time", 0L) / 1000) * yd.z(this.pn)), true);
            com.bytedance.sdk.openadsdk.core.component.reward.business.fx.fx.u().nr(this.oa);
            this.nb.nr(false);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.pn.b bVar = this.sf;
        if (bVar != null) {
            bVar.b();
            int iU = (int) this.sf.u(TimeUnit.SECONDS);
            u(iU, false);
            this.sf.pn();
            if (this.rh != null && !yd.o(this.pn)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", iU);
                } catch (JSONException unused) {
                }
                this.rh.u("reduceTime", jSONObject);
            }
        }
        this.q = true;
        this.wq.fx();
        this.pb.b();
        com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = this.y;
        if (uVar != null) {
            uVar.nr(this.b.containsKey(0));
            bc();
            this.m.u();
            rg();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.b bVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.b();
        bVar2.u = ja.u(kj()) > 0;
        bVar2.nr = ja.u(kj());
        u(1, bVar2);
        this.nr.sendEmptyMessageDelayed(1300, this.xw.a());
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("multi_process_key", this.w);
            bundle.putBoolean("is_preload", this.qq);
            bundle.putLong("object_create_ts", this.kj);
            bundle.putBoolean("is_adm", this.z);
            bundle.putInt("key_video_cache_callback", this.gi);
            bundle.putLong("video_current", this.xg.my());
            bundle.putBoolean(be.j, this.c);
            bundle.putString("rit_scene", this.cj);
            Double d = this.uq;
            bundle.putString("_client_bidding_aution_price", d == null ? "" : String.valueOf(d));
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    public void onSkipBorderClick(View view) {
        this.y.u(view);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.wq.mv();
        com.bytedance.sdk.openadsdk.gi.u uVar = this.i;
        if (uVar != null) {
            uVar.u();
        }
        com.bytedance.sdk.openadsdk.core.k.u.fx.u().u(this, this.pn, this.c);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = this.y;
        if (uVar != null) {
            uVar.fx(this.x.get());
        }
        this.wq.iz();
        com.bytedance.sdk.openadsdk.gi.u uVar2 = this.i;
        if (uVar2 != null) {
            uVar2.nr();
        }
        com.bytedance.sdk.openadsdk.core.k.u.fx.u().nr((Context) this, this.pn, false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (ju()) {
            return;
        }
        this.f5220jp.pn().u(1.0f, z ? 12 : 13);
    }

    public void p() {
        this.y.mh();
    }

    public void pb() {
        this.m.nr();
    }

    public String rh() {
        return "";
    }

    public iz su() {
        return this.xg;
    }

    public void tk() {
        if (this.mv.getAndSet(true)) {
            return;
        }
        iz(3);
    }

    public String u() {
        return null;
    }

    public boolean v() {
        com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = this.y;
        return (uVar != null && uVar.rv()) || !this.iz.isEmpty();
    }

    public boolean wi() {
        return this.m.b() || this.wq.pb() || !yd.fx(this.pn, this.y.x());
    }

    public void wq() {
        boolean z = !this.c;
        this.c = z;
        this.y.pn(z);
    }

    public rh xg() {
        return this.nr;
    }

    public Map<String, Object> xw() {
        return u(this.pn);
    }

    public void y() {
        s(0);
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.b.u yd() {
        return this.y;
    }

    public abstract void z();

    public void a() {
        float[] fArrU = com.bytedance.sdk.openadsdk.core.component.reward.pn.nr.u(this.bc.getApplicationContext(), this.ob, this.ju);
        float f = fArrU[0];
        float f2 = fArrU[1];
        if (this.ob == 100.0f) {
            this.zx = (int) f;
            this.jw = (int) f2;
            return;
        }
        int[] iArrU = com.bytedance.sdk.openadsdk.core.component.reward.pn.nr.u(this.bc.getApplicationContext(), this.ob, this.pn.ng(), this.ju);
        int i = iArrU[0];
        int i2 = iArrU[1];
        int i3 = iArrU[2];
        int i4 = iArrU[3];
        float f3 = i;
        float f4 = i3;
        this.zx = (int) ((f - f3) - f4);
        float f5 = i2;
        float f6 = i4;
        this.jw = (int) ((f2 - f5) - f6);
        if (!gi.u(this.pn) || com.bytedance.sdk.openadsdk.core.my.b.u(String.valueOf(this.oa))) {
            try {
                this.d.u(y.fx(this.bc, f3), y.fx(this.bc, f5), y.fx(this.bc, f4), y.fx(this.bc, f6));
            } catch (Throwable unused) {
            }
        }
    }

    public void bg() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.pn pnVar;
        if (this.mh == null || (pnVar = this.rh) == null || pnVar.l() == null) {
            return;
        }
        this.rh.l().setEasyPlayableSender(this.mh.u());
        this.mh.u(bf().getEasyPlayableContainer(), null);
    }

    public boolean bq() {
        com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = this.tk;
        if (nrVar != null) {
            return nrVar.fx();
        }
        return false;
    }

    public void c() {
        this.m.fx();
        this.wq.xg();
        this.bf.u(1);
        this.nr.removeMessages(1200);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, 0);
            if (kj()) {
                jSONObject.put("reduce_duration", this.y.tk());
            }
            this.rh.u("playableStateChange", jSONObject);
        } catch (Exception unused) {
        }
        if (!this.eh.u(1)) {
            this.my.set(true);
        }
        u(1, (com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.b) null);
    }

    public void dw() {
        this.bf.u(1);
        if (!yd.o(this.pn)) {
            this.bf.u(false, null, null, true, true);
        }
        this.bf.u(true);
        this.bf.pn(true);
        this.bf.iz(false);
        this.bf.nr(this.pn.uo());
        this.m.u(this.c, this.b.containsKey(0));
        this.nr.sendEmptyMessage(1200);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(LocationConst.HDYawConst.KEY_HD_YAW_STATE, 1);
            this.rh.u("playableStateChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void iz() {
        if (this.y.nb()) {
            if (nr(this.xg.iz(), false)) {
                return;
            }
            u(true, true);
        } else {
            if (com.bytedance.sdk.openadsdk.core.y.q.x(this.pn)) {
                return;
            }
            nr(true, true);
        }
    }

    public void jk() {
        if (this.wq.k()) {
            this.wq.my();
            return;
        }
        if (!this.wq.z() && !com.bytedance.sdk.openadsdk.core.ugeno.jk.pn(this.pn) && !com.bytedance.sdk.openadsdk.core.ugeno.jk.b(this.pn)) {
            nr();
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar = new com.bytedance.sdk.openadsdk.core.component.reward.fx.jk() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void nr() {
                if (bg.t(((BaseThemeActivity) TTBaseVideoActivity.this).pn)) {
                    new u.C0284u().pn(((BaseThemeActivity) TTBaseVideoActivity.this).pn.lk()).u("rewarded_video").nr("popup_cancel").b(((BaseThemeActivity) TTBaseVideoActivity.this).pn.ap()).u((com.bytedance.sdk.openadsdk.iz.u.u) null);
                    TTBaseVideoActivity.this.s();
                    TTBaseVideoActivity.this.nr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void u() {
                if (bg.t(((BaseThemeActivity) TTBaseVideoActivity.this).pn)) {
                    new u.C0284u().pn(((BaseThemeActivity) TTBaseVideoActivity.this).pn.lk()).u("rewarded_video").nr("popup_play").b(((BaseThemeActivity) TTBaseVideoActivity.this).pn.ap()).u((com.bytedance.sdk.openadsdk.iz.u.u) null);
                    if (com.bytedance.sdk.openadsdk.core.ugeno.jk.pn(((BaseThemeActivity) TTBaseVideoActivity.this).pn) || com.bytedance.sdk.openadsdk.core.ugeno.jk.b(((BaseThemeActivity) TTBaseVideoActivity.this).pn)) {
                        return;
                    }
                    TTBaseVideoActivity.this.nr("onClickModalCallback");
                }
            }
        };
        if (com.bytedance.sdk.openadsdk.core.ugeno.jk.pn(this.pn) || com.bytedance.sdk.openadsdk.core.ugeno.jk.b(this.pn)) {
            u(jkVar);
        } else {
            nr(jkVar);
        }
    }

    public void k() {
        this.nr.removeMessages(700);
        this.nr.removeMessages(600);
    }

    public void l() {
        s.u().u(this.pn, "stats_reward_full_completed", this.f5220jp.u(new JSONObject()));
        if (this.t.getAndSet(true)) {
            return;
        }
        b("onVideoComplete");
    }

    public void mv() {
        if (this.jk.getAndSet(true)) {
            return;
        }
        b("onVideoError");
    }

    public void my() {
        this.nr.removeMessages(400);
    }

    public void nr() {
        finish();
    }

    public void o() {
        this.xg.jk();
    }

    public void pn() {
        com.bytedance.sdk.openadsdk.core.component.reward.nr.nr nrVar;
        JSONObject jSONObject = new JSONObject();
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = this.y;
            if (uVar != null) {
                jSONObject.put("reward_full_scene_type", uVar.rh());
            }
        } catch (Exception unused) {
        }
        s.u().u(this.pn, "stats_reward_full_show_endcard", jSONObject);
        if (isDestroyed() || isFinishing() || (nrVar = this.wq) == null || nrVar.pb()) {
            return;
        }
        if (!bg.b(this.pn)) {
            this.wq.b(true);
        }
        this.y.qq();
        if (this.y instanceof com.bytedance.sdk.openadsdk.core.component.reward.b.jk) {
            this.eh.nr(true);
            this.eh.iz();
        }
        if (!(this.y instanceof x) || !this.wq.bq() || (this.y instanceof n)) {
            this.wq.c();
        }
        this.bf.u(true);
        this.m.u(this.c);
        this.wq.l();
        if ((this.y instanceof x) && this.wq.h()) {
            this.wq.a();
            return;
        }
        this.bf.u(2);
        com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar2 = this.tk;
        if (nrVar2 != null) {
            nrVar2.nr();
        }
        nr.u uVar2 = this.rg;
        if (uVar2 != null) {
            uVar2.pn();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.layout.nr nrVar3 = this.h;
        if (nrVar3 != null) {
            nrVar3.pn(8);
        }
        this.wq.fx(false);
        if (!this.wq.o()) {
            if (!zx.t(this.pn)) {
                this.wq.u(false, 408, "end_card_timeout");
            }
            this.wq.pn(true);
            this.xg.n();
            return;
        }
        if (!zx.t(this.pn) && !com.bytedance.sdk.openadsdk.core.y.q.nr(this.pn)) {
            this.wq.u(true, 0, (String) null);
        }
        this.wq.s();
        this.nr.sendEmptyMessageDelayed(500, 100L);
    }

    public boolean q() {
        return dc() || bq() || this.y.ja();
    }

    public boolean qq() {
        if (q() || this.xg.jp()) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = this.y;
        if ((uVar != null && !uVar.nb()) || this.m.b() || this.wq.pb()) {
            return false;
        }
        if (this.xg.q()) {
            if ((!this.xg.fx() && !this.xg.nr()) || this.xg.nr()) {
                return false;
            }
            this.xg.fx();
        }
        return true;
    }

    public void s() {
        if (this.t.get() || this.f5219a.getAndSet(true)) {
            return;
        }
        b("onSkippedVideo");
    }

    public void sx() {
        pn();
    }

    public void t() {
        if (this.y.nb()) {
            this.xg.u(3);
            this.xg.bg();
            this.xg.fx(true);
            u(false, false);
        }
    }

    public void x() {
        com.bytedance.sdk.openadsdk.core.nr.pn pnVar = new com.bytedance.sdk.openadsdk.core.nr.pn(this.bc, this.pn, this.u, kj() ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.21
            @Override // com.bytedance.sdk.openadsdk.core.nr.pn
            public void nr(View view, jk jkVar) {
                TTBaseVideoActivity.this.u(2);
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.pb.u(view, tTBaseVideoActivity.ge, jkVar);
            }
        };
        this.su = pnVar;
        if (this.ob != 100.0f) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) pnVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.qe);
        }
        u((com.bytedance.sdk.openadsdk.core.nr.u.fx.fx) this.su.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class));
        this.su.u(this.h.mv());
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) this.su.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(xw());
        com.bytedance.sdk.openadsdk.core.nr.nr nrVar = new com.bytedance.sdk.openadsdk.core.nr.nr(this.bc, this.pn, this.u, kj() ? 7 : 5) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.22
            @Override // com.bytedance.sdk.openadsdk.core.nr.nr, com.bytedance.sdk.openadsdk.core.nr.b
            public void u(View view, jk jkVar) {
                TTBaseVideoActivity.this.f5220jp.u(view, jkVar);
            }
        };
        this.tm = nrVar;
        u((com.bytedance.sdk.openadsdk.core.nr.u.fx.fx) nrVar.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class));
        this.ge = new u.InterfaceC0248u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.u.InterfaceC0248u
            public void u(String str, JSONObject jSONObject) {
                TTBaseVideoActivity.this.f5220jp.u(str, jSONObject);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.u.InterfaceC0248u
            public void u(View view, jk jkVar) {
                TTBaseVideoActivity.this.f5220jp.u(view, jkVar);
            }
        };
        this.rv = new u.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.u.nr
            public void fx(boolean z, long j, long j2, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.wq.u(j2, j, 4);
                }
                TTBaseVideoActivity.this.u("下载失败");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.u.nr
            public void nr(boolean z, long j, long j2, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.wq.u(j2, j, 2);
                }
                TTBaseVideoActivity.this.u("下载暂停");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.u.nr
            public void u(boolean z) {
                if (z) {
                    TTBaseVideoActivity.this.wq.u(1, 0);
                }
                TTBaseVideoActivity.this.u("点击开始下载");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.u.nr
            public void u(boolean z, long j, long j2, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.wq.u(j2, j, 3);
                }
                if (j > 0) {
                    int i = (int) ((j2 * 100) / j);
                    TTBaseVideoActivity.this.u("已下载" + i + "%");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.u.nr
            public void u(boolean z, long j, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.wq.u(5, 100);
                }
                TTBaseVideoActivity.this.u("点击安装");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.u.nr
            public void u(boolean z, String str, String str2) {
                if (z) {
                    TTBaseVideoActivity.this.wq.u(6, 100);
                }
                TTBaseVideoActivity.this.u("点击打开");
            }
        };
        this.y.u(this.su);
    }

    private void nr(final com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar) {
        final boolean[] zArr = {false};
        com.bytedance.sdk.openadsdk.a.u.nr.u(new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.6
            @Override // com.bytedance.sdk.openadsdk.a.u.nr.u
            public void u() {
                zArr[0] = true;
                jkVar.nr();
            }

            @Override // com.bytedance.sdk.openadsdk.a.u.nr.u
            public void u(int i) {
                zArr[0] = true;
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this.bc;
                if (tTBaseVideoActivity != null && tTBaseVideoActivity.getIntent() != null) {
                    TTBaseVideoActivity.this.bc.getIntent().putExtra("remainTime", i);
                }
                if (i > 0) {
                    TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                    if (tTBaseVideoActivity2.u(((BaseThemeActivity) tTBaseVideoActivity2).pn, jkVar)) {
                        return;
                    }
                }
                jkVar.nr();
            }
        });
        nr("onClickBrowseClose");
        new CountDownTimer(1000L, 1000L) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.7
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (zArr[0]) {
                    return;
                }
                TTBaseVideoActivity.this.nr();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    public void b() {
        this.d.u(this.y);
        ge();
        this.h = this.y.u(kj());
        this.rh = this.y.l();
        this.ja = this.y.mv();
        this.h.u();
        x();
        this.h.u(this.su, this.tm);
        this.h.u(this.pb.x());
        this.bf.u(this.pn, this.wq, kj(), this.su);
        this.bf.b(this.c);
        if (this.pb.fx()) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) this.su.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.pb.nr());
            this.pb.u(this.ge);
        }
        this.pb.u(this.rv);
        this.pb.u(this.qe);
        this.wq.u(this.bf, this.pb, kj(), this.u, this.zx, this.jw);
        this.wq.u(this.pn, this.su, this.qe.r_(), this.ja);
        this.m.u(this.wq, this.pn, this.u, this.bf);
        this.f5220jp.u(this.pn, this.u, this.h.mv());
        this.xg.u(this.pn);
        this.i = new com.bytedance.sdk.openadsdk.gi.u();
        this.mh = new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fx(this.pn, false, this.v);
        this.yd = new com.bytedance.sdk.openadsdk.core.playable.nr.nr(this.u);
    }

    public void fx() {
        this.xg.m();
        this.xg.u(2);
        this.xg.a();
        s();
        iz(2);
    }

    public void my(int i) {
        if (i == 0) {
            return;
        }
        this.iz.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public Map<String, Object> n() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.pn pnVar;
        Map<String, Object> mapXw = xw();
        if (this.kj > 0) {
            mapXw.put("object_media_holder_time", Long.valueOf((System.currentTimeMillis() - this.kj) / 1000));
        }
        com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = this.y;
        if (uVar != null && uVar.iz() && (pnVar = this.rh) != null) {
            kj.u(mapXw, this.pn, pnVar.l());
        }
        return mapXw;
    }

    public void o(int i) {
        if (i == 0) {
            return;
        }
        this.iz.remove(Integer.valueOf(i));
    }

    public boolean u(Bundle bundle) {
        this.pb.u(this.pn, this.u, this.w);
        if (bundle != null) {
            this.pb.u();
        }
        com.bytedance.sdk.openadsdk.core.b.u().nr(this.pn);
        if (this.pn != null) {
            return true;
        }
        k.nr("TTBaseVideoActivity", "mMaterialMeta is null , no data to display ,the TTBaseVideoActivity finished !!");
        nr();
        return false;
    }

    public void k(int i) {
        o(i);
        if (this.y instanceof n) {
            this.nr.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.15
                @Override // java.lang.Runnable
                public void run() {
                    TTBaseVideoActivity.this.ua();
                }
            }, 500L);
        } else {
            ua();
        }
        if (q()) {
            return;
        }
        if (this.wq.rh()) {
            this.nr.sendEmptyMessageDelayed(1200, 1000L);
        }
        if (!v() || this.wq.pb() || this.wq.rh()) {
            this.y.c();
        }
        this.wq.b();
    }

    public void mv(int i) {
        this.h.pn(i);
    }

    public void l(int i) {
        this.y.fx(i);
        fx(0);
    }

    public void s(int i) {
        com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar;
        if (this.xg.nr()) {
            HashMap map = new HashMap();
            map.put("pause_from", Integer.valueOf(i));
            this.xg.u(map);
        }
        this.nr.removeMessages(300);
        this.nr.removeMessages(1200);
        my(i);
        if ((v() && yd.o(this.pn) && this.m.b()) || (uVar = this.y) == null) {
            return;
        }
        uVar.dw();
        this.wq.nr(v());
    }

    public void iz(int i) {
        int iPn = pn(i);
        if (i != 2) {
            if (this.m.b()) {
                return;
            }
            if (this.xg.l()) {
                this.xg.jk();
                return;
            }
            if (yd.o(this.pn)) {
                if (this.l.get() && !this.mv.get()) {
                    if (iPn == 1 && !this.b.containsKey(0) && kj()) {
                        this.bf.nr((this.pn.qf() == 3 && yd.sx(this.pn)) ? "奖励就快来了\n去详情页看看也累计时长哦～" : "奖励还在路上狂奔\n再等一下下哦～");
                    }
                    this.xg.y();
                }
                if (!this.l.get() && this.mv.get()) {
                    return;
                }
                if (iPn == 1 && (!this.l.get() || !this.mv.get())) {
                    return;
                }
            }
        }
        if (iPn == 1) {
            nr();
            return;
        }
        if (iPn == 2) {
            if (this.n.get()) {
                this.wq.c();
            }
            pn();
        } else if (iPn == 3) {
            this.xg.y();
        } else if (iPn == 4 && i != 3) {
            o();
        }
    }

    public void nr(String str) {
        com.bytedance.sdk.openadsdk.core.ja jaVarGi = this.wq.gi();
        if (jaVarGi != null && !isFinishing()) {
            try {
                jaVarGi.fx(str, null);
                return;
            } catch (Exception unused) {
                nr();
                return;
            }
        }
        nr();
    }

    public void t(int i) {
        if (this.rh != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", i);
            } catch (JSONException unused) {
            }
            this.rh.u("reduceTime", jSONObject);
        }
    }

    public void fx(String str) {
        if (isFinishing()) {
            return;
        }
        if (this.tk == null) {
            com.bytedance.sdk.openadsdk.core.dislike.ui.nr nrVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.nr(this.bc, this.pn.vz(), this.u, true, com.bytedance.sdk.openadsdk.n.nr.u());
            this.tk = nrVar;
            com.bytedance.sdk.openadsdk.core.dislike.fx.u(this.bc, this.pn, nrVar);
            this.tk.u(new nr.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.11
                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
                public void nr() {
                    TTBaseVideoActivity.this.bc();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
                public void u() {
                    TTBaseVideoActivity.this.y();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.nr.u
                public void u(int i, String str2, boolean z) {
                    TTBaseVideoActivity.this.nr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TTBaseVideoActivity.this.bc();
                        }
                    });
                }
            });
        }
        this.tk.u(str);
        this.tk.u();
    }

    public boolean u(long j, boolean z) {
        if (!this.xg.q()) {
            return false;
        }
        if (!z || !this.xg.qq()) {
            uq();
        }
        boolean zU = this.xg.u(j, this.c, this.y.q());
        if (zU && !z) {
            if (com.bytedance.sdk.openadsdk.core.y.q.x(this.pn)) {
                return true;
            }
            nr(true, true);
        }
        return zU;
    }

    public void jk(int i) {
        com.bytedance.sdk.openadsdk.core.video.nr.nr nrVarPb;
        com.bytedance.sdk.openadsdk.core.component.reward.b.u uVar = this.y;
        if (!(uVar instanceof n) || (nrVarPb = uVar.pb()) == null) {
            return;
        }
        if (nrVarPb.t() == 1 && i == 1 && this.dj.getAndSet(false)) {
            int iN = y.n(dw.getContext());
            float fIz = y.iz(dw.getContext());
            float fX = y.x(dw.getContext());
            Map<String, Object> mapXw = xw();
            mapXw.putAll(nrVarPb.x());
            com.bytedance.sdk.openadsdk.core.s.b.u("click", this.pn, new a.u().iz(-1.0f).pn(-1.0f).b(-1.0f).fx(-1.0f).nr(-1L).u(-1L).fx(-1).b(-1).pn(ErrorCode.ERROR_CODE_LICENSE_NOT_MATCH_WITH_CACHE).nr(com.bytedance.sdk.openadsdk.core.n.o().fx() ? 1 : 2).u(iN).u(fIz).nr(fX).u(), this.u, true, mapXw, -1, false, false);
        }
    }

    public void nr(int i) {
        if (i <= 0) {
            this.bf.u(false, null, null, true, true);
        } else {
            this.nr.sendEmptyMessageDelayed(600, i);
        }
    }

    public void nr(boolean z) {
        Message message = new Message();
        message.what = 400;
        this.nr.sendMessageDelayed(message, z ? 2000L : 0L);
    }

    public void u(final com.bytedance.sdk.openadsdk.core.nr.u.fx.fx fxVar) {
        fxVar.u(new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.u
            public boolean u() {
                fxVar.u(TTBaseVideoActivity.this.n());
                fxVar.u(TTBaseVideoActivity.this.u);
                fxVar.u(TTBaseVideoActivity.this.uq);
                return TTBaseVideoActivity.this.mk.get();
            }
        });
    }

    public void x(int i) {
        this.d.u(i);
    }

    public void u(String str) {
        this.wq.u(str);
    }

    private void u(com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar) {
        int iM = this.y.m();
        TTBaseVideoActivity tTBaseVideoActivity = this.bc;
        if (tTBaseVideoActivity != null && tTBaseVideoActivity.getIntent() != null) {
            this.bc.getIntent().putExtra("remainTime", iM);
        }
        if (iM > 0) {
            if (u(this.pn, jkVar)) {
                return;
            }
            jkVar.nr();
            return;
        }
        nr();
    }

    public void nr(boolean z, boolean z2) {
        if (z) {
            Map<String, Object> mapN = n();
            this.mk.set(true);
            mapN.put("cache_strategy", Integer.valueOf(com.bytedance.sdk.openadsdk.core.component.reward.u.pn.u(kj())));
            mapN.put("is_adm", Boolean.valueOf(this.z));
            mapN.put("is_play_again", Boolean.valueOf(gi()));
            mapN.put("if_cache_callback", Integer.valueOf(this.gi == 1 ? 1 : 0));
            mapN.put("src_req_id", this.pn.ls());
            mapN.put("is_map", Boolean.valueOf(this.pn.la()));
            mapN.put("is_repeat", Boolean.valueOf(this.bg.getAndSet(true)));
            com.bytedance.sdk.openadsdk.core.s.b.u(this.pn, this.u, mapN, this.uq);
            this.f5220jp.pn().u(1.0f, 11);
            com.bytedance.sdk.openadsdk.core.bf.u.u().b();
            xg.u(this.pn.n());
        }
        if (z2) {
            if (!ja.nr(kj(), this.pn, true)) {
                boolean zVp = dw.nr().vp();
                if (this.sx.getAndSet(true) && !zVp) {
                    s.u().b(this.pn, "stats_callback_repeat");
                } else {
                    b("onAdShow");
                }
            }
            if (this.y.iz()) {
                this.rh.x();
            }
            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fx fxVar = this.mh;
            if (fxVar != null && fxVar.u() != null) {
                this.mh.u().b();
            }
            if (this.pn.fx() && this.pn.kv() != null) {
                com.bytedance.sdk.openadsdk.core.o.u.u().u(getApplicationContext(), this.pn.kv().nr());
            }
        }
        fx(false);
    }

    public void a(int i) {
        this.nb.nr(true);
        this.nb.u(i);
    }

    public void w() {
    }

    public boolean u(bc bcVar, final com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar) {
        if (!kj() || !this.pn.cb() || this.b.containsKey(0) || isFinishing()) {
            return false;
        }
        if (System.currentTimeMillis() - this.dc < 1000) {
            return true;
        }
        this.dc = System.currentTimeMillis();
        nr.u uVarU = this.y.u(bcVar, new com.bytedance.sdk.openadsdk.core.component.reward.fx.jk() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity.8
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void nr() {
                TTBaseVideoActivity.this.s.set(true);
                com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.nr();
                }
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.f5220jp.u("reward_retain_dialog_skip", tTBaseVideoActivity.rg.u(), TTBaseVideoActivity.this.rg.nr());
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void u() {
                com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.u();
                }
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.f5220jp.u("reward_retain_dialog_cancel", tTBaseVideoActivity.rg.u(), TTBaseVideoActivity.this.rg.nr());
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void u(int i) {
                TTBaseVideoActivity.this.u(i, true);
                TTBaseVideoActivity.this.bf.nr("恭喜您，可提前" + i + "s获得奖励～");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void fx() {
            }
        });
        this.rg = uVarU;
        this.f5220jp.u("reward_retain_dialog_show", uVarU.u(), this.rg.nr());
        return this.rg.fx();
    }

    @Override // com.bytedance.sdk.component.utils.rh.u
    public void u(Message message) {
        int i = message.what;
        if (i == 300) {
            t();
            return;
        }
        if (i == 400) {
            this.xg.a();
            if (this.y.iz()) {
                this.rh.u(true);
            }
            u(false, true);
            return;
        }
        if (i == 500) {
            this.wq.n();
            this.xg.n();
            this.h.fx(false);
            this.rh.fx(false);
            this.rh.b();
            return;
        }
        if (i == 600) {
            this.bf.u(false, null, null, true, true);
            return;
        }
        if (i == 700) {
            this.wq.bf();
            return;
        }
        if (i == 1200) {
            if (yd.o(this.pn)) {
                return;
            }
            if (this.wq.rh()) {
                u(1, false);
                this.m.u(m(), this.y.m());
                fx(0);
            }
            this.nr.sendEmptyMessageDelayed(1200, 1000L);
            return;
        }
        if (i != 1300) {
            return;
        }
        this.nr.sendEmptyMessageDelayed(1300, this.xw.a());
        if (q()) {
            return;
        }
        this.xw.n();
        if (!v()) {
            this.xw.x();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.b bVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.b();
        if (ja.nr(kj()) > 0) {
            int iPn = ja.pn(this.pn) / 1000;
            int iNr = ja.nr(kj());
            if (iPn < iNr) {
                iNr = iPn;
            }
            if (iPn - iNr <= this.y.gi()) {
                bVar.u = true;
                bVar.nr = iNr;
            }
        }
        u(2, bVar);
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.b bVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.b();
        bVar2.u = true;
        u(3, bVar2);
        this.eh.x();
        this.y.ay();
    }

    public int pn(int i) {
        boolean z = i == 2;
        int iMf = this.pn.mf();
        if (iMf == 1) {
            return 1;
        }
        if (iMf != 3) {
            if (iMf == 4 || iMf == 5) {
                return z ? 1 : 3;
            }
            if (iMf == 6) {
                return z ? 1 : 4;
            }
            if (iMf == 7 && z && this.s.get()) {
                return 1;
            }
        } else if (z) {
            return 1;
        }
        return 2;
    }

    public boolean nr(long j, boolean z) {
        this.xg.u(this.su);
        this.xg.u(this.y.sx(), this.u, kj());
        this.xg.nr(n());
        if (this.y.iz()) {
            this.rh.u(this.xg.xg());
        }
        this.xg.u(this.ay);
        boolean zU = u(j, z);
        if (zU && !z) {
            this.wi = (int) (System.currentTimeMillis() / 1000);
        }
        return zU;
    }

    public void nr(Bundle bundle) {
        if (bundle != null) {
            this.w = bundle.getString("multi_process_key");
            this.qq = bundle.getBoolean("is_preload");
            this.kj = bundle.getLong("object_create_ts");
            this.z = bundle.getBoolean("is_adm");
            this.gi = bundle.getInt("key_video_cache_callback", -1);
            this.cj = bundle.getString("rit_scene");
            String string = bundle.getString("_client_bidding_aution_price");
            this.uq = TextUtils.isEmpty(string) ? null : Double.valueOf(Double.parseDouble(string));
            this.c = bundle.getBoolean(be.j);
            long j = bundle.getLong("video_current");
            if (j > 0) {
                this.xg.u(j);
            }
        }
    }

    public void nr(Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getStringExtra("insert_ad_bundle"))) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.fx fxVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.fx(intent.getStringExtra("insert_ad_bundle"));
        this.w = fxVar.u();
        if (ja.u(this.pn) == 1) {
            this.kw = fxVar.jk();
        }
        this.p = fxVar.t();
        this.t.set(fxVar.b());
        this.b.putAll(fxVar.n());
        this.eh.u(fxVar);
        this.c = fxVar.pn();
        this.gc.fx(fxVar.iz());
    }

    public void u(long j) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 700;
        this.nr.sendMessageDelayed(messageObtain, j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.n.nr
    public void u(boolean z) {
        if (z) {
            if (this.rh.iz()) {
                return;
            }
            this.y.b(true);
            return;
        }
        if (this.rh.iz() && this.xg.wq() != null) {
            this.xg.wq().u(8);
        }
        this.y.b(false);
        if (this.rh.iz() || this.ju == 2 || !com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.pn)) {
            return;
        }
        this.h.iz(8);
    }

    public void u(boolean z, boolean z2) {
        this.xg.nr(z2);
        mv();
        if (z) {
            this.k.set(true);
            if (yd.o(this.pn)) {
                this.y.h();
            }
            this.bf.u(false, null, null, true, true);
            pn();
            return;
        }
        if (yd.dw(this.pn)) {
            this.wq.jp();
        } else {
            this.bf.u(false, null, null, true, true);
            b(0);
        }
        if (this.xg.jp()) {
            return;
        }
        if (yd.o(this.pn)) {
            this.y.h();
        }
        pn();
    }

    public void u(int i, com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.b bVar) {
        if (com.bytedance.sdk.openadsdk.core.y.q.fx(this.pn) || this.s.get() || this.jk.get()) {
            return;
        }
        int iJk = 0;
        if (i == 1) {
            if (!this.my.get()) {
                return;
            }
            if (bVar == null || !bVar.u) {
                this.my.set(false);
            }
        }
        int iU = this.eh.u(i, bVar != null && bVar.b);
        if (iU == 0) {
            return;
        }
        if (iU == 3 && bVar != null && bVar.fx) {
            iJk = ja.jk();
        }
        this.eh.u(new fx.u().u(this.w).u(this.y.m()).nr(iJk).u(this.t.get()).u(this.b.keySet()).nr(this.c).u(this.gc).fx(iU).b(this.y.gi()).fx(this.eh.b() ? this.p : bc.nr(this.pn)).u(), iU, bVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.n.nr
    public void u(int i) {
        this.bq.set(true);
        if (System.currentTimeMillis() - this.ua > 50) {
            this.ua = System.currentTimeMillis();
            b("onAdVideoBarClick");
        }
        if (!isFinishing()) {
            com.bytedance.sdk.openadsdk.core.nativeexpress.n.u(this.rh.l());
        }
        if (!this.x.get()) {
            this.x.set(true);
        }
        if (!this.eh.u(1)) {
            this.my.set(true);
        }
        fx(0);
        jk(i);
    }

    public void u(Intent intent) {
        if (intent != null) {
            this.cj = intent.getStringExtra("rit_scene");
            this.qq = intent.getBooleanExtra("is_preload", false);
            this.kj = intent.getLongExtra("object_create_ts", 0L);
            this.z = intent.getBooleanExtra("is_adm", false);
            this.w = intent.getStringExtra("multi_process_key");
            this.gi = intent.getIntExtra("key_video_cache_callback", -1);
            String stringExtra = intent.getStringExtra("_client_bidding_aution_price");
            this.uq = TextUtils.isEmpty(stringExtra) ? null : Double.valueOf(Double.parseDouble(stringExtra));
            this.nb.u(intent.getBooleanExtra("is_second_page", false));
        }
    }

    public void u(int i, boolean z) {
        l(i);
        if (z) {
            t(i);
        }
    }

    public void u(float f, float f2, float f3, float f4, int i) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.pn pnVar = this.rh;
        if (pnVar == null || pnVar.u() == null) {
            return;
        }
        int measuredWidth = this.rh.u().getMeasuredWidth();
        int measuredHeight = this.rh.u().getMeasuredHeight();
        if (this.xg.xg() instanceof com.bytedance.sdk.openadsdk.core.video.nr.u ? ((com.bytedance.sdk.openadsdk.core.video.nr.u) this.xg.xg()).cj() : false) {
            this.rh.u().animate().translationY(-(measuredHeight * (1.0f - f2))).setDuration(i).start();
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2, measuredWidth * f3, measuredHeight * f4);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(i);
        this.rh.u().startAnimation(scaleAnimation);
    }

    public Map<String, Object> u(bc bcVar) {
        HashMap map = new HashMap();
        String str = this.cj;
        if (str != null) {
            map.put("rit_scene", str);
        }
        map.put("insert_ad_control", Integer.valueOf(ja.u(bcVar)));
        map.put("carousel_pos", Integer.valueOf(ja.b(bcVar)));
        map.put("refresh_ad_control", Integer.valueOf(ja.nr(bcVar)));
        if (this.eh.nr() != 0) {
            map.put("carousel_type", Integer.valueOf(this.eh.nr()));
        } else if (wi.n(bcVar)) {
            map.put("carousel_type", 4);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.nr.fx fxVar = this.f5220jp;
        if (fxVar != null) {
            fxVar.u(map);
        }
        return map;
    }

    public void u(bc bcVar, com.bytedance.sdk.openadsdk.core.nr.nr nrVar) {
        this.wq.u(bcVar, nrVar);
        this.m.u(bcVar);
    }

    public void u(int i, int i2) {
        this.eh.u(i, i2, 0);
    }

    public void u(int i, int i2, int i3) {
        this.eh.u(i, i2, i3);
    }
}
