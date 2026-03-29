package com.opos.cmn.func.a.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7932a;
    public final String b;
    public final Map<String, String> c;
    public final byte[] d;
    public final long e;
    public final boolean f;
    public final boolean g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static AtomicLong f7933a = new AtomicLong(0);
        private String b;
        private String c;
        private Map<String, String> d;
        private byte[] e;
        private long f;
        private boolean g = false;
        private boolean h = false;

        private static long b() {
            return f7933a.getAndIncrement();
        }

        public a a(d dVar) {
            a aVar = new a();
            if (dVar != null) {
                aVar.a(dVar.f7932a);
                aVar.b(dVar.b);
                aVar.a(dVar.c);
                aVar.a(dVar.d);
                aVar.a(dVar.f);
                aVar.b(dVar.g);
            }
            return aVar;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a a(Map<String, String> map) {
            this.d = map;
            return this;
        }

        public a b(boolean z) {
            this.h = z;
            return this;
        }

        public a a(boolean z) {
            this.g = z;
            return this;
        }

        public a a(byte[] bArr) {
            this.e = bArr;
            return this;
        }

        public d a() {
            if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) {
                throw new NullPointerException("httpMethod or url is null.");
            }
            this.f = b();
            if (this.d == null) {
                this.d = new HashMap();
            }
            return new d(this);
        }
    }

    public d(a aVar) {
        this.f7932a = aVar.b;
        this.b = aVar.c;
        this.c = aVar.d;
        this.d = aVar.e;
        this.e = aVar.f;
        this.f = aVar.g;
        this.g = aVar.h;
    }

    public String toString() {
        return "NetRequest{, httpMethod='" + this.f7932a + "', url='" + this.b + "', headerMap=" + this.c + ", requestId=" + this.e + ", needEnCrypt=" + this.f + ", supportGzipCompress=" + this.g + '}';
    }
}
