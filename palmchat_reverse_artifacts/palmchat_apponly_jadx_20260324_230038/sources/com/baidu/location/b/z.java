package com.baidu.location.b;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import com.baidu.location.Jni;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.google.android.material.timepicker.TimeModel;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class z {
    private int B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f3469a = 0;
    private a z;
    private static ArrayList<String> b = new ArrayList<>();
    private static ArrayList<String> c = new ArrayList<>();
    private static ArrayList<String> d = new ArrayList<>();
    private static String e = com.baidu.location.e.g.f3537a + "/yo.dat";
    private static String f = com.baidu.location.e.g.f3537a + "/yoh.dat";
    private static String g = com.baidu.location.e.g.f3537a + "/yom.dat";
    private static String h = com.baidu.location.e.g.f3537a + "/yol.dat";
    private static String i = com.baidu.location.e.g.f3537a + "/yor.dat";
    private static File j = null;
    private static int k = 8;
    private static int l = 8;
    private static int m = 16;
    private static int n = 2048;
    private static double o = 0.0d;
    private static double p = 0.1d;
    private static double q = 30.0d;
    private static double r = 100.0d;
    private static int s = 0;
    private static int t = 64;
    private static int u = 128;
    private static Location v = null;
    private static Location w = null;
    private static Location x = null;
    private static com.baidu.location.c.k y = null;
    private static z A = null;
    private static long C = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends com.baidu.location.e.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f3470a = false;
        int b = 0;
        int c = 0;
        private ArrayList<String> e = new ArrayList<>();
        private boolean f = true;

        public a() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            Map<String, Object> map;
            StringBuilder sb;
            String str;
            if (this.b != 1) {
                this.eh = com.baidu.location.e.h.d();
            }
            this.ei = 2;
            if (this.e != null) {
                for (int i = 0; i < this.e.size(); i++) {
                    if (this.b == 1) {
                        map = this.el;
                        sb = new StringBuilder();
                        str = "cldc[";
                    } else {
                        map = this.el;
                        sb = new StringBuilder();
                        str = "cltr[";
                    }
                    sb.append(str);
                    sb.append(i);
                    sb.append("]");
                    map.put(sb.toString(), this.e.get(i));
                }
                this.el.put("trtm", String.format(Locale.CHINA, TimeModel.NUMBER_FORMAT, Long.valueOf(System.currentTimeMillis())));
                if (this.b != 1) {
                    this.el.put("qt", "cltrg");
                }
            }
        }

        public synchronized void b() {
            ExecutorService executorServiceC;
            String strD;
            String strD2;
            int i;
            if (this.f3470a) {
                return;
            }
            int i2 = com.baidu.location.e.f.et;
            if (i2 > 4 && (i = this.c) < i2) {
                this.c = i + 1;
                return;
            }
            this.c = 0;
            this.f3470a = true;
            this.b = 0;
            try {
                ArrayList<String> arrayList = this.e;
                if (arrayList == null || arrayList.size() < 1) {
                    if (this.e == null) {
                        this.e = new ArrayList<>();
                    }
                    this.b = 0;
                    int length = 0;
                    while (true) {
                        String strA = null;
                        String strB = this.b < 2 ? z.b() : null;
                        if (strB == null && this.b != 1 && this.f) {
                            this.b = 2;
                            try {
                                strA = j.a();
                            } catch (Exception unused) {
                            }
                        } else {
                            this.b = 1;
                            strA = strB;
                        }
                        if (strA == null) {
                            break;
                        }
                        if (!strA.contains("err!")) {
                            this.e.add(strA);
                            length += strA.length();
                            if (length >= com.baidu.location.e.a.h) {
                                break;
                            }
                        }
                    }
                }
                ArrayList<String> arrayList2 = this.e;
                if (arrayList2 == null || arrayList2.size() < 1) {
                    ArrayList<String> arrayList3 = this.e;
                    if (arrayList3 != null) {
                        arrayList3.clear();
                    }
                    this.f3470a = false;
                    return;
                }
                if (this.b != 1) {
                    executorServiceC = x.a().c();
                    if (executorServiceC != null) {
                        strD2 = com.baidu.location.e.h.d();
                        a(executorServiceC, strD2);
                    } else {
                        strD = com.baidu.location.e.h.d();
                        b(strD);
                    }
                } else {
                    executorServiceC = x.a().c();
                    if (executorServiceC != null) {
                        strD2 = com.baidu.location.e.d.e;
                        a(executorServiceC, strD2);
                    } else {
                        strD = com.baidu.location.e.d.e;
                        b(strD);
                    }
                }
            } catch (Exception unused2) {
                ArrayList<String> arrayList4 = this.e;
                if (arrayList4 != null) {
                    arrayList4.clear();
                }
            }
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z) {
            if (z && this.ej != null) {
                ArrayList<String> arrayList = this.e;
                if (arrayList != null) {
                    arrayList.clear();
                }
                try {
                    JSONObject jSONObject = new JSONObject(this.ej);
                    if (jSONObject.has("ison") && jSONObject.getInt("ison") == 0) {
                        this.f = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Map<String, Object> map = this.el;
            if (map != null) {
                map.clear();
            }
            this.f3470a = false;
        }
    }

    private z() {
        String strI;
        this.z = null;
        this.B = 0;
        this.z = new a();
        this.B = 0;
        if (Build.VERSION.SDK_INT <= 28 || (strI = com.baidu.location.e.h.i()) == null) {
            return;
        }
        e = strI + "/yo2.dat";
        f = strI + "/yoh2.dat";
        g = strI + "/yom2.dat";
        h = strI + "/yol2.dat";
        i = strI + "/yor2.dat";
    }

    private static synchronized int a(List<String> list, int i2) {
        if (list != null && i2 <= 256) {
            if (i2 >= 0) {
                try {
                    if (j == null) {
                        File file = new File(e);
                        j = file;
                        if (!file.exists()) {
                            j = null;
                            return -2;
                        }
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(j, "rw");
                    if (randomAccessFile.length() < 1) {
                        randomAccessFile.close();
                        return -3;
                    }
                    long j2 = i2;
                    randomAccessFile.seek(j2);
                    int i3 = randomAccessFile.readInt();
                    int i4 = randomAccessFile.readInt();
                    int i5 = randomAccessFile.readInt();
                    int i6 = randomAccessFile.readInt();
                    long j3 = randomAccessFile.readLong();
                    long j4 = j3;
                    if (a(i3, i4, i5, i6, j3)) {
                        int i7 = 1;
                        if (i4 >= 1) {
                            byte[] bArr = new byte[n];
                            int i8 = k;
                            while (i8 > 0 && i4 > 0) {
                                long j5 = (((i3 + i4) - i7) % i5) * i6;
                                byte[] bArr2 = bArr;
                                long j6 = j4;
                                randomAccessFile.seek(j5 + j6);
                                int i9 = randomAccessFile.readInt();
                                if (i9 > 0 && i9 < i6) {
                                    randomAccessFile.read(bArr2, 0, i9);
                                    int i10 = i9 - 1;
                                    if (bArr2[i10] == 0) {
                                        list.add(new String(bArr2, 0, i10));
                                    }
                                }
                                i8--;
                                i4--;
                                j4 = j6;
                                bArr = bArr2;
                                i7 = 1;
                            }
                            randomAccessFile.seek(j2);
                            randomAccessFile.writeInt(i3);
                            randomAccessFile.writeInt(i4);
                            randomAccessFile.writeInt(i5);
                            randomAccessFile.writeInt(i6);
                            randomAccessFile.writeLong(j4);
                            randomAccessFile.close();
                            return k - i8;
                        }
                    }
                    randomAccessFile.close();
                    return -4;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return -5;
                }
            }
        }
        return -1;
    }

    public static String b() {
        return f();
    }

    public static void d() {
        l = 0;
        a(1, false);
        a(2, false);
        a(3, false);
        l = 8;
    }

    public static String e() {
        File file = new File(g);
        String str = null;
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(20L);
                int i2 = randomAccessFile.readInt();
                if (i2 > 128) {
                    String str2 = "&p1=" + i2;
                    try {
                        randomAccessFile.seek(20L);
                        randomAccessFile.writeInt(0);
                        randomAccessFile.close();
                        return str2;
                    } catch (Exception unused) {
                        str = str2;
                    }
                } else {
                    randomAccessFile.close();
                }
            } catch (Exception unused2) {
            }
        }
        File file2 = new File(h);
        if (file2.exists()) {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                randomAccessFile2.seek(20L);
                int i3 = randomAccessFile2.readInt();
                if (i3 > 256) {
                    String str3 = "&p2=" + i3;
                    try {
                        randomAccessFile2.seek(20L);
                        randomAccessFile2.writeInt(0);
                        randomAccessFile2.close();
                        return str3;
                    } catch (Exception unused3) {
                        str = str3;
                    }
                } else {
                    randomAccessFile2.close();
                }
            } catch (Exception unused4) {
            }
        }
        File file3 = new File(i);
        if (file3.exists()) {
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file3, "rw");
                randomAccessFile3.seek(20L);
                int i4 = randomAccessFile3.readInt();
                if (i4 > 512) {
                    String str4 = "&p3=" + i4;
                    try {
                        randomAccessFile3.seek(20L);
                        randomAccessFile3.writeInt(0);
                        randomAccessFile3.close();
                        return str4;
                    } catch (Exception unused5) {
                        str = str4;
                    }
                } else {
                    randomAccessFile3.close();
                }
            } catch (Exception unused6) {
            }
        }
        return str;
    }

    private static String f() {
        String strA = null;
        for (int i2 = 1; i2 < 5; i2++) {
            strA = a(i2);
            if (strA != null) {
                return strA;
            }
        }
        a(d, t);
        try {
            if (d.size() > 0) {
                String str = d.get(0);
                try {
                    d.remove(0);
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                strA = str;
            }
        } catch (ArrayIndexOutOfBoundsException unused2) {
        }
        if (strA != null) {
            return strA;
        }
        a(d, s);
        try {
            if (d.size() > 0) {
                String str2 = d.get(0);
                try {
                    d.remove(0);
                } catch (ArrayIndexOutOfBoundsException unused3) {
                }
                strA = str2;
            }
        } catch (ArrayIndexOutOfBoundsException unused4) {
        }
        if (strA != null) {
            return strA;
        }
        a(d, u);
        try {
            if (d.size() <= 0) {
                return strA;
            }
            String str3 = d.get(0);
            try {
                d.remove(0);
            } catch (ArrayIndexOutOfBoundsException unused5) {
            }
            return str3;
        } catch (ArrayIndexOutOfBoundsException unused6) {
            return strA;
        }
    }

    public void c() {
        if (com.baidu.location.c.f.a().l() && !com.baidu.location.e.h.b()) {
            this.z.b();
        }
    }

    public static synchronized z a() {
        if (A == null) {
            A = new z();
        }
        return A;
    }

    private static void b(String str) {
        e(str);
    }

    private static void c(String str) {
        e(str);
    }

    private static void d(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            File file2 = new File(com.baidu.location.e.g.f3537a);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file.createNewFile()) {
                file = null;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(32);
            randomAccessFile.writeInt(2048);
            randomAccessFile.writeInt(BmLocated.HALF_LEFT_TOP);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    private static synchronized void e(String str) {
        ArrayList<String> arrayList;
        if (str.contains("err!")) {
            return;
        }
        int i2 = com.baidu.location.e.h.p;
        if (i2 == 1) {
            arrayList = b;
        } else if (i2 == 2) {
            arrayList = c;
        } else if (i2 != 3) {
            return;
        } else {
            arrayList = d;
        }
        if (arrayList == null) {
            return;
        }
        if (arrayList.size() <= m) {
            arrayList.add(str);
        }
        if (arrayList.size() >= m) {
            a(i2, false);
        }
        while (arrayList.size() > m) {
            arrayList.remove(0);
        }
    }

    private static String a(int i2) {
        String str;
        ArrayList<String> arrayList;
        String str2 = null;
        if (i2 == 1) {
            str = f;
            arrayList = b;
        } else if (i2 == 2) {
            str = g;
            arrayList = c;
        } else {
            if (i2 == 3) {
                str = h;
            } else {
                if (i2 != 4) {
                    return null;
                }
                str = i;
            }
            arrayList = d;
        }
        if (arrayList == null) {
            return null;
        }
        if (arrayList.size() < 1) {
            a(str, arrayList);
        }
        synchronized (z.class) {
            int size = arrayList.size();
            if (size > 0) {
                int i3 = size - 1;
                try {
                    String str3 = arrayList.get(i3);
                    try {
                        arrayList.remove(i3);
                    } catch (Exception unused) {
                    }
                    str2 = str3;
                } catch (Exception unused2) {
                }
            }
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ce A[EDGE_INSN: B:51:0x00ce->B:42:0x00ce BREAK  A[LOOP:0: B:28:0x005b->B:40:0x00ca], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(int i2, boolean z) {
        String str;
        ArrayList<String> arrayList;
        File file;
        int size;
        int i3;
        try {
            if (i2 == 1) {
                str = f;
                if (z) {
                    return;
                }
            } else {
                if (i2 == 2) {
                    str = g;
                    if (z) {
                    }
                    file = new File(str);
                    if (!file.exists()) {
                        d(str);
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(4L);
                    int i4 = randomAccessFile.readInt();
                    int i5 = randomAccessFile.readInt();
                    int i6 = randomAccessFile.readInt();
                    int i7 = randomAccessFile.readInt();
                    int i8 = randomAccessFile.readInt();
                    size = arrayList.size();
                    while (true) {
                        i3 = 0;
                        if (size <= l) {
                            break;
                        }
                        if (z) {
                            i8++;
                        }
                        if (i6 >= i4) {
                            if (!z) {
                                i3 = 1;
                                break;
                            }
                            randomAccessFile.seek((i7 * i5) + 128);
                            byte[] bytes = (arrayList.get(0) + (char) 0).getBytes();
                            randomAccessFile.writeInt(bytes.length);
                            randomAccessFile.write(bytes, 0, bytes.length);
                            arrayList.remove(0);
                            int i9 = i7 + 1;
                            if (i9 <= i6) {
                                i3 = i9;
                            }
                            i7 = i3;
                        } else {
                            randomAccessFile.seek((i5 * i6) + 128);
                            byte[] bytes2 = (arrayList.get(0) + (char) 0).getBytes();
                            randomAccessFile.writeInt(bytes2.length);
                            randomAccessFile.write(bytes2, 0, bytes2.length);
                            arrayList.remove(0);
                            i6++;
                        }
                        size--;
                    }
                    randomAccessFile.seek(12L);
                    randomAccessFile.writeInt(i6);
                    randomAccessFile.writeInt(i7);
                    randomAccessFile.writeInt(i8);
                    randomAccessFile.close();
                    if (i3 == 0 || i2 >= 4) {
                        return;
                    }
                    a(i2 + 1, true);
                    return;
                }
                if (i2 == 3) {
                    str = h;
                    if (z) {
                    }
                    file = new File(str);
                    if (!file.exists()) {
                    }
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                    randomAccessFile2.seek(4L);
                    int i42 = randomAccessFile2.readInt();
                    int i52 = randomAccessFile2.readInt();
                    int i62 = randomAccessFile2.readInt();
                    int i72 = randomAccessFile2.readInt();
                    int i82 = randomAccessFile2.readInt();
                    size = arrayList.size();
                    while (true) {
                        i3 = 0;
                        if (size <= l) {
                        }
                        size--;
                    }
                    randomAccessFile2.seek(12L);
                    randomAccessFile2.writeInt(i62);
                    randomAccessFile2.writeInt(i72);
                    randomAccessFile2.writeInt(i82);
                    randomAccessFile2.close();
                    if (i3 == 0) {
                        return;
                    } else {
                        return;
                    }
                }
                if (i2 != 4) {
                    return;
                }
                str = i;
                if (!z) {
                    return;
                }
                arrayList = d;
                file = new File(str);
                if (!file.exists()) {
                }
                RandomAccessFile randomAccessFile22 = new RandomAccessFile(file, "rw");
                randomAccessFile22.seek(4L);
                int i422 = randomAccessFile22.readInt();
                int i522 = randomAccessFile22.readInt();
                int i622 = randomAccessFile22.readInt();
                int i722 = randomAccessFile22.readInt();
                int i822 = randomAccessFile22.readInt();
                size = arrayList.size();
                while (true) {
                    i3 = 0;
                    if (size <= l) {
                    }
                    size--;
                }
                randomAccessFile22.seek(12L);
                randomAccessFile22.writeInt(i622);
                randomAccessFile22.writeInt(i722);
                randomAccessFile22.writeInt(i822);
                randomAccessFile22.close();
                if (i3 == 0) {
                }
                arrayList = c;
                file = new File(str);
                if (!file.exists()) {
                }
                RandomAccessFile randomAccessFile222 = new RandomAccessFile(file, "rw");
                randomAccessFile222.seek(4L);
                int i4222 = randomAccessFile222.readInt();
                int i5222 = randomAccessFile222.readInt();
                int i6222 = randomAccessFile222.readInt();
                int i7222 = randomAccessFile222.readInt();
                int i8222 = randomAccessFile222.readInt();
                size = arrayList.size();
                while (true) {
                    i3 = 0;
                    if (size <= l) {
                    }
                    size--;
                }
                randomAccessFile222.seek(12L);
                randomAccessFile222.writeInt(i6222);
                randomAccessFile222.writeInt(i7222);
                randomAccessFile222.writeInt(i8222);
                randomAccessFile222.close();
                if (i3 == 0) {
                }
            }
            RandomAccessFile randomAccessFile2222 = new RandomAccessFile(file, "rw");
            randomAccessFile2222.seek(4L);
            int i42222 = randomAccessFile2222.readInt();
            int i52222 = randomAccessFile2222.readInt();
            int i62222 = randomAccessFile2222.readInt();
            int i72222 = randomAccessFile2222.readInt();
            int i82222 = randomAccessFile2222.readInt();
            size = arrayList.size();
            while (true) {
                i3 = 0;
                if (size <= l) {
                }
                size--;
            }
            randomAccessFile2222.seek(12L);
            randomAccessFile2222.writeInt(i62222);
            randomAccessFile2222.writeInt(i72222);
            randomAccessFile2222.writeInt(i82222);
            randomAccessFile2222.close();
            if (i3 == 0) {
            }
        } catch (Exception unused) {
            return;
        }
        arrayList = b;
        file = new File(str);
        if (!file.exists()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(com.baidu.location.c.a aVar, com.baidu.location.c.k kVar, Location location, String str, String str2) {
        StringBuilder sb;
        String str3;
        String strEncode;
        StringBuilder sb2;
        String str4;
        String strEncode2;
        String strEncode3;
        if ((com.baidu.location.e.h.u == 3 && !a(location, kVar) && !a(location, false)) || aVar == null || aVar.c()) {
            return;
        }
        if (aVar.a()) {
            if (!a(location, kVar)) {
                kVar = null;
            }
            String str5 = com.baidu.location.e.h.a(aVar, kVar, location, str, 1) + str2;
            if (str5 != null) {
                if (Build.VERSION.SDK_INT > 28) {
                    strEncode3 = Jni.encodeTp4(str5);
                } else {
                    String strEncodeTp4 = Jni.encodeTp4(str5);
                    strEncode3 = (strEncodeTp4 == null || strEncodeTp4.length() >= 1000) ? Jni.encode(str5) : strEncodeTp4;
                }
                a(strEncode3);
                w = location;
                v = location;
                if (kVar != null) {
                    y = kVar;
                    return;
                }
                return;
            }
            return;
        }
        if (kVar != null && kVar.c() && a(location, kVar)) {
            if (a(location) || com.baidu.location.c.f.a().e()) {
                if (!a(location) && com.baidu.location.c.f.a().e()) {
                    str = "&cfr=3" + str;
                } else if (com.baidu.location.c.f.a().e()) {
                    sb2 = new StringBuilder();
                    sb2.append("&cfr=2");
                }
                str4 = com.baidu.location.e.h.a(aVar, kVar, location, str, 2) + str2;
                if (str4 == null) {
                    if (Build.VERSION.SDK_INT > 28) {
                        strEncode2 = Jni.encodeTp4(str4);
                    } else {
                        String strEncodeTp42 = Jni.encodeTp4(str4);
                        strEncode2 = (strEncodeTp42 == null || strEncodeTp42.length() >= 1000) ? Jni.encode(str4) : strEncodeTp42;
                    }
                    b(strEncode2);
                    x = location;
                    v = location;
                    y = kVar;
                    return;
                }
                return;
            }
            sb2 = new StringBuilder();
            sb2.append("&cfr=1");
            sb2.append(str);
            str = sb2.toString();
            str4 = com.baidu.location.e.h.a(aVar, kVar, location, str, 2) + str2;
            if (str4 == null) {
            }
        } else {
            if (a(location) || com.baidu.location.c.f.a().e()) {
                if (!a(location) && com.baidu.location.c.f.a().e()) {
                    str = "&cfr=3" + str;
                } else if (com.baidu.location.c.f.a().e()) {
                    sb = new StringBuilder();
                    sb.append("&cfr=2");
                }
                if (!a(location, kVar)) {
                    kVar = null;
                }
                str3 = com.baidu.location.e.h.a(aVar, kVar, location, str, 3) + str2;
                if (str3 == null) {
                    if (Build.VERSION.SDK_INT > 28) {
                        strEncode = Jni.encodeTp4(str3);
                    } else {
                        String strEncodeTp43 = Jni.encodeTp4(str3);
                        strEncode = (strEncodeTp43 == null || strEncodeTp43.length() >= 1000) ? Jni.encode(str3) : strEncodeTp43;
                    }
                    c(strEncode);
                    v = location;
                    if (kVar != null) {
                        y = kVar;
                        return;
                    }
                    return;
                }
                return;
            }
            sb = new StringBuilder();
            sb.append("&cfr=1");
            sb.append(str);
            str = sb.toString();
            if (!a(location, kVar)) {
            }
            str3 = com.baidu.location.e.h.a(aVar, kVar, location, str, 3) + str2;
            if (str3 == null) {
            }
        }
    }

    private static void a(String str) {
        e(str);
    }

    private static boolean a(int i2, int i3, int i4, int i5, long j2) {
        return i2 >= 0 && i2 < i4 && i3 >= 0 && i3 <= i4 && i4 >= 0 && i4 <= 1024 && i5 >= 128 && i5 <= 1024;
    }

    private static boolean a(Location location) {
        if (location == null) {
            return false;
        }
        Location location2 = w;
        if (location2 == null || v == null) {
            w = location;
            return true;
        }
        double dDistanceTo = location.distanceTo(location2);
        return ((double) location.distanceTo(v)) > (((((double) com.baidu.location.e.h.S) * dDistanceTo) * dDistanceTo) + (((double) com.baidu.location.e.h.T) * dDistanceTo)) + ((double) com.baidu.location.e.h.U);
    }

    private static boolean a(Location location, com.baidu.location.c.k kVar) {
        List<ScanResult> list;
        boolean z = false;
        if (location != null && kVar != null && (list = kVar.f3506a) != null && !list.isEmpty()) {
            if (kVar.a(y)) {
                return false;
            }
            z = true;
            if (x == null) {
                x = location;
            }
        }
        return z;
    }

    public static boolean a(Location location, boolean z) {
        return com.baidu.location.c.d.a(v, location, z);
    }

    private static boolean a(String str, List<String> list) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(8L);
            int i2 = randomAccessFile.readInt();
            int i3 = randomAccessFile.readInt();
            int i4 = randomAccessFile.readInt();
            byte[] bArr = new byte[n];
            int i5 = l + 1;
            boolean z = false;
            while (i5 > 0 && i3 > 0) {
                if (i3 < i4) {
                    i4 = 0;
                }
                try {
                    randomAccessFile.seek(((i3 - 1) * i2) + 128);
                    int i6 = randomAccessFile.readInt();
                    if (i6 > 0 && i6 < i2) {
                        randomAccessFile.read(bArr, 0, i6);
                        int i7 = i6 - 1;
                        if (bArr[i7] == 0) {
                            list.add(0, new String(bArr, 0, i7));
                            z = true;
                        }
                    }
                    i5--;
                    i3--;
                } catch (Exception unused) {
                    return z;
                }
            }
            randomAccessFile.seek(12L);
            randomAccessFile.writeInt(i3);
            randomAccessFile.writeInt(i4);
            randomAccessFile.close();
            return z;
        } catch (Exception unused2) {
            return false;
        }
    }
}
