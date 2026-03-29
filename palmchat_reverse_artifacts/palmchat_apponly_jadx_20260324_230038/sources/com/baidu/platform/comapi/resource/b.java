package com.baidu.platform.comapi.resource;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.util.MD5;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f4224a = new b();
    private final SharedPreferences b = JNIInitializer.getCachedContext().getSharedPreferences("engine_resource_sp", 0);

    private b() {
    }

    private boolean b(File file, byte[] bArr) throws Throwable {
        if (file != null && file.exists() && bArr != null) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr2 = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr2);
                    if (Arrays.equals(bArr2, bArr)) {
                        a.a(fileInputStream2);
                        return false;
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    a.a(fileInputStream);
                    throw th;
                }
                fileInputStream = fileInputStream2;
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
            a.a(fileInputStream);
        }
        return true;
    }

    public synchronized void a(ResourceList resourceList) {
        File file;
        boolean zB;
        Context cachedContext = JNIInitializer.getCachedContext();
        boolean zA = false;
        byte[] bArrResVer = null;
        boolean zA2 = true;
        try {
            String strA = a();
            file = new File(strA, "/ver.dat");
            try {
                bArrResVer = resourceList.resVer();
                zB = b(file, bArrResVer);
                if (zB) {
                    try {
                        AssetManager assets = cachedContext.getAssets();
                        byte[] bArr = new byte[65536];
                        for (String str : resourceList.resList()) {
                            zA2 = a(assets, bArr, str, strA + "/" + str);
                        }
                    } catch (RuntimeException | Exception unused) {
                        zA2 = zB;
                        zB = zA2;
                    }
                }
                a(strA);
                zA = zA2;
            } catch (RuntimeException | Exception unused2) {
            }
        } catch (RuntimeException | Exception unused3) {
            file = null;
        }
        if (zB && zA) {
            zA = a(file, bArrResVer);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("initEngineRes firstInit = " + zB + "; isInitSucceed = " + zA);
        }
    }

    private String a() {
        String outputDirPath = SysOSUtil.getInstance().getOutputDirPath();
        File file = new File(outputDirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return outputDirPath;
    }

    private boolean a(AssetManager assetManager, byte[] bArr, String str, String str2) {
        InputStream inputStreamOpen = null;
        try {
            if (!TextUtils.isEmpty(str) && str.endsWith(".dir")) {
                String strSubstring = str.substring(0, str.indexOf(".dir"));
                String strSubstring2 = str2.substring(0, str2.indexOf(".dir"));
                String[] list = assetManager.list(strSubstring);
                if (list != null && list.length > 0) {
                    File file = new File(strSubstring2);
                    if (file.exists()) {
                        file.delete();
                    }
                    file.mkdirs();
                    for (String str3 : list) {
                        if (!TextUtils.isEmpty(str3)) {
                            a(assetManager, bArr, strSubstring + "/" + str3, strSubstring2 + "/" + str3);
                        }
                    }
                }
            } else {
                inputStreamOpen = assetManager.open(str);
                File file2 = new File(str2);
                File parentFile = file2.getParentFile();
                if (parentFile != null && !parentFile.isDirectory()) {
                    parentFile.mkdirs();
                }
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                a.a(inputStreamOpen, new FileOutputStream(file2), bArr);
            }
            a.a(inputStreamOpen);
            return true;
        } catch (Exception unused) {
            a.a(null);
            return false;
        } catch (Throwable th) {
            a.a(null);
            throw th;
        }
    }

    private boolean a(File file, byte[] bArr) throws Throwable {
        if (file != null && bArr != null) {
            FileOutputStream fileOutputStream = null;
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    a.a(fileOutputStream2);
                    return true;
                } catch (Exception unused) {
                    fileOutputStream = fileOutputStream2;
                    a.a(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    a.a(fileOutputStream);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return false;
    }

    private void a(String str) {
        if (this.b == null) {
            return;
        }
        File file = new File(str, "shader/");
        String mD5String = MD5.getMD5String(Build.FINGERPRINT);
        if (!file.exists()) {
            this.b.edit().putString(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, mD5String).commit();
            return;
        }
        String string = this.b.getString(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, "");
        if (TextUtils.isEmpty(string) || !(string.equals(mD5String) || MD5.getMD5String(string).equals(mD5String))) {
            a(file);
            if (file.exists()) {
                return;
            }
            this.b.edit().putString(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, mD5String).commit();
        }
    }

    private static void a(File file) {
        if (file == null) {
            return;
        }
        if (!file.isFile() && (!file.exists() || file.list() == null || file.list().length != 0)) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (int i = 0; i < fileArrListFiles.length; i++) {
                    a(fileArrListFiles[i]);
                    fileArrListFiles[i].delete();
                }
            }
            if (file.exists()) {
                file.delete();
                return;
            }
            return;
        }
        file.delete();
    }
}
