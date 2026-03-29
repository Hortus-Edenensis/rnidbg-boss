package defpackage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.lxvoip.LxVoipManager;
import com.zenmen.palmchat.videocall.VideoCallActivity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ny {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19638a = "ny";
    public static String b = "VOIP_NOTIFICATION_CHANNEL";

    public static void a() {
        NotificationManager notificationManager = (NotificationManager) AppContext.getContext().getSystemService("notification");
        notificationManager.cancel(MediationConstant.ErrorCode.ADN_AD_NO_CACHE);
        notificationManager.cancel(MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL);
        notificationManager.cancel(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL);
    }

    public static void b() {
        ((NotificationManager) AppContext.getContext().getSystemService("notification")).cancel(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL);
    }

    public static void c() {
        ((NotificationManager) AppContext.getContext().getSystemService("notification")).cancel(MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL);
    }

    public static Notification d(int i) {
        a();
        NotificationCompat.Builder builderL = l();
        builderL.setLargeIcon(BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.ic_launcher));
        builderL.setSmallIcon(R.drawable.voip_minisize_window_icon);
        builderL.setContentTitle(AppContext.getContext().getResources().getString(R.string.app_name));
        if (i == 0) {
            builderL.setContentText(AppContext.getContext().getResources().getString(R.string.notification_min_video));
        } else {
            builderL.setContentText(AppContext.getContext().getResources().getString(R.string.notification_min_voice));
        }
        builderL.setWhen(System.currentTimeMillis());
        builderL.setAutoCancel(true);
        builderL.setOngoing(true);
        builderL.setDefaults(2);
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) VideoCallActivity.class);
        intent.addFlags(268435456);
        builderL.setContentIntent(PendingIntent.getActivity(AppContext.getContext(), 0, intent, 0));
        return builderL.build();
    }

    public static Notification e(int i, String str, String str2) {
        NotificationCompat.Builder when = l().setLargeIcon(BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.ic_launcher)).setSmallIcon(R.drawable.voip_minisize_window_icon).setAutoCancel(true).setContentTitle(str).setContentText(i == 0 ? AppContext.getContext().getResources().getString(R.string.missed_notify_video_call) : AppContext.getContext().getResources().getString(R.string.missed_notify_voice_call)).setShowWhen(true).setWhen(System.currentTimeMillis());
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) ChatterActivity.class);
        intent.addFlags(335544320);
        ContactInfoItem contactInfoItem = new ContactInfoItem();
        contactInfoItem.setUid(str2);
        intent.putExtra("thread_biz_type", 0);
        intent.putExtra("chat_need_back_to_main", false);
        intent.putExtra("chat_back_to_greet", false);
        intent.putExtra("chat_item", contactInfoItem);
        intent.putExtra("chat_from", "CHAT_FROM_MISSED_CALL_NOTIFICATION");
        when.setContentIntent(PendingIntent.getActivity(AppContext.getContext(), MediationConstant.ErrorCode.ADN_AD_NO_CACHE, intent, 268435456));
        return when.build();
    }

    public static Notification f(int i, boolean z) {
        return i == 0 ? j(AppContext.getContext().getResources().getString(R.string.notification_min_video), z) : j(AppContext.getContext().getResources().getString(R.string.notification_min_voice), z);
    }

    public static Notification g(int i, boolean z) {
        return i == 0 ? j(AppContext.getContext().getResources().getString(R.string.notification_min_video), z) : j(AppContext.getContext().getResources().getString(R.string.notification_min_voice), z);
    }

    public static Notification h(int i) {
        a();
        NotificationCompat.Builder builderL = l();
        builderL.setLargeIcon(BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.ic_launcher));
        builderL.setSmallIcon(R.drawable.voip_minisize_window_icon);
        builderL.setContentTitle(AppContext.getContext().getResources().getString(R.string.app_name));
        if (i == 0) {
            builderL.setContentText("来自好友的视频电话，点击查看");
        } else {
            builderL.setContentText("来自好友的音频电话，点击查看");
        }
        builderL.setWhen(System.currentTimeMillis());
        builderL.setAutoCancel(true);
        builderL.setOngoing(true);
        builderL.setDefaults(2);
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) VideoCallActivity.class);
        intent.addFlags(268435456);
        builderL.setContentIntent(PendingIntent.getActivity(AppContext.getContext(), 0, intent, 0));
        return builderL.build();
    }

    public static Notification i(int i) {
        c();
        NotificationCompat.Builder builderL = l();
        builderL.setLargeIcon(BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.voip_minisize_window_icon_small));
        builderL.setSmallIcon(R.drawable.voip_minisize_window_icon_small);
        builderL.setContentTitle(AppContext.getContext().getResources().getString(R.string.app_name));
        if (i == 0) {
            builderL.setContentText("来自好友的视频电话，点击查看");
        } else {
            builderL.setContentText("来自好友的音频电话，点击查看");
        }
        builderL.setWhen(System.currentTimeMillis());
        builderL.setAutoCancel(true);
        builderL.setOngoing(true);
        builderL.setDefaults(2);
        builderL.setVibrate(new long[]{200, 200, 200, 200});
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) MainTabsActivity.class);
        intent.addFlags(268435456);
        builderL.setContentIntent(PendingIntent.getActivity(AppContext.getContext(), 0, intent, 0));
        return builderL.build();
    }

    public static Notification j(String str, boolean z) {
        Intent intentA;
        c();
        NotificationCompat.Builder builderL = l();
        builderL.setLargeIcon(BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.voip_minisize_window_icon_small));
        builderL.setSmallIcon(R.drawable.voip_minisize_window_icon_small);
        builderL.setContentTitle(AppContext.getContext().getResources().getString(R.string.app_name));
        builderL.setContentText(str);
        builderL.setWhen(System.currentTimeMillis());
        builderL.setAutoCancel(true);
        builderL.setOngoing(true);
        builderL.setDefaults(2);
        if (z) {
            intentA = LxVoipManager.b().a();
        } else {
            intentA = new Intent(AppContext.getContext(), (Class<?>) VideoCallActivity.class);
            intentA.addFlags(268435456);
        }
        builderL.setContentIntent(PendingIntent.getActivity(AppContext.getContext(), MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL, intentA, 134217728));
        return builderL.build();
    }

    public static String k() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) AppContext.getContext().getSystemService("notification");
            String str = b;
            String string = AppContext.getContext().getString(R.string.string_notify_channel_video_name);
            String string2 = AppContext.getContext().getString(R.string.string_notify_channel_des);
            NotificationChannel notificationChannelA = sz3.a(str, string, 3);
            notificationChannelA.setDescription(string2);
            notificationChannelA.enableLights(true);
            notificationChannelA.setSound(null, null);
            notificationChannelA.enableVibration(true);
            notificationChannelA.setLockscreenVisibility(1);
            notificationManager.createNotificationChannel(notificationChannelA);
        }
        return b;
    }

    public static NotificationCompat.Builder l() {
        return new NotificationCompat.Builder(AppContext.getContext(), k()).setCategory(NotificationCompat.CATEGORY_CALL);
    }

    public static void m(int i) {
        Log.i(f19638a, "setNotificationCalling");
        ((NotificationManager) AppContext.getContext().getSystemService("notification")).notify(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, d(i));
    }

    public static void n(int i, String str, String str2) {
        String str3 = Build.BRAND;
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if (str3.toLowerCase().equals("oppo") || str3.toLowerCase().equals("vivo")) {
            ((NotificationManager) AppContext.getContext().getSystemService("notification")).notify(MediationConstant.ErrorCode.ADN_AD_NO_CACHE, e(i, str, str2));
        }
    }

    public static void o(int i) {
        if (bc1.e()) {
            p(i);
        } else {
            q(i);
        }
    }

    public static void p(int i) {
        Log.i(f19638a, "setNotificationRinging_normal");
        ((NotificationManager) AppContext.getContext().getSystemService("notification")).notify(MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL, h(i));
    }

    public static void q(int i) {
        Log.i(f19638a, "setNotificationRinging_systemtab");
        ((NotificationManager) AppContext.getContext().getSystemService("notification")).notify(MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL, i(i));
    }
}
