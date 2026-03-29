package defpackage;

import com.google.common.base.Optional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class fr3 {

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17584a;
        public final C1194b b;
        public C1194b c;
        public boolean d;
        public boolean e;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a extends C1194b {
            public a() {
            }
        }

        /* JADX INFO: renamed from: fr3$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C1194b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f17585a;
            public Object b;
            public C1194b c;
        }

        public static boolean k(Object obj) {
            return obj instanceof CharSequence ? ((CharSequence) obj).length() == 0 : obj instanceof Collection ? ((Collection) obj).isEmpty() : obj instanceof Map ? ((Map) obj).isEmpty() : obj instanceof Optional ? !((Optional) obj).isPresent() : obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public b a(String str, double d) {
            return i(str, String.valueOf(d));
        }

        public b b(String str, int i) {
            return i(str, String.valueOf(i));
        }

        public b c(String str, long j) {
            return i(str, String.valueOf(j));
        }

        public b d(String str, Object obj) {
            return g(str, obj);
        }

        public final C1194b e() {
            C1194b c1194b = new C1194b();
            this.c.c = c1194b;
            this.c = c1194b;
            return c1194b;
        }

        public final b f(Object obj) {
            e().b = obj;
            return this;
        }

        public final b g(String str, Object obj) {
            C1194b c1194bE = e();
            c1194bE.b = obj;
            c1194bE.f17585a = (String) dm4.o(str);
            return this;
        }

        public final a h() {
            a aVar = new a();
            this.c.c = aVar;
            this.c = aVar;
            return aVar;
        }

        public final b i(String str, Object obj) {
            a aVarH = h();
            aVarH.b = obj;
            aVarH.f17585a = (String) dm4.o(str);
            return this;
        }

        public b j(Object obj) {
            return f(obj);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            boolean z = this.d;
            boolean z2 = this.e;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f17584a);
            sb.append('{');
            String str = "";
            for (C1194b c1194b = this.b.c; c1194b != null; c1194b = c1194b.c) {
                Object obj = c1194b.b;
                if (c1194b instanceof a) {
                    sb.append(str);
                    String str2 = c1194b.f17585a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    }
                    str = ", ";
                } else if (obj == null) {
                    if (!z) {
                    }
                } else if (!z2 || !k(obj)) {
                }
            }
            sb.append('}');
            return sb.toString();
        }

        public b(String str) {
            C1194b c1194b = new C1194b();
            this.b = c1194b;
            this.c = c1194b;
            this.d = false;
            this.e = false;
            this.f17584a = (String) dm4.o(str);
        }
    }

    public static <T> T a(T t, T t2) {
        if (t != null) {
            return t;
        }
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
