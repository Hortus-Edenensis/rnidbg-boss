package defpackage;

import android.app.Activity;
import android.app.Dialog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class db3 extends Dialog {
    public static xn4 a(Activity activity, String str) {
        xn4 xn4Var = new xn4(activity);
        xn4Var.setCancelable(false);
        xn4Var.b(str);
        xn4Var.setCanceledOnTouchOutside(false);
        xn4Var.setCancelable(false);
        return xn4Var;
    }
}
