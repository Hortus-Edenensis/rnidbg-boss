package com.wifi.open.sec;

import android.os.Build;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.kuaishou.weapon.p0.t;
import dalvik.system.BaseDexClassLoader;
import defpackage.rb3;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class SecInfo {
    private static String method_385() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return "0,";
            }
            for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
                if (networkInterface.isUp() && networkInterface.getInterfaceAddresses().size() != 0) {
                    String name = networkInterface.getName();
                    if (name.contains("tun") || name.contains("tap") || name.contains("ppp")) {
                        return "1,".concat(name);
                    }
                }
            }
            return "0,";
        } catch (Throwable unused) {
            return "0,";
        }
    }

    private static boolean method_386() {
        String[] strArr = {"/system/app/Superuser.apk", "/system/app/Kinguser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 11; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean method_387(String str) {
        try {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            if (method_388(systemClassLoader, str) || method_388(systemClassLoader.getParent(), str)) {
                return true;
            }
            ClassLoader classLoader = SecInfo.class.getClassLoader();
            if (!method_388(classLoader, str)) {
                if (!method_388(classLoader.getParent(), str)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean method_388(ClassLoader classLoader, String str) {
        if (classLoader == null || !(classLoader instanceof BaseDexClassLoader)) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("dalvik.system.DexPathList");
            Method method = Class.forName("dalvik.system.DexPathList$Element").getMethod("toString", null);
            Field declaredField = cls.getDeclaredField("dexElements");
            declaredField.setAccessible(true);
            Field declaredField2 = BaseDexClassLoader.class.getDeclaredField("pathList");
            declaredField2.setAccessible(true);
            Object[] objArr = (Object[]) declaredField.get(declaredField2.get(classLoader));
            for (Object obj : objArr) {
                String str2 = (String) method.invoke(obj, null);
                if (str2 != null && str2.contains(str)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static String method_389(String str, boolean z) {
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles == null) {
            return "-999";
        }
        StringBuilder sb = new StringBuilder();
        for (File file : fileArrListFiles) {
            long length = file.length();
            long jLastModified = file.lastModified();
            sb.append(file.getName());
            sb.append(length);
            if (z) {
                sb.append(jLastModified);
            }
        }
        return rb3.c(sb.toString());
    }

    public final String getTag() {
        return "sinfo";
    }

    public String ons() {
        JSONObject jSONObject = new JSONObject();
        DataUtil.AddBool(jSONObject, "plt", WKSec.c());
        DataUtil.AddBool(jSONObject, "xp", method_387("XposedBridge.jar"));
        List<String> listDataDirectories = SystemUserUtil.DataDirectories();
        if (listDataDirectories.size() > 0) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : listDataDirectories) {
                if (!z) {
                    sb.append(",");
                }
                sb.append(str);
                z = false;
            }
            DataUtil.AddString(jSONObject, "vs", sb.toString());
        }
        DataUtil.AddBool(jSONObject, "v", SystemUserUtil.DataDirectories().size() > 1);
        DataUtil.AddInt(jSONObject, t.x, SystemUserUtil.DataDirectories().size());
        String str2 = Build.TAGS;
        DataUtil.AddBool(jSONObject, t.k, (str2 != null && str2.contains("test-keys")) || method_386());
        DataUtil.AddInt(jSONObject, "hk", WKSec.a());
        DataUtil.AddString(jSONObject, "ds", method_389("/data/system", true));
        DataUtil.AddString(jSONObject, "ds2", method_389("/data/system", false));
        DataUtil.AddString(jSONObject, "vf", method_389("/vendor/firmware", true));
        DataUtil.AddString(jSONObject, "vl", method_389("/vendor/lib", true));
        DataUtil.AddString(jSONObject, "sb", method_389("/system/bin", true));
        DataUtil.AddString(jSONObject, CmcdConfiguration.KEY_STREAMING_FORMAT, method_389("/system/framework", true));
        DataUtil.AddString(jSONObject, "ne", method_385());
        return jSONObject.toString();
    }
}
