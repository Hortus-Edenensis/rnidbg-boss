package defpackage;

import android.text.TextUtils;
import com.hihonor.push.sdk.HonorPushCallback;
import com.hihonor.push.sdk.HonorPushClient;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.thirdpush.PushTokenManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class mi2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f19223a = false;
    public static String b = null;
    public static boolean c = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements HonorPushCallback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HonorPushCallback f19224a;

        public a(HonorPushCallback honorPushCallback) {
            this.f19224a = honorPushCallback;
        }

        @Override // com.hihonor.push.sdk.HonorPushCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            mi2.b = str;
            this.f19224a.onSuccess(str);
        }

        @Override // com.hihonor.push.sdk.HonorPushCallback
        public void onFailure(int i, String str) {
            this.f19224a.onFailure(i, str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements HonorPushCallback<String> {
            public a() {
            }

            @Override // com.hihonor.push.sdk.HonorPushCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str) {
                LogUtil.i("HonorUtils", "get token:" + str);
                mi2.c = false;
                mi2.j(str);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                PushTokenManager.l(str, PushTokenManager.PushType.HONOR);
            }

            @Override // com.hihonor.push.sdk.HonorPushCallback
            public void onFailure(int i, String str) {
                LogUtil.i("HonorUtils", "onFailure:" + i + " " + str);
                mi2.c = false;
                mi2.j(null);
                LogUtil.onImmediateClickEvent("HONORError", String.valueOf(i), null);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                mi2.f(new a());
            } catch (Throwable th) {
                th.printStackTrace();
                LogUtil.onImmediateClickEvent("HONORError", "ex=" + th.toString(), null);
            }
        }
    }

    public static void e() {
        LogUtil.i("HonorUtils", "get token: begin" + c);
        if (c) {
            return;
        }
        c = true;
        u93.e(new b());
    }

    public static void f(HonorPushCallback<String> honorPushCallback) {
        if (TextUtils.isEmpty(b)) {
            HonorPushClient.getInstance().getPushToken(new a(honorPushCallback));
        } else {
            honorPushCallback.onSuccess(b);
        }
    }

    public static void g() {
        if (i()) {
            HonorPushClient.getInstance().init(AppContext.getContext(), false);
        }
    }

    public static boolean h() throws Throwable {
        int iE = sb1.e("ro.build.version.magic", "MagicOS");
        return iE == -1 || iE >= 800;
    }

    public static boolean i() throws Throwable {
        boolean zCheckSupportHonorPush = HonorPushClient.getInstance().checkSupportHonorPush(AppContext.getContext());
        boolean zH = h();
        LogUtil.i("HonorUtils", "isSupport=" + zCheckSupportHonorPush + " isMagicOSAndBeyond8=" + zH);
        return zCheckSupportHonorPush && (zH || f19223a);
    }

    public static void j(String str) {
        if (b63.a().b().c()) {
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(str)) {
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
    }

    public static void k() {
        LogUtil.i("HonorUtils", "requestToken");
        if (hx3.m(AppContext.getContext()) && nl0.g() && PushTokenManager.h()) {
            e();
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
}
