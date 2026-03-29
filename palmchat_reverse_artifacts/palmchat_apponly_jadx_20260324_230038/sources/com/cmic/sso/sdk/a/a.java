package com.cmic.sso.sdk.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5469a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;

    /* JADX INFO: renamed from: com.cmic.sso.sdk.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0321a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f5470a = new a();

        public C0321a a(String str) {
            this.f5470a.f5469a = str;
            return this;
        }

        public C0321a b(String str) {
            this.f5470a.b = str;
            return this;
        }

        public C0321a c(String str) {
            this.f5470a.c = str;
            return this;
        }

        public C0321a d(String str) {
            this.f5470a.d = str;
            return this;
        }

        public C0321a e(boolean z) {
            this.f5470a.i = z;
            return this;
        }

        public C0321a f(boolean z) {
            this.f5470a.j = z;
            return this;
        }

        public C0321a a(boolean z) {
            this.f5470a.e = z;
            return this;
        }

        public C0321a b(boolean z) {
            this.f5470a.f = z;
            return this;
        }

        public C0321a c(boolean z) {
            this.f5470a.g = z;
            return this;
        }

        public C0321a d(boolean z) {
            this.f5470a.h = z;
            return this;
        }

        public C0321a a(int i) {
            this.f5470a.k = i;
            return this;
        }

        public C0321a b(int i) {
            this.f5470a.l = i;
            return this;
        }

        public a a() {
            return this.f5470a;
        }
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public boolean i() {
        return this.i;
    }

    public boolean j() {
        return this.j;
    }

    public int k() {
        return this.k;
    }

    public int l() {
        return this.l;
    }

    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public a clone() throws CloneNotSupportedException {
        return (a) super.clone();
    }

    public String toString() {
        return "UmcConfigBean{mHttpsGetTokenHost='" + this.f5469a + "', mHttpsGetPhoneScripHost='" + this.b + "', mConfigHost='" + this.c + "', mLogHost='" + this.d + "', mCloseCtccWork=" + this.e + ", mCloseCuccWort=" + this.f + ", mCloseM008Business=" + this.g + ", mCloseGetPhoneIpv4=" + this.h + ", mCloseGetPhoneIpv6=" + this.i + ", mCloseLog=" + this.j + ", mMaxFailedLogTimes=" + this.k + ", mLogSuspendTime=" + this.l + '}';
    }

    private a() {
        this.f5469a = "rcs.cmpassport.com";
        this.b = "rcs.cmpassport.com";
        this.c = "config2.cmpassport.com";
        this.d = "log2.cmpassport.com:9443";
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = 3;
        this.l = 1;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String a() {
        return this.f5469a;
    }

    public String b() {
        return this.b;
    }
}
