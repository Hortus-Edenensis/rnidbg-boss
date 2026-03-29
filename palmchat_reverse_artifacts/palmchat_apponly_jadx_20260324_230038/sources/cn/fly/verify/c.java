package cn.fly.verify;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2136a;
    private String b;
    private int c;
    private String d;
    private int e;
    private String f;
    private long g;
    private long h;
    private long i;
    private boolean j;
    private boolean k;
    private String l;
    private boolean m;
    private String o;
    private String p;
    private boolean q;
    private Integer s;
    private String t;
    private Integer u;
    private boolean r = false;
    private final long n = System.currentTimeMillis();

    /* JADX INFO: renamed from: cn.fly.verify.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2137a;

        static {
            int[] iArr = new int[g.values().length];
            f2137a = iArr;
            try {
                iArr[g.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2137a[g.PREVERIFY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2137a[g.AUTHPAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2137a[g.VERIFY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2137a[g.LOG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public c(g gVar, String str) {
        String str2;
        int i = AnonymousClass1.f2137a[gVar.ordinal()];
        if (i == 1) {
            str2 = "init";
        } else if (i == 2) {
            str2 = "preVerify";
        } else if (i == 3) {
            str2 = "authPageOpend";
        } else {
            if (i != 4) {
                if (i == 5) {
                    str2 = "log";
                }
                this.b = str;
            }
            str2 = "verify";
        }
        this.f2136a = str2;
        this.b = str;
    }

    public void a(int i) {
        this.c = i;
    }

    public String b() {
        return this.p;
    }

    public String c() {
        return this.f2136a;
    }

    public String d() {
        return this.b;
    }

    public int e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }

    public int g() {
        return this.e;
    }

    public String h() {
        return this.f;
    }

    public long i() {
        return this.g;
    }

    public long j() {
        return this.h;
    }

    public long k() {
        return this.i;
    }

    public boolean l() {
        return this.j;
    }

    public boolean m() {
        return this.k;
    }

    public String n() {
        return this.l;
    }

    public boolean o() {
        return this.m;
    }

    public boolean p() {
        return this.q;
    }

    public String q() {
        return this.o;
    }

    public Integer r() {
        return this.s;
    }

    public String s() {
        return this.t;
    }

    public Integer t() {
        return this.u;
    }

    public void a(long j) {
        this.g = j;
    }

    public void b(int i) {
        this.e = i;
    }

    public void c(long j) {
        this.i = j;
    }

    public void d(String str) {
        this.f = str;
    }

    public void e(String str) {
        this.l = str;
    }

    public void f(String str) {
        this.o = str;
    }

    public void g(String str) {
        this.t = str;
    }

    public void a(Integer num) {
        this.s = num;
    }

    public void b(long j) {
        this.h = j;
    }

    public void c(String str) {
        this.d = str;
    }

    public void a(String str) {
        this.p = str;
    }

    public void b(Integer num) {
        this.u = num;
    }

    public void c(boolean z) {
        this.q = z;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public void b(String str) {
        this.b = str;
    }

    public boolean a() {
        return this.r;
    }

    public void b(boolean z) {
        this.m = z;
    }
}
