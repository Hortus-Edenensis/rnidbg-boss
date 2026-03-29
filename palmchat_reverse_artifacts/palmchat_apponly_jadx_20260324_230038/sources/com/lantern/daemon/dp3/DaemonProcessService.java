package com.lantern.daemon.dp3;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.lantern.daemon.dp3.utils.BroadcastReceiverA;
import com.lantern.daemon.dp3.utils.BroadcastReceiverD;
import com.lantern.daemon.dp3.utils.BroadcastReceiverF;
import com.lantern.daemon.dp3.utils.StatReceiverJ;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DaemonProcessService extends Service {
    public BroadcastReceiverD broadcast = new BroadcastReceiverD();

    public static void send(DaemonProcessService daemonProcessService) {
        daemonProcessService.send();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        BroadcastReceiverA.send(this, getPackageName(), DaemonProcessService.class.getName());
        BroadcastReceiverF.register(this, new AssistFA(this));
        HashMap map = new HashMap();
        map.put("type", "user_manual_start");
        DaemonHelper.instance().onAlive(this, map);
        new Handler(getMainLooper()).postDelayed(new DaemonRun(this), 10000L);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public final void send() {
        HashMap map = new HashMap();
        map.put("type", "user_manual_start");
        StatReceiverJ.stat(this, map);
    }
}
