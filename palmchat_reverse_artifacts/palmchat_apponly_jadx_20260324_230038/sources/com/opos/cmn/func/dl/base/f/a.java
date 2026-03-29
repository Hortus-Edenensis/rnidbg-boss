package com.opos.cmn.func.dl.base.f;

import android.text.TextUtils;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.a.a.d;
import com.opos.cmn.func.dl.base.a.c;
import com.opos.cmn.func.dl.base.e;
import com.opos.cmn.func.dl.base.exception.DlException;
import com.opos.cmn.func.dl.base.g.b;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public e c;
    public b d;
    com.opos.cmn.func.dl.base.d.b e;
    private d g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<Integer, DownloadRequest> f7992a = new ConcurrentHashMap();
    public Map<Integer, c> b = new ConcurrentHashMap();
    public com.opos.cmn.func.dl.base.a.a.b f = new com.opos.cmn.func.dl.base.a.a.b();

    /* JADX INFO: renamed from: com.opos.cmn.func.dl.base.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0671a extends com.opos.cmn.func.dl.base.a {
        public C0671a() {
        }

        private void a(int i) {
            a.this.f7992a.remove(Integer.valueOf(i));
            a.this.b.remove(Integer.valueOf(i));
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.c
        public final void d(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            com.opos.cmn.an.f.a.a("RequestManager", "onPause:" + downloadRequest.f7955a);
            a.this.a().b(downloadRequest.f);
            c cVar = a.this.b.get(Integer.valueOf(downloadRequest.f));
            if (cVar == null || cVar.f7967a.m) {
                return;
            }
            a(cVar);
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.c
        public final void e(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            com.opos.cmn.an.f.a.a("RequestManager", "onCancle:" + downloadRequest.f7955a);
            a.this.a().b(downloadRequest.f);
            c cVar = a.this.b.get(Integer.valueOf(downloadRequest.f));
            if (cVar != null) {
                a(cVar);
            }
            a(downloadRequest.f);
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.c
        public final void f(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            com.opos.cmn.an.f.a.a("RequestManager", "onComplete:" + downloadRequest.f7955a);
            c cVar = a.this.b.get(Integer.valueOf(downloadRequest.f));
            if (cVar != null) {
                a(cVar);
            }
            a(downloadRequest.f);
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.c
        public final void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse, DlException dlException) {
            com.opos.cmn.an.f.a.a("RequestManager", "onError:" + dlException.toString());
            a.this.a().b(downloadRequest.f);
            c cVar = a.this.b.get(Integer.valueOf(downloadRequest.f));
            if (cVar != null && !cVar.f7967a.m) {
                a(cVar);
            }
            if (downloadRequest.g) {
                return;
            }
            a(downloadRequest.f);
        }

        private void a(c cVar) {
            final com.opos.cmn.func.dl.base.a.b bVar = cVar.f7967a;
            if (TextUtils.isEmpty(bVar.h)) {
                return;
            }
            a.this.c.f().d().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.f.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.opos.cmn.an.e.b.a.e(bVar.i);
                    com.opos.cmn.an.e.b.a.e(bVar.j);
                }
            });
        }
    }

    public a(e eVar) {
        this.c = eVar;
        this.d = eVar.g();
        this.e = new com.opos.cmn.func.dl.base.d.b(this.c.e(), this);
        eVar.a(new C0671a());
    }

    public final synchronized d a() {
        if (this.g == null) {
            this.g = new d(this.c.e(), this, this.c.a());
        }
        return this.g;
    }

    public final void a(final DownloadRequest downloadRequest, final boolean z) {
        if (downloadRequest == null) {
            com.opos.cmn.an.f.a.d("RequestManager", "Request is null,do nothing");
        } else {
            com.opos.cmn.func.dl.base.b.a().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.f.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    int i = downloadRequest.f;
                    if (a.this.f7992a.get(Integer.valueOf(i)) == null) {
                        a.this.f7992a.put(Integer.valueOf(i), downloadRequest);
                    }
                    c cVar = a.this.b.get(Integer.valueOf(i));
                    if (cVar == null) {
                        cVar = new c(downloadRequest, a.this);
                        a.this.b.put(Integer.valueOf(i), cVar);
                    }
                    a.this.e.a(downloadRequest);
                    cVar.a(z);
                }
            });
        }
    }
}
