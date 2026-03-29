package com.bytedance.pangle.n;

import android.content.pm.Signature;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.n.fx;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(api = 21)
public class b {
    public static k u(String str, int i) throws Throwable {
        RandomAccessFile randomAccessFile;
        int[] iArr;
        if (i > 3) {
            throw new o(4, "No signature found in package of version " + i + " or newer for package " + str);
        }
        RandomAccessFile randomAccessFile2 = null;
        Signature[] signatureArr = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, com.kuaishou.weapon.p0.t.k);
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    iz.u(str, randomAccessFile, -262969152, 1896449818);
                    try {
                        fx.C0195fx c0195fxU = fx.u(randomAccessFile, str);
                        Signature[] signatureArrU = u(new Certificate[][]{c0195fxU.u});
                        fx.nr nrVar = c0195fxU.nr;
                        if (nrVar != null) {
                            int size = nrVar.u.size();
                            Signature[] signatureArr2 = new Signature[size];
                            iArr = new int[c0195fxU.nr.nr.size()];
                            for (int i2 = 0; i2 < size; i2++) {
                                signatureArr2[i2] = new Signature(c0195fxU.nr.u.get(i2).getEncoded());
                                iArr[i2] = c0195fxU.nr.nr.get(i2).intValue();
                            }
                            signatureArr = signatureArr2;
                        } else {
                            iArr = null;
                        }
                        k kVar = new k(signatureArrU, 3, signatureArr, iArr);
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused) {
                        }
                        return kVar;
                    } catch (s e) {
                        if (i >= 3) {
                            throw new o(4, "No APK Signature Scheme v3 signature in package ".concat(String.valueOf(str)), e);
                        }
                        if (i > 2) {
                            throw new o(4, "No signature found in package of version " + i + " or newer for package " + str);
                        }
                        try {
                            k kVar2 = new k(u(nr.u(randomAccessFile, str)), 2);
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused2) {
                            }
                            return kVar2;
                        } catch (s e2) {
                            if (i >= 2) {
                                throw new o(4, "No APK Signature Scheme v2 signature in package ".concat(String.valueOf(str)), e2);
                            }
                            if (i <= 1) {
                                k kVarU = u.u(str, true);
                                try {
                                    randomAccessFile.close();
                                } catch (Exception unused3) {
                                }
                                return kVarU;
                            }
                            throw new o(4, "No signature found in package of version " + i + " or newer for package " + str);
                        } catch (Exception e3) {
                            throw new o(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e3);
                        }
                    } catch (Exception e4) {
                        throw new o(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e4);
                    }
                } catch (Exception e5) {
                    throw new o(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e5);
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            throw new o(6, "failed to read apk file, minSignatureSchemeVersion : " + i + ", apkPath : " + str);
        }
    }

    public static Signature[] u(Certificate[][] certificateArr) throws CertificateEncodingException {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i = 0; i < certificateArr.length; i++) {
            if (com.bytedance.pangle.util.a.b()) {
                Constructor constructorU = com.bytedance.pangle.nr.nr.u.u((Class<?>) Signature.class, (Class<?>[]) new Class[]{Certificate[].class});
                if (constructorU != null) {
                    constructorU.setAccessible(true);
                }
                if (constructorU != null && constructorU.isAccessible()) {
                    try {
                        signatureArr[i] = (Signature) constructorU.newInstance(certificateArr[i]);
                    } catch (IllegalAccessException e) {
                        com.bytedance.sdk.openadsdk.api.iz.u(e);
                    } catch (InstantiationException e2) {
                        com.bytedance.sdk.openadsdk.api.iz.u(e2);
                    } catch (InvocationTargetException e3) {
                        com.bytedance.sdk.openadsdk.api.iz.u(e3);
                    }
                }
            } else {
                signatureArr[i] = new Signature(certificateArr[i][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
