package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.kuaishou.weapon.p0.jni.Engine;
import com.oplus.tblplayer.Constants;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class r {
    private static r c;
    private static Application d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7494a;
    private String e;
    private static Random f = new Random();
    private static Map<String, s> g = new ConcurrentHashMap();
    private static Map<String, s> h = new ConcurrentHashMap();
    public static List<Integer> b = new ArrayList();

    private r() {
    }

    public static r a(Context context, boolean z) {
        try {
            if (c == null) {
                d = (Application) context.getApplicationContext();
                c = new r();
            }
        } catch (Throwable unused) {
        }
        return c;
    }

    public static boolean e(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean b(String str) {
        s sVar = h.get(str);
        if (sVar == null) {
            return false;
        }
        g.remove(sVar.e);
        h.remove(str);
        dn.c(sVar.m);
        Application application = d;
        if (application == null) {
            return true;
        }
        dn.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
        return true;
    }

    public s c(String str) {
        try {
            return g.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public s d(String str) {
        try {
            return h.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static r a() {
        return c;
    }

    public boolean a(s sVar, boolean z) {
        this.f7494a = z;
        this.e = sVar.d;
        return a(sVar);
    }

    public Map<String, s> b() {
        return h;
    }

    private synchronized boolean a(s sVar) {
        boolean z;
        if (sVar != null) {
            if (!TextUtils.isEmpty(sVar.e)) {
                s sVar2 = g.get(sVar.e);
                if (sVar2 != null) {
                    if (sVar2.d.equals(sVar.d)) {
                        return true;
                    }
                    a(sVar2.e);
                }
                try {
                    sVar.f = d;
                    if (sVar.p == 1) {
                        try {
                            try {
                                if (!TextUtils.isEmpty(sVar.c) && !TextUtils.isEmpty(sVar.e)) {
                                    sVar.m = d.getFilesDir().getCanonicalPath() + bi.j + sVar.f7495a;
                                    String str = sVar.m + "/dex";
                                    String str2 = sVar.m + "/lib/" + this.e;
                                    dn.c(sVar.m + "/lib");
                                    String str3 = str2 + "/" + f.nextInt();
                                    e(str);
                                    dn.a(str, Boolean.FALSE);
                                    e(str3);
                                    a(sVar, str3, str, false);
                                    h.put(sVar.c, sVar);
                                    g.put(sVar.e, sVar);
                                    z = false;
                                } else {
                                    throw new RuntimeException("apkPackageName or apkPkgPath is null");
                                }
                            } catch (Throwable unused) {
                                a(sVar.e);
                                z = true;
                            }
                        } catch (Throwable unused2) {
                            return false;
                        }
                    } else {
                        z = false;
                    }
                    if (sVar.p != 1 || z) {
                        PackageInfo packageArchiveInfo = sVar.r;
                        if (packageArchiveInfo == null || TextUtils.isEmpty(packageArchiveInfo.packageName) || TextUtils.isEmpty(packageArchiveInfo.versionName)) {
                            packageArchiveInfo = d.getPackageManager().getPackageArchiveInfo(sVar.e, 1);
                        }
                        if (!TextUtils.isEmpty(packageArchiveInfo.packageName) && packageArchiveInfo.packageName.startsWith("com.kuaishou.weapon")) {
                            if (sVar.p != 1 && sVar.b != 1 && !((Boolean) a(sVar.j, sVar.e).first).booleanValue()) {
                                return false;
                            }
                            sVar.c = packageArchiveInfo.packageName;
                            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                            sVar.o = applicationInfo.className;
                            sVar.d = packageArchiveInfo.versionName;
                            sVar.l = packageArchiveInfo.activities;
                            sVar.q = applicationInfo.theme;
                            sVar.m = d.getFilesDir().getCanonicalPath() + bi.j + sVar.f7495a;
                            String str4 = sVar.m + "/dex";
                            String str5 = sVar.m + "/lib/" + this.e;
                            dn.c(sVar.m + "/lib");
                            String str6 = str5 + "/" + f.nextInt();
                            e(str4);
                            dn.a(str4, Boolean.FALSE);
                            e(str6);
                            a(sVar, str6, str4, true);
                            h.put(sVar.c, sVar);
                            g.put(sVar.e, sVar);
                            b.add(Integer.valueOf(sVar.f7495a));
                        } else {
                            throw new Exception("weapon package name check failed");
                        }
                    }
                    return true;
                } catch (Throwable unused3) {
                    a(sVar.e);
                    return false;
                }
            }
        }
        return false;
    }

    private Pair<Boolean, String> a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (!dn.a(file)) {
                return new Pair<>(Boolean.FALSE, "");
            }
            String strA = f.a(file);
            if (TextUtils.isEmpty(strA)) {
                return new Pair<>(Boolean.FALSE, "");
            }
            if (!strA.equalsIgnoreCase(str)) {
                return new Pair<>(Boolean.FALSE, strA);
            }
            return new Pair<>(Boolean.TRUE, "");
        }
        return new Pair<>(Boolean.FALSE, "");
    }

    public boolean a(String str) {
        s sVar = g.get(str);
        if (sVar == null) {
            return false;
        }
        g.remove(str);
        h.remove(sVar.c);
        dn.c(sVar.m);
        Application application = d;
        if (application == null) {
            return true;
        }
        dn.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:30|(2:257|31)|34|(11:(5:263|36|(4:38|259|39|(1:41)(1:280))(1:42)|43|(4:276|52|284|283))(2:279|56)|265|60|61|(3:269|62|(4:64|267|65|287)(1:286))|66|67|253|88|(4:90|106|112|285)(0)|283)|57|58|247|59) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:30|257|31|34|(11:(5:263|36|(4:38|259|39|(1:41)(1:280))(1:42)|43|(4:276|52|284|283))(2:279|56)|265|60|61|(3:269|62|(4:64|267|65|287)(1:286))|66|67|253|88|(4:90|106|112|285)(0)|283)|57|58|247|59) */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0229, code lost:
    
        if (r18 != 0) goto L167;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02e6 A[PHI: r11 r17 r18 r21 r22
      0x02e6: PHI (r11v11 ??) = (r11v8 ??), (r11v9 ??), (r11v12 ??), (r11v16 ??) binds: [B:146:0x02a8, B:166:0x02e4, B:156:0x02c6, B:116:0x0229] A[DONT_GENERATE, DONT_INLINE]
      0x02e6: PHI (r17v12 java.io.InputStream) = (r17v9 java.io.InputStream), (r17v10 java.io.InputStream), (r17v13 java.io.InputStream), (r17v20 java.io.InputStream) binds: [B:146:0x02a8, B:166:0x02e4, B:156:0x02c6, B:116:0x0229] A[DONT_GENERATE, DONT_INLINE]
      0x02e6: PHI (r18v9 ??) = (r18v6 ??), (r18v7 ??), (r18v10 ??), (r18v14 ??) binds: [B:146:0x02a8, B:166:0x02e4, B:156:0x02c6, B:116:0x0229] A[DONT_GENERATE, DONT_INLINE]
      0x02e6: PHI (r21v8 ??) = (r21v4 ??), (r21v5 ??), (r21v9 ??), (r21v19 ??) binds: [B:146:0x02a8, B:166:0x02e4, B:156:0x02c6, B:116:0x0229] A[DONT_GENERATE, DONT_INLINE]
      0x02e6: PHI (r22v8 java.lang.String) = (r22v4 java.lang.String), (r22v5 java.lang.String), (r22v9 java.lang.String), (r22v19 java.lang.String) binds: [B:146:0x02a8, B:166:0x02e4, B:156:0x02c6, B:116:0x0229] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03ed A[Catch: all -> 0x0463, TryCatch #1 {all -> 0x0463, blocks: (B:198:0x03cc, B:199:0x03df, B:201:0x03ed, B:203:0x03f7, B:207:0x0441, B:208:0x0462, B:205:0x0401), top: B:230:0x03cc, inners: #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0463 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x035f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r11v16, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v44 */
    /* JADX WARN: Type inference failed for: r11v45 */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r11v49 */
    /* JADX WARN: Type inference failed for: r11v50 */
    /* JADX WARN: Type inference failed for: r11v51 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v16 */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v19 */
    /* JADX WARN: Type inference failed for: r18v20 */
    /* JADX WARN: Type inference failed for: r18v21 */
    /* JADX WARN: Type inference failed for: r18v22 */
    /* JADX WARN: Type inference failed for: r18v23 */
    /* JADX WARN: Type inference failed for: r18v24 */
    /* JADX WARN: Type inference failed for: r18v25 */
    /* JADX WARN: Type inference failed for: r18v26 */
    /* JADX WARN: Type inference failed for: r18v27 */
    /* JADX WARN: Type inference failed for: r18v28 */
    /* JADX WARN: Type inference failed for: r18v29 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v30 */
    /* JADX WARN: Type inference failed for: r18v31 */
    /* JADX WARN: Type inference failed for: r18v32 */
    /* JADX WARN: Type inference failed for: r18v33 */
    /* JADX WARN: Type inference failed for: r18v34 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r21v13 */
    /* JADX WARN: Type inference failed for: r21v14 */
    /* JADX WARN: Type inference failed for: r21v15 */
    /* JADX WARN: Type inference failed for: r21v16 */
    /* JADX WARN: Type inference failed for: r21v17 */
    /* JADX WARN: Type inference failed for: r21v18 */
    /* JADX WARN: Type inference failed for: r21v19 */
    /* JADX WARN: Type inference failed for: r21v20 */
    /* JADX WARN: Type inference failed for: r21v21 */
    /* JADX WARN: Type inference failed for: r21v24 */
    /* JADX WARN: Type inference failed for: r21v25 */
    /* JADX WARN: Type inference failed for: r21v26 */
    /* JADX WARN: Type inference failed for: r21v27 */
    /* JADX WARN: Type inference failed for: r21v31 */
    /* JADX WARN: Type inference failed for: r21v32 */
    /* JADX WARN: Type inference failed for: r21v33 */
    /* JADX WARN: Type inference failed for: r21v34 */
    /* JADX WARN: Type inference failed for: r21v35 */
    /* JADX WARN: Type inference failed for: r21v36 */
    /* JADX WARN: Type inference failed for: r21v37 */
    /* JADX WARN: Type inference failed for: r21v38 */
    /* JADX WARN: Type inference failed for: r21v39 */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r21v40 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r21v6 */
    /* JADX WARN: Type inference failed for: r21v7 */
    /* JADX WARN: Type inference failed for: r21v8 */
    /* JADX WARN: Type inference failed for: r21v9 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(s sVar, String str, String str2, boolean z) throws Throwable {
        boolean z2;
        InputStream inputStream;
        ?? r18;
        String str3;
        ZipFile zipFile;
        ZipFile zipFile2;
        ZipFile zipFile3;
        Object obj;
        ?? r182;
        Object obj2;
        Object obj3;
        ?? r21;
        String str4;
        String str5;
        String str6;
        ?? r212;
        String str7;
        ?? r213;
        File file;
        String str8;
        String string;
        InputStream inputStream2;
        String str9;
        String str10 = Constants.LIBRARY_SUFFIX;
        ?? r11 = "armeabi";
        HashSet<String> hashSet = new HashSet<>();
        if (z || TextUtils.isEmpty(sVar.n)) {
            z2 = true;
        } else {
            File file2 = new File(sVar.n);
            if (file2.exists() && file2.isFile()) {
                z2 = false;
            }
        }
        String str11 = "";
        String strReplace = !TextUtils.isEmpty(sVar.d) ? sVar.d.replace(".", "") : "";
        StringBuilder sb = new StringBuilder();
        if (!z2) {
            sb.append(sVar.n);
        }
        byte[] bArr = new byte[4096];
        ?? r16 = 0;
        str = null;
        String str12 = null;
        try {
            try {
                try {
                    ZipFile zipFile4 = new ZipFile(sVar.e);
                    try {
                        Enumeration<? extends ZipEntry> enumerationEntries = zipFile4.entries();
                        inputStream = null;
                        r182 = 0;
                        while (enumerationEntries.hasMoreElements()) {
                            try {
                                try {
                                    try {
                                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                                        ?? name = zipEntryNextElement.getName();
                                        Enumeration<? extends ZipEntry> enumeration = enumerationEntries;
                                        if (name.startsWith("lib/") && !zipEntryNextElement.isDirectory()) {
                                            String str13 = Build.CPU_ABI;
                                            try {
                                                str8 = Build.CPU_ABI2;
                                            } catch (Throwable unused) {
                                                str8 = null;
                                            }
                                            try {
                                                if (name.contains(str13)) {
                                                    str3 = str11;
                                                } else {
                                                    try {
                                                        if (TextUtils.isEmpty(str8)) {
                                                            str3 = str11;
                                                            str9 = str8;
                                                        } else {
                                                            str3 = str11;
                                                            str9 = str8;
                                                            try {
                                                                if (!name.contains(str9)) {
                                                                }
                                                            } catch (EOFException unused2) {
                                                                r212 = r11;
                                                                r11 = zipFile4;
                                                                r182 = r182;
                                                                r21 = r212;
                                                                a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                if (r11 != 0) {
                                                                    r11.close();
                                                                }
                                                                if (inputStream != null) {
                                                                    inputStream.close();
                                                                }
                                                                if (r182 != 0) {
                                                                    r182.close();
                                                                }
                                                                str4 = Build.CPU_ABI;
                                                                if (hashSet.contains(str4)) {
                                                                    String str14 = str + "/" + str4;
                                                                    try {
                                                                        String str15 = Build.CPU_ABI2;
                                                                        if (hashSet.contains(str15)) {
                                                                            str12 = str + "/" + str15;
                                                                        }
                                                                    } catch (Throwable unused3) {
                                                                    }
                                                                    String str16 = str12;
                                                                    if (str16 != null) {
                                                                        str5 = str14 + ":" + str16 + ":" + System.getProperty("java.library.path");
                                                                    } else {
                                                                        str5 = str14 + ":" + System.getProperty("java.library.path");
                                                                    }
                                                                } else {
                                                                    try {
                                                                        str6 = Build.CPU_ABI2;
                                                                    } catch (Throwable unused4) {
                                                                    }
                                                                    if (hashSet.contains(str6)) {
                                                                        str5 = str + "/" + str6 + ":" + System.getProperty("java.library.path");
                                                                    } else {
                                                                        str5 = str3;
                                                                    }
                                                                }
                                                                if (TextUtils.isEmpty(str5)) {
                                                                    ?? r1 = r21;
                                                                    if (("armeabi-v7a".equals(Build.CPU_ABI) && hashSet.contains(r1)) || ("armeabi-v7a".equals(Build.CPU_ABI2) && hashSet.contains(r1))) {
                                                                        str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                    }
                                                                }
                                                                sVar.h = str5;
                                                                sVar.n = sb.toString();
                                                                try {
                                                                    String absolutePath = new File(str2, "apkDex").getAbsolutePath();
                                                                    dn.c(absolutePath);
                                                                    e(absolutePath);
                                                                    String strA = dm.a(d);
                                                                    if (TextUtils.isEmpty(sVar.n)) {
                                                                        if (sVar.c.endsWith("v7") || sVar.c.endsWith("v8")) {
                                                                            Cdo.a(getClass().getClassLoader(), new File(str + "/" + strA));
                                                                            Engine.soPath = str + "/" + strA;
                                                                            Engine.soVersion = sVar.d;
                                                                            Engine.getInstance(d);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    return;
                                                                } catch (Throwable unused5) {
                                                                    return;
                                                                }
                                                            } catch (FileNotFoundException | ZipException unused6) {
                                                                r212 = r11;
                                                                r11 = zipFile4;
                                                                r182 = r182;
                                                                r21 = r212;
                                                                a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                if (r11 != 0) {
                                                                    r11.close();
                                                                }
                                                                if (inputStream != null) {
                                                                    inputStream.close();
                                                                }
                                                                if (r182 != 0) {
                                                                }
                                                                str4 = Build.CPU_ABI;
                                                                if (hashSet.contains(str4)) {
                                                                }
                                                                if (TextUtils.isEmpty(str5)) {
                                                                }
                                                                sVar.h = str5;
                                                                sVar.n = sb.toString();
                                                                String absolutePath2 = new File(str2, "apkDex").getAbsolutePath();
                                                                dn.c(absolutePath2);
                                                                e(absolutePath2);
                                                                String strA2 = dm.a(d);
                                                                if (TextUtils.isEmpty(sVar.n)) {
                                                                }
                                                            } catch (IOException unused7) {
                                                                r212 = r11;
                                                                r11 = zipFile4;
                                                                r182 = r182;
                                                                r21 = r212;
                                                                a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                if (r11 != 0) {
                                                                    r11.close();
                                                                }
                                                                if (inputStream != null) {
                                                                    inputStream.close();
                                                                }
                                                                if (r182 != 0) {
                                                                }
                                                                str4 = Build.CPU_ABI;
                                                                if (hashSet.contains(str4)) {
                                                                }
                                                                if (TextUtils.isEmpty(str5)) {
                                                                }
                                                                sVar.h = str5;
                                                                sVar.n = sb.toString();
                                                                String absolutePath22 = new File(str2, "apkDex").getAbsolutePath();
                                                                dn.c(absolutePath22);
                                                                e(absolutePath22);
                                                                String strA22 = dm.a(d);
                                                                if (TextUtils.isEmpty(sVar.n)) {
                                                                }
                                                            }
                                                        }
                                                        if (!name.contains(r11) || (!"armeabi-v7a".equalsIgnoreCase(str13) && (TextUtils.isEmpty(str9) || !"armeabi-v7a".equalsIgnoreCase(str9)))) {
                                                            enumerationEntries = enumeration;
                                                            str11 = str3;
                                                        }
                                                    } catch (EOFException unused8) {
                                                        str3 = str11;
                                                    } catch (FileNotFoundException | ZipException unused9) {
                                                        str3 = str11;
                                                    } catch (IOException unused10) {
                                                        str3 = str11;
                                                    }
                                                }
                                                FileOutputStream fileOutputStream = new FileOutputStream(string);
                                                str7 = str10;
                                                while (true) {
                                                    try {
                                                        int i = inputStream2.read(bArr);
                                                        if (i <= 0) {
                                                            break;
                                                        }
                                                        inputStream = inputStream2;
                                                        try {
                                                            fileOutputStream.write(bArr, 0, i);
                                                            inputStream2 = inputStream;
                                                        } catch (EOFException unused11) {
                                                            r11 = zipFile4;
                                                            r182 = fileOutputStream;
                                                            r21 = r212;
                                                            a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                            if (r11 != 0) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (r182 != 0) {
                                                            }
                                                            str4 = Build.CPU_ABI;
                                                            if (hashSet.contains(str4)) {
                                                            }
                                                            if (TextUtils.isEmpty(str5)) {
                                                            }
                                                            sVar.h = str5;
                                                            sVar.n = sb.toString();
                                                            String absolutePath222 = new File(str2, "apkDex").getAbsolutePath();
                                                            dn.c(absolutePath222);
                                                            e(absolutePath222);
                                                            String strA222 = dm.a(d);
                                                            if (TextUtils.isEmpty(sVar.n)) {
                                                            }
                                                        } catch (FileNotFoundException | ZipException unused12) {
                                                            r11 = zipFile4;
                                                            r182 = fileOutputStream;
                                                            r21 = r212;
                                                            a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                            if (r11 != 0) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (r182 != 0) {
                                                            }
                                                            str4 = Build.CPU_ABI;
                                                            if (hashSet.contains(str4)) {
                                                            }
                                                            if (TextUtils.isEmpty(str5)) {
                                                            }
                                                            sVar.h = str5;
                                                            sVar.n = sb.toString();
                                                            String absolutePath2222 = new File(str2, "apkDex").getAbsolutePath();
                                                            dn.c(absolutePath2222);
                                                            e(absolutePath2222);
                                                            String strA2222 = dm.a(d);
                                                            if (TextUtils.isEmpty(sVar.n)) {
                                                            }
                                                        } catch (IOException unused13) {
                                                            r11 = zipFile4;
                                                            r182 = fileOutputStream;
                                                            r21 = r212;
                                                            a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                            if (r11 != 0) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (r182 != 0) {
                                                            }
                                                            str4 = Build.CPU_ABI;
                                                            if (hashSet.contains(str4)) {
                                                            }
                                                            if (TextUtils.isEmpty(str5)) {
                                                            }
                                                            sVar.h = str5;
                                                            sVar.n = sb.toString();
                                                            String absolutePath22222 = new File(str2, "apkDex").getAbsolutePath();
                                                            dn.c(absolutePath22222);
                                                            e(absolutePath22222);
                                                            String strA22222 = dm.a(d);
                                                            if (TextUtils.isEmpty(sVar.n)) {
                                                            }
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            r16 = zipFile4;
                                                            r18 = fileOutputStream;
                                                            if (r16 != 0) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (r18 != 0) {
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (EOFException unused14) {
                                                        inputStream = inputStream2;
                                                    } catch (FileNotFoundException | ZipException unused15) {
                                                        inputStream = inputStream2;
                                                    } catch (IOException unused16) {
                                                        inputStream = inputStream2;
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        inputStream = inputStream2;
                                                    }
                                                }
                                                inputStream = inputStream2;
                                                dn.a(string, Boolean.TRUE);
                                                r182 = fileOutputStream;
                                                r213 = r212;
                                                if (!name.endsWith(".dex")) {
                                                    enumerationEntries = enumeration;
                                                    r11 = r213;
                                                    str11 = str3;
                                                    str10 = str7;
                                                }
                                            } catch (EOFException unused17) {
                                                inputStream = inputStream2;
                                                r11 = zipFile4;
                                                r182 = r182;
                                                r21 = r212;
                                                a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                if (r11 != 0) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (r182 != 0) {
                                                }
                                                str4 = Build.CPU_ABI;
                                                if (hashSet.contains(str4)) {
                                                }
                                                if (TextUtils.isEmpty(str5)) {
                                                }
                                                sVar.h = str5;
                                                sVar.n = sb.toString();
                                                String absolutePath222222 = new File(str2, "apkDex").getAbsolutePath();
                                                dn.c(absolutePath222222);
                                                e(absolutePath222222);
                                                String strA222222 = dm.a(d);
                                                if (TextUtils.isEmpty(sVar.n)) {
                                                }
                                            } catch (FileNotFoundException | ZipException unused18) {
                                                inputStream = inputStream2;
                                                r11 = zipFile4;
                                                r182 = r182;
                                                r21 = r212;
                                                a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                if (r11 != 0) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (r182 != 0) {
                                                }
                                                str4 = Build.CPU_ABI;
                                                if (hashSet.contains(str4)) {
                                                }
                                                if (TextUtils.isEmpty(str5)) {
                                                }
                                                sVar.h = str5;
                                                sVar.n = sb.toString();
                                                String absolutePath2222222 = new File(str2, "apkDex").getAbsolutePath();
                                                dn.c(absolutePath2222222);
                                                e(absolutePath2222222);
                                                String strA2222222 = dm.a(d);
                                                if (TextUtils.isEmpty(sVar.n)) {
                                                }
                                            } catch (IOException unused19) {
                                                inputStream = inputStream2;
                                                r11 = zipFile4;
                                                r182 = r182;
                                                r21 = r212;
                                                a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                if (r11 != 0) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (r182 != 0) {
                                                }
                                                str4 = Build.CPU_ABI;
                                                if (hashSet.contains(str4)) {
                                                }
                                                if (TextUtils.isEmpty(str5)) {
                                                }
                                                sVar.h = str5;
                                                sVar.n = sb.toString();
                                                String absolutePath22222222 = new File(str2, "apkDex").getAbsolutePath();
                                                dn.c(absolutePath22222222);
                                                e(absolutePath22222222);
                                                String strA22222222 = dm.a(d);
                                                if (TextUtils.isEmpty(sVar.n)) {
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                inputStream = inputStream2;
                                                r16 = zipFile4;
                                                r18 = r182;
                                                if (r16 != 0) {
                                                    r16.close();
                                                }
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                if (r18 != 0) {
                                                    r18.close();
                                                }
                                                throw th;
                                            }
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append(str);
                                            r212 = r11;
                                            sb2.append(name.substring(3).replace(str10, strReplace + str10));
                                            string = sb2.toString();
                                            String strSubstring = string.substring(0, string.lastIndexOf(47));
                                            hashSet.add(strSubstring.substring(strSubstring.lastIndexOf(47) + 1));
                                            e(strSubstring);
                                            new File(string).delete();
                                            inputStream2 = zipFile4.getInputStream(zipEntryNextElement);
                                        } else {
                                            str7 = str10;
                                            r213 = r11;
                                            str3 = str11;
                                            r182 = r182;
                                            try {
                                                if (!name.endsWith(".dex") && !zipEntryNextElement.isDirectory() && z2) {
                                                    String str17 = sVar.m;
                                                    e(str17);
                                                    file = new File(str17, sVar.f7495a + "-" + sVar.d + ".dex");
                                                    try {
                                                        InputStream inputStream3 = zipFile4.getInputStream(zipEntryNextElement);
                                                        try {
                                                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                                            while (true) {
                                                                try {
                                                                    int i2 = inputStream3.read(bArr);
                                                                    if (i2 <= 0) {
                                                                        break;
                                                                    }
                                                                    try {
                                                                        fileOutputStream2.write(bArr, 0, i2);
                                                                    } catch (Throwable unused20) {
                                                                        inputStream = inputStream3;
                                                                        r182 = fileOutputStream2;
                                                                        if (file != null && file.exists()) {
                                                                            file.delete();
                                                                        }
                                                                        enumerationEntries = enumeration;
                                                                        r11 = r213;
                                                                        str11 = str3;
                                                                        str10 = str7;
                                                                    }
                                                                } catch (Throwable unused21) {
                                                                }
                                                            }
                                                            fileOutputStream2.close();
                                                            inputStream3.close();
                                                            sb.append(file.getAbsolutePath());
                                                            dn.a(sb.toString(), Boolean.TRUE);
                                                            inputStream = inputStream3;
                                                            r182 = fileOutputStream2;
                                                        } catch (Throwable unused22) {
                                                            inputStream = inputStream3;
                                                            r182 = r182;
                                                        }
                                                    } catch (Throwable unused23) {
                                                        r182 = r182;
                                                    }
                                                }
                                            } catch (Throwable unused24) {
                                                file = null;
                                                r182 = r182;
                                            }
                                            enumerationEntries = enumeration;
                                            r11 = r213;
                                            str11 = str3;
                                            str10 = str7;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                } catch (FileNotFoundException | ZipException unused25) {
                                    r212 = r11;
                                    str3 = str11;
                                }
                            } catch (EOFException unused26) {
                                r212 = r11;
                                str3 = str11;
                            } catch (IOException unused27) {
                                r212 = r11;
                                str3 = str11;
                            }
                        }
                        r21 = r11;
                        str3 = str11;
                        zipFile4.close();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (EOFException unused28) {
                        obj3 = "armeabi";
                        str3 = "";
                        zipFile3 = zipFile4;
                        inputStream = null;
                        r182 = inputStream;
                        r11 = zipFile3;
                        r21 = obj3;
                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                        if (r11 != 0) {
                        }
                        if (inputStream != null) {
                        }
                        if (r182 != 0) {
                        }
                        str4 = Build.CPU_ABI;
                        if (hashSet.contains(str4)) {
                        }
                        if (TextUtils.isEmpty(str5)) {
                        }
                        sVar.h = str5;
                        sVar.n = sb.toString();
                        String absolutePath222222222 = new File(str2, "apkDex").getAbsolutePath();
                        dn.c(absolutePath222222222);
                        e(absolutePath222222222);
                        String strA222222222 = dm.a(d);
                        if (TextUtils.isEmpty(sVar.n)) {
                        }
                    } catch (FileNotFoundException | ZipException unused29) {
                        obj2 = "armeabi";
                        str3 = "";
                        zipFile2 = zipFile4;
                        inputStream = null;
                        r182 = inputStream;
                        r11 = zipFile2;
                        r21 = obj2;
                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                        if (r11 != 0) {
                        }
                        if (inputStream != null) {
                        }
                        if (r182 != 0) {
                        }
                        str4 = Build.CPU_ABI;
                        if (hashSet.contains(str4)) {
                        }
                        if (TextUtils.isEmpty(str5)) {
                        }
                        sVar.h = str5;
                        sVar.n = sb.toString();
                        String absolutePath2222222222 = new File(str2, "apkDex").getAbsolutePath();
                        dn.c(absolutePath2222222222);
                        e(absolutePath2222222222);
                        String strA2222222222 = dm.a(d);
                        if (TextUtils.isEmpty(sVar.n)) {
                        }
                    } catch (IOException unused30) {
                        obj = "armeabi";
                        str3 = "";
                        zipFile = zipFile4;
                        inputStream = null;
                        r182 = inputStream;
                        r11 = zipFile;
                        r21 = obj;
                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                        if (r11 != 0) {
                        }
                        if (inputStream != null) {
                        }
                        if (r182 != 0) {
                        }
                        str4 = Build.CPU_ABI;
                        if (hashSet.contains(str4)) {
                        }
                        if (TextUtils.isEmpty(str5)) {
                        }
                        sVar.h = str5;
                        sVar.n = sb.toString();
                        String absolutePath22222222222 = new File(str2, "apkDex").getAbsolutePath();
                        dn.c(absolutePath22222222222);
                        e(absolutePath22222222222);
                        String strA22222222222 = dm.a(d);
                        if (TextUtils.isEmpty(sVar.n)) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
                        r182 = 0;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    r16 = r11;
                    r18 = r182;
                }
            } catch (IOException e) {
                Object obj4 = "armeabi";
                str3 = "";
                try {
                    throw new FileNotFoundException(e.getMessage() + "--backupFile not exists");
                } catch (EOFException unused31) {
                    zipFile3 = null;
                    inputStream = null;
                    obj3 = obj4;
                    r182 = inputStream;
                    r11 = zipFile3;
                    r21 = obj3;
                    a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                    if (r11 != 0) {
                    }
                    if (inputStream != null) {
                    }
                    if (r182 != 0) {
                    }
                    str4 = Build.CPU_ABI;
                    if (hashSet.contains(str4)) {
                    }
                    if (TextUtils.isEmpty(str5)) {
                    }
                    sVar.h = str5;
                    sVar.n = sb.toString();
                    String absolutePath222222222222 = new File(str2, "apkDex").getAbsolutePath();
                    dn.c(absolutePath222222222222);
                    e(absolutePath222222222222);
                    String strA222222222222 = dm.a(d);
                    if (TextUtils.isEmpty(sVar.n)) {
                    }
                } catch (FileNotFoundException | ZipException unused32) {
                    zipFile2 = null;
                    inputStream = null;
                    obj2 = obj4;
                    r182 = inputStream;
                    r11 = zipFile2;
                    r21 = obj2;
                    a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                    if (r11 != 0) {
                    }
                    if (inputStream != null) {
                    }
                    if (r182 != 0) {
                    }
                    str4 = Build.CPU_ABI;
                    if (hashSet.contains(str4)) {
                    }
                    if (TextUtils.isEmpty(str5)) {
                    }
                    sVar.h = str5;
                    sVar.n = sb.toString();
                    String absolutePath2222222222222 = new File(str2, "apkDex").getAbsolutePath();
                    dn.c(absolutePath2222222222222);
                    e(absolutePath2222222222222);
                    String strA2222222222222 = dm.a(d);
                    if (TextUtils.isEmpty(sVar.n)) {
                    }
                } catch (IOException unused33) {
                    zipFile = null;
                    inputStream = null;
                    obj = obj4;
                    r182 = inputStream;
                    r11 = zipFile;
                    r21 = obj;
                    a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                    if (r11 != 0) {
                    }
                    if (inputStream != null) {
                    }
                    if (r182 != 0) {
                    }
                    str4 = Build.CPU_ABI;
                    if (hashSet.contains(str4)) {
                    }
                    if (TextUtils.isEmpty(str5)) {
                    }
                    sVar.h = str5;
                    sVar.n = sb.toString();
                    String absolutePath22222222222222 = new File(str2, "apkDex").getAbsolutePath();
                    dn.c(absolutePath22222222222222);
                    e(absolutePath22222222222222);
                    String strA22222222222222 = dm.a(d);
                    if (TextUtils.isEmpty(sVar.n)) {
                    }
                }
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            r18 = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0126 A[Catch: all -> 0x014a, LOOP:2: B:76:0x0120->B:47:0x0126, LOOP_END, TryCatch #2 {all -> 0x014a, blocks: (B:45:0x0120, B:47:0x0126, B:48:0x012b, B:50:0x0135, B:51:0x0138), top: B:76:0x0120 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0135 A[Catch: all -> 0x014a, TryCatch #2 {all -> 0x014a, blocks: (B:45:0x0120, B:47:0x0126, B:48:0x012b, B:50:0x0135, B:51:0x0138), top: B:76:0x0120 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012b A[EDGE_INSN: B:99:0x012b->B:48:0x012b BREAK  A[LOOP:2: B:76:0x0120->B:47:0x0126], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(s sVar, String str, String str2, HashSet<String> hashSet, byte[] bArr, StringBuilder sb, boolean z) throws Throwable {
        File file;
        FileOutputStream fileOutputStream;
        int i;
        String str3;
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(sVar.e));
        FileOutputStream fileOutputStream2 = null;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                if (!name.contains("../")) {
                    if (name.startsWith("lib/") && !nextEntry.isDirectory()) {
                        String str4 = Build.CPU_ABI;
                        try {
                            str3 = Build.CPU_ABI2;
                        } catch (Throwable unused) {
                            str3 = null;
                        }
                        if (name.contains(str4) || ((!TextUtils.isEmpty(str3) && name.contains(str3)) || (name.contains("armeabi") && ("armeabi-v7a".equalsIgnoreCase(str4) || (!TextUtils.isEmpty(str3) && "armeabi-v7a".equalsIgnoreCase(str3)))))) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str);
                            sb2.append(name.substring(3).replace(Constants.LIBRARY_SUFFIX, str2 + Constants.LIBRARY_SUFFIX));
                            String string = sb2.toString();
                            String strSubstring = string.substring(0, string.lastIndexOf(47));
                            hashSet.add(strSubstring.substring(strSubstring.lastIndexOf(47) + 1));
                            e(strSubstring);
                            File file2 = new File(string);
                            file2.delete();
                            file2.createNewFile();
                            FileOutputStream fileOutputStream3 = new FileOutputStream(string);
                            while (true) {
                                try {
                                    int i2 = zipInputStream.read(bArr);
                                    if (i2 <= 0) {
                                        break;
                                    } else {
                                        fileOutputStream3.write(bArr, 0, i2);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream2 = fileOutputStream3;
                                    zipInputStream.close();
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    throw th;
                                }
                            }
                            fileOutputStream3.close();
                            dn.a(string, Boolean.TRUE);
                            fileOutputStream2 = fileOutputStream3;
                            if (name.endsWith(".dex")) {
                                String str5 = sVar.m;
                                e(str5);
                                file = new File(str5, sVar.f7495a + "-" + sVar.d + ".dex");
                                file.delete();
                                file.createNewFile();
                                fileOutputStream = new FileOutputStream(file);
                                while (true) {
                                    i = zipInputStream.read(bArr);
                                    if (i > 0) {
                                    }
                                    fileOutputStream.write(bArr, 0, i);
                                }
                                fileOutputStream.close();
                                if (sb.length() > 0) {
                                }
                                sb.append(file.getAbsolutePath());
                                dn.a(sb.toString(), Boolean.TRUE);
                                fileOutputStream2 = fileOutputStream;
                            }
                            zipInputStream.closeEntry();
                        }
                    } else {
                        try {
                            if (name.endsWith(".dex") && !nextEntry.isDirectory() && z) {
                                String str52 = sVar.m;
                                e(str52);
                                file = new File(str52, sVar.f7495a + "-" + sVar.d + ".dex");
                                try {
                                    file.delete();
                                    file.createNewFile();
                                    fileOutputStream = new FileOutputStream(file);
                                    while (true) {
                                        try {
                                            i = zipInputStream.read(bArr);
                                            if (i > 0) {
                                                break;
                                            } else {
                                                fileOutputStream.write(bArr, 0, i);
                                            }
                                        } catch (Throwable unused2) {
                                            fileOutputStream2 = fileOutputStream;
                                            if (file != null && file.exists()) {
                                                file.delete();
                                            }
                                        }
                                    }
                                    fileOutputStream.close();
                                    if (sb.length() > 0) {
                                        sb.setLength(0);
                                    }
                                    sb.append(file.getAbsolutePath());
                                    dn.a(sb.toString(), Boolean.TRUE);
                                    fileOutputStream2 = fileOutputStream;
                                } catch (Throwable unused3) {
                                }
                            }
                        } catch (Throwable unused4) {
                            file = null;
                        }
                        zipInputStream.closeEntry();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        zipInputStream.close();
        if (fileOutputStream2 != null) {
            fileOutputStream2.close();
        }
    }
}
