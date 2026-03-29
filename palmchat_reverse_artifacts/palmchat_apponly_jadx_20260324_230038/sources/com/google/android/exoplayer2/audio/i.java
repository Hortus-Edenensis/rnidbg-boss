package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.d;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.c;
import com.google.android.exoplayer2.u;
import com.google.android.exoplayer2.z;
import com.google.common.collect.ImmutableList;
import com.oplus.tblplayer.misc.IMediaFormat;
import defpackage.bn;
import defpackage.f12;
import defpackage.fp3;
import defpackage.g86;
import defpackage.ow0;
import defpackage.pj;
import defpackage.qv4;
import defpackage.vg3;
import defpackage.vh;
import defpackage.xe3;
import defpackage.y53;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class i extends MediaCodecRenderer implements xe3 {
    public final Context L0;
    public final d.a M0;
    public final AudioSink N0;
    public int O0;
    public boolean P0;

    @Nullable
    public com.google.android.exoplayer2.m Q0;

    @Nullable
    public com.google.android.exoplayer2.m R0;
    public long S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;
    public boolean W0;

    @Nullable
    public z.a X0;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(23)
    public static final class b {
        @DoNotInline
        public static void a(AudioSink audioSink, @Nullable Object obj) {
            audioSink.setPreferredDevice(pj.a(obj));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c implements AudioSink.a {
        public c() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onAudioCapabilitiesChanged() {
            i.this.s();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onAudioSinkError(Exception exc) {
            y53.d("MediaCodecAudioRenderer", "Audio sink error", exc);
            i.this.M0.l(exc);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onOffloadBufferEmptying() {
            if (i.this.X0 != null) {
                i.this.X0.onWakeup();
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onOffloadBufferFull() {
            if (i.this.X0 != null) {
                i.this.X0.onSleep();
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onPositionAdvancing(long j) {
            i.this.M0.B(j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onPositionDiscontinuity() {
            i.this.k1();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onSkipSilenceEnabledChanged(boolean z) {
            i.this.M0.C(z);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onUnderrun(int i, long j, long j2) {
            i.this.M0.D(i, j, j2);
        }
    }

    public i(Context context, c.b bVar, com.google.android.exoplayer2.mediacodec.e eVar, boolean z, @Nullable Handler handler, @Nullable d dVar, AudioSink audioSink) {
        super(1, bVar, eVar, z, 44100.0f);
        this.L0 = context.getApplicationContext();
        this.N0 = audioSink;
        this.M0 = new d.a(handler, dVar);
        audioSink.e(new c());
    }

    public static boolean e1(String str) {
        if (g86.f17680a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(g86.c)) {
            String str2 = g86.b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    public static boolean f1() {
        if (g86.f17680a == 23) {
            String str = g86.d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static List<com.google.android.exoplayer2.mediacodec.d> i1(com.google.android.exoplayer2.mediacodec.e eVar, com.google.android.exoplayer2.m mVar, boolean z, AudioSink audioSink) throws MediaCodecUtil.DecoderQueryException {
        com.google.android.exoplayer2.mediacodec.d dVarX;
        return mVar.l == null ? ImmutableList.of() : (!audioSink.a(mVar) || (dVarX = MediaCodecUtil.x()) == null) ? MediaCodecUtil.v(eVar, mVar, z, false) : ImmutableList.of(dVarX);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void A0(DecoderInputBuffer decoderInputBuffer) {
        if (!this.T0 || decoderInputBuffer.f()) {
            return;
        }
        if (Math.abs(decoderInputBuffer.e - this.S0) > 500000) {
            this.S0 = decoderInputBuffer.e;
        }
        this.T0 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public ow0 C(com.google.android.exoplayer2.mediacodec.d dVar, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.m mVar2) {
        ow0 ow0VarF = dVar.f(mVar, mVar2);
        int i = ow0VarF.e;
        if (l0(mVar2)) {
            i |= 32768;
        }
        if (g1(dVar, mVar2) > this.O0) {
            i |= 64;
        }
        int i2 = i;
        return new ow0(dVar.f5902a, mVar, mVar2, i2 != 0 ? 0 : ow0VarF.d, i2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean D0(long j, long j2, @Nullable com.google.android.exoplayer2.mediacodec.c cVar, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, com.google.android.exoplayer2.m mVar) throws ExoPlaybackException {
        vh.e(byteBuffer);
        if (this.R0 != null && (i2 & 2) != 0) {
            ((com.google.android.exoplayer2.mediacodec.c) vh.e(cVar)).releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            if (cVar != null) {
                cVar.releaseOutputBuffer(i, false);
            }
            this.G0.f += i3;
            this.N0.handleDiscontinuity();
            return true;
        }
        try {
            if (!this.N0.handleBuffer(byteBuffer, j3, i3)) {
                return false;
            }
            if (cVar != null) {
                cVar.releaseOutputBuffer(i, false);
            }
            this.G0.e += i3;
            return true;
        } catch (AudioSink.InitializationException e) {
            throw h(e, this.Q0, e.isRecoverable, 5001);
        } catch (AudioSink.WriteException e2) {
            throw h(e2, mVar, e2.isRecoverable, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void I0() throws ExoPlaybackException {
        try {
            this.N0.playToEndOfStream();
        } catch (AudioSink.WriteException e) {
            throw h(e, e.format, e.isRecoverable, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean V0(com.google.android.exoplayer2.m mVar) {
        return this.N0.a(mVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int W0(com.google.android.exoplayer2.mediacodec.e eVar, com.google.android.exoplayer2.m mVar) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        if (!fp3.o(mVar.l)) {
            return qv4.a(0);
        }
        int i = g86.f17680a >= 21 ? 32 : 0;
        boolean z2 = true;
        boolean z3 = mVar.H != 0;
        boolean zX0 = MediaCodecRenderer.X0(mVar);
        int i2 = 8;
        if (zX0 && this.N0.a(mVar) && (!z3 || MediaCodecUtil.x() != null)) {
            return qv4.b(4, 8, i);
        }
        if ("audio/raw".equals(mVar.l) && !this.N0.a(mVar)) {
            return qv4.a(1);
        }
        if (!this.N0.a(g86.e0(2, mVar.y, mVar.z))) {
            return qv4.a(1);
        }
        List<com.google.android.exoplayer2.mediacodec.d> listI1 = i1(eVar, mVar, false, this.N0);
        if (listI1.isEmpty()) {
            return qv4.a(1);
        }
        if (!zX0) {
            return qv4.a(2);
        }
        com.google.android.exoplayer2.mediacodec.d dVar = listI1.get(0);
        boolean zO = dVar.o(mVar);
        if (zO) {
            z2 = zO;
            z = true;
        } else {
            for (int i3 = 1; i3 < listI1.size(); i3++) {
                com.google.android.exoplayer2.mediacodec.d dVar2 = listI1.get(i3);
                if (dVar2.o(mVar)) {
                    dVar = dVar2;
                    z = false;
                    break;
                }
            }
            z2 = zO;
            z = true;
        }
        int i4 = z2 ? 4 : 3;
        if (z2 && dVar.r(mVar)) {
            i2 = 16;
        }
        return qv4.c(i4, i2, i, dVar.h ? 64 : 0, z ? 128 : 0);
    }

    @Override // defpackage.xe3
    public void b(u uVar) {
        this.N0.b(uVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float b0(float f, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.m[] mVarArr) {
        int iMax = -1;
        for (com.google.android.exoplayer2.m mVar2 : mVarArr) {
            int i = mVar2.z;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return f * iMax;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<com.google.android.exoplayer2.mediacodec.d> d0(com.google.android.exoplayer2.mediacodec.e eVar, com.google.android.exoplayer2.m mVar, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.w(i1(eVar, mVar, z, this.N0), mVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public c.a e0(com.google.android.exoplayer2.mediacodec.d dVar, com.google.android.exoplayer2.m mVar, @Nullable MediaCrypto mediaCrypto, float f) {
        this.O0 = h1(dVar, mVar, m());
        this.P0 = e1(dVar.f5902a);
        MediaFormat mediaFormatJ1 = j1(mVar, dVar.c, this.O0, f);
        this.R0 = "audio/raw".equals(dVar.b) && !"audio/raw".equals(mVar.l) ? mVar : null;
        return c.a.a(dVar, mediaFormatJ1, mVar, mediaCrypto);
    }

    public final int g1(com.google.android.exoplayer2.mediacodec.d dVar, com.google.android.exoplayer2.m mVar) {
        int i;
        if (!"OMX.google.raw.decoder".equals(dVar.f5902a) || (i = g86.f17680a) >= 24 || (i == 23 && g86.C0(this.L0))) {
            return mVar.m;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.z, com.google.android.exoplayer2.a0
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // defpackage.xe3
    public u getPlaybackParameters() {
        return this.N0.getPlaybackParameters();
    }

    @Override // defpackage.xe3
    public long getPositionUs() {
        if (getState() == 2) {
            l1();
        }
        return this.S0;
    }

    public int h1(com.google.android.exoplayer2.mediacodec.d dVar, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.m[] mVarArr) {
        int iG1 = g1(dVar, mVar);
        if (mVarArr.length == 1) {
            return iG1;
        }
        for (com.google.android.exoplayer2.m mVar2 : mVarArr) {
            if (dVar.f(mVar, mVar2).d != 0) {
                iG1 = Math.max(iG1, g1(dVar, mVar2));
            }
        }
        return iG1;
    }

    @Override // com.google.android.exoplayer2.e, com.google.android.exoplayer2.w.b
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.N0.setVolume(((Float) obj).floatValue());
        }
        if (i == 3) {
            this.N0.c((com.google.android.exoplayer2.audio.a) obj);
            return;
        }
        if (i == 6) {
            this.N0.d((bn) obj);
            return;
        }
        switch (i) {
            case 9:
                this.N0.setSkipSilenceEnabled(((Boolean) obj).booleanValue());
                break;
            case 10:
                this.N0.setAudioSessionId(((Integer) obj).intValue());
                break;
            case 11:
                this.X0 = (z.a) obj;
                break;
            case 12:
                if (g86.f17680a >= 23) {
                    b.a(this.N0, obj);
                }
                break;
            default:
                super.handleMessage(i, obj);
                break;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.z
    public boolean isEnded() {
        return super.isEnded() && this.N0.isEnded();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.z
    public boolean isReady() {
        return this.N0.hasPendingData() || super.isReady();
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat j1(com.google.android.exoplayer2.m mVar, String str, int i, float f) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, str);
        mediaFormat.setInteger("channel-count", mVar.y);
        mediaFormat.setInteger("sample-rate", mVar.z);
        vg3.e(mediaFormat, mVar.n);
        vg3.d(mediaFormat, IMediaFormat.KEY_MAX_INPUT_SIZE, i);
        int i2 = g86.f17680a;
        if (i2 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f && !f1()) {
                mediaFormat.setFloat(IMediaFormat.KEY_OPERATING_RATE, f);
            }
        }
        if (i2 <= 28 && "audio/ac4".equals(mVar.l)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i2 >= 24 && this.N0.f(g86.e0(4, mVar.y, mVar.z)) == 2) {
            mediaFormat.setInteger(IMediaFormat.KEY_PCM_ENCODING, 4);
        }
        if (i2 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }

    @CallSuper
    public void k1() {
        this.U0 = true;
    }

    public final void l1() {
        long currentPositionUs = this.N0.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.U0) {
                currentPositionUs = Math.max(this.S0, currentPositionUs);
            }
            this.S0 = currentPositionUs;
            this.U0 = false;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void o() {
        this.V0 = true;
        this.Q0 = null;
        try {
            this.N0.flush();
            try {
                super.o();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.o();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void p(boolean z, boolean z2) throws ExoPlaybackException {
        super.p(z, z2);
        this.M0.p(this.G0);
        if (i().f21081a) {
            this.N0.enableTunnelingV21();
        } else {
            this.N0.disableTunneling();
        }
        this.N0.g(l());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void q(long j, boolean z) throws ExoPlaybackException {
        super.q(j, z);
        if (this.W0) {
            this.N0.experimentalFlushWithoutAudioTrackRelease();
        } else {
            this.N0.flush();
        }
        this.S0 = j;
        this.T0 = true;
        this.U0 = true;
    }

    @Override // com.google.android.exoplayer2.e
    public void r() {
        this.N0.release();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void s0(Exception exc) {
        y53.d("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.M0.k(exc);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void t() {
        try {
            super.t();
        } finally {
            if (this.V0) {
                this.V0 = false;
                this.N0.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void t0(String str, c.a aVar, long j, long j2) {
        this.M0.m(str, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void u() {
        super.u();
        this.N0.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void u0(String str) {
        this.M0.n(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void v() {
        l1();
        this.N0.pause();
        super.v();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public ow0 v0(f12 f12Var) throws ExoPlaybackException {
        this.Q0 = (com.google.android.exoplayer2.m) vh.e(f12Var.b);
        ow0 ow0VarV0 = super.v0(f12Var);
        this.M0.q(this.Q0, ow0VarV0);
        return ow0VarV0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void w0(com.google.android.exoplayer2.m mVar, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
        int i;
        com.google.android.exoplayer2.m mVar2 = this.R0;
        int[] iArr = null;
        if (mVar2 != null) {
            mVar = mVar2;
        } else if (Y() != null) {
            com.google.android.exoplayer2.m mVarG = new m.b().g0("audio/raw").a0("audio/raw".equals(mVar.l) ? mVar.A : (g86.f17680a < 24 || !mediaFormat.containsKey(IMediaFormat.KEY_PCM_ENCODING)) ? mediaFormat.containsKey("v-bits-per-sample") ? g86.d0(mediaFormat.getInteger("v-bits-per-sample")) : 2 : mediaFormat.getInteger(IMediaFormat.KEY_PCM_ENCODING)).P(mVar.B).Q(mVar.C).J(mediaFormat.getInteger("channel-count")).h0(mediaFormat.getInteger("sample-rate")).G();
            if (this.P0 && mVarG.y == 6 && (i = mVar.y) < 6) {
                iArr = new int[i];
                for (int i2 = 0; i2 < mVar.y; i2++) {
                    iArr[i2] = i2;
                }
            }
            mVar = mVarG;
        }
        try {
            this.N0.h(mVar, 0, iArr);
        } catch (AudioSink.ConfigurationException e) {
            throw g(e, e.format, 5001);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void x0(long j) {
        this.N0.setOutputStreamOffsetUs(j);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void z0() {
        super.z0();
        this.N0.handleDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.e, com.google.android.exoplayer2.z
    @Nullable
    public xe3 getMediaClock() {
        return this;
    }
}
