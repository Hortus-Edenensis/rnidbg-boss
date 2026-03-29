package rx.internal.operators;

import defpackage.kn4;
import defpackage.lh5;
import defpackage.n54;
import defpackage.o54;
import defpackage.s46;
import defpackage.sh5;
import defpackage.sm5;
import defpackage.so;
import defpackage.zm5;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements n54.a<T>, o54<T>, zm5 {
    static final b<?>[] EMPTY = new b[0];
    static final b<?>[] TERMINATED = new b[0];
    private static final long serialVersionUID = -3741892510772238743L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final a<T> parent;
    final int prefetch;
    volatile kn4 producer;
    final Queue<T> queue;
    volatile b<T>[] subscribers;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a<T> extends sm5<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OnSubscribePublishMulticast<T> f20603a;

        public a(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.f20603a = onSubscribePublishMulticast;
        }

        @Override // defpackage.o54
        public void onCompleted() {
            this.f20603a.onCompleted();
        }

        @Override // defpackage.o54
        public void onError(Throwable th) {
            this.f20603a.onError(th);
        }

        @Override // defpackage.o54
        public void onNext(T t) {
            this.f20603a.onNext(t);
        }

        @Override // defpackage.sm5
        public void setProducer(kn4 kn4Var) {
            this.f20603a.setProducer(kn4Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b<T> extends AtomicLong implements kn4, zm5 {
        private static final long serialVersionUID = 960704844171597367L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final sm5<? super T> f20604a;
        public final OnSubscribePublishMulticast<T> b;
        public final AtomicBoolean c = new AtomicBoolean();

        public b(sm5<? super T> sm5Var, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.f20604a = sm5Var;
            this.b = onSubscribePublishMulticast;
        }

        @Override // defpackage.zm5
        public boolean isUnsubscribed() {
            return this.c.get();
        }

        @Override // defpackage.kn4
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
            if (j != 0) {
                so.b(this, j);
                this.b.drain();
            }
        }

        @Override // defpackage.zm5
        public void unsubscribe() {
            if (this.c.compareAndSet(false, true)) {
                this.b.remove(this);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OnSubscribePublishMulticast(int i, boolean z) {
        if (i <= 0) {
            throw new IllegalArgumentException("prefetch > 0 required but it was " + i);
        }
        this.prefetch = i;
        this.delayError = z;
        if (s46.b()) {
            this.queue = new lh5(i);
        } else {
            this.queue = new sh5(i);
        }
        this.subscribers = (b<T>[]) EMPTY;
        this.parent = new a<>(this);
    }

    public boolean add(b<T> bVar) {
        b<T>[] bVarArr = this.subscribers;
        b<?>[] bVarArr2 = TERMINATED;
        if (bVarArr == bVarArr2) {
            return false;
        }
        synchronized (this) {
            b<T>[] bVarArr3 = this.subscribers;
            if (bVarArr3 == bVarArr2) {
                return false;
            }
            int length = bVarArr3.length;
            b<T>[] bVarArr4 = new b[length + 1];
            System.arraycopy(bVarArr3, 0, bVarArr4, 0, length);
            bVarArr4[length] = bVar;
            this.subscribers = bVarArr4;
            return true;
        }
    }

    public boolean checkTerminated(boolean z, boolean z2) {
        int i = 0;
        if (z) {
            if (!this.delayError) {
                Throwable th = this.error;
                if (th != null) {
                    this.queue.clear();
                    b<T>[] bVarArrTerminate = terminate();
                    int length = bVarArrTerminate.length;
                    while (i < length) {
                        bVarArrTerminate[i].f20604a.onError(th);
                        i++;
                    }
                    return true;
                }
                if (z2) {
                    b<T>[] bVarArrTerminate2 = terminate();
                    int length2 = bVarArrTerminate2.length;
                    while (i < length2) {
                        bVarArrTerminate2[i].f20604a.onCompleted();
                        i++;
                    }
                    return true;
                }
            } else if (z2) {
                b<T>[] bVarArrTerminate3 = terminate();
                Throwable th2 = this.error;
                if (th2 != null) {
                    int length3 = bVarArrTerminate3.length;
                    while (i < length3) {
                        bVarArrTerminate3[i].f20604a.onError(th2);
                        i++;
                    }
                } else {
                    int length4 = bVarArrTerminate3.length;
                    while (i < length4) {
                        bVarArrTerminate3[i].f20604a.onCompleted();
                        i++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void drain() {
        if (getAndIncrement() != 0) {
            return;
        }
        Queue<T> queue = this.queue;
        int iAddAndGet = 0;
        do {
            b<T>[] bVarArr = this.subscribers;
            int length = bVarArr.length;
            long jMin = Long.MAX_VALUE;
            for (b<T> bVar : bVarArr) {
                jMin = Math.min(jMin, bVar.get());
            }
            if (length != 0) {
                long j = 0;
                while (j != jMin) {
                    boolean z = this.done;
                    T tPoll = queue.poll();
                    boolean z2 = tPoll == null;
                    if (checkTerminated(z, z2)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    for (b<T> bVar2 : bVarArr) {
                        bVar2.f20604a.onNext(tPoll);
                    }
                    j++;
                }
                if (j == jMin && checkTerminated(this.done, queue.isEmpty())) {
                    return;
                }
                if (j != 0) {
                    kn4 kn4Var = this.producer;
                    if (kn4Var != null) {
                        kn4Var.request(j);
                    }
                    for (b<T> bVar3 : bVarArr) {
                        so.c(bVar3, j);
                    }
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // defpackage.zm5
    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    @Override // defpackage.o54
    public void onCompleted() {
        this.done = true;
        drain();
    }

    @Override // defpackage.o54
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // defpackage.o54
    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        drain();
    }

    public void remove(b<T> bVar) {
        b<?>[] bVarArr;
        b[] bVarArr2;
        b<T>[] bVarArr3 = this.subscribers;
        b<?>[] bVarArr4 = TERMINATED;
        if (bVarArr3 == bVarArr4 || bVarArr3 == (bVarArr = EMPTY)) {
            return;
        }
        synchronized (this) {
            b<T>[] bVarArr5 = this.subscribers;
            if (bVarArr5 != bVarArr4 && bVarArr5 != bVarArr) {
                int length = bVarArr5.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (bVarArr5[i] == bVar) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = EMPTY;
                } else {
                    b[] bVarArr6 = new b[length - 1];
                    System.arraycopy(bVarArr5, 0, bVarArr6, 0, i);
                    System.arraycopy(bVarArr5, i + 1, bVarArr6, i, (length - i) - 1);
                    bVarArr2 = bVarArr6;
                }
                this.subscribers = bVarArr2;
            }
        }
    }

    public void setProducer(kn4 kn4Var) {
        this.producer = kn4Var;
        kn4Var.request(this.prefetch);
    }

    public sm5<T> subscriber() {
        return this.parent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b<T>[] terminate() {
        b<T>[] bVarArr = this.subscribers;
        b<T>[] bVarArr2 = (b<T>[]) TERMINATED;
        if (bVarArr != bVarArr2) {
            synchronized (this) {
                bVarArr = this.subscribers;
                if (bVarArr != bVarArr2) {
                    this.subscribers = bVarArr2;
                }
            }
        }
        return bVarArr;
    }

    @Override // defpackage.zm5
    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    @Override // defpackage.c5
    public void call(sm5<? super T> sm5Var) {
        b<T> bVar = new b<>(sm5Var, this);
        sm5Var.add(bVar);
        sm5Var.setProducer(bVar);
        if (add(bVar)) {
            if (bVar.isUnsubscribed()) {
                remove(bVar);
                return;
            } else {
                drain();
                return;
            }
        }
        Throwable th = this.error;
        if (th != null) {
            sm5Var.onError(th);
        } else {
            sm5Var.onCompleted();
        }
    }
}
