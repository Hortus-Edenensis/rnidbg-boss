package com.opos.cmn.func.a.a;

import com.opos.cmn.an.g.h;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7934a;
    public final String b;
    public final InputStream c;
    public final long d;

    @Deprecated
    public final Map<String, String> e;
    public final com.opos.cmn.func.a.a.a f;
    private final long g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private String b;
        private InputStream c;
        private Map<String, String> e;
        private com.opos.cmn.func.a.a.a f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7935a = -1;
        private long d = -1;
        private long g = -1;

        public a b(long j) {
            this.g = j;
            return this;
        }

        public a a(int i) {
            this.f7935a = i;
            return this;
        }

        public a a(long j) {
            this.d = j;
            return this;
        }

        public a a(com.opos.cmn.func.a.a.a aVar) {
            this.f = aVar;
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

        public e a() {
            return new e(this);
        }
    }

    public e(a aVar) {
        this.f7934a = aVar.f7935a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
    }

    public void a() {
        long j = this.g;
        if (j >= 0) {
            h.a(j);
            return;
        }
        InputStream inputStream = this.c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                com.opos.cmn.an.f.a.c("NetResponse", "close", e);
            }
        }
    }

    public String toString() {
        return "NetResponse{code=" + this.f7934a + ", errMsg='" + this.b + "', inputStream=" + this.c + ", contentLength=" + this.d + ", headerMap=" + this.e + ", headers=" + this.f + '}';
    }
}
