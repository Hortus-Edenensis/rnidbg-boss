package defpackage;

import java.util.concurrent.ThreadFactory;
import rx.internal.util.RxThreadFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class oz4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final oz4 f19906a = new oz4();

    public static x25 a() {
        return b(new RxThreadFactory("RxComputationScheduler-"));
    }

    public static x25 b(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new nn1(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static x25 c() {
        return d(new RxThreadFactory("RxIoScheduler-"));
    }

    public static x25 d(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new rw(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static x25 e() {
        return f(new RxThreadFactory("RxNewThreadScheduler-"));
    }

    public static x25 f(ThreadFactory threadFactory) {
        if (threadFactory != null) {
            return new wx3(threadFactory);
        }
        throw new NullPointerException("threadFactory == null");
    }

    public static oz4 h() {
        return f19906a;
    }

    public x25 g() {
        return null;
    }

    public x25 i() {
        return null;
    }

    public x25 j() {
        return null;
    }

    @Deprecated
    public b5 k(b5 b5Var) {
        return b5Var;
    }
}
