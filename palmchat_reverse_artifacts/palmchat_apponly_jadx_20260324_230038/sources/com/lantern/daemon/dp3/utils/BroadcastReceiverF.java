package com.lantern.daemon.dp3.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.lantern.daemon.dp3.ProcessUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class BroadcastReceiverF extends BroadcastReceiver {
    public static BroadcastReceiverF receiver;
    public IAssist assist;

    /* JADX INFO: compiled from: SearchBox */
    public interface IAssist {
        void onReceive(Context context);
    }

    public static void register(Context context, IAssist iAssist) {
        synchronized (BroadcastReceiverF.class) {
            if (receiver != null) {
                return;
            }
            BroadcastReceiverF broadcastReceiverF = new BroadcastReceiverF();
            receiver = broadcastReceiverF;
            broadcastReceiverF.assist = iAssist;
            IntentFilter intentFilter = new IntentFilter("com.lantern.daemon.dp3.intent.action.MAIN_PROCESS_START_NOTIFY");
            intentFilter.setPriority(1000);
            context.registerReceiver(receiver, intentFilter, ProcessUtils.receiverPermission(context), null);
        }
    }

    public static void sendBroadcast(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.lantern.daemon.dp3.intent.action.MAIN_PROCESS_START_NOTIFY");
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent, ProcessUtils.receiverPermission(context));
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IAssist iAssist = this.assist;
        if (iAssist != null) {
            iAssist.onReceive(context);
        }
    }
}
