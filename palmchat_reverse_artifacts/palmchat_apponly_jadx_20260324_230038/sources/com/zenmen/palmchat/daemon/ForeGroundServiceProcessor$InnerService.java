package com.zenmen.palmchat.daemon;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ForeGroundServiceProcessor$InnerService extends Service {
    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        startForeground(12121, new Notification());
        stopForeground(true);
        stopSelf();
        return super.onStartCommand(intent, i, i2);
    }
}
