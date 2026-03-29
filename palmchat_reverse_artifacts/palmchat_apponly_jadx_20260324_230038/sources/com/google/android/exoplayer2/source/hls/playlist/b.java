package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import defpackage.bv2;
import defpackage.ei2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class b extends ei2 {
    public final int d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final long h;
    public final boolean i;
    public final int j;
    public final long k;
    public final int l;
    public final long m;
    public final long n;
    public final boolean o;
    public final boolean p;

    @Nullable
    public final DrmInitData q;
    public final List<d> r;
    public final List<C0357b> s;
    public final Map<Uri, c> t;
    public final long u;
    public final f v;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.hls.playlist.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0357b extends e {
        public final boolean l;
        public final boolean m;

        public C0357b(String str, @Nullable d dVar, long j, int i, long j2, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j3, long j4, boolean z, boolean z2, boolean z3) {
            super(str, dVar, j, i, j2, drmInitData, str2, str3, j3, j4, z);
            this.l = z2;
            this.m = z3;
        }

        public C0357b b(long j, int i) {
            return new C0357b(this.f5964a, this.b, this.c, i, j, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f5963a;
        public final long b;
        public final int c;

        public c(Uri uri, long j, int i) {
            this.f5963a = uri;
            this.b = j;
            this.c = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements Comparable<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5964a;

        @Nullable
        public final d b;
        public final long c;
        public final int d;
        public final long e;

        @Nullable
        public final DrmInitData f;

        @Nullable
        public final String g;

        @Nullable
        public final String h;
        public final long i;
        public final long j;
        public final boolean k;

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Long l) {
            if (this.e > l.longValue()) {
                return 1;
            }
            return this.e < l.longValue() ? -1 : 0;
        }

        public e(String str, @Nullable d dVar, long j, int i, long j2, @Nullable DrmInitData drmInitData, @Nullable String str2, @Nullable String str3, long j3, long j4, boolean z) {
            this.f5964a = str;
            this.b = dVar;
            this.c = j;
            this.d = i;
            this.e = j2;
            this.f = drmInitData;
            this.g = str2;
            this.h = str3;
            this.i = j3;
            this.j = j4;
            this.k = z;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f5965a;
        public final boolean b;
        public final long c;
        public final long d;
        public final boolean e;

        public f(long j, boolean z, long j2, long j3, boolean z2) {
            this.f5965a = j;
            this.b = z;
            this.c = j2;
            this.d = j3;
            this.e = z2;
        }
    }

    public b(int i, String str, List<String> list, long j, boolean z, long j2, boolean z2, int i2, long j3, int i3, long j4, long j5, boolean z3, boolean z4, boolean z5, @Nullable DrmInitData drmInitData, List<d> list2, List<C0357b> list3, f fVar, Map<Uri, c> map) {
        super(str, list, z3);
        this.d = i;
        this.h = j2;
        this.g = z;
        this.i = z2;
        this.j = i2;
        this.k = j3;
        this.l = i3;
        this.m = j4;
        this.n = j5;
        this.o = z4;
        this.p = z5;
        this.q = drmInitData;
        this.r = ImmutableList.copyOf((Collection) list2);
        this.s = ImmutableList.copyOf((Collection) list3);
        this.t = ImmutableMap.copyOf((Map) map);
        if (!list3.isEmpty()) {
            C0357b c0357b = (C0357b) bv2.g(list3);
            this.u = c0357b.e + c0357b.c;
        } else if (list2.isEmpty()) {
            this.u = 0L;
        } else {
            d dVar = (d) bv2.g(list2);
            this.u = dVar.e + dVar.c;
        }
        this.e = j != -9223372036854775807L ? j >= 0 ? Math.min(this.u, j) : Math.max(0L, this.u + j) : -9223372036854775807L;
        this.f = j >= 0;
        this.v = fVar;
    }

    public b b(long j, int i) {
        return new b(this.d, this.f17306a, this.b, this.e, this.g, j, true, i, this.k, this.l, this.m, this.n, this.c, this.o, this.p, this.q, this.r, this.s, this.v, this.t);
    }

    public b c() {
        return this.o ? this : new b(this.d, this.f17306a, this.b, this.e, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.c, true, this.p, this.q, this.r, this.s, this.v, this.t);
    }

    public long d() {
        return this.h + this.u;
    }

    public boolean e(@Nullable b bVar) {
        if (bVar == null) {
            return true;
        }
        long j = this.k;
        long j2 = bVar.k;
        if (j > j2) {
            return true;
        }
        if (j < j2) {
            return false;
        }
        int size = this.r.size() - bVar.r.size();
        if (size != 0) {
            return size > 0;
        }
        int size2 = this.s.size();
        int size3 = bVar.s.size();
        if (size2 <= size3) {
            return size2 == size3 && this.o && !bVar.o;
        }
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends e {
        public final String l;
        public final List<C0357b> m;

        public d(String str, long j, long j2, @Nullable String str2, @Nullable String str3) {
            this(str, null, "", 0L, -1, -9223372036854775807L, null, str2, str3, j, j2, false, ImmutableList.of());
        }

        public d b(long j, int i) {
            ArrayList arrayList = new ArrayList();
            long j2 = j;
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                C0357b c0357b = this.m.get(i2);
                arrayList.add(c0357b.b(j2, i));
                j2 += c0357b.c;
            }
            return new d(this.f5964a, this.b, this.l, this.c, i, j, this.f, this.g, this.h, this.i, this.j, this.k, arrayList);
        }

        public d(String str, @Nullable d dVar, String str2, long j, int i, long j2, @Nullable DrmInitData drmInitData, @Nullable String str3, @Nullable String str4, long j3, long j4, boolean z, List<C0357b> list) {
            super(str, dVar, j, i, j2, drmInitData, str3, str4, j3, j4, z);
            this.l = str2;
            this.m = ImmutableList.copyOf((Collection) list);
        }
    }

    @Override // defpackage.mv1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b copy(List<StreamKey> list) {
        return this;
    }
}
