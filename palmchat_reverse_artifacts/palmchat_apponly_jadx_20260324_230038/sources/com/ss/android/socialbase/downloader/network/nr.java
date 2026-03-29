package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr {
    private static volatile nr n = null;
    private static final String nr = "nr";
    public static volatile boolean u = false;
    private static long x = -1;
    private long iz;
    private final t fx = t.u();
    private final AtomicInteger b = new AtomicInteger();
    private final u pn = new u(com.ss.android.socialbase.downloader.a.pn.u());

    /* JADX INFO: compiled from: SearchBox */
    public class u extends Handler {
        public u(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            nr.this.iz();
            sendEmptyMessageDelayed(1, 1000L);
        }

        public void nr() {
            removeMessages(1);
        }

        public void u() {
            sendEmptyMessage(1);
        }
    }

    private nr() {
    }

    public static long b() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void pn() {
        u = com.ss.android.socialbase.downloader.jk.iz.nr(com.ss.android.socialbase.downloader.downloader.fx.oa());
    }

    public static nr u() {
        if (n == null) {
            synchronized (nr.class) {
                if (n == null) {
                    n = new nr();
                }
            }
        }
        return n;
    }

    public void fx() {
        try {
            com.ss.android.socialbase.downloader.fx.u.fx(nr, "stopSampling: mSamplingCounter = " + this.b);
            if (this.b.decrementAndGet() == 0) {
                this.pn.nr();
                x();
            }
        } catch (Throwable unused) {
        }
    }

    public void iz() {
        try {
            pn();
            long jB = u ? b() : TrafficStats.getMobileRxBytes();
            long j = x;
            long j2 = jB - j;
            if (j >= 0) {
                synchronized (this) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    this.fx.u(j2, jUptimeMillis - this.iz);
                    this.iz = jUptimeMillis;
                }
            }
            x = jB;
        } catch (Exception unused) {
        }
    }

    public void nr() {
        try {
            com.ss.android.socialbase.downloader.fx.u.fx(nr, "startSampling: mSamplingCounter = " + this.b);
            if (this.b.getAndIncrement() == 0) {
                this.pn.u();
                this.iz = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void x() {
        iz();
        x = -1L;
    }
}
