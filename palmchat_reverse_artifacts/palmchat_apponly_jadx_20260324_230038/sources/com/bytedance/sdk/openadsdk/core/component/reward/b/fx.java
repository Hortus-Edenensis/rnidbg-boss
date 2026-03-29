package com.bytedance.sdk.openadsdk.core.component.reward.b;

import android.text.TextUtils;
import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.sdk.component.adexpress.nr.s;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.fx;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.wi;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends com.bytedance.sdk.openadsdk.core.component.reward.b.u {
    private final AtomicBoolean bc;
    private int bf;
    private com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.u cj;
    private int ja;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private final AtomicBoolean f5221jp;
    private int m;
    private final AtomicBoolean oa;
    private int pb;
    private final List<com.bytedance.sdk.openadsdk.core.component.reward.draw.nr> rh;
    private com.bytedance.sdk.openadsdk.core.ugeno.t.u tk;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.pn w;
    private int wq;
    private int xg;
    private final AtomicBoolean xw;
    private final AtomicBoolean y;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void b();

        Map<String, Object> fx();

        void nr();

        void u();

        void u(int i);

        void u(long j, long j2);
    }

    public fx(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar) {
        super(tTBaseVideoActivity, bcVar);
        this.rh = new ArrayList();
        this.ja = 0;
        this.bf = 0;
        this.wq = 0;
        this.pb = 0;
        this.xg = 0;
        this.m = 0;
        this.f5221jp = new AtomicBoolean(false);
        this.y = new AtomicBoolean(false);
        this.bc = new AtomicBoolean(true);
        this.xw = new AtomicBoolean(false);
        this.oa = new AtomicBoolean(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc() {
        if (this.pb < this.rh.size() - 1) {
            this.rh.get(this.pb + 1).l();
            this.rh.get(this.pb + 1).u(this.pn, this.iz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.b ju() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.nr nrVar = this.f5223a;
        if (nrVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.b) {
            return (com.bytedance.sdk.openadsdk.core.component.reward.layout.b) nrVar;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void jw() {
        String str;
        boolean z;
        com.bytedance.sdk.openadsdk.core.ugeno.t.u uVar;
        String str2;
        boolean z2 = Math.max(0, this.h.fx() - kj()) == 0;
        int iB = wi.b(this.nr);
        int iPn = wi.pn(this.nr);
        int iIz = iz(false);
        if (wi.n(this.nr)) {
            if (iIz > 0) {
                str2 = iIz + "s";
            } else {
                str2 = "奖励已领取";
            }
            str = str2;
        } else {
            str = "领取成功";
            if (iB == 0) {
                if (iIz > 0) {
                    str = iIz + "s后可领取奖励";
                }
                z = true;
                nr(iz(true));
                this.sx.u(z, str, (z2 || iPn != 1) ? null : "跳过", !z2 && iPn == 0, z2);
                uVar = this.tk;
                if (uVar == null) {
                    uVar.u((int) (this.h.u() / 1000), this.h.pn(), this.h.nr(), iz(false));
                    return;
                }
                return;
            }
            if (iIz > 0) {
                str = iIz + "s";
            }
        }
        z = false;
        nr(iz(true));
        if (z2) {
        }
        if (z2) {
        }
        this.sx.u(z, str, (z2 || iPn != 1) ? null : "跳过", !z2 && iPn == 0, z2);
        uVar = this.tk;
        if (uVar == null) {
        }
    }

    public static int nr(bc bcVar) {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rg() {
        com.bykv.vk.openvk.component.video.api.fx.iz izVarJk;
        com.bytedance.sdk.openadsdk.core.component.reward.draw.pn pnVar = this.w;
        bc bcVarU = null;
        com.bykv.vk.openvk.component.video.api.b.fx fxVarXg = pnVar != null ? pnVar.xg() : null;
        com.bytedance.sdk.openadsdk.core.component.reward.draw.nr nrVar = this.rh.get(this.pb);
        if (nrVar != null) {
            bcVarU = nrVar.u();
            izVarJk = nrVar.jk();
        } else {
            izVarJk = null;
        }
        this.bg.u(bcVarU, fxVarXg, izVarJk);
        this.bg.nr(this.u.n());
    }

    private void uq() {
        int i;
        String str;
        String string;
        String str2;
        if (wi.n(this.nr)) {
            int iMin = this.pb + 1;
            int size = this.rh.size();
            boolean z = this.pb + 1 >= this.rh.size();
            boolean z2 = this.pb == 0;
            int iGe = ge();
            boolean z3 = this.h.pn() - this.wq < wi.k(this.nr);
            if (this.bc.get()) {
                if (!z3) {
                    iMin = Math.min(iMin + 1, size);
                }
                int i2 = iMin;
                String str3 = i2 + "/" + size;
                if (z3) {
                    StringBuilder sb = new StringBuilder();
                    if (z2) {
                        str2 = "可看" + size + "个视频,当前 ";
                    } else {
                        str2 = "正在播放 ";
                    }
                    sb.append(str2);
                    sb.append(str3);
                    string = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    if (z) {
                        str = "";
                    } else {
                        str = iGe + "秒后播放 ";
                    }
                    sb2.append(str);
                    sb2.append(str3);
                    string = sb2.toString();
                }
                this.sx.u(string, this.xw.get() ? "取消" : null, this.xw.get());
                com.bytedance.sdk.openadsdk.core.ugeno.t.u uVar = this.tk;
                if (uVar != null) {
                    uVar.u(iGe, z, i2, size, true, z3, this.xw.get());
                }
            } else {
                this.sx.u((String) null, (String) null, false);
                com.bytedance.sdk.openadsdk.core.ugeno.t.u uVar2 = this.tk;
                if (uVar2 != null) {
                    i = iGe;
                    uVar2.u(0, z, 0, 0, false, false, false);
                }
                if (i == 0 && !ob()) {
                    a(false);
                }
            }
            i = iGe;
            if (i == 0) {
                a(false);
            }
        }
        if (this.h.pn() <= wi.a(this.nr) || this.y.get() || ju() == null) {
            return;
        }
        ju().pn();
    }

    private void zx() {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.pn pnVar = this.w;
        if (pnVar == null || !pnVar.m()) {
            int iB = this.rh.get(this.pb).b();
            if (iB > 0) {
                this.ja += iB;
            }
            if ((wi.fx(this.nr) <= this.bf) && !this.f5221jp.get()) {
                this.u.b(0);
                this.u.l();
                this.f5221jp.set(true);
            }
            int i = this.bf;
            if (i < this.ja) {
                this.bf = i + 1;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int bc() {
        return this.bf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void c() {
        if (this.bq.pb()) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.draw.pn pnVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.pn) ju().nr().fx(this.xg);
            if (pnVar != null) {
                pnVar.d();
            }
        } catch (Exception e) {
            k.u("cubic  resume exception:" + e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void dw() {
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.draw.pn pnVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.pn) ju().nr().fx(this.xg);
            if (pnVar != null) {
                pnVar.gi();
            }
        } catch (Exception e) {
            k.u("cubic pause exception:" + e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean eh() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void f() {
        jw();
        zx();
        uq();
    }

    public int ge() {
        return Math.max(0, ((((int) Math.min(Math.round(zx.x(this.rh.get(this.pb).u())), wi.nr(r0))) + (ob() ? 1 : 0)) + this.wq) - this.h.pn());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public boolean iz() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int jp() {
        return wi.fx(this.nr) - this.bf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void k() {
        super.k();
        List<com.bytedance.sdk.openadsdk.core.component.reward.draw.nr> list = this.rh;
        if (list != null) {
            Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.nr> it = list.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
        }
        if (ju() != null) {
            ju().fx().b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean lf() {
        return this.nr.mf() == 2 || this.nr.mf() == 3 || this.nr.mf() == 7;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void mh() {
        this.bc.set(false);
        this.oa.set(false);
        f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean nb() {
        return true;
    }

    public boolean ob() {
        bc bcVarU = this.rh.get(this.pb).u();
        return Math.round(zx.x(bcVarU)) <= ((long) wi.nr(bcVarU));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void qq() {
        super.qq();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MapBundleKey.MapObjKey.OBJ_SL_VISI, false);
        } catch (JSONException unused) {
        }
        this.bq.u(jSONObject);
        if (!yd()) {
            dw();
        }
        this.bc.set(false);
        this.sx.u((String) null, (String) null, false);
        com.bytedance.sdk.openadsdk.core.ugeno.t.u uVar = this.tk;
        if (uVar != null) {
            uVar.u(0, true, 0, 0, false, false, false);
            this.tk.u((int) (this.h.u() / 1000), this.h.pn(), this.h.nr(), iz(false));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int rh() {
        return nr(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean rv() {
        if (wi.my(this.nr)) {
            return this.my;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u, com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean yd() {
        return wi.n(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void za() {
        this.sx.u(true);
        this.sx.nr(this.nr.uo());
        this.sx.fx(true);
        this.sx.pn(true);
        if (!TextUtils.isEmpty(wi.t(this.nr))) {
            this.sx.u(false);
            com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.u uVar = new com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.u(this.nr);
            this.cj = uVar;
            uVar.u(new com.bytedance.sdk.component.adexpress.nr.x() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.fx.1
                boolean u = false;

                @Override // com.bytedance.sdk.component.adexpress.nr.x
                public void u(final View view, final s sVar) {
                    if (this.u) {
                        return;
                    }
                    fx.this.u.bf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.fx.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fx.this.u.bf().getTopFrameContainer().removeAllViews();
                            fx.this.u.bf().getTopFrameContainer().addView(view);
                            fx.this.sx.u(true);
                            s sVar2 = sVar;
                            if (sVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.fx) {
                                fx.this.tk = ((com.bytedance.sdk.openadsdk.core.ugeno.express.fx) sVar2).sx();
                                fx.this.tk.u((int) (fx.this.h.u() / 1000), fx.this.h.pn(), fx.this.h.nr(), fx.this.iz(false));
                                fx.this.f();
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.component.adexpress.nr.x
                public void u(int i, String str) {
                    this.u = true;
                    fx.this.sx.u(true);
                }
            });
            this.cj.u(new com.bytedance.sdk.component.adexpress.nr.n() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.fx.2
                @Override // com.bytedance.sdk.component.adexpress.nr.n
                public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar, int i2) {
                }

                @Override // com.bytedance.sdk.component.adexpress.nr.n
                public void u(View view, int i, com.bytedance.sdk.component.adexpress.fx fxVar) {
                    if (i == 3) {
                        fx.this.cj().jk();
                    } else if (i == 5) {
                        fx.this.cj().u(!fx.this.mv);
                    } else {
                        if (i != 6) {
                            return;
                        }
                        fx.this.cj().x();
                    }
                }
            });
            this.cj.u(new com.bytedance.sdk.openadsdk.core.ugeno.express.u.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.fx.3
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.u.nr
                public void u() {
                    fx.this.mh();
                }
            });
            this.cj.u(wi.t(this.nr), wi.l(this.nr), this.pn, 0, wi.mv(this.nr));
        }
        f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public View a() {
        return com.bytedance.sdk.openadsdk.res.pn.jk(this.u);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void n() {
        super.n();
        this.rh.add(new com.bytedance.sdk.openadsdk.core.component.reward.draw.nr(this.u, this.nr, this.l, lf(), true));
        try {
            JSONArray jSONArray = new JSONArray(this.nr.lg());
            for (int i = 0; i < jSONArray.length(); i++) {
                this.rh.add(new com.bytedance.sdk.openadsdk.core.component.reward.draw.nr(this.u, com.bytedance.sdk.openadsdk.core.u.u(jSONArray.getJSONObject(i)), this.l, lf(), false));
            }
        } catch (JSONException unused) {
        }
        Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.nr> it = this.rh.iterator();
        while (it.hasNext()) {
            it.next().u(this.mv);
        }
        this.xw.set(wi.s(this.nr));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int x(boolean z) {
        return z ? jp() : wi.x(this.nr) - this.bf;
    }

    public void a(boolean z) {
        if (!this.bq.pb() && this.pb + 1 < this.rh.size()) {
            this.wq = this.h.pn();
            if (!(z || this.oa.get() || wi.iz(this.nr)) || ju() == null) {
                return;
            }
            ju().nr().nr(this.xg + 1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u, com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void fx() {
        this.f5223a.fx(true);
        if (ju() != null) {
            ju().fx().u(this.rh);
            ju().b().u(new fx.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.fx.4
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.fx.u
                public void u() {
                    fx fxVar = fx.this;
                    fxVar.my = true;
                    fxVar.pb = 0;
                    u((com.bytedance.sdk.openadsdk.core.component.reward.draw.pn) fx.this.ju().nr().fx(0));
                    fx.this.rg();
                    fx.this.dc();
                    fx.this.u.nr(false, true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.fx.u
                public void u(boolean z, int i, boolean z2) {
                    int i2 = fx.this.xg;
                    if (fx.this.w != null) {
                        fx.this.u.mh().u(z, i2 + 1, fx.this.w.ja());
                    }
                    fx.this.xg = i;
                    fx fxVar = fx.this;
                    fxVar.m = Math.max(fxVar.m, i + 1);
                    fx fxVar2 = fx.this;
                    fxVar2.pb = i % fxVar2.rh.size();
                    u((com.bytedance.sdk.openadsdk.core.component.reward.draw.pn) fx.this.ju().nr().fx(i));
                    fx.this.ju().iz();
                    fx.this.y.set(true);
                    fx.this.xw.set(wi.s(fx.this.nr) && fx.this.pb + 1 < fx.this.rh.size());
                    fx.this.f();
                    fx.this.dc();
                    fx fxVar3 = fx.this;
                    fxVar3.sx.u(((com.bytedance.sdk.openadsdk.core.component.reward.draw.nr) fxVar3.rh.get(fx.this.pb)).u());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.fx.u
                public void u(boolean z, int i) {
                    com.bytedance.sdk.openadsdk.core.component.reward.draw.pn pnVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.pn) fx.this.ju().nr().fx(i);
                    if (pnVar != null) {
                        pnVar.nr(false);
                    }
                }

                private void u(com.bytedance.sdk.openadsdk.core.component.reward.draw.pn pnVar) {
                    if (pnVar != null) {
                        fx.this.w = pnVar;
                        fx.this.w.nr(true);
                        fx.this.w.u(new u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.fx.4.1
                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.fx.u
                            public void b() {
                                if (fx.this.pb + 1 >= fx.this.rh.size() || !fx.this.bc.get()) {
                                    fx.this.u.iz(1);
                                } else if (fx.this.ob()) {
                                    fx.this.a(false);
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.fx.u
                            public Map<String, Object> fx() {
                                return fx.this.u.n();
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.fx.u
                            public void nr() {
                                fx fxVar = fx.this;
                                fxVar.my = false;
                                fxVar.ju().u(true);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.fx.u
                            public void u() {
                                fx fxVar = fx.this;
                                fxVar.my = true;
                                fxVar.ju().u(false);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.fx.u
                            public void u(int i) {
                                fx.this.ja += i;
                                fx.this.bf += i;
                                fx.this.u.l(i);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.fx.u
                            public void u(long j, long j2) {
                                fx.this.my = false;
                            }
                        });
                        fx.this.my = pnVar.m();
                        fx.this.ju().u(!pnVar.jp());
                    } else {
                        fx.this.my = false;
                    }
                    fx.this.rg();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void pn(boolean z) {
        super.pn(z);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.pn pnVar = this.w;
        if (pnVar != null) {
            pnVar.fx(z);
        }
        Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.nr> it = this.rh.iterator();
        while (it.hasNext()) {
            it.next().u(z);
        }
    }

    public static boolean u(bc bcVar) {
        return (bcVar == null || !wi.u(bcVar) || TextUtils.isEmpty(bcVar.lg())) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.nr u(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.b bVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.b(this.u, this.nr, z);
        float f = this.pn;
        float f2 = this.iz;
        float[] fArrBg = {f, f2};
        if (f < 10.0f || f2 < 10.0f) {
            fArrBg = bg();
        }
        bVar.u(fArrBg);
        this.f5223a = bVar;
        return bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public nr.u u(bc bcVar, final com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar) {
        this.u.y();
        com.bytedance.sdk.openadsdk.core.component.reward.fx.u fxVar = wi.n(bcVar) ? new com.bytedance.sdk.openadsdk.core.component.reward.fx.fx(this.u, bcVar) : new com.bytedance.sdk.openadsdk.core.component.reward.fx.pn(this.u, bcVar);
        fxVar.u(y());
        return fxVar.nr(new com.bytedance.sdk.openadsdk.core.component.reward.fx.jk() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.fx.5
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void fx() {
                super.fx();
                fx.this.u.bc();
                fx.this.a(true);
                fx.this.u.mh().u("reward_retain_dialog_next", 0, "");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void nr() {
                com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.nr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void u() {
                super.u();
                com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.u();
                }
                fx.this.u.bc();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void u(Map<String, Object> map) {
        super.u(map);
        map.put("group_pos", Integer.valueOf(this.xg + 1));
        com.bytedance.sdk.openadsdk.core.component.reward.draw.pn pnVar = this.w;
        if (pnVar != null) {
            map.put("duration", Long.valueOf(pnVar.ja()));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void u(JSONObject jSONObject) {
        super.u(jSONObject);
        try {
            jSONObject.put("group_pos", this.pb + 1);
            jSONObject.put("duration", this.w.ja());
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void u(View view) {
        super.u(view);
        this.w.u(view);
    }
}
