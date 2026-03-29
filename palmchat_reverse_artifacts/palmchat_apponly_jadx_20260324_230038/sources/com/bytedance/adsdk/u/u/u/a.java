package com.bytedance.adsdk.u.u.u;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.adsdk.u.u.nr.iz;
import com.bytedance.adsdk.u.u.nr.x;
import com.bytedance.component.sdk.annotation.WorkerThread;
import com.bytedance.sdk.component.utils.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a<R extends com.bytedance.adsdk.u.u.nr.iz, W extends com.bytedance.adsdk.u.u.nr.x> {
    private static final Rect s = new Rect();
    private static final String x = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f5020a;
    protected Map<Bitmap, Canvas> b;
    private R bg;
    private boolean bq;
    private volatile nr dw;
    protected int fx;
    protected volatile Rect iz;
    private int jk;
    private final Runnable k;
    private final Set<u> l;
    private final AtomicBoolean mv;
    private final Set<Bitmap> my;
    private final com.bytedance.adsdk.u.u.fx.nr n;
    private final Object o;
    protected ByteBuffer pn;
    private W sx;
    protected List<n<R, W>> u = new ArrayList();
    protected int nr = -1;
    private Integer t = null;

    /* JADX INFO: compiled from: SearchBox */
    public enum nr {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void nr();

        void nr(ByteBuffer byteBuffer);

        void u();
    }

    public a(com.bytedance.adsdk.u.u.fx.nr nrVar, u uVar) {
        HashSet hashSet = new HashSet();
        this.l = hashSet;
        this.mv = new AtomicBoolean(true);
        this.k = new Runnable() { // from class: com.bytedance.adsdk.u.u.u.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.mv.get()) {
                    return;
                }
                if (!a.this.o()) {
                    a.this.a();
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                a.this.f5020a.postDelayed(this, Math.max(0L, a.this.sx() - (System.currentTimeMillis() - jCurrentTimeMillis)));
                Iterator it = a.this.l.iterator();
                while (it.hasNext()) {
                    ((u) it.next()).nr(a.this.pn);
                }
            }
        };
        this.fx = 1;
        this.my = new HashSet();
        this.o = new Object();
        this.b = new WeakHashMap();
        this.sx = (W) b();
        this.bg = null;
        this.bq = false;
        this.dw = nr.IDLE;
        this.n = nrVar;
        if (uVar != null) {
            hashSet.add(uVar);
        }
        this.f5020a = com.bytedance.sdk.component.jk.nr.u.u().nr();
    }

    private String k() {
        return "";
    }

    private int my() {
        Integer num = this.t;
        return num != null ? num.intValue() : nr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        if (!jk() || this.u.size() == 0) {
            return false;
        }
        if (my() <= 0 || this.jk < my() - 1) {
            return true;
        }
        if (this.jk == my() - 1 && this.nr < x() - 1) {
            return true;
        }
        this.bq = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void s() {
        this.f5020a.removeCallbacks(this.k);
        this.u.clear();
        synchronized (this.o) {
            for (Bitmap bitmap : this.my) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.my.clear();
        }
        if (this.pn != null) {
            this.pn = null;
        }
        this.b.clear();
        try {
            if (this.bg != null) {
                this.bg = null;
            }
        } catch (IOException unused) {
        }
        fx();
        this.dw = nr.IDLE;
        Iterator<u> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().nr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public long sx() {
        int i = this.nr + 1;
        this.nr = i;
        if (i >= x()) {
            this.nr = 0;
            this.jk++;
        }
        n<R, W> nVarU = u(this.nr);
        if (nVarU == null) {
            return 0L;
        }
        u(nVarU);
        return nVarU.l;
    }

    public abstract W b();

    public abstract R fx(com.bytedance.adsdk.u.u.nr.iz izVar);

    public abstract void fx();

    public boolean jk() {
        return this.dw == nr.RUNNING || this.dw == nr.INITIALIZING;
    }

    public int l() {
        return this.fx;
    }

    public abstract int nr();

    public abstract Rect nr(R r) throws IOException;

    public void t() {
        this.f5020a.post(new Runnable() { // from class: com.bytedance.adsdk.u.u.u.a.8
            @Override // java.lang.Runnable
            public void run() {
                a.this.jk = 0;
                a aVar = a.this;
                aVar.nr = -1;
                aVar.bq = false;
            }
        });
    }

    public abstract void u(n<R, W> nVar);

    public void a() {
        if (this.iz == s) {
            return;
        }
        nr nrVar = this.dw;
        nr nrVar2 = nr.FINISHING;
        if (nrVar == nrVar2 || this.dw == nr.IDLE) {
            k();
            return;
        }
        if (this.dw == nr.INITIALIZING) {
            k.nr(x, k() + "Processing,wait for finish at " + this.dw);
        }
        this.dw = nrVar2;
        if (Looper.myLooper() == this.f5020a.getLooper()) {
            s();
        } else {
            this.f5020a.post(new Runnable() { // from class: com.bytedance.adsdk.u.u.u.a.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.s();
                }
            });
        }
    }

    public int fx(int i, int i2) {
        int i3 = 1;
        if (i != 0 && i2 != 0) {
            int iMin = Math.min(iz().width() / i, iz().height() / i2);
            while (true) {
                int i4 = i3 * 2;
                if (i4 > iMin) {
                    break;
                }
                i3 = i4;
            }
        }
        return i3;
    }

    public Rect iz() {
        if (this.iz == null) {
            if (this.dw == nr.FINISHING) {
                k.nr(x, "In finishing,do not interrupt");
            }
            final Thread threadCurrentThread = Thread.currentThread();
            this.f5020a.post(new Runnable() { // from class: com.bytedance.adsdk.u.u.u.a.5
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (a.this.iz == null) {
                                if (a.this.bg == null) {
                                    a aVar = a.this;
                                    aVar.bg = aVar.fx(aVar.n.nr());
                                } else {
                                    a.this.bg.d_();
                                }
                                a aVar2 = a.this;
                                aVar2.u(aVar2.nr(aVar2.bg));
                            }
                        } catch (Exception unused) {
                            a.this.iz = a.s;
                        }
                    } finally {
                        LockSupport.unpark(threadCurrentThread);
                    }
                }
            });
            LockSupport.park(threadCurrentThread);
        }
        return this.iz == null ? s : this.iz;
    }

    public void n() {
        if (this.iz == s) {
            return;
        }
        if (this.dw != nr.RUNNING) {
            nr nrVar = this.dw;
            nr nrVar2 = nr.INITIALIZING;
            if (nrVar != nrVar2) {
                if (this.dw == nr.FINISHING) {
                    k.nr(x, k() + " Processing,wait for finish at " + this.dw);
                }
                this.dw = nrVar2;
                if (Looper.myLooper() == this.f5020a.getLooper()) {
                    u();
                    return;
                } else {
                    this.f5020a.post(new Runnable() { // from class: com.bytedance.adsdk.u.u.u.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.u();
                        }
                    });
                    return;
                }
            }
        }
        k();
    }

    public void nr(final u uVar) {
        this.f5020a.post(new Runnable() { // from class: com.bytedance.adsdk.u.u.u.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.l.remove(uVar);
            }
        });
    }

    public void pn() {
        this.f5020a.post(new Runnable() { // from class: com.bytedance.adsdk.u.u.u.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.l.size() == 0) {
                    a.this.a();
                }
            }
        });
    }

    public int x() {
        return this.u.size();
    }

    public boolean nr(int i, int i2) {
        final int iFx = fx(i, i2);
        if (iFx == this.fx) {
            return false;
        }
        final boolean zJk = jk();
        this.f5020a.removeCallbacks(this.k);
        this.f5020a.post(new Runnable() { // from class: com.bytedance.adsdk.u.u.u.a.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                a.this.s();
                try {
                    a aVar = a.this;
                    aVar.fx = iFx;
                    aVar.u(aVar.nr(aVar.fx(aVar.n.nr())));
                    if (zJk) {
                        a.this.u();
                    }
                } catch (IOException unused) {
                }
            }
        });
        return true;
    }

    public Bitmap u(int i, int i2) {
        synchronized (this.o) {
            Iterator<Bitmap> it = this.my.iterator();
            Bitmap bitmapCreateBitmap = null;
            while (it.hasNext()) {
                int i3 = i * i2 * 4;
                Bitmap next = it.next();
                if (next != null && next.getAllocationByteCount() >= i3) {
                    it.remove();
                    if ((next.getWidth() != i || next.getHeight() != i2) && i > 0 && i2 > 0) {
                        next.reconfigure(i, i2, Bitmap.Config.ARGB_4444);
                    }
                    next.eraseColor(0);
                    return next;
                }
                bitmapCreateBitmap = next;
            }
            if (i <= 0 || i2 <= 0) {
                return null;
            }
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
            } catch (Exception | OutOfMemoryError unused) {
            }
            return bitmapCreateBitmap;
        }
    }

    public void u(Bitmap bitmap) {
        synchronized (this.o) {
            if (bitmap != null) {
                this.my.add(bitmap);
            }
        }
    }

    public void u(final u uVar) {
        this.f5020a.post(new Runnable() { // from class: com.bytedance.adsdk.u.u.u.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.l.add(uVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Rect rect) {
        this.iz = rect;
        int iWidth = rect.width() * rect.height();
        int i = this.fx;
        this.pn = ByteBuffer.allocate(((iWidth / (i * i)) + 1) * 4);
        if (this.sx == null) {
            this.sx = (W) b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void u() {
        this.mv.compareAndSet(true, false);
        System.currentTimeMillis();
        try {
            if (this.u.size() == 0) {
                try {
                    R r = this.bg;
                    if (r == null) {
                        this.bg = (R) fx(this.n.nr());
                    } else {
                        r.d_();
                    }
                    u(nr(this.bg));
                } catch (Throwable unused) {
                }
            }
            k();
            System.currentTimeMillis();
            this.dw = nr.RUNNING;
            if (my() != 0 && this.bq) {
                k();
                return;
            }
            this.nr = -1;
            this.k.run();
            Iterator<u> it = this.l.iterator();
            while (it.hasNext()) {
                it.next().u();
            }
        } catch (Throwable th) {
            k();
            System.currentTimeMillis();
            this.dw = nr.RUNNING;
            throw th;
        }
    }

    public n<R, W> u(int i) {
        if (i < 0 || i >= this.u.size()) {
            return null;
        }
        return this.u.get(i);
    }
}
