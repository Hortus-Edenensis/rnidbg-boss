package defpackage;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import com.umeng.analytics.pro.bt;
import com.wifi.ad.core.config.EventParams;
import com.wifi.adsdk.utils.BLPlatform;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class hw2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f18063a = "";
    public static String b = "";
    public static final FileFilter c = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith(bt.w)) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        }
    }

    public static int a(byte[] bArr, int i) {
        byte b2;
        byte b3;
        while (i < bArr.length && (b2 = bArr[i]) != 10) {
            if (b2 >= 48 && b2 <= 57) {
                int i2 = i + 1;
                while (i2 < bArr.length && (b3 = bArr[i2]) >= 48 && b3 <= 57) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    public static int b() {
        int iIntValue = -1;
        for (int i = 0; i < c(); i++) {
            try {
                File file = new File(SysPerformanceCollector.SYS_CPU_INFO_ROOT_PATH + i + SysPerformanceCollector.SYS_CPU_MAX_FREQ_FILE);
                if (file.exists()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i2 = 0;
                        while (true) {
                            byte b2 = bArr[i2];
                            if (b2 < 48 || b2 > 57 || i2 >= 128) {
                                break;
                            }
                            i2++;
                        }
                        Integer numValueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i2)));
                        if (numValueOf.intValue() > iIntValue) {
                            iIntValue = numValueOf.intValue();
                        }
                    } catch (Throwable unused) {
                    }
                    fileInputStream.close();
                }
            } catch (Throwable unused2) {
                return -1;
            }
        }
        if (iIntValue == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int iO = o("cpu MHz", fileInputStream2) * 1000;
                if (iO > iIntValue) {
                    iIntValue = iO;
                }
                fileInputStream2.close();
            } catch (Throwable th) {
                fileInputStream2.close();
                throw th;
            }
        }
        return iIntValue;
    }

    public static int c() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(c).length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String d() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        m();
        return b;
    }

    public static String e() {
        if (!TextUtils.isEmpty(f18063a)) {
            return f18063a;
        }
        m();
        return f18063a;
    }

    public static String f(Context context) {
        try {
            vb1 vb1VarA = vb1.a(context);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sim_slots", l(context));
            jSONObject.put("packagename", context.getPackageName());
            jSONObject.put("appkey", rv2.e(context));
            jSONObject.put("platform", 0);
            jSONObject.put("apkversion", vb1VarA.b);
            jSONObject.put("systemversion", vb1VarA.c);
            jSONObject.put("modelnumber", vb1VarA.d);
            jSONObject.put("basebandversion", vb1VarA.e);
            jSONObject.put("buildnumber", vb1VarA.f);
            jSONObject.put("channel", vb1VarA.g);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("PushSDKVer", rv2.s(0));
            jSONObject2.put("StatisticSDKVer", rv2.s(1));
            jSONObject2.put("ShareSDKVer", rv2.s(2));
            jSONObject2.put("CoreSDKVer", rv2.s(3));
            jSONObject2.put("SspSDKVer", rv2.s(4));
            jSONObject2.put("VerificationSDKVer", rv2.s(5));
            jSONObject.put(EventParams.KEY_PARAM_SDKVER, jSONObject2);
            jSONObject.put("installation", vb1VarA.h);
            jSONObject.put("resolution", vb1VarA.i);
            jSONObject.put("business", rv2.p());
            jSONObject.put("device_id_status", rv2.j(context));
            jSONObject.put("device_id", rv2.i(context));
            jSONObject.put("android_id", vb1VarA.j);
            jSONObject.put("mac_address", "");
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static long g(String str) {
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 4096);
            do {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
            } while (!line.contains(str));
            bufferedReader.close();
            return Integer.valueOf(line.split("\\s+")[1]).intValue();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static long h(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            activityManager.getProcessMemoryInfo(new int[]{0});
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem / 1024;
        } catch (Throwable unused) {
            return g(BLPlatform.MEMTOTAL);
        }
    }

    public static String i(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return "0*0";
        }
        return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
    }

    public static long j(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1024;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static double k(Context context) {
        double dPow;
        double dPow2;
        Point point = new Point();
        if (context instanceof Activity) {
            ((Activity) context).getWindowManager().getDefaultDisplay().getRealSize(point);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (context instanceof Activity) {
            dPow = Math.pow(point.x / displayMetrics.xdpi, 2.0d);
            dPow2 = Math.pow(point.y / displayMetrics.ydpi, 2.0d);
        } else {
            dPow = Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d);
            dPow2 = Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d);
        }
        return Math.sqrt(dPow + dPow2);
    }

    public static JSONArray l(Context context) {
        JSONObject jSONObjectA;
        List<mw2> listD = lw2.d(context.getApplicationContext());
        if (listD == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (mw2 mw2Var : listD) {
            if (mw2Var != null && (jSONObjectA = mw2Var.a()) != null) {
                jSONArray.put(jSONObjectA);
            }
        }
        return jSONArray;
    }

    public static void m() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            if (new File("/proc/cpuinfo").exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));
                String strTrim = null;
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.contains("Processor")) {
                        int iIndexOf = line.indexOf(":");
                        if (iIndexOf >= 0 && iIndexOf < line.length() - 1) {
                            strTrim = line.substring(iIndexOf + 1).trim();
                        }
                        if (strTrim != null && !stringBuffer.toString().contains(strTrim)) {
                            stringBuffer.append(strTrim);
                        }
                    }
                    if (line.contains("Hardware")) {
                        try {
                            String strTrim2 = line.substring(line.indexOf(":") + 1).trim();
                            if (!TextUtils.isEmpty(strTrim2)) {
                                b = strTrim2;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                bufferedReader.close();
            }
        } catch (Throwable unused2) {
        }
        f18063a = stringBuffer.toString();
    }

    public static String n(Context context, int i) {
        if (i != 53) {
            return null;
        }
        try {
            String strP = p(context);
            if (TextUtils.isEmpty(strP)) {
                strP = f(context);
            }
            JSONObject jSONObject = new JSONObject(strP);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rom_type", (int) rv2.o(context));
            jSONObject2.put("regid", rv2.n(context));
            jSONObject.put("rom_info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("cmd", 53);
            jSONObject3.put("content", jSONObject);
            return jSONObject3.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static int o(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int i = fileInputStream.read(bArr);
            int i2 = 0;
            while (i2 < i) {
                byte b2 = bArr[i2];
                if (b2 == 10 || i2 == 0) {
                    if (b2 == 10) {
                        i2++;
                    }
                    for (int i3 = i2; i3 < i; i3++) {
                        int i4 = i3 - i2;
                        if (bArr[i3] != str.charAt(i4)) {
                            break;
                        }
                        if (i4 == str.length() - 1) {
                            return a(bArr, i3);
                        }
                    }
                }
                i2++;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String p(Context context) {
        String str;
        String str2 = (String) lg5.f(context, new zz2("cn.jpush.preferences.v2", "n_udp_report_device_info", ""));
        if (TextUtils.isEmpty(str2)) {
            str = (String) lg5.f(context, new zz2("cn.jpush.preferences.v2", "udp_report_device_info", ""));
            if (!TextUtils.isEmpty(str)) {
                q(context, str);
            }
        } else {
            str = new String(Base64.decode(str2, 2));
        }
        p63.a("JDeviceHelper", "read deviceinfo:" + str);
        return str;
    }

    public static void q(Context context, String str) {
        lg5.h(context, new zz2("cn.jpush.preferences.v2", "n_udp_report_device_info", "").a0(Base64.encodeToString(str.getBytes(), 2)));
        p63.a("JDeviceHelper", "save device info:" + str);
    }
}
