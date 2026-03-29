package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.zenmen.openapi.R$layout;
import com.zenmen.openapi.R$style;
import com.zenmen.openapi.auth.widget.ConfirmDialogView;
import com.zenmen.openapi.auth.widget.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class sm {
    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 11) {
            return str;
        }
        return str.substring(0, 3) + "****" + str.substring(7, 11);
    }

    public static void b(Activity activity, ConfirmDialogView.a aVar, a.b bVar) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        a aVar2 = new a(activity, R$style.lx_pay_dialog_bottom_full);
        aVar2.b(bVar);
        ConfirmDialogView confirmDialogView = (ConfirmDialogView) View.inflate(activity, R$layout.lx_auth_view_confirm, null);
        confirmDialogView.initView(aVar);
        aVar2.setContentView(confirmDialogView);
        aVar2.setCanceledOnTouchOutside(false);
        Window window = aVar2.getWindow();
        window.setGravity(80);
        window.setWindowAnimations(R$style.lx_pay_botton_dialog_animation);
        window.setLayout(-1, -2);
        aVar2.show();
    }
}
