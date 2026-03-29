package defpackage;

import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import defpackage.ys;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ro4 extends ys {

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements ys.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jy5 f20518a;
        public final gc4 b;

        public static void c(gc4 gc4Var) {
            int iK;
            int iG = gc4Var.g();
            if (gc4Var.a() < 10) {
                gc4Var.U(iG);
                return;
            }
            gc4Var.V(9);
            int iH = gc4Var.H() & 7;
            if (gc4Var.a() < iH) {
                gc4Var.U(iG);
                return;
            }
            gc4Var.V(iH);
            if (gc4Var.a() < 4) {
                gc4Var.U(iG);
                return;
            }
            if (ro4.k(gc4Var.e(), gc4Var.f()) == 443) {
                gc4Var.V(4);
                int iN = gc4Var.N();
                if (gc4Var.a() < iN) {
                    gc4Var.U(iG);
                    return;
                }
                gc4Var.V(iN);
            }
            while (gc4Var.a() >= 4 && (iK = ro4.k(gc4Var.e(), gc4Var.f())) != 442 && iK != 441 && (iK >>> 8) == 1) {
                gc4Var.V(4);
                if (gc4Var.a() < 2) {
                    gc4Var.U(iG);
                    return;
                }
                gc4Var.U(Math.min(gc4Var.g(), gc4Var.f() + gc4Var.N()));
            }
        }

        @Override // ys.f
        public ys.e a(ps1 ps1Var, long j) throws IOException {
            long position = ps1Var.getPosition();
            int iMin = (int) Math.min(20000L, ps1Var.getLength() - position);
            this.b.Q(iMin);
            ps1Var.peekFully(this.b.e(), 0, iMin);
            return b(this.b, j, position);
        }

        public final ys.e b(gc4 gc4Var, long j, long j2) {
            int iF = -1;
            long j3 = -9223372036854775807L;
            int iF2 = -1;
            while (gc4Var.a() >= 4) {
                if (ro4.k(gc4Var.e(), gc4Var.f()) != 442) {
                    gc4Var.V(1);
                } else {
                    gc4Var.V(4);
                    long jL = so4.l(gc4Var);
                    if (jL != -9223372036854775807L) {
                        long jB = this.f20518a.b(jL);
                        if (jB > j) {
                            return j3 == -9223372036854775807L ? ys.e.d(jB, j2) : ys.e.e(j2 + ((long) iF2));
                        }
                        if (SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US + jB > j) {
                            return ys.e.e(j2 + ((long) gc4Var.f()));
                        }
                        iF2 = gc4Var.f();
                        j3 = jB;
                    }
                    c(gc4Var);
                    iF = gc4Var.f();
                }
            }
            return j3 != -9223372036854775807L ? ys.e.f(j3, j2 + ((long) iF)) : ys.e.d;
        }

        @Override // ys.f
        public void onSeekFinished() {
            this.b.R(g86.f);
        }

        public b(jy5 jy5Var) {
            this.f20518a = jy5Var;
            this.b = new gc4();
        }
    }

    public ro4(jy5 jy5Var, long j, long j2) {
        super(new ys.b(), new b(jy5Var), j, 0L, j + 1, 0L, j2, 188L, 1000);
    }

    public static int k(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }
}
