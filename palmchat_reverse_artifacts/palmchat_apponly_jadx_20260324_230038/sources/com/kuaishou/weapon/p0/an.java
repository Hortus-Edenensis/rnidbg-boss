package com.kuaishou.weapon.p0;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Camera;
import android.location.Location;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.cdo.oaps.ad.Launcher;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import com.tide.protocol.util.TdFileUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7393a = "de.robv.android.xposed.XposedHelpers";
    public static final String b = "de.robv.android.xposed.XposedBridge";
    public static final String c = "com.elderdrivers.riru.edxp.config.EdXpConfigGlobal";

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:45|3)|(7:43|4|(2:6|(4:49|10|52|50)(2:51|50))(1:47)|41|21|33|(1:35)(1:36))|11|(4:14|(3:55|16|59)(3:53|17|(3:54|19|58)(1:57))|56|12)|41|21|33|(0)(0)|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0098 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Set<String> a() throws Throwable {
        BufferedReader bufferedReader;
        HashSet<String> hashSet;
        HashSet hashSet2 = new HashSet();
        BufferedReader bufferedReader2 = null;
        try {
            hashSet = new HashSet();
            bufferedReader = new BufferedReader(new FileReader(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH + Process.myPid() + "/maps"));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.endsWith(Constants.LIBRARY_SUFFIX) || line.endsWith(TdFileUtils.PLUGIN_FILE_TAIL)) {
                    hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                }
            } catch (Exception unused2) {
                if (bufferedReader != null) {
                }
                if (hashSet2.size() > 0) {
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
            bufferedReader.close();
            if (hashSet2.size() > 0) {
                return hashSet2;
            }
            return null;
        }
        bufferedReader.close();
        for (String str : hashSet) {
            if (str.contains("com.saurik.substrate")) {
                hashSet2.add(str);
            } else if (str.contains("XposedBridge.jar")) {
                hashSet2.add(str);
            }
        }
        bufferedReader.close();
        if (hashSet2.size() > 0) {
        }
    }

    public Set<String> b() {
        Set setKeySet;
        try {
            Class<?> clsLoadClass = ClassLoader.getSystemClassLoader().loadClass(b);
            if (clsLoadClass == null) {
                return null;
            }
            Field declaredField = clsLoadClass.getDeclaredField("sHookedMethodCallbacks");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(clsLoadClass);
            if (map == null || (setKeySet = map.keySet()) == null || setKeySet.size() <= 0) {
                return null;
            }
            return a(setKeySet);
        } catch (Exception unused) {
            return null;
        }
    }

    public Set<String> c() {
        Set setKeySet;
        try {
            Class<?> clsLoadClass = ClassLoader.getSystemClassLoader().loadClass(f7393a);
            if (clsLoadClass == null) {
                return null;
            }
            Field declaredField = clsLoadClass.getDeclaredField("methodCache");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(clsLoadClass);
            if (map == null || (setKeySet = map.keySet()) == null || setKeySet.size() <= 0) {
                return null;
            }
            return a(setKeySet);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", a(TelephonyManager.class, "getDeviceId", new Class[0]) ? 1 : 0);
            jSONObject.put("1", a(TelephonyManager.class, "getSubscriberId", new Class[0]) ? 1 : 0);
            jSONObject.put("2", a(TelephonyManager.class, "getSimSerialNumber", new Class[0]) ? 1 : 0);
            jSONObject.put("3", a(Location.class, "getLatitude", new Class[0]) ? 1 : 0);
            jSONObject.put("4", a(Location.class, "getLongitude", new Class[0]) ? 1 : 0);
            if (Build.VERSION.SDK_INT >= 26) {
                jSONObject.put("5", a(Build.class, "getSerial", new Class[0]) ? 1 : 0);
            } else {
                jSONObject.put("5", 0);
            }
            jSONObject.put("6", a(WifiInfo.class, "getMacAddress", new Class[0]) ? 1 : 0);
            jSONObject.put("7", a(WifiInfo.class, "getBSSID", new Class[0]) ? 1 : 0);
            jSONObject.put("8", a(WifiInfo.class, "getRssi", new Class[0]) ? 1 : 0);
            jSONObject.put("9", a(Class.class, "forName", String.class) ? 1 : 0);
            jSONObject.put("10", a(ActivityManager.class, "getRunningServices", Integer.TYPE) ? 1 : 0);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject e() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i = 1;
            boolean zA = a(MediaRecorder.class, "setOutputFile", String.class);
            if (zA) {
                jSONObject.put("0", zA ? 1 : 0);
            }
            boolean zA2 = a(Camera.class, "takePicture", Camera.ShutterCallback.class, Camera.PictureCallback.class, Camera.PictureCallback.class);
            if (zA2) {
                jSONObject.put("1", zA2 ? 1 : 0);
            }
            boolean zA3 = a(MediaPlayer.class, "setDataSource", Context.class, Uri.class);
            if (zA3) {
                if (!zA3) {
                    i = 0;
                }
                jSONObject.put("2", i);
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject f() {
        JSONObject jSONObject;
        boolean zA;
        boolean zA2;
        try {
            jSONObject = new JSONObject();
            zA = a(Cipher.class, "doFinal", byte[].class);
            jSONObject.put("0", zA ? 1 : 0);
            boolean zA3 = a(SecureRandom.class, "setSeed", byte[].class);
            jSONObject.put("1", zA3 ? 1 : 0);
            if (zA3) {
                zA = true;
            }
            boolean zA4 = a(MessageDigest.class, "update", byte[].class);
            jSONObject.put("2", zA4 ? 1 : 0);
            if (zA4) {
                zA = true;
            }
            boolean zA5 = a(MessageDigest.class, "getInstance", String.class);
            jSONObject.put("3", zA5 ? 1 : 0);
            if (zA5) {
                zA = true;
            }
            boolean zA6 = a(Uri.class, "parse", String.class);
            jSONObject.put("4", zA6 ? 1 : 0);
            if (zA6) {
                zA = true;
            }
            boolean zA7 = a(SQLiteDatabase.class, "execSQL", String.class);
            jSONObject.put("5", zA7 ? 1 : 0);
            if (zA7) {
                zA = true;
            }
            zA2 = a(Activity.class, "finish", new Class[0]);
            jSONObject.put("6", zA2 ? 1 : 0);
        } catch (Exception unused) {
        }
        if (zA2 ? true : zA) {
            return jSONObject;
        }
        return null;
    }

    public JSONObject g() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            boolean zA = a(JSONObject.class, "toString", new Class[0]);
            if (zA) {
                jSONObject.put("0", zA ? 1 : 0);
            }
            boolean zA2 = a(TextUtils.class, "isEmpty", CharSequence.class);
            if (zA2) {
                jSONObject.put("1", zA2 ? 1 : 0);
            }
            boolean zA3 = a(JSONArray.class, "toString", new Class[0]);
            if (zA3) {
                jSONObject.put("2", zA3 ? 1 : 0);
            }
            boolean zA4 = a(Cipher.class, "doFinal", byte[].class);
            if (zA4) {
                jSONObject.put("3", zA4 ? 1 : 0);
            }
            boolean zA5 = a(ByteArrayOutputStream.class, "toByteArray", new Class[0]);
            if (zA5) {
                jSONObject.put("4", zA5 ? 1 : 0);
            }
            boolean zA6 = a(FileOutputStream.class, "write", byte[].class);
            if (zA6) {
                jSONObject.put("5", zA6 ? 1 : 0);
            }
            boolean zA7 = a(HttpURLConnection.class, "setRequestProperty", String.class, String.class);
            if (zA7) {
                jSONObject.put("6", zA7 ? 1 : 0);
            }
        } catch (Exception unused) {
        }
        if (jSONObject.length() > 0) {
            return jSONObject;
        }
        return null;
    }

    public JSONObject b(Set set) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (ClassLoader.getSystemClassLoader() != null && set.size() > 0) {
                int i = 1;
                jSONObject.put("0", a(Class.class, "forName", set) ? 1 : 0);
                jSONObject.put("1", a(ClassLoader.class, "loadClass", set) ? 1 : 0);
                jSONObject.put("2", a(Throwable.class, "getStackTrace", set) ? 1 : 0);
                jSONObject.put("3", a(PackageManager.class, c.b("Z2V0SW5zdGFsbGVkUGFja2FnZXM=", 2), set) ? 1 : 0);
                jSONObject.put("4", a(PackageManager.class, c.b("Z2V0SW5zdGFsbGVkQXBwbGljYXRpb25z", 2), set) ? 1 : 0);
                jSONObject.put("5", a(ActivityManager.class, "getRunningServices", set) ? 1 : 0);
                if (!a(JSONObject.class, "toString", set)) {
                    i = 0;
                }
                jSONObject.put("6", i);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public Set a(Set set) {
        HashSet hashSet = new HashSet();
        for (Object obj : set) {
            if (obj instanceof String) {
                if (obj != null) {
                    String str = (String) obj;
                    if (str.startsWith("android.app.ResourcesManager#") || str.startsWith("android.view.LayoutInflater#")) {
                    }
                }
                hashSet.add(obj);
            } else if (obj instanceof Method) {
                hashSet.add(((Method) obj).getName());
            }
        }
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(Context context, int i, Set set) {
        boolean zA;
        try {
            if (ClassLoader.getSystemClassLoader() != null) {
                switch (i) {
                    case 13:
                        zA = a(context, "getDeviceId", set);
                        break;
                    case 14:
                        zA = a(context, "getSubscriberId", set);
                        break;
                    case 15:
                        zA = a(context, "getSimSerialNumber", set);
                        break;
                    case 16:
                        zA = a(Settings.Secure.class, "getString", set);
                        break;
                    case 17:
                        zA = a(StringBuilder.class, "toString", set);
                        break;
                    case 18:
                        zA = a(Method.class, Launcher.Method.INVOKE_CALLBACK, set);
                        break;
                    case 19:
                        zA = a(WifiInfo.class, "getMacAddress", set);
                        break;
                    case 20:
                        zA = a(WifiInfo.class, "getSSID", set);
                        break;
                    case 21:
                        zA = a(WifiInfo.class, "getBSSID", set);
                        break;
                    default:
                        zA = false;
                        break;
                }
                if (zA) {
                    return 1;
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private boolean a(Class cls, String str, Set set) {
        if (str != null) {
            try {
                if (set.size() > 0 && set.toString().contains(str)) {
                    if (set.toString().contains(cls.getName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean a(Context context, String str, Set set) {
        TelephonyManager telephonyManager;
        try {
            if (set.size() > 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                return a(telephonyManager.getClass(), str, set);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a(Class cls, String str, Class<?>... clsArr) {
        try {
            return a(bh.a((Class<?>) cls, str, clsArr));
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean a(Method method) {
        return method != null && Modifier.isNative(method.getModifiers());
    }
}
