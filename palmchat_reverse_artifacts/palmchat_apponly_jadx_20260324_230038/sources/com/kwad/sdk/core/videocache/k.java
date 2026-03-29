package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ax;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
class k {
    private final m aQi;
    private final com.kwad.sdk.core.videocache.a aQj;
    private volatile Thread aQn;
    private volatile boolean nf;
    private final Object aQk = new Object();
    private final Object aQl = new Object();
    private volatile int aQo = -1;
    private final AtomicInteger aQm = new AtomicInteger();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.Ms();
        }

        public /* synthetic */ a(k kVar, byte b) {
            this();
        }
    }

    public k(m mVar, com.kwad.sdk.core.videocache.a aVar) {
        this.aQi = (m) ax.checkNotNull(mVar);
        this.aQj = (com.kwad.sdk.core.videocache.a) ax.checkNotNull(aVar);
    }

    private void Mp() throws ProxyCacheException {
        int i = this.aQm.get();
        if (i <= 0) {
            return;
        }
        this.aQm.set(0);
        throw new ProxyCacheException("Error reading source " + i + " times");
    }

    private synchronized void Mq() {
        byte b = 0;
        boolean z = (this.aQn == null || this.aQn.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.nf && !this.aQj.isCompleted() && !z) {
            this.aQn = new Thread(new a(this, b), "Source reader for " + this.aQi);
            this.aQn.start();
        }
    }

    private void Mr() {
        synchronized (this.aQk) {
            try {
                try {
                    this.aQk.wait(1000L);
                } catch (InterruptedException e) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        r2 = r2 + ((long) r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Ms() {
        long length = -1;
        long jMd = 0;
        try {
            jMd = this.aQj.Md();
            this.aQi.aK(jMd);
            length = this.aQi.length();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = this.aQi.read(bArr);
                if (i == -1) {
                    tryComplete();
                    Mt();
                    break;
                } else {
                    synchronized (this.aQl) {
                        if (isStopped()) {
                            break;
                        } else {
                            this.aQj.d(bArr, i);
                        }
                    }
                }
                j(jMd, length);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private void Mt() {
        this.aQo = 100;
        ee(this.aQo);
    }

    private void Mu() {
        try {
            this.aQi.close();
        } catch (ProxyCacheException e) {
            onError(new ProxyCacheException("Error closing source " + this.aQi, e));
        }
    }

    private boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.nf;
    }

    private void j(long j, long j2) {
        k(j, j2);
        synchronized (this.aQk) {
            this.aQk.notifyAll();
        }
    }

    private void k(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this.aQo;
        if ((j2 >= 0) && z) {
            ee(i);
        }
        this.aQo = i;
    }

    private static void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            com.kwad.sdk.core.d.c.d("ProxyCache", "ProxyCache is interrupted");
        } else {
            com.kwad.sdk.core.d.c.e("ProxyCache", "ProxyCache error");
        }
    }

    private void tryComplete() {
        synchronized (this.aQl) {
            if (!isStopped() && this.aQj.Md() == this.aQi.length()) {
                this.aQj.complete();
            }
        }
    }

    public final void shutdown() {
        synchronized (this.aQl) {
            com.kwad.sdk.core.d.c.d("ProxyCache", "Shutdown proxy for " + this.aQi);
            try {
                this.nf = true;
                if (this.aQn != null) {
                    this.aQn.interrupt();
                }
                this.aQj.close();
            } catch (ProxyCacheException e) {
                onError(e);
            }
        }
    }

    public final int a(byte[] bArr, long j, int i) throws ProxyCacheException {
        l.b(bArr, j, 1024);
        while (!this.aQj.isCompleted() && this.aQj.Md() < 1024 + j && !this.nf) {
            Mq();
            Mr();
            Mp();
        }
        int iA = this.aQj.a(bArr, j, 1024);
        if (this.aQj.isCompleted() && this.aQo != 100) {
            this.aQo = 100;
            ee(100);
        }
        return iA;
    }

    public void ee(int i) {
    }
}
