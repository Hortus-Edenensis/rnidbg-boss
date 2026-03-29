package com.wifi.gdt.ad;

import android.os.Environment;
import com.wifi.ad.core.utils.WifiLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class CsjDeclaredUtils {
    private static boolean done = false;

    public static void copyDemo() {
        if (done) {
            return;
        }
        done = true;
        String str = getSDPath() + "/gdt.jar";
        WifiLog.d("copyDemo newPath " + str);
        try {
            boolean zExists = new File("data/user/0/com.zenmen.palmchat/app_e_qq_com_plugin_36308dbb9d2423ba2dacc5122047b28f/gdt_plugin.jar").exists();
            WifiLog.d("copyDemo oldFileEx " + zExists);
            if (!zExists) {
                return;
            }
            FileInputStream fileInputStream = new FileInputStream("data/user/0/com.zenmen.palmchat/app_e_qq_com_plugin_36308dbb9d2423ba2dacc5122047b28f/gdt_plugin.jar");
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    WifiLog.d("copyDemo 拷贝成功 ");
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            WifiLog.d("copyDemo 拷贝失败  " + e.toString());
        }
    }

    private static String getSDPath() {
        return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null).toString();
    }

    public static Object getTemplateInfo(Object obj) {
        WifiLog.d("getTemplateInfo bgView " + obj);
        Object objInvoke = null;
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod("getTemplateInfo", null);
            declaredMethod.setAccessible(true);
            Object objInvoke2 = declaredMethod.invoke(obj, null);
            try {
                WifiLog.d("getTemplateInfo setState1 res " + objInvoke2);
                if (objInvoke2 != null) {
                    return objInvoke2;
                }
                Method declaredMethod2 = obj.getClass().getSuperclass().getDeclaredMethod("getTemplateInfo", null);
                declaredMethod2.setAccessible(true);
                objInvoke = declaredMethod2.invoke(obj, null);
                WifiLog.d("getTemplateInfo setState2 res " + objInvoke);
            } catch (Throwable th) {
                th = th;
                objInvoke = objInvoke2;
                WifiLog.d("getTemplateInfo Throwable e " + th.toString());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return objInvoke;
    }
}
