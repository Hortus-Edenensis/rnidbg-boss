package com.opos.cmn.func.dl;

import android.content.Context;
import com.opos.cmn.func.dl.base.DownloadConfig;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.c;
import com.opos.cmn.func.dl.base.d;
import com.opos.cmn.func.dl.base.e;
import com.opos.cmn.func.dl.service.DownloadRemoteManager;
import com.opos.cmn.func.dl.service.DownloadService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f7953a;

    public a(Context context) {
        this(context, null);
    }

    @Override // com.opos.cmn.func.dl.base.d
    public final void a(DownloadConfig downloadConfig) {
        this.f7953a.a(downloadConfig);
    }

    @Override // com.opos.cmn.func.dl.base.d
    public final void b(DownloadRequest downloadRequest) {
        this.f7953a.b(downloadRequest);
    }

    @Override // com.opos.cmn.func.dl.base.d
    public final void c(DownloadRequest downloadRequest) {
        this.f7953a.c(downloadRequest);
    }

    @Override // com.opos.cmn.func.dl.base.d
    public final void d(DownloadRequest downloadRequest) {
        this.f7953a.d(downloadRequest);
    }

    public a(Context context, Class cls) {
        d dVar;
        if (context == null) {
            com.opos.cmn.an.f.a.d("DownloadManager", "Context should not be null!");
            return;
        }
        try {
            if (cls != null) {
                try {
                    if (DownloadService.class.isAssignableFrom(cls)) {
                        this.f7953a = new DownloadRemoteManager(context.getApplicationContext(), cls);
                    }
                } catch (NoClassDefFoundError unused) {
                    com.opos.cmn.an.f.a.d("DownloadManager", "library service not include!");
                    if (this.f7953a == null) {
                        this.f7953a = new e(context);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    com.opos.cmn.an.f.a.d("DownloadManager", "create DownloadRemoteManager error", th);
                    if (dVar == null) {
                        return;
                    }
                    return;
                }
            }
            if (this.f7953a == null) {
                this.f7953a = new e(context);
            }
        } finally {
            if (this.f7953a == null) {
                this.f7953a = new e(context);
            }
        }
    }

    @Override // com.opos.cmn.func.dl.base.d
    public final void a(DownloadRequest downloadRequest) {
        this.f7953a.a(downloadRequest);
    }

    @Override // com.opos.cmn.func.dl.base.d
    public final void b(c cVar) {
        this.f7953a.b(cVar);
    }

    @Override // com.opos.cmn.func.dl.base.d
    public final void a(c cVar) {
        this.f7953a.a(cVar);
    }
}
