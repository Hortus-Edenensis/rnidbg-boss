package com.zenmen.palmchat.thirdpush;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.huawei.hms.ads.ex;
import com.lantern.auth.server.WkParams;
import com.vivo.push.PushClient;
import com.vivo.push.PushConfig;
import com.vivo.push.util.VivoPushException;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.utils.dao.DaoException;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.ak2;
import defpackage.ap6;
import defpackage.b05;
import defpackage.b63;
import defpackage.dm1;
import defpackage.hp4;
import defpackage.hx3;
import defpackage.ir5;
import defpackage.l16;
import defpackage.lg6;
import defpackage.mi2;
import defpackage.nl0;
import defpackage.p94;
import defpackage.pg6;
import defpackage.q56;
import defpackage.vp3;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class PushTokenManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f15573a = true;
    public static boolean b = false;
    public static PushType c;
    public static JSONObject d;

    /* JADX INFO: compiled from: SearchBox */
    public enum PushType {
        HUAWEI("huawei"),
        HONOR("honor"),
        OPPO("oppo"),
        VIVO("vivo"),
        XIAOMI("xiaomi");

        public String value;

        PushType(String str) {
            this.value = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15574a;

        public a(String str) {
            this.f15574a = str;
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            int iOptInt = jSONObject.optInt("resultCode");
            LogUtil.i("PushTokenManager", "iUploadTokenInfo Result: " + jSONObject.toString());
            b05.d("iUploadTokenInfo Result: " + jSONObject.toString());
            if (iOptInt == 0) {
                AppContext.getContext().getTrayPreferences().h(PushTokenManager.f(), this.f15574a);
                AppContext.getContext().getTrayPreferences().g(PushTokenManager.g(), ir5.b());
                PushTokenManager.f15573a = false;
            }
            if (b63.a().b().c()) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (iOptInt == 0) {
                        jSONObject2.put("uploadToken", ex.Code);
                    } else {
                        jSONObject2.put("uploadToken", ex.V);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push04", null, null, jSONObject2.toString());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            LogUtil.i("PushTokenManager", "" + volleyError.toString());
            if (b63.a().b().c()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("uploadToken", ex.V);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push04", null, null, jSONObject.toString());
            }
        }
    }

    public static void c(Context context) {
        String str;
        LogUtil.i("PushTokenManager", "initThirdPush needCheckTokenUpload" + f15573a);
        if (hx3.m(AppContext.getContext()) && nl0.g() && h() && f15573a && b) {
            if (mi2.i()) {
                mi2.k();
                str = "honor";
            } else if (dm1.d()) {
                ak2.f();
                str = "huawei";
            } else if (p94.c()) {
                p94.e();
                str = "oppo";
            } else if (lg6.c()) {
                pg6.a(context);
                str = "vivo";
            } else if (vp3.e()) {
                ap6.a(context);
                str = "xiaomi";
            } else {
                str = "unknow";
            }
            if (b63.a().b().c()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("manufacture", str);
                    jSONObject.put("oriManufacture", Build.MANUFACTURER);
                    jSONObject.put(WkParams.MODEL, Build.MODEL);
                    jSONObject.put("brand", Build.BRAND);
                    jSONObject.put("sourceOsType", ac1.u());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push01", null, null, jSONObject.toString());
            }
        }
    }

    public static void d() {
        LogUtil.i("PushTokenManager", "clearStatusOnLogout ");
        l16 trayPreferences = AppContext.getContext().getTrayPreferences();
        trayPreferences.h(f(), "");
        trayPreferences.g(g(), 0L);
        f15573a = true;
        d = null;
    }

    public static JSONObject e() {
        return d;
    }

    public static String f() {
        return "upload_token_info_" + AccountUtils.p(AppContext.getContext());
    }

    public static String g() {
        return "upload_token_info_time_" + AccountUtils.p(AppContext.getContext());
    }

    public static boolean h() {
        return (TextUtils.isEmpty(AccountUtils.p(AppContext.getContext())) && d == null) ? false : true;
    }

    public static void i(String str, PushType pushType) {
        l16 trayPreferences = AppContext.getContext().getTrayPreferences();
        String strE = trayPreferences.e(f(), "");
        boolean z = Math.abs(trayPreferences.c(g(), 0L) - ir5.b()) > 86400000 && hp4.b();
        b05.d("iUploadTokenInfo " + str + ",type====>" + pushType);
        if ((str.equals(strE) && !z) || TextUtils.isEmpty(str)) {
            LogUtil.i("PushTokenManager", "Result: same return");
            f15573a = false;
            if (b63.a().b().c()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("uploadToken", "sameToken");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push04", null, null, jSONObject.toString());
                return;
            }
            return;
        }
        HashMap map = new HashMap();
        map.put("domain", "youni");
        map.put("osType", "android");
        map.put("deviceModel", ac1.b);
        try {
            map.put("sourceOsType", ac1.u());
        } catch (Exception unused) {
        }
        map.put("ptoken", str);
        map.put("manufacturer", pushType.value + "_" + ac1.f1194a);
        StringBuilder sb = new StringBuilder();
        sb.append("iUploadTokenInfo  params = ");
        sb.append(map.toString());
        LogUtil.i("PushTokenManager", sb.toString());
        try {
            new q56(new a(str), new b(), map).n();
        } catch (DaoException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static void j(Context context) {
        LogUtil.i("PushTokenManager", "onAppCreate needCheckTokenUpload" + f15573a);
        b = true;
        if (mi2.i()) {
            c = PushType.HONOR;
            mi2.g();
            return;
        }
        if (dm1.d()) {
            c = PushType.HUAWEI;
            ak2.e();
            return;
        }
        if (p94.c()) {
            c = PushType.OPPO;
            p94.d(context);
            return;
        }
        if (lg6.c()) {
            c = PushType.VIVO;
            try {
                PushClient.getInstance(context).initialize(new PushConfig.Builder().agreePrivacyStatement(true).build());
                return;
            } catch (VivoPushException e) {
                e.printStackTrace();
                return;
            }
        }
        if (vp3.e()) {
            c = PushType.XIAOMI;
            if (hp4.d()) {
                ap6.a(context);
            }
        }
    }

    public static void k(JSONObject jSONObject) {
        d = jSONObject;
    }

    public static void l(String str, PushType pushType) {
        LogUtil.i("PushTokenManager", "uploadTokenInfo");
        i(str, pushType);
    }
}
