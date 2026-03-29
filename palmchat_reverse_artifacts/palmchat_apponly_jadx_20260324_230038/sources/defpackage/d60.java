package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.drm.c;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.f;
import defpackage.e60;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class d60<T extends e60> implements d25, q, Loader.b<x50>, Loader.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16981a;
    public final int[] b;
    public final m[] c;
    public final boolean[] d;
    public final T e;
    public final q.a<d60<T>> f;
    public final j.a g;
    public final f h;
    public final Loader i;
    public final a60 j;
    public final ArrayList<fr> k;
    public final List<fr> l;
    public final p m;
    public final p[] n;
    public final hr o;

    @Nullable
    public x50 p;
    public m q;

    @Nullable
    public b<T> r;
    public long s;
    public long t;
    public int u;

    @Nullable
    public fr v;
    public boolean w;

    /* JADX INFO: compiled from: SearchBox */
    public interface b<T extends e60> {
        void d(d60<T> d60Var);
    }

    public d60(int i, @Nullable int[] iArr, @Nullable m[] mVarArr, T t, q.a<d60<T>> aVar, w9 w9Var, long j, c cVar, b.a aVar2, f fVar, j.a aVar3) {
        this.f16981a = i;
        int i2 = 0;
        iArr = iArr == null ? new int[0] : iArr;
        this.b = iArr;
        this.c = mVarArr == null ? new m[0] : mVarArr;
        this.e = t;
        this.f = aVar;
        this.g = aVar3;
        this.h = fVar;
        this.i = new Loader("ChunkSampleStream");
        this.j = new a60();
        ArrayList<fr> arrayList = new ArrayList<>();
        this.k = arrayList;
        this.l = Collections.unmodifiableList(arrayList);
        int length = iArr.length;
        this.n = new p[length];
        this.d = new boolean[length];
        int i3 = length + 1;
        int[] iArr2 = new int[i3];
        p[] pVarArr = new p[i3];
        p pVarK = p.k(w9Var, cVar, aVar2);
        this.m = pVarK;
        iArr2[0] = i;
        pVarArr[0] = pVarK;
        while (i2 < length) {
            p pVarL = p.l(w9Var);
            this.n[i2] = pVarL;
            int i4 = i2 + 1;
            pVarArr[i4] = pVarL;
            iArr2[i4] = this.b[i2];
            i2 = i4;
        }
        this.o = new hr(iArr2, pVarArr);
        this.s = j;
        this.t = j;
    }

    public final int A(int i, int i2) {
        do {
            i2++;
            if (i2 >= this.k.size()) {
                return this.k.size() - 1;
            }
        } while (this.k.get(i2).g(0) <= i);
        return i2 - 1;
    }

    public void B(@Nullable b<T> bVar) {
        this.r = bVar;
        this.m.R();
        for (p pVar : this.n) {
            pVar.R();
        }
        this.i.l(this);
    }

    public final void C() {
        this.m.V();
        for (p pVar : this.n) {
            pVar.V();
        }
    }

    public void D(long j) {
        fr frVar;
        this.t = j;
        if (u()) {
            this.s = j;
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            frVar = this.k.get(i2);
            long j2 = frVar.g;
            if (j2 == j && frVar.k == -9223372036854775807L) {
                break;
            } else {
                if (j2 > j) {
                    break;
                }
            }
        }
        frVar = null;
        if (frVar != null ? this.m.Y(frVar.g(0)) : this.m.Z(j, j < getNextLoadPositionUs())) {
            this.u = A(this.m.C(), 0);
            p[] pVarArr = this.n;
            int length = pVarArr.length;
            while (i < length) {
                pVarArr[i].Z(j, true);
                i++;
            }
            return;
        }
        this.s = j;
        this.w = false;
        this.k.clear();
        this.u = 0;
        if (!this.i.i()) {
            this.i.f();
            C();
            return;
        }
        this.m.r();
        p[] pVarArr2 = this.n;
        int length2 = pVarArr2.length;
        while (i < length2) {
            pVarArr2[i].r();
            i++;
        }
        this.i.e();
    }

    public d60<T>.a E(long j, int i) {
        for (int i2 = 0; i2 < this.n.length; i2++) {
            if (this.b[i2] == i) {
                vh.g(!this.d[i2]);
                this.d[i2] = true;
                this.n[i2].Z(j, true);
                return new a(this, this.n[i2], i2);
            }
        }
        throw new IllegalStateException();
    }

    public long a(long j, w45 w45Var) {
        return this.e.a(j, w45Var);
    }

    @Override // defpackage.d25
    public int c(f12 f12Var, DecoderInputBuffer decoderInputBuffer, int i) {
        if (u()) {
            return -3;
        }
        fr frVar = this.v;
        if (frVar != null && frVar.g(0) <= this.m.C()) {
            return -3;
        }
        v();
        return this.m.S(f12Var, decoderInputBuffer, i, this.w);
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j) {
        List<fr> listEmptyList;
        long j2;
        if (this.w || this.i.i() || this.i.h()) {
            return false;
        }
        boolean zU = u();
        if (zU) {
            listEmptyList = Collections.emptyList();
            j2 = this.s;
        } else {
            listEmptyList = this.l;
            j2 = r().h;
        }
        this.e.d(j, j2, listEmptyList, this.j);
        a60 a60Var = this.j;
        boolean z = a60Var.b;
        x50 x50Var = a60Var.f1159a;
        a60Var.a();
        if (z) {
            this.s = -9223372036854775807L;
            this.w = true;
            return true;
        }
        if (x50Var == null) {
            return false;
        }
        this.p = x50Var;
        if (t(x50Var)) {
            fr frVar = (fr) x50Var;
            if (zU) {
                long j3 = frVar.g;
                long j4 = this.s;
                if (j3 != j4) {
                    this.m.b0(j4);
                    for (p pVar : this.n) {
                        pVar.b0(this.s);
                    }
                }
                this.s = -9223372036854775807L;
            }
            frVar.i(this.o);
            this.k.add(frVar);
        } else if (x50Var instanceof ys2) {
            ((ys2) x50Var).e(this.o);
        }
        this.g.z(new m43(x50Var.f21879a, x50Var.b, this.i.m(x50Var, this, this.h.getMinimumLoadableRetryCount(x50Var.c))), x50Var.c, this.f16981a, x50Var.d, x50Var.e, x50Var.f, x50Var.g, x50Var.h);
        return true;
    }

    public void discardBuffer(long j, boolean z) {
        if (u()) {
            return;
        }
        int iX = this.m.x();
        this.m.q(j, z, true);
        int iX2 = this.m.x();
        if (iX2 > iX) {
            long jY = this.m.y();
            int i = 0;
            while (true) {
                p[] pVarArr = this.n;
                if (i >= pVarArr.length) {
                    break;
                }
                pVarArr[i].q(jY, z, this.d[i]);
                i++;
            }
        }
        n(iX2);
    }

    @Override // com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        if (this.w) {
            return Long.MIN_VALUE;
        }
        if (u()) {
            return this.s;
        }
        long jMax = this.t;
        fr frVarR = r();
        if (!frVarR.f()) {
            if (this.k.size() > 1) {
                frVarR = this.k.get(r2.size() - 2);
            } else {
                frVarR = null;
            }
        }
        if (frVarR != null) {
            jMax = Math.max(jMax, frVarR.h);
        }
        return Math.max(jMax, this.m.z());
    }

    @Override // com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        if (u()) {
            return this.s;
        }
        if (this.w) {
            return Long.MIN_VALUE;
        }
        return r().h;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.i.i();
    }

    @Override // defpackage.d25
    public boolean isReady() {
        return !u() && this.m.K(this.w);
    }

    @Override // defpackage.d25
    public void maybeThrowError() throws IOException {
        this.i.maybeThrowError();
        this.m.N();
        if (this.i.i()) {
            return;
        }
        this.e.maybeThrowError();
    }

    public final void n(int i) {
        int iMin = Math.min(A(i, 0), this.u);
        if (iMin > 0) {
            g86.S0(this.k, 0, iMin);
            this.u -= iMin;
        }
    }

    public final void o(int i) {
        vh.g(!this.i.i());
        int size = this.k.size();
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (!s(i)) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        long j = r().h;
        fr frVarP = p(i);
        if (this.k.isEmpty()) {
            this.s = this.t;
        }
        this.w = false;
        this.g.C(this.f16981a, frVarP.g, j);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void onLoaderReleased() {
        this.m.T();
        for (p pVar : this.n) {
            pVar.T();
        }
        this.e.release();
        b<T> bVar = this.r;
        if (bVar != null) {
            bVar.d(this);
        }
    }

    public final fr p(int i) {
        fr frVar = this.k.get(i);
        ArrayList<fr> arrayList = this.k;
        g86.S0(arrayList, i, arrayList.size());
        this.u = Math.max(this.u, this.k.size());
        int i2 = 0;
        this.m.u(frVar.g(0));
        while (true) {
            p[] pVarArr = this.n;
            if (i2 >= pVarArr.length) {
                return frVar;
            }
            p pVar = pVarArr[i2];
            i2++;
            pVar.u(frVar.g(i2));
        }
    }

    public T q() {
        return this.e;
    }

    public final fr r() {
        return this.k.get(r0.size() - 1);
    }

    @Override // com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j) {
        if (this.i.h() || u()) {
            return;
        }
        if (!this.i.i()) {
            int preferredQueueSize = this.e.getPreferredQueueSize(j, this.l);
            if (preferredQueueSize < this.k.size()) {
                o(preferredQueueSize);
                return;
            }
            return;
        }
        x50 x50Var = (x50) vh.e(this.p);
        if (!(t(x50Var) && s(this.k.size() - 1)) && this.e.b(j, x50Var, this.l)) {
            this.i.e();
            if (t(x50Var)) {
                this.v = (fr) x50Var;
            }
        }
    }

    public final boolean s(int i) {
        int iC;
        fr frVar = this.k.get(i);
        if (this.m.C() > frVar.g(0)) {
            return true;
        }
        int i2 = 0;
        do {
            p[] pVarArr = this.n;
            if (i2 >= pVarArr.length) {
                return false;
            }
            iC = pVarArr[i2].C();
            i2++;
        } while (iC <= frVar.g(i2));
        return true;
    }

    @Override // defpackage.d25
    public int skipData(long j) {
        if (u()) {
            return 0;
        }
        int iE = this.m.E(j, this.w);
        fr frVar = this.v;
        if (frVar != null) {
            iE = Math.min(iE, frVar.g(0) - this.m.C());
        }
        this.m.e0(iE);
        v();
        return iE;
    }

    public final boolean t(x50 x50Var) {
        return x50Var instanceof fr;
    }

    public boolean u() {
        return this.s != -9223372036854775807L;
    }

    public final void v() {
        int iA = A(this.m.C(), this.u - 1);
        while (true) {
            int i = this.u;
            if (i > iA) {
                return;
            }
            this.u = i + 1;
            w(i);
        }
    }

    public final void w(int i) {
        fr frVar = this.k.get(i);
        m mVar = frVar.d;
        if (!mVar.equals(this.q)) {
            this.g.h(this.f16981a, mVar, frVar.e, frVar.f, frVar.g);
        }
        this.q = mVar;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void e(x50 x50Var, long j, long j2, boolean z) {
        this.p = null;
        this.v = null;
        m43 m43Var = new m43(x50Var.f21879a, x50Var.b, x50Var.d(), x50Var.c(), j, j2, x50Var.a());
        this.h.onLoadTaskConcluded(x50Var.f21879a);
        this.g.q(m43Var, x50Var.c, this.f16981a, x50Var.d, x50Var.e, x50Var.f, x50Var.g, x50Var.h);
        if (z) {
            return;
        }
        if (u()) {
            C();
        } else if (t(x50Var)) {
            p(this.k.size() - 1);
            if (this.k.isEmpty()) {
                this.s = this.t;
            }
        }
        this.f.c(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public void f(x50 x50Var, long j, long j2) {
        this.p = null;
        this.e.e(x50Var);
        m43 m43Var = new m43(x50Var.f21879a, x50Var.b, x50Var.d(), x50Var.c(), j, j2, x50Var.a());
        this.h.onLoadTaskConcluded(x50Var.f21879a);
        this.g.t(m43Var, x50Var.c, this.f16981a, x50Var.d, x50Var.e, x50Var.f, x50Var.g, x50Var.h);
        this.f.c(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Loader.c j(x50 x50Var, long j, long j2, IOException iOException, int i) {
        Loader.c cVarG;
        long jA = x50Var.a();
        boolean zT = t(x50Var);
        int size = this.k.size() - 1;
        boolean z = (jA != 0 && zT && s(size)) ? false : true;
        m43 m43Var = new m43(x50Var.f21879a, x50Var.b, x50Var.d(), x50Var.c(), j, j2, jA);
        f.c cVar = new f.c(m43Var, new kh3(x50Var.c, this.f16981a, x50Var.d, x50Var.e, x50Var.f, g86.m1(x50Var.g), g86.m1(x50Var.h)), iOException, i);
        if (!this.e.f(x50Var, z, cVar, this.h)) {
            cVarG = null;
        } else if (z) {
            cVarG = Loader.f;
            if (zT) {
                vh.g(p(size) == x50Var);
                if (this.k.isEmpty()) {
                    this.s = this.t;
                }
            }
        } else {
            y53.i("ChunkSampleStream", "Ignoring attempt to cancel non-cancelable load.");
            cVarG = null;
        }
        if (cVarG == null) {
            long jA2 = this.h.a(cVar);
            cVarG = jA2 != -9223372036854775807L ? Loader.g(false, jA2) : Loader.g;
        }
        boolean z2 = !cVarG.c();
        this.g.v(m43Var, x50Var.c, this.f16981a, x50Var.d, x50Var.e, x50Var.f, x50Var.g, x50Var.h, iOException, z2);
        if (z2) {
            this.p = null;
            this.h.onLoadTaskConcluded(x50Var.f21879a);
            this.f.c(this);
        }
        return cVarG;
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class a implements d25 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d60<T> f16982a;
        public final p b;
        public final int c;
        public boolean d;

        public a(d60<T> d60Var, p pVar, int i) {
            this.f16982a = d60Var;
            this.b = pVar;
            this.c = i;
        }

        public final void a() {
            if (this.d) {
                return;
            }
            d60.this.g.h(d60.this.b[this.c], d60.this.c[this.c], 0, null, d60.this.t);
            this.d = true;
        }

        public void b() {
            vh.g(d60.this.d[this.c]);
            d60.this.d[this.c] = false;
        }

        @Override // defpackage.d25
        public int c(f12 f12Var, DecoderInputBuffer decoderInputBuffer, int i) {
            if (d60.this.u()) {
                return -3;
            }
            if (d60.this.v != null && d60.this.v.g(this.c + 1) <= this.b.C()) {
                return -3;
            }
            a();
            return this.b.S(f12Var, decoderInputBuffer, i, d60.this.w);
        }

        @Override // defpackage.d25
        public boolean isReady() {
            return !d60.this.u() && this.b.K(d60.this.w);
        }

        @Override // defpackage.d25
        public int skipData(long j) {
            if (d60.this.u()) {
                return 0;
            }
            int iE = this.b.E(j, d60.this.w);
            if (d60.this.v != null) {
                iE = Math.min(iE, d60.this.v.g(this.c + 1) - this.b.C());
            }
            this.b.e0(iE);
            if (iE > 0) {
                a();
            }
            return iE;
        }

        @Override // defpackage.d25
        public void maybeThrowError() {
        }
    }
}
