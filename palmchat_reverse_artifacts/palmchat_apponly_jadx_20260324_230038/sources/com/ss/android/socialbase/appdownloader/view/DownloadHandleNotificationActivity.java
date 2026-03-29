package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.huawei.openalliance.ad.constant.x;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class DownloadHandleNotificationActivity extends Activity {
    private static final String[] u = {x.cI};
    private DownloadHandlerService nr = new DownloadHandlerService();

    private void u() {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                requestPermissions(u, 1000);
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.fx.u.nr("DownloadNotificationJumpActivity", "requestNotificationPermissionError:".concat(String.valueOf(th)));
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if ("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION".equals(intent.getAction())) {
            u();
        } else {
            this.nr.onStartCommand(intent, 0, 0);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1000 || iArr == null || iArr.length <= 0 || iArr[0] != 0) {
            com.ss.android.socialbase.downloader.fx.u.nr("DownloadNotificationJumpActivity", "onRequestPermissionsResultNotification Permission denied");
        }
    }
}
