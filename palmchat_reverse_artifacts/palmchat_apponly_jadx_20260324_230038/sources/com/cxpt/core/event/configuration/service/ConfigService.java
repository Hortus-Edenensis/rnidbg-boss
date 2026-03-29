package com.cxpt.core.event.configuration.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.lantern.core.MobEvent;
import defpackage.bm0;
import defpackage.cm0;
import defpackage.pl0;
import defpackage.ql0;
import defpackage.ul0;
import defpackage.wl0;
import defpackage.xl0;
import defpackage.xw4;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ConfigService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5536a;
    public LocalBroadcastManager b;
    public BroadcastReceiver c;
    public d d;
    public int e;
    public c f;
    public final pl0 g = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements pl0 {
        public a() {
        }

        @Override // defpackage.pl0
        public void a(int i, boolean z, List<cm0> list) {
            try {
                if (!z) {
                    ul0.b(ConfigService.this).h(list);
                    Log.i("CX_EVENT", "ConfigService onConfig callback as version:" + i);
                    ConfigService.this.e = i;
                    wl0.b(ConfigService.this.getApplicationContext(), i);
                } else if (ul0.b(ConfigService.this).c(list) != 0) {
                    Log.i("CX_EVENT", "ConfigService onConfig callback as version:" + i + "; isAll:" + z);
                    ConfigService.this.e = i;
                    wl0.b(ConfigService.this.getApplicationContext(), i);
                }
            } catch (Exception e) {
                Log.e("CX_EVENT", "ConfigService onConfig callback exception:" + e.getMessage());
            }
            ConfigService.this.d.b(0, 3600000L);
        }

        @Override // defpackage.pl0
        public void onFailed() {
            Log.i("CX_EVENT", "ConfigService onConfig callback fail");
            ConfigService.this.d.b(0, 3600000L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.i("CX_EVENT", "ConfigService Receiver, onReceive! start copy database");
            ConfigService.this.d.a(1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Log.i("CX_EVENT", "ConfigService ConfigContentObserver onChange selfChange:" + z);
            super.onChange(z);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        public void a(int i) {
            if (hasMessages(i)) {
                return;
            }
            sendEmptyMessage(i);
        }

        public void b(int i, long j) {
            if (hasMessages(i)) {
                return;
            }
            sendEmptyMessageDelayed(i, j);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                Log.i("CX_EVENT", "ConfigService request Config with version:" + ConfigService.this.e);
                xw4.b(ConfigService.this.e, ConfigService.this.g);
                return;
            }
            if (i != 1) {
                return;
            }
            Log.i("CX_EVENT", "COPY old database to new one to use, result:" + bm0.f(ConfigService.this.f5536a));
        }
    }

    public final void f() {
        HandlerThread handlerThread = new HandlerThread("Config-Request", 10);
        handlerThread.start();
        this.d = new d(handlerThread.getLooper());
    }

    public final void g() {
        try {
            this.b = LocalBroadcastManager.getInstance(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.cxpt.core.event.ACTION_COPY_DB");
            b bVar = new b();
            this.c = bVar;
            this.b.registerReceiver(bVar, intentFilter);
        } catch (Throwable th) {
            Log.e("CX_EVENT", "ConfigService registerReceiver, ex:" + th.getMessage());
        }
    }

    public final void h() {
        try {
            this.b.unregisterReceiver(this.c);
        } catch (Throwable th) {
            Log.e("CX_EVENT", "EventManager registerReceiver, ex:" + th.getMessage());
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.i("CX_EVENT", "ConfigService onCreate!");
        this.f5536a = this;
        f();
        int iA = wl0.a(getApplicationContext());
        this.e = iA;
        if (iA == 0) {
            xl0.a(this);
        }
        this.f = new c(new Handler());
        getContentResolver().registerContentObserver(ql0.b(this), true, this.f);
        g();
    }

    @Override // android.app.Service
    public void onDestroy() {
        h();
        getContentResolver().unregisterContentObserver(this.f);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.d.b(0, 3000L);
        if (bm0.c()) {
            Log.e("CX_EVENT", "ConfigService onStartCommand database need copy!");
            this.d.a(1);
        }
        return MobEvent.notSticky ? 2 : 1;
    }
}
