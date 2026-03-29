package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.InputStream;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.volatile, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cvolatile {
    public static String a(Context context, String str) {
        ZipFile zipFile;
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        InputStream inputStream = null;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
        } catch (Throwable unused) {
        }
        String nodeValue = (packageManager == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0)) == null) ? null : packageArchiveInfo.packageName;
        if (nodeValue != null) {
            return nodeValue;
        }
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    InputStream inputStream2 = zipFile.getInputStream(zipFile.getEntry("AndroidManifest.xml"));
                    try {
                        nodeValue = new Creturn().a(inputStream2).getChildNodes().item(0).getAttributes().getNamedItem("package").getNodeValue();
                        Auriga.a(inputStream2);
                        if (Cdefault.b() >= 19) {
                            Auriga.a(zipFile);
                        } else {
                            zipFile.close();
                        }
                    } catch (Throwable unused2) {
                        inputStream = inputStream2;
                        Auriga.a(inputStream);
                        if (Cdefault.b() >= 19) {
                            Auriga.a(zipFile);
                        } else {
                            zipFile.close();
                        }
                    }
                } catch (Throwable unused3) {
                }
            } catch (Throwable unused4) {
                zipFile = null;
            }
        } catch (Throwable unused5) {
        }
        return nodeValue;
    }
}
