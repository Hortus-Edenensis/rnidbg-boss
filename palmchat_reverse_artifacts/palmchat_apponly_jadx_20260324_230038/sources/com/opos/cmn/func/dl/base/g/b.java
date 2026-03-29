package com.opos.cmn.func.dl.base.g;

import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.c;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f7999a;
    public List<c> b = new ArrayList();

    @Override // com.opos.cmn.func.dl.base.c
    public final void b(final DownloadRequest downloadRequest, final DownloadResponse downloadResponse) {
        com.opos.cmn.an.f.a.a("StatusDispatcher", "onStart:" + downloadRequest.f7955a);
        a().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.2
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.b.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).b(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void c(final DownloadRequest downloadRequest, final DownloadResponse downloadResponse) {
        a().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.3
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.b.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).c(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void d(final DownloadRequest downloadRequest, final DownloadResponse downloadResponse) {
        com.opos.cmn.an.f.a.a("StatusDispatcher", "onPause:" + downloadRequest.f7955a);
        a().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.4
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.b.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).d(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void e(final DownloadRequest downloadRequest, final DownloadResponse downloadResponse) {
        com.opos.cmn.an.f.a.a("StatusDispatcher", "onCancle:" + downloadRequest.f7955a);
        a().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.5
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.b.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).e(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void f(final DownloadRequest downloadRequest, final DownloadResponse downloadResponse) {
        com.opos.cmn.an.f.a.a("StatusDispatcher", "onComplete:" + downloadRequest.f7955a);
        a().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.6
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.b.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).f(downloadRequest, downloadResponse);
                }
            }
        });
    }

    private synchronized Executor a() {
        if (this.f7999a == null) {
            new com.opos.cmn.func.dl.base.b.a();
            this.f7999a = com.opos.cmn.an.j.b.b();
        }
        return this.f7999a;
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void a(final DownloadRequest downloadRequest, final DownloadResponse downloadResponse) {
        com.opos.cmn.an.f.a.a("StatusDispatcher", "onQueued:" + downloadRequest.f7955a);
        a().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.b.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(downloadRequest, downloadResponse);
                }
            }
        });
    }

    @Override // com.opos.cmn.func.dl.base.c
    public final void a(final DownloadRequest downloadRequest, final DownloadResponse downloadResponse, final DlException dlException) {
        com.opos.cmn.an.f.a.a("StatusDispatcher", "onError:request url:" + downloadRequest.f7955a + " exception:" + dlException.toString());
        a().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.g.b.7
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = b.this.b.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(downloadRequest, downloadResponse, dlException);
                }
            }
        });
    }
}
