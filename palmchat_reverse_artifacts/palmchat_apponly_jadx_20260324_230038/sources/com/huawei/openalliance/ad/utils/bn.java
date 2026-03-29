package com.huawei.openalliance.ad.utils;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.fh;
import defpackage.r27;
import defpackage.s27;
import defpackage.t27;
import defpackage.u27;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bn {
    private static final String B = "../";
    private static final String C = "..\\";
    private static final String Code = "ZipUtil";
    private static final int I = 100;
    private static final int V = 524288000;
    private static final int Z = 4096;

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:17:0x0030
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private static java.lang.String Code(java.lang.String r5) {
        /*
            java.lang.String r0 = "close zipFile IOException "
            java.lang.String r1 = "ZipUtil"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            java.lang.String r4 = "UTF-8"
            if (r2 < r3) goto L50
            r2 = 0
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3b
            java.util.Enumeration r5 = r3.entries()     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L37
        L16:
            boolean r2 = r5.hasMoreElements()     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L37
            if (r2 == 0) goto L27
            r5.nextElement()     // Catch: java.lang.Exception -> L20 java.lang.Throwable -> L34
            goto L16
        L20:
            java.lang.String r5 = "zipFile format exception"
            com.huawei.hms.ads.fh.I(r1, r5)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L37
            r5 = 1
            goto L28
        L27:
            r5 = 0
        L28:
            if (r5 == 0) goto L2c
            java.lang.String r4 = "GBK"
        L2c:
            r3.close()     // Catch: java.io.IOException -> L30
            goto L50
        L30:
            com.huawei.hms.ads.fh.Z(r1, r0)
            goto L50
        L34:
            r5 = move-exception
            r2 = r3
            goto L46
        L37:
            r2 = r3
            goto L3b
        L39:
            r5 = move-exception
            goto L46
        L3b:
            java.lang.String r5 = "zipFile create exception"
            com.huawei.hms.ads.fh.I(r1, r5)     // Catch: java.lang.Throwable -> L39
            if (r2 == 0) goto L50
            r2.close()     // Catch: java.io.IOException -> L30
            goto L50
        L46:
            if (r2 == 0) goto L4f
            r2.close()     // Catch: java.io.IOException -> L4c
            goto L4f
        L4c:
            com.huawei.hms.ads.fh.Z(r1, r0)
        L4f:
            throw r5
        L50:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.bn.Code(java.lang.String):java.lang.String");
    }

    private static void I(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        fh.Z(Code, "mkdirs error , files exists or IOException.");
    }

    private static void V(File file) {
        if (file == null || file.delete()) {
            return;
        }
        fh.Z(Code, "delete file error");
    }

    private static void Code(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            V(file);
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                V(file);
                return;
            }
            for (File file2 : fileArrListFiles) {
                Code(file2);
            }
            V(file);
        }
    }

    private static boolean V(String str) {
        return str.contains(B) || str.contains(C) || str.contains("..") || str.contains("./") || str.contains(".\\.\\") || str.contains("%00");
    }

    private static void Code(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        bb.Code((Closeable) fileInputStream);
        bb.Code(bufferedOutputStream);
        bb.Code((Closeable) zipInputStream);
        bb.Code(fileOutputStream);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:(7:37|3|(1:5)(1:6)|7|(3:10|(2:42|17)(1:47)|8)|43|19)|35|20|29) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
    
        com.huawei.hms.ads.fh.Z(com.huawei.openalliance.ad.utils.bn.Code, "close zipFile IOException ");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean Code(String str, int i, int i2) {
        ZipFile zipFile = null;
        boolean z = false;
        try {
            try {
                String strCode = Code(str);
                if (Build.VERSION.SDK_INT >= 24) {
                    s27.a();
                    zipFile = r27.a(str, Charset.forName(strCode));
                } else {
                    zipFile = new ZipFile(str);
                }
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                long size = 0;
                int i3 = 0;
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    size += zipEntryNextElement.getSize();
                    i3++;
                    if (V(zipEntryNextElement.getName()) || i3 >= i2 || size > i || zipEntryNextElement.getSize() == -1) {
                        fh.Z(Code, "File name is invalid or too many files or too big");
                        break;
                    }
                }
                z = true;
            } catch (Exception e) {
                fh.Z(Code, "not a valid zip file, IOException : " + e.getClass().getSimpleName());
                if (zipFile != null) {
                    break;
                }
                return z;
            }
            zipFile.close();
            return z;
        } catch (Throwable th) {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException unused) {
                    fh.Z(Code, "close zipFile IOException ");
                }
            }
            throw th;
        }
    }

    private static boolean Code(String str, String str2, int i, int i2) {
        String str3;
        if (TextUtils.isEmpty(str) || V(str)) {
            str3 = "zip file is not valid";
        } else {
            if (!TextUtils.isEmpty(str2) && !V(str2)) {
                if (Code(str, i, i2)) {
                    return true;
                }
                fh.Z(Code, "zip file contains valid chars or too many files");
                throw new dt("unsecure zipfile!");
            }
            str3 = "target directory is not valid";
        }
        fh.Z(Code, str3);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean Code(String str, String str2, int i, int i2, boolean z) throws Throwable {
        ZipInputStream zipInputStream;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        ZipInputStream zipInputStream2;
        boolean z2;
        String strSubstring = str2;
        boolean z3 = false;
        if (!Code(str, str2, i, i2)) {
            return false;
        }
        String str3 = File.separator;
        if (strSubstring.endsWith(str3) && str2.length() > str3.length()) {
            strSubstring = strSubstring.substring(0, str2.length() - str3.length());
        }
        byte[] bArr = new byte[4096];
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    u27.a();
                    zipInputStream2 = t27.a(new BufferedInputStream(fileInputStream2), Charset.forName(Code(str)));
                } else {
                    zipInputStream2 = new ZipInputStream(new BufferedInputStream(fileInputStream2));
                }
                fileOutputStream = null;
                ZipInputStream zipInputStream3 = zipInputStream2;
                bufferedOutputStream = null;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream3.getNextEntry();
                        if (nextEntry == null) {
                            z2 = true;
                            break;
                        }
                        String name = nextEntry.getName();
                        if (V(name)) {
                            fh.I(Code, "File name is invalid");
                            z2 = false;
                            break;
                        }
                        File file = new File(strSubstring + File.separator + name);
                        if (z && file.exists()) {
                            Code(file);
                        }
                        if (nextEntry.isDirectory()) {
                            I(file);
                            arrayList.add(file);
                        } else {
                            File parentFile = file.getParentFile();
                            if (parentFile != null && !parentFile.exists()) {
                                I(parentFile);
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream2);
                                int i3 = 0;
                                while (i3 + 4096 <= i) {
                                    try {
                                        int i4 = zipInputStream3.read(bArr, 0, 4096);
                                        if (i4 == -1) {
                                            break;
                                        }
                                        bufferedOutputStream2.write(bArr, 0, i4);
                                        i3 += i4;
                                    } catch (IOException e) {
                                        e = e;
                                        zipInputStream = zipInputStream3;
                                        fileInputStream = fileInputStream2;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        fileOutputStream = fileOutputStream2;
                                        try {
                                            fh.Z(Code, "Unzip IOException : " + e.getClass().getSimpleName());
                                            Code(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                                            if (!z3) {
                                            }
                                            return z3;
                                        } catch (Throwable th) {
                                            th = th;
                                            Code(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        zipInputStream = zipInputStream3;
                                        fileInputStream = fileInputStream2;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        fileOutputStream = fileOutputStream2;
                                        Code(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                                        throw th;
                                    }
                                }
                                arrayList.add(file);
                                bufferedOutputStream2.flush();
                                bb.Code(bufferedOutputStream2);
                                bb.Code(fileOutputStream2);
                                bufferedOutputStream = bufferedOutputStream2;
                                fileOutputStream = fileOutputStream2;
                            } catch (IOException e2) {
                                e = e2;
                                zipInputStream = zipInputStream3;
                                fileInputStream = fileInputStream2;
                            } catch (Throwable th3) {
                                th = th3;
                                zipInputStream = zipInputStream3;
                                fileInputStream = fileInputStream2;
                            }
                        }
                        zipInputStream3.closeEntry();
                    } catch (IOException e3) {
                        e = e3;
                        zipInputStream = zipInputStream3;
                        fileInputStream = fileInputStream2;
                        fh.Z(Code, "Unzip IOException : " + e.getClass().getSimpleName());
                        Code(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                        if (!z3) {
                        }
                        return z3;
                    } catch (Throwable th4) {
                        th = th4;
                        zipInputStream = zipInputStream3;
                        fileInputStream = fileInputStream2;
                        Code(fileInputStream, bufferedOutputStream, zipInputStream, fileOutputStream);
                        throw th;
                    }
                }
                bb.Code((Closeable) zipInputStream3);
                bb.Code((Closeable) fileInputStream2);
                Code(fileInputStream2, bufferedOutputStream, zipInputStream3, fileOutputStream);
                z3 = z2;
            } catch (IOException e4) {
                e = e4;
                zipInputStream = null;
                bufferedOutputStream = null;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                zipInputStream = null;
                bufferedOutputStream = null;
                fileOutputStream = null;
            }
        } catch (IOException e5) {
            e = e5;
            zipInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            zipInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
        }
        if (!z3) {
            Code(arrayList);
        }
        return z3;
    }

    public static boolean Code(String str, String str2, boolean z) {
        return Code(str, str2, V, 100, z);
    }

    private static boolean Code(List<File> list) {
        try {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                Code(it.next());
            }
            return true;
        } catch (Exception e) {
            fh.Z(Code, "unzip fail delete file failed" + e.getClass().getSimpleName());
            return false;
        }
    }
}
