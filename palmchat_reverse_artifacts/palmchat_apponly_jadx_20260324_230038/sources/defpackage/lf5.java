package defpackage;

import android.content.Context;
import android.net.Uri;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class lf5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static qo2 f18971a;

    public static void a(String str, String str2) {
        qo2 qo2Var = f18971a;
        if (qo2Var != null) {
            qo2Var.d(str, str2);
        }
    }

    public static boolean b() {
        qo2 qo2Var = f18971a;
        if (qo2Var != null) {
            return qo2Var.b();
        }
        return true;
    }

    public static String c() {
        qo2 qo2Var = f18971a;
        return qo2Var != null ? qo2Var.e() : "https://palmchat.cdn.lianxinapp.com/static/resource/logo/wine/w6.png";
    }

    public static void d(qo2 qo2Var) {
        f18971a = qo2Var;
    }

    public static void e(Context context, String str, int i, String str2, String str3) {
        f(context, str, i, str2, "", "", str3);
    }

    public static void f(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        qo2 qo2Var = f18971a;
        if (qo2Var != null) {
            qo2Var.a(context, str, i, str2, str3, str4, str5);
        }
    }

    public static void g(Context context, String str) {
        qo2 qo2Var = f18971a;
        if (qo2Var != null) {
            qo2Var.c(context, str);
        }
    }

    public static void h(boolean z) {
        LogUtil.i("SmallVideoManager", "onSendFinish" + z);
    }

    public static void i(Uri uri) {
    }
}
