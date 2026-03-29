package com.bytedance.sdk.openadsdk.core.component.reward.b;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.kj.ay;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.yd;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n extends u {
    private long bf;
    private final int ja;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.business.u.u f5222jp;
    private final AtomicBoolean m;
    private final AtomicBoolean pb;
    protected final AtomicLong rh;
    private final AtomicBoolean wq;
    private final AtomicBoolean xg;
    private final com.bytedance.sdk.openadsdk.core.video.nr.nr y;

    public n(TTBaseVideoActivity tTBaseVideoActivity, bc bcVar) {
        super(tTBaseVideoActivity, bcVar);
        this.ja = 4;
        this.bf = 4L;
        this.wq = new AtomicBoolean(false);
        this.pb = new AtomicBoolean(false);
        this.xg = new AtomicBoolean(false);
        this.m = new AtomicBoolean(false);
        this.rh = new AtomicLong();
        this.y = new com.bytedance.sdk.openadsdk.core.video.nr.nr() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.b.n.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nr.nr
            public void a() {
                n.this.u.bc();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.nr
            public boolean b() {
                return n.this.m.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.nr
            public void fx() {
                n.this.wq();
                n.this.m.set(true);
                n.this.u.l();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.nr
            public boolean iz() {
                return n.this.dw.iz();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.nr
            public void jk() {
                TTBaseVideoActivity tTBaseVideoActivity2 = n.this.u;
                if (tTBaseVideoActivity2 != null) {
                    tTBaseVideoActivity2.t();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.nr
            public void n() {
                n.this.ju();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.nr
            public void nr() {
                n.this.xg.set(false);
                n.this.f5223a.pn(8);
                if (!n.this.x()) {
                    n.this.u.bc();
                }
                n.this.u.c();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.nr
            public long pn() {
                return n.this.rh.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.nr
            public int t() {
                return n.this.xg.get() ? 1 : 2;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.nr
            public boolean u() {
                if (!n.this.xg.get() && !ay.nr(n.this.nr)) {
                    return false;
                }
                n.this.ob();
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.nr
            public Map<String, Object> x() {
                HashMap map = new HashMap();
                map.put("refer", "in_video");
                return map;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nr.nr
            public void u(long j, long j2) {
                n.this.bg.nr(j);
                n.this.bq();
                n.this.rh.set(j);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ju() {
        this.wq.set(false);
    }

    private void jw() {
        if (this.wq.get()) {
            ge();
            uq();
        }
    }

    public static int nr(bc bcVar) {
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ob() {
        this.f5223a.pn(0);
        this.u.y();
        this.f5222jp.fx();
        this.u.dw();
    }

    private void uq() {
        if (this.pb.get()) {
            long j = this.bf - 1;
            this.bf = j;
            if (j != 0) {
                if (j > 0) {
                    this.f5222jp.u(j);
                }
            } else {
                this.f5222jp.u(j);
                this.xg.set(true);
                if (x()) {
                    this.f5222jp.u(this.q);
                } else {
                    this.f5222jp.u(this.n);
                }
            }
        }
    }

    private void zx() {
        this.pb.set(true);
        this.f5222jp.u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void bq() {
        super.bq();
        this.my = false;
        boolean z = ((int) (this.bg.rh() / 1000)) >= this.h.fx() || this.u.wi();
        if (this.bg.bf()) {
            this.sx.u(false, null, "跳过", false, true);
            return;
        }
        int iH = this.bg.h();
        if (this.bg.u()) {
            return;
        }
        this.sx.u(false, iH + "s", z ? "跳过" : "", false, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean eh() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void f() {
        jw();
        if (yd.o(this.nr)) {
            this.u.fx(0);
            if (kj() > xw() || this.k) {
                com.bytedance.sdk.openadsdk.core.n.b.u = 0;
            }
            nr(iz(true));
            com.bytedance.sdk.openadsdk.core.n.b.u = y();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean gc() {
        return true;
    }

    public void ge() {
        if (this.pb.get()) {
            return;
        }
        int iRh = (int) this.bg.rh();
        int iDw = (int) this.bg.dw();
        int iFx = ay.fx(this.nr);
        if (iFx == 1) {
            u(ay.b(this.nr), iDw, 1000 * ((long) this.h.pn()), false);
        } else if (iFx == 2) {
            u((int) (iDw * 0.001f * 0.01f * ay.b(this.nr)), iDw, iRh, false);
        } else {
            if (iFx != 3) {
                return;
            }
            u(m(), iDw, iRh, true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean kw() {
        return yd.o(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean lf() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean nb() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public boolean p() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public com.bytedance.sdk.openadsdk.core.video.nr.nr pb() {
        return this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void qq() {
        super.qq();
        this.sx.u(false, "奖励已领取", "跳过", false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public int rh() {
        return nr(this.nr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void tm() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.pn pnVar = this.q;
        if (pnVar != null) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) pnVar.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.y);
            ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) this.q.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(this.y);
        }
        com.bytedance.sdk.openadsdk.core.nr.pn pnVar2 = this.n;
        if (pnVar2 != null) {
            ((com.bytedance.sdk.openadsdk.core.nr.u.u.u) pnVar2.u(com.bytedance.sdk.openadsdk.core.nr.u.u.u.class)).u(this.y);
            ((com.bytedance.sdk.openadsdk.core.nr.u.fx.u) this.n.u(com.bytedance.sdk.openadsdk.core.nr.u.fx.u.class)).u(this.y);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.u.u uVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.u.u(this.u, this.nr, this.y);
        this.f5222jp = uVar;
        uVar.u(this.u.bf().getSceneFrameContainer(), this.u.bf().getSceneFrame());
        this.wq.set(ay.fx(this.nr) != 0);
        if (this.wq.get()) {
            this.my = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.u
    public void wq() {
        super.wq();
        this.sx.u(false, "奖励已领取", "跳过", false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.b.nr
    public void za() {
        this.f5223a.pn(8);
        this.f5223a.iz(0);
        this.sx.pn(true);
        this.sx.fx(true);
        this.sx.nr(true);
        this.sx.u(true);
        this.u.w();
    }

    public static boolean u(bc bcVar) {
        return ay.u(bcVar);
    }

    private void u(int i, long j, long j2, boolean z) {
        if (z) {
            if (i <= 3) {
                zx();
            }
        } else if (i > 0) {
            long j3 = ((long) i) * 1000;
            if (j3 > j) {
                return;
            }
            long j4 = j3 - j2;
            if (j4 <= 0 || Math.abs(j4) > 3200) {
                return;
            }
            zx();
        }
    }
}
