package com.opos.exoplayer.core.a;

import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.ss.android.ttvecamera.TECameraUtils;
import com.uc.crashsdk.export.LogType;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f8105a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] b = {-1, 8000, 16000, LogType.UNEXP_KNOWN_REASON, -1, -1, 11025, 22050, 44100, -1, -1, ErrorCode.REASON_TEE, ErrorCode.REASON_HLS_PLAYLIST_RESET, 48000, -1, -1};
    private static final int[] c = {64, 112, 128, 192, 224, 256, 384, 448, 512, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 768, 896, 1024, 1152, 1280, 1536, TECameraUtils.CAPTURE_NORMAL, 2048, 2304, TECameraUtils.CAPTURE_HQ_2X, 2688, 2816, 2823, 2944, 3072, 3840, 4096, BmLocated.HALF_LEFT_BOTTOM, 7680};

    public static int a(ByteBuffer byteBuffer) {
        int i;
        int i2;
        int i3;
        int i4;
        int iPosition = byteBuffer.position();
        byte b2 = byteBuffer.get(iPosition);
        if (b2 != -2) {
            if (b2 == -1) {
                i = (byteBuffer.get(iPosition + 4) & 7) << 4;
                i4 = iPosition + 7;
            } else if (b2 != 31) {
                i = (byteBuffer.get(iPosition + 4) & 1) << 6;
                i2 = iPosition + 5;
            } else {
                i = (byteBuffer.get(iPosition + 5) & 7) << 4;
                i4 = iPosition + 6;
            }
            i3 = byteBuffer.get(i4) & 60;
            return (((i3 >> 2) | i) + 1) * 32;
        }
        i = (byteBuffer.get(iPosition + 5) & 1) << 6;
        i2 = iPosition + 4;
        i3 = byteBuffer.get(i2) & 252;
        return (((i3 >> 2) | i) + 1) * 32;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(byte[] bArr) {
        int i;
        byte b2;
        int i2;
        int i3;
        byte b3;
        boolean z = false;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i3 = ((bArr[7] & 3) << 12) | ((bArr[6] & UByte.MAX_VALUE) << 4);
                b3 = bArr[9];
            } else if (b4 != 31) {
                i = ((bArr[5] & 3) << 12) | ((bArr[6] & UByte.MAX_VALUE) << 4);
                b2 = bArr[7];
            } else {
                i3 = ((bArr[6] & 3) << 12) | ((bArr[7] & UByte.MAX_VALUE) << 4);
                b3 = bArr[8];
            }
            i2 = (((b3 & 60) >> 2) | i3) + 1;
            z = true;
            return !z ? (i2 * 16) / 14 : i2;
        }
        i = ((bArr[4] & 3) << 12) | ((bArr[7] & UByte.MAX_VALUE) << 4);
        b2 = bArr[6];
        i2 = (((b2 & 240) >> 4) | i) + 1;
        if (!z) {
        }
    }

    private static com.opos.exoplayer.core.util.o c(byte[] bArr) {
        if (bArr[0] == 127) {
            return new com.opos.exoplayer.core.util.o(bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (d(bArrCopyOf)) {
            for (int i = 0; i < bArrCopyOf.length - 1; i += 2) {
                byte b2 = bArrCopyOf[i];
                int i2 = i + 1;
                bArrCopyOf[i] = bArrCopyOf[i2];
                bArrCopyOf[i2] = b2;
            }
        }
        com.opos.exoplayer.core.util.o oVar = new com.opos.exoplayer.core.util.o(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            com.opos.exoplayer.core.util.o oVar2 = new com.opos.exoplayer.core.util.o(bArrCopyOf);
            while (oVar2.a() >= 16) {
                oVar2.b(2);
                oVar.a(oVar2.c(14), 14);
            }
        }
        oVar.a(bArrCopyOf);
        return oVar;
    }

    private static boolean d(byte[] bArr) {
        byte b2 = bArr[0];
        return b2 == -2 || b2 == -1;
    }

    public static int a(byte[] bArr) {
        int i;
        byte b2;
        int i2;
        byte b3;
        byte b4 = bArr[0];
        if (b4 != -2) {
            if (b4 == -1) {
                i = (bArr[4] & 7) << 4;
                b3 = bArr[7];
            } else if (b4 != 31) {
                i = (bArr[4] & 1) << 6;
                b2 = bArr[5];
            } else {
                i = (bArr[5] & 7) << 4;
                b3 = bArr[6];
            }
            i2 = b3 & 60;
            return (((i2 >> 2) | i) + 1) * 32;
        }
        i = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        i2 = b2 & 252;
        return (((i2 >> 2) | i) + 1) * 32;
    }

    public static Format a(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        com.opos.exoplayer.core.util.o oVarC = c(bArr);
        oVarC.b(60);
        int i = f8105a[oVarC.c(6)];
        int i2 = b[oVarC.c(4)];
        int iC = oVarC.c(5);
        int[] iArr = c;
        int i3 = iC >= iArr.length ? -1 : (iArr[iC] * 1000) / 2;
        oVarC.b(10);
        return Format.a(str, "audio/vnd.dts", null, i3, -1, i + (oVarC.c(2) > 0 ? 1 : 0), i2, null, drmInitData, 0, str2);
    }

    public static boolean a(int i) {
        return i == 2147385345 || i == -25230976 || i == 536864768 || i == -14745368;
    }
}
