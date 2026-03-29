package defpackage;

import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class so4 {
    public boolean c;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jy5 f20796a = new jy5(0);
    public long f = -9223372036854775807L;
    public long g = -9223372036854775807L;
    public long h = -9223372036854775807L;
    public final gc4 b = new gc4();

    public static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    public static long l(gc4 gc4Var) {
        int iF = gc4Var.f();
        if (gc4Var.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        gc4Var.l(bArr, 0, 9);
        gc4Var.U(iF);
        if (a(bArr)) {
            return m(bArr);
        }
        return -9223372036854775807L;
    }

    public static long m(byte[] bArr) {
        byte b = bArr[0];
        long j = (((((long) b) & 56) >> 3) << 30) | ((((long) b) & 3) << 28) | ((((long) bArr[1]) & 255) << 20);
        byte b2 = bArr[2];
        return j | (((((long) b2) & 248) >> 3) << 15) | ((((long) b2) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    public final int b(ps1 ps1Var) {
        this.b.R(g86.f);
        this.c = true;
        ps1Var.resetPeekPosition();
        return 0;
    }

    public long c() {
        return this.h;
    }

    public jy5 d() {
        return this.f20796a;
    }

    public boolean e() {
        return this.c;
    }

    public final int f(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }

    public int g(ps1 ps1Var, vk4 vk4Var) throws IOException {
        if (!this.e) {
            return j(ps1Var, vk4Var);
        }
        if (this.g == -9223372036854775807L) {
            return b(ps1Var);
        }
        if (!this.d) {
            return h(ps1Var, vk4Var);
        }
        long j = this.f;
        if (j == -9223372036854775807L) {
            return b(ps1Var);
        }
        long jB = this.f20796a.b(this.g) - this.f20796a.b(j);
        this.h = jB;
        if (jB < 0) {
            y53.i("PsDurationReader", "Invalid duration: " + this.h + ". Using TIME_UNSET instead.");
            this.h = -9223372036854775807L;
        }
        return b(ps1Var);
    }

    public final int h(ps1 ps1Var, vk4 vk4Var) throws IOException {
        int iMin = (int) Math.min(20000L, ps1Var.getLength());
        long j = 0;
        if (ps1Var.getPosition() != j) {
            vk4Var.f21468a = j;
            return 1;
        }
        this.b.Q(iMin);
        ps1Var.resetPeekPosition();
        ps1Var.peekFully(this.b.e(), 0, iMin);
        this.f = i(this.b);
        this.d = true;
        return 0;
    }

    public final long i(gc4 gc4Var) {
        int iG = gc4Var.g();
        for (int iF = gc4Var.f(); iF < iG - 3; iF++) {
            if (f(gc4Var.e(), iF) == 442) {
                gc4Var.U(iF + 4);
                long jL = l(gc4Var);
                if (jL != -9223372036854775807L) {
                    return jL;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final int j(ps1 ps1Var, vk4 vk4Var) throws IOException {
        long length = ps1Var.getLength();
        int iMin = (int) Math.min(20000L, length);
        long j = length - ((long) iMin);
        if (ps1Var.getPosition() != j) {
            vk4Var.f21468a = j;
            return 1;
        }
        this.b.Q(iMin);
        ps1Var.resetPeekPosition();
        ps1Var.peekFully(this.b.e(), 0, iMin);
        this.g = k(this.b);
        this.e = true;
        return 0;
    }

    public final long k(gc4 gc4Var) {
        int iF = gc4Var.f();
        for (int iG = gc4Var.g() - 4; iG >= iF; iG--) {
            if (f(gc4Var.e(), iG) == 442) {
                gc4Var.U(iG + 4);
                long jL = l(gc4Var);
                if (jL != -9223372036854775807L) {
                    return jL;
                }
            }
        }
        return -9223372036854775807L;
    }
}
