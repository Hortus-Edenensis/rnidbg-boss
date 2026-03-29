package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.igexin.sdk.PushConsts;
import defpackage.xw6;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class rt6 implements xw6.c {
    public static rt6 g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20570a;
    public a37 b;
    public xw6 c;
    public IntentFilter d;
    public BroadcastReceiver e;
    public b f;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(action)) {
                rt6.this.f.b();
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                rt6.this.f.a();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<rt6> f20572a;

        public b(Looper looper, rt6 rt6Var) {
            super(looper);
            this.f20572a = new WeakReference<>(rt6Var);
        }

        public void a() {
            if (hasMessages(0)) {
                return;
            }
            sendEmptyMessageDelayed(0, 10000L);
        }

        public void b() {
            if (hasMessages(0)) {
                removeMessages(0);
            }
            if (hasMessages(1)) {
                return;
            }
            sendEmptyMessage(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a37 a37Var;
            if (this.f20572a.get() == null || rt6.this.b == null) {
                return;
            }
            int i = message.what;
            boolean z = true;
            if (i == 0) {
                a37Var = rt6.this.b;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        return;
                    }
                    rt6.this.b.b();
                    return;
                }
                a37Var = rt6.this.b;
                z = false;
            }
            a37Var.i(z);
        }
    }

    public rt6(Context context) {
        yw6.a("wfcManager init");
        this.f20570a = context.getApplicationContext();
        this.b = new a37(context);
        yw6.a("wfcManager start");
        e();
    }

    public static rt6 b(Context context) {
        if (g == null) {
            synchronized (rt6.class) {
                if (g == null) {
                    g = new rt6(context);
                }
            }
        }
        return g;
    }

    public void c(sp2 sp2Var) {
        if (this.b == null || sp2Var == null) {
            return;
        }
        xw6 xw6Var = new xw6(this.f20570a, this);
        this.c = xw6Var;
        this.b.d(xw6Var);
        f();
        this.b.c(sp2Var);
    }

    public final void e() {
        HandlerThread handlerThread = new HandlerThread(rt6.class.getName(), 10);
        handlerThread.start();
        this.f = new b(handlerThread.getLooper(), this);
    }

    public final void f() {
        IntentFilter intentFilter = new IntentFilter();
        this.d = intentFilter;
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
        this.d.addAction("android.intent.action.SCREEN_ON");
        a aVar = new a();
        this.e = aVar;
        this.f20570a.registerReceiver(aVar, this.d);
    }

    @Override // xw6.c
    public void b() {
        b bVar = this.f;
        if (bVar != null) {
            bVar.a();
        }
    }
}
