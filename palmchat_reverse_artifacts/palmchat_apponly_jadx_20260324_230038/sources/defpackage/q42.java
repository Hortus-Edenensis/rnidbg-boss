package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public final class q42 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20176a = "q42";
    public static JSONObject b = new JSONObject();
    public static boolean c = false;
    public static JSONObject d = new JSONObject();
    public static String e = "";
    public static String f = "";

    static {
        b();
        c();
    }

    public static boolean a() {
        return d.optBoolean("hit", false);
    }

    public static void b() {
        JSONObject jSONObject;
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.MAINTAB_CONFIG, k86.a("key_fun_group_mgr_content"), "");
        if (TextUtils.isEmpty(strN)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(strN);
            } catch (Exception e2) {
                LogUtil.e(f20176a, "parse disk group info failed.", e2);
                jSONObject = null;
            }
        }
        if (jSONObject == null) {
            b = new JSONObject();
        } else {
            b = jSONObject;
        }
    }

    public static void c() {
        JSONObject jSONObject;
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.MAINTAB_CONFIG, k86.a("key_fun_group_uid_hit_content"), "");
        if (TextUtils.isEmpty(strN)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(strN);
            } catch (Exception e2) {
                LogUtil.e(f20176a, "parse disk uid hit failed.", e2);
                jSONObject = null;
            }
        }
        if (jSONObject == null) {
            d = new JSONObject();
        } else {
            d = jSONObject;
        }
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            e = jSONObject.optString("new_kdy_fullopenchannel", "");
            f = jSONObject.optString("old_kdy_fullopenchannel", "");
            LogUtil.d(f20176a, "initConfig newKdyFullopenchannel:" + e + " oldKdyFullopenchannel " + f);
        } catch (Exception unused) {
        }
    }

    public static void e(String str) {
    }
}
