package com.bytedance.sdk.openadsdk.core.component.reward.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.q;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.CommonEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.fx.nr;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.h;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u extends nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.nr f5223a;
    protected float b;
    protected com.bytedance.sdk.openadsdk.core.component.reward.nr.iz bg;
    protected com.bytedance.sdk.openadsdk.core.component.reward.nr.nr bq;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.iz c;
    protected com.bytedance.sdk.openadsdk.core.component.reward.nr.b dw;
    protected int fx;
    protected com.bytedance.sdk.openadsdk.core.component.reward.pn.fx h;
    protected int iz;
    protected com.bytedance.sdk.openadsdk.core.component.reward.layout.pn jk;
    protected boolean k;
    protected String l;
    protected boolean mv;
    protected boolean my;
    protected com.bytedance.sdk.openadsdk.core.nr.pn n;
    protected bc nr;
    protected boolean o;
    protected int pn;
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.pn q;
    com.bytedance.sdk.openadsdk.core.component.reward.nr.u qq;
    protected boolean s;
    protected com.bytedance.sdk.openadsdk.core.component.reward.nr.pn sx;
    protected AbstractEndCardFrameLayout t;
    protected final TTBaseVideoActivity u;
    protected int x = -1;
    protected int kj = -5;
    protected boolean z = false;
    protected boolean gi = false;
    protected int d = Integer.MIN_VALUE;
    private final com.bytedance.sdk.openadsdk.core.nativeexpress.t rh = new com.bytedance.sdk.openadsdk.core.nativeexpress.t() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.u.1
        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void a() {
            u.this.u.lf();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void b(int i) {
            u.this.u.a(i);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public int fx() {
            return u.this.kj();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void iz() {
            u uVar = u.this;
            uVar.gi = true;
            uVar.u.nb();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void jk() {
            u.this.sx.fx();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void n() {
            s.u().b(u.this.nr, "stats_reward_full_click_express_close");
            u.this.u.finish();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public int nr() {
            if (u.this.n(true)) {
                int i = u.this.u.v() ? 3 : 2;
                if (u.this.u.f()) {
                    return 5;
                }
                return i;
            }
            if (u.this.jk.nr()) {
                return 4;
            }
            if (u.this.jk.fx()) {
                return 5;
            }
            if (u.this.bg.b()) {
                return 1;
            }
            if (u.this.bg.nr()) {
                return 2;
            }
            u.this.bg.fx();
            return 3;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void pn() {
            u.this.z = false;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void setPauseFromExpressView(boolean z) {
            u.this.u.my(1);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void t() {
            u.this.u.n(3);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void u(int i, String str) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void x() {
            s.u().b(u.this.nr, "stats_reward_full_click_express_close");
            u.this.sx.u();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void b() {
            u.this.z = true;
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void fx(int i) {
            u.this.u.fx(i);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void u(boolean z) {
            u uVar = u.this;
            if (uVar.mv != z) {
                uVar.mv = z;
                uVar.sx.nr();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void u(int i) {
            if (i != 1) {
                if (i == 2) {
                    u.this.bg.z();
                    return;
                }
                if (i == 3) {
                    u.this.bg.gi();
                    return;
                } else if (i == 4) {
                    u.this.bg.x();
                    return;
                } else if (i != 5) {
                    return;
                }
            }
            if (u.this.bg.nr() || u.this.bg.fx() || u.this.bg.jp()) {
                return;
            }
            u.this.u.nr(0L, false);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void nr(int i) {
            if (yd.pn(u.this.nr)) {
                u.this.u.b(1);
            } else {
                u.this.u.u(i, false);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public long u() {
            if (u.this.n(true)) {
                hashCode();
                return ((long) u.this.kj()) * 1000;
            }
            u uVar = u.this;
            uVar.nr(uVar.iz(true));
            return u.this.h.u();
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void u(float f, float f2, float f3, float f4, int i) {
            u.this.u.u(f, f2, f3, f4, i);
        }

        @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.t
        public void u(float f) {
            com.bytedance.sdk.openadsdk.core.component.reward.pn.fx fxVar = u.this.h;
            if (fxVar != null) {
                fxVar.fx((int) (1000.0f / f));
            }
            u.this.u.su().u(f);
        }
    };

    public u(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar) {
        this.u = tTBaseVideoActivity;
        this.nr = bcVar;
        this.fx = bcVar.sv();
        this.b = bcVar.ba();
    }

    private void ge() {
        this.sx.u(false);
        this.f5223a.iz(8);
        this.f5223a.pn(8);
        this.f5223a.fx(8);
        za();
    }

    private int ob() {
        long jMax = Math.max(((long) (this.bg.d() * 1000.0d)) - this.bg.rh(), 0L);
        return Math.max((((int) (jMax / 1000)) + (((int) (jMax % 1000)) > 500 ? 1 : 0)) - tk(), 0);
    }

    public View a() {
        if (this.b != 100.0f) {
            return v();
        }
        int iZa = this.nr.za();
        return iZa != 1 ? iZa != 3 ? com.bytedance.sdk.openadsdk.res.pn.u(this.u) : com.bytedance.sdk.openadsdk.res.pn.b(this.u) : com.bytedance.sdk.openadsdk.res.pn.fx(this.u);
    }

    public void ay() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.pn pnVar = this.jk;
        if (pnVar != null) {
            pnVar.u(this.h);
        }
        if (mk() && this.bq.y()) {
            d();
        } else {
            f();
        }
    }

    public void b() {
        boolean zIz = this.jk.iz();
        if (!this.bq.pb() && !zIz) {
            my();
        }
        this.bq.u(this.jk.t());
        if (zIz) {
            this.jk.u().setBackgroundColor(-16777216);
        }
        this.f5223a.fx(!zIz);
        this.jk.fx(zIz);
        this.sx.u(gc() || !zIz);
        this.u.iz();
    }

    public int bc() {
        return (int) (this.bg.rh() / 1000);
    }

    public boolean bf() {
        return true;
    }

    public float[] bg() {
        TTBaseVideoActivity tTBaseVideoActivity = this.u;
        int iB = y.b(tTBaseVideoActivity, y.t((Context) tTBaseVideoActivity));
        float f = this.iz;
        float f2 = this.pn;
        int i = this.fx;
        if ((i == 1) != (f > f2)) {
            float f3 = f + f2;
            f2 = f3 - f2;
            f = f3 - f2;
        }
        if (i == 1) {
            f -= iB;
        } else {
            f2 -= iB;
        }
        return new float[]{f2, f};
    }

    public void bq() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.pn pnVar = this.jk;
        if (pnVar != null) {
            pnVar.u(this.h);
        }
        if (this.s) {
            this.f5223a.nr((int) (this.bg.rh() / 1000));
        }
    }

    public com.bytedance.sdk.openadsdk.core.nativeexpress.t cj() {
        return this.rh;
    }

    public void d() {
        if (this.kj < 0) {
            this.kj = this.bq.bc();
        }
        int i = this.kj;
        if (i <= 0) {
            if (i == 0) {
                this.u.b(0);
                this.sx.u(false, "奖励已领取", null, true, true);
                return;
            }
            return;
        }
        this.kj = i - 1;
        this.sx.u(false, this.kj + "s", null, true, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void fx() {
        b();
    }

    public int gi() {
        return this.h.iz();
    }

    public void h() {
        this.k = true;
    }

    public boolean iz() {
        return tk.u(this.nr) == 2;
    }

    public boolean ja() {
        return false;
    }

    public View jk() {
        if (this.t == null) {
            this.t = new CommonEndCardFrameLayout(this.u, this.nr);
        }
        return this.t;
    }

    public int jp() {
        return jk(true);
    }

    public void k() {
        AbstractEndCardFrameLayout abstractEndCardFrameLayout = this.t;
        if (abstractEndCardFrameLayout != null) {
            abstractEndCardFrameLayout.nr();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.layout.pn pnVar = this.jk;
        if (pnVar != null) {
            pnVar.b();
        }
        if (lf() || this.bq.pb()) {
            return;
        }
        this.bq.q();
    }

    public int kj() {
        return this.h.pn() + this.h.nr();
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.layout.pn l() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.pn pnVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.pn(this.u);
        this.jk = pnVar;
        return pnVar;
    }

    public int m() {
        if (mk() && this.bq.y()) {
            return this.kj;
        }
        if (kw()) {
            return n(false) ? a(true) : (int) Math.max((xw() * (this.nr.na() / 100.0f)) - kj(), 0.0f);
        }
        return jp();
    }

    public AbstractEndCardFrameLayout mv() {
        return this.t;
    }

    public void my() {
        this.f5223a.my();
        this.sx.nr(this.nr.uo());
        this.sx.pn(nb());
        this.f5223a.iz(0);
        this.f5223a.pn(0);
    }

    public void n() {
        boolean z;
        if (this.s) {
            z = false;
        } else {
            boolean z2 = this instanceof jk;
            z = true;
            if (yd.q(this.nr)) {
                z2 = true;
            }
            if (this.b == 100.0f) {
                z = z2;
            }
        }
        if (z) {
            oa();
        }
        if ((this instanceof jk) || this.b == 100.0f) {
            return;
        }
        try {
            final View decorView = this.u.getWindow().getDecorView();
            decorView.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.u.5
                @Override // java.lang.Runnable
                public void run() {
                    int iT = (int) (y.t((Context) u.this.u) / 2.0f);
                    int paddingLeft = decorView.getPaddingLeft();
                    int paddingRight = decorView.getPaddingRight();
                    int paddingTop = decorView.getPaddingTop();
                    int paddingBottom = decorView.getPaddingBottom();
                    if (u.this.fx == 1 && !y.nr()) {
                        paddingTop += iT;
                        paddingBottom += iT;
                    }
                    if (u.this.fx == 2 && !y.nr()) {
                        paddingLeft += iT;
                        paddingRight += iT;
                    }
                    decorView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void nr(Map<String, Object> map) {
    }

    public boolean o() {
        return false;
    }

    public void oa() {
        if (this.o || Build.VERSION.SDK_INT == 26) {
            return;
        }
        TTBaseVideoActivity tTBaseVideoActivity = this.u;
        tTBaseVideoActivity.setTheme(q.x(tTBaseVideoActivity, "tt_full_screen_interaction"));
        y.x((Activity) this.u);
        this.o = true;
    }

    public com.bytedance.sdk.openadsdk.core.video.nr.nr pb() {
        return null;
    }

    public void pn() {
        this.u.x(0);
        this.sx.u(gc());
        float f = this.pn;
        float f2 = this.iz;
        float[] fArrBg = {f, f2};
        if (f < 10.0f || f2 < 10.0f) {
            fArrBg = bg();
        }
        this.jk.u(this.nr, h.u(this.u.kj() ? 7 : 8, String.valueOf(jp.t(this.nr)), fArrBg[0], fArrBg[1]), this.l, this.mv, this.u.u());
        this.f5223a.fx(false);
        this.jk.fx(true);
        this.jk.u(this.rh);
        this.jk.u(new com.bytedance.sdk.openadsdk.core.nativeexpress.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.u.4
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
            public void u(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
            public void u(View view, String str, int i) {
                if (u.this.bq.pb()) {
                    return;
                }
                u.this.bq.nr();
                u.this.u.bg();
                u.this.u.x(8);
                u.this.sx.u(true);
                com.bytedance.sdk.component.utils.jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.u.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.u.sx();
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
            public void u(View view, float f3, float f4) {
                if (u.this.bq.pb()) {
                    return;
                }
                u.this.bq.nr();
                u.this.u.bg();
                u.this.u.x(8);
                u uVar = u.this;
                uVar.x = uVar.jk.a();
                u uVar2 = u.this;
                if (uVar2.x == 0) {
                    yd.nr(uVar2.nr, true);
                }
                u.this.fx();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.u
            public void nr(View view, int i) {
            }
        });
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) this.c.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(this.u.xw());
        ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) this.q.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(this.u.xw());
        this.u.u((com.bytedance.sdk.openadsdk.core.nr.u.fx.fx) this.c.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class));
        this.u.u((com.bytedance.sdk.openadsdk.core.nr.u.fx.fx) this.q.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.fx.class));
        this.jk.u(this.c, this.q);
        this.jk.n();
    }

    public final int q() {
        return this.x;
    }

    public void qq() {
        yd();
    }

    public int rh() {
        return 0;
    }

    public boolean su() {
        return this.gi;
    }

    public FrameLayout sx() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.pn pnVar;
        return bg.b(this.nr) ? this.t.getVideoArea() : (iz() && (pnVar = this.jk) != null && pnVar.iz()) ? this.jk.u() : this.f5223a.l();
    }

    public View t() {
        return com.bytedance.sdk.openadsdk.res.pn.pn(this.u);
    }

    public int tk() {
        return this.h.nr();
    }

    public void u(int i) {
    }

    public View v() {
        int i = (int) (this.b * 1000.0f);
        return this.fx == 1 ? i != 666 ? i != 1000 ? i != 1500 ? i != 1777 ? com.bytedance.sdk.openadsdk.res.pn.d(this.u) : com.bytedance.sdk.openadsdk.res.pn.gi(this.u) : com.bytedance.sdk.openadsdk.res.pn.kj(this.u) : com.bytedance.sdk.openadsdk.res.pn.z(this.u) : com.bytedance.sdk.openadsdk.res.pn.qq(this.u) : i != 562 ? i != 666 ? i != 1000 ? i != 1500 ? com.bytedance.sdk.openadsdk.res.pn.bf(this.u) : com.bytedance.sdk.openadsdk.res.pn.rh(this.u) : com.bytedance.sdk.openadsdk.res.pn.z(this.u) : com.bytedance.sdk.openadsdk.res.pn.h(this.u) : com.bytedance.sdk.openadsdk.res.pn.ja(this.u);
    }

    public boolean w() {
        return !this.s && this.fx == 1 && yd.q(this.nr) && this.nr.ba() != 100.0f;
    }

    public int wi() {
        return this.h.fx();
    }

    public boolean x() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.pn pnVar;
        return iz() && (pnVar = this.jk) != null && pnVar.iz();
    }

    public int xg() {
        return kw() ? kj() : bc() + tk();
    }

    public int xw() {
        return com.bytedance.sdk.openadsdk.core.y.q.fx(this.nr) ? com.bytedance.sdk.openadsdk.core.y.q.pn(this.nr) : yd.k(this.nr);
    }

    public int y() {
        int i = this.d;
        return i == Integer.MIN_VALUE ? iz(true) : i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean yd() {
        return yd.o(this.nr) || this.bq.y();
    }

    public int z() {
        return this.h.pn();
    }

    public void fx(boolean z) {
        if (this.nr.ba() != 100.0f) {
            if (dw.nr().jk(jp.t(this.nr)) || this.s) {
                if (com.bytedance.sdk.openadsdk.core.l.fx.fx.iz.fx && com.bytedance.sdk.openadsdk.core.l.fx.fx.iz.nr && u(this.nr)) {
                    com.bytedance.sdk.openadsdk.core.l.fx.fx.iz.nr = false;
                    com.bytedance.sdk.openadsdk.core.l.fx.fx.iz.fx = false;
                    this.u.finish();
                } else if (z && !com.bytedance.sdk.openadsdk.core.l.fx.fx.iz.fx) {
                    this.u.finish();
                } else {
                    if (!this.bq.ja() || com.bytedance.sdk.openadsdk.core.l.fx.fx.iz.fx) {
                        return;
                    }
                    this.u.finish();
                }
            }
        }
    }

    public int iz(boolean z) {
        return (mk() && this.bq.y()) ? this.kj : kw() ? n(false) ? a(z) : Math.max(xw() - kj(), 0) : x(z);
    }

    public void nr() {
        tm();
        if (p()) {
            yd.u(this.nr, true);
        }
        ge();
        if (eh()) {
            this.bq.nr();
        }
        if (iz()) {
            pn();
        } else {
            this.u.bg();
            fx();
        }
    }

    public void u(int i, int i2, Intent intent) {
    }

    public int x(boolean z) {
        return z ? jk(false) : ob();
    }

    public void u(View view) {
    }

    private int jk(boolean z) {
        long jRh = this.bg.rh();
        if (z) {
            long jMax = Math.max(Math.min(yd.u(), (long) ((this.bg.d() * 1000.0d) * ((double) (this.nr.na() / 100.0f)))) - (jRh + (((long) tk()) * 1000)), 0L);
            return (int) Math.max(((long) ((int) (jMax / 1000))) + (((int) (jMax % 1000)) > 500 ? 1L : 0L), 0L);
        }
        long jMin = Math.min(yd.u(), (long) (this.bg.d() * 1000.0d));
        long jTk = ((long) tk()) * 1000;
        long jD = (long) ((this.bg.d() % 1.0d) * 1000.0d);
        if (jD > 0) {
            jRh -= 1000 - jD;
        }
        return Math.round((jMin - (jRh + jTk)) / 1000.0f);
    }

    public void u(Map<String, Object> map) {
    }

    public void u(JSONObject jSONObject) {
    }

    public void u(com.bytedance.sdk.openadsdk.core.component.reward.nr.pn pnVar, com.bytedance.sdk.openadsdk.core.component.reward.nr.iz izVar, com.bytedance.sdk.openadsdk.core.component.reward.nr.nr nrVar, com.bytedance.sdk.openadsdk.core.component.reward.nr.b bVar, com.bytedance.sdk.openadsdk.core.component.reward.nr.u uVar) {
        this.sx = pnVar;
        this.bg = izVar;
        this.bq = nrVar;
        this.dw = bVar;
        this.qq = uVar;
    }

    private int a(boolean z) {
        double dMax;
        float fNa = this.nr.na() / 100.0f;
        if (z) {
            dMax = Math.max(Math.min(zx.x(this.nr) * ((double) fNa), yd.u() / 1000) - ((double) kj()), 0.0d);
        } else {
            dMax = Math.max(zx.x(this.nr) - ((double) kj()), 0.0d);
        }
        return (int) dMax;
    }

    public void b(boolean z) {
        float f = this.b;
        if (f != 100.0f) {
            int i = (int) (f * 1000.0f);
            if (this.fx == 1) {
                if (i != 666 && i != 1000 && i != 1500 && i != 1777) {
                    this.f5223a.b(z ? 0 : 8);
                    return;
                } else {
                    this.f5223a.b(8);
                    return;
                }
            }
        } else {
            if (z) {
                if (this.fx == 1) {
                    this.f5223a.b(0);
                }
                if (com.bytedance.sdk.openadsdk.core.video.fx.u.u(this.nr)) {
                    this.f5223a.iz(0);
                    return;
                }
                return;
            }
            if (this.fx != 1) {
                return;
            }
        }
        this.f5223a.b(8);
    }

    public void u(String str, boolean z, boolean z2, com.bytedance.sdk.openadsdk.core.component.reward.pn.fx fxVar) {
        this.l = str;
        this.mv = z;
        this.s = z2;
        this.h = fxVar;
    }

    public void nr(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.pn pnVar = this.jk;
        if (pnVar != null) {
            pnVar.pn();
        }
    }

    public void fx(int i) {
        this.h.u(i);
    }

    public void nr(int i) {
        this.d = i;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.nr.pn u() {
        return this.sx;
    }

    public final void u(com.bytedance.sdk.openadsdk.core.nr.pn pnVar) {
        this.n = pnVar;
        TTBaseVideoActivity tTBaseVideoActivity = this.u;
        bc bcVar = this.nr;
        String str = this.l;
        this.c = new com.bytedance.sdk.openadsdk.core.nativeexpress.iz(tTBaseVideoActivity, bcVar, str, jp.nr(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.u.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.iz, com.bytedance.sdk.openadsdk.core.nr.nr, com.bytedance.sdk.openadsdk.core.nr.b
            public void u(View view, com.bytedance.sdk.openadsdk.core.kj.jk jkVar) {
                if (bc.pn(this.u)) {
                    return;
                }
                super.u(view, jkVar);
                u.this.u.u(2);
            }
        };
        TTBaseVideoActivity tTBaseVideoActivity2 = this.u;
        bc bcVar2 = this.nr;
        String str2 = this.l;
        this.q = new com.bytedance.sdk.openadsdk.core.nativeexpress.pn(tTBaseVideoActivity2, bcVar2, str2, jp.nr(str2)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.u.3
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.pn, com.bytedance.sdk.openadsdk.core.nr.nr, com.bytedance.sdk.openadsdk.core.nr.b
            public void u(View view, com.bytedance.sdk.openadsdk.core.kj.jk jkVar) {
                if (bc.pn(this.u)) {
                    return;
                }
                super.u(view, jkVar);
                com.bytedance.sdk.openadsdk.core.nr.u.nr nrVar = (com.bytedance.sdk.openadsdk.core.nr.u.nr) this.n.u(com.bytedance.sdk.openadsdk.core.nr.u.nr.class);
                if (nrVar == null || !nrVar.nr(view)) {
                    return;
                }
                u.this.u.u(2);
            }
        };
        this.t.setClickListener(this.n);
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.layout.nr u(boolean z) {
        if (this.b != 100.0f) {
            this.f5223a = new com.bytedance.sdk.openadsdk.core.component.reward.layout.x(this.u, this.nr, z);
        } else {
            this.f5223a = new com.bytedance.sdk.openadsdk.core.component.reward.layout.fx(this.u, this.nr, z);
        }
        return this.f5223a;
    }

    public void pn(boolean z) {
        this.mv = z;
        this.bg.fx(z);
    }

    public void c() {
    }

    public void dw() {
    }

    public void mh() {
    }

    public void s() {
    }

    public void wq() {
    }

    public void u(int i, int i2) {
        this.pn = i;
        this.iz = i2;
    }

    private boolean u(bc bcVar) {
        return (bcVar.qf() == 4) && !TextUtils.isEmpty(bcVar.kd());
    }

    public nr.u u(bc bcVar, final com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.fx.fx fxVar = new com.bytedance.sdk.openadsdk.core.component.reward.fx.fx(this.u, bcVar);
        fxVar.u(y());
        fxVar.nr(xg());
        fxVar.fx(this.u.rh());
        fxVar.b(this.u.ja());
        fxVar.fx(this.z);
        fxVar.b(yd.gi(bcVar) && !this.u.x.get());
        this.u.y();
        return fxVar.nr(new com.bytedance.sdk.openadsdk.core.component.reward.fx.jk() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.u.6
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void fx() {
                com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.fx();
                }
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
                com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.u();
                }
                u.this.u.bc();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.fx.jk
            public void u(int i) {
                com.bytedance.sdk.openadsdk.core.component.reward.fx.jk jkVar2 = jkVar;
                if (jkVar2 != null) {
                    jkVar2.u(i);
                }
            }
        });
    }
}
