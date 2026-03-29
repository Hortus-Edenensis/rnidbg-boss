package defpackage;

import android.net.Uri;
import android.util.Pair;
import androidx.media3.muxer.MuxerUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m;
import com.huawei.openalliance.ad.constant.ai;
import com.lantern.auth.app.FunDC;
import com.zenmen.palmchat.groupchat.dao.GroupModifyResultVo;
import java.io.IOException;
import java.util.Map;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class oi6 implements os1 {
    public static final ys1 h = new ys1() { // from class: li6
        @Override // defpackage.ys1
        public final os1[] createExtractors() {
            return oi6.f();
        }

        @Override // defpackage.ys1
        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
            return vs1.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qs1 f19778a;
    public c06 b;
    public b e;
    public int c = 0;
    public long d = -1;
    public int f = -1;
    public long g = -1;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a implements b {
        public static final int[] m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        public static final int[] n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE, 157, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME, 209, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 253, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS, 307, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND, 408, 449, ai.u, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 598, MediaPlayer.MEDIA_PLAYER_OPTION_BACKGROUND_STATUS, 724, 796, 876, 963, FunDC.ID_AUTH_1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, GroupModifyResultVo.RESUL_CODE_INVITE_REALNAME, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final qs1 f19779a;
        public final c06 b;
        public final pi6 c;
        public final int d;
        public final byte[] e;
        public final gc4 f;
        public final int g;
        public final m h;
        public int i;
        public long j;
        public int k;
        public long l;

        public a(qs1 qs1Var, c06 c06Var, pi6 pi6Var) throws ParserException {
            this.f19779a = qs1Var;
            this.b = c06Var;
            this.c = pi6Var;
            int iMax = Math.max(1, pi6Var.c / 10);
            this.g = iMax;
            gc4 gc4Var = new gc4(pi6Var.g);
            gc4Var.z();
            int iZ = gc4Var.z();
            this.d = iZ;
            int i = pi6Var.b;
            int i2 = (((pi6Var.e - (i * 4)) * 8) / (pi6Var.f * i)) + 1;
            if (iZ == i2) {
                int iL = g86.l(iMax, iZ);
                this.e = new byte[pi6Var.e * iL];
                this.f = new gc4(iL * f(iZ, i));
                int i3 = ((pi6Var.c * pi6Var.e) * 8) / iZ;
                this.h = new m.b().g0("audio/raw").I(i3).b0(i3).Y(f(iMax, i)).J(pi6Var.b).h0(pi6Var.c).a0(2).G();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected frames per block: " + i2 + "; got: " + iZ, null);
        }

        public static int f(int i, int i2) {
            return i * 2 * i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0036 -> B:4:0x001c). Please report as a decompilation issue!!! */
        @Override // oi6.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(ps1 ps1Var, long j) throws IOException {
            int iD;
            int iL = g86.l(this.g - d(this.k), this.d) * this.c.e;
            boolean z = j == 0;
            while (!z) {
                if (this.i >= iL) {
                    break;
                }
                int i = ps1Var.read(this.e, this.i, (int) Math.min(iL - r2, j));
                if (i == -1) {
                    while (!z) {
                    }
                } else {
                    this.i += i;
                }
            }
            int i2 = this.i / this.c.e;
            if (i2 > 0) {
                b(this.e, i2, this.f);
                this.i -= i2 * this.c.e;
                int iG = this.f.g();
                this.b.d(this.f, iG);
                int i3 = this.k + iG;
                this.k = i3;
                int iD2 = d(i3);
                int i4 = this.g;
                if (iD2 >= i4) {
                    g(i4);
                }
            }
            if (z && (iD = d(this.k)) > 0) {
                g(iD);
            }
            return z;
        }

        public final void b(byte[] bArr, int i, gc4 gc4Var) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < this.c.b; i3++) {
                    c(bArr, i2, i3, gc4Var.e());
                }
            }
            int iE = e(this.d * i);
            gc4Var.U(0);
            gc4Var.T(iE);
        }

        public final void c(byte[] bArr, int i, int i2, byte[] bArr2) {
            pi6 pi6Var = this.c;
            int i3 = pi6Var.e;
            int i4 = pi6Var.b;
            int i5 = (i * i3) + (i2 * 4);
            int i6 = (i4 * 4) + i5;
            int i7 = (i3 / i4) - 4;
            int iQ = (short) (((bArr[i5 + 1] & UByte.MAX_VALUE) << 8) | (bArr[i5] & UByte.MAX_VALUE));
            int iMin = Math.min(bArr[i5 + 2] & UByte.MAX_VALUE, 88);
            int i8 = n[iMin];
            int i9 = ((i * this.d * i4) + i2) * 2;
            bArr2[i9] = (byte) (iQ & 255);
            bArr2[i9 + 1] = (byte) (iQ >> 8);
            for (int i10 = 0; i10 < i7 * 2; i10++) {
                int i11 = bArr[((i10 / 8) * i4 * 4) + i6 + ((i10 / 2) % 4)] & UByte.MAX_VALUE;
                int i12 = i10 % 2 == 0 ? i11 & 15 : i11 >> 4;
                int i13 = ((((i12 & 7) * 2) + 1) * i8) >> 3;
                if ((i12 & 8) != 0) {
                    i13 = -i13;
                }
                iQ = g86.q(iQ + i13, -32768, 32767);
                i9 += i4 * 2;
                bArr2[i9] = (byte) (iQ & 255);
                bArr2[i9 + 1] = (byte) (iQ >> 8);
                int i14 = iMin + m[i12];
                int[] iArr = n;
                iMin = g86.q(i14, 0, iArr.length - 1);
                i8 = iArr[iMin];
            }
        }

        public final int d(int i) {
            return i / (this.c.b * 2);
        }

        public final int e(int i) {
            return f(i, this.c.b);
        }

        public final void g(int i) {
            long jU0 = this.j + g86.U0(this.l, 1000000L, this.c.c);
            int iE = e(i);
            this.b.e(jU0, 1, iE, this.k - iE, null);
            this.l += (long) i;
            this.k -= iE;
        }

        @Override // oi6.b
        public void init(int i, long j) {
            this.f19779a.d(new ri6(this.c, this.d, i, j));
            this.b.b(this.h);
        }

        @Override // oi6.b
        public void reset(long j) {
            this.i = 0;
            this.j = j;
            this.k = 0;
            this.l = 0L;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        boolean a(ps1 ps1Var, long j) throws IOException;

        void init(int i, long j) throws ParserException;

        void reset(long j);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final qs1 f19780a;
        public final c06 b;
        public final pi6 c;
        public final m d;
        public final int e;
        public long f;
        public int g;
        public long h;

        public c(qs1 qs1Var, c06 c06Var, pi6 pi6Var, String str, int i) throws ParserException {
            this.f19780a = qs1Var;
            this.b = c06Var;
            this.c = pi6Var;
            int i2 = (pi6Var.b * pi6Var.f) / 8;
            if (pi6Var.e == i2) {
                int i3 = pi6Var.c;
                int i4 = i3 * i2 * 8;
                int iMax = Math.max(i2, (i3 * i2) / 10);
                this.e = iMax;
                this.d = new m.b().g0(str).I(i4).b0(i4).Y(iMax).J(pi6Var.b).h0(pi6Var.c).a0(i).G();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected block size: " + i2 + "; got: " + pi6Var.e, null);
        }

        @Override // oi6.b
        public boolean a(ps1 ps1Var, long j) throws IOException {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.g) < (i2 = this.e)) {
                int iC = this.b.c(ps1Var, (int) Math.min(i2 - i, j2), true);
                if (iC == -1) {
                    j2 = 0;
                } else {
                    this.g += iC;
                    j2 -= (long) iC;
                }
            }
            int i3 = this.c.e;
            int i4 = this.g / i3;
            if (i4 > 0) {
                long jU0 = this.f + g86.U0(this.h, 1000000L, r1.c);
                int i5 = i4 * i3;
                int i6 = this.g - i5;
                this.b.e(jU0, 1, i5, i6, null);
                this.h += (long) i4;
                this.g = i6;
            }
            return j2 <= 0;
        }

        @Override // oi6.b
        public void init(int i, long j) {
            this.f19780a.d(new ri6(this.c, 1, i, j));
            this.b.b(this.d);
        }

        @Override // oi6.b
        public void reset(long j) {
            this.f = j;
            this.g = 0;
            this.h = 0L;
        }
    }

    public static /* synthetic */ os1[] f() {
        return new os1[]{new oi6()};
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.f19778a = qs1Var;
        this.b = qs1Var.track(0, 1);
        qs1Var.endTracks();
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        e();
        int i = this.c;
        if (i == 0) {
            g(ps1Var);
            return 0;
        }
        if (i == 1) {
            i(ps1Var);
            return 0;
        }
        if (i == 2) {
            h(ps1Var);
            return 0;
        }
        if (i == 3) {
            k(ps1Var);
            return 0;
        }
        if (i == 4) {
            return j(ps1Var);
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        return qi6.a(ps1Var);
    }

    public final void e() {
        vh.i(this.b);
        g86.j(this.f19778a);
    }

    public final void g(ps1 ps1Var) throws IOException {
        vh.g(ps1Var.getPosition() == 0);
        int i = this.f;
        if (i != -1) {
            ps1Var.skipFully(i);
            this.c = 4;
        } else {
            if (!qi6.a(ps1Var)) {
                throw ParserException.createForMalformedContainer("Unsupported or unrecognized wav file type.", null);
            }
            ps1Var.skipFully((int) (ps1Var.getPeekPosition() - ps1Var.getPosition()));
            this.c = 1;
        }
    }

    public final void h(ps1 ps1Var) throws IOException {
        pi6 pi6VarB = qi6.b(ps1Var);
        int i = pi6VarB.f20024a;
        if (i == 17) {
            this.e = new a(this.f19778a, this.b, pi6VarB);
        } else if (i == 6) {
            this.e = new c(this.f19778a, this.b, pi6VarB, "audio/g711-alaw", -1);
        } else if (i == 7) {
            this.e = new c(this.f19778a, this.b, pi6VarB, "audio/g711-mlaw", -1);
        } else {
            int iA = si6.a(i, pi6VarB.f);
            if (iA == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Unsupported WAV format type: " + pi6VarB.f20024a);
            }
            this.e = new c(this.f19778a, this.b, pi6VarB, "audio/raw", iA);
        }
        this.c = 3;
    }

    public final void i(ps1 ps1Var) throws IOException {
        this.d = qi6.c(ps1Var);
        this.c = 2;
    }

    public final int j(ps1 ps1Var) throws IOException {
        vh.g(this.g != -1);
        return ((b) vh.e(this.e)).a(ps1Var, this.g - ps1Var.getPosition()) ? -1 : 0;
    }

    public final void k(ps1 ps1Var) throws IOException {
        Pair<Long, Long> pairE = qi6.e(ps1Var);
        this.f = ((Long) pairE.first).intValue();
        long jLongValue = ((Long) pairE.second).longValue();
        long j = this.d;
        if (j != -1 && jLongValue == MuxerUtil.UNSIGNED_INT_MAX_VALUE) {
            jLongValue = j;
        }
        this.g = ((long) this.f) + jLongValue;
        long length = ps1Var.getLength();
        if (length != -1 && this.g > length) {
            y53.i("WavExtractor", "Data exceeds input length: " + this.g + ", " + length);
            this.g = length;
        }
        ((b) vh.e(this.e)).init(this.f, this.g);
        this.c = 4;
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        this.c = j == 0 ? 0 : 4;
        b bVar = this.e;
        if (bVar != null) {
            bVar.reset(j2);
        }
    }

    @Override // defpackage.os1
    public void release() {
    }
}
