package com.ss.android.socialbase.downloader.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class x {
    private Handler b;
    private u fx;
    private Object u = new Object();
    private Queue<nr> nr = new ConcurrentLinkedQueue();

    /* JADX INFO: compiled from: SearchBox */
    public class nr {
        public long nr;
        public Runnable u;

        public nr(Runnable runnable, long j) {
            this.u = runnable;
            this.nr = j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u extends HandlerThread {
        public u(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (x.this.u) {
                x.this.b = new Handler(looper);
            }
            while (!x.this.nr.isEmpty()) {
                nr nrVar = (nr) x.this.nr.poll();
                if (nrVar != null) {
                    x.this.b.postDelayed(nrVar.u, nrVar.nr);
                }
            }
        }
    }

    public x(String str) {
        this.fx = new u(str);
    }

    public void nr() {
        this.fx.quit();
    }

    public void u() {
        this.fx.start();
    }

    public void u(Runnable runnable) {
        u(runnable, 0L);
    }

    public void u(Runnable runnable, long j) {
        if (this.b == null) {
            synchronized (this.u) {
                if (this.b == null) {
                    this.nr.add(new nr(runnable, j));
                    return;
                }
            }
        }
        this.b.postDelayed(runnable, j);
    }
}
