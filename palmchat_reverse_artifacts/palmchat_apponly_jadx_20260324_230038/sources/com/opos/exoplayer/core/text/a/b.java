package com.opos.exoplayer.core.text.a;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.exoplayer.core.text.Cue;
import com.opos.exoplayer.core.text.g;
import com.opos.exoplayer.core.util.o;
import com.opos.exoplayer.core.util.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import kotlin.text.Typography;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f8319a = new p();
    private final o b = new o();
    private final int c;
    private final a[] d;
    private a e;
    private List<Cue> f;
    private List<Cue> g;
    private C0700b h;
    private int i;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f8320a = a(2, 2, 2, 0);
        public static final int b;
        public static final int c;
        private static final int[] d;
        private static final int[] e;
        private static final int[] f;
        private static final boolean[] g;
        private static final int[] h;
        private static final int[] i;
        private static final int[] j;
        private static final int[] k;
        private int A;
        private int B;
        private int C;
        private int D;
        private int E;
        private int F;
        private int G;
        private final List<SpannableString> l = new LinkedList();
        private final SpannableStringBuilder m = new SpannableStringBuilder();
        private boolean n;
        private boolean o;
        private int p;
        private boolean q;
        private int r;
        private int s;
        private int t;
        private int u;
        private boolean v;
        private int w;
        private int x;
        private int y;
        private int z;

        static {
            int iA = a(0, 0, 0, 0);
            b = iA;
            int iA2 = a(0, 0, 0, 3);
            c = iA2;
            d = new int[]{0, 0, 0, 0, 0, 2, 0};
            e = new int[]{0, 0, 0, 0, 0, 0, 2};
            f = new int[]{3, 3, 3, 3, 3, 3, 1};
            g = new boolean[]{false, false, false, true, true, true, false};
            h = new int[]{iA, iA2, iA, iA, iA2, iA, iA};
            i = new int[]{0, 1, 2, 3, 4, 3, 4};
            j = new int[]{0, 0, 0, 0, 0, 3, 3};
            k = new int[]{iA, iA, iA, iA, iA, iA2, iA2};
        }

        public a() {
            b();
        }

        public static int a(int i2, int i3, int i4) {
            return a(i2, i3, i4, 0);
        }

        public void b() {
            c();
            this.n = false;
            this.o = false;
            this.p = 4;
            this.q = false;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = 15;
            this.v = true;
            this.w = 0;
            this.x = 0;
            this.y = 0;
            int i2 = b;
            this.z = i2;
            this.D = f8320a;
            this.F = i2;
        }

        public void c() {
            this.l.clear();
            this.m.clear();
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.E = -1;
            this.G = 0;
        }

        public boolean d() {
            return this.n;
        }

        public boolean e() {
            return this.o;
        }

        public void f() {
            int length = this.m.length();
            if (length > 0) {
                this.m.delete(length - 1, length);
            }
        }

        public SpannableString g() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.m);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.A != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.A, length, 33);
                }
                if (this.B != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.B, length, 33);
                }
                if (this.C != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.D), this.C, length, 33);
                }
                if (this.E != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.F), this.E, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public d h() {
            Layout.Alignment alignment;
            float f2;
            float f3;
            if (a()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                spannableStringBuilder.append((CharSequence) this.l.get(i2));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) g());
            int i3 = this.w;
            if (i3 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i3 == 1) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i3 != 2) {
                if (i3 != 3) {
                    throw new IllegalArgumentException("Unexpected justification value: " + this.w);
                }
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            Layout.Alignment alignment2 = alignment;
            if (this.q) {
                f2 = this.s / 99.0f;
                f3 = this.r / 99.0f;
            } else {
                f2 = this.s / 209.0f;
                f3 = this.r / 74.0f;
            }
            float f4 = (f2 * 0.9f) + 0.05f;
            float f5 = (f3 * 0.9f) + 0.05f;
            int i4 = this.t;
            int i5 = i4 % 3;
            int i6 = i5 == 0 ? 0 : i5 == 1 ? 1 : 2;
            int i7 = i4 / 3;
            int i8 = i7 == 0 ? 0 : i7 == 1 ? 1 : 2;
            int i9 = this.z;
            return new d(spannableStringBuilder, alignment2, f5, 0, i6, f4, i8, Float.MIN_VALUE, i9 != b, i9, this.p);
        }

        public static int a(int i2, int i3, int i4, int i5) {
            com.opos.exoplayer.core.util.a.a(i2, 0, 4);
            com.opos.exoplayer.core.util.a.a(i3, 0, 4);
            com.opos.exoplayer.core.util.a.a(i4, 0, 4);
            com.opos.exoplayer.core.util.a.a(i5, 0, 4);
            return Color.argb(i5 != 2 ? i5 != 3 ? 255 : 0 : 127, i2 > 1 ? 255 : 0, i3 > 1 ? 255 : 0, i4 > 1 ? 255 : 0);
        }

        public void b(int i2, int i3, int i4) {
            int i5;
            int i6;
            if (this.C != -1 && (i6 = this.D) != i2) {
                this.m.setSpan(new ForegroundColorSpan(i6), this.C, this.m.length(), 33);
            }
            if (i2 != f8320a) {
                this.C = this.m.length();
                this.D = i2;
            }
            if (this.E != -1 && (i5 = this.F) != i3) {
                this.m.setSpan(new BackgroundColorSpan(i5), this.E, this.m.length(), 33);
            }
            if (i3 != b) {
                this.E = this.m.length();
                this.F = i3;
            }
        }

        public void a(char c2) {
            if (c2 != '\n') {
                this.m.append(c2);
                return;
            }
            this.l.add(g());
            this.m.clear();
            if (this.A != -1) {
                this.A = 0;
            }
            if (this.B != -1) {
                this.B = 0;
            }
            if (this.C != -1) {
                this.C = 0;
            }
            if (this.E != -1) {
                this.E = 0;
            }
            while (true) {
                if ((!this.v || this.l.size() < this.u) && this.l.size() < 15) {
                    return;
                } else {
                    this.l.remove(0);
                }
            }
        }

        public void a(int i2, int i3) {
            if (this.G != i2) {
                a('\n');
            }
            this.G = i2;
        }

        public void a(int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6) {
            if (this.A != -1) {
                if (!z) {
                    this.m.setSpan(new StyleSpan(2), this.A, this.m.length(), 33);
                    this.A = -1;
                }
            } else if (z) {
                this.A = this.m.length();
            }
            if (this.B == -1) {
                if (z2) {
                    this.B = this.m.length();
                }
            } else {
                if (z2) {
                    return;
                }
                this.m.setSpan(new UnderlineSpan(), this.B, this.m.length(), 33);
                this.B = -1;
            }
        }

        public void a(int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
            this.z = i2;
            this.w = i7;
        }

        public void a(boolean z) {
            this.o = z;
        }

        public void a(boolean z, boolean z2, boolean z3, int i2, boolean z4, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.n = true;
            this.o = z;
            this.v = z2;
            this.p = i2;
            this.q = z4;
            this.r = i3;
            this.s = i4;
            this.t = i7;
            int i10 = i5 + 1;
            if (this.u != i10) {
                this.u = i10;
                while (true) {
                    if ((!z2 || this.l.size() < this.u) && this.l.size() < 15) {
                        break;
                    } else {
                        this.l.remove(0);
                    }
                }
            }
            if (i8 != 0 && this.x != i8) {
                this.x = i8;
                int i11 = i8 - 1;
                a(h[i11], c, g[i11], 0, e[i11], f[i11], d[i11]);
            }
            if (i9 == 0 || this.y == i9) {
                return;
            }
            this.y = i9;
            int i12 = i9 - 1;
            a(0, 1, 1, false, false, j[i12], i[i12]);
            b(f8320a, k[i12], b);
        }

        public boolean a() {
            return !d() || (this.l.isEmpty() && this.m.length() == 0);
        }
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.text.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0700b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8321a;
        public final int b;
        public final byte[] c;
        int d = 0;

        public C0700b(int i, int i2) {
            this.f8321a = i;
            this.b = i2;
            this.c = new byte[(i2 * 2) - 1];
        }
    }

    public b(int i) {
        this.c = i == -1 ? 1 : i;
        this.d = new a[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.d[i2] = new a();
        }
        this.e = this.d[0];
        p();
    }

    private void a(int i) {
        o oVar;
        if (i != 0) {
            if (i == 3) {
                this.f = o();
            }
            int i2 = 8;
            if (i == 8) {
                this.e.f();
                return;
            }
            switch (i) {
                case 12:
                    p();
                    break;
                case 13:
                    this.e.a('\n');
                    break;
                case 14:
                    break;
                default:
                    if (i >= 17 && i <= 23) {
                        com.opos.cmn.an.f.a.c("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i);
                        oVar = this.b;
                    } else if (i < 24 || i > 31) {
                        com.opos.cmn.an.f.a.c("Cea708Decoder", "Invalid C0 command: " + i);
                    } else {
                        com.opos.cmn.an.f.a.c("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i);
                        oVar = this.b;
                        i2 = 16;
                    }
                    oVar.b(i2);
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void b(int i) {
        a aVar;
        o oVar;
        int i2 = 16;
        int i3 = 1;
        switch (i) {
            case 128:
            case 129:
            case 130:
            case 131:
            case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA /* 132 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START /* 133 */:
            case 134:
            case 135:
                int i4 = i - 128;
                if (this.i != i4) {
                    this.i = i4;
                    aVar = this.d[i4];
                    this.e = aVar;
                }
                break;
            case 136:
                while (i3 <= 8) {
                    if (this.b.e()) {
                        this.d[8 - i3].c();
                    }
                    i3++;
                }
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME /* 137 */:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.b.e()) {
                        this.d[8 - i5].a(true);
                    }
                }
                break;
            case 138:
                while (i3 <= 8) {
                    if (this.b.e()) {
                        this.d[8 - i3].a(false);
                    }
                    i3++;
                }
                break;
            case 139:
                for (int i6 = 1; i6 <= 8; i6++) {
                    if (this.b.e()) {
                        this.d[8 - i6].a(!r0.e());
                    }
                }
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID /* 140 */:
                while (i3 <= 8) {
                    if (this.b.e()) {
                        this.d[8 - i3].b();
                    }
                    i3++;
                }
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID /* 141 */:
                this.b.b(8);
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO /* 142 */:
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE /* 143 */:
                p();
                break;
            case 144:
                if (this.e.d()) {
                    k();
                }
                oVar = this.b;
                oVar.b(i2);
                break;
            case 145:
                if (this.e.d()) {
                    l();
                } else {
                    oVar = this.b;
                    i2 = 24;
                    oVar.b(i2);
                }
                break;
            case MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK /* 146 */:
                if (this.e.d()) {
                    m();
                }
                oVar = this.b;
                oVar.b(i2);
                break;
            case 147:
            case MediaPlayer.MEDIA_PLAYER_OPTION_EANABLE_DROPPING_DTS_ROLLBACK /* 148 */:
            case 149:
            case 150:
            default:
                com.opos.cmn.an.f.a.c("Cea708Decoder", "Invalid C1 command: " + i);
                break;
            case 151:
                if (this.e.d()) {
                    n();
                } else {
                    oVar = this.b;
                    i2 = 32;
                    oVar.b(i2);
                }
                break;
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i7 = i - 152;
                i(i7);
                if (this.i != i7) {
                    this.i = i7;
                    aVar = this.d[i7];
                    this.e = aVar;
                }
                break;
        }
    }

    private void e(int i) {
        if (i == 127) {
            this.e.a((char) 9835);
        } else {
            this.e.a((char) (i & 255));
        }
    }

    private void i() {
        if (this.h == null) {
            return;
        }
        j();
        this.h = null;
    }

    private void j() {
        StringBuilder sb;
        String str;
        C0700b c0700b = this.h;
        int i = c0700b.d;
        if (i != (c0700b.b * 2) - 1) {
            com.opos.cmn.an.f.a.c("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.h.b * 2) - 1) + ", but current index is " + this.h.d + " (sequence number " + this.h.f8321a + "); ignoring packet");
            return;
        }
        this.b.a(c0700b.c, i);
        int iC = this.b.c(3);
        int iC2 = this.b.c(5);
        if (iC == 7) {
            this.b.b(2);
            iC += this.b.c(6);
        }
        if (iC2 == 0) {
            if (iC != 0) {
                com.opos.cmn.an.f.a.c("Cea708Decoder", "serviceNumber is non-zero (" + iC + ") when blockSize is 0");
                return;
            }
            return;
        }
        if (iC != this.c) {
            return;
        }
        boolean z = false;
        while (this.b.a() > 0) {
            int iC3 = this.b.c(8);
            if (iC3 == 16) {
                iC3 = this.b.c(8);
                if (iC3 <= 31) {
                    c(iC3);
                } else {
                    if (iC3 <= 127) {
                        g(iC3);
                    } else if (iC3 <= 159) {
                        d(iC3);
                    } else if (iC3 <= 255) {
                        h(iC3);
                    } else {
                        sb = new StringBuilder();
                        str = "Invalid extended command: ";
                        sb.append(str);
                        sb.append(iC3);
                        com.opos.cmn.an.f.a.c("Cea708Decoder", sb.toString());
                    }
                    z = true;
                }
            } else if (iC3 <= 31) {
                a(iC3);
            } else {
                if (iC3 <= 127) {
                    e(iC3);
                } else if (iC3 <= 159) {
                    b(iC3);
                } else if (iC3 <= 255) {
                    f(iC3);
                } else {
                    sb = new StringBuilder();
                    str = "Invalid base command: ";
                    sb.append(str);
                    sb.append(iC3);
                    com.opos.cmn.an.f.a.c("Cea708Decoder", sb.toString());
                }
                z = true;
            }
        }
        if (z) {
            this.f = o();
        }
    }

    private void k() {
        this.e.a(this.b.c(4), this.b.c(2), this.b.c(2), this.b.e(), this.b.e(), this.b.c(3), this.b.c(3));
    }

    private void l() {
        int iA = a.a(this.b.c(2), this.b.c(2), this.b.c(2), this.b.c(2));
        int iA2 = a.a(this.b.c(2), this.b.c(2), this.b.c(2), this.b.c(2));
        this.b.b(2);
        this.e.b(iA, iA2, a.a(this.b.c(2), this.b.c(2), this.b.c(2)));
    }

    private void m() {
        this.b.b(4);
        int iC = this.b.c(4);
        this.b.b(2);
        this.e.a(iC, this.b.c(6));
    }

    private void n() {
        int iA = a.a(this.b.c(2), this.b.c(2), this.b.c(2), this.b.c(2));
        int iC = this.b.c(2);
        int iA2 = a.a(this.b.c(2), this.b.c(2), this.b.c(2));
        if (this.b.e()) {
            iC |= 4;
        }
        boolean zE = this.b.e();
        int iC2 = this.b.c(2);
        int iC3 = this.b.c(2);
        int iC4 = this.b.c(2);
        this.b.b(8);
        this.e.a(iA, iA2, zE, iC, iC2, iC3, iC4);
    }

    private List<Cue> o() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.d[i].a() && this.d[i].e()) {
                arrayList.add(this.d[i].h());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void p() {
        for (int i = 0; i < 8; i++) {
            this.d[i].b();
        }
    }

    @Override // com.opos.exoplayer.core.text.a.e, com.opos.exoplayer.core.decoder.c
    public void c() {
        super.c();
        this.f = null;
        this.g = null;
        this.i = 0;
        this.e = this.d[0];
        p();
        this.h = null;
    }

    @Override // com.opos.exoplayer.core.text.a.e, com.opos.exoplayer.core.decoder.c
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.opos.exoplayer.core.text.a.e
    public com.opos.exoplayer.core.text.b f() {
        List<Cue> list = this.f;
        this.g = list;
        return new f(list);
    }

    @Override // com.opos.exoplayer.core.text.a.e
    /* JADX INFO: renamed from: g */
    public /* bridge */ /* synthetic */ g b() {
        return super.b();
    }

    @Override // com.opos.exoplayer.core.text.a.e
    /* JADX INFO: renamed from: h */
    public /* bridge */ /* synthetic */ com.opos.exoplayer.core.text.f a() {
        return super.a();
    }

    private void c(int i) {
        o oVar;
        int i2;
        if (i <= 7) {
            return;
        }
        if (i <= 15) {
            oVar = this.b;
            i2 = 8;
        } else if (i <= 23) {
            oVar = this.b;
            i2 = 16;
        } else {
            if (i > 31) {
                return;
            }
            oVar = this.b;
            i2 = 24;
        }
        oVar.b(i2);
    }

    private void d(int i) {
        o oVar;
        int i2;
        if (i <= 135) {
            oVar = this.b;
            i2 = 32;
        } else {
            if (i > 143) {
                if (i <= 159) {
                    this.b.b(2);
                    this.b.b(this.b.c(6) * 8);
                    return;
                }
                return;
            }
            oVar = this.b;
            i2 = 40;
        }
        oVar.b(i2);
    }

    private void f(int i) {
        this.e.a((char) (i & 255));
    }

    private void g(int i) {
        a aVar;
        char c = ' ';
        if (i == 32) {
            aVar = this.e;
        } else if (i == 33) {
            aVar = this.e;
            c = Typography.nbsp;
        } else if (i == 37) {
            aVar = this.e;
            c = Typography.ellipsis;
        } else if (i == 42) {
            aVar = this.e;
            c = 352;
        } else if (i == 44) {
            aVar = this.e;
            c = 338;
        } else if (i == 63) {
            aVar = this.e;
            c = 376;
        } else if (i == 57) {
            aVar = this.e;
            c = Typography.tm;
        } else if (i == 58) {
            aVar = this.e;
            c = 353;
        } else if (i == 60) {
            aVar = this.e;
            c = 339;
        } else if (i != 61) {
            switch (i) {
                case 48:
                    aVar = this.e;
                    c = 9608;
                    break;
                case 49:
                    aVar = this.e;
                    c = Typography.leftSingleQuote;
                    break;
                case 50:
                    aVar = this.e;
                    c = Typography.rightSingleQuote;
                    break;
                case 51:
                    aVar = this.e;
                    c = Typography.leftDoubleQuote;
                    break;
                case 52:
                    aVar = this.e;
                    c = Typography.rightDoubleQuote;
                    break;
                case 53:
                    aVar = this.e;
                    c = Typography.bullet;
                    break;
                default:
                    switch (i) {
                        case 118:
                            aVar = this.e;
                            c = 8539;
                            break;
                        case 119:
                            aVar = this.e;
                            c = 8540;
                            break;
                        case 120:
                            aVar = this.e;
                            c = 8541;
                            break;
                        case 121:
                            aVar = this.e;
                            c = 8542;
                            break;
                        case 122:
                            aVar = this.e;
                            c = 9474;
                            break;
                        case 123:
                            aVar = this.e;
                            c = 9488;
                            break;
                        case 124:
                            aVar = this.e;
                            c = 9492;
                            break;
                        case 125:
                            aVar = this.e;
                            c = 9472;
                            break;
                        case 126:
                            aVar = this.e;
                            c = 9496;
                            break;
                        case 127:
                            aVar = this.e;
                            c = 9484;
                            break;
                        default:
                            com.opos.cmn.an.f.a.c("Cea708Decoder", "Invalid G2 character: " + i);
                            return;
                    }
                    break;
            }
        } else {
            aVar = this.e;
            c = 8480;
        }
        aVar.a(c);
    }

    private void h(int i) {
        a aVar;
        char c;
        if (i == 160) {
            aVar = this.e;
            c = 13252;
        } else {
            com.opos.cmn.an.f.a.c("Cea708Decoder", "Invalid G3 character: " + i);
            aVar = this.e;
            c = '_';
        }
        aVar.a(c);
    }

    private void i(int i) {
        a aVar = this.d[i];
        this.b.b(2);
        boolean zE = this.b.e();
        boolean zE2 = this.b.e();
        boolean zE3 = this.b.e();
        int iC = this.b.c(3);
        boolean zE4 = this.b.e();
        int iC2 = this.b.c(7);
        int iC3 = this.b.c(8);
        int iC4 = this.b.c(4);
        int iC5 = this.b.c(4);
        this.b.b(2);
        int iC6 = this.b.c(6);
        this.b.b(2);
        aVar.a(zE, zE2, zE3, iC, zE4, iC2, iC3, iC5, iC6, iC4, this.b.c(3), this.b.c(3));
    }

    @Override // com.opos.exoplayer.core.text.a.e, com.opos.exoplayer.core.text.c
    public /* bridge */ /* synthetic */ void a(long j) {
        super.a(j);
    }

    @Override // com.opos.exoplayer.core.text.a.e
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ void a(com.opos.exoplayer.core.text.f fVar) {
        super.a(fVar);
    }

    @Override // com.opos.exoplayer.core.text.a.e
    public boolean e() {
        return this.f != this.g;
    }

    @Override // com.opos.exoplayer.core.text.a.e
    public void a(com.opos.exoplayer.core.text.f fVar) {
        this.f8319a.a(fVar.b.array(), fVar.b.limit());
        while (this.f8319a.b() >= 3) {
            int iG = this.f8319a.g() & 7;
            int i = iG & 3;
            boolean z = (iG & 4) == 4;
            byte bG = (byte) this.f8319a.g();
            byte bG2 = (byte) this.f8319a.g();
            if (i == 2 || i == 3) {
                if (z) {
                    if (i == 3) {
                        i();
                        int i2 = (bG & 192) >> 6;
                        int i3 = bG & Utf8.REPLACEMENT_BYTE;
                        if (i3 == 0) {
                            i3 = 64;
                        }
                        C0700b c0700b = new C0700b(i2, i3);
                        this.h = c0700b;
                        byte[] bArr = c0700b.c;
                        int i4 = c0700b.d;
                        c0700b.d = i4 + 1;
                        bArr[i4] = bG2;
                    } else {
                        com.opos.exoplayer.core.util.a.a(i == 2);
                        C0700b c0700b2 = this.h;
                        if (c0700b2 == null) {
                            com.opos.cmn.an.f.a.d("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = c0700b2.c;
                            int i5 = c0700b2.d;
                            int i6 = i5 + 1;
                            bArr2[i5] = bG;
                            c0700b2.d = i6 + 1;
                            bArr2[i6] = bG2;
                        }
                    }
                    C0700b c0700b3 = this.h;
                    if (c0700b3.d == (c0700b3.b * 2) - 1) {
                        i();
                    }
                }
            }
        }
    }
}
