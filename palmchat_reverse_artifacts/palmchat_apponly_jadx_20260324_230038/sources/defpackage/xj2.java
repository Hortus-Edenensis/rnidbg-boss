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
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.guide.HuaweiBootAndBackgroundGuideActivity;
import com.zenmen.palmchat.notification.NotificationChannelManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class xj2 extends vg4 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21976a;

        public a(boolean z) {
            this.f21976a = z;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (this.f21976a) {
                ((Activity) xj2.this.b()).finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21977a;

        public b(int i) {
            this.f21977a = i;
            put("action", i == 3 ? "send_feed_permission" : "send_msg_permission");
            put("type", Integer.valueOf(i == 2 ? 4 : 3));
            put("status", "unauth_adapted_noGoSet");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21978a;

        public c(int i) {
            this.f21978a = i;
            put("action", i == 3 ? "send_feed_permission" : "send_msg_permission");
            put("type", Integer.valueOf(i == 2 ? 4 : 3));
            put("status", "unauth_adapted_withGoSet");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f21979a;
        public final /* synthetic */ boolean b;

        public d(Intent intent, boolean z) {
            this.f21979a = intent;
            this.b = z;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            if (this.b) {
                ((Activity) xj2.this.b()).finish();
            }
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            n86.c(xj2.this.b(), this.f21979a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21980a;

        public e(int i) {
            this.f21980a = i;
            put("action", i == 3 ? "send_feed_permission" : "send_msg_permission");
            put("type", Integer.valueOf(i == 2 ? 4 : 3));
            put("status", "unauth_adapted_noGoSet");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21981a;

        public f(boolean z) {
            this.f21981a = z;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (this.f21981a) {
                ((Activity) xj2.this.b()).finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21982a;

        public g(int i) {
            this.f21982a = i;
            put("action", i == 3 ? "send_feed_permission" : "send_msg_permission");
            put("type", Integer.valueOf(i == 2 ? 4 : 3));
            put("status", "unauth_adapted_withGoSet");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f21983a;

        public h(Intent intent) {
            this.f21983a = intent;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            ((Activity) xj2.this.b()).finish();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            n86.c(xj2.this.b(), this.f21983a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MessageVo messageVo = new MessageVo();
            messageVo.mid = xn3.a();
            messageVo.time = ir5.b();
            messageVo.contactRelate = "88888004";
            messageVo.to = AccountUtils.p(AppContext.getContext());
            messageVo.text = "【重要】华为用户务必进行设置！为了防止接收不到新消息, <a href=\"zenxin://activity?page=a0101\">请点击进行相关设置</a>";
            messageVo.mimeType = 1;
            messageVo.status = 2;
            messageVo.sendFlag = String.valueOf(0);
            messageVo.from = "88888000";
            messageVo.isSend = false;
            messageVo.isRead = true;
            messageVo.extention = "";
            messageVo.data1 = "0";
            messageVo.data2 = "{\"linkFlag\":1}";
            com.zenmen.palmchat.database.b.t(messageVo);
            LogUtil.onImmediateClickEvent("3701", null, null);
        }
    }

    public xj2(Context context, ol2 ol2Var) {
        super(context, ol2Var);
    }

    @Override // defpackage.vg4
    public void a() {
        if (cf2.a()) {
            LogUtil.i(vg4.c, "addSecretaryMessageToDB");
            new g13(new i()).start();
        }
    }

    @Override // defpackage.vg4
    public void c(boolean z, int i2) {
        Intent permissionActivity = this.b.getPermissionActivity(6);
        if (permissionActivity == null) {
            new sd3(b()).T(R.string.update_install_dialog_title).j(R.string.allow_audio_permission_guide_huawei).O(R.string.alert_dialog_i_knoW).f(new a(z)).h(false).e().show();
            LogUtil.i(vg4.c, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new b(i2), (Throwable) null);
        } else {
            LogUtil.i(vg4.c, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new c(i2), (Throwable) null);
            new sd3(b()).T(R.string.acquire_permission).j(R.string.allow_audio_permission_guide_huawei).O(R.string.go_to_set).K(R.string.alert_dialog_cancel).f(new d(permissionActivity, z)).h(false).e().show();
        }
    }

    @Override // defpackage.vg4
    public void d() {
        if (cf2.a()) {
            LogUtil.i(vg4.c, "showBootAndBackgroundPermissionGuide");
            Intent intent = new Intent(b(), (Class<?>) HuaweiBootAndBackgroundGuideActivity.class);
            intent.putExtra("FROM_SOURCE_IS_NOTIFY", true);
            intent.setFlags(268435456);
            ((NotificationManager) b().getSystemService("notification")).notify(3000, NotificationChannelManager.MessageType.MSG.genNotificationCompatBuilder().setContentTitle(b().getString(R.string.allow_boot_and_background_permissions_title_huawei)).setContentText(b().getString(R.string.allow_boot_and_background_permissions_content)).setTicker(b().getString(R.string.allow_boot_and_background_permissions_title_huawei)).setLargeIcon(((BitmapDrawable) AppContext.getContext().getResources().getDrawable(R.drawable.ic_launcher)).getBitmap()).setSmallIcon(R.drawable.message_notify_icon_huawei).setContentIntent(PendingIntent.getActivity(b(), 0, intent, 0)).setAutoCancel(true).build());
        }
    }

    @Override // defpackage.vg4
    public void e() {
        b().startActivity(new Intent(b(), (Class<?>) HuaweiBootAndBackgroundGuideActivity.class));
    }

    @Override // defpackage.vg4
    public void f(boolean z, int i2) {
        Intent permissionActivity = this.b.getPermissionActivity(6);
        if (permissionActivity == null) {
            LogUtil.i(vg4.c, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new e(i2), (Throwable) null);
            new sd3(b()).T(R.string.update_install_dialog_title).j(R.string.allow_camera_permission_guide_huawei).O(R.string.alert_dialog_i_knoW).f(new f(z)).h(false).e().show();
        } else {
            LogUtil.i(vg4.c, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new g(i2), (Throwable) null);
            new sd3(b()).T(R.string.acquire_permission).j(R.string.allow_camera_permission_guide_huawei).O(R.string.go_to_set).K(R.string.alert_dialog_cancel).f(new h(permissionActivity)).h(false).e().show();
        }
    }
}
