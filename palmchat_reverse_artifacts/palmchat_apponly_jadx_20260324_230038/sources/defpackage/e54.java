package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e54 {
    public static final e54 f = new e54();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f17216a;
    public int b;
    public String c;
    public String d;
    public String e;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17217a = 0;
        public int b;
        public String c;
        public String d;
        public String e;

        public b b(String str) {
            this.c = str;
            return this;
        }

        public e54 c() {
            return new e54(this);
        }

        public b d(String str) {
            this.d = str;
            return this;
        }

        public b f(String str) {
            this.e = str;
            return this;
        }
    }

    public e54() {
        this.c = "";
        this.d = "";
        this.e = "";
    }

    public int a() {
        return this.f17216a;
    }

    public void b(String str) {
        this.c = str;
    }

    public int c() {
        return this.b;
    }

    public void d(String str) {
        this.d = str;
    }

    public String e() {
        return this.c;
    }

    public void f(String str) {
        this.e = str;
    }

    public String g() {
        return this.d;
    }

    public String h() {
        return this.e;
    }

    public e54(b bVar) {
        this.c = "";
        this.d = "";
        this.e = "";
        this.f17216a = bVar.f17217a;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.b = bVar.b;
    }
}
