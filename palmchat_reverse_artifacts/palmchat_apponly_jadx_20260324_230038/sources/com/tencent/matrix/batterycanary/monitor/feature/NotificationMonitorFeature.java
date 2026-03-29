package com.tencent.matrix.batterycanary.monitor.feature;

import android.app.Notification;
import android.content.res.Resources;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.tencent.matrix.batterycanary.utils.BatteryCanaryUtil;
import com.tencent.matrix.batterycanary.utils.NotificationManagerServiceHooker;
import com.tencent.matrix.util.MatrixLog;
import defpackage.i04;
import defpackage.u67;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class NotificationMonitorFeature extends AbsMonitorFeature {
    private static final String TAG = "Matrix.battery.NotificationMonitorFeature";

    @Nullable
    String mAppRunningNotifyText;
    long mLastBgStartMillis = -1;

    @Nullable
    NotificationManagerServiceHooker.IListener mListener;

    /* JADX INFO: compiled from: SearchBox */
    public static final class BadNotification {
        public long bgMillis;

        @Nullable
        public String content;

        @Nullable
        public String stack;

        @Nullable
        public String title;

        public String toString() {
            return "BadNotification{title='" + this.title + "', content='" + this.content + "', stack='" + this.stack + "', bgMillis=" + this.bgMillis + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface NotificationListener {
        void onNotify(@NonNull BadNotification badNotification);
    }

    private String tryGetAppRunningNotificationText() {
        int identifier;
        Resources system = Resources.getSystem();
        if (system == null || (identifier = system.getIdentifier("app_running_notification_text", "string", "android")) <= 0) {
            return null;
        }
        return system.getString(identifier);
    }

    @VisibleForTesting
    public void checkNotifyContent(@Nullable final String str, @Nullable final String str2) {
        final long jUptimeMillis = this.mLastBgStartMillis > 0 ? SystemClock.uptimeMillis() - this.mLastBgStartMillis : 0L;
        final String strStackTraceToString = this.mCore.getConfig().isAggressiveMode ? BatteryCanaryUtil.stackTraceToString(new Throwable().getStackTrace()) : "";
        this.mCore.getHandler().post(new Runnable() { // from class: com.tencent.matrix.batterycanary.monitor.feature.NotificationMonitorFeature.2
            @Override // java.lang.Runnable
            public void run() {
                BadNotification badNotification = new BadNotification();
                badNotification.title = str;
                badNotification.content = str2;
                badNotification.stack = strStackTraceToString;
                badNotification.bgMillis = jUptimeMillis;
                NotificationMonitorFeature.this.mCore.onNotify(badNotification);
            }
        });
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature
    public String getTag() {
        return TAG;
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onForeground(boolean z) {
        super.onForeground(z);
        this.mLastBgStartMillis = z ? -1L : SystemClock.uptimeMillis();
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOff() {
        super.onTurnOff();
        NotificationManagerServiceHooker.removeListener(this.mListener);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.AbsMonitorFeature, com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public void onTurnOn() {
        super.onTurnOn();
        String strTryGetAppRunningNotificationText = tryGetAppRunningNotificationText();
        this.mAppRunningNotifyText = strTryGetAppRunningNotificationText;
        if (TextUtils.isEmpty(strTryGetAppRunningNotificationText)) {
            MatrixLog.w(TAG, "can not get app_running_notification_text, abort notification monitor", new Object[0]);
            return;
        }
        MatrixLog.i(TAG, "get app_running_notification_text: " + this.mAppRunningNotifyText, new Object[0]);
        NotificationManagerServiceHooker.IListener iListener = new NotificationManagerServiceHooker.IListener() { // from class: com.tencent.matrix.batterycanary.monitor.feature.NotificationMonitorFeature.1
            @Override // com.tencent.matrix.batterycanary.utils.NotificationManagerServiceHooker.IListener
            public void onCreateNotification(int i, @Nullable Notification notification) {
                if (notification != null) {
                    String string = notification.extras.getString(NotificationCompat.EXTRA_TITLE, null);
                    String string2 = notification.extras.getString(NotificationCompat.EXTRA_TEXT, null);
                    MatrixLog.i(NotificationMonitorFeature.TAG, "#onCreateNotification, id = " + i + ", title = " + string + ", text = " + string2, new Object[0]);
                    if (TextUtils.isEmpty(string2)) {
                        MatrixLog.w(NotificationMonitorFeature.TAG, "notify with empty text!", new Object[0]);
                        NotificationMonitorFeature.this.checkNotifyContent(string, "");
                    } else if (string2.equals(NotificationMonitorFeature.this.mAppRunningNotifyText)) {
                        MatrixLog.w(NotificationMonitorFeature.TAG, "notify with appRunningText: " + string2, new Object[0]);
                        NotificationMonitorFeature.this.checkNotifyContent(string, string2);
                    }
                }
            }

            @Override // com.tencent.matrix.batterycanary.utils.NotificationManagerServiceHooker.IListener
            public void onCreateNotificationChannel(@Nullable Object obj) {
                if (Build.VERSION.SDK_INT < 26 || !u67.a(obj)) {
                    return;
                }
                MatrixLog.i(NotificationMonitorFeature.TAG, "#onCreateNotificationChannel, id = " + i04.a(obj).getId() + ", name = " + ((Object) i04.a(obj).getName()), new Object[0]);
            }
        };
        this.mListener = iListener;
        NotificationManagerServiceHooker.addListener(iListener);
    }

    @Override // com.tencent.matrix.batterycanary.monitor.feature.MonitorFeature
    public int weight() {
        return Integer.MIN_VALUE;
    }
}
