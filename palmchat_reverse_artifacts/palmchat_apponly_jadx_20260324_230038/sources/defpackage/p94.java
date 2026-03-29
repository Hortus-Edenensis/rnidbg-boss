package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.thirdpush.PushTokenManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class p94 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19972a = "p94";
    public static ICallBackResultService b = new b();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("action", "opush");
            put("allaction", "doRegister");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ICallBackResultService {
        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onError(int i, String str, String str2, String str3) {
            LogUtil.i(p94.f19972a, "onError errorCode=" + i + ",message=" + str);
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onGetNotificationStatus(int i, int i2) {
            LogUtil.i(p94.f19972a, "onGetPushStatus code=" + i + ",status=" + i2);
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onGetPushStatus(int i, int i2) {
            LogUtil.i(p94.f19972a, "onGetPushStatus code=" + i + ",status=" + i2);
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onRegister(int i, String str, String str2, String str3) {
            LogUtil.i(p94.f19972a, "onRegister" + i + " s=" + str);
            if (b63.a().b().c()) {
                JSONObject jSONObject = new JSONObject();
                if (i == 0) {
                    try {
                        jSONObject.put("isTokenGet", true);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        jSONObject.put("isTokenGet", false);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push03", null, null, jSONObject.toString());
            }
            if (nl0.g() && PushTokenManager.h()) {
                LogUtil.i(p94.f19972a, "upload Oppo token: " + str);
                PushTokenManager.l(str, PushTokenManager.PushType.OPPO);
            }
            if (r75.d(AppContext.getContext(), "sp_push_init_event", false)) {
                return;
            }
            LogUtil.i(p94.f19972a, "IMEI: onevent");
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dhid", ac1.h);
                jSONObject2.put("token", str);
                jSONObject2.put("manufacture", ac1.f1194a);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("00", null, null, jSONObject2.toString());
            r75.o(AppContext.getContext(), "sp_push_init_event", true);
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onSetPushTime(int i, String str) {
            LogUtil.i(p94.f19972a, "onSetPushTime code=" + i + ",s=" + str);
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onUnRegister(int i, String str, String str2) {
            LogUtil.i(p94.f19972a, "onUnRegister" + i);
        }
    }

    public static String b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.e(f19972a, "getMetaInfo NameNotFoundException:" + e.getMessage());
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            return applicationInfo.metaData.getString(str);
        }
        return null;
    }

    public static boolean c() {
        return HeytapPushManager.isSupportPush(AppContext.getContext());
    }

    public static void d(Context context) {
        HeytapPushManager.init(context, false);
    }

    public static void e() {
        if (hx3.m(AppContext.getContext()) && nl0.g() && PushTokenManager.h()) {
            try {
                String strB = b(AppContext.getContext(), com.heytap.mcssdk.constant.b.z);
                String strB2 = b(AppContext.getContext(), com.heytap.mcssdk.constant.b.A);
                String str = f19972a;
                LogUtil.i(str, "before REGISTER appkey: " + strB + " appsecret" + strB2);
                boolean zIsSupportPush = HeytapPushManager.isSupportPush(AppContext.getContext());
                StringBuilder sb = new StringBuilder();
                sb.append("isSupport : ");
                sb.append(zIsSupportPush);
                LogUtil.i(str, sb.toString());
                if (!zIsSupportPush) {
                    if (b63.a().b().c()) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("isPushSdkInit", false);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push02", null, null, jSONObject.toString());
                        return;
                    }
                    return;
                }
                LogUtil.i(str, 3, new a(), (Throwable) null);
                HeytapPushManager.register(AppContext.getContext(), strB, strB2, b);
                if (b63.a().b().c()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("isPushSdkInit", true);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push02", null, null, jSONObject2.toString());
                    return;
                }
                return;
            } catch (Exception e3) {
                LogUtil.i(f19972a, "Exception : " + e3.toString());
                e3.printStackTrace();
            }
            LogUtil.i(f19972a, "Exception : " + e3.toString());
            e3.printStackTrace();
        }
    }
}
