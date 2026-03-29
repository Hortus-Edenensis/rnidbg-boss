package com.lantern.daemon.dp3.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.lantern.daemon.dp3.DaemonHelper;
import com.lantern.daemon.dp3.ProcessUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class StatReceiverJ extends BroadcastReceiver {
    public static StatReceiverJ receiver;

    public static void register(Context context) {
        synchronized (StatReceiverJ.class) {
            if (receiver != null) {
                return;
            }
            receiver = new StatReceiverJ();
            IntentFilter intentFilter = new IntentFilter("com.lantern.daemon.dp3.intent.action.REPORT_STAT_NOTIFY");
            intentFilter.setPriority(1000);
            context.registerReceiver(receiver, intentFilter, ProcessUtils.receiverPermission(context), null);
        }
    }

    public static void stat(Context context, HashMap map) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.lantern.daemon.dp3.intent.action.REPORT_STAT_NOTIFY");
            intent.putExtra("report_stat_info_key", map);
            intent.setPackage(context.getPackageName());
            context.sendOrderedBroadcast(intent, ProcessUtils.receiverPermission(context));
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        DaemonHelper.instance().onAlive(context.getApplicationContext(), (HashMap) intent.getSerializableExtra("report_stat_info_key"));
    }
}
