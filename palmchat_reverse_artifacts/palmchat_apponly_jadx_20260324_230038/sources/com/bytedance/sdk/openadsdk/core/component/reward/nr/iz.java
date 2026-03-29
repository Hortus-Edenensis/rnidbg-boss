package com.bytedance.sdk.openadsdk.core.component.reward.nr;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.bytedance.sdk.openadsdk.core.video.nr.u;
import com.bytedance.sdk.openadsdk.gi.jk;
import com.bytedance.sdk.openadsdk.gi.t;
import com.bytedance.sdk.openadsdk.iz.fx.o;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    protected long b;
    boolean iz;
    private TTBaseVideoActivity jk;
    private com.bytedance.sdk.openadsdk.core.nr.u k;
    private FrameLayout l;
    private String mv;
    private com.bykv.vk.openvk.component.video.api.fx.iz my;
    long n;
    protected int pn;
    private long s;
    private bc t;
    com.bykv.vk.openvk.component.video.api.b.fx x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5239a = 210;
    boolean u = false;
    protected boolean nr = false;
    protected boolean fx = false;
    private boolean o = false;

    public iz(TTBaseVideoActivity tTBaseVideoActivity) {
        this.jk = tTBaseVideoActivity;
    }

    private void xw() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar == null || fxVar.o() == null) {
            return;
        }
        this.n = this.x.t();
        if (this.x.o().jk() || !this.x.o().a()) {
            this.x.iz();
            this.x.a();
            this.nr = true;
        }
    }

    public void a() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            fxVar.jk();
        }
    }

    public boolean b() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        return fxVar != null && fxVar.c();
    }

    public void bc() {
        try {
            com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
            if (fxVar instanceof com.bytedance.sdk.openadsdk.core.video.nr.u) {
                ((com.bytedance.sdk.openadsdk.core.video.nr.u) fxVar).mh();
            }
        } catch (Throwable unused) {
        }
    }

    public boolean bf() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar == null) {
            return false;
        }
        return fxVar.fx();
    }

    public void bg() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar == null || fxVar.o() == null) {
            return;
        }
        this.x.o().b();
    }

    public long bq() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            return fxVar.s() + this.x.l();
        }
        return 0L;
    }

    public boolean c() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            if (fxVar.o() != null) {
                com.bykv.vk.openvk.component.video.api.u uVarO = this.x.o();
                if (uVarO.s() || uVarO.k()) {
                    ((com.bytedance.sdk.openadsdk.core.video.nr.u) this.x).w();
                    return true;
                }
            } else if (pn()) {
                u(false);
                ((com.bytedance.sdk.openadsdk.core.video.nr.u) this.x).w();
                return true;
            }
        }
        return false;
    }

    public double d() {
        double dX = zx.x(this.t);
        return (zx.k(this.t) == null || this.t.de() <= 0 || dX <= ((double) this.t.de())) ? dX : this.t.de();
    }

    public long dw() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            return fxVar.s();
        }
        return 0L;
    }

    public boolean fx() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        return (fxVar == null || fxVar.o() == null || !this.x.o().s()) ? false : true;
    }

    public void gi() {
        try {
            this.jk.k(1);
        } catch (Throwable th) {
            k.nr("TTBaseVideoActivity", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public int h() {
        return this.pn;
    }

    public long iz() {
        return this.n;
    }

    public com.bytedance.sdk.openadsdk.core.video.nr.u ja() {
        return (com.bytedance.sdk.openadsdk.core.video.nr.u) xg();
    }

    public void jk() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            fxVar.nr();
        }
    }

    public boolean jp() {
        return this.fx;
    }

    public int k() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            return fxVar.k();
        }
        return 0;
    }

    public void kj() {
        x();
    }

    public boolean l() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            return fxVar.pn();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void m() {
        boolean zU;
        o.u uVar = new o.u();
        uVar.nr(o());
        uVar.fx(bq());
        uVar.u(my());
        uVar.pn(3);
        uVar.iz(sx());
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar instanceof com.bytedance.sdk.openadsdk.core.video.nr.u) {
            ((com.bytedance.sdk.openadsdk.core.video.nr.u) fxVar).dw.fx(32);
            zU = ((com.bytedance.sdk.openadsdk.core.video.nr.u) this.x).dw.u(2);
        } else {
            zU = 0;
        }
        com.bytedance.sdk.openadsdk.iz.nr.b.u(wq(), uVar, this.jk.n(), !zU);
    }

    public boolean mv() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            return fxVar.bg();
        }
        return false;
    }

    public long my() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        return fxVar != null ? fxVar.t() : this.n;
    }

    public void n() {
        if (this.x != null && nr()) {
            this.x.nr(true);
        }
    }

    public boolean nr() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        return (fxVar == null || fxVar.o() == null || !this.x.o().mv()) ? false : true;
    }

    public long o() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            return fxVar.l();
        }
        return 0L;
    }

    public boolean pb() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar == null || fxVar.o() == null) {
            return false;
        }
        return this.x.o().iz();
    }

    public boolean pn() {
        return this.nr;
    }

    public boolean q() {
        return this.x != null;
    }

    public boolean qq() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        return fxVar != null && fxVar.o() == null;
    }

    public long rh() {
        if (t()) {
            double dIz = zx.o(this.t).iz() * 1000.0d * ((double) ja().xw());
            long j = this.b;
            if (dIz - j > 210.0d) {
                long j2 = (long) (j + dIz);
                this.s = j2;
                return j2;
            }
        }
        return Math.max(this.b, this.s);
    }

    public long s() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            return fxVar.s();
        }
        return 0L;
    }

    public int sx() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            return fxVar.mv();
        }
        return 0;
    }

    public boolean t() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            return fxVar.b();
        }
        return false;
    }

    public void u(bc bcVar) {
        this.t = bcVar;
    }

    public com.bykv.vk.openvk.component.video.api.b.nr wq() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            return fxVar.sx();
        }
        return null;
    }

    public void x() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar == null) {
            return;
        }
        fxVar.a();
        this.x = null;
    }

    public com.bykv.vk.openvk.component.video.api.b.fx xg() {
        return this.x;
    }

    public void y() {
        this.fx = true;
    }

    public void z() {
        try {
            this.jk.s(1);
        } catch (Throwable th) {
            k.nr("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
        }
    }

    public void fx(boolean z) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            fxVar.nr(z);
        }
    }

    public void nr(boolean z) {
        if (this.x == null) {
            return;
        }
        int i = z ? pb() ? 2 : 4 : pb() ? 0 : 1;
        o.u uVar = new o.u();
        uVar.nr(o());
        uVar.fx(bq());
        uVar.u(my());
        uVar.fx(1 ^ (pb() ? 1 : 0));
        uVar.b(i);
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (!(fxVar instanceof com.bytedance.sdk.openadsdk.core.video.nr.u) || ((com.bytedance.sdk.openadsdk.core.video.nr.u) fxVar).dw.u(128)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.video.nr.u) this.x).dw.fx(128);
        com.bytedance.sdk.openadsdk.iz.nr.b.fx(this.x.sx(), uVar);
    }

    public void u(FrameLayout frameLayout, String str, boolean z) {
        if (this.o) {
            return;
        }
        this.o = true;
        this.l = frameLayout;
        this.mv = str;
        this.iz = z;
        if (z) {
            this.x = new com.bytedance.sdk.openadsdk.core.component.reward.iz.nr(this.jk, frameLayout, this.t, this.k);
        } else {
            this.x = new com.bytedance.sdk.openadsdk.core.component.reward.iz.u(this.jk, frameLayout, this.t, this.k);
        }
        this.pn = (int) d();
    }

    public boolean u() {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        return (fxVar == null || fxVar.o() == null || !this.x.o().a()) ? false : true;
    }

    public void u(boolean z) {
        this.nr = z;
    }

    public void u(long j) {
        this.n = j;
    }

    public void u(long j, boolean z) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar == null || this.fx) {
            return;
        }
        if (j != 0) {
            fxVar.u(j);
            this.x.nr(z);
        } else {
            fxVar.n();
        }
    }

    public void nr(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            fxVar.nr(map);
        }
    }

    public void nr(long j) {
        this.b = j;
        if (!l() && t()) {
            this.pn = (int) Math.max(0L, Math.round(d() - ((this.b + (zx.o(this.t).iz() * 1000.0d)) / 1000.0d)));
        } else {
            this.pn = Math.max(0, (int) (d() - (this.b / 1000)));
        }
    }

    public void u(Map<String, Object> map) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar == null || this.fx) {
            return;
        }
        fxVar.u(map);
    }

    public void u(u.InterfaceC0302u interfaceC0302u) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar instanceof com.bytedance.sdk.openadsdk.core.video.nr.u) {
            ((com.bytedance.sdk.openadsdk.core.video.nr.u) fxVar).u(interfaceC0302u);
        }
    }

    public boolean u(long j, boolean z, int i) {
        if (this.x == null || zx.k(this.t) == null) {
            return false;
        }
        com.bykv.vk.openvk.component.video.api.fx.iz izVarU = this.my;
        if (izVarU == null) {
            File file = new File(jk.u(this.t.oi()).u(), zx.n(this.t));
            if (file.exists() && file.length() > 0) {
                this.u = true;
            }
            izVarU = zx.u(1, this.t);
            izVarU.nr(this.t.lk());
            FrameLayout frameLayout = this.l;
            izVarU.nr(frameLayout == null ? 100 : frameLayout.getWidth());
            FrameLayout frameLayout2 = this.l;
            izVarU.fx(frameLayout2 != null ? frameLayout2.getHeight() : 100);
            izVarU.fx(this.t.ap());
            izVarU.u(j);
            izVarU.nr(z);
            if (t.u(this.t)) {
                izVarU.u(true);
            }
        }
        return this.x.u(izVarU);
    }

    public void u(boolean z, TTBaseVideoActivity tTBaseVideoActivity) {
        boolean zB;
        long jPn;
        boolean zIz;
        if (z || this.jk.v()) {
            return;
        }
        if (fx()) {
            com.bytedance.sdk.openadsdk.core.video.nr.nr nrVarPb = this.jk.yd().pb();
            if (nrVarPb != null) {
                zB = nrVarPb.b();
                jPn = nrVarPb.pn();
                zIz = nrVarPb.iz();
            } else {
                zB = false;
                jPn = 0;
                zIz = false;
            }
            if (!zB) {
                u(jPn, zIz);
                return;
            }
        }
        xw();
        u(tTBaseVideoActivity);
    }

    public void u(TTBaseVideoActivity tTBaseVideoActivity) {
        if (!c() || tTBaseVideoActivity == null) {
            return;
        }
        tTBaseVideoActivity.nr(iz(), true);
    }

    public void u(int i) {
        com.bykv.vk.openvk.component.video.api.b.fx fxVar = this.x;
        if (fxVar != null) {
            fxVar.u(i);
        }
    }

    public void u(bc bcVar, com.bykv.vk.openvk.component.video.api.b.fx fxVar, com.bykv.vk.openvk.component.video.api.fx.iz izVar) {
        this.t = bcVar;
        this.x = fxVar;
        this.my = izVar;
    }

    public void u(com.bytedance.sdk.openadsdk.core.nr.u uVar) {
        this.k = uVar;
    }

    public void u(float f) {
        if (this.x.o() != null) {
            this.x.o().u(f);
        }
    }
}
