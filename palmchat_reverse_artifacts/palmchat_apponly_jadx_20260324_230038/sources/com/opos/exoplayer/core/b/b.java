package com.opos.exoplayer.core.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.ExoPlaybackException;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.b.d;
import com.opos.exoplayer.core.decoder.DecoderInputBuffer;
import com.opos.exoplayer.core.drm.DrmSession;
import com.opos.exoplayer.core.drm.e;
import com.opos.exoplayer.core.j;
import com.opos.exoplayer.core.util.n;
import com.opos.exoplayer.core.util.x;
import com.opos.exoplayer.core.util.y;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@TargetApi(16)
public abstract class b extends com.opos.exoplayer.core.a {
    private static final byte[] b = y.g("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private long A;
    private int B;
    private int C;
    private ByteBuffer D;
    private boolean E;
    private boolean F;
    private int G;
    private int H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.opos.exoplayer.core.decoder.d f8112a;
    private final c c;

    @Nullable
    private final com.opos.exoplayer.core.drm.b<e> d;
    private final boolean e;
    private final DecoderInputBuffer f;
    private final DecoderInputBuffer g;
    private final j h;
    private final List<Long> i;
    private final MediaCodec.BufferInfo j;
    private Format k;
    private DrmSession<e> l;
    private DrmSession<e> m;
    private MediaCodec n;
    private com.opos.exoplayer.core.b.a o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private ByteBuffer[] y;
    private ByteBuffer[] z;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends com.opos.exoplayer.core.util.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8113a;
        public final boolean b;
        public final String c;
        public final String d;

        public a(Format format, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + format, th);
            this.f8113a = format.f;
            this.b = z;
            this.c = null;
            this.d = a(i);
        }

        @Override // com.opos.exoplayer.core.util.b
        public String a() {
            return "DecoderInitializationException";
        }

        public a(Format format, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + format, th);
            this.f8113a = format.f;
            this.b = z;
            this.c = str;
            this.d = y.f8407a >= 21 ? a(th) : null;
        }

        private static String a(int i) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        @TargetApi(21)
        private static String a(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }
    }

    public b(int i, c cVar, @Nullable com.opos.exoplayer.core.drm.b<e> bVar, boolean z) {
        super(i);
        com.opos.exoplayer.core.util.a.b(y.f8407a >= 16);
        this.c = (c) com.opos.exoplayer.core.util.a.a(cVar);
        this.d = bVar;
        this.e = z;
        this.f = new DecoderInputBuffer(0);
        this.g = DecoderInputBuffer.e();
        this.h = new j();
        this.i = new ArrayList();
        this.j = new MediaCodec.BufferInfo();
        this.G = 0;
        this.H = 0;
    }

    private void D() {
        if (y.f8407a < 21) {
            this.y = this.n.getInputBuffers();
            this.z = this.n.getOutputBuffers();
        }
    }

    private void E() {
        if (y.f8407a < 21) {
            this.y = null;
            this.z = null;
        }
    }

    private boolean F() {
        return this.C >= 0;
    }

    private void G() {
        this.B = -1;
        this.f.b = null;
    }

    private void H() {
        this.C = -1;
        this.D = null;
    }

    private void I() {
        MediaFormat outputFormat = this.n.getOutputFormat();
        if (this.p != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.x = true;
            return;
        }
        if (this.v) {
            outputFormat.setInteger("channel-count", 1);
        }
        a(this.n, outputFormat);
    }

    private void J() {
        if (y.f8407a < 21) {
            this.z = this.n.getOutputBuffers();
        }
    }

    private void K() {
        if (this.H == 2) {
            A();
            x();
        } else {
            this.L = true;
            w();
        }
    }

    private int b(String str) {
        int i = y.f8407a;
        if (i <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = y.d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = y.b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    private boolean d(long j) {
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            if (this.i.get(i).longValue() == j) {
                this.i.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean e(String str) {
        return y.f8407a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private boolean v() throws ExoPlaybackException {
        int iPosition;
        int iA;
        MediaCodec mediaCodec = this.n;
        if (mediaCodec == null || this.H == 2 || this.K) {
            return false;
        }
        if (this.B < 0) {
            int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.B = iDequeueInputBuffer;
            if (iDequeueInputBuffer < 0) {
                return false;
            }
            this.f.b = b(iDequeueInputBuffer);
            this.f.a();
        }
        if (this.H == 1) {
            if (!this.s) {
                this.J = true;
                this.n.queueInputBuffer(this.B, 0, 0, 0L, 4);
                G();
            }
            this.H = 2;
            return false;
        }
        if (this.w) {
            this.w = false;
            ByteBuffer byteBuffer = this.f.b;
            byte[] bArr = b;
            byteBuffer.put(bArr);
            this.n.queueInputBuffer(this.B, 0, bArr.length, 0L, 0);
            G();
            this.I = true;
            return true;
        }
        if (this.M) {
            iA = -4;
            iPosition = 0;
        } else {
            if (this.G == 1) {
                for (int i = 0; i < this.k.h.size(); i++) {
                    this.f.b.put(this.k.h.get(i));
                }
                this.G = 2;
            }
            iPosition = this.f.b.position();
            iA = a(this.h, this.f, false);
        }
        if (iA == -3) {
            return false;
        }
        if (iA == -5) {
            if (this.G == 2) {
                this.f.a();
                this.G = 1;
            }
            b(this.h.f8252a);
            return true;
        }
        if (this.f.c()) {
            if (this.G == 2) {
                this.f.a();
                this.G = 1;
            }
            this.K = true;
            if (!this.I) {
                K();
                return false;
            }
            try {
                if (!this.s) {
                    this.J = true;
                    this.n.queueInputBuffer(this.B, 0, 0, 0L, 4);
                    G();
                }
                return false;
            } catch (MediaCodec.CryptoException e) {
                String strA = y.a(e);
                ExoPlaybackException exoPlaybackExceptionA = ExoPlaybackException.a(e, r());
                exoPlaybackExceptionA.a(strA);
                throw exoPlaybackExceptionA;
            }
        }
        if (this.N && !this.f.d()) {
            this.f.a();
            if (this.G == 2) {
                this.G = 1;
            }
            return true;
        }
        this.N = false;
        boolean zG = this.f.g();
        boolean zB = b(zG);
        this.M = zB;
        if (zB) {
            return false;
        }
        if (this.q && !zG) {
            n.a(this.f.b);
            if (this.f.b.position() == 0) {
                return true;
            }
            this.q = false;
        }
        try {
            DecoderInputBuffer decoderInputBuffer = this.f;
            long j = decoderInputBuffer.c;
            if (decoderInputBuffer.d_()) {
                this.i.add(Long.valueOf(j));
            }
            this.f.h();
            a(this.f);
            if (zG) {
                this.n.queueSecureInputBuffer(this.B, 0, a(this.f, iPosition), j, 0);
            } else {
                this.n.queueInputBuffer(this.B, 0, this.f.b.limit(), j, 0);
            }
            G();
            this.I = true;
            this.G = 0;
            this.f8112a.c++;
            return true;
        } catch (MediaCodec.CryptoException e2) {
            String strA2 = y.a(e2);
            ExoPlaybackException exoPlaybackExceptionA2 = ExoPlaybackException.a(e2, r());
            exoPlaybackExceptionA2.a(strA2);
            throw exoPlaybackExceptionA2;
        }
    }

    public void A() {
        this.A = -9223372036854775807L;
        G();
        H();
        this.M = false;
        this.E = false;
        this.i.clear();
        E();
        this.o = null;
        this.F = false;
        this.I = false;
        this.q = false;
        this.r = false;
        this.p = 0;
        this.s = false;
        this.t = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.J = false;
        this.G = 0;
        this.H = 0;
        MediaCodec mediaCodec = this.n;
        if (mediaCodec != null) {
            this.f8112a.b++;
            try {
                mediaCodec.stop();
                try {
                    this.n.release();
                    this.n = null;
                    DrmSession<e> drmSession = this.l;
                    if (drmSession == null || this.m == drmSession) {
                        return;
                    }
                    try {
                        this.d.a(drmSession);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.n = null;
                    DrmSession<e> drmSession2 = this.l;
                    if (drmSession2 != null && this.m != drmSession2) {
                        try {
                            this.d.a(drmSession2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.n.release();
                    this.n = null;
                    DrmSession<e> drmSession3 = this.l;
                    if (drmSession3 != null && this.m != drmSession3) {
                        try {
                            this.d.a(drmSession3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.n = null;
                    DrmSession<e> drmSession4 = this.l;
                    if (drmSession4 != null && this.m != drmSession4) {
                        try {
                            this.d.a(drmSession4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    public void B() {
        this.A = -9223372036854775807L;
        G();
        H();
        this.N = true;
        this.M = false;
        this.E = false;
        this.i.clear();
        this.w = false;
        this.x = false;
        if (this.r || ((this.t && this.J) || this.H != 0)) {
            A();
            x();
        } else {
            this.n.flush();
            this.I = false;
        }
        if (!this.F || this.k == null) {
            return;
        }
        this.G = 1;
    }

    public long C() {
        return 0L;
    }

    @Override // com.opos.exoplayer.core.r
    public final int a(Format format) throws ExoPlaybackException {
        try {
            return a(this.c, this.d, format);
        } catch (d.a e) {
            String strA = y.a(e);
            ExoPlaybackException exoPlaybackExceptionA = ExoPlaybackException.a(e, r());
            exoPlaybackExceptionA.a(strA);
            throw exoPlaybackExceptionA;
        }
    }

    public abstract int a(c cVar, com.opos.exoplayer.core.drm.b<e> bVar, Format format);

    public abstract void a(com.opos.exoplayer.core.b.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    public abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    public final MediaFormat c(Format format) {
        MediaFormat mediaFormatB = format.b();
        if (y.f8407a >= 23) {
            a(mediaFormatB);
        }
        return mediaFormatB;
    }

    @Override // com.opos.exoplayer.core.a, com.opos.exoplayer.core.r
    public final int m() {
        return 8;
    }

    @Override // com.opos.exoplayer.core.a
    public void p() {
        this.k = null;
        try {
            A();
            try {
                DrmSession<e> drmSession = this.l;
                if (drmSession != null) {
                    this.d.a(drmSession);
                }
                try {
                    DrmSession<e> drmSession2 = this.m;
                    if (drmSession2 != null && drmSession2 != this.l) {
                        this.d.a(drmSession2);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    DrmSession<e> drmSession3 = this.m;
                    if (drmSession3 != null && drmSession3 != this.l) {
                        this.d.a(drmSession3);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.l != null) {
                    this.d.a(this.l);
                }
                try {
                    DrmSession<e> drmSession4 = this.m;
                    if (drmSession4 != null && drmSession4 != this.l) {
                        this.d.a(drmSession4);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    DrmSession<e> drmSession5 = this.m;
                    if (drmSession5 != null && drmSession5 != this.l) {
                        this.d.a(drmSession5);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.opos.exoplayer.core.q
    public boolean t() {
        return (this.k == null || this.M || (!s() && !F() && (this.A == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.A))) ? false : true;
    }

    @Override // com.opos.exoplayer.core.q
    public boolean u() {
        return this.L;
    }

    public final void x() {
        Format format;
        MediaCrypto mediaCryptoA;
        boolean zA;
        if (this.n != null || (format = this.k) == null) {
            return;
        }
        DrmSession<e> drmSession = this.m;
        this.l = drmSession;
        String str = format.f;
        if (drmSession == null) {
            mediaCryptoA = null;
            zA = false;
        } else {
            e eVar = (e) drmSession.g();
            if (eVar == null) {
                if (this.l.f() == null) {
                    return;
                }
                mediaCryptoA = null;
                zA = false;
            } else {
                mediaCryptoA = eVar.a();
                zA = eVar.a(str);
            }
        }
        if (this.o == null) {
            try {
                com.opos.exoplayer.core.b.a aVarA = a(this.c, this.k, zA);
                this.o = aVarA;
                if (aVarA == null && zA) {
                    com.opos.exoplayer.core.b.a aVarA2 = a(this.c, this.k, false);
                    this.o = aVarA2;
                    if (aVarA2 != null) {
                        com.opos.cmn.an.f.a.c("MediaCodecRenderer", "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.o.f8111a + ".");
                    }
                }
            } catch (d.a e) {
                a(new a(this.k, e, zA, -49998));
            }
            if (this.o == null) {
                a(new a(this.k, (Throwable) null, zA, -49999));
            }
        }
        if (a(this.o)) {
            String str2 = this.o.f8111a;
            this.p = b(str2);
            this.q = a(str2, this.k);
            this.r = a(str2);
            this.s = c(str2);
            this.t = d(str2);
            this.u = e(str2);
            this.v = b(str2, this.k);
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                x.a("createCodec:" + str2);
                this.n = MediaCodec.createByCodecName(str2);
                x.a();
                x.a("configureCodec");
                a(this.o, this.n, this.k, mediaCryptoA);
                x.a();
                x.a("startCodec");
                this.n.start();
                x.a();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                a(str2, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
                D();
            } catch (Exception e2) {
                a(new a(this.k, e2, zA, str2));
            }
            this.A = a_() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
            G();
            H();
            this.N = true;
            this.f8112a.f8134a++;
        }
    }

    public final MediaCodec y() {
        return this.n;
    }

    public final com.opos.exoplayer.core.b.a z() {
        return this.o;
    }

    private static MediaCodec.CryptoInfo a(DecoderInputBuffer decoderInputBuffer, int i) {
        MediaCodec.CryptoInfo cryptoInfoA = decoderInputBuffer.f8130a.a();
        if (i == 0) {
            return cryptoInfoA;
        }
        if (cryptoInfoA.numBytesOfClearData == null) {
            cryptoInfoA.numBytesOfClearData = new int[1];
        }
        int[] iArr = cryptoInfoA.numBytesOfClearData;
        iArr[0] = iArr[0] + i;
        return cryptoInfoA;
    }

    private ByteBuffer b(int i) {
        return y.f8407a >= 21 ? this.n.getInputBuffer(i) : this.y[i];
    }

    private ByteBuffer c(int i) {
        return y.f8407a >= 21 ? this.n.getOutputBuffer(i) : this.z[i];
    }

    private static boolean d(String str) {
        int i = y.f8407a;
        return (i <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (i <= 19 && "hb2000".equals(y.b) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
    }

    public com.opos.exoplayer.core.b.a a(c cVar, Format format, boolean z) {
        return cVar.a(format.f, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Format format) {
        MediaCodec mediaCodec;
        Format format2 = this.k;
        this.k = format;
        boolean z = true;
        if (!y.a(format.i, format2 == null ? null : format2.i)) {
            if (this.k.i != null) {
                com.opos.exoplayer.core.drm.b<e> bVar = this.d;
                if (bVar == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("Media requires a DrmSessionManager");
                    String strA = y.a(illegalStateException);
                    ExoPlaybackException exoPlaybackExceptionA = ExoPlaybackException.a(illegalStateException, r());
                    exoPlaybackExceptionA.a(strA);
                    throw exoPlaybackExceptionA;
                }
                DrmSession drmSessionA = bVar.a(Looper.myLooper(), this.k.i);
                this.m = drmSessionA;
                if (drmSessionA == this.l) {
                    this.d.a(drmSessionA);
                }
            } else {
                this.m = null;
            }
        }
        if (this.m != this.l || (mediaCodec = this.n) == null || !a(mediaCodec, this.o.b, format2, this.k)) {
            if (this.I) {
                this.H = 1;
                return;
            } else {
                A();
                x();
                return;
            }
        }
        this.F = true;
        this.G = 1;
        int i = this.p;
        if (i != 2) {
            if (i == 1) {
                Format format3 = this.k;
                if (format3.j != format2.j || format3.k != format2.k) {
                    z = false;
                }
            }
        }
        this.w = z;
    }

    public void c(long j) {
    }

    private boolean b(long j, long j2) {
        boolean zA;
        int iDequeueOutputBuffer;
        if (!F()) {
            if (!this.u || !this.J) {
                iDequeueOutputBuffer = this.n.dequeueOutputBuffer(this.j, C());
            } else {
                try {
                    iDequeueOutputBuffer = this.n.dequeueOutputBuffer(this.j, C());
                } catch (IllegalStateException unused) {
                    K();
                    if (this.L) {
                        A();
                    }
                    return false;
                }
            }
            if (iDequeueOutputBuffer < 0) {
                if (iDequeueOutputBuffer == -2) {
                    I();
                    return true;
                }
                if (iDequeueOutputBuffer == -3) {
                    J();
                    return true;
                }
                if (this.s && (this.K || this.H == 2)) {
                    K();
                }
                return false;
            }
            if (this.x) {
                this.x = false;
                this.n.releaseOutputBuffer(iDequeueOutputBuffer, false);
                return true;
            }
            if ((this.j.flags & 4) != 0) {
                K();
                return false;
            }
            this.C = iDequeueOutputBuffer;
            ByteBuffer byteBufferC = c(iDequeueOutputBuffer);
            this.D = byteBufferC;
            if (byteBufferC != null) {
                byteBufferC.position(this.j.offset);
                ByteBuffer byteBuffer = this.D;
                MediaCodec.BufferInfo bufferInfo = this.j;
                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            }
            this.E = d(this.j.presentationTimeUs);
        }
        if (!this.u || !this.J) {
            MediaCodec mediaCodec = this.n;
            ByteBuffer byteBuffer2 = this.D;
            int i = this.C;
            MediaCodec.BufferInfo bufferInfo2 = this.j;
            zA = a(j, j2, mediaCodec, byteBuffer2, i, bufferInfo2.flags, bufferInfo2.presentationTimeUs, this.E);
        } else {
            try {
                MediaCodec mediaCodec2 = this.n;
                ByteBuffer byteBuffer3 = this.D;
                int i2 = this.C;
                MediaCodec.BufferInfo bufferInfo3 = this.j;
                zA = a(j, j2, mediaCodec2, byteBuffer3, i2, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.E);
            } catch (IllegalStateException unused2) {
                K();
                if (this.L) {
                    A();
                }
                return false;
            }
        }
        if (!zA) {
            return false;
        }
        c(this.j.presentationTimeUs);
        H();
        return true;
    }

    private static boolean c(String str) {
        return y.f8407a <= 17 && ("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str));
    }

    @Override // com.opos.exoplayer.core.q
    public void a(long j, long j2) {
        if (this.L) {
            w();
            return;
        }
        if (this.k == null) {
            this.g.a();
            int iA = a(this.h, this.g, true);
            if (iA != -5) {
                if (iA == -4) {
                    com.opos.exoplayer.core.util.a.b(this.g.c());
                    this.K = true;
                    K();
                    return;
                }
                return;
            }
            b(this.h.f8252a);
        }
        x();
        if (this.n != null) {
            x.a("drainAndFeed");
            while (b(j, j2)) {
            }
            while (v()) {
            }
            x.a();
        } else {
            this.f8112a.d += b(j);
            this.g.a();
            int iA2 = a(this.h, this.g, false);
            if (iA2 == -5) {
                b(this.h.f8252a);
            } else if (iA2 == -4) {
                com.opos.exoplayer.core.util.a.b(this.g.c());
                this.K = true;
                K();
            }
        }
        this.f8112a.a();
    }

    private static boolean b(String str, Format format) {
        return y.f8407a <= 18 && format.r == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    @Override // com.opos.exoplayer.core.a
    public void a(long j, boolean z) {
        this.K = false;
        this.L = false;
        if (this.n != null) {
            B();
        }
    }

    private boolean b(boolean z) throws ExoPlaybackException {
        DrmSession<e> drmSession = this.l;
        if (drmSession == null || (!z && this.e)) {
            return false;
        }
        int iE = drmSession.e();
        if (iE != 1) {
            return iE != 4;
        }
        String strA = y.a(this.l.f());
        ExoPlaybackException exoPlaybackExceptionA = ExoPlaybackException.a(this.l.f(), r());
        exoPlaybackExceptionA.a(strA);
        throw exoPlaybackExceptionA;
    }

    public void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    @TargetApi(23)
    private static void a(MediaFormat mediaFormat) {
        mediaFormat.setInteger("priority", 0);
    }

    private void a(a aVar) throws ExoPlaybackException {
        String strA = y.a(aVar);
        ExoPlaybackException exoPlaybackExceptionA = ExoPlaybackException.a(aVar, r());
        exoPlaybackExceptionA.a(strA);
        throw exoPlaybackExceptionA;
    }

    public void a(DecoderInputBuffer decoderInputBuffer) {
    }

    public void a(String str, long j, long j2) {
    }

    @Override // com.opos.exoplayer.core.a
    public void a(boolean z) {
        this.f8112a = new com.opos.exoplayer.core.decoder.d();
    }

    public boolean a(MediaCodec mediaCodec, boolean z, Format format, Format format2) {
        return false;
    }

    public boolean a(com.opos.exoplayer.core.b.a aVar) {
        return true;
    }

    private static boolean a(String str) {
        int i = y.f8407a;
        return i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i == 19 && y.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private static boolean a(String str, Format format) {
        return y.f8407a < 21 && format.h.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    @Override // com.opos.exoplayer.core.a
    public void n() {
    }

    @Override // com.opos.exoplayer.core.a
    public void o() {
    }

    public void w() {
    }
}
