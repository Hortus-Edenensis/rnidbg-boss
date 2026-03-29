package defpackage;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.huawei.openalliance.ad.constant.ai;
import com.lantern.auth.app.FunDC;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class zp5 {
    public static final zp5[] i;
    public static zp5[] j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22478a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;

    static {
        zp5[] zp5VarArr = {new zp5(false, 3, 5, 8, 8, 1), new zp5(false, 5, 7, 10, 10, 1), new zp5(true, 5, 7, 16, 6, 1), new zp5(false, 8, 10, 12, 12, 1), new zp5(true, 10, 11, 14, 6, 2), new zp5(false, 12, 12, 14, 14, 1), new zp5(true, 16, 14, 24, 10, 1), new zp5(false, 18, 14, 16, 16, 1), new zp5(false, 22, 18, 18, 18, 1), new zp5(true, 22, 18, 16, 10, 2), new zp5(false, 30, 20, 20, 20, 1), new zp5(true, 32, 24, 16, 14, 2), new zp5(false, 36, 24, 22, 22, 1), new zp5(false, 44, 28, 24, 24, 1), new zp5(true, 49, 28, 22, 14, 2), new zp5(false, 62, 36, 14, 14, 4), new zp5(false, 86, 42, 16, 16, 4), new zp5(false, 114, 48, 18, 18, 4), new zp5(false, 144, 56, 20, 20, 4), new zp5(false, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 68, 22, 22, 4), new zp5(false, 204, 84, 24, 24, 4, 102, 42), new zp5(false, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 112, 14, 14, 16, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 56), new zp5(false, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION, 144, 16, 16, 16, 92, 36), new zp5(false, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, 192, 18, 18, 16, 114, 48), new zp5(false, 576, 224, 20, 20, 16, 144, 56), new zp5(false, 696, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 22, 22, 16, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 68), new zp5(false, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, 24, 24, 16, 136, 56), new zp5(false, FunDC.ID_AUTH_1050, 408, 18, 18, 36, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 68), new zp5(false, 1304, ai.v, 20, 20, 36, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 62), new pu0()};
        i = zp5VarArr;
        j = zp5VarArr;
    }

    public zp5(boolean z, int i2, int i3, int i4, int i5, int i6) {
        this(z, i2, i3, i4, i5, i6, i2, i3);
    }

    public static zp5 l(int i2, SymbolShapeHint symbolShapeHint, gd1 gd1Var, gd1 gd1Var2, boolean z) {
        for (zp5 zp5Var : j) {
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && zp5Var.f22478a) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || zp5Var.f22478a) && ((gd1Var == null || (zp5Var.j() >= gd1Var.b() && zp5Var.i() >= gd1Var.a())) && ((gd1Var2 == null || (zp5Var.j() <= gd1Var2.b() && zp5Var.i() <= gd1Var2.a())) && i2 <= zp5Var.b)))) {
                return zp5Var;
            }
        }
        if (!z) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i2);
    }

    public final int a() {
        return this.b;
    }

    public int b(int i2) {
        return this.g;
    }

    public final int c() {
        return this.c;
    }

    public final int d(int i2) {
        return this.h;
    }

    public final int e() {
        int i2 = this.f;
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2 && i2 != 4) {
                if (i2 == 16) {
                    return 4;
                }
                if (i2 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i3;
    }

    public int f() {
        return this.b / this.g;
    }

    public final int g() {
        return k() * this.e;
    }

    public final int h() {
        return e() * this.d;
    }

    public final int i() {
        return g() + (k() << 1);
    }

    public final int j() {
        return h() + (e() << 1);
    }

    public final int k() {
        int i2 = this.f;
        if (i2 == 1 || i2 == 2) {
            return 1;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22478a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.d);
        sb.append('x');
        sb.append(this.e);
        sb.append(", symbol size ");
        sb.append(j());
        sb.append('x');
        sb.append(i());
        sb.append(", symbol data size ");
        sb.append(h());
        sb.append('x');
        sb.append(g());
        sb.append(", codewords ");
        sb.append(this.b);
        sb.append('+');
        sb.append(this.c);
        return sb.toString();
    }

    public zp5(boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f22478a = z;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
    }
}
