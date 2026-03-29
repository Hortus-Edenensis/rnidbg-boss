package com.opos.exoplayer.core.extractor.b;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.extractor.b.i;
import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.extractor.m;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class d extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.exoplayer.core.util.i f8166a;
    private a b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements g, l {
        private long[] b;
        private long[] c;
        private long d = -1;
        private long e = -1;

        public a() {
        }

        @Override // com.opos.exoplayer.core.extractor.b.g
        public long a(long j) {
            long jB = d.this.b(j);
            this.e = this.b[y.a(this.b, jB, true, true)];
            return jB;
        }

        @Override // com.opos.exoplayer.core.extractor.l
        public long b() {
            return d.this.f8166a.b();
        }

        @Override // com.opos.exoplayer.core.extractor.b.g
        public l c() {
            return this;
        }

        @Override // com.opos.exoplayer.core.extractor.b.g
        public long a(com.opos.exoplayer.core.extractor.f fVar) {
            long j = this.e;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.e = -1L;
            return j2;
        }

        @Override // com.opos.exoplayer.core.extractor.l
        public l.a b(long j) {
            int iA = y.a(this.b, d.this.b(j), true, true);
            long jA = d.this.a(this.b[iA]);
            m mVar = new m(jA, this.d + this.c[iA]);
            if (jA < j) {
                long[] jArr = this.b;
                if (iA != jArr.length - 1) {
                    int i = iA + 1;
                    return new l.a(mVar, new m(d.this.a(jArr[i]), this.d + this.c[i]));
                }
            }
            return new l.a(mVar);
        }

        public void c(long j) {
            this.d = j;
        }

        public void a(p pVar) {
            pVar.d(1);
            int iK = pVar.k() / 18;
            this.b = new long[iK];
            this.c = new long[iK];
            for (int i = 0; i < iK; i++) {
                this.b[i] = pVar.q();
                this.c[i] = pVar.q();
                pVar.d(2);
            }
        }

        @Override // com.opos.exoplayer.core.extractor.l
        public boolean a() {
            return true;
        }
    }

    private int c(p pVar) {
        int i;
        int i2;
        int i3 = (pVar.f8400a[2] & UByte.MAX_VALUE) >> 4;
        switch (i3) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                i = i3 - 2;
                i2 = 576;
                break;
            case 6:
            case 7:
                pVar.d(4);
                pVar.A();
                int iG = i3 == 6 ? pVar.g() : pVar.h();
                pVar.c(0);
                return iG + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i = i3 - 8;
                i2 = 256;
                break;
            default:
                return -1;
        }
        return i2 << i;
    }

    @Override // com.opos.exoplayer.core.extractor.b.i
    public long b(p pVar) {
        if (a(pVar.f8400a)) {
            return c(pVar);
        }
        return -1L;
    }

    @Override // com.opos.exoplayer.core.extractor.b.i
    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.f8166a = null;
            this.b = null;
        }
    }

    public static boolean a(p pVar) {
        return pVar.b() >= 5 && pVar.g() == 127 && pVar.m() == 1179402563;
    }

    @Override // com.opos.exoplayer.core.extractor.b.i
    public boolean a(p pVar, long j, i.b bVar) {
        byte[] bArr = pVar.f8400a;
        if (this.f8166a == null) {
            this.f8166a = new com.opos.exoplayer.core.util.i(bArr, 17);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 9, pVar.c());
            bArrCopyOfRange[4] = ByteCompanionObject.MIN_VALUE;
            List listSingletonList = Collections.singletonList(bArrCopyOfRange);
            int iA = this.f8166a.a();
            com.opos.exoplayer.core.util.i iVar = this.f8166a;
            bVar.f8172a = Format.a(null, "audio/flac", null, -1, iA, iVar.f, iVar.e, listSingletonList, null, 0, null);
            return true;
        }
        if ((bArr[0] & ByteCompanionObject.MAX_VALUE) == 3) {
            a aVar = new a();
            this.b = aVar;
            aVar.a(pVar);
            return true;
        }
        if (!a(bArr)) {
            return true;
        }
        a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.c(j);
            bVar.b = this.b;
        }
        return false;
    }

    private static boolean a(byte[] bArr) {
        return bArr[0] == -1;
    }
}
