package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import defpackage.x25;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class p73 extends x25 {
    public final Handler b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends x25.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f19953a;
        public final hz4 b = gz4.a().b();
        public volatile boolean c;

        public a(Handler handler) {
            this.f19953a = handler;
        }

        @Override // x25.a
        public zm5 a(b5 b5Var) {
            return b(b5Var, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // x25.a
        public zm5 b(b5 b5Var, long j, TimeUnit timeUnit) {
            if (this.c) {
                return cn5.c();
            }
            b bVar = new b(this.b.c(b5Var), this.f19953a);
            Message messageObtain = Message.obtain(this.f19953a, bVar);
            messageObtain.obj = this;
            this.f19953a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
            if (!this.c) {
                return bVar;
            }
            this.f19953a.removeCallbacks(bVar);
            return cn5.c();
        }

        @Override // defpackage.zm5
        public boolean isUnsubscribed() {
            return this.c;
        }

        @Override // defpackage.zm5
        public void unsubscribe() {
            this.c = true;
            this.f19953a.removeCallbacksAndMessages(this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements Runnable, zm5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b5 f19954a;
        public final Handler b;
        public volatile boolean c;

        public b(b5 b5Var, Handler handler) {
            this.f19954a = b5Var;
            this.b = handler;
        }

        @Override // defpackage.zm5
        public boolean isUnsubscribed() {
            return this.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f19954a.call();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = th instanceof OnErrorNotImplementedException ? new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th) : new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                nz4.c().b().a(illegalStateException);
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, illegalStateException);
            }
        }

        @Override // defpackage.zm5
        public void unsubscribe() {
            this.c = true;
            this.b.removeCallbacks(this);
        }
    }

    public p73(Looper looper) {
        this.b = new Handler(looper);
    }

    @Override // defpackage.x25
    public x25.a a() {
        return new a(this.b);
    }
}
