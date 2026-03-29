package defpackage;

import android.content.Context;
import android.content.pm.ComponentInfo;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import com.baidu.location.LocationConst;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class rv2 {
    public static void A(String str) {
        bw2.h(str);
    }

    public static String B(File file) {
        return hv1.i(file);
    }

    public static void C(Context context, Object obj) {
        JCoreManager.onEvent(context, "JCOMMON", 39, null, null, obj);
    }

    public static void D(Context context, Object obj, Object obj2) {
        JCoreManager.onEvent(context, "JCOMMON", 15, null, null, obj, obj2);
    }

    public static boolean E(File file, String str) {
        return hv1.j(file, str);
    }

    public static void F(Runnable runnable) {
        bw2.m(runnable, new int[0]);
    }

    public static byte[] G(String str) {
        return nl5.o(str);
    }

    public static void H(Context context, Bundle bundle) {
        JCoreManager.onEvent(context, "JCOMMON", 16, null, bundle, new Object[0]);
    }

    public static String I(String str) {
        return nl5.q(str);
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            p63.a("JCommonPresenter", "jsonContent:" + jSONObject2);
            int iOptInt = jSONObject2.optInt(LocationConst.HDYawConst.KEY_HD_YAW_STATE, -1);
            if (iOptInt == -1) {
                p63.f("JCommonPresenter", "unknow state");
                return;
            }
            if (iOptInt == 0) {
                p63.a("JCommonPresenter", "turn on share process");
                bw2.r(context, iOptInt);
            } else {
                if (iOptInt == 1) {
                    p63.a("JCommonPresenter", "turn off share process");
                    bw2.r(context, iOptInt);
                    o75.m().e(context, fv2.n(context));
                    o75.d(context, context.getPackageName());
                    return;
                }
                p63.f("JCommonPresenter", "#exception - unsupport state:" + iOptInt);
            }
        } catch (Exception e) {
            p63.f("JCommonPresenter", "configReportRunningApp exception:" + e.getMessage());
        }
    }

    public static JSONObject b(Context context, JSONObject jSONObject, String str) {
        return fv2.b(context, jSONObject, str);
    }

    public static void c(Runnable runnable) {
        bw2.c(runnable, new int[0]);
    }

    public static String d(Context context) {
        return ad.c(context);
    }

    public static String e(Context context) {
        return fv2.e(context);
    }

    public static String f(Context context) {
        return fv2.f(context);
    }

    public static ComponentInfo g(Context context, String str, Class<?> cls) {
        return ad.g(context, str, cls);
    }

    public static String h(String str) {
        return n45.c(str);
    }

    public static String i(Context context) {
        return fv2.g(context);
    }

    public static int j(Context context) {
        return tb1.f20948a;
    }

    public static String k(String str) {
        return n45.e(str);
    }

    public static String l(String str) {
        return nl5.h(str);
    }

    public static String m(Context context) {
        return fv2.j(context);
    }

    public static String n(Context context) {
        return zd1.e().h(context);
    }

    public static byte o(Context context) {
        return zd1.e().i(context);
    }

    public static long p() {
        return zd1.e().j();
    }

    public static long q(Context context) {
        return mg5.b(context);
    }

    public static String r() {
        return wv2.b;
    }

    public static String s(int i) {
        return zd1.e().l(i);
    }

    public static int t() {
        return wv2.c;
    }

    public static long u(Context context) {
        return fv2.n(context);
    }

    public static boolean v(Context context, String str) {
        return ad.s(context, str);
    }

    public static File w(Context context, String str) {
        return hv1.e(context, str);
    }

    public static boolean x(Context context, boolean z, String str) {
        return tv2.b(context, z, str);
    }

    public static boolean y() {
        return bw2.f1842a;
    }

    public static boolean z(Context context) {
        return mg5.d(context);
    }
}
