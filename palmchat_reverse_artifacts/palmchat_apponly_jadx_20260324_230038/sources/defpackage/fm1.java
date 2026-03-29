package defpackage;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.huawei.hms.ads.ex;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.lantern.auth.server.WkParams;
import com.umeng.ccg.a;
import com.wifi.open.sec.InputListInfo;
import com.wifi.open.sec.SecInfo;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.SmidHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class fm1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f17555a;

    public static void a() throws JSONException {
        ServiceInfo serviceInfo;
        AccessibilityManager accessibilityManager = (AccessibilityManager) AppContext.getContext().getSystemService("accessibility");
        accessibilityManager.getInstalledAccessibilityServiceList();
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16);
        JSONArray jSONArray = new JSONArray();
        if (enabledAccessibilityServiceList != null) {
            for (int i = 0; i < enabledAccessibilityServiceList.size(); i++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    ResolveInfo resolveInfo = enabledAccessibilityServiceList.get(i).getResolveInfo();
                    if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                        jSONObject.put("package", serviceInfo.packageName);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        LogUtil.i("EmulatorUtil", "accessibility_list=" + jSONArray.toString());
        f17555a.put("accessibility_list", jSONArray);
    }

    public static void b() throws JSONException {
        String name;
        String address = "none";
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                name = defaultAdapter.getName();
                try {
                    if (defaultAdapter.isEnabled()) {
                        address = defaultAdapter.getAddress();
                    }
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                }
            } else {
                name = "none";
            }
        } catch (Throwable th2) {
            th = th2;
            name = "none";
        }
        f17555a.put("bt_mac", address);
        f17555a.put("bt_name", name);
    }

    public static void c() throws JSONException {
        String strTrim;
        String str;
        String strTrim2;
        Throwable th;
        InputStream inputStream;
        BufferedReader bufferedReader;
        f17555a.put("cpu_cores", Runtime.getRuntime().availableProcessors());
        String strN = n();
        String strO = o();
        try {
            inputStream = Runtime.getRuntime().exec("cat /proc/cpuinfo").getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            strTrim = "unknown";
            str = strTrim;
            strTrim2 = str;
        } catch (Throwable th2) {
            strTrim = "unknown";
            str = strTrim;
            strTrim2 = str;
            th = th2;
        }
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.contains("Hardware")) {
                    strTrim2 = line.split(":")[1].trim();
                } else if (line.contains("Features")) {
                    strTrim = line.split(":")[1].trim();
                } else if (line.contains("Processor")) {
                    String strTrim3 = line.split(":")[1].trim();
                    if (str.equals("unknown")) {
                        str = strTrim3;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
            }
            f17555a.put("cpu_features", strTrim);
            f17555a.put("cpu_hardware", strTrim2);
            f17555a.put("cpu_max_freq", strN);
            f17555a.put("cpu_min_freq", strO);
            f17555a.put("cpu_processor", str);
        }
        bufferedReader.close();
        inputStream.close();
        f17555a.put("cpu_features", strTrim);
        f17555a.put("cpu_hardware", strTrim2);
        f17555a.put("cpu_max_freq", strN);
        f17555a.put("cpu_min_freq", strO);
        f17555a.put("cpu_processor", str);
    }

    public static void d() {
        try {
            f17555a.put(WfConstant.EXTRA_KEY_APP_PKG, c.b().getPackageName());
            f17555a.put("app_name", "palmchat");
            f17555a.put("app_version", ac1.g);
            if (Build.VERSION.SDK_INT >= 23) {
                f17555a.put("build_version_security_patch", Build.VERSION.SECURITY_PATCH);
            }
            f17555a.put("build_fingerprint", Build.FINGERPRINT);
            f17555a.put("build_host", Build.HOST);
            f17555a.put("build_time", Build.TIME);
            f17555a.put("build_cpu_abis", az2.c(Build.SUPPORTED_ABIS));
            f17555a.put("build_display", Build.DISPLAY);
            f17555a.put("build_id", Build.ID);
            f17555a.put("build_manufacturer", Build.MANUFACTURER);
            f17555a.put("build_bootloader", Build.BOOTLOADER);
            f17555a.put("build_version_codename", Build.VERSION.CODENAME);
            c();
            f17555a.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, hx3.c());
            f17555a.put("gles", 3);
            e();
            f17555a.put("wifiSSID", hx3.l());
            i();
            b();
            f17555a.put("http.agent", ac1.x(AppContext.getContext()));
            f17555a.put("screen_brightness", Settings.System.getInt(c.b().getContentResolver(), "screen_brightness", 125));
            PowerManager powerManager = (PowerManager) AppContext.getContext().getApplicationContext().getSystemService("power");
            f17555a.put(a.f, powerManager != null && powerManager.isScreenOn());
            h();
            f17555a.put("last_boot_time", System.currentTimeMillis() - SystemClock.elapsedRealtime());
            f17555a.put("usb_state", q());
            a();
            LogUtil.i("EmulatorUtil", "dfp= " + f17555a);
        } catch (Throwable th) {
            th.printStackTrace();
            LogUtil.i("EmulatorUtil", "appendExtraInfo error " + th);
        }
    }

    public static void e() throws JSONException {
        String host;
        int port;
        ProxyInfo defaultProxy;
        ConnectivityManager connectivityManager = (ConnectivityManager) c.b().getSystemService("connectivity");
        if (Build.VERSION.SDK_INT < 23 || connectivityManager.getActiveNetwork() == null || (defaultProxy = connectivityManager.getDefaultProxy()) == null) {
            host = "none";
            port = 0;
        } else {
            host = defaultProxy.getHost();
            port = defaultProxy.getPort();
        }
        f17555a.put("proxy_ip", host);
        f17555a.put("proxy_port", port);
    }

    public static void f() {
        String strQ = SmidHelper.q();
        if (TextUtils.isEmpty(strQ)) {
            strQ = "";
        }
        try {
            f17555a.put("duDeviceLabel", strQ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void g() {
        try {
            SecInfo secInfo = new SecInfo();
            InputListInfo inputListInfo = new InputListInfo();
            f17555a.put(secInfo.getTag(), secInfo.ons());
            f17555a.put("netState", hx3.d(true));
            f17555a.put(inputListInfo.getTag(), inputListInfo.oni());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void h() throws JSONException {
        SensorManager sensorManager = (SensorManager) c.b().getApplicationContext().getSystemService("sensor");
        String str = "";
        if (sensorManager != null) {
            List<Sensor> sensorList = sensorManager.getSensorList(-1);
            for (int i = 0; i < sensorList.size(); i++) {
                Sensor sensor = sensorList.get(i);
                str = str + sensor.getName() + "_" + sensor.getVendor();
                if (i != sensorList.size() - 1) {
                    str = str + ",";
                }
            }
        }
        f17555a.put("sensor_name_list", str);
    }

    public static void i() throws JSONException {
        String strM = "none";
        try {
            WifiInfo connectionInfo = ((WifiManager) AppContext.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                strM = m(connectionInfo.getIpAddress());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        f17555a.put("wifi_ip", strM);
    }

    public static void j() throws Throwable {
        boolean zB;
        try {
            try {
                zB = tv1.b();
            } catch (Exception e) {
                e.printStackTrace();
                zB = false;
            }
            if (zB) {
                f17555a.put("hasTracerPid", ex.Code);
            } else {
                f17555a.put("hasTracerPid", ex.V);
            }
            if (tv1.c()) {
                f17555a.put("isDebuggerConnected", ex.Code);
            } else {
                f17555a.put("isDebuggerConnected", ex.V);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static JSONObject k() {
        if (f17555a == null) {
            f17555a = l();
        }
        LogUtil.i("EmulatorUtil", "dfp= " + f17555a);
        return f17555a;
    }

    public static JSONObject l() throws Throwable {
        f17555a = new JSONObject();
        g();
        v();
        t();
        j();
        u();
        f();
        d();
        LogUtil.i("EmulatorUtil", "dfpImp= " + f17555a);
        return f17555a;
    }

    public static String m(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public static String n() {
        String line = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            line = bufferedReader.readLine();
            bufferedReader.close();
            return line;
        } catch (Throwable th) {
            th.printStackTrace();
            return line;
        }
    }

    public static String o() {
        String line = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"));
            line = bufferedReader.readLine();
            bufferedReader.close();
            return line;
        } catch (Throwable th) {
            th.printStackTrace();
            return line;
        }
    }

    public static String p() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "sys.usb.config");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String q() {
        return p();
    }

    public static boolean r() {
        try {
            Cipher.class.getField("key");
            return true;
        } catch (NoSuchFieldException unused) {
            return false;
        }
    }

    public static boolean s() {
        try {
            FileDescriptor.class.getField("name");
            return true;
        } catch (NoSuchFieldException unused) {
            return false;
        }
    }

    public static void t() {
        try {
            if (fw1.a()) {
                f17555a.put("isUserAMonkey", ex.Code);
            } else {
                f17555a.put("isUserAMonkey", ex.V);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void u() {
        try {
            f17555a.put("deviceId", ac1.i);
            f17555a.put(WkParams.IMEI, ac1.i);
            f17555a.put("imsi", ac1.j);
            f17555a.put("resolution", me1.e());
            f17555a.put("androidid", ac1.p);
            f17555a.put("simulator", ac1.n ? 1 : 0);
            f17555a.put("android.os.Build.BOARD", Build.BOARD);
            f17555a.put("android.os.Build.BRAND", Build.BRAND);
            f17555a.put("android.os.Build.DEVICE", Build.DEVICE);
            f17555a.put("android.os.Build.HARDWARE", Build.HARDWARE);
            f17555a.put("android.os.Build.MODEL", Build.MODEL);
            f17555a.put("android.os.Build.PRODUCT", Build.PRODUCT);
            f17555a.put("android.os.Build.VERSION.RELEASE", Build.VERSION.RELEASE);
            f17555a.put("phoneNumber", "");
            f17555a.put("socket_pipe", uv1.g());
            if (uv1.j()) {
                f17555a.put("hasQemuDrivers", ex.Code);
            } else {
                f17555a.put("hasQemuDrivers", ex.V);
            }
            if (uv1.i()) {
                f17555a.put("hasEmulatorAdb", ex.Code);
            } else {
                f17555a.put("hasEmulatorAdb", ex.V);
            }
            f17555a.put("QEmuFiles", uv1.h());
            f17555a.put("GenyFiles", uv1.b());
            f17555a.put("checkQemuBreakpoint", ex.V);
            f17555a.put("macAddr", uv1.f());
            f17555a.put("basicVersion", uv1.a());
            f17555a.put("kernelVersion", uv1.e());
            f17555a.put("innerVersion", uv1.d());
            f17555a.put("ip", uv1.c(AppContext.getContext()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void v() {
        try {
            if (pw1.a(AppContext.getContext())) {
                f17555a.put("org.appanalysis", ex.Code);
            } else {
                f17555a.put("org.appanalysis", ex.V);
            }
            if (pw1.b()) {
                f17555a.put("dalvik.system.Taint", ex.Code);
            } else {
                f17555a.put("dalvik.system.Taint", ex.V);
            }
            if (s()) {
                f17555a.put("FileDescriptor_name", ex.Code);
            } else {
                f17555a.put("FileDescriptor_name", ex.V);
            }
            if (r()) {
                f17555a.put("Cipher_key", ex.Code);
            } else {
                f17555a.put("Cipher_key", ex.V);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
