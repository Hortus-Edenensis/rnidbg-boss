package defpackage;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ParserException;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.uc.crashsdk.export.LogType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f17400a = {96000, 88200, 64000, 48000, 44100, LogType.UNEXP_KNOWN_REASON, ErrorCode.REASON_HLS_PLAYLIST_RESET, 22050, 16000, ErrorCode.REASON_TEE, 11025, 8000, 7350};
    public static final int[] b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17401a;
        public final int b;
        public final String c;

        public b(int i, int i2, String str) {
            this.f17401a = i;
            this.b = i2;
            this.c = str;
        }
    }

    public static byte[] a(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static int b(fc4 fc4Var) {
        int iH = fc4Var.h(5);
        return iH == 31 ? fc4Var.h(6) + 32 : iH;
    }

    public static int c(fc4 fc4Var) throws ParserException {
        int iH = fc4Var.h(4);
        if (iH == 15) {
            if (fc4Var.b() >= 24) {
                return fc4Var.h(24);
            }
            throw ParserException.createForMalformedContainer("AAC header insufficient data", null);
        }
        if (iH < 13) {
            return f17400a[iH];
        }
        throw ParserException.createForMalformedContainer("AAC header wrong Sampling Frequency Index", null);
    }

    public static b d(fc4 fc4Var, boolean z) throws ParserException {
        int iB = b(fc4Var);
        int iC = c(fc4Var);
        int iH = fc4Var.h(4);
        String str = "mp4a.40." + iB;
        if (iB == 5 || iB == 29) {
            iC = c(fc4Var);
            iB = b(fc4Var);
            if (iB == 22) {
                iH = fc4Var.h(4);
            }
        }
        if (z) {
            if (iB != 1 && iB != 2 && iB != 3 && iB != 4 && iB != 6 && iB != 7 && iB != 17) {
                switch (iB) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ParserException.createForUnsupportedContainerFeature("Unsupported audio object type: " + iB);
                }
            }
            f(fc4Var, iB, iH);
            switch (iB) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iH2 = fc4Var.h(2);
                    if (iH2 == 2 || iH2 == 3) {
                        throw ParserException.createForUnsupportedContainerFeature("Unsupported epConfig: " + iH2);
                    }
                    break;
            }
        }
        int i = b[iH];
        if (i != -1) {
            return new b(iC, i, str);
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static b e(byte[] bArr) throws ParserException {
        return d(new fc4(bArr), false);
    }

    public static void f(fc4 fc4Var, int i, int i2) {
        if (fc4Var.g()) {
            y53.i("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (fc4Var.g()) {
            fc4Var.r(14);
        }
        boolean zG = fc4Var.g();
        if (i2 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i == 6 || i == 20) {
            fc4Var.r(3);
        }
        if (zG) {
            if (i == 22) {
                fc4Var.r(16);
            }
            if (i == 17 || i == 19 || i == 20 || i == 23) {
                fc4Var.r(3);
            }
            fc4Var.r(1);
        }
    }
}
