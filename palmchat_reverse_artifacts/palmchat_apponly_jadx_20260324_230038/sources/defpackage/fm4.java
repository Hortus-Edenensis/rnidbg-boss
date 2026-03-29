package defpackage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class fm4 {

    /* JADX INFO: compiled from: SearchBox */
    public static class b<T> implements em4<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<? extends em4<? super T>> f17557a;

        @Override // defpackage.em4
        public boolean apply(T t) {
            for (int i = 0; i < this.f17557a.size(); i++) {
                if (!this.f17557a.get(i).apply(t)) {
                    return false;
                }
            }
            return true;
        }

        @Override // defpackage.em4
        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f17557a.equals(((b) obj).f17557a);
            }
            return false;
        }

        public int hashCode() {
            return this.f17557a.hashCode() + 306654252;
        }

        public String toString() {
            return fm4.j("and", this.f17557a);
        }

        public b(List<? extends em4<? super T>> list) {
            this.f17557a = list;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c<A, B> implements em4<A>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final em4<B> f17558a;
        public final u42<A, ? extends B> b;

        @Override // defpackage.em4
        public boolean apply(A a2) {
            return this.f17558a.apply(this.b.apply(a2));
        }

        @Override // defpackage.em4
        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.b.equals(cVar.b) && this.f17558a.equals(cVar.f17558a);
        }

        public int hashCode() {
            return this.b.hashCode() ^ this.f17558a.hashCode();
        }

        public String toString() {
            return this.f17558a + "(" + this.b + ")";
        }

        public c(em4<B> em4Var, u42<A, ? extends B> u42Var) {
            this.f17558a = (em4) dm4.o(em4Var);
            this.b = (u42) dm4.o(u42Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d<T> implements em4<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection<?> f17559a;

        @Override // defpackage.em4
        public boolean apply(T t) {
            try {
                return this.f17559a.contains(t);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // defpackage.em4
        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f17559a.equals(((d) obj).f17559a);
            }
            return false;
        }

        public int hashCode() {
            return this.f17559a.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.f17559a + ")";
        }

        public d(Collection<?> collection) {
            this.f17559a = (Collection) dm4.o(collection);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements em4<Object>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f17560a;

        @Override // defpackage.em4
        public boolean apply(Object obj) {
            return this.f17560a.equals(obj);
        }

        @Override // defpackage.em4
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                return this.f17560a.equals(((e) obj).f17560a);
            }
            return false;
        }

        public int hashCode() {
            return this.f17560a.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.f17560a + ")";
        }

        public e(Object obj) {
            this.f17560a = obj;
        }

        public <T> em4<T> b() {
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f<T> implements em4<T>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final em4<T> f17561a;

        public f(em4<T> em4Var) {
            this.f17561a = (em4) dm4.o(em4Var);
        }

        @Override // defpackage.em4
        public boolean apply(T t) {
            return !this.f17561a.apply(t);
        }

        @Override // defpackage.em4
        public boolean equals(Object obj) {
            if (obj instanceof f) {
                return this.f17561a.equals(((f) obj).f17561a);
            }
            return false;
        }

        public int hashCode() {
            return ~this.f17561a.hashCode();
        }

        public String toString() {
            return "Predicates.not(" + this.f17561a + ")";
        }
    }

    public static <T> em4<T> b() {
        return g.ALWAYS_TRUE.withNarrowedType();
    }

    public static <T> em4<T> c(em4<? super T> em4Var, em4<? super T> em4Var2) {
        return new b(d((em4) dm4.o(em4Var), (em4) dm4.o(em4Var2)));
    }

    public static <T> List<em4<? super T>> d(em4<? super T> em4Var, em4<? super T> em4Var2) {
        return Arrays.asList(em4Var, em4Var2);
    }

    public static <A, B> em4<A> e(em4<B> em4Var, u42<A, ? extends B> u42Var) {
        return new c(em4Var, u42Var);
    }

    public static <T> em4<T> f(T t) {
        return t == null ? h() : new e(t).b();
    }

    public static <T> em4<T> g(Collection<? extends T> collection) {
        return new d(collection);
    }

    public static <T> em4<T> h() {
        return g.IS_NULL.withNarrowedType();
    }

    public static <T> em4<T> i(em4<T> em4Var) {
        return new f(em4Var);
    }

    public static String j(String str, Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z = true;
        for (Object obj : iterable) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class g implements em4<Object> {
        public static final g ALWAYS_TRUE = new a("ALWAYS_TRUE", 0);
        public static final g ALWAYS_FALSE = new b("ALWAYS_FALSE", 1);
        public static final g IS_NULL = new c("IS_NULL", 2);
        public static final g NOT_NULL = new d("NOT_NULL", 3);
        private static final /* synthetic */ g[] $VALUES = $values();

        /* JADX INFO: compiled from: SearchBox */
        public enum a extends g {
            public a(String str, int i) {
                super(str, i);
            }

            @Override // fm4.g, defpackage.em4
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public enum b extends g {
            public b(String str, int i) {
                super(str, i);
            }

            @Override // fm4.g, defpackage.em4
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public enum c extends g {
            public c(String str, int i) {
                super(str, i);
            }

            @Override // fm4.g, defpackage.em4
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public enum d extends g {
            public d(String str, int i) {
                super(str, i);
            }

            @Override // fm4.g, defpackage.em4
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        }

        private static /* synthetic */ g[] $values() {
            return new g[]{ALWAYS_TRUE, ALWAYS_FALSE, IS_NULL, NOT_NULL};
        }

        private g(String str, int i) {
        }

        public static g valueOf(String str) {
            return (g) Enum.valueOf(g.class, str);
        }

        public static g[] values() {
            return (g[]) $VALUES.clone();
        }

        @Override // defpackage.em4
        public abstract /* synthetic */ boolean apply(Object obj);

        public <T> em4<T> withNarrowedType() {
            return this;
        }
    }
}
