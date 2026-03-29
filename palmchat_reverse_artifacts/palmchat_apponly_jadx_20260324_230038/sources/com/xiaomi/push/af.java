package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11403a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f94a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f95a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile b f96a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile boolean f97a;
    private final boolean b;

    public af() {
        this(false);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final LinkedBlockingQueue<b> f99a;

        public a() {
            super("PackageProcessor");
            this.f99a = new LinkedBlockingQueue<>();
        }

        public void a(b bVar) {
            try {
                this.f99a.add(bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j = af.this.f11403a > 0 ? af.this.f11403a : Long.MAX_VALUE;
            while (!af.this.f97a) {
                try {
                    b bVarPoll = this.f99a.poll(j, TimeUnit.SECONDS);
                    af.this.f96a = bVarPoll;
                    if (bVarPoll != null) {
                        a(0, bVarPoll);
                        bVarPoll.b();
                        a(1, bVarPoll);
                    } else if (af.this.f11403a > 0) {
                        af.this.a();
                    }
                } catch (InterruptedException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
        }

        private void a(int i, b bVar) {
            try {
                af.this.f94a.sendMessage(af.this.f94a.obtainMessage(i, bVar));
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }

    public af(boolean z) {
        this(z, 0);
    }

    public af(boolean z, int i) {
        this.f94a = null;
        this.f97a = false;
        this.f11403a = 0;
        this.f94a = new Handler(Looper.getMainLooper()) { // from class: com.xiaomi.push.af.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                b bVar = (b) message.obj;
                int i2 = message.what;
                if (i2 == 0) {
                    bVar.a();
                } else if (i2 == 1) {
                    bVar.mo289c();
                }
                super.handleMessage(message);
            }
        };
        this.b = z;
        this.f11403a = i;
    }

    public synchronized void a(b bVar) {
        if (this.f95a == null) {
            a aVar = new a();
            this.f95a = aVar;
            aVar.setDaemon(this.b);
            this.f97a = false;
            this.f95a.start();
        }
        this.f95a.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f95a = null;
        this.f97a = true;
    }

    public void a(final b bVar, long j) {
        this.f94a.postDelayed(new Runnable() { // from class: com.xiaomi.push.af.2
            @Override // java.lang.Runnable
            public void run() {
                af.this.a(bVar);
            }
        }, j);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b {
        public abstract void b();

        public void a() {
        }

        /* JADX INFO: renamed from: c */
        public void mo289c() {
        }
    }
}
