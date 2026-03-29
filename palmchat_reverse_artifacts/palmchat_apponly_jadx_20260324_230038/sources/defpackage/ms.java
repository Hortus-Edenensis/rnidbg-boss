package defpackage;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.matrix.AppActiveMatrixDelegate;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.batterycanary.BatteryEventDelegate;
import com.tencent.matrix.batterycanary.BatteryMonitorPlugin;
import com.tencent.matrix.plugin.Plugin;
import com.tencent.matrix.util.MatrixLog;
import com.zenmen.palmchat.battery.bean.BatteryCanaryConfig;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ms {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f19305a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements MatrixLog.MatrixLogImp {
        public final void a(String str, String str2, Object... objArr) {
            b(str, null, str2, objArr);
        }

        public final void b(String str, Throwable th, String str2, Object... objArr) {
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            LogUtil.d(str, str2, th);
        }

        @Override // com.tencent.matrix.util.MatrixLog.MatrixLogImp
        public void d(String str, String str2, Object... objArr) {
            a(str, str2, objArr);
        }

        @Override // com.tencent.matrix.util.MatrixLog.MatrixLogImp
        public void e(String str, String str2, Object... objArr) {
            a(str, str2, objArr);
        }

        @Override // com.tencent.matrix.util.MatrixLog.MatrixLogImp
        public void i(String str, String str2, Object... objArr) {
            a(str, str2, objArr);
        }

        @Override // com.tencent.matrix.util.MatrixLog.MatrixLogImp
        public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            b(str, th, str2, objArr);
        }

        @Override // com.tencent.matrix.util.MatrixLog.MatrixLogImp
        public void v(String str, String str2, Object... objArr) {
            a(str, str2, objArr);
        }

        @Override // com.tencent.matrix.util.MatrixLog.MatrixLogImp
        public void w(String str, String str2, Object... objArr) {
            a(str, str2, objArr);
        }
    }

    public static MatrixLog.MatrixLogImp a() {
        return new a();
    }

    public static BatteryCanaryConfig b() {
        JSONObject jSONObjectD = ts0.o().d();
        if (jSONObjectD != null) {
            return (BatteryCanaryConfig) new Gson().fromJson(jSONObjectD.toString(), BatteryCanaryConfig.class);
        }
        return null;
    }

    public static void c(Application application) {
        if (!e()) {
            LogUtil.d("BatteryCheckUtils", "TaiChi config is false, don't start it!");
            return;
        }
        BatteryCanaryConfig batteryCanaryConfigB = b();
        if (batteryCanaryConfigB == null) {
            LogUtil.d("BatteryCheckUtils", "has't get batteryCanary config, don't start it!");
            return;
        }
        LogUtil.d("BatteryCheckUtils", batteryCanaryConfigB.toString());
        MatrixLog.setMatrixLogImp(a());
        Matrix.Builder builder = new Matrix.Builder(application);
        builder.plugin(ks.a(batteryCanaryConfigB));
        Matrix.init(builder.build());
        h(application);
    }

    public static boolean d() {
        return "KOZ-AL00".equals(Build.MODEL);
    }

    public static boolean e() {
        if (f19305a == null) {
            f19305a = Boolean.valueOf(SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, "key_battery_canary_enable", false));
        }
        return f19305a.booleanValue() && !d();
    }

    public static void f(String str, Throwable th) {
        synchronized (ms.class) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            long jI = sPUtil.i(scene, "last_upload_time_battery_info", 0L);
            if (jI > 0 && Math.abs(jCurrentTimeMillis - jI) < 300000) {
                LogUtil.i("BatteryCheckUtils", str, th);
                return;
            }
            sPUtil.t(scene, "last_upload_time_battery_info", Long.valueOf(jCurrentTimeMillis));
            HashMap map = new HashMap();
            map.put("action", "BatteryCanary");
            map.put("bizType", 1);
            map.put("isAppFront", Boolean.valueOf(AppActiveMatrixDelegate.INSTANCE.isAppForeground()));
            map.put("info", str);
            LogUtil.i("BatteryCheckUtils", LogUtil.LogType.LOG_TYPE_ANR_NEW, 3, (HashMap<String, Object>) map, th);
        }
    }

    public static void g(String str, Throwable th) {
        HashMap map = new HashMap();
        map.put("action", "BatteryCanary");
        map.put("bizType", 2);
        map.put("isAppFront", Boolean.valueOf(AppActiveMatrixDelegate.INSTANCE.isAppForeground()));
        map.put("info", str);
        LogUtil.i("BatteryCheckUtils", LogUtil.LogType.LOG_TYPE_ANR_NEW, 3, (HashMap<String, Object>) map, th);
    }

    public static void h(Application application) {
        Plugin pluginByClass = Matrix.with().getPluginByClass(BatteryMonitorPlugin.class);
        if (pluginByClass.isPluginStarted()) {
            return;
        }
        if (!BatteryEventDelegate.isInit()) {
            BatteryEventDelegate.init(application);
        }
        MatrixLog.i("BatteryCheckUtils", "plugin-battery start", new Object[0]);
        pluginByClass.start();
    }

    public static void i() {
        SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_battery_canary_enable", Boolean.valueOf(jo6.a("LX-31393", false)));
    }
}
