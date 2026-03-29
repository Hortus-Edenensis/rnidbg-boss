package defpackage;

import android.content.Context;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class zw4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ko2 f22534a;

    public static ko2 a() {
        return f22534a;
    }

    public static String b() {
        return f22534a.getUserAgent();
    }

    public static void c(Context context, ko2 ko2Var) {
        ko2Var.init(context);
        f22534a = ko2Var;
    }

    @Deprecated
    public static JSONObject d(String str, HashMap<String, Object> map) throws Exception {
        return f22534a.h(str, map, true);
    }

    public static void e(go2 go2Var) {
        f22534a.f(go2Var);
    }

    @Deprecated
    public static void f(String str, int i, JSONObject jSONObject, yw4 yw4Var) {
        g(str, i, jSONObject, yw4Var, true);
    }

    @Deprecated
    public static void g(String str, int i, JSONObject jSONObject, yw4 yw4Var, boolean z) {
        f22534a.c(str, i, jSONObject, yw4Var, z, true);
    }

    @Deprecated
    public static void h(String str, String str2, String str3, int i, JSONObject jSONObject, yw4 yw4Var) {
        try {
            f22534a.c(k86.b0(str, str2, str3), i, jSONObject, yw4Var, false, true);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void i(String str, int i, JSONObject jSONObject, yw4 yw4Var, boolean z) {
        f22534a.c(str, i, jSONObject, yw4Var, z, false);
    }

    public static void j(String str, int i, JSONObject jSONObject, yw4 yw4Var, boolean z, boolean z2) {
        f22534a.c(str, i, jSONObject, yw4Var, z, z2);
    }

    public static LXBaseNetBean k(go2 go2Var) throws Exception {
        return f22534a.e(go2Var);
    }

    @Deprecated
    public static JSONObject l(String str, int i, JSONObject jSONObject) throws Exception {
        return f22534a.d(str, i, jSONObject, true, null);
    }

    @Deprecated
    public static JSONObject m(String str, int i, JSONObject jSONObject, aw awVar) throws Exception {
        return f22534a.d(str, i, jSONObject, true, awVar);
    }

    public static void n(String str, String str2, String str3, yw4 yw4Var) {
        try {
            f22534a.a(str, str2, str3, yw4Var);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void o(String str, String str2, String str3, String str4, String str5, yw4 yw4Var) {
        try {
            f22534a.b(str, str2, str3, str4, str5, yw4Var);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void p(JSONObject jSONObject) {
        f22534a.g(jSONObject);
    }
}
