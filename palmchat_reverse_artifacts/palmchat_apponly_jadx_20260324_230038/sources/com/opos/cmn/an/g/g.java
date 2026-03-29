package com.opos.cmn.an.g;

import java.io.InputStream;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7785a;
    public final String b;
    public final InputStream c;
    public final long d;
    public final Map<String, String> e;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private String b;
        private InputStream c;
        private Map<String, String> e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7786a = -1;
        private long d = -1;

        public a a(int i) {
            this.f7786a = i;
            return this;
        }

        public a a(long j) {
            this.d = j;
            return this;
        }

        public a a(InputStream inputStream) {
            this.c = inputStream;
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a a(Map<String, String> map) {
            this.e = map;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    public g(a aVar) {
        this.f7785a = aVar.f7786a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
    }

    public String toString() {
        return "NetResponse{code=" + this.f7785a + ", errMsg='" + this.b + "', inputStream=" + this.c + ", contentLength=" + this.d + ", headerMap=" + this.e + '}';
    }
}
