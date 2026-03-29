package com.zenmen.media.roomchatdemo.videocallgroup;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.zenmen.media.roomchat.RTCParameters;
import defpackage.oa6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class VideoCallGroupService extends Service {
    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
        oa6.a();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            try {
                if ("group_action_foreground".equals(intent.getAction())) {
                    VideoCallGroupChattingUIActivity.w2();
                    if (VideoCallGroupChattingUIActivity.L0 == RTCParameters.MY_NAME.I_AM_ALICE) {
                        startForeground(81001, oa6.f(0));
                    } else {
                        startForeground(81001, oa6.e(0));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
