package com.ss.android.socialbase.downloader.iz;

import android.os.Process;
import android.text.TextUtils;
import com.lantern.auth.app.FunDC;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.umeng.analytics.pro.bd;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class mv implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f10611a;
    volatile long b;
    private long bf;
    private volatile long bg;
    private volatile long bq;
    private volatile long c;
    private volatile boolean d;
    final int fx;
    private Thread gi;
    private int h;
    volatile long iz;
    private int ja;
    String jk;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private boolean f10612jp;
    private com.ss.android.socialbase.downloader.network.a k;
    private volatile boolean kj;
    private final fx l;
    private boolean m;
    private final DownloadInfo mv;
    private com.ss.android.socialbase.downloader.model.b my;
    String n;
    o nr;
    private boolean pb;
    volatile long pn;
    private Future q;
    private volatile boolean qq;
    private int rh;
    private final com.ss.android.socialbase.downloader.n.u s;
    private long sx;
    private final iz t;
    volatile a u;
    private int wq;
    volatile long x;
    private BaseException xg;
    private com.ss.android.socialbase.downloader.jk.pn y;
    private volatile boolean z;
    private final List<a> o = new ArrayList();
    private volatile long dw = -1;

    public mv(DownloadInfo downloadInfo, t tVar, fx fxVar, o oVar, int i) {
        this.mv = downloadInfo;
        this.t = tVar;
        this.l = fxVar;
        this.s = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId());
        this.nr = oVar;
        this.fx = i;
    }

    private void a() {
        this.bf = this.b;
        this.b = -1L;
        this.pn = -1L;
        this.iz = -1L;
        this.x = -1L;
        jk();
    }

    /* JADX WARN: Removed duplicated region for block: B:202:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0173 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017a A[Catch: all -> 0x026c, BaseException -> 0x026e, TryCatch #22 {BaseException -> 0x026e, all -> 0x026c, blocks: (B:27:0x006e, B:28:0x0072, B:49:0x00db, B:87:0x0168, B:89:0x0173, B:90:0x017a, B:92:0x0180, B:94:0x0186, B:97:0x018f, B:98:0x0193, B:132:0x025d), top: B:237:0x005d }] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:78:0x0156
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.ss.android.socialbase.downloader.iz.a r32) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instruction units count: 922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.iz.mv.b(com.ss.android.socialbase.downloader.iz.a):void");
    }

    private void fx(a aVar) throws BaseException {
        String strReplaceFirst;
        com.ss.android.socialbase.downloader.network.a aVarU;
        try {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.pn = 0L;
                this.b = jCurrentTimeMillis;
                this.sx = aVar.pn();
                this.bq = aVar.iz();
                if (this.bq > 0 && this.sx > this.bq) {
                    throw new jk(6, "createConn, ".concat(String.valueOf(aVar)));
                }
                this.y = new com.ss.android.socialbase.downloader.jk.pn();
                List<com.ss.android.socialbase.downloader.model.fx> listU = com.ss.android.socialbase.downloader.jk.iz.u(this.mv.getExtraHeaders(), this.mv.geteTag(), this.sx, this.bq);
                listU.add(new com.ss.android.socialbase.downloader.model.fx("Segment-Index", String.valueOf(aVar.x())));
                listU.add(new com.ss.android.socialbase.downloader.model.fx("Thread-Index", String.valueOf(this.fx)));
                com.ss.android.socialbase.downloader.jk.iz.u(listU, this.mv);
                com.ss.android.socialbase.downloader.jk.iz.nr(listU, this.mv);
                strReplaceFirst = this.nr.u;
                if (this.pb && !TextUtils.isEmpty(strReplaceFirst) && strReplaceFirst.startsWith(BaseConstants.SCHEME_HTTPS)) {
                    strReplaceFirst = strReplaceFirst.replaceFirst(BaseConstants.SCHEME_HTTPS, HttpHost.DEFAULT_SCHEME_NAME);
                }
                String str = this.nr.nr;
                com.ss.android.socialbase.downloader.fx.u.fx("SegmentReader", "createConnectionBegin: url = " + strReplaceFirst + ", ip = " + str + ", segment = " + aVar + ", threadIndex = " + this.fx);
                this.n = strReplaceFirst;
                this.f10611a = str;
                aVarU = com.ss.android.socialbase.downloader.downloader.fx.u(this.mv.isNeedDefaultHttpServiceBackUp(), this.mv.getMaxBytes(), strReplaceFirst, str, listU, 0, jCurrentTimeMillis - this.bf > 3000 && this.s.nr("monitor_download_connect") > 0, this.mv);
            } finally {
                this.pn = System.currentTimeMillis();
            }
        } catch (BaseException e) {
            throw e;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.jk.iz.u(th, "createConn");
        }
        if (aVarU == null) {
            throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
        }
        this.k = aVarU;
        this.my = new com.ss.android.socialbase.downloader.model.b(strReplaceFirst, aVarU);
        if (this.qq) {
            throw new my("createConn");
        }
        if (aVarU instanceof com.ss.android.socialbase.downloader.network.u) {
            this.jk = ((com.ss.android.socialbase.downloader.network.u) aVarU).pn();
        }
    }

    private void jk() {
        com.ss.android.socialbase.downloader.network.a aVar = this.k;
        if (aVar != null) {
            try {
                com.ss.android.socialbase.downloader.fx.u.fx("SegmentReader", "closeConnection: thread = " + this.fx);
                aVar.b();
                aVar.fx();
            } catch (Throwable unused) {
            }
        }
    }

    private void l() {
        this.rh = this.nr.b ? this.mv.getRetryCount() : this.mv.getBackUpUrlRetryCount();
        this.ja = 0;
    }

    private long mv() {
        long j = this.bg;
        this.bg = 0L;
        if (j <= 0) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    private void nr(a aVar) throws com.ss.android.socialbase.downloader.exception.a, BaseException {
        fx(aVar);
        this.t.u(this, aVar, this.nr, this.my);
        this.nr.fx();
    }

    private void t() {
        this.pb = false;
        l();
    }

    private boolean u(a aVar) throws BaseException {
        t();
        while (true) {
            try {
                try {
                    nr(aVar);
                    b(aVar);
                    a();
                    return true;
                } catch (jk e) {
                    this.xg = e;
                    throw e;
                }
            } catch (Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.fx.u.pn("SegmentReader", "download: e = " + th + ", threadIndex = " + this.fx + ", reconnect = " + this.kj + ", closed = " + this.qq);
                    if (this.qq) {
                        a();
                        return false;
                    }
                    if (this.kj) {
                        this.kj = false;
                        try {
                            Thread.interrupted();
                        } catch (Throwable unused) {
                        }
                        if (this.z) {
                            this.z = false;
                            throw new jk(5, "download");
                        }
                    } else {
                        if (th instanceof BaseException) {
                            e = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.jk.iz.u((Throwable) th, "download");
                                e = null;
                            } catch (BaseException e2) {
                                e = e2;
                            }
                        }
                        if (e == null || !u(aVar, e)) {
                            a();
                            return false;
                        }
                    }
                    a();
                } catch (Throwable th2) {
                    a();
                    throw th2;
                }
            }
        }
        a();
        return false;
    }

    public void iz() {
        u(false);
    }

    public long n() {
        return this.sx;
    }

    public void pn() {
        com.ss.android.socialbase.downloader.fx.u.fx("SegmentReader", "close: threadIndex = " + this.fx);
        synchronized (this) {
            this.qq = true;
            this.d = true;
        }
        jk();
        Future future = this.q;
        if (future != null) {
            this.q = null;
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0075, code lost:
    
        r5.u = null;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        a aVarU;
        Process.setThreadPriority(10);
        try {
            try {
                this.gi = Thread.currentThread();
                this.t.u(this);
                this.nr.u(this);
                while (true) {
                    aVarU = this.t.u(this, this.nr);
                    if (aVarU == null) {
                        com.ss.android.socialbase.downloader.fx.u.fx("SegmentReader", "no more segment, thread_index = " + this.fx);
                        break;
                    }
                    this.u = aVarU;
                    try {
                        try {
                            if (!u(aVarU)) {
                                if (!this.qq) {
                                    com.ss.android.socialbase.downloader.fx.u.pn("SegmentReader", "download segment failed, segment = " + aVarU + ", thread_index = " + this.fx + ", failedException = " + this.xg);
                                    break;
                                }
                                break;
                            }
                            this.o.add(aVarU);
                            this.u = null;
                        } catch (jk e) {
                            com.ss.android.socialbase.downloader.fx.u.pn("SegmentReader", "run: SegmentApplyException, e = ".concat(String.valueOf(e)));
                            int i = this.h;
                            if (i >= 50) {
                                com.ss.android.socialbase.downloader.fx.u.pn("SegmentReader", "segment apply failed " + this.h + "times, thread_index = " + this.fx);
                                this.u = null;
                                this.t.u(this, aVarU);
                            } else {
                                this.h = i + 1;
                                this.u = null;
                            }
                        }
                        this.t.u(this, aVarU);
                    } catch (Throwable th) {
                        this.u = null;
                        this.t.u(this, aVarU);
                        throw th;
                    }
                }
                this.t.u(this, aVarU);
                try {
                    this.nr.nr(this);
                    this.t.nr(this);
                } catch (Throwable unused) {
                }
                this.gi = null;
            } catch (Throwable unused2) {
                this.nr.nr(this);
                this.t.nr(this);
                this.gi = null;
            }
        } catch (Throwable unused3) {
            this.gi = null;
        }
    }

    public boolean x() {
        return this.m;
    }

    public long nr() {
        long jFx;
        synchronized (this.t) {
            jFx = this.c + fx();
        }
        return jFx;
    }

    public void nr(boolean z) {
        this.m = z;
    }

    public void nr(long j) {
        long j2 = this.dw;
        com.ss.android.socialbase.downloader.jk.pn pnVar = this.y;
        if (j2 < 0 || pnVar == null) {
            return;
        }
        pnVar.u(j2, j);
    }

    public boolean u(o oVar) {
        int i = this.wq;
        if (i >= 30) {
            return false;
        }
        this.wq = i + 1;
        o oVar2 = this.nr;
        if (oVar2 != null) {
            oVar2.nr(this);
        }
        oVar.u(this);
        this.nr = oVar;
        l();
        return true;
    }

    private boolean u(a aVar, BaseException baseException) {
        com.ss.android.socialbase.downloader.fx.u.pn("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.ja + ", retryCount = " + this.rh);
        this.xg = baseException;
        this.nr.nr();
        this.t.u(this, this.nr, aVar, baseException, this.ja, this.rh);
        int i = this.ja;
        if (i < this.rh) {
            this.ja = i + 1;
            return true;
        }
        if (u(baseException)) {
            return true;
        }
        this.t.u(this, this.nr, aVar, baseException);
        return false;
    }

    private boolean u(BaseException baseException) {
        if (!com.ss.android.socialbase.downloader.jk.iz.fx(baseException)) {
            return false;
        }
        String str = this.nr.u;
        if (TextUtils.isEmpty(str) || !str.startsWith(BaseConstants.SCHEME_HTTPS) || !this.mv.isNeedHttpsToHttpRetry() || this.pb) {
            return false;
        }
        this.pb = true;
        l();
        return true;
    }

    public long fx() {
        synchronized (this.t) {
            long j = this.dw;
            long j2 = this.sx;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    public void fx(boolean z) {
        this.f10612jp = z;
    }

    private u u(fx fxVar, InputStream inputStream) throws Throwable {
        int i;
        u uVarNr = fxVar.nr();
        try {
            i = inputStream.read(uVarNr.u);
        } catch (Throwable th) {
            th = th;
            i = -1;
        }
        try {
            if (i != -1) {
                uVarNr.fx = i;
                if (i == -1) {
                    fxVar.u(uVarNr);
                }
                return uVarNr;
            }
            throw new BaseException(FunDC.ID_AUTH_1073, bd.s);
        } catch (Throwable th2) {
            th = th2;
            if (i == -1) {
                fxVar.u(uVarNr);
            }
            throw th;
        }
    }

    public boolean u(long j) {
        long j2 = this.bq;
        if (j <= 0 && j2 > 0) {
            return false;
        }
        if (j > j2 && j2 > 0) {
            return false;
        }
        this.bg = j;
        this.d = true;
        return true;
    }

    public void u() {
        o oVar = this.nr;
        try {
            synchronized (this.t) {
                long jFx = fx();
                if (jFx > 0) {
                    this.c += jFx;
                    oVar.u(jFx);
                }
                this.dw = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public void u(boolean z) {
        com.ss.android.socialbase.downloader.fx.u.fx("SegmentReader", "reconnect: threadIndex = " + this.fx);
        synchronized (this) {
            this.z = z;
            this.kj = true;
            this.d = true;
        }
        jk();
        Thread thread = this.gi;
        if (thread != null) {
            try {
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    public void u(Future future) {
        this.q = future;
    }

    public long u(long j, long j2) {
        com.ss.android.socialbase.downloader.jk.pn pnVar = this.y;
        if (pnVar == null) {
            return -1L;
        }
        return pnVar.nr(j, j2);
    }

    public long b() {
        return this.dw;
    }
}
