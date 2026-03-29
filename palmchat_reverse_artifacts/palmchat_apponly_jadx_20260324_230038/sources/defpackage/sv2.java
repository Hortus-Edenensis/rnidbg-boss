package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.service.JCommonService;
import com.igexin.push.core.b;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class sv2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f20851a = new Object();
    public static volatile sv2 b;
    public static String c;
    public static String d;

    public static String b(Context context) {
        ComponentInfo componentInfoG;
        try {
            String str = c;
            if (str != null) {
                return str;
            }
            Intent intent = new Intent();
            intent.setAction("cn.jiguang.user.service.action");
            intent.setPackage(context.getPackageName());
            List<String> listE = ad.e(context, intent, "");
            if (listE != null && listE.size() >= 1 && JCommonService.class.isAssignableFrom(Class.forName(listE.get(0)))) {
                c = listE.get(0);
                k63.h("JCommonServiceHelper", "found userServiceClass :" + c + " by getCommonServiceNames");
            }
        } catch (Throwable th) {
            k63.a("JCommonServiceHelper", "getUserServiceClass failed:" + th);
        }
        if (TextUtils.isEmpty(c) && (componentInfoG = ad.g(context, context.getPackageName(), JCommonService.class)) != null) {
            c = componentInfoG.name;
            k63.h("JCommonServiceHelper", "found userServiceClass :" + c + " by getComponentInfo");
        }
        if (TextUtils.isEmpty(c)) {
            c = "";
        }
        return c;
    }

    public static sv2 c() {
        if (b == null) {
            synchronized (f20851a) {
                if (b == null) {
                    b = new sv2();
                }
            }
        }
        return b;
    }

    public static String d(Context context) {
        String str = d;
        if (str != null) {
            return str;
        }
        String strB = b(context);
        if (TextUtils.isEmpty(strB)) {
            d = "";
            return "";
        }
        d = ad.f(context, strB);
        k63.a("JCommonServiceHelper", "user serviceProcess is:" + d);
        return d;
    }

    public void a(Context context, String str, Bundle bundle) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("callAction action:");
            sb.append(str);
            sb.append(" bundle:");
            sb.append(bundle == null ? b.m : bundle.toString());
            k63.g("JCommonServiceHelper", sb.toString());
            uv2.a(tv2.a(context), str, bundle);
        } catch (Throwable th) {
            k63.i("JCommonServiceHelper", "callAction failed", th);
        }
    }

    public void e(Context context, String str, Bundle bundle) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("onAction action:");
            sb.append(str);
            sb.append(" bundle:");
            sb.append(bundle == null ? b.m : bundle.toString());
            k63.a("JCommonServiceHelper", sb.toString());
            String strB = b(context);
            if (TextUtils.isEmpty(strB)) {
                wv2.b(context, str, bundle);
            } else {
                rw2.c().e(context, strB, str, bundle);
            }
        } catch (Throwable th) {
            k63.i("JCommonServiceHelper", "onAction failed", th);
        }
    }
}
