package com.bytedance.sdk.openadsdk.gi;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.kwad.sdk.collector.AppStatusRules;
import com.oplus.tblplayer.Constants;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private static boolean fx = u().exists();
    private static Method nr;
    private static Boolean u;

    private static boolean nr(String str) {
        try {
            if (nr == null) {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class);
                nr = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            BaseDexClassLoader baseDexClassLoader = (BaseDexClassLoader) iz.class.getClassLoader();
            if (nr != null && baseDexClassLoader != null) {
                String strFindLibrary = baseDexClassLoader.findLibrary(str);
                synchronized (iz.class) {
                    nr.invoke(null, strFindLibrary, baseDexClassLoader);
                }
                return true;
            }
        } catch (Throwable th) {
            fx = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(Constants.LIBRARY_PREFIX, str);
                jSONObject.putOpt("msg", "lock load failed!");
            } catch (JSONException unused) {
            }
            s.u().u("so_load_fail", jSONObject, th);
        }
        return false;
    }

    public static File u() {
        return new File(com.bytedance.sdk.openadsdk.api.plugin.nr.u(dw.getContext()), ".csj_so");
    }

    public static void u(String str) {
        try {
            if (fx && nr(str)) {
                return;
            }
            System.loadLibrary(str);
        } catch (Throwable th) {
            u(str, th);
        }
    }

    private static boolean u(String str, Throwable th) {
        String strIz = d.iz();
        String str2 = Constants.LIBRARY_PREFIX + str + Constants.LIBRARY_SUFFIX;
        File file = new File(strIz, "/lib/".concat(String.valueOf(str2)));
        if (file.exists() && file.length() > 0) {
            return u(str, file.getAbsolutePath());
        }
        File file2 = new File(strIz, "apk/base-1.apk");
        if (file2.exists() && file2.length() > 0) {
            u(file2, file, str2);
            File file3 = new File(strIz, "/lib/".concat(String.valueOf(str2)));
            if (file3.exists() && file3.length() > 0) {
                try {
                    System.loadLibrary(str);
                    return true;
                } catch (Throwable unused) {
                    return u(str, file3.getAbsolutePath());
                }
            }
            u(str, str2 + " unzip failed !", th);
            return false;
        }
        u(str, "load so filed! apk not exist! ", th);
        return false;
    }

    public static boolean nr() {
        Boolean bool = u;
        if (bool != null) {
            return bool.booleanValue();
        }
        u = Boolean.FALSE;
        try {
            Context context = dw.getContext();
            if ((context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).applicationInfo.flags & 1) != 0) {
                u = Boolean.TRUE;
            }
        } catch (Exception unused) {
        }
        return u.booleanValue();
    }

    private static boolean u(String str, String str2) {
        try {
            System.load(str2);
            return true;
        } catch (Throwable th) {
            new File(str2).delete();
            u(str, "load so " + str + " filed! ", th);
            throw th;
        }
    }

    private static void u(File file, File file2, String str) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        try {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = zipFile.getEntry("lib/" + com.bytedance.sdk.openadsdk.core.ja.nr.nr.u() + "/" + str);
            if (entry == null) {
                entry = zipFile.getEntry("lib/armeabi/".concat(String.valueOf(str)));
            }
            if (entry == null) {
                return;
            }
            file2.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(entry));
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        try {
                            byte[] bArr = new byte[AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE];
                            while (true) {
                                int i = bufferedInputStream.read(bArr);
                                if (i != -1) {
                                    bufferedOutputStream.write(bArr, 0, i);
                                } else {
                                    com.bytedance.sdk.component.iz.fx.fx.nr.u(bufferedInputStream);
                                    com.bytedance.sdk.component.iz.fx.fx.nr.u(bufferedOutputStream);
                                    com.bytedance.sdk.component.iz.fx.fx.nr.u(fileOutputStream);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            com.bytedance.sdk.component.iz.fx.fx.nr.u(bufferedInputStream);
                            com.bytedance.sdk.component.iz.fx.fx.nr.u(bufferedOutputStream);
                            com.bytedance.sdk.component.iz.fx.fx.nr.u(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = null;
                    }
                } catch (Throwable th4) {
                    bufferedInputStream = null;
                    th = th4;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th5) {
                bufferedInputStream = null;
                fileOutputStream = null;
                th = th5;
                bufferedOutputStream = null;
            }
        } catch (Throwable unused) {
        }
    }

    private static void u(String str, String str2, Throwable th) {
        if ("maparmor".equals(str)) {
            bg.u = false;
        }
        if (nr()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(Constants.LIBRARY_PREFIX, str);
            jSONObject.putOpt("msg", str2);
        } catch (JSONException unused) {
        }
        s.u().u("so_load_fail", jSONObject, th);
    }
}
