package rx.internal.schedulers;

import defpackage.b5;
import defpackage.bn5;
import defpackage.hk0;
import defpackage.kz4;
import defpackage.zm5;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, zm5 {
    private static final long serialVersionUID = -3962399486978279857L;
    final b5 action;
    final bn5 cancel;

    /* JADX INFO: compiled from: SearchBox */
    public final class a implements zm5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Future<?> f20605a;

        public a(Future<?> future) {
            this.f20605a = future;
        }

        @Override // defpackage.zm5
        public boolean isUnsubscribed() {
            return this.f20605a.isCancelled();
        }

        @Override // defpackage.zm5
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.f20605a.cancel(true);
            } else {
                this.f20605a.cancel(false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends AtomicBoolean implements zm5 {
        private static final long serialVersionUID = 247232374289553518L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledAction f20606a;
        public final bn5 b;

        public b(ScheduledAction scheduledAction, bn5 bn5Var) {
            this.f20606a = scheduledAction;
            this.b = bn5Var;
        }

        @Override // defpackage.zm5
        public boolean isUnsubscribed() {
            return this.f20606a.isUnsubscribed();
        }

        @Override // defpackage.zm5
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.b.b(this.f20606a);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends AtomicBoolean implements zm5 {
        private static final long serialVersionUID = 247232374289553518L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledAction f20607a;
        public final hk0 b;

        public c(ScheduledAction scheduledAction, hk0 hk0Var) {
            this.f20607a = scheduledAction;
            this.b = hk0Var;
        }

        @Override // defpackage.zm5
        public boolean isUnsubscribed() {
            return this.f20607a.isUnsubscribed();
        }

        @Override // defpackage.zm5
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.b.b(this.f20607a);
            }
        }
    }

    public ScheduledAction(b5 b5Var) {
        this.action = b5Var;
        this.cancel = new bn5();
    }

    public void add(zm5 zm5Var) {
        this.cancel.a(zm5Var);
    }

    public void addParent(hk0 hk0Var) {
        this.cancel.a(new c(this, hk0Var));
    }

    @Override // defpackage.zm5
    public boolean isUnsubscribed() {
        return this.cancel.isUnsubscribed();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                lazySet(Thread.currentThread());
                this.action.call();
            } finally {
                unsubscribe();
            }
        } catch (OnErrorNotImplementedException e) {
            signalError(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e));
        } catch (Throwable th) {
            signalError(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th));
        }
    }

    public void signalError(Throwable th) {
        kz4.g(th);
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }

    @Override // defpackage.zm5
    public void unsubscribe() {
        if (this.cancel.isUnsubscribed()) {
            return;
        }
        this.cancel.unsubscribe();
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(bn5 bn5Var) {
        this.cancel.a(new b(this, bn5Var));
    }

    public ScheduledAction(b5 b5Var, hk0 hk0Var) {
        this.action = b5Var;
        this.cancel = new bn5(new c(this, hk0Var));
    }

    public ScheduledAction(b5 b5Var, bn5 bn5Var) {
        this.action = b5Var;
        this.cancel = new bn5(new b(this, bn5Var));
    }
}
