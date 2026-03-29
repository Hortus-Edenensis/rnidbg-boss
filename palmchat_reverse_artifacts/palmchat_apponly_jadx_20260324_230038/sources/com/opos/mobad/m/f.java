package com.opos.mobad.m;

import android.os.Handler;
import android.os.Looper;
import com.oplus.tbl.exoplayer2.Renderer;
import com.opos.mobad.ad.j;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class f<T> extends j.a implements com.opos.mobad.ad.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Handler f8973a;
    private com.opos.mobad.ad.e.a<T> b;
    private o c = l.a();
    private p d;

    public f(com.opos.mobad.ad.e.a<T> aVar) {
        Handler handler = new Handler(Looper.getMainLooper());
        this.f8973a = handler;
        this.d = new p(handler, new Runnable() { // from class: com.opos.mobad.m.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.g();
            }
        });
        this.b = aVar;
    }

    public void b() {
        this.d.b();
        this.c.a(5);
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.c.a();
    }

    public abstract boolean c(String str);

    public boolean d() {
        return false;
    }

    public void g() {
        this.d.a();
        int iA = this.c.a(6);
        com.opos.cmn.an.f.a.b("SyncStateController", "onTimeout state=" + iA + ",Ad = " + this);
        if (6 == iA) {
            b(11009, "network timeout, please check network status and retry");
        }
    }

    public void a() {
        b(m.a());
    }

    public void b(int i, String str) {
        com.opos.mobad.ad.e.a<T> aVar = this.b;
        if (aVar != null) {
            aVar.onAdFailed(i, str);
        }
    }

    public final void c(final int i, final String str) {
        this.d.a();
        this.f8973a.post(new Runnable() { // from class: com.opos.mobad.m.f.3
            @Override // java.lang.Runnable
            public void run() {
                int iA = f.this.c.a(1, 0);
                com.opos.cmn.an.f.a.b("SyncStateController", "state=" + iA + ",Ad = " + this);
                if (5 == iA) {
                    return;
                }
                f.this.b(i, str);
            }
        });
    }

    @Override // com.opos.mobad.ad.b
    public void a(int i) {
        a(m.a(), i);
    }

    @Override // com.opos.mobad.ad.b
    public void b(String str) {
        com.opos.cmn.an.f.a.b("", "loadAd:" + str);
        a(str, 30000);
    }

    @Override // com.opos.mobad.ad.b
    public void a(int i, String str) {
        a(m.a(), i, null, str);
    }

    public final void b(List<T> list) {
        com.opos.mobad.ad.e.a<T> aVar;
        this.d.a();
        if (2 != this.c.a(2) || (aVar = this.b) == null) {
            return;
        }
        aVar.onAdSuccess(list);
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

    @Override // com.opos.mobad.ad.b
    public void a(String str) {
        a(30000, str);
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
    public void a(final String str, final int i) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i);
        a(new Callable<Boolean>() { // from class: com.opos.mobad.m.f.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(f.this.b(str, i));
            }
        });
    }

    public boolean b(String str, int i, List<String> list, String str2) {
        if (i > 0) {
            this.d.a(i);
        } else {
            this.d.a();
        }
        return a(str, list, str2);
    }

    @Override // com.opos.mobad.ad.l
    public void a(final String str, final int i, final List<String> list) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i + "," + list);
        a(new Callable<Boolean>() { // from class: com.opos.mobad.m.f.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(f.this.b(str, i, list));
            }
        });
    }

    @Override // com.opos.mobad.ad.l
    public void a(final String str, final int i, final List<String> list, final String str2) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i);
        a(new Callable<Boolean>() { // from class: com.opos.mobad.m.f.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(f.this.b(str, i, list, str2));
            }
        });
    }

    public void a(List<String> list) {
    }

    private final void a(Callable<Boolean> callable) {
        int iA = this.c.a(1, callable);
        com.opos.cmn.an.f.a.b("", "loadAd state=" + iA + ",Ad =" + this);
        if (1 == iA) {
            return;
        }
        if (5 == iA) {
            b(Renderer.MSG_ENABLE_VIDEO_RENDER_STUCK_DETECTOR, "ad has destroyed.");
            return;
        }
        b(-1, "load with illegal state:" + iA);
    }

    public boolean a(String str, List<String> list) {
        return false;
    }

    public boolean a(String str, List<String> list, String str2) {
        return false;
    }
}
