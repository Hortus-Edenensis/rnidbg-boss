package com.ss.android.socialbase.appdownloader.iz.u;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.az;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn {
    private static PackageInfo nr(@NonNull Context context, @NonNull File file, int i) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            u("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i);
        } catch (Throwable th) {
            u("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    private static String u(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
    
        r13 = r1.getInputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
    
        r4 = r1;
        r5 = r2;
        r1 = null;
        r13 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PackageInfo u(@NonNull File file) {
        ?? r1;
        ?? r2;
        ?? r4;
        Enumeration<? extends ZipEntry> enumerationEntries;
        ZipEntry zipEntryNextElement;
        InputStream inputStream;
        ZipFile zipFile;
        ZipEntry zipEntry;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        InputStream inputStream2;
        ZipFile zipFile2;
        ?? r12;
        int iNr;
        long j;
        u uVar = null;
        uVar = null;
        String strU = null;
        uVar = null;
        uVar = null;
        try {
            if (Build.VERSION.SDK_INT < 24) {
                ZipFile zipFile3 = new ZipFile(file);
                try {
                    enumerationEntries = zipFile3.entries();
                    zipEntryNextElement = null;
                } catch (Throwable th) {
                    th = th;
                    r2 = 0;
                    r4 = zipFile3;
                    r1 = 0;
                }
                while (true) {
                    if (!enumerationEntries.hasMoreElements()) {
                        inputStream = null;
                        zipFile = zipFile3;
                        zipEntry = zipEntryNextElement;
                        fileInputStream = null;
                        break;
                    }
                    zipEntryNextElement = enumerationEntries.nextElement();
                    if (!zipEntryNextElement.isDirectory() && "AndroidManifest.xml".equals(zipEntryNextElement.getName())) {
                        break;
                    }
                }
                fileInputStream2 = fileInputStream;
                r12 = fileInputStream;
                zipFile2 = zipFile;
                inputStream2 = inputStream;
                if (zipEntry != null) {
                }
                throw new fx("没有找到AndroidManifest.xml entry");
            }
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                ZipInputStream zipInputStream = new ZipInputStream(fileInputStream3);
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        zipFile2 = null;
                        zipEntry = nextEntry;
                        fileInputStream2 = fileInputStream3;
                        r12 = zipInputStream;
                        inputStream2 = null;
                        break;
                    }
                    if (!nextEntry.isDirectory()) {
                        if ("AndroidManifest.xml".equals(nextEntry.getName())) {
                            zipFile2 = null;
                            zipEntry = nextEntry;
                            fileInputStream2 = fileInputStream3;
                            r12 = zipInputStream;
                            inputStream2 = zipInputStream;
                            break;
                        }
                        zipInputStream.closeEntry();
                    } else {
                        try {
                            zipInputStream.closeEntry();
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (zipEntry != null) {
                    try {
                        if ("AndroidManifest.xml".equals(zipEntry.getName())) {
                            u uVar2 = new u();
                            try {
                                uVar2.u(inputStream2);
                                do {
                                    iNr = uVar2.nr();
                                    if (iNr == 1) {
                                        throw new fx("已达到END_DOCUMENT");
                                    }
                                } while (iNr != 2);
                                int iPn = uVar2.pn();
                                String strU2 = null;
                                String strU3 = null;
                                for (int i = 0; i != iPn; i++) {
                                    if ("versionName".equals(uVar2.u(i))) {
                                        strU2 = u(uVar2, i);
                                    } else if (az.aW.equals(uVar2.u(i))) {
                                        strU = u(uVar2, i);
                                    } else if ("package".equals(uVar2.u(i))) {
                                        strU3 = u(uVar2, i);
                                    }
                                }
                                try {
                                    j = Long.parseLong(strU);
                                } catch (fx unused2) {
                                    j = -1;
                                }
                                if (j == -1) {
                                    throw new fx("versionCode获取失败: ".concat(String.valueOf(strU)));
                                }
                                PackageInfo packageInfo = new PackageInfo();
                                packageInfo.versionName = strU2;
                                packageInfo.versionCode = (int) j;
                                packageInfo.packageName = strU3;
                                if (r12 != 0) {
                                    try {
                                        r12.closeEntry();
                                    } catch (Throwable unused3) {
                                    }
                                }
                                try {
                                    uVar2.u();
                                } catch (Throwable unused4) {
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable unused5) {
                                    }
                                }
                                if (zipFile2 != null) {
                                    try {
                                        zipFile2.close();
                                    } catch (Throwable unused6) {
                                    }
                                }
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (Throwable unused7) {
                                    }
                                }
                                return packageInfo;
                            } catch (Throwable th2) {
                                r1 = inputStream2;
                                th = th2;
                                uVar = uVar2;
                                r2 = fileInputStream2;
                                r4 = zipFile2;
                            }
                        }
                    } catch (Throwable th3) {
                        r1 = inputStream2;
                        th = th3;
                        r2 = fileInputStream2;
                        r4 = zipFile2;
                    }
                }
                throw new fx("没有找到AndroidManifest.xml entry");
            } catch (Throwable th4) {
                th = th4;
                r4 = 0;
                r2 = fileInputStream3;
                r1 = 0;
            }
        } catch (Throwable th5) {
            th = th5;
            r1 = uVar;
            r2 = r1;
            r4 = r2;
        }
        try {
            throw new fx("throwable: " + th.getMessage() + th.toString());
        } finally {
        }
    }

    public static PackageInfo u(@NonNull Context context, @NonNull File file, int i) {
        if (com.ss.android.socialbase.downloader.jk.u.u(268435456) && Build.VERSION.SDK_INT < 26) {
            try {
                return u(file);
            } catch (Throwable th) {
                u("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
            }
        }
        return nr(context, file, i);
    }

    private static void u(@NonNull String str, @NonNull String str2) {
        if (com.ss.android.socialbase.downloader.downloader.fx.x() == null) {
            return;
        }
        try {
            new JSONObject().put("message", str2);
        } catch (JSONException unused) {
        }
    }

    private static String u(u uVar, int i) {
        int iNr = uVar.nr(i);
        int iFx = uVar.fx(i);
        if (iNr == 3) {
            return uVar.b(i);
        }
        return iNr == 2 ? String.format("?%s%08X", u(iFx), Integer.valueOf(iFx)) : (iNr < 16 || iNr > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(iFx), Integer.valueOf(iNr)) : String.valueOf(iFx);
    }

    public static String u(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e) {
            u("getPackageInfo::fail_load_label", e.getMessage());
            return null;
        }
    }
}
