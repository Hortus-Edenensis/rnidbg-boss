package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.oplus.tblplayer.Constants;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6615a = "_multiKitLoadNative";
    private static final String b = "com.huawei.hms.runtimekit.container.kitsdk.KitContext";
    private static ThreadPoolExecutor c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());

    private static String a(Context context) throws IOException {
        if (Build.VERSION.SDK_INT >= 24) {
            context = context.createDeviceProtectedStorageContext();
        }
        return context.getFilesDir().getCanonicalPath() + File.separator + "modules";
    }

    private static String b(Context context, String str, String str2, PackageInfo packageInfo) throws Throwable {
        String string;
        String str3;
        String strSubstring;
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            try {
                StringBuilder sb = new StringBuilder();
                if (Build.VERSION.SDK_INT >= 24) {
                    context = context.createDeviceProtectedStorageContext();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(context.getFilesDir().getCanonicalPath());
                str3 = File.separator;
                sb2.append(str3);
                sb2.append("modules");
                sb.append(sb2.toString());
                sb.append(str3);
                sb.append(packageInfo.packageName);
                string = sb.toString();
                try {
                    strSubstring = str2.substring(str2.lastIndexOf(str3) + 1);
                    zipFile = new ZipFile(str);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                HashSet hashSet = new HashSet();
                ac.a(enumerationEntries, hashSet, strSubstring);
                if (hashSet.size() <= 0) {
                    af.b(f6615a, "native is empty");
                    a(zipFile, string, packageInfo, true);
                    return str2;
                }
                String str4 = string + str3 + packageInfo.versionCode + str3 + Constants.LIBRARY_PREFIX + str3 + strSubstring;
                if (new File(str4).exists() || ac.a(zipFile, hashSet, str4) == 0) {
                    a(zipFile, string, packageInfo, true);
                    return str4;
                }
                af.b(f6615a, "the apk decompress fail");
                a(zipFile, string, packageInfo, false);
                return str2;
            } catch (Exception unused2) {
                zipFile2 = zipFile;
                af.c(f6615a, "catch IOException");
                a(zipFile2, string, packageInfo, true);
                return str2;
            } catch (Throwable th2) {
                th = th2;
                zipFile2 = zipFile;
                a(zipFile2, string, packageInfo, true);
                throw th;
            }
        } catch (Exception unused3) {
            string = null;
        } catch (Throwable th3) {
            th = th3;
            string = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(File file) {
        return file.exists() && file.isDirectory() && file.listFiles() != null && file.listFiles().length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(File file) {
        boolean z;
        boolean z2 = false;
        if (c(file)) {
            z = true;
            for (File file2 : file.listFiles()) {
                z = z && d(file2);
            }
        } else {
            z = true;
        }
        if (!z) {
            return z;
        }
        if (z && file.delete()) {
            z2 = true;
        }
        return z2;
    }

    public static String a(Context context, String str, String str2, PackageInfo packageInfo) {
        af.b(f6615a, " generaNewNativePath");
        if (!b(context)) {
            return str2;
        }
        if (!TextUtils.isEmpty(str2) && str2.contains(File.separator)) {
            return b(context, str, str2, packageInfo);
        }
        af.b(f6615a, "nativePath is empty or error");
        return str2;
    }

    private static boolean b(Context context) {
        try {
            return context.getClassLoader().loadClass(b) != null;
        } catch (ClassNotFoundException unused) {
            af.b(f6615a, "The cp is not hms kit.");
            return false;
        }
    }

    private static void a(final String str, final int i, final boolean z) {
        c.execute(new Runnable() { // from class: com.huawei.hms.ads.uiengineloader.ag.1
            @Override // java.lang.Runnable
            public final void run() {
                File file = new File(str);
                String string = Integer.toString(i);
                if (ag.c(file)) {
                    for (File file2 : file.listFiles()) {
                        if (!z || !file2.getPath().contains(string)) {
                            StringBuilder sb = ag.d(file2) ? new StringBuilder(" delete success : ") : new StringBuilder(" delete failed : ");
                            sb.append(file2.getName());
                            af.b(ag.f6615a, sb.toString());
                        }
                    }
                }
            }
        });
    }

    private static void a(ZipFile zipFile, String str, PackageInfo packageInfo, boolean z) {
        int i;
        aj.a(zipFile);
        try {
            if (TextUtils.isEmpty(str) || (i = packageInfo.versionCode) <= 0) {
                return;
            }
            a(str, i, z);
        } catch (Exception unused) {
            af.c(f6615a, "IOException:");
        }
    }
}
