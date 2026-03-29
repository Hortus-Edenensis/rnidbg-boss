package com.lantern.daemon.dp3;

import android.content.Context;
import com.lantern.daemon.dp3.DaemonHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ServiceHelper implements DaemonHelper.IServiceHelper {
    @Override // com.lantern.daemon.dp3.DaemonHelper.IServiceHelper
    public boolean startBindService(Context context, String str) {
        DaemonHelper.DaemonParams daemonParams;
        Class cls;
        try {
            daemonParams = DaemonHelper.instance().getDaemonParams();
        } catch (Exception unused) {
        }
        if (str.equals(daemonParams.processDaemon)) {
            cls = DaemonProcessService.class;
        } else {
            if (!str.equals(daemonParams.processAssist)) {
                if (str.equals(daemonParams.processAssist1)) {
                    cls = Assist1ProcessService.class;
                }
                return false;
            }
            cls = AssistProcessService.class;
        }
        ProcessUtils.startBindService(context, cls);
        return true;
    }
}
