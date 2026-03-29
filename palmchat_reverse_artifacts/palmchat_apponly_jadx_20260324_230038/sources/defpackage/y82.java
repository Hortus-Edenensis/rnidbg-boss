package defpackage;

import android.app.Activity;
import android.content.Context;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class y82 extends vg4 {
    public static final String d = "y82";

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22159a;

        public a(int i) {
            this.f22159a = i;
            put("action", i == 3 ? "send_feed_permission" : "send_msg_permission");
            put("type", Integer.valueOf(i == 2 ? 4 : 3));
            put("status", "unauth_adapted_fail");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22160a;

        public b(int i) {
            this.f22160a = i;
            put("action", i == 3 ? "send_feed_permission" : "send_msg_permission");
            put("type", Integer.valueOf(i == 2 ? 4 : 3));
            put("status", "unauth_adapted_fail");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f22161a;

        public c(boolean z) {
            this.f22161a = z;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (this.f22161a) {
                ((Activity) y82.this.b()).finish();
            }
        }
    }

    public y82(Context context) {
        super(context, null);
    }

    @Override // defpackage.vg4
    public void c(boolean z, int i) {
        LogUtil.i(d, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new a(i), (Throwable) null);
        g(z);
    }

    @Override // defpackage.vg4
    public void f(boolean z, int i) {
        LogUtil.i(d, LogUtil.LogType.LOG_TYPE_QA_NORMAL, 3, new b(i), (Throwable) null);
        g(z);
    }

    public final void g(boolean z) {
        new sd3(b()).T(R.string.update_install_dialog_title).j(R.string.permission_no_adapter).O(R.string.alert_dialog_i_knoW).f(new c(z)).h(false).e().show();
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
