package com.opos.cmn.func.a.a.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7927a;
    public final long b;
    public final String c;
    public final String d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f7928a = true;
        private long b = 0;
        private String c = "";
        private String d = "";

        public f a() {
            if (this.b <= 0) {
                this.b = com.opos.cmn.func.a.b.a.a.a() ? 173525275249090560L : 183258695109709824L;
            }
            return new f(this);
        }
    }

    private f(a aVar) {
        this.f7927a = aVar.f7928a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
    }

    public String toString() {
        return "IPv6Config{useIpv6Switcher=" + this.f7927a + ", ipv6ConfigId=" + this.b + ", channelId='" + this.c + "', buildNumber='" + this.d + "'}";
    }
}
