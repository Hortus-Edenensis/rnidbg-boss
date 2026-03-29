package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.c;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.umeng.analytics.pro.dn;
import defpackage.bk4;
import defpackage.ch1;
import defpackage.dy5;
import defpackage.f12;
import defpackage.g86;
import defpackage.h64;
import defpackage.hr0;
import defpackage.hz5;
import defpackage.i32;
import defpackage.is;
import defpackage.lw0;
import defpackage.ot3;
import defpackage.ow0;
import defpackage.vh;
import defpackage.xv;
import defpackage.y53;
import defpackage.zv;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class MediaCodecRenderer extends com.google.android.exoplayer2.e {
    public static final byte[] K0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, dn.k, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    public final h64 A;
    public long A0;

    @Nullable
    public m B;
    public boolean B0;

    @Nullable
    public m C;
    public boolean C0;
    public boolean D0;

    @Nullable
    public DrmSession E;
    public boolean E0;

    @Nullable
    public DrmSession F;

    @Nullable
    public ExoPlaybackException F0;

    @Nullable
    public MediaCrypto G;
    public lw0 G0;
    public boolean H;
    public b H0;
    public long I;
    public long I0;
    public float J;
    public boolean J0;
    public float K;

    @Nullable
    public c L;

    @Nullable
    public m M;

    @Nullable
    public MediaFormat N;
    public boolean O;
    public float P;

    @Nullable
    public ArrayDeque<d> Q;

    @Nullable
    public DecoderInitializationException R;

    @Nullable
    public d S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public boolean e0;
    public boolean f0;
    public boolean g0;
    public boolean h0;

    @Nullable
    public xv i0;
    public long j0;
    public int k0;
    public int l0;

    @Nullable
    public ByteBuffer m0;
    public boolean n0;
    public boolean o0;
    public final c.b p;
    public boolean p0;
    public final e q;
    public boolean q0;
    public final boolean r;
    public boolean r0;
    public final float s;
    public boolean s0;
    public final DecoderInputBuffer t;
    public int t0;
    public final DecoderInputBuffer u;
    public int u0;
    public final DecoderInputBuffer v;
    public int v0;
    public final is w;
    public boolean w0;
    public final ArrayList<Long> x;
    public boolean x0;
    public final MediaCodec.BufferInfo y;
    public boolean y0;
    public final ArrayDeque<b> z;
    public long z0;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(31)
    public static final class a {
        @DoNotInline
        public static void a(c.a aVar, bk4 bk4Var) {
            LogSessionId logSessionIdA = bk4Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            aVar.b.setString("log-session-id", logSessionIdA.getStringId());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {
        public static final b e = new b(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f5894a;
        public final long b;
        public final long c;
        public final dy5<m> d = new dy5<>();

        public b(long j, long j2, long j3) {
            this.f5894a = j;
            this.b = j2;
            this.c = j3;
        }
    }

    public MediaCodecRenderer(int i, c.b bVar, e eVar, boolean z, float f) {
        super(i);
        this.p = bVar;
        this.q = (e) vh.e(eVar);
        this.r = z;
        this.s = f;
        this.t = DecoderInputBuffer.p();
        this.u = new DecoderInputBuffer(0);
        this.v = new DecoderInputBuffer(2);
        is isVar = new is();
        this.w = isVar;
        this.x = new ArrayList<>();
        this.y = new MediaCodec.BufferInfo();
        this.J = 1.0f;
        this.K = 1.0f;
        this.I = -9223372036854775807L;
        this.z = new ArrayDeque<>();
        O0(b.e);
        isVar.m(0);
        isVar.c.order(ByteOrder.nativeOrder());
        this.A = new h64();
        this.P = -1.0f;
        this.T = 0;
        this.t0 = 0;
        this.k0 = -1;
        this.l0 = -1;
        this.j0 = -9223372036854775807L;
        this.z0 = -9223372036854775807L;
        this.A0 = -9223372036854775807L;
        this.I0 = -9223372036854775807L;
        this.u0 = 0;
        this.v0 = 0;
    }

    public static boolean E(String str, m mVar) {
        return g86.f17680a < 21 && mVar.n.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    public static boolean F(String str) {
        if (g86.f17680a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(g86.c)) {
            String str2 = g86.b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    public static boolean G(String str) {
        int i = g86.f17680a;
        if (i > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i <= 19) {
                String str2 = g86.b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean H(String str) {
        return g86.f17680a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    public static boolean I(d dVar) {
        String str = dVar.f5902a;
        int i = g86.f17680a;
        return (i <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str) || "OMX.bcm.vdec.avc.tunnel".equals(str) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str) || "OMX.bcm.vdec.hevc.tunnel".equals(str) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str))) || ("Amazon".equals(g86.c) && "AFTS".equals(g86.d) && dVar.g));
    }

    public static boolean J(String str) {
        int i = g86.f17680a;
        return i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i == 19 && g86.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    public static boolean K(String str, m mVar) {
        return g86.f17680a <= 18 && mVar.y == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    public static boolean L(String str) {
        return g86.f17680a == 29 && "c2.android.aac.decoder".equals(str);
    }

    public static boolean X0(m mVar) {
        int i = mVar.H;
        return i == 0 || i == 2;
    }

    public static boolean n0(IllegalStateException illegalStateException) {
        if (g86.f17680a >= 21 && o0(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    @RequiresApi(21)
    public static boolean o0(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    @RequiresApi(21)
    public static boolean p0(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    public final void A() throws ExoPlaybackException {
        String str;
        vh.g(!this.B0);
        f12 f12VarJ = j();
        this.v.b();
        do {
            this.v.b();
            int iX = x(f12VarJ, this.v, 0);
            if (iX == -5) {
                v0(f12VarJ);
                return;
            }
            if (iX != -4) {
                if (iX != -3) {
                    throw new IllegalStateException();
                }
                return;
            }
            if (this.v.g()) {
                this.B0 = true;
                return;
            }
            if (this.D0) {
                m mVar = (m) vh.e(this.B);
                this.C = mVar;
                w0(mVar, null);
                this.D0 = false;
            }
            this.v.n();
            m mVar2 = this.B;
            if (mVar2 != null && (str = mVar2.l) != null && str.equals("audio/opus")) {
                this.A.a(this.v, this.B.n);
            }
        } while (this.w.r(this.v));
        this.q0 = true;
    }

    public abstract void A0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException;

    public final boolean B(long j, long j2) throws ExoPlaybackException {
        vh.g(!this.C0);
        if (this.w.w()) {
            is isVar = this.w;
            if (!D0(j, j2, null, isVar.c, this.l0, 0, isVar.v(), this.w.t(), this.w.f(), this.w.g(), this.C)) {
                return false;
            }
            y0(this.w.u());
            this.w.b();
        }
        if (this.B0) {
            this.C0 = true;
            return false;
        }
        if (this.q0) {
            vh.g(this.w.r(this.v));
            this.q0 = false;
        }
        if (this.r0) {
            if (this.w.w()) {
                return true;
            }
            N();
            this.r0 = false;
            q0();
            if (!this.p0) {
                return false;
            }
        }
        A();
        if (this.w.w()) {
            this.w.n();
        }
        return this.w.w() || this.B0 || this.r0;
    }

    public abstract ow0 C(d dVar, m mVar, m mVar2);

    @TargetApi(23)
    public final void C0() throws ExoPlaybackException {
        int i = this.v0;
        if (i == 1) {
            U();
            return;
        }
        if (i == 2) {
            U();
            Z0();
        } else if (i == 3) {
            G0();
        } else {
            this.C0 = true;
            I0();
        }
    }

    public final int D(String str) {
        int i = g86.f17680a;
        if (i <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = g86.d;
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
        String str3 = g86.b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    public abstract boolean D0(long j, long j2, @Nullable c cVar, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, m mVar) throws ExoPlaybackException;

    public final void E0() {
        this.y0 = true;
        MediaFormat outputFormat = this.L.getOutputFormat();
        if (this.T != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.g0 = true;
            return;
        }
        if (this.e0) {
            outputFormat.setInteger("channel-count", 1);
        }
        this.N = outputFormat;
        this.O = true;
    }

    public final boolean F0(int i) throws ExoPlaybackException {
        f12 f12VarJ = j();
        this.t.b();
        int iX = x(f12VarJ, this.t, i | 4);
        if (iX == -5) {
            v0(f12VarJ);
            return true;
        }
        if (iX != -4 || !this.t.g()) {
            return false;
        }
        this.B0 = true;
        C0();
        return false;
    }

    public final void G0() throws ExoPlaybackException {
        H0();
        q0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void H0() {
        try {
            c cVar = this.L;
            if (cVar != null) {
                cVar.release();
                this.G0.b++;
                u0(this.S.f5902a);
            }
            this.L = null;
            try {
                MediaCrypto mediaCrypto = this.G;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.L = null;
            try {
                MediaCrypto mediaCrypto2 = this.G;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    @CallSuper
    public void J0() {
        L0();
        M0();
        this.j0 = -9223372036854775807L;
        this.x0 = false;
        this.w0 = false;
        this.f0 = false;
        this.g0 = false;
        this.n0 = false;
        this.o0 = false;
        this.x.clear();
        this.z0 = -9223372036854775807L;
        this.A0 = -9223372036854775807L;
        this.I0 = -9223372036854775807L;
        xv xvVar = this.i0;
        if (xvVar != null) {
            xvVar.c();
        }
        this.u0 = 0;
        this.v0 = 0;
        this.t0 = this.s0 ? 1 : 0;
    }

    @CallSuper
    public void K0() {
        J0();
        this.F0 = null;
        this.i0 = null;
        this.Q = null;
        this.S = null;
        this.M = null;
        this.N = null;
        this.O = false;
        this.y0 = false;
        this.P = -1.0f;
        this.T = 0;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.e0 = false;
        this.h0 = false;
        this.s0 = false;
        this.t0 = 0;
        this.H = false;
    }

    public final void L0() {
        this.k0 = -1;
        this.u.c = null;
    }

    public MediaCodecDecoderException M(Throwable th, @Nullable d dVar) {
        return new MediaCodecDecoderException(th, dVar);
    }

    public final void M0() {
        this.l0 = -1;
        this.m0 = null;
    }

    public final void N() {
        this.r0 = false;
        this.w.b();
        this.v.b();
        this.q0 = false;
        this.p0 = false;
        this.A.d();
    }

    public final void N0(@Nullable DrmSession drmSession) {
        ch1.a(this.E, drmSession);
        this.E = drmSession;
    }

    public final boolean O() {
        if (this.w0) {
            this.u0 = 1;
            if (this.V || this.X) {
                this.v0 = 3;
                return false;
            }
            this.v0 = 1;
        }
        return true;
    }

    public final void O0(b bVar) {
        this.H0 = bVar;
        long j = bVar.c;
        if (j != -9223372036854775807L) {
            this.J0 = true;
            x0(j);
        }
    }

    public final void P() throws ExoPlaybackException {
        if (!this.w0) {
            G0();
        } else {
            this.u0 = 1;
            this.v0 = 3;
        }
    }

    public final void P0() {
        this.E0 = true;
    }

    @TargetApi(23)
    public final boolean Q() throws ExoPlaybackException {
        if (this.w0) {
            this.u0 = 1;
            if (this.V || this.X) {
                this.v0 = 3;
                return false;
            }
            this.v0 = 2;
        } else {
            Z0();
        }
        return true;
    }

    public final void Q0(ExoPlaybackException exoPlaybackException) {
        this.F0 = exoPlaybackException;
    }

    public final boolean R(long j, long j2) throws ExoPlaybackException {
        boolean z;
        boolean zD0;
        c cVar;
        ByteBuffer byteBuffer;
        int i;
        MediaCodec.BufferInfo bufferInfo;
        int iDequeueOutputBufferIndex;
        if (!i0()) {
            if (this.Y && this.x0) {
                try {
                    iDequeueOutputBufferIndex = this.L.dequeueOutputBufferIndex(this.y);
                } catch (IllegalStateException unused) {
                    C0();
                    if (this.C0) {
                        H0();
                    }
                    return false;
                }
            } else {
                iDequeueOutputBufferIndex = this.L.dequeueOutputBufferIndex(this.y);
            }
            if (iDequeueOutputBufferIndex < 0) {
                if (iDequeueOutputBufferIndex == -2) {
                    E0();
                    return true;
                }
                if (this.h0 && (this.B0 || this.u0 == 2)) {
                    C0();
                }
                return false;
            }
            if (this.g0) {
                this.g0 = false;
                this.L.releaseOutputBuffer(iDequeueOutputBufferIndex, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.y;
            if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                C0();
                return false;
            }
            this.l0 = iDequeueOutputBufferIndex;
            ByteBuffer outputBuffer = this.L.getOutputBuffer(iDequeueOutputBufferIndex);
            this.m0 = outputBuffer;
            if (outputBuffer != null) {
                outputBuffer.position(this.y.offset);
                ByteBuffer byteBuffer2 = this.m0;
                MediaCodec.BufferInfo bufferInfo3 = this.y;
                byteBuffer2.limit(bufferInfo3.offset + bufferInfo3.size);
            }
            if (this.Z) {
                MediaCodec.BufferInfo bufferInfo4 = this.y;
                if (bufferInfo4.presentationTimeUs == 0 && (bufferInfo4.flags & 4) != 0) {
                    long j3 = this.z0;
                    if (j3 != -9223372036854775807L) {
                        bufferInfo4.presentationTimeUs = j3;
                    }
                }
            }
            this.n0 = m0(this.y.presentationTimeUs);
            long j4 = this.A0;
            long j5 = this.y.presentationTimeUs;
            this.o0 = j4 == j5;
            a1(j5);
        }
        if (this.Y && this.x0) {
            try {
                cVar = this.L;
                byteBuffer = this.m0;
                i = this.l0;
                bufferInfo = this.y;
                z = false;
            } catch (IllegalStateException unused2) {
                z = false;
            }
            try {
                zD0 = D0(j, j2, cVar, byteBuffer, i, bufferInfo.flags, 1, bufferInfo.presentationTimeUs, this.n0, this.o0, this.C);
            } catch (IllegalStateException unused3) {
                C0();
                if (this.C0) {
                    H0();
                }
                return z;
            }
        } else {
            z = false;
            c cVar2 = this.L;
            ByteBuffer byteBuffer3 = this.m0;
            int i2 = this.l0;
            MediaCodec.BufferInfo bufferInfo5 = this.y;
            zD0 = D0(j, j2, cVar2, byteBuffer3, i2, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.n0, this.o0, this.C);
        }
        if (zD0) {
            y0(this.y.presentationTimeUs);
            boolean z2 = (this.y.flags & 4) != 0;
            M0();
            if (!z2) {
                return true;
            }
            C0();
        }
        return z;
    }

    public final void R0(@Nullable DrmSession drmSession) {
        ch1.a(this.F, drmSession);
        this.F = drmSession;
    }

    public final boolean S(d dVar, m mVar, @Nullable DrmSession drmSession, @Nullable DrmSession drmSession2) throws ExoPlaybackException {
        hr0 cryptoConfig;
        hr0 cryptoConfig2;
        if (drmSession == drmSession2) {
            return false;
        }
        if (drmSession2 != null && drmSession != null && (cryptoConfig = drmSession2.getCryptoConfig()) != null && (cryptoConfig2 = drmSession.getCryptoConfig()) != null && cryptoConfig.getClass().equals(cryptoConfig2.getClass())) {
            if (!(cryptoConfig instanceof i32)) {
                return false;
            }
            i32 i32Var = (i32) cryptoConfig;
            if (!drmSession2.getSchemeUuid().equals(drmSession.getSchemeUuid()) || g86.f17680a < 23) {
                return true;
            }
            UUID uuid = zv.e;
            if (!uuid.equals(drmSession.getSchemeUuid()) && !uuid.equals(drmSession2.getSchemeUuid())) {
                return !dVar.g && (i32Var.c ? false : drmSession2.requiresSecureDecoder(mVar.l));
            }
        }
        return true;
    }

    public final boolean S0(long j) {
        return this.I == -9223372036854775807L || SystemClock.elapsedRealtime() - j < this.I;
    }

    public final boolean T() throws ExoPlaybackException {
        int i;
        if (this.L == null || (i = this.u0) == 2 || this.B0) {
            return false;
        }
        if (i == 0 && U0()) {
            P();
        }
        if (this.k0 < 0) {
            int iDequeueInputBufferIndex = this.L.dequeueInputBufferIndex();
            this.k0 = iDequeueInputBufferIndex;
            if (iDequeueInputBufferIndex < 0) {
                return false;
            }
            this.u.c = this.L.getInputBuffer(iDequeueInputBufferIndex);
            this.u.b();
        }
        if (this.u0 == 1) {
            if (!this.h0) {
                this.x0 = true;
                this.L.queueInputBuffer(this.k0, 0, 0, 0L, 4);
                L0();
            }
            this.u0 = 2;
            return false;
        }
        if (this.f0) {
            this.f0 = false;
            ByteBuffer byteBuffer = this.u.c;
            byte[] bArr = K0;
            byteBuffer.put(bArr);
            this.L.queueInputBuffer(this.k0, 0, bArr.length, 0L, 0);
            L0();
            this.w0 = true;
            return true;
        }
        if (this.t0 == 1) {
            for (int i2 = 0; i2 < this.M.n.size(); i2++) {
                this.u.c.put(this.M.n.get(i2));
            }
            this.t0 = 2;
        }
        int iPosition = this.u.c.position();
        f12 f12VarJ = j();
        try {
            int iX = x(f12VarJ, this.u, 0);
            if (hasReadStreamToEnd() || this.u.j()) {
                this.A0 = this.z0;
            }
            if (iX == -3) {
                return false;
            }
            if (iX == -5) {
                if (this.t0 == 2) {
                    this.u.b();
                    this.t0 = 1;
                }
                v0(f12VarJ);
                return true;
            }
            if (this.u.g()) {
                if (this.t0 == 2) {
                    this.u.b();
                    this.t0 = 1;
                }
                this.B0 = true;
                if (!this.w0) {
                    C0();
                    return false;
                }
                try {
                    if (!this.h0) {
                        this.x0 = true;
                        this.L.queueInputBuffer(this.k0, 0, 0, 0L, 4);
                        L0();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw g(e, this.B, g86.V(e.getErrorCode()));
                }
            }
            if (!this.w0 && !this.u.i()) {
                this.u.b();
                if (this.t0 == 2) {
                    this.t0 = 1;
                }
                return true;
            }
            boolean zO = this.u.o();
            if (zO) {
                this.u.b.b(iPosition);
            }
            if (this.U && !zO) {
                ot3.b(this.u.c);
                if (this.u.c.position() == 0) {
                    return true;
                }
                this.U = false;
            }
            DecoderInputBuffer decoderInputBuffer = this.u;
            long jD = decoderInputBuffer.e;
            xv xvVar = this.i0;
            if (xvVar != null) {
                jD = xvVar.d(this.B, decoderInputBuffer);
                this.z0 = Math.max(this.z0, this.i0.b(this.B));
            }
            long j = jD;
            if (this.u.f()) {
                this.x.add(Long.valueOf(j));
            }
            if (this.D0) {
                if (this.z.isEmpty()) {
                    this.H0.d.a(j, this.B);
                } else {
                    this.z.peekLast().d.a(j, this.B);
                }
                this.D0 = false;
            }
            this.z0 = Math.max(this.z0, j);
            this.u.n();
            if (this.u.e()) {
                h0(this.u);
            }
            A0(this.u);
            try {
                if (zO) {
                    this.L.a(this.k0, 0, this.u.b, j, 0);
                } else {
                    this.L.queueInputBuffer(this.k0, 0, this.u.c.limit(), j, 0);
                }
                L0();
                this.w0 = true;
                this.t0 = 0;
                this.G0.c++;
                return true;
            } catch (MediaCodec.CryptoException e2) {
                throw g(e2, this.B, g86.V(e2.getErrorCode()));
            }
        } catch (DecoderInputBuffer.InsufficientCapacityException e3) {
            s0(e3);
            F0(0);
            U();
            return true;
        }
    }

    public boolean T0(d dVar) {
        return true;
    }

    public final void U() {
        try {
            this.L.flush();
        } finally {
            J0();
        }
    }

    public boolean U0() {
        return false;
    }

    public final boolean V() throws ExoPlaybackException {
        boolean zW = W();
        if (zW) {
            q0();
        }
        return zW;
    }

    public boolean V0(m mVar) {
        return false;
    }

    public boolean W() {
        if (this.L == null) {
            return false;
        }
        int i = this.v0;
        if (i == 3 || this.V || ((this.W && !this.y0) || (this.X && this.x0))) {
            H0();
            return true;
        }
        if (i == 2) {
            int i2 = g86.f17680a;
            vh.g(i2 >= 23);
            if (i2 >= 23) {
                try {
                    Z0();
                } catch (ExoPlaybackException e) {
                    y53.j("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                    H0();
                    return true;
                }
            }
        }
        U();
        return false;
    }

    public abstract int W0(e eVar, m mVar) throws MediaCodecUtil.DecoderQueryException;

    public final List<d> X(boolean z) throws MediaCodecUtil.DecoderQueryException {
        List<d> listD0 = d0(this.q, this.B, z);
        if (listD0.isEmpty() && z) {
            listD0 = d0(this.q, this.B, false);
            if (!listD0.isEmpty()) {
                y53.i("MediaCodecRenderer", "Drm session requires secure decoder for " + this.B.l + ", but no secure decoder available. Trying to proceed with " + listD0 + ".");
            }
        }
        return listD0;
    }

    @Nullable
    public final c Y() {
        return this.L;
    }

    public final boolean Y0(m mVar) throws ExoPlaybackException {
        if (g86.f17680a >= 23 && this.L != null && this.v0 != 3 && getState() != 0) {
            float fB0 = b0(this.K, mVar, m());
            float f = this.P;
            if (f == fB0) {
                return true;
            }
            if (fB0 == -1.0f) {
                P();
                return false;
            }
            if (f == -1.0f && fB0 <= this.s) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat(IMediaFormat.KEY_OPERATING_RATE, fB0);
            this.L.setParameters(bundle);
            this.P = fB0;
        }
        return true;
    }

    @Nullable
    public final d Z() {
        return this.S;
    }

    @RequiresApi(23)
    public final void Z0() throws ExoPlaybackException {
        hr0 cryptoConfig = this.F.getCryptoConfig();
        if (cryptoConfig instanceof i32) {
            try {
                this.G.setMediaDrmSession(((i32) cryptoConfig).b);
            } catch (MediaCryptoException e) {
                throw g(e, this.B, 6006);
            }
        }
        N0(this.F);
        this.u0 = 0;
        this.v0 = 0;
    }

    @Override // com.google.android.exoplayer2.a0
    public final int a(m mVar) throws ExoPlaybackException {
        try {
            return W0(this.q, mVar);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw g(e, mVar, 4002);
        }
    }

    public boolean a0() {
        return false;
    }

    public final void a1(long j) throws ExoPlaybackException {
        boolean z;
        m mVarJ = this.H0.d.j(j);
        if (mVarJ == null && this.J0 && this.N != null) {
            mVarJ = this.H0.d.i();
        }
        if (mVarJ != null) {
            this.C = mVarJ;
            z = true;
        } else {
            z = false;
        }
        if (z || (this.O && this.C != null)) {
            w0(this.C, this.N);
            this.O = false;
            this.J0 = false;
        }
    }

    public abstract float b0(float f, m mVar, m[] mVarArr);

    @Nullable
    public final MediaFormat c0() {
        return this.N;
    }

    public abstract List<d> d0(e eVar, m mVar, boolean z) throws MediaCodecUtil.DecoderQueryException;

    public abstract c.a e0(d dVar, m mVar, @Nullable MediaCrypto mediaCrypto, float f);

    public final long f0() {
        return this.H0.c;
    }

    public float g0() {
        return this.J;
    }

    public final boolean i0() {
        return this.l0 >= 0;
    }

    @Override // com.google.android.exoplayer2.z
    public boolean isEnded() {
        return this.C0;
    }

    @Override // com.google.android.exoplayer2.z
    public boolean isReady() {
        return this.B != null && (n() || i0() || (this.j0 != -9223372036854775807L && SystemClock.elapsedRealtime() < this.j0));
    }

    public final void j0(m mVar) {
        N();
        String str = mVar.l;
        if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
            this.w.x(32);
        } else {
            this.w.x(1);
        }
        this.p0 = true;
    }

    public final void k0(d dVar, @Nullable MediaCrypto mediaCrypto) throws Exception {
        String str = dVar.f5902a;
        int i = g86.f17680a;
        float fB0 = i < 23 ? -1.0f : b0(this.K, this.B, m());
        float f = fB0 > this.s ? fB0 : -1.0f;
        B0(this.B);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        c.a aVarE0 = e0(dVar, this.B, mediaCrypto, f);
        if (i >= 31) {
            a.a(aVarE0, l());
        }
        try {
            hz5.a("createCodec:" + str);
            this.L = this.p.a(aVarE0);
            hz5.c();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            if (!dVar.o(this.B)) {
                y53.i("MediaCodecRenderer", g86.C("Format exceeds selected codec's capabilities [%s, %s]", m.j(this.B), str));
            }
            this.S = dVar;
            this.P = f;
            this.M = this.B;
            this.T = D(str);
            this.U = E(str, this.M);
            this.V = J(str);
            this.W = L(str);
            this.X = G(str);
            this.Y = H(str);
            this.Z = F(str);
            this.e0 = K(str, this.M);
            this.h0 = I(dVar) || a0();
            if (this.L.needsReconfiguration()) {
                this.s0 = true;
                this.t0 = 1;
                this.f0 = this.T != 0;
            }
            if ("c2.android.mp3.decoder".equals(dVar.f5902a)) {
                this.i0 = new xv();
            }
            if (getState() == 2) {
                this.j0 = SystemClock.elapsedRealtime() + 1000;
            }
            this.G0.f19089a++;
            t0(str, aVarE0, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
        } catch (Throwable th) {
            hz5.c();
            throw th;
        }
    }

    public final boolean l0(m mVar) {
        return this.F == null && V0(mVar);
    }

    public final boolean m0(long j) {
        int size = this.x.size();
        for (int i = 0; i < size; i++) {
            if (this.x.get(i).longValue() == j) {
                this.x.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.e
    public void o() {
        this.B = null;
        O0(b.e);
        this.z.clear();
        W();
    }

    @Override // com.google.android.exoplayer2.e
    public void p(boolean z, boolean z2) throws ExoPlaybackException {
        this.G0 = new lw0();
    }

    @Override // com.google.android.exoplayer2.e
    public void q(long j, boolean z) throws ExoPlaybackException {
        this.B0 = false;
        this.C0 = false;
        this.E0 = false;
        if (this.p0) {
            this.w.b();
            this.v.b();
            this.q0 = false;
            this.A.d();
        } else {
            V();
        }
        if (this.H0.d.l() > 0) {
            this.D0 = true;
        }
        this.H0.d.c();
        this.z.clear();
    }

    public final void q0() throws ExoPlaybackException {
        m mVar;
        if (this.L != null || this.p0 || (mVar = this.B) == null) {
            return;
        }
        if (l0(mVar)) {
            j0(this.B);
            return;
        }
        N0(this.F);
        String str = this.B.l;
        DrmSession drmSession = this.E;
        if (drmSession != null) {
            hr0 cryptoConfig = drmSession.getCryptoConfig();
            if (this.G == null) {
                if (cryptoConfig == null) {
                    if (this.E.getError() == null) {
                        return;
                    }
                } else if (cryptoConfig instanceof i32) {
                    i32 i32Var = (i32) cryptoConfig;
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(i32Var.f18096a, i32Var.b);
                        this.G = mediaCrypto;
                        this.H = !i32Var.c && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e) {
                        throw g(e, this.B, 6006);
                    }
                }
            }
            if (i32.d && (cryptoConfig instanceof i32)) {
                int state = this.E.getState();
                if (state == 1) {
                    DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) vh.e(this.E.getError());
                    throw g(drmSessionException, this.B, drmSessionException.errorCode);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            r0(this.G, this.H);
        } catch (DecoderInitializationException e2) {
            throw g(e2, this.B, 4001);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0049 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r0(@Nullable MediaCrypto mediaCrypto, boolean z) throws DecoderInitializationException {
        DecoderInitializationException decoderInitializationException;
        if (this.Q == null) {
            try {
                List<d> listX = X(z);
                ArrayDeque<d> arrayDeque = new ArrayDeque<>();
                this.Q = arrayDeque;
                if (this.r) {
                    arrayDeque.addAll(listX);
                } else if (!listX.isEmpty()) {
                    this.Q.add(listX.get(0));
                }
                this.R = null;
            } catch (MediaCodecUtil.DecoderQueryException e) {
                throw new DecoderInitializationException(this.B, e, z, -49998);
            }
        }
        if (this.Q.isEmpty()) {
            throw new DecoderInitializationException(this.B, (Throwable) null, z, -49999);
        }
        d dVarPeekFirst = this.Q.peekFirst();
        while (this.L == null) {
            d dVarPeekFirst2 = this.Q.peekFirst();
            if (!T0(dVarPeekFirst2)) {
                return;
            }
            try {
                k0(dVarPeekFirst2, mediaCrypto);
            } catch (Exception e2) {
                if (dVarPeekFirst2 != dVarPeekFirst) {
                    throw e2;
                }
                try {
                    y53.i("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                    Thread.sleep(50L);
                    k0(dVarPeekFirst2, mediaCrypto);
                } catch (Exception e3) {
                    y53.j("MediaCodecRenderer", "Failed to initialize decoder: " + dVarPeekFirst2, e3);
                    this.Q.removeFirst();
                    DecoderInitializationException decoderInitializationException2 = new DecoderInitializationException(this.B, e3, z, dVarPeekFirst2);
                    s0(decoderInitializationException2);
                    decoderInitializationException = this.R;
                    if (decoderInitializationException != null) {
                    }
                    if (!this.Q.isEmpty()) {
                    }
                }
                y53.j("MediaCodecRenderer", "Failed to initialize decoder: " + dVarPeekFirst2, e3);
                this.Q.removeFirst();
                DecoderInitializationException decoderInitializationException22 = new DecoderInitializationException(this.B, e3, z, dVarPeekFirst2);
                s0(decoderInitializationException22);
                decoderInitializationException = this.R;
                if (decoderInitializationException != null) {
                    this.R = decoderInitializationException22;
                } else {
                    this.R = decoderInitializationException.copyWithFallbackException(decoderInitializationException22);
                }
                if (!this.Q.isEmpty()) {
                    throw this.R;
                }
            }
        }
        this.Q = null;
    }

    @Override // com.google.android.exoplayer2.z
    public void render(long j, long j2) throws ExoPlaybackException {
        boolean z = false;
        if (this.E0) {
            this.E0 = false;
            C0();
        }
        ExoPlaybackException exoPlaybackException = this.F0;
        if (exoPlaybackException != null) {
            this.F0 = null;
            throw exoPlaybackException;
        }
        try {
            if (this.C0) {
                I0();
                return;
            }
            if (this.B != null || F0(2)) {
                q0();
                if (this.p0) {
                    hz5.a("bypassRender");
                    while (B(j, j2)) {
                    }
                    hz5.c();
                } else if (this.L != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    hz5.a("drainAndFeed");
                    while (R(j, j2) && S0(jElapsedRealtime)) {
                    }
                    while (T() && S0(jElapsedRealtime)) {
                    }
                    hz5.c();
                } else {
                    this.G0.d += z(j);
                    F0(1);
                }
                this.G0.c();
            }
        } catch (IllegalStateException e) {
            if (!n0(e)) {
                throw e;
            }
            s0(e);
            if (g86.f17680a >= 21 && p0(e)) {
                z = true;
            }
            if (z) {
                H0();
            }
            throw h(M(e, Z()), this.B, z, 4003);
        }
    }

    public abstract void s0(Exception exc);

    @Override // com.google.android.exoplayer2.e, com.google.android.exoplayer2.z
    public void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
        this.J = f;
        this.K = f2;
        Y0(this.M);
    }

    @Override // com.google.android.exoplayer2.e, com.google.android.exoplayer2.a0
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    @Override // com.google.android.exoplayer2.e
    public void t() {
        try {
            N();
            H0();
        } finally {
            R0(null);
        }
    }

    public abstract void t0(String str, c.a aVar, long j, long j2);

    public abstract void u0(String str);

    /* JADX WARN: Removed duplicated region for block: B:69:0x00cf  */
    @Nullable
    @CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ow0 v0(f12 f12Var) throws ExoPlaybackException {
        int i;
        boolean z = true;
        this.D0 = true;
        m mVar = (m) vh.e(f12Var.b);
        if (mVar.l == null) {
            throw g(new IllegalArgumentException(), mVar, 4005);
        }
        R0(f12Var.f17409a);
        this.B = mVar;
        if (this.p0) {
            this.r0 = true;
            return null;
        }
        c cVar = this.L;
        if (cVar == null) {
            this.Q = null;
            q0();
            return null;
        }
        d dVar = this.S;
        m mVar2 = this.M;
        if (S(dVar, mVar, this.E, this.F)) {
            P();
            return new ow0(dVar.f5902a, mVar2, mVar, 0, 128);
        }
        boolean z2 = this.F != this.E;
        vh.g(!z2 || g86.f17680a >= 23);
        ow0 ow0VarC = C(dVar, mVar2, mVar);
        int i2 = ow0VarC.d;
        if (i2 != 0) {
            if (i2 == 1) {
                if (Y0(mVar)) {
                    this.M = mVar;
                    if (!z2 ? O() : Q()) {
                    }
                }
                i = 16;
            } else if (i2 == 2) {
                if (Y0(mVar)) {
                    this.s0 = true;
                    this.t0 = 1;
                    int i3 = this.T;
                    if (i3 != 2 && (i3 != 1 || mVar.q != mVar2.q || mVar.r != mVar2.r)) {
                        z = false;
                    }
                    this.f0 = z;
                    this.M = mVar;
                    if (!z2 || Q()) {
                    }
                }
                i = 16;
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException();
                }
                if (Y0(mVar)) {
                    this.M = mVar;
                    if (z2 && !Q()) {
                        i = 2;
                    }
                }
                i = 16;
            }
            return (ow0VarC.d != 0 || (this.L == cVar && this.v0 != 3)) ? ow0VarC : new ow0(dVar.f5902a, mVar2, mVar, 0, i);
        }
        P();
        i = 0;
        if (ow0VarC.d != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        if (r5 >= r1) goto L13;
     */
    @Override // com.google.android.exoplayer2.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(m[] mVarArr, long j, long j2) throws ExoPlaybackException {
        if (this.H0.c == -9223372036854775807L) {
            O0(new b(-9223372036854775807L, j, j2));
            return;
        }
        if (this.z.isEmpty()) {
            long j3 = this.z0;
            if (j3 != -9223372036854775807L) {
                long j4 = this.I0;
                if (j4 != -9223372036854775807L) {
                }
            }
            O0(new b(-9223372036854775807L, j, j2));
            if (this.H0.c != -9223372036854775807L) {
                z0();
                return;
            }
            return;
        }
        this.z.add(new b(this.z0, j, j2));
    }

    public abstract void w0(m mVar, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException;

    @CallSuper
    public void y0(long j) {
        this.I0 = j;
        while (!this.z.isEmpty() && j >= this.z.peek().f5894a) {
            O0(this.z.poll());
            z0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class DecoderInitializationException extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;

        @Nullable
        public final d codecInfo;

        @Nullable
        public final String diagnosticInfo;

        @Nullable
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(m mVar, @Nullable Throwable th, boolean z, int i) {
            this("Decoder init failed: [" + i + "], " + mVar, th, mVar.l, z, null, buildCustomDiagnosticInfo(i), null);
        }

        private static String buildCustomDiagnosticInfo(int i) {
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @CheckResult
        public DecoderInitializationException copyWithFallbackException(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, decoderInitializationException);
        }

        @Nullable
        @RequiresApi(21)
        private static String getDiagnosticInfoV21(@Nullable Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        public DecoderInitializationException(m mVar, @Nullable Throwable th, boolean z, d dVar) {
            this("Decoder init failed: " + dVar.f5902a + ", " + mVar, th, mVar.l, z, dVar, g86.f17680a >= 21 ? getDiagnosticInfoV21(th) : null, null);
        }

        private DecoderInitializationException(String str, @Nullable Throwable th, String str2, boolean z, @Nullable d dVar, @Nullable String str3, @Nullable DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z;
            this.codecInfo = dVar;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }
    }

    public void I0() throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.e
    public void u() {
    }

    @Override // com.google.android.exoplayer2.e
    public void v() {
    }

    public void z0() {
    }

    public void B0(m mVar) throws ExoPlaybackException {
    }

    public void h0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    public void x0(long j) {
    }
}
