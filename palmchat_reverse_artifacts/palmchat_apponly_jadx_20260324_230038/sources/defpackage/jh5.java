package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class jh5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z00 f18405a;
    public final boolean b;
    public final c c;
    public final int d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z00 f18406a;

        /* JADX INFO: renamed from: jh5$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1222a extends b {
            public C1222a(jh5 jh5Var, CharSequence charSequence) {
                super(jh5Var, charSequence);
            }

            @Override // jh5.b
            public int e(int i) {
                return i + 1;
            }

            @Override // jh5.b
            public int f(int i) {
                return a.this.f18406a.e(this.c, i);
            }
        }

        public a(z00 z00Var) {
            this.f18406a = z00Var;
        }

        @Override // jh5.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(jh5 jh5Var, CharSequence charSequence) {
            return new C1222a(jh5Var, charSequence);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class b extends j1<String> {
        public final CharSequence c;
        public final z00 d;
        public final boolean e;
        public int f = 0;
        public int g;

        public b(jh5 jh5Var, CharSequence charSequence) {
            this.d = jh5Var.f18405a;
            this.e = jh5Var.b;
            this.g = jh5Var.d;
            this.c = charSequence;
        }

        @Override // defpackage.j1
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int iF;
            int i = this.f;
            while (true) {
                int i2 = this.f;
                if (i2 == -1) {
                    return b();
                }
                iF = f(i2);
                if (iF == -1) {
                    iF = this.c.length();
                    this.f = -1;
                } else {
                    this.f = e(iF);
                }
                int i3 = this.f;
                if (i3 == i) {
                    int i4 = i3 + 1;
                    this.f = i4;
                    if (i4 > this.c.length()) {
                        this.f = -1;
                    }
                } else {
                    while (i < iF && this.d.g(this.c.charAt(i))) {
                        i++;
                    }
                    while (iF > i && this.d.g(this.c.charAt(iF - 1))) {
                        iF--;
                    }
                    if (!this.e || i != iF) {
                        break;
                    }
                    i = this.f;
                }
            }
            int i5 = this.g;
            if (i5 == 1) {
                iF = this.c.length();
                this.f = -1;
                while (iF > i && this.d.g(this.c.charAt(iF - 1))) {
                    iF--;
                }
            } else {
                this.g = i5 - 1;
            }
            return this.c.subSequence(i, iF).toString();
        }

        public abstract int e(int i);

        public abstract int f(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        Iterator<String> a(jh5 jh5Var, CharSequence charSequence);
    }

    public jh5(c cVar) {
        this(cVar, false, z00.i(), Integer.MAX_VALUE);
    }

    public static jh5 d(char c2) {
        return e(z00.f(c2));
    }

    public static jh5 e(z00 z00Var) {
        dm4.o(z00Var);
        return new jh5(new a(z00Var));
    }

    public List<String> f(CharSequence charSequence) {
        dm4.o(charSequence);
        Iterator<String> itG = g(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itG.hasNext()) {
            arrayList.add(itG.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final Iterator<String> g(CharSequence charSequence) {
        return this.c.a(this, charSequence);
    }

    public jh5(c cVar, boolean z, z00 z00Var, int i) {
        this.c = cVar;
        this.b = z;
        this.f18405a = z00Var;
        this.d = i;
    }
}
