package defpackage;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.guide.HuaweiBootAndBackgroundGuideActivity;
import com.zenmen.palmchat.notification.NotificationChannelManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class l94 extends vg4 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18935a;

        public a(int i) {
            this.f18935a = i;
            put("action", i == 3 ? "send_feed_permission" : "send_msg_permission");
            put("type", Integer.valueOf(i == 2 ? 4 : 3));
            put("status", "unauth_adapted_noGoSet");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18936a;

        public b(boolean z) {
            this.f18936a = z;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (this.f18936a) {
                ((Activity) l94.this.b()).finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18937a;

        public c(int i) {
            this.f18937a = i;
            put("action", i == 3 ? "send_feed_permission" : "send_msg_permission");
            put("type", Integer.valueOf(i == 2 ? 4 : 3));
            put("status", "unauth_adapted_withGoSet");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f18938a;
        public final /* synthetic */ boolean b;

        public d(Intent intent, boolean z) {
            this.f18938a = intent;
            this.b = z;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            if (this.b) {
                ((Activity) l94.this.b()).finish();
            }
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            n86.c(l94.this.b(), this.f18938a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18939a;

        public e(int i) {
            this.f18939a = i;
            put("action", i == 3 ? "send_feed_permission" : "send_msg_permission");
            put("type", Integer.valueOf(i == 2 ? 4 : 3));
            put("status", "unauth_adapted_noGoSet");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18940a;

        public f(boolean z) {
            this.f18940a = z;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (this.f18940a) {
                ((Activity) l94.this.b()).finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f18941a;

        public g(int i) {
            this.f18941a = i;
            put("action", i == 3 ? "send_feed_permission" : "send_msg_permission");
            put("type", Integer.valueOf(i == 2 ? 4 : 3));
            put("status", "unauth_adapted_withGoSet");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f18942a;

        public h(Intent intent) {
            this.f18942a = intent;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            ((Activity) l94.this.b()).finish();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            n86.c(l94.this.b(), this.f18942a);
        }
    }

    public l94(Context context, ol2 ol2Var) {
        super(context, ol2Var);
    }

    @Override // defpackage.vg4
    public void c(boolean z, int i) {
        Intent permissionActivity = this.b.getPermissionActivity(6);
        if (permissionActivity == null) {
            LogUtil.i(vg4.c, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(i), (Throwable) null);
            new sd3(b()).T(R.string.update_install_dialog_title).j(R.string.allow_audio_permission_guide_oppo).O(R.string.alert_dialog_i_knoW).f(new b(z)).h(false).e().show();
        } else {
            LogUtil.i(vg4.c, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new c(i), (Throwable) null);
            new sd3(b()).T(R.string.acquire_permission).j(R.string.allow_audio_permission_guide_oppo).O(R.string.go_to_set).K(R.string.alert_dialog_cancel).f(new d(permissionActivity, z)).h(false).e().show();
        }
    }

    @Override // defpackage.vg4
    public void d() {
        Intent intent = new Intent(b(), (Class<?>) HuaweiBootAndBackgroundGuideActivity.class);
        intent.setFlags(268435456);
        ((NotificationManager) b().getSystemService("notification")).notify(3000, NotificationChannelManager.MessageType.MSG.genNotificationCompatBuilder().setContentTitle(b().getString(R.string.allow_boot_and_background_permissions_title_oppo)).setContentText(b().getString(R.string.allow_boot_and_background_permissions_content)).setTicker(b().getString(R.string.allow_boot_and_background_permissions_title_oppo)).setLargeIcon(((BitmapDrawable) AppContext.getContext().getResources().getDrawable(R.drawable.ic_launcher)).getBitmap()).setSmallIcon(R.drawable.message_notify_icon_huawei).setContentIntent(PendingIntent.getActivity(b(), 0, intent, 0)).setAutoCancel(true).build());
    }

    @Override // defpackage.vg4
    public void f(boolean z, int i) {
        Intent permissionActivity = this.b.getPermissionActivity(6);
        if (permissionActivity == null) {
            LogUtil.i(vg4.c, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new e(i), (Throwable) null);
            new sd3(b()).T(R.string.update_install_dialog_title).j(R.string.allow_camera_permission_guide_oppo).O(R.string.alert_dialog_i_knoW).f(new f(z)).h(false).e().show();
        } else {
            LogUtil.i(vg4.c, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new g(i), (Throwable) null);
            new sd3(b()).T(R.string.acquire_permission).j(R.string.allow_camera_permission_guide_oppo).O(R.string.go_to_set).K(R.string.alert_dialog_cancel).f(new h(permissionActivity)).h(false).e().show();
        }
    }

    @Override // defpackage.vg4
    public void a() {
    }

    @Override // defpackage.vg4
    public void e() {
    }
}
