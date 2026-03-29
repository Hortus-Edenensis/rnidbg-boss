package com.ss.android.socialbase.downloader.iz;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class x {
    private final DownloadInfo fx;
    private final com.ss.android.socialbase.downloader.a.iz iz;
    private final long k;
    private final boolean mv;
    private final boolean my;
    private BaseException n;
    private long o;
    private final com.ss.android.socialbase.downloader.n.u pn;
    private final long s;
    private final fx x;
    private final List<l> u = new LinkedList();
    private final List<l> nr = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f10616a = false;
    private volatile boolean jk = false;
    private volatile boolean t = false;
    private volatile long sx = 0;
    private volatile long bg = 0;
    private final com.ss.android.socialbase.downloader.downloader.jk b = com.ss.android.socialbase.downloader.downloader.fx.kj();
    private final com.ss.android.socialbase.downloader.u.u l = com.ss.android.socialbase.downloader.u.u.u();

    public x(DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.a.iz izVar, fx fxVar) {
        this.fx = downloadInfo;
        this.iz = izVar;
        this.x = fxVar;
        com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId());
        this.pn = uVarU;
        boolean z = uVarU.u("sync_strategy", 0) == 1;
        this.mv = z;
        if (z) {
            long jU = uVarU.u("sync_interval_ms_fg", 5000);
            long jU2 = uVarU.u("sync_interval_ms_bg", 1000);
            this.s = Math.max(jU, 500L);
            this.k = Math.max(jU2, 500L);
        } else {
            this.s = 0L;
            this.k = 0L;
        }
        this.my = uVarU.nr("monitor_rw") == 1;
    }

    private void fx() throws IOException {
        boolean z;
        boolean z2 = this.my;
        long jNanoTime = z2 ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.fx;
        com.ss.android.socialbase.downloader.downloader.jk jkVar = this.b;
        List<l> list = this.u;
        List<l> list2 = this.nr;
        Map<Long, a> mapL = jkVar.l(downloadInfo.getId());
        if (mapL == null) {
            mapL = new HashMap<>(4);
        }
        synchronized (this) {
            u(list);
            try {
                nr(list);
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
            u(list, mapL);
            if (list2.size() > 0) {
                fx(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z) {
            downloadInfo.updateRealDownloadTime(true);
            jkVar.u(downloadInfo.getId(), mapL);
            jkVar.u(downloadInfo);
            this.sx = downloadInfo.getCurBytes();
        }
        if (z2) {
            this.o += System.nanoTime() - jNanoTime;
        }
    }

    private void nr(List<l> list) throws IOException {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            it.next().fx();
        }
    }

    private boolean u(long j, long j2) {
        return j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j2 > 500;
    }

    public void u(l lVar) {
        synchronized (this) {
            this.u.add(lVar);
        }
    }

    public void nr() {
        this.jk = true;
        this.f10616a = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b8, code lost:
    
        if (r13 <= 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bb, code lost:
    
        r3.nr(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ec A[Catch: all -> 0x03a1, TryCatch #0 {all -> 0x03a1, blocks: (B:158:0x01e8, B:160:0x01ec, B:163:0x01f2, B:164:0x0204, B:201:0x0281, B:202:0x0283, B:241:0x0303, B:243:0x030d, B:245:0x0311, B:282:0x038c, B:283:0x03a0), top: B:329:0x0027, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x030d A[Catch: all -> 0x03a1, TryCatch #0 {all -> 0x03a1, blocks: (B:158:0x01e8, B:160:0x01ec, B:163:0x01f2, B:164:0x0204, B:201:0x0281, B:202:0x0283, B:241:0x0303, B:243:0x030d, B:245:0x0311, B:282:0x038c, B:283:0x03a0), top: B:329:0x0027, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x03d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:340:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x03bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x02a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:358:0x022d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0339 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0290 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0215 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(b bVar) throws BaseException {
        DownloadInfo downloadInfo;
        long curBytes;
        long jNanoTime;
        boolean z;
        boolean z2;
        long j;
        long j2;
        long j3;
        long j4;
        Throwable th;
        int i;
        Throwable th2;
        Throwable th3;
        Throwable th4;
        Throwable th5;
        long jNanoTime2;
        long jNanoTime3;
        long j5;
        int i2;
        u uVarU;
        Throwable th6;
        if (this.jk || this.t) {
            return;
        }
        com.ss.android.socialbase.downloader.network.nr.pn();
        this.n = null;
        downloadInfo = this.fx;
        com.ss.android.socialbase.downloader.a.iz izVar = this.iz;
        fx fxVar = this.x;
        curBytes = downloadInfo.getCurBytes();
        jNanoTime = System.nanoTime();
        z = this.my;
        long jNanoTime4 = 0;
        z2 = true;
        int i3 = 0;
        boolean z3 = false;
        try {
            try {
                downloadInfo.updateRealStartDownloadTime();
                jNanoTime2 = 0;
                jNanoTime3 = 0;
                j5 = 0;
                i2 = 0;
            } catch (Throwable th7) {
                th = th7;
                if (i3 > 0) {
                    try {
                        izVar.nr(i3);
                    } catch (Throwable unused) {
                    }
                }
                if (this.t) {
                    try {
                        fx();
                        th5 = null;
                    } catch (Throwable th8) {
                        com.ss.android.socialbase.downloader.fx.u.b("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th8)));
                        th5 = th8;
                        synchronized (this) {
                        }
                    }
                } else {
                    th5 = null;
                }
                synchronized (this) {
                    fx(this.u);
                    this.u.clear();
                }
                com.ss.android.socialbase.downloader.b.u.u(this.pn, downloadInfo, downloadInfo.getUrl(), null, this.jk, this.t, this.n, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j2, j, this.o, null);
                if (th5 != null) {
                    if (!this.jk && !this.t && this.n == null) {
                        z2 = false;
                    }
                    if (!z2) {
                        try {
                            com.ss.android.socialbase.downloader.jk.iz.u(th5, "loopAndWrite_finally");
                            throw th;
                        } catch (BaseException e) {
                            this.n = e;
                            throw e;
                        }
                    }
                    throw th;
                }
                throw th;
            }
        } catch (my e2) {
            e = e2;
            j4 = 0;
        } catch (BaseException e3) {
            e = e3;
            j3 = 0;
            j2 = 0;
        } catch (Throwable th9) {
            th = th9;
            j = 0;
            j2 = 0;
        }
        while (true) {
            if (z) {
                try {
                    jNanoTime2 = System.nanoTime();
                } catch (my e4) {
                    e = e4;
                    i3 = i2;
                    j4 = jNanoTime3;
                } catch (BaseException e5) {
                    e = e5;
                    j2 = jNanoTime4;
                    i = i2;
                    j3 = jNanoTime3;
                    if (!this.pn.u("ignore_base_ex_on_stop_status") && (this.jk || this.t)) {
                        if (i > 0) {
                            try {
                                izVar.nr(i);
                            } catch (Throwable unused2) {
                            }
                        }
                        if (this.t) {
                            th4 = null;
                        } else {
                            try {
                                fx();
                                th4 = null;
                            } catch (Throwable th10) {
                                th4 = th10;
                                com.ss.android.socialbase.downloader.fx.u.b("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th4)));
                                synchronized (this) {
                                    fx(this.u);
                                    this.u.clear();
                                }
                                com.ss.android.socialbase.downloader.b.u.u(this.pn, downloadInfo, downloadInfo.getUrl(), null, this.jk, this.t, this.n, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j2, j3, this.o, null);
                                if (th4 != null) {
                                    if (!this.jk && !this.t && this.n == null) {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        return;
                                    }
                                    try {
                                        com.ss.android.socialbase.downloader.jk.iz.u(th4, "loopAndWrite_finally");
                                        return;
                                    } catch (BaseException e6) {
                                        this.n = e6;
                                        throw e6;
                                    }
                                }
                                return;
                            }
                        }
                        synchronized (this) {
                        }
                    } else {
                        com.ss.android.socialbase.downloader.fx.u.u();
                        com.ss.android.socialbase.downloader.fx.u.b("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                        this.n = e;
                        throw e;
                    }
                } catch (Throwable th11) {
                    th = th11;
                    j2 = jNanoTime4;
                    i3 = i2;
                    j = jNanoTime3;
                    if (!this.jk && !this.t) {
                        com.ss.android.socialbase.downloader.fx.u.u();
                        com.ss.android.socialbase.downloader.fx.u.b("MultiSegmentWriter", "loopAndWrite:  e = ".concat(String.valueOf(th)));
                        try {
                            com.ss.android.socialbase.downloader.jk.iz.u(th, "loopAndWrite");
                            if (i3 > 0) {
                                try {
                                    izVar.nr(i3);
                                } catch (Throwable unused3) {
                                }
                            }
                            if (this.t) {
                                try {
                                    fx();
                                    th3 = null;
                                } catch (Throwable th12) {
                                    th3 = th12;
                                    com.ss.android.socialbase.downloader.fx.u.b("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th3)));
                                    synchronized (this) {
                                        fx(this.u);
                                        this.u.clear();
                                    }
                                    com.ss.android.socialbase.downloader.b.u.u(this.pn, downloadInfo, downloadInfo.getUrl(), null, this.jk, this.t, this.n, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j2, j, this.o, null);
                                    if (th3 != null) {
                                        if (!this.jk && !this.t && this.n == null) {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            return;
                                        }
                                        try {
                                            com.ss.android.socialbase.downloader.jk.iz.u(th3, "loopAndWrite_finally");
                                            return;
                                        } catch (BaseException e7) {
                                            this.n = e7;
                                            throw e7;
                                        }
                                    }
                                    return;
                                }
                            } else {
                                th3 = null;
                            }
                            synchronized (this) {
                            }
                        } catch (BaseException e8) {
                            this.n = e8;
                            throw e8;
                        }
                    }
                    if (i3 > 0) {
                        try {
                            izVar.nr(i3);
                        } catch (Throwable unused4) {
                        }
                    }
                    if (this.t) {
                        try {
                            fx();
                            th2 = null;
                        } catch (Throwable th13) {
                            th2 = th13;
                            com.ss.android.socialbase.downloader.fx.u.b("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th2)));
                            synchronized (this) {
                                fx(this.u);
                                this.u.clear();
                            }
                            com.ss.android.socialbase.downloader.b.u.u(this.pn, downloadInfo, downloadInfo.getUrl(), null, this.jk, this.t, this.n, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j2, j, this.o, null);
                            if (th2 != null) {
                                if (!this.jk && !this.t && this.n == null) {
                                    z2 = false;
                                }
                                if (z2) {
                                    return;
                                }
                                try {
                                    com.ss.android.socialbase.downloader.jk.iz.u(th2, "loopAndWrite_finally");
                                    return;
                                } catch (BaseException e9) {
                                    this.n = e9;
                                    throw e9;
                                }
                            }
                            return;
                        }
                    } else {
                        th2 = null;
                    }
                    synchronized (this) {
                    }
                }
            }
            try {
                uVarU = bVar.u();
                if (z) {
                    jNanoTime4 += System.nanoTime() - jNanoTime2;
                }
                j2 = jNanoTime4;
            } catch (my e10) {
                e = e10;
                i3 = i2;
                j4 = jNanoTime3;
            } catch (BaseException e11) {
                e = e11;
                j2 = jNanoTime4;
            } catch (Throwable th14) {
                th = th14;
                j2 = jNanoTime4;
            }
            try {
                int i4 = uVarU.fx;
                if (i4 == -1) {
                    try {
                        u(uVarU.nr);
                        fxVar.u(uVarU);
                        jNanoTime4 = j2;
                    } catch (my e12) {
                        e = e12;
                        i3 = i2;
                        j4 = jNanoTime3;
                        jNanoTime4 = j2;
                        this.n = e;
                        throw e;
                    } catch (BaseException e13) {
                        e = e13;
                        i = i2;
                        j3 = jNanoTime3;
                        if (!this.pn.u("ignore_base_ex_on_stop_status")) {
                        }
                        com.ss.android.socialbase.downloader.fx.u.u();
                        com.ss.android.socialbase.downloader.fx.u.b("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                        this.n = e;
                        throw e;
                    } catch (Throwable th15) {
                        th = th15;
                        i3 = i2;
                        j = jNanoTime3;
                        if (!this.jk) {
                            com.ss.android.socialbase.downloader.fx.u.u();
                            com.ss.android.socialbase.downloader.fx.u.b("MultiSegmentWriter", "loopAndWrite:  e = ".concat(String.valueOf(th)));
                            com.ss.android.socialbase.downloader.jk.iz.u(th, "loopAndWrite");
                            if (i3 > 0) {
                            }
                            if (this.t) {
                            }
                            synchronized (this) {
                            }
                        }
                        if (i3 > 0) {
                        }
                        if (this.t) {
                        }
                        synchronized (this) {
                        }
                    }
                } else {
                    if (z) {
                        jNanoTime2 = System.nanoTime();
                    }
                    uVarU.nr.nr(uVarU);
                    if (z) {
                        jNanoTime3 += System.nanoTime() - jNanoTime2;
                    }
                    j4 = jNanoTime3;
                    try {
                        fxVar.u(uVarU);
                        if (this.f10616a) {
                            if (this.jk) {
                                break;
                            }
                            try {
                                if (this.t) {
                                    break;
                                } else {
                                    this.f10616a = z3;
                                }
                            } catch (my e14) {
                                e = e14;
                                i3 = i2;
                                jNanoTime4 = j2;
                                this.n = e;
                                throw e;
                            } catch (BaseException e15) {
                                e = e15;
                                i = i2;
                                j3 = j4;
                                if (!this.pn.u("ignore_base_ex_on_stop_status")) {
                                }
                                com.ss.android.socialbase.downloader.fx.u.u();
                                com.ss.android.socialbase.downloader.fx.u.b("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                                this.n = e;
                                throw e;
                            } catch (Throwable th16) {
                                th = th16;
                                i3 = i2;
                                j = j4;
                                if (!this.jk) {
                                }
                                if (i3 > 0) {
                                }
                                if (this.t) {
                                }
                                synchronized (this) {
                                }
                            }
                        }
                        i2 += i4;
                        if (i2 >= 65536) {
                            try {
                                long jUptimeMillis = SystemClock.uptimeMillis();
                                if (jUptimeMillis - j5 > 100) {
                                    long j6 = jNanoTime2;
                                    try {
                                        u(jUptimeMillis, izVar.nr(i2));
                                        if (!com.ss.android.socialbase.downloader.network.nr.u) {
                                            if (!downloadInfo.isOnlyWifi()) {
                                                if (downloadInfo.isDownloadFromReserveWifi() && downloadInfo.isPauseReserveOnWifi()) {
                                                    throw new com.ss.android.socialbase.downloader.exception.pn();
                                                }
                                            } else {
                                                throw new com.ss.android.socialbase.downloader.exception.fx();
                                            }
                                        }
                                        j5 = jUptimeMillis;
                                        jNanoTime4 = j2;
                                        jNanoTime3 = j4;
                                        jNanoTime2 = j6;
                                        i2 = 0;
                                    } catch (my e16) {
                                        e = e16;
                                        jNanoTime4 = j2;
                                        i3 = 0;
                                        this.n = e;
                                        throw e;
                                    } catch (BaseException e17) {
                                        e = e17;
                                        j3 = j4;
                                        i = 0;
                                        if (!this.pn.u("ignore_base_ex_on_stop_status")) {
                                        }
                                        com.ss.android.socialbase.downloader.fx.u.u();
                                        com.ss.android.socialbase.downloader.fx.u.b("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                                        this.n = e;
                                        throw e;
                                    } catch (Throwable th17) {
                                        th = th17;
                                        j = j4;
                                        i3 = 0;
                                        if (!this.jk) {
                                        }
                                        if (i3 > 0) {
                                        }
                                        if (this.t) {
                                        }
                                        synchronized (this) {
                                        }
                                    }
                                } else {
                                    jNanoTime4 = j2;
                                    jNanoTime3 = j4;
                                    jNanoTime2 = jNanoTime2;
                                }
                                z3 = false;
                            } catch (my e18) {
                                e = e18;
                                i3 = i2;
                                jNanoTime4 = j2;
                                this.n = e;
                                throw e;
                            } catch (BaseException e19) {
                                e = e19;
                                i = i2;
                                j3 = j4;
                                if (!this.pn.u("ignore_base_ex_on_stop_status")) {
                                }
                                com.ss.android.socialbase.downloader.fx.u.u();
                                com.ss.android.socialbase.downloader.fx.u.b("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                                this.n = e;
                                throw e;
                            } catch (Throwable th18) {
                                th = th18;
                                i3 = i2;
                                j = j4;
                                if (!this.jk) {
                                }
                                if (i3 > 0) {
                                }
                                if (this.t) {
                                }
                                synchronized (this) {
                                }
                            }
                        }
                    } catch (my e20) {
                        e = e20;
                    } catch (BaseException e21) {
                        e = e21;
                    } catch (Throwable th19) {
                        th = th19;
                    }
                }
            } catch (my e22) {
                e = e22;
                i3 = i2;
                j4 = jNanoTime3;
            } catch (BaseException e23) {
                e = e23;
                i = i2;
                j3 = jNanoTime3;
                if (!this.pn.u("ignore_base_ex_on_stop_status")) {
                }
                com.ss.android.socialbase.downloader.fx.u.u();
                com.ss.android.socialbase.downloader.fx.u.b("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                this.n = e;
                throw e;
            } catch (Throwable th20) {
                th = th20;
                i3 = i2;
                j = jNanoTime3;
                if (!this.jk) {
                }
                if (i3 > 0) {
                }
                if (this.t) {
                }
                synchronized (this) {
                }
            }
            try {
                this.n = e;
                throw e;
            } catch (Throwable th21) {
                th = th21;
                j2 = jNanoTime4;
                j = j4;
                if (i3 > 0) {
                }
                if (this.t) {
                }
                synchronized (this) {
                }
            }
        }
        if (this.t) {
            th6 = null;
        } else {
            try {
                fx();
                th6 = null;
            } catch (Throwable th22) {
                th6 = th22;
                com.ss.android.socialbase.downloader.fx.u.b("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th6)));
                synchronized (this) {
                    fx(this.u);
                    this.u.clear();
                }
                com.ss.android.socialbase.downloader.b.u.u(this.pn, downloadInfo, downloadInfo.getUrl(), null, this.jk, this.t, this.n, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j2, j4, this.o, null);
                if (th6 != null) {
                    if (!this.jk && !this.t && this.n == null) {
                        z2 = false;
                    }
                    if (z2) {
                        return;
                    }
                    try {
                        com.ss.android.socialbase.downloader.jk.iz.u(th6, "loopAndWrite_finally");
                        return;
                    } catch (BaseException e24) {
                        this.n = e24;
                        throw e24;
                    }
                }
                return;
            }
        }
        synchronized (this) {
        }
    }

    private void fx(List<l> list) {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private void u(long j, boolean z) throws IOException {
        long j2 = j - this.bg;
        if (this.mv) {
            if (j2 <= (this.l.nr() ? this.s : this.k)) {
                return;
            }
        } else {
            long curBytes = this.fx.getCurBytes() - this.sx;
            if (!z && !u(curBytes, j2)) {
                return;
            }
        }
        fx();
        this.bg = j;
    }

    private void u(pn pnVar) {
        synchronized (this) {
            this.nr.add((l) pnVar);
        }
    }

    private void u(List<l> list) throws IOException {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            it.next().nr();
        }
    }

    private void u(List<l> list, Map<Long, a> map) {
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            a aVarPn = it.next().pn();
            a aVar = map.get(Long.valueOf(aVarPn.fx()));
            if (aVar == null) {
                map.put(Long.valueOf(aVarPn.fx()), new a(aVarPn));
            } else {
                aVar.u(aVarPn.b());
                aVar.fx(aVarPn.iz());
            }
        }
    }

    public void u() {
        this.t = true;
        this.f10616a = true;
    }
}
