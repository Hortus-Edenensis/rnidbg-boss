package defpackage;

import android.os.Build;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class p34 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Pair<String, String> f19930a;
    public int b;
    public int c;
    public Pair<Integer, Integer> d;
    public String e;

    public static p34 a() {
        p34 p34Var = new p34();
        p34Var.f19930a = new Pair<>("LX_NOTIFICATION_CHANNEL_MESSAGE_APP_INFOS", "LX_NOTIFICATION_CHANNEL_MESSAGE_APP_INFOSnew");
        p34Var.b = R.string.string_notify_channel_name_app_info;
        p34Var.c = R.string.string_notify_channel_des;
        if (Build.VERSION.SDK_INT >= 24) {
            p34Var.d = new Pair<>(2, 2);
        } else {
            p34Var.d = new Pair<>(0, 0);
        }
        p34Var.e = NotificationCompat.CATEGORY_SOCIAL;
        return p34Var;
    }

    public static p34 d() {
        p34 p34Var = new p34();
        p34Var.f19930a = new Pair<>("NOTIFICATION_CHANNEL_MESSAGE_INTERACTIVE", "NOTIFICATION_CHANNEL_MESSAGE_INTERACTIVEnew");
        p34Var.b = R.string.string_notify_channel_name_interactive;
        p34Var.c = R.string.string_notify_channel_des;
        if (Build.VERSION.SDK_INT >= 24) {
            p34Var.d = new Pair<>(4, 1);
        } else {
            p34Var.d = new Pair<>(0, 0);
        }
        p34Var.e = NotificationCompat.CATEGORY_SOCIAL;
        return p34Var;
    }

    public static p34 e() {
        p34 p34Var = new p34();
        p34Var.f19930a = new Pair<>("LX_NOTIFICATION_CHANNEL_MESSAGE", "LX_NOTIFICATION_CHANNEL_MESSAGEnew");
        p34Var.b = R.string.string_notify_channel_name;
        p34Var.c = R.string.string_notify_channel_des;
        if (Build.VERSION.SDK_INT >= 24) {
            p34Var.d = new Pair<>(4, 3);
        } else {
            p34Var.d = new Pair<>(0, 0);
        }
        p34Var.e = "msg";
        return p34Var;
    }

    public static p34 f() {
        p34 p34Var = new p34();
        p34Var.f19930a = new Pair<>("LX_NOTIFICATION_CHANNEL_MESSAGE_MOMENT", "LX_NOTIFICATION_CHANNEL_MESSAGE_MOMENTnew");
        p34Var.b = R.string.notification_O_moment_title;
        p34Var.c = R.string.string_notify_channel_des;
        if (Build.VERSION.SDK_INT >= 24) {
            p34Var.d = new Pair<>(4, 1);
        } else {
            p34Var.d = new Pair<>(0, 0);
        }
        p34Var.e = NotificationCompat.CATEGORY_SOCIAL;
        return p34Var;
    }

    public static p34 g() {
        p34 p34Var = new p34();
        p34Var.f19930a = new Pair<>("LX_NOTIFICATION_CHANNEL_MESSAGE_PUBLIC", "LX_NOTIFICATION_CHANNEL_MESSAGE_PUBLICnew");
        p34Var.b = R.string.string_notify_channel_name_service;
        p34Var.c = R.string.string_notify_channel_des;
        if (Build.VERSION.SDK_INT >= 24) {
            p34Var.d = new Pair<>(4, 1);
        } else {
            p34Var.d = new Pair<>(0, 0);
        }
        p34Var.e = NotificationCompat.CATEGORY_SOCIAL;
        return p34Var;
    }

    public static p34 h() {
        p34 p34Var = new p34();
        p34Var.f19930a = new Pair<>("LX_NOTIFICATION_CHANNEL_MESSAGE_SUBSCRIPTION", "LX_NOTIFICATION_CHANNEL_MESSAGE_SUBSCRIPTIONnew");
        p34Var.b = R.string.string_notify_channel_subscription;
        p34Var.c = R.string.string_notify_channel_des;
        if (Build.VERSION.SDK_INT >= 24) {
            p34Var.d = new Pair<>(4, 3);
        } else {
            p34Var.d = new Pair<>(0, 0);
        }
        p34Var.e = "msg";
        return p34Var;
    }

    public String b(boolean z) {
        return (String) (z ? this.f19930a.second : this.f19930a.first);
    }

    public int c(boolean z) {
        return ((Integer) (z ? this.d.second : this.d.first)).intValue();
    }
}
