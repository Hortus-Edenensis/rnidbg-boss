package defpackage;

import android.util.Log;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.Thread;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class vq0 implements Thread.UncaughtExceptionHandler {
    public static final String c = "vq0";
    public static vq0 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DateFormat f21506a = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss");
    public Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();

    public vq0() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static void b(Throwable th) {
        Map<Thread, StackTraceElement[]> allStackTraces;
        int i;
        if (!e(th) || (allStackTraces = Thread.getAllStackTraces()) == null || allStackTraces.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (it.hasNext()) {
            Iterator<Map.Entry<Thread, StackTraceElement[]>> it2 = it;
            Thread key = it.next().getKey();
            Map<Thread, StackTraceElement[]> map = allStackTraces;
            String name = key.getName();
            if (i15 % 10 == 0) {
                i = i7;
                sb.append(HttpClient.NEWLINE);
            } else {
                i = i7;
            }
            i15++;
            sb.append(name);
            sb.append(", ");
            if (key instanceof g13) {
                i5++;
            } else if (name.startsWith("LXHT#")) {
                i2++;
            } else if (name.startsWith("LXTP#")) {
                i3++;
            } else if (name.contains("TaskScheduler")) {
                i6++;
            } else if (name.contains("OkHttp") || name.contains("Okio")) {
                i7 = i + 1;
                allStackTraces = map;
                it = it2;
            } else if (name.contains("GDT") || name.contains("gdt")) {
                i8++;
            } else if (name.contains(MediationConstant.ADN_PANGLE)) {
                i9++;
            } else if (name.contains("ksad")) {
                i10++;
            } else if (name.contains("mobads")) {
                i11++;
            } else if (name.contains("GoodPlayer")) {
                i12++;
            } else if (name.contains("exo_player")) {
                i13++;
            } else if (name.contains("-thread-") || name.contains("ThreadPool")) {
                i4++;
            } else {
                i14++;
            }
            i7 = i;
            allStackTraces = map;
            it = it2;
        }
        Map<Thread, StackTraceElement[]> map2 = allStackTraces;
        HashMap map3 = new HashMap();
        map3.put("action", "CRASH-ALL-THREADS");
        map3.put("threadSize", Integer.valueOf(map2.size()));
        map3.put("lxHandlerThreads", Integer.valueOf(i2));
        map3.put("lxPoolThreads", Integer.valueOf(i3));
        map3.put("otherPoolThreads", Integer.valueOf(i4));
        map3.put("lxThreads", Integer.valueOf(i5));
        map3.put("taskSchedulerThreads", Integer.valueOf(i6));
        map3.put("okHttpThreads", Integer.valueOf(i7));
        map3.put("gdtThreads", Integer.valueOf(i8));
        map3.put("pangleThreads", Integer.valueOf(i9));
        map3.put("ksadThreads", Integer.valueOf(i10));
        map3.put("mobadsThreads", Integer.valueOf(i11));
        map3.put("goodPlayerThreads", Integer.valueOf(i12));
        map3.put("exoPlayerThreads", Integer.valueOf(i13));
        map3.put("otherThreads", Integer.valueOf(i14));
        map3.put("allThreads", sb.toString());
        LogUtil.i(c, LogUtil.LogType.LOG_TYPE_ANR_NEW, 3, (HashMap<String, Object>) map3, th);
    }

    public static synchronized vq0 d() {
        if (d == null) {
            d = new vq0();
        }
        return d;
    }

    public static boolean e(Throwable th) {
        String message;
        return (th instanceof OutOfMemoryError) && (message = th.getMessage()) != null && message.contains("pthread_create");
    }

    public final void a(Throwable th) {
        if (th instanceof RuntimeException) {
            String message = th.getMessage();
            boolean z = message != null && message.contains("Bad notification(tag=null, id=90001) ");
            Log.e("checkNotificationError", "is" + z + " detailMessage" + message);
            if (z) {
                SPUtil.f14322a.u(SPUtil.SCENE.APP_COMMON, "key_special_attention_error", Boolean.TRUE);
                Log.e("checkNotificationError", "saveValueWithCommit");
            }
        }
    }

    public final void c(Throwable th) {
        if (th instanceof UnsatisfiedLinkError) {
            String message = th.getMessage();
            boolean z = message != null && message.contains("/data/local/plugs/libTTArtArm64.so");
            boolean z2 = message != null && message.contains("com.example.lsdemo.Hook");
            if (z || z2) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crashMsg", message);
                    jSONObject.put("libTTArtArm64", z);
                    jSONObject.put("lsdemoHook", z2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.uploadInfoImmediate("Crash_libTTArtArm64", null, null, jSONObject.toString());
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (thread.getName().equals("FinalizerWatchdogDaemon") && (th instanceof TimeoutException)) {
            return;
        }
        b(th);
        a(th);
        c(th);
        this.b.uncaughtException(thread, th);
    }
}
