package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class fl0<O> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oy3 f17545a;
    public volatile ky3 b;
    public final ReadWriteLock c;
    public final boolean d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Iterable<O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f17546a;
        public final /* synthetic */ ky3 b;

        /* JADX INFO: renamed from: fl0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1192a extends r13<O> {
            public Iterator<d> c;

            public C1192a() {
                this.c = fl0.this.f(a.this.f17546a, a.this.b).iterator();
            }

            @Override // defpackage.r13
            public O a() {
                while (this.c.hasNext()) {
                    O o = (O) this.c.next().f17549a.getValue();
                    if (o != null) {
                        return o;
                    }
                }
                return b();
            }
        }

        public a(CharSequence charSequence, ky3 ky3Var) {
            this.f17546a = charSequence;
            this.b = ky3Var;
        }

        @Override // java.lang.Iterable
        public Iterator<O> iterator() {
            return new C1192a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Iterable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ky3 f17547a;
        public final /* synthetic */ CharSequence b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends r13<d> {
            public Deque<d> c;

            public a() {
                LinkedList linkedList = new LinkedList();
                this.c = linkedList;
                linkedList.push(new d(b.this.f17547a, b.this.b));
            }

            @Override // defpackage.r13
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public d a() {
                if (this.c.isEmpty()) {
                    return b();
                }
                d dVarPop = this.c.pop();
                List<ky3> listB = dVarPop.f17549a.b();
                for (int size = listB.size(); size > 0; size--) {
                    ky3 ky3Var = listB.get(size - 1);
                    this.c.push(new d(ky3Var, a10.a(dVarPop.b, ky3Var.c())));
                }
                return dVarPop;
            }
        }

        public b(ky3 ky3Var, CharSequence charSequence) {
            this.f17547a = ky3Var;
            this.b = charSequence;
        }

        @Override // java.lang.Iterable
        public Iterator<d> iterator() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17548a;

        static {
            int[] iArr = new int[e.a.values().length];
            f17548a = iArr;
            try {
                iArr[e.a.EXACT_MATCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17548a[e.a.KEY_ENDS_MID_EDGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17548a[e.a.INCOMPLETE_MATCH_TO_MIDDLE_OF_EDGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17548a[e.a.INCOMPLETE_MATCH_TO_END_OF_EDGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ky3 f17549a;
        public final CharSequence b;

        public d(ky3 ky3Var, CharSequence charSequence) {
            this.f17549a = ky3Var;
            this.b = charSequence;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f17550a;
        public final ky3 b;
        public final int c;
        public final int d;
        public final ky3 e;
        public final ky3 f;
        public final a g;

        /* JADX INFO: compiled from: SearchBox */
        public enum a {
            EXACT_MATCH,
            INCOMPLETE_MATCH_TO_END_OF_EDGE,
            INCOMPLETE_MATCH_TO_MIDDLE_OF_EDGE,
            KEY_ENDS_MID_EDGE,
            INVALID
        }

        public e(CharSequence charSequence, ky3 ky3Var, int i, int i2, ky3 ky3Var2, ky3 ky3Var3) {
            this.f17550a = charSequence;
            this.b = ky3Var;
            this.c = i;
            this.d = i2;
            this.e = ky3Var2;
            this.f = ky3Var3;
            this.g = a(charSequence, ky3Var, i, i2);
        }

        public a a(CharSequence charSequence, ky3 ky3Var, int i, int i2) {
            if (i == charSequence.length()) {
                if (i2 == ky3Var.c().length()) {
                    return a.EXACT_MATCH;
                }
                if (i2 < ky3Var.c().length()) {
                    return a.KEY_ENDS_MID_EDGE;
                }
            } else if (i < charSequence.length()) {
                if (i2 == ky3Var.c().length()) {
                    return a.INCOMPLETE_MATCH_TO_END_OF_EDGE;
                }
                if (i2 < ky3Var.c().length()) {
                    return a.INCOMPLETE_MATCH_TO_MIDDLE_OF_EDGE;
                }
            }
            throw new IllegalStateException("Unexpected failure to classify SearchResult: " + this);
        }

        public String toString() {
            return "SearchResult{key=" + ((Object) this.f17550a) + ", nodeFound=" + this.b + ", charsMatched=" + this.c + ", charsMatchedInNodeFound=" + this.d + ", parentNode=" + this.e + ", parentNodesParent=" + this.f + ", classification=" + this.g + '}';
        }
    }

    public fl0(oy3 oy3Var) {
        this(oy3Var, false);
    }

    public void a() {
        if (this.d) {
            this.c.readLock().lock();
        }
    }

    public void b() {
        this.c.writeLock().lock();
    }

    public <O> Iterable<O> c(CharSequence charSequence, ky3 ky3Var) {
        return new a(charSequence, ky3Var);
    }

    public O d(CharSequence charSequence) {
        a();
        try {
            e eVarK = k(charSequence);
            if (eVarK.g.equals(e.a.EXACT_MATCH)) {
                return (O) eVarK.b.getValue();
            }
            i();
            return null;
        } finally {
            i();
        }
    }

    public Iterable<O> e(CharSequence charSequence) {
        a();
        try {
            e eVarK = k(charSequence);
            int i = c.f17548a[eVarK.g.ordinal()];
            return i != 1 ? i != 2 ? Collections.emptySet() : c(a10.a(charSequence, a10.e(eVarK.b.c(), eVarK.d)), eVarK.b) : c(charSequence, eVarK.b);
        } finally {
            i();
        }
    }

    public Iterable<d> f(CharSequence charSequence, ky3 ky3Var) {
        return new b(ky3Var, charSequence);
    }

    public O g(CharSequence charSequence, O o) {
        return (O) h(charSequence, o, true);
    }

    public Object h(CharSequence charSequence, Object obj, boolean z) {
        if (charSequence == null) {
            throw new IllegalArgumentException("The key argument was null");
        }
        if (charSequence.length() == 0) {
            throw new IllegalArgumentException("The key argument was zero-length");
        }
        if (obj == null) {
            throw new IllegalArgumentException("The value argument was null");
        }
        b();
        try {
            e eVarK = k(charSequence);
            int i = c.f17548a[eVarK.g.ordinal()];
            boolean z2 = true;
            if (i == 1) {
                Object value = eVarK.b.getValue();
                if (!z && value != null) {
                    return value;
                }
                eVarK.e.e(this.f17545a.a(eVarK.b.c(), obj, eVarK.b.b(), false));
                return value;
            }
            if (i == 2) {
                CharSequence charSequenceD = a10.d(charSequence.subSequence(eVarK.c - eVarK.d, charSequence.length()), eVarK.b.c());
                eVarK.e.e(this.f17545a.a(charSequenceD, obj, Arrays.asList(this.f17545a.a(a10.f(eVarK.b.c(), charSequenceD), eVarK.b.getValue(), eVarK.b.b(), false)), false));
                return null;
            }
            if (i == 3) {
                CharSequence charSequenceD2 = a10.d(charSequence.subSequence(eVarK.c - eVarK.d, charSequence.length()), eVarK.b.c());
                eVarK.e.e(this.f17545a.a(charSequenceD2, null, Arrays.asList(this.f17545a.a(charSequence.subSequence(eVarK.c, charSequence.length()), obj, Collections.emptyList(), false), this.f17545a.a(a10.f(eVarK.b.c(), charSequenceD2), eVarK.b.getValue(), eVarK.b.b(), false)), false));
                return null;
            }
            if (i != 4) {
                throw new IllegalStateException("Unexpected classification for search result: " + eVarK);
            }
            ky3 ky3VarA = this.f17545a.a(charSequence.subSequence(eVarK.c, charSequence.length()), obj, Collections.emptyList(), false);
            ArrayList arrayList = new ArrayList(eVarK.b.b().size() + 1);
            arrayList.addAll(eVarK.b.b());
            arrayList.add(ky3VarA);
            oy3 oy3Var = this.f17545a;
            CharSequence charSequenceC = eVarK.b.c();
            Object value2 = eVarK.b.getValue();
            if (eVarK.b != this.b) {
                z2 = false;
            }
            ky3 ky3VarA2 = oy3Var.a(charSequenceC, value2, arrayList, z2);
            if (eVarK.b == this.b) {
                this.b = ky3VarA2;
            } else {
                eVarK.e.e(ky3VarA2);
            }
            return null;
        } finally {
            j();
        }
    }

    public void i() {
        if (this.d) {
            this.c.readLock().unlock();
        }
    }

    public void j() {
        this.c.writeLock().unlock();
    }

    public e k(CharSequence charSequence) {
        ky3 ky3Var;
        int i;
        ky3 ky3Var2;
        int i2;
        ky3 ky3Var3;
        ky3 ky3Var4 = this.b;
        int length = charSequence.length();
        ky3 ky3Var5 = null;
        ky3 ky3Var6 = null;
        int i3 = 0;
        int i4 = 0;
        loop0: while (i3 < length) {
            ky3 ky3VarD = ky3Var4.d(Character.valueOf(charSequence.charAt(i3)));
            if (ky3VarD == null) {
                break;
            }
            CharSequence charSequenceC = ky3VarD.c();
            int length2 = charSequenceC.length();
            int i5 = 0;
            for (int i6 = 0; i6 < length2 && i3 < length; i6++) {
                if (charSequenceC.charAt(i6) != charSequence.charAt(i3)) {
                    ky3Var2 = ky3Var4;
                    ky3Var = ky3VarD;
                    i = i5;
                    int i7 = i3;
                    ky3Var3 = ky3Var5;
                    i2 = i7;
                    break loop0;
                }
                i3++;
                i5++;
            }
            ky3Var6 = ky3Var5;
            i4 = i5;
            ky3Var5 = ky3Var4;
            ky3Var4 = ky3VarD;
        }
        ky3Var = ky3Var4;
        i = i4;
        ky3 ky3Var7 = ky3Var6;
        ky3Var2 = ky3Var5;
        i2 = i3;
        ky3Var3 = ky3Var7;
        return new e(charSequence, ky3Var, i2, i, ky3Var2, ky3Var3);
    }

    public fl0(oy3 oy3Var, boolean z) {
        this.c = new ReentrantReadWriteLock();
        this.f17545a = oy3Var;
        this.d = z;
        this.b = oy3Var.a("", null, Collections.emptyList(), true);
    }
}
