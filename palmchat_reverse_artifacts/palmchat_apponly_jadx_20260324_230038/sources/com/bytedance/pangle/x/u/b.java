package com.bytedance.pangle.x.u;

import android.content.pm.PackageInfo;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.x;
import com.huawei.openalliance.ad.constant.az;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static String u(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    public static pn u(File file) {
        ZipFile zipFile;
        u uVar;
        PackageInfo packageArchiveInfo;
        int iNr;
        int i;
        try {
            if (!file.exists()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                x.u((ZipFile) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    x.u(zipFile2);
                    return null;
                }
                uVar = new u();
                try {
                    uVar.u(zipFile2.getInputStream(entry));
                    do {
                        iNr = uVar.nr();
                        if (iNr == 1) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                uVar.u();
                            } catch (Throwable unused) {
                            }
                            x.u(zipFile2);
                            return null;
                        }
                    } while (iNr != 2);
                    int iFx = uVar.fx();
                    String strU = null;
                    String strU2 = null;
                    for (int i2 = 0; i2 != iFx; i2++) {
                        if (az.aW.equals(uVar.u(i2))) {
                            strU = u(uVar, i2);
                        } else if ("package".equals(uVar.u(i2))) {
                            strU2 = u(uVar, i2);
                        }
                    }
                    try {
                        i = Integer.parseInt(strU);
                    } catch (Throwable unused2) {
                        i = -1;
                    }
                    if (i == -1) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(strU)));
                        try {
                            uVar.u();
                        } catch (Throwable unused3) {
                        }
                        x.u(zipFile2);
                        return null;
                    }
                    pn pnVar = new pn(strU2, i);
                    try {
                        uVar.u();
                    } catch (Throwable unused4) {
                    }
                    x.u(zipFile2);
                    return pnVar;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    zipFile = zipFile2;
                    th = th2;
                    try {
                        packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                    } catch (Throwable unused5) {
                        packageArchiveInfo = null;
                    }
                    try {
                        if (packageArchiveInfo == null) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                            return null;
                        }
                        pn pnVar2 = new pn(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (uVar != null) {
                            try {
                                uVar.u();
                            } catch (Throwable unused6) {
                            }
                        }
                        x.u(zipFile);
                        return pnVar2;
                    } finally {
                        if (uVar != null) {
                            try {
                                uVar.u();
                            } catch (Throwable unused7) {
                            }
                        }
                        x.u(zipFile);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                uVar = null;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
            uVar = null;
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
}
