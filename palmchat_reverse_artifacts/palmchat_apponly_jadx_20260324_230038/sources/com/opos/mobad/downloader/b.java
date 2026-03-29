package com.opos.mobad.downloader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.opos.cmn.func.dl.base.DownloadConfig;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.exception.DlException;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {
    private static volatile b b;
    private static final byte[] c = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8774a;
    private com.opos.cmn.func.dl.a d;
    private C0736b e;
    private a f;
    private ConcurrentHashMap<String, DownloadRequest> g = new ConcurrentHashMap<>();
    private boolean h = false;
    private AtomicBoolean i = new AtomicBoolean(false);
    private i j;
    private i k;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(String str);

        void a(String str, int i, long j, long j2);

        void a(String str, long j, long j2);

        void a(String str, String str2);

        void b(String str);

        void b(String str, long j, long j2);

        void c(String str, long j, long j2);

        void d(String str, long j, long j2);
    }

    /* JADX INFO: renamed from: com.opos.mobad.downloader.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0736b implements com.opos.cmn.func.dl.base.c {
        private C0736b() {
        }

        @Override // com.opos.cmn.func.dl.base.c
        public void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || b.this.f == null || downloadResponse == null) {
                return;
            }
            b.this.f.a(downloadRequest.f7955a, downloadResponse.c, downloadResponse.d);
        }

        @Override // com.opos.cmn.func.dl.base.c
        public void b(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || b.this.f == null || downloadResponse == null) {
                return;
            }
            b.this.f.b(downloadRequest.f7955a, downloadResponse.c, downloadResponse.d);
        }

        @Override // com.opos.cmn.func.dl.base.c
        public void c(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || b.this.f == null || downloadResponse == null) {
                return;
            }
            b.this.f.b(downloadRequest.f7955a, downloadResponse.c, downloadResponse.d);
        }

        @Override // com.opos.cmn.func.dl.base.c
        public void d(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || b.this.f == null || downloadResponse == null) {
                return;
            }
            b.this.f.c(downloadRequest.f7955a, downloadResponse.c, downloadResponse.d);
        }

        @Override // com.opos.cmn.func.dl.base.c
        public void e(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || b.this.f == null || downloadResponse == null) {
                return;
            }
            b.this.f.d(downloadRequest.f7955a, downloadResponse.c, downloadResponse.d);
            b.this.f(downloadRequest.f7955a);
        }

        @Override // com.opos.cmn.func.dl.base.c
        public void f(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            String str;
            com.opos.cmn.an.f.a.b("DownloadApkTool", "complete ");
            if (!a(downloadRequest) || b.this.f == null) {
                return;
            }
            if (downloadRequest == null || TextUtils.isEmpty(downloadRequest.b) || TextUtils.isEmpty(downloadRequest.c)) {
                str = null;
            } else {
                str = downloadRequest.b + File.separator + downloadRequest.c;
            }
            b.this.f.a(downloadRequest.f7955a, str);
            b.this.f(downloadRequest.f7955a);
        }

        @Override // com.opos.cmn.func.dl.base.c
        public void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse, DlException dlException) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "fail exception:" + dlException);
            if (!a(downloadRequest) || b.this.f == null || downloadResponse == null || dlException == null) {
                return;
            }
            if (dlException.a() == 1013) {
                b.this.f.b(downloadRequest.f7955a);
            } else {
                b.this.f.a(downloadRequest.f7955a, dlException.a(), downloadResponse.c, downloadResponse.d);
            }
        }

        private boolean a(DownloadRequest downloadRequest) {
            return (downloadRequest == null || TextUtils.isEmpty(downloadRequest.f7955a) || !b.this.g.containsKey(downloadRequest.f7955a)) ? false : true;
        }
    }

    private b(Context context) {
        if (context == null) {
            return;
        }
        this.f8774a = context.getApplicationContext();
        this.j = new c();
        this.d = new com.opos.cmn.func.dl.a(this.f8774a);
        this.e = new C0736b();
    }

    private void c() {
        if (this.i.get()) {
            return;
        }
        a(3, null, null);
    }

    private void e(String str) {
        if (com.opos.cmn.an.d.b.a(str) || com.opos.cmn.an.e.b.a.b(str)) {
            return;
        }
        com.opos.cmn.an.e.b.a.f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.g.remove(str);
    }

    public int a(final String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "add to download but url is empty");
            return -1;
        }
        try {
            c();
            com.opos.cmn.an.f.a.b("DownloadApkTool", "add download request:" + str);
            if (!this.h && !"WIFI".equalsIgnoreCase(com.opos.cmn.an.h.c.a.f(this.f8774a))) {
                this.h = true;
            }
            DownloadRequest.a aVarC = new DownloadRequest.a(str).a(this.h).b(a().a(this.f8774a)).c(a().a(str)).b(false).c(true);
            if (!TextUtils.isEmpty(str2)) {
                aVarC.a(str2);
            }
            DownloadRequest downloadRequestA = aVarC.a(this.f8774a);
            this.g.put(str, downloadRequestA);
            this.d.a(downloadRequestA);
            if (this.f != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.opos.mobad.downloader.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f != null) {
                            b.this.f.a(str);
                        }
                    }
                });
            }
            return downloadRequestA.f;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloadApkTool", "", (Throwable) e);
            return -1;
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "resume download but url is empty");
            return;
        }
        c();
        com.opos.cmn.an.f.a.b("DownloadApkTool", "resume download request:" + str);
        DownloadRequest downloadRequest = this.g.get(str);
        if (downloadRequest != null) {
            this.d.a(downloadRequest);
        }
    }

    public void b() {
        try {
            this.d.b(this.e);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloadApkTool", "", (Throwable) e);
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "cancel download but url is empty");
            return;
        }
        c();
        com.opos.cmn.an.f.a.b("DownloadApkTool", "cancel download request:" + str);
        DownloadRequest downloadRequest = this.g.get(str);
        if (downloadRequest != null) {
            this.d.d(downloadRequest);
        }
    }

    public static b a(Context context) {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new b(context);
                }
            }
        }
        return b;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "pause download but url is empty");
            return;
        }
        c();
        com.opos.cmn.an.f.a.b("DownloadApkTool", "pause download request:" + str);
        DownloadRequest downloadRequest = this.g.get(str);
        if (downloadRequest != null) {
            this.d.c(downloadRequest);
        }
    }

    public i a() {
        i iVar = this.k;
        return iVar != null ? iVar : this.j;
    }

    public void a(int i, i iVar, a aVar) {
        if (this.i.compareAndSet(false, true)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "init download apk manager");
            this.k = iVar;
            this.f = aVar;
            e(a().a(this.f8774a));
            DownloadConfig downloadConfig = new DownloadConfig();
            downloadConfig.a(i).a(true).a(0.005f, 1000, 524288);
            this.d.a(downloadConfig);
            this.d.a(this.e);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "addMobileTask but url is empty");
            return;
        }
        c();
        this.h = true;
        com.opos.cmn.an.f.a.b("DownloadApkTool", "pause download request:" + str);
        DownloadRequest downloadRequest = this.g.get(str);
        if (downloadRequest != null) {
            this.d.b(downloadRequest);
        }
    }
}
