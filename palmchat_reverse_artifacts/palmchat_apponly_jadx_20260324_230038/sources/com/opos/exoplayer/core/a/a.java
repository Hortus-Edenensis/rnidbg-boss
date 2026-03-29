package com.opos.exoplayer.core.a;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.util.p;
import com.uc.crashsdk.export.LogType;
import java.nio.ByteBuffer;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f8085a = {1, 2, 3, 6};
    private static final int[] b = {48000, 44100, LogType.UNEXP_KNOWN_REASON};
    private static final int[] c = {ErrorCode.REASON_HLS_PLAYLIST_RESET, 22050, 16000};
    private static final int[] d = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, 384, 448, 512, 576, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK};
    private static final int[] f = {69, 87, 104, 121, 139, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 208, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC, 417, 487, MediaPlayer.MEDIA_PLAYER_OPTION_CLIP_HEAACV2_FIRSTPTS_PACKET, 696, 835, 975, 1114, 1253, 1393};

    /* JADX INFO: renamed from: com.opos.exoplayer.core.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0677a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8086a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        private C0677a(String str, int i, int i2, int i3, int i4, int i5) {
            this.f8086a = str;
            this.b = i;
            this.d = i2;
            this.c = i3;
            this.e = i4;
            this.f = i5;
        }
    }

    public static int a() {
        return 1536;
    }

    public static int b(ByteBuffer byteBuffer) {
        if (byteBuffer.getInt(byteBuffer.position() + 4) != -1167101192) {
            return 0;
        }
        return 40 << (byteBuffer.get(byteBuffer.position() + 8) & 7);
    }

    private static int a(int i, int i2) {
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

    public static int b(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && bArr[7] == -70) {
            return 40 << (bArr[8] & 7);
        }
        return 0;
    }

    public static int a(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? f8085a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }

    public static Format b(p pVar, String str, String str2, DrmInitData drmInitData) {
        pVar.d(2);
        int i = b[(pVar.g() & 192) >> 6];
        int iG = pVar.g();
        int i2 = d[(iG & 14) >> 1];
        if ((iG & 1) != 0) {
            i2++;
        }
        if (((pVar.g() & 30) >> 1) > 0 && (2 & pVar.g()) != 0) {
            i2 += 2;
        }
        return Format.a(str, (pVar.b() <= 0 || (pVar.g() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc", null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static int a(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        byte b2 = bArr[4];
        return a((b2 & 192) >> 6, b2 & Utf8.REPLACEMENT_BYTE);
    }

    public static Format a(p pVar, String str, String str2, DrmInitData drmInitData) {
        int i = b[(pVar.g() & 192) >> 6];
        int iG = pVar.g();
        int i2 = d[(iG & 56) >> 3];
        if ((iG & 4) != 0) {
            i2++;
        }
        return Format.a(str, "audio/ac3", null, -1, -1, i2, i, null, drmInitData, 0, str2);
    }

    public static C0677a a(com.opos.exoplayer.core.util.o oVar) {
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int iC;
        int i6;
        int i7;
        int i8;
        int iB = oVar.b();
        oVar.b(40);
        boolean z = oVar.c(5) == 16;
        oVar.a(iB);
        if (z) {
            oVar.b(16);
            int iC2 = oVar.c(2);
            oVar.b(3);
            int iC3 = (oVar.c(11) + 1) * 2;
            int iC4 = oVar.c(2);
            if (iC4 == 3) {
                i7 = c[oVar.c(2)];
                iC = 3;
                i6 = 6;
            } else {
                iC = oVar.c(2);
                i6 = f8085a[iC];
                i7 = b[iC4];
            }
            int i9 = i6 * 256;
            int iC5 = oVar.c(3);
            boolean zE = oVar.e();
            int i10 = d[iC5] + (zE ? 1 : 0);
            oVar.b(10);
            if (oVar.e()) {
                oVar.b(8);
            }
            if (iC5 == 0) {
                oVar.b(5);
                if (oVar.e()) {
                    oVar.b(8);
                }
            }
            if (iC2 == 1 && oVar.e()) {
                oVar.b(16);
            }
            if (oVar.e()) {
                if (iC5 > 2) {
                    oVar.b(2);
                }
                if ((iC5 & 1) != 0 && iC5 > 2) {
                    oVar.b(6);
                }
                if ((iC5 & 4) != 0) {
                    oVar.b(6);
                }
                if (zE && oVar.e()) {
                    oVar.b(5);
                }
                if (iC2 == 0) {
                    if (oVar.e()) {
                        oVar.b(6);
                    }
                    if (iC5 == 0 && oVar.e()) {
                        oVar.b(6);
                    }
                    if (oVar.e()) {
                        oVar.b(6);
                    }
                    int iC6 = oVar.c(2);
                    if (iC6 == 1) {
                        oVar.b(5);
                    } else if (iC6 == 2) {
                        oVar.b(12);
                    } else if (iC6 == 3) {
                        int iC7 = oVar.c(5);
                        if (oVar.e()) {
                            oVar.b(5);
                            if (oVar.e()) {
                                oVar.b(4);
                            }
                            if (oVar.e()) {
                                oVar.b(4);
                            }
                            if (oVar.e()) {
                                oVar.b(4);
                            }
                            if (oVar.e()) {
                                oVar.b(4);
                            }
                            if (oVar.e()) {
                                oVar.b(4);
                            }
                            if (oVar.e()) {
                                oVar.b(4);
                            }
                            if (oVar.e()) {
                                oVar.b(4);
                            }
                            if (oVar.e()) {
                                if (oVar.e()) {
                                    oVar.b(4);
                                }
                                if (oVar.e()) {
                                    oVar.b(4);
                                }
                            }
                        }
                        if (oVar.e()) {
                            oVar.b(5);
                            if (oVar.e()) {
                                oVar.b(7);
                                if (oVar.e()) {
                                    oVar.b(8);
                                }
                            }
                        }
                        oVar.b((iC7 + 2) * 8);
                        oVar.f();
                    }
                    if (iC5 < 2) {
                        if (oVar.e()) {
                            oVar.b(14);
                        }
                        if (iC5 == 0 && oVar.e()) {
                            oVar.b(14);
                        }
                    }
                    if (oVar.e()) {
                        if (iC == 0) {
                            oVar.b(5);
                        } else {
                            for (int i11 = 0; i11 < i6; i11++) {
                                if (oVar.e()) {
                                    oVar.b(5);
                                }
                            }
                        }
                    }
                }
            }
            if (oVar.e()) {
                oVar.b(5);
                if (iC5 == 2) {
                    oVar.b(4);
                }
                if (iC5 >= 6) {
                    oVar.b(2);
                }
                if (oVar.e()) {
                    oVar.b(8);
                }
                if (iC5 == 0 && oVar.e()) {
                    oVar.b(8);
                }
                i8 = 3;
                if (iC4 < 3) {
                    oVar.d();
                }
            } else {
                i8 = 3;
            }
            if (iC2 == 0 && iC != i8) {
                oVar.d();
            }
            if (iC2 == 2 && (iC == i8 || oVar.e())) {
                oVar.b(6);
            }
            str = (oVar.e() && oVar.c(6) == 1 && oVar.c(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i4 = iC2;
            i = iC3;
            i2 = i7;
            i5 = i9;
            i3 = i10;
        } else {
            oVar.b(32);
            int iC8 = oVar.c(2);
            int iA = a(iC8, oVar.c(6));
            oVar.b(8);
            int iC9 = oVar.c(3);
            if ((iC9 & 1) != 0 && iC9 != 1) {
                oVar.b(2);
            }
            if ((iC9 & 4) != 0) {
                oVar.b(2);
            }
            if (iC9 == 2) {
                oVar.b(2);
            }
            str = "audio/ac3";
            i = iA;
            i2 = b[iC8];
            i3 = d[iC9] + (oVar.e() ? 1 : 0);
            i4 = -1;
            i5 = 1536;
        }
        return new C0677a(str, i4, i3, i2, i, i5);
    }
}
