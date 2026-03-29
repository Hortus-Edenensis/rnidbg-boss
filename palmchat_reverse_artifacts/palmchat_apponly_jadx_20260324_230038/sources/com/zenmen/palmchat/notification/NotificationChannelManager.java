package com.zenmen.palmchat.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.p34;
import defpackage.sz3;
import defpackage.tz3;
import defpackage.vs0;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class NotificationChannelManager {

    /* JADX INFO: compiled from: SearchBox */
    public enum MessageType {
        MSG(p34.e()),
        SUBSCRIPTION_MSG(p34.h()),
        INTERACTIVE(p34.d()),
        MOMENT(p34.f()),
        PUBLIC(p34.g()),
        APP_INFO(p34.a());

        private p34 info;

        MessageType(p34 p34Var) {
            this.info = p34Var;
        }

        private void createNotificationChannel(Context context, String str, int i, int i2, int i3) {
            NotificationManager notificationManager;
            try {
                if (Build.VERSION.SDK_INT >= 26 && (notificationManager = (NotificationManager) context.getSystemService("notification")) != null) {
                    try {
                        if (notificationManager.getNotificationChannel(str) == null) {
                            String string = context.getString(i);
                            String string2 = context.getString(i2);
                            tz3.a();
                            NotificationChannel notificationChannelA = sz3.a(str, string, i3);
                            notificationChannelA.setDescription(string2);
                            notificationChannelA.enableVibration(true);
                            notificationChannelA.enableLights(true);
                            notificationChannelA.setLockscreenVisibility(1);
                            notificationManager.createNotificationChannel(notificationChannelA);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception unused) {
            }
        }

        public NotificationCompat.Builder genNotificationCompatBuilder() {
            return new NotificationCompat.Builder(AppContext.getContext(), getNotificationChannel()).setCategory(this.info.e);
        }

        public String getNotificationChannel() {
            boolean zC = NotificationChannelManager.c();
            String strB = this.info.b(zC);
            int iC = this.info.c(zC);
            AppContext context = AppContext.getContext();
            p34 p34Var = this.info;
            createNotificationChannel(context, strB, p34Var.b, p34Var.c, iC);
            LogUtil.i("NotificationChannelManager", "notificationInfo channelId=" + strB + " category=" + this.info.e + " importance=" + iC + " isEnable=" + zC);
            return strB;
        }

        public String getNotificationChannelForLog() {
            return this.info.b(NotificationChannelManager.c());
        }
    }

    public static boolean a(MessageType messageType) {
        boolean zCanNotify = b().canNotify(messageType);
        LogUtil.i("NotificationChannelManager", "canNotify=" + zCanNotify + " type =" + messageType);
        return zCanNotify;
    }

    public static StrictConfig b() {
        StrictConfig strictConfig;
        JSONObject config = vs0.a().getConfig("notification_importance_config");
        if (config == null || (strictConfig = (StrictConfig) az2.a(config.toString(), StrictConfig.class)) == null) {
            strictConfig = null;
        }
        return strictConfig == null ? new StrictConfig() : strictConfig;
    }

    public static boolean c() {
        return b().isStrict();
    }

    public static boolean d() {
        return b().isTmpChatStrict();
    }
}
