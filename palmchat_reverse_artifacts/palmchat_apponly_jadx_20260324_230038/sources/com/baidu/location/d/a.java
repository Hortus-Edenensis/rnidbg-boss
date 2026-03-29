package com.baidu.location.d;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.LLSInterface;
import com.baidu.location.b.aa;
import com.baidu.location.b.ab;
import com.baidu.location.b.b;
import com.baidu.location.b.c;
import com.baidu.location.b.e;
import com.baidu.location.b.k;
import com.baidu.location.b.l;
import com.baidu.location.b.p;
import com.baidu.location.b.w;
import com.baidu.location.b.x;
import com.baidu.location.b.z;
import com.baidu.location.c.d;
import com.baidu.location.e.h;
import com.baidu.location.f;
import com.baidu.mshield.x6.EngineImpl;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends Service implements LLSInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static HandlerC0066a f3507a;
    public static long c;
    private static long g;
    Messenger b = null;
    private Looper d = null;
    private HandlerThread e = null;
    private boolean f = true;
    private int h = 0;
    private boolean i = true;

    /* JADX INFO: renamed from: com.baidu.location.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class HandlerC0066a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<a> f3509a;

        public HandlerC0066a(Looper looper, a aVar) {
            super(looper);
            this.f3509a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = this.f3509a.get();
            if (aVar == null) {
                return;
            }
            if (f.isServing) {
                int i = message.what;
                if (i == 11) {
                    aVar.a(message);
                } else if (i == 12) {
                    aVar.b(message);
                } else if (i == 15) {
                    aVar.c(message);
                } else if (i == 22) {
                    p.c().b(message);
                } else if (i == 41) {
                    p.c().i();
                } else if (i == 401) {
                    try {
                        message.getData();
                    } catch (Exception unused) {
                    }
                } else if (i == 406) {
                    k.a().e();
                } else if (i == 705) {
                    b.a().a(message.getData().getBoolean("foreground"));
                }
            }
            if (message.what == 1) {
                aVar.b();
            }
            if (message.what == 0) {
                aVar.a();
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        d.a().e();
        aa.a().f();
        com.baidu.location.c.f.a().d();
        p.c().e();
        k.a().c();
        if (this.i) {
            z.d();
        }
        b.a().b();
        try {
            x.a().d();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.h = 4;
        if (this.f) {
            return;
        }
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        b.a().c(message);
    }

    @Override // com.baidu.location.LLSInterface
    public double getVersion() {
        return 9.652999877929688d;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public IBinder onBind(Intent intent) {
        String string;
        String string2;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            com.baidu.location.e.b.h = extras.getString("key");
            com.baidu.location.e.b.g = extras.getString("sign");
            this.f = extras.getBoolean("kill_process");
            extras.getBoolean("cache_exception");
            string = extras.getString("auth_key");
            string2 = extras.getString(EngineImpl.KEY_CUID);
            h.aZ = extras.getString("proxyHost");
            h.ba = extras.getInt("proxyPort");
            h.bb = extras.getString("username");
            h.bc = extras.getString("password");
        } else {
            string = null;
            string2 = null;
        }
        if (string != null) {
            com.baidu.location.a.a.a().a(f.getServiceContext(), string);
        }
        if (!TextUtils.isEmpty(h.aZ) && h.ba != -1) {
            LBSAuthManager.getInstance(f.getServiceContext()).setProxy(h.aZ, h.ba);
        }
        if (!TextUtils.isEmpty(h.bb) && !TextUtils.isEmpty(h.bc)) {
            LBSAuthManager.getInstance(f.getServiceContext()).setHttpProxyUsernameAndPassword(h.bb, h.bc);
        }
        com.baidu.location.a.a.a().a(f.getServiceContext());
        com.baidu.location.e.b.a().a(string2);
        return this.b.getBinder();
    }

    @Override // com.baidu.location.LLSInterface
    public void onCreate(Context context) {
        ab.a().a(context);
        LBSAuthManager.getInstance(f.getServiceContext()).setPrivacyMode(true);
        try {
            h.aw = context.getPackageName();
        } catch (Exception unused) {
        }
        g = System.currentTimeMillis();
        HandlerThread handlerThreadA = w.a();
        this.e = handlerThreadA;
        if (handlerThreadA != null) {
            this.d = handlerThreadA.getLooper();
        }
        f3507a = this.d == null ? new HandlerC0066a(Looper.getMainLooper(), this) : new HandlerC0066a(this.d, this);
        c = System.currentTimeMillis();
        this.b = new Messenger(f3507a);
        f3507a.sendEmptyMessage(0);
        this.h = 1;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onDestroy() {
        try {
            f3507a.sendEmptyMessage(1);
        } catch (Exception unused) {
            Log.d("baidu_location_service", "baidu location service stop exception...");
            this.i = false;
            b();
            Process.killProcess(Process.myPid());
        }
        this.h = 3;
        Handler handler = new Handler(Looper.getMainLooper());
        final WeakReference weakReference = new WeakReference(this);
        handler.postDelayed(new Runnable() { // from class: com.baidu.location.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                a aVar = (a) weakReference.get();
                if (aVar == null || aVar.h != 3) {
                    return;
                }
                Log.d("baidu_location_service", "baidu location service force stopped ...");
                aVar.i = false;
                aVar.b();
            }
        }, 1000L);
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onTaskRemoved(Intent intent) {
        Log.d("baidu_location_service", "baidu location service remove task...");
    }

    @Override // com.baidu.location.LLSInterface
    public boolean onUnBind(Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.baidu.location.e.a.a.a().b();
        com.baidu.location.e.b.a();
        e.a().a(f.getServiceContext());
        c.b().b(false);
        c.b().c();
        try {
            aa.a().e();
        } catch (Exception unused) {
        }
        l.a().a(f.getServiceContext());
        k.a().b();
        d.a().b();
        com.baidu.location.c.f.a().b();
        com.baidu.location.c.f.a().a(f.getServiceContext());
        p.c().d();
        this.h = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        b.a().b(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        b.a().a(message);
    }
}
