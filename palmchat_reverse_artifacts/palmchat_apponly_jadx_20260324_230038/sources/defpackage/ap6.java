package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.zenmen.palmchat.thirdpush.PushTokenManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ap6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1550a = "ap6";
    public static String b = "2882303761517526122";
    public static String c = "5231752684122";

    public static void a(Context context) {
        if (PushTokenManager.h() && hx3.m(context) && nl0.g() && vp3.e()) {
            LogUtil.d(f1550a, "initXiaomiPush");
            if (!b(context)) {
                if (b63.a().b().c()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("isPushSdkInit", true);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push02", null, null, jSONObject.toString());
                    return;
                }
                return;
            }
            MiPushClient.registerPush(context, b, c);
            if (b63.a().b().c()) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("isPushSdkInit", true);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_THIRD_PUSH, null, "push02", null, null, jSONObject2.toString());
            }
        }
    }

    public static boolean b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        String str = context.getApplicationInfo().processName;
        int iMyPid = Process.myPid();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid && str.equals(runningAppProcessInfo.processName)) {
                return true;
            }
        }
        return false;
    }
}
