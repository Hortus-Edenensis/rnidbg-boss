package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6611a = 0;
    private static final String b = "ExtractNativeUtils";
    private static final int c = -1;
    private static final int d = 128;
    private static final int e = 50;
    private static final int f = 52428800;
    private static final Pattern g = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f6612a;
        ZipEntry b;
        String c;

        private a(ZipEntry zipEntry, String str, String str2) {
            this.b = zipEntry;
            this.f6612a = str;
            this.c = str2;
        }

        public /* synthetic */ a(ZipEntry zipEntry, String str, String str2, byte b) {
            this(zipEntry, str, str2);
        }
    }

    public static int a(File file, String str) throws Throwable {
        af.b(b, "begin extractNativeLibrary");
        int i = 0;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    try {
                        Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                        HashMap map = new HashMap();
                        int iA = a(enumerationEntries, (HashMap<String, HashSet<a>>) map, 0);
                        if (iA == -1) {
                            af.d(b, "Unsafe zip name!");
                            aj.a(zipFile2);
                            return -1;
                        }
                        if (iA > 50) {
                            af.d(b, "the total number is larger than the max");
                            aj.a(zipFile2);
                            return -1;
                        }
                        Iterator it = map.keySet().iterator();
                        int iA2 = 0;
                        while (it.hasNext()) {
                            try {
                                Set<a> set = (Set) map.get((String) it.next());
                                if (set == null) {
                                    af.d(b, "Get nativeZipEntries failed.");
                                    aj.a(zipFile2);
                                    return -1;
                                }
                                for (a aVar : set) {
                                    String str2 = str + File.separator + aVar.c;
                                    ad.a(str2);
                                    new File(str2).setExecutable(true, false);
                                    iA2 = a(zipFile2, aVar, str2);
                                    if (iA2 != 0) {
                                        aj.a(zipFile2);
                                        return iA2;
                                    }
                                    new File(str2, aVar.f6612a).setReadable(true, false);
                                }
                            } catch (IOException unused) {
                                zipFile = zipFile2;
                                i = iA2;
                                af.d(b, "catch IOException");
                                aj.a(zipFile);
                                return i;
                            }
                        }
                        aj.a(zipFile2);
                        return iA2;
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        aj.a(zipFile);
                        throw th;
                    }
                } catch (IOException unused2) {
                    zipFile = zipFile2;
                }
            } catch (IOException unused3) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int a(Enumeration enumeration, HashMap<String, HashSet<a>> map, int i) {
        while (enumeration.hasMoreElements()) {
            Object objNextElement = enumeration.nextElement();
            if (objNextElement != null && (objNextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) objNextElement;
                String name = zipEntry.getName();
                if (name.contains("../")) {
                    af.d(b, "Unsafe zip name!");
                    return -1;
                }
                Matcher matcher = g.matcher(name);
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    HashSet<a> hashSet = map.get(strGroup);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        map.put(strGroup, hashSet);
                    }
                    hashSet.add(new a(zipEntry, strGroup2, strGroup, (byte) 0));
                    i++;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        com.huawei.hms.ads.uiengineloader.af.d(com.huawei.hms.ads.uiengineloader.ac.b, "so file too big , " + r9.c + " , " + r9.f6612a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(ZipFile zipFile, a aVar, String str) throws Throwable {
        InputStream inputStream;
        InputStream inputStream2;
        String str2;
        byte[] bArr;
        FileOutputStream fileOutputStream;
        int i;
        int i2 = -1;
        FileOutputStream fileOutputStream2 = null;
        inputStream = null;
        inputStream = null;
        InputStream inputStream3 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        try {
            bArr = new byte[4096];
            fileOutputStream = new FileOutputStream(new File(str, aVar.f6612a));
            try {
                inputStream3 = zipFile.getInputStream(aVar.b);
                i = 0;
            } catch (FileNotFoundException unused) {
                inputStream2 = inputStream3;
                fileOutputStream2 = fileOutputStream;
                str2 = "FileNotFoundException";
                try {
                    af.d(b, str2);
                    aj.a(fileOutputStream2);
                    aj.a(inputStream2);
                } catch (Throwable th) {
                    inputStream = inputStream2;
                    th = th;
                    aj.a(fileOutputStream2);
                    aj.a(inputStream);
                    throw th;
                }
            } catch (IOException unused2) {
                inputStream2 = inputStream3;
                fileOutputStream2 = fileOutputStream;
                str2 = "IOException";
                af.d(b, str2);
                aj.a(fileOutputStream2);
                aj.a(inputStream2);
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStream3;
                fileOutputStream2 = fileOutputStream;
                aj.a(fileOutputStream2);
                aj.a(inputStream);
                throw th;
            }
        } catch (FileNotFoundException unused3) {
            inputStream2 = null;
        } catch (IOException unused4) {
            inputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
        while (true) {
            int i3 = inputStream3.read(bArr);
            if (i3 <= 0) {
                i2 = 0;
                break;
            }
            i += i3;
            if (i > 52428800) {
                break;
            }
            fileOutputStream.write(bArr, 0, i3);
            return i2;
        }
        aj.a(fileOutputStream);
        aj.a(inputStream3);
        return i2;
    }

    public static int a(ZipFile zipFile, Set<a> set, String str) throws Throwable {
        af.b(b, "begin extractNativeLibrary ");
        int i = 0;
        for (a aVar : set) {
            File file = new File(str);
            if (!file.exists()) {
                ad.a(str);
            }
            file.setExecutable(true, false);
            int iA = a(zipFile, aVar, str);
            if (iA != 0) {
                return iA;
            }
            File file2 = new File(str, aVar.f6612a);
            if (Build.VERSION.SDK_INT < 23) {
                String strA = ad.a(file2);
                if (!TextUtils.isEmpty(strA) && strA.length() > 128) {
                    af.c(b, file2.getName() + "  too long,  length > 128");
                    return -1;
                }
            }
            file2.setReadable(true, false);
            i = iA;
        }
        return i;
    }

    public static void a(Enumeration enumeration, Set<a> set, String str) throws ZipException {
        while (enumeration.hasMoreElements()) {
            Object objNextElement = enumeration.nextElement();
            if (objNextElement != null && (objNextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) objNextElement;
                String name = zipEntry.getName();
                if (name.contains("../")) {
                    throw new ZipException("Unsafe zip name!");
                }
                Matcher matcher = g.matcher(name);
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    if (strGroup.equals(str)) {
                        set.add(new a(zipEntry, strGroup2, strGroup, (byte) 0));
                    }
                }
            }
        }
    }

    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT <= 23) {
            af.b(b, "The android version is below android 6.");
            return true;
        }
        try {
            if ((context.getPackageManager().getPackageArchiveInfo(str, 128).applicationInfo.flags & 268435456) == 268435456) {
                af.b(b, "The extract-native-flag has set, need to extract.");
                return true;
            }
            af.b(b, "The extract-native-flag has not set, No need to extract.");
            return false;
        } catch (Exception unused) {
            af.c(b, "Get package name failed: name not found.");
            return true;
        }
    }
}
