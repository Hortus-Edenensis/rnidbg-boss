package com.lantern.daemon.dp3.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.lantern.daemon.dp3.DaemonHelper;
import com.lantern.daemon.dp3.ProcessUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class BroadcastReceiverA extends BroadcastReceiver {
    public static BroadcastReceiverA receiver;

    public static void register(Context context) {
        synchronized (BroadcastReceiverA.class) {
            if (receiver != null) {
                return;
            }
            receiver = new BroadcastReceiverA();
            IntentFilter intentFilter = new IntentFilter("com.lantern.daemon.dp3.intent.action.SERVICE_START_NOTIFY");
            intentFilter.setPriority(1000);
            context.registerReceiver(receiver, intentFilter, ProcessUtils.receiverPermission(context), null);
        }
    }

    public static void send(Context context, String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.lantern.daemon.dp3.intent.action.SERVICE_START_NOTIFY");
            intent.putExtra("package_name_key", str);
            intent.putExtra("service_name_key", str2);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent, ProcessUtils.receiverPermission(context));
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("package_name_key");
        String stringExtra2 = intent.getStringExtra("service_name_key");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        DaemonHelper.instance().bindService(stringExtra, stringExtra2);
    }
}
