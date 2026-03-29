package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.f0;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.u;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidContentTypeException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.v;
import com.google.common.collect.ImmutableList;
import defpackage.kj4;
import defpackage.oc;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(31)
@Deprecated
public final class uj3 implements oc, kj4.a {
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21228a;
    public final kj4 b;
    public final PlaybackSession c;

    @Nullable
    public String i;

    @Nullable
    public PlaybackMetrics.Builder j;
    public int k;

    @Nullable
    public PlaybackException n;

    @Nullable
    public b o;

    @Nullable
    public b p;

    @Nullable
    public b q;

    @Nullable
    public m r;

    @Nullable
    public m s;

    @Nullable
    public m t;
    public boolean u;
    public int v;
    public boolean w;
    public int x;
    public int y;
    public int z;
    public final e0.d e = new e0.d();
    public final e0.b f = new e0.b();
    public final HashMap<String, Long> h = new HashMap<>();
    public final HashMap<String, Long> g = new HashMap<>();
    public final long d = SystemClock.elapsedRealtime();
    public int l = 0;
    public int m = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21229a;
        public final int b;

        public a(int i, int i2) {
            this.f21229a = i;
            this.b = i2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f21230a;
        public final int b;
        public final String c;

        public b(m mVar, int i, String str) {
            this.f21230a = mVar;
            this.b = i;
            this.c = str;
        }
    }

    public uj3(Context context, PlaybackSession playbackSession) {
        this.f21228a = context.getApplicationContext();
        this.c = playbackSession;
        c71 c71Var = new c71();
        this.b = c71Var;
        c71Var.f(this);
    }

    public static int A0(DrmInitData drmInitData) {
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            UUID uuid = drmInitData.get(i).uuid;
            if (uuid.equals(zv.d)) {
                return 3;
            }
            if (uuid.equals(zv.e)) {
                return 2;
            }
            if (uuid.equals(zv.c)) {
                return 6;
            }
        }
        return 1;
    }

    public static a B0(PlaybackException playbackException, Context context, boolean z) {
        int i;
        boolean z2;
        if (playbackException.errorCode == 1001) {
            return new a(20, 0);
        }
        if (playbackException instanceof ExoPlaybackException) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
            z2 = exoPlaybackException.type == 1;
            i = exoPlaybackException.rendererFormatSupport;
        } else {
            i = 0;
            z2 = false;
        }
        Throwable th = (Throwable) vh.e(playbackException.getCause());
        if (!(th instanceof IOException)) {
            if (z2 && (i == 0 || i == 1)) {
                return new a(35, 0);
            }
            if (z2 && i == 3) {
                return new a(15, 0);
            }
            if (z2 && i == 2) {
                return new a(23, 0);
            }
            if (th instanceof MediaCodecRenderer.DecoderInitializationException) {
                return new a(13, g86.W(((MediaCodecRenderer.DecoderInitializationException) th).diagnosticInfo));
            }
            if (th instanceof MediaCodecDecoderException) {
                return new a(14, g86.W(((MediaCodecDecoderException) th).diagnosticInfo));
            }
            if (th instanceof OutOfMemoryError) {
                return new a(14, 0);
            }
            if (th instanceof AudioSink.InitializationException) {
                return new a(17, ((AudioSink.InitializationException) th).audioTrackState);
            }
            if (th instanceof AudioSink.WriteException) {
                return new a(18, ((AudioSink.WriteException) th).errorCode);
            }
            if (g86.f17680a < 16 || !(th instanceof MediaCodec.CryptoException)) {
                return new a(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th).getErrorCode();
            return new a(y0(errorCode), errorCode);
        }
        if (th instanceof HttpDataSource$InvalidResponseCodeException) {
            return new a(5, ((HttpDataSource$InvalidResponseCodeException) th).responseCode);
        }
        if ((th instanceof HttpDataSource$InvalidContentTypeException) || (th instanceof ParserException)) {
            return new a(z ? 10 : 11, 0);
        }
        if ((th instanceof HttpDataSource$HttpDataSourceException) || (th instanceof UdpDataSource.UdpDataSourceException)) {
            if (ww3.d(context).f() == 1) {
                return new a(3, 0);
            }
            Throwable cause = th.getCause();
            return cause instanceof UnknownHostException ? new a(6, 0) : cause instanceof SocketTimeoutException ? new a(7, 0) : ((th instanceof HttpDataSource$HttpDataSourceException) && ((HttpDataSource$HttpDataSourceException) th).type == 1) ? new a(4, 0) : new a(8, 0);
        }
        if (playbackException.errorCode == 1002) {
            return new a(21, 0);
        }
        if (!(th instanceof DrmSession.DrmSessionException)) {
            if (!(th instanceof FileDataSource.FileDataSourceException) || !(th.getCause() instanceof FileNotFoundException)) {
                return new a(9, 0);
            }
            Throwable cause2 = ((Throwable) vh.e(th.getCause())).getCause();
            return (g86.f17680a >= 21 && (cause2 instanceof ErrnoException) && ((ErrnoException) cause2).errno == OsConstants.EACCES) ? new a(32, 0) : new a(31, 0);
        }
        Throwable th2 = (Throwable) vh.e(th.getCause());
        int i2 = g86.f17680a;
        if (i2 < 21 || !(th2 instanceof MediaDrm.MediaDrmStateException)) {
            return (i2 < 23 || !qi3.a(th2)) ? (i2 < 18 || !(th2 instanceof NotProvisionedException)) ? (i2 < 18 || !(th2 instanceof DeniedByServerException)) ? th2 instanceof UnsupportedDrmException ? new a(23, 0) : th2 instanceof DefaultDrmSessionManager.MissingSchemeDataException ? new a(28, 0) : new a(30, 0) : new a(29, 0) : new a(24, 0) : new a(27, 0);
        }
        int iW = g86.W(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo());
        return new a(y0(iW), iW);
    }

    public static Pair<String, String> C0(String str) {
        String[] strArrZ0 = g86.Z0(str, "-");
        return Pair.create(strArrZ0[0], strArrZ0.length >= 2 ? strArrZ0[1] : null);
    }

    public static int E0(Context context) {
        switch (ww3.d(context).f()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
            case 8:
            default:
                return 1;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
        }
    }

    public static int F0(p pVar) {
        p.h hVar = pVar.b;
        if (hVar == null) {
            return 0;
        }
        int iU0 = g86.u0(hVar.f5920a, hVar.b);
        if (iU0 == 0) {
            return 3;
        }
        if (iU0 != 1) {
            return iU0 != 2 ? 1 : 4;
        }
        return 5;
    }

    public static int G0(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? 1 : 4;
        }
        return 3;
    }

    @Nullable
    public static uj3 w0(Context context) {
        MediaMetricsManager mediaMetricsManagerA = bj3.a(context.getSystemService("media_metrics"));
        if (mediaMetricsManagerA == null) {
            return null;
        }
        return new uj3(context, mediaMetricsManagerA.createPlaybackSession());
    }

    @SuppressLint({"SwitchIntDef"})
    public static int y0(int i) {
        switch (g86.V(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    @Nullable
    public static DrmInitData z0(ImmutableList<f0.a> immutableList) {
        DrmInitData drmInitData;
        o46<f0.a> it = immutableList.iterator();
        while (it.hasNext()) {
            f0.a next = it.next();
            for (int i = 0; i < next.f5874a; i++) {
                if (next.h(i) && (drmInitData = next.c(i).o) != null) {
                    return drmInitData;
                }
            }
        }
        return null;
    }

    @Override // defpackage.oc
    public /* synthetic */ void A(oc.a aVar) {
        lc.w(this, aVar);
    }

    @Override // defpackage.oc
    public /* synthetic */ void B(oc.a aVar, m mVar, ow0 ow0Var) {
        lc.g0(this, aVar, mVar, ow0Var);
    }

    @Override // defpackage.oc
    public /* synthetic */ void C(oc.a aVar, v.b bVar) {
        lc.l(this, aVar, bVar);
    }

    @Override // defpackage.oc
    public /* synthetic */ void D(oc.a aVar, p pVar, int i) {
        lc.E(this, aVar, pVar, i);
    }

    public LogSessionId D0() {
        return this.c.getSessionId();
    }

    @Override // defpackage.oc
    public /* synthetic */ void E(oc.a aVar, lw0 lw0Var) {
        lc.e(this, aVar, lw0Var);
    }

    @Override // defpackage.oc
    public /* synthetic */ void F(oc.a aVar, boolean z) {
        lc.D(this, aVar, z);
    }

    @Override // defpackage.oc
    public /* synthetic */ void G(oc.a aVar, int i) {
        lc.K(this, aVar, i);
    }

    @Override // defpackage.oc
    public void H(v vVar, oc.b bVar) {
        if (bVar.d() == 0) {
            return;
        }
        H0(bVar);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        N0(vVar, bVar);
        J0(jElapsedRealtime);
        L0(vVar, bVar, jElapsedRealtime);
        I0(jElapsedRealtime);
        K0(vVar, bVar, jElapsedRealtime);
        if (bVar.a(1028)) {
            this.b.c(bVar.c(1028));
        }
    }

    public final void H0(oc.b bVar) {
        for (int i = 0; i < bVar.d(); i++) {
            int iB = bVar.b(i);
            oc.a aVarC = bVar.c(iB);
            if (iB == 0) {
                this.b.a(aVarC);
            } else if (iB == 11) {
                this.b.b(aVarC, this.k);
            } else {
                this.b.d(aVarC);
            }
        }
    }

    @Override // defpackage.oc
    public /* synthetic */ void I(oc.a aVar) {
        lc.q(this, aVar);
    }

    public final void I0(long j) {
        int iE0 = E0(this.f21228a);
        if (iE0 != this.m) {
            this.m = iE0;
            this.c.reportNetworkEvent(jj3.a().setNetworkType(iE0).setTimeSinceCreatedMillis(j - this.d).build());
        }
    }

    @Override // defpackage.oc
    public /* synthetic */ void J(oc.a aVar, Exception exc) {
        lc.j(this, aVar, exc);
    }

    public final void J0(long j) {
        PlaybackException playbackException = this.n;
        if (playbackException == null) {
            return;
        }
        a aVarB0 = B0(playbackException, this.f21228a, this.v == 4);
        this.c.reportPlaybackErrorEvent(ej3.a().setTimeSinceCreatedMillis(j - this.d).setErrorCode(aVarB0.f21229a).setSubErrorCode(aVarB0.b).setException(playbackException).build());
        this.A = true;
        this.n = null;
    }

    @Override // defpackage.oc
    public /* synthetic */ void K(oc.a aVar, List list) {
        lc.n(this, aVar, list);
    }

    public final void K0(v vVar, oc.b bVar, long j) {
        if (vVar.getPlaybackState() != 2) {
            this.u = false;
        }
        if (vVar.getPlayerError() == null) {
            this.w = false;
        } else if (bVar.a(10)) {
            this.w = true;
        }
        int iS0 = S0(vVar);
        if (this.l != iS0) {
            this.l = iS0;
            this.A = true;
            this.c.reportPlaybackStateEvent(ij3.a().setState(this.l).setTimeSinceCreatedMillis(j - this.d).build());
        }
    }

    @Override // defpackage.oc
    public /* synthetic */ void L(oc.a aVar, boolean z) {
        lc.T(this, aVar, z);
    }

    public final void L0(v vVar, oc.b bVar, long j) {
        if (bVar.a(2)) {
            f0 currentTracks = vVar.getCurrentTracks();
            boolean zD = currentTracks.d(2);
            boolean zD2 = currentTracks.d(1);
            boolean zD3 = currentTracks.d(3);
            if (zD || zD2 || zD3) {
                if (!zD) {
                    Q0(j, null, 0);
                }
                if (!zD2) {
                    M0(j, null, 0);
                }
                if (!zD3) {
                    O0(j, null, 0);
                }
            }
        }
        if (v0(this.o)) {
            b bVar2 = this.o;
            m mVar = bVar2.f21230a;
            if (mVar.r != -1) {
                Q0(j, mVar, bVar2.b);
                this.o = null;
            }
        }
        if (v0(this.p)) {
            b bVar3 = this.p;
            M0(j, bVar3.f21230a, bVar3.b);
            this.p = null;
        }
        if (v0(this.q)) {
            b bVar4 = this.q;
            O0(j, bVar4.f21230a, bVar4.b);
            this.q = null;
        }
    }

    @Override // defpackage.oc
    public void M(oc.a aVar, m43 m43Var, kh3 kh3Var, IOException iOException, boolean z) {
        this.v = kh3Var.f18688a;
    }

    public final void M0(long j, @Nullable m mVar, int i) {
        if (g86.c(this.s, mVar)) {
            return;
        }
        int i2 = (this.s == null && i == 0) ? 1 : i;
        this.s = mVar;
        R0(0, j, mVar, i2);
    }

    @Override // defpackage.oc
    public /* synthetic */ void N(oc.a aVar, long j, int i) {
        lc.e0(this, aVar, j, i);
    }

    public final void N0(v vVar, oc.b bVar) {
        DrmInitData drmInitDataZ0;
        if (bVar.a(0)) {
            oc.a aVarC = bVar.c(0);
            if (this.j != null) {
                P0(aVarC.b, aVarC.d);
            }
        }
        if (bVar.a(2) && this.j != null && (drmInitDataZ0 = z0(vVar.getCurrentTracks().b())) != null) {
            ci3.a(g86.j(this.j)).setDrmType(A0(drmInitDataZ0));
        }
        if (bVar.a(1011)) {
            this.z++;
        }
    }

    @Override // defpackage.oc
    public /* synthetic */ void O(oc.a aVar, long j) {
        lc.i(this, aVar, j);
    }

    public final void O0(long j, @Nullable m mVar, int i) {
        if (g86.c(this.t, mVar)) {
            return;
        }
        int i2 = (this.t == null && i == 0) ? 1 : i;
        this.t = mVar;
        R0(2, j, mVar, i2);
    }

    @Override // defpackage.oc
    public /* synthetic */ void P(oc.a aVar, kh3 kh3Var) {
        lc.Y(this, aVar, kh3Var);
    }

    public final void P0(e0 e0Var, @Nullable i.b bVar) {
        int iF;
        PlaybackMetrics.Builder builder = this.j;
        if (bVar == null || (iF = e0Var.f(bVar.f18710a)) == -1) {
            return;
        }
        e0Var.j(iF, this.f);
        e0Var.r(this.f.c, this.e);
        builder.setStreamType(F0(this.e.c));
        e0.d dVar = this.e;
        if (dVar.n != -9223372036854775807L && !dVar.l && !dVar.i && !dVar.h()) {
            builder.setMediaDurationMillis(this.e.f());
        }
        builder.setPlaybackType(this.e.h() ? 2 : 1);
        this.A = true;
    }

    @Override // defpackage.oc
    public /* synthetic */ void Q(oc.a aVar, int i, int i2, int i3, float f) {
        lc.h0(this, aVar, i, i2, i3, f);
    }

    public final void Q0(long j, @Nullable m mVar, int i) {
        if (g86.c(this.r, mVar)) {
            return;
        }
        int i2 = (this.r == null && i == 0) ? 1 : i;
        this.r = mVar;
        R0(1, j, mVar, i2);
    }

    @Override // defpackage.oc
    public /* synthetic */ void R(oc.a aVar, m mVar, ow0 ow0Var) {
        lc.h(this, aVar, mVar, ow0Var);
    }

    public final void R0(int i, long j, @Nullable m mVar, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = gj3.a(i).setTimeSinceCreatedMillis(j - this.d);
        if (mVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(G0(i2));
            String str = mVar.k;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = mVar.l;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = mVar.i;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i3 = mVar.h;
            if (i3 != -1) {
                timeSinceCreatedMillis.setBitrate(i3);
            }
            int i4 = mVar.q;
            if (i4 != -1) {
                timeSinceCreatedMillis.setWidth(i4);
            }
            int i5 = mVar.r;
            if (i5 != -1) {
                timeSinceCreatedMillis.setHeight(i5);
            }
            int i6 = mVar.y;
            if (i6 != -1) {
                timeSinceCreatedMillis.setChannelCount(i6);
            }
            int i7 = mVar.z;
            if (i7 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i7);
            }
            String str4 = mVar.c;
            if (str4 != null) {
                Pair<String, String> pairC0 = C0(str4);
                timeSinceCreatedMillis.setLanguage((String) pairC0.first);
                Object obj = pairC0.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f = mVar.s;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.A = true;
        this.c.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    @Override // defpackage.oc
    public /* synthetic */ void S(oc.a aVar, Object obj, long j) {
        lc.P(this, aVar, obj, j);
    }

    public final int S0(v vVar) {
        int playbackState = vVar.getPlaybackState();
        if (this.u) {
            return 5;
        }
        if (this.w) {
            return 13;
        }
        if (playbackState == 4) {
            return 11;
        }
        if (playbackState == 2) {
            int i = this.l;
            if (i == 0 || i == 2) {
                return 2;
            }
            if (vVar.getPlayWhenReady()) {
                return vVar.getPlaybackSuppressionReason() != 0 ? 10 : 6;
            }
            return 7;
        }
        if (playbackState == 3) {
            if (vVar.getPlayWhenReady()) {
                return vVar.getPlaybackSuppressionReason() != 0 ? 9 : 3;
            }
            return 4;
        }
        if (playbackState != 1 || this.l == 0) {
            return this.l;
        }
        return 12;
    }

    @Override // defpackage.oc
    public void T(oc.a aVar, PlaybackException playbackException) {
        this.n = playbackException;
    }

    @Override // defpackage.oc
    public void U(oc.a aVar, lw0 lw0Var) {
        this.x += lw0Var.g;
        this.y += lw0Var.e;
    }

    @Override // defpackage.oc
    public /* synthetic */ void V(oc.a aVar, xr0 xr0Var) {
        lc.m(this, aVar, xr0Var);
    }

    @Override // defpackage.oc
    public /* synthetic */ void W(oc.a aVar, m43 m43Var, kh3 kh3Var) {
        lc.A(this, aVar, m43Var, kh3Var);
    }

    @Override // defpackage.oc
    public /* synthetic */ void X(oc.a aVar, String str, long j) {
        lc.a0(this, aVar, str, j);
    }

    @Override // defpackage.oc
    public void Y(oc.a aVar, v.e eVar, v.e eVar2, int i) {
        if (i == 1) {
            this.u = true;
        }
        this.k = i;
    }

    @Override // defpackage.oc
    public /* synthetic */ void a(oc.a aVar, boolean z) {
        lc.z(this, aVar, z);
    }

    @Override // defpackage.oc
    public /* synthetic */ void a0(oc.a aVar, String str) {
        lc.d(this, aVar, str);
    }

    @Override // defpackage.oc
    public /* synthetic */ void b(oc.a aVar, Exception exc) {
        lc.a(this, aVar, exc);
    }

    @Override // kj4.a
    public void b0(oc.a aVar, String str, boolean z) {
        i.b bVar = aVar.d;
        if ((bVar == null || !bVar.b()) && str.equals(this.i)) {
            x0();
        }
        this.g.remove(str);
        this.h.remove(str);
    }

    @Override // defpackage.oc
    public /* synthetic */ void c(oc.a aVar, m43 m43Var, kh3 kh3Var) {
        lc.C(this, aVar, m43Var, kh3Var);
    }

    @Override // defpackage.oc
    public /* synthetic */ void c0(oc.a aVar, m mVar) {
        lc.g(this, aVar, mVar);
    }

    @Override // defpackage.oc
    public /* synthetic */ void d(oc.a aVar) {
        lc.M(this, aVar);
    }

    @Override // defpackage.oc
    public /* synthetic */ void d0(oc.a aVar, String str, long j, long j2) {
        lc.c(this, aVar, str, j, j2);
    }

    @Override // defpackage.oc
    public /* synthetic */ void e(oc.a aVar, int i, int i2) {
        lc.U(this, aVar, i, i2);
    }

    @Override // defpackage.oc
    public /* synthetic */ void e0(oc.a aVar, int i) {
        lc.Q(this, aVar, i);
    }

    @Override // kj4.a
    public void f(oc.a aVar, String str) {
        i.b bVar = aVar.d;
        if (bVar == null || !bVar.b()) {
            x0();
            this.i = str;
            this.j = hj3.a().setPlayerName("ExoPlayerLib").setPlayerVersion("2.19.1");
            P0(aVar.b, aVar.d);
        }
    }

    @Override // defpackage.oc
    public /* synthetic */ void f0(oc.a aVar, Exception exc) {
        lc.Z(this, aVar, exc);
    }

    @Override // defpackage.oc
    public void g(oc.a aVar, te6 te6Var) {
        b bVar = this.o;
        if (bVar != null) {
            m mVar = bVar.f21230a;
            if (mVar.r == -1) {
                this.o = new b(mVar.b().n0(te6Var.f20973a).S(te6Var.b).G(), bVar.b, bVar.c);
            }
        }
    }

    @Override // defpackage.oc
    public /* synthetic */ void g0(oc.a aVar, u uVar) {
        lc.I(this, aVar, uVar);
    }

    @Override // defpackage.oc
    public /* synthetic */ void h(oc.a aVar, PlaybackException playbackException) {
        lc.L(this, aVar, playbackException);
    }

    @Override // defpackage.oc
    public /* synthetic */ void h0(oc.a aVar, String str, long j, long j2) {
        lc.b0(this, aVar, str, j, j2);
    }

    @Override // defpackage.oc
    public /* synthetic */ void i0(oc.a aVar, String str) {
        lc.c0(this, aVar, str);
    }

    @Override // defpackage.oc
    public /* synthetic */ void j(oc.a aVar, f0 f0Var) {
        lc.X(this, aVar, f0Var);
    }

    @Override // defpackage.oc
    public /* synthetic */ void j0(oc.a aVar, Metadata metadata) {
        lc.G(this, aVar, metadata);
    }

    @Override // defpackage.oc
    public /* synthetic */ void k(oc.a aVar, int i) {
        lc.O(this, aVar, i);
    }

    @Override // defpackage.oc
    public /* synthetic */ void k0(oc.a aVar, m43 m43Var, kh3 kh3Var) {
        lc.B(this, aVar, m43Var, kh3Var);
    }

    @Override // defpackage.oc
    public /* synthetic */ void l(oc.a aVar, q qVar) {
        lc.F(this, aVar, qVar);
    }

    @Override // defpackage.oc
    public /* synthetic */ void l0(oc.a aVar, float f) {
        lc.i0(this, aVar, f);
    }

    @Override // defpackage.oc
    public /* synthetic */ void m(oc.a aVar, boolean z) {
        lc.S(this, aVar, z);
    }

    @Override // defpackage.oc
    public /* synthetic */ void m0(oc.a aVar, int i, long j, long j2) {
        lc.k(this, aVar, i, j, j2);
    }

    @Override // defpackage.oc
    public /* synthetic */ void n(oc.a aVar) {
        lc.r(this, aVar);
    }

    @Override // defpackage.oc
    public void n0(oc.a aVar, int i, long j, long j2) {
        i.b bVar = aVar.d;
        if (bVar != null) {
            String strE = this.b.e(aVar.b, (i.b) vh.e(bVar));
            Long l = this.h.get(strE);
            Long l2 = this.g.get(strE);
            this.h.put(strE, Long.valueOf((l == null ? 0L : l.longValue()) + j));
            this.g.put(strE, Long.valueOf((l2 != null ? l2.longValue() : 0L) + ((long) i)));
        }
    }

    @Override // defpackage.oc
    public /* synthetic */ void o(oc.a aVar, int i) {
        lc.J(this, aVar, i);
    }

    @Override // defpackage.oc
    public void o0(oc.a aVar, kh3 kh3Var) {
        if (aVar.d == null) {
            return;
        }
        b bVar = new b((m) vh.e(kh3Var.c), kh3Var.d, this.b.e(aVar.b, (i.b) vh.e(aVar.d)));
        int i = kh3Var.b;
        if (i != 0) {
            if (i == 1) {
                this.p = bVar;
                return;
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                this.q = bVar;
                return;
            }
        }
        this.o = bVar;
    }

    @Override // defpackage.oc
    public /* synthetic */ void p(oc.a aVar) {
        lc.t(this, aVar);
    }

    @Override // defpackage.oc
    public /* synthetic */ void p0(oc.a aVar, int i, boolean z) {
        lc.p(this, aVar, i, z);
    }

    @Override // defpackage.oc
    public /* synthetic */ void q(oc.a aVar) {
        lc.R(this, aVar);
    }

    @Override // defpackage.oc
    public /* synthetic */ void q0(oc.a aVar, int i, long j) {
        lc.x(this, aVar, i, j);
    }

    @Override // defpackage.oc
    public /* synthetic */ void r(oc.a aVar, m mVar) {
        lc.f0(this, aVar, mVar);
    }

    @Override // defpackage.oc
    public /* synthetic */ void r0(oc.a aVar, boolean z) {
        lc.y(this, aVar, z);
    }

    @Override // defpackage.oc
    public /* synthetic */ void s(oc.a aVar, int i) {
        lc.V(this, aVar, i);
    }

    @Override // defpackage.oc
    public /* synthetic */ void s0(oc.a aVar, boolean z, int i) {
        lc.H(this, aVar, z, i);
    }

    @Override // defpackage.oc
    public /* synthetic */ void t(oc.a aVar, lw0 lw0Var) {
        lc.f(this, aVar, lw0Var);
    }

    @Override // defpackage.oc
    public /* synthetic */ void t0(oc.a aVar, Exception exc) {
        lc.v(this, aVar, exc);
    }

    @Override // defpackage.oc
    public /* synthetic */ void u(oc.a aVar, boolean z, int i) {
        lc.N(this, aVar, z, i);
    }

    @Override // defpackage.oc
    public /* synthetic */ void u0(oc.a aVar) {
        lc.s(this, aVar);
    }

    @Override // defpackage.oc
    public /* synthetic */ void v(oc.a aVar, String str, long j) {
        lc.b(this, aVar, str, j);
    }

    public final boolean v0(@Nullable b bVar) {
        return bVar != null && bVar.c.equals(this.b.getActiveSessionId());
    }

    @Override // defpackage.oc
    public /* synthetic */ void w(oc.a aVar, lw0 lw0Var) {
        lc.d0(this, aVar, lw0Var);
    }

    @Override // defpackage.oc
    public /* synthetic */ void x(oc.a aVar, int i) {
        lc.u(this, aVar, i);
    }

    public final void x0() {
        PlaybackMetrics.Builder builder = this.j;
        if (builder != null && this.A) {
            builder.setAudioUnderrunCount(this.z);
            this.j.setVideoFramesDropped(this.x);
            this.j.setVideoFramesPlayed(this.y);
            Long l = this.g.get(this.i);
            this.j.setNetworkTransferDurationMillis(l == null ? 0L : l.longValue());
            Long l2 = this.h.get(this.i);
            this.j.setNetworkBytesRead(l2 == null ? 0L : l2.longValue());
            this.j.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            this.c.reportPlaybackMetrics(this.j.build());
        }
        this.j = null;
        this.i = null;
        this.z = 0;
        this.x = 0;
        this.y = 0;
        this.r = null;
        this.s = null;
        this.t = null;
        this.A = false;
    }

    @Override // defpackage.oc
    public /* synthetic */ void y(oc.a aVar, k06 k06Var) {
        lc.W(this, aVar, k06Var);
    }

    @Override // defpackage.oc
    public /* synthetic */ void z(oc.a aVar, com.google.android.exoplayer2.i iVar) {
        lc.o(this, aVar, iVar);
    }

    @Override // kj4.a
    public void Z(oc.a aVar, String str) {
    }

    @Override // kj4.a
    public void i(oc.a aVar, String str, String str2) {
    }
}
