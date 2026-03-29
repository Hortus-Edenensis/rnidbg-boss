package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.vivo.push.listener.IPushQueryActionListener;
import com.zenmen.palmchat.thirdpush.PushTokenManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class pg6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20013a = "pg6";

    /* JADX INFO: compiled from: SearchBox */
    public class a implements IPushActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20014a;

        /* JADX INFO: renamed from: pg6$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1263a implements IPushQueryActionListener {
            public C1263a() {
            }

            @Override // com.vivo.push.listener.IPushQueryActionListener, com.vivo.push.listener.IPushRequestListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onFail(Integer num) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isTokenGet", false);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push03", null, null, jSONObject.toString());
            }

            @Override // com.vivo.push.listener.IPushQueryActionListener, com.vivo.push.listener.IPushRequestListener
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str) {
                b05.d("PushApplication regId= " + str);
                if (!TextUtils.isEmpty(str)) {
                    PushTokenManager.l(str, PushTokenManager.PushType.VIVO);
                    String str2 = pg6.f20013a;
                    LogUtil.d(str2, "id: " + str);
                    LogUtil.d(str2, "imei: " + ac1.i);
                }
                if (b63.a().b().c()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("isTokenGet", true);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push03", null, null, jSONObject.toString());
                }
            }
        }

        public a(Context context) {
            this.f20014a = context;
        }

        @Override // com.vivo.push.IPushActionListener
        public void onStateChanged(int i) {
            b05.d("PushApplication=====state= " + i);
            if (i == 0) {
                PushClient.getInstance(this.f20014a).getRegId(new C1263a());
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("isTokenGet", false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push03", null, null, jSONObject.toString());
        }
    }

    public static void a(Context context) {
        if (PushTokenManager.h() && hx3.m(context) && nl0.g() && lg6.c()) {
            PushClient.getInstance(context).turnOnPush(new a(context));
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
