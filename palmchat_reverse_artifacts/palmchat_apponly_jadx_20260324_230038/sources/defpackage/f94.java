package defpackage;

import defpackage.n54;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorThrowable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class f94<T> extends im0<T> {
    public static final r42 e = new a();
    public final n54<? extends T> b;
    public final AtomicReference<i<T>> c;
    public final r42<? extends h<T>> d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements r42 {
        @Override // defpackage.r42, java.util.concurrent.Callable
        public Object call() {
            return new l(16);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements r42<h<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f17481a;

        public b(int i) {
            this.f17481a = i;
        }

        @Override // defpackage.r42, java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h<T> call() {
            return new k(this.f17481a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements r42<h<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f17482a;
        public final /* synthetic */ long b;
        public final /* synthetic */ x25 c;

        public c(int i, long j, x25 x25Var) {
            this.f17482a = i;
            this.b = j;
            this.c = x25Var;
        }

        @Override // defpackage.r42, java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h<T> call() {
            return new j(this.f17482a, this.b, this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements n54.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f17483a;
        public final /* synthetic */ r42 b;

        public d(AtomicReference atomicReference, r42 r42Var) {
            this.f17483a = atomicReference;
            this.b = r42Var;
        }

        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(sm5<? super T> sm5Var) {
            i iVar;
            while (true) {
                iVar = (i) this.f17483a.get();
                if (iVar != null) {
                    break;
                }
                i iVar2 = new i((h) this.b.call());
                iVar2.c();
                if (g23.a(this.f17483a, iVar, iVar2)) {
                    iVar = iVar2;
                    break;
                }
            }
            f<T> fVar = new f<>(iVar, sm5Var);
            iVar.a(fVar);
            sm5Var.add(fVar);
            iVar.f17487a.b(fVar);
            sm5Var.setProducer(fVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f<T> extends AtomicLong implements kn4, zm5 {
        private static final long serialVersionUID = -4453897557930727610L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i<T> f17485a;
        public sm5<? super T> b;
        public Object c;
        public final AtomicLong d = new AtomicLong();
        public boolean e;
        public boolean f;

        public f(i<T> iVar, sm5<? super T> sm5Var) {
            this.f17485a = iVar;
            this.b = sm5Var;
        }

        public void a(long j) {
            long j2;
            long j3;
            do {
                j2 = this.d.get();
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!this.d.compareAndSet(j2, j3));
        }

        public <U> U b() {
            return (U) this.c;
        }

        public long c(long j) {
            long j2;
            long j3;
            if (j <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j3 = j2 - j;
                if (j3 < 0) {
                    throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + ")");
                }
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        @Override // defpackage.zm5
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // defpackage.kn4
        public void request(long j) {
            long j2;
            long j3;
            if (j < 0) {
                return;
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                if (j2 >= 0 && j == 0) {
                    return;
                }
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j2, j3));
            a(j);
            this.f17485a.e(this);
            this.f17485a.f17487a.b(this);
        }

        @Override // defpackage.zm5
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.f17485a.f(this);
            this.f17485a.e(this);
            this.b = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g extends AtomicReference<g> {
        private static final long serialVersionUID = 245354315435971818L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f17486a;
        public final long b;

        public g(Object obj, long j) {
            this.f17486a = obj;
            this.b = j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface h<T> {
        void a(T t);

        void b(f<T> fVar);

        void c(Throwable th);

        void complete();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class i<T> extends sm5<T> {
        public static final f[] p = new f[0];
        public static final f[] q = new f[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h<T> f17487a;
        public boolean b;
        public volatile boolean c;
        public volatile long f;
        public long g;
        public boolean i;
        public boolean j;
        public long k;
        public long l;
        public volatile kn4 m;
        public List<f<T>> n;
        public boolean o;
        public final m84<f<T>> d = new m84<>();
        public f<T>[] e = p;
        public final AtomicBoolean h = new AtomicBoolean();

        /* JADX INFO: compiled from: SearchBox */
        public class a implements b5 {
            public a() {
            }

            @Override // defpackage.b5
            public void call() {
                if (i.this.c) {
                    return;
                }
                synchronized (i.this.d) {
                    if (!i.this.c) {
                        i.this.d.g();
                        i.this.f++;
                        i.this.c = true;
                    }
                }
            }
        }

        public i(h<T> hVar) {
            this.f17487a = hVar;
            request(0L);
        }

        public boolean a(f<T> fVar) {
            fVar.getClass();
            if (this.c) {
                return false;
            }
            synchronized (this.d) {
                if (this.c) {
                    return false;
                }
                this.d.a(fVar);
                this.f++;
                return true;
            }
        }

        public f<T>[] b() {
            f<T>[] fVarArr;
            synchronized (this.d) {
                f<T>[] fVarArrH = this.d.h();
                int length = fVarArrH.length;
                fVarArr = new f[length];
                System.arraycopy(fVarArrH, 0, fVarArr, 0, length);
            }
            return fVarArr;
        }

        public void c() {
            add(cn5.a(new a()));
        }

        public void d(long j, long j2) {
            long j3 = this.l;
            kn4 kn4Var = this.m;
            long j4 = j - j2;
            if (j4 == 0) {
                if (j3 == 0 || kn4Var == null) {
                    return;
                }
                this.l = 0L;
                kn4Var.request(j3);
                return;
            }
            this.k = j;
            if (kn4Var == null) {
                long j5 = j3 + j4;
                if (j5 < 0) {
                    j5 = Long.MAX_VALUE;
                }
                this.l = j5;
                return;
            }
            if (j3 == 0) {
                kn4Var.request(j4);
            } else {
                this.l = 0L;
                kn4Var.request(j3 + j4);
            }
        }

        public void e(f<T> fVar) {
            long jMax;
            List<f<T>> list;
            boolean z;
            long jMax2;
            if (isUnsubscribed()) {
                return;
            }
            synchronized (this) {
                if (this.i) {
                    if (fVar != null) {
                        List arrayList = this.n;
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            this.n = arrayList;
                        }
                        arrayList.add(fVar);
                    } else {
                        this.o = true;
                    }
                    this.j = true;
                    return;
                }
                this.i = true;
                long j = this.k;
                if (fVar != null) {
                    jMax = Math.max(j, fVar.d.get());
                } else {
                    long jMax3 = j;
                    for (f<T> fVar2 : b()) {
                        if (fVar2 != null) {
                            jMax3 = Math.max(jMax3, fVar2.d.get());
                        }
                    }
                    jMax = jMax3;
                }
                d(jMax, j);
                while (!isUnsubscribed()) {
                    synchronized (this) {
                        if (!this.j) {
                            this.i = false;
                            return;
                        }
                        this.j = false;
                        list = this.n;
                        this.n = null;
                        z = this.o;
                        this.o = false;
                    }
                    long j2 = this.k;
                    if (list != null) {
                        Iterator<f<T>> it = list.iterator();
                        jMax2 = j2;
                        while (it.hasNext()) {
                            jMax2 = Math.max(jMax2, it.next().d.get());
                        }
                    } else {
                        jMax2 = j2;
                    }
                    if (z) {
                        for (f<T> fVar3 : b()) {
                            if (fVar3 != null) {
                                jMax2 = Math.max(jMax2, fVar3.d.get());
                            }
                        }
                    }
                    d(jMax2, j2);
                }
            }
        }

        public void f(f<T> fVar) {
            if (this.c) {
                return;
            }
            synchronized (this.d) {
                if (this.c) {
                    return;
                }
                this.d.e(fVar);
                if (this.d.b()) {
                    this.e = p;
                }
                this.f++;
            }
        }

        public void g() {
            f<T>[] fVarArr = this.e;
            if (this.g != this.f) {
                synchronized (this.d) {
                    fVarArr = this.e;
                    f<T>[] fVarArrH = this.d.h();
                    int length = fVarArrH.length;
                    if (fVarArr.length != length) {
                        fVarArr = new f[length];
                        this.e = fVarArr;
                    }
                    System.arraycopy(fVarArrH, 0, fVarArr, 0, length);
                    this.g = this.f;
                }
            }
            h<T> hVar = this.f17487a;
            for (f<T> fVar : fVarArr) {
                if (fVar != null) {
                    hVar.b(fVar);
                }
            }
        }

        @Override // defpackage.o54
        public void onCompleted() {
            if (this.b) {
                return;
            }
            this.b = true;
            try {
                this.f17487a.complete();
                g();
            } finally {
                unsubscribe();
            }
        }

        @Override // defpackage.o54
        public void onError(Throwable th) {
            if (this.b) {
                return;
            }
            this.b = true;
            try {
                this.f17487a.c(th);
                g();
            } finally {
                unsubscribe();
            }
        }

        @Override // defpackage.o54
        public void onNext(T t) {
            if (this.b) {
                return;
            }
            this.f17487a.a(t);
            g();
        }

        @Override // defpackage.sm5
        public void setProducer(kn4 kn4Var) {
            if (this.m != null) {
                throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
            }
            this.m = kn4Var;
            e(null);
            g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class j<T> extends e<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        public final x25 d;
        public final long e;
        public final int f;

        public j(int i, long j, x25 x25Var) {
            this.d = x25Var;
            this.f = i;
            this.e = j;
        }

        @Override // f94.e
        public Object e(Object obj) {
            return new ny5(this.d.b(), obj);
        }

        @Override // f94.e
        public g o() {
            g gVar;
            long jB = this.d.b() - this.e;
            g gVar2 = get();
            g gVar3 = gVar2.get();
            while (true) {
                g gVar4 = gVar3;
                gVar = gVar2;
                gVar2 = gVar4;
                if (gVar2 == null || ((ny5) gVar2.f17486a).a() > jB) {
                    break;
                }
                gVar3 = gVar2.get();
            }
            return gVar;
        }

        @Override // f94.e
        public Object p(Object obj) {
            return ((ny5) obj).b();
        }

        @Override // f94.e
        public void u() {
            g gVar;
            long jB = this.d.b() - this.e;
            g gVar2 = get();
            g gVar3 = gVar2.get();
            int i = 0;
            while (true) {
                g gVar4 = gVar3;
                gVar = gVar2;
                gVar2 = gVar4;
                if (gVar2 != null) {
                    int i2 = this.b;
                    if (i2 <= this.f) {
                        if (((ny5) gVar2.f17486a).a() > jB) {
                            break;
                        }
                        i++;
                        this.b--;
                        gVar3 = gVar2.get();
                    } else {
                        i++;
                        this.b = i2 - 1;
                        gVar3 = gVar2.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                t(gVar);
            }
        }

        @Override // f94.e
        public void v() {
            g gVar;
            long jB = this.d.b() - this.e;
            g gVar2 = get();
            g gVar3 = gVar2.get();
            int i = 0;
            while (true) {
                g gVar4 = gVar3;
                gVar = gVar2;
                gVar2 = gVar4;
                if (gVar2 == null || this.b <= 1 || ((ny5) gVar2.f17486a).a() > jB) {
                    break;
                }
                i++;
                this.b--;
                gVar3 = gVar2.get();
            }
            if (i != 0) {
                t(gVar);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class k<T> extends e<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        public final int d;

        public k(int i) {
            this.d = i;
        }

        @Override // f94.e
        public void u() {
            if (this.b > this.d) {
                s();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class l<T> extends ArrayList<Object> implements h<T> {
        private static final long serialVersionUID = 7063189396499112664L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile int f17489a;

        public l(int i) {
            super(i);
        }

        @Override // f94.h
        public void a(T t) {
            add(z24.g(t));
            this.f17489a++;
        }

        @Override // f94.h
        public void b(f<T> fVar) {
            synchronized (fVar) {
                if (fVar.e) {
                    fVar.f = true;
                    return;
                }
                fVar.e = true;
                while (!fVar.isUnsubscribed()) {
                    int i = this.f17489a;
                    Integer num = (Integer) fVar.b();
                    int iIntValue = num != null ? num.intValue() : 0;
                    sm5<? super T> sm5Var = fVar.b;
                    if (sm5Var == null) {
                        return;
                    }
                    long j = fVar.get();
                    long j2 = 0;
                    while (j2 != j && iIntValue < i) {
                        Object obj = get(iIntValue);
                        try {
                            if (z24.a(sm5Var, obj) || fVar.isUnsubscribed()) {
                                return;
                            }
                            iIntValue++;
                            j2++;
                        } catch (Throwable th) {
                            yn1.d(th);
                            fVar.unsubscribe();
                            if (z24.f(obj) || z24.e(obj)) {
                                return;
                            }
                            sm5Var.onError(OnErrorThrowable.addValueAsLastCause(th, z24.d(obj)));
                            return;
                        }
                    }
                    if (j2 != 0) {
                        fVar.c = Integer.valueOf(iIntValue);
                        if (j != Long.MAX_VALUE) {
                            fVar.c(j2);
                        }
                    }
                    synchronized (fVar) {
                        if (!fVar.f) {
                            fVar.e = false;
                            return;
                        }
                        fVar.f = false;
                    }
                }
            }
        }

        @Override // f94.h
        public void c(Throwable th) {
            add(z24.c(th));
            this.f17489a++;
        }

        @Override // f94.h
        public void complete() {
            add(z24.b());
            this.f17489a++;
        }
    }

    public f94(n54.a<T> aVar, n54<? extends T> n54Var, AtomicReference<i<T>> atomicReference, r42<? extends h<T>> r42Var) {
        super(aVar);
        this.b = n54Var;
        this.c = atomicReference;
        this.d = r42Var;
    }

    public static <T> im0<T> A(n54<? extends T> n54Var, int i2) {
        return i2 == Integer.MAX_VALUE ? z(n54Var) : D(n54Var, new b(i2));
    }

    public static <T> im0<T> B(n54<? extends T> n54Var, long j2, TimeUnit timeUnit, x25 x25Var) {
        return C(n54Var, j2, timeUnit, x25Var, Integer.MAX_VALUE);
    }

    public static <T> im0<T> C(n54<? extends T> n54Var, long j2, TimeUnit timeUnit, x25 x25Var, int i2) {
        return D(n54Var, new c(i2, timeUnit.toMillis(j2), x25Var));
    }

    public static <T> im0<T> D(n54<? extends T> n54Var, r42<? extends h<T>> r42Var) {
        AtomicReference atomicReference = new AtomicReference();
        return new f94(new d(atomicReference, r42Var), n54Var, atomicReference, r42Var);
    }

    public static <T> im0<T> z(n54<? extends T> n54Var) {
        return D(n54Var, e);
    }

    @Override // defpackage.im0
    public void y(c5<? super zm5> c5Var) {
        i<T> iVar;
        while (true) {
            iVar = this.c.get();
            if (iVar != null && !iVar.isUnsubscribed()) {
                break;
            }
            i<T> iVar2 = new i<>(this.d.call());
            iVar2.c();
            if (g23.a(this.c, iVar, iVar2)) {
                iVar = iVar2;
                break;
            }
        }
        boolean z = false;
        if (!iVar.h.get() && iVar.h.compareAndSet(false, true)) {
            z = true;
        }
        c5Var.call(iVar);
        if (z) {
            this.b.x(iVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e<T> extends AtomicReference<g> implements h<T> {
        private static final long serialVersionUID = 2346567790059478686L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g f17484a;
        public int b;
        public long c;

        public e() {
            g gVar = new g(null, 0L);
            this.f17484a = gVar;
            set(gVar);
        }

        @Override // f94.h
        public final void a(T t) {
            Object objE = e(z24.g(t));
            long j = this.c + 1;
            this.c = j;
            d(new g(objE, j));
            u();
        }

        @Override // f94.h
        public final void b(f<T> fVar) {
            sm5<? super T> sm5Var;
            g gVar;
            synchronized (fVar) {
                if (fVar.e) {
                    fVar.f = true;
                    return;
                }
                fVar.e = true;
                while (!fVar.isUnsubscribed()) {
                    g gVarO = (g) fVar.b();
                    if (gVarO == null) {
                        gVarO = o();
                        fVar.c = gVarO;
                        fVar.a(gVarO.b);
                    }
                    if (fVar.isUnsubscribed() || (sm5Var = fVar.b) == null) {
                        return;
                    }
                    long j = fVar.get();
                    long j2 = 0;
                    while (j2 != j && (gVar = gVarO.get()) != null) {
                        Object objP = p(gVar.f17486a);
                        try {
                            if (z24.a(sm5Var, objP)) {
                                fVar.c = null;
                                return;
                            }
                            j2++;
                            if (fVar.isUnsubscribed()) {
                                return;
                            } else {
                                gVarO = gVar;
                            }
                        } catch (Throwable th) {
                            fVar.c = null;
                            yn1.d(th);
                            fVar.unsubscribe();
                            if (z24.f(objP) || z24.e(objP)) {
                                return;
                            }
                            sm5Var.onError(OnErrorThrowable.addValueAsLastCause(th, z24.d(objP)));
                            return;
                        }
                    }
                    if (j2 != 0) {
                        fVar.c = gVarO;
                        if (j != Long.MAX_VALUE) {
                            fVar.c(j2);
                        }
                    }
                    synchronized (fVar) {
                        if (!fVar.f) {
                            fVar.e = false;
                            return;
                        }
                        fVar.f = false;
                    }
                }
            }
        }

        @Override // f94.h
        public final void c(Throwable th) {
            Object objE = e(z24.c(th));
            long j = this.c + 1;
            this.c = j;
            d(new g(objE, j));
            v();
        }

        @Override // f94.h
        public final void complete() {
            Object objE = e(z24.b());
            long j = this.c + 1;
            this.c = j;
            d(new g(objE, j));
            v();
        }

        public final void d(g gVar) {
            this.f17484a.set(gVar);
            this.f17484a = gVar;
            this.b++;
        }

        public g o() {
            return get();
        }

        public final void s() {
            g gVar = get().get();
            if (gVar == null) {
                throw new IllegalStateException("Empty list!");
            }
            this.b--;
            t(gVar);
        }

        public final void t(g gVar) {
            set(gVar);
        }

        public void u() {
            throw null;
        }

        public void v() {
        }

        public Object e(Object obj) {
            return obj;
        }

        public Object p(Object obj) {
            return obj;
        }
    }
}
