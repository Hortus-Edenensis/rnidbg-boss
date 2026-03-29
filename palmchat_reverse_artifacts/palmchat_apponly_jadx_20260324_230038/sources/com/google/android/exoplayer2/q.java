package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.q;
import defpackage.g86;
import defpackage.m54;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class q implements f {
    public static final q J = new b().H();
    public static final String K = g86.w0(0);
    public static final String L = g86.w0(1);
    public static final String M = g86.w0(2);
    public static final String N = g86.w0(3);
    public static final String O = g86.w0(4);
    public static final String P = g86.w0(5);
    public static final String Q = g86.w0(6);
    public static final String R = g86.w0(8);
    public static final String S = g86.w0(9);
    public static final String T = g86.w0(10);
    public static final String U = g86.w0(11);
    public static final String V = g86.w0(12);
    public static final String W = g86.w0(13);
    public static final String X = g86.w0(14);
    public static final String Y = g86.w0(15);
    public static final String Z = g86.w0(16);
    public static final String e0 = g86.w0(17);
    public static final String f0 = g86.w0(18);
    public static final String g0 = g86.w0(19);
    public static final String h0 = g86.w0(20);
    public static final String i0 = g86.w0(21);
    public static final String j0 = g86.w0(22);
    public static final String k0 = g86.w0(23);
    public static final String l0 = g86.w0(24);
    public static final String m0 = g86.w0(25);
    public static final String n0 = g86.w0(26);
    public static final String o0 = g86.w0(27);
    public static final String p0 = g86.w0(28);
    public static final String q0 = g86.w0(29);
    public static final String r0 = g86.w0(30);
    public static final String s0 = g86.w0(31);
    public static final String t0 = g86.w0(32);
    public static final String u0 = g86.w0(1000);
    public static final f.a<q> v0 = new f.a() { // from class: mh3
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return q.c(bundle);
        }
    };

    @Nullable
    public final CharSequence A;

    @Nullable
    public final Integer B;

    @Nullable
    public final Integer C;

    @Nullable
    public final CharSequence E;

    @Nullable
    public final CharSequence F;

    @Nullable
    public final CharSequence G;

    @Nullable
    public final Integer H;

    @Nullable
    public final Bundle I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final CharSequence f5925a;

    @Nullable
    public final CharSequence b;

    @Nullable
    public final CharSequence c;

    @Nullable
    public final CharSequence d;

    @Nullable
    public final CharSequence e;

    @Nullable
    public final CharSequence f;

    @Nullable
    public final CharSequence g;

    @Nullable
    public final y h;

    @Nullable
    public final y i;

    @Nullable
    public final byte[] j;

    @Nullable
    public final Integer k;

    @Nullable
    public final Uri l;

    @Nullable
    public final Integer m;

    @Nullable
    public final Integer n;

    @Nullable
    @Deprecated
    public final Integer o;

    @Nullable
    public final Boolean p;

    @Nullable
    public final Boolean q;

    @Nullable
    @Deprecated
    public final Integer r;

    @Nullable
    public final Integer s;

    @Nullable
    public final Integer t;

    @Nullable
    public final Integer u;

    @Nullable
    public final Integer v;

    @Nullable
    public final Integer w;

    @Nullable
    public final Integer x;

    @Nullable
    public final CharSequence y;

    @Nullable
    public final CharSequence z;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        @Nullable
        public Integer A;

        @Nullable
        public Integer B;

        @Nullable
        public CharSequence C;

        @Nullable
        public CharSequence D;

        @Nullable
        public CharSequence E;

        @Nullable
        public Integer F;

        @Nullable
        public Bundle G;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public CharSequence f5926a;

        @Nullable
        public CharSequence b;

        @Nullable
        public CharSequence c;

        @Nullable
        public CharSequence d;

        @Nullable
        public CharSequence e;

        @Nullable
        public CharSequence f;

        @Nullable
        public CharSequence g;

        @Nullable
        public y h;

        @Nullable
        public y i;

        @Nullable
        public byte[] j;

        @Nullable
        public Integer k;

        @Nullable
        public Uri l;

        @Nullable
        public Integer m;

        @Nullable
        public Integer n;

        @Nullable
        public Integer o;

        @Nullable
        public Boolean p;

        @Nullable
        public Boolean q;

        @Nullable
        public Integer r;

        @Nullable
        public Integer s;

        @Nullable
        public Integer t;

        @Nullable
        public Integer u;

        @Nullable
        public Integer v;

        @Nullable
        public Integer w;

        @Nullable
        public CharSequence x;

        @Nullable
        public CharSequence y;

        @Nullable
        public CharSequence z;

        public q H() {
            return new q(this);
        }

        public b I(byte[] bArr, int i) {
            if (this.j == null || g86.c(Integer.valueOf(i), 3) || !g86.c(this.k, 3)) {
                this.j = (byte[]) bArr.clone();
                this.k = Integer.valueOf(i);
            }
            return this;
        }

        public b J(@Nullable q qVar) {
            if (qVar == null) {
                return this;
            }
            CharSequence charSequence = qVar.f5925a;
            if (charSequence != null) {
                m0(charSequence);
            }
            CharSequence charSequence2 = qVar.b;
            if (charSequence2 != null) {
                O(charSequence2);
            }
            CharSequence charSequence3 = qVar.c;
            if (charSequence3 != null) {
                N(charSequence3);
            }
            CharSequence charSequence4 = qVar.d;
            if (charSequence4 != null) {
                M(charSequence4);
            }
            CharSequence charSequence5 = qVar.e;
            if (charSequence5 != null) {
                W(charSequence5);
            }
            CharSequence charSequence6 = qVar.f;
            if (charSequence6 != null) {
                l0(charSequence6);
            }
            CharSequence charSequence7 = qVar.g;
            if (charSequence7 != null) {
                U(charSequence7);
            }
            y yVar = qVar.h;
            if (yVar != null) {
                q0(yVar);
            }
            y yVar2 = qVar.i;
            if (yVar2 != null) {
                d0(yVar2);
            }
            byte[] bArr = qVar.j;
            if (bArr != null) {
                P(bArr, qVar.k);
            }
            Uri uri = qVar.l;
            if (uri != null) {
                Q(uri);
            }
            Integer num = qVar.m;
            if (num != null) {
                p0(num);
            }
            Integer num2 = qVar.n;
            if (num2 != null) {
                o0(num2);
            }
            Integer num3 = qVar.o;
            if (num3 != null) {
                Y(num3);
            }
            Boolean bool = qVar.p;
            if (bool != null) {
                a0(bool);
            }
            Boolean bool2 = qVar.q;
            if (bool2 != null) {
                b0(bool2);
            }
            Integer num4 = qVar.r;
            if (num4 != null) {
                g0(num4);
            }
            Integer num5 = qVar.s;
            if (num5 != null) {
                g0(num5);
            }
            Integer num6 = qVar.t;
            if (num6 != null) {
                f0(num6);
            }
            Integer num7 = qVar.u;
            if (num7 != null) {
                e0(num7);
            }
            Integer num8 = qVar.v;
            if (num8 != null) {
                j0(num8);
            }
            Integer num9 = qVar.w;
            if (num9 != null) {
                i0(num9);
            }
            Integer num10 = qVar.x;
            if (num10 != null) {
                h0(num10);
            }
            CharSequence charSequence8 = qVar.y;
            if (charSequence8 != null) {
                r0(charSequence8);
            }
            CharSequence charSequence9 = qVar.z;
            if (charSequence9 != null) {
                S(charSequence9);
            }
            CharSequence charSequence10 = qVar.A;
            if (charSequence10 != null) {
                T(charSequence10);
            }
            Integer num11 = qVar.B;
            if (num11 != null) {
                V(num11);
            }
            Integer num12 = qVar.C;
            if (num12 != null) {
                n0(num12);
            }
            CharSequence charSequence11 = qVar.E;
            if (charSequence11 != null) {
                Z(charSequence11);
            }
            CharSequence charSequence12 = qVar.F;
            if (charSequence12 != null) {
                R(charSequence12);
            }
            CharSequence charSequence13 = qVar.G;
            if (charSequence13 != null) {
                k0(charSequence13);
            }
            Integer num13 = qVar.H;
            if (num13 != null) {
                c0(num13);
            }
            Bundle bundle = qVar.I;
            if (bundle != null) {
                X(bundle);
            }
            return this;
        }

        public b K(Metadata metadata) {
            for (int i = 0; i < metadata.length(); i++) {
                metadata.get(i).populateMediaMetadata(this);
            }
            return this;
        }

        public b L(List<Metadata> list) {
            for (int i = 0; i < list.size(); i++) {
                Metadata metadata = list.get(i);
                for (int i2 = 0; i2 < metadata.length(); i2++) {
                    metadata.get(i2).populateMediaMetadata(this);
                }
            }
            return this;
        }

        public b M(@Nullable CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }

        public b N(@Nullable CharSequence charSequence) {
            this.c = charSequence;
            return this;
        }

        public b O(@Nullable CharSequence charSequence) {
            this.b = charSequence;
            return this;
        }

        public b P(@Nullable byte[] bArr, @Nullable Integer num) {
            this.j = bArr == null ? null : (byte[]) bArr.clone();
            this.k = num;
            return this;
        }

        public b Q(@Nullable Uri uri) {
            this.l = uri;
            return this;
        }

        public b R(@Nullable CharSequence charSequence) {
            this.D = charSequence;
            return this;
        }

        public b S(@Nullable CharSequence charSequence) {
            this.y = charSequence;
            return this;
        }

        public b T(@Nullable CharSequence charSequence) {
            this.z = charSequence;
            return this;
        }

        public b U(@Nullable CharSequence charSequence) {
            this.g = charSequence;
            return this;
        }

        public b V(@Nullable Integer num) {
            this.A = num;
            return this;
        }

        public b W(@Nullable CharSequence charSequence) {
            this.e = charSequence;
            return this;
        }

        public b X(@Nullable Bundle bundle) {
            this.G = bundle;
            return this;
        }

        @Deprecated
        public b Y(@Nullable Integer num) {
            this.o = num;
            return this;
        }

        public b Z(@Nullable CharSequence charSequence) {
            this.C = charSequence;
            return this;
        }

        public b a0(@Nullable Boolean bool) {
            this.p = bool;
            return this;
        }

        public b b0(@Nullable Boolean bool) {
            this.q = bool;
            return this;
        }

        public b c0(@Nullable Integer num) {
            this.F = num;
            return this;
        }

        public b d0(@Nullable y yVar) {
            this.i = yVar;
            return this;
        }

        public b e0(@IntRange(from = 1, to = 31) @Nullable Integer num) {
            this.t = num;
            return this;
        }

        public b f0(@IntRange(from = 1, to = 12) @Nullable Integer num) {
            this.s = num;
            return this;
        }

        public b g0(@Nullable Integer num) {
            this.r = num;
            return this;
        }

        public b h0(@IntRange(from = 1, to = 31) @Nullable Integer num) {
            this.w = num;
            return this;
        }

        public b i0(@IntRange(from = 1, to = 12) @Nullable Integer num) {
            this.v = num;
            return this;
        }

        public b j0(@Nullable Integer num) {
            this.u = num;
            return this;
        }

        public b k0(@Nullable CharSequence charSequence) {
            this.E = charSequence;
            return this;
        }

        public b l0(@Nullable CharSequence charSequence) {
            this.f = charSequence;
            return this;
        }

        public b m0(@Nullable CharSequence charSequence) {
            this.f5926a = charSequence;
            return this;
        }

        public b n0(@Nullable Integer num) {
            this.B = num;
            return this;
        }

        public b o0(@Nullable Integer num) {
            this.n = num;
            return this;
        }

        public b p0(@Nullable Integer num) {
            this.m = num;
            return this;
        }

        public b q0(@Nullable y yVar) {
            this.h = yVar;
            return this;
        }

        public b r0(@Nullable CharSequence charSequence) {
            this.x = charSequence;
            return this;
        }

        public b() {
        }

        public b(q qVar) {
            this.f5926a = qVar.f5925a;
            this.b = qVar.b;
            this.c = qVar.c;
            this.d = qVar.d;
            this.e = qVar.e;
            this.f = qVar.f;
            this.g = qVar.g;
            this.h = qVar.h;
            this.i = qVar.i;
            this.j = qVar.j;
            this.k = qVar.k;
            this.l = qVar.l;
            this.m = qVar.m;
            this.n = qVar.n;
            this.o = qVar.o;
            this.p = qVar.p;
            this.q = qVar.q;
            this.r = qVar.s;
            this.s = qVar.t;
            this.t = qVar.u;
            this.u = qVar.v;
            this.v = qVar.w;
            this.w = qVar.x;
            this.x = qVar.y;
            this.y = qVar.z;
            this.z = qVar.A;
            this.A = qVar.B;
            this.B = qVar.C;
            this.C = qVar.E;
            this.D = qVar.F;
            this.E = qVar.G;
            this.F = qVar.H;
            this.G = qVar.I;
        }
    }

    public static q c(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        b bVar = new b();
        b bVarU = bVar.m0(bundle.getCharSequence(K)).O(bundle.getCharSequence(L)).N(bundle.getCharSequence(M)).M(bundle.getCharSequence(N)).W(bundle.getCharSequence(O)).l0(bundle.getCharSequence(P)).U(bundle.getCharSequence(Q));
        byte[] byteArray = bundle.getByteArray(T);
        String str = q0;
        bVarU.P(byteArray, bundle.containsKey(str) ? Integer.valueOf(bundle.getInt(str)) : null).Q((Uri) bundle.getParcelable(U)).r0(bundle.getCharSequence(j0)).S(bundle.getCharSequence(k0)).T(bundle.getCharSequence(l0)).Z(bundle.getCharSequence(o0)).R(bundle.getCharSequence(p0)).k0(bundle.getCharSequence(r0)).X(bundle.getBundle(u0));
        String str2 = R;
        if (bundle.containsKey(str2) && (bundle3 = bundle.getBundle(str2)) != null) {
            bVar.q0((y) y.b.fromBundle(bundle3));
        }
        String str3 = S;
        if (bundle.containsKey(str3) && (bundle2 = bundle.getBundle(str3)) != null) {
            bVar.d0((y) y.b.fromBundle(bundle2));
        }
        String str4 = V;
        if (bundle.containsKey(str4)) {
            bVar.p0(Integer.valueOf(bundle.getInt(str4)));
        }
        String str5 = W;
        if (bundle.containsKey(str5)) {
            bVar.o0(Integer.valueOf(bundle.getInt(str5)));
        }
        String str6 = X;
        if (bundle.containsKey(str6)) {
            bVar.Y(Integer.valueOf(bundle.getInt(str6)));
        }
        String str7 = t0;
        if (bundle.containsKey(str7)) {
            bVar.a0(Boolean.valueOf(bundle.getBoolean(str7)));
        }
        String str8 = Y;
        if (bundle.containsKey(str8)) {
            bVar.b0(Boolean.valueOf(bundle.getBoolean(str8)));
        }
        String str9 = Z;
        if (bundle.containsKey(str9)) {
            bVar.g0(Integer.valueOf(bundle.getInt(str9)));
        }
        String str10 = e0;
        if (bundle.containsKey(str10)) {
            bVar.f0(Integer.valueOf(bundle.getInt(str10)));
        }
        String str11 = f0;
        if (bundle.containsKey(str11)) {
            bVar.e0(Integer.valueOf(bundle.getInt(str11)));
        }
        String str12 = g0;
        if (bundle.containsKey(str12)) {
            bVar.j0(Integer.valueOf(bundle.getInt(str12)));
        }
        String str13 = h0;
        if (bundle.containsKey(str13)) {
            bVar.i0(Integer.valueOf(bundle.getInt(str13)));
        }
        String str14 = i0;
        if (bundle.containsKey(str14)) {
            bVar.h0(Integer.valueOf(bundle.getInt(str14)));
        }
        String str15 = m0;
        if (bundle.containsKey(str15)) {
            bVar.V(Integer.valueOf(bundle.getInt(str15)));
        }
        String str16 = n0;
        if (bundle.containsKey(str16)) {
            bVar.n0(Integer.valueOf(bundle.getInt(str16)));
        }
        String str17 = s0;
        if (bundle.containsKey(str17)) {
            bVar.c0(Integer.valueOf(bundle.getInt(str17)));
        }
        return bVar.H();
    }

    public static int d(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                return 1;
            case 20:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            default:
                return 0;
            case 21:
                return 2;
            case 22:
                return 3;
            case 23:
                return 4;
            case 24:
                return 5;
            case 25:
                return 6;
        }
    }

    public static int e(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 21;
            case 3:
                return 22;
            case 4:
                return 23;
            case 5:
                return 24;
            case 6:
                return 25;
            default:
                return 20;
        }
    }

    public b b() {
        return new b();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        return g86.c(this.f5925a, qVar.f5925a) && g86.c(this.b, qVar.b) && g86.c(this.c, qVar.c) && g86.c(this.d, qVar.d) && g86.c(this.e, qVar.e) && g86.c(this.f, qVar.f) && g86.c(this.g, qVar.g) && g86.c(this.h, qVar.h) && g86.c(this.i, qVar.i) && Arrays.equals(this.j, qVar.j) && g86.c(this.k, qVar.k) && g86.c(this.l, qVar.l) && g86.c(this.m, qVar.m) && g86.c(this.n, qVar.n) && g86.c(this.o, qVar.o) && g86.c(this.p, qVar.p) && g86.c(this.q, qVar.q) && g86.c(this.s, qVar.s) && g86.c(this.t, qVar.t) && g86.c(this.u, qVar.u) && g86.c(this.v, qVar.v) && g86.c(this.w, qVar.w) && g86.c(this.x, qVar.x) && g86.c(this.y, qVar.y) && g86.c(this.z, qVar.z) && g86.c(this.A, qVar.A) && g86.c(this.B, qVar.B) && g86.c(this.C, qVar.C) && g86.c(this.E, qVar.E) && g86.c(this.F, qVar.F) && g86.c(this.G, qVar.G) && g86.c(this.H, qVar.H);
    }

    public int hashCode() {
        return m54.b(this.f5925a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, Integer.valueOf(Arrays.hashCode(this.j)), this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.E, this.F, this.G, this.H);
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.f5925a;
        if (charSequence != null) {
            bundle.putCharSequence(K, charSequence);
        }
        CharSequence charSequence2 = this.b;
        if (charSequence2 != null) {
            bundle.putCharSequence(L, charSequence2);
        }
        CharSequence charSequence3 = this.c;
        if (charSequence3 != null) {
            bundle.putCharSequence(M, charSequence3);
        }
        CharSequence charSequence4 = this.d;
        if (charSequence4 != null) {
            bundle.putCharSequence(N, charSequence4);
        }
        CharSequence charSequence5 = this.e;
        if (charSequence5 != null) {
            bundle.putCharSequence(O, charSequence5);
        }
        CharSequence charSequence6 = this.f;
        if (charSequence6 != null) {
            bundle.putCharSequence(P, charSequence6);
        }
        CharSequence charSequence7 = this.g;
        if (charSequence7 != null) {
            bundle.putCharSequence(Q, charSequence7);
        }
        byte[] bArr = this.j;
        if (bArr != null) {
            bundle.putByteArray(T, bArr);
        }
        Uri uri = this.l;
        if (uri != null) {
            bundle.putParcelable(U, uri);
        }
        CharSequence charSequence8 = this.y;
        if (charSequence8 != null) {
            bundle.putCharSequence(j0, charSequence8);
        }
        CharSequence charSequence9 = this.z;
        if (charSequence9 != null) {
            bundle.putCharSequence(k0, charSequence9);
        }
        CharSequence charSequence10 = this.A;
        if (charSequence10 != null) {
            bundle.putCharSequence(l0, charSequence10);
        }
        CharSequence charSequence11 = this.E;
        if (charSequence11 != null) {
            bundle.putCharSequence(o0, charSequence11);
        }
        CharSequence charSequence12 = this.F;
        if (charSequence12 != null) {
            bundle.putCharSequence(p0, charSequence12);
        }
        CharSequence charSequence13 = this.G;
        if (charSequence13 != null) {
            bundle.putCharSequence(r0, charSequence13);
        }
        y yVar = this.h;
        if (yVar != null) {
            bundle.putBundle(R, yVar.toBundle());
        }
        y yVar2 = this.i;
        if (yVar2 != null) {
            bundle.putBundle(S, yVar2.toBundle());
        }
        Integer num = this.m;
        if (num != null) {
            bundle.putInt(V, num.intValue());
        }
        Integer num2 = this.n;
        if (num2 != null) {
            bundle.putInt(W, num2.intValue());
        }
        Integer num3 = this.o;
        if (num3 != null) {
            bundle.putInt(X, num3.intValue());
        }
        Boolean bool = this.p;
        if (bool != null) {
            bundle.putBoolean(t0, bool.booleanValue());
        }
        Boolean bool2 = this.q;
        if (bool2 != null) {
            bundle.putBoolean(Y, bool2.booleanValue());
        }
        Integer num4 = this.s;
        if (num4 != null) {
            bundle.putInt(Z, num4.intValue());
        }
        Integer num5 = this.t;
        if (num5 != null) {
            bundle.putInt(e0, num5.intValue());
        }
        Integer num6 = this.u;
        if (num6 != null) {
            bundle.putInt(f0, num6.intValue());
        }
        Integer num7 = this.v;
        if (num7 != null) {
            bundle.putInt(g0, num7.intValue());
        }
        Integer num8 = this.w;
        if (num8 != null) {
            bundle.putInt(h0, num8.intValue());
        }
        Integer num9 = this.x;
        if (num9 != null) {
            bundle.putInt(i0, num9.intValue());
        }
        Integer num10 = this.B;
        if (num10 != null) {
            bundle.putInt(m0, num10.intValue());
        }
        Integer num11 = this.C;
        if (num11 != null) {
            bundle.putInt(n0, num11.intValue());
        }
        Integer num12 = this.k;
        if (num12 != null) {
            bundle.putInt(q0, num12.intValue());
        }
        Integer num13 = this.H;
        if (num13 != null) {
            bundle.putInt(s0, num13.intValue());
        }
        Bundle bundle2 = this.I;
        if (bundle2 != null) {
            bundle.putBundle(u0, bundle2);
        }
        return bundle;
    }

    public q(b bVar) {
        Boolean boolValueOf = bVar.p;
        Integer numValueOf = bVar.o;
        Integer numValueOf2 = bVar.F;
        if (boolValueOf != null) {
            if (!boolValueOf.booleanValue()) {
                numValueOf = -1;
            } else if (numValueOf == null || numValueOf.intValue() == -1) {
                numValueOf = Integer.valueOf(numValueOf2 != null ? d(numValueOf2.intValue()) : 0);
            }
        } else if (numValueOf != null) {
            boolValueOf = Boolean.valueOf(numValueOf.intValue() != -1);
            if (boolValueOf.booleanValue() && numValueOf2 == null) {
                numValueOf2 = Integer.valueOf(e(numValueOf.intValue()));
            }
        }
        this.f5925a = bVar.f5926a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
        this.m = bVar.m;
        this.n = bVar.n;
        this.o = numValueOf;
        this.p = boolValueOf;
        this.q = bVar.q;
        this.r = bVar.r;
        this.s = bVar.r;
        this.t = bVar.s;
        this.u = bVar.t;
        this.v = bVar.u;
        this.w = bVar.v;
        this.x = bVar.w;
        this.y = bVar.x;
        this.z = bVar.y;
        this.A = bVar.z;
        this.B = bVar.A;
        this.C = bVar.B;
        this.E = bVar.C;
        this.F = bVar.D;
        this.G = bVar.E;
        this.H = numValueOf2;
        this.I = bVar.G;
    }
}
