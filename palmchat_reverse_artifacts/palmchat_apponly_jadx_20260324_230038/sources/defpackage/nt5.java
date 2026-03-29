package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class nt5 {
    public static volatile nt5 e;
    public static final Object f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19598a = false;
    public ConcurrentHashMap<Integer, gt5> b = new ConcurrentHashMap<>();
    public Handler c;
    public HandlerThread d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                super.run();
            } catch (RuntimeException e) {
                k63.c("TaskHandlerManager_xxx", "handler thread run e:" + e + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                gt5 gt5Var = (gt5) nt5.this.b.get(Integer.valueOf(message.what));
                if (gt5Var != null) {
                    gt5Var.a(message);
                    if (gt5Var.b == 1) {
                        sendEmptyMessageDelayed(message.what, tt5.u().t() * 1000);
                    } else {
                        nt5.this.b.remove(Integer.valueOf(message.what));
                    }
                } else {
                    k63.l("TaskHandlerManager_xxx", "miss task:" + message.what);
                }
            } catch (Throwable th) {
                k63.l("TaskHandlerManager_xxx", "handleMessage,e:" + th);
            }
        }
    }

    public static nt5 b() {
        if (e == null) {
            synchronized (f) {
                if (e == null) {
                    e = new nt5();
                }
            }
        }
        return e;
    }

    public boolean c(int i) {
        Handler handler = this.c;
        if (handler == null) {
            return false;
        }
        return handler.hasMessages(i);
    }

    public synchronized void d(Context context) {
        if (this.f19598a) {
            return;
        }
        if (context == null) {
            k63.a("TaskHandlerManager_xxx", "init context is null");
            return;
        }
        k63.a("TaskHandlerManager_xxx", "init task manager...");
        try {
            HandlerThread handlerThread = this.d;
            if (handlerThread == null || !handlerThread.isAlive()) {
                a aVar = new a("jg_tsk_thread");
                this.d = aVar;
                aVar.start();
            }
            this.c = new b(this.d.getLooper() == null ? Looper.getMainLooper() : this.d.getLooper());
        } catch (Exception unused) {
            this.c = new b(Looper.getMainLooper());
        }
        this.f19598a = true;
    }

    public void e(int i, long j, gt5 gt5Var) {
        if (this.c == null) {
            return;
        }
        gt5Var.f17804a = j;
        gt5Var.b = 1;
        this.b.put(Integer.valueOf(i), gt5Var);
        if (this.c.hasMessages(i)) {
            k63.l("TaskHandlerManager_xxx", "registerFixedAction,same action in handler,will replace");
            this.c.removeMessages(i);
        }
        this.c.sendEmptyMessageDelayed(i, j);
    }

    public void f(int i) {
        if (this.c == null) {
            return;
        }
        this.b.remove(Integer.valueOf(i));
        this.c.removeMessages(i);
    }

    public void g(int i, long j, gt5 gt5Var) {
        if (this.c == null) {
            return;
        }
        gt5Var.b = 2;
        this.b.put(Integer.valueOf(i), gt5Var);
        if (this.c.hasMessages(i)) {
            k63.a("TaskHandlerManager_xxx", "sendMsg,replace:" + i);
            this.c.removeMessages(i);
        } else {
            k63.a("TaskHandlerManager_xxx", "sendMsg,action=" + i);
        }
        this.c.sendEmptyMessageDelayed(i, j);
    }
}
