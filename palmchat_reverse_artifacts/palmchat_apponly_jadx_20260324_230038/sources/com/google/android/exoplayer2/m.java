package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.baidu.platform.comapi.map.MapController;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import defpackage.fp3;
import defpackage.g86;
import defpackage.hv;
import defpackage.qy2;
import defpackage.xg0;
import defpackage.zv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class m implements f {
    public static final m J = new b().G();
    public static final String K = g86.w0(0);
    public static final String L = g86.w0(1);
    public static final String M = g86.w0(2);
    public static final String N = g86.w0(3);
    public static final String O = g86.w0(4);
    public static final String P = g86.w0(5);
    public static final String Q = g86.w0(6);
    public static final String R = g86.w0(7);
    public static final String S = g86.w0(8);
    public static final String T = g86.w0(9);
    public static final String U = g86.w0(10);
    public static final String V = g86.w0(11);
    public static final String W = g86.w0(12);
    public static final String X = g86.w0(13);
    public static final String Y = g86.w0(14);
    public static final String Z = g86.w0(15);
    public static final String e0 = g86.w0(16);
    public static final String f0 = g86.w0(17);
    public static final String g0 = g86.w0(18);
    public static final String h0 = g86.w0(19);
    public static final String i0 = g86.w0(20);
    public static final String j0 = g86.w0(21);
    public static final String k0 = g86.w0(22);
    public static final String l0 = g86.w0(23);
    public static final String m0 = g86.w0(24);
    public static final String n0 = g86.w0(25);
    public static final String o0 = g86.w0(26);
    public static final String p0 = g86.w0(27);
    public static final String q0 = g86.w0(28);
    public static final String r0 = g86.w0(29);
    public static final String s0 = g86.w0(30);
    public static final String t0 = g86.w0(31);
    public static final f.a<m> u0 = new f.a() { // from class: a12
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return m.e(bundle);
        }
    };
    public final int A;
    public final int B;
    public final int C;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public int I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f5892a;

    @Nullable
    public final String b;

    @Nullable
    public final String c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;

    @Nullable
    public final String i;

    @Nullable
    public final Metadata j;

    @Nullable
    public final String k;

    @Nullable
    public final String l;
    public final int m;
    public final List<byte[]> n;

    @Nullable
    public final DrmInitData o;
    public final long p;
    public final int q;
    public final int r;
    public final float s;
    public final int t;
    public final float u;

    @Nullable
    public final byte[] v;
    public final int w;

    @Nullable
    public final xg0 x;
    public final int y;
    public final int z;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public String f5893a;

        @Nullable
        public String b;

        @Nullable
        public String c;
        public int d;
        public int e;
        public int f;
        public int g;

        @Nullable
        public String h;

        @Nullable
        public Metadata i;

        @Nullable
        public String j;

        @Nullable
        public String k;
        public int l;

        @Nullable
        public List<byte[]> m;

        @Nullable
        public DrmInitData n;
        public long o;
        public int p;
        public int q;
        public float r;
        public int s;
        public float t;

        @Nullable
        public byte[] u;
        public int v;

        @Nullable
        public xg0 w;
        public int x;
        public int y;
        public int z;

        public m G() {
            return new m(this);
        }

        public b H(int i) {
            this.C = i;
            return this;
        }

        public b I(int i) {
            this.f = i;
            return this;
        }

        public b J(int i) {
            this.x = i;
            return this;
        }

        public b K(@Nullable String str) {
            this.h = str;
            return this;
        }

        public b L(@Nullable xg0 xg0Var) {
            this.w = xg0Var;
            return this;
        }

        public b M(@Nullable String str) {
            this.j = str;
            return this;
        }

        public b N(int i) {
            this.F = i;
            return this;
        }

        public b O(@Nullable DrmInitData drmInitData) {
            this.n = drmInitData;
            return this;
        }

        public b P(int i) {
            this.A = i;
            return this;
        }

        public b Q(int i) {
            this.B = i;
            return this;
        }

        public b R(float f) {
            this.r = f;
            return this;
        }

        public b S(int i) {
            this.q = i;
            return this;
        }

        public b T(int i) {
            this.f5893a = Integer.toString(i);
            return this;
        }

        public b U(@Nullable String str) {
            this.f5893a = str;
            return this;
        }

        public b V(@Nullable List<byte[]> list) {
            this.m = list;
            return this;
        }

        public b W(@Nullable String str) {
            this.b = str;
            return this;
        }

        public b X(@Nullable String str) {
            this.c = str;
            return this;
        }

        public b Y(int i) {
            this.l = i;
            return this;
        }

        public b Z(@Nullable Metadata metadata) {
            this.i = metadata;
            return this;
        }

        public b a0(int i) {
            this.z = i;
            return this;
        }

        public b b0(int i) {
            this.g = i;
            return this;
        }

        public b c0(float f) {
            this.t = f;
            return this;
        }

        public b d0(@Nullable byte[] bArr) {
            this.u = bArr;
            return this;
        }

        public b e0(int i) {
            this.e = i;
            return this;
        }

        public b f0(int i) {
            this.s = i;
            return this;
        }

        public b g0(@Nullable String str) {
            this.k = str;
            return this;
        }

        public b h0(int i) {
            this.y = i;
            return this;
        }

        public b i0(int i) {
            this.d = i;
            return this;
        }

        public b j0(int i) {
            this.v = i;
            return this;
        }

        public b k0(long j) {
            this.o = j;
            return this;
        }

        public b l0(int i) {
            this.D = i;
            return this;
        }

        public b m0(int i) {
            this.E = i;
            return this;
        }

        public b n0(int i) {
            this.p = i;
            return this;
        }

        public b() {
            this.f = -1;
            this.g = -1;
            this.l = -1;
            this.o = Long.MAX_VALUE;
            this.p = -1;
            this.q = -1;
            this.r = -1.0f;
            this.t = 1.0f;
            this.v = -1;
            this.x = -1;
            this.y = -1;
            this.z = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = 0;
        }

        public b(m mVar) {
            this.f5893a = mVar.f5892a;
            this.b = mVar.b;
            this.c = mVar.c;
            this.d = mVar.d;
            this.e = mVar.e;
            this.f = mVar.f;
            this.g = mVar.g;
            this.h = mVar.i;
            this.i = mVar.j;
            this.j = mVar.k;
            this.k = mVar.l;
            this.l = mVar.m;
            this.m = mVar.n;
            this.n = mVar.o;
            this.o = mVar.p;
            this.p = mVar.q;
            this.q = mVar.r;
            this.r = mVar.s;
            this.s = mVar.t;
            this.t = mVar.u;
            this.u = mVar.v;
            this.v = mVar.w;
            this.w = mVar.x;
            this.x = mVar.y;
            this.y = mVar.z;
            this.z = mVar.A;
            this.A = mVar.B;
            this.B = mVar.C;
            this.C = mVar.E;
            this.D = mVar.F;
            this.E = mVar.G;
            this.F = mVar.H;
        }
    }

    @Nullable
    public static <T> T d(@Nullable T t, @Nullable T t2) {
        return t != null ? t : t2;
    }

    public static m e(Bundle bundle) {
        b bVar = new b();
        hv.c(bundle);
        String string = bundle.getString(K);
        m mVar = J;
        bVar.U((String) d(string, mVar.f5892a)).W((String) d(bundle.getString(L), mVar.b)).X((String) d(bundle.getString(M), mVar.c)).i0(bundle.getInt(N, mVar.d)).e0(bundle.getInt(O, mVar.e)).I(bundle.getInt(P, mVar.f)).b0(bundle.getInt(Q, mVar.g)).K((String) d(bundle.getString(R), mVar.i)).Z((Metadata) d((Metadata) bundle.getParcelable(S), mVar.j)).M((String) d(bundle.getString(T), mVar.k)).g0((String) d(bundle.getString(U), mVar.l)).Y(bundle.getInt(V, mVar.m));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            byte[] byteArray = bundle.getByteArray(h(i));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i++;
        }
        b bVarO = bVar.V(arrayList).O((DrmInitData) bundle.getParcelable(X));
        String str = Y;
        m mVar2 = J;
        bVarO.k0(bundle.getLong(str, mVar2.p)).n0(bundle.getInt(Z, mVar2.q)).S(bundle.getInt(e0, mVar2.r)).R(bundle.getFloat(f0, mVar2.s)).f0(bundle.getInt(g0, mVar2.t)).c0(bundle.getFloat(h0, mVar2.u)).d0(bundle.getByteArray(i0)).j0(bundle.getInt(j0, mVar2.w));
        Bundle bundle2 = bundle.getBundle(k0);
        if (bundle2 != null) {
            bVar.L((xg0) xg0.l.fromBundle(bundle2));
        }
        bVar.J(bundle.getInt(l0, mVar2.y)).h0(bundle.getInt(m0, mVar2.z)).a0(bundle.getInt(n0, mVar2.A)).P(bundle.getInt(o0, mVar2.B)).Q(bundle.getInt(p0, mVar2.C)).H(bundle.getInt(q0, mVar2.E)).l0(bundle.getInt(s0, mVar2.F)).m0(bundle.getInt(t0, mVar2.G)).N(bundle.getInt(r0, mVar2.H));
        return bVar.G();
    }

    public static String h(int i) {
        return W + "_" + Integer.toString(i, 36);
    }

    public static String j(@Nullable m mVar) {
        if (mVar == null) {
            return com.igexin.push.core.b.m;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(mVar.f5892a);
        sb.append(", mimeType=");
        sb.append(mVar.l);
        if (mVar.h != -1) {
            sb.append(", bitrate=");
            sb.append(mVar.h);
        }
        if (mVar.i != null) {
            sb.append(", codecs=");
            sb.append(mVar.i);
        }
        if (mVar.o != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            while (true) {
                DrmInitData drmInitData = mVar.o;
                if (i >= drmInitData.schemeDataCount) {
                    break;
                }
                UUID uuid = drmInitData.get(i).uuid;
                if (uuid.equals(zv.b)) {
                    linkedHashSet.add("cenc");
                } else if (uuid.equals(zv.c)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(zv.e)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(zv.d)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(zv.f22519a)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
                i++;
            }
            sb.append(", drm=[");
            qy2.g(',').b(sb, linkedHashSet);
            sb.append(']');
        }
        if (mVar.q != -1 && mVar.r != -1) {
            sb.append(", res=");
            sb.append(mVar.q);
            sb.append("x");
            sb.append(mVar.r);
        }
        xg0 xg0Var = mVar.x;
        if (xg0Var != null && xg0Var.g()) {
            sb.append(", color=");
            sb.append(mVar.x.k());
        }
        if (mVar.s != -1.0f) {
            sb.append(", fps=");
            sb.append(mVar.s);
        }
        if (mVar.y != -1) {
            sb.append(", channels=");
            sb.append(mVar.y);
        }
        if (mVar.z != -1) {
            sb.append(", sample_rate=");
            sb.append(mVar.z);
        }
        if (mVar.c != null) {
            sb.append(", language=");
            sb.append(mVar.c);
        }
        if (mVar.b != null) {
            sb.append(", label=");
            sb.append(mVar.b);
        }
        if (mVar.d != 0) {
            ArrayList arrayList = new ArrayList();
            if ((mVar.d & 4) != 0) {
                arrayList.add("auto");
            }
            if ((mVar.d & 1) != 0) {
                arrayList.add(MapController.DEFAULT_LAYER_TAG);
            }
            if ((mVar.d & 2) != 0) {
                arrayList.add("forced");
            }
            sb.append(", selectionFlags=[");
            qy2.g(',').b(sb, arrayList);
            sb.append("]");
        }
        if (mVar.e != 0) {
            ArrayList arrayList2 = new ArrayList();
            if ((mVar.e & 1) != 0) {
                arrayList2.add("main");
            }
            if ((mVar.e & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((mVar.e & 4) != 0) {
                arrayList2.add("supplementary");
            }
            if ((mVar.e & 8) != 0) {
                arrayList2.add("commentary");
            }
            if ((mVar.e & 16) != 0) {
                arrayList2.add("dub");
            }
            if ((mVar.e & 32) != 0) {
                arrayList2.add("emergency");
            }
            if ((mVar.e & 64) != 0) {
                arrayList2.add("caption");
            }
            if ((mVar.e & 128) != 0) {
                arrayList2.add(MediaFormat.KEY_SUBTITLE);
            }
            if ((mVar.e & 256) != 0) {
                arrayList2.add("sign");
            }
            if ((mVar.e & 512) != 0) {
                arrayList2.add("describes-video");
            }
            if ((mVar.e & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((mVar.e & 2048) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((mVar.e & 4096) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((mVar.e & 8192) != 0) {
                arrayList2.add("easy-read");
            }
            if ((mVar.e & 16384) != 0) {
                arrayList2.add("trick-play");
            }
            sb.append(", roleFlags=[");
            qy2.g(',').b(sb, arrayList2);
            sb.append("]");
        }
        return sb.toString();
    }

    public b b() {
        return new b();
    }

    public m c(int i) {
        return b().N(i).G();
    }

    public boolean equals(@Nullable Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        int i2 = this.I;
        return (i2 == 0 || (i = mVar.I) == 0 || i2 == i) && this.d == mVar.d && this.e == mVar.e && this.f == mVar.f && this.g == mVar.g && this.m == mVar.m && this.p == mVar.p && this.q == mVar.q && this.r == mVar.r && this.t == mVar.t && this.w == mVar.w && this.y == mVar.y && this.z == mVar.z && this.A == mVar.A && this.B == mVar.B && this.C == mVar.C && this.E == mVar.E && this.F == mVar.F && this.G == mVar.G && this.H == mVar.H && Float.compare(this.s, mVar.s) == 0 && Float.compare(this.u, mVar.u) == 0 && g86.c(this.f5892a, mVar.f5892a) && g86.c(this.b, mVar.b) && g86.c(this.i, mVar.i) && g86.c(this.k, mVar.k) && g86.c(this.l, mVar.l) && g86.c(this.c, mVar.c) && Arrays.equals(this.v, mVar.v) && g86.c(this.j, mVar.j) && g86.c(this.x, mVar.x) && g86.c(this.o, mVar.o) && g(mVar);
    }

    public int f() {
        int i;
        int i2 = this.q;
        if (i2 == -1 || (i = this.r) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public boolean g(m mVar) {
        if (this.n.size() != mVar.n.size()) {
            return false;
        }
        for (int i = 0; i < this.n.size(); i++) {
            if (!Arrays.equals(this.n.get(i), mVar.n.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.I == 0) {
            String str = this.f5892a;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31;
            String str4 = this.i;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.j;
            int iHashCode5 = (iHashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.k;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.l;
            this.I = ((((((((((((((((((((((((((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.m) * 31) + ((int) this.p)) * 31) + this.q) * 31) + this.r) * 31) + Float.floatToIntBits(this.s)) * 31) + this.t) * 31) + Float.floatToIntBits(this.u)) * 31) + this.w) * 31) + this.y) * 31) + this.z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.E) * 31) + this.F) * 31) + this.G) * 31) + this.H;
        }
        return this.I;
    }

    public Bundle i(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(K, this.f5892a);
        bundle.putString(L, this.b);
        bundle.putString(M, this.c);
        bundle.putInt(N, this.d);
        bundle.putInt(O, this.e);
        bundle.putInt(P, this.f);
        bundle.putInt(Q, this.g);
        bundle.putString(R, this.i);
        if (!z) {
            bundle.putParcelable(S, this.j);
        }
        bundle.putString(T, this.k);
        bundle.putString(U, this.l);
        bundle.putInt(V, this.m);
        for (int i = 0; i < this.n.size(); i++) {
            bundle.putByteArray(h(i), this.n.get(i));
        }
        bundle.putParcelable(X, this.o);
        bundle.putLong(Y, this.p);
        bundle.putInt(Z, this.q);
        bundle.putInt(e0, this.r);
        bundle.putFloat(f0, this.s);
        bundle.putInt(g0, this.t);
        bundle.putFloat(h0, this.u);
        bundle.putByteArray(i0, this.v);
        bundle.putInt(j0, this.w);
        xg0 xg0Var = this.x;
        if (xg0Var != null) {
            bundle.putBundle(k0, xg0Var.toBundle());
        }
        bundle.putInt(l0, this.y);
        bundle.putInt(m0, this.z);
        bundle.putInt(n0, this.A);
        bundle.putInt(o0, this.B);
        bundle.putInt(p0, this.C);
        bundle.putInt(q0, this.E);
        bundle.putInt(s0, this.F);
        bundle.putInt(t0, this.G);
        bundle.putInt(r0, this.H);
        return bundle;
    }

    public m k(m mVar) {
        String str;
        if (this == mVar) {
            return this;
        }
        int iK = fp3.k(this.l);
        String str2 = mVar.f5892a;
        String str3 = mVar.b;
        if (str3 == null) {
            str3 = this.b;
        }
        String str4 = this.c;
        if ((iK == 3 || iK == 1) && (str = mVar.c) != null) {
            str4 = str;
        }
        int i = this.f;
        if (i == -1) {
            i = mVar.f;
        }
        int i2 = this.g;
        if (i2 == -1) {
            i2 = mVar.g;
        }
        String str5 = this.i;
        if (str5 == null) {
            String strK = g86.K(mVar.i, iK);
            if (g86.b1(strK).length == 1) {
                str5 = strK;
            }
        }
        Metadata metadata = this.j;
        Metadata metadataCopyWithAppendedEntriesFrom = metadata == null ? mVar.j : metadata.copyWithAppendedEntriesFrom(mVar.j);
        float f = this.s;
        if (f == -1.0f && iK == 2) {
            f = mVar.s;
        }
        return b().U(str2).W(str3).X(str4).i0(this.d | mVar.d).e0(this.e | mVar.e).I(i).b0(i2).K(str5).Z(metadataCopyWithAppendedEntriesFrom).O(DrmInitData.createSessionCreationData(mVar.o, this.o)).R(f).G();
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        return i(false);
    }

    public String toString() {
        return "Format(" + this.f5892a + ", " + this.b + ", " + this.k + ", " + this.l + ", " + this.i + ", " + this.h + ", " + this.c + ", [" + this.q + ", " + this.r + ", " + this.s + ", " + this.x + "], [" + this.y + ", " + this.z + "])";
    }

    public m(b bVar) {
        this.f5892a = bVar.f5893a;
        this.b = bVar.b;
        this.c = g86.J0(bVar.c);
        this.d = bVar.d;
        this.e = bVar.e;
        int i = bVar.f;
        this.f = i;
        int i2 = bVar.g;
        this.g = i2;
        this.h = i2 != -1 ? i2 : i;
        this.i = bVar.h;
        this.j = bVar.i;
        this.k = bVar.j;
        this.l = bVar.k;
        this.m = bVar.l;
        this.n = bVar.m == null ? Collections.emptyList() : bVar.m;
        DrmInitData drmInitData = bVar.n;
        this.o = drmInitData;
        this.p = bVar.o;
        this.q = bVar.p;
        this.r = bVar.q;
        this.s = bVar.r;
        this.t = bVar.s == -1 ? 0 : bVar.s;
        this.u = bVar.t == -1.0f ? 1.0f : bVar.t;
        this.v = bVar.u;
        this.w = bVar.v;
        this.x = bVar.w;
        this.y = bVar.x;
        this.z = bVar.y;
        this.A = bVar.z;
        this.B = bVar.A == -1 ? 0 : bVar.A;
        this.C = bVar.B != -1 ? bVar.B : 0;
        this.E = bVar.C;
        this.F = bVar.D;
        this.G = bVar.E;
        if (bVar.F != 0 || drmInitData == null) {
            this.H = bVar.F;
        } else {
            this.H = 1;
        }
    }
}
