package com.opos.exoplayer.core.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.opos.exoplayer.core.C;
import com.opos.exoplayer.core.drm.DefaultDrmSessionManager;
import com.opos.exoplayer.core.drm.DrmSession;
import com.opos.exoplayer.core.drm.c;
import com.opos.exoplayer.core.drm.d;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@TargetApi(18)
class a<T extends com.opos.exoplayer.core.drm.c> implements DrmSession<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.opos.exoplayer.core.drm.g f8143a;
    final UUID b;
    final a<T>.g c;
    private final com.opos.exoplayer.core.drm.d<T> d;
    private final InterfaceC0686a<T> e;
    private final byte[] f;
    private final String g;
    private final int h;
    private final HashMap<String, String> i;
    private final Handler j;
    private final DefaultDrmSessionManager.a k;
    private final int l;
    private int m = 2;
    private int n;
    private HandlerThread o;
    private a<T>.f p;
    private T q;
    private DrmSession.a r;
    private byte[] s;
    private byte[] t;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.drm.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0686a<T extends com.opos.exoplayer.core.drm.c> {
        void a();

        void a(a<T> aVar);

        void a(Exception exc);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.k.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.k.c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.k.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Exception f8147a;

        public e(Exception exc) {
            this.f8147a = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.k.a(this.f8147a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"HandlerLeak"})
    public class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        private long a(int i) {
            return Math.min((i - 1) * 1000, 5000);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == 0) {
                    a aVar = a.this;
                    e = aVar.f8143a.a(aVar.b, (d.c) message.obj);
                } else {
                    if (i != 1) {
                        throw new RuntimeException();
                    }
                    a aVar2 = a.this;
                    e = aVar2.f8143a.a(aVar2.b, (d.b) message.obj);
                }
            } catch (Exception e) {
                e = e;
                if (a(message)) {
                    return;
                }
            }
            a.this.c.obtainMessage(message.what, e).sendToTarget();
        }

        public Message a(int i, Object obj, boolean z) {
            return obtainMessage(i, z ? 1 : 0, 0, obj);
        }

        private boolean a(Message message) {
            int i;
            if (!(message.arg1 == 1) || (i = message.arg2 + 1) > a.this.l) {
                return false;
            }
            Message messageObtain = Message.obtain(message);
            messageObtain.arg2 = i;
            sendMessageDelayed(messageObtain, a(i));
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"HandlerLeak"})
    public class g extends Handler {
        public g(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                a.this.a(message.obj);
            } else {
                if (i != 1) {
                    return;
                }
                a.this.b(message.obj);
            }
        }
    }

    public a(UUID uuid, com.opos.exoplayer.core.drm.d<T> dVar, InterfaceC0686a<T> interfaceC0686a, byte[] bArr, String str, int i, byte[] bArr2, HashMap<String, String> map, com.opos.exoplayer.core.drm.g gVar, Looper looper, Handler handler, DefaultDrmSessionManager.a aVar, int i2) {
        this.b = uuid;
        this.e = interfaceC0686a;
        this.d = dVar;
        this.h = i;
        this.t = bArr2;
        this.i = map;
        this.f8143a = gVar;
        this.l = i2;
        this.j = handler;
        this.k = aVar;
        this.c = new g(looper);
        HandlerThread handlerThread = new HandlerThread("DrmRequestHandler");
        this.o = handlerThread;
        handlerThread.start();
        this.p = new f(this.o.getLooper());
        if (bArr2 == null) {
            this.f = bArr;
            this.g = str;
        } else {
            this.f = null;
            this.g = null;
        }
    }

    private boolean i() {
        try {
            this.d.b(this.s, this.t);
            return true;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.d("DefaultDrmSession", "Error trying to restore Widevine keys.", e2);
            c(e2);
            return false;
        }
    }

    private long j() {
        if (!C.e.equals(this.b)) {
            return Long.MAX_VALUE;
        }
        Pair<Long, Long> pairA = h.a(this);
        return Math.min(((Long) pairA.first).longValue(), ((Long) pairA.second).longValue());
    }

    private void k() {
        if (this.m == 4) {
            this.m = 3;
            c(new com.opos.exoplayer.core.drm.f());
        }
    }

    private boolean l() {
        int i = this.m;
        return i == 3 || i == 4;
    }

    public void c() {
        this.p.a(0, this.d.b(), true).sendToTarget();
    }

    public void d() {
        if (a(false)) {
            b(true);
        }
    }

    @Override // com.opos.exoplayer.core.drm.DrmSession
    public final int e() {
        return this.m;
    }

    @Override // com.opos.exoplayer.core.drm.DrmSession
    public final DrmSession.a f() {
        if (this.m == 1) {
            return this.r;
        }
        return null;
    }

    @Override // com.opos.exoplayer.core.drm.DrmSession
    public final T g() {
        return this.q;
    }

    @Override // com.opos.exoplayer.core.drm.DrmSession
    public Map<String, String> h() {
        byte[] bArr = this.s;
        if (bArr == null) {
            return null;
        }
        return this.d.c(bArr);
    }

    private void c(Exception exc) {
        this.r = new DrmSession.a(exc);
        Handler handler = this.j;
        if (handler != null && this.k != null) {
            handler.post(new e(exc));
        }
        if (this.m != 4) {
            this.m = 1;
        }
    }

    public void a() {
        int i = this.n + 1;
        this.n = i;
        if (i == 1 && this.m != 1 && a(true)) {
            b(true);
        }
    }

    private void b(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.e.a(this);
        } else {
            c(exc);
        }
    }

    public void a(int i) {
        if (l()) {
            if (i == 1) {
                this.m = 3;
                this.e.a(this);
            } else if (i == 2) {
                b(false);
            } else {
                if (i != 3) {
                    return;
                }
                k();
            }
        }
    }

    private void a(int i, boolean z) {
        try {
            d.b bVarA = this.d.a(i == 3 ? this.t : this.s, this.f, this.g, i, this.i);
            if (C.d.equals(this.b)) {
                bVarA = new d.a(i.a(bVarA.a()), bVarA.b());
            }
            this.p.a(1, bVarA, z).sendToTarget();
        } catch (Exception e2) {
            b(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Object obj) {
        Handler handler;
        Runnable dVar;
        if (l()) {
            if (obj instanceof Exception) {
                b((Exception) obj);
                return;
            }
            try {
                byte[] bArrB = (byte[]) obj;
                if (C.d.equals(this.b)) {
                    bArrB = i.b(bArrB);
                }
                if (this.h == 3) {
                    this.d.a(this.t, bArrB);
                    handler = this.j;
                    if (handler == null || this.k == null) {
                        return;
                    } else {
                        dVar = new c();
                    }
                } else {
                    byte[] bArrA = this.d.a(this.s, bArrB);
                    int i = this.h;
                    if ((i == 2 || (i == 0 && this.t != null)) && bArrA != null && bArrA.length != 0) {
                        this.t = bArrA;
                    }
                    this.m = 4;
                    handler = this.j;
                    if (handler == null || this.k == null) {
                        return;
                    } else {
                        dVar = new d();
                    }
                }
                handler.post(dVar);
            } catch (Exception e2) {
                b(e2);
            }
        }
    }

    private void b(boolean z) {
        int i = this.h;
        int i2 = 1;
        if (i != 0 && i != 1) {
            if (i == 2) {
                if (this.t != null && !i()) {
                    return;
                }
                a(2, z);
                return;
            }
            i2 = 3;
            if (i != 3 || !i()) {
                return;
            }
            a(i2, z);
        }
        if (this.t != null) {
            if (this.m == 4 || i()) {
                long j = j();
                if (this.h == 0 && j <= 60) {
                    com.opos.cmn.an.f.a.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + j);
                    a(2, z);
                    return;
                }
                if (j <= 0) {
                    c(new com.opos.exoplayer.core.drm.f());
                    return;
                }
                this.m = 4;
                Handler handler = this.j;
                if (handler == null || this.k == null) {
                    return;
                }
                handler.post(new b());
                return;
            }
            return;
        }
        a(i2, z);
    }

    public void a(Exception exc) {
        c(exc);
    }

    public boolean b() {
        int i = this.n - 1;
        this.n = i;
        if (i != 0) {
            return false;
        }
        this.m = 0;
        this.c.removeCallbacksAndMessages(null);
        this.p.removeCallbacksAndMessages(null);
        this.p = null;
        this.o.quit();
        this.o = null;
        this.q = null;
        this.r = null;
        byte[] bArr = this.s;
        if (bArr != null) {
            this.d.a(bArr);
            this.s = null;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        if (this.m == 2 || l()) {
            if (obj instanceof Exception) {
                this.e.a((Exception) obj);
                return;
            }
            try {
                this.d.b((byte[]) obj);
                this.e.a();
            } catch (Exception e2) {
                this.e.a(e2);
            }
        }
    }

    public boolean b(byte[] bArr) {
        return Arrays.equals(this.s, bArr);
    }

    private boolean a(boolean z) {
        if (l()) {
            return true;
        }
        try {
            byte[] bArrA = this.d.a();
            this.s = bArrA;
            this.q = (T) this.d.d(bArrA);
            this.m = 3;
            return true;
        } catch (NotProvisionedException e2) {
            if (z) {
                this.e.a(this);
                return false;
            }
            c(e2);
            return false;
        } catch (Exception e3) {
            c(e3);
            return false;
        }
    }

    public boolean a(byte[] bArr) {
        return Arrays.equals(this.f, bArr);
    }
}
