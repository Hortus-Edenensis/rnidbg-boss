package com.bytedance.pangle.n;

import android.content.pm.Signature;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static final AtomicReference<byte[]> u = new AtomicReference<>();

    public static k u(String str, boolean z) throws Throwable {
        JarFile jarFile;
        JarFile jarFile2 = null;
        try {
            try {
                jarFile = new JarFile(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (RuntimeException e2) {
            e = e2;
        } catch (GeneralSecurityException e3) {
            e = e3;
        }
        try {
            ArrayList<JarEntry> arrayList = new ArrayList();
            JarEntry jarEntry = jarFile.getJarEntry("AndroidManifest.xml");
            if (jarEntry == null) {
                throw new o(1, "Package " + str + " has no manifest");
            }
            Certificate[][] certificateArrU = u(jarFile, jarEntry);
            if (com.bytedance.pangle.util.b.u(certificateArrU)) {
                throw new o(4, "Package " + str + " has no certificates at entry AndroidManifest.xml");
            }
            Signature[] signatureArrU = b.u(certificateArrU);
            if (z) {
                Enumeration<JarEntry> enumerationEntries = jarFile.entries();
                while (enumerationEntries.hasMoreElements()) {
                    JarEntry jarEntryNextElement = enumerationEntries.nextElement();
                    if (!jarEntryNextElement.isDirectory()) {
                        String name = jarEntryNextElement.getName();
                        if (!name.startsWith("META-INF/") && !name.equals("AndroidManifest.xml")) {
                            arrayList.add(jarEntryNextElement);
                        }
                    }
                }
                for (JarEntry jarEntry2 : arrayList) {
                    Certificate[][] certificateArrU2 = u(jarFile, jarEntry2);
                    if (com.bytedance.pangle.util.b.u(certificateArrU2)) {
                        throw new o(4, "Package " + str + " has no certificates at entry " + jarEntry2.getName());
                    }
                    if (!k.u(signatureArrU, b.u(certificateArrU2))) {
                        throw new o(3, "Package " + str + " has mismatched certificates at entry " + jarEntry2.getName());
                    }
                }
            }
            k kVar = new k(signatureArrU, 1, null, null, null);
            try {
                jarFile.close();
            } catch (Exception unused) {
            }
            return kVar;
        } catch (IOException e4) {
            e = e4;
            throw new o(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
        } catch (RuntimeException e5) {
            e = e5;
            throw new o(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
        } catch (GeneralSecurityException e6) {
            e = e6;
            throw new o(2, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
        } catch (Throwable th2) {
            th = th2;
            jarFile2 = jarFile;
            if (jarFile2 != null) {
                try {
                    jarFile2.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private static Certificate[][] u(JarFile jarFile, JarEntry jarEntry) throws o {
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStream2 = jarFile.getInputStream(jarEntry);
                u(inputStream2);
                Certificate[][] certificateArr = {jarEntry.getCertificates()};
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused) {
                    }
                }
                return certificateArr;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | RuntimeException e3) {
            throw new o(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e3);
        }
    }

    private static void u(InputStream inputStream) throws IOException {
        byte[] andSet = u.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (inputStream.read(andSet, 0, andSet.length) != -1) {
        }
        u.set(andSet);
    }
}
