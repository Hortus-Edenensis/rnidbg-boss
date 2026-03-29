package defpackage;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.q;
import defpackage.pr0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class rz extends vz {
    public final int h;
    public final int i;
    public final int j;
    public final long k;

    @Nullable
    public List<pr0> n;

    @Nullable
    public List<pr0> o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public byte t;
    public byte u;
    public boolean w;
    public long x;
    public static final int[] y = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] z = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] A = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};
    public static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 209, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 9632};
    public static final int[] C = {MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD, 189, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 8482, 162, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 9834, 224, 32, 232, 226, 234, 238, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR};
    public static final int[] D = {MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT, 201, 211, 218, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, AVMDLDataLoader.KeyIsLoaderFactoryP2PLevel, 161, 42, 39, q.a.D, 169, 8480, 8226, 8220, 8221, 192, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, 200, 202, 203, 235, 206, 207, 239, 212, 217, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 219, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME};
    public static final int[] E = {MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 227, 205, 204, 236, 210, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 213, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 123, 125, 92, 94, 95, 124, 126, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 228, 214, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 223, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME, 9474, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 229, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 9484, 9488, 9492, 9496};
    public static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    public final gc4 g = new gc4();
    public final ArrayList<a> l = new ArrayList<>();
    public a m = new a(0, 4);
    public int v = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<C1273a> f20625a = new ArrayList();
        public final List<SpannableString> b = new ArrayList();
        public final StringBuilder c = new StringBuilder();
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;

        /* JADX INFO: renamed from: rz$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C1273a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f20626a;
            public final boolean b;
            public int c;

            public C1273a(int i, boolean z, int i2) {
                this.f20626a = i;
                this.b = z;
                this.c = i2;
            }
        }

        public a(int i, int i2) {
            j(i);
            this.h = i2;
        }

        public static void n(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3) {
            if (i3 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        }

        public static void o(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i, i2, 33);
        }

        public static void q(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }

        public void e(char c) {
            if (this.c.length() < 32) {
                this.c.append(c);
            }
        }

        public void f() {
            int length = this.c.length();
            if (length > 0) {
                this.c.delete(length - 1, length);
                for (int size = this.f20625a.size() - 1; size >= 0; size--) {
                    C1273a c1273a = this.f20625a.get(size);
                    int i = c1273a.c;
                    if (i != length) {
                        return;
                    }
                    c1273a.c = i - 1;
                }
            }
        }

        @Nullable
        public pr0 g(int i) {
            float f;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                spannableStringBuilder.append((CharSequence) this.b.get(i2));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) h());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i3 = this.e + this.f;
            int length = (32 - i3) - spannableStringBuilder.length();
            int i4 = i3 - length;
            if (i == Integer.MIN_VALUE) {
                i = (this.g != 2 || (Math.abs(i4) >= 3 && length >= 0)) ? (this.g != 2 || i4 <= 0) ? 0 : 2 : 1;
            }
            if (i != 1) {
                if (i == 2) {
                    i3 = 32 - length;
                }
                f = ((i3 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = 0.5f;
            }
            int i5 = this.d;
            if (i5 > 7) {
                i5 = (i5 - 15) - 2;
            } else if (this.g == 1) {
                i5 -= this.h - 1;
            }
            return new pr0.b().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(i5, 1).k(f).l(i).a();
        }

        public final SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c);
            int length = spannableStringBuilder.length();
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            boolean z = false;
            while (i < this.f20625a.size()) {
                C1273a c1273a = this.f20625a.get(i);
                boolean z2 = c1273a.b;
                int i7 = c1273a.f20626a;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i6 = rz.A[i7];
                    }
                    z = z3;
                }
                int i8 = c1273a.c;
                i++;
                if (i8 != (i < this.f20625a.size() ? this.f20625a.get(i).c : length)) {
                    if (i2 != -1 && !z2) {
                        q(spannableStringBuilder, i2, i8);
                        i2 = -1;
                    } else if (i2 == -1 && z2) {
                        i2 = i8;
                    }
                    if (i3 != -1 && !z) {
                        o(spannableStringBuilder, i3, i8);
                        i3 = -1;
                    } else if (i3 == -1 && z) {
                        i3 = i8;
                    }
                    if (i6 != i5) {
                        n(spannableStringBuilder, i4, i8, i5);
                        i5 = i6;
                        i4 = i8;
                    }
                }
            }
            if (i2 != -1 && i2 != length) {
                q(spannableStringBuilder, i2, length);
            }
            if (i3 != -1 && i3 != length) {
                o(spannableStringBuilder, i3, length);
            }
            if (i4 != length) {
                n(spannableStringBuilder, i4, length, i5);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public boolean i() {
            return this.f20625a.isEmpty() && this.b.isEmpty() && this.c.length() == 0;
        }

        public void j(int i) {
            this.g = i;
            this.f20625a.clear();
            this.b.clear();
            this.c.setLength(0);
            this.d = 15;
            this.e = 0;
            this.f = 0;
        }

        public void k() {
            this.b.add(h());
            this.c.setLength(0);
            this.f20625a.clear();
            int iMin = Math.min(this.h, this.d);
            while (this.b.size() >= iMin) {
                this.b.remove(0);
            }
        }

        public void l(int i) {
            this.g = i;
        }

        public void m(int i) {
            this.h = i;
        }

        public void p(int i, boolean z) {
            this.f20625a.add(new C1273a(i, z, this.c.length()));
        }
    }

    public rz(String str, int i, long j) {
        this.k = j > 0 ? j * 1000 : -9223372036854775807L;
        this.h = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i == 1) {
            this.j = 0;
            this.i = 0;
        } else if (i == 2) {
            this.j = 1;
            this.i = 0;
        } else if (i == 3) {
            this.j = 0;
            this.i = 1;
        } else if (i != 4) {
            y53.i("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.j = 0;
            this.i = 0;
        } else {
            this.j = 1;
            this.i = 1;
        }
        I(0);
        H();
        this.w = true;
        this.x = -9223372036854775807L;
    }

    public static boolean A(byte b) {
        return (b & 240) == 16;
    }

    public static boolean C(byte b) {
        return (b & 246) == 20;
    }

    public static boolean D(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 48;
    }

    public static boolean E(byte b, byte b2) {
        return (b & 247) == 23 && b2 >= 33 && b2 <= 35;
    }

    public static boolean F(byte b) {
        return 1 <= b && b <= 15;
    }

    public static char l(byte b) {
        return (char) B[(b & ByteCompanionObject.MAX_VALUE) - 32];
    }

    public static int m(byte b) {
        return (b >> 3) & 1;
    }

    public static char o(byte b) {
        return (char) D[b & TELogUtils.DEBUG_LEVEL_V];
    }

    public static char p(byte b) {
        return (char) E[b & TELogUtils.DEBUG_LEVEL_V];
    }

    public static char q(byte b, byte b2) {
        return (b & 1) == 0 ? o(b2) : p(b2);
    }

    public static char r(byte b) {
        return (char) C[b & 15];
    }

    public static boolean v(byte b) {
        return (b & 224) == 0;
    }

    public static boolean w(byte b, byte b2) {
        return (b & 246) == 18 && (b2 & 224) == 32;
    }

    public static boolean x(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 32;
    }

    public static boolean y(byte b, byte b2) {
        return (b & 246) == 20 && (b2 & 240) == 32;
    }

    public static boolean z(byte b, byte b2) {
        return (b & 240) == 16 && (b2 & 192) == 64;
    }

    public final boolean B(boolean z2, byte b, byte b2) {
        if (!z2 || !A(b)) {
            this.s = false;
        } else {
            if (this.s && this.t == b && this.u == b2) {
                this.s = false;
                return true;
            }
            this.s = true;
            this.t = b;
            this.u = b2;
        }
        return false;
    }

    public final void G(byte b, byte b2) {
        if (F(b)) {
            this.w = false;
            return;
        }
        if (C(b)) {
            if (b2 != 32 && b2 != 47) {
                switch (b2) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b2) {
                            case 42:
                            case 43:
                                this.w = false;
                                break;
                        }
                }
            }
            this.w = true;
        }
    }

    public final void H() {
        this.m.j(this.p);
        this.l.clear();
        this.l.add(this.m);
    }

    public final void I(int i) {
        int i2 = this.p;
        if (i2 == i) {
            return;
        }
        this.p = i;
        if (i == 3) {
            for (int i3 = 0; i3 < this.l.size(); i3++) {
                this.l.get(i3).l(i);
            }
            return;
        }
        H();
        if (i2 == 3 || i == 1 || i == 0) {
            this.n = Collections.emptyList();
        }
    }

    public final void J(int i) {
        this.q = i;
        this.m.m(i);
    }

    public final boolean K() {
        return (this.k == -9223372036854775807L || this.x == -9223372036854775807L || f() - this.x < this.k) ? false : true;
    }

    public final boolean L(byte b) {
        if (v(b)) {
            this.v = m(b);
        }
        return this.v == this.j;
    }

    @Override // defpackage.vz
    public dn5 a() {
        List<pr0> list = this.n;
        this.o = list;
        return new wz((List) vh.e(list));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    @Override // defpackage.vz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(in5 in5Var) {
        ByteBuffer byteBuffer = (ByteBuffer) vh.e(in5Var.c);
        this.g.S(byteBuffer.array(), byteBuffer.limit());
        boolean z2 = false;
        while (true) {
            int iA = this.g.a();
            int i = this.h;
            if (iA < i) {
                break;
            }
            int iH = i == 2 ? -4 : this.g.H();
            int iH2 = this.g.H();
            int iH3 = this.g.H();
            if ((iH & 2) == 0 && (iH & 1) == this.i) {
                byte b = (byte) (iH2 & 127);
                byte b2 = (byte) (iH3 & 127);
                if (b != 0 || b2 != 0) {
                    boolean z3 = this.r;
                    if ((iH & 4) == 4) {
                        boolean[] zArr = F;
                        boolean z4 = zArr[iH2] && zArr[iH3];
                        this.r = z4;
                        if (!B(z4, b, b2)) {
                            if (this.r) {
                                G(b, b2);
                                if (this.w && L(b)) {
                                    if (!v(b)) {
                                        this.m.e(l(b));
                                        if ((b2 & 224) != 0) {
                                            this.m.e(l(b2));
                                        }
                                    } else if (D(b, b2)) {
                                        this.m.e(r(b2));
                                    } else if (w(b, b2)) {
                                        this.m.f();
                                        this.m.e(q(b, b2));
                                    } else if (x(b, b2)) {
                                        s(b2);
                                    } else if (z(b, b2)) {
                                        u(b, b2);
                                    } else if (E(b, b2)) {
                                        this.m.f = b2 - 32;
                                    } else if (y(b, b2)) {
                                        t(b2);
                                    }
                                    z2 = true;
                                }
                            } else if (z3) {
                                H();
                                z2 = true;
                            }
                        }
                    }
                }
            }
        }
        if (z2) {
            int i2 = this.p;
            if (i2 == 1 || i2 == 3) {
                this.n = n();
                this.x = f();
            }
        }
    }

    @Override // defpackage.vz
    @Nullable
    /* JADX INFO: renamed from: c */
    public /* bridge */ /* synthetic */ in5 dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    @Override // defpackage.vz, defpackage.kw0
    @Nullable
    /* JADX INFO: renamed from: d */
    public jn5 dequeueOutputBuffer() throws SubtitleDecoderException {
        jn5 jn5VarE;
        jn5 jn5VarDequeueOutputBuffer = super.dequeueOutputBuffer();
        if (jn5VarDequeueOutputBuffer != null) {
            return jn5VarDequeueOutputBuffer;
        }
        if (!K() || (jn5VarE = e()) == null) {
            return null;
        }
        this.n = Collections.emptyList();
        this.x = -9223372036854775807L;
        jn5VarE.m(f(), a(), Long.MAX_VALUE);
        return jn5VarE;
    }

    @Override // defpackage.vz, defpackage.kw0
    public void flush() {
        super.flush();
        this.n = null;
        this.o = null;
        I(0);
        J(4);
        H();
        this.r = false;
        this.s = false;
        this.t = (byte) 0;
        this.u = (byte) 0;
        this.v = 0;
        this.w = true;
        this.x = -9223372036854775807L;
    }

    @Override // defpackage.vz
    public boolean g() {
        return this.n != this.o;
    }

    @Override // defpackage.vz
    /* JADX INFO: renamed from: h */
    public /* bridge */ /* synthetic */ void queueInputBuffer(in5 in5Var) throws SubtitleDecoderException {
        super.queueInputBuffer(in5Var);
    }

    public final List<pr0> n() {
        int size = this.l.size();
        ArrayList arrayList = new ArrayList(size);
        int iMin = 2;
        for (int i = 0; i < size; i++) {
            pr0 pr0VarG = this.l.get(i).g(Integer.MIN_VALUE);
            arrayList.add(pr0VarG);
            if (pr0VarG != null) {
                iMin = Math.min(iMin, pr0VarG.i);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            pr0 pr0Var = (pr0) arrayList.get(i2);
            if (pr0Var != null) {
                if (pr0Var.i != iMin) {
                    pr0Var = (pr0) vh.e(this.l.get(i2).g(iMin));
                }
                arrayList2.add(pr0Var);
            }
        }
        return arrayList2;
    }

    public final void s(byte b) {
        this.m.e(' ');
        this.m.p((b >> 1) & 7, (b & 1) == 1);
    }

    @Override // defpackage.vz, defpackage.en5
    public /* bridge */ /* synthetic */ void setPositionUs(long j) {
        super.setPositionUs(j);
    }

    public final void t(byte b) {
        if (b == 32) {
            I(2);
            return;
        }
        if (b == 41) {
            I(3);
            return;
        }
        switch (b) {
            case 37:
                I(1);
                J(2);
                break;
            case 38:
                I(1);
                J(3);
                break;
            case 39:
                I(1);
                J(4);
                break;
            default:
                int i = this.p;
                if (i != 0) {
                    if (b != 33) {
                        switch (b) {
                            case 44:
                                this.n = Collections.emptyList();
                                int i2 = this.p;
                                if (i2 == 1 || i2 == 3) {
                                    H();
                                }
                                break;
                            case 45:
                                if (i == 1 && !this.m.i()) {
                                    this.m.k();
                                    break;
                                }
                                break;
                            case 46:
                                H();
                                break;
                            case 47:
                                this.n = n();
                                H();
                                break;
                        }
                    } else {
                        this.m.f();
                        break;
                    }
                }
                break;
        }
    }

    public final void u(byte b, byte b2) {
        int i = y[b & 7];
        if ((b2 & 32) != 0) {
            i++;
        }
        if (i != this.m.d) {
            if (this.p != 1 && !this.m.i()) {
                a aVar = new a(this.p, this.q);
                this.m = aVar;
                this.l.add(aVar);
            }
            this.m.d = i;
        }
        boolean z2 = (b2 & 16) == 16;
        boolean z3 = (b2 & 1) == 1;
        int i2 = (b2 >> 1) & 7;
        this.m.p(z2 ? 8 : i2, z3);
        if (z2) {
            this.m.e = z[i2];
        }
    }

    @Override // defpackage.vz, defpackage.kw0
    public void release() {
    }
}
