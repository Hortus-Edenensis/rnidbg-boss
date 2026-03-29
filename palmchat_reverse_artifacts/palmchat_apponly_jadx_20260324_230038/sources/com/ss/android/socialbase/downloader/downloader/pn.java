package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.lantern.auth.app.FunDC;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn {
    private static String nr = "ResponseHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private bq f10607a;
    private final String b;
    private final boolean bg;
    private final com.ss.android.socialbase.downloader.n.u bq;
    private final boolean c;
    private long d;
    private final com.ss.android.socialbase.downloader.u.u dw;
    private final DownloadInfo fx;
    private long gi;
    private long h;
    private final com.ss.android.socialbase.downloader.network.a iz;
    private com.ss.android.socialbase.downloader.model.pn jk;
    private long k;
    private final boolean kj;
    private volatile boolean l;
    private volatile boolean mv;
    private long my;
    private com.ss.android.socialbase.downloader.impls.t n;
    private volatile long o;
    private final com.ss.android.socialbase.downloader.model.nr pn;
    private final long q;
    private final long qq;
    private long rh;
    private final com.ss.android.socialbase.downloader.a.iz s;
    private volatile long sx;
    private BaseException t;
    private jk x;
    private boolean z;
    boolean u = false;
    private volatile long ja = 0;
    private volatile long bf = 0;

    public pn(DownloadInfo downloadInfo, String str, com.ss.android.socialbase.downloader.network.a aVar, com.ss.android.socialbase.downloader.model.nr nrVar, com.ss.android.socialbase.downloader.a.iz izVar) {
        this.fx = downloadInfo;
        this.b = str;
        jk jkVarKj = fx.kj();
        this.x = jkVarKj;
        if (jkVarKj instanceof com.ss.android.socialbase.downloader.impls.b) {
            com.ss.android.socialbase.downloader.impls.b bVar = (com.ss.android.socialbase.downloader.impls.b) jkVarKj;
            this.n = bVar.u();
            this.f10607a = bVar.iz();
        }
        this.iz = aVar;
        this.pn = nrVar;
        this.s = izVar;
        long jS = nrVar.s();
        this.k = jS;
        this.my = jS;
        if (nrVar.b()) {
            this.sx = nrVar.o();
        } else {
            this.sx = nrVar.fx(false);
        }
        this.o = nrVar.my();
        this.dw = com.ss.android.socialbase.downloader.u.u.u();
        com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId());
        this.bq = uVarU;
        boolean z = uVarU.u("sync_strategy", 0) == 1;
        this.c = z;
        if (z) {
            long jU = uVarU.u("sync_interval_ms_fg", 5000);
            long jU2 = uVarU.u("sync_interval_ms_bg", 1000);
            this.q = Math.max(jU, 500L);
            this.qq = Math.max(jU2, 500L);
        } else {
            this.q = 0L;
            this.qq = 0L;
        }
        this.kj = uVarU.nr("monitor_rw") == 1;
        this.bg = com.ss.android.socialbase.downloader.jk.u.u(65536);
    }

    private boolean iz() {
        return this.l || this.mv;
    }

    private void n() {
        boolean z;
        long jNanoTime = this.kj ? System.nanoTime() : 0L;
        try {
            this.jk.u();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            this.fx.updateRealDownloadTime(true);
            boolean z2 = this.fx.getChunkCount() > 1;
            mv mvVarU = com.ss.android.socialbase.downloader.impls.l.u(com.ss.android.socialbase.downloader.jk.iz.nr());
            if (z2) {
                u(this.f10607a);
                if (mvVarU != null) {
                    mvVarU.fx(this.fx);
                } else {
                    this.f10607a.u(this.fx.getId(), this.fx.getCurBytes());
                }
            } else if (mvVarU != null) {
                mvVarU.fx(this.fx);
            } else {
                this.f10607a.u(this.pn.t(), this.k);
            }
            this.ja = this.k;
        }
        if (this.kj) {
            this.h += System.nanoTime() - jNanoTime;
        }
    }

    private boolean nr(long j, long j2) {
        return j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j2 > 500;
    }

    private void x() {
        ExecutorService executorServiceL;
        if (this.iz == null || (executorServiceL = fx.l()) == null) {
            return;
        }
        executorServiceL.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.pn.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pn.this.iz.b();
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x023c A[Catch: all -> 0x028d, TryCatch #17 {all -> 0x028d, blocks: (B:144:0x0238, B:146:0x023c, B:147:0x023e, B:157:0x0253, B:158:0x0254, B:160:0x025d, B:148:0x023f, B:150:0x0243, B:152:0x024c, B:153:0x024f), top: B:341:0x0238, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0254 A[Catch: all -> 0x028d, TryCatch #17 {all -> 0x028d, blocks: (B:144:0x0238, B:146:0x023c, B:147:0x023e, B:157:0x0253, B:158:0x0254, B:160:0x025d, B:148:0x023f, B:150:0x0243, B:152:0x024c, B:153:0x024f), top: B:341:0x0238, inners: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x035b A[Catch: all -> 0x04cc, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x04cc, blocks: (B:186:0x02e4, B:215:0x035b, B:216:0x035e, B:257:0x0451, B:258:0x0453, B:262:0x0459, B:264:0x0472, B:292:0x04c6, B:293:0x04cb), top: B:340:0x0028, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03df A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0229 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0119 A[Catch: all -> 0x0107, BaseException -> 0x010e, TRY_ENTER, TRY_LEAVE, TryCatch #37 {BaseException -> 0x010e, all -> 0x0107, blocks: (B:48:0x0102, B:56:0x0119), top: B:353:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0129 A[Catch: all -> 0x029a, BaseException -> 0x02a1, TRY_LEAVE, TryCatch #33 {BaseException -> 0x02a1, all -> 0x029a, blocks: (B:54:0x0113, B:57:0x0125, B:59:0x0129), top: B:361:0x0113 }] */
    /* JADX WARN: Type inference failed for: r21v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() throws BaseException {
        long j;
        long j2;
        int iU;
        com.ss.android.socialbase.downloader.pn.nr nrVarU;
        long j3;
        BaseException baseException;
        boolean z;
        boolean z2;
        com.ss.android.socialbase.downloader.network.a aVar;
        String str;
        DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.n.u uVar;
        ?? r4;
        boolean z3;
        boolean z4;
        com.ss.android.socialbase.downloader.network.a aVar2;
        String str2;
        DownloadInfo downloadInfo2;
        com.ss.android.socialbase.downloader.n.u uVar2;
        ?? r42;
        ?? r43;
        ?? r44;
        int i;
        InputStream inputStreamU;
        long j4;
        long j5;
        long jCurrentTimeMillis;
        long jNanoTime;
        long j6;
        int i2;
        com.ss.android.socialbase.downloader.pn.nr nrVar;
        com.ss.android.socialbase.downloader.network.a aVar3;
        com.ss.android.socialbase.downloader.pn.nr nrVar2;
        if (iz() || this.pn == null) {
            return;
        }
        long jU = com.ss.android.socialbase.downloader.jk.iz.u(this.iz);
        ?? r45 = 0;
        if (jU == 0) {
            throw new com.ss.android.socialbase.downloader.exception.iz(1004, "the content-length is 0");
        }
        long jL = this.pn.l();
        long jNanoTime2 = System.nanoTime();
        boolean z5 = this.kj;
        int i3 = 1;
        try {
            try {
                DownloadInfo downloadInfo3 = this.fx;
                String tempPath = downloadInfo3.getTempPath();
                String tempName = this.fx.getTempName();
                i = -1;
                iU = this.bq.u("flush_buffer_size_byte", -1);
                com.ss.android.socialbase.downloader.model.pn pnVarU = com.ss.android.socialbase.downloader.jk.iz.u(downloadInfo3, tempPath, tempName, iU);
                this.jk = pnVarU;
                try {
                    try {
                        pnVarU.u(this.k);
                        inputStreamU = this.iz.u();
                    } catch (IOException e) {
                        throw new BaseException(FunDC.ID_AUTH_1054, e);
                    }
                } catch (BaseException e2) {
                    e = e2;
                    nrVarU = null;
                    r44 = iU;
                } catch (Throwable th) {
                    th = th;
                    nrVarU = null;
                    r45 = iU;
                    com.ss.android.socialbase.downloader.fx.u.b(nr, "handleResponse: e = ".concat(String.valueOf(th)));
                    if (iz()) {
                    }
                }
            } catch (Throwable th2) {
                com.ss.android.socialbase.downloader.network.a aVar4 = this.iz;
                if (aVar4 != null) {
                    aVar4.b();
                }
                if (nrVarU != null) {
                    nrVarU.nr();
                }
                try {
                    if (this.bg) {
                        synchronized (this.s) {
                            if (!this.mv) {
                                u(this.n);
                                if (this.jk != null) {
                                    n();
                                }
                            }
                        }
                    } else {
                        u(this.n);
                        if (this.jk != null) {
                            n();
                        }
                    }
                    com.ss.android.socialbase.downloader.jk.iz.u(this.jk);
                    this.rh = System.nanoTime() - j2;
                    com.ss.android.socialbase.downloader.b.u.u(this.bq, this.fx, this.b, this.iz, this.l, this.mv, this.t, this.k - this.my, this.rh, r45, this.gi, this.d, this.h, null);
                    throw th2;
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.jk.iz.u(this.jk);
                    throw th3;
                }
            }
        } catch (BaseException e3) {
            e = e3;
            j2 = jNanoTime2;
            iU = z5 ? 1 : 0;
        } catch (Throwable th4) {
            th = th4;
            j = jL;
            j2 = jNanoTime2;
            iU = z5 ? 1 : 0;
        }
        if (inputStreamU == null) {
            throw new BaseException(FunDC.ID_AUTH_1042, new IOException("inputStream is null"));
        }
        this.fx.updateRealStartDownloadTime();
        nrVarU = u(inputStreamU);
        try {
            this.fx.setIsRwConcurrent(this.z);
            this.u = this.fx.getOpenLimitSpeed();
            long j7 = com.ss.android.socialbase.downloader.constants.pn.b;
            j4 = com.ss.android.socialbase.downloader.constants.pn.pn;
            j5 = j7 / (1000 / j4);
            jCurrentTimeMillis = System.currentTimeMillis();
            jNanoTime = 0;
            j6 = 0;
            z5 = z5;
        } catch (BaseException e4) {
            e = e4;
            j2 = jNanoTime2;
            r44 = z5;
        } catch (Throwable th5) {
            th = th5;
            j = jL;
            j2 = jNanoTime2;
            r45 = z5;
        }
        try {
            while (!iz()) {
                boolean z6 = z5 ? 1 : 0;
                if (z6) {
                    try {
                        jNanoTime = System.nanoTime();
                        try {
                            com.ss.android.socialbase.downloader.iz.u uVarU = nrVarU.u();
                            if (z6) {
                                this.gi += System.nanoTime() - jNanoTime;
                            }
                            i2 = uVarU.fx;
                            if (i2 == i) {
                                if (this.fx.isIgnoreDataVerify()) {
                                    j = jL;
                                    j2 = jNanoTime2;
                                    nrVar2 = nrVarU;
                                } else {
                                    j = jL;
                                    try {
                                        j2 = jNanoTime2;
                                    } catch (BaseException e5) {
                                        e = e5;
                                        j2 = jNanoTime2;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        j2 = jNanoTime2;
                                    }
                                    try {
                                        nrVar2 = nrVarU;
                                        try {
                                            if (this.sx > this.k - this.my && this.sx < (this.k - this.my) + ((long) i2)) {
                                                i2 = (int) (this.sx - (this.k - this.my));
                                            }
                                        } catch (BaseException e6) {
                                            e = e6;
                                            nrVarU = nrVar2;
                                            r44 = z6;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            nrVarU = nrVar2;
                                            r45 = z6;
                                            com.ss.android.socialbase.downloader.fx.u.b(nr, "handleResponse: e = ".concat(String.valueOf(th)));
                                            if (iz()) {
                                            }
                                        }
                                    } catch (BaseException e7) {
                                        e = e7;
                                        r44 = z6;
                                    } catch (Throwable th8) {
                                        th = th8;
                                        r45 = z6;
                                        com.ss.android.socialbase.downloader.fx.u.b(nr, "handleResponse: e = ".concat(String.valueOf(th)));
                                        if (iz()) {
                                        }
                                    }
                                }
                                if (z6) {
                                    jNanoTime = System.nanoTime();
                                }
                                try {
                                    this.jk.u(uVarU.u, 0, i2);
                                    if (z6) {
                                        this.d += System.nanoTime() - jNanoTime;
                                    }
                                    nrVar = nrVar2;
                                } catch (BaseException e8) {
                                    e = e8;
                                    nrVar = nrVar2;
                                } catch (Throwable th9) {
                                    th = th9;
                                    nrVar = nrVar2;
                                }
                                try {
                                    nrVar.u(uVarU);
                                    long j8 = i2;
                                    this.k += j8;
                                    j6 += j8;
                                    synchronized (this.s) {
                                        if (!this.bg || !this.mv) {
                                            boolean zNr = this.s.nr(j8);
                                            u(this.n);
                                            u(zNr);
                                        }
                                    }
                                    if (!this.fx.isDownloadWithWifiValid()) {
                                        throw new com.ss.android.socialbase.downloader.exception.fx();
                                    }
                                    if (!this.fx.isPauseReserveWithWifiValid()) {
                                        throw new com.ss.android.socialbase.downloader.exception.pn();
                                    }
                                    if (this.fx.isIgnoreDataVerify() || this.sx < 0 || this.sx > this.k - this.my) {
                                        if (this.u && j6 > j5) {
                                            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                            if (jCurrentTimeMillis2 < j4) {
                                                try {
                                                    Thread.sleep(j4 - jCurrentTimeMillis2);
                                                } catch (InterruptedException unused) {
                                                }
                                            }
                                            jCurrentTimeMillis = System.currentTimeMillis();
                                            j6 = 0;
                                        }
                                        z5 = z6;
                                        nrVarU = nrVar;
                                        jNanoTime2 = j2;
                                        jL = j;
                                        i = -1;
                                        i3 = 1;
                                    }
                                } catch (BaseException e9) {
                                    e = e9;
                                    nrVarU = nrVar;
                                    r44 = z6;
                                    com.ss.android.socialbase.downloader.fx.u.b(nr, "handleResponse: BaseException e = ".concat(String.valueOf(e)));
                                    if (this.bq.u("ignore_base_ex_on_stop_status")) {
                                    }
                                    com.ss.android.socialbase.downloader.fx.u.u();
                                    this.t = e;
                                    throw e;
                                } catch (Throwable th10) {
                                    th = th10;
                                    nrVarU = nrVar;
                                    r45 = z6;
                                    com.ss.android.socialbase.downloader.fx.u.b(nr, "handleResponse: e = ".concat(String.valueOf(th)));
                                    if (iz()) {
                                    }
                                }
                            } else {
                                j = jL;
                                j2 = jNanoTime2;
                                nrVar = nrVarU;
                            }
                            aVar3 = this.iz;
                            if (aVar3 != null) {
                                aVar3.b();
                            }
                            nrVar.nr();
                            try {
                                if (this.bg) {
                                    u(this.n);
                                    if (this.jk != null) {
                                        n();
                                    }
                                } else {
                                    synchronized (this.s) {
                                        if (!this.mv) {
                                            u(this.n);
                                            if (this.jk != null) {
                                                n();
                                            }
                                        }
                                    }
                                }
                                com.ss.android.socialbase.downloader.jk.iz.u(this.jk);
                                this.rh = System.nanoTime() - j2;
                                uVar = this.bq;
                                downloadInfo = this.fx;
                                str = this.b;
                                aVar = this.iz;
                                z2 = this.l;
                                z = this.mv;
                                baseException = this.t;
                                j3 = this.k - this.my;
                                r4 = z6;
                            } catch (Throwable th11) {
                                com.ss.android.socialbase.downloader.jk.iz.u(this.jk);
                                throw th11;
                            }
                        } catch (BaseException e10) {
                            e = e10;
                            j2 = jNanoTime2;
                            r44 = z6;
                        } catch (Throwable th12) {
                            th = th12;
                            j = jL;
                            j2 = jNanoTime2;
                            r45 = z6;
                        }
                    } catch (BaseException e11) {
                        e = e11;
                        j2 = jNanoTime2;
                        r44 = z6;
                    } catch (Throwable th13) {
                        th = th13;
                        j = jL;
                        j2 = jNanoTime2;
                        r45 = z6;
                        com.ss.android.socialbase.downloader.fx.u.b(nr, "handleResponse: e = ".concat(String.valueOf(th)));
                        if (iz()) {
                            com.ss.android.socialbase.downloader.network.a aVar5 = this.iz;
                            if (aVar5 != null) {
                                aVar5.b();
                            }
                            if (nrVarU != null) {
                                nrVarU.nr();
                            }
                            try {
                                if (this.bg) {
                                    synchronized (this.s) {
                                        if (!this.mv) {
                                            u(this.n);
                                            if (this.jk != null) {
                                                n();
                                            }
                                        }
                                    }
                                } else {
                                    u(this.n);
                                    if (this.jk != null) {
                                        n();
                                    }
                                }
                                com.ss.android.socialbase.downloader.jk.iz.u(this.jk);
                                r43 = r45;
                                this.rh = System.nanoTime() - j2;
                                uVar2 = this.bq;
                                downloadInfo2 = this.fx;
                                str2 = this.b;
                                aVar2 = this.iz;
                                z4 = this.l;
                                z3 = this.mv;
                                r42 = r43;
                                com.ss.android.socialbase.downloader.b.u.u(uVar2, downloadInfo2, str2, aVar2, z4, z3, this.t, this.k - this.my, this.rh, r42, this.gi, this.d, this.h, null);
                            } catch (Throwable th14) {
                                com.ss.android.socialbase.downloader.jk.iz.u(this.jk);
                                throw th14;
                            }
                        }
                        com.ss.android.socialbase.downloader.fx.u.u();
                        try {
                            com.ss.android.socialbase.downloader.jk.iz.u(th, "ResponseHandler");
                            com.ss.android.socialbase.downloader.network.a aVar6 = this.iz;
                            if (aVar6 != null) {
                                aVar6.b();
                            }
                            if (nrVarU != null) {
                                nrVarU.nr();
                            }
                            try {
                                if (this.bg) {
                                    synchronized (this.s) {
                                        if (!this.mv) {
                                            u(this.n);
                                            if (this.jk != null) {
                                                n();
                                            }
                                        }
                                    }
                                } else {
                                    u(this.n);
                                    if (this.jk != null) {
                                        n();
                                    }
                                }
                                com.ss.android.socialbase.downloader.jk.iz.u(this.jk);
                                this.rh = System.nanoTime() - j2;
                                uVar = this.bq;
                                downloadInfo = this.fx;
                                str = this.b;
                                aVar = this.iz;
                                z2 = this.l;
                                z = this.mv;
                                baseException = this.t;
                                j3 = this.k - this.my;
                                r4 = r45;
                                com.ss.android.socialbase.downloader.b.u.u(uVar, downloadInfo, str, aVar, z2, z, baseException, j3, this.rh, r4, this.gi, this.d, this.h, null);
                                if (this.fx.isIgnoreDataVerify()) {
                                }
                            } catch (Throwable th15) {
                                com.ss.android.socialbase.downloader.jk.iz.u(this.jk);
                                throw th15;
                            }
                        } catch (BaseException e12) {
                            this.t = e12;
                            throw e12;
                        }
                    }
                    com.ss.android.socialbase.downloader.b.u.u(uVar, downloadInfo, str, aVar, z2, z, baseException, j3, this.rh, r4, this.gi, this.d, this.h, null);
                    if (this.fx.isIgnoreDataVerify()) {
                        return;
                    }
                    long j9 = this.k - this.my;
                    if (j9 >= 0 && this.sx >= 0 && this.sx != j9) {
                        throw new BaseException(FunDC.ID_AUTH_1051, String.format("handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", Long.valueOf(j9), Long.valueOf(jU), Long.valueOf(this.sx), Long.valueOf(j), Long.valueOf(this.o), Long.valueOf(this.k), Long.valueOf(this.my)));
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.iz.u uVarU2 = nrVarU.u();
                if (z6) {
                }
                i2 = uVarU2.fx;
                if (i2 == i) {
                }
                aVar3 = this.iz;
                if (aVar3 != null) {
                }
                nrVar.nr();
                if (this.bg) {
                }
                com.ss.android.socialbase.downloader.jk.iz.u(this.jk);
                this.rh = System.nanoTime() - j2;
                uVar = this.bq;
                downloadInfo = this.fx;
                str = this.b;
                aVar = this.iz;
                z2 = this.l;
                z = this.mv;
                baseException = this.t;
                j3 = this.k - this.my;
                r4 = z6;
                com.ss.android.socialbase.downloader.b.u.u(uVar, downloadInfo, str, aVar, z2, z, baseException, j3, this.rh, r4, this.gi, this.d, this.h, null);
                if (this.fx.isIgnoreDataVerify()) {
                }
                com.ss.android.socialbase.downloader.b.u.u(uVar2, downloadInfo2, str2, aVar2, z4, z3, this.t, this.k - this.my, this.rh, r42, this.gi, this.d, this.h, null);
            }
            if (this.bg) {
                synchronized (this.s) {
                    if (!this.mv) {
                        u(this.n);
                        if (this.jk != null) {
                            n();
                        }
                    }
                }
            } else {
                u(this.n);
                if (this.jk != null) {
                    n();
                }
            }
            Closeable[] closeableArr = new Closeable[i3];
            closeableArr[0] = this.jk;
            com.ss.android.socialbase.downloader.jk.iz.u(closeableArr);
            this.rh = System.nanoTime() - jNanoTime2;
            uVar2 = this.bq;
            downloadInfo2 = this.fx;
            str2 = this.b;
            aVar2 = this.iz;
            z4 = this.l;
            boolean z7 = this.mv;
            r42 = z5 ? 1 : 0;
            z3 = z7;
            com.ss.android.socialbase.downloader.b.u.u(uVar2, downloadInfo2, str2, aVar2, z4, z3, this.t, this.k - this.my, this.rh, r42, this.gi, this.d, this.h, null);
        } catch (Throwable th16) {
            Closeable[] closeableArr2 = new Closeable[i3];
            closeableArr2[0] = this.jk;
            com.ss.android.socialbase.downloader.jk.iz.u(closeableArr2);
            throw th16;
        }
        com.ss.android.socialbase.downloader.network.a aVar7 = this.iz;
        if (aVar7 != null) {
            aVar7.b();
        }
        if (nrVarU != null) {
            nrVarU.nr();
        }
        nrVarU = null;
        r44 = iU;
        com.ss.android.socialbase.downloader.fx.u.b(nr, "handleResponse: BaseException e = ".concat(String.valueOf(e)));
        if (this.bq.u("ignore_base_ex_on_stop_status") || !iz()) {
            com.ss.android.socialbase.downloader.fx.u.u();
            this.t = e;
            throw e;
        }
        com.ss.android.socialbase.downloader.network.a aVar8 = this.iz;
        if (aVar8 != null) {
            aVar8.b();
        }
        if (nrVarU != null) {
            nrVarU.nr();
        }
        try {
            if (this.bg) {
                synchronized (this.s) {
                    if (!this.mv) {
                        u(this.n);
                        if (this.jk != null) {
                            n();
                        }
                    }
                }
            } else {
                u(this.n);
                if (this.jk != null) {
                    n();
                }
            }
            com.ss.android.socialbase.downloader.jk.iz.u(this.jk);
            r43 = r44;
            this.rh = System.nanoTime() - j2;
            uVar2 = this.bq;
            downloadInfo2 = this.fx;
            str2 = this.b;
            aVar2 = this.iz;
            z4 = this.l;
            z3 = this.mv;
            r42 = r43;
            com.ss.android.socialbase.downloader.b.u.u(uVar2, downloadInfo2, str2, aVar2, z4, z3, this.t, this.k - this.my, this.rh, r42, this.gi, this.d, this.h, null);
        } catch (Throwable th17) {
            com.ss.android.socialbase.downloader.jk.iz.u(this.jk);
            throw th17;
        }
    }

    public void fx() {
        if (this.mv) {
            return;
        }
        synchronized (this.s) {
            this.mv = true;
        }
        x();
    }

    public long pn() {
        return this.ja;
    }

    public void nr() {
        if (this.l) {
            return;
        }
        this.l = true;
        x();
    }

    public long u() {
        return this.k;
    }

    public void u(long j, long j2, long j3) {
        this.k = j;
        this.my = j;
        this.o = j2;
        this.sx = j3;
    }

    public void u(long j, long j2) {
        this.o = j;
        this.sx = j2;
    }

    private com.ss.android.socialbase.downloader.pn.nr u(InputStream inputStream) {
        int iXg = fx.xg();
        if (this.bq.u("rw_concurrent", 0) == 1 && this.fx.getChunkCount() == 1 && this.fx.getTotalBytes() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.pn.u uVar = new com.ss.android.socialbase.downloader.pn.u(inputStream, iXg, this.bq.u("rw_concurrent_max_buffer_count", 4));
                this.z = true;
                return uVar;
            } catch (Throwable unused) {
            }
        }
        com.ss.android.socialbase.downloader.pn.fx fxVar = new com.ss.android.socialbase.downloader.pn.fx(inputStream, iXg);
        this.z = false;
        return fxVar;
    }

    private void u(boolean z) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.bf;
        if (this.c) {
            if (j <= (this.dw.nr() ? this.q : this.qq)) {
                return;
            }
        } else {
            long j2 = this.k - this.ja;
            if (!z && !nr(j2, j)) {
                return;
            }
        }
        n();
        this.bf = jUptimeMillis;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(jk jkVar) {
        mv mvVarU;
        com.ss.android.socialbase.downloader.model.nr nrVarPn;
        com.ss.android.socialbase.downloader.model.nr nrVar;
        boolean z;
        if (jkVar == null) {
            return;
        }
        boolean z2 = jkVar instanceof com.ss.android.socialbase.downloader.nr.pn;
        if (z2) {
            mvVarU = com.ss.android.socialbase.downloader.impls.l.u(com.ss.android.socialbase.downloader.jk.iz.nr());
            if (mvVarU == null) {
                return;
            }
        } else {
            mvVarU = null;
        }
        mv mvVar = mvVarU;
        if (this.pn.b()) {
            nrVarPn = this.pn.pn();
        } else {
            nrVarPn = this.pn;
        }
        com.ss.android.socialbase.downloader.model.nr nrVar2 = nrVarPn;
        if (nrVar2 != null) {
            nrVar2.nr(this.k);
            if (z2 && mvVar != null) {
                mvVar.u(nrVar2.t(), nrVar2.bg(), nrVar2.nr(), this.k);
                nrVar = nrVar2;
            } else {
                nrVar = nrVar2;
                jkVar.u(nrVar2.t(), nrVar2.bg(), nrVar2.nr(), this.k);
            }
            if (nrVar.n()) {
                if (nrVar.a()) {
                    long jJk = nrVar.jk();
                    if (jJk > this.k) {
                        if (z2 && mvVar != null) {
                            mvVar.u(nrVar.t(), nrVar.nr(), jJk);
                        } else {
                            jkVar.u(nrVar.t(), nrVar.nr(), jJk);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    return;
                }
                if (z2 && mvVar != null) {
                    mvVar.u(nrVar.t(), nrVar.nr(), this.k);
                    return;
                } else {
                    jkVar.u(nrVar.t(), nrVar.nr(), this.k);
                    return;
                }
            }
            return;
        }
        if (this.pn.b()) {
            if (z2 && mvVar != null) {
                mvVar.u(this.pn.t(), this.pn.bg(), this.k);
            } else {
                jkVar.u(this.pn.t(), this.pn.bg(), this.k);
            }
        }
    }
}
