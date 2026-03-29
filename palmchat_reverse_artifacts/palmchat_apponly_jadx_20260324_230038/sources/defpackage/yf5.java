package defpackage;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.zenmen.media.msgevent.MessageDefine;
import com.zenmen.media.rtc.ZMRtcSessionInfo;
import com.zenmen.palmchat.framework.httpdns.DNSNode;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class yf5 extends g13 {
    public static yf5 v;
    public Handler k;
    public InetAddress n;
    public int o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f22188a = null;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = true;
    public Thread f = null;
    public Thread g = null;
    public Runnable h = null;
    public Thread i = null;
    public Thread j = null;
    public y36 l = null;
    public z36 m = null;
    public final int p = 49;
    public int q = 49;
    public boolean r = false;
    public int s = 3;
    public int t = 2;
    public boolean u = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!Thread.currentThread().isInterrupted() && !e.b()) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused) {
                    Log.i("SocketConnectThread", "init_async was interrupted while Thread.sleep, and exit directly");
                    return;
                }
            }
            if (Thread.currentThread().isInterrupted()) {
                Log.i("SocketConnectThread", "init_async was interrupted, and exit directly");
                return;
            }
            yf5.this.F();
            yf5 yf5Var = yf5.this;
            yf5Var.z(yf5Var.n, yf5Var.o);
            yf5.this.I();
            yf5.this.J();
            yf5.this.H();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zE;
            yf5.this.b = true;
            while (yf5.this.b) {
                try {
                    zE = yf5.this.E();
                } catch (Exception e) {
                    e.printStackTrace();
                    zE = false;
                }
                if (!zE) {
                    try {
                        if (yf5.this.t <= 0) {
                            synchronized (yf5.this.f) {
                                yf5.this.f.wait(49000L);
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (yf5.this.t > 0) {
                    yf5.this.t--;
                }
                Thread.sleep(500L);
            }
            yf5.this.l.d();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yf5.this.c = true;
            while (yf5.this.c) {
                if (yf5.this.f22188a == null || yf5.this.f22188a.size() <= 0) {
                    synchronized (this) {
                        try {
                            wait(10000L);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    yf5 yf5Var = yf5.this;
                    yf5Var.O((String) yf5Var.f22188a.get(0));
                    yf5.this.E();
                    yf5.this.f22188a.remove(0);
                }
            }
            yf5.this.m.f();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yf5.this.d = true;
            while (yf5.this.d) {
                yf5.v.x(yf5.this.u ? pa6.p().u(yf5.this.q, true, dx.a(), dx.b(hx3.g()), it0.k().f()) : pa6.p().u(yf5.this.q, false, 4, 6, ""));
                try {
                    Log.i("SocketConnectThread", "Sent heart beat to call notify server");
                    synchronized (yf5.v) {
                        while (true) {
                            yf5.this.r = false;
                            if (yf5.this.s > 0) {
                                yf5.v.wait(10000);
                                yf5.this.s--;
                                break;
                            } else {
                                if (yf5.this.q <= 30 || yf5.this.q >= 120) {
                                    yf5.v.wait(49000L);
                                    yf5.this.q = 49;
                                } else {
                                    yf5.v.wait(yf5.this.q * 1000);
                                }
                                if (!yf5.this.r) {
                                    break;
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static String f22193a = "";
        public static int b;

        public static boolean b() {
            DNSNode[] dNSNodeArrI = it0.k().i(nl0.x);
            int i = 0;
            if (dNSNodeArrI == null || dNSNodeArrI.length <= 0) {
                return false;
            }
            int iRandom = (int) (Math.random() * ((double) dNSNodeArrI.length));
            if (iRandom >= 0 && iRandom <= dNSNodeArrI.length) {
                i = iRandom;
            }
            DNSNode dNSNode = dNSNodeArrI[i];
            f(dNSNode.host, dNSNode.port);
            Log.i("SocketConnectThread", "Set call notify server to " + dNSNodeArrI[i].host + ":" + dNSNodeArrI[i].port);
            return true;
        }

        public static String c() {
            return ib1.D() != null ? "127.0.0.1" : f22193a;
        }

        public static int d() {
            if (ib1.D() != null) {
                return 0;
            }
            return b;
        }

        public static boolean e() {
            return !nl0.x.equals("");
        }

        public static void f(String str, int i) {
            f22193a = str;
            b = i;
        }
    }

    public static yf5 A() {
        if (v == null) {
            v = new yf5();
        }
        return v;
    }

    public void B(int i, String str) {
        if (str == null || this.k == null) {
            return;
        }
        try {
            Message message = new Message();
            message.what = MessageDefine.ReceiveDataFromSocket;
            message.arg1 = i;
            message.obj = str;
            ZMRtcSessionInfo zMRtcSessionInfo = new ZMRtcSessionInfo();
            pa6.p().s(str, zMRtcSessionInfo);
            Log.i("SocketConnectThread", "CallNotify: get msg type:" + zMRtcSessionInfo.signalType);
            if (!this.u) {
                if (zMRtcSessionInfo.signalType != ZMRtcSessionInfo.SignallingTypeOnCallNotify) {
                    this.k.sendMessage(message);
                }
            } else {
                if (zMRtcSessionInfo.signalType != ZMRtcSessionInfo.SignallingTypeOnCallNotify) {
                    this.k.sendMessage(message);
                    return;
                }
                if (zMRtcSessionInfo.callNotifyInterval > 0) {
                    synchronized (v) {
                        this.q = zMRtcSessionInfo.callNotifyInterval;
                        this.r = true;
                        v.notify();
                        Log.i("SocketConnectThread", "Update the call notify interval to " + this.q);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void C(InetAddress inetAddress, int i, Handler handler) {
        this.k = handler;
        this.l = y36.a();
        this.m = z36.a();
        this.n = inetAddress;
        this.o = i;
        D();
        if (ib1.D() != null) {
            ib1.D().x();
        }
    }

    public final void D() {
        if (!e.e()) {
            Log.i("SocketConnectThread", "the callnotify service doesn't exist");
            return;
        }
        g13 g13Var = new g13(new a());
        this.i = g13Var;
        g13Var.start();
    }

    public final boolean E() {
        try {
            return this.l.b();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void F() {
        K();
        M();
        L();
        y();
        List<String> list = this.f22188a;
        if (list != null) {
            list.clear();
            this.f22188a = null;
        }
    }

    public void G() {
        try {
            synchronized (v) {
                this.s = 3;
                v.notify();
            }
        } catch (Exception unused) {
        }
        try {
            synchronized (this.f) {
                this.t = 30;
                this.f.notify();
            }
        } catch (Exception unused2) {
        }
    }

    public final void H() {
        if (this.d) {
            return;
        }
        g13 g13Var = new g13(new d());
        this.j = g13Var;
        g13Var.start();
    }

    public final void I() {
        if (this.b) {
            return;
        }
        g13 g13Var = new g13(new b());
        this.f = g13Var;
        g13Var.start();
    }

    public final void J() {
        if (this.c) {
            return;
        }
        c cVar = new c();
        this.h = cVar;
        g13 g13Var = new g13(cVar);
        this.g = g13Var;
        g13Var.start();
    }

    public final void K() {
        this.d = false;
        Thread thread = this.j;
        if (thread != null) {
            try {
                thread.interrupt();
                this.j.join();
                this.j = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void L() {
        this.b = false;
        Thread thread = this.f;
        if (thread != null) {
            try {
                thread.notify();
                this.f.interrupt();
                this.f.join();
                this.f = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void M() {
        this.c = false;
        Thread thread = this.g;
        if (thread != null) {
            try {
                thread.interrupt();
                this.g.join();
                this.g = null;
                this.h = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void N() {
        F();
        try {
            Thread thread = this.i;
            if (thread != null) {
                thread.interrupt();
                this.i.join();
                this.i = null;
            }
            if (ib1.D() != null) {
                ib1.D().y();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Log.i("SocketConnectThread", "SocketConnect exited");
    }

    public final void O(String str) {
        z36 z36Var;
        if (str == null || (z36Var = this.m) == null) {
            return;
        }
        try {
            z36Var.d(str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        F();
        z(this.n, this.o);
        I();
        J();
    }

    public void x(String str) {
        if (this.f22188a == null) {
            this.f22188a = new ArrayList();
        }
        this.f22188a.add(str);
        Runnable runnable = this.h;
        if (runnable != null) {
            synchronized (runnable) {
                try {
                    this.h.notify();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void y() {
        try {
            z36 z36Var = this.m;
            if (z36Var != null) {
                z36Var.f();
            }
            y36 y36Var = this.l;
            if (y36Var != null) {
                y36Var.d();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void z(InetAddress inetAddress, int i) {
    }
}
