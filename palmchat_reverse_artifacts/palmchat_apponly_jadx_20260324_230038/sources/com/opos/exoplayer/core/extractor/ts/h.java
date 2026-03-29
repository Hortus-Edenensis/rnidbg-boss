package com.opos.exoplayer.core.extractor.ts;

import android.util.Pair;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.ts.s;
import com.ss.android.ttvecamera.TELogUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double[] f8230a = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String b;
    private com.opos.exoplayer.core.extractor.n c;
    private boolean d;
    private long e;
    private final boolean[] f = new boolean[4];
    private final a g = new a(128);
    private long h;
    private boolean i;
    private long j;
    private long k;
    private long l;
    private boolean m;
    private boolean n;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        private static final byte[] d = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8231a;
        public int b;
        public byte[] c;
        private boolean e;

        public a(int i) {
            this.c = new byte[i];
        }

        public void a() {
            this.e = false;
            this.f8231a = 0;
            this.b = 0;
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.e) {
                int i3 = i2 - i;
                byte[] bArr2 = this.c;
                int length = bArr2.length;
                int i4 = this.f8231a + i3;
                if (length < i4) {
                    this.c = Arrays.copyOf(bArr2, i4 * 2);
                }
                System.arraycopy(bArr, i, this.c, this.f8231a, i3);
                this.f8231a += i3;
            }
        }

        public boolean a(int i, int i2) {
            if (this.e) {
                int i3 = this.f8231a - i2;
                this.f8231a = i3;
                if (this.b != 0 || i != 181) {
                    this.e = false;
                    return true;
                }
                this.b = i3;
            } else if (i == 179) {
                this.e = true;
            }
            byte[] bArr = d;
            a(bArr, 0, bArr.length);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair<Format, Long> a(a aVar, String str) {
        float f;
        int i;
        float f2;
        int i2;
        long j;
        byte[] bArrCopyOf = Arrays.copyOf(aVar.c, aVar.f8231a);
        int i3 = bArrCopyOf[4] & UByte.MAX_VALUE;
        int i4 = bArrCopyOf[5] & UByte.MAX_VALUE;
        int i5 = (i3 << 4) | (i4 >> 4);
        int i6 = ((i4 & 15) << 8) | (bArrCopyOf[6] & UByte.MAX_VALUE);
        int i7 = (bArrCopyOf[7] & 240) >> 4;
        if (i7 == 2) {
            f = i6 * 4;
            i = i5 * 3;
        } else if (i7 == 3) {
            f = i6 * 16;
            i = i5 * 9;
        } else {
            if (i7 != 4) {
                f2 = 1.0f;
                Format formatA = Format.a(str, "video/mpeg2", (String) null, -1, -1, i5, i6, -1.0f, (List<byte[]>) Collections.singletonList(bArrCopyOf), -1, f2, (DrmInitData) null);
                i2 = (bArrCopyOf[7] & 15) - 1;
                if (i2 < 0) {
                    double[] dArr = f8230a;
                    if (i2 < dArr.length) {
                        double d = dArr[i2];
                        byte b = bArrCopyOf[aVar.b + 9];
                        int i8 = (b & 96) >> 5;
                        int i9 = b & TELogUtils.DEBUG_LEVEL_V;
                        if (i8 != i9) {
                            d *= (((double) i8) + 1.0d) / ((double) (i9 + 1));
                        }
                        j = (long) (1000000.0d / d);
                    } else {
                        j = 0;
                    }
                }
                return Pair.create(formatA, Long.valueOf(j));
            }
            f = i6 * 121;
            i = i5 * 100;
        }
        f2 = f / i;
        Format formatA2 = Format.a(str, "video/mpeg2", (String) null, -1, -1, i5, i6, -1.0f, (List<byte[]>) Collections.singletonList(bArrCopyOf), -1, f2, (DrmInitData) null);
        i2 = (bArrCopyOf[7] & 15) - 1;
        if (i2 < 0) {
        }
        return Pair.create(formatA2, Long.valueOf(j));
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a() {
        com.opos.exoplayer.core.util.n.a(this.f);
        this.g.a();
        this.h = 0L;
        this.i = false;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(long j, boolean z) {
        this.j = j;
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.extractor.g gVar, s.d dVar) {
        dVar.a();
        this.b = dVar.c();
        this.c = gVar.a(dVar.b(), 2);
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void a(com.opos.exoplayer.core.util.p pVar) {
        int iD = pVar.d();
        int iC = pVar.c();
        byte[] bArr = pVar.f8400a;
        this.h += (long) pVar.b();
        this.c.a(pVar, pVar.b());
        while (true) {
            int iA = com.opos.exoplayer.core.util.n.a(bArr, iD, iC, this.f);
            if (iA == iC) {
                break;
            }
            int i = iA + 3;
            int i2 = pVar.f8400a[i] & UByte.MAX_VALUE;
            if (!this.d) {
                int i3 = iA - iD;
                if (i3 > 0) {
                    this.g.a(bArr, iD, iA);
                }
                if (this.g.a(i2, i3 < 0 ? -i3 : 0)) {
                    Pair<Format, Long> pairA = a(this.g, this.b);
                    this.c.a((Format) pairA.first);
                    this.e = ((Long) pairA.second).longValue();
                    this.d = true;
                }
            }
            if (i2 == 0 || i2 == 179) {
                int i4 = iC - iA;
                if (this.i && this.n && this.d) {
                    this.c.a(this.l, this.m ? 1 : 0, ((int) (this.h - this.k)) - i4, i4, null);
                }
                boolean z = this.i;
                if (!z || this.n) {
                    this.k = this.h - ((long) i4);
                    long j = this.j;
                    if (j == -9223372036854775807L) {
                        j = z ? this.l + this.e : 0L;
                    }
                    this.l = j;
                    this.m = false;
                    this.j = -9223372036854775807L;
                    this.i = true;
                }
                this.n = i2 == 0;
            } else if (i2 == 184) {
                this.m = true;
            }
            iD = i;
        }
        if (this.d) {
            return;
        }
        this.g.a(bArr, iD, iC);
    }

    @Override // com.opos.exoplayer.core.extractor.ts.g
    public void b() {
    }
}
