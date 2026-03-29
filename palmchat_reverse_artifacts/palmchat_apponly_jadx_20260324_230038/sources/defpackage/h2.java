package defpackage;

import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.uc.crashsdk.export.LogType;
import java.nio.ByteBuffer;
import kotlin.UByte;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f17854a = {1, 2, 3, 6};
    public static final int[] b = {48000, 44100, LogType.UNEXP_KNOWN_REASON};
    public static final int[] c = {ErrorCode.REASON_HLS_PLAYLIST_RESET, 22050, 16000};
    public static final int[] d = {2, 1, 2, 3, 3, 4, 4, 5};
    public static final int[] e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 384, 448, 512, 576, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK};
    public static final int[] f = {69, 87, 104, 121, 139, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 208, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC, 417, 487, MediaPlayer.MEDIA_PLAYER_OPTION_CLIP_HEAACV2_FIRSTPTS_PACKET, 696, 835, 975, 1114, 1253, 1393};

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final String f17855a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;

        public b(@Nullable String str, int i, int i2, int i3, int i4, int i5, int i6) {
            this.f17855a = str;
            this.b = i;
            this.d = i2;
            this.c = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
        }
    }

    public static int a(int i, int i2, int i3) {
        return (i * i2) / (i3 * 32);
    }

    public static int b(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i = iPosition; i <= iLimit; i++) {
            if ((g86.I(byteBuffer, i + 4) & (-2)) == -126718022) {
                return i - iPosition;
            }
        }
        return -1;
    }

    public static int c(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = b;
        if (i >= iArr.length || i2 < 0) {
            return -1;
        }
        int[] iArr2 = f;
        if (i3 >= iArr2.length) {
            return -1;
        }
        int i4 = iArr[i];
        if (i4 == 44100) {
            return (iArr2[i3] + (i2 % 2)) * 2;
        }
        int i5 = e[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }

    public static m d(gc4 gc4Var, String str, String str2, @Nullable DrmInitData drmInitData) {
        fc4 fc4Var = new fc4();
        fc4Var.m(gc4Var);
        int i = b[fc4Var.h(2)];
        fc4Var.r(8);
        int i2 = d[fc4Var.h(3)];
        if (fc4Var.h(1) != 0) {
            i2++;
        }
        int i3 = e[fc4Var.h(5)] * 1000;
        fc4Var.c();
        gc4Var.U(fc4Var.d());
        return new m.b().U(str).g0("audio/ac3").J(i2).h0(i).O(drmInitData).X(str2).I(i3).b0(i3).G();
    }

    public static int e(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return f17854a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static b f(fc4 fc4Var) {
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int iE = fc4Var.e();
        fc4Var.r(40);
        boolean z = fc4Var.h(5) > 10;
        fc4Var.p(iE);
        int i13 = -1;
        if (z) {
            fc4Var.r(16);
            int iH = fc4Var.h(2);
            if (iH == 0) {
                i13 = 0;
            } else if (iH == 1) {
                i13 = 1;
            } else if (iH == 2) {
                i13 = 2;
            }
            fc4Var.r(3);
            int iH2 = (fc4Var.h(11) + 1) * 2;
            int iH3 = fc4Var.h(2);
            if (iH3 == 3) {
                i8 = c[fc4Var.h(2)];
                i7 = 3;
                i9 = 6;
            } else {
                int iH4 = fc4Var.h(2);
                int i14 = f17854a[iH4];
                i7 = iH4;
                i8 = b[iH3];
                i9 = i14;
            }
            int i15 = i9 * 256;
            int iA = a(iH2, i8, i9);
            int iH5 = fc4Var.h(3);
            boolean zG = fc4Var.g();
            int i16 = d[iH5] + (zG ? 1 : 0);
            fc4Var.r(10);
            if (fc4Var.g()) {
                fc4Var.r(8);
            }
            if (iH5 == 0) {
                fc4Var.r(5);
                if (fc4Var.g()) {
                    fc4Var.r(8);
                }
            }
            if (i13 == 1 && fc4Var.g()) {
                fc4Var.r(16);
            }
            if (fc4Var.g()) {
                if (iH5 > 2) {
                    fc4Var.r(2);
                }
                if ((iH5 & 1) == 0 || iH5 <= 2) {
                    i11 = 6;
                } else {
                    i11 = 6;
                    fc4Var.r(6);
                }
                if ((iH5 & 4) != 0) {
                    fc4Var.r(i11);
                }
                if (zG && fc4Var.g()) {
                    fc4Var.r(5);
                }
                if (i13 == 0) {
                    if (fc4Var.g()) {
                        i12 = 6;
                        fc4Var.r(6);
                    } else {
                        i12 = 6;
                    }
                    if (iH5 == 0 && fc4Var.g()) {
                        fc4Var.r(i12);
                    }
                    if (fc4Var.g()) {
                        fc4Var.r(i12);
                    }
                    int iH6 = fc4Var.h(2);
                    if (iH6 == 1) {
                        fc4Var.r(5);
                    } else if (iH6 == 2) {
                        fc4Var.r(12);
                    } else if (iH6 == 3) {
                        int iH7 = fc4Var.h(5);
                        if (fc4Var.g()) {
                            fc4Var.r(5);
                            if (fc4Var.g()) {
                                fc4Var.r(4);
                            }
                            if (fc4Var.g()) {
                                fc4Var.r(4);
                            }
                            if (fc4Var.g()) {
                                fc4Var.r(4);
                            }
                            if (fc4Var.g()) {
                                fc4Var.r(4);
                            }
                            if (fc4Var.g()) {
                                fc4Var.r(4);
                            }
                            if (fc4Var.g()) {
                                fc4Var.r(4);
                            }
                            if (fc4Var.g()) {
                                fc4Var.r(4);
                            }
                            if (fc4Var.g()) {
                                if (fc4Var.g()) {
                                    fc4Var.r(4);
                                }
                                if (fc4Var.g()) {
                                    fc4Var.r(4);
                                }
                            }
                        }
                        if (fc4Var.g()) {
                            fc4Var.r(5);
                            if (fc4Var.g()) {
                                fc4Var.r(7);
                                if (fc4Var.g()) {
                                    fc4Var.r(8);
                                }
                            }
                        }
                        fc4Var.r((iH7 + 2) * 8);
                        fc4Var.c();
                    }
                    if (iH5 < 2) {
                        if (fc4Var.g()) {
                            fc4Var.r(14);
                        }
                        if (iH5 == 0 && fc4Var.g()) {
                            fc4Var.r(14);
                        }
                    }
                    if (fc4Var.g()) {
                        if (i7 == 0) {
                            fc4Var.r(5);
                        } else {
                            for (int i17 = 0; i17 < i9; i17++) {
                                if (fc4Var.g()) {
                                    fc4Var.r(5);
                                }
                            }
                        }
                    }
                }
            }
            if (fc4Var.g()) {
                fc4Var.r(5);
                if (iH5 == 2) {
                    fc4Var.r(4);
                }
                if (iH5 >= 6) {
                    fc4Var.r(2);
                }
                if (fc4Var.g()) {
                    fc4Var.r(8);
                }
                if (iH5 == 0 && fc4Var.g()) {
                    fc4Var.r(8);
                }
                if (iH3 < 3) {
                    fc4Var.q();
                }
            }
            if (i13 == 0 && i7 != 3) {
                fc4Var.q();
            }
            if (i13 == 2 && (i7 == 3 || fc4Var.g())) {
                i10 = 6;
                fc4Var.r(6);
            } else {
                i10 = 6;
            }
            str = (fc4Var.g() && fc4Var.h(i10) == 1 && fc4Var.h(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i5 = i13;
            i6 = i15;
            i2 = iH2;
            i3 = i8;
            i = iA;
            i4 = i16;
        } else {
            fc4Var.r(32);
            int iH8 = fc4Var.h(2);
            String str2 = iH8 == 3 ? null : "audio/ac3";
            int iH9 = fc4Var.h(6);
            int i18 = e[iH9 / 2] * 1000;
            int iC = c(iH8, iH9);
            fc4Var.r(8);
            int iH10 = fc4Var.h(3);
            if ((iH10 & 1) != 0 && iH10 != 1) {
                fc4Var.r(2);
            }
            if ((iH10 & 4) != 0) {
                fc4Var.r(2);
            }
            if (iH10 == 2) {
                fc4Var.r(2);
            }
            int[] iArr = b;
            str = str2;
            i = i18;
            i2 = iC;
            i3 = iH8 < iArr.length ? iArr[iH8] : -1;
            i4 = d[iH10] + (fc4Var.g() ? 1 : 0);
            i5 = -1;
            i6 = 1536;
        }
        return new b(str, i5, i4, i3, i2, i6, i);
    }

    public static int g(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & UByte.MAX_VALUE) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b2 = bArr[4];
        return c((b2 & 192) >> 6, b2 & Utf8.REPLACEMENT_BYTE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static m h(gc4 gc4Var, String str, String str2, @Nullable DrmInitData drmInitData) {
        String str3;
        fc4 fc4Var = new fc4();
        fc4Var.m(gc4Var);
        int iH = fc4Var.h(13) * 1000;
        fc4Var.r(3);
        int i = b[fc4Var.h(2)];
        fc4Var.r(10);
        int i2 = d[fc4Var.h(3)];
        if (fc4Var.h(1) != 0) {
            i2++;
        }
        fc4Var.r(3);
        int iH2 = fc4Var.h(4);
        fc4Var.r(1);
        if (iH2 > 0) {
            fc4Var.r(6);
            if (fc4Var.h(1) != 0) {
                i2 += 2;
            }
            fc4Var.r(1);
        }
        if (fc4Var.b() > 7) {
            fc4Var.r(7);
            str3 = fc4Var.h(1) != 0 ? "audio/eac3-joc" : "audio/eac3";
        }
        fc4Var.c();
        gc4Var.U(fc4Var.d());
        return new m.b().U(str).g0(str3).J(i2).h0(i).O(drmInitData).X(str2).b0(iH).G();
    }

    public static int i(ByteBuffer byteBuffer, int i) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i) + ((byteBuffer.get((byteBuffer.position() + i) + 7) & UByte.MAX_VALUE) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int j(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b2 = bArr[7];
            if ((b2 & 254) == 186) {
                return 40 << ((bArr[(b2 & UByte.MAX_VALUE) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }
}
