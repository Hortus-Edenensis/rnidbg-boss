package defpackage;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.igexin.sdk.PushConsts;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.specialattention.SpecialAttentionConfig;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.login.InitActivity;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class zg5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SpecialAttentionConfig f22409a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22410a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ FrameworkBaseActivity c;

        /* JADX INFO: renamed from: zg5$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1297a implements Runnable {
            public RunnableC1297a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.b) {
                    xg5.e().q(true);
                } else {
                    xg5.e().s(false);
                }
            }
        }

        public a(String str, boolean z, FrameworkBaseActivity frameworkBaseActivity) {
            this.f22410a = str;
            this.b = z;
            this.c = frameworkBaseActivity;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("fuid", this.f22410a);
            map.put("notice", Integer.valueOf(this.b ? 1 : 0));
            return sw4.b(1, nl0.z + "/friend.notice.v2", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
            this.c.hideBaseProgressBar();
            if (z && lXBaseNetBean.resultCode == 0) {
                if (this.b) {
                    sy5.f(AppContext.getContext(), zg5.g().getSASetSuccessToast(false), 1).g();
                }
                iq5.j(false, new String[0]);
                xg5.e().f().postDelayed(new RunnableC1297a(), 2500L);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22412a;
        public final /* synthetic */ Runnable b;

        public b(Activity activity, Runnable runnable) {
            this.f22412a = activity;
            this.b = runnable;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            com.zenmen.palmchat.utils.a.E().y0(this.f22412a);
            this.b.run();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f22413a;
        public final /* synthetic */ Runnable b;

        public c(Activity activity, Runnable runnable) {
            this.f22413a = activity;
            this.b = runnable;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            com.zenmen.palmchat.utils.a.E().y0(this.f22413a);
            this.b.run();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f22414a;

        public d(Runnable runnable) {
            this.f22414a = runnable;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            this.f22414a.run();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f22415a;

        public e(Runnable runnable) {
            this.f22415a = runnable;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            this.f22415a.run();
        }
    }

    public static PendingIntent a() {
        Intent intent = new Intent(AppContext.getContext(), (Class<?>) InitActivity.class);
        intent.setAction("SpecialAttention" + System.currentTimeMillis());
        intent.putExtra("key_push_param", "zenxin://activity?page=a10086");
        intent.putExtra("key_from_push", true);
        intent.addFlags(268435456);
        return PendingIntent.getActivity(AppContext.getContext(), PushConsts.MIN_FEEDBACK_ACTION, intent, 134217728);
    }

    public static void b(FrameworkBaseActivity frameworkBaseActivity, String str, boolean z, boolean z2) {
        frameworkBaseActivity.showBaseProgressBar();
        zw4.e(new a(str, z, frameworkBaseActivity));
    }

    public static void c(Activity activity, Runnable runnable) {
        new sd3(activity).k(g().getFirstSetDes()).P(g().getSAConfirm()).L(g().getSACancel()).f(new d(runnable)).e().show();
    }

    public static void d() {
        ((NotificationManager) AppContext.getContext().getSystemService("notification")).cancel(PushConsts.MIN_FEEDBACK_ACTION);
    }

    public static Notification e(RemoteViews remoteViews) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(AppContext.getContext(), f());
        builder.setLargeIcon(BitmapFactory.decodeResource(AppContext.getContext().getResources(), R.drawable.ic_launcher));
        builder.setSmallIcon(R.drawable.message_notify_icon_white);
        builder.setContentTitle(AppContext.getContext().getResources().getString(R.string.app_name));
        builder.setContentText("特别关注");
        builder.setCustomContentView(remoteViews);
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);
        builder.setOngoing(true);
        builder.setDefaults(2);
        return builder.build();
    }

    public static String f() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) AppContext.getContext().getSystemService("notification");
            NotificationChannel notificationChannelA = sz3.a("SPECIAL_ATTENTION_NOTIFICATION_CHANNEL", "特别关注通知", 3);
            notificationChannelA.setDescription("连信特别关注通知");
            notificationChannelA.enableLights(true);
            notificationChannelA.setSound(null, null);
            notificationChannelA.enableVibration(false);
            notificationChannelA.setLockscreenVisibility(1);
            notificationManager.createNotificationChannel(notificationChannelA);
        }
        return "SPECIAL_ATTENTION_NOTIFICATION_CHANNEL";
    }

    public static SpecialAttentionConfig g() {
        if (f22409a == null) {
            JSONObject config = vs0.a().getConfig("noticebar_permanent");
            if (config != null) {
                f22409a = (SpecialAttentionConfig) az2.a(config.toString(), SpecialAttentionConfig.class);
            } else {
                f22409a = new SpecialAttentionConfig();
            }
        }
        return f22409a;
    }

    public static boolean h() {
        CopyOnWriteArrayList<ContactInfoItem> copyOnWriteArrayListQ = bo0.r().q();
        return copyOnWriteArrayListQ != null && copyOnWriteArrayListQ.size() > 0;
    }

    public static boolean i(ContactInfoItem contactInfoItem) {
        if (contactInfoItem != null) {
            return jw5.i(contactInfoItem.getSessionConfig());
        }
        return false;
    }

    public static boolean j(String str) {
        if (str != null) {
            return i(bo0.r().l(str));
        }
        return false;
    }

    public static void k(Activity activity, Runnable runnable) {
        new sd3(activity).k(g().getNotificationGuideOnChat()).K(R.string.alert_dialog_cancel).P("去开启").f(new b(activity, runnable)).e().show();
    }

    public static void l(Activity activity, Runnable runnable) {
        new sd3(activity).k(g().getNotificationGuideString()).K(R.string.alert_dialog_cancel).P("去开启").f(new c(activity, runnable)).e().show();
    }

    public static void m(Activity activity, Runnable runnable) {
        new sd3(activity).k(g().getFirstSetDes()).L(g().getSACancel()).P(g().getSAConfirm()).f(new e(runnable)).e().show();
    }
}
