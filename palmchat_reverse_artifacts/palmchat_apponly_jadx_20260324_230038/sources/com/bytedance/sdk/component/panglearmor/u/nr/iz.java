package com.bytedance.sdk.component.panglearmor.u.nr;

import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.api.model.AdnName;
import com.oplus.tblplayer.Constants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.UByte;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {
    private static JSONObject nr(List<u> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        for (u uVar : list) {
            if (uVar != null) {
                arrayList.add(u(uVar.nr()));
                arrayList2.add(String.valueOf(uVar.u()));
            }
        }
        u(jSONObject, "sign", arrayList, false);
        u(jSONObject, "subject", arrayList2, false);
        return jSONObject;
    }

    private static String u(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & UByte.MAX_VALUE) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static void u(JSONObject jSONObject, String str, List<String> list, boolean z) {
        if (jSONObject == null || list == null || list.isEmpty()) {
            return;
        }
        if (z) {
            try {
                jSONObject.put(str + "Size", list.size());
            } catch (JSONException unused) {
                return;
            }
        }
        jSONObject.put(str, pn.u(list));
    }

    private static JSONObject u(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : list) {
            if (str.endsWith(".png")) {
                arrayList2.add(str.substring(0, str.lastIndexOf(".png")));
            } else if (str.endsWith(".xml")) {
                arrayList.add(str.substring(0, str.lastIndexOf(".xml")));
            } else {
                arrayList3.add(str);
            }
        }
        u(jSONObject, "xml", arrayList, true);
        u(jSONObject, "png", arrayList2, true);
        u(jSONObject, AdnName.OTHER, arrayList3, true);
        return jSONObject;
    }

    public static long u(long j, InputStream inputStream) throws IOException {
        if (j != -1) {
            return j;
        }
        byte[] bArr = new byte[8192];
        long j2 = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return j2;
            }
            j2 += (long) i;
        }
    }

    private static void u(File file, List<u> list) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, t.k);
            try {
                nr nrVarU = fx.u(randomAccessFile, 0L, randomAccessFile.length());
                list.addAll(com.bytedance.sdk.component.panglearmor.u.u.nr.u.u.u.u(nrVarU, com.bytedance.sdk.component.panglearmor.u.u.u.u.u(nrVarU)));
                randomAccessFile.close();
            } finally {
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|130|3|(8:146|4|(8:140|7|(11:9|(3:142|11|(1:153))|15|16|(7:144|18|(2:154|20)|21|91|159|158)(1:22)|23|(2:28|(3:157|33|(2:51|(6:56|(2:62|(3:67|(0)(3:138|77|(3:79|(4:82|(5:84|85|134|86|163)(2:88|162)|89|80)|161))|158)(1:66))(1:60)|61|91|159|158)(1:55))(2:37|(2:43|(2:48|(1:50))(1:47))))(4:151|32|160|158))(2:155|27)|21|91|159|158)(1:152)|90|91|159|158|5)|150|94|136|95|96)|(11:148|97|(1:99)|100|(1:102)|103|(1:107)|108|(1:112)|113|(1:115))|132|116|124|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0277 A[EXC_TOP_SPLITTER, PHI: r8 r10
      0x0277: PHI (r8v2 org.json.JSONObject) = (r8v4 org.json.JSONObject), (r8v9 org.json.JSONObject), (r8v9 org.json.JSONObject) binds: [B:122:0x0283, B:114:0x0270, B:115:0x0272] A[DONT_GENERATE, DONT_INLINE]
      0x0277: PHI (r10v1 java.util.zip.ZipFile) = (r10v2 java.util.zip.ZipFile), (r10v3 java.util.zip.ZipFile), (r10v3 java.util.zip.ZipFile) binds: [B:122:0x0283, B:114:0x0270, B:115:0x0272] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject u(File file) {
        JSONObject jSONObject;
        ZipFile zipFile;
        long jU;
        ArrayList arrayList;
        ArrayList arrayList2;
        JSONObject jSONObject2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        Enumeration<? extends ZipEntry> enumeration;
        ArrayList arrayList5;
        JSONObject jSONObject3 = new JSONObject();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        JSONObject jSONObject4 = new JSONObject();
        u(file, arrayList12);
        try {
            zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                jU = 0;
                while (enumerationEntries.hasMoreElements()) {
                    try {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement != null) {
                            String name = zipEntryNextElement.getName();
                            if (TextUtils.isEmpty(name)) {
                                try {
                                    if (zipEntryNextElement.isDirectory()) {
                                    }
                                } catch (Throwable unused) {
                                    jSONObject = jSONObject3;
                                    if (zipFile != null) {
                                        zipFile.close();
                                    }
                                    return jSONObject;
                                }
                            }
                            String[] strArrSplit = name.split("/");
                            ArrayList arrayList13 = arrayList11;
                            ArrayList arrayList14 = arrayList12;
                            long size = zipEntryNextElement.getSize();
                            enumeration = enumerationEntries;
                            jSONObject2 = jSONObject3;
                            if (name.startsWith("res/drawable/")) {
                                try {
                                    arrayList5 = arrayList10;
                                    if (name.length() > 13) {
                                        arrayList7.add(strArrSplit[2]);
                                    }
                                    arrayList3 = arrayList13;
                                    arrayList4 = arrayList14;
                                    arrayList10 = arrayList5;
                                    arrayList12 = arrayList4;
                                    enumerationEntries = enumeration;
                                    arrayList11 = arrayList3;
                                    jSONObject3 = jSONObject2;
                                } catch (Throwable unused2) {
                                    jSONObject = jSONObject2;
                                    if (zipFile != null) {
                                    }
                                    return jSONObject;
                                }
                            } else {
                                arrayList5 = arrayList10;
                            }
                            if (name.startsWith("res/") && strArrSplit.length == 2) {
                                arrayList8.add(strArrSplit[1]);
                            } else if (name.startsWith("classes") && name.endsWith(".dex")) {
                                jU += u(size, zipFile.getInputStream(zipEntryNextElement));
                                arrayList11 = arrayList13;
                                arrayList12 = arrayList14;
                                enumerationEntries = enumeration;
                                jSONObject3 = jSONObject2;
                                arrayList10 = arrayList5;
                            } else if (name.startsWith("assets/") && strArrSplit.length >= 2) {
                                arrayList6.add(strArrSplit[1]);
                                if (name.startsWith("assets/assets/resources/native/") && strArrSplit.length >= 6 && jSONObject4.length() < 10) {
                                    if (!TextUtils.isEmpty(strArrSplit[4]) && !jSONObject4.has(strArrSplit[4])) {
                                        jSONObject4.put(strArrSplit[4], u(size, zipFile.getInputStream(zipEntryNextElement)));
                                    } else if (jSONObject4.has(strArrSplit[4])) {
                                        jSONObject4.put(strArrSplit[4], jSONObject4.getLong(strArrSplit[4]) + u(size, zipFile.getInputStream(zipEntryNextElement)));
                                    }
                                }
                            } else if (name.startsWith("lib/armeabi/") && name.length() > 12) {
                                arrayList9.add(strArrSplit[2]);
                            } else {
                                if (name.startsWith("lib/armeabi-v7a/") && name.length() > 16) {
                                    arrayList10 = arrayList5;
                                    arrayList10.add(strArrSplit[2]);
                                    arrayList3 = arrayList13;
                                } else {
                                    arrayList10 = arrayList5;
                                    if (name.startsWith("lib/arm64-v8a/") && name.length() > 14) {
                                        arrayList3 = arrayList13;
                                        arrayList3.add(strArrSplit[2]);
                                    } else {
                                        arrayList3 = arrayList13;
                                        if (((name.startsWith("META-INF/") && name.endsWith(".RSA")) || name.endsWith(".DSA") || name.endsWith(".EC")) && arrayList14.isEmpty()) {
                                            try {
                                                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                                                if (certificateFactory != null) {
                                                    for (Certificate certificate : certificateFactory.generateCertificates(zipFile.getInputStream(zipEntryNextElement))) {
                                                        if (certificate instanceof X509Certificate) {
                                                            u uVar = new u(String.valueOf(((X509Certificate) certificate).getSubjectDN()), ((X509Certificate) certificate).getEncoded());
                                                            arrayList4 = arrayList14;
                                                            try {
                                                                arrayList4.add(uVar);
                                                            } catch (CertificateException unused3) {
                                                            }
                                                        } else {
                                                            arrayList4 = arrayList14;
                                                        }
                                                        arrayList14 = arrayList4;
                                                    }
                                                }
                                            } catch (CertificateException unused4) {
                                            }
                                        }
                                    }
                                }
                                arrayList4 = arrayList14;
                                arrayList12 = arrayList4;
                                enumerationEntries = enumeration;
                                arrayList11 = arrayList3;
                                jSONObject3 = jSONObject2;
                            }
                            arrayList3 = arrayList13;
                            arrayList4 = arrayList14;
                            arrayList10 = arrayList5;
                            arrayList12 = arrayList4;
                            enumerationEntries = enumeration;
                            arrayList11 = arrayList3;
                            jSONObject3 = jSONObject2;
                        }
                        jSONObject2 = jSONObject3;
                        arrayList3 = arrayList11;
                        arrayList4 = arrayList12;
                        enumeration = enumerationEntries;
                        arrayList12 = arrayList4;
                        enumerationEntries = enumeration;
                        arrayList11 = arrayList3;
                        jSONObject3 = jSONObject2;
                    } catch (Throwable unused5) {
                        jSONObject2 = jSONObject3;
                    }
                }
                JSONObject jSONObject5 = jSONObject3;
                arrayList = arrayList11;
                arrayList2 = arrayList12;
                try {
                    jSONObject = jSONObject5;
                } catch (Throwable unused6) {
                    jSONObject = jSONObject5;
                }
            } catch (Throwable unused7) {
                jSONObject = jSONObject3;
            }
        } catch (Throwable unused8) {
            jSONObject = jSONObject3;
            zipFile = null;
        }
        try {
            jSONObject.put("apkSize", file.length());
            jSONObject.put("dexSize", jU);
            if (jSONObject4.length() > 0) {
                jSONObject.put("cocos", jSONObject4);
            }
            u(jSONObject, "assets", arrayList6, false);
            JSONObject jSONObject6 = new JSONObject();
            u(jSONObject6, "eabi", arrayList9, false);
            u(jSONObject6, "v7a", arrayList10, false);
            u(jSONObject6, "v8a", arrayList, false);
            if (jSONObject6.length() > 0) {
                jSONObject.put(Constants.LIBRARY_PREFIX, jSONObject6);
            }
            JSONObject jSONObjectU = u(arrayList7);
            if (jSONObjectU != null && jSONObjectU.length() > 0) {
                jSONObject.put("drawable", jSONObjectU);
            }
            JSONObject jSONObjectU2 = u(arrayList8);
            if (jSONObjectU2 != null && jSONObjectU2.length() > 0) {
                jSONObject.put("res", jSONObjectU2);
            }
            JSONObject jSONObjectNr = nr(arrayList2);
            if (jSONObjectNr.length() > 0) {
                jSONObject.put("signInfo", jSONObjectNr);
            }
        } catch (Throwable unused9) {
            if (zipFile != null) {
            }
            return jSONObject;
        }
        zipFile.close();
        return jSONObject;
    }
}
