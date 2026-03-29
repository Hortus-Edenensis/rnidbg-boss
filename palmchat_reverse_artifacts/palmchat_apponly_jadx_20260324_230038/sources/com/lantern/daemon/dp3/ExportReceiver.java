package com.lantern.daemon.dp3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.lantern.daemon.dp3.utils.StatReceiverJ;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ExportReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        HashMap map = new HashMap();
        map.put("type", "file_lock_start");
        StatReceiverJ.stat(context, map);
        ProcessUtils.startBindService(context.getApplicationContext(), DaemonProcessService.class);
    }
}
