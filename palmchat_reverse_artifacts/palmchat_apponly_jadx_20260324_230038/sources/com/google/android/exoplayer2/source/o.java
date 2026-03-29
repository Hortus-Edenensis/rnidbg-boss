package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.p;
import defpackage.c06;
import defpackage.g86;
import defpackage.gc4;
import defpackage.ir0;
import defpackage.ru0;
import defpackage.v9;
import defpackage.vh;
import defpackage.w9;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w9 f5980a;
    public final int b;
    public final gc4 c;
    public a d;
    public a e;
    public a f;
    public long g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements w9.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f5981a;
        public long b;

        @Nullable
        public v9 c;

        @Nullable
        public a d;

        public a(long j, int i) {
            c(j, i);
        }

        public a a() {
            this.c = null;
            a aVar = this.d;
            this.d = null;
            return aVar;
        }

        public void b(v9 v9Var, a aVar) {
            this.c = v9Var;
            this.d = aVar;
        }

        public void c(long j, int i) {
            vh.g(this.c == null);
            this.f5981a = j;
            this.b = j + ((long) i);
        }

        public int d(long j) {
            return ((int) (j - this.f5981a)) + this.c.b;
        }

        @Override // w9.a
        public v9 getAllocation() {
            return (v9) vh.e(this.c);
        }

        @Override // w9.a
        @Nullable
        public w9.a next() {
            a aVar = this.d;
            if (aVar == null || aVar.c == null) {
                return null;
            }
            return aVar;
        }
    }

    public o(w9 w9Var) {
        this.f5980a = w9Var;
        int individualAllocationLength = w9Var.getIndividualAllocationLength();
        this.b = individualAllocationLength;
        this.c = new gc4(32);
        a aVar = new a(0L, individualAllocationLength);
        this.d = aVar;
        this.e = aVar;
        this.f = aVar;
    }

    public static a d(a aVar, long j) {
        while (j >= aVar.b) {
            aVar = aVar.d;
        }
        return aVar;
    }

    public static a i(a aVar, long j, ByteBuffer byteBuffer, int i) {
        a aVarD = d(aVar, j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (aVarD.b - j));
            byteBuffer.put(aVarD.c.f21383a, aVarD.d(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == aVarD.b) {
                aVarD = aVarD.d;
            }
        }
        return aVarD;
    }

    public static a j(a aVar, long j, byte[] bArr, int i) {
        a aVarD = d(aVar, j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (aVarD.b - j));
            System.arraycopy(aVarD.c.f21383a, aVarD.d(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == aVarD.b) {
                aVarD = aVarD.d;
            }
        }
        return aVarD;
    }

    public static a k(a aVar, DecoderInputBuffer decoderInputBuffer, p.b bVar, gc4 gc4Var) {
        int iN;
        long j = bVar.b;
        gc4Var.Q(1);
        a aVarJ = j(aVar, j, gc4Var.e(), 1);
        long j2 = j + 1;
        byte b = gc4Var.e()[0];
        boolean z = (b & ByteCompanionObject.MIN_VALUE) != 0;
        int i = b & ByteCompanionObject.MAX_VALUE;
        ir0 ir0Var = decoderInputBuffer.b;
        byte[] bArr = ir0Var.f18240a;
        if (bArr == null) {
            ir0Var.f18240a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        a aVarJ2 = j(aVarJ, j2, ir0Var.f18240a, i);
        long j3 = j2 + ((long) i);
        if (z) {
            gc4Var.Q(2);
            aVarJ2 = j(aVarJ2, j3, gc4Var.e(), 2);
            j3 += 2;
            iN = gc4Var.N();
        } else {
            iN = 1;
        }
        int[] iArr = ir0Var.d;
        if (iArr == null || iArr.length < iN) {
            iArr = new int[iN];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = ir0Var.e;
        if (iArr3 == null || iArr3.length < iN) {
            iArr3 = new int[iN];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i2 = iN * 6;
            gc4Var.Q(i2);
            aVarJ2 = j(aVarJ2, j3, gc4Var.e(), i2);
            j3 += (long) i2;
            gc4Var.U(0);
            for (int i3 = 0; i3 < iN; i3++) {
                iArr2[i3] = gc4Var.N();
                iArr4[i3] = gc4Var.L();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = bVar.f5983a - ((int) (j3 - bVar.b));
        }
        c06.a aVar2 = (c06.a) g86.j(bVar.c);
        ir0Var.c(iN, iArr2, iArr4, aVar2.b, ir0Var.f18240a, aVar2.f1866a, aVar2.c, aVar2.d);
        long j4 = bVar.b;
        int i4 = (int) (j3 - j4);
        bVar.b = j4 + ((long) i4);
        bVar.f5983a -= i4;
        return aVarJ2;
    }

    public static a l(a aVar, DecoderInputBuffer decoderInputBuffer, p.b bVar, gc4 gc4Var) {
        if (decoderInputBuffer.o()) {
            aVar = k(aVar, decoderInputBuffer, bVar, gc4Var);
        }
        if (!decoderInputBuffer.e()) {
            decoderInputBuffer.m(bVar.f5983a);
            return i(aVar, bVar.b, decoderInputBuffer.c, bVar.f5983a);
        }
        gc4Var.Q(4);
        a aVarJ = j(aVar, bVar.b, gc4Var.e(), 4);
        int iL = gc4Var.L();
        bVar.b += 4;
        bVar.f5983a -= 4;
        decoderInputBuffer.m(iL);
        a aVarI = i(aVarJ, bVar.b, decoderInputBuffer.c, iL);
        bVar.b += (long) iL;
        int i = bVar.f5983a - iL;
        bVar.f5983a = i;
        decoderInputBuffer.q(i);
        return i(aVarI, bVar.b, decoderInputBuffer.f, bVar.f5983a);
    }

    public final void a(a aVar) {
        if (aVar.c == null) {
            return;
        }
        this.f5980a.b(aVar);
        aVar.a();
    }

    public void b(long j) {
        a aVar;
        if (j == -1) {
            return;
        }
        while (true) {
            aVar = this.d;
            if (j < aVar.b) {
                break;
            }
            this.f5980a.a(aVar.c);
            this.d = this.d.a();
        }
        if (this.e.f5981a < aVar.f5981a) {
            this.e = aVar;
        }
    }

    public void c(long j) {
        vh.a(j <= this.g);
        this.g = j;
        if (j != 0) {
            a aVar = this.d;
            if (j != aVar.f5981a) {
                while (this.g > aVar.b) {
                    aVar = aVar.d;
                }
                a aVar2 = (a) vh.e(aVar.d);
                a(aVar2);
                a aVar3 = new a(aVar.b, this.b);
                aVar.d = aVar3;
                if (this.g == aVar.b) {
                    aVar = aVar3;
                }
                this.f = aVar;
                if (this.e == aVar2) {
                    this.e = aVar3;
                    return;
                }
                return;
            }
        }
        a(this.d);
        a aVar4 = new a(this.g, this.b);
        this.d = aVar4;
        this.e = aVar4;
        this.f = aVar4;
    }

    public long e() {
        return this.g;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, p.b bVar) {
        l(this.e, decoderInputBuffer, bVar, this.c);
    }

    public final void g(int i) {
        long j = this.g + ((long) i);
        this.g = j;
        a aVar = this.f;
        if (j == aVar.b) {
            this.f = aVar.d;
        }
    }

    public final int h(int i) {
        a aVar = this.f;
        if (aVar.c == null) {
            aVar.b(this.f5980a.allocate(), new a(this.f.b, this.b));
        }
        return Math.min(i, (int) (this.f.b - this.g));
    }

    public void m(DecoderInputBuffer decoderInputBuffer, p.b bVar) {
        this.e = l(this.e, decoderInputBuffer, bVar, this.c);
    }

    public void n() {
        a(this.d);
        this.d.c(0L, this.b);
        a aVar = this.d;
        this.e = aVar;
        this.f = aVar;
        this.g = 0L;
        this.f5980a.trim();
    }

    public void o() {
        this.e = this.d;
    }

    public int p(ru0 ru0Var, int i, boolean z) throws IOException {
        int iH = h(i);
        a aVar = this.f;
        int i2 = ru0Var.read(aVar.c.f21383a, aVar.d(this.g), iH);
        if (i2 != -1) {
            g(i2);
            return i2;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public void q(gc4 gc4Var, int i) {
        while (i > 0) {
            int iH = h(i);
            a aVar = this.f;
            gc4Var.l(aVar.c.f21383a, aVar.d(this.g), iH);
            i -= iH;
            g(iH);
        }
    }
}
