package com.opos.exoplayer.core.extractor.mkv;

import com.opos.exoplayer.core.extractor.f;
import com.opos.exoplayer.core.m;
import java.util.Stack;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class a implements com.opos.exoplayer.core.extractor.mkv.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f8190a = new byte[8];
    private final Stack<b> b = new Stack<>();
    private final e c = new e();
    private c d;
    private int e;
    private int f;
    private long g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8191a;
        private final long b;

        private b(int i, long j) {
            this.f8191a = i;
            this.b = j;
        }
    }

    private long a(f fVar, int i) {
        fVar.b(this.f8190a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.f8190a[i2] & UByte.MAX_VALUE));
        }
        return j;
    }

    private double b(f fVar, int i) {
        return i == 4 ? Float.intBitsToFloat((int) r0) : Double.longBitsToDouble(a(fVar, i));
    }

    private String c(f fVar, int i) {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        fVar.b(bArr, 0, i);
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        return new String(bArr, 0, i);
    }

    private long b(f fVar) {
        fVar.a();
        while (true) {
            fVar.c(this.f8190a, 0, 4);
            int iA = e.a(this.f8190a[0]);
            if (iA != -1 && iA <= 4) {
                int iA2 = (int) e.a(this.f8190a, iA, false);
                if (this.d.b(iA2)) {
                    fVar.b(iA);
                    return iA2;
                }
            }
            fVar.b(1);
        }
    }

    @Override // com.opos.exoplayer.core.extractor.mkv.b
    public void a() {
        this.e = 0;
        this.b.clear();
        this.c.a();
    }

    @Override // com.opos.exoplayer.core.extractor.mkv.b
    public void a(c cVar) {
        this.d = cVar;
    }

    @Override // com.opos.exoplayer.core.extractor.mkv.b
    public boolean a(f fVar) throws m {
        com.opos.exoplayer.core.util.a.b(this.d != null);
        while (true) {
            if (!this.b.isEmpty() && fVar.c() >= this.b.peek().b) {
                this.d.c(this.b.pop().f8191a);
                return true;
            }
            if (this.e == 0) {
                long jA = this.c.a(fVar, true, false, 4);
                if (jA == -2) {
                    jA = b(fVar);
                }
                if (jA == -1) {
                    return false;
                }
                this.f = (int) jA;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.c.a(fVar, false, true, 8);
                this.e = 2;
            }
            int iA = this.d.a(this.f);
            if (iA != 0) {
                if (iA == 1) {
                    long jC = fVar.c();
                    this.b.add(new b(this.f, this.g + jC));
                    this.d.a(this.f, jC, this.g);
                    this.e = 0;
                    return true;
                }
                if (iA == 2) {
                    long j = this.g;
                    if (j <= 8) {
                        this.d.a(this.f, a(fVar, (int) j));
                        this.e = 0;
                        return true;
                    }
                    throw new m("Invalid integer size: " + this.g);
                }
                if (iA == 3) {
                    long j2 = this.g;
                    if (j2 <= 2147483647L) {
                        this.d.a(this.f, c(fVar, (int) j2));
                        this.e = 0;
                        return true;
                    }
                    throw new m("String element size: " + this.g);
                }
                if (iA == 4) {
                    this.d.a(this.f, (int) this.g, fVar);
                    this.e = 0;
                    return true;
                }
                if (iA != 5) {
                    throw new m("Invalid element type " + iA);
                }
                long j3 = this.g;
                if (j3 == 4 || j3 == 8) {
                    this.d.a(this.f, b(fVar, (int) j3));
                    this.e = 0;
                    return true;
                }
                throw new m("Invalid float size: " + this.g);
            }
            fVar.b((int) this.g);
            this.e = 0;
        }
    }
}
