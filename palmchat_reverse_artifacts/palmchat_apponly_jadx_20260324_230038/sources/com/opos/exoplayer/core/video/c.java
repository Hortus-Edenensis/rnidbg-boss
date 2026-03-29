package com.opos.exoplayer.core.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.oplus.tbl.exoplayer2.audio.DefaultAudioSink;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.decoder.DecoderInputBuffer;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.util.m;
import com.opos.exoplayer.core.util.x;
import com.opos.exoplayer.core.util.y;
import com.opos.exoplayer.core.video.f;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TECameraUtils;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@TargetApi(16)
public class c extends com.opos.exoplayer.core.b.b {
    private static final int[] c = {TECameraUtils.CAPTURE_NORMAL, 1600, 1440, 1280, 960, 854, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 540, TECameraSettings.FPS_480};
    private int A;
    private int B;
    private float C;
    private int D;
    private int E;
    private int F;
    private float G;
    private boolean H;
    private int I;
    private long J;
    private int K;
    C0706c b;
    private final Context d;
    private final d e;
    private final f.a f;
    private final long g;
    private final int h;
    private final boolean i;
    private final long[] j;
    private Format[] k;
    private a l;
    private boolean m;
    private Surface n;
    private Surface o;
    private int p;
    private boolean q;
    private long r;
    private long s;
    private int t;
    private int u;
    private int v;
    private long w;
    private int x;
    private float y;
    private int z;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8416a;
        public final int b;
        public final int c;

        public a(int i, int i2, int i3) {
            this.f8416a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.video.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(23)
    public final class C0706c implements MediaCodec.OnFrameRenderedListener {
        private C0706c(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public void onFrameRendered(@NonNull MediaCodec mediaCodec, long j, long j2) {
            c cVar = c.this;
            if (this != cVar.b) {
                return;
            }
            cVar.v();
        }
    }

    public c(Context context, com.opos.exoplayer.core.b.c cVar, long j, @Nullable com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.e> bVar, boolean z, @Nullable Handler handler, @Nullable f fVar, int i) {
        super(2, cVar, bVar, z);
        this.g = j;
        this.h = i;
        this.d = context.getApplicationContext();
        this.e = new d(context);
        this.f = new f.a(handler, fVar);
        this.i = K();
        this.j = new long[10];
        this.J = -9223372036854775807L;
        this.r = -9223372036854775807L;
        this.z = -1;
        this.A = -1;
        this.C = -1.0f;
        this.y = -1.0f;
        this.p = 1;
        G();
    }

    private void D() {
        this.r = this.g > 0 ? SystemClock.elapsedRealtime() + this.g : -9223372036854775807L;
    }

    private void E() {
        MediaCodec mediaCodecY;
        this.q = false;
        if (y.f8407a < 23 || !this.H || (mediaCodecY = y()) == null) {
            return;
        }
        this.b = new C0706c(mediaCodecY);
    }

    private void F() {
        if (this.q) {
            this.f.a(this.n);
        }
    }

    private void G() {
        this.D = -1;
        this.E = -1;
        this.G = -1.0f;
        this.F = -1;
    }

    private void H() {
        int i = this.z;
        if (i == -1 && this.A == -1) {
            return;
        }
        if (this.D == i && this.E == this.A && this.F == this.B && this.G == this.C) {
            return;
        }
        this.f.a(i, this.A, this.B, this.C);
        this.D = this.z;
        this.E = this.A;
        this.F = this.B;
        this.G = this.C;
    }

    private void I() {
        int i = this.D;
        if (i == -1 && this.E == -1) {
            return;
        }
        this.f.a(i, this.E, this.F, this.G);
    }

    private void J() {
        if (this.t > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f.a(this.t, jElapsedRealtime - this.s);
            this.t = 0;
            this.s = jElapsedRealtime;
        }
    }

    private static boolean K() {
        return y.f8407a <= 22 && "foster".equals(y.b) && "NVIDIA".equals(y.c);
    }

    private static int d(Format format) {
        if (format.g == -1) {
            return a(format.f, format.j, format.k);
        }
        int size = format.h.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += format.h.get(i).length;
        }
        return format.g + length;
    }

    private static float e(Format format) {
        float f = format.n;
        if (f == -1.0f) {
            return 1.0f;
        }
        return f;
    }

    private static int f(Format format) {
        int i = format.m;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    @Override // com.opos.exoplayer.core.b.b
    @CallSuper
    public void A() {
        try {
            super.A();
            this.v = 0;
            Surface surface = this.o;
            if (surface != null) {
                if (this.n == surface) {
                    this.n = null;
                }
                surface.release();
                this.o = null;
            }
        } catch (Throwable th) {
            this.v = 0;
            Surface surface2 = this.o;
            if (surface2 != null) {
                if (this.n == surface2) {
                    this.n = null;
                }
                this.o.release();
                this.o = null;
            }
            throw th;
        }
    }

    @Override // com.opos.exoplayer.core.b.b
    @CallSuper
    public void B() {
        super.B();
        this.v = 0;
    }

    @Override // com.opos.exoplayer.core.b.b
    public int a(com.opos.exoplayer.core.b.c cVar, com.opos.exoplayer.core.drm.b<com.opos.exoplayer.core.drm.e> bVar, Format format) {
        boolean z;
        int i;
        int i2;
        String str = format.f;
        if (!m.b(str)) {
            return 0;
        }
        DrmInitData drmInitData = format.i;
        if (drmInitData != null) {
            z = false;
            for (int i3 = 0; i3 < drmInitData.b; i3++) {
                z |= drmInitData.a(i3).c;
            }
        } else {
            z = false;
        }
        com.opos.exoplayer.core.b.a aVarA = cVar.a(str, z);
        if (aVarA == null) {
            return (!z || cVar.a(str, false) == null) ? 1 : 2;
        }
        if (!com.opos.exoplayer.core.a.a(bVar, drmInitData)) {
            return 2;
        }
        boolean zB = aVarA.b(format.c);
        if (zB && (i = format.j) > 0 && (i2 = format.k) > 0) {
            if (y.f8407a >= 21) {
                zB = aVarA.a(i, i2, format.l);
            } else {
                boolean z2 = i * i2 <= com.opos.exoplayer.core.b.d.b();
                if (!z2) {
                    com.opos.cmn.an.f.a.b("MediaCodecVideoRenderer", "FalseCheck [legacyFrameSize, " + format.j + "x" + format.k + "] [" + y.e + "]");
                }
                zB = z2;
            }
        }
        return (zB ? 4 : 3) | (aVarA.b ? 16 : 8) | (aVarA.c ? 32 : 0);
    }

    public void b(int i) {
        com.opos.exoplayer.core.decoder.d dVar = ((com.opos.exoplayer.core.b.b) this).f8112a;
        dVar.g += i;
        this.t += i;
        int i2 = this.u + i;
        this.u = i2;
        dVar.h = Math.max(i2, dVar.h);
        if (this.t >= this.h) {
            J();
        }
    }

    @Override // com.opos.exoplayer.core.b.b
    @CallSuper
    public void c(long j) {
        this.v--;
    }

    @Override // com.opos.exoplayer.core.b.b, com.opos.exoplayer.core.a
    public void n() {
        super.n();
        this.t = 0;
        this.s = SystemClock.elapsedRealtime();
        this.w = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.opos.exoplayer.core.b.b, com.opos.exoplayer.core.a
    public void o() {
        this.r = -9223372036854775807L;
        J();
        super.o();
    }

    @Override // com.opos.exoplayer.core.b.b, com.opos.exoplayer.core.a
    public void p() {
        this.z = -1;
        this.A = -1;
        this.C = -1.0f;
        this.y = -1.0f;
        this.J = -9223372036854775807L;
        this.K = 0;
        G();
        E();
        this.e.b();
        this.b = null;
        this.H = false;
        try {
            super.p();
        } finally {
            ((com.opos.exoplayer.core.b.b) this).f8112a.a();
            this.f.b(((com.opos.exoplayer.core.b.b) this).f8112a);
        }
    }

    @Override // com.opos.exoplayer.core.b.b, com.opos.exoplayer.core.q
    public boolean t() {
        Surface surface;
        if (super.t() && (this.q || (((surface = this.o) != null && this.n == surface) || y() == null || this.H))) {
            this.r = -9223372036854775807L;
            return true;
        }
        if (this.r == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.r) {
            return true;
        }
        this.r = -9223372036854775807L;
        return false;
    }

    public void v() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.f.a(this.n);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(String str, int i, int i2) {
        int i3;
        int iA;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        str.hashCode();
        i3 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                iA = i * i2;
                i3 = 2;
                break;
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                iA = i * i2;
                break;
            case "video/avc":
                if (!"BRAVIA 4K 2015".equals(y.d)) {
                    iA = y.a(i, 16) * y.a(i2, 16) * 16 * 16;
                    i3 = 2;
                    break;
                }
                break;
        }
        return -1;
    }

    private static boolean d(long j) {
        return j < -30000;
    }

    private static boolean e(long j) {
        return j < -500000;
    }

    public void b(MediaCodec mediaCodec, int i, long j) {
        x.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        x.a();
        b(1);
    }

    public void c(MediaCodec mediaCodec, int i, long j) {
        H();
        x.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        x.a();
        this.w = SystemClock.elapsedRealtime() * 1000;
        ((com.opos.exoplayer.core.b.b) this).f8112a.e++;
        this.u = 0;
        v();
    }

    private static Point a(com.opos.exoplayer.core.b.a aVar, Format format) {
        int i = format.k;
        int i2 = format.j;
        boolean z = i > i2;
        int i3 = z ? i : i2;
        if (z) {
            i = i2;
        }
        float f = i / i3;
        for (int i4 : c) {
            int i5 = (int) (i4 * f);
            if (i4 <= i3 || i5 <= i) {
                break;
            }
            if (y.f8407a >= 21) {
                int i6 = z ? i5 : i4;
                if (!z) {
                    i4 = i5;
                }
                Point pointA = aVar.a(i6, i4);
                if (aVar.a(pointA.x, pointA.y, format.l)) {
                    return pointA;
                }
            } else {
                int iA = y.a(i4, 16) * 16;
                int iA2 = y.a(i5, 16) * 16;
                if (iA * iA2 <= com.opos.exoplayer.core.b.d.b()) {
                    int i7 = z ? iA2 : iA;
                    if (!z) {
                        iA = iA2;
                    }
                    return new Point(i7, iA);
                }
            }
        }
        return null;
    }

    @TargetApi(21)
    public void b(MediaCodec mediaCodec, int i, long j, long j2) {
        H();
        x.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        x.a();
        this.w = SystemClock.elapsedRealtime() * 1000;
        ((com.opos.exoplayer.core.b.b) this).f8112a.e++;
        this.u = 0;
        v();
    }

    public boolean c(long j, long j2) {
        return e(j);
    }

    public boolean d(long j, long j2) {
        return d(j) && j2 > SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US;
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat a(Format format, a aVar, boolean z, int i) {
        MediaFormat mediaFormatC = c(format);
        mediaFormatC.setInteger(IMediaFormat.KEY_MAX_WIDTH, aVar.f8416a);
        mediaFormatC.setInteger(IMediaFormat.KEY_MAX_HEIGHT, aVar.b);
        int i2 = aVar.c;
        if (i2 != -1) {
            mediaFormatC.setInteger(IMediaFormat.KEY_MAX_INPUT_SIZE, i2);
        }
        if (z) {
            mediaFormatC.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            a(mediaFormatC, i);
        }
        return mediaFormatC;
    }

    @Override // com.opos.exoplayer.core.b.b
    public void b(Format format) {
        super.b(format);
        this.f.a(format);
        this.y = e(format);
        this.x = f(format);
    }

    public a a(com.opos.exoplayer.core.b.a aVar, Format format, Format[] formatArr) {
        int iMax = format.j;
        int iMax2 = format.k;
        int iD = d(format);
        if (formatArr.length == 1) {
            return new a(iMax, iMax2, iD);
        }
        boolean z = false;
        for (Format format2 : formatArr) {
            if (a(aVar.b, format, format2)) {
                int i = format2.j;
                z |= i == -1 || format2.k == -1;
                iMax = Math.max(iMax, i);
                iMax2 = Math.max(iMax2, format2.k);
                iD = Math.max(iD, d(format2));
            }
        }
        if (z) {
            com.opos.cmn.an.f.a.c("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point pointA = a(aVar, format);
            if (pointA != null) {
                iMax = Math.max(iMax, pointA.x);
                iMax2 = Math.max(iMax2, pointA.y);
                iD = Math.max(iD, a(format.f, iMax, iMax2));
                com.opos.cmn.an.f.a.c("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new a(iMax, iMax2, iD);
    }

    public boolean b(long j, long j2) {
        return d(j);
    }

    private boolean b(com.opos.exoplayer.core.b.a aVar) {
        return y.f8407a >= 23 && !this.H && !a(aVar.f8111a) && (!aVar.d || DummySurface.a(this.d));
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.o.b
    public void a(int i, Object obj) {
        if (i == 1) {
            a((Surface) obj);
            return;
        }
        if (i != 4) {
            super.a(i, obj);
            return;
        }
        this.p = ((Integer) obj).intValue();
        MediaCodec mediaCodecY = y();
        if (mediaCodecY != null) {
            a(mediaCodecY, this.p);
        }
    }

    @Override // com.opos.exoplayer.core.b.b, com.opos.exoplayer.core.a
    public void a(long j, boolean z) {
        super.a(j, z);
        E();
        this.u = 0;
        int i = this.K;
        if (i != 0) {
            this.J = this.j[i - 1];
            this.K = 0;
        }
        if (z) {
            D();
        } else {
            this.r = -9223372036854775807L;
        }
    }

    private static void a(MediaCodec mediaCodec, int i) {
        mediaCodec.setVideoScalingMode(i);
    }

    public void a(MediaCodec mediaCodec, int i, long j) {
        x.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        x.a();
        ((com.opos.exoplayer.core.b.b) this).f8112a.f++;
    }

    @Override // com.opos.exoplayer.core.b.b
    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        this.z = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        this.A = integer;
        float f = this.y;
        this.C = f;
        if (y.f8407a >= 21) {
            int i = this.x;
            if (i == 90 || i == 270) {
                int i2 = this.z;
                this.z = integer;
                this.A = i2;
                this.C = 1.0f / f;
            }
        } else {
            this.B = this.x;
        }
        a(mediaCodec, this.p);
    }

    @TargetApi(23)
    private static void a(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    @TargetApi(21)
    private static void a(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger(IMediaFormat.KEY_AUDIO_SESSION_ID, i);
    }

    private void a(Surface surface) {
        if (surface == null) {
            Surface surface2 = this.o;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.opos.exoplayer.core.b.a aVarZ = z();
                if (aVarZ != null && b(aVarZ)) {
                    surface = DummySurface.a(this.d, aVarZ.d);
                    this.o = surface;
                }
            }
        }
        if (this.n == surface) {
            if (surface == null || surface == this.o) {
                return;
            }
            I();
            F();
            return;
        }
        this.n = surface;
        int iA_ = a_();
        if (iA_ == 1 || iA_ == 2) {
            MediaCodec mediaCodecY = y();
            if (y.f8407a < 23 || mediaCodecY == null || surface == null || this.m) {
                A();
                x();
            } else {
                a(mediaCodecY, surface);
            }
        }
        if (surface == null || surface == this.o) {
            G();
            E();
            return;
        }
        I();
        E();
        if (iA_ == 2) {
            D();
        }
    }

    @Override // com.opos.exoplayer.core.b.b
    public void a(com.opos.exoplayer.core.b.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        a aVarA = a(aVar, format, this.k);
        this.l = aVarA;
        MediaFormat mediaFormatA = a(format, aVarA, this.i, this.I);
        if (this.n == null) {
            com.opos.exoplayer.core.util.a.b(b(aVar));
            if (this.o == null) {
                this.o = DummySurface.a(this.d, aVar.d);
            }
            this.n = this.o;
        }
        mediaCodec.configure(mediaFormatA, this.n, mediaCrypto, 0);
        if (y.f8407a < 23 || !this.H) {
            return;
        }
        this.b = new C0706c(mediaCodec);
    }

    @Override // com.opos.exoplayer.core.b.b
    @CallSuper
    public void a(DecoderInputBuffer decoderInputBuffer) {
        this.v++;
        if (y.f8407a >= 23 || !this.H) {
            return;
        }
        v();
    }

    @Override // com.opos.exoplayer.core.b.b
    public void a(String str, long j, long j2) {
        this.f.a(str, j, j2);
        this.m = a(str);
    }

    @Override // com.opos.exoplayer.core.b.b, com.opos.exoplayer.core.a
    public void a(boolean z) {
        super.a(z);
        int i = q().b;
        this.I = i;
        this.H = i != 0;
        this.f.a(((com.opos.exoplayer.core.b.b) this).f8112a);
        this.e.a();
    }

    @Override // com.opos.exoplayer.core.a
    public void a(Format[] formatArr, long j) {
        this.k = formatArr;
        if (this.J == -9223372036854775807L) {
            this.J = j;
        } else {
            int i = this.K;
            if (i == this.j.length) {
                com.opos.cmn.an.f.a.c("MediaCodecVideoRenderer", "Too many stream changes, so dropping offset: " + this.j[this.K - 1]);
            } else {
                this.K = i + 1;
            }
            this.j[this.K - 1] = j;
        }
        super.a(formatArr, j);
    }

    @Override // com.opos.exoplayer.core.b.b
    public boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        long j4;
        long j5;
        while (true) {
            int i3 = this.K;
            if (i3 == 0) {
                break;
            }
            long[] jArr = this.j;
            long j6 = jArr[0];
            if (j3 < j6) {
                break;
            }
            this.J = j6;
            int i4 = i3 - 1;
            this.K = i4;
            System.arraycopy(jArr, 1, jArr, 0, i4);
        }
        long j7 = j3 - this.J;
        if (z) {
            a(mediaCodec, i, j7);
            return true;
        }
        long j8 = j3 - j;
        if (this.n == this.o) {
            if (!d(j8)) {
                return false;
            }
            a(mediaCodec, i, j7);
            return true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        boolean z2 = a_() == 2;
        if (!this.q || (z2 && d(j8, jElapsedRealtime - this.w))) {
            if (y.f8407a >= 21) {
                b(mediaCodec, i, j7, System.nanoTime());
                return true;
            }
            c(mediaCodec, i, j7);
            return true;
        }
        if (!z2) {
            return false;
        }
        long j9 = j8 - (jElapsedRealtime - j2);
        long jNanoTime = System.nanoTime();
        long jA = this.e.a(j3, (j9 * 1000) + jNanoTime);
        long j10 = (jA - jNanoTime) / 1000;
        if (c(j10, j2)) {
            j4 = jA;
            j5 = j10;
            if (a(mediaCodec, i, j7, j)) {
                return false;
            }
        } else {
            j4 = jA;
            j5 = j10;
        }
        if (b(j5, j2)) {
            b(mediaCodec, i, j7);
            return true;
        }
        if (y.f8407a >= 21) {
            if (j5 >= DefaultAudioSink.MIN_AUDIO_UNDERRUN_OFFSET_US) {
                return false;
            }
            b(mediaCodec, i, j7, j4);
            return true;
        }
        if (j5 >= 30000) {
            return false;
        }
        if (j5 > 11000) {
            try {
                Thread.sleep((j5 - 10000) / 1000);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        c(mediaCodec, i, j7);
        return true;
    }

    public boolean a(MediaCodec mediaCodec, int i, long j, long j2) {
        int iB = b(j2);
        if (iB == 0) {
            return false;
        }
        ((com.opos.exoplayer.core.b.b) this).f8112a.i++;
        b(this.v + iB);
        B();
        return true;
    }

    @Override // com.opos.exoplayer.core.b.b
    public boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        if (a(z, format, format2)) {
            int i = format2.j;
            a aVar = this.l;
            if (i <= aVar.f8416a && format2.k <= aVar.b && d(format2) <= this.l.c) {
                return true;
            }
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.b.b
    public boolean a(com.opos.exoplayer.core.b.a aVar) {
        return this.n != null || b(aVar);
    }

    private static boolean a(String str) {
        String str2 = y.b;
        if (((!"deb".equals(str2) && !"flo".equals(str2) && !"mido".equals(str2) && !"santoni".equals(str2)) || !"OMX.qcom.video.decoder.avc".equals(str)) && ((!"tcl_eu".equals(str2) && !"SVP-DTV15".equals(str2) && !"BRAVIA_ATV2".equals(str2) && !str2.startsWith("panell_") && !"F3311".equals(str2) && !"M5c".equals(str2) && !"A7010a48".equals(str2)) || !"OMX.MTK.VIDEO.DECODER.AVC".equals(str))) {
            String str3 = y.d;
            if ((!"ALE-L21".equals(str3) && !"CAM-L21".equals(str3)) || !"OMX.k3.video.decoder.avc".equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(boolean z, Format format, Format format2) {
        return format.f.equals(format2.f) && f(format) == f(format2) && (z || (format.j == format2.j && format.k == format2.k));
    }
}
