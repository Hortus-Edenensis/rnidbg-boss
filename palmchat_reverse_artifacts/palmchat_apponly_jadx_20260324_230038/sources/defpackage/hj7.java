package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class hj7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17979a;
    public String b;
    public boolean c;
    public boolean d;
    public byte[] e;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17980a;
        public String b;
        public boolean c;
        public boolean d;
        public byte[] e;

        public a a(String str) {
            this.f17980a = str;
            return this;
        }

        public a b(boolean z) {
            this.d = z;
            return this;
        }

        public a c(byte[] bArr) {
            this.e = bArr;
            return this;
        }

        public hj7 d() {
            hj7 hj7Var = new hj7();
            hj7Var.f17979a = this.f17980a;
            hj7Var.b = this.b;
            hj7Var.c = this.c;
            hj7Var.d = this.d;
            hj7Var.e = this.e;
            return hj7Var;
        }
    }

    public byte[] a() {
        return this.e;
    }

    public boolean c() {
        return this.d;
    }

    public String e() {
        return this.f17979a;
    }
}
