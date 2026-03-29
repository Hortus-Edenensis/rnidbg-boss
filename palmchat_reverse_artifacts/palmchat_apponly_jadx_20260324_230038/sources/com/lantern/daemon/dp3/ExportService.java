package com.lantern.daemon.dp3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.lantern.daemon.dp3.utils.StatReceiverJ;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ExportService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        HashMap map = new HashMap();
        map.put("type", "file_lock_start");
        StatReceiverJ.stat(this, map);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        ProcessUtils.startBindService(this, DaemonProcessService.class);
        return super.onStartCommand(intent, i, i2);
    }
}
