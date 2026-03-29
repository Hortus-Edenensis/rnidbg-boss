package defpackage;

import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import defpackage.ys;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class c26 extends ys {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements ys.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jy5 f1884a;
        public final gc4 b = new gc4();
        public final int c;
        public final int d;

        public a(int i, jy5 jy5Var, int i2) {
            this.c = i;
            this.f1884a = jy5Var;
            this.d = i2;
        }

        @Override // ys.f
        public ys.e a(ps1 ps1Var, long j) throws IOException {
            long position = ps1Var.getPosition();
            int iMin = (int) Math.min(this.d, ps1Var.getLength() - position);
            this.b.Q(iMin);
            ps1Var.peekFully(this.b.e(), 0, iMin);
            return b(this.b, j, position);
        }

        public final ys.e b(gc4 gc4Var, long j, long j2) {
            int iA;
            int iA2;
            int iG = gc4Var.g();
            long j3 = -1;
            long j4 = -1;
            long j5 = -9223372036854775807L;
            while (gc4Var.a() >= 188 && (iA2 = (iA = k26.a(gc4Var.e(), gc4Var.f(), iG)) + 188) <= iG) {
                long jC = k26.c(gc4Var, iA, this.c);
                if (jC != -9223372036854775807L) {
                    long jB = this.f1884a.b(jC);
                    if (jB > j) {
                        return j5 == -9223372036854775807L ? ys.e.d(jB, j2) : ys.e.e(j2 + j4);
                    }
                    if (SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US + jB > j) {
                        return ys.e.e(j2 + ((long) iA));
                    }
                    j4 = iA;
                    j5 = jB;
                }
                gc4Var.U(iA2);
                j3 = iA2;
            }
            return j5 != -9223372036854775807L ? ys.e.f(j5, j2 + j3) : ys.e.d;
        }

        @Override // ys.f
        public void onSeekFinished() {
            this.b.R(g86.f);
        }
    }

    public c26(jy5 jy5Var, long j, long j2, int i, int i2) {
        super(new ys.b(), new a(i, jy5Var, i2), j, 0L, j + 1, 0L, j2, 188L, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PARAMS);
    }
}
