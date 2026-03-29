package com.opos.exoplayer.core.util;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.uc.crashsdk.export.LogType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f8391a = {0, 0, 0, 1};
    private static final int[] b = {96000, 88200, 64000, 48000, 44100, LogType.UNEXP_KNOWN_REASON, ErrorCode.REASON_HLS_PLAYLIST_RESET, 22050, 16000, ErrorCode.REASON_TEE, 11025, 8000, 7350};
    private static final int[] c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    private static int a(o oVar) {
        int iC = oVar.c(5);
        return iC == 31 ? oVar.c(6) + 32 : iC;
    }

    private static int b(o oVar) {
        int iC = oVar.c(4);
        if (iC == 15) {
            return oVar.c(24);
        }
        a.a(iC < 13);
        return b[iC];
    }

    public static Pair<Integer, Integer> a(o oVar, boolean z) throws com.opos.exoplayer.core.m {
        int iA = a(oVar);
        int iB = b(oVar);
        int iC = oVar.c(4);
        if (iA == 5 || iA == 29) {
            iB = b(oVar);
            iA = a(oVar);
            if (iA == 22) {
                iC = oVar.c(4);
            }
        }
        if (z) {
            if (iA != 6 && iA != 7 && iA != 17 && iA != 1 && iA != 2 && iA != 3 && iA != 4) {
                switch (iA) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new com.opos.exoplayer.core.m("Unsupported audio object type: " + iA);
                }
            }
            a(oVar, iA, iC);
            switch (iA) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iC2 = oVar.c(2);
                    if (iC2 == 2 || iC2 == 3) {
                        throw new com.opos.exoplayer.core.m("Unsupported epConfig: " + iC2);
                    }
                    break;
            }
        }
        int i = c[iC];
        a.a(i != -1);
        return Pair.create(Integer.valueOf(iB), Integer.valueOf(i));
    }

    public static Pair<Integer, Integer> a(byte[] bArr) {
        return a(new o(bArr), false);
    }

    private static void a(o oVar, int i, int i2) {
        oVar.b(1);
        if (oVar.e()) {
            oVar.b(14);
        }
        boolean zE = oVar.e();
        if (i2 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i == 6 || i == 20) {
            oVar.b(3);
        }
        if (zE) {
            if (i == 22) {
                oVar.b(16);
            }
            if (i == 17 || i == 19 || i == 20 || i == 23) {
                oVar.b(3);
            }
            oVar.b(1);
        }
    }

    public static byte[] a(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = f8391a;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length, i2);
        return bArr3;
    }
}
