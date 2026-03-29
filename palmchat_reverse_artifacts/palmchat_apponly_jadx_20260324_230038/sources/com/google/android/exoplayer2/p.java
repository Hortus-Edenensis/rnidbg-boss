package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.p;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import defpackage.g86;
import defpackage.hv;
import defpackage.vh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class p implements com.google.android.exoplayer2.f {
    public static final p i = new c().a();
    public static final String j = g86.w0(0);
    public static final String k = g86.w0(1);
    public static final String l = g86.w0(2);
    public static final String m = g86.w0(3);
    public static final String n = g86.w0(4);
    public static final String o = g86.w0(5);
    public static final f.a<p> p = new f.a() { // from class: xg3
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return p.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5910a;

    @Nullable
    public final h b;

    @Nullable
    @Deprecated
    public final h c;
    public final g d;
    public final q e;
    public final d f;

    @Deprecated
    public final e g;
    public final i h;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements com.google.android.exoplayer2.f {
        public static final String c = g86.w0(0);
        public static final f.a<b> d = new f.a() { // from class: yg3
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return p.b.b(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f5911a;

        @Nullable
        public final Object b;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Uri f5912a;

            @Nullable
            public Object b;

            public a(Uri uri) {
                this.f5912a = uri;
            }

            public b c() {
                return new b(this);
            }
        }

        public static b b(Bundle bundle) {
            Uri uri = (Uri) bundle.getParcelable(c);
            vh.e(uri);
            return new a(uri).c();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f5911a.equals(bVar.f5911a) && g86.c(this.b, bVar.b);
        }

        public int hashCode() {
            int iHashCode = this.f5911a.hashCode() * 31;
            Object obj = this.b;
            return iHashCode + (obj != null ? obj.hashCode() : 0);
        }

        @Override // com.google.android.exoplayer2.f
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(c, this.f5911a);
            return bundle;
        }

        public b(a aVar) {
            this.f5911a = aVar.f5912a;
            this.b = aVar.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public String f5913a;

        @Nullable
        public Uri b;

        @Nullable
        public String c;
        public d.a d;
        public f.a e;
        public List<StreamKey> f;

        @Nullable
        public String g;
        public ImmutableList<k> h;

        @Nullable
        public b i;

        @Nullable
        public Object j;

        @Nullable
        public q k;
        public g.a l;
        public i m;

        public p a() {
            h hVar;
            vh.g(this.e.b == null || this.e.f5917a != null);
            Uri uri = this.b;
            if (uri != null) {
                hVar = new h(uri, this.c, this.e.f5917a != null ? this.e.i() : null, this.i, this.f, this.g, this.h, this.j);
            } else {
                hVar = null;
            }
            String str = this.f5913a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            e eVarG = this.d.g();
            g gVarF = this.l.f();
            q qVar = this.k;
            if (qVar == null) {
                qVar = q.J;
            }
            return new p(str2, eVarG, hVar, gVarF, qVar, this.m);
        }

        public c b(@Nullable String str) {
            this.g = str;
            return this;
        }

        public c c(g gVar) {
            this.l = gVar.b();
            return this;
        }

        public c d(String str) {
            this.f5913a = (String) vh.e(str);
            return this;
        }

        public c e(@Nullable String str) {
            this.c = str;
            return this;
        }

        public c f(@Nullable List<StreamKey> list) {
            this.f = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public c g(List<k> list) {
            this.h = ImmutableList.copyOf((Collection) list);
            return this;
        }

        public c h(@Nullable Object obj) {
            this.j = obj;
            return this;
        }

        public c i(@Nullable Uri uri) {
            this.b = uri;
            return this;
        }

        public c j(@Nullable String str) {
            return i(str == null ? null : Uri.parse(str));
        }

        public c() {
            this.d = new d.a();
            this.e = new f.a();
            this.f = Collections.emptyList();
            this.h = ImmutableList.of();
            this.l = new g.a();
            this.m = i.d;
        }

        public c(p pVar) {
            f.a aVar;
            this();
            this.d = pVar.f.b();
            this.f5913a = pVar.f5910a;
            this.k = pVar.e;
            this.l = pVar.d.b();
            this.m = pVar.h;
            h hVar = pVar.b;
            if (hVar != null) {
                this.g = hVar.f;
                this.c = hVar.b;
                this.b = hVar.f5920a;
                this.f = hVar.e;
                this.h = hVar.g;
                this.j = hVar.i;
                f fVar = hVar.c;
                if (fVar != null) {
                    aVar = fVar.c();
                } else {
                    aVar = new f.a();
                }
                this.e = aVar;
                this.i = hVar.d;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements com.google.android.exoplayer2.f {
        public static final d f = new a().f();
        public static final String g = g86.w0(0);
        public static final String h = g86.w0(1);
        public static final String i = g86.w0(2);
        public static final String j = g86.w0(3);
        public static final String k = g86.w0(4);
        public static final f.a<e> l = new f.a() { // from class: zg3
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return p.d.c(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @IntRange(from = 0)
        public final long f5914a;
        public final long b;
        public final boolean c;
        public final boolean d;
        public final boolean e;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f5915a;
            public long b;
            public boolean c;
            public boolean d;
            public boolean e;

            public d f() {
                return g();
            }

            @Deprecated
            public e g() {
                return new e(this);
            }

            public a h(long j) {
                vh.a(j == Long.MIN_VALUE || j >= 0);
                this.b = j;
                return this;
            }

            public a i(boolean z) {
                this.d = z;
                return this;
            }

            public a j(boolean z) {
                this.c = z;
                return this;
            }

            public a k(@IntRange(from = 0) long j) {
                vh.a(j >= 0);
                this.f5915a = j;
                return this;
            }

            public a l(boolean z) {
                this.e = z;
                return this;
            }

            public a() {
                this.b = Long.MIN_VALUE;
            }

            public a(d dVar) {
                this.f5915a = dVar.f5914a;
                this.b = dVar.b;
                this.c = dVar.c;
                this.d = dVar.d;
                this.e = dVar.e;
            }
        }

        public static /* synthetic */ e c(Bundle bundle) {
            a aVar = new a();
            String str = g;
            d dVar = f;
            return aVar.k(bundle.getLong(str, dVar.f5914a)).h(bundle.getLong(h, dVar.b)).j(bundle.getBoolean(i, dVar.c)).i(bundle.getBoolean(j, dVar.d)).l(bundle.getBoolean(k, dVar.e)).g();
        }

        public a b() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f5914a == dVar.f5914a && this.b == dVar.b && this.c == dVar.c && this.d == dVar.d && this.e == dVar.e;
        }

        public int hashCode() {
            long j2 = this.f5914a;
            int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
            long j3 = this.b;
            return ((((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0);
        }

        @Override // com.google.android.exoplayer2.f
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            long j2 = this.f5914a;
            d dVar = f;
            if (j2 != dVar.f5914a) {
                bundle.putLong(g, j2);
            }
            long j3 = this.b;
            if (j3 != dVar.b) {
                bundle.putLong(h, j3);
            }
            boolean z = this.c;
            if (z != dVar.c) {
                bundle.putBoolean(i, z);
            }
            boolean z2 = this.d;
            if (z2 != dVar.d) {
                bundle.putBoolean(j, z2);
            }
            boolean z3 = this.e;
            if (z3 != dVar.e) {
                bundle.putBoolean(k, z3);
            }
            return bundle;
        }

        public d(a aVar) {
            this.f5914a = aVar.f5915a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Deprecated
    public static final class e extends d {
        public static final e m = new d.a().g();

        public e(d.a aVar) {
            super(aVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f implements com.google.android.exoplayer2.f {
        public static final String l = g86.w0(0);
        public static final String m = g86.w0(1);
        public static final String n = g86.w0(2);
        public static final String o = g86.w0(3);
        public static final String p = g86.w0(4);
        public static final String q = g86.w0(5);
        public static final String r = g86.w0(6);
        public static final String s = g86.w0(7);
        public static final f.a<f> t = new f.a() { // from class: ah3
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return p.f.d(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UUID f5916a;

        @Deprecated
        public final UUID b;

        @Nullable
        public final Uri c;

        @Deprecated
        public final ImmutableMap<String, String> d;
        public final ImmutableMap<String, String> e;
        public final boolean f;
        public final boolean g;
        public final boolean h;

        @Deprecated
        public final ImmutableList<Integer> i;
        public final ImmutableList<Integer> j;

        @Nullable
        public final byte[] k;

        public static f d(Bundle bundle) {
            UUID uuidFromString = UUID.fromString((String) vh.e(bundle.getString(l)));
            Uri uri = (Uri) bundle.getParcelable(m);
            ImmutableMap<String, String> immutableMapB = hv.b(hv.f(bundle, n, Bundle.EMPTY));
            boolean z = bundle.getBoolean(o, false);
            boolean z2 = bundle.getBoolean(p, false);
            boolean z3 = bundle.getBoolean(q, false);
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) hv.g(bundle, r, new ArrayList()));
            return new a(uuidFromString).n(uri).m(immutableMapB).o(z).j(z3).p(z2).k(immutableListCopyOf).l(bundle.getByteArray(s)).i();
        }

        public a c() {
            return new a();
        }

        @Nullable
        public byte[] e() {
            byte[] bArr = this.k;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f5916a.equals(fVar.f5916a) && g86.c(this.c, fVar.c) && g86.c(this.e, fVar.e) && this.f == fVar.f && this.h == fVar.h && this.g == fVar.g && this.j.equals(fVar.j) && Arrays.equals(this.k, fVar.k);
        }

        public int hashCode() {
            int iHashCode = this.f5916a.hashCode() * 31;
            Uri uri = this.c;
            return ((((((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.e.hashCode()) * 31) + (this.f ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + this.j.hashCode()) * 31) + Arrays.hashCode(this.k);
        }

        @Override // com.google.android.exoplayer2.f
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString(l, this.f5916a.toString());
            Uri uri = this.c;
            if (uri != null) {
                bundle.putParcelable(m, uri);
            }
            if (!this.e.isEmpty()) {
                bundle.putBundle(n, hv.h(this.e));
            }
            boolean z = this.f;
            if (z) {
                bundle.putBoolean(o, z);
            }
            boolean z2 = this.g;
            if (z2) {
                bundle.putBoolean(p, z2);
            }
            boolean z3 = this.h;
            if (z3) {
                bundle.putBoolean(q, z3);
            }
            if (!this.j.isEmpty()) {
                bundle.putIntegerArrayList(r, new ArrayList<>(this.j));
            }
            byte[] bArr = this.k;
            if (bArr != null) {
                bundle.putByteArray(s, bArr);
            }
            return bundle;
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            public UUID f5917a;

            @Nullable
            public Uri b;
            public ImmutableMap<String, String> c;
            public boolean d;
            public boolean e;
            public boolean f;
            public ImmutableList<Integer> g;

            @Nullable
            public byte[] h;

            public f i() {
                return new f(this);
            }

            public a j(boolean z) {
                this.f = z;
                return this;
            }

            public a k(List<Integer> list) {
                this.g = ImmutableList.copyOf((Collection) list);
                return this;
            }

            public a l(@Nullable byte[] bArr) {
                this.h = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
                return this;
            }

            public a m(Map<String, String> map) {
                this.c = ImmutableMap.copyOf((Map) map);
                return this;
            }

            public a n(@Nullable Uri uri) {
                this.b = uri;
                return this;
            }

            public a o(boolean z) {
                this.d = z;
                return this;
            }

            public a p(boolean z) {
                this.e = z;
                return this;
            }

            public a(UUID uuid) {
                this.f5917a = uuid;
                this.c = ImmutableMap.of();
                this.g = ImmutableList.of();
            }

            @Deprecated
            public a() {
                this.c = ImmutableMap.of();
                this.g = ImmutableList.of();
            }

            public a(f fVar) {
                this.f5917a = fVar.f5916a;
                this.b = fVar.c;
                this.c = fVar.e;
                this.d = fVar.f;
                this.e = fVar.g;
                this.f = fVar.h;
                this.g = fVar.j;
                this.h = fVar.k;
            }
        }

        public f(a aVar) {
            vh.g((aVar.f && aVar.b == null) ? false : true);
            UUID uuid = (UUID) vh.e(aVar.f5917a);
            this.f5916a = uuid;
            this.b = uuid;
            this.c = aVar.b;
            this.d = aVar.c;
            this.e = aVar.c;
            this.f = aVar.d;
            this.h = aVar.f;
            this.g = aVar.e;
            this.i = aVar.g;
            this.j = aVar.g;
            this.k = aVar.h != null ? Arrays.copyOf(aVar.h, aVar.h.length) : null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g implements com.google.android.exoplayer2.f {
        public static final g f = new a().f();
        public static final String g = g86.w0(0);
        public static final String h = g86.w0(1);
        public static final String i = g86.w0(2);
        public static final String j = g86.w0(3);
        public static final String k = g86.w0(4);
        public static final f.a<g> l = new f.a() { // from class: bh3
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return p.g.c(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f5918a;
        public final long b;
        public final long c;
        public final float d;
        public final float e;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f5919a;
            public long b;
            public long c;
            public float d;
            public float e;

            public g f() {
                return new g(this);
            }

            public a g(long j) {
                this.c = j;
                return this;
            }

            public a h(float f) {
                this.e = f;
                return this;
            }

            public a i(long j) {
                this.b = j;
                return this;
            }

            public a j(float f) {
                this.d = f;
                return this;
            }

            public a k(long j) {
                this.f5919a = j;
                return this;
            }

            public a() {
                this.f5919a = -9223372036854775807L;
                this.b = -9223372036854775807L;
                this.c = -9223372036854775807L;
                this.d = -3.4028235E38f;
                this.e = -3.4028235E38f;
            }

            public a(g gVar) {
                this.f5919a = gVar.f5918a;
                this.b = gVar.b;
                this.c = gVar.c;
                this.d = gVar.d;
                this.e = gVar.e;
            }
        }

        public static /* synthetic */ g c(Bundle bundle) {
            String str = g;
            g gVar = f;
            return new g(bundle.getLong(str, gVar.f5918a), bundle.getLong(h, gVar.b), bundle.getLong(i, gVar.c), bundle.getFloat(j, gVar.d), bundle.getFloat(k, gVar.e));
        }

        public a b() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f5918a == gVar.f5918a && this.b == gVar.b && this.c == gVar.c && this.d == gVar.d && this.e == gVar.e;
        }

        public int hashCode() {
            long j2 = this.f5918a;
            long j3 = this.b;
            int i2 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.c;
            int i3 = (i2 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            float f2 = this.d;
            int iFloatToIntBits = (i3 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
            float f3 = this.e;
            return iFloatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0);
        }

        @Override // com.google.android.exoplayer2.f
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            long j2 = this.f5918a;
            g gVar = f;
            if (j2 != gVar.f5918a) {
                bundle.putLong(g, j2);
            }
            long j3 = this.b;
            if (j3 != gVar.b) {
                bundle.putLong(h, j3);
            }
            long j4 = this.c;
            if (j4 != gVar.c) {
                bundle.putLong(i, j4);
            }
            float f2 = this.d;
            if (f2 != gVar.d) {
                bundle.putFloat(j, f2);
            }
            float f3 = this.e;
            if (f3 != gVar.e) {
                bundle.putFloat(k, f3);
            }
            return bundle;
        }

        public g(a aVar) {
            this(aVar.f5919a, aVar.b, aVar.c, aVar.d, aVar.e);
        }

        @Deprecated
        public g(long j2, long j3, long j4, float f2, float f3) {
            this.f5918a = j2;
            this.b = j3;
            this.c = j4;
            this.d = f2;
            this.e = f3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class h implements com.google.android.exoplayer2.f {
        public static final String j = g86.w0(0);
        public static final String k = g86.w0(1);
        public static final String l = g86.w0(2);
        public static final String m = g86.w0(3);
        public static final String n = g86.w0(4);
        public static final String o = g86.w0(5);
        public static final String p = g86.w0(6);
        public static final f.a<h> q = new f.a() { // from class: ch3
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return p.h.b(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f5920a;

        @Nullable
        public final String b;

        @Nullable
        public final f c;

        @Nullable
        public final b d;
        public final List<StreamKey> e;

        @Nullable
        public final String f;
        public final ImmutableList<k> g;

        @Deprecated
        public final List<j> h;

        @Nullable
        public final Object i;

        public static h b(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(l);
            f fVar = bundle2 == null ? null : (f) f.t.fromBundle(bundle2);
            Bundle bundle3 = bundle.getBundle(m);
            b bVar = bundle3 != null ? (b) b.d.fromBundle(bundle3) : null;
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(n);
            ImmutableList immutableListOf = parcelableArrayList == null ? ImmutableList.of() : hv.d(new f.a() { // from class: eh3
                @Override // com.google.android.exoplayer2.f.a
                public final f fromBundle(Bundle bundle4) {
                    return StreamKey.fromBundle(bundle4);
                }
            }, parcelableArrayList);
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(p);
            return new h((Uri) vh.e((Uri) bundle.getParcelable(j)), bundle.getString(k), fVar, bVar, immutableListOf, bundle.getString(o), parcelableArrayList2 == null ? ImmutableList.of() : hv.d(k.o, parcelableArrayList2), null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f5920a.equals(hVar.f5920a) && g86.c(this.b, hVar.b) && g86.c(this.c, hVar.c) && g86.c(this.d, hVar.d) && this.e.equals(hVar.e) && g86.c(this.f, hVar.f) && this.g.equals(hVar.g) && g86.c(this.i, hVar.i);
        }

        public int hashCode() {
            int iHashCode = this.f5920a.hashCode() * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.c;
            int iHashCode3 = (iHashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 31;
            b bVar = this.d;
            int iHashCode4 = (((iHashCode3 + (bVar == null ? 0 : bVar.hashCode())) * 31) + this.e.hashCode()) * 31;
            String str2 = this.f;
            int iHashCode5 = (((iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.g.hashCode()) * 31;
            Object obj = this.i;
            return iHashCode5 + (obj != null ? obj.hashCode() : 0);
        }

        @Override // com.google.android.exoplayer2.f
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(j, this.f5920a);
            String str = this.b;
            if (str != null) {
                bundle.putString(k, str);
            }
            f fVar = this.c;
            if (fVar != null) {
                bundle.putBundle(l, fVar.toBundle());
            }
            b bVar = this.d;
            if (bVar != null) {
                bundle.putBundle(m, bVar.toBundle());
            }
            if (!this.e.isEmpty()) {
                bundle.putParcelableArrayList(n, hv.i(this.e));
            }
            String str2 = this.f;
            if (str2 != null) {
                bundle.putString(o, str2);
            }
            if (!this.g.isEmpty()) {
                bundle.putParcelableArrayList(p, hv.i(this.g));
            }
            return bundle;
        }

        public h(Uri uri, @Nullable String str, @Nullable f fVar, @Nullable b bVar, List<StreamKey> list, @Nullable String str2, ImmutableList<k> immutableList, @Nullable Object obj) {
            this.f5920a = uri;
            this.b = str;
            this.c = fVar;
            this.d = bVar;
            this.e = list;
            this.f = str2;
            this.g = immutableList;
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (int i = 0; i < immutableList.size(); i++) {
                aVarBuilder.a(immutableList.get(i).b().j());
            }
            this.h = aVarBuilder.e();
            this.i = obj;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class i implements com.google.android.exoplayer2.f {
        public static final i d = new a().d();
        public static final String e = g86.w0(0);
        public static final String f = g86.w0(1);
        public static final String g = g86.w0(2);
        public static final f.a<i> h = new f.a() { // from class: ih3
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return p.i.b(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Uri f5921a;

        @Nullable
        public final String b;

        @Nullable
        public final Bundle c;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            public Uri f5922a;

            @Nullable
            public String b;

            @Nullable
            public Bundle c;

            public i d() {
                return new i(this);
            }

            public a e(@Nullable Bundle bundle) {
                this.c = bundle;
                return this;
            }

            public a f(@Nullable Uri uri) {
                this.f5922a = uri;
                return this;
            }

            public a g(@Nullable String str) {
                this.b = str;
                return this;
            }
        }

        public static /* synthetic */ i b(Bundle bundle) {
            return new a().f((Uri) bundle.getParcelable(e)).g(bundle.getString(f)).e(bundle.getBundle(g)).d();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return g86.c(this.f5921a, iVar.f5921a) && g86.c(this.b, iVar.b);
        }

        public int hashCode() {
            Uri uri = this.f5921a;
            int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.b;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        @Override // com.google.android.exoplayer2.f
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            Uri uri = this.f5921a;
            if (uri != null) {
                bundle.putParcelable(e, uri);
            }
            String str = this.b;
            if (str != null) {
                bundle.putString(f, str);
            }
            Bundle bundle2 = this.c;
            if (bundle2 != null) {
                bundle.putBundle(g, bundle2);
            }
            return bundle;
        }

        public i(a aVar) {
            this.f5921a = aVar.f5922a;
            this.b = aVar.b;
            this.c = aVar.c;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Deprecated
    public static final class j extends k {
        public j(k.a aVar) {
            super(aVar);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k implements com.google.android.exoplayer2.f {
        public static final String h = g86.w0(0);
        public static final String i = g86.w0(1);
        public static final String j = g86.w0(2);
        public static final String k = g86.w0(3);
        public static final String l = g86.w0(4);
        public static final String m = g86.w0(5);
        public static final String n = g86.w0(6);
        public static final f.a<k> o = new f.a() { // from class: jh3
            @Override // com.google.android.exoplayer2.f.a
            public final f fromBundle(Bundle bundle) {
                return p.k.c(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f5923a;

        @Nullable
        public final String b;

        @Nullable
        public final String c;
        public final int d;
        public final int e;

        @Nullable
        public final String f;

        @Nullable
        public final String g;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Uri f5924a;

            @Nullable
            public String b;

            @Nullable
            public String c;
            public int d;
            public int e;

            @Nullable
            public String f;

            @Nullable
            public String g;

            public k i() {
                return new k(this);
            }

            public final j j() {
                return new j(this);
            }

            public a k(@Nullable String str) {
                this.g = str;
                return this;
            }

            public a l(@Nullable String str) {
                this.f = str;
                return this;
            }

            public a m(@Nullable String str) {
                this.c = str;
                return this;
            }

            public a n(@Nullable String str) {
                this.b = str;
                return this;
            }

            public a o(int i) {
                this.e = i;
                return this;
            }

            public a p(int i) {
                this.d = i;
                return this;
            }

            public a(Uri uri) {
                this.f5924a = uri;
            }

            public a(k kVar) {
                this.f5924a = kVar.f5923a;
                this.b = kVar.b;
                this.c = kVar.c;
                this.d = kVar.d;
                this.e = kVar.e;
                this.f = kVar.f;
                this.g = kVar.g;
            }
        }

        public static k c(Bundle bundle) {
            Uri uri = (Uri) vh.e((Uri) bundle.getParcelable(h));
            String string = bundle.getString(i);
            String string2 = bundle.getString(j);
            int i2 = bundle.getInt(k, 0);
            int i3 = bundle.getInt(l, 0);
            String string3 = bundle.getString(m);
            return new a(uri).n(string).m(string2).p(i2).o(i3).l(string3).k(bundle.getString(n)).i();
        }

        public a b() {
            return new a();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return this.f5923a.equals(kVar.f5923a) && g86.c(this.b, kVar.b) && g86.c(this.c, kVar.c) && this.d == kVar.d && this.e == kVar.e && g86.c(this.f, kVar.f) && g86.c(this.g, kVar.g);
        }

        public int hashCode() {
            int iHashCode = this.f5923a.hashCode() * 31;
            String str = this.b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.c;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.d) * 31) + this.e) * 31;
            String str3 = this.f;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.g;
            return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        }

        @Override // com.google.android.exoplayer2.f
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(h, this.f5923a);
            String str = this.b;
            if (str != null) {
                bundle.putString(i, str);
            }
            String str2 = this.c;
            if (str2 != null) {
                bundle.putString(j, str2);
            }
            int i2 = this.d;
            if (i2 != 0) {
                bundle.putInt(k, i2);
            }
            int i3 = this.e;
            if (i3 != 0) {
                bundle.putInt(l, i3);
            }
            String str3 = this.f;
            if (str3 != null) {
                bundle.putString(m, str3);
            }
            String str4 = this.g;
            if (str4 != null) {
                bundle.putString(n, str4);
            }
            return bundle;
        }

        public k(a aVar) {
            this.f5923a = aVar.f5924a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
            this.g = aVar.g;
        }
    }

    public static p c(Bundle bundle) {
        String str = (String) vh.e(bundle.getString(j, ""));
        Bundle bundle2 = bundle.getBundle(k);
        g gVar = bundle2 == null ? g.f : (g) g.l.fromBundle(bundle2);
        Bundle bundle3 = bundle.getBundle(l);
        q qVar = bundle3 == null ? q.J : (q) q.v0.fromBundle(bundle3);
        Bundle bundle4 = bundle.getBundle(m);
        e eVar = bundle4 == null ? e.m : (e) d.l.fromBundle(bundle4);
        Bundle bundle5 = bundle.getBundle(n);
        i iVar = bundle5 == null ? i.d : (i) i.h.fromBundle(bundle5);
        Bundle bundle6 = bundle.getBundle(o);
        return new p(str, eVar, bundle6 == null ? null : (h) h.q.fromBundle(bundle6), gVar, qVar, iVar);
    }

    public static p d(String str) {
        return new c().j(str).a();
    }

    public c b() {
        return new c();
    }

    public final Bundle e(boolean z) {
        h hVar;
        Bundle bundle = new Bundle();
        if (!this.f5910a.equals("")) {
            bundle.putString(j, this.f5910a);
        }
        if (!this.d.equals(g.f)) {
            bundle.putBundle(k, this.d.toBundle());
        }
        if (!this.e.equals(q.J)) {
            bundle.putBundle(l, this.e.toBundle());
        }
        if (!this.f.equals(d.f)) {
            bundle.putBundle(m, this.f.toBundle());
        }
        if (!this.h.equals(i.d)) {
            bundle.putBundle(n, this.h.toBundle());
        }
        if (z && (hVar = this.b) != null) {
            bundle.putBundle(o, hVar.toBundle());
        }
        return bundle;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return g86.c(this.f5910a, pVar.f5910a) && this.f.equals(pVar.f) && g86.c(this.b, pVar.b) && g86.c(this.d, pVar.d) && g86.c(this.e, pVar.e) && g86.c(this.h, pVar.h);
    }

    public int hashCode() {
        int iHashCode = this.f5910a.hashCode() * 31;
        h hVar = this.b;
        return ((((((((iHashCode + (hVar != null ? hVar.hashCode() : 0)) * 31) + this.d.hashCode()) * 31) + this.f.hashCode()) * 31) + this.e.hashCode()) * 31) + this.h.hashCode();
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        return e(false);
    }

    public p(String str, e eVar, @Nullable h hVar, g gVar, q qVar, i iVar) {
        this.f5910a = str;
        this.b = hVar;
        this.c = hVar;
        this.d = gVar;
        this.e = qVar;
        this.f = eVar;
        this.g = eVar;
        this.h = iVar;
    }
}
