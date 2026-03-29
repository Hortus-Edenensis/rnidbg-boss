package defpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class n57 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h57 f19443a;
    public ExecutorService b;
    public boolean c = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ThreadFactory {
        public a(n57 n57Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "EventTaskManagerThread");
        }
    }

    public n57() {
        try {
            this.f19443a = h57.a();
            this.b = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new a(this));
        } catch (Exception e) {
            g57.a(e);
        }
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        Runnable runnablePoll;
        while (true) {
            try {
                Runnable runnableTake = null;
                if (this.c) {
                    break;
                }
                h57 h57Var = this.f19443a;
                h57Var.getClass();
                try {
                    runnableTake = h57Var.f17875a.take();
                } catch (Exception e) {
                    g57.a(e);
                }
                this.b.execute(runnableTake);
            } catch (Exception e2) {
                g57.a(e2);
                return;
            }
            g57.a(e2);
            return;
        }
        while (true) {
            h57 h57Var2 = this.f19443a;
            h57Var2.getClass();
            try {
                runnablePoll = h57Var2.f17875a.poll();
            } catch (Exception e3) {
                g57.a(e3);
                runnablePoll = null;
            }
            if (runnablePoll == null) {
                this.b.shutdown();
                return;
            }
            this.b.execute(runnablePoll);
        }
    }
}
