package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class og6 extends vg4 {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19759a;

        public a(int i) {
            this.f19759a = i;
            put("action", i == 3 ? "send_feed_permission" : "send_msg_permission");
            put("type", Integer.valueOf(i == 2 ? 4 : 3));
            put("status", "unauth_adapted_noGoSet");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f19760a;

        public b(boolean z) {
            this.f19760a = z;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (this.f19760a) {
                ((Activity) og6.this.b()).finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19761a;

        public c(int i) {
            this.f19761a = i;
            put("action", i == 3 ? "send_feed_permission" : "send_msg_permission");
            put("type", Integer.valueOf(i == 2 ? 4 : 3));
            put("status", "unauth_adapted_withGoSet");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f19762a;
        public final /* synthetic */ boolean b;

        public d(Intent intent, boolean z) {
            this.f19762a = intent;
            this.b = z;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            if (this.b) {
                ((Activity) og6.this.b()).finish();
            }
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            n86.c(og6.this.b(), this.f19762a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19763a;

        public e(int i) {
            this.f19763a = i;
            put("action", i == 3 ? "send_feed_permission" : "send_msg_permission");
            put("type", Integer.valueOf(i == 2 ? 4 : 3));
            put("status", "unauth_adapted_noGoSet");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f19764a;

        public f(boolean z) {
            this.f19764a = z;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (this.f19764a) {
                ((Activity) og6.this.b()).finish();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19765a;

        public g(int i) {
            this.f19765a = i;
            put("action", i == 3 ? "send_feed_permission" : "send_msg_permission");
            put("type", Integer.valueOf(i == 2 ? 4 : 3));
            put("status", "unauth_adapted_withGoSet");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f19766a;

        public h(Intent intent) {
            this.f19766a = intent;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            ((Activity) og6.this.b()).finish();
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            n86.c(og6.this.b(), this.f19766a);
        }
    }

    public og6(Context context, ol2 ol2Var) {
        super(context, ol2Var);
    }

    @Override // defpackage.vg4
    public void c(boolean z, int i) {
        Intent permissionActivity = this.b.getPermissionActivity(6);
        if (permissionActivity == null) {
            LogUtil.i(vg4.c, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(i), (Throwable) null);
            new sd3(b()).T(R.string.update_install_dialog_title).j(R.string.allow_audio_permission_guide_vivo).O(R.string.alert_dialog_i_knoW).f(new b(z)).h(false).e().show();
        } else {
            LogUtil.i(vg4.c, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new c(i), (Throwable) null);
            new sd3(b()).T(R.string.acquire_permission).j(R.string.allow_audio_permission_guide_vivo).O(R.string.go_to_set).K(R.string.alert_dialog_cancel).f(new d(permissionActivity, z)).h(false).e().show();
        }
    }

    @Override // defpackage.vg4
    public void f(boolean z, int i) {
        Intent permissionActivity = this.b.getPermissionActivity(6);
        if (permissionActivity == null) {
            LogUtil.i(vg4.c, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new e(i), (Throwable) null);
            new sd3(b()).T(R.string.update_install_dialog_title).j(R.string.allow_camera_permission_guide_vivo).O(R.string.alert_dialog_i_knoW).f(new f(z)).h(false).e().show();
        } else {
            LogUtil.i(vg4.c, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new g(i), (Throwable) null);
            new sd3(b()).T(R.string.acquire_permission).j(R.string.allow_camera_permission_guide_vivo).O(R.string.go_to_set).K(R.string.alert_dialog_cancel).f(new h(permissionActivity)).h(false).e().show();
        }
    }

    @Override // defpackage.vg4
    public void a() {
    }

    @Override // defpackage.vg4
    public void d() {
    }

    @Override // defpackage.vg4
    public void e() {
    }
}
