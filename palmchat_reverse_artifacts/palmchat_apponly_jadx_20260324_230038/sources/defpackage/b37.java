package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b37 {
    public b f;
    public mw6 k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1641a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String g = "";
    public int h = 1;
    public int i = 1;
    public int j = 7;
    public c e = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements c {
        public a() {
        }

        @Override // b37.c
        public final String a() {
            return "";
        }

        @Override // b37.c
        public final String b() {
            return "";
        }

        @Override // b37.c
        public final String c() {
            return "";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        String a();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        String a();

        String b();

        String c();
    }

    public b a() {
        return this.f;
    }

    public void b(int i) {
        this.h = i;
    }

    public void c(mw6 mw6Var) {
        this.k = mw6Var;
    }

    public void d(b bVar) {
        this.f = bVar;
    }

    public void e(c cVar) {
        this.e = cVar;
    }

    public void f(String str) {
        this.g = str;
    }

    public c g() {
        return this.e;
    }

    public void h(int i) {
        this.i = i;
    }

    public void i(String str) {
        this.f1641a = str;
    }

    public String j() {
        return this.g;
    }

    public void k(int i) {
        this.j = i;
    }

    public void l(String str) {
        this.b = str;
    }

    public String m() {
        return this.b;
    }

    public void n(String str) {
        this.c = str;
    }

    public String o() {
        return this.f1641a;
    }

    public void p(String str) {
        this.d = str;
    }

    public String q() {
        return this.c;
    }

    public String r() {
        return this.d;
    }

    public int s() {
        return this.h;
    }

    public int t() {
        return this.i;
    }

    public int u() {
        return this.j;
    }

    public mw6 v() {
        return this.k;
    }
}
