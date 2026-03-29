package defpackage;

import j$.util.Objects;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class qy2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20352a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends qy2 {
        public final /* synthetic */ String b;
        public final /* synthetic */ qy2 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qy2 qy2Var, qy2 qy2Var2, String str) {
            super(qy2Var2, null);
            this.b = str;
            this.c = qy2Var;
        }

        @Override // defpackage.qy2
        public CharSequence i(Object obj) {
            return obj == null ? this.b : this.c.i(obj);
        }

        @Override // defpackage.qy2
        public qy2 j(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    public /* synthetic */ qy2(qy2 qy2Var, a aVar) {
        this(qy2Var);
    }

    public static qy2 g(char c) {
        return new qy2(String.valueOf(c));
    }

    public static qy2 h(String str) {
        return new qy2(str);
    }

    public <A extends Appendable> A a(A a2, Iterator<? extends Object> it) throws IOException {
        dm4.o(a2);
        if (it.hasNext()) {
            a2.append(i(it.next()));
            while (it.hasNext()) {
                a2.append(this.f20352a);
                a2.append(i(it.next()));
            }
        }
        return a2;
    }

    public final StringBuilder b(StringBuilder sb, Iterable<? extends Object> iterable) {
        return c(sb, iterable.iterator());
    }

    public final StringBuilder c(StringBuilder sb, Iterator<? extends Object> it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final String d(Iterable<? extends Object> iterable) {
        return e(iterable.iterator());
    }

    public final String e(Iterator<? extends Object> it) {
        return c(new StringBuilder(), it).toString();
    }

    public final String f(Object[] objArr) {
        return d(Arrays.asList(objArr));
    }

    public CharSequence i(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public qy2 j(String str) {
        dm4.o(str);
        return new a(this, this, str);
    }

    public qy2(String str) {
        this.f20352a = (String) dm4.o(str);
    }

    public qy2(qy2 qy2Var) {
        this.f20352a = qy2Var.f20352a;
    }
}
