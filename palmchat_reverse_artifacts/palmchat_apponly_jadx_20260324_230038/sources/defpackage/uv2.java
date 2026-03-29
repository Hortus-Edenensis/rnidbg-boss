package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class uv2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f21297a;

    public static void a(Context context, String str, Bundle bundle) {
        String string;
        b(context);
        if (TextUtils.isEmpty(str)) {
            k63.n("JCoreActionImpl", "handleAction Failed,action is empty");
            return;
        }
        k63.a("JCoreActionImpl", "handleAction action:" + str);
        String string2 = bundle != null ? bundle.getString("sdk_type") : "";
        if (str.equals("a1")) {
            if (bundle != null) {
                try {
                    string = bundle.getString("report_data");
                } catch (Throwable th) {
                    k63.l("JCoreActionImpl", "report failed:" + th.getMessage());
                    return;
                }
            } else {
                string = null;
            }
            bw2.i(context, string);
            return;
        }
        if (str.startsWith("tcp_")) {
            tt5.u().r(context, str, bundle);
            return;
        }
        if (str.equals("a2")) {
            ng4.c().g(context, true);
        } else if (str.equals("a3")) {
            zd1.e().q(context, string2, bundle);
        } else if (str.equals("a4")) {
            bw2.a(context, bundle);
        }
    }

    public static synchronized void b(Context context) {
        if (f21297a) {
            return;
        }
        if (context == null) {
            return;
        }
        k63.a("JCoreActionImpl", "init jcore impl ,version:" + wv2.b + ",local version:" + tv2.d);
        f21297a = true;
        try {
            k63.a("JCoreActionImpl", "hb:" + tt5.u().t() + ",google:false,internal:" + tv2.f);
            int i = !TextUtils.isEmpty(tv2.c) ? 2 : 0;
            int i2 = wv2.c != tv2.d ? 2 : 0;
            k63.a("JCoreActionImpl", "custom:" + i + ",dynamic:" + i2);
            JCoreManager.onEvent(context, "JCore", 72, true, null, null, "core", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(wv2.c));
        } catch (Throwable th) {
            k63.n("JCoreActionImpl", "sdk type call failed:" + th.getMessage());
        }
        vs2.b(context);
        vs2.a(context);
    }
}
