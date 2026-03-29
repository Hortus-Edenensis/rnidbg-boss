package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import defpackage.vt6;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b97 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f1672a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(boolean z, JSONObject jSONObject, String str);
    }

    public static boolean a(ru6 ru6Var, int i, int i2, Intent intent) {
        if (i != 1010 || intent == null) {
            return false;
        }
        a aVar = f1672a;
        if (aVar == null) {
            return true;
        }
        f1672a = null;
        if (i2 == -1) {
            xt6.b(ru6Var, "biz", "TbOk", intent.toUri(1));
            aVar.a(true, qh7.s(intent), "OK");
        } else if (i2 != 0) {
            xt6.g(ru6Var, "biz", "TbUnknown", "" + i2);
        } else {
            xt6.b(ru6Var, "biz", "TbCancel", intent.toUri(1));
            aVar.a(false, null, "CANCELED");
        }
        return true;
    }

    public static boolean b(ru6 ru6Var, Activity activity, int i, String str, String str2, a aVar) {
        try {
            xt6.a(ru6Var, "biz", "TbStart");
            activity.startActivityForResult(new Intent(str2, Uri.parse(str)), i);
            f1672a = aVar;
            return true;
        } catch (Throwable th) {
            aVar.a(false, null, "UNKNOWN_ERROR");
            xt6.c(ru6Var, "biz", "TbActFail", th);
            return false;
        }
    }

    public static boolean c(ru6 ru6Var, Context context) {
        return qh7.v(ru6Var, context, Collections.singletonList(new vt6.b("com.taobao.taobao", 0, "")), false);
    }
}
