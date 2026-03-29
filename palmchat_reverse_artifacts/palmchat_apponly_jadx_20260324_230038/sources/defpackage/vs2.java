package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.push.core.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class vs2 {
    public static boolean a(Context context) {
        String str = (String) lg5.c(context, zz2.e());
        String strE = fv2.e(context);
        k63.a("InitHelper", "appkey=" + strE + " last=" + str);
        if (!nl5.i(str) && !b.m.equals(str) && str.equalsIgnoreCase(strE)) {
            return false;
        }
        lg5.h(context, zz2.e().a0(strE));
        k63.b("InitHelper", "We found the appKey is changed or register appkey is empty. Will re-register.");
        bw2.b(context);
        return true;
    }

    public static void b(Context context) {
        String str = (String) lg5.c(context, zz2.h());
        if (TextUtils.isEmpty(str) || str.startsWith("1.")) {
            bw2.t(context);
        }
        if (TextUtils.isEmpty(str) || !"2.4.7".equals(str)) {
            lg5.h(context, zz2.h().a0("2.4.7"));
        }
    }
}
