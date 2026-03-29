package com.ss.android.socialbase.downloader.a;

import android.annotation.SuppressLint;
import android.os.Process;
import com.ss.android.socialbase.downloader.downloader.jk;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.a;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr implements Runnable {
    private static final String u = "nr";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private jk f10601a;
    private com.ss.android.socialbase.downloader.downloader.pn b;
    private com.ss.android.socialbase.downloader.model.nr fx;
    private DownloadInfo iz;
    private volatile boolean jk;
    private boolean l;
    private a n;
    private com.ss.android.socialbase.downloader.model.nr nr;
    private final DownloadTask pn;
    private volatile boolean t;
    private final iz x;

    public nr(com.ss.android.socialbase.downloader.model.nr nrVar, DownloadTask downloadTask, iz izVar) {
        this.l = false;
        this.fx = nrVar;
        this.pn = downloadTask;
        if (downloadTask != null) {
            this.iz = downloadTask.getDownloadInfo();
        }
        this.x = izVar;
        this.f10601a = com.ss.android.socialbase.downloader.downloader.fx.kj();
        this.fx.u(this);
    }

    private void b() {
        a aVar = this.n;
        if (aVar != null) {
            aVar.b();
            this.n = null;
        }
    }

    private String fx() {
        return this.iz.getConnectionUrl();
    }

    private boolean pn() {
        return this.jk || this.t;
    }

    public void nr() {
        this.t = true;
        com.ss.android.socialbase.downloader.downloader.pn pnVar = this.b;
        if (pnVar != null) {
            pnVar.fx();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        r3.nr.u(false);
     */
    @Override // java.lang.Runnable
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Process.setThreadPriority(10);
        this.nr = this.fx;
        while (true) {
            try {
                this.nr.u(this);
                if (!u(this.nr)) {
                    break;
                }
                this.nr.u(false);
                if (pn()) {
                    break;
                }
                this.nr = this.x.u(this.nr.bg());
                if (pn() || this.nr == null) {
                    break;
                } else {
                    try {
                        Thread.sleep(50L);
                    } catch (Throwable unused) {
                    }
                }
            } finally {
                com.ss.android.socialbase.downloader.model.nr nrVar = this.nr;
                if (nrVar != null) {
                    nrVar.u(false);
                }
                b();
                this.x.u(this);
            }
        }
    }

    public void u(long j, long j2) {
        com.ss.android.socialbase.downloader.downloader.pn pnVar = this.b;
        if (pnVar == null) {
            return;
        }
        pnVar.u(j, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0193 A[Catch: all -> 0x019a, TRY_LEAVE, TryCatch #10 {all -> 0x019a, blocks: (B:103:0x018b, B:106:0x0193), top: B:199:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a7 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01c9 A[Catch: all -> 0x028c, TRY_ENTER, TryCatch #4 {all -> 0x028c, blocks: (B:127:0x01bf, B:131:0x01c9, B:133:0x01cf, B:136:0x01d8, B:138:0x01e0, B:140:0x01e6, B:144:0x01f1, B:146:0x01f5, B:148:0x01fd, B:150:0x020e, B:159:0x0234, B:161:0x023a, B:163:0x0247, B:167:0x024f, B:162:0x0241, B:153:0x021b, B:154:0x0227, B:169:0x025a, B:171:0x0262, B:173:0x026a, B:175:0x0272, B:177:0x027a, B:180:0x0283, B:114:0x01a1, B:118:0x01ab, B:121:0x01b2), top: B:195:0x01bf, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x01c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f2 A[Catch: all -> 0x019f, BaseException -> 0x01bb, TRY_ENTER, TryCatch #14 {BaseException -> 0x01bb, blocks: (B:22:0x004e, B:26:0x0058, B:30:0x0063, B:58:0x00e8, B:62:0x00f2, B:64:0x00f6, B:75:0x0124, B:49:0x00d5), top: B:203:0x004e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean u(com.ss.android.socialbase.downloader.model.nr nrVar) {
        com.ss.android.socialbase.downloader.model.nr nrVarPn;
        boolean z;
        long j;
        long jU;
        com.ss.android.socialbase.downloader.exception.n nVarU;
        int iNr;
        iz izVar;
        a aVar;
        int iNr2;
        a aVar2;
        int iNr3;
        while (true) {
            if (!nrVar.b() || !nrVar.iz() || (nrVarPn = nrVar.pn()) == null || nrVarPn.bg() != nrVar.bg()) {
                nrVarPn = null;
            }
            com.ss.android.socialbase.downloader.model.nr nrVar2 = nrVarPn;
            if (nrVar2 != null && nrVar2.a()) {
                return true;
            }
            long jS = nrVar.s();
            long jMy = nrVar.my();
            long jS2 = nrVar.s();
            if (nrVar2 != null) {
                jS2 = nrVar2.s();
                jS = nrVar2.s();
                jMy = nrVar2.my();
            }
            long j2 = jS;
            long j3 = jMy;
            long jU2 = 0;
            boolean z2 = false;
            try {
                try {
                    if (pn()) {
                        return false;
                    }
                    String strFx = fx();
                    boolean z3 = this.n != null;
                    this.l = z3;
                    nrVar.nr(z3);
                    try {
                        try {
                            try {
                                if (!this.l) {
                                    List<com.ss.android.socialbase.downloader.model.fx> listU = com.ss.android.socialbase.downloader.jk.iz.u(this.iz.getExtraHeaders(), this.iz.geteTag(), j2, j3);
                                    listU.add(new com.ss.android.socialbase.downloader.model.fx("Chunk-Index", String.valueOf(nrVar.bg())));
                                    com.ss.android.socialbase.downloader.jk.iz.u(listU, this.iz);
                                    com.ss.android.socialbase.downloader.jk.iz.nr(listU, this.iz);
                                    this.n = com.ss.android.socialbase.downloader.downloader.fx.u(this.iz.isNeedDefaultHttpServiceBackUp(), this.iz.getMaxBytes(), strFx, listU);
                                }
                                aVar2 = this.n;
                            } catch (Throwable unused) {
                            }
                        } catch (BaseException e) {
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                aVar = this.n;
                                if (aVar != null && this.x != null) {
                                    try {
                                        iNr2 = aVar.nr();
                                        if (iNr2 >= 200 || iNr2 >= 300) {
                                            this.x.u(this.n);
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            try {
                                com.ss.android.socialbase.downloader.jk.iz.u(th2, "ChunkRunnableConnection");
                                a aVar3 = this.n;
                                if (aVar3 != null && this.x != null && ((iNr = aVar3.nr()) < 200 || iNr >= 300)) {
                                    izVar = this.x;
                                }
                                if (!pn()) {
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                aVar = this.n;
                                if (aVar != null) {
                                    iNr2 = aVar.nr();
                                    if (iNr2 >= 200) {
                                        this.x.u(this.n);
                                    }
                                }
                                throw th;
                            }
                            if (!pn()) {
                            }
                        }
                        if (aVar2 != null && this.x != null && ((iNr3 = aVar2.nr()) < 200 || iNr3 >= 300)) {
                            izVar = this.x;
                            izVar.u(this.n);
                        }
                        if (!pn()) {
                            return false;
                        }
                        a aVar4 = this.n;
                        if (aVar4 != null) {
                            if (!this.l) {
                                try {
                                    int iNr4 = aVar4.nr();
                                    if (!com.ss.android.socialbase.downloader.jk.iz.b(iNr4)) {
                                        throw new BaseException(1002, String.format("Http response error , code is : %s ", String.valueOf(iNr4)));
                                    }
                                } catch (BaseException e2) {
                                    throw e2;
                                } catch (Throwable th4) {
                                    com.ss.android.socialbase.downloader.jk.iz.u(th4, "ChunkRunnableGetResponseCode");
                                }
                            }
                            z = false;
                            j = jS2;
                            try {
                                try {
                                    this.b = new com.ss.android.socialbase.downloader.downloader.pn(this.iz, strFx, this.n, nrVar, this.x);
                                    if (nrVar2 != null) {
                                        long jFx = nrVar2.fx(false);
                                        if (j3 != 0 && j3 >= j2) {
                                            jFx = (j3 - j2) + 1;
                                        }
                                        this.b.u(nrVar2.s(), nrVar2.my(), jFx);
                                    }
                                    try {
                                        this.b.b();
                                        return true;
                                    } catch (BaseException e3) {
                                        e = e3;
                                        z2 = true;
                                        try {
                                            if (!pn()) {
                                                return true;
                                            }
                                            if (com.ss.android.socialbase.downloader.jk.iz.nr(e)) {
                                                this.x.u(e, z);
                                                return z;
                                            }
                                            if (this.x.u(e)) {
                                                if (com.ss.android.socialbase.downloader.jk.iz.u(e)) {
                                                    this.x.u(e, true);
                                                    return z;
                                                }
                                                if (!z2) {
                                                    jU = jU2;
                                                } else if (this.b != null) {
                                                    if (com.ss.android.socialbase.downloader.jk.u.u(32)) {
                                                        jU = this.b.u() - this.b.pn();
                                                        if (jU > 0) {
                                                            u(nrVar, this.b.pn());
                                                        } else if (jU < 0) {
                                                        }
                                                    } else {
                                                        jU2 = this.b.u() - j;
                                                        u(nrVar, j);
                                                    }
                                                    jU = jU2;
                                                } else {
                                                    this.x.nr(e);
                                                    return z;
                                                }
                                                if (com.ss.android.socialbase.downloader.jk.u.u(16)) {
                                                    nVarU = this.x.u(nrVar, e, jU);
                                                } else {
                                                    nVarU = this.x.u(e, jU);
                                                }
                                                if (nVarU == com.ss.android.socialbase.downloader.exception.n.RETURN) {
                                                    return z;
                                                }
                                                nrVar.nr(z);
                                                b();
                                            } else {
                                                if (this.iz.isNeedChunkDowngradeRetry() && !this.iz.isChunkDowngradeRetryUsed() && this.iz.getChunkCount() > 1 && com.ss.android.socialbase.downloader.jk.iz.u(e, this.iz)) {
                                                    this.x.fx(e);
                                                    return z;
                                                }
                                                this.x.nr(e);
                                                return z;
                                            }
                                        } finally {
                                            b();
                                        }
                                    }
                                } catch (BaseException e4) {
                                    e = e4;
                                    z2 = false;
                                    if (!pn()) {
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } else {
                            throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
                        }
                    } catch (BaseException e5) {
                        e = e5;
                        j = jS2;
                        z = false;
                    }
                } catch (BaseException e6) {
                    e = e6;
                    j = jS2;
                    z = false;
                }
            } catch (Throwable th6) {
                th = th6;
                z = false;
            }
            if (!pn()) {
                return true;
            }
            try {
                com.ss.android.socialbase.downloader.jk.iz.u(th, "downloadChunkInner");
            } catch (BaseException e7) {
                this.x.nr(e7);
            }
            return z;
        }
    }

    public nr(com.ss.android.socialbase.downloader.model.nr nrVar, DownloadTask downloadTask, a aVar, iz izVar) {
        this(nrVar, downloadTask, izVar);
        this.n = aVar;
    }

    private void u(com.ss.android.socialbase.downloader.model.nr nrVar, long j) {
        com.ss.android.socialbase.downloader.model.nr nrVarPn = nrVar.b() ? nrVar.pn() : nrVar;
        if (nrVarPn != null) {
            if (nrVarPn.n()) {
                this.f10601a.u(nrVarPn.t(), nrVarPn.nr(), j);
            }
            nrVarPn.nr(j);
            this.f10601a.u(nrVarPn.t(), nrVarPn.bg(), nrVarPn.nr(), j);
            return;
        }
        if (nrVar.b()) {
            this.f10601a.u(nrVar.t(), nrVar.bg(), j);
        }
    }

    public void u() {
        this.jk = true;
        com.ss.android.socialbase.downloader.downloader.pn pnVar = this.b;
        if (pnVar != null) {
            pnVar.nr();
        }
    }
}
