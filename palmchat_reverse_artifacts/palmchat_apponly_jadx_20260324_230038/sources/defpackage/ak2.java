package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.HmsMessaging;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.thirdpush.PushTokenManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ak2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f1245a = false;
    public static String b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                String strD = ak2.d();
                if (b63.a().b().c()) {
                    JSONObject jSONObject = new JSONObject();
                    if (TextUtils.isEmpty(strD)) {
                        try {
                            jSONObject.put("isTokenGet", false);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            jSONObject.put("isTokenGet", true);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push03", null, null, jSONObject.toString());
                }
                if (!TextUtils.isEmpty(strD)) {
                    PushTokenManager.l(strD, PushTokenManager.PushType.HUAWEI);
                }
            } catch (ApiException e3) {
                Log.e("HWPUSH_HwUtils", "get token failed, " + e3);
                LogUtil.onImmediateClickEvent("HMSCoreError", String.valueOf(e3.getStatusCode()), null);
            } catch (Throwable th) {
                th.printStackTrace();
                LogUtil.onImmediateClickEvent("HMSCoreError", "ex=" + th.toString(), null);
            }
            ak2.f1245a = false;
        }
    }

    public static void c() {
        LogUtil.i("HWPUSH_HwUtils", "get token: begin" + f1245a);
        if (f1245a) {
            return;
        }
        f1245a = true;
        u93.d(4000, new a());
    }

    public static String d() throws ApiException {
        if (TextUtils.isEmpty(b)) {
            String token = HmsInstanceId.getInstance(AppContext.getContext()).getToken(l.c(AppContext.getContext()).getString("client/app_id"), HmsMessaging.DEFAULT_TOKEN_SCOPE);
            Log.i("HWPUSH_HwUtils", "get token:" + token);
            b = token;
        }
        return b;
    }

    public static void f() {
        LogUtil.i("HWPUSH_HwUtils", "requestToken");
        if (hx3.m(AppContext.getContext()) && nl0.g() && PushTokenManager.h()) {
            c();
            if (b63.a().b().c()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isPushSdkInit", true);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push02", null, null, jSONObject.toString());
            }
        }
    }

    public static void e() {
    }
}
