package com.qq.gdt.action.multioprocess;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import com.qq.gdt.action.j.o;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UserMessageChangeReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f10540a = "_gdt.action.USER_MESSAGE_CHANGED";
    public static String b = ".gdt.qq.RECEIVE_PERMISSION";
    public static String c = ".gdt.qq.SEND_PERMISSION";
    private HandlerThread d;
    private Handler e;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Context f10541a;
        Intent b;

        public a(Context context, Intent intent) {
            this.f10541a = context;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UserMessageChangeReceiver.f10540a.equals(this.b.getAction())) {
                    o.a("UserMessageChangeReceiver intent:" + this.b, new Object[0]);
                    b bVar = (b) this.b.getSerializableExtra("user_message");
                    o.a("UserMessageChangeReceiver userMessage :" + bVar, new Object[0]);
                    if (bVar != null) {
                        d.a().f10548a = bVar;
                    }
                }
            } catch (Throwable th) {
                o.a("onReceive e", th);
            }
        }
    }

    public UserMessageChangeReceiver() {
        Context contextG = com.qq.gdt.action.d.a().g();
        if (contextG != null) {
            f10540a = contextG.getPackageName() + f10540a;
            b = contextG.getPackageName() + b;
            c = contextG.getPackageName() + c;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        o.a("UserMessageChangeReceiver onReceive:" + intent, new Object[0]);
        if (this.d == null) {
            HandlerThread handlerThread = new HandlerThread("receive HandlerThread");
            this.d = handlerThread;
            handlerThread.start();
        }
        if (this.e == null) {
            this.e = new Handler(this.d.getLooper());
        }
        this.e.removeCallbacksAndMessages(null);
        this.e.postDelayed(new a(context, intent), 1000L);
    }
}
