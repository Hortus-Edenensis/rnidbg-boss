package com.baidu.xclient.gdid.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.xclient.gdid.d;
import com.igexin.sdk.PushConsts;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4307a = "action_tir_mshield";
    public boolean b = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f4308a;
        public final /* synthetic */ Context b;

        public a(Intent intent, Context context) {
            this.f4308a = intent;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = this.f4308a;
                if (intent == null) {
                    return;
                }
                String action = intent.getAction();
                if (b.f4307a.equals(action)) {
                    d.a().a(false, true);
                    return;
                }
                if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
                    if (b.this.b) {
                        b.this.b = false;
                    } else if (com.baidu.xclient.gdid.j.d.a(this.b)) {
                        d.a().a(false, false);
                    }
                }
            } catch (Throwable th) {
                com.baidu.xclient.gdid.j.d.a(th);
            }
        }
    }

    public final void a(Context context, Intent intent) {
        com.baidu.xclient.gdid.j.b.a().a(new a(intent, context));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
        }
    }
}
