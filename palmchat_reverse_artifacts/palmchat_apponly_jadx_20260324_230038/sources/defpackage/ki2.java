package defpackage;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.f;
import com.google.common.collect.ImmutableList;
import defpackage.c06;
import defpackage.xh2;
import j$.util.Objects;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ki2 implements Loader.b<x50>, Loader.f, q, qs1, p.d {
    public static final Set<Integer> Z = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    public int A;
    public int B;
    public boolean C;
    public boolean E;
    public int F;
    public m G;

    @Nullable
    public m H;
    public boolean I;
    public vz5 J;
    public Set<qz5> K;
    public int[] L;
    public int M;
    public boolean N;
    public boolean[] O;
    public boolean[] P;
    public long Q;
    public long R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public long W;

    @Nullable
    public DrmInitData X;

    @Nullable
    public bi2 Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18696a;
    public final int b;
    public final b c;
    public final xh2 d;
    public final w9 e;

    @Nullable
    public final m f;
    public final com.google.android.exoplayer2.drm.c g;
    public final b.a h;
    public final f i;
    public final j.a k;
    public final int l;
    public final ArrayList<bi2> n;
    public final List<bi2> o;
    public final Runnable p;
    public final Runnable q;
    public final Handler r;
    public final ArrayList<gi2> s;
    public final Map<String, DrmInitData> t;

    @Nullable
    public x50 u;
    public d[] v;
    public Set<Integer> x;
    public SparseIntArray y;
    public c06 z;
    public final Loader j = new Loader("Loader:HlsSampleStreamWrapper");
    public final xh2.b m = new xh2.b();
    public int[] w = new int[0];

    /* JADX INFO: compiled from: SearchBox */
    public interface b extends q.a<ki2> {
        void e(Uri uri);

        void onPrepared();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements c06 {
        public static final m g = new m.b().g0("application/id3").G();
        public static final m h = new m.b().g0("application/x-emsg").G();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final on1 f18697a = new on1();
        public final c06 b;
        public final m c;
        public m d;
        public byte[] e;
        public int f;

        public c(c06 c06Var, int i) {
            this.b = c06Var;
            if (i == 1) {
                this.c = g;
            } else {
                if (i != 3) {
                    throw new IllegalArgumentException("Unknown metadataType: " + i);
                }
                this.c = h;
            }
            this.e = new byte[0];
            this.f = 0;
        }

        @Override // defpackage.c06
        public void a(gc4 gc4Var, int i, int i2) {
            h(this.f + i);
            gc4Var.l(this.e, this.f, i);
            this.f += i;
        }

        @Override // defpackage.c06
        public void b(m mVar) {
            this.d = mVar;
            this.b.b(this.c);
        }

        @Override // defpackage.c06
        public /* synthetic */ int c(ru0 ru0Var, int i, boolean z) {
            return zz5.a(this, ru0Var, i, z);
        }

        @Override // defpackage.c06
        public /* synthetic */ void d(gc4 gc4Var, int i) {
            zz5.b(this, gc4Var, i);
        }

        @Override // defpackage.c06
        public void e(long j, int i, int i2, int i3, @Nullable c06.a aVar) {
            vh.e(this.d);
            gc4 gc4VarI = i(i2, i3);
            if (!g86.c(this.d.l, this.c.l)) {
                if (!"application/x-emsg".equals(this.d.l)) {
                    y53.i("HlsSampleStreamWrapper", "Ignoring sample for unsupported format: " + this.d.l);
                    return;
                }
                EventMessage eventMessageC = this.f18697a.c(gc4VarI);
                if (!g(eventMessageC)) {
                    y53.i("HlsSampleStreamWrapper", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.c.l, eventMessageC.getWrappedMetadataFormat()));
                    return;
                }
                gc4VarI = new gc4((byte[]) vh.e(eventMessageC.getWrappedMetadataBytes()));
            }
            int iA = gc4VarI.a();
            this.b.d(gc4VarI, iA);
            this.b.e(j, i, iA, i3, aVar);
        }

        @Override // defpackage.c06
        public int f(ru0 ru0Var, int i, boolean z, int i2) throws IOException {
            h(this.f + i);
            int i3 = ru0Var.read(this.e, this.f, i);
            if (i3 != -1) {
                this.f += i3;
                return i3;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }

        public final boolean g(EventMessage eventMessage) {
            m wrappedMetadataFormat = eventMessage.getWrappedMetadataFormat();
            return wrappedMetadataFormat != null && g86.c(this.c.l, wrappedMetadataFormat.l);
        }

        public final void h(int i) {
            byte[] bArr = this.e;
            if (bArr.length < i) {
                this.e = Arrays.copyOf(bArr, i + (i / 2));
            }
        }

        public final gc4 i(int i, int i2) {
            int i3 = this.f - i2;
            gc4 gc4Var = new gc4(Arrays.copyOfRange(this.e, i3 - i, i3));
            byte[] bArr = this.e;
            System.arraycopy(bArr, i3, bArr, 0, i2);
            this.f = i2;
            return gc4Var;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d extends p {
        public final Map<String, DrmInitData> H;

        @Nullable
        public DrmInitData I;

        @Override // com.google.android.exoplayer2.source.p, defpackage.c06
        public void e(long j, int i, int i2, int i3, @Nullable c06.a aVar) {
            super.e(j, i, i2, i3, aVar);
        }

        @Nullable
        public final Metadata h0(@Nullable Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int length = metadata.length();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                }
                Metadata.Entry entry = metadata.get(i2);
                if ((entry instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) entry).owner)) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return metadata;
            }
            if (length == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[length - 1];
            while (i < length) {
                if (i != i2) {
                    entryArr[i < i2 ? i : i - 1] = metadata.get(i);
                }
                i++;
            }
            return new Metadata(entryArr);
        }

        public void i0(@Nullable DrmInitData drmInitData) {
            this.I = drmInitData;
            I();
        }

        public void j0(bi2 bi2Var) {
            f0(bi2Var.k);
        }

        @Override // com.google.android.exoplayer2.source.p
        public m w(m mVar) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.I;
            if (drmInitData2 == null) {
                drmInitData2 = mVar.o;
            }
            if (drmInitData2 != null && (drmInitData = this.H.get(drmInitData2.schemeType)) != null) {
                drmInitData2 = drmInitData;
            }
            Metadata metadataH0 = h0(mVar.j);
            if (drmInitData2 != mVar.o || metadataH0 != mVar.j) {
                mVar = mVar.b().O(drmInitData2).Z(metadataH0).G();
            }
            return super.w(mVar);
        }

        public d(w9 w9Var, com.google.android.exoplayer2.drm.c cVar, b.a aVar, Map<String, DrmInitData> map) {
            super(w9Var, cVar, aVar);
            this.H = map;
        }
    }

    public ki2(String str, int i, b bVar, xh2 xh2Var, Map<String, DrmInitData> map, w9 w9Var, long j, @Nullable m mVar, com.google.android.exoplayer2.drm.c cVar, b.a aVar, f fVar, j.a aVar2, int i2) {
        this.f18696a = str;
        this.b = i;
        this.c = bVar;
        this.d = xh2Var;
        this.t = map;
        this.e = w9Var;
        this.f = mVar;
        this.g = cVar;
        this.h = aVar;
        this.i = fVar;
        this.k = aVar2;
        this.l = i2;
        Set<Integer> set = Z;
        this.x = new HashSet(set.size());
        this.y = new SparseIntArray(set.size());
        this.v = new d[0];
        this.P = new boolean[0];
        this.O = new boolean[0];
        ArrayList<bi2> arrayList = new ArrayList<>();
        this.n = arrayList;
        this.o = Collections.unmodifiableList(arrayList);
        this.s = new ArrayList<>();
        this.p = new Runnable() { // from class: ii2
            @Override // java.lang.Runnable
            public final void run() {
                this.f18173a.G();
            }
        };
        this.q = new Runnable() { // from class: ji2
            @Override // java.lang.Runnable
            public final void run() {
                this.f18419a.P();
            }
        };
        this.r = g86.w();
        this.Q = j;
        this.R = j;
    }

    public static boolean B(x50 x50Var) {
        return x50Var instanceof bi2;
    }

    public static pi1 p(int i, int i2) {
        y53.i("HlsSampleStreamWrapper", "Unmapped track with id " + i + " of type " + i2);
        return new pi1();
    }

    public static m s(@Nullable m mVar, m mVar2, boolean z) {
        String strD;
        String strG;
        if (mVar == null) {
            return mVar2;
        }
        int iK = fp3.k(mVar2.l);
        if (g86.J(mVar.i, iK) == 1) {
            strD = g86.K(mVar.i, iK);
            strG = fp3.g(strD);
        } else {
            strD = fp3.d(mVar.i, mVar2.l);
            strG = mVar2.l;
        }
        m.b bVarK = mVar2.b().U(mVar.f5892a).W(mVar.b).X(mVar.c).i0(mVar.d).e0(mVar.e).I(z ? mVar.f : -1).b0(z ? mVar.g : -1).K(strD);
        if (iK == 2) {
            bVarK.n0(mVar.q).S(mVar.r).R(mVar.s);
        }
        if (strG != null) {
            bVarK.g0(strG);
        }
        int i = mVar.y;
        if (i != -1 && iK == 1) {
            bVarK.J(i);
        }
        Metadata metadataCopyWithAppendedEntriesFrom = mVar.j;
        if (metadataCopyWithAppendedEntriesFrom != null) {
            Metadata metadata = mVar2.j;
            if (metadata != null) {
                metadataCopyWithAppendedEntriesFrom = metadata.copyWithAppendedEntriesFrom(metadataCopyWithAppendedEntriesFrom);
            }
            bVarK.Z(metadataCopyWithAppendedEntriesFrom);
        }
        return bVarK.G();
    }

    public static boolean w(m mVar, m mVar2) {
        String str = mVar.l;
        String str2 = mVar2.l;
        int iK = fp3.k(str);
        if (iK != 3) {
            return iK == fp3.k(str2);
        }
        if (g86.c(str, str2)) {
            return !("application/cea-608".equals(str) || "application/cea-708".equals(str)) || mVar.E == mVar2.E;
        }
        return false;
    }

    public static int z(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 0 : 1;
        }
        return 3;
    }

    public final void A(bi2 bi2Var) {
        this.Y = bi2Var;
        this.G = bi2Var.d;
        this.R = -9223372036854775807L;
        this.n.add(bi2Var);
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (d dVar : this.v) {
            aVarBuilder.a(Integer.valueOf(dVar.G()));
        }
        bi2Var.l(this, aVarBuilder.e());
        for (d dVar2 : this.v) {
            dVar2.j0(bi2Var);
            if (bi2Var.n) {
                dVar2.g0();
            }
        }
    }

    public final boolean C() {
        return this.R != -9223372036854775807L;
    }

    public boolean D(int i) {
        return !C() && this.v[i].K(this.U);
    }

    public boolean E() {
        return this.A == 2;
    }

    public final void F() {
        int i = this.J.f21565a;
        int[] iArr = new int[i];
        this.L = iArr;
        Arrays.fill(iArr, -1);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = 0;
            while (true) {
                d[] dVarArr = this.v;
                if (i3 >= dVarArr.length) {
                    break;
                }
                if (w((m) vh.i(dVarArr[i3].F()), this.J.b(i2).c(0))) {
                    this.L[i2] = i3;
                    break;
                }
                i3++;
            }
        }
        Iterator<gi2> it = this.s.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public final void G() {
        if (!this.I && this.L == null && this.C) {
            for (d dVar : this.v) {
                if (dVar.F() == null) {
                    return;
                }
            }
            if (this.J != null) {
                F();
                return;
            }
            m();
            Y();
            this.c.onPrepared();
        }
    }

    public void H() throws IOException {
        this.j.maybeThrowError();
        this.d.n();
    }

    public void I(int i) throws IOException {
        H();
        this.v[i].N();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void e(x50 x50Var, long j, long j2, boolean z) {
        this.u = null;
        m43 m43Var = new m43(x50Var.f21879a, x50Var.b, x50Var.d(), x50Var.c(), j, j2, x50Var.a());
        this.i.onLoadTaskConcluded(x50Var.f21879a);
        this.k.q(m43Var, x50Var.c, this.b, x50Var.d, x50Var.e, x50Var.f, x50Var.g, x50Var.h);
        if (z) {
            return;
        }
        if (C() || this.F == 0) {
            T();
        }
        if (this.F > 0) {
            this.c.c(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public void f(x50 x50Var, long j, long j2) {
        this.u = null;
        this.d.p(x50Var);
        m43 m43Var = new m43(x50Var.f21879a, x50Var.b, x50Var.d(), x50Var.c(), j, j2, x50Var.a());
        this.i.onLoadTaskConcluded(x50Var.f21879a);
        this.k.t(m43Var, x50Var.c, this.b, x50Var.d, x50Var.e, x50Var.f, x50Var.g, x50Var.h);
        if (this.E) {
            this.c.c(this);
        } else {
            continueLoading(this.Q);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public Loader.c j(x50 x50Var, long j, long j2, IOException iOException, int i) {
        Loader.c cVarG;
        int i2;
        boolean zB = B(x50Var);
        if (zB && !((bi2) x50Var).o() && (iOException instanceof HttpDataSource$InvalidResponseCodeException) && ((i2 = ((HttpDataSource$InvalidResponseCodeException) iOException).responseCode) == 410 || i2 == 404)) {
            return Loader.d;
        }
        long jA = x50Var.a();
        m43 m43Var = new m43(x50Var.f21879a, x50Var.b, x50Var.d(), x50Var.c(), j, j2, jA);
        f.c cVar = new f.c(m43Var, new kh3(x50Var.c, this.b, x50Var.d, x50Var.e, x50Var.f, g86.m1(x50Var.g), g86.m1(x50Var.h)), iOException, i);
        f.b bVarB = this.i.b(l06.c(this.d.k()), cVar);
        boolean zM = (bVarB == null || bVarB.f6025a != 2) ? false : this.d.m(x50Var, bVarB.b);
        if (zM) {
            if (zB && jA == 0) {
                ArrayList<bi2> arrayList = this.n;
                vh.g(arrayList.remove(arrayList.size() - 1) == x50Var);
                if (this.n.isEmpty()) {
                    this.R = this.Q;
                } else {
                    ((bi2) bv2.g(this.n)).m();
                }
            }
            cVarG = Loader.f;
        } else {
            long jA2 = this.i.a(cVar);
            cVarG = jA2 != -9223372036854775807L ? Loader.g(false, jA2) : Loader.g;
        }
        Loader.c cVar2 = cVarG;
        boolean z = !cVar2.c();
        this.k.v(m43Var, x50Var.c, this.b, x50Var.d, x50Var.e, x50Var.f, x50Var.g, x50Var.h, iOException, z);
        if (z) {
            this.u = null;
            this.i.onLoadTaskConcluded(x50Var.f21879a);
        }
        if (zM) {
            if (this.E) {
                this.c.c(this);
            } else {
                continueLoading(this.Q);
            }
        }
        return cVar2;
    }

    public void M() {
        this.x.clear();
    }

    public boolean N(Uri uri, f.c cVar, boolean z) {
        f.b bVarB;
        if (!this.d.o(uri)) {
            return true;
        }
        long j = (z || (bVarB = this.i.b(l06.c(this.d.k()), cVar)) == null || bVarB.f6025a != 2) ? -9223372036854775807L : bVarB.b;
        return this.d.q(uri, j) && j != -9223372036854775807L;
    }

    public void O() {
        if (this.n.isEmpty()) {
            return;
        }
        bi2 bi2Var = (bi2) bv2.g(this.n);
        int iC = this.d.c(bi2Var);
        if (iC == 1) {
            bi2Var.t();
        } else if (iC == 2 && !this.U && this.j.i()) {
            this.j.e();
        }
    }

    public final void P() {
        this.C = true;
        G();
    }

    public void Q(qz5[] qz5VarArr, int i, int... iArr) {
        this.J = r(qz5VarArr);
        this.K = new HashSet();
        for (int i2 : iArr) {
            this.K.add(this.J.b(i2));
        }
        this.M = i;
        Handler handler = this.r;
        final b bVar = this.c;
        Objects.requireNonNull(bVar);
        handler.post(new Runnable() { // from class: hi2
            @Override // java.lang.Runnable
            public final void run() {
                bVar.onPrepared();
            }
        });
        Y();
    }

    public int R(int i, f12 f12Var, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (C()) {
            return -3;
        }
        int i3 = 0;
        if (!this.n.isEmpty()) {
            int i4 = 0;
            while (i4 < this.n.size() - 1 && v(this.n.get(i4))) {
                i4++;
            }
            g86.S0(this.n, 0, i4);
            bi2 bi2Var = this.n.get(0);
            m mVar = bi2Var.d;
            if (!mVar.equals(this.H)) {
                this.k.h(this.b, mVar, bi2Var.e, bi2Var.f, bi2Var.g);
            }
            this.H = mVar;
        }
        if (!this.n.isEmpty() && !this.n.get(0).o()) {
            return -3;
        }
        int iS = this.v[i].S(f12Var, decoderInputBuffer, i2, this.U);
        if (iS == -5) {
            m mVarK = (m) vh.e(f12Var.b);
            if (i == this.B) {
                int iE = ku2.e(this.v[i].Q());
                while (i3 < this.n.size() && this.n.get(i3).k != iE) {
                    i3++;
                }
                mVarK = mVarK.k(i3 < this.n.size() ? this.n.get(i3).d : (m) vh.e(this.G));
            }
            f12Var.b = mVarK;
        }
        return iS;
    }

    public void S() {
        if (this.E) {
            for (d dVar : this.v) {
                dVar.R();
            }
        }
        this.j.l(this);
        this.r.removeCallbacksAndMessages(null);
        this.I = true;
        this.s.clear();
    }

    public final void T() {
        for (d dVar : this.v) {
            dVar.W(this.S);
        }
        this.S = false;
    }

    public final boolean U(long j) {
        int length = this.v.length;
        for (int i = 0; i < length; i++) {
            if (!this.v[i].Z(j, false) && (this.P[i] || !this.N)) {
                return false;
            }
        }
        return true;
    }

    public boolean V(long j, boolean z) {
        this.Q = j;
        if (C()) {
            this.R = j;
            return true;
        }
        if (this.C && !z && U(j)) {
            return false;
        }
        this.R = j;
        this.U = false;
        this.n.clear();
        if (this.j.i()) {
            if (this.C) {
                for (d dVar : this.v) {
                    dVar.r();
                }
            }
            this.j.e();
        } else {
            this.j.f();
            T();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean W(or1[] or1VarArr, boolean[] zArr, d25[] d25VarArr, boolean[] zArr2, long j, boolean z) {
        boolean z2;
        k();
        int i = this.F;
        int i2 = 0;
        for (int i3 = 0; i3 < or1VarArr.length; i3++) {
            gi2 gi2Var = (gi2) d25VarArr[i3];
            if (gi2Var != null && (or1VarArr[i3] == null || !zArr[i3])) {
                this.F--;
                gi2Var.d();
                d25VarArr[i3] = null;
            }
        }
        boolean z3 = z || (!this.T ? j == this.Q : i != 0);
        or1 or1VarK = this.d.k();
        boolean z4 = z3;
        or1 or1Var = or1VarK;
        for (int i4 = 0; i4 < or1VarArr.length; i4++) {
            or1 or1Var2 = or1VarArr[i4];
            if (or1Var2 != null) {
                int iC = this.J.c(or1Var2.getTrackGroup());
                if (iC == this.M) {
                    this.d.u(or1Var2);
                    or1Var = or1Var2;
                }
                if (d25VarArr[i4] == null) {
                    this.F++;
                    gi2 gi2Var2 = new gi2(this, iC);
                    d25VarArr[i4] = gi2Var2;
                    zArr2[i4] = true;
                    if (this.L != null) {
                        gi2Var2.a();
                        if (!z4) {
                            d dVar = this.v[this.L[iC]];
                            z4 = (dVar.Z(j, true) || dVar.C() == 0) ? false : true;
                        }
                    }
                }
            }
        }
        if (this.F == 0) {
            this.d.r();
            this.H = null;
            this.S = true;
            this.n.clear();
            if (this.j.i()) {
                if (this.C) {
                    d[] dVarArr = this.v;
                    int length = dVarArr.length;
                    while (i2 < length) {
                        dVarArr[i2].r();
                        i2++;
                    }
                }
                this.j.e();
            } else {
                T();
            }
        } else if (this.n.isEmpty() || g86.c(or1Var, or1VarK)) {
            z2 = z;
            if (z4) {
                V(j, z2);
                while (i2 < d25VarArr.length) {
                    if (d25VarArr[i2] != null) {
                        zArr2[i2] = true;
                    }
                    i2++;
                }
            }
        } else if (!this.T) {
            long j2 = j < 0 ? -j : 0L;
            bi2 bi2VarX = x();
            or1Var.b(j, j2, -9223372036854775807L, this.o, this.d.a(bi2VarX, j));
            boolean z5 = or1Var.getSelectedIndexInTrackGroup() != this.d.j().d(bi2VarX.d);
            if (z5) {
                this.S = true;
                z2 = true;
                z4 = true;
            }
            if (z4) {
            }
        }
        d0(d25VarArr);
        this.T = true;
        return z4;
    }

    public void X(@Nullable DrmInitData drmInitData) {
        if (g86.c(this.X, drmInitData)) {
            return;
        }
        this.X = drmInitData;
        int i = 0;
        while (true) {
            d[] dVarArr = this.v;
            if (i >= dVarArr.length) {
                return;
            }
            if (this.P[i]) {
                dVarArr[i].i0(drmInitData);
            }
            i++;
        }
    }

    public final void Y() {
        this.E = true;
    }

    public void Z(boolean z) {
        this.d.t(z);
    }

    public long a(long j, w45 w45Var) {
        return this.d.b(j, w45Var);
    }

    public void a0(long j) {
        if (this.W != j) {
            this.W = j;
            for (d dVar : this.v) {
                dVar.a0(j);
            }
        }
    }

    public int b0(int i, long j) {
        if (C()) {
            return 0;
        }
        d dVar = this.v[i];
        int iE = dVar.E(j, this.U);
        bi2 bi2Var = (bi2) bv2.h(this.n, null);
        if (bi2Var != null && !bi2Var.o()) {
            iE = Math.min(iE, bi2Var.k(i) - dVar.C());
        }
        dVar.e0(iE);
        return iE;
    }

    @Override // com.google.android.exoplayer2.source.p.d
    public void c(m mVar) {
        this.r.post(this.p);
    }

    public void c0(int i) {
        k();
        vh.e(this.L);
        int i2 = this.L[i];
        vh.g(this.O[i2]);
        this.O[i2] = false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j) {
        List<bi2> listEmptyList;
        long jMax;
        if (this.U || this.j.i() || this.j.h()) {
            return false;
        }
        if (C()) {
            listEmptyList = Collections.emptyList();
            jMax = this.R;
            for (d dVar : this.v) {
                dVar.b0(this.R);
            }
        } else {
            listEmptyList = this.o;
            bi2 bi2VarX = x();
            jMax = bi2VarX.f() ? bi2VarX.h : Math.max(this.Q, bi2VarX.g);
        }
        List<bi2> list = listEmptyList;
        long j2 = jMax;
        this.m.a();
        this.d.e(j, j2, list, this.E || !list.isEmpty(), this.m);
        xh2.b bVar = this.m;
        boolean z = bVar.b;
        x50 x50Var = bVar.f21961a;
        Uri uri = bVar.c;
        if (z) {
            this.R = -9223372036854775807L;
            this.U = true;
            return true;
        }
        if (x50Var == null) {
            if (uri != null) {
                this.c.e(uri);
            }
            return false;
        }
        if (B(x50Var)) {
            A((bi2) x50Var);
        }
        this.u = x50Var;
        this.k.z(new m43(x50Var.f21879a, x50Var.b, this.j.m(x50Var, this, this.i.getMinimumLoadableRetryCount(x50Var.c))), x50Var.c, this.b, x50Var.d, x50Var.e, x50Var.f, x50Var.g, x50Var.h);
        return true;
    }

    public final void d0(d25[] d25VarArr) {
        this.s.clear();
        for (d25 d25Var : d25VarArr) {
            if (d25Var != null) {
                this.s.add((gi2) d25Var);
            }
        }
    }

    public void discardBuffer(long j, boolean z) {
        if (!this.C || C()) {
            return;
        }
        int length = this.v.length;
        for (int i = 0; i < length; i++) {
            this.v[i].q(j, z, this.O[i]);
        }
    }

    @Override // defpackage.qs1
    public void endTracks() {
        this.V = true;
        this.r.post(this.q);
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:506)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:509)
        */
    @Override // com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        /*
            r7 = this;
            boolean r0 = r7.U
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r7.C()
            if (r0 == 0) goto L10
            long r0 = r7.R
            return r0
        L10:
            long r0 = r7.Q
            bi2 r2 = r7.x()
            boolean r3 = r2.f()
            if (r3 == 0) goto L1d
            goto L36
        L1d:
            java.util.ArrayList<bi2> r2 = r7.n
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L35
            java.util.ArrayList<bi2> r2 = r7.n
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            bi2 r2 = (defpackage.bi2) r2
            goto L36
        L35:
            r2 = 0
        L36:
            if (r2 == 0) goto L3e
            long r2 = r2.h
            long r0 = java.lang.Math.max(r0, r2)
        L3e:
            boolean r2 = r7.C
            if (r2 == 0) goto L55
            ki2$d[] r2 = r7.v
            int r3 = r2.length
            r4 = 0
        L46:
            if (r4 >= r3) goto L55
            r5 = r2[r4]
            long r5 = r5.z()
            long r0 = java.lang.Math.max(r0, r5)
            int r4 = r4 + 1
            goto L46
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ki2.getBufferedPositionUs():long");
    }

    @Override // com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        if (C()) {
            return this.R;
        }
        if (this.U) {
            return Long.MIN_VALUE;
        }
        return x().h;
    }

    public vz5 getTrackGroups() {
        k();
        return this.J;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.j.i();
    }

    public final void k() {
        vh.g(this.E);
        vh.e(this.J);
        vh.e(this.K);
    }

    public int l(int i) {
        k();
        vh.e(this.L);
        int i2 = this.L[i];
        if (i2 == -1) {
            return this.K.contains(this.J.b(i)) ? -3 : -2;
        }
        boolean[] zArr = this.O;
        if (zArr[i2]) {
            return -2;
        }
        zArr[i2] = true;
        return i2;
    }

    public final void m() {
        m mVar;
        int length = this.v.length;
        int i = 0;
        int i2 = -2;
        int i3 = -1;
        while (true) {
            if (i >= length) {
                break;
            }
            String str = ((m) vh.i(this.v[i].F())).l;
            int i4 = fp3.s(str) ? 2 : fp3.o(str) ? 1 : fp3.r(str) ? 3 : -2;
            if (z(i4) > z(i2)) {
                i3 = i;
                i2 = i4;
            } else if (i4 == i2 && i3 != -1) {
                i3 = -1;
            }
            i++;
        }
        qz5 qz5VarJ = this.d.j();
        int i5 = qz5VarJ.f20360a;
        this.M = -1;
        this.L = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            this.L[i6] = i6;
        }
        qz5[] qz5VarArr = new qz5[length];
        int i7 = 0;
        while (i7 < length) {
            m mVar2 = (m) vh.i(this.v[i7].F());
            if (i7 == i3) {
                m[] mVarArr = new m[i5];
                for (int i8 = 0; i8 < i5; i8++) {
                    m mVarC = qz5VarJ.c(i8);
                    if (i2 == 1 && (mVar = this.f) != null) {
                        mVarC = mVarC.k(mVar);
                    }
                    mVarArr[i8] = i5 == 1 ? mVar2.k(mVarC) : s(mVarC, mVar2, true);
                }
                qz5VarArr[i7] = new qz5(this.f18696a, mVarArr);
                this.M = i7;
            } else {
                m mVar3 = (i2 == 2 && fp3.o(mVar2.l)) ? this.f : null;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f18696a);
                sb.append(":muxed:");
                sb.append(i7 < i3 ? i7 : i7 - 1);
                qz5VarArr[i7] = new qz5(sb.toString(), s(mVar3, mVar2, false));
            }
            i7++;
        }
        this.J = r(qz5VarArr);
        vh.g(this.K == null);
        this.K = Collections.emptySet();
    }

    public void maybeThrowPrepareError() throws IOException {
        H();
        if (this.U && !this.E) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    public final boolean n(int i) {
        for (int i2 = i; i2 < this.n.size(); i2++) {
            if (this.n.get(i2).n) {
                return false;
            }
        }
        bi2 bi2Var = this.n.get(i);
        for (int i3 = 0; i3 < this.v.length; i3++) {
            if (this.v[i3].C() > bi2Var.k(i3)) {
                return false;
            }
        }
        return true;
    }

    public void o() {
        if (this.E) {
            return;
        }
        continueLoading(this.Q);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void onLoaderReleased() {
        for (d dVar : this.v) {
            dVar.T();
        }
    }

    public final p q(int i, int i2) {
        int length = this.v.length;
        boolean z = true;
        if (i2 != 1 && i2 != 2) {
            z = false;
        }
        d dVar = new d(this.e, this.g, this.h, this.t);
        dVar.b0(this.Q);
        if (z) {
            dVar.i0(this.X);
        }
        dVar.a0(this.W);
        bi2 bi2Var = this.Y;
        if (bi2Var != null) {
            dVar.j0(bi2Var);
        }
        dVar.d0(this);
        int i3 = length + 1;
        int[] iArrCopyOf = Arrays.copyOf(this.w, i3);
        this.w = iArrCopyOf;
        iArrCopyOf[length] = i;
        this.v = (d[]) g86.K0(this.v, dVar);
        boolean[] zArrCopyOf = Arrays.copyOf(this.P, i3);
        this.P = zArrCopyOf;
        zArrCopyOf[length] = z;
        this.N |= z;
        this.x.add(Integer.valueOf(i2));
        this.y.append(i2, length);
        if (z(i2) > z(this.A)) {
            this.B = length;
            this.A = i2;
        }
        this.O = Arrays.copyOf(this.O, i3);
        return dVar;
    }

    public final vz5 r(qz5[] qz5VarArr) {
        for (int i = 0; i < qz5VarArr.length; i++) {
            qz5 qz5Var = qz5VarArr[i];
            m[] mVarArr = new m[qz5Var.f20360a];
            for (int i2 = 0; i2 < qz5Var.f20360a; i2++) {
                m mVarC = qz5Var.c(i2);
                mVarArr[i2] = mVarC.c(this.g.d(mVarC));
            }
            qz5VarArr[i] = new qz5(qz5Var.b, mVarArr);
        }
        return new vz5(qz5VarArr);
    }

    @Override // com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j) {
        if (this.j.h() || C()) {
            return;
        }
        if (this.j.i()) {
            vh.e(this.u);
            if (this.d.v(j, this.u, this.o)) {
                this.j.e();
                return;
            }
            return;
        }
        int size = this.o.size();
        while (size > 0 && this.d.c(this.o.get(size - 1)) == 2) {
            size--;
        }
        if (size < this.o.size()) {
            t(size);
        }
        int iH = this.d.h(j, this.o);
        if (iH < this.n.size()) {
            t(iH);
        }
    }

    public final void t(int i) {
        vh.g(!this.j.i());
        while (true) {
            if (i >= this.n.size()) {
                i = -1;
                break;
            } else if (n(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        long j = x().h;
        bi2 bi2VarU = u(i);
        if (this.n.isEmpty()) {
            this.R = this.Q;
        } else {
            ((bi2) bv2.g(this.n)).m();
        }
        this.U = false;
        this.k.C(this.A, bi2VarU.g, j);
    }

    @Override // defpackage.qs1
    public c06 track(int i, int i2) {
        c06 c06VarQ;
        if (!Z.contains(Integer.valueOf(i2))) {
            int i3 = 0;
            while (true) {
                c06[] c06VarArr = this.v;
                if (i3 >= c06VarArr.length) {
                    c06VarQ = null;
                    break;
                }
                if (this.w[i3] == i) {
                    c06VarQ = c06VarArr[i3];
                    break;
                }
                i3++;
            }
        } else {
            c06VarQ = y(i, i2);
        }
        if (c06VarQ == null) {
            if (this.V) {
                return p(i, i2);
            }
            c06VarQ = q(i, i2);
        }
        if (i2 != 5) {
            return c06VarQ;
        }
        if (this.z == null) {
            this.z = new c(c06VarQ, this.l);
        }
        return this.z;
    }

    public final bi2 u(int i) {
        bi2 bi2Var = this.n.get(i);
        ArrayList<bi2> arrayList = this.n;
        g86.S0(arrayList, i, arrayList.size());
        for (int i2 = 0; i2 < this.v.length; i2++) {
            this.v[i2].u(bi2Var.k(i2));
        }
        return bi2Var;
    }

    public final boolean v(bi2 bi2Var) {
        int i = bi2Var.k;
        int length = this.v.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.O[i2] && this.v[i2].Q() == i) {
                return false;
            }
        }
        return true;
    }

    public final bi2 x() {
        return this.n.get(r0.size() - 1);
    }

    @Nullable
    public final c06 y(int i, int i2) {
        vh.a(Z.contains(Integer.valueOf(i2)));
        int i3 = this.y.get(i2, -1);
        if (i3 == -1) {
            return null;
        }
        if (this.x.add(Integer.valueOf(i2))) {
            this.w[i3] = i;
        }
        return this.w[i3] == i ? this.v[i3] : p(i, i2);
    }

    @Override // defpackage.qs1
    public void d(v45 v45Var) {
    }
}
