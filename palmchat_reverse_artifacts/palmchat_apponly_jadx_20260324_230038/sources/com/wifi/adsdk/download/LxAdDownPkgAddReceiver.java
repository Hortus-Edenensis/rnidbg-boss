package com.wifi.adsdk.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdDownPkgAddReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String schemeSpecificPart;
        String action = intent.getAction();
        Uri data = intent.getData();
        if (data != null && (schemeSpecificPart = data.getSchemeSpecificPart()) != null && action.equals("android.intent.action.PACKAGE_ADDED") && LxAdDLManager.getInstance(context).getDownStatus(schemeSpecificPart) == LxAdDLManager.STATUS_DOWNED) {
            LxAdDLManager.getInstance(context).startApp(LxAdDLManager.getInstance(context).getDownUrl(schemeSpecificPart), schemeSpecificPart);
            LxAdDLManager.getInstance(context).saveDownInstallenSpStatus(schemeSpecificPart);
            LxAdDLManager.getInstance(context).adDownLoadChange(schemeSpecificPart, 0, "");
            LxAdDLManager.getInstance(context).checkInstallRealReport(schemeSpecificPart);
        }
    }
}
