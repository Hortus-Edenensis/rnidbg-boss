package com.opos.mobad.m;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.oplus.tbl.exoplayer2.Renderer;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.j;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class j extends j.a implements com.opos.mobad.ad.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b.a f8982a;
    private int b;
    private long c;
    private p d;
    protected Handler e;
    o f;

    public j(int i, b.a aVar) {
        o();
        Handler handler = new Handler(Looper.getMainLooper());
        this.e = handler;
        this.d = new p(handler, new Runnable() { // from class: com.opos.mobad.m.j.1
            @Override // java.lang.Runnable
            public void run() {
                j.this.l();
            }
        });
        this.f8982a = aVar;
        this.b = i;
    }

    public void b() {
        this.d.b();
        this.f.a(5);
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.f.a();
    }

    public abstract boolean c(String str);

    public final void d(final int i, final String str) {
        this.d.a();
        this.e.post(new Runnable() { // from class: com.opos.mobad.m.j.4
            @Override // java.lang.Runnable
            public void run() {
                int iA = j.this.f.a(0);
                com.opos.cmn.an.f.a.b("SyncStateController", "onAdFailed state=" + iA + ",Ad = " + this);
                if (5 == iA) {
                    return;
                }
                j.this.b(i, str);
            }
        });
    }

    public void l() {
        this.d.a();
        int iA = this.f.a(6);
        com.opos.cmn.an.f.a.b("SyncStateController", "onTimeout state=" + iA + ",Ad = " + this);
        if (6 == iA) {
            b(11009, "network timeout, please check network status and retry");
        }
    }

    public void n() {
        b.a aVar = this.f8982a;
        if (aVar != null) {
            aVar.onAdClose();
        }
    }

    public void o() {
        this.f = l.a();
    }

    public final void p() {
        this.d.a();
        if (2 == this.f.a(2)) {
            this.c = SystemClock.elapsedRealtime();
            a(new Runnable() { // from class: com.opos.mobad.m.j.5
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f8982a != null) {
                        j.this.f8982a.onAdReady();
                    }
                }
            });
        }
    }

    public j(b.a aVar) {
        this(-1, aVar);
    }

    public void a() {
        b(m.a());
    }

    public void b(int i, String str) {
        b.a aVar = this.f8982a;
        if (aVar != null) {
            aVar.onAdFailed(i, str);
        }
    }

    public final void c(final int i, final String str) {
        this.d.a();
        this.e.post(new Runnable() { // from class: com.opos.mobad.m.j.3
            @Override // java.lang.Runnable
            public void run() {
                if (6 == j.this.f.a()) {
                    com.opos.cmn.an.f.a.b("SyncStateController", "onAdFailed but timeout");
                    return;
                }
                int iA = j.this.f.a(1, 0);
                com.opos.cmn.an.f.a.b("SyncStateController", "onLoadFailed state=" + iA + ",Ad = " + this);
                if (5 == iA) {
                    return;
                }
                j.this.b(i, str);
            }
        });
    }

    public boolean d() {
        int i;
        return 2 == c() && ((i = this.b) <= 0 || this.c + ((long) i) >= SystemClock.elapsedRealtime());
    }

    @Override // com.opos.mobad.ad.b
    public void a(int i) {
        a(m.a(), i);
    }

    public void b(String str) {
        com.opos.cmn.an.f.a.b("", "loadAd:" + str);
        a(str, 30000);
    }

    public final void c(Callable<Boolean> callable) {
        this.d.a();
        if (2 == this.f.a(2, callable)) {
            this.c = SystemClock.elapsedRealtime();
            a(new Runnable() { // from class: com.opos.mobad.m.j.6
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f8982a != null) {
                        j.this.f8982a.onAdReady();
                    }
                }
            });
        }
    }

    @Override // com.opos.mobad.ad.b
    public void a(int i, String str) {
        a(m.a(), i, null, str);
    }

    public final void b(Callable<Boolean> callable) {
        int iA = this.f.a(1, callable);
        com.opos.cmn.an.f.a.b("SyncStateController", "loadAd state=" + iA + ",Ad =" + this);
        if (1 == iA) {
            return;
        }
        if (5 == iA) {
            b(Renderer.MSG_ENABLE_VIDEO_RENDER_STUCK_DETECTOR, "ad has destroyed.");
            return;
        }
        b(-1, "load with illegal state:" + iA);
    }

    public void a(int i, List<String> list) {
    }

    public boolean b(String str, int i) {
        if (i > 0) {
            this.d.a(i);
        } else {
            this.d.a();
        }
        return c(str);
    }

    public final void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.e.post(runnable);
        }
    }

    public boolean b(String str, int i, List<String> list) {
        if (i > 0) {
            this.d.a(i);
        } else {
            this.d.a();
        }
        return a(str, list);
    }

    @Override // com.opos.mobad.ad.b
    public void a(String str) {
        a(30000, str);
    }

    public boolean b(String str, int i, List<String> list, String str2) {
        if (i > 0) {
            this.d.a(i);
        } else {
            this.d.a();
        }
        return a(str, list, str2);
    }

    public void a(final String str, final int i) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i);
        b(new Callable<Boolean>() { // from class: com.opos.mobad.m.j.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(j.this.b(str, i));
            }
        });
    }

    @Override // com.opos.mobad.ad.l
    public void a(final String str, final int i, final List<String> list) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i + "," + list);
        b(new Callable<Boolean>() { // from class: com.opos.mobad.m.j.7
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(j.this.b(str, i, list));
            }
        });
    }

    @Override // com.opos.mobad.ad.l
    public void a(final String str, final int i, final List<String> list, final String str2) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i + ", " + str2);
        Object[] objArr = new Object[2];
        objArr[0] = "bidIds:";
        objArr[1] = list != null ? list.toArray() : "";
        com.opos.cmn.an.f.a.b("", objArr);
        b(new Callable<Boolean>() { // from class: com.opos.mobad.m.j.8
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(j.this.b(str, i, list, str2));
            }
        });
    }

    public void a(List<String> list) {
    }

    public void a(Callable<Boolean> callable) {
        this.d.a();
        int iA = this.f.a(6, callable);
        com.opos.cmn.an.f.a.b("SyncStateController", "onTimeout state=" + iA + ",Ad = " + this);
        if (6 == iA) {
            b(11009, "network timeout, please check network status and retry");
        }
    }

    public boolean a(String str, List<String> list) {
        return false;
    }

    public boolean a(String str, List<String> list, String str2) {
        return false;
    }
}
