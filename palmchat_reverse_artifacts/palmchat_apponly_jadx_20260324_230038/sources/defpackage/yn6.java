package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.lantern.daemon.dp3.DaemonHelper;
import com.lantern.daemon.dp3.utils.Reflection;
import com.zenmen.palmchat.modulemanager.TaskExecutorHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class yn6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f22235a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f22236a;

        public a(Context context) {
            this.f22236a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            yn6.i(this.f22236a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements DaemonHelper.IDaemonCallback {
        @Override // com.lantern.daemon.dp3.DaemonHelper.IDaemonCallback
        public void onAlive(Context context, Map map) {
            if (map == null || !map.containsKey("type")) {
                return;
            }
            Object obj = map.get("type");
            Log.i("WkDaemonProcessor", "onAlive " + obj);
            if ((obj instanceof String) && "file_lock_start".equals(obj)) {
                Log.d("WkDaemonProcessor", "file_lock_start");
                LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_KEEPALIVE, null, "wkdaemon01", "1", null, null);
                vt0.d().n("from_self");
                yn6.p(context);
            }
        }
    }

    public static void c(Context context) {
        if (ot0.f().b("ziqidongbaoheSdk") && j(context)) {
            Reflection.unseal(context);
            if (Build.VERSION.SDK_INT >= 30) {
                long jB = ir5.b();
                Log.e("WkDaemonProcessor", "attachBaseContext addhiddenapi =" + ir5.e(jB) + " result=" + sh2.b("L"));
            }
        }
    }

    public static boolean d(Context context, String str, boolean z) {
        try {
            return g(context).getBoolean(str, z);
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public static Pair<Integer, Integer> e(String str) {
        try {
            if (TextUtils.isEmpty(str) || !str.contains("_")) {
                return null;
            }
            String[] strArrSplit = str.split("_");
            return new Pair<>(Integer.valueOf(strArrSplit[0]), Integer.valueOf(strArrSplit[1]));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int f(long j) {
        return (int) (j / 86400000);
    }

    public static SharedPreferences g(Context context) {
        return context.getSharedPreferences("sp_WkDaemonProcessor", 4);
    }

    public static String h(Context context, String str, String str2) {
        try {
            return g(context).getString(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static void i(Context context) {
        DaemonHelper.instance().init(context, true, ot0.f().e());
        DaemonHelper.instance().callback = new b();
        Log.d("WkDaemonProcessor", "onCreateImp end");
    }

    public static boolean j(Context context) {
        if (f22235a == null) {
            boolean zD = d(context, "enable_V2", false);
            boolean zK = k(context);
            if (zD && zK) {
                f22235a = Boolean.TRUE;
            } else {
                f22235a = Boolean.FALSE;
            }
            Log.d("WkDaemonProcessor", "isEnable enableSp" + zD + " fre" + zK);
        }
        return f22235a.booleanValue();
    }

    public static boolean k(Context context) {
        String strH;
        String strH2;
        String strH3 = h(context, "frequency_enable", "A");
        boolean z = true;
        if ("A".equals(strH3)) {
            strH = null;
            strH2 = null;
        } else {
            strH = h(context, "pull_count", "");
            Pair<Integer, Integer> pairE = e(strH);
            long jF = f(ir5.b());
            strH2 = h(context, "max_pull_count", String.valueOf(5));
            if (pairE != null && ((Integer) pairE.first).intValue() == jF && ((Integer) pairE.second).intValue() >= Integer.valueOf(strH2).intValue()) {
                z = false;
            }
        }
        Log.d("WkDaemonProcessor", "isFrequencyOk enableSp" + strH3 + " maxCount=" + strH2 + "content=" + strH + " result =" + z);
        return z;
    }

    public static void l(Context context) {
        if (ot0.f().b("ziqidongbaoheSdk") && j(context)) {
            boolean zI = ot0.f().i();
            Log.d("WkDaemonProcessor", "onCreate enableAsync=" + zI);
            if (zI) {
                TaskExecutorHelper.safeRun("WkDaemonProcessorInit", new a(context));
            } else {
                i(context);
            }
        }
    }

    public static void m(Context context, String str, boolean z) {
        try {
            g(context).edit().putBoolean(str, z).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void n(Context context, String str, String str2) {
        try {
            g(context).edit().putString(str, str2).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void o(Context context) {
        JSONObject jSONObjectZ;
        boolean zA = jo6.a("LX-20245", false);
        LogUtil.i("WkDaemonProcessor", "updateEnable" + zA);
        m(context, "enable_V2", zA);
        String strC = jo6.c("LX-37024", "A");
        n(context, "frequency_enable", strC);
        if ("A".equals(strC) || (jSONObjectZ = ts0.o().z()) == null) {
            return;
        }
        n(context, "max_pull_count", String.valueOf(jSONObjectZ.optInt("frequency" + strC, 5)));
    }

    public static void p(Context context) {
        String str;
        if (!"A".equals(h(context, "frequency_enable", "A"))) {
            Pair<Integer, Integer> pairE = e(h(context, "pull_count", ""));
            long jF = f(ir5.b());
            if (pairE == null) {
                str = jF + "_1";
            } else if (((Integer) pairE.first).intValue() == jF) {
                str = jF + "_" + (((Integer) pairE.second).intValue() + 1);
            } else {
                str = jF + "_1";
            }
            n(context, "pull_count", str);
            LogUtil.i("WkDaemonProcessor", "updateOnWake saveStatus" + str);
        }
        m(context, "has_success", true);
    }
}
