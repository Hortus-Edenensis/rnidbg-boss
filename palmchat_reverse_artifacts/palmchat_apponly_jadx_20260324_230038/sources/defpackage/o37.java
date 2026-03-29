package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class o37 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19689a = null;
    public static long b = -1;
    public static boolean c = false;
    public static ActivityManager.ProcessErrorStateInfo d;

    public static String a(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        if (!x97.z()) {
            return "|------------- processErrorStateInfo--------------|\ndisable anr info\n\"-----------------------end----------------------------\"";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("|------------- processErrorStateInfo--------------|\n");
        sb.append("condition: " + processErrorStateInfo.condition + "\n");
        sb.append("processName: " + processErrorStateInfo.processName + "\n");
        sb.append("pid: " + processErrorStateInfo.pid + "\n");
        sb.append("uid: " + processErrorStateInfo.uid + "\n");
        sb.append("tag: " + processErrorStateInfo.tag + "\n");
        sb.append("shortMsg : " + processErrorStateInfo.shortMsg + "\n");
        sb.append("longMsg : " + processErrorStateInfo.longMsg + "\n");
        sb.append("-----------------------end----------------------------");
        return sb.toString();
    }

    public static String b(Context context, int i) {
        if (nj7.c(256)) {
            c = false;
            return "TEST_ANR_INFO";
        }
        if (SystemClock.uptimeMillis() - b < 5000) {
            return null;
        }
        try {
            ActivityManager.ProcessErrorStateInfo processErrorStateInfoB = kv6.b(context, i);
            if (processErrorStateInfoB != null && Process.myPid() == processErrorStateInfoB.pid) {
                ActivityManager.ProcessErrorStateInfo processErrorStateInfo = d;
                if (processErrorStateInfo != null && e(processErrorStateInfo, processErrorStateInfoB)) {
                    return null;
                }
                d = processErrorStateInfoB;
                f19689a = null;
                b = SystemClock.uptimeMillis();
                c = false;
                return a(processErrorStateInfoB);
            }
        } catch (Throwable unused) {
        }
        String str = f19689a;
        if (str == null) {
            return null;
        }
        c = true;
        f19689a = null;
        b = SystemClock.uptimeMillis();
        return str;
    }

    public static JSONObject c(boolean z) {
        try {
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("thread_number", 1);
            jSONObject.put("mainStackFromTrace", yl7.e(stackTrace));
            return jSONObject;
        } catch (Throwable th) {
            n37.a();
            n37.b("NPTH_CATCH", th);
            return null;
        }
    }

    public static boolean d() {
        return c;
    }

    public static boolean e(ActivityManager.ProcessErrorStateInfo processErrorStateInfo, ActivityManager.ProcessErrorStateInfo processErrorStateInfo2) {
        return String.valueOf(processErrorStateInfo.condition).equals(String.valueOf(processErrorStateInfo2.condition)) && String.valueOf(processErrorStateInfo.processName).equals(String.valueOf(processErrorStateInfo2.processName)) && String.valueOf(processErrorStateInfo.pid).equals(String.valueOf(processErrorStateInfo2.pid)) && String.valueOf(processErrorStateInfo.uid).equals(String.valueOf(processErrorStateInfo2.uid)) && String.valueOf(processErrorStateInfo.tag).equals(String.valueOf(processErrorStateInfo2.tag)) && String.valueOf(processErrorStateInfo.shortMsg).equals(String.valueOf(processErrorStateInfo2.shortMsg)) && String.valueOf(processErrorStateInfo.longMsg).equals(String.valueOf(processErrorStateInfo2.longMsg));
    }

    public static void f() {
        d = null;
    }
}
