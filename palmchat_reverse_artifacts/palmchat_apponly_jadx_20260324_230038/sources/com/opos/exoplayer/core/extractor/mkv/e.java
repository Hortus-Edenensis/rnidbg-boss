package com.opos.exoplayer.core.extractor.mkv;

import com.opos.exoplayer.core.extractor.f;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long[] f8193a = {128, 64, 32, 16, 8, 4, 2, 1};
    private final byte[] b = new byte[8];
    private int c;
    private int d;

    public static int a(int i) {
        long j;
        int i2 = 0;
        do {
            long[] jArr = f8193a;
            if (i2 >= jArr.length) {
                return -1;
            }
            j = jArr[i2] & ((long) i);
            i2++;
        } while (j == 0);
        return i2;
    }

    public int b() {
        return this.d;
    }

    public long a(f fVar, boolean z, boolean z2, int i) {
        if (this.c == 0) {
            if (!fVar.a(this.b, 0, 1, z)) {
                return -1L;
            }
            int iA = a(this.b[0] & UByte.MAX_VALUE);
            this.d = iA;
            if (iA == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.c = 1;
        }
        int i2 = this.d;
        if (i2 > i) {
            this.c = 0;
            return -2L;
        }
        if (i2 != 1) {
            fVar.b(this.b, 1, i2 - 1);
        }
        this.c = 0;
        return a(this.b, this.d, z2);
    }

    public static long a(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= ~f8193a[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }

    public void a() {
        this.c = 0;
        this.d = 0;
    }
}
