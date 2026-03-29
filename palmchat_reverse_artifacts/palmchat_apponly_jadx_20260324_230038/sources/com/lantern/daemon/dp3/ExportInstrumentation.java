package com.lantern.daemon.dp3;

import android.app.Application;
import android.app.Instrumentation;
import android.os.Bundle;
import android.util.Log;
import com.lantern.daemon.dp3.utils.StatReceiverJ;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ExportInstrumentation extends Instrumentation {
    @Override // android.app.Instrumentation
    public void callApplicationOnCreate(Application application) {
        super.callApplicationOnCreate(application);
        HashMap map = new HashMap();
        map.put("type", "file_lock_start");
        StatReceiverJ.stat(application, map);
        Log.d(DaemonHelper.TAG, "ExportInstrumentation callApplicationOnCreate: ");
    }

    @Override // android.app.Instrumentation
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(DaemonHelper.TAG, "ExportInstrumentation onCreate: ");
        ProcessUtils.startBindService(getTargetContext(), DaemonProcessService.class);
    }
}
