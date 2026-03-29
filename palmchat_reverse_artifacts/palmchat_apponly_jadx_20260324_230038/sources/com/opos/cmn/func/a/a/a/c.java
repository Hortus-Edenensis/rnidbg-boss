package com.opos.cmn.func.a.a.a;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7922a;
    public final String b;
    public final String c;
    public final boolean d;
    public final List<String> e;
    public final b f;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private String b;
        private String c;
        private List<String> e;
        private b f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f7923a = true;
        private boolean d = true;

        public c a() {
            return new c(this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    private c(a aVar) {
        this.f7922a = aVar.f7923a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
    }

    public String toString() {
        return "HttpDnsConfig{enableHttpDns=" + this.f7922a + ", region='" + this.b + "', appVersion='" + this.c + "', enableDnUnit=" + this.d + ", innerWhiteList=" + this.e + ", accountCallback=" + this.f + '}';
    }
}
