package com.opos.exoplayer.core.source;

import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.decoder.DecoderInputBuffer;
import com.opos.exoplayer.core.extractor.n;
import com.opos.exoplayer.core.source.j;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class k implements com.opos.exoplayer.core.extractor.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.exoplayer.core.upstream.b f8301a;
    private final int b;
    private final j c;
    private final j.a d;
    private final com.opos.exoplayer.core.util.p e;
    private b f;
    private b g;
    private b h;
    private Format i;
    private boolean j;
    private Format k;
    private long l;
    private long m;
    private boolean n;
    private a o;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(Format format);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f8302a;
        public final long b;
        public boolean c;

        @Nullable
        public com.opos.exoplayer.core.upstream.a d;

        @Nullable
        public b e;

        public b(long j, int i) {
            this.f8302a = j;
            this.b = j + ((long) i);
        }

        public int a(long j) {
            return ((int) (j - this.f8302a)) + this.d.b;
        }

        public b a() {
            this.d = null;
            b bVar = this.e;
            this.e = null;
            return bVar;
        }

        public void a(com.opos.exoplayer.core.upstream.a aVar, b bVar) {
            this.d = aVar;
            this.e = bVar;
            this.c = true;
        }
    }

    public k(com.opos.exoplayer.core.upstream.b bVar) {
        this.f8301a = bVar;
        int iC = bVar.c();
        this.b = iC;
        this.c = new j();
        this.d = new j.a();
        this.e = new com.opos.exoplayer.core.util.p(32);
        b bVar2 = new b(0L, iC);
        this.f = bVar2;
        this.g = bVar2;
        this.h = bVar2;
    }

    private int a(int i) {
        b bVar = this.h;
        if (!bVar.c) {
            bVar.a(this.f8301a.a(), new b(this.h.b, this.b));
        }
        return Math.min(i, (int) (this.h.b - this.m));
    }

    public int b() {
        return this.c.a();
    }

    public boolean c() {
        return this.c.c();
    }

    public int d() {
        return this.c.b();
    }

    public Format e() {
        return this.c.d();
    }

    public long f() {
        return this.c.e();
    }

    public void g() {
        this.c.f();
        this.g = this.f;
    }

    public void h() {
        b(this.c.h());
    }

    public int i() {
        return this.c.g();
    }

    @Override // com.opos.exoplayer.core.extractor.n
    public int a(com.opos.exoplayer.core.extractor.f fVar, int i, boolean z) throws EOFException {
        int iA = a(i);
        b bVar = this.h;
        int iA2 = fVar.a(bVar.d.f8371a, bVar.a(this.m), iA);
        if (iA2 != -1) {
            b(iA2);
            return iA2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public int b(long j, boolean z, boolean z2) {
        return this.c.a(j, z, z2);
    }

    private void b(int i) {
        long j = this.m + ((long) i);
        this.m = j;
        b bVar = this.h;
        if (j == bVar.b) {
            this.h = bVar.e;
        }
    }

    public int a(com.opos.exoplayer.core.j jVar, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, long j) {
        int iA = this.c.a(jVar, decoderInputBuffer, z, z2, this.i, this.d);
        if (iA == -5) {
            this.i = jVar.f8252a;
            return -5;
        }
        if (iA != -4) {
            if (iA == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!decoderInputBuffer.c()) {
            if (decoderInputBuffer.c < j) {
                decoderInputBuffer.b(Integer.MIN_VALUE);
            }
            if (decoderInputBuffer.g()) {
                a(decoderInputBuffer, this.d);
            }
            decoderInputBuffer.e(this.d.f8300a);
            j.a aVar = this.d;
            a(aVar.b, decoderInputBuffer.b, aVar.f8300a);
        }
        return -4;
    }

    private static Format a(Format format, long j) {
        if (format == null) {
            return null;
        }
        if (j == 0) {
            return format;
        }
        long j2 = format.w;
        return j2 != Long.MAX_VALUE ? format.a(j2 + j) : format;
    }

    private void b(long j) {
        b bVar;
        if (j == -1) {
            return;
        }
        while (true) {
            bVar = this.f;
            if (j < bVar.b) {
                break;
            }
            this.f8301a.a(bVar.d);
            this.f = this.f.a();
        }
        if (this.g.f8302a < bVar.f8302a) {
            this.g = bVar;
        }
    }

    public void a() {
        a(false);
    }

    private void a(long j) {
        while (true) {
            b bVar = this.g;
            if (j < bVar.b) {
                return;
            } else {
                this.g = bVar.e;
            }
        }
    }

    @Override // com.opos.exoplayer.core.extractor.n
    public void a(long j, int i, int i2, int i3, n.a aVar) {
        if (this.j) {
            a(this.k);
        }
        if (this.n) {
            if ((i & 1) == 0 || !this.c.b(j)) {
                return;
            } else {
                this.n = false;
            }
        }
        this.c.a(j + this.l, i, (this.m - ((long) i2)) - ((long) i3), i2, aVar);
    }

    private void a(long j, ByteBuffer byteBuffer, int i) {
        a(j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (this.g.b - j));
            b bVar = this.g;
            byteBuffer.put(bVar.d.f8371a, bVar.a(j), iMin);
            i -= iMin;
            j += (long) iMin;
            b bVar2 = this.g;
            if (j == bVar2.b) {
                this.g = bVar2.e;
            }
        }
    }

    public void a(long j, boolean z, boolean z2) {
        b(this.c.b(j, z, z2));
    }

    private void a(long j, byte[] bArr, int i) {
        a(j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (this.g.b - j));
            b bVar = this.g;
            System.arraycopy(bVar.d.f8371a, bVar.a(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            b bVar2 = this.g;
            if (j == bVar2.b) {
                this.g = bVar2.e;
            }
        }
    }

    @Override // com.opos.exoplayer.core.extractor.n
    public void a(Format format) {
        Format formatA = a(format, this.l);
        boolean zA = this.c.a(formatA);
        this.k = format;
        this.j = false;
        a aVar = this.o;
        if (aVar == null || !zA) {
            return;
        }
        aVar.a(formatA);
    }

    private void a(DecoderInputBuffer decoderInputBuffer, j.a aVar) {
        int iH;
        long j = aVar.b;
        this.e.a(1);
        a(j, this.e.f8400a, 1);
        long j2 = j + 1;
        byte b2 = this.e.f8400a[0];
        boolean z = (b2 & ByteCompanionObject.MIN_VALUE) != 0;
        int i = b2 & ByteCompanionObject.MAX_VALUE;
        com.opos.exoplayer.core.decoder.b bVar = decoderInputBuffer.f8130a;
        if (bVar.f8132a == null) {
            bVar.f8132a = new byte[16];
        }
        a(j2, bVar.f8132a, i);
        long j3 = j2 + ((long) i);
        if (z) {
            this.e.a(2);
            a(j3, this.e.f8400a, 2);
            j3 += 2;
            iH = this.e.h();
        } else {
            iH = 1;
        }
        com.opos.exoplayer.core.decoder.b bVar2 = decoderInputBuffer.f8130a;
        int[] iArr = bVar2.d;
        if (iArr == null || iArr.length < iH) {
            iArr = new int[iH];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = bVar2.e;
        if (iArr3 == null || iArr3.length < iH) {
            iArr3 = new int[iH];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i2 = iH * 6;
            this.e.a(i2);
            a(j3, this.e.f8400a, i2);
            j3 += (long) i2;
            this.e.c(0);
            for (int i3 = 0; i3 < iH; i3++) {
                iArr2[i3] = this.e.h();
                iArr4[i3] = this.e.u();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar.f8300a - ((int) (j3 - aVar.b));
        }
        n.a aVar2 = aVar.c;
        com.opos.exoplayer.core.decoder.b bVar3 = decoderInputBuffer.f8130a;
        bVar3.a(iH, iArr2, iArr4, aVar2.b, bVar3.f8132a, aVar2.f8219a, aVar2.c, aVar2.d);
        long j4 = aVar.b;
        int i4 = (int) (j3 - j4);
        aVar.b = j4 + ((long) i4);
        aVar.f8300a -= i4;
    }

    public void a(a aVar) {
        this.o = aVar;
    }

    private void a(b bVar) {
        if (bVar.c) {
            b bVar2 = this.h;
            boolean z = bVar2.c;
            int i = (z ? 1 : 0) + (((int) (bVar2.f8302a - bVar.f8302a)) / this.b);
            com.opos.exoplayer.core.upstream.a[] aVarArr = new com.opos.exoplayer.core.upstream.a[i];
            for (int i2 = 0; i2 < i; i2++) {
                aVarArr[i2] = bVar.d;
                bVar = bVar.a();
            }
            this.f8301a.a(aVarArr);
        }
    }

    @Override // com.opos.exoplayer.core.extractor.n
    public void a(com.opos.exoplayer.core.util.p pVar, int i) {
        while (i > 0) {
            int iA = a(i);
            b bVar = this.h;
            pVar.a(bVar.d.f8371a, bVar.a(this.m), iA);
            i -= iA;
            b(iA);
        }
    }

    public void a(boolean z) {
        this.c.a(z);
        a(this.f);
        b bVar = new b(0L, this.b);
        this.f = bVar;
        this.g = bVar;
        this.h = bVar;
        this.m = 0L;
        this.f8301a.b();
    }
}
