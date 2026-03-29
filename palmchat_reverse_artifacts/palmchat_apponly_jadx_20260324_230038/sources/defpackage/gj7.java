package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class gj7 {
    public static String a(Context context, int i) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfoH = sl7.h(context, i);
        if (processErrorStateInfoH == null || Process.myPid() != processErrorStateInfoH.pid) {
            return null;
        }
        return ki7.a(processErrorStateInfoH);
    }

    public static JSONObject b(boolean z) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", tj7.e(stackTrace));
        return jSONObject;
    }
}
