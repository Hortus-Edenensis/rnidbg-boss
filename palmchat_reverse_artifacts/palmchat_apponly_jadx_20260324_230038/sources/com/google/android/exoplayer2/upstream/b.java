package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.qiniu.android.http.request.Request;
import defpackage.jr1;
import defpackage.vh;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f6011a;
    public final long b;
    public final int c;

    @Nullable
    public final byte[] d;
    public final Map<String, String> e;

    @Deprecated
    public final long f;
    public final long g;
    public final long h;

    @Nullable
    public final String i;
    public final int j;

    @Nullable
    public final Object k;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0361b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Uri f6012a;
        public long b;
        public int c;

        @Nullable
        public byte[] d;
        public Map<String, String> e;
        public long f;
        public long g;

        @Nullable
        public String h;
        public int i;

        @Nullable
        public Object j;

        public b a() {
            vh.j(this.f6012a, "The uri must be set.");
            return new b(this.f6012a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }

        public C0361b b(int i) {
            this.i = i;
            return this;
        }

        public C0361b c(@Nullable byte[] bArr) {
            this.d = bArr;
            return this;
        }

        public C0361b d(int i) {
            this.c = i;
            return this;
        }

        public C0361b e(Map<String, String> map) {
            this.e = map;
            return this;
        }

        public C0361b f(@Nullable String str) {
            this.h = str;
            return this;
        }

        public C0361b g(long j) {
            this.g = j;
            return this;
        }

        public C0361b h(long j) {
            this.f = j;
            return this;
        }

        public C0361b i(Uri uri) {
            this.f6012a = uri;
            return this;
        }

        public C0361b j(String str) {
            this.f6012a = Uri.parse(str);
            return this;
        }

        public C0361b k(long j) {
            this.b = j;
            return this;
        }

        public C0361b() {
            this.c = 1;
            this.e = Collections.emptyMap();
            this.g = -1L;
        }

        public C0361b(b bVar) {
            this.f6012a = bVar.f6011a;
            this.b = bVar.b;
            this.c = bVar.c;
            this.d = bVar.d;
            this.e = bVar.e;
            this.f = bVar.g;
            this.g = bVar.h;
            this.h = bVar.i;
            this.i = bVar.j;
            this.j = bVar.k;
        }
    }

    static {
        jr1.a("goog.exo.datasource");
    }

    public static String c(int i) {
        if (i == 1) {
            return "GET";
        }
        if (i == 2) {
            return "POST";
        }
        if (i == 3) {
            return Request.HttpMethodHEAD;
        }
        throw new IllegalStateException();
    }

    public C0361b a() {
        return new C0361b();
    }

    public final String b() {
        return c(this.c);
    }

    public boolean d(int i) {
        return (this.j & i) == i;
    }

    public b e(long j) {
        long j2 = this.h;
        return f(j, j2 != -1 ? j2 - j : -1L);
    }

    public b f(long j, long j2) {
        return (j == 0 && this.h == j2) ? this : new b(this.f6011a, this.b, this.c, this.d, this.e, this.g + j, j2, this.i, this.j, this.k);
    }

    public String toString() {
        return "DataSpec[" + b() + " " + this.f6011a + ", " + this.g + ", " + this.h + ", " + this.i + ", " + this.j + "]";
    }

    public b(Uri uri, long j, int i, @Nullable byte[] bArr, Map<String, String> map, long j2, long j3, @Nullable String str, int i2, @Nullable Object obj) {
        byte[] bArr2 = bArr;
        long j4 = j + j2;
        boolean z = true;
        vh.a(j4 >= 0);
        vh.a(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        vh.a(z);
        this.f6011a = uri;
        this.b = j;
        this.c = i;
        this.d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.e = Collections.unmodifiableMap(new HashMap(map));
        this.g = j2;
        this.f = j4;
        this.h = j3;
        this.i = str;
        this.j = i2;
        this.k = obj;
    }
}
