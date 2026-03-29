package com.opos.cmn.func.dl.base;

import android.content.Context;
import com.opos.cmn.func.dl.base.c.c;
import com.opos.cmn.func.dl.base.c.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f7986a = false;
    private int b;
    private int c;
    private boolean d;
    private float e;
    private int f;
    private int g;
    private Context h;
    private com.opos.cmn.func.dl.base.b.d i;
    private com.opos.cmn.func.dl.base.g.b j;
    private com.opos.cmn.func.dl.base.f.a k;
    private d.a l;

    public e(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context should not be null");
        }
        this.h = context.getApplicationContext();
    }

    public int a() {
        return this.b;
    }

    public float b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.g;
    }

    public Context e() {
        return this.h;
    }

    public com.opos.cmn.func.dl.base.b.d f() {
        return this.i;
    }

    public synchronized com.opos.cmn.func.dl.base.g.b g() {
        if (this.j == null) {
            this.j = new com.opos.cmn.func.dl.base.g.b();
        }
        return this.j;
    }

    public d.a h() {
        return this.l;
    }

    public String toString() {
        return "InnerManager{isInited=" + this.f7986a + ", writeThreadCount=" + this.b + ", maxDownloadNum=" + this.c + ", listenOnUi=" + this.d + ", notifyRatio=" + this.e + ", notifyInterval=" + this.f + ", notifyIntervalSize=" + this.g + '}';
    }

    private void b(DownloadConfig downloadConfig) {
        try {
            synchronized (this) {
                if (this.f7986a) {
                    return;
                }
                com.opos.cmn.an.f.a.a("InnerManager", "---init!");
                if (downloadConfig == null) {
                    downloadConfig = new DownloadConfig();
                }
                this.b = downloadConfig.a();
                this.c = downloadConfig.b();
                this.d = downloadConfig.c();
                this.e = downloadConfig.d();
                this.f = downloadConfig.e();
                this.g = downloadConfig.f();
                if (this.l == null) {
                    this.l = new c.a();
                }
                com.opos.cmn.func.dl.base.b.a aVar = new com.opos.cmn.func.dl.base.b.a();
                aVar.f7970a = this.c;
                this.i = new com.opos.cmn.func.dl.base.b.c(aVar);
                com.opos.cmn.func.dl.base.g.b bVarG = g();
                boolean z = this.d;
                com.opos.cmn.func.dl.base.b.d dVar = this.i;
                bVarG.f7999a = z ? dVar.a() : dVar.d();
                this.k = new com.opos.cmn.func.dl.base.f.a(this);
                this.f7986a = true;
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("InnerManager", "tryInit", th);
        }
    }

    @Override // com.opos.cmn.func.dl.base.d
    public void a(DownloadConfig downloadConfig) {
        b(downloadConfig);
    }

    @Override // com.opos.cmn.func.dl.base.d
    public void c(final DownloadRequest downloadRequest) {
        try {
            com.opos.cmn.an.f.a.a("InnerManager", "---pause!");
            if (this.f7986a) {
                final com.opos.cmn.func.dl.base.f.a aVar = this.k;
                if (downloadRequest == null) {
                    com.opos.cmn.an.f.a.d("RequestManager", "Request is null,do nothing");
                } else {
                    b.a().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.f.a.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.opos.cmn.func.dl.base.a.c cVar = a.this.b.get(Integer.valueOf(downloadRequest.f));
                            if (cVar != null) {
                                cVar.a();
                            }
                        }
                    });
                }
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("InnerManager", "pause", th);
        }
    }

    @Override // com.opos.cmn.func.dl.base.d
    public void d(final DownloadRequest downloadRequest) {
        try {
            com.opos.cmn.an.f.a.a("InnerManager", "---cancel!");
            if (this.f7986a) {
                final com.opos.cmn.func.dl.base.f.a aVar = this.k;
                if (downloadRequest == null) {
                    com.opos.cmn.an.f.a.d("RequestManager", "Request is null,do nothing");
                } else {
                    b.a().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.f.a.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.opos.cmn.func.dl.base.a.c cVar = a.this.b.get(Integer.valueOf(downloadRequest.f));
                            if (cVar != null) {
                                cVar.b();
                            }
                        }
                    });
                }
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("InnerManager", "cancel", th);
        }
    }

    @Override // com.opos.cmn.func.dl.base.d
    public void a(DownloadRequest downloadRequest) {
        try {
            com.opos.cmn.an.f.a.a("InnerManager", "---start!");
            if (this.f7986a) {
                this.k.a(downloadRequest, false);
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("InnerManager", "start", th);
        }
    }

    @Override // com.opos.cmn.func.dl.base.d
    public void b(DownloadRequest downloadRequest) {
        try {
            com.opos.cmn.an.f.a.a("InnerManager", "---forceContinue!");
            if (this.f7986a) {
                this.k.a(downloadRequest, true);
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("InnerManager", "forceContinue", th);
        }
    }

    @Override // com.opos.cmn.func.dl.base.d
    public void a(c cVar) {
        try {
            g().b.add(cVar);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("InnerManager", "registerObserver", th);
        }
    }

    @Override // com.opos.cmn.func.dl.base.d
    public void b(c cVar) {
        try {
            g().b.remove(cVar);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("InnerManager", "unregisterObserver", th);
        }
    }
}
