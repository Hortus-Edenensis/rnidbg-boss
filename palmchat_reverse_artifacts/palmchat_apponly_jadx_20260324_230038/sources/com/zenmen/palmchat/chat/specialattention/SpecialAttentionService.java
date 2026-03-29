package com.zenmen.palmchat.chat.specialattention;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.igexin.sdk.PushConsts;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import defpackage.xg5;
import defpackage.zg5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SpecialAttentionService extends Service {
    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
        zg5.d();
        xg5.e().t();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                boolean zA = SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, "key_special_attention_error", false);
                if ("action_foreground_notification".equals(action) && !zA) {
                    NotificationUpdateInfo notificationUpdateInfo = (NotificationUpdateInfo) intent.getSerializableExtra("extra_foreground_notification");
                    zg5.d();
                    Notification notificationD = xg5.e().d(notificationUpdateInfo);
                    startForeground(PushConsts.MIN_FEEDBACK_ACTION, notificationD);
                    xg5.e().r(notificationD);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
