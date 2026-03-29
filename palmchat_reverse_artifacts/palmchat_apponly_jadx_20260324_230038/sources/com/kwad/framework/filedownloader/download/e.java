package com.kwad.framework.filedownloader.download;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class e {
    private final String afW;
    private final boolean arE;
    private final int arh;
    private final long arp;
    long arq;
    private final long arr;
    private final com.kwad.framework.filedownloader.b.a arw;
    private volatile long asA;
    private final f ase;
    private final int asg;
    private final c asw;
    private final com.kwad.framework.filedownloader.a.b asx;
    private com.kwad.framework.filedownloader.e.a asy;
    private volatile long asz;
    private final long contentLength;
    private volatile boolean ne;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        String afW;
        Integer arn;
        com.kwad.framework.filedownloader.download.a aro;
        c asB;
        Boolean asb;
        f ase;
        Integer asi;
        com.kwad.framework.filedownloader.a.b asx;

        public final e Ak() {
            com.kwad.framework.filedownloader.a.b bVar;
            com.kwad.framework.filedownloader.download.a aVar;
            Integer num;
            if (this.asb == null || (bVar = this.asx) == null || (aVar = this.aro) == null || this.ase == null || this.afW == null || (num = this.arn) == null || this.asi == null) {
                throw new IllegalArgumentException();
            }
            return new e(bVar, aVar, this.asB, num.intValue(), this.asi.intValue(), this.asb.booleanValue(), this.ase, this.afW, (byte) 0);
        }

        public final a a(c cVar) {
            this.asB = cVar;
            return this;
        }

        public final a b(f fVar) {
            this.ase = fVar;
            return this;
        }

        public final a bH(String str) {
            this.afW = str;
            return this;
        }

        public final a bm(boolean z) {
            this.asb = Boolean.valueOf(z);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.download.a aVar) {
            this.aro = aVar;
            return this;
        }

        public final a cg(int i) {
            this.asi = Integer.valueOf(i);
            return this;
        }

        public final a ch(int i) {
            this.arn = Integer.valueOf(i);
            return this;
        }

        public final a d(com.kwad.framework.filedownloader.a.b bVar) {
            this.asx = bVar;
            return this;
        }
    }

    public /* synthetic */ e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str, byte b) {
        this(bVar, aVar, cVar, i, i2, z, fVar, str);
    }

    private void Aj() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwad.framework.filedownloader.f.f.i(this.arq - this.asz, jElapsedRealtime - this.asA)) {
            sync();
            this.asz = this.arq;
            this.asA = jElapsedRealtime;
        }
    }

    private void sync() {
        boolean z;
        long jUptimeMillis = SystemClock.uptimeMillis();
        try {
            this.asy.Ba();
            z = true;
        } catch (IOException e) {
            if (com.kwad.framework.filedownloader.f.d.atL) {
                com.kwad.framework.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
            }
            z = false;
        }
        if (z) {
            if (this.asw != null) {
                this.arw.a(this.arh, this.asg, this.arq);
            } else {
                this.ase.zS();
            }
            if (com.kwad.framework.filedownloader.f.d.atL) {
                com.kwad.framework.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.arh), Integer.valueOf(this.asg), Long.valueOf(this.arq), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
            }
        }
    }

    public final void pause() {
        this.ne = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x011c, code lost:
    
        if (r13 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x011e, code lost:
    
        sync();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0121, code lost:
    
        com.kwad.sdk.crash.utils.b.closeQuietly(r8);
        com.kwad.sdk.crash.utils.b.closeQuietly(r13);
        r6 = r16.arq - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012e, code lost:
    
        if (r2 == (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0132, code lost:
    
        if (r2 != r6) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0171, code lost:
    
        throw new com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", java.lang.Long.valueOf(r6), java.lang.Long.valueOf(r2), java.lang.Long.valueOf(r16.arp), java.lang.Long.valueOf(r16.arr), java.lang.Long.valueOf(r16.arq), java.lang.Long.valueOf(r4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0172, code lost:
    
        r16.ase.a(r16.asw, r16.arp, r16.arr);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x017d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws Throwable {
        com.kwad.framework.filedownloader.e.a aVarBV;
        boolean zZK;
        if (this.ne) {
            return;
        }
        long jB = com.kwad.framework.filedownloader.f.f.b(this.asg, this.asx);
        int i = 0;
        if (jB == 0) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.arh), Integer.valueOf(this.asg)));
        }
        long j = this.contentLength;
        if (j > 0 && jB != j) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", this.arr == 0 ? com.kwad.framework.filedownloader.f.f.c("range[%d-)", Long.valueOf(this.arq)) : com.kwad.framework.filedownloader.f.f.c("range[%d-%d)", Long.valueOf(this.arq), Long.valueOf(this.arr)), Long.valueOf(this.contentLength), Long.valueOf(jB), Integer.valueOf(this.arh), Integer.valueOf(this.asg)));
        }
        long j2 = this.arq;
        try {
            zZK = b.zG().zK();
            if (this.asw != null && !zZK) {
                throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
            }
            aVarBV = com.kwad.framework.filedownloader.f.f.bV(this.afW);
        } catch (Throwable th) {
            th = th;
            aVarBV = null;
        }
        try {
            this.asy = aVarBV;
            if (zZK) {
                aVarBV.seek(this.arq);
            }
            if (com.kwad.framework.filedownloader.f.d.atL) {
                com.kwad.framework.filedownloader.f.d.c(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.asg), Long.valueOf(this.arp), Long.valueOf(this.arr), Long.valueOf(this.arq));
            }
            InputStream inputStream = this.asx.getInputStream();
            byte[] bArr = new byte[4096];
            if (!this.ne) {
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    aVarBV.write(bArr, i, i2);
                    long j3 = i2;
                    this.arq += j3;
                    this.ase.onProgress(j3);
                    Aj();
                    if (this.ne) {
                        break;
                    }
                    if (this.arE && com.kwad.framework.filedownloader.f.f.Bk()) {
                        throw new FileDownloadNetworkPolicyException();
                    }
                    i = 0;
                }
            } else {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(aVarBV);
            }
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
            com.kwad.sdk.crash.utils.b.closeQuietly(aVarBV);
            throw th;
        }
    }

    private e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str) {
        this.asz = 0L;
        this.asA = 0L;
        this.ase = fVar;
        this.afW = str;
        this.asx = bVar;
        this.arE = z;
        this.asw = cVar;
        this.asg = i2;
        this.arh = i;
        this.arw = b.zG().zI();
        this.arp = aVar.arp;
        this.arr = aVar.arr;
        this.arq = aVar.arq;
        this.contentLength = aVar.contentLength;
    }
}
