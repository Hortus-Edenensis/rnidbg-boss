package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.ClippingMediaSource;
import com.google.android.exoplayer2.source.h;
import defpackage.d25;
import defpackage.f12;
import defpackage.fp3;
import defpackage.g86;
import defpackage.or1;
import defpackage.vh;
import defpackage.vz5;
import defpackage.w45;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class b implements h, h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f5933a;

    @Nullable
    public h.a b;
    public a[] c = new a[0];
    public long d;
    public long e;
    public long f;

    @Nullable
    public ClippingMediaSource.IllegalClippingException g;

    /* JADX INFO: compiled from: SearchBox */
    public final class a implements d25 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d25 f5934a;
        public boolean b;

        public a(d25 d25Var) {
            this.f5934a = d25Var;
        }

        public void a() {
            this.b = false;
        }

        @Override // defpackage.d25
        public int c(f12 f12Var, DecoderInputBuffer decoderInputBuffer, int i) {
            if (b.this.h()) {
                return -3;
            }
            if (this.b) {
                decoderInputBuffer.k(4);
                return -4;
            }
            long bufferedPositionUs = b.this.getBufferedPositionUs();
            int iC = this.f5934a.c(f12Var, decoderInputBuffer, i);
            if (iC == -5) {
                com.google.android.exoplayer2.m mVar = (com.google.android.exoplayer2.m) vh.e(f12Var.b);
                int i2 = mVar.B;
                if (i2 != 0 || mVar.C != 0) {
                    b bVar = b.this;
                    if (bVar.e != 0) {
                        i2 = 0;
                    }
                    f12Var.b = mVar.b().P(i2).Q(bVar.f == Long.MIN_VALUE ? mVar.C : 0).G();
                }
                return -5;
            }
            long j = b.this.f;
            if (j == Long.MIN_VALUE || ((iC != -4 || decoderInputBuffer.e < j) && !(iC == -3 && bufferedPositionUs == Long.MIN_VALUE && !decoderInputBuffer.d))) {
                return iC;
            }
            decoderInputBuffer.b();
            decoderInputBuffer.k(4);
            this.b = true;
            return -4;
        }

        @Override // defpackage.d25
        public boolean isReady() {
            return !b.this.h() && this.f5934a.isReady();
        }

        @Override // defpackage.d25
        public void maybeThrowError() throws IOException {
            this.f5934a.maybeThrowError();
        }

        @Override // defpackage.d25
        public int skipData(long j) {
            if (b.this.h()) {
                return -3;
            }
            return this.f5934a.skipData(j);
        }
    }

    public b(h hVar, boolean z, long j, long j2) {
        this.f5933a = hVar;
        this.d = z ? j : -9223372036854775807L;
        this.e = j;
        this.f = j2;
    }

    public static boolean k(long j, or1[] or1VarArr) {
        if (j != 0) {
            for (or1 or1Var : or1VarArr) {
                if (or1Var != null) {
                    com.google.android.exoplayer2.m selectedFormat = or1Var.getSelectedFormat();
                    if (!fp3.a(selectedFormat.l, selectedFormat.i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j, w45 w45Var) {
        long j2 = this.e;
        if (j == j2) {
            return j2;
        }
        return this.f5933a.a(j, d(j, w45Var));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    @Override // com.google.android.exoplayer2.source.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long b(or1[] or1VarArr, boolean[] zArr, d25[] d25VarArr, boolean[] zArr2, long j) {
        long j2;
        boolean z;
        this.c = new a[d25VarArr.length];
        d25[] d25VarArr2 = new d25[d25VarArr.length];
        int i = 0;
        while (true) {
            d25 d25Var = null;
            if (i >= d25VarArr.length) {
                break;
            }
            a[] aVarArr = this.c;
            a aVar = (a) d25VarArr[i];
            aVarArr[i] = aVar;
            if (aVar != null) {
                d25Var = aVar.f5934a;
            }
            d25VarArr2[i] = d25Var;
            i++;
        }
        long jB = this.f5933a.b(or1VarArr, zArr, d25VarArr2, zArr2, j);
        if (h()) {
            long j3 = this.e;
            j2 = (j == j3 && k(j3, or1VarArr)) ? jB : -9223372036854775807L;
        }
        this.d = j2;
        if (jB == j) {
            z = true;
        } else {
            if (jB >= this.e) {
                long j4 = this.f;
                if (j4 == Long.MIN_VALUE || jB <= j4) {
                }
            }
            z = false;
        }
        vh.g(z);
        for (int i2 = 0; i2 < d25VarArr.length; i2++) {
            d25 d25Var2 = d25VarArr2[i2];
            if (d25Var2 == null) {
                this.c[i2] = null;
            } else {
                a[] aVarArr2 = this.c;
                a aVar2 = aVarArr2[i2];
                if (aVar2 == null || aVar2.f5934a != d25Var2) {
                    aVarArr2[i2] = new a(d25Var2);
                }
            }
            d25VarArr[i2] = this.c[i2];
        }
        return jB;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j) {
        return this.f5933a.continueLoading(j);
    }

    public final w45 d(long j, w45 w45Var) {
        long jR = g86.r(w45Var.f21618a, 0L, j - this.e);
        long j2 = w45Var.b;
        long j3 = this.f;
        long jR2 = g86.r(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        return (jR == w45Var.f21618a && jR2 == w45Var.b) ? w45Var : new w45(jR, jR2);
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j, boolean z) {
        this.f5933a.discardBuffer(j, z);
    }

    @Override // com.google.android.exoplayer2.source.h.a
    public void f(h hVar) {
        if (this.g != null) {
            return;
        }
        ((h.a) vh.e(this.b)).f(this);
    }

    @Override // com.google.android.exoplayer2.source.h
    public void g(h.a aVar, long j) {
        this.b = aVar;
        this.f5933a.g(this, j);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.f5933a.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j = this.f;
            if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.f5933a.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j = this.f;
            if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.h
    public vz5 getTrackGroups() {
        return this.f5933a.getTrackGroups();
    }

    public boolean h() {
        return this.d != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.q.a
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void c(h hVar) {
        ((h.a) vh.e(this.b)).c(this);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.f5933a.isLoading();
    }

    public void j(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.g = illegalClippingException;
    }

    public void l(long j, long j2) {
        this.e = j;
        this.f = j2;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() throws IOException {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.g;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        this.f5933a.maybeThrowPrepareError();
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        if (h()) {
            long j = this.d;
            this.d = -9223372036854775807L;
            long discontinuity = readDiscontinuity();
            return discontinuity != -9223372036854775807L ? discontinuity : j;
        }
        long discontinuity2 = this.f5933a.readDiscontinuity();
        if (discontinuity2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        vh.g(discontinuity2 >= this.e);
        long j2 = this.f;
        if (j2 != Long.MIN_VALUE && discontinuity2 > j2) {
            z = false;
        }
        vh.g(z);
        return discontinuity2;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j) {
        this.f5933a.reevaluateBuffer(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    @Override // com.google.android.exoplayer2.source.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long seekToUs(long j) {
        this.d = -9223372036854775807L;
        boolean z = false;
        for (a aVar : this.c) {
            if (aVar != null) {
                aVar.a();
            }
        }
        long jSeekToUs = this.f5933a.seekToUs(j);
        if (jSeekToUs == j) {
            z = true;
        } else if (jSeekToUs >= this.e) {
            long j2 = this.f;
            if (j2 == Long.MIN_VALUE || jSeekToUs <= j2) {
            }
        }
        vh.g(z);
        return jSeekToUs;
    }
}
