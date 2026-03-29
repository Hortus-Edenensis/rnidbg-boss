package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.b;
import com.google.android.exoplayer2.audio.e;
import com.google.android.exoplayer2.audio.h;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.u;
import com.google.common.collect.ImmutableList;
import defpackage.as3;
import defpackage.bk4;
import defpackage.bl0;
import defpackage.bn;
import defpackage.ed0;
import defpackage.fp3;
import defpackage.g86;
import defpackage.h2;
import defpackage.ik;
import defpackage.k21;
import defpackage.mi1;
import defpackage.mj;
import defpackage.ml0;
import defpackage.n2;
import defpackage.o46;
import defpackage.o94;
import defpackage.s31;
import defpackage.vh;
import defpackage.y53;
import defpackage.zl;
import j$.util.Objects;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class DefaultAudioSink implements AudioSink {
    public static boolean h0 = false;
    public static final Object i0 = new Object();

    @Nullable
    @GuardedBy("releaseExecutorLock")
    public static ExecutorService j0;

    @GuardedBy("releaseExecutorLock")
    public static int k0;

    @Nullable
    public i A;
    public i B;
    public u C;
    public boolean D;

    @Nullable
    public ByteBuffer E;
    public int F;
    public long G;
    public long H;
    public long I;
    public long J;
    public int K;
    public boolean L;
    public boolean M;
    public long N;
    public float O;

    @Nullable
    public ByteBuffer P;
    public int Q;

    @Nullable
    public ByteBuffer R;
    public byte[] S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public int Y;
    public bn Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Context f5819a;

    @Nullable
    public d a0;
    public final ik b;
    public boolean b0;
    public final boolean c;
    public long c0;
    public final com.google.android.exoplayer2.audio.g d;
    public long d0;
    public final n e;
    public boolean e0;
    public final ImmutableList<AudioProcessor> f;
    public boolean f0;
    public final ImmutableList<AudioProcessor> g;

    @Nullable
    public Looper g0;
    public final ml0 h;
    public final com.google.android.exoplayer2.audio.e i;
    public final ArrayDeque<i> j;
    public final boolean k;
    public final int l;
    public l m;
    public final j<AudioSink.InitializationException> n;
    public final j<AudioSink.WriteException> o;
    public final e p;

    @Nullable
    public final j.a q;

    @Nullable
    public bk4 r;

    @Nullable
    public AudioSink.a s;

    @Nullable
    public g t;
    public g u;
    public com.google.android.exoplayer2.audio.c v;

    @Nullable
    public AudioTrack w;
    public mj x;
    public com.google.android.exoplayer2.audio.b y;
    public com.google.android.exoplayer2.audio.a z;

    /* JADX INFO: compiled from: SearchBox */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(23)
    public static final class b {
        @DoNotInline
        public static void a(AudioTrack audioTrack, @Nullable d dVar) {
            audioTrack.setPreferredDevice(dVar == null ? null : dVar.f5820a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(31)
    public static final class c {
        @DoNotInline
        public static void a(AudioTrack audioTrack, bk4 bk4Var) {
            LogSessionId logSessionIdA = bk4Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            audioTrack.setLogSessionId(logSessionIdA);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(23)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioDeviceInfo f5820a;

        public d(AudioDeviceInfo audioDeviceInfo) {
            this.f5820a = audioDeviceInfo;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f5821a = new h.a().g();

        int getBufferSizeInBytes(int i, int i2, int i3, int i4, int i5, int i6, double d);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Context f5822a;

        @Nullable
        public ik c;
        public boolean d;
        public boolean e;

        @Nullable
        public j.a h;
        public mj b = mj.c;
        public int f = 0;
        public e g = e.f5821a;

        public f(Context context) {
            this.f5822a = context;
        }

        public DefaultAudioSink g() {
            if (this.c == null) {
                this.c = new h(new AudioProcessor[0]);
            }
            return new DefaultAudioSink(this);
        }

        public f h(boolean z) {
            this.e = z;
            return this;
        }

        public f i(boolean z) {
            this.d = z;
            return this;
        }

        public f j(int i) {
            this.f = i;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.m f5823a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final com.google.android.exoplayer2.audio.c i;
        public final boolean j;

        public g(com.google.android.exoplayer2.m mVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, com.google.android.exoplayer2.audio.c cVar, boolean z) {
            this.f5823a = mVar;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = i7;
            this.i = cVar;
            this.j = z;
        }

        @RequiresApi(21)
        public static AudioAttributes i(com.google.android.exoplayer2.audio.a aVar, boolean z) {
            return z ? j() : aVar.b().f5831a;
        }

        @RequiresApi(21)
        public static AudioAttributes j() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack a(boolean z, com.google.android.exoplayer2.audio.a aVar, int i) throws AudioSink.InitializationException {
            try {
                AudioTrack audioTrackD = d(z, aVar, i);
                int state = audioTrackD.getState();
                if (state == 1) {
                    return audioTrackD;
                }
                try {
                    audioTrackD.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.e, this.f, this.h, this.f5823a, l(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e) {
                throw new AudioSink.InitializationException(0, this.e, this.f, this.h, this.f5823a, l(), e);
            }
        }

        public boolean b(g gVar) {
            return gVar.c == this.c && gVar.g == this.g && gVar.e == this.e && gVar.f == this.f && gVar.d == this.d && gVar.j == this.j;
        }

        public g c(int i) {
            return new g(this.f5823a, this.b, this.c, this.d, this.e, this.f, this.g, i, this.i, this.j);
        }

        public final AudioTrack d(boolean z, com.google.android.exoplayer2.audio.a aVar, int i) {
            int i2 = g86.f17680a;
            return i2 >= 29 ? f(z, aVar, i) : i2 >= 21 ? e(z, aVar, i) : g(aVar, i);
        }

        @RequiresApi(21)
        public final AudioTrack e(boolean z, com.google.android.exoplayer2.audio.a aVar, int i) {
            return new AudioTrack(i(aVar, z), DefaultAudioSink.x(this.e, this.f, this.g), this.h, 1, i);
        }

        @RequiresApi(29)
        public final AudioTrack f(boolean z, com.google.android.exoplayer2.audio.a aVar, int i) {
            return s31.a().setAudioAttributes(i(aVar, z)).setAudioFormat(DefaultAudioSink.x(this.e, this.f, this.g)).setTransferMode(1).setBufferSizeInBytes(this.h).setSessionId(i).setOffloadedPlayback(this.c == 1).build();
        }

        public final AudioTrack g(com.google.android.exoplayer2.audio.a aVar, int i) {
            int iH0 = g86.h0(aVar.c);
            return i == 0 ? new AudioTrack(iH0, this.e, this.f, this.g, this.h, 1) : new AudioTrack(iH0, this.e, this.f, this.g, this.h, 1, i);
        }

        public long h(long j) {
            return g86.T0(j, this.e);
        }

        public long k(long j) {
            return g86.T0(j, this.f5823a.z);
        }

        public boolean l() {
            return this.c == 1;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h implements ik {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioProcessor[] f5824a;
        public final com.google.android.exoplayer2.audio.j b;
        public final com.google.android.exoplayer2.audio.k c;

        public h(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new com.google.android.exoplayer2.audio.j(), new com.google.android.exoplayer2.audio.k());
        }

        @Override // defpackage.ik
        public u a(u uVar) {
            this.c.d(uVar.f5989a);
            this.c.c(uVar.b);
            return uVar;
        }

        @Override // defpackage.ik
        public boolean applySkipSilenceEnabled(boolean z) {
            this.b.q(z);
            return z;
        }

        @Override // defpackage.ik
        public AudioProcessor[] getAudioProcessors() {
            return this.f5824a;
        }

        @Override // defpackage.ik
        public long getMediaDuration(long j) {
            return this.c.b(j);
        }

        @Override // defpackage.ik
        public long getSkippedOutputFrameCount() {
            return this.b.k();
        }

        public h(AudioProcessor[] audioProcessorArr, com.google.android.exoplayer2.audio.j jVar, com.google.android.exoplayer2.audio.k kVar) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.f5824a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.b = jVar;
            this.c = kVar;
            audioProcessorArr2[audioProcessorArr.length] = jVar;
            audioProcessorArr2[audioProcessorArr.length + 1] = kVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u f5825a;
        public final long b;
        public final long c;

        public i(u uVar, long j, long j2) {
            this.f5825a = uVar;
            this.b = j;
            this.c = j2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class j<T extends Exception> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f5826a;

        @Nullable
        public T b;
        public long c;

        public j(long j) {
            this.f5826a = j;
        }

        public void a() {
            this.b = null;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: T extends java.lang.Exception */
        public void b(T t) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.b == null) {
                this.b = t;
                this.c = this.f5826a + jElapsedRealtime;
            }
            if (jElapsedRealtime >= this.c) {
                T t2 = this.b;
                if (t2 != t) {
                    t2.addSuppressed(t);
                }
                T t3 = this.b;
                a();
                throw t3;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class k implements e.a {
        public k() {
        }

        @Override // com.google.android.exoplayer2.audio.e.a
        public void onInvalidLatency(long j) {
            y53.i("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j);
        }

        @Override // com.google.android.exoplayer2.audio.e.a
        public void onPositionAdvancing(long j) {
            if (DefaultAudioSink.this.s != null) {
                DefaultAudioSink.this.s.onPositionAdvancing(j);
            }
        }

        @Override // com.google.android.exoplayer2.audio.e.a
        public void onPositionFramesMismatch(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + DefaultAudioSink.this.B() + ", " + DefaultAudioSink.this.C();
            if (DefaultAudioSink.h0) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            y53.i("DefaultAudioSink", str);
        }

        @Override // com.google.android.exoplayer2.audio.e.a
        public void onSystemTimeUsMismatch(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + DefaultAudioSink.this.B() + ", " + DefaultAudioSink.this.C();
            if (DefaultAudioSink.h0) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            y53.i("DefaultAudioSink", str);
        }

        @Override // com.google.android.exoplayer2.audio.e.a
        public void onUnderrun(int i, long j) {
            if (DefaultAudioSink.this.s != null) {
                DefaultAudioSink.this.s.onUnderrun(i, j, SystemClock.elapsedRealtime() - DefaultAudioSink.this.d0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(29)
    public final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f5828a = new Handler(Looper.myLooper());
        public final AudioTrack.StreamEventCallback b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends AudioTrack.StreamEventCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DefaultAudioSink f5829a;

            public a(DefaultAudioSink defaultAudioSink) {
                this.f5829a = defaultAudioSink;
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i) {
                if (audioTrack.equals(DefaultAudioSink.this.w) && DefaultAudioSink.this.s != null && DefaultAudioSink.this.W) {
                    DefaultAudioSink.this.s.onOffloadBufferEmptying();
                }
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(AudioTrack audioTrack) {
                if (audioTrack.equals(DefaultAudioSink.this.w) && DefaultAudioSink.this.s != null && DefaultAudioSink.this.W) {
                    DefaultAudioSink.this.s.onOffloadBufferEmptying();
                }
            }
        }

        public l() {
            this.b = new a(DefaultAudioSink.this);
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.f5828a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new bl0(handler), this.b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.b);
            this.f5828a.removeCallbacksAndMessages(null);
        }
    }

    public static boolean E(int i2) {
        return (g86.f17680a >= 24 && i2 == -6) || i2 == -32;
    }

    public static boolean G(AudioTrack audioTrack) {
        return g86.f17680a >= 29 && audioTrack.isOffloadedPlayback();
    }

    public static /* synthetic */ void H(AudioTrack audioTrack, ml0 ml0Var) {
        try {
            audioTrack.flush();
            audioTrack.release();
            ml0Var.e();
            synchronized (i0) {
                int i2 = k0 - 1;
                k0 = i2;
                if (i2 == 0) {
                    j0.shutdown();
                    j0 = null;
                }
            }
        } catch (Throwable th) {
            ml0Var.e();
            synchronized (i0) {
                int i3 = k0 - 1;
                k0 = i3;
                if (i3 == 0) {
                    j0.shutdown();
                    j0 = null;
                }
                throw th;
            }
        }
    }

    public static void N(final AudioTrack audioTrack, final ml0 ml0Var) {
        ml0Var.c();
        synchronized (i0) {
            if (j0 == null) {
                j0 = g86.I0("ExoPlayer:AudioTrackReleaseThread");
            }
            k0++;
            j0.execute(new Runnable() { // from class: u21
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultAudioSink.H(audioTrack, ml0Var);
                }
            });
        }
    }

    @RequiresApi(21)
    public static void S(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    public static void T(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    @RequiresApi(21)
    public static int a0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    @RequiresApi(21)
    public static AudioFormat x(int i2, int i3, int i4) {
        return new AudioFormat.Builder().setSampleRate(i2).setChannelMask(i3).setEncoding(i4).build();
    }

    public static int y(int i2, int i3, int i4) {
        int minBufferSize = AudioTrack.getMinBufferSize(i2, i3, i4);
        vh.g(minBufferSize != -2);
        return minBufferSize;
    }

    public static int z(int i2, ByteBuffer byteBuffer) {
        switch (i2) {
            case 5:
            case 6:
            case 18:
                return h2.e(byteBuffer);
            case 7:
            case 8:
                return mi1.e(byteBuffer);
            case 9:
                int iM = as3.m(g86.I(byteBuffer, byteBuffer.position()));
                if (iM != -1) {
                    return iM;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            case 19:
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i2);
            case 14:
                int iB = h2.b(byteBuffer);
                if (iB == -1) {
                    return 0;
                }
                return h2.i(byteBuffer, iB) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return n2.c(byteBuffer);
            case 20:
                return o94.g(byteBuffer);
        }
    }

    @RequiresApi(29)
    @SuppressLint({"InlinedApi"})
    public final int A(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        int i2 = g86.f17680a;
        if (i2 >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return (i2 == 30 && g86.d.startsWith("Pixel")) ? 2 : 1;
        }
        return 0;
    }

    public final long B() {
        g gVar = this.u;
        return gVar.c == 0 ? this.G / ((long) gVar.b) : this.H;
    }

    public final long C() {
        g gVar = this.u;
        return gVar.c == 0 ? this.I / ((long) gVar.d) : this.J;
    }

    public final boolean D() throws AudioSink.InitializationException {
        bk4 bk4Var;
        if (!this.h.d()) {
            return false;
        }
        AudioTrack audioTrackU = u();
        this.w = audioTrackU;
        if (G(audioTrackU)) {
            M(this.w);
            if (this.l != 3) {
                AudioTrack audioTrack = this.w;
                com.google.android.exoplayer2.m mVar = this.u.f5823a;
                audioTrack.setOffloadDelayPadding(mVar.B, mVar.C);
            }
        }
        int i2 = g86.f17680a;
        if (i2 >= 31 && (bk4Var = this.r) != null) {
            c.a(this.w, bk4Var);
        }
        this.Y = this.w.getAudioSessionId();
        com.google.android.exoplayer2.audio.e eVar = this.i;
        AudioTrack audioTrack2 = this.w;
        g gVar = this.u;
        eVar.r(audioTrack2, gVar.c == 2, gVar.g, gVar.d, gVar.h);
        R();
        int i3 = this.Z.f1754a;
        if (i3 != 0) {
            this.w.attachAuxEffect(i3);
            this.w.setAuxEffectSendLevel(this.Z.b);
        }
        d dVar = this.a0;
        if (dVar != null && i2 >= 23) {
            b.a(this.w, dVar);
        }
        this.M = true;
        return true;
    }

    public final boolean F() {
        return this.w != null;
    }

    public final void I() {
        if (this.u.l()) {
            this.e0 = true;
        }
    }

    public void J(mj mjVar) {
        vh.g(this.g0 == Looper.myLooper());
        if (mjVar.equals(w())) {
            return;
        }
        this.x = mjVar;
        AudioSink.a aVar = this.s;
        if (aVar != null) {
            aVar.onAudioCapabilitiesChanged();
        }
    }

    public final void K() {
        if (this.V) {
            return;
        }
        this.V = true;
        this.i.f(C());
        this.w.stop();
        this.F = 0;
    }

    public final void L(long j2) throws Exception {
        ByteBuffer byteBufferD;
        if (!this.v.f()) {
            ByteBuffer byteBuffer = this.P;
            if (byteBuffer == null) {
                byteBuffer = AudioProcessor.f5817a;
            }
            Z(byteBuffer, j2);
            return;
        }
        while (!this.v.e()) {
            do {
                byteBufferD = this.v.d();
                if (byteBufferD.hasRemaining()) {
                    Z(byteBufferD, j2);
                } else {
                    ByteBuffer byteBuffer2 = this.P;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.v.i(this.P);
                    }
                }
            } while (!byteBufferD.hasRemaining());
            return;
        }
    }

    @RequiresApi(29)
    public final void M(AudioTrack audioTrack) {
        if (this.m == null) {
            this.m = new l();
        }
        this.m.a(audioTrack);
    }

    public final void O() {
        this.G = 0L;
        this.H = 0L;
        this.I = 0L;
        this.J = 0L;
        this.f0 = false;
        this.K = 0;
        this.B = new i(this.C, 0L, 0L);
        this.N = 0L;
        this.A = null;
        this.j.clear();
        this.P = null;
        this.Q = 0;
        this.R = null;
        this.V = false;
        this.U = false;
        this.E = null;
        this.F = 0;
        this.e.i();
        U();
    }

    public final void P(u uVar) {
        i iVar = new i(uVar, -9223372036854775807L, -9223372036854775807L);
        if (F()) {
            this.A = iVar;
        } else {
            this.B = iVar;
        }
    }

    @RequiresApi(23)
    public final void Q() {
        if (F()) {
            try {
                this.w.setPlaybackParams(k21.a().allowDefaults().setSpeed(this.C.f5989a).setPitch(this.C.b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e2) {
                y53.j("DefaultAudioSink", "Failed to set playback params", e2);
            }
            u uVar = new u(this.w.getPlaybackParams().getSpeed(), this.w.getPlaybackParams().getPitch());
            this.C = uVar;
            this.i.s(uVar.f5989a);
        }
    }

    public final void R() {
        if (F()) {
            if (g86.f17680a >= 21) {
                S(this.w, this.O);
            } else {
                T(this.w, this.O);
            }
        }
    }

    public final void U() {
        com.google.android.exoplayer2.audio.c cVar = this.u.i;
        this.v = cVar;
        cVar.b();
    }

    public final boolean V() {
        if (!this.b0) {
            g gVar = this.u;
            if (gVar.c == 0 && !W(gVar.f5823a.A)) {
                return true;
            }
        }
        return false;
    }

    public final boolean W(int i2) {
        return this.c && g86.y0(i2);
    }

    public final boolean X() {
        g gVar = this.u;
        return gVar != null && gVar.j && g86.f17680a >= 23;
    }

    public final boolean Y(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.audio.a aVar) {
        int iF;
        int iG;
        int iA;
        if (g86.f17680a < 29 || this.l == 0 || (iF = fp3.f((String) vh.e(mVar.l), mVar.i)) == 0 || (iG = g86.G(mVar.y)) == 0 || (iA = A(x(mVar.z, iG, iF), aVar.b().f5831a)) == 0) {
            return false;
        }
        if (iA == 1) {
            return ((mVar.B != 0 || mVar.C != 0) && (this.l == 1)) ? false : true;
        }
        if (iA == 2) {
            return true;
        }
        throw new IllegalStateException();
    }

    public final void Z(ByteBuffer byteBuffer, long j2) throws Exception {
        int iA0;
        AudioSink.a aVar;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.R;
            if (byteBuffer2 != null) {
                vh.a(byteBuffer2 == byteBuffer);
            } else {
                this.R = byteBuffer;
                if (g86.f17680a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.S;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.S = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.S, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.T = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            if (g86.f17680a < 21) {
                int iB = this.i.b(this.I);
                if (iB > 0) {
                    iA0 = this.w.write(this.S, this.T, Math.min(iRemaining2, iB));
                    if (iA0 > 0) {
                        this.T += iA0;
                        byteBuffer.position(byteBuffer.position() + iA0);
                    }
                } else {
                    iA0 = 0;
                }
            } else if (this.b0) {
                vh.g(j2 != -9223372036854775807L);
                if (j2 == Long.MIN_VALUE) {
                    j2 = this.c0;
                } else {
                    this.c0 = j2;
                }
                iA0 = b0(this.w, byteBuffer, iRemaining2, j2);
            } else {
                iA0 = a0(this.w, byteBuffer, iRemaining2);
            }
            this.d0 = SystemClock.elapsedRealtime();
            if (iA0 < 0) {
                AudioSink.WriteException writeException = new AudioSink.WriteException(iA0, this.u.f5823a, E(iA0) && this.J > 0);
                AudioSink.a aVar2 = this.s;
                if (aVar2 != null) {
                    aVar2.onAudioSinkError(writeException);
                }
                if (writeException.isRecoverable) {
                    this.x = mj.c;
                    throw writeException;
                }
                this.o.b(writeException);
                return;
            }
            this.o.a();
            if (G(this.w)) {
                if (this.J > 0) {
                    this.f0 = false;
                }
                if (this.W && (aVar = this.s) != null && iA0 < iRemaining2 && !this.f0) {
                    aVar.onOffloadBufferFull();
                }
            }
            int i2 = this.u.c;
            if (i2 == 0) {
                this.I += (long) iA0;
            }
            if (iA0 == iRemaining2) {
                if (i2 != 0) {
                    vh.g(byteBuffer == this.P);
                    this.J += ((long) this.K) * ((long) this.Q);
                }
                this.R = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(com.google.android.exoplayer2.m mVar) {
        return f(mVar) != 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void b(u uVar) {
        this.C = new u(g86.p(uVar.f5989a, 0.1f, 8.0f), g86.p(uVar.b, 0.1f, 8.0f));
        if (X()) {
            Q();
        } else {
            P(uVar);
        }
    }

    @RequiresApi(21)
    public final int b0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        if (g86.f17680a >= 26) {
            return audioTrack.write(byteBuffer, i2, 1, j2 * 1000);
        }
        if (this.E == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.E = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.E.putInt(1431633921);
        }
        if (this.F == 0) {
            this.E.putInt(4, i2);
            this.E.putLong(8, j2 * 1000);
            this.E.position(0);
            this.F = i2;
        }
        int iRemaining = this.E.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.E, iRemaining, 1);
            if (iWrite < 0) {
                this.F = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iA0 = a0(audioTrack, byteBuffer, i2);
        if (iA0 < 0) {
            this.F = 0;
            return iA0;
        }
        this.F -= iA0;
        return iA0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void c(com.google.android.exoplayer2.audio.a aVar) {
        if (this.z.equals(aVar)) {
            return;
        }
        this.z = aVar;
        if (this.b0) {
            return;
        }
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void d(bn bnVar) {
        if (this.Z.equals(bnVar)) {
            return;
        }
        int i2 = bnVar.f1754a;
        float f2 = bnVar.b;
        AudioTrack audioTrack = this.w;
        if (audioTrack != null) {
            if (this.Z.f1754a != i2) {
                audioTrack.attachAuxEffect(i2);
            }
            if (i2 != 0) {
                this.w.setAuxEffectSendLevel(f2);
            }
        }
        this.Z = bnVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        if (this.b0) {
            this.b0 = false;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void e(AudioSink.a aVar) {
        this.s = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21() {
        vh.g(g86.f17680a >= 21);
        vh.g(this.X);
        if (this.b0) {
            return;
        }
        this.b0 = true;
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void experimentalFlushWithoutAudioTrackRelease() {
        if (g86.f17680a < 25) {
            flush();
            return;
        }
        this.o.a();
        this.n.a();
        if (F()) {
            O();
            if (this.i.h()) {
                this.w.pause();
            }
            this.w.flush();
            this.i.p();
            com.google.android.exoplayer2.audio.e eVar = this.i;
            AudioTrack audioTrack = this.w;
            g gVar = this.u;
            eVar.r(audioTrack, gVar.c == 2, gVar.g, gVar.d, gVar.h);
            this.M = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int f(com.google.android.exoplayer2.m mVar) {
        if (!"audio/raw".equals(mVar.l)) {
            return ((this.e0 || !Y(mVar, this.z)) && !w().i(mVar)) ? 0 : 2;
        }
        if (g86.z0(mVar.A)) {
            int i2 = mVar.A;
            return (i2 == 2 || (this.c && i2 == 4)) ? 2 : 1;
        }
        y53.i("DefaultAudioSink", "Invalid PCM encoding: " + mVar.A);
        return 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        if (F()) {
            O();
            if (this.i.h()) {
                this.w.pause();
            }
            if (G(this.w)) {
                ((l) vh.e(this.m)).b(this.w);
            }
            if (g86.f17680a < 21 && !this.X) {
                this.Y = 0;
            }
            g gVar = this.t;
            if (gVar != null) {
                this.u = gVar;
                this.t = null;
            }
            this.i.p();
            N(this.w, this.h);
            this.w = null;
        }
        this.o.a();
        this.n.a();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void g(@Nullable bk4 bk4Var) {
        this.r = bk4Var;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z) {
        if (!F() || this.M) {
            return Long.MIN_VALUE;
        }
        return s(r(Math.min(this.i.c(z), this.u.h(C()))));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public u getPlaybackParameters() {
        return this.C;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void h(com.google.android.exoplayer2.m mVar, int i2, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        com.google.android.exoplayer2.audio.c cVar;
        int i3;
        int iIntValue;
        int iF;
        boolean z;
        int iF0;
        int iF02;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int bufferSizeInBytes;
        int[] iArr2;
        if ("audio/raw".equals(mVar.l)) {
            vh.a(g86.z0(mVar.A));
            iF0 = g86.f0(mVar.A, mVar.y);
            ImmutableList.a aVar = new ImmutableList.a();
            if (W(mVar.A)) {
                aVar.l(this.g);
            } else {
                aVar.l(this.f);
                aVar.k(this.b.getAudioProcessors());
            }
            com.google.android.exoplayer2.audio.c cVar2 = new com.google.android.exoplayer2.audio.c(aVar.e());
            if (cVar2.equals(this.v)) {
                cVar2 = this.v;
            }
            this.e.j(mVar.B, mVar.C);
            if (g86.f17680a < 21 && mVar.y == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i9 = 0; i9 < 6; i9++) {
                    iArr2[i9] = i9;
                }
            } else {
                iArr2 = iArr;
            }
            this.d.h(iArr2);
            try {
                AudioProcessor.a aVarA = cVar2.a(new AudioProcessor.a(mVar.z, mVar.y, mVar.A));
                int i10 = aVarA.c;
                int i11 = aVarA.f5818a;
                int iG = g86.G(aVarA.b);
                iF02 = g86.f0(i10, aVarA.b);
                cVar = cVar2;
                i3 = i11;
                iIntValue = iG;
                z = this.k;
                i4 = 0;
                iF = i10;
            } catch (AudioProcessor.UnhandledAudioFormatException e2) {
                throw new AudioSink.ConfigurationException(e2, mVar);
            }
        } else {
            com.google.android.exoplayer2.audio.c cVar3 = new com.google.android.exoplayer2.audio.c(ImmutableList.of());
            int i12 = mVar.z;
            if (Y(mVar, this.z)) {
                cVar = cVar3;
                i3 = i12;
                iF = fp3.f((String) vh.e(mVar.l), mVar.i);
                iIntValue = g86.G(mVar.y);
                iF0 = -1;
                iF02 = -1;
                i4 = 1;
                z = true;
            } else {
                Pair<Integer, Integer> pairF = w().f(mVar);
                if (pairF == null) {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + mVar, mVar);
                }
                int iIntValue2 = ((Integer) pairF.first).intValue();
                cVar = cVar3;
                i3 = i12;
                iIntValue = ((Integer) pairF.second).intValue();
                iF = iIntValue2;
                z = this.k;
                iF0 = -1;
                iF02 = -1;
                i4 = 2;
            }
        }
        if (iF == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i4 + ") for: " + mVar, mVar);
        }
        if (iIntValue == 0) {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i4 + ") for: " + mVar, mVar);
        }
        if (i2 != 0) {
            bufferSizeInBytes = i2;
            i5 = iF;
            i6 = iIntValue;
            i7 = iF02;
            i8 = i3;
        } else {
            i5 = iF;
            i6 = iIntValue;
            i7 = iF02;
            i8 = i3;
            bufferSizeInBytes = this.p.getBufferSizeInBytes(y(i3, iIntValue, iF), iF, i4, iF02 != -1 ? iF02 : 1, i3, mVar.h, z ? 8.0d : 1.0d);
        }
        this.e0 = false;
        g gVar = new g(mVar, iF0, i4, i7, i8, i6, i5, bufferSizeInBytes, cVar, z);
        if (F()) {
            this.t = gVar;
        } else {
            this.u = gVar;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean handleBuffer(ByteBuffer byteBuffer, long j2, int i2) throws Exception {
        ByteBuffer byteBuffer2 = this.P;
        vh.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.t != null) {
            if (!v()) {
                return false;
            }
            if (this.t.b(this.u)) {
                this.u = this.t;
                this.t = null;
                if (G(this.w) && this.l != 3) {
                    if (this.w.getPlayState() == 3) {
                        this.w.setOffloadEndOfStream();
                    }
                    AudioTrack audioTrack = this.w;
                    com.google.android.exoplayer2.m mVar = this.u.f5823a;
                    audioTrack.setOffloadDelayPadding(mVar.B, mVar.C);
                    this.f0 = true;
                }
            } else {
                K();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            }
            q(j2);
        }
        if (!F()) {
            try {
                if (!D()) {
                    return false;
                }
            } catch (AudioSink.InitializationException e2) {
                if (e2.isRecoverable) {
                    throw e2;
                }
                this.n.b(e2);
                return false;
            }
        }
        this.n.a();
        if (this.M) {
            this.N = Math.max(0L, j2);
            this.L = false;
            this.M = false;
            if (X()) {
                Q();
            }
            q(j2);
            if (this.W) {
                play();
            }
        }
        if (!this.i.j(C())) {
            return false;
        }
        if (this.P == null) {
            vh.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            g gVar = this.u;
            if (gVar.c != 0 && this.K == 0) {
                int iZ = z(gVar.g, byteBuffer);
                this.K = iZ;
                if (iZ == 0) {
                    return true;
                }
            }
            if (this.A != null) {
                if (!v()) {
                    return false;
                }
                q(j2);
                this.A = null;
            }
            long jK = this.N + this.u.k(B() - this.e.h());
            if (!this.L && Math.abs(jK - j2) > 200000) {
                AudioSink.a aVar = this.s;
                if (aVar != null) {
                    aVar.onAudioSinkError(new AudioSink.UnexpectedDiscontinuityException(j2, jK));
                }
                this.L = true;
            }
            if (this.L) {
                if (!v()) {
                    return false;
                }
                long j3 = j2 - jK;
                this.N += j3;
                this.L = false;
                q(j2);
                AudioSink.a aVar2 = this.s;
                if (aVar2 != null && j3 != 0) {
                    aVar2.onPositionDiscontinuity();
                }
            }
            if (this.u.c == 0) {
                this.G += (long) byteBuffer.remaining();
            } else {
                this.H += ((long) this.K) * ((long) i2);
            }
            this.P = byteBuffer;
            this.Q = i2;
        }
        L(j2);
        if (!this.P.hasRemaining()) {
            this.P = null;
            this.Q = 0;
            return true;
        }
        if (!this.i.i(C())) {
            return false;
        }
        y53.i("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        this.L = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        return F() && this.i.g(C());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        return !F() || (this.U && !hasPendingData());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.W = false;
        if (F() && this.i.o()) {
            this.w.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.W = true;
        if (F()) {
            this.i.t();
            this.w.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() throws AudioSink.WriteException {
        if (!this.U && F() && v()) {
            K();
            this.U = true;
        }
    }

    public final void q(long j2) {
        u uVarA;
        if (X()) {
            uVarA = u.d;
        } else {
            uVarA = V() ? this.b.a(this.C) : u.d;
            this.C = uVarA;
        }
        u uVar = uVarA;
        this.D = V() ? this.b.applySkipSilenceEnabled(this.D) : false;
        this.j.add(new i(uVar, Math.max(0L, j2), this.u.h(C())));
        U();
        AudioSink.a aVar = this.s;
        if (aVar != null) {
            aVar.onSkipSilenceEnabledChanged(this.D);
        }
    }

    public final long r(long j2) {
        while (!this.j.isEmpty() && j2 >= this.j.getFirst().c) {
            this.B = this.j.remove();
        }
        i iVar = this.B;
        long j3 = j2 - iVar.c;
        if (iVar.f5825a.equals(u.d)) {
            return this.B.b + j3;
        }
        if (this.j.isEmpty()) {
            return this.B.b + this.b.getMediaDuration(j3);
        }
        i first = this.j.getFirst();
        return first.b - g86.b0(first.c - j2, this.B.f5825a.f5989a);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void release() {
        com.google.android.exoplayer2.audio.b bVar = this.y;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        flush();
        o46<AudioProcessor> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
        o46<AudioProcessor> it2 = this.g.iterator();
        while (it2.hasNext()) {
            it2.next().reset();
        }
        com.google.android.exoplayer2.audio.c cVar = this.v;
        if (cVar != null) {
            cVar.j();
        }
        this.W = false;
        this.e0 = false;
    }

    public final long s(long j2) {
        return j2 + this.u.h(this.b.getSkippedOutputFrameCount());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int i2) {
        if (this.Y != i2) {
            this.Y = i2;
            this.X = i2 != 0;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public /* synthetic */ void setOutputStreamOffsetUs(long j2) {
        zl.a(this, j2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    @RequiresApi(23)
    public void setPreferredDevice(@Nullable AudioDeviceInfo audioDeviceInfo) {
        d dVar = audioDeviceInfo == null ? null : new d(audioDeviceInfo);
        this.a0 = dVar;
        AudioTrack audioTrack = this.w;
        if (audioTrack != null) {
            b.a(audioTrack, dVar);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setSkipSilenceEnabled(boolean z) {
        this.D = z;
        P(X() ? u.d : this.C);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f2) {
        if (this.O != f2) {
            this.O = f2;
            R();
        }
    }

    public final AudioTrack t(g gVar) throws AudioSink.InitializationException {
        try {
            AudioTrack audioTrackA = gVar.a(this.b0, this.z, this.Y);
            j.a aVar = this.q;
            if (aVar != null) {
                aVar.g(G(audioTrackA));
            }
            return audioTrackA;
        } catch (AudioSink.InitializationException e2) {
            AudioSink.a aVar2 = this.s;
            if (aVar2 != null) {
                aVar2.onAudioSinkError(e2);
            }
            throw e2;
        }
    }

    public final AudioTrack u() throws AudioSink.InitializationException {
        try {
            return t((g) vh.e(this.u));
        } catch (AudioSink.InitializationException e2) {
            g gVar = this.u;
            if (gVar.h > 1000000) {
                g gVarC = gVar.c(1000000);
                try {
                    AudioTrack audioTrackT = t(gVarC);
                    this.u = gVarC;
                    return audioTrackT;
                } catch (AudioSink.InitializationException e3) {
                    e2.addSuppressed(e3);
                    I();
                    throw e2;
                }
            }
            I();
            throw e2;
        }
    }

    public final boolean v() throws Exception {
        if (!this.v.f()) {
            ByteBuffer byteBuffer = this.R;
            if (byteBuffer == null) {
                return true;
            }
            Z(byteBuffer, Long.MIN_VALUE);
            return this.R == null;
        }
        this.v.h();
        L(Long.MIN_VALUE);
        if (!this.v.e()) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.R;
        return byteBuffer2 == null || !byteBuffer2.hasRemaining();
    }

    public final mj w() {
        if (this.y == null && this.f5819a != null) {
            this.g0 = Looper.myLooper();
            com.google.android.exoplayer2.audio.b bVar = new com.google.android.exoplayer2.audio.b(this.f5819a, new b.f() { // from class: z21
                @Override // com.google.android.exoplayer2.audio.b.f
                public final void a(mj mjVar) {
                    this.f22323a.J(mjVar);
                }
            });
            this.y = bVar;
            this.x = bVar.d();
        }
        return this.x;
    }

    public DefaultAudioSink(f fVar) {
        Context context = fVar.f5822a;
        this.f5819a = context;
        this.x = context != null ? mj.c(context) : fVar.b;
        this.b = fVar.c;
        int i2 = g86.f17680a;
        this.c = i2 >= 21 && fVar.d;
        this.k = i2 >= 23 && fVar.e;
        this.l = i2 >= 29 ? fVar.f : 0;
        this.p = fVar.g;
        ml0 ml0Var = new ml0(ed0.f17276a);
        this.h = ml0Var;
        ml0Var.e();
        this.i = new com.google.android.exoplayer2.audio.e(new k());
        com.google.android.exoplayer2.audio.g gVar = new com.google.android.exoplayer2.audio.g();
        this.d = gVar;
        n nVar = new n();
        this.e = nVar;
        this.f = ImmutableList.of((n) new m(), (n) gVar, nVar);
        this.g = ImmutableList.of(new com.google.android.exoplayer2.audio.l());
        this.O = 1.0f;
        this.z = com.google.android.exoplayer2.audio.a.g;
        this.Y = 0;
        this.Z = new bn(0, 0.0f);
        u uVar = u.d;
        this.B = new i(uVar, 0L, 0L);
        this.C = uVar;
        this.D = false;
        this.j = new ArrayDeque<>();
        this.n = new j<>(100L);
        this.o = new j<>(100L);
        this.q = fVar.h;
    }
}
