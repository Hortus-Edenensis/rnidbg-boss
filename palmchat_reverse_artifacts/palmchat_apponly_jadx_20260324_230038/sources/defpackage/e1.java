package defpackage;

import com.huawei.hms.ads.ex;
import com.kuaishou.weapon.p0.t;
import j$.util.Objects;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class e1<V> extends yt2 implements r33<V> {
    public static final boolean d;
    public static final s13 e;
    public static final b f;
    public static final Object g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f17191a;
    public volatile e b;
    public volatile l c;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(e1<?> e1Var, e eVar, e eVar2);

        public abstract boolean b(e1<?> e1Var, Object obj, Object obj2);

        public abstract boolean c(e1<?> e1Var, l lVar, l lVar2);

        public abstract e d(e1<?> e1Var, e eVar);

        public abstract l e(e1<?> e1Var, l lVar);

        public abstract void f(l lVar, l lVar2);

        public abstract void g(l lVar, Thread thread);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {
        public static final c c;
        public static final c d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f17192a;
        public final Throwable b;

        static {
            if (e1.d) {
                d = null;
                c = null;
            } else {
                d = new c(false, null);
                c = new c(true, null);
            }
        }

        public c(boolean z, Throwable th) {
            this.f17192a = z;
            this.b = th;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {
        public static final d b = new d(new a("Failure occurred while trying to finish a future."));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f17193a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends Throwable {
            public a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.f17193a = (Throwable) dm4.o(th);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<l, Thread> f17195a;
        public final AtomicReferenceFieldUpdater<l, l> b;
        public final AtomicReferenceFieldUpdater<? super e1<?>, l> c;
        public final AtomicReferenceFieldUpdater<? super e1<?>, e> d;
        public final AtomicReferenceFieldUpdater<? super e1<?>, Object> e;

        public f(AtomicReferenceFieldUpdater<l, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<l, l> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<? super e1<?>, l> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<? super e1<?>, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<? super e1<?>, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f17195a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // e1.b
        public boolean a(e1<?> e1Var, e eVar, e eVar2) {
            return p1.a(this.d, e1Var, eVar, eVar2);
        }

        @Override // e1.b
        public boolean b(e1<?> e1Var, Object obj, Object obj2) {
            return p1.a(this.e, e1Var, obj, obj2);
        }

        @Override // e1.b
        public boolean c(e1<?> e1Var, l lVar, l lVar2) {
            return p1.a(this.c, e1Var, lVar, lVar2);
        }

        @Override // e1.b
        public e d(e1<?> e1Var, e eVar) {
            return this.d.getAndSet(e1Var, eVar);
        }

        @Override // e1.b
        public l e(e1<?> e1Var, l lVar) {
            return this.c.getAndSet(e1Var, lVar);
        }

        @Override // e1.b
        public void f(l lVar, l lVar2) {
            this.b.lazySet(lVar, lVar2);
        }

        @Override // e1.b
        public void g(l lVar, Thread thread) {
            this.f17195a.lazySet(lVar, thread);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e1<V> f17196a;
        public final r33<? extends V> b;

        public g(e1<V> e1Var, r33<? extends V> r33Var) {
            this.f17196a = e1Var;
            this.b = r33Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17196a.f17191a != this) {
                return;
            }
            if (e1.f.b(this.f17196a, this, e1.u(this.b))) {
                e1.r(this.f17196a, false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class h extends b {
        public h() {
            super();
        }

        @Override // e1.b
        public boolean a(e1<?> e1Var, e eVar, e eVar2) {
            synchronized (e1Var) {
                if (e1Var.b != eVar) {
                    return false;
                }
                e1Var.b = eVar2;
                return true;
            }
        }

        @Override // e1.b
        public boolean b(e1<?> e1Var, Object obj, Object obj2) {
            synchronized (e1Var) {
                if (e1Var.f17191a != obj) {
                    return false;
                }
                e1Var.f17191a = obj2;
                return true;
            }
        }

        @Override // e1.b
        public boolean c(e1<?> e1Var, l lVar, l lVar2) {
            synchronized (e1Var) {
                if (e1Var.c != lVar) {
                    return false;
                }
                e1Var.c = lVar2;
                return true;
            }
        }

        @Override // e1.b
        public e d(e1<?> e1Var, e eVar) {
            e eVar2;
            synchronized (e1Var) {
                eVar2 = e1Var.b;
                if (eVar2 != eVar) {
                    e1Var.b = eVar;
                }
            }
            return eVar2;
        }

        @Override // e1.b
        public l e(e1<?> e1Var, l lVar) {
            l lVar2;
            synchronized (e1Var) {
                lVar2 = e1Var.c;
                if (lVar2 != lVar) {
                    e1Var.c = lVar;
                }
            }
            return lVar2;
        }

        @Override // e1.b
        public void f(l lVar, l lVar2) {
            lVar.b = lVar2;
        }

        @Override // e1.b
        public void g(l lVar, Thread thread) {
            lVar.f17198a = thread;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface i<V> extends r33<V> {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class j<V> extends e1<V> implements i<V> {
        @Override // defpackage.e1, defpackage.r33
        public final void addListener(Runnable runnable, Executor executor) {
            super.addListener(runnable, executor);
        }

        @Override // defpackage.e1, java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // defpackage.e1, java.util.concurrent.Future
        public final V get() throws ExecutionException, InterruptedException {
            return (V) super.get();
        }

        @Override // defpackage.e1, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // defpackage.e1, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // defpackage.e1, java.util.concurrent.Future
        public final V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) super.get(j, timeUnit);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class k extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Unsafe f17197a;
        public static final long b;
        public static final long c;
        public static final long d;
        public static final long e;
        public static final long f;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements PrivilegedExceptionAction<Unsafe> {
            @Override // java.security.PrivilegedExceptionAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unsafe run() throws Exception {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new a());
            }
            try {
                c = unsafe.objectFieldOffset(e1.class.getDeclaredField("c"));
                b = unsafe.objectFieldOffset(e1.class.getDeclaredField(t.l));
                d = unsafe.objectFieldOffset(e1.class.getDeclaredField("a"));
                e = unsafe.objectFieldOffset(l.class.getDeclaredField("a"));
                f = unsafe.objectFieldOffset(l.class.getDeclaredField(t.l));
                f17197a = unsafe;
            } catch (NoSuchFieldException e3) {
                throw new RuntimeException(e3);
            }
        }

        public k() {
            super();
        }

        @Override // e1.b
        public boolean a(e1<?> e1Var, e eVar, e eVar2) {
            return f1.a(f17197a, e1Var, b, eVar, eVar2);
        }

        @Override // e1.b
        public boolean b(e1<?> e1Var, Object obj, Object obj2) {
            return f1.a(f17197a, e1Var, d, obj, obj2);
        }

        @Override // e1.b
        public boolean c(e1<?> e1Var, l lVar, l lVar2) {
            return f1.a(f17197a, e1Var, c, lVar, lVar2);
        }

        @Override // e1.b
        public e d(e1<?> e1Var, e eVar) {
            e eVar2;
            do {
                eVar2 = e1Var.b;
                if (eVar == eVar2) {
                    return eVar2;
                }
            } while (!a(e1Var, eVar2, eVar));
            return eVar2;
        }

        @Override // e1.b
        public l e(e1<?> e1Var, l lVar) {
            l lVar2;
            do {
                lVar2 = e1Var.c;
                if (lVar == lVar2) {
                    return lVar2;
                }
            } while (!c(e1Var, lVar2, lVar));
            return lVar2;
        }

        @Override // e1.b
        public void f(l lVar, l lVar2) {
            f17197a.putObject(lVar, f, lVar2);
        }

        @Override // e1.b
        public void g(l lVar, Thread thread) {
            f17197a.putObject(lVar, e, thread);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class l {
        public static final l c = new l(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f17198a;
        public volatile l b;

        public l(boolean z) {
        }

        public void a(l lVar) {
            e1.f.f(this, lVar);
        }

        public void b() {
            Thread thread = this.f17198a;
            if (thread != null) {
                this.f17198a = null;
                LockSupport.unpark(thread);
            }
        }

        public l() {
            e1.f.g(this, Thread.currentThread());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r1v3, types: [e1$a] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v9 */
    static {
        boolean z;
        b hVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", ex.V));
        } catch (SecurityException unused) {
            z = false;
        }
        d = z;
        e = new s13(e1.class);
        ?? r1 = 0;
        r1 = 0;
        try {
            hVar = new k();
            e = null;
        } catch (Error | Exception e2) {
            e = e2;
            try {
                hVar = new f(AtomicReferenceFieldUpdater.newUpdater(l.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(l.class, l.class, t.l), AtomicReferenceFieldUpdater.newUpdater(e1.class, l.class, "c"), AtomicReferenceFieldUpdater.newUpdater(e1.class, e.class, t.l), AtomicReferenceFieldUpdater.newUpdater(e1.class, Object.class, "a"));
            } catch (Error | Exception e3) {
                hVar = new h();
                r1 = e3;
            }
        }
        f = hVar;
        if (r1 != 0) {
            s13 s13Var = e;
            Logger loggerA = s13Var.a();
            Level level = Level.SEVERE;
            loggerA.log(level, "UnsafeAtomicHelper is broken!", e);
            s13Var.a().log(level, "SafeAtomicHelper is broken!", r1);
        }
        g = new Object();
    }

    public static CancellationException p(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static void r(e1<?> e1Var, boolean z) {
        e eVar = null;
        while (true) {
            e1Var.y();
            if (z) {
                e1Var.w();
                z = false;
            }
            e1Var.m();
            e eVarQ = e1Var.q(eVar);
            while (eVarQ != null) {
                eVar = eVarQ.c;
                Runnable runnable = eVarQ.f17194a;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof g) {
                    g gVar = (g) runnable2;
                    e1Var = gVar.f17196a;
                    if (e1Var.f17191a == gVar) {
                        if (f.b(e1Var, gVar, u(gVar.b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = eVarQ.b;
                    Objects.requireNonNull(executor);
                    s(runnable2, executor);
                }
                eVarQ = eVar;
            }
            return;
        }
    }

    public static void s(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e2) {
            e.a().log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object u(r33<?> r33Var) {
        Throwable thA;
        if (r33Var instanceof i) {
            Object cVar = ((e1) r33Var).f17191a;
            if (cVar instanceof c) {
                c cVar2 = (c) cVar;
                if (cVar2.f17192a) {
                    cVar = cVar2.b != null ? new c(false, cVar2.b) : c.d;
                }
            }
            Objects.requireNonNull(cVar);
            return cVar;
        }
        if ((r33Var instanceof yt2) && (thA = zt2.a((yt2) r33Var)) != null) {
            return new d(thA);
        }
        boolean zIsCancelled = r33Var.isCancelled();
        if ((!d) && zIsCancelled) {
            c cVar3 = c.d;
            Objects.requireNonNull(cVar3);
            return cVar3;
        }
        try {
            Object objV = v(r33Var);
            if (!zIsCancelled) {
                return objV == null ? g : objV;
            }
            return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + r33Var));
        } catch (Error e2) {
            e = e2;
            return new d(e);
        } catch (CancellationException e3) {
            if (zIsCancelled) {
                return new c(false, e3);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + r33Var, e3));
        } catch (ExecutionException e4) {
            if (!zIsCancelled) {
                return new d(e4.getCause());
            }
            return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + r33Var, e4));
        } catch (Exception e5) {
            e = e5;
            return new d(e);
        }
    }

    public static <V> V v(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    public boolean A(V v) {
        if (v == null) {
            v = (V) g;
        }
        if (!f.b(this, null, v)) {
            return false;
        }
        r(this, false);
        return true;
    }

    public boolean B(Throwable th) {
        if (!f.b(this, null, new d((Throwable) dm4.o(th)))) {
            return false;
        }
        r(this, false);
        return true;
    }

    public boolean C(r33<? extends V> r33Var) {
        d dVar;
        dm4.o(r33Var);
        Object obj = this.f17191a;
        if (obj == null) {
            if (r33Var.isDone()) {
                if (!f.b(this, null, u(r33Var))) {
                    return false;
                }
                r(this, false);
                return true;
            }
            g gVar = new g(this, r33Var);
            if (f.b(this, null, gVar)) {
                try {
                    r33Var.addListener(gVar, kd1.INSTANCE);
                } catch (Throwable th) {
                    try {
                        dVar = new d(th);
                    } catch (Error | Exception unused) {
                        dVar = d.b;
                    }
                    f.b(this, gVar, dVar);
                }
                return true;
            }
            obj = this.f17191a;
        }
        if (obj instanceof c) {
            r33Var.cancel(((c) obj).f17192a);
        }
        return false;
    }

    public final boolean D() {
        Object obj = this.f17191a;
        return (obj instanceof c) && ((c) obj).f17192a;
    }

    @Override // defpackage.yt2
    public final Throwable a() {
        if (!(this instanceof i)) {
            return null;
        }
        Object obj = this.f17191a;
        if (obj instanceof d) {
            return ((d) obj).f17193a;
        }
        return null;
    }

    @Override // defpackage.r33
    public void addListener(Runnable runnable, Executor executor) {
        e eVar;
        dm4.p(runnable, "Runnable was null.");
        dm4.p(executor, "Executor was null.");
        if (!isDone() && (eVar = this.b) != e.d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.c = eVar;
                if (f.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.b;
                }
            } while (eVar != e.d);
        }
        s(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        c cVar;
        Object obj = this.f17191a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        if (d) {
            cVar = new c(z, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z ? c.c : c.d;
            Objects.requireNonNull(cVar);
        }
        boolean z2 = false;
        e1<V> e1Var = this;
        while (true) {
            if (f.b(e1Var, obj, cVar)) {
                r(e1Var, z);
                if (!(obj instanceof g)) {
                    return true;
                }
                r33<? extends V> r33Var = ((g) obj).b;
                if (!(r33Var instanceof i)) {
                    r33Var.cancel(z);
                    return true;
                }
                e1Var = (e1) r33Var;
                obj = e1Var.f17191a;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = e1Var.f17191a;
                if (!(obj instanceof g)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public V get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f17191a;
        if ((obj != null) && (!(obj instanceof g))) {
            return t(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            l lVar = this.c;
            if (lVar != l.c) {
                l lVar2 = new l();
                do {
                    lVar2.a(lVar);
                    if (f.c(this, lVar, lVar2)) {
                        do {
                            ka4.a(this, nanos);
                            if (Thread.interrupted()) {
                                z(lVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f17191a;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return t(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        z(lVar2);
                    } else {
                        lVar = this.c;
                    }
                } while (lVar != l.c);
            }
            Object obj3 = this.f17191a;
            Objects.requireNonNull(obj3);
            return t(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.f17191a;
            if ((obj4 != null) && (!(obj4 instanceof g))) {
                return t(obj4);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j3 = -nanos;
            long jConvert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f17191a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return (!(r0 instanceof g)) & (this.f17191a != null);
    }

    public final void k(StringBuilder sb) {
        try {
            Object objV = v(this);
            sb.append("SUCCESS, result=[");
            n(sb, objV);
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        } catch (Exception e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    public final void l(StringBuilder sb) {
        String strA;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.f17191a;
        if (obj instanceof g) {
            sb.append(", setFuture=[");
            o(sb, ((g) obj).b);
            sb.append("]");
        } else {
            try {
                strA = ol5.a(x());
            } catch (Exception | StackOverflowError e2) {
                strA = "Exception thrown from implementation: " + e2.getClass();
            }
            if (strA != null) {
                sb.append(", info=[");
                sb.append(strA);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            k(sb);
        }
    }

    public final void n(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            if (obj == this) {
                sb.append("this future");
                return;
            }
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    public final void o(StringBuilder sb, Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (Exception | StackOverflowError e2) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e2.getClass());
        }
    }

    public final e q(e eVar) {
        e eVar2 = eVar;
        e eVarD = f.d(this, e.d);
        while (eVarD != null) {
            e eVar3 = eVarD.c;
            eVarD.c = eVar2;
            eVar2 = eVarD;
            eVarD = eVar3;
        }
        return eVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V t(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw p("Task was cancelled.", ((c) obj).b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f17193a);
        }
        return obj == g ? (V) b44.b() : obj;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            k(sb);
        } else {
            l(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String x() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void y() {
        for (l lVarE = f.e(this, l.c); lVarE != null; lVarE = lVarE.b) {
            lVarE.b();
        }
    }

    public final void z(l lVar) {
        lVar.f17198a = null;
        while (true) {
            l lVar2 = this.c;
            if (lVar2 == l.c) {
                return;
            }
            l lVar3 = null;
            while (lVar2 != null) {
                l lVar4 = lVar2.b;
                if (lVar2.f17198a != null) {
                    lVar3 = lVar2;
                } else if (lVar3 != null) {
                    lVar3.b = lVar4;
                    if (lVar3.f17198a == null) {
                        break;
                    }
                } else if (!f.c(this, lVar2, lVar4)) {
                    break;
                }
                lVar2 = lVar4;
            }
            return;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e {
        public static final e d = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f17194a;
        public final Executor b;
        public e c;

        public e(Runnable runnable, Executor executor) {
            this.f17194a = runnable;
            this.b = executor;
        }

        public e() {
            this.f17194a = null;
            this.b = null;
        }
    }

    public void m() {
    }

    public void w() {
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f17191a;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return t(obj2);
            }
            l lVar = this.c;
            if (lVar != l.c) {
                l lVar2 = new l();
                do {
                    lVar2.a(lVar);
                    if (f.c(this, lVar, lVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f17191a;
                            } else {
                                z(lVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return t(obj);
                    }
                    lVar = this.c;
                } while (lVar != l.c);
            }
            Object obj3 = this.f17191a;
            Objects.requireNonNull(obj3);
            return t(obj3);
        }
        throw new InterruptedException();
    }
}
