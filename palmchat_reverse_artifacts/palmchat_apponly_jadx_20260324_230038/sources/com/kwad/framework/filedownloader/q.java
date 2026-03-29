package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class q {
    private final b aqw = new b();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private static final q aqx = new q();

        static {
            com.kwad.framework.filedownloader.message.e.Ax().a(new aa());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        private ThreadPoolExecutor aqy;
        private LinkedBlockingQueue<Runnable> aqz;

        public b() {
            init();
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.aqz = linkedBlockingQueue;
            this.aqy = com.kwad.framework.filedownloader.f.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public final void b(x.b bVar) {
            this.aqz.remove(bVar);
        }

        public final void c(x.b bVar) {
            this.aqy.execute(new c(bVar));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements Runnable {
        private final x.b aqA;
        private boolean aqB = false;

        public c(x.b bVar) {
            this.aqA = bVar;
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) || obj == this.aqA;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.aqB) {
                return;
            }
            this.aqA.start();
        }
    }

    public static q zk() {
        return a.aqx;
    }

    public final synchronized void a(x.b bVar) {
        this.aqw.c(bVar);
    }

    public final synchronized void b(x.b bVar) {
        this.aqw.b(bVar);
    }
}
