package defpackage;

import l54.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class l54<T extends a> {
    public static int g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18908a;
    public int b;
    public Object[] c;
    public int d;
    public T e;
    public float f;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a {
        public static int b = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18909a = b;

        public abstract a a();
    }

    public l54(int i, T t) {
        if (i <= 0) {
            throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
        }
        this.b = i;
        this.c = new Object[i];
        this.d = 0;
        this.e = t;
        this.f = 1.0f;
        d();
    }

    /* JADX WARN: In static synchronized method top region not synchronized by class const: (wrap:java.lang.Class:0x0000: CONST_CLASS  A[WRAPPED] (LINE:1) l54.class) */
    public static synchronized l54 a(int i, a aVar) {
        l54 l54Var;
        synchronized (l54.class) {
            l54Var = new l54(i, aVar);
            int i2 = g;
            l54Var.f18908a = i2;
            g = i2 + 1;
        }
        return l54Var;
    }

    public synchronized T b() {
        T t;
        if (this.d == -1 && this.f > 0.0f) {
            d();
        }
        Object[] objArr = this.c;
        int i = this.d;
        t = (T) objArr[i];
        t.f18909a = a.b;
        this.d = i - 1;
        return t;
    }

    public synchronized void c(T t) {
        int i = t.f18909a;
        if (i != a.b) {
            if (i == this.f18908a) {
                throw new IllegalArgumentException("The object passed is already stored in this pool!");
            }
            throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t.f18909a + ".  Object cannot belong to two different pool instances simultaneously!");
        }
        int i2 = this.d + 1;
        this.d = i2;
        if (i2 >= this.c.length) {
            f();
        }
        t.f18909a = this.f18908a;
        this.c[this.d] = t;
    }

    public final void d() {
        e(this.f);
    }

    public final void e(float f) {
        int i = this.b;
        int i2 = (int) (i * f);
        if (i2 < 1) {
            i = 1;
        } else if (i2 <= i) {
            i = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            this.c[i3] = this.e.a();
        }
        this.d = i - 1;
    }

    public final void f() {
        int i = this.b;
        int i2 = i * 2;
        this.b = i2;
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i; i3++) {
            objArr[i3] = this.c[i3];
        }
        this.c = objArr;
    }

    public void g(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.f = f;
    }
}
