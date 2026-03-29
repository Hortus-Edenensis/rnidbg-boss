package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.c;
import com.google.android.exoplayer2.source.dash.d;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.g;
import defpackage.au0;
import defpackage.c41;
import defpackage.c7;
import defpackage.du0;
import defpackage.e65;
import defpackage.es;
import defpackage.f10;
import defpackage.f76;
import defpackage.g86;
import defpackage.gk0;
import defpackage.hi1;
import defpackage.jr1;
import defpackage.kh3;
import defpackage.m43;
import defpackage.m73;
import defpackage.mg4;
import defpackage.od0;
import defpackage.ov1;
import defpackage.ow4;
import defpackage.q43;
import defpackage.u06;
import defpackage.uf5;
import defpackage.vh;
import defpackage.w9;
import defpackage.y53;
import defpackage.zt0;
import j$.util.DesugarTimeZone;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class DashMediaSource extends com.google.android.exoplayer2.source.a {
    public com.google.android.exoplayer2.upstream.a A;
    public Loader B;

    @Nullable
    public u06 C;
    public IOException D;
    public Handler E;
    public p.g F;
    public Uri G;
    public Uri H;
    public zt0 I;
    public boolean J;
    public long K;
    public long L;
    public long M;
    public int N;
    public long O;
    public int P;
    public final p h;
    public final boolean i;
    public final a.InterfaceC0360a j;
    public final a.InterfaceC0354a k;
    public final gk0 l;
    public final com.google.android.exoplayer2.drm.c m;
    public final com.google.android.exoplayer2.upstream.f n;
    public final es o;
    public final long p;
    public final long q;
    public final j.a r;
    public final g.a<? extends zt0> s;
    public final e t;
    public final Object u;
    public final SparseArray<com.google.android.exoplayer2.source.dash.b> v;
    public final Runnable w;
    public final Runnable x;
    public final d.b y;
    public final q43 z;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0354a f5940a;

        @Nullable
        public final a.InterfaceC0360a b;
        public od0.a c;
        public hi1 d;
        public gk0 e;
        public com.google.android.exoplayer2.upstream.f f;
        public long g;
        public long h;

        @Nullable
        public g.a<? extends zt0> i;

        public Factory(a.InterfaceC0360a interfaceC0360a) {
            this(new c.a(interfaceC0360a), interfaceC0360a);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public DashMediaSource c(p pVar) {
            vh.e(pVar.b);
            g.a au0Var = this.i;
            if (au0Var == null) {
                au0Var = new au0();
            }
            List<StreamKey> list = pVar.b.e;
            g.a ov1Var = !list.isEmpty() ? new ov1(au0Var, list) : au0Var;
            od0.a aVar = this.c;
            if (aVar != null) {
                aVar.a(pVar);
            }
            return new DashMediaSource(pVar, null, this.b, ov1Var, this.f5940a, this.e, null, this.d.a(pVar), this.f, this.g, this.h, null);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory a(od0.a aVar) {
            this.c = (od0.a) vh.e(aVar);
            return this;
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Factory d(hi1 hi1Var) {
            this.d = (hi1) vh.f(hi1Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Factory b(com.google.android.exoplayer2.upstream.f fVar) {
            this.f = (com.google.android.exoplayer2.upstream.f) vh.f(fVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(a.InterfaceC0354a interfaceC0354a, @Nullable a.InterfaceC0360a interfaceC0360a) {
            this.f5940a = (a.InterfaceC0354a) vh.e(interfaceC0354a);
            this.b = interfaceC0360a;
            this.d = new com.google.android.exoplayer2.drm.a();
            this.f = new com.google.android.exoplayer2.upstream.e();
            this.g = 30000L;
            this.h = 5000000L;
            this.e = new c41();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements uf5.b {
        public a() {
        }

        @Override // uf5.b
        public void onInitializationFailed(IOException iOException) {
            DashMediaSource.this.R(iOException);
        }

        @Override // uf5.b
        public void onInitialized() {
            DashMediaSource.this.S(uf5.h());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends e0 {
        public final long f;
        public final long g;
        public final long h;
        public final int i;
        public final long j;
        public final long k;
        public final long l;
        public final zt0 m;
        public final p n;

        @Nullable
        public final p.g o;

        public b(long j, long j2, long j3, int i, long j4, long j5, long j6, zt0 zt0Var, p pVar, @Nullable p.g gVar) {
            vh.g(zt0Var.d == (gVar != null));
            this.f = j;
            this.g = j2;
            this.h = j3;
            this.i = i;
            this.j = j4;
            this.k = j5;
            this.l = j6;
            this.m = zt0Var;
            this.n = pVar;
            this.o = gVar;
        }

        public static boolean x(zt0 zt0Var) {
            return zt0Var.d && zt0Var.e != -9223372036854775807L && zt0Var.b == -9223372036854775807L;
        }

        @Override // com.google.android.exoplayer2.e0
        public int f(Object obj) {
            int iIntValue;
            if ((obj instanceof Integer) && (iIntValue = ((Integer) obj).intValue() - this.i) >= 0 && iIntValue < m()) {
                return iIntValue;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.e0
        public e0.b k(int i, e0.b bVar, boolean z) {
            vh.c(i, 0, m());
            return bVar.v(z ? this.m.c(i).f19213a : null, z ? Integer.valueOf(this.i + i) : null, 0, this.m.f(i), g86.H0(this.m.c(i).b - this.m.c(0).b) - this.j);
        }

        @Override // com.google.android.exoplayer2.e0
        public int m() {
            return this.m.d();
        }

        @Override // com.google.android.exoplayer2.e0
        public Object q(int i) {
            vh.c(i, 0, m());
            return Integer.valueOf(this.i + i);
        }

        @Override // com.google.android.exoplayer2.e0
        public e0.d s(int i, e0.d dVar, long j) {
            vh.c(i, 0, 1);
            long jW = w(j);
            Object obj = e0.d.r;
            p pVar = this.n;
            zt0 zt0Var = this.m;
            return dVar.i(obj, pVar, zt0Var, this.f, this.g, this.h, true, x(zt0Var), this.o, jW, this.k, 0, m() - 1, this.j);
        }

        @Override // com.google.android.exoplayer2.e0
        public int t() {
            return 1;
        }

        public final long w(long j) {
            du0 du0VarK;
            long j2 = this.l;
            if (!x(this.m)) {
                return j2;
            }
            if (j > 0) {
                j2 += j;
                if (j2 > this.k) {
                    return -9223372036854775807L;
                }
            }
            long j3 = this.j + j2;
            long jF = this.m.f(0);
            int i = 0;
            while (i < this.m.d() - 1 && j3 >= jF) {
                j3 -= jF;
                i++;
                jF = this.m.f(i);
            }
            mg4 mg4VarC = this.m.c(i);
            int iA = mg4VarC.a(2);
            return (iA == -1 || (du0VarK = mg4VarC.c.get(iA).c.get(0).k()) == null || du0VarK.e(jF) == 0) ? j2 : (j2 + du0VarK.getTimeUs(du0VarK.d(j3, jF))) - j3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c implements d.b {
        public c() {
        }

        @Override // com.google.android.exoplayer2.source.dash.d.b
        public void a(long j) {
            DashMediaSource.this.K(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.d.b
        public void b() {
            DashMediaSource.this.L();
        }

        public /* synthetic */ c(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d implements g.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Pattern f5943a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        @Override // com.google.android.exoplayer2.upstream.g.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            String line = new BufferedReader(new InputStreamReader(inputStream, f10.c)).readLine();
            try {
                Matcher matcher = f5943a.matcher(line);
                if (!matcher.matches()) {
                    throw ParserException.createForMalformedManifest("Couldn't parse timestamp: " + line, null);
                }
                String strGroup = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(strGroup).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j = "+".equals(matcher.group(4)) ? 1L : -1L;
                    long j2 = Long.parseLong(matcher.group(5));
                    String strGroup2 = matcher.group(7);
                    time -= j * ((((j2 * 60) + (TextUtils.isEmpty(strGroup2) ? 0L : Long.parseLong(strGroup2))) * 60) * 1000);
                }
                return Long.valueOf(time);
            } catch (ParseException e) {
                throw ParserException.createForMalformedManifest(null, e);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class e implements Loader.b<com.google.android.exoplayer2.upstream.g<zt0>> {
        public e() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(com.google.android.exoplayer2.upstream.g<zt0> gVar, long j, long j2, boolean z) {
            DashMediaSource.this.M(gVar, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void f(com.google.android.exoplayer2.upstream.g<zt0> gVar, long j, long j2) {
            DashMediaSource.this.N(gVar, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c j(com.google.android.exoplayer2.upstream.g<zt0> gVar, long j, long j2, IOException iOException, int i) {
            return DashMediaSource.this.O(gVar, j, j2, iOException, i);
        }

        public /* synthetic */ e(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class f implements q43 {
        public f() {
        }

        public final void a() throws IOException {
            if (DashMediaSource.this.D != null) {
                throw DashMediaSource.this.D;
            }
        }

        @Override // defpackage.q43
        public void maybeThrowError() throws IOException {
            DashMediaSource.this.B.maybeThrowError();
            a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class g implements Loader.b<com.google.android.exoplayer2.upstream.g<Long>> {
        public g() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(com.google.android.exoplayer2.upstream.g<Long> gVar, long j, long j2, boolean z) {
            DashMediaSource.this.M(gVar, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void f(com.google.android.exoplayer2.upstream.g<Long> gVar, long j, long j2) {
            DashMediaSource.this.P(gVar, j, j2);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Loader.c j(com.google.android.exoplayer2.upstream.g<Long> gVar, long j, long j2, IOException iOException, int i) {
            return DashMediaSource.this.Q(gVar, j, j2, iOException);
        }

        public /* synthetic */ g(DashMediaSource dashMediaSource, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class h implements g.a<Long> {
        public h() {
        }

        @Override // com.google.android.exoplayer2.upstream.g.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long parse(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(g86.O0(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        jr1.a("goog.exo.dash");
    }

    public /* synthetic */ DashMediaSource(p pVar, zt0 zt0Var, a.InterfaceC0360a interfaceC0360a, g.a aVar, a.InterfaceC0354a interfaceC0354a, gk0 gk0Var, od0 od0Var, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.upstream.f fVar, long j, long j2, a aVar2) {
        this(pVar, zt0Var, interfaceC0360a, aVar, interfaceC0354a, gk0Var, od0Var, cVar, fVar, j, j2);
    }

    public static long C(mg4 mg4Var, long j, long j2) {
        long jH0 = g86.H0(mg4Var.b);
        boolean zG = G(mg4Var);
        long jMin = Long.MAX_VALUE;
        for (int i = 0; i < mg4Var.c.size(); i++) {
            c7 c7Var = mg4Var.c.get(i);
            List<ow4> list = c7Var.c;
            int i2 = c7Var.b;
            boolean z = (i2 == 1 || i2 == 2) ? false : true;
            if ((!zG || !z) && !list.isEmpty()) {
                du0 du0VarK = list.get(0).k();
                if (du0VarK == null) {
                    return jH0 + j;
                }
                long jI = du0VarK.i(j, j2);
                if (jI == 0) {
                    return jH0;
                }
                long jB = (du0VarK.b(j, j2) + jI) - 1;
                jMin = Math.min(jMin, du0VarK.a(jB, j) + du0VarK.getTimeUs(jB) + jH0);
            }
        }
        return jMin;
    }

    public static long D(mg4 mg4Var, long j, long j2) {
        long jH0 = g86.H0(mg4Var.b);
        boolean zG = G(mg4Var);
        long jMax = jH0;
        for (int i = 0; i < mg4Var.c.size(); i++) {
            c7 c7Var = mg4Var.c.get(i);
            List<ow4> list = c7Var.c;
            int i2 = c7Var.b;
            boolean z = (i2 == 1 || i2 == 2) ? false : true;
            if ((!zG || !z) && !list.isEmpty()) {
                du0 du0VarK = list.get(0).k();
                if (du0VarK == null) {
                    return jH0;
                }
                if (du0VarK.i(j, j2) == 0) {
                    return jH0;
                }
                jMax = Math.max(jMax, du0VarK.getTimeUs(du0VarK.b(j, j2)) + jH0);
            }
        }
        return jMax;
    }

    public static long E(zt0 zt0Var, long j) {
        du0 du0VarK;
        int iD = zt0Var.d() - 1;
        mg4 mg4VarC = zt0Var.c(iD);
        long jH0 = g86.H0(mg4VarC.b);
        long jF = zt0Var.f(iD);
        long jH02 = g86.H0(j);
        long jH03 = g86.H0(zt0Var.f22506a);
        long jH04 = g86.H0(5000L);
        for (int i = 0; i < mg4VarC.c.size(); i++) {
            List<ow4> list = mg4VarC.c.get(i).c;
            if (!list.isEmpty() && (du0VarK = list.get(0).k()) != null) {
                long jC = ((jH03 + jH0) + du0VarK.c(jF, jH02)) - jH02;
                if (jC < jH04 - SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US || (jC > jH04 && jC < jH04 + SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US)) {
                    jH04 = jC;
                }
            }
        }
        return m73.c(jH04, 1000L, RoundingMode.CEILING);
    }

    public static boolean G(mg4 mg4Var) {
        for (int i = 0; i < mg4Var.c.size(); i++) {
            int i2 = mg4Var.c.get(i).b;
            if (i2 == 1 || i2 == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean H(mg4 mg4Var) {
        for (int i = 0; i < mg4Var.c.size(); i++) {
            du0 du0VarK = mg4Var.c.get(i).c.get(0).k();
            if (du0VarK == null || du0VarK.h()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        T(false);
    }

    public final long F() {
        return Math.min((this.N - 1) * 1000, 5000);
    }

    public final void J() {
        uf5.j(this.B, new a());
    }

    public void K(long j) {
        long j2 = this.O;
        if (j2 == -9223372036854775807L || j2 < j) {
            this.O = j;
        }
    }

    public void L() {
        this.E.removeCallbacks(this.x);
        Z();
    }

    public void M(com.google.android.exoplayer2.upstream.g<?> gVar, long j, long j2) {
        m43 m43Var = new m43(gVar.f6027a, gVar.b, gVar.d(), gVar.b(), j, j2, gVar.a());
        this.n.onLoadTaskConcluded(gVar.f6027a);
        this.r.p(m43Var, gVar.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void N(com.google.android.exoplayer2.upstream.g<zt0> gVar, long j, long j2) {
        boolean z;
        m43 m43Var = new m43(gVar.f6027a, gVar.b, gVar.d(), gVar.b(), j, j2, gVar.a());
        this.n.onLoadTaskConcluded(gVar.f6027a);
        this.r.s(m43Var, gVar.c);
        zt0 zt0VarC = gVar.c();
        zt0 zt0Var = this.I;
        int iD = zt0Var == null ? 0 : zt0Var.d();
        long j3 = zt0VarC.c(0).b;
        int i = 0;
        while (i < iD && this.I.c(i).b < j3) {
            i++;
        }
        if (zt0VarC.d) {
            if (iD - i > zt0VarC.d()) {
                y53.i("DashMediaSource", "Loaded out of sync manifest");
            } else {
                long j4 = this.O;
                if (j4 == -9223372036854775807L || zt0VarC.h * 1000 > j4) {
                    z = false;
                    if (!z) {
                        int i2 = this.N;
                        this.N = i2 + 1;
                        if (i2 < this.n.getMinimumLoadableRetryCount(gVar.c)) {
                            X(F());
                            return;
                        } else {
                            this.D = new DashManifestStaleException();
                            return;
                        }
                    }
                    this.N = 0;
                } else {
                    y53.i("DashMediaSource", "Loaded stale dynamic manifest: " + zt0VarC.h + ", " + this.O);
                }
            }
            z = true;
            if (!z) {
            }
        }
        this.I = zt0VarC;
        this.J = zt0VarC.d & this.J;
        this.K = j - j2;
        this.L = j;
        synchronized (this.u) {
            if (gVar.b.f6011a == this.G) {
                Uri uriD = this.I.k;
                if (uriD == null) {
                    uriD = gVar.d();
                }
                this.G = uriD;
            }
        }
        if (iD != 0) {
            this.P += i;
            T(true);
            return;
        }
        zt0 zt0Var2 = this.I;
        if (!zt0Var2.d) {
            T(true);
            return;
        }
        f76 f76Var = zt0Var2.i;
        if (f76Var != null) {
            U(f76Var);
        } else {
            J();
        }
    }

    public Loader.c O(com.google.android.exoplayer2.upstream.g<zt0> gVar, long j, long j2, IOException iOException, int i) {
        m43 m43Var = new m43(gVar.f6027a, gVar.b, gVar.d(), gVar.b(), j, j2, gVar.a());
        long jA = this.n.a(new f.c(m43Var, new kh3(gVar.c), iOException, i));
        Loader.c cVarG = jA == -9223372036854775807L ? Loader.g : Loader.g(false, jA);
        boolean z = !cVarG.c();
        this.r.w(m43Var, gVar.c, iOException, z);
        if (z) {
            this.n.onLoadTaskConcluded(gVar.f6027a);
        }
        return cVarG;
    }

    public void P(com.google.android.exoplayer2.upstream.g<Long> gVar, long j, long j2) {
        m43 m43Var = new m43(gVar.f6027a, gVar.b, gVar.d(), gVar.b(), j, j2, gVar.a());
        this.n.onLoadTaskConcluded(gVar.f6027a);
        this.r.s(m43Var, gVar.c);
        S(gVar.c().longValue() - j);
    }

    public Loader.c Q(com.google.android.exoplayer2.upstream.g<Long> gVar, long j, long j2, IOException iOException) {
        this.r.w(new m43(gVar.f6027a, gVar.b, gVar.d(), gVar.b(), j, j2, gVar.a()), gVar.c, iOException, true);
        this.n.onLoadTaskConcluded(gVar.f6027a);
        R(iOException);
        return Loader.f;
    }

    public final void R(IOException iOException) {
        y53.d("DashMediaSource", "Failed to resolve time offset.", iOException);
        T(true);
    }

    public final void S(long j) {
        this.M = j;
        T(true);
    }

    public final void T(boolean z) {
        mg4 mg4Var;
        long j;
        long j2;
        for (int i = 0; i < this.v.size(); i++) {
            int iKeyAt = this.v.keyAt(i);
            if (iKeyAt >= this.P) {
                this.v.valueAt(i).B(this.I, iKeyAt - this.P);
            }
        }
        mg4 mg4VarC = this.I.c(0);
        int iD = this.I.d() - 1;
        mg4 mg4VarC2 = this.I.c(iD);
        long jF = this.I.f(iD);
        long jH0 = g86.H0(g86.c0(this.M));
        long jD = D(mg4VarC, this.I.f(0), jH0);
        long jC = C(mg4VarC2, jF, jH0);
        boolean z2 = this.I.d && !H(mg4VarC2);
        if (z2) {
            long j3 = this.I.f;
            if (j3 != -9223372036854775807L) {
                jD = Math.max(jD, jC - g86.H0(j3));
            }
        }
        long j4 = jC - jD;
        zt0 zt0Var = this.I;
        if (zt0Var.d) {
            vh.g(zt0Var.f22506a != -9223372036854775807L);
            long jH02 = (jH0 - g86.H0(this.I.f22506a)) - jD;
            a0(jH02, j4);
            long jM1 = this.I.f22506a + g86.m1(jD);
            long jH03 = jH02 - g86.H0(this.F.f5918a);
            long jMin = Math.min(this.q, j4 / 2);
            j = jM1;
            j2 = jH03 < jMin ? jMin : jH03;
            mg4Var = mg4VarC;
        } else {
            mg4Var = mg4VarC;
            j = -9223372036854775807L;
            j2 = 0;
        }
        long jH04 = jD - g86.H0(mg4Var.b);
        zt0 zt0Var2 = this.I;
        u(new b(zt0Var2.f22506a, j, this.M, this.P, jH04, j4, j2, zt0Var2, this.h, zt0Var2.d ? this.F : null));
        if (this.i) {
            return;
        }
        this.E.removeCallbacks(this.x);
        if (z2) {
            this.E.postDelayed(this.x, E(this.I, g86.c0(this.M)));
        }
        if (this.J) {
            Z();
            return;
        }
        if (z) {
            zt0 zt0Var3 = this.I;
            if (zt0Var3.d) {
                long j5 = zt0Var3.e;
                if (j5 != -9223372036854775807L) {
                    if (j5 == 0) {
                        j5 = 5000;
                    }
                    X(Math.max(0L, (this.K + j5) - SystemClock.elapsedRealtime()));
                }
            }
        }
    }

    public final void U(f76 f76Var) {
        String str = f76Var.f17474a;
        if (g86.c(str, "urn:mpeg:dash:utc:direct:2014") || g86.c(str, "urn:mpeg:dash:utc:direct:2012")) {
            V(f76Var);
            return;
        }
        if (g86.c(str, "urn:mpeg:dash:utc:http-iso:2014") || g86.c(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            W(f76Var, new d());
            return;
        }
        if (g86.c(str, "urn:mpeg:dash:utc:http-xsdate:2014") || g86.c(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            W(f76Var, new h(null));
        } else if (g86.c(str, "urn:mpeg:dash:utc:ntp:2014") || g86.c(str, "urn:mpeg:dash:utc:ntp:2012")) {
            J();
        } else {
            R(new IOException("Unsupported UTC timing scheme"));
        }
    }

    public final void V(f76 f76Var) {
        try {
            S(g86.O0(f76Var.b) - this.L);
        } catch (ParserException e2) {
            R(e2);
        }
    }

    public final void W(f76 f76Var, g.a<Long> aVar) {
        Y(new com.google.android.exoplayer2.upstream.g(this.A, Uri.parse(f76Var.b), 5, aVar), new g(this, null), 1);
    }

    public final void X(long j) {
        this.E.postDelayed(this.w, j);
    }

    public final <T> void Y(com.google.android.exoplayer2.upstream.g<T> gVar, Loader.b<com.google.android.exoplayer2.upstream.g<T>> bVar, int i) {
        this.r.y(new m43(gVar.f6027a, gVar.b, this.B.m(gVar, bVar, i)), gVar.c);
    }

    public final void Z() {
        Uri uri;
        this.E.removeCallbacks(this.w);
        if (this.B.h()) {
            return;
        }
        if (this.B.i()) {
            this.J = true;
            return;
        }
        synchronized (this.u) {
            uri = this.G;
        }
        this.J = false;
        Y(new com.google.android.exoplayer2.upstream.g(this.A, uri, 4, this.s), this.t, this.n.getMinimumLoadableRetryCount(4));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a0(long j, long j2) {
        long j3;
        long jMin;
        long jM1;
        long j4;
        long jR;
        long j5;
        long jR2;
        float f2;
        float f3;
        e65 e65Var;
        long jM12 = g86.m1(j);
        long j6 = this.h.d.c;
        if (j6 == -9223372036854775807L) {
            e65 e65Var2 = this.I.j;
            if (e65Var2 != null) {
                long j7 = e65Var2.c;
                if (j7 != -9223372036854775807L) {
                    jMin = Math.min(jM12, j7);
                }
            }
            j3 = jM12;
            jM1 = g86.m1(j - j2);
            if (jM1 < 0 && j3 > 0) {
                jM1 = 0;
            }
            j4 = this.I.c;
            if (j4 != -9223372036854775807L) {
                jM1 = Math.min(jM1 + j4, jM12);
            }
            jR = jM1;
            j5 = this.h.d.b;
            if (j5 == -9223372036854775807L) {
                jR = g86.r(j5, jR, jM12);
            } else {
                e65 e65Var3 = this.I.j;
                if (e65Var3 != null) {
                    long j8 = e65Var3.b;
                    if (j8 != -9223372036854775807L) {
                        jR = g86.r(j8, jR, jM12);
                    }
                }
            }
            if (jR > j3) {
                j3 = jR;
            }
            jR2 = this.F.f5918a;
            if (jR2 == -9223372036854775807L) {
                zt0 zt0Var = this.I;
                e65 e65Var4 = zt0Var.j;
                if (e65Var4 != null) {
                    long j9 = e65Var4.f17223a;
                    if (j9 != -9223372036854775807L) {
                        jR2 = j9;
                    } else {
                        jR2 = zt0Var.g;
                        if (jR2 == -9223372036854775807L) {
                            jR2 = this.p;
                        }
                    }
                }
            }
            if (jR2 < jR) {
                jR2 = jR;
            }
            if (jR2 > j3) {
                jR2 = g86.r(g86.m1(j - Math.min(this.q, j2 / 2)), jR, j3);
            }
            p.g gVar = this.h.d;
            f2 = gVar.d;
            if (f2 == -3.4028235E38f) {
                e65 e65Var5 = this.I.j;
                f2 = e65Var5 != null ? e65Var5.d : -3.4028235E38f;
            }
            f3 = gVar.e;
            if (f3 == -3.4028235E38f) {
                e65 e65Var6 = this.I.j;
                f3 = e65Var6 != null ? e65Var6.e : -3.4028235E38f;
            }
            if (f2 == -3.4028235E38f && f3 == -3.4028235E38f && ((e65Var = this.I.j) == null || e65Var.f17223a == -9223372036854775807L)) {
                f2 = 1.0f;
                f3 = 1.0f;
            }
            this.F = new p.g.a().k(jR2).i(jR).g(j3).j(f2).h(f3).f();
        }
        jMin = Math.min(jM12, j6);
        j3 = jMin;
        jM1 = g86.m1(j - j2);
        if (jM1 < 0) {
            jM1 = 0;
        }
        j4 = this.I.c;
        if (j4 != -9223372036854775807L) {
        }
        jR = jM1;
        j5 = this.h.d.b;
        if (j5 == -9223372036854775807L) {
        }
        if (jR > j3) {
        }
        jR2 = this.F.f5918a;
        if (jR2 == -9223372036854775807L) {
        }
        if (jR2 < jR) {
        }
        if (jR2 > j3) {
        }
        p.g gVar2 = this.h.d;
        f2 = gVar2.d;
        if (f2 == -3.4028235E38f) {
        }
        f3 = gVar2.e;
        if (f3 == -3.4028235E38f) {
        }
        if (f2 == -3.4028235E38f) {
            f2 = 1.0f;
            f3 = 1.0f;
        }
        this.F = new p.g.a().k(jR2).i(jR).g(j3).j(f2).h(f3).f();
    }

    @Override // com.google.android.exoplayer2.source.i
    public com.google.android.exoplayer2.source.h c(i.b bVar, w9 w9Var, long j) {
        int iIntValue = ((Integer) bVar.f18710a).intValue() - this.P;
        j.a aVarO = o(bVar);
        com.google.android.exoplayer2.source.dash.b bVar2 = new com.google.android.exoplayer2.source.dash.b(iIntValue + this.P, this.I, this.o, iIntValue, this.k, this.C, null, this.m, m(bVar), this.n, aVarO, this.M, this.z, w9Var, this.l, this.y, r());
        this.v.put(bVar2.f5947a, bVar2);
        return bVar2;
    }

    @Override // com.google.android.exoplayer2.source.i
    public void f(com.google.android.exoplayer2.source.h hVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) hVar;
        bVar.x();
        this.v.remove(bVar.f5947a);
    }

    @Override // com.google.android.exoplayer2.source.i
    public p getMediaItem() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.z.maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void t(@Nullable u06 u06Var) {
        this.C = u06Var;
        this.m.a(Looper.myLooper(), r());
        this.m.prepare();
        if (this.i) {
            T(false);
            return;
        }
        this.A = this.j.createDataSource();
        this.B = new Loader("DashMediaSource");
        this.E = g86.w();
        Z();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void v() {
        this.J = false;
        this.A = null;
        Loader loader = this.B;
        if (loader != null) {
            loader.k();
            this.B = null;
        }
        this.K = 0L;
        this.L = 0L;
        this.I = this.i ? this.I : null;
        this.G = this.H;
        this.D = null;
        Handler handler = this.E;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.E = null;
        }
        this.M = -9223372036854775807L;
        this.N = 0;
        this.O = -9223372036854775807L;
        this.v.clear();
        this.o.i();
        this.m.release();
    }

    public DashMediaSource(p pVar, @Nullable zt0 zt0Var, @Nullable a.InterfaceC0360a interfaceC0360a, @Nullable g.a<? extends zt0> aVar, a.InterfaceC0354a interfaceC0354a, gk0 gk0Var, @Nullable od0 od0Var, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.upstream.f fVar, long j, long j2) {
        this.h = pVar;
        this.F = pVar.d;
        this.G = ((p.h) vh.e(pVar.b)).f5920a;
        this.H = pVar.b.f5920a;
        this.I = zt0Var;
        this.j = interfaceC0360a;
        this.s = aVar;
        this.k = interfaceC0354a;
        this.m = cVar;
        this.n = fVar;
        this.p = j;
        this.q = j2;
        this.l = gk0Var;
        this.o = new es();
        boolean z = zt0Var != null;
        this.i = z;
        a aVar2 = null;
        this.r = o(null);
        this.u = new Object();
        this.v = new SparseArray<>();
        this.y = new c(this, aVar2);
        this.O = -9223372036854775807L;
        this.M = -9223372036854775807L;
        if (!z) {
            this.t = new e(this, aVar2);
            this.z = new f();
            this.w = new Runnable() { // from class: bu0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1819a.Z();
                }
            };
            this.x = new Runnable() { // from class: cu0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16915a.I();
                }
            };
            return;
        }
        vh.g(true ^ zt0Var.d);
        this.t = null;
        this.w = null;
        this.x = null;
        this.z = new q43.a();
    }
}
