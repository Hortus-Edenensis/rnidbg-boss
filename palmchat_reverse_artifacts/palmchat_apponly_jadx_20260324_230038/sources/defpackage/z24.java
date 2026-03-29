package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class z24 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f22325a = new a();
    public static final Object b = new b();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Serializable {
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Serializable {
        private static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements Serializable {
        private static final long serialVersionUID = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f22326a;

        public c(Throwable th) {
            this.f22326a = th;
        }

        public String toString() {
            return "Notification=>Error:" + this.f22326a;
        }
    }

    public static <T> boolean a(o54<? super T> o54Var, Object obj) {
        if (obj == f22325a) {
            o54Var.onCompleted();
            return true;
        }
        if (obj == b) {
            o54Var.onNext(null);
            return false;
        }
        if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
        if (obj.getClass() == c.class) {
            o54Var.onError(((c) obj).f22326a);
            return true;
        }
        o54Var.onNext(obj);
        return false;
    }

    public static Object b() {
        return f22325a;
    }

    public static Object c(Throwable th) {
        return new c(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T d(Object obj) {
        if (obj == b) {
            return null;
        }
        return obj;
    }

    public static boolean e(Object obj) {
        return obj == f22325a;
    }

    public static boolean f(Object obj) {
        return obj instanceof c;
    }

    public static <T> Object g(T t) {
        return t == null ? b : t;
    }
}
