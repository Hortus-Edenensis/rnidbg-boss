package defpackage;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.c;
import com.google.android.exoplayer2.mediacodec.e;
import com.google.android.exoplayer2.video.MediaCodecVideoDecoderException;
import com.google.android.exoplayer2.video.PlaceholderSurface;
import com.google.common.collect.ImmutableList;
import com.igexin.push.core.g;
import com.oplus.tbl.exoplayer2.audio.DefaultAudioSink;
import com.oplus.tblplayer.misc.IMediaFormat;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import defpackage.ac6;
import defpackage.c32;
import defpackage.oe6;
import j$.util.Objects;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class bg3 extends MediaCodecRenderer {
    public static final int[] t1 = {TECameraUtils.CAPTURE_NORMAL, 1600, 1440, 1280, 960, 854, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 540, TECameraSettings.FPS_480};
    public static boolean u1;
    public static boolean v1;
    public final Context L0;
    public final fc6 M0;
    public final oe6.a N0;
    public final d O0;
    public final long P0;
    public final int Q0;
    public final boolean R0;
    public b S0;
    public boolean T0;
    public boolean U0;

    @Nullable
    public Surface V0;

    @Nullable
    public PlaceholderSurface W0;
    public boolean X0;
    public int Y0;
    public boolean Z0;
    public boolean a1;
    public boolean b1;
    public long c1;
    public long d1;
    public long e1;
    public int f1;
    public int g1;
    public int h1;
    public long i1;
    public long j1;
    public long k1;
    public int l1;
    public long m1;
    public te6 n1;

    @Nullable
    public te6 o1;
    public boolean p1;
    public int q1;

    @Nullable
    public c r1;

    @Nullable
    public yb6 s1;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(26)
    public static final class a {
        @DoNotInline
        public static boolean a(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display == null || !display.isHdr()) {
                return false;
            }
            for (int i : display.getHdrCapabilities().getSupportedHdrTypes()) {
                if (i == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1706a;
        public final int b;
        public final int c;

        public b(int i, int i2, int i3) {
            this.f1706a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(23)
    public final class c implements c.InterfaceC0353c, Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f1707a;

        public c(com.google.android.exoplayer2.mediacodec.c cVar) {
            Handler handlerX = g86.x(this);
            this.f1707a = handlerX;
            cVar.b(this, handlerX);
        }

        @Override // com.google.android.exoplayer2.mediacodec.c.InterfaceC0353c
        public void a(com.google.android.exoplayer2.mediacodec.c cVar, long j, long j2) {
            if (g86.f17680a >= 30) {
                b(j);
            } else {
                this.f1707a.sendMessageAtFrontOfQueue(Message.obtain(this.f1707a, 0, (int) (j >> 32), (int) j));
            }
        }

        public final void b(long j) {
            bg3 bg3Var = bg3.this;
            if (this != bg3Var.r1 || bg3Var.Y() == null) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                bg3.this.P1();
                return;
            }
            try {
                bg3.this.O1(j);
            } catch (ExoPlaybackException e) {
                bg3.this.Q0(e);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(g86.j1(message.arg1, message.arg2));
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fc6 f1708a;
        public final bg3 b;
        public Handler e;

        @Nullable
        public ac6 f;

        @Nullable
        public CopyOnWriteArrayList<jk1> g;

        @Nullable
        public m h;
        public Pair<Long, m> i;

        @Nullable
        public Pair<Surface, ne5> j;
        public boolean m;
        public boolean n;
        public boolean o;
        public final ArrayDeque<Long> c = new ArrayDeque<>();
        public final ArrayDeque<Pair<Long, m>> d = new ArrayDeque<>();
        public int k = -1;
        public boolean l = true;
        public long p = -9223372036854775807L;
        public te6 q = te6.e;
        public long r = -9223372036854775807L;
        public long s = -9223372036854775807L;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements ac6.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ m f1709a;

            public a(m mVar) {
                this.f1709a = mVar;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static Constructor<?> f1710a;
            public static Method b;
            public static Method c;
            public static Constructor<?> d;
            public static Method e;

            public static jk1 a(float f) throws Exception {
                c();
                Object objNewInstance = f1710a.newInstance(new Object[0]);
                b.invoke(objNewInstance, Float.valueOf(f));
                return (jk1) vh.e(c.invoke(objNewInstance, new Object[0]));
            }

            public static ac6.a b() throws Exception {
                c();
                return (ac6.a) vh.e(e.invoke(d.newInstance(new Object[0]), new Object[0]));
            }

            public static void c() throws Exception {
                if (f1710a == null || b == null || c == null) {
                    Class<?> cls = Class.forName("com.google.android.exoplayer2.effect.ScaleAndRotateTransformation$Builder");
                    f1710a = cls.getConstructor(new Class[0]);
                    b = cls.getMethod("setRotationDegrees", Float.TYPE);
                    c = cls.getMethod("build", new Class[0]);
                }
                if (d == null || e == null) {
                    Class<?> cls2 = Class.forName("com.google.android.exoplayer2.effect.DefaultVideoFrameProcessor$Factory$Builder");
                    d = cls2.getConstructor(new Class[0]);
                    e = cls2.getMethod("build", new Class[0]);
                }
            }
        }

        public d(fc6 fc6Var, bg3 bg3Var) {
            this.f1708a = fc6Var;
            this.b = bg3Var;
        }

        public MediaFormat a(MediaFormat mediaFormat) {
            if (g86.f17680a >= 29 && this.b.L0.getApplicationContext().getApplicationInfo().targetSdkVersion >= 29) {
                mediaFormat.setInteger("allow-frame-drop", 0);
            }
            return mediaFormat;
        }

        public void b() {
            ((ac6) vh.e(this.f)).a(null);
            this.j = null;
        }

        public void c() {
            vh.i(this.f);
            this.f.flush();
            this.c.clear();
            this.e.removeCallbacksAndMessages(null);
            if (this.m) {
                this.m = false;
                this.n = false;
                this.o = false;
            }
        }

        public long d(long j, long j2) {
            vh.g(this.s != -9223372036854775807L);
            return (j + j2) - this.s;
        }

        public Surface e() {
            return ((ac6) vh.e(this.f)).getInputSurface();
        }

        public boolean f() {
            return this.f != null;
        }

        public boolean g() {
            Pair<Surface, ne5> pair = this.j;
            return pair == null || !((ne5) pair.second).equals(ne5.c);
        }

        public boolean h(m mVar, long j) throws ExoPlaybackException {
            int i;
            vh.g(!f());
            if (!this.l) {
                return false;
            }
            if (this.g == null) {
                this.l = false;
                return false;
            }
            this.e = g86.w();
            Pair<xg0, xg0> pairW1 = this.b.w1(mVar.x);
            try {
                if (!bg3.q1() && (i = mVar.t) != 0) {
                    this.g.add(0, b.a(i));
                }
                ac6.a aVarB = b.b();
                Context context = this.b.L0;
                List<jk1> list = (List) vh.e(this.g);
                vv0 vv0Var = vv0.f21536a;
                xg0 xg0Var = (xg0) pairW1.first;
                xg0 xg0Var2 = (xg0) pairW1.second;
                Handler handler = this.e;
                Objects.requireNonNull(handler);
                ac6 ac6VarA = aVarB.a(context, list, vv0Var, xg0Var, xg0Var2, false, new bl0(handler), new a(mVar));
                this.f = ac6VarA;
                ac6VarA.b(1);
                this.s = j;
                Pair<Surface, ne5> pair = this.j;
                if (pair != null) {
                    ne5 ne5Var = (ne5) pair.second;
                    this.f.a(new bp5((Surface) pair.first, ne5Var.b(), ne5Var.a()));
                }
                o(mVar);
                return true;
            } catch (Exception e) {
                throw this.b.g(e, mVar, 7000);
            }
        }

        public boolean i(m mVar, long j, boolean z) {
            vh.i(this.f);
            vh.g(this.k != -1);
            if (this.f.getPendingInputFrameCount() >= this.k) {
                return false;
            }
            this.f.registerInputFrame();
            Pair<Long, m> pair = this.i;
            if (pair == null) {
                this.i = Pair.create(Long.valueOf(j), mVar);
            } else if (!g86.c(mVar, pair.second)) {
                this.d.add(Pair.create(Long.valueOf(j), mVar));
            }
            if (z) {
                this.m = true;
                this.p = j;
            }
            return true;
        }

        public void j(String str) {
            this.k = g86.a0(this.b.L0, str, false);
        }

        public final void k(long j, boolean z) {
            vh.i(this.f);
            this.f.renderOutputFrame(j);
            this.c.remove();
            this.b.j1 = SystemClock.elapsedRealtime() * 1000;
            if (j != -2) {
                this.b.I1();
            }
            if (z) {
                this.o = true;
            }
        }

        public void l(long j, long j2) {
            vh.i(this.f);
            while (!this.c.isEmpty()) {
                boolean z = false;
                boolean z2 = this.b.getState() == 2;
                long jLongValue = ((Long) vh.e(this.c.peek())).longValue();
                long j3 = jLongValue + this.s;
                long jN1 = this.b.n1(j, j2, SystemClock.elapsedRealtime() * 1000, j3, z2);
                if (this.n && this.c.size() == 1) {
                    z = true;
                }
                if (this.b.a2(j, jN1)) {
                    k(-1L, z);
                    return;
                }
                if (!z2 || j == this.b.c1 || jN1 > DefaultAudioSink.MIN_AUDIO_UNDERRUN_OFFSET_US) {
                    return;
                }
                this.f1708a.h(j3);
                long jB = this.f1708a.b(System.nanoTime() + (jN1 * 1000));
                if (this.b.Z1((jB - System.nanoTime()) / 1000, j2, z)) {
                    k(-2L, z);
                } else {
                    if (!this.d.isEmpty() && j3 > ((Long) this.d.peek().first).longValue()) {
                        this.i = this.d.remove();
                    }
                    this.b.N1(jLongValue, jB, (m) this.i.second);
                    if (this.r >= j3) {
                        this.r = -9223372036854775807L;
                        this.b.K1(this.q);
                    }
                    k(jB, z);
                }
            }
        }

        public boolean m() {
            return this.o;
        }

        public void n() {
            ((ac6) vh.e(this.f)).release();
            this.f = null;
            Handler handler = this.e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            CopyOnWriteArrayList<jk1> copyOnWriteArrayList = this.g;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.clear();
            }
            this.c.clear();
            this.l = true;
        }

        public void o(m mVar) {
            ((ac6) vh.e(this.f)).c(new c32.b(mVar.q, mVar.r).b(mVar.u).a());
            this.h = mVar;
            if (this.m) {
                this.m = false;
                this.n = false;
                this.o = false;
            }
        }

        public void p(Surface surface, ne5 ne5Var) {
            Pair<Surface, ne5> pair = this.j;
            if (pair != null && ((Surface) pair.first).equals(surface) && ((ne5) this.j.second).equals(ne5Var)) {
                return;
            }
            this.j = Pair.create(surface, ne5Var);
            if (f()) {
                ((ac6) vh.e(this.f)).a(new bp5(surface, ne5Var.b(), ne5Var.a()));
            }
        }

        public void q(List<jk1> list) {
            CopyOnWriteArrayList<jk1> copyOnWriteArrayList = this.g;
            if (copyOnWriteArrayList == null) {
                this.g = new CopyOnWriteArrayList<>(list);
            } else {
                copyOnWriteArrayList.clear();
                this.g.addAll(list);
            }
        }
    }

    public bg3(Context context, c.b bVar, e eVar, long j, boolean z, @Nullable Handler handler, @Nullable oe6 oe6Var, int i) {
        this(context, bVar, eVar, j, z, handler, oe6Var, i, 30.0f);
    }

    public static List<com.google.android.exoplayer2.mediacodec.d> A1(Context context, e eVar, m mVar, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        String str = mVar.l;
        if (str == null) {
            return ImmutableList.of();
        }
        if (g86.f17680a >= 26 && "video/dolby-vision".equals(str) && !a.a(context)) {
            List<com.google.android.exoplayer2.mediacodec.d> listN = MediaCodecUtil.n(eVar, mVar, z, z2);
            if (!listN.isEmpty()) {
                return listN;
            }
        }
        return MediaCodecUtil.v(eVar, mVar, z, z2);
    }

    public static int B1(com.google.android.exoplayer2.mediacodec.d dVar, m mVar) {
        if (mVar.m == -1) {
            return x1(dVar, mVar);
        }
        int size = mVar.n.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += mVar.n.get(i).length;
        }
        return mVar.m + length;
    }

    public static int C1(int i, int i2) {
        return (i * 3) / (i2 * 2);
    }

    public static boolean E1(long j) {
        return j < -30000;
    }

    public static boolean F1(long j) {
        return j < -500000;
    }

    @RequiresApi(29)
    public static void U1(com.google.android.exoplayer2.mediacodec.c cVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray(IMediaFormat.KEY_HDR10_PLUS_INFO, bArr);
        cVar.setParameters(bundle);
    }

    public static boolean q1() {
        return g86.f17680a >= 21;
    }

    @RequiresApi(21)
    public static void s1(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger(IMediaFormat.KEY_AUDIO_SESSION_ID, i);
    }

    public static boolean t1() {
        return "NVIDIA".equals(g86.c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean v1() {
        String str;
        int i = g86.f17680a;
        byte b2 = 7;
        if (i <= 28) {
            String str2 = g86.b;
            str2.hashCode();
            switch (str2) {
            }
            return true;
        }
        if (i <= 27 && "HWEML".equals(g86.b)) {
            return true;
        }
        str = g86.d;
        str.hashCode();
        switch (str) {
            case "AFTJMST12":
            case "AFTKMST12":
            case "AFTA":
            case "AFTN":
            case "AFTR":
            case "AFTEU011":
            case "AFTEU014":
            case "AFTSO001":
            case "AFTEUFF014":
                break;
            default:
                if (i <= 26) {
                    String str3 = g86.b;
                    str3.hashCode();
                    switch (str3.hashCode()) {
                        case -2144781245:
                            b2 = !str3.equals("GIONEE_SWW1609") ? (byte) -1 : (byte) 0;
                            break;
                        case -2144781185:
                            if (str3.equals("GIONEE_SWW1627")) {
                                b2 = 1;
                                break;
                            }
                            break;
                        case -2144781160:
                            if (str3.equals("GIONEE_SWW1631")) {
                                b2 = 2;
                                break;
                            }
                            break;
                        case -2097309513:
                            if (str3.equals("K50a40")) {
                                b2 = 3;
                                break;
                            }
                            break;
                        case -2022874474:
                            if (str3.equals("CP8676_I02")) {
                                b2 = 4;
                                break;
                            }
                            break;
                        case -1978993182:
                            if (str3.equals("NX541J")) {
                                b2 = 5;
                                break;
                            }
                            break;
                        case -1978990237:
                            if (str3.equals("NX573J")) {
                                b2 = 6;
                                break;
                            }
                            break;
                        case -1936688988:
                            if (!str3.equals("PGN528")) {
                            }
                            break;
                        case -1936688066:
                            if (str3.equals("PGN610")) {
                                b2 = 8;
                                break;
                            }
                            break;
                        case -1936688065:
                            if (str3.equals("PGN611")) {
                                b2 = 9;
                                break;
                            }
                            break;
                        case -1931988508:
                            if (str3.equals("AquaPowerM")) {
                                b2 = 10;
                                break;
                            }
                            break;
                        case -1885099851:
                            if (str3.equals("RAIJIN")) {
                                b2 = 11;
                                break;
                            }
                            break;
                        case -1696512866:
                            if (str3.equals("XT1663")) {
                                b2 = 12;
                                break;
                            }
                            break;
                        case -1680025915:
                            if (str3.equals("ComioS1")) {
                                b2 = dn.k;
                                break;
                            }
                            break;
                        case -1615810839:
                            if (str3.equals("Phantom6")) {
                                b2 = dn.l;
                                break;
                            }
                            break;
                        case -1600724499:
                            if (str3.equals("pacificrim")) {
                                b2 = 15;
                                break;
                            }
                            break;
                        case -1554255044:
                            if (str3.equals("vernee_M5")) {
                                b2 = 16;
                                break;
                            }
                            break;
                        case -1481772737:
                            if (str3.equals("panell_dl")) {
                                b2 = 17;
                                break;
                            }
                            break;
                        case -1481772730:
                            if (str3.equals("panell_ds")) {
                                b2 = 18;
                                break;
                            }
                            break;
                        case -1481772729:
                            if (str3.equals("panell_dt")) {
                                b2 = 19;
                                break;
                            }
                            break;
                        case -1320080169:
                            if (str3.equals("GiONEE_GBL7319")) {
                                b2 = 20;
                                break;
                            }
                            break;
                        case -1217592143:
                            if (str3.equals("BRAVIA_ATV2")) {
                                b2 = 21;
                                break;
                            }
                            break;
                        case -1180384755:
                            if (str3.equals("iris60")) {
                                b2 = 22;
                                break;
                            }
                            break;
                        case -1139198265:
                            if (str3.equals("Slate_Pro")) {
                                b2 = 23;
                                break;
                            }
                            break;
                        case -1052835013:
                            if (str3.equals("namath")) {
                                b2 = 24;
                                break;
                            }
                            break;
                        case -993250464:
                            if (str3.equals("A10-70F")) {
                                b2 = 25;
                                break;
                            }
                            break;
                        case -993250458:
                            if (str3.equals("A10-70L")) {
                                b2 = 26;
                                break;
                            }
                            break;
                        case -965403638:
                            if (str3.equals("s905x018")) {
                                b2 = 27;
                                break;
                            }
                            break;
                        case -958336948:
                            if (str3.equals("ELUGA_Ray_X")) {
                                b2 = 28;
                                break;
                            }
                            break;
                        case -879245230:
                            if (str3.equals("tcl_eu")) {
                                b2 = 29;
                                break;
                            }
                            break;
                        case -842500323:
                            if (str3.equals("nicklaus_f")) {
                                b2 = 30;
                                break;
                            }
                            break;
                        case -821392978:
                            if (str3.equals("A7000-a")) {
                                b2 = TELogUtils.DEBUG_LEVEL_V;
                                break;
                            }
                            break;
                        case -797483286:
                            if (str3.equals("SVP-DTV15")) {
                                b2 = 32;
                                break;
                            }
                            break;
                        case -794946968:
                            if (str3.equals("watson")) {
                                b2 = 33;
                                break;
                            }
                            break;
                        case -788334647:
                            if (str3.equals("whyred")) {
                                b2 = 34;
                                break;
                            }
                            break;
                        case -782144577:
                            if (str3.equals("OnePlus5T")) {
                                b2 = 35;
                                break;
                            }
                            break;
                        case -575125681:
                            if (str3.equals("GiONEE_CBL7513")) {
                                b2 = 36;
                                break;
                            }
                            break;
                        case -521118391:
                            if (str3.equals("GIONEE_GBL7360")) {
                                b2 = 37;
                                break;
                            }
                            break;
                        case -430914369:
                            if (str3.equals("Pixi4-7_3G")) {
                                b2 = 38;
                                break;
                            }
                            break;
                        case -290434366:
                            if (str3.equals("taido_row")) {
                                b2 = 39;
                                break;
                            }
                            break;
                        case -282781963:
                            if (str3.equals("BLACK-1X")) {
                                b2 = 40;
                                break;
                            }
                            break;
                        case -277133239:
                            if (str3.equals("Z12_PRO")) {
                                b2 = 41;
                                break;
                            }
                            break;
                        case -173639913:
                            if (str3.equals("ELUGA_A3_Pro")) {
                                b2 = 42;
                                break;
                            }
                            break;
                        case -56598463:
                            if (str3.equals("woods_fn")) {
                                b2 = 43;
                                break;
                            }
                            break;
                        case 2126:
                            if (str3.equals("C1")) {
                                b2 = 44;
                                break;
                            }
                            break;
                        case 2564:
                            if (str3.equals("Q5")) {
                                b2 = 45;
                                break;
                            }
                            break;
                        case 2715:
                            if (str3.equals(g.e)) {
                                b2 = 46;
                                break;
                            }
                            break;
                        case 2719:
                            if (str3.equals("V5")) {
                                b2 = 47;
                                break;
                            }
                            break;
                        case 3091:
                            if (str3.equals("b5")) {
                                b2 = 48;
                                break;
                            }
                            break;
                        case 3483:
                            if (str3.equals("mh")) {
                                b2 = 49;
                                break;
                            }
                            break;
                        case 73405:
                            if (str3.equals("JGZ")) {
                                b2 = 50;
                                break;
                            }
                            break;
                        case 75537:
                            if (str3.equals("M04")) {
                                b2 = 51;
                                break;
                            }
                            break;
                        case 75739:
                            if (str3.equals("M5c")) {
                                b2 = 52;
                                break;
                            }
                            break;
                        case 76779:
                            if (str3.equals("MX6")) {
                                b2 = 53;
                                break;
                            }
                            break;
                        case 78669:
                            if (str3.equals("P85")) {
                                b2 = 54;
                                break;
                            }
                            break;
                        case 79305:
                            if (str3.equals("PLE")) {
                                b2 = 55;
                                break;
                            }
                            break;
                        case 80618:
                            if (str3.equals("QX1")) {
                                b2 = 56;
                                break;
                            }
                            break;
                        case 88274:
                            if (str3.equals("Z80")) {
                                b2 = 57;
                                break;
                            }
                            break;
                        case 98846:
                            if (str3.equals("cv1")) {
                                b2 = 58;
                                break;
                            }
                            break;
                        case 98848:
                            if (str3.equals("cv3")) {
                                b2 = 59;
                                break;
                            }
                            break;
                        case 99329:
                            if (str3.equals("deb")) {
                                b2 = 60;
                                break;
                            }
                            break;
                        case 101481:
                            if (str3.equals("flo")) {
                                b2 = Base64.padSymbol;
                                break;
                            }
                            break;
                        case 1513190:
                            if (str3.equals("1601")) {
                                b2 = 62;
                                break;
                            }
                            break;
                        case 1514184:
                            if (str3.equals("1713")) {
                                b2 = Utf8.REPLACEMENT_BYTE;
                                break;
                            }
                            break;
                        case 1514185:
                            if (str3.equals("1714")) {
                                b2 = 64;
                                break;
                            }
                            break;
                        case 2133089:
                            if (str3.equals("F01H")) {
                                b2 = 65;
                                break;
                            }
                            break;
                        case 2133091:
                            if (str3.equals("F01J")) {
                                b2 = 66;
                                break;
                            }
                            break;
                        case 2133120:
                            if (str3.equals("F02H")) {
                                b2 = 67;
                                break;
                            }
                            break;
                        case 2133151:
                            if (str3.equals("F03H")) {
                                b2 = 68;
                                break;
                            }
                            break;
                        case 2133182:
                            if (str3.equals("F04H")) {
                                b2 = 69;
                                break;
                            }
                            break;
                        case 2133184:
                            if (str3.equals("F04J")) {
                                b2 = 70;
                                break;
                            }
                            break;
                        case 2436959:
                            if (str3.equals("P681")) {
                                b2 = 71;
                                break;
                            }
                            break;
                        case 2463773:
                            if (str3.equals("Q350")) {
                                b2 = 72;
                                break;
                            }
                            break;
                        case 2464648:
                            if (str3.equals("Q427")) {
                                b2 = 73;
                                break;
                            }
                            break;
                        case 2689555:
                            if (str3.equals("XE2X")) {
                                b2 = 74;
                                break;
                            }
                            break;
                        case 3154429:
                            if (str3.equals("fugu")) {
                                b2 = 75;
                                break;
                            }
                            break;
                        case 3284551:
                            if (str3.equals("kate")) {
                                b2 = 76;
                                break;
                            }
                            break;
                        case 3351335:
                            if (str3.equals("mido")) {
                                b2 = 77;
                                break;
                            }
                            break;
                        case 3386211:
                            if (str3.equals("p212")) {
                                b2 = 78;
                                break;
                            }
                            break;
                        case 41325051:
                            if (str3.equals("MEIZU_M5")) {
                                b2 = 79;
                                break;
                            }
                            break;
                        case 51349633:
                            if (str3.equals("601LV")) {
                                b2 = 80;
                                break;
                            }
                            break;
                        case 51350594:
                            if (str3.equals("602LV")) {
                                b2 = 81;
                                break;
                            }
                            break;
                        case 55178625:
                            if (str3.equals("Aura_Note_2")) {
                                b2 = 82;
                                break;
                            }
                            break;
                        case 61542055:
                            if (str3.equals("A1601")) {
                                b2 = 83;
                                break;
                            }
                            break;
                        case 65355429:
                            if (str3.equals("E5643")) {
                                b2 = 84;
                                break;
                            }
                            break;
                        case 66214468:
                            if (str3.equals("F3111")) {
                                b2 = 85;
                                break;
                            }
                            break;
                        case 66214470:
                            if (str3.equals("F3113")) {
                                b2 = 86;
                                break;
                            }
                            break;
                        case 66214473:
                            if (str3.equals("F3116")) {
                                b2 = 87;
                                break;
                            }
                            break;
                        case 66215429:
                            if (str3.equals("F3211")) {
                                b2 = 88;
                                break;
                            }
                            break;
                        case 66215431:
                            if (str3.equals("F3213")) {
                                b2 = 89;
                                break;
                            }
                            break;
                        case 66215433:
                            if (str3.equals("F3215")) {
                                b2 = 90;
                                break;
                            }
                            break;
                        case 66216390:
                            if (str3.equals("F3311")) {
                                b2 = 91;
                                break;
                            }
                            break;
                        case 76402249:
                            if (str3.equals("PRO7S")) {
                                b2 = 92;
                                break;
                            }
                            break;
                        case 76404105:
                            if (str3.equals("Q4260")) {
                                b2 = 93;
                                break;
                            }
                            break;
                        case 76404911:
                            if (str3.equals("Q4310")) {
                                b2 = 94;
                                break;
                            }
                            break;
                        case 80963634:
                            if (str3.equals("V23GB")) {
                                b2 = 95;
                                break;
                            }
                            break;
                        case 82882791:
                            if (str3.equals("X3_HK")) {
                                b2 = 96;
                                break;
                            }
                            break;
                        case 98715550:
                            if (str3.equals("i9031")) {
                                b2 = 97;
                                break;
                            }
                            break;
                        case 101370885:
                            if (str3.equals("l5460")) {
                                b2 = 98;
                                break;
                            }
                            break;
                        case 102844228:
                            if (str3.equals("le_x6")) {
                                b2 = 99;
                                break;
                            }
                            break;
                        case 165221241:
                            if (str3.equals("A2016a40")) {
                                b2 = 100;
                                break;
                            }
                            break;
                        case 182191441:
                            if (str3.equals("CPY83_I00")) {
                                b2 = 101;
                                break;
                            }
                            break;
                        case 245388979:
                            if (str3.equals("marino_f")) {
                                b2 = 102;
                                break;
                            }
                            break;
                        case 287431619:
                            if (str3.equals("griffin")) {
                                b2 = 103;
                                break;
                            }
                            break;
                        case 307593612:
                            if (str3.equals("A7010a48")) {
                                b2 = 104;
                                break;
                            }
                            break;
                        case 308517133:
                            if (str3.equals("A7020a48")) {
                                b2 = 105;
                                break;
                            }
                            break;
                        case 316215098:
                            if (str3.equals("TB3-730F")) {
                                b2 = 106;
                                break;
                            }
                            break;
                        case 316215116:
                            if (str3.equals("TB3-730X")) {
                                b2 = 107;
                                break;
                            }
                            break;
                        case 316246811:
                            if (str3.equals("TB3-850F")) {
                                b2 = 108;
                                break;
                            }
                            break;
                        case 316246818:
                            if (str3.equals("TB3-850M")) {
                                b2 = 109;
                                break;
                            }
                            break;
                        case 407160593:
                            if (str3.equals("Pixi5-10_4G")) {
                                b2 = 110;
                                break;
                            }
                            break;
                        case 507412548:
                            if (str3.equals("QM16XE_U")) {
                                b2 = 111;
                                break;
                            }
                            break;
                        case 793982701:
                            if (str3.equals("GIONEE_WBL5708")) {
                                b2 = 112;
                                break;
                            }
                            break;
                        case 794038622:
                            if (str3.equals("GIONEE_WBL7365")) {
                                b2 = 113;
                                break;
                            }
                            break;
                        case 794040393:
                            if (str3.equals("GIONEE_WBL7519")) {
                                b2 = 114;
                                break;
                            }
                            break;
                        case 835649806:
                            if (str3.equals("manning")) {
                                b2 = 115;
                                break;
                            }
                            break;
                        case 917340916:
                            if (str3.equals("A7000plus")) {
                                b2 = 116;
                                break;
                            }
                            break;
                        case 958008161:
                            if (str3.equals("j2xlteins")) {
                                b2 = 117;
                                break;
                            }
                            break;
                        case 1060579533:
                            if (str3.equals("panell_d")) {
                                b2 = 118;
                                break;
                            }
                            break;
                        case 1150207623:
                            if (str3.equals("LS-5017")) {
                                b2 = 119;
                                break;
                            }
                            break;
                        case 1176899427:
                            if (str3.equals("itel_S41")) {
                                b2 = 120;
                                break;
                            }
                            break;
                        case 1280332038:
                            if (str3.equals("hwALE-H")) {
                                b2 = 121;
                                break;
                            }
                            break;
                        case 1306947716:
                            if (str3.equals("EverStar_S")) {
                                b2 = 122;
                                break;
                            }
                            break;
                        case 1349174697:
                            if (str3.equals("htc_e56ml_dtul")) {
                                b2 = 123;
                                break;
                            }
                            break;
                        case 1522194893:
                            if (str3.equals("woods_f")) {
                                b2 = 124;
                                break;
                            }
                            break;
                        case 1691543273:
                            if (str3.equals("CPH1609")) {
                                b2 = 125;
                                break;
                            }
                            break;
                        case 1691544261:
                            if (str3.equals("CPH1715")) {
                                b2 = 126;
                                break;
                            }
                            break;
                        case 1709443163:
                            if (str3.equals("iball8735_9806")) {
                                b2 = ByteCompanionObject.MAX_VALUE;
                                break;
                            }
                            break;
                        case 1865889110:
                            if (str3.equals("santoni")) {
                                b2 = ByteCompanionObject.MIN_VALUE;
                                break;
                            }
                            break;
                        case 1906253259:
                            if (str3.equals("PB2-670M")) {
                                b2 = 129;
                                break;
                            }
                            break;
                        case 1977196784:
                            if (str3.equals("Infinix-X572")) {
                                b2 = 130;
                                break;
                            }
                            break;
                        case 2006372676:
                            if (str3.equals("BRAVIA_ATV3_4K")) {
                                b2 = 131;
                                break;
                            }
                            break;
                        case 2019281702:
                            if (str3.equals("DM-01K")) {
                                b2 = 132;
                                break;
                            }
                            break;
                        case 2029784656:
                            if (str3.equals("HWBLN-H")) {
                                b2 = 133;
                                break;
                            }
                            break;
                        case 2030379515:
                            if (str3.equals("HWCAM-H")) {
                                b2 = 134;
                                break;
                            }
                            break;
                        case 2033393791:
                            if (str3.equals("ASUS_X00AD_2")) {
                                b2 = 135;
                                break;
                            }
                            break;
                        case 2047190025:
                            if (str3.equals("ELUGA_Note")) {
                                b2 = 136;
                                break;
                            }
                            break;
                        case 2047252157:
                            if (str3.equals("ELUGA_Prim")) {
                                b2 = 137;
                                break;
                            }
                            break;
                        case 2048319463:
                            if (str3.equals("HWVNS-H")) {
                                b2 = 138;
                                break;
                            }
                            break;
                        case 2048855701:
                            if (str3.equals("HWWAS-H")) {
                                b2 = 139;
                                break;
                            }
                            break;
                    }
                    switch (b2) {
                        default:
                            str.hashCode();
                            if (!str.equals("JSN-L21")) {
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        case 82:
                        case 83:
                        case 84:
                        case 85:
                        case 86:
                        case 87:
                        case 88:
                        case 89:
                        case 90:
                        case 91:
                        case 92:
                        case 93:
                        case 94:
                        case 95:
                        case 96:
                        case 97:
                        case 98:
                        case 99:
                        case 100:
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                        case 105:
                        case 106:
                        case 107:
                        case 108:
                        case 109:
                        case 110:
                        case 111:
                        case 112:
                        case 113:
                        case 114:
                        case 115:
                        case 116:
                        case 117:
                        case 118:
                        case 119:
                        case 120:
                        case 121:
                        case 122:
                        case 123:
                        case 124:
                        case 125:
                        case 126:
                        case 127:
                        case 128:
                        case 129:
                        case 130:
                        case 131:
                        case MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA /* 132 */:
                        case MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START /* 133 */:
                        case 134:
                        case 135:
                        case 136:
                        case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME /* 137 */:
                        case 138:
                        case 139:
                            return true;
                    }
                }
                break;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int x1(com.google.android.exoplayer2.mediacodec.d dVar, m mVar) {
        int iIntValue;
        int i = mVar.q;
        int i2 = mVar.r;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        String str = mVar.l;
        if ("video/dolby-vision".equals(str)) {
            Pair<Integer, Integer> pairR = MediaCodecUtil.r(mVar);
            str = (pairR == null || !((iIntValue = ((Integer) pairR.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? "video/hevc" : "video/avc";
        }
        str.hashCode();
        switch (str) {
            case "video/3gpp":
            case "video/av01":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                return C1(i * i2, 2);
            case "video/hevc":
                return Math.max(2097152, C1(i * i2, 2));
            case "video/avc":
                String str2 = g86.d;
                if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(g86.c) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && dVar.g)))) {
                    return -1;
                }
                return C1(g86.l(i, 16) * g86.l(i2, 16) * 16 * 16, 2);
            case "video/x-vnd.on2.vp9":
                return C1(i * i2, 4);
            default:
                return -1;
        }
    }

    @Nullable
    public static Point y1(com.google.android.exoplayer2.mediacodec.d dVar, m mVar) {
        int i = mVar.r;
        int i2 = mVar.q;
        boolean z = i > i2;
        int i3 = z ? i : i2;
        if (z) {
            i = i2;
        }
        float f = i / i3;
        for (int i4 : t1) {
            int i5 = (int) (i4 * f);
            if (i4 <= i3 || i5 <= i) {
                break;
            }
            if (g86.f17680a >= 21) {
                int i6 = z ? i5 : i4;
                if (!z) {
                    i4 = i5;
                }
                Point pointC = dVar.c(i6, i4);
                if (dVar.w(pointC.x, pointC.y, mVar.s)) {
                    return pointC;
                }
            } else {
                try {
                    int iL = g86.l(i4, 16) * 16;
                    int iL2 = g86.l(i5, 16) * 16;
                    if (iL * iL2 <= MediaCodecUtil.P()) {
                        int i7 = z ? iL2 : iL;
                        if (!z) {
                            iL = iL2;
                        }
                        return new Point(i7, iL);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void A0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z = this.p1;
        if (!z) {
            this.h1++;
        }
        if (g86.f17680a >= 23 || !z) {
            return;
        }
        O1(decoderInputBuffer.e);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void B0(m mVar) throws ExoPlaybackException {
        if (this.O0.f()) {
            return;
        }
        this.O0.h(mVar, f0());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public ow0 C(com.google.android.exoplayer2.mediacodec.d dVar, m mVar, m mVar2) {
        ow0 ow0VarF = dVar.f(mVar, mVar2);
        int i = ow0VarF.e;
        int i2 = mVar2.q;
        b bVar = this.S0;
        if (i2 > bVar.f1706a || mVar2.r > bVar.b) {
            i |= 256;
        }
        if (B1(dVar, mVar2) > this.S0.c) {
            i |= 64;
        }
        int i3 = i;
        return new ow0(dVar.f5902a, mVar, mVar2, i3 != 0 ? 0 : ow0VarF.d, i3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean D0(long j, long j2, @Nullable com.google.android.exoplayer2.mediacodec.c cVar, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, m mVar) throws ExoPlaybackException {
        vh.e(cVar);
        if (this.c1 == -9223372036854775807L) {
            this.c1 = j;
        }
        if (j3 != this.i1) {
            if (!this.O0.f()) {
                this.M0.h(j3);
            }
            this.i1 = j3;
        }
        long jF0 = j3 - f0();
        if (z && !z2) {
            d2(cVar, i, jF0);
            return true;
        }
        boolean z3 = false;
        boolean z4 = getState() == 2;
        long jN1 = n1(j, j2, SystemClock.elapsedRealtime() * 1000, j3, z4);
        if (this.V0 == this.W0) {
            if (!E1(jN1)) {
                return false;
            }
            d2(cVar, i, jF0);
            f2(jN1);
            return true;
        }
        if (a2(j, jN1)) {
            if (!this.O0.f()) {
                z3 = true;
            } else if (!this.O0.i(mVar, jF0, z2)) {
                return false;
            }
            S1(cVar, mVar, i, jF0, z3);
            f2(jN1);
            return true;
        }
        if (z4 && j != this.c1) {
            long jNanoTime = System.nanoTime();
            long jB = this.M0.b((jN1 * 1000) + jNanoTime);
            if (!this.O0.f()) {
                jN1 = (jB - jNanoTime) / 1000;
            }
            boolean z5 = this.d1 != -9223372036854775807L;
            if (Y1(jN1, j2, z2) && G1(j, z5)) {
                return false;
            }
            if (Z1(jN1, j2, z2)) {
                if (z5) {
                    d2(cVar, i, jF0);
                } else {
                    u1(cVar, i, jF0);
                }
                f2(jN1);
                return true;
            }
            if (this.O0.f()) {
                this.O0.l(j, j2);
                if (!this.O0.i(mVar, jF0, z2)) {
                    return false;
                }
                S1(cVar, mVar, i, jF0, false);
                return true;
            }
            if (g86.f17680a >= 21) {
                if (jN1 < DefaultAudioSink.MIN_AUDIO_UNDERRUN_OFFSET_US) {
                    if (jB == this.m1) {
                        d2(cVar, i, jF0);
                    } else {
                        N1(jF0, jB, mVar);
                        T1(cVar, i, jF0, jB);
                    }
                    f2(jN1);
                    this.m1 = jB;
                    return true;
                }
            } else if (jN1 < 30000) {
                if (jN1 > 11000) {
                    try {
                        Thread.sleep((jN1 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                N1(jF0, jB, mVar);
                R1(cVar, i, jF0);
                f2(jN1);
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    public MediaFormat D1(m mVar, String str, b bVar, float f, boolean z, int i) {
        Pair<Integer, Integer> pairR;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, str);
        mediaFormat.setInteger("width", mVar.q);
        mediaFormat.setInteger("height", mVar.r);
        vg3.e(mediaFormat, mVar.n);
        vg3.c(mediaFormat, IMediaFormat.KEY_FRAME_RATE, mVar.s);
        vg3.d(mediaFormat, IMediaFormat.KEY_ROTATION, mVar.t);
        vg3.b(mediaFormat, mVar.x);
        if ("video/dolby-vision".equals(mVar.l) && (pairR = MediaCodecUtil.r(mVar)) != null) {
            vg3.d(mediaFormat, IMediaFormat.KEY_PROFILE, ((Integer) pairR.first).intValue());
        }
        mediaFormat.setInteger(IMediaFormat.KEY_MAX_WIDTH, bVar.f1706a);
        mediaFormat.setInteger(IMediaFormat.KEY_MAX_HEIGHT, bVar.b);
        vg3.d(mediaFormat, IMediaFormat.KEY_MAX_INPUT_SIZE, bVar.c);
        if (g86.f17680a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat(IMediaFormat.KEY_OPERATING_RATE, f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            s1(mediaFormat, i);
        }
        return mediaFormat;
    }

    public boolean G1(long j, boolean z) throws ExoPlaybackException {
        int iZ = z(j);
        if (iZ == 0) {
            return false;
        }
        if (z) {
            lw0 lw0Var = this.G0;
            lw0Var.d += iZ;
            lw0Var.f += this.h1;
        } else {
            this.G0.j++;
            e2(iZ, this.h1);
        }
        V();
        if (this.O0.f()) {
            this.O0.c();
        }
        return true;
    }

    public final void H1() {
        if (this.f1 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.N0.n(this.f1, jElapsedRealtime - this.e1);
            this.f1 = 0;
            this.e1 = jElapsedRealtime;
        }
    }

    public void I1() {
        this.b1 = true;
        if (this.Z0) {
            return;
        }
        this.Z0 = true;
        this.N0.A(this.V0);
        this.X0 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void J0() {
        super.J0();
        this.h1 = 0;
    }

    public final void J1() {
        int i = this.l1;
        if (i != 0) {
            this.N0.B(this.k1, i);
            this.k1 = 0L;
            this.l1 = 0;
        }
    }

    public final void K1(te6 te6Var) {
        if (te6Var.equals(te6.e) || te6Var.equals(this.o1)) {
            return;
        }
        this.o1 = te6Var;
        this.N0.D(te6Var);
    }

    public final void L1() {
        if (this.X0) {
            this.N0.A(this.V0);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecDecoderException M(Throwable th, @Nullable com.google.android.exoplayer2.mediacodec.d dVar) {
        return new MediaCodecVideoDecoderException(th, dVar, this.V0);
    }

    public final void M1() {
        te6 te6Var = this.o1;
        if (te6Var != null) {
            this.N0.D(te6Var);
        }
    }

    public final void N1(long j, long j2, m mVar) {
        yb6 yb6Var = this.s1;
        if (yb6Var != null) {
            yb6Var.a(j, j2, mVar, c0());
        }
    }

    public void O1(long j) throws ExoPlaybackException {
        a1(j);
        K1(this.n1);
        this.G0.e++;
        I1();
        y0(j);
    }

    public final void P1() {
        P0();
    }

    @RequiresApi(17)
    public final void Q1() {
        Surface surface = this.V0;
        PlaceholderSurface placeholderSurface = this.W0;
        if (surface == placeholderSurface) {
            this.V0 = null;
        }
        placeholderSurface.release();
        this.W0 = null;
    }

    public void R1(com.google.android.exoplayer2.mediacodec.c cVar, int i, long j) {
        hz5.a("releaseOutputBuffer");
        cVar.releaseOutputBuffer(i, true);
        hz5.c();
        this.G0.e++;
        this.g1 = 0;
        if (this.O0.f()) {
            return;
        }
        this.j1 = SystemClock.elapsedRealtime() * 1000;
        K1(this.n1);
        I1();
    }

    public final void S1(com.google.android.exoplayer2.mediacodec.c cVar, m mVar, int i, long j, boolean z) {
        long jD = this.O0.f() ? this.O0.d(j, f0()) * 1000 : System.nanoTime();
        if (z) {
            N1(j, jD, mVar);
        }
        if (g86.f17680a >= 21) {
            T1(cVar, i, j, jD);
        } else {
            R1(cVar, i, j);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean T0(com.google.android.exoplayer2.mediacodec.d dVar) {
        return this.V0 != null || c2(dVar);
    }

    @RequiresApi(21)
    public void T1(com.google.android.exoplayer2.mediacodec.c cVar, int i, long j, long j2) {
        hz5.a("releaseOutputBuffer");
        cVar.releaseOutputBuffer(i, j2);
        hz5.c();
        this.G0.e++;
        this.g1 = 0;
        if (this.O0.f()) {
            return;
        }
        this.j1 = SystemClock.elapsedRealtime() * 1000;
        K1(this.n1);
        I1();
    }

    public final void V1() {
        this.d1 = this.P0 > 0 ? SystemClock.elapsedRealtime() + this.P0 : -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int W0(e eVar, m mVar) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        int i = 0;
        if (!fp3.s(mVar.l)) {
            return qv4.a(0);
        }
        boolean z2 = mVar.o != null;
        List<com.google.android.exoplayer2.mediacodec.d> listA1 = A1(this.L0, eVar, mVar, z2, false);
        if (z2 && listA1.isEmpty()) {
            listA1 = A1(this.L0, eVar, mVar, false, false);
        }
        if (listA1.isEmpty()) {
            return qv4.a(1);
        }
        if (!MediaCodecRenderer.X0(mVar)) {
            return qv4.a(2);
        }
        com.google.android.exoplayer2.mediacodec.d dVar = listA1.get(0);
        boolean zO = dVar.o(mVar);
        if (zO) {
            z = true;
        } else {
            for (int i2 = 1; i2 < listA1.size(); i2++) {
                com.google.android.exoplayer2.mediacodec.d dVar2 = listA1.get(i2);
                if (dVar2.o(mVar)) {
                    dVar = dVar2;
                    z = false;
                    zO = true;
                    break;
                }
            }
            z = true;
        }
        int i3 = zO ? 4 : 3;
        int i4 = dVar.r(mVar) ? 16 : 8;
        int i5 = dVar.h ? 64 : 0;
        int i6 = z ? 128 : 0;
        if (g86.f17680a >= 26 && "video/dolby-vision".equals(mVar.l) && !a.a(this.L0)) {
            i6 = 256;
        }
        if (zO) {
            List<com.google.android.exoplayer2.mediacodec.d> listA12 = A1(this.L0, eVar, mVar, z2, true);
            if (!listA12.isEmpty()) {
                com.google.android.exoplayer2.mediacodec.d dVar3 = MediaCodecUtil.w(listA12, mVar).get(0);
                if (dVar3.o(mVar) && dVar3.r(mVar)) {
                    i = 32;
                }
            }
        }
        return qv4.c(i3, i4, i, i5, i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [fc6] */
    /* JADX WARN: Type inference failed for: r0v8, types: [bg3$d] */
    /* JADX WARN: Type inference failed for: r4v0, types: [bg3, com.google.android.exoplayer2.e, com.google.android.exoplayer2.mediacodec.MediaCodecRenderer] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.android.exoplayer2.video.PlaceholderSurface] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final void W1(@Nullable Object obj) throws ExoPlaybackException {
        ?? NewInstanceV17 = obj instanceof Surface ? (Surface) obj : 0;
        if (NewInstanceV17 == 0) {
            PlaceholderSurface placeholderSurface = this.W0;
            if (placeholderSurface != null) {
                NewInstanceV17 = placeholderSurface;
            } else {
                com.google.android.exoplayer2.mediacodec.d dVarZ = Z();
                if (dVarZ != null && c2(dVarZ)) {
                    NewInstanceV17 = PlaceholderSurface.newInstanceV17(this.L0, dVarZ.g);
                    this.W0 = NewInstanceV17;
                }
            }
        }
        if (this.V0 == NewInstanceV17) {
            if (NewInstanceV17 == 0 || NewInstanceV17 == this.W0) {
                return;
            }
            M1();
            L1();
            return;
        }
        this.V0 = NewInstanceV17;
        this.M0.m(NewInstanceV17);
        this.X0 = false;
        int state = getState();
        com.google.android.exoplayer2.mediacodec.c cVarY = Y();
        if (cVarY != null && !this.O0.f()) {
            if (g86.f17680a < 23 || NewInstanceV17 == 0 || this.T0) {
                H0();
                q0();
            } else {
                X1(cVarY, NewInstanceV17);
            }
        }
        if (NewInstanceV17 == 0 || NewInstanceV17 == this.W0) {
            p1();
            o1();
            if (this.O0.f()) {
                this.O0.b();
                return;
            }
            return;
        }
        M1();
        o1();
        if (state == 2) {
            V1();
        }
        if (this.O0.f()) {
            this.O0.p(NewInstanceV17, ne5.c);
        }
    }

    @RequiresApi(23)
    public void X1(com.google.android.exoplayer2.mediacodec.c cVar, Surface surface) {
        cVar.setOutputSurface(surface);
    }

    public boolean Y1(long j, long j2, boolean z) {
        return F1(j) && !z;
    }

    public boolean Z1(long j, long j2, boolean z) {
        return E1(j) && !z;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean a0() {
        return this.p1 && g86.f17680a < 23;
    }

    public final boolean a2(long j, long j2) {
        boolean z = getState() == 2;
        boolean z2 = this.b1 ? !this.Z0 : z || this.a1;
        long jElapsedRealtime = (SystemClock.elapsedRealtime() * 1000) - this.j1;
        if (this.d1 == -9223372036854775807L && j >= f0()) {
            if (z2) {
                return true;
            }
            if (z && b2(j2, jElapsedRealtime)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float b0(float f, m mVar, m[] mVarArr) {
        float fMax = -1.0f;
        for (m mVar2 : mVarArr) {
            float f2 = mVar2.s;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f;
    }

    public boolean b2(long j, long j2) {
        return E1(j) && j2 > SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US;
    }

    public final boolean c2(com.google.android.exoplayer2.mediacodec.d dVar) {
        return g86.f17680a >= 23 && !this.p1 && !r1(dVar.f5902a) && (!dVar.g || PlaceholderSurface.isSecureSupported(this.L0));
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<com.google.android.exoplayer2.mediacodec.d> d0(e eVar, m mVar, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.w(A1(this.L0, eVar, mVar, z, this.p1), mVar);
    }

    public void d2(com.google.android.exoplayer2.mediacodec.c cVar, int i, long j) {
        hz5.a("skipVideoBuffer");
        cVar.releaseOutputBuffer(i, false);
        hz5.c();
        this.G0.f++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(17)
    public c.a e0(com.google.android.exoplayer2.mediacodec.d dVar, m mVar, @Nullable MediaCrypto mediaCrypto, float f) {
        PlaceholderSurface placeholderSurface = this.W0;
        if (placeholderSurface != null && placeholderSurface.secure != dVar.g) {
            Q1();
        }
        String str = dVar.c;
        b bVarZ1 = z1(dVar, mVar, m());
        this.S0 = bVarZ1;
        MediaFormat mediaFormatD1 = D1(mVar, str, bVarZ1, f, this.R0, this.p1 ? this.q1 : 0);
        if (this.V0 == null) {
            if (!c2(dVar)) {
                throw new IllegalStateException();
            }
            if (this.W0 == null) {
                this.W0 = PlaceholderSurface.newInstanceV17(this.L0, dVar.g);
            }
            this.V0 = this.W0;
        }
        if (this.O0.f()) {
            mediaFormatD1 = this.O0.a(mediaFormatD1);
        }
        return c.a.b(dVar, mediaFormatD1, mVar, this.O0.f() ? this.O0.e() : this.V0, mediaCrypto);
    }

    public void e2(int i, int i2) {
        lw0 lw0Var = this.G0;
        lw0Var.h += i;
        int i3 = i + i2;
        lw0Var.g += i3;
        this.f1 += i3;
        int i4 = this.g1 + i3;
        this.g1 = i4;
        lw0Var.i = Math.max(i4, lw0Var.i);
        int i5 = this.Q0;
        if (i5 <= 0 || this.f1 < i5) {
            return;
        }
        H1();
    }

    public void f2(long j) {
        this.G0.a(j);
        this.k1 += j;
        this.l1++;
    }

    @Override // com.google.android.exoplayer2.z, com.google.android.exoplayer2.a0
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(29)
    public void h0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.U0) {
            ByteBuffer byteBuffer = (ByteBuffer) vh.e(decoderInputBuffer.f);
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s == 60 && s2 == 1 && b3 == 4) {
                    if (b4 == 0 || b4 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        U1(Y(), bArr);
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.e, com.google.android.exoplayer2.w.b
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        Surface surface;
        if (i == 1) {
            W1(obj);
            return;
        }
        if (i == 7) {
            this.s1 = (yb6) obj;
            return;
        }
        if (i == 10) {
            int iIntValue = ((Integer) obj).intValue();
            if (this.q1 != iIntValue) {
                this.q1 = iIntValue;
                if (this.p1) {
                    H0();
                    return;
                }
                return;
            }
            return;
        }
        if (i == 4) {
            this.Y0 = ((Integer) obj).intValue();
            com.google.android.exoplayer2.mediacodec.c cVarY = Y();
            if (cVarY != null) {
                cVarY.setVideoScalingMode(this.Y0);
                return;
            }
            return;
        }
        if (i == 5) {
            this.M0.o(((Integer) obj).intValue());
            return;
        }
        if (i == 13) {
            this.O0.q((List) vh.e(obj));
            return;
        }
        if (i != 14) {
            super.handleMessage(i, obj);
            return;
        }
        ne5 ne5Var = (ne5) vh.e(obj);
        if (ne5Var.b() == 0 || ne5Var.a() == 0 || (surface = this.V0) == null) {
            return;
        }
        this.O0.p(surface, ne5Var);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.z
    public boolean isEnded() {
        boolean zIsEnded = super.isEnded();
        return this.O0.f() ? zIsEnded & this.O0.m() : zIsEnded;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.z
    public boolean isReady() {
        PlaceholderSurface placeholderSurface;
        if (super.isReady() && ((!this.O0.f() || this.O0.g()) && (this.Z0 || (((placeholderSurface = this.W0) != null && this.V0 == placeholderSurface) || Y() == null || this.p1)))) {
            this.d1 = -9223372036854775807L;
            return true;
        }
        if (this.d1 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.d1) {
            return true;
        }
        this.d1 = -9223372036854775807L;
        return false;
    }

    public final long n1(long j, long j2, long j3, long j4, boolean z) {
        long jG0 = (long) ((j4 - j) / ((double) g0()));
        return z ? jG0 - (j3 - j2) : jG0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void o() {
        p1();
        o1();
        this.X0 = false;
        this.r1 = null;
        try {
            super.o();
        } finally {
            this.N0.m(this.G0);
            this.N0.D(te6.e);
        }
    }

    public final void o1() {
        com.google.android.exoplayer2.mediacodec.c cVarY;
        this.Z0 = false;
        if (g86.f17680a < 23 || !this.p1 || (cVarY = Y()) == null) {
            return;
        }
        this.r1 = new c(cVarY);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void p(boolean z, boolean z2) throws ExoPlaybackException {
        super.p(z, z2);
        boolean z3 = i().f21081a;
        vh.g((z3 && this.q1 == 0) ? false : true);
        if (this.p1 != z3) {
            this.p1 = z3;
            H0();
        }
        this.N0.o(this.G0);
        this.a1 = z2;
        this.b1 = false;
    }

    public final void p1() {
        this.o1 = null;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void q(long j, boolean z) throws ExoPlaybackException {
        super.q(j, z);
        if (this.O0.f()) {
            this.O0.c();
        }
        o1();
        this.M0.j();
        this.i1 = -9223372036854775807L;
        this.c1 = -9223372036854775807L;
        this.g1 = 0;
        if (z) {
            V1();
        } else {
            this.d1 = -9223372036854775807L;
        }
    }

    public boolean r1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (bg3.class) {
            if (!u1) {
                v1 = v1();
                u1 = true;
            }
        }
        return v1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.z
    @CallSuper
    public void render(long j, long j2) throws ExoPlaybackException {
        super.render(j, j2);
        if (this.O0.f()) {
            this.O0.l(j, j2);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void s0(Exception exc) {
        y53.d("MediaCodecVideoRenderer", "Video codec error", exc);
        this.N0.C(exc);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e, com.google.android.exoplayer2.z
    public void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
        super.setPlaybackSpeed(f, f2);
        this.M0.i(f);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    @TargetApi(17)
    public void t() {
        try {
            super.t();
        } finally {
            if (this.O0.f()) {
                this.O0.n();
            }
            if (this.W0 != null) {
                Q1();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void t0(String str, c.a aVar, long j, long j2) {
        this.N0.k(str, j, j2);
        this.T0 = r1(str);
        this.U0 = ((com.google.android.exoplayer2.mediacodec.d) vh.e(Z())).p();
        if (g86.f17680a >= 23 && this.p1) {
            this.r1 = new c((com.google.android.exoplayer2.mediacodec.c) vh.e(Y()));
        }
        this.O0.j(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void u() {
        super.u();
        this.f1 = 0;
        this.e1 = SystemClock.elapsedRealtime();
        this.j1 = SystemClock.elapsedRealtime() * 1000;
        this.k1 = 0L;
        this.l1 = 0;
        this.M0.k();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void u0(String str) {
        this.N0.l(str);
    }

    public void u1(com.google.android.exoplayer2.mediacodec.c cVar, int i, long j) {
        hz5.a("dropVideoBuffer");
        cVar.releaseOutputBuffer(i, false);
        hz5.c();
        e2(0, 1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.e
    public void v() {
        this.d1 = -9223372036854775807L;
        H1();
        J1();
        this.M0.l();
        super.v();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public ow0 v0(f12 f12Var) throws ExoPlaybackException {
        ow0 ow0VarV0 = super.v0(f12Var);
        this.N0.p(f12Var.b, ow0VarV0);
        return ow0VarV0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void w0(m mVar, @Nullable MediaFormat mediaFormat) {
        int integer;
        int i;
        com.google.android.exoplayer2.mediacodec.c cVarY = Y();
        if (cVarY != null) {
            cVarY.setVideoScalingMode(this.Y0);
        }
        int i2 = 0;
        if (this.p1) {
            i = mVar.q;
            integer = mVar.r;
        } else {
            vh.e(mediaFormat);
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            int integer2 = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            integer = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
            i = integer2;
        }
        float f = mVar.u;
        if (q1()) {
            int i3 = mVar.t;
            if (i3 == 90 || i3 == 270) {
                f = 1.0f / f;
                int i4 = integer;
                integer = i;
                i = i4;
            }
        } else if (!this.O0.f()) {
            i2 = mVar.t;
        }
        this.n1 = new te6(i, integer, i2, f);
        this.M0.g(mVar.s);
        if (this.O0.f()) {
            this.O0.o(mVar.b().n0(i).S(integer).f0(i2).c0(f).G());
        }
    }

    public Pair<xg0, xg0> w1(@Nullable xg0 xg0Var) {
        if (xg0.f(xg0Var)) {
            return xg0Var.c == 7 ? Pair.create(xg0Var, xg0Var.b().d(6).a()) : Pair.create(xg0Var, xg0Var);
        }
        xg0 xg0Var2 = xg0.f;
        return Pair.create(xg0Var2, xg0Var2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void y0(long j) {
        super.y0(j);
        if (this.p1) {
            return;
        }
        this.h1--;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void z0() {
        super.z0();
        o1();
    }

    public b z1(com.google.android.exoplayer2.mediacodec.d dVar, m mVar, m[] mVarArr) {
        int iX1;
        int iMax = mVar.q;
        int iMax2 = mVar.r;
        int iB1 = B1(dVar, mVar);
        if (mVarArr.length == 1) {
            if (iB1 != -1 && (iX1 = x1(dVar, mVar)) != -1) {
                iB1 = Math.min((int) (iB1 * 1.5f), iX1);
            }
            return new b(iMax, iMax2, iB1);
        }
        int length = mVarArr.length;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            m mVarG = mVarArr[i];
            if (mVar.x != null && mVarG.x == null) {
                mVarG = mVarG.b().L(mVar.x).G();
            }
            if (dVar.f(mVar, mVarG).d != 0) {
                int i2 = mVarG.q;
                z |= i2 == -1 || mVarG.r == -1;
                iMax = Math.max(iMax, i2);
                iMax2 = Math.max(iMax2, mVarG.r);
                iB1 = Math.max(iB1, B1(dVar, mVarG));
            }
        }
        if (z) {
            y53.i("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point pointY1 = y1(dVar, mVar);
            if (pointY1 != null) {
                iMax = Math.max(iMax, pointY1.x);
                iMax2 = Math.max(iMax2, pointY1.y);
                iB1 = Math.max(iB1, x1(dVar, mVar.b().n0(iMax).S(iMax2).G()));
                y53.i("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new b(iMax, iMax2, iB1);
    }

    public bg3(Context context, c.b bVar, e eVar, long j, boolean z, @Nullable Handler handler, @Nullable oe6 oe6Var, int i, float f) {
        super(2, bVar, eVar, z, f);
        this.P0 = j;
        this.Q0 = i;
        Context applicationContext = context.getApplicationContext();
        this.L0 = applicationContext;
        fc6 fc6Var = new fc6(applicationContext);
        this.M0 = fc6Var;
        this.N0 = new oe6.a(handler, oe6Var);
        this.O0 = new d(fc6Var, this);
        this.R0 = t1();
        this.d1 = -9223372036854775807L;
        this.Y0 = 1;
        this.n1 = te6.e;
        this.q1 = 0;
        p1();
    }
}
