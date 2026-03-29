package com.bykv.vk.openvk.component.video.u.b;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.fx.iz;
import com.bykv.vk.openvk.component.video.api.u;
import com.bykv.vk.openvk.component.video.u.b.fx;
import com.bytedance.sdk.component.utils.rh;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b implements com.bykv.vk.openvk.component.video.api.u, fx.b, fx.InterfaceC0157fx, fx.iz, fx.nr, fx.pn, fx.u, fx.x, rh.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4968a;
    private int b;
    private long bc;
    private AtomicBoolean bf;
    private long bg;
    private long bq;
    private boolean c;
    private iz d;
    private long dw;
    private SurfaceHolder fx;
    private final List<WeakReference<u.InterfaceC0156u>> gi;
    private boolean h;
    private boolean iz;
    private volatile int ja;
    private boolean jk;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private final u f4969jp;
    private volatile boolean k;
    private volatile int l;
    private final Runnable m;
    private long mv;
    private boolean my;
    private final boolean n;
    private SurfaceTexture nr;
    private long o;
    private boolean oa;
    private AtomicBoolean pb;
    private int pn;
    private ArrayList<Runnable> q;
    private int qq;
    private com.bykv.vk.openvk.component.video.api.fx.nr rh;
    private volatile rh s;
    private long sx;
    private boolean t;
    private AtomicBoolean wq;
    private volatile fx x;
    private Surface xg;
    private long xw;
    private volatile boolean y;
    private boolean z;
    private static final AtomicInteger u = new AtomicInteger(0);
    private static final SparseIntArray kj = new SparseIntArray();

    /* JADX INFO: compiled from: SearchBox */
    public class u implements Runnable {
        private boolean fx;
        private long nr;

        public u() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.x != null) {
                try {
                    if (!this.fx) {
                        long jA = b.this.x.a();
                        b.this.mv = Math.max(this.nr, jA);
                    }
                    long unused = b.this.mv;
                } catch (Throwable unused2) {
                }
            }
            if (b.this.s != null) {
                b.this.s.sendEmptyMessageDelayed(100, 0L);
            }
        }

        public void u(boolean z) {
            this.fx = z;
        }

        public void u(long j) {
            this.nr = j;
        }
    }

    public b(String str) {
        this(str, null);
    }

    private void bf() {
        ArrayList<Runnable> arrayList = this.q;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.q.clear();
    }

    private void c() {
        this.o = 0L;
        this.b = 0;
        this.bg = 0L;
        this.my = false;
        this.sx = Long.MIN_VALUE;
    }

    private void d() {
        u("0506");
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.dw;
        for (WeakReference<u.InterfaceC0156u> weakReference : this.gi) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().u(this, jElapsedRealtime);
            }
        }
        this.iz = true;
    }

    private void gi() {
        SparseIntArray sparseIntArray = kj;
        Integer numValueOf = Integer.valueOf(sparseIntArray.get(this.qq));
        if (numValueOf == null) {
            sparseIntArray.put(this.qq, 1);
        } else {
            sparseIntArray.put(this.qq, numValueOf.intValue() + 1);
        }
    }

    private void h() {
        if (this.s != null) {
            this.s.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.x.x();
                        b.this.l = 207;
                        b.this.y = false;
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        ArrayList<Runnable> arrayList = this.q;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        rh();
    }

    private void kj() {
        if (this.x == null) {
            return;
        }
        try {
            this.x.l();
        } catch (Throwable unused) {
        }
        this.x.u((fx.nr) null);
        this.x.u((fx.x) null);
        this.x.u((fx.u) null);
        this.x.u((fx.b) null);
        this.x.u((fx.InterfaceC0157fx) null);
        this.x.u((fx.pn) null);
        this.x.u((fx.iz) null);
        try {
            this.x.t();
            com.bykv.vk.openvk.component.video.api.fx.nr nrVar = this.rh;
            if (nrVar != null) {
                nrVar.u(this.sx, this.d);
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.s != null) {
            this.s.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.12
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.x == null) {
                        try {
                            b.this.x = new nr();
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO_MEDIA", th.getMessage());
                        }
                        if (b.this.x == null) {
                            return;
                        }
                        fx unused = b.this.x;
                        b.this.x.u((fx.pn) b.this);
                        b.this.x.u((fx.nr) b.this);
                        b.this.x.u((fx.InterfaceC0157fx) b.this);
                        b.this.x.u((fx.u) b.this);
                        b.this.x.u((fx.iz) b.this);
                        b.this.x.u((fx.b) b.this);
                        b.this.x.u((fx.x) b.this);
                        try {
                            b.this.x.fx(false);
                        } catch (Throwable unused2) {
                        }
                        b.this.f4968a = false;
                    }
                }
            });
        }
    }

    private void qq() {
        nr(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.s != null) {
                    b.this.s.sendEmptyMessage(104);
                }
            }
        });
    }

    private void rh() {
        if (this.jk) {
            return;
        }
        this.jk = true;
        Iterator it = new ArrayList(this.q).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.q.clear();
        this.jk = false;
    }

    private boolean u(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    private void z() {
        rh rhVar = this.s;
        if (rhVar == null || rhVar.getLooper() == null) {
            return;
        }
        rhVar.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.8
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.s == null || b.this.s.getLooper() == null) {
                    return;
                }
                try {
                    if (b.this.k) {
                        b.this.s.removeCallbacksAndMessages(null);
                    } else {
                        com.bytedance.sdk.component.jk.nr.u.u().u(b.this.s);
                    }
                    b.this.s = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long bg() {
        if (k()) {
            return 0L;
        }
        if (this.l == 206 || this.l == 207) {
            try {
                return this.x.a();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public int bq() {
        if (k()) {
            return 203;
        }
        return this.l;
    }

    public boolean dw() {
        return this.l == 205;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean k() {
        return this.t;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long my() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.xw;
        }
        if (this.my) {
            long j = this.bg;
            if (j > 0) {
                return this.o + j;
            }
        }
        return this.o;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int o() {
        return this.b;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean s() {
        return ((this.l != 207 && !this.y) || this.s == null || this.s.hasMessages(100)) ? false : true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public long sx() {
        long j = this.bq;
        if (j != 0) {
            return j;
        }
        if (this.l == 206 || this.l == 207) {
            try {
                this.bq = this.x.jk();
            } catch (Throwable unused) {
            }
        }
        return this.bq;
    }

    public b(String str, com.bykv.vk.openvk.component.video.api.fx.nr nrVar) {
        this.b = 0;
        this.iz = false;
        this.x = null;
        this.n = false;
        this.f4968a = false;
        this.l = 201;
        this.mv = -1L;
        this.k = false;
        this.my = false;
        this.o = 0L;
        this.sx = Long.MIN_VALUE;
        this.bg = 0L;
        this.bq = 0L;
        this.dw = 0L;
        this.qq = 0;
        this.gi = new CopyOnWriteArrayList();
        this.d = null;
        this.h = false;
        this.ja = 200;
        this.bf = new AtomicBoolean(false);
        this.wq = new AtomicBoolean(false);
        this.pb = new AtomicBoolean(false);
        this.xg = null;
        this.m = new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.x == null) {
                    return;
                }
                long jBg = b.this.bg();
                if (jBg > 0 && Build.VERSION.SDK_INT >= 23 && b.this.mv() && b.this.sx != Long.MIN_VALUE) {
                    try {
                        if (b.this.sx == jBg) {
                            if (!b.this.my && b.this.bg >= 400) {
                                b.this.nr(701, 800);
                                b.this.my = true;
                            }
                            b.this.bg += (long) b.this.ja;
                        } else {
                            if (b.this.my) {
                                b.this.o += b.this.bg;
                                b.this.nr(702, 800);
                                long unused = b.this.o;
                                int unused2 = b.this.b;
                            }
                            b.this.bg = 0L;
                            b.this.my = false;
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
                if (b.this.sx() > 0) {
                    if (b.this.sx != jBg) {
                        if (com.bykv.vk.openvk.component.video.api.fx.b()) {
                            long unused3 = b.this.sx;
                        }
                        b bVar = b.this;
                        bVar.u(jBg, bVar.sx());
                    }
                    b.this.sx = jBg;
                }
                if (b.this.a()) {
                    b bVar2 = b.this;
                    bVar2.u(bVar2.sx(), b.this.sx());
                } else if (b.this.s != null) {
                    b.this.s.postDelayed(this, b.this.ja);
                }
            }
        };
        this.f4969jp = new u();
        this.bc = 0L;
        this.xw = 0L;
        this.oa = true;
        this.rh = nrVar;
        u("mda_" + str + "_" + u.addAndGet(1), (Looper) null);
        u("0501");
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean a() {
        return this.l == 209;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean iz() {
        return this.iz;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean jk() {
        return dw() || mv() || s();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int l() {
        if (this.x == null || k()) {
            return 0;
        }
        return this.x.s();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public boolean mv() {
        return (this.l == 206 || (this.s != null && this.s.hasMessages(100))) && !this.y;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public SurfaceTexture n() {
        return this.nr;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void pn() {
        if (k()) {
            return;
        }
        this.t = true;
        bf();
        if (this.s != null) {
            try {
                this.s.removeCallbacksAndMessages(null);
                if (this.x != null) {
                    this.s.sendEmptyMessage(103);
                }
                z();
            } catch (Throwable unused) {
                z();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public int t() {
        if (this.x == null || k()) {
            return 0;
        }
        return this.x.mv();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public SurfaceHolder x() {
        return this.fx;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void b() {
        if (k()) {
            return;
        }
        nr(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.s != null) {
                    b.this.s.sendEmptyMessage(105);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void fx() {
        if (k() || this.s == null) {
            return;
        }
        this.s.removeMessages(100);
        this.y = true;
        if (!this.oa) {
            if (!this.c && !nr(this.d)) {
                u(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.16
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.s != null) {
                            b.this.s.sendEmptyMessage(101);
                        }
                    }
                });
                return;
            } else {
                if (this.s != null) {
                    this.s.sendEmptyMessage(101);
                    return;
                }
                return;
            }
        }
        if (!this.iz && !nr(this.d)) {
            u(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.17
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.s != null) {
                        b.this.s.sendEmptyMessage(101);
                    }
                }
            });
        } else if (this.s != null) {
            this.s.sendEmptyMessage(101);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void nr(final boolean z) {
        if (k()) {
            return;
        }
        this.z = z;
        if (this.x != null) {
            this.x.u(z);
        } else if (this.s != null) {
            this.s.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.11
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.x != null) {
                        b.this.x.u(z);
                    }
                }
            });
        }
    }

    private void nr(long j) {
        this.f4969jp.u(j);
        if (this.z) {
            nr(this.f4969jp);
        } else if (nr(this.d)) {
            nr(this.f4969jp);
        } else {
            u(this.f4969jp);
        }
    }

    private void u(String str) {
        com.bykv.vk.openvk.component.video.api.fx.nr nrVar = this.rh;
        if (nrVar != null) {
            nrVar.u(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j, long j2) {
        for (WeakReference<u.InterfaceC0156u> weakReference : this.gi) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().u(this, j, j2);
            }
        }
    }

    private void u(String str, Looper looper) {
        this.qq = 0;
        if (looper != null) {
            this.k = true;
            this.s = new rh(looper, this);
        } else if (this.s == null) {
            this.s = com.bytedance.sdk.component.jk.nr.u.u().u(this, "csj_" + str);
        }
        q();
    }

    private boolean nr(iz izVar) {
        return izVar != null && izVar.x();
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx.iz
    public void fx(fx fxVar) {
        for (WeakReference<u.InterfaceC0156u> weakReference : this.gi) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().u((com.bykv.vk.openvk.component.video.api.u) this, true);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void nr() {
        if (k() || this.s == null) {
            return;
        }
        this.bf.set(true);
        this.s.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.15
            @Override // java.lang.Runnable
            public void run() {
                if (!b.this.s() || b.this.x == null) {
                    return;
                }
                try {
                    b.this.x.pn();
                    for (WeakReference weakReference : b.this.gi) {
                        if (weakReference != null && weakReference.get() != null) {
                            weakReference.get();
                        }
                    }
                    b.this.l = 206;
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void fx(boolean z) {
        if (k()) {
            return;
        }
        this.x.pn(z);
    }

    private void nr(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.x.u(fileInputStream.getFD());
        fileInputStream.close();
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u() {
        if (k() || this.x == null) {
            return;
        }
        if (this.l != 206) {
            c();
            this.y = false;
            this.f4969jp.u(true);
            nr(0L);
            if (this.s != null) {
                this.s.removeCallbacks(this.m);
                this.s.postDelayed(this.m, this.ja);
            }
        }
        this.bf.set(true);
        if ((this.wq.get() || this.pb.get()) && this.s != null) {
            this.s.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.13
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ja();
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx.b
    public boolean nr(fx fxVar, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO_MEDIA", "what,extra:" + i + "," + i2);
        if (this.x != fxVar) {
            return false;
        }
        if (i2 == -1004) {
            com.bykv.vk.openvk.component.video.api.fx.fx fxVar2 = new com.bykv.vk.openvk.component.video.api.fx.fx(i, i2);
            u("0510");
            com.bykv.vk.openvk.component.video.api.fx.nr nrVar = this.rh;
            if (nrVar != null) {
                nrVar.u(i, i2, "");
            }
            for (WeakReference<u.InterfaceC0156u> weakReference : this.gi) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().u(this, fxVar2);
                }
            }
        }
        nr(i, i2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(int i, int i2) {
        if (i == 701) {
            this.bc = SystemClock.elapsedRealtime();
            this.b++;
            for (WeakReference<u.InterfaceC0156u> weakReference : this.gi) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().u(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            return;
        }
        if (i == 702) {
            if (this.bc > 0) {
                this.xw += SystemClock.elapsedRealtime() - this.bc;
                this.bc = 0L;
            }
            for (WeakReference<u.InterfaceC0156u> weakReference2 : this.gi) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    weakReference2.get().u((com.bykv.vk.openvk.component.video.api.u) this, Integer.MAX_VALUE);
                }
            }
            return;
        }
        if (this.oa && i == 3) {
            ja();
            d();
            u(this.h);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(boolean z, long j, boolean z2) {
        if (k()) {
            return;
        }
        q();
        this.h = z2;
        this.y = false;
        u(z2);
        if (z) {
            this.mv = j;
            qq();
        } else {
            nr(j);
        }
        if (this.s != null) {
            this.s.removeCallbacks(this.m);
            this.s.postDelayed(this.m, this.ja);
        }
        this.bf.set(true);
        if ((this.wq.get() || this.pb.get()) && this.s != null) {
            this.s.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.14
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ja();
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(final long j) {
        if (k()) {
            return;
        }
        if (this.l == 207 || this.l == 206 || this.l == 209) {
            nr(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.4
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.s != null) {
                        b.this.s.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx.pn
    public void nr(fx fxVar) {
        if (k()) {
            return;
        }
        this.l = 205;
        try {
            iz izVar = this.d;
            if (izVar != null) {
                float fK = izVar.k();
                if (fK > 0.0f) {
                    com.bykv.vk.openvk.component.video.api.nr nrVar = new com.bykv.vk.openvk.component.video.api.nr();
                    nrVar.u(fK);
                    this.x.u(nrVar);
                }
            }
        } catch (Throwable unused) {
        }
        if (this.s != null) {
            if (this.y) {
                h();
            } else {
                com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO_MEDIA", "onPrepared op_Start");
                this.s.sendMessage(this.s.obtainMessage(100, -1, -1));
            }
        }
        kj.delete(this.qq);
        com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO_MEDIA", "onPrepared:" + this.oa + " " + this.c);
        if (!this.oa && !this.c) {
            d();
            this.c = true;
        }
        u("0504");
        for (WeakReference<u.InterfaceC0156u> weakReference : this.gi) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().nr(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(final SurfaceTexture surfaceTexture) {
        if (k()) {
            return;
        }
        this.nr = surfaceTexture;
        nr(true);
        nr(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.5
            @Override // java.lang.Runnable
            public void run() {
                b.this.q();
                if (b.this.s != null) {
                    b.this.s.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(final SurfaceHolder surfaceHolder) {
        if (k()) {
            return;
        }
        this.fx = surfaceHolder;
        nr(true);
        nr(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.6
            @Override // java.lang.Runnable
            public void run() {
                b.this.q();
                if (b.this.s != null) {
                    b.this.s.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(final iz izVar) {
        if (k()) {
            return;
        }
        this.d = izVar;
        if (izVar != null) {
            this.oa = !izVar.x();
        }
        nr(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.7
            @Override // java.lang.Runnable
            public void run() {
                b.this.q();
                if (b.this.s != null) {
                    b.this.s.obtainMessage(107, izVar).sendToTarget();
                }
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0023. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0201  */
    @Override // com.bytedance.sdk.component.utils.rh.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(Message message) {
        boolean z;
        int i = this.l;
        int i2 = message.what;
        if (this.x != null) {
            switch (message.what) {
                case 100:
                    if (this.l == 205 || this.l == 207 || this.l == 209) {
                        u("0505");
                        this.x.pn();
                        this.dw = SystemClock.elapsedRealtime();
                        this.l = 206;
                        if (this.mv > 0) {
                            this.x.u(this.mv, this.pn);
                            this.mv = -1L;
                        }
                        if (this.d != null) {
                            u(this.h);
                        }
                        z = false;
                    }
                    z = true;
                    break;
                case 101:
                    if (this.my) {
                        this.o += this.bg;
                    }
                    this.my = false;
                    this.bg = 0L;
                    this.sx = Long.MIN_VALUE;
                    if (this.l == 206 || this.l == 207 || this.l == 209) {
                        try {
                            this.x.x();
                            u("0507");
                            this.l = 207;
                            this.y = false;
                            for (WeakReference<u.InterfaceC0156u> weakReference : this.gi) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        z = false;
                    }
                    z = true;
                    break;
                case 102:
                    this.x.l();
                    this.l = 201;
                    z = false;
                    break;
                case 103:
                    try {
                        kj();
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO_MEDIA", "OP_RELEASE error: ", th);
                    }
                    for (WeakReference<u.InterfaceC0156u> weakReference2 : this.gi) {
                        if (weakReference2 != null && weakReference2.get() != null) {
                            weakReference2.get().fx(this);
                        }
                    }
                    this.l = 203;
                    z = false;
                    break;
                case 104:
                    if (this.l == 202 || this.l == 208) {
                        try {
                            this.x.n();
                        } catch (Throwable th2) {
                            com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO_MEDIA", "OP_PREPARE_ASYNC error: ", th2);
                        }
                        z = false;
                    }
                    z = true;
                    break;
                case 105:
                    if (this.l == 205 || this.l == 206 || this.l == 208 || this.l == 207 || this.l == 209) {
                        this.x.iz();
                        u("0508");
                        this.l = 208;
                        z = false;
                    }
                    z = true;
                    break;
                case 106:
                    if (this.l == 206 || this.l == 207 || this.l == 209) {
                        this.x.u(((Long) message.obj).longValue(), this.pn);
                        z = false;
                    }
                    z = true;
                    break;
                case 107:
                    c();
                    if (this.l == 201 || this.l == 203) {
                        iz izVar = (iz) message.obj;
                        if (TextUtils.isEmpty(izVar.pn())) {
                            izVar.u(com.bykv.vk.openvk.component.video.api.fx.u());
                        }
                        File file = new File(izVar.pn(), izVar.o());
                        if (file.exists()) {
                            file.getAbsolutePath();
                            if (com.bykv.vk.openvk.component.video.api.fx.nr()) {
                                nr(file.getAbsolutePath());
                            } else {
                                this.x.u(file.getAbsolutePath());
                            }
                        } else {
                            izVar.my();
                            this.x.u(izVar, this.rh);
                        }
                        u("0503");
                        this.l = 202;
                        z = false;
                    }
                    z = true;
                    break;
                case 108:
                case 109:
                default:
                    z = false;
                    break;
                case 110:
                    this.x.u((SurfaceHolder) message.obj);
                    u("0502");
                    this.x.nr(true);
                    this.wq.set(true);
                    if (this.bf.get()) {
                        ja();
                    }
                    z = false;
                    break;
                case 111:
                    this.xg = new Surface((SurfaceTexture) message.obj);
                    this.x.u(this.xg);
                    u("0502");
                    this.x.nr(true);
                    this.pb.set(true);
                    if (this.bf.get()) {
                        ja();
                    }
                    z = false;
                    break;
            }
        }
        if (z) {
            this.l = 200;
            if (this.f4968a) {
                return;
            }
            com.bykv.vk.openvk.component.video.api.fx.fx fxVar = new com.bykv.vk.openvk.component.video.api.fx.fx(308, i2);
            fxVar.u(i + "," + i2);
            u("0510");
            com.bykv.vk.openvk.component.video.api.fx.nr nrVar = this.rh;
            if (nrVar != null) {
                nrVar.u(308, i2, "state error");
            }
            for (WeakReference<u.InterfaceC0156u> weakReference3 : this.gi) {
                if (weakReference3 != null && weakReference3.get() != null) {
                    weakReference3.get().u(this, fxVar);
                }
            }
            this.f4968a = true;
        }
    }

    private void nr(Runnable runnable) {
        if (runnable == null || k()) {
            return;
        }
        if (!this.t) {
            runnable.run();
        } else {
            u(runnable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx.u
    public void u(fx fxVar, int i) {
        if (this.x != fxVar) {
            return;
        }
        for (WeakReference<u.InterfaceC0156u> weakReference : this.gi) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().nr(this, i);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx.nr
    public void u(fx fxVar) {
        this.l = 209;
        kj.delete(this.qq);
        if (this.s != null) {
            this.s.removeCallbacks(this.m);
        }
        u("0509");
        for (WeakReference<u.InterfaceC0156u> weakReference : this.gi) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().u(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx.InterfaceC0157fx
    public boolean u(fx fxVar, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO_MEDIA", "what=" + i + " extra=" + i2);
        gi();
        this.l = 200;
        if (this.s != null) {
            this.s.removeCallbacks(this.m);
        }
        if (u(i, i2)) {
            z();
        }
        if (!this.bf.get()) {
            return true;
        }
        this.bf.set(false);
        com.bykv.vk.openvk.component.video.api.fx.fx fxVar2 = new com.bykv.vk.openvk.component.video.api.fx.fx(i, i2);
        u("0510");
        com.bykv.vk.openvk.component.video.api.fx.nr nrVar = this.rh;
        if (nrVar != null) {
            nrVar.u(i, i2, "");
        }
        for (WeakReference<u.InterfaceC0156u> weakReference : this.gi) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().u(this, fxVar2);
            }
        }
        return true;
    }

    private void u(Runnable runnable) {
        try {
            if (this.q == null) {
                this.q = new ArrayList<>();
            }
            this.q.add(runnable);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.iz.fx.u("CSJ_VIDEO_MEDIA", th.getMessage());
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(final boolean z) {
        if (k() || this.s == null) {
            return;
        }
        this.s.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.b.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.k() || b.this.x == null) {
                    return;
                }
                try {
                    b.this.h = z;
                    b.this.x.b(z);
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.u.b.fx.x
    public void u(fx fxVar, int i, int i2, int i3, int i4) {
        for (WeakReference<u.InterfaceC0156u> weakReference : this.gi) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().u((com.bykv.vk.openvk.component.video.api.u) this, i, i2);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(u.InterfaceC0156u interfaceC0156u) {
        if (interfaceC0156u == null) {
            return;
        }
        for (WeakReference<u.InterfaceC0156u> weakReference : this.gi) {
            if (weakReference != null && weakReference.get() == interfaceC0156u) {
                return;
            }
        }
        this.gi.add(new WeakReference<>(interfaceC0156u));
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(int i) {
        if (k()) {
            return;
        }
        this.ja = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.u
    public void u(float f) {
        try {
            com.bykv.vk.openvk.component.video.api.nr nrVar = new com.bykv.vk.openvk.component.video.api.nr();
            nrVar.u(f);
            this.x.u(nrVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
