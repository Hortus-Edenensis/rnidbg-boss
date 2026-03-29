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
import com.zenmen.media.roomchat.RTCParameters;
import com.zenmen.media.roomchatdemo.videocallgroup.VideoCallGroupChattingUIActivity;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class oa6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19728a = "oa6";
    public static String b = "VOIP_NOTIFICATION_CHANNEL";

    public static void a() {
        if (RTCParameters.c() == null) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) RTCParameters.c().getSystemService("notification");
        notificationManager.cancel(81002);
        notificationManager.cancel(81003);
        notificationManager.cancel(81001);
        notificationManager.cancel(81004);
    }

    public static void b() {
        if (RTCParameters.c() == null) {
            return;
        }
        ((NotificationManager) RTCParameters.c().getSystemService("notification")).cancel(81001);
    }

    public static void c() {
        if (RTCParameters.c() == null) {
            return;
        }
        ((NotificationManager) RTCParameters.c().getSystemService("notification")).cancel(81004);
    }

    public static void d() {
        if (RTCParameters.c() == null) {
            return;
        }
        ((NotificationManager) RTCParameters.c().getSystemService("notification")).cancel(81003);
    }

    public static Notification e(int i) {
        try {
            return m(RTCParameters.c().getResources().getString(R.string.manychats_notification_call_voice_bob));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Notification f(int i) {
        try {
            return m(RTCParameters.c().getResources().getString(R.string.manychats_notification_min_voice));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String g() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) RTCParameters.c().getSystemService("notification");
            String str = b;
            String string = RTCParameters.c().getString(R.string.string_notify_channel_video_name);
            String string2 = RTCParameters.c().getString(R.string.string_notify_channel_des);
            NotificationChannel notificationChannelA = sz3.a(str, string, 4);
            notificationChannelA.setDescription(string2);
            notificationChannelA.enableLights(true);
            notificationChannelA.setSound(null, null);
            notificationChannelA.enableVibration(true);
            notificationChannelA.setLockscreenVisibility(1);
            notificationManager.createNotificationChannel(notificationChannelA);
        }
        return b;
    }

    public static boolean h() {
        try {
            String extra = rl0.h().d().getDynamicConfig(DynamicConfig.Type.VOIP_MEETING).getExtra();
            if (TextUtils.isEmpty(extra)) {
                return true;
            }
            return new JSONObject(extra).getInt("active") == 1;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean i() {
        try {
            boolean zJ = j();
            boolean zH = h();
            StringBuilder sb = new StringBuilder();
            sb.append("enable = ");
            DynamicConfig dynamicConfigD = rl0.h().d();
            DynamicConfig.Type type = DynamicConfig.Type.VOIP_MEETING;
            sb.append(dynamicConfigD.getDynamicConfig(type).isEnable());
            sb.append(", active = ");
            sb.append(zH);
            sb.append(", videoEnable = ");
            sb.append(zJ);
            sb.append(", sp enable = ");
            sb.append(r75.d(AppContext.getContext(), k86.a("sp_voip_meeting_enabled"), false));
            LogUtil.i("Meeting Call: ", sb.toString());
            if (!rl0.h().d().getDynamicConfig(type).isEnable()) {
                if (!r75.d(AppContext.getContext(), k86.a("sp_voip_meeting_enabled"), false)) {
                    return false;
                }
                if (!h()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean j() {
        boolean z = false;
        try {
            String extra = rl0.h().d().getDynamicConfig(DynamicConfig.Type.VOIP_MEETING).getExtra();
            if (!TextUtils.isEmpty(extra)) {
                if (new JSONObject(extra).getInt("videoEnable") == 1) {
                    z = true;
                }
            }
        } catch (Exception unused) {
        }
        RTCParameters.k.i = z;
        return z;
    }

    public static void k(int i) {
        if (RTCParameters.c() == null) {
            return;
        }
        Log.i(f19728a, "setNotificationCalling");
        ((NotificationManager) RTCParameters.c().getSystemService("notification")).notify(81001, f(i));
    }

    public static int l() {
        if (!h()) {
            return 1;
        }
        if (r75.d(AppContext.getContext(), k86.a("sp_voip_meeting_enabled"), false)) {
            return 2;
        }
        r75.o(AppContext.getContext(), k86.a("sp_voip_meeting_enabled"), true);
        return 3;
    }

    public static Notification m(String str) {
        NotificationManager notificationManager = (NotificationManager) RTCParameters.c().getSystemService("notification");
        if (Build.VERSION.SDK_INT > 26) {
            try {
                int importance = notificationManager.getNotificationChannel(b).getImportance();
                Log.i(f19728a, "startNotificationNormal importance:" + importance + " " + str);
            } catch (Exception unused) {
            }
        }
        d();
        b();
        c();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(RTCParameters.c(), g());
        builder.setLargeIcon(BitmapFactory.decodeResource(RTCParameters.c().getResources(), R.drawable.voip_minisize_window_icon_small));
        builder.setSmallIcon(R.drawable.voip_minisize_window_icon_small);
        builder.setContentTitle(RTCParameters.c().getResources().getString(R.string.app_name));
        builder.setContentText(str);
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);
        builder.setOngoing(true);
        builder.setDefaults(2);
        builder.setContentIntent(PendingIntent.getActivity(RTCParameters.c(), 0, new Intent(RTCParameters.c(), (Class<?>) VideoCallGroupChattingUIActivity.class), 0));
        return builder.build();
    }
}
