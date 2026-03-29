package com.opos.exoplayer.core.text.a;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.exoplayer.core.text.Cue;
import com.opos.exoplayer.core.text.g;
import com.opos.exoplayer.core.util.p;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f8316a = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] b = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] c = {-1, -16711936, -16776961, -16711681, SupportMenu.CATEGORY_MASK, InputDeviceCompat.SOURCE_ANY, -65281};
    private static final int[] d = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 209, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 9632};
    private static final int[] e = {MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD, 189, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 8482, 162, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 9834, 224, 32, 232, 226, 234, 238, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR};
    private static final int[] f = {MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT, 201, 211, 218, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, AVMDLDataLoader.KeyIsLoaderFactoryP2PLevel, 161, 42, 39, q.a.D, 169, 8480, 8226, 8220, 8221, 192, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, 200, 202, 203, 235, 206, 207, 239, 212, 217, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 219, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME};
    private static final int[] g = {MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 227, 205, 204, 236, 210, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE, 213, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR, 123, 125, 92, 94, 95, 124, 126, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 228, 214, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 223, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME, 9474, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 229, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 9484, 9488, 9492, 9496};
    private final int i;
    private final int j;
    private List<Cue> m;
    private List<Cue> n;
    private int o;
    private int p;
    private boolean q;
    private byte r;
    private byte s;
    private final p h = new p();
    private final ArrayList<C0698a> k = new ArrayList<>();
    private C0698a l = new C0698a(0, 4);

    /* JADX INFO: renamed from: com.opos.exoplayer.core.text.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0698a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<CharacterStyle> f8317a = new ArrayList();
        private final List<C0699a> b = new ArrayList();
        private final List<SpannableString> c = new ArrayList();
        private final SpannableStringBuilder d = new SpannableStringBuilder();
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;

        /* JADX INFO: renamed from: com.opos.exoplayer.core.text.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0699a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CharacterStyle f8318a;
            public final int b;
            public final int c;

            public C0699a(CharacterStyle characterStyle, int i, int i2) {
                this.f8318a = characterStyle;
                this.b = i;
                this.c = i2;
            }
        }

        public C0698a(int i, int i2) {
            a(i);
            b(i2);
        }

        public void a(char c) {
            this.d.append(c);
        }

        public void b() {
            int length = this.d.length();
            if (length > 0) {
                this.d.delete(length - 1, length);
            }
        }

        public int c() {
            return this.e;
        }

        public void d() {
            this.c.add(e());
            this.d.clear();
            this.f8317a.clear();
            this.b.clear();
            this.j = -1;
            int iMin = Math.min(this.i, this.e);
            while (this.c.size() >= iMin) {
                this.c.remove(0);
            }
        }

        public SpannableString e() {
            int length = this.d.length();
            int i = 0;
            for (int i2 = 0; i2 < this.f8317a.size(); i2++) {
                this.d.setSpan(this.f8317a.get(i2), 0, length, 33);
            }
            while (i < this.b.size()) {
                C0699a c0699a = this.b.get(i);
                int size = this.b.size();
                int i3 = c0699a.c;
                this.d.setSpan(c0699a.f8318a, c0699a.b, i < size - i3 ? this.b.get(i3 + i).b : length, 33);
                i++;
            }
            if (this.j != -1) {
                this.d.setSpan(new UnderlineSpan(), this.j, length, 33);
            }
            return new SpannableString(this.d);
        }

        public Cue f() {
            float f;
            int i;
            int i2;
            int i3;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.c.size(); i4++) {
                spannableStringBuilder.append((CharSequence) this.c.get(i4));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) e());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i5 = this.f + this.g;
            int length = (32 - i5) - spannableStringBuilder.length();
            int i6 = i5 - length;
            if (this.h == 2 && (Math.abs(i6) < 3 || length < 0)) {
                f = 0.5f;
                i = 1;
            } else if (this.h != 2 || i6 <= 0) {
                f = ((i5 / 32.0f) * 0.8f) + 0.1f;
                i = 0;
            } else {
                f = (((32 - length) / 32.0f) * 0.8f) + 0.1f;
                i = 2;
            }
            if (this.h == 1 || (i2 = this.e) > 7) {
                i2 = (this.e - 15) - 2;
                i3 = 2;
            } else {
                i3 = 0;
            }
            return new Cue(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, i2, 1, i3, f, i, Float.MIN_VALUE);
        }

        public String toString() {
            return this.d.toString();
        }

        public void a(int i) {
            this.h = i;
            this.f8317a.clear();
            this.b.clear();
            this.c.clear();
            this.d.clear();
            this.e = 15;
            this.f = 0;
            this.g = 0;
            this.j = -1;
        }

        public void b(int i) {
            this.i = i;
        }

        public void c(int i) {
            this.e = i;
        }

        public void d(int i) {
            this.f = i;
        }

        public void e(int i) {
            this.g = i;
        }

        public void a(CharacterStyle characterStyle) {
            this.f8317a.add(characterStyle);
        }

        public void a(CharacterStyle characterStyle, int i) {
            this.b.add(new C0699a(characterStyle, this.d.length(), i));
        }

        public void a(boolean z) {
            if (z) {
                this.j = this.d.length();
            } else if (this.j != -1) {
                this.d.setSpan(new UnderlineSpan(), this.j, this.d.length(), 33);
                this.j = -1;
            }
        }

        public boolean a() {
            return this.f8317a.isEmpty() && this.b.isEmpty() && this.c.isEmpty() && this.d.length() == 0;
        }
    }

    public a(String str, int i) {
        this.i = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i == 3 || i == 4) {
            this.j = 2;
        } else {
            this.j = 1;
        }
        a(0);
        j();
    }

    private void a(byte b2) {
        this.l.a((b2 & 1) == 1);
        int i = (b2 >> 1) & 15;
        if (i != 7) {
            this.l.a(new ForegroundColorSpan(c[i]), 1);
        } else {
            this.l.a(new StyleSpan(2), 2);
            this.l.a(new ForegroundColorSpan(-1), 1);
        }
    }

    private void b(byte b2) {
        if (b2 == 32) {
            a(2);
            return;
        }
        if (b2 == 41) {
            a(3);
            return;
        }
        switch (b2) {
            case 37:
                a(1);
                b(2);
                break;
            case 38:
                a(1);
                b(3);
                break;
            case 39:
                a(1);
                b(4);
                break;
            default:
                int i = this.o;
                if (i != 0) {
                    if (b2 == 33) {
                        this.l.b();
                    } else if (b2 != 36) {
                        switch (b2) {
                            case 44:
                                this.m = null;
                                if (i != 1 && i != 3) {
                                }
                                break;
                            case 45:
                                if (i == 1 && !this.l.a()) {
                                    this.l.d();
                                    break;
                                }
                                break;
                            case 47:
                                this.m = i();
                                break;
                        }
                        j();
                    }
                    break;
                }
                break;
        }
    }

    private static char c(byte b2) {
        return (char) d[(b2 & ByteCompanionObject.MAX_VALUE) - 32];
    }

    private static char d(byte b2) {
        return (char) e[b2 & 15];
    }

    private static char e(byte b2) {
        return (char) f[b2 & TELogUtils.DEBUG_LEVEL_V];
    }

    private static char f(byte b2) {
        return (char) g[b2 & TELogUtils.DEBUG_LEVEL_V];
    }

    private List<Cue> i() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.k.size(); i++) {
            Cue cueF = this.k.get(i).f();
            if (cueF != null) {
                arrayList.add(cueF);
            }
        }
        return arrayList;
    }

    private void j() {
        this.l.a(this.o);
        this.k.clear();
        this.k.add(this.l);
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

    private void a(int i) {
        int i2 = this.o;
        if (i2 == i) {
            return;
        }
        this.o = i;
        j();
        if (i2 == 3 || i == 1 || i == 0) {
            this.m = null;
        }
    }

    private void b(byte b2, byte b3) {
        int i = f8316a[b2 & 7];
        if ((b3 & 32) != 0) {
            i++;
        }
        if (i != this.l.c()) {
            if (this.o != 1 && !this.l.a()) {
                C0698a c0698a = new C0698a(this.o, this.p);
                this.l = c0698a;
                this.k.add(c0698a);
            }
            this.l.c(i);
        }
        if ((b3 & 1) == 1) {
            this.l.a(new UnderlineSpan());
        }
        int i2 = (b3 >> 1) & 15;
        if (i2 > 7) {
            this.l.d(b[i2 & 7]);
        } else if (i2 != 7) {
            this.l.a(new ForegroundColorSpan(c[i2]));
        } else {
            this.l.a(new StyleSpan(2));
            this.l.a(new ForegroundColorSpan(-1));
        }
    }

    private static boolean g(byte b2) {
        return (b2 & 240) == 16;
    }

    @Override // com.opos.exoplayer.core.text.a.e, com.opos.exoplayer.core.decoder.c
    public void c() {
        super.c();
        this.m = null;
        this.n = null;
        a(0);
        b(4);
        j();
        this.q = false;
        this.r = (byte) 0;
        this.s = (byte) 0;
    }

    @Override // com.opos.exoplayer.core.text.a.e, com.opos.exoplayer.core.decoder.c
    public void d() {
    }

    @Override // com.opos.exoplayer.core.text.a.e
    public boolean e() {
        return this.m != this.n;
    }

    @Override // com.opos.exoplayer.core.text.a.e
    public com.opos.exoplayer.core.text.b f() {
        List<Cue> list = this.m;
        this.n = list;
        return new f(list);
    }

    private void b(int i) {
        this.p = i;
        this.l.b(i);
    }

    private static boolean c(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 32;
    }

    private static boolean d(byte b2, byte b3) {
        return (b2 & 240) == 16 && (b3 & 192) == 64;
    }

    private static boolean e(byte b2, byte b3) {
        return (b2 & 247) == 23 && b3 >= 33 && b3 <= 35;
    }

    private static boolean f(byte b2, byte b3) {
        return (b2 & 247) == 20 && (b3 & 240) == 32;
    }

    @Override // com.opos.exoplayer.core.text.a.e, com.opos.exoplayer.core.text.c
    public /* bridge */ /* synthetic */ void a(long j) {
        super.a(j);
    }

    @Override // com.opos.exoplayer.core.text.a.e
    public void a(com.opos.exoplayer.core.text.f fVar) {
        int i;
        C0698a c0698a;
        char c2;
        this.h.a(fVar.b.array(), fVar.b.limit());
        boolean z = false;
        boolean zA = false;
        while (true) {
            int iB = this.h.b();
            int i2 = this.i;
            if (iB < i2) {
                break;
            }
            byte bG = i2 == 2 ? (byte) -4 : (byte) this.h.g();
            byte bG2 = (byte) (this.h.g() & 127);
            byte bG3 = (byte) (this.h.g() & 127);
            if ((bG & 6) == 4 && ((i = this.j) != 1 || (bG & 1) == 0)) {
                if (i != 2 || (bG & 1) == 1) {
                    if (bG2 != 0 || bG3 != 0) {
                        if ((bG2 & 247) == 17 && (bG3 & 240) == 48) {
                            c0698a = this.l;
                            c2 = d(bG3);
                        } else if ((bG2 & 246) == 18 && (bG3 & 224) == 32) {
                            this.l.b();
                            if ((bG2 & 1) == 0) {
                                c0698a = this.l;
                                c2 = e(bG3);
                            } else {
                                c0698a = this.l;
                                c2 = f(bG3);
                            }
                        } else {
                            if ((bG2 & 224) == 0) {
                                zA = a(bG2, bG3);
                            } else {
                                this.l.a(c(bG2));
                                if ((bG3 & 224) != 0) {
                                    c0698a = this.l;
                                    c2 = c(bG3);
                                }
                            }
                            z = true;
                        }
                        c0698a.a(c2);
                        z = true;
                    }
                }
            }
        }
        if (z) {
            if (!zA) {
                this.q = false;
            }
            int i3 = this.o;
            if (i3 == 1 || i3 == 3) {
                this.m = i();
            }
        }
    }

    @Override // com.opos.exoplayer.core.text.a.e
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ void a(com.opos.exoplayer.core.text.f fVar) {
        super.a(fVar);
    }

    private boolean a(byte b2, byte b3) {
        boolean zG = g(b2);
        if (zG) {
            if (this.q && this.r == b2 && this.s == b3) {
                this.q = false;
                return true;
            }
            this.q = true;
            this.r = b2;
            this.s = b3;
        }
        if (c(b2, b3)) {
            a(b3);
        } else if (d(b2, b3)) {
            b(b2, b3);
        } else if (e(b2, b3)) {
            this.l.e(b3 - 32);
        } else if (f(b2, b3)) {
            b(b3);
        }
        return zG;
    }
}
