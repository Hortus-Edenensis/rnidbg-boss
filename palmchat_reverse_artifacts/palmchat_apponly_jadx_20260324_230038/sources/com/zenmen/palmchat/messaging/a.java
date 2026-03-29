package com.zenmen.palmchat.messaging;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.GlobalConfig;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.messaging.CreateConnectionDelegate;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ir5;
import defpackage.lg2;
import defpackage.mo3;
import defpackage.ns;
import defpackage.r75;
import defpackage.rl0;
import defpackage.xo6;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class a {
    public static final String n = "a";
    public static int o = 0;
    public static Integer p = null;
    public static boolean q = true;
    public HandlerThread b;
    public Handler c;
    public CreateConnectionDelegate d;
    public Context e;
    public CreateConnectionDelegate.k f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xo6 f14696a = null;
    public boolean g = false;
    public long h = 0;
    public Object i = new Object();
    public long j = 0;
    public long k = 0;
    public h l = new f();
    public h m = new g();

    /* JADX INFO: renamed from: com.zenmen.palmchat.messaging.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1076a extends TimerTask {
        public C1076a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a.this.p(false, "TimerTaskFire");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14698a;

        public b(String str) {
            this.f14698a = str;
            put("action", "MessagingService");
            put("status", "onStartCommand");
            put("detail", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            xo6 xo6Var = a.this.f14696a;
            if (xo6Var != null) {
                xo6Var.l();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14700a;

        public d(boolean z) {
            this.f14700a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Math.abs(ir5.b() - a.this.j) > 30000) {
                a.this.j = ir5.b();
                if (this.f14700a) {
                    MessagingService.setSecretKeys(null, null);
                    AppContext.setContextSecretKey(null);
                }
                if (a.this.l()) {
                    a.this.f14696a.l();
                    a.this.f14696a = null;
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14701a;

        public e(String str) {
            this.f14701a = str;
            put("action", "msg_reconnect");
            put("status", "startConnectXNetwork retryCount =" + a.o);
            put("detail", str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends h {
        public f() {
            super();
        }

        @Override // com.zenmen.palmchat.messaging.a.h
        public long a(int i) {
            return (b() - i) * d();
        }

        @Override // com.zenmen.palmchat.messaging.a.h
        public int b() {
            return a.this.h();
        }

        public int d() {
            return 1000;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends h {
        public int b;

        public g() {
            super();
            this.b = 2;
        }

        @Override // com.zenmen.palmchat.messaging.a.h
        public long a(int i) {
            return (b() - i) * d();
        }

        @Override // com.zenmen.palmchat.messaging.a.h
        public int b() {
            return a.this.h() / this.b;
        }

        public int d() {
            return this.b * 1000;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public abstract class h {
        public h() {
        }

        public abstract long a(int i);

        public abstract int b();

        public int c(int i) {
            return Math.min(b(), i) - 1;
        }
    }

    public a(Context context, CreateConnectionDelegate.k kVar) {
        this.e = context;
        this.f = kVar;
        j();
    }

    public long e(long j) {
        GlobalConfig globalConfigE = rl0.h().e();
        if (globalConfigE == null) {
            return j;
        }
        long jB = (long) (globalConfigE.b() * j);
        return jB > 0 ? jB : j;
    }

    public void f() {
        if (m()) {
            this.f14696a.r();
        }
    }

    public xo6 g() {
        return this.f14696a;
    }

    public final int h() {
        if (p == null) {
            GlobalConfig globalConfigE = rl0.h().e();
            if (globalConfigE == null || globalConfigE.c() <= 0) {
                p = 10;
            } else {
                p = Integer.valueOf(globalConfigE.c());
            }
        }
        return p.intValue();
    }

    public h i() {
        return ns.c().b().isReConnectPolicySwitch() ? AppContext.getContext().isBackground() ? this.m : this.l : this.l;
    }

    public final void j() {
        HandlerThread handlerThreadA = lg2.a("messaging_service_working_thread");
        this.b = handlerThreadA;
        handlerThreadA.start();
        this.c = new Handler(this.b.getLooper());
        this.d = new CreateConnectionDelegate(this.e, this.f);
        x();
    }

    public boolean k() {
        xo6 xo6Var = this.f14696a;
        if (xo6Var == null) {
            return false;
        }
        return xo6Var.u();
    }

    public boolean l() {
        xo6 xo6Var = this.f14696a;
        if (xo6Var == null) {
            return false;
        }
        return xo6Var.i();
    }

    public boolean m() {
        xo6 xo6Var = this.f14696a;
        return xo6Var != null && xo6Var.i() && this.f14696a.u();
    }

    public final void n() {
        if (Math.abs(ir5.b() - this.k) >= 90000) {
            this.k = ir5.b();
            Intent intent = new Intent();
            intent.setAction(mo3.b);
            LocalBroadcastManager.getInstance(AppContext.getContext()).sendBroadcast(intent);
        }
    }

    public void o() {
        synchronized (this.i) {
            this.i.notifyAll();
        }
    }

    public void p(boolean z, String str) {
        LogUtil.i(n, 3, new b("needResetSk=" + z + "reason=" + str), (Throwable) null);
        if (z) {
            s(true);
        } else {
            w(true, str);
            q();
        }
    }

    public void q() {
        xo6 xo6Var;
        if (SystemClock.elapsedRealtime() - this.h < MessagingService.d() || (xo6Var = this.f14696a) == null || !xo6Var.i()) {
            return;
        }
        this.f14696a.x();
        this.h = SystemClock.elapsedRealtime();
    }

    public void r() throws RemoteException {
        xo6 xo6Var = this.f14696a;
        if (xo6Var == null || !xo6Var.i()) {
            LogUtil.d(MessagingService.c, "reconnect startConnectXNetwork", 3);
            w(true, "STASRT_REASON_RECONNECT");
        } else {
            LogUtil.d(MessagingService.c, "reconnect closeConnection", 3);
            this.c.post(new c());
        }
    }

    public synchronized void s(boolean z) {
        this.c.post(new d(z));
    }

    public void t(xo6 xo6Var) {
        this.f14696a = xo6Var;
    }

    public void u(boolean z) {
        q = z;
    }

    public void v(boolean z) {
        this.g = z;
        if (z) {
            this.k = ir5.b();
        }
    }

    public synchronized void w(boolean z, String str) {
        if (!m() && !TextUtils.isEmpty(AccountUtils.p(AppContext.getContext())) && !TextUtils.isEmpty(AccountUtils.o(AppContext.getContext())) && !r75.k()) {
            h hVarI = i();
            if (z) {
                this.c.removeCallbacks(this.d);
                o = hVarI.b();
            }
            LogUtil.i(n, LogUtil.LogType.LOG_TYPE_QA_SOCKET, 3, new e(str), (Throwable) null);
            int i = o;
            if (i > 0) {
                int iC = hVarI.c(i);
                o = iC;
                this.c.postDelayed(this.d, e(hVarI.a(iC)));
            } else if (q) {
                n();
                q = false;
            }
            if (this.g) {
                n();
            }
        }
    }

    public final void x() {
        new Timer().schedule(new C1076a(), 10000L, MessagingService.d());
    }

    public void y(long j) {
        synchronized (this.i) {
            try {
                this.i.wait(j);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void z(long j) {
        if (m()) {
            return;
        }
        y(j);
    }
}
