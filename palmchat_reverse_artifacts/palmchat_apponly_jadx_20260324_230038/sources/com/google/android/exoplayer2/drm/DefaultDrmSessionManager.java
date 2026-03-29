package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.drm.c;
import com.google.android.exoplayer2.drm.g;
import com.google.android.exoplayer2.m;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.k0;
import defpackage.bk4;
import defpackage.fp3;
import defpackage.g86;
import defpackage.i32;
import defpackage.o46;
import defpackage.vh;
import defpackage.y53;
import defpackage.zv;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(18)
@Deprecated
public class DefaultDrmSessionManager implements com.google.android.exoplayer2.drm.c {
    public final UUID c;
    public final g.c d;
    public final j e;
    public final HashMap<String, String> f;
    public final boolean g;
    public final int[] h;
    public final boolean i;
    public final f j;
    public final com.google.android.exoplayer2.upstream.f k;
    public final g l;
    public final long m;
    public final List<DefaultDrmSession> n;
    public final Set<e> o;
    public final Set<DefaultDrmSession> p;
    public int q;

    @Nullable
    public com.google.android.exoplayer2.drm.g r;

    @Nullable
    public DefaultDrmSession s;

    @Nullable
    public DefaultDrmSession t;
    public Looper u;
    public Handler v;
    public int w;

    @Nullable
    public byte[] x;
    public bk4 y;

    @Nullable
    public volatile d z;

    /* JADX INFO: compiled from: SearchBox */
    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {
        public boolean d;
        public boolean f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<String, String> f5853a = new HashMap<>();
        public UUID b = zv.d;
        public g.c c = h.d;
        public com.google.android.exoplayer2.upstream.f g = new com.google.android.exoplayer2.upstream.e();
        public int[] e = new int[0];
        public long h = 300000;

        public DefaultDrmSessionManager a(j jVar) {
            return new DefaultDrmSessionManager(this.b, this.c, jVar, this.f5853a, this.d, this.e, this.f, this.g, this.h);
        }

        public b b(boolean z) {
            this.d = z;
            return this;
        }

        public b c(boolean z) {
            this.f = z;
            return this;
        }

        public b d(int... iArr) {
            for (int i : iArr) {
                boolean z = true;
                if (i != 2 && i != 1) {
                    z = false;
                }
                vh.a(z);
            }
            this.e = (int[]) iArr.clone();
            return this;
        }

        public b e(UUID uuid, g.c cVar) {
            this.b = (UUID) vh.e(uuid);
            this.c = (g.c) vh.e(cVar);
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements g.b {
        public c() {
        }

        @Override // com.google.android.exoplayer2.drm.g.b
        public void a(com.google.android.exoplayer2.drm.g gVar, @Nullable byte[] bArr, int i, int i2, @Nullable byte[] bArr2) {
            ((d) vh.e(DefaultDrmSessionManager.this.z)).obtainMessage(i, bArr).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"HandlerLeak"})
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.n) {
                if (defaultDrmSession.n(bArr)) {
                    defaultDrmSession.v(message.what);
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements c.b {

        @Nullable
        public final b.a b;

        @Nullable
        public DrmSession c;
        public boolean d;

        public e(@Nullable b.a aVar) {
            this.b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(m mVar) {
            if (DefaultDrmSessionManager.this.q == 0 || this.d) {
                return;
            }
            DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
            this.c = defaultDrmSessionManager.s((Looper) vh.e(defaultDrmSessionManager.u), this.b, mVar, false);
            DefaultDrmSessionManager.this.o.add(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            if (this.d) {
                return;
            }
            DrmSession drmSession = this.c;
            if (drmSession != null) {
                drmSession.a(this.b);
            }
            DefaultDrmSessionManager.this.o.remove(this);
            this.d = true;
        }

        public void c(final m mVar) {
            ((Handler) vh.e(DefaultDrmSessionManager.this.v)).post(new Runnable() { // from class: z41
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22342a.d(mVar);
                }
            });
        }

        @Override // com.google.android.exoplayer2.drm.c.b
        public void release() {
            g86.Q0((Handler) vh.e(DefaultDrmSessionManager.this.v), new Runnable() { // from class: y41
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22118a.e();
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements DefaultDrmSession.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<DefaultDrmSession> f5856a = new HashSet();

        @Nullable
        public DefaultDrmSession b;

        public f() {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void a(DefaultDrmSession defaultDrmSession) {
            this.f5856a.add(defaultDrmSession);
            if (this.b != null) {
                return;
            }
            this.b = defaultDrmSession;
            defaultDrmSession.B();
        }

        public void b(DefaultDrmSession defaultDrmSession) {
            this.f5856a.remove(defaultDrmSession);
            if (this.b == defaultDrmSession) {
                this.b = null;
                if (this.f5856a.isEmpty()) {
                    return;
                }
                DefaultDrmSession next = this.f5856a.iterator().next();
                this.b = next;
                next.B();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void onProvisionCompleted() {
            this.b = null;
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) this.f5856a);
            this.f5856a.clear();
            o46 it = immutableListCopyOf.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).w();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void onProvisionError(Exception exc, boolean z) {
            this.b = null;
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) this.f5856a);
            this.f5856a.clear();
            o46 it = immutableListCopyOf.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).x(exc, z);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements DefaultDrmSession.b {
        public g() {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.b
        public void a(final DefaultDrmSession defaultDrmSession, int i) {
            if (i == 1 && DefaultDrmSessionManager.this.q > 0 && DefaultDrmSessionManager.this.m != -9223372036854775807L) {
                DefaultDrmSessionManager.this.p.add(defaultDrmSession);
                ((Handler) vh.e(DefaultDrmSessionManager.this.v)).postAtTime(new Runnable() { // from class: a51
                    @Override // java.lang.Runnable
                    public final void run() {
                        defaultDrmSession.a(null);
                    }
                }, defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.m);
            } else if (i == 0) {
                DefaultDrmSessionManager.this.n.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.s == defaultDrmSession) {
                    DefaultDrmSessionManager.this.s = null;
                }
                if (DefaultDrmSessionManager.this.t == defaultDrmSession) {
                    DefaultDrmSessionManager.this.t = null;
                }
                DefaultDrmSessionManager.this.j.b(defaultDrmSession);
                if (DefaultDrmSessionManager.this.m != -9223372036854775807L) {
                    ((Handler) vh.e(DefaultDrmSessionManager.this.v)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.p.remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.this.B();
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.b
        public void b(DefaultDrmSession defaultDrmSession, int i) {
            if (DefaultDrmSessionManager.this.m != -9223372036854775807L) {
                DefaultDrmSessionManager.this.p.remove(defaultDrmSession);
                ((Handler) vh.e(DefaultDrmSessionManager.this.v)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }
    }

    public static boolean t(DrmSession drmSession) {
        return drmSession.getState() == 1 && (g86.f17680a < 19 || (((DrmSession.DrmSessionException) vh.e(drmSession.getError())).getCause() instanceof ResourceBusyException));
    }

    public static List<DrmInitData.SchemeData> x(DrmInitData drmInitData, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i);
            if ((schemeData.matches(uuid) || (zv.c.equals(uuid) && schemeData.matches(zv.b))) && (schemeData.data != null || z)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    public final void A(Looper looper) {
        if (this.z == null) {
            this.z = new d(looper);
        }
    }

    public final void B() {
        if (this.r != null && this.q == 0 && this.n.isEmpty() && this.o.isEmpty()) {
            ((com.google.android.exoplayer2.drm.g) vh.e(this.r)).release();
            this.r = null;
        }
    }

    public final void C() {
        o46 it = ImmutableSet.copyOf((Collection) this.p).iterator();
        while (it.hasNext()) {
            ((DrmSession) it.next()).a(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D() {
        o46 it = ImmutableSet.copyOf((Collection) this.o).iterator();
        while (it.hasNext()) {
            ((e) it.next()).release();
        }
    }

    public void E(int i, @Nullable byte[] bArr) {
        vh.g(this.n.isEmpty());
        if (i == 1 || i == 3) {
            vh.e(bArr);
        }
        this.w = i;
        this.x = bArr;
    }

    public final void F(DrmSession drmSession, @Nullable b.a aVar) {
        drmSession.a(aVar);
        if (this.m != -9223372036854775807L) {
            drmSession.a(null);
        }
    }

    public final void G(boolean z) {
        if (z && this.u == null) {
            y53.j("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
            return;
        }
        if (Thread.currentThread() != ((Looper) vh.e(this.u)).getThread()) {
            y53.j("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.u.getThread().getName(), new IllegalStateException());
        }
    }

    @Override // com.google.android.exoplayer2.drm.c
    public void a(Looper looper, bk4 bk4Var) {
        y(looper);
        this.y = bk4Var;
    }

    @Override // com.google.android.exoplayer2.drm.c
    @Nullable
    public DrmSession b(@Nullable b.a aVar, m mVar) {
        G(false);
        vh.g(this.q > 0);
        vh.i(this.u);
        return s(this.u, aVar, mVar, true);
    }

    @Override // com.google.android.exoplayer2.drm.c
    public c.b c(@Nullable b.a aVar, m mVar) {
        vh.g(this.q > 0);
        vh.i(this.u);
        e eVar = new e(aVar);
        eVar.c(mVar);
        return eVar;
    }

    @Override // com.google.android.exoplayer2.drm.c
    public int d(m mVar) {
        G(false);
        int cryptoType = ((com.google.android.exoplayer2.drm.g) vh.e(this.r)).getCryptoType();
        DrmInitData drmInitData = mVar.o;
        if (drmInitData != null) {
            if (u(drmInitData)) {
                return cryptoType;
            }
            return 1;
        }
        if (g86.E0(this.h, fp3.k(mVar.l)) != -1) {
            return cryptoType;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.drm.c
    public final void prepare() {
        G(true);
        int i = this.q;
        this.q = i + 1;
        if (i != 0) {
            return;
        }
        if (this.r == null) {
            com.google.android.exoplayer2.drm.g gVarAcquireExoMediaDrm = this.d.acquireExoMediaDrm(this.c);
            this.r = gVarAcquireExoMediaDrm;
            gVarAcquireExoMediaDrm.a(new c());
        } else if (this.m != -9223372036854775807L) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                this.n.get(i2).b(null);
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.c
    public final void release() {
        G(true);
        int i = this.q - 1;
        this.q = i;
        if (i != 0) {
            return;
        }
        if (this.m != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.n);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((DefaultDrmSession) arrayList.get(i2)).a(null);
            }
        }
        D();
        B();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final DrmSession s(Looper looper, @Nullable b.a aVar, m mVar, boolean z) {
        List<DrmInitData.SchemeData> listX;
        A(looper);
        DrmInitData drmInitData = mVar.o;
        if (drmInitData == null) {
            return z(fp3.k(mVar.l), z);
        }
        DefaultDrmSession defaultDrmSessionW = null;
        Object[] objArr = 0;
        if (this.x == null) {
            listX = x((DrmInitData) vh.e(drmInitData), this.c, false);
            if (listX.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.c);
                y53.d("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (aVar != null) {
                    aVar.l(missingSchemeDataException);
                }
                return new com.google.android.exoplayer2.drm.f(new DrmSession.DrmSessionException(missingSchemeDataException, 6003));
            }
        } else {
            listX = null;
        }
        if (this.g) {
            Iterator<DefaultDrmSession> it = this.n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it.next();
                if (g86.c(next.f5849a, listX)) {
                    defaultDrmSessionW = next;
                    break;
                }
            }
        } else {
            defaultDrmSessionW = this.t;
        }
        if (defaultDrmSessionW == null) {
            defaultDrmSessionW = w(listX, false, aVar, z);
            if (!this.g) {
                this.t = defaultDrmSessionW;
            }
            this.n.add(defaultDrmSessionW);
        } else {
            defaultDrmSessionW.b(aVar);
        }
        return defaultDrmSessionW;
    }

    public final boolean u(DrmInitData drmInitData) {
        if (this.x != null) {
            return true;
        }
        if (x(drmInitData, this.c, true).isEmpty()) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(zv.b)) {
                return false;
            }
            y53.i("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.c);
        }
        String str = drmInitData.schemeType;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return "cbcs".equals(str) ? g86.f17680a >= 25 : ("cbc1".equals(str) || "cens".equals(str)) ? false : true;
    }

    public final DefaultDrmSession v(@Nullable List<DrmInitData.SchemeData> list, boolean z, @Nullable b.a aVar) {
        vh.e(this.r);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.c, this.r, this.j, this.l, list, this.w, this.i | z, z, this.x, this.f, this.e, (Looper) vh.e(this.u), this.k, (bk4) vh.e(this.y));
        defaultDrmSession.b(aVar);
        if (this.m != -9223372036854775807L) {
            defaultDrmSession.b(null);
        }
        return defaultDrmSession;
    }

    public final DefaultDrmSession w(@Nullable List<DrmInitData.SchemeData> list, boolean z, @Nullable b.a aVar, boolean z2) {
        DefaultDrmSession defaultDrmSessionV = v(list, z, aVar);
        if (t(defaultDrmSessionV) && !this.p.isEmpty()) {
            C();
            F(defaultDrmSessionV, aVar);
            defaultDrmSessionV = v(list, z, aVar);
        }
        if (!t(defaultDrmSessionV) || !z2 || this.o.isEmpty()) {
            return defaultDrmSessionV;
        }
        D();
        if (!this.p.isEmpty()) {
            C();
        }
        F(defaultDrmSessionV, aVar);
        return v(list, z, aVar);
    }

    public final synchronized void y(Looper looper) {
        Looper looper2 = this.u;
        if (looper2 == null) {
            this.u = looper;
            this.v = new Handler(looper);
        } else {
            vh.g(looper2 == looper);
            vh.e(this.v);
        }
    }

    @Nullable
    public final DrmSession z(int i, boolean z) {
        com.google.android.exoplayer2.drm.g gVar = (com.google.android.exoplayer2.drm.g) vh.e(this.r);
        if ((gVar.getCryptoType() == 2 && i32.d) || g86.E0(this.h, i) == -1 || gVar.getCryptoType() == 1) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.s;
        if (defaultDrmSession == null) {
            DefaultDrmSession defaultDrmSessionW = w(ImmutableList.of(), true, null, z);
            this.n.add(defaultDrmSessionW);
            this.s = defaultDrmSessionW;
        } else {
            defaultDrmSession.b(null);
        }
        return this.s;
    }

    public DefaultDrmSessionManager(UUID uuid, g.c cVar, j jVar, HashMap<String, String> map, boolean z, int[] iArr, boolean z2, com.google.android.exoplayer2.upstream.f fVar, long j) {
        vh.e(uuid);
        vh.b(!zv.b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.c = uuid;
        this.d = cVar;
        this.e = jVar;
        this.f = map;
        this.g = z;
        this.h = iArr;
        this.i = z2;
        this.k = fVar;
        this.j = new f();
        this.l = new g();
        this.w = 0;
        this.n = new ArrayList();
        this.o = k0.i();
        this.p = k0.i();
        this.m = j;
    }
}
