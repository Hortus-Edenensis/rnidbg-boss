package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.drm.g;
import com.google.android.exoplayer2.upstream.f;
import defpackage.al6;
import defpackage.bk4;
import defpackage.fq0;
import defpackage.g86;
import defpackage.hr0;
import defpackage.kh3;
import defpackage.m43;
import defpackage.vh;
import defpackage.y53;
import defpackage.ym0;
import defpackage.zv;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(18)
@Deprecated
public class DefaultDrmSession implements DrmSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final List<DrmInitData.SchemeData> f5849a;
    public final g b;
    public final a c;
    public final b d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final HashMap<String, String> h;
    public final fq0<b.a> i;
    public final com.google.android.exoplayer2.upstream.f j;
    public final bk4 k;
    public final j l;
    public final UUID m;
    public final Looper n;
    public final e o;
    public int p;
    public int q;

    @Nullable
    public HandlerThread r;

    @Nullable
    public c s;

    @Nullable
    public hr0 t;

    @Nullable
    public DrmSession.DrmSessionException u;

    @Nullable
    public byte[] v;
    public byte[] w;

    @Nullable
    public g.a x;

    @Nullable
    public g.d y;

    /* JADX INFO: compiled from: SearchBox */
    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@Nullable Throwable th) {
            super(th);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(DefaultDrmSession defaultDrmSession);

        void onProvisionCompleted();

        void onProvisionError(Exception exc, boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(DefaultDrmSession defaultDrmSession, int i);

        void b(DefaultDrmSession defaultDrmSession, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"HandlerLeak"})
    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @GuardedBy("this")
        public boolean f5850a;

        public c(Looper looper) {
            super(looper);
        }

        public final boolean a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            d dVar = (d) message.obj;
            if (!dVar.b) {
                return false;
            }
            int i = dVar.e + 1;
            dVar.e = i;
            if (i > DefaultDrmSession.this.j.getMinimumLoadableRetryCount(3)) {
                return false;
            }
            long jA = DefaultDrmSession.this.j.a(new f.c(new m43(dVar.f5851a, mediaDrmCallbackException.dataSpec, mediaDrmCallbackException.uriAfterRedirects, mediaDrmCallbackException.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.c, mediaDrmCallbackException.bytesLoaded), new kh3(3), mediaDrmCallbackException.getCause() instanceof IOException ? (IOException) mediaDrmCallbackException.getCause() : new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause()), dVar.e));
            if (jA == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                if (this.f5850a) {
                    return false;
                }
                sendMessageDelayed(Message.obtain(message), jA);
                return true;
            }
        }

        public void b(int i, Object obj, boolean z) {
            obtainMessage(i, new d(m43.a(), z, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages(null);
            this.f5850a = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object objB;
            d dVar = (d) message.obj;
            try {
                int i = message.what;
                if (i == 0) {
                    objB = DefaultDrmSession.this.l.b(DefaultDrmSession.this.m, (g.d) dVar.d);
                } else {
                    if (i != 1) {
                        throw new RuntimeException();
                    }
                    objB = DefaultDrmSession.this.l.a(DefaultDrmSession.this.m, (g.a) dVar.d);
                }
            } catch (MediaDrmCallbackException e) {
                boolean zA = a(message, e);
                objB = e;
                if (zA) {
                    return;
                }
            } catch (Exception e2) {
                y53.j("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e2);
                objB = e2;
            }
            DefaultDrmSession.this.j.onLoadTaskConcluded(dVar.f5851a);
            synchronized (this) {
                if (!this.f5850a) {
                    DefaultDrmSession.this.o.obtainMessage(message.what, Pair.create(dVar.d, objB)).sendToTarget();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f5851a;
        public final boolean b;
        public final long c;
        public final Object d;
        public int e;

        public d(long j, boolean z, long j2, Object obj) {
            this.f5851a = j;
            this.b = z;
            this.c = j2;
            this.d = obj;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"HandlerLeak"})
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                DefaultDrmSession.this.y(obj, obj2);
            } else {
                if (i != 1) {
                    return;
                }
                DefaultDrmSession.this.s(obj, obj2);
            }
        }
    }

    public DefaultDrmSession(UUID uuid, g gVar, a aVar, b bVar, @Nullable List<DrmInitData.SchemeData> list, int i, boolean z, boolean z2, @Nullable byte[] bArr, HashMap<String, String> map, j jVar, Looper looper, com.google.android.exoplayer2.upstream.f fVar, bk4 bk4Var) {
        if (i == 1 || i == 3) {
            vh.e(bArr);
        }
        this.m = uuid;
        this.c = aVar;
        this.d = bVar;
        this.b = gVar;
        this.e = i;
        this.f = z;
        this.g = z2;
        if (bArr != null) {
            this.w = bArr;
            this.f5849a = null;
        } else {
            this.f5849a = Collections.unmodifiableList((List) vh.e(list));
        }
        this.h = map;
        this.l = jVar;
        this.i = new fq0<>();
        this.j = fVar;
        this.k = bk4Var;
        this.p = 2;
        this.n = looper;
        this.o = new e(looper);
    }

    public final void A(byte[] bArr, int i, boolean z) {
        try {
            this.x = this.b.getKeyRequest(bArr, this.f5849a, i, this.h);
            ((c) g86.j(this.s)).b(1, vh.e(this.x), z);
        } catch (Exception e2) {
            t(e2, true);
        }
    }

    public void B() {
        this.y = this.b.getProvisionRequest();
        ((c) g86.j(this.s)).b(0, vh.e(this.y), true);
    }

    public final boolean C() {
        try {
            this.b.restoreKeys(this.v, this.w);
            return true;
        } catch (Exception e2) {
            r(e2, 1);
            return false;
        }
    }

    public final void D() {
        if (Thread.currentThread() != this.n.getThread()) {
            y53.j("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.n.getThread().getName(), new IllegalStateException());
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(@Nullable b.a aVar) {
        D();
        int i = this.q;
        if (i <= 0) {
            y53.c("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i2 = i - 1;
        this.q = i2;
        if (i2 == 0) {
            this.p = 0;
            ((e) g86.j(this.o)).removeCallbacksAndMessages(null);
            ((c) g86.j(this.s)).c();
            this.s = null;
            ((HandlerThread) g86.j(this.r)).quit();
            this.r = null;
            this.t = null;
            this.u = null;
            this.x = null;
            this.y = null;
            byte[] bArr = this.v;
            if (bArr != null) {
                this.b.closeSession(bArr);
                this.v = null;
            }
        }
        if (aVar != null) {
            this.i.b(aVar);
            if (this.i.count(aVar) == 0) {
                aVar.m();
            }
        }
        this.d.a(this, this.q);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void b(@Nullable b.a aVar) {
        D();
        if (this.q < 0) {
            y53.c("DefaultDrmSession", "Session reference count less than zero: " + this.q);
            this.q = 0;
        }
        if (aVar != null) {
            this.i.a(aVar);
        }
        int i = this.q + 1;
        this.q = i;
        if (i == 1) {
            vh.g(this.p == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.r = handlerThread;
            handlerThread.start();
            this.s = new c(this.r.getLooper());
            if (z()) {
                l(true);
            }
        } else if (aVar != null && o() && this.i.count(aVar) == 1) {
            aVar.k(this.p);
        }
        this.d.b(this, this.q);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final hr0 getCryptoConfig() {
        D();
        return this.t;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final DrmSession.DrmSessionException getError() {
        D();
        if (this.p == 1) {
            return this.u;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID getSchemeUuid() {
        D();
        return this.m;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        D();
        return this.p;
    }

    public final void k(ym0<b.a> ym0Var) {
        Iterator<b.a> it = this.i.elementSet().iterator();
        while (it.hasNext()) {
            ym0Var.accept(it.next());
        }
    }

    public final void l(boolean z) {
        if (this.g) {
            return;
        }
        byte[] bArr = (byte[]) g86.j(this.v);
        int i = this.e;
        if (i != 0 && i != 1) {
            if (i == 2) {
                if (this.w == null || C()) {
                    A(bArr, 2, z);
                    return;
                }
                return;
            }
            if (i != 3) {
                return;
            }
            vh.e(this.w);
            vh.e(this.v);
            A(this.w, 3, z);
            return;
        }
        if (this.w == null) {
            A(bArr, 1, z);
            return;
        }
        if (this.p == 4 || C()) {
            long jM = m();
            if (this.e != 0 || jM > 60) {
                if (jM <= 0) {
                    r(new KeysExpiredException(), 2);
                    return;
                } else {
                    this.p = 4;
                    k(new ym0() { // from class: v41
                        @Override // defpackage.ym0
                        public final void accept(Object obj) {
                            ((b.a) obj).j();
                        }
                    });
                    return;
                }
            }
            y53.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + jM);
            A(bArr, 2, z);
        }
    }

    public final long m() {
        if (!zv.d.equals(this.m)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) vh.e(al6.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    public boolean n(byte[] bArr) {
        D();
        return Arrays.equals(this.v, bArr);
    }

    public final boolean o() {
        int i = this.p;
        return i == 3 || i == 4;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        D();
        return this.f;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public Map<String, String> queryKeyStatus() {
        D();
        byte[] bArr = this.v;
        if (bArr == null) {
            return null;
        }
        return this.b.queryKeyStatus(bArr);
    }

    public final void r(final Exception exc, int i) {
        this.u = new DrmSession.DrmSessionException(exc, com.google.android.exoplayer2.drm.d.a(exc, i));
        y53.d("DefaultDrmSession", "DRM session error", exc);
        k(new ym0() { // from class: s41
            @Override // defpackage.ym0
            public final void accept(Object obj) {
                ((b.a) obj).l(exc);
            }
        });
        if (this.p != 4) {
            this.p = 1;
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean requiresSecureDecoder(String str) {
        D();
        return this.b.requiresSecureDecoder((byte[]) vh.i(this.v), str);
    }

    public final void s(Object obj, Object obj2) {
        if (obj == this.x && o()) {
            this.x = null;
            if (obj2 instanceof Exception) {
                t((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.e == 3) {
                    this.b.provideKeyResponse((byte[]) g86.j(this.w), bArr);
                    k(new ym0() { // from class: m41
                        @Override // defpackage.ym0
                        public final void accept(Object obj3) {
                            ((b.a) obj3).i();
                        }
                    });
                    return;
                }
                byte[] bArrProvideKeyResponse = this.b.provideKeyResponse(this.v, bArr);
                int i = this.e;
                if ((i == 2 || (i == 0 && this.w != null)) && bArrProvideKeyResponse != null && bArrProvideKeyResponse.length != 0) {
                    this.w = bArrProvideKeyResponse;
                }
                this.p = 4;
                k(new ym0() { // from class: o41
                    @Override // defpackage.ym0
                    public final void accept(Object obj3) {
                        ((b.a) obj3).h();
                    }
                });
            } catch (Exception e2) {
                t(e2, true);
            }
        }
    }

    public final void t(Exception exc, boolean z) {
        if (exc instanceof NotProvisionedException) {
            this.c.a(this);
        } else {
            r(exc, z ? 1 : 2);
        }
    }

    public final void u() {
        if (this.e == 0 && this.p == 4) {
            g86.j(this.v);
            l(false);
        }
    }

    public void v(int i) {
        if (i != 2) {
            return;
        }
        u();
    }

    public void w() {
        if (z()) {
            l(true);
        }
    }

    public void x(Exception exc, boolean z) {
        r(exc, z ? 1 : 3);
    }

    public final void y(Object obj, Object obj2) {
        if (obj == this.y) {
            if (this.p == 2 || o()) {
                this.y = null;
                if (obj2 instanceof Exception) {
                    this.c.onProvisionError((Exception) obj2, false);
                    return;
                }
                try {
                    this.b.provideProvisionResponse((byte[]) obj2);
                    this.c.onProvisionCompleted();
                } catch (Exception e2) {
                    this.c.onProvisionError(e2, true);
                }
            }
        }
    }

    public final boolean z() {
        if (o()) {
            return true;
        }
        try {
            byte[] bArrOpenSession = this.b.openSession();
            this.v = bArrOpenSession;
            this.b.b(bArrOpenSession, this.k);
            this.t = this.b.createCryptoConfig(this.v);
            final int i = 3;
            this.p = 3;
            k(new ym0() { // from class: p41
                @Override // defpackage.ym0
                public final void accept(Object obj) {
                    ((b.a) obj).k(i);
                }
            });
            vh.e(this.v);
            return true;
        } catch (NotProvisionedException unused) {
            this.c.a(this);
            return false;
        } catch (Exception e2) {
            r(e2, 1);
            return false;
        }
    }
}
