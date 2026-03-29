package com.huawei.hms.hatool;

import defpackage.ma4;
import defpackage.oh2;
import defpackage.pm1;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6796a = q0.i().getFilesDir().getPath();

    private String b(String str) throws Throwable {
        File file = new File(a(str), "hianalytics_" + str);
        if (a(file)) {
            return k1.a(file);
        }
        String strD = pm1.d(128);
        k1.a(file, strD);
        return strD;
    }

    public static boolean c() {
        return b(new File(q0.i().getFilesDir().getPath() + "/hms"));
    }

    private String d() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }

    public String a() throws Throwable {
        String strB;
        String strB2;
        String strB3;
        String strB4;
        String strD = d();
        if (b()) {
            v.c("hmsSdk", "refresh components");
            strB = pm1.d(128);
            a("aprpap", strB);
            strB2 = pm1.d(128);
            a("febdoc", strB2);
            strB3 = pm1.d(128);
            a("marfil", strB3);
            strB4 = pm1.d(128);
            a("maywnj", strB4);
            d.b(q0.i(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
        } else {
            strB = b("aprpap");
            strB2 = b("febdoc");
            strB3 = b("marfil");
            strB4 = b("maywnj");
        }
        return oh2.a(ma4.b(a(strB, strB2, strB3, strD), oh2.b(strB4), 10000, 16));
    }

    private String a(String str) {
        return this.f6796a + "/hms/component/".replace("component", str);
    }

    private boolean b() {
        long jA = d.a(q0.i(), "Privacy_MY", "assemblyFlash", -1L);
        if (-1 != jA) {
            return System.currentTimeMillis() - jA > 31536000000L;
        }
        v.c("hmsSdk", "First init components");
        return true;
    }

    private void a(String str, String str2) throws Throwable {
        File file = new File(a(str));
        File file2 = new File(a(str), "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            v.c("hmsSdk", "file directory is mkdirs");
        }
        if (a(file2)) {
            k1.a(file2, str2);
        } else {
            v.f("hmsSdk", "refreshComponent():file is not found,and file is create failed");
        }
    }

    private static boolean b(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    v.c("hmsSdk", "delete file failed : " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                b(file2);
            }
        }
        return file.delete();
    }

    private boolean a(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            v.f("hmsSdk", "create new file error!");
            return false;
        }
    }

    private char[] a(String str, String str2, String str3, String str4) {
        byte[] bArrB = oh2.b(str);
        byte[] bArrB2 = oh2.b(str2);
        byte[] bArrB3 = oh2.b(str3);
        byte[] bArrB4 = oh2.b(str4);
        int length = bArrB.length;
        if (length > bArrB2.length) {
            length = bArrB2.length;
        }
        if (length > bArrB3.length) {
            length = bArrB3.length;
        }
        if (length > bArrB4.length) {
            length = bArrB4.length;
        }
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (((bArrB[i] ^ bArrB2[i]) ^ bArrB3[i]) ^ bArrB4[i]);
        }
        return cArr;
    }
}
