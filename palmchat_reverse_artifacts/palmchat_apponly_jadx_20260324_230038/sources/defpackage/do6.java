package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class do6<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f17106a;
    public final Exception b;
    public final boolean c;

    public do6(Exception exc) {
        this.f17106a = null;
        this.b = exc;
        this.c = false;
    }

    public static <T> do6<T> a(Exception exc) {
        return new do6<>(exc);
    }

    public static <T> do6<T> e(T t) {
        return new do6<>(t);
    }

    public Exception b() {
        return this.b;
    }

    public T c() {
        return this.f17106a;
    }

    public boolean d() {
        return this.c;
    }

    public do6(T t) {
        this.f17106a = t;
        this.b = null;
        this.c = true;
    }
}
