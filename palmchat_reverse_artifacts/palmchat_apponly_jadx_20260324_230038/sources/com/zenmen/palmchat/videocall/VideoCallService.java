package com.zenmen.palmchat.videocall;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import defpackage.ny;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class VideoCallService extends Service {
    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
        ny.b();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            try {
                if ("action_foreground".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("call_type", 0);
                    if (intent.getBooleanExtra("is_ve_rtc", false)) {
                        startForeground(MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL, ny.f(intExtra, true));
                    } else if (VideoCallActivity.o3().Y) {
                        startForeground(MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL, ny.f(intExtra, false));
                    } else {
                        startForeground(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, ny.g(intExtra, false));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
