package defpackage;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import kotlin.text.Typography;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class p52 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final et f19942a;
    public final yr0 b = new yr0();
    public final StringBuilder c = new StringBuilder();

    public p52(et etVar) {
        this.f19942a = etVar;
    }

    public static int g(et etVar, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (etVar.g(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    public String a(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            dw0 dw0VarC = c(i, str);
            String strA = cu1.a(dw0VarC.b());
            if (strA != null) {
                sb.append(strA);
            }
            String strValueOf = dw0VarC.d() ? String.valueOf(dw0VarC.c()) : null;
            if (i == dw0VarC.a()) {
                return sb.toString();
            }
            i = dw0VarC.a();
            str = strValueOf;
        }
    }

    public final cw0 b(int i) {
        char c;
        int iF = f(i, 5);
        if (iF == 15) {
            return new cw0(i + 5, Typography.dollar);
        }
        if (iF >= 5 && iF < 15) {
            return new cw0(i + 5, (char) ((iF + 48) - 5));
        }
        int iF2 = f(i, 6);
        if (iF2 >= 32 && iF2 < 58) {
            return new cw0(i + 6, (char) (iF2 + 33));
        }
        switch (iF2) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + iF2);
        }
        return new cw0(i + 6, c);
    }

    public dw0 c(int i, String str) throws FormatException {
        this.c.setLength(0);
        if (str != null) {
            this.c.append(str);
        }
        this.b.h(i);
        dw0 dw0VarO = o();
        return (dw0VarO == null || !dw0VarO.d()) ? new dw0(this.b.a(), this.c.toString()) : new dw0(this.b.a(), this.c.toString(), dw0VarO.c());
    }

    public final cw0 d(int i) throws FormatException {
        char c;
        int iF = f(i, 5);
        if (iF == 15) {
            return new cw0(i + 5, Typography.dollar);
        }
        if (iF >= 5 && iF < 15) {
            return new cw0(i + 5, (char) ((iF + 48) - 5));
        }
        int iF2 = f(i, 7);
        if (iF2 >= 64 && iF2 < 90) {
            return new cw0(i + 7, (char) (iF2 + 1));
        }
        if (iF2 >= 90 && iF2 < 116) {
            return new cw0(i + 7, (char) (iF2 + 7));
        }
        switch (f(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = Typography.quote;
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = Typography.amp;
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = '(';
                break;
            case 238:
                c = ')';
                break;
            case 239:
                c = '*';
                break;
            case 240:
                c = '+';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE /* 241 */:
                c = ',';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE /* 242 */:
                c = '-';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE /* 243 */:
                c = '.';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE /* 244 */:
                c = '/';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR /* 245 */:
                c = ':';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT /* 246 */:
                c = ';';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT /* 247 */:
                c = Typography.less;
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT /* 248 */:
                c = '=';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN /* 249 */:
                c = Typography.greater;
                break;
            case 250:
                c = '?';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR /* 251 */:
                c = '_';
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF /* 252 */:
                c = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new cw0(i + 8, c);
    }

    public final ew0 e(int i) throws FormatException {
        int i2 = i + 7;
        if (i2 > this.f19942a.k()) {
            int iF = f(i, 4);
            return iF == 0 ? new ew0(this.f19942a.k(), 10, 10) : new ew0(this.f19942a.k(), iF - 1, 10);
        }
        int iF2 = f(i, 7) - 8;
        return new ew0(i2, iF2 / 11, iF2 % 11);
    }

    public int f(int i, int i2) {
        return g(this.f19942a, i, i2);
    }

    public final boolean h(int i) {
        int i2 = i + 3;
        if (i2 > this.f19942a.k()) {
            return false;
        }
        while (i < i2) {
            if (this.f19942a.g(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public final boolean i(int i) {
        int i2;
        if (i + 1 > this.f19942a.k()) {
            return false;
        }
        for (int i3 = 0; i3 < 5 && (i2 = i3 + i) < this.f19942a.k(); i3++) {
            if (i3 == 2) {
                if (!this.f19942a.g(i + 2)) {
                    return false;
                }
            } else if (this.f19942a.g(i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(int i) {
        int i2;
        if (i + 1 > this.f19942a.k()) {
            return false;
        }
        for (int i3 = 0; i3 < 4 && (i2 = i3 + i) < this.f19942a.k(); i3++) {
            if (this.f19942a.g(i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(int i) {
        int iF;
        if (i + 5 > this.f19942a.k()) {
            return false;
        }
        int iF2 = f(i, 5);
        if (iF2 < 5 || iF2 >= 16) {
            return i + 6 <= this.f19942a.k() && (iF = f(i, 6)) >= 16 && iF < 63;
        }
        return true;
    }

    public final boolean l(int i) {
        int iF;
        if (i + 5 > this.f19942a.k()) {
            return false;
        }
        int iF2 = f(i, 5);
        if (iF2 >= 5 && iF2 < 16) {
            return true;
        }
        if (i + 7 > this.f19942a.k()) {
            return false;
        }
        int iF3 = f(i, 7);
        if (iF3 < 64 || iF3 >= 116) {
            return i + 8 <= this.f19942a.k() && (iF = f(i, 8)) >= 232 && iF < 253;
        }
        return true;
    }

    public final boolean m(int i) {
        if (i + 7 > this.f19942a.k()) {
            return i + 4 <= this.f19942a.k();
        }
        int i2 = i;
        while (true) {
            int i3 = i + 3;
            if (i2 >= i3) {
                return this.f19942a.g(i3);
            }
            if (this.f19942a.g(i2)) {
                return true;
            }
            i2++;
        }
    }

    public final bu n() {
        while (k(this.b.a())) {
            cw0 cw0VarB = b(this.b.a());
            this.b.h(cw0VarB.a());
            if (cw0VarB.c()) {
                return new bu(new dw0(this.b.a(), this.c.toString()), true);
            }
            this.c.append(cw0VarB.b());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.g();
        } else if (i(this.b.a())) {
            if (this.b.a() + 5 < this.f19942a.k()) {
                this.b.b(5);
            } else {
                this.b.h(this.f19942a.k());
            }
            this.b.f();
        }
        return new bu(false);
    }

    public final dw0 o() throws FormatException {
        bu buVarQ;
        boolean zB;
        do {
            int iA = this.b.a();
            if (this.b.c()) {
                buVarQ = n();
                zB = buVarQ.b();
            } else if (this.b.d()) {
                buVarQ = p();
                zB = buVarQ.b();
            } else {
                buVarQ = q();
                zB = buVarQ.b();
            }
            if (!(iA != this.b.a()) && !zB) {
                break;
            }
        } while (!zB);
        return buVarQ.a();
    }

    public final bu p() throws FormatException {
        while (l(this.b.a())) {
            cw0 cw0VarD = d(this.b.a());
            this.b.h(cw0VarD.a());
            if (cw0VarD.c()) {
                return new bu(new dw0(this.b.a(), this.c.toString()), true);
            }
            this.c.append(cw0VarD.b());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.g();
        } else if (i(this.b.a())) {
            if (this.b.a() + 5 < this.f19942a.k()) {
                this.b.b(5);
            } else {
                this.b.h(this.f19942a.k());
            }
            this.b.e();
        }
        return new bu(false);
    }

    public final bu q() throws FormatException {
        while (m(this.b.a())) {
            ew0 ew0VarE = e(this.b.a());
            this.b.h(ew0VarE.a());
            if (ew0VarE.d()) {
                return new bu(ew0VarE.e() ? new dw0(this.b.a(), this.c.toString()) : new dw0(this.b.a(), this.c.toString(), ew0VarE.c()), true);
            }
            this.c.append(ew0VarE.b());
            if (ew0VarE.e()) {
                return new bu(new dw0(this.b.a(), this.c.toString()), true);
            }
            this.c.append(ew0VarE.c());
        }
        if (j(this.b.a())) {
            this.b.e();
            this.b.b(4);
        }
        return new bu(false);
    }
}
