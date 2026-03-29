package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.f;
import defpackage.cv0;
import defpackage.d25;
import defpackage.f12;
import defpackage.fp3;
import defpackage.g86;
import defpackage.kh3;
import defpackage.m43;
import defpackage.or1;
import defpackage.qz5;
import defpackage.rk5;
import defpackage.u06;
import defpackage.vh;
import defpackage.vz5;
import defpackage.w45;
import defpackage.y53;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class r implements h, Loader.b<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f5985a;
    public final a.InterfaceC0360a b;

    @Nullable
    public final u06 c;
    public final com.google.android.exoplayer2.upstream.f d;
    public final j.a e;
    public final vz5 f;
    public final long h;
    public final com.google.android.exoplayer2.m j;
    public final boolean k;
    public boolean l;
    public byte[] m;
    public int n;
    public final ArrayList<b> g = new ArrayList<>();
    public final Loader i = new Loader("SingleSampleMediaPeriod");

    /* JADX INFO: compiled from: SearchBox */
    public final class b implements d25 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5986a;
        public boolean b;

        public b() {
        }

        public final void a() {
            if (this.b) {
                return;
            }
            r.this.e.h(fp3.k(r.this.j.l), r.this.j, 0, null, 0L);
            this.b = true;
        }

        public void b() {
            if (this.f5986a == 2) {
                this.f5986a = 1;
            }
        }

        @Override // defpackage.d25
        public int c(f12 f12Var, DecoderInputBuffer decoderInputBuffer, int i) {
            a();
            r rVar = r.this;
            boolean z = rVar.l;
            if (z && rVar.m == null) {
                this.f5986a = 2;
            }
            int i2 = this.f5986a;
            if (i2 == 2) {
                decoderInputBuffer.a(4);
                return -4;
            }
            if ((i & 2) != 0 || i2 == 0) {
                f12Var.b = rVar.j;
                this.f5986a = 1;
                return -5;
            }
            if (!z) {
                return -3;
            }
            vh.e(rVar.m);
            decoderInputBuffer.a(1);
            decoderInputBuffer.e = 0L;
            if ((i & 4) == 0) {
                decoderInputBuffer.m(r.this.n);
                ByteBuffer byteBuffer = decoderInputBuffer.c;
                r rVar2 = r.this;
                byteBuffer.put(rVar2.m, 0, rVar2.n);
            }
            if ((i & 1) == 0) {
                this.f5986a = 2;
            }
            return -4;
        }

        @Override // defpackage.d25
        public boolean isReady() {
            return r.this.l;
        }

        @Override // defpackage.d25
        public void maybeThrowError() throws IOException {
            r rVar = r.this;
            if (rVar.k) {
                return;
            }
            rVar.i.maybeThrowError();
        }

        @Override // defpackage.d25
        public int skipData(long j) {
            a();
            if (j <= 0 || this.f5986a == 2) {
                return 0;
            }
            this.f5986a = 2;
            return 1;
        }
    }

    public r(com.google.android.exoplayer2.upstream.b bVar, a.InterfaceC0360a interfaceC0360a, @Nullable u06 u06Var, com.google.android.exoplayer2.m mVar, long j, com.google.android.exoplayer2.upstream.f fVar, j.a aVar, boolean z) {
        this.f5985a = bVar;
        this.b = interfaceC0360a;
        this.c = u06Var;
        this.j = mVar;
        this.h = j;
        this.d = fVar;
        this.e = aVar;
        this.k = z;
        this.f = new vz5(new qz5(mVar));
    }

    @Override // com.google.android.exoplayer2.source.h
    public long b(or1[] or1VarArr, boolean[] zArr, d25[] d25VarArr, boolean[] zArr2, long j) {
        for (int i = 0; i < or1VarArr.length; i++) {
            d25 d25Var = d25VarArr[i];
            if (d25Var != null && (or1VarArr[i] == null || !zArr[i])) {
                this.g.remove(d25Var);
                d25VarArr[i] = null;
            }
            if (d25VarArr[i] == null && or1VarArr[i] != null) {
                b bVar = new b();
                this.g.add(bVar);
                d25VarArr[i] = bVar;
                zArr2[i] = true;
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j) {
        if (this.l || this.i.i() || this.i.h()) {
            return false;
        }
        com.google.android.exoplayer2.upstream.a aVarCreateDataSource = this.b.createDataSource();
        u06 u06Var = this.c;
        if (u06Var != null) {
            aVarCreateDataSource.b(u06Var);
        }
        c cVar = new c(this.f5985a, aVarCreateDataSource);
        this.e.z(new m43(cVar.f5987a, this.f5985a, this.i.m(cVar, this, this.d.getMinimumLoadableRetryCount(1))), 1, -1, this.j, 0, null, 0L, this.h);
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void e(c cVar, long j, long j2, boolean z) {
        rk5 rk5Var = cVar.c;
        m43 m43Var = new m43(cVar.f5987a, cVar.b, rk5Var.d(), rk5Var.e(), j, j2, rk5Var.c());
        this.d.onLoadTaskConcluded(cVar.f5987a);
        this.e.q(m43Var, 1, -1, null, 0, null, 0L, this.h);
    }

    @Override // com.google.android.exoplayer2.source.h
    public void g(h.a aVar, long j) {
        aVar.f(this);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        return this.l ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        return (this.l || this.i.i()) ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.h
    public vz5 getTrackGroups() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void f(c cVar, long j, long j2) {
        this.n = (int) cVar.c.c();
        this.m = (byte[]) vh.e(cVar.d);
        this.l = true;
        rk5 rk5Var = cVar.c;
        m43 m43Var = new m43(cVar.f5987a, cVar.b, rk5Var.d(), rk5Var.e(), j, j2, this.n);
        this.d.onLoadTaskConcluded(cVar.f5987a);
        this.e.t(m43Var, 1, -1, this.j, 0, null, 0L, this.h);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Loader.c j(c cVar, long j, long j2, IOException iOException, int i) {
        Loader.c cVarG;
        rk5 rk5Var = cVar.c;
        m43 m43Var = new m43(cVar.f5987a, cVar.b, rk5Var.d(), rk5Var.e(), j, j2, rk5Var.c());
        long jA = this.d.a(new f.c(m43Var, new kh3(1, -1, this.j, 0, null, 0L, g86.m1(this.h)), iOException, i));
        boolean z = jA == -9223372036854775807L || i >= this.d.getMinimumLoadableRetryCount(1);
        if (this.k && z) {
            y53.j("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.l = true;
            cVarG = Loader.f;
        } else {
            cVarG = jA != -9223372036854775807L ? Loader.g(false, jA) : Loader.g;
        }
        Loader.c cVar2 = cVarG;
        boolean z2 = !cVar2.c();
        this.e.v(m43Var, 1, -1, this.j, 0, null, 0L, this.h, iOException, z2);
        if (z2) {
            this.d.onLoadTaskConcluded(cVar.f5987a);
        }
        return cVar2;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.i.i();
    }

    public void k() {
        this.i.k();
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j) {
        for (int i = 0; i < this.g.size(); i++) {
            this.g.get(i).b();
        }
        return j;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements Loader.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f5987a = m43.a();
        public final com.google.android.exoplayer2.upstream.b b;
        public final rk5 c;

        @Nullable
        public byte[] d;

        public c(com.google.android.exoplayer2.upstream.b bVar, com.google.android.exoplayer2.upstream.a aVar) {
            this.b = bVar;
            this.c = new rk5(aVar);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void load() throws IOException {
            this.c.f();
            try {
                this.c.a(this.b);
                int i = 0;
                while (i != -1) {
                    int iC = (int) this.c.c();
                    byte[] bArr = this.d;
                    if (bArr == null) {
                        this.d = new byte[1024];
                    } else if (iC == bArr.length) {
                        this.d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    rk5 rk5Var = this.c;
                    byte[] bArr2 = this.d;
                    i = rk5Var.read(bArr2, iC, bArr2.length - iC);
                }
            } finally {
                cv0.a(this.c);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void cancelLoad() {
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() {
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j) {
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j, w45 w45Var) {
        return j;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j, boolean z) {
    }
}
