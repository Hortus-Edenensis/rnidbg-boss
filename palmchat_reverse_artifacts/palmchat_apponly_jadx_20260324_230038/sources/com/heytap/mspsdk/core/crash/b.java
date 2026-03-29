package com.heytap.mspsdk.core.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.mspsdk.log.MspLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        MspLog.d("AppCrashReceiver", "AppCrashReceiver onReceive");
        if (TextUtils.isEmpty(intent.getAction())) {
            MspLog.d("AppCrashReceiver", "AppCrashReceiver onReceive action is null");
            return;
        }
        MspLog.d("AppCrashReceiver", "AppCrashReceiver onReceive action:" + intent.getAction());
        if (intent.getAction().equals("com.heytap.htms.sub_process_crash")) {
            String stringExtra = intent.getStringExtra("key_msp_app_crash_process_name");
            int intExtra = intent.getIntExtra("key_msp_app_crash_count", 0);
            int intExtra2 = intent.getIntExtra("key_msp_app_launch_count", 0);
            int intExtra3 = intent.getIntExtra("key_msp_app_version_code", 0);
            String stringExtra2 = intent.getStringExtra("key_msp_app_version_name");
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            a.a().a(context, stringExtra, intExtra, intExtra2, intExtra3, stringExtra2);
        }
    }
}
