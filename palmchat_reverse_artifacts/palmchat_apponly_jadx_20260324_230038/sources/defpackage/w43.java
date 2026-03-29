package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.kuaishou.weapon.p0.g;
import com.zenmen.openapi.R$layout;
import com.zenmen.openapi.R$style;
import com.zenmen.openapi.auth.widget.a;
import com.zenmen.openapi.jssdk.widget.PermissionDialogView;
import defpackage.ka3;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class w43 extends ya3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f21615a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f21616a;
        public final /* synthetic */ PermissionDialogView.a b;
        public final /* synthetic */ a.b c;

        public a(Activity activity, PermissionDialogView.a aVar, a.b bVar) {
            this.f21616a = activity;
            this.b = aVar;
            this.c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            w43.h(this.f21616a, this.b, this.c);
        }
    }

    static {
        HashMap map = new HashMap();
        f21615a = map;
        map.put(g.g, "获取你的位置信息");
        map.put("com.zenmen.palmchat.permissions.ACCESS_PRIV_DEVICEINFO", "获取你的设备信息");
        map.put("com.zenmen.palmchat.permissions.GET_PHONENUMBER", "使用你的手机号码");
        map.put("android.permission.RECORD_AUDIO", "使用您的麦克风");
    }

    public static void e(Activity activity, PermissionDialogView.a aVar, a.b bVar) {
        ka3.b bVar2;
        String str;
        if (aVar == null || (bVar2 = aVar.f12022a) == null || (str = bVar2.f21948a) == null) {
            if (bVar != null) {
                bVar.onConfirmback(1);
            }
        } else if (f(activity, str, aVar.b)) {
            bVar.onConfirmback(0);
        } else {
            new Handler(Looper.getMainLooper()).post(new a(activity, aVar, bVar));
        }
    }

    public static boolean f(Context context, String str, String str2) {
        return ya3.a(context, "lx_jssdk_permission", str + "_" + str2, false);
    }

    public static void g(Context context, String str, String str2, boolean z) {
        ya3.c(context, "lx_jssdk_permission", str + "_" + str2, z);
    }

    public static void h(Activity activity, PermissionDialogView.a aVar, a.b bVar) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        com.zenmen.openapi.auth.widget.a aVar2 = new com.zenmen.openapi.auth.widget.a(activity, R$style.lx_pay_dialog_bottom_full);
        aVar2.b(bVar);
        PermissionDialogView permissionDialogView = (PermissionDialogView) View.inflate(activity, R$layout.lx_jssdk_permisson_confirm_view, null);
        permissionDialogView.initView(aVar);
        aVar2.setContentView(permissionDialogView);
        aVar2.setCanceledOnTouchOutside(false);
        Window window = aVar2.getWindow();
        window.setGravity(80);
        window.setWindowAnimations(R$style.lx_pay_botton_dialog_animation);
        window.setLayout(-1, -2);
        aVar2.show();
    }
}
