package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.extends, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cextends {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10758a = Cfinally.a(Cfinally.b);
    public static final String b = Cfinally.a(Cfinally.c);
    public static final String c = Cfinally.a(Cfinally.d);
    public static final String d = Cfinally.a(Cfinally.e);
    public static final String e = Cfinally.a(Cfinally.f);
    public static long f = 0;
    public static final String[] g = {"^/data/user/\\d+$", "^/data/data$"};

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.extends$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class Cdo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f10759a;
        public final String b;

        public Cdo(boolean z, String str) {
            this.f10759a = z;
            this.b = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        String str2;
        long length;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        try {
            str2 = context.getPackageManager().getApplicationInfo(str, 0).sourceDir;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "";
        }
        try {
            sb.append((String) ((ArrayList) UrsaMinor.a(new File(str2))).get(0));
        } catch (Throwable unused2) {
            sb.append("");
        }
        sb.append("_");
        if (!TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            length = file.exists() ? file.length() : -1L;
        }
        sb.append(length);
        sb.append("_");
        sb.append(Process.myUid());
        return sb.toString();
    }

    public static String b(Context context) {
        Method method;
        try {
            Class<?> cls = Class.forName("android.os.UserManager");
            Field field = context.getClass().getField("USER_SERVICE");
            field.setAccessible(true);
            Object systemService = context.getSystemService((String) field.get(context));
            if (systemService == null || (method = cls.getMethod("getUserName", new Class[0])) == null) {
                return "";
            }
            method.setAccessible(true);
            return (String) method.invoke(systemService, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a() {
        try {
            return 999 == Process.myUid() / 100000;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0199, code lost:
    
        r13 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03ec A[LOOP:0: B:178:0x03e6->B:180:0x03ec, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01be  */
    /* JADX WARN: Type inference failed for: r0v45, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v51, types: [int] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v9, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:158:0x0321 -> B:159:0x0322). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        File parentFile;
        boolean z;
        Cdo cdo;
        boolean z2;
        int iA;
        FileReader fileReader;
        BufferedReader bufferedReader;
        String str;
        boolean z3;
        Cdo cdo2;
        int iIndexOf;
        String line;
        String name;
        ?? A;
        String strA;
        boolean z4;
        int i;
        StringBuilder sb;
        int i2;
        Cdo cdo3;
        int iA2;
        String str2;
        String str3;
        int iMyUid;
        StringBuilder sb2 = new StringBuilder();
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList<Cthrows> arrayList = new ArrayList();
        File parentFile2 = context.getApplicationContext().getFilesDir().getParentFile();
        if (parentFile2 == null || (parentFile = parentFile2.getParentFile()) == null) {
            cdo = new Cdo(false, "");
        } else {
            String[] strArr = g;
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z = true;
                    break;
                }
                if (Pattern.compile(strArr[i3]).matcher(parentFile.getAbsolutePath()).find()) {
                    z = false;
                    break;
                }
                i3++;
            }
            String absolutePath = parentFile2.getAbsolutePath();
            String packageName = context.getPackageName();
            String[] strArrSplit = absolutePath.split("/", 6);
            if (absolutePath.startsWith("/data/data/") && strArrSplit.length >= 4 && !TextUtils.isEmpty(strArrSplit[3])) {
                packageName = strArrSplit[3];
            } else if (absolutePath.startsWith("/data/user/") && strArrSplit.length >= 5 && !TextUtils.isEmpty(strArrSplit[4])) {
                packageName = strArrSplit[4];
            }
            if (z && !packageName.equals(context.getPackageName())) {
                cdo = new Cdo(z, a(context, packageName));
            } else {
                cdo = new Cdo(z, "");
            }
        }
        if (cdo.f10759a && !TextUtils.isEmpty(cdo.b)) {
            iA = Cthis.a(0, true, 0);
            Cthrows cthrows = new Cthrows();
            cthrows.f10778a = f10758a + c;
            cthrows.b = cdo.b;
            arrayList.add(cthrows);
            z2 = false;
        } else {
            z2 = false;
            iA = Cthis.a(0, false, 0);
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            cdo2 = new Cdo(z2, "");
        } else {
            int i4 = -1;
            try {
                fileReader = new FileReader("/proc/self/maps");
                try {
                    bufferedReader = new BufferedReader(fileReader);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = null;
                    try {
                        th.printStackTrace();
                        Auriga.a(fileReader);
                        Auriga.a(bufferedReader);
                        str = null;
                        String packageName2 = applicationContext.getPackageName();
                        if (TextUtils.isEmpty(str)) {
                        }
                        A = Cthis.a(iA, cdo2.f10759a, 1);
                        if (cdo2.f10759a) {
                        }
                        ?? sb3 = new StringBuilder();
                        strA = Cfinally.a(Cfinally.e1);
                        try {
                            if (strA == null) {
                                str3 = Build.BRAND;
                                if (!"xiaomi".equalsIgnoreCase(str3)) {
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        Cdo cdo4 = new Cdo(z4, sb.toString());
                        sb3 = Cthis.a(i, cdo4.f10759a, 2);
                        A = cdo4.f10759a;
                        if (A != 0) {
                        }
                        new SparseArray();
                        str2 = (String) Pyxis.a(TNative$aa.d90_9F87DFDD2CC93068(new SparseArray(), context, 206), 206, String.class);
                        int i5 = Damson.f10689a;
                        if (str2 == null) {
                        }
                        i2 = Integer.parseInt(str2);
                        if (i2 <= 0) {
                        }
                        iA2 = Cthis.a(sb3, cdo3.f10759a, 4);
                        if (cdo3.f10759a) {
                        }
                        if (iA2 > 0) {
                        }
                        f = System.currentTimeMillis() - jCurrentTimeMillis;
                        while (r0.hasNext()) {
                        }
                        return sb2.toString();
                    } finally {
                        Auriga.a(fileReader);
                        Auriga.a(bufferedReader);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileReader = null;
            }
            while (true) {
                try {
                    line = bufferedReader.readLine();
                } catch (Throwable th3) {
                    th = th3;
                    th.printStackTrace();
                    Auriga.a(fileReader);
                    Auriga.a(bufferedReader);
                    str = null;
                }
                if (line == null) {
                    break;
                }
                int iIndexOf2 = line.indexOf(47);
                if (iIndexOf2 != i4) {
                    String strTrim = line.substring(iIndexOf2).trim();
                    if (Build.VERSION.SDK_INT < 23) {
                        if (strTrim.startsWith("/data/dalvik-cache/") && strTrim.endsWith(".apk@classes.dex")) {
                            int iLastIndexOf = strTrim.lastIndexOf(47);
                            i4 = -1;
                            if (iLastIndexOf != -1) {
                                String strReplace = strTrim.substring(iLastIndexOf, strTrim.length() - 12).replace('@', '/');
                                if (strReplace.startsWith("/data/app/")) {
                                    File file = new File(strReplace);
                                    if ("base.apk".equals(file.getName())) {
                                        if (file.getParentFile() != null) {
                                            name = file.getParentFile().getName();
                                        }
                                    } else {
                                        name = file.getName();
                                    }
                                }
                            }
                        }
                        i4 = -1;
                    } else {
                        if (strTrim.startsWith("/data/app/") && strTrim.endsWith("/base.odex")) {
                            String[] strArrSplit2 = strTrim.split("/");
                            if (strArrSplit2.length >= 7) {
                                name = strArrSplit2[3];
                                break;
                            }
                        }
                        i4 = -1;
                    }
                    String packageName22 = applicationContext.getPackageName();
                    if (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf("-")) == -1) {
                        z3 = false;
                        if (z3) {
                            cdo2 = new Cdo(z3, a(context, packageName22));
                        } else {
                            cdo2 = new Cdo(z3, "");
                        }
                    } else {
                        String strSubstring = str.substring(0, iIndexOf);
                        if (!TextUtils.isEmpty(strSubstring)) {
                            File file2 = new File("/data/data/" + strSubstring);
                            if (!file2.exists() || !file2.canWrite()) {
                                strSubstring = packageName22;
                            }
                            z3 = !TextUtils.equals(packageName22, strSubstring);
                            packageName22 = strSubstring;
                        }
                        if (z3) {
                        }
                    }
                }
            }
            str = null;
            String packageName222 = applicationContext.getPackageName();
            if (TextUtils.isEmpty(str)) {
                z3 = false;
                if (z3) {
                }
            }
        }
        A = Cthis.a(iA, cdo2.f10759a, 1);
        if (cdo2.f10759a) {
            Cthrows cthrows2 = new Cthrows();
            cthrows2.f10778a = f10758a + d;
            cthrows2.b = cdo2.b;
            arrayList.add(cthrows2);
        }
        ?? sb32 = new StringBuilder();
        strA = Cfinally.a(Cfinally.e1);
        if (strA == null && strA.equalsIgnoreCase(Build.BRAND)) {
            String strB = b(context);
            String str4 = new String(Base64.decode("5YiG6Lqr5bqU55So", 0));
            if (!TextUtils.isEmpty(strB) && str4.equals(strB)) {
                String strA2 = Cfinally.a(Cfinally.f1);
                if (strA2 != null) {
                    sb32.append(strA2);
                } else {
                    sb32.append("H");
                }
                z4 = true;
                sb = sb32;
                i = A;
            }
            z4 = false;
            sb = sb32;
            i = A;
        } else {
            str3 = Build.BRAND;
            if (!"xiaomi".equalsIgnoreCase(str3)) {
                if (a()) {
                    sb32.append("XiaoMi");
                    z4 = true;
                    sb = sb32;
                    i = A;
                }
                z4 = false;
                sb = sb32;
                i = A;
            } else if ("redmi".equalsIgnoreCase(str3)) {
                if (a()) {
                    sb32.append("Redmi");
                    z4 = true;
                    sb = sb32;
                    i = A;
                }
                z4 = false;
                sb = sb32;
                i = A;
            } else if ("oppo".equalsIgnoreCase(str3)) {
                if (a()) {
                    sb32.append("OPPO");
                    z4 = true;
                    sb = sb32;
                    i = A;
                }
                z4 = false;
                sb = sb32;
                i = A;
            } else if ("vivo".equalsIgnoreCase(str3)) {
                if (a()) {
                    sb32.append("VIVO_A");
                    z4 = true;
                    sb = sb32;
                    i = A;
                } else {
                    if (new String(Cstrictfp.a("/proc/self/mountinfo")).contains(context.getApplicationContext().getPackageName() + "_cloned")) {
                        sb32.append("VIVO_B");
                        z4 = true;
                        sb = sb32;
                        i = A;
                    }
                    z4 = false;
                    sb = sb32;
                    i = A;
                }
            } else {
                if ("samsung".equalsIgnoreCase(str3) && (iMyUid = Process.myUid() / 100000) > 50) {
                    sb32.append("samsung");
                    sb32.append(iMyUid);
                    z4 = true;
                    sb = sb32;
                    i = A;
                }
                z4 = false;
                sb = sb32;
                i = A;
            }
        }
        Cdo cdo42 = new Cdo(z4, sb.toString());
        sb32 = Cthis.a(i, cdo42.f10759a, 2);
        A = cdo42.f10759a;
        if (A != 0) {
            Cthrows cthrows3 = new Cthrows();
            cthrows3.f10778a = f10758a + e;
            cthrows3.b = cdo42.b;
            arrayList.add(cthrows3);
        }
        new SparseArray();
        try {
            str2 = (String) Pyxis.a(TNative$aa.d90_9F87DFDD2CC93068(new SparseArray(), context, 206), 206, String.class);
            int i52 = Damson.f10689a;
            if (str2 == null) {
                str2 = "";
            }
            i2 = Integer.parseInt(str2);
        } catch (Throwable unused2) {
            i2 = 0;
        }
        if (i2 <= 0) {
            cdo3 = new Cdo(true, "");
        } else {
            cdo3 = new Cdo(false, "");
        }
        iA2 = Cthis.a(sb32, cdo3.f10759a, 4);
        if (cdo3.f10759a) {
            Cthrows cthrows4 = new Cthrows();
            cthrows4.f10778a = f10758a + "dual_e";
            cthrows4.b = cdo42.b;
            arrayList.add(cthrows4);
        }
        if (iA2 > 0) {
            Cthrows cthrows5 = new Cthrows();
            cthrows5.f10778a = f10758a + b;
            cthrows5.b = Cygnus.a("", iA2);
            arrayList.add(cthrows5);
        }
        f = System.currentTimeMillis() - jCurrentTimeMillis;
        for (Cthrows cthrows6 : arrayList) {
            sb2.append(cthrows6.f10778a);
            sb2.append(":");
            sb2.append(cthrows6.b);
            sb2.append(",");
        }
        return sb2.toString();
    }
}
