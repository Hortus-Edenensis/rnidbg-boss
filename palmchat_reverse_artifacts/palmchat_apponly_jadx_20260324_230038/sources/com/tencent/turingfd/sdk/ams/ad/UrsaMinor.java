package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class UrsaMinor {
    public static String a(Context context, String str) {
        ByteArrayInputStream byteArrayInputStream;
        String strA;
        try {
            PackageManager packageManager = context.getPackageManager();
            byteArrayInputStream = new ByteArrayInputStream(packageManager.getPackageInfo(packageManager.getPackagesForUid(context.getPackageManager().getApplicationInfo(str, 0).uid)[0], 64).signatures[0].toByteArray());
            try {
                strA = Norma.a(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream)).getEncoded());
            } catch (Throwable unused) {
                strA = "";
                if (byteArrayInputStream != null) {
                }
                return strA;
            }
        } catch (Throwable unused2) {
            byteArrayInputStream = null;
        }
        try {
            byteArrayInputStream.close();
        } catch (Throwable unused3) {
        }
        return strA;
    }

    public static List<String> a(File file) throws IOException {
        ArrayList arrayList = new ArrayList();
        JarFile jarFile = new JarFile(file);
        try {
            Certificate[] certificateArrA = a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), new byte[8192]);
            if (certificateArrA != null) {
                for (Certificate certificate : certificateArrA) {
                    arrayList.add(Norma.a(certificate.getEncoded()));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            jarFile.close();
            throw th;
        }
        jarFile.close();
        return arrayList;
    }

    public static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) throws Throwable {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = jarFile.getInputStream(jarEntry);
            do {
                try {
                } catch (IOException unused) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } while (inputStream.read(bArr, 0, bArr.length) != -1);
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
            try {
                inputStream.close();
            } catch (IOException unused4) {
            }
            return certificates;
        } catch (IOException unused5) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
