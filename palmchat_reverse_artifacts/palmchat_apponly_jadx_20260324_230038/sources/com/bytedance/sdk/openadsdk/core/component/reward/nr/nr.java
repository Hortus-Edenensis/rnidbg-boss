package com.bytedance.sdk.openadsdk.core.component.reward.nr;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.b.n;
import com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.ja;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.bg;
import com.bytedance.sdk.openadsdk.core.kj.gi;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.q;
import com.bytedance.sdk.openadsdk.core.y.y;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.nr.u f5240a;
    private boolean b;
    private boolean c;
    private String fx;
    private int iz;
    private com.bytedance.sdk.openadsdk.core.nr.nr jk;
    private boolean k;
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx l;
    private final com.bytedance.sdk.openadsdk.core.component.reward.view.u mv;
    private pn n;
    private bc nr;
    private int pn;
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.u s;
    private com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr t;
    private final TTBaseVideoActivity u;
    private AbstractEndCardFrameLayout x;
    private int my = -1;
    private boolean o = false;
    private final AtomicBoolean sx = new AtomicBoolean(false);
    private final AtomicBoolean bg = new AtomicBoolean(false);
    private int dw = 0;
    private boolean bq = false;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.reward.nr.nr$nr, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0247nr {
        pn fx();

        void nr();

        void u();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u();
    }

    public nr(TTBaseVideoActivity tTBaseVideoActivity) {
        this.u = tTBaseVideoActivity;
        this.mv = new com.bytedance.sdk.openadsdk.core.component.reward.view.u(tTBaseVideoActivity);
    }

    private void oa() {
        try {
            if (!gi.u(this.nr) || this.c) {
                return;
            }
            float[] fArrU = com.bytedance.sdk.openadsdk.core.component.reward.pn.nr.u(this.u.getApplicationContext(), this.nr.ba(), this.nr.sv());
            float f = fArrU[0];
            float f2 = fArrU[1];
            if (this.nr.ba() == 100.0f) {
                this.pn = (int) f;
                this.iz = (int) f2;
                return;
            }
            int[] iArrU = com.bytedance.sdk.openadsdk.core.component.reward.pn.nr.u(this.u.getApplicationContext(), this.nr.ba(), this.nr.ng(), this.nr.sv());
            int i = iArrU[0];
            int i2 = iArrU[1];
            int i3 = iArrU[2];
            int i4 = iArrU[3];
            float f3 = i;
            float f4 = i3;
            this.pn = (int) ((f - f3) - f4);
            float f5 = i2;
            float f6 = i4;
            this.iz = (int) ((f2 - f5) - f6);
            this.u.getWindow().getDecorView().setPadding(y.fx(this.u, f3), y.fx(this.u, f5), y.fx(this.u, f4), y.fx(this.u, f6));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xw() {
        if (this.u.isDestroyed()) {
            return;
        }
        Toast toast = new Toast(this.u);
        toast.setDuration(1);
        toast.setGravity(17, 0, 0);
        LinearLayout linearLayout = new LinearLayout(this.u);
        linearLayout.setBackgroundColor(Color.parseColor("#CC161823"));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(y.fx(this.u, 20.0f), y.fx(this.u, 12.0f), y.fx(this.u, 20.0f), y.fx(this.u, 12.0f));
        TextView textView = new TextView(this.u);
        textView.setTextColor(-1);
        textView.setText("请求异常无法发放奖励，请关闭重试");
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.show();
        this.u.xg().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.5
            @Override // java.lang.Runnable
            public void run() {
                nr.this.xw();
            }
        }, 6000L);
    }

    public void a() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.z();
        }
    }

    public int bc() {
        return this.dw;
    }

    public void bf() {
        u(1000L);
    }

    public boolean bg() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            return uVar.fx();
        }
        return false;
    }

    public boolean bq() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            return uVar.b();
        }
        return false;
    }

    public void c() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr nrVar = this.t;
        if (nrVar != null) {
            this.s = nrVar;
        }
    }

    public void d() {
        fx(false);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx fxVar = this.l;
        if (fxVar != null) {
            fxVar.iz();
        }
        if (this.o) {
            xg();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr nrVar = this.t;
        if (nrVar != null) {
            this.s = nrVar;
        }
    }

    public boolean dw() {
        if (this.o) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        return uVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx ? this.l.rh() : uVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr;
    }

    public ja gi() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx fxVar = this.l;
        if (fxVar != null) {
            return fxVar.ja();
        }
        return null;
    }

    public boolean h() {
        return this.s instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx;
    }

    public boolean ja() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr nrVar = this.t;
        if (nrVar == null) {
            return false;
        }
        return nrVar.dw();
    }

    public int jk() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            return uVar.jk();
        }
        return 0;
    }

    public void jp() {
        this.dw = yd.nr(this.nr, this.u.yd().m());
        this.bg.set(yd.dw(this.nr));
        com.bytedance.sdk.openadsdk.core.n.b.fx = true;
    }

    public boolean k() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            return uVar.x();
        }
        return false;
    }

    public void kj() {
        fx(true);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx fxVar = this.l;
        if (fxVar == null || !fxVar.fx()) {
            pn(false);
        } else {
            this.l.u(this.u.yd() instanceof n ? 2 : 0);
        }
        if (this.t != null) {
            this.s = this.l;
        }
    }

    public void l() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.o();
        }
    }

    public String m() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        return uVar != null ? uVar.qq() : "endcard";
    }

    public void mv() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.bg();
        }
    }

    public void my() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.n();
        }
    }

    public void n() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.my();
        }
    }

    public boolean o() {
        boolean zSx = zx.t(this.nr) ? sx() : bg();
        if (this.s == null && !TextUtils.isEmpty(zx.a(this.nr)) && dw.nr().ss()) {
            return true;
        }
        if (bq()) {
            return zSx || q.nr(this.nr);
        }
        return false;
    }

    public boolean pb() {
        return this.sx.get();
    }

    public void q() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr nrVar = this.t;
        if (nrVar != null) {
            nrVar.a();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx fxVar = this.l;
        if (fxVar != null) {
            fxVar.a();
        }
    }

    public void qq() {
        if (q.fx(this.nr) || y()) {
            return;
        }
        this.my = Math.max(u(this.nr), 0);
        u(0L);
    }

    public boolean rh() {
        return this.k;
    }

    public void s() {
        if (!this.u.yd().yd()) {
            qq();
        }
        this.n.fx(false);
        this.n.iz(false);
        this.n.nr(this.nr.uo());
        this.n.x(false);
        oa();
        if (this.s == null && dw.nr().ss() && !TextUtils.isEmpty(zx.a(this.nr))) {
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr nrVar = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr(this.u, this.nr, this.fx, this.pn, this.iz, this.b, this.x);
            this.t = nrVar;
            nrVar.u(this.b, this.u.xw(), this.n.b());
            this.t.u(this.f5240a.x(), this.jk);
            nr();
            this.s = this.t;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar == null) {
            this.n.pn(false);
            return;
        }
        uVar.pn();
        this.s.u(1);
        this.n.pn(true ^ (this.s instanceof com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr));
    }

    public boolean sx() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            return uVar.nr();
        }
        return false;
    }

    public String t() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        return uVar != null ? uVar.t() : "";
    }

    public boolean wq() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx fxVar = this.l;
        if (fxVar != null) {
            return fxVar.bf();
        }
        return false;
    }

    public void x() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr nrVar = this.t;
        if (nrVar != null) {
            nrVar.k();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx fxVar = this.l;
        if (fxVar != null) {
            fxVar.k();
        }
    }

    public void xg() {
        this.mv.fx();
    }

    public boolean y() {
        return pb() && this.bg.get();
    }

    public boolean z() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx fxVar = this.l;
        return fxVar != null && fxVar.fx();
    }

    public void b() {
        if (y()) {
            return;
        }
        int i = this.my;
        if (i >= 0) {
            this.u.nr(i);
            u(0L);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.kj();
        }
    }

    public void fx() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.l();
        }
    }

    public void iz() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.sx();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar2 = this.s;
        if (uVar2 != null) {
            uVar2.s();
        }
    }

    public void nr() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx fxVar = this.l;
        if (fxVar != null) {
            fxVar.gi();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr nrVar = this.t;
        if (nrVar != null) {
            nrVar.d();
        }
    }

    public void pn() {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.mv();
        }
    }

    public void u(pn pnVar, com.bytedance.sdk.openadsdk.core.component.reward.nr.u uVar, boolean z, String str, int i, int i2) {
        this.b = z;
        this.n = pnVar;
        this.f5240a = uVar;
        this.fx = str;
        this.pn = i;
        this.iz = i2;
    }

    public void fx(boolean z) {
        this.k = z;
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx fxVar = this.l;
        if (fxVar != null) {
            fxVar.iz(z);
        }
    }

    public void pn(boolean z) {
        if (pb() || rh()) {
            this.o = true;
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
            if (uVar != null) {
                uVar.bq();
                this.s.iz();
            }
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx fxVar = this.l;
            if (fxVar != null) {
                fxVar.q();
            }
            pn pnVar = this.n;
            if (pnVar != null) {
                pnVar.x();
            }
            if (this.n != null && this.nr.my()) {
                y.u(this.n.b(), 0);
            }
            s.u().iz(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.3
                @Override // com.bytedance.sdk.openadsdk.t.u.u
                public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                    com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarIz = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u(nr.this.b ? 7 : 8).fx(String.valueOf(jp.t(nr.this.nr))).iz(jp.k(nr.this.nr));
                    nrVarIz.nr(nr.this.jk()).x(nr.this.t());
                    nrVarIz.n(nr.this.nr.ap()).b(nr.this.nr.lk());
                    return nrVarIz;
                }
            });
            this.mv.u();
            if (bg.u(this.nr)) {
                this.u.mv(8);
            }
            this.n.u(true);
            this.n.x(false);
            this.u.xg().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.4
                @Override // java.lang.Runnable
                public void run() {
                    nr.this.n.u(true);
                    if (nr.this.n.pn()) {
                        return;
                    }
                    nr.this.n.u(false, null, null, true, true);
                    if (nr.this.wq() && nr.this.b) {
                        nr.this.xw();
                    }
                }
            }, 500L);
            if (z) {
                if (!yd.o(this.nr)) {
                    this.n.u(false, null, null, true, true);
                }
                this.n.pn(false);
                this.n.nr(this.nr.uo());
            }
        }
    }

    public void iz(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx fxVar = this.l;
        if (fxVar != null) {
            fxVar.pn(z);
        }
    }

    public void nr(boolean z) {
        if (this.my >= 0) {
            this.u.k();
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.b(z);
        }
    }

    public void b(boolean z) {
        this.sx.set(z);
    }

    public void u(bc bcVar, com.bytedance.sdk.openadsdk.core.nr.nr nrVar, com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar, AbstractEndCardFrameLayout abstractEndCardFrameLayout) {
        if (this.bq) {
            return;
        }
        this.bq = true;
        this.nr = bcVar;
        this.jk = nrVar;
        this.mv.u(bcVar);
        this.x = abstractEndCardFrameLayout;
        u();
        u(uVar);
        this.c = com.bytedance.sdk.openadsdk.core.my.b.u(String.valueOf(jp.t(this.nr)));
    }

    public void nr(int i, int i2) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx fxVar = this.l;
        if (fxVar != null) {
            fxVar.nr(i, i2);
        }
    }

    public void u() {
        if (this.nr.rh() == 1) {
            return;
        }
        if (q.nr(this.nr)) {
            this.l = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx(this.u, this.nr, this.fx, this.pn, this.iz, this.b, this.x);
        }
        if (!TextUtils.isEmpty(zx.a(this.nr)) && !dw.nr().ss()) {
            this.t = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr(this.u, this.nr, this.fx, this.pn, this.iz, this.b, this.x);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.l;
        if (uVar == null) {
            uVar = this.t;
        }
        this.s = uVar;
    }

    public void u(long j, long j2, int i) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.u(j, j2, i);
        }
    }

    public void u(int i, int i2) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.u(i, i2);
        }
    }

    public void u(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.nr(z);
        }
    }

    public void u(com.bytedance.sdk.openadsdk.core.multipro.nr.u uVar) {
        Map<String, Object> mapXw = this.u.xw();
        this.mv.u(this.jk);
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx fxVar = this.l;
        if (fxVar != null) {
            fxVar.u(uVar);
            this.l.u(this.b, mapXw, this.n.b());
            this.l.u(this.f5240a.x(), this.jk);
            this.l.u(new u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.u
                public void u() {
                    nr.this.pn(false);
                }
            });
            this.l.u(new InterfaceC0247nr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.2
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.InterfaceC0247nr
                public pn fx() {
                    return nr.this.n;
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.InterfaceC0247nr
                public void nr() {
                    nr.this.u.l();
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.InterfaceC0247nr
                public void u() {
                    nr.this.u.nr(true, true);
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr nrVar = this.t;
        if (nrVar != null) {
            nrVar.u(this.b, mapXw, this.n.b());
            this.t.u(this.f5240a.x(), this.jk);
        }
    }

    public void u(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.u(map);
        }
    }

    public void u(boolean z, int i, String str) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.u(z, i, str);
        }
    }

    private int u(bc bcVar) {
        return bcVar.im();
    }

    private void u(long j) {
        int i = this.my / 1000;
        if (!yd.o(this.nr)) {
            if (i > 0) {
                this.n.u(false, i + "s", null, false, false);
            } else {
                this.n.u(false, null, null, true, true);
            }
        }
        if (i > 0) {
            this.my = (int) (((long) this.my) - j);
            this.u.u(j);
        }
    }

    public void u(bc bcVar, com.bytedance.sdk.openadsdk.core.nr.nr nrVar) {
        this.nr = bcVar;
        this.jk = nrVar;
        this.mv.u(bcVar);
        this.mv.u(this.jk);
        if (q.nr(bcVar)) {
            if (this.l == null) {
                this.l = new com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx(this.u, bcVar, this.fx, this.pn, this.iz, this.b, this.x);
            }
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.fx fxVar = this.l;
            this.s = fxVar;
            fxVar.u(new u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.6
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.u
                public void u() {
                    nr.this.pn(false);
                }
            });
            this.l.u(new InterfaceC0247nr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.7
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.InterfaceC0247nr
                public pn fx() {
                    return nr.this.n;
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.InterfaceC0247nr
                public void nr() {
                    nr.this.u.l();
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.InterfaceC0247nr
                public void u() {
                    nr.this.u.nr(true, true);
                }
            });
        } else {
            this.s = this.t;
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
            if (uVar != null) {
                uVar.u(this.nr);
                this.s.u(this.b, this.u.xw(), this.n.b());
                this.s.u(this.f5240a.x(), this.jk);
                nr();
            }
        } catch (Throwable unused) {
        }
    }

    public void u(final String str) {
        this.u.xg().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.nr.nr.8
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                nr.this.mv.u(str);
            }
        });
    }

    public void u(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.u uVar = this.s;
        if (uVar != null) {
            uVar.u(jSONObject);
        }
    }

    public void u(com.bytedance.sdk.component.adexpress.nr.s sVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.endcard.nr nrVar = this.t;
        if (nrVar == null) {
            return;
        }
        nrVar.u(sVar);
    }
}
