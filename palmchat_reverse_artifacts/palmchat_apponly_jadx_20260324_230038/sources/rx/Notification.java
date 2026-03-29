package rx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class Notification<T> {
    public static final Notification<Void> d = new Notification<>(Kind.OnCompleted, null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Kind f20599a;
    public final Throwable b;
    public final T c;

    /* JADX INFO: compiled from: SearchBox */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public Notification(Kind kind, T t, Throwable th) {
        this.c = t;
        this.b = th;
        this.f20599a = kind;
    }

    public Kind a() {
        return this.f20599a;
    }

    public Throwable b() {
        return this.b;
    }

    public T c() {
        return this.c;
    }

    public boolean d() {
        return f() && this.b != null;
    }

    public boolean e() {
        return g() && this.c != null;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != Notification.class) {
            return false;
        }
        Notification notification = (Notification) obj;
        if (notification.a() != a()) {
            return false;
        }
        T t = this.c;
        T t2 = notification.c;
        if (t != t2 && (t == null || !t.equals(t2))) {
            return false;
        }
        Throwable th = this.b;
        Throwable th2 = notification.b;
        return th == th2 || (th != null && th.equals(th2));
    }

    public boolean f() {
        return a() == Kind.OnError;
    }

    public boolean g() {
        return a() == Kind.OnNext;
    }

    public int hashCode() {
        int iHashCode = a().hashCode();
        if (e()) {
            iHashCode = (iHashCode * 31) + c().hashCode();
        }
        return d() ? (iHashCode * 31) + b().hashCode() : iHashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(super.toString());
        sb.append(' ');
        sb.append(a());
        if (e()) {
            sb.append(' ');
            sb.append(c());
        }
        if (d()) {
            sb.append(' ');
            sb.append(b().getMessage());
        }
        sb.append(']');
        return sb.toString();
    }
}
