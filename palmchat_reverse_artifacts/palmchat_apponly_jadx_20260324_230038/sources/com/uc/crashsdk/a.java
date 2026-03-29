package com.uc.crashsdk;

import android.content.pm.PackageInfo;
import android.util.Log;
import android.util.SparseArray;
import com.huawei.openalliance.ad.constant.x;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import com.uc.crashsdk.export.LogType;
import java.io.File;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f10808a = "";
    public static String b = "";
    static final /* synthetic */ boolean d = true;
    private static final Map<String, String> e = new HashMap();
    private static final List<String> f = new ArrayList();
    private static String g = "";
    private static String h = null;
    private static int i = -1;
    private static long j = 0;
    private static final HashMap<String, Object[]> k = new HashMap<>();
    private static final List<String> l = new ArrayList();
    private static int m = 0;
    private static int n = 0;
    private static int o = 0;
    private static int p = 0;
    private static final HashMap<String, Object[]> q = new HashMap<>();
    private static final List<String> r = new ArrayList();
    private static int s = 0;
    private static int t = 0;
    private static int u = 0;
    private static int v = 0;
    private static int w = 0;
    private static int x = 0;
    private static final SparseArray<Object[]> y = new SparseArray<>();
    private static final List<Integer> z = new ArrayList();
    private static final HashMap<String, Object[]> A = new HashMap<>();
    private static final List<String> B = new ArrayList();
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;
    static boolean c = false;
    private static Runnable F = new com.uc.crashsdk.a.e(201);
    private static boolean G = false;
    private static boolean H = false;
    private static boolean I = false;

    public static String a() {
        String str = h;
        return str != null ? str : o() ? h : "";
    }

    public static long b() {
        return j;
    }

    public static int c() {
        if (i == -1) {
            o();
        }
        return i;
    }

    public static void d() {
        StringBuilder sb = new StringBuilder();
        synchronized (e) {
            for (String str : f) {
                String str2 = e.get(str);
                sb.append(str);
                sb.append(": ");
                if (str2 != null) {
                    sb.append(str2);
                }
                sb.append("\n");
            }
        }
        sb.append(String.format(Locale.US, "(saved at %s)\n", e.n()));
        com.uc.crashsdk.a.b.a(b.h(), sb.toString());
    }

    public static void e() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (e) {
            for (String str : f) {
                JNIBridge.nativeAddHeaderInfo(str, e.get(str));
            }
        }
    }

    public static byte[] f() {
        return new byte[]{24, 99, 121, 60};
    }

    public static void g() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (k) {
            for (String str : l) {
                Object[] objArr = k.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & iIntValue) != 0) {
                    JNIBridge.nativeAddDumpFile(str, (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), iIntValue, ((Boolean) objArr[4]).booleanValue());
                }
            }
        }
    }

    public static String h() {
        StringBuilder sb = new StringBuilder();
        synchronized (k) {
            boolean z2 = true;
            for (String str : l) {
                if (LogType.isForJava(((Integer) k.get(str)[0]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    public static void i() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (q) {
            for (String str : r) {
                Object[] objArr = q.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                if ((1048833 & iIntValue) != 0) {
                    JNIBridge.nativeAddCallbackInfo(str, iIntValue, ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                }
            }
        }
    }

    public static String j() {
        String string;
        synchronized (q) {
            StringBuilder sb = new StringBuilder();
            List<String> list = r;
            synchronized (list) {
                boolean z2 = true;
                for (String str : list) {
                    if (LogType.isForJava(((Integer) q.get(str)[0]).intValue())) {
                        if (!z2) {
                            sb.append("`");
                        }
                        sb.append(str);
                        z2 = false;
                    }
                }
            }
            string = sb.toString();
        }
        return string;
    }

    public static void k() {
        if (!d && !b.d) {
            throw new AssertionError();
        }
        synchronized (A) {
            for (String str : B) {
                Object[] objArr = A.get(str);
                int iIntValue = ((Integer) objArr[0]).intValue();
                int iIntValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if ((1048577 & iIntValue2) != 0 && JNIBridge.nativeCreateCachedInfo(str, iIntValue, iIntValue2) != 0) {
                    Iterator it = list.iterator();
                    while (it.hasNext() && JNIBridge.nativeAddCachedInfo(str, (String) it.next())) {
                    }
                }
            }
        }
    }

    public static String l() {
        StringBuilder sb = new StringBuilder();
        synchronized (A) {
            boolean z2 = true;
            for (String str : B) {
                if (LogType.isForJava(((Integer) A.get(str)[1]).intValue())) {
                    if (!z2) {
                        sb.append("`");
                    }
                    sb.append(str);
                    z2 = false;
                }
            }
        }
        return sb.toString();
    }

    public static String m() throws Throwable {
        if (!G) {
            String strA = com.uc.crashsdk.a.b.a(b.m());
            g = strA;
            G = true;
            if (strA == null) {
                g = "";
            }
        }
        return g;
    }

    public static void n() {
        p();
        if (!H) {
            H = true;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(202));
        } else if (b.d) {
            JNIBridge.set(128, g);
        }
    }

    private static boolean o() {
        try {
            PackageInfo packageInfo = com.uc.crashsdk.a.g.a().getPackageManager().getPackageInfo(f10808a, 0);
            h = packageInfo.versionName;
            j = packageInfo.lastUpdateTime;
            i = packageInfo.versionCode;
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.b(th);
            return false;
        }
    }

    private static void p() {
        if (!I && e.a()) {
            if (b.d || !b.g) {
                String str = String.format(Locale.US, "%s/%s/%s", g.U(), g.V(), g.W());
                com.uc.crashsdk.a.a.b("crashsdk", "UUID: " + e.q());
                com.uc.crashsdk.a.a.b("crashsdk", "Version: " + str);
                com.uc.crashsdk.a.a.b("crashsdk", "Process Name: " + e.h());
                I = true;
            }
        }
    }

    private static StringBuilder b(String str, boolean z2) {
        String strA;
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr = q.get(str);
            try {
                if (objArr == null) {
                    strA = "Unknown callback: " + str;
                } else {
                    Callable callable = (Callable) objArr[1];
                    strA = callable != null ? (String) callable.call() : d.a(str, z2);
                }
                if (strA != null) {
                    sb.append(strA);
                }
            } catch (Throwable th) {
                sb.append("[DEBUG] Callback occurred new exception:\n");
                sb.append(Log.getStackTraceString(th));
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        try {
            if (sb.length() == 0) {
                sb.append("(data is null)\n");
            }
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        return sb;
    }

    public static void a(String str, String str2) {
        Map<String, String> map = e;
        synchronized (map) {
            if (!map.containsKey(str)) {
                f.add(str);
            }
            map.put(str, str2);
            if (b.d) {
                JNIBridge.nativeAddHeaderInfo(str, str2);
            }
            e.y();
        }
    }

    public static ArrayList<String> c(String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return null;
        }
        String[] strArrSplit = str.split(x.aQ, 20);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : strArrSplit) {
            if (!com.uc.crashsdk.a.g.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static void a(OutputStream outputStream, String str) {
        synchronized (e) {
            for (String str2 : f) {
                try {
                    StringBuilder sb = new StringBuilder(11);
                    sb.append(str2);
                    sb.append(": ");
                    String str3 = e.get(str2);
                    if (str3 != null) {
                        sb.append(str3);
                    }
                    sb.append("\n");
                    outputStream.write(sb.toString().getBytes(str));
                } catch (Throwable th) {
                    e.a(th, outputStream);
                }
            }
        }
    }

    public static int b(String str, String str2) {
        int iAddType;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str2.length() > 2048) {
            str2 = str2.substring(0, 2048);
        }
        HashMap<String, Object[]> map = A;
        synchronized (map) {
            Object[] objArr = map.get(str);
            if (objArr != null) {
                int iIntValue = ((Integer) objArr[0]).intValue();
                int iIntValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (list.size() >= iIntValue) {
                    list.remove(0);
                }
                list.add(str2);
                iAddType = LogType.isForJava(iIntValue2) ? LogType.addType(0, 16) : 0;
                if (!b.d) {
                    if (LogType.isForNative(iIntValue2)) {
                        iAddType = LogType.addType(iAddType, 1);
                    }
                    if (LogType.isForANR(iIntValue2)) {
                        iAddType = LogType.addType(iAddType, 1048576);
                    }
                }
                iAddType = iAddType;
                iAddType = iIntValue2;
            } else {
                iAddType = 0;
            }
            if (b.d && JNIBridge.nativeAddCachedInfo(str, str2)) {
                if (LogType.isForNative(iAddType)) {
                    iAddType = LogType.addType(iAddType, 1);
                }
                if (LogType.isForANR(iAddType)) {
                    iAddType = LogType.addType(iAddType, 1048576);
                }
            }
        }
        return iAddType;
    }

    public static int a(String str, String str2, boolean z2, boolean z3, int i2, boolean z4) {
        int iRemoveType;
        int iIntValue;
        boolean z5;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.length() > 256) {
            com.uc.crashsdk.a.a.a("crashsdk", "addDumpFile: description is too long!", null);
            return 0;
        }
        HashMap<String, Object[]> map = k;
        synchronized (map) {
            if (map.containsKey(str)) {
                iIntValue = ((Integer) map.get(str)[0]).intValue();
                iRemoveType = LogType.addType(iIntValue, i2);
            } else {
                iRemoveType = i2;
                iIntValue = 0;
            }
            if (LogType.isForJava(iRemoveType) && !LogType.isForJava(iIntValue)) {
                int i3 = m;
                if (i3 >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 16);
                } else {
                    m = i3 + 1;
                }
            }
            if (LogType.isForNative(iRemoveType) && !LogType.isForNative(iIntValue)) {
                int i4 = n;
                if (i4 >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                } else {
                    n = i4 + 1;
                }
            }
            if (LogType.isForUnexp(iRemoveType) && !LogType.isForUnexp(iIntValue)) {
                int i5 = o;
                if (i5 >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 256);
                } else {
                    o = i5 + 1;
                }
            }
            if (LogType.isForANR(iRemoveType) && !LogType.isForANR(iIntValue)) {
                int i6 = p;
                if (i6 >= 10) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                } else {
                    p = i6 + 1;
                }
            }
            if ((1048849 & iRemoveType) == 0) {
                z5 = false;
            } else {
                if (iIntValue == 0) {
                    l.add(str);
                }
                z5 = true;
            }
            if (!z5) {
                return iRemoveType;
            }
            if (b.d && (1048833 & i2) != 0) {
                int iNativeAddDumpFile = JNIBridge.nativeAddDumpFile(str, str2, z2, z3, i2, z4);
                if (!LogType.isForNative(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                }
                if (!LogType.isForUnexp(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 256);
                }
                if (!LogType.isForANR(iNativeAddDumpFile)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                }
            }
            map.put(str, new Object[]{Integer.valueOf(iRemoveType), str2, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)});
            return iRemoveType;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(OutputStream outputStream, String str, String str2, ArrayList<String> arrayList) {
        synchronized (A) {
            for (String str3 : B) {
                Object[] objArr = A.get(str3);
                int iIntValue = ((Integer) objArr[0]).intValue();
                int iIntValue2 = ((Integer) objArr[1]).intValue();
                List list = (List) objArr[2];
                if (arrayList == null) {
                    if (LogType.isForJava(iIntValue2)) {
                        try {
                            outputStream.write(String.format(Locale.US, "%s (%d/%d)\n", str3, Integer.valueOf(list.size()), Integer.valueOf(iIntValue)).getBytes(str));
                        } catch (Throwable th) {
                            e.a(th, outputStream);
                        }
                        try {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                outputStream.write(((String) it.next()).getBytes(str));
                                outputStream.write("\n".getBytes(str));
                            }
                        } catch (Throwable th2) {
                            e.a(th2, outputStream);
                        }
                        try {
                            outputStream.write("\n".getBytes(str));
                            outputStream.write(str2.getBytes(str));
                        } catch (Throwable th3) {
                            e.a(th3, outputStream);
                        }
                    }
                } else if (a(arrayList, str3)) {
                }
            }
            if (arrayList != null && e.F()) {
                for (String str4 : arrayList) {
                    if (!a(B, str4)) {
                        e.a(outputStream, "CUSTOMCACHEDINFO", str4);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #2 {all -> 0x00d7, blocks: (B:12:0x0025, B:14:0x002f, B:20:0x0045, B:22:0x0050, B:17:0x003e), top: B:73:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b0 A[Catch: all -> 0x00d3, TryCatch #0 {all -> 0x00d3, blocks: (B:34:0x007f, B:36:0x009b, B:38:0x00a3, B:40:0x00b0, B:41:0x00b5), top: B:69:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b5 A[Catch: all -> 0x00d3, TRY_LEAVE, TryCatch #0 {all -> 0x00d3, blocks: (B:34:0x007f, B:36:0x009b, B:38:0x00a3, B:40:0x00b0, B:41:0x00b5), top: B:69:0x007f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(OutputStream outputStream, String str, ArrayList<String> arrayList) {
        int i2;
        boolean zBooleanValue;
        boolean zBooleanValue2;
        int iB;
        boolean z2 = arrayList == null;
        boolean zF = e.F();
        synchronized (k) {
            int i3 = 0;
            for (String str2 : l) {
                try {
                    Object[] objArr = k.get(str2);
                    if (arrayList == null) {
                        if (LogType.isForJava(((Integer) objArr[0]).intValue())) {
                            if (!((Boolean) objArr[3]).booleanValue()) {
                                try {
                                    outputStream.write((str2 + "\n").getBytes(str));
                                } catch (Throwable th) {
                                    th = th;
                                    e.a(th, outputStream);
                                }
                            }
                            i2 = i3 <= 153600 ? 153600 : i3;
                            try {
                                int iMin = Math.min(20480, 153600 - i2);
                                zBooleanValue = ((Boolean) objArr[2]).booleanValue();
                                String str3 = (String) objArr[1];
                                zBooleanValue2 = ((Boolean) objArr[4]).booleanValue();
                                if (zF || str3.startsWith(SysPerformanceCollector.APP_CPU_INFO_ROOT_PATH)) {
                                    if (!zBooleanValue) {
                                        iB = e.a(outputStream, str3, iMin);
                                    } else {
                                        iB = e.b(outputStream, str3, iMin);
                                    }
                                    i2 += iB;
                                } else {
                                    e.a(outputStream, "FILE", str3, iMin, zBooleanValue, zBooleanValue2);
                                }
                                i3 = i2;
                                if (!zBooleanValue2 && z2 && !zF) {
                                    File file = new File(str3);
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                i3 = i2;
                                e.a(th, outputStream);
                            }
                        }
                    } else if (a(arrayList, str2)) {
                        if (!((Boolean) objArr[3]).booleanValue()) {
                        }
                        if (i3 <= 153600) {
                        }
                        int iMin2 = Math.min(20480, 153600 - i2);
                        zBooleanValue = ((Boolean) objArr[2]).booleanValue();
                        String str32 = (String) objArr[1];
                        zBooleanValue2 = ((Boolean) objArr[4]).booleanValue();
                        if (zF) {
                            if (!zBooleanValue) {
                            }
                            i2 += iB;
                            i3 = i2;
                            if (!zBooleanValue2) {
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            if (arrayList != null && zF) {
                for (String str4 : arrayList) {
                    if (!a(l, str4)) {
                        e.a(outputStream, "CUSTOMDUMPFILE", str4);
                    }
                }
            }
        }
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Object[]> map = A;
        synchronized (map) {
            Object[] objArr = map.get(str);
            int iIntValue = ((Integer) objArr[0]).intValue();
            List list = (List) objArr[2];
            sb.append(String.format(Locale.US, "%s (%d/%d)\n", str, Integer.valueOf(list.size()), Integer.valueOf(iIntValue)));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static String a(String str) {
        HashMap<String, Object[]> map = k;
        synchronized (map) {
            Object[] objArr = map.get(str);
            if (objArr == null) {
                return null;
            }
            int i2 = 1;
            String str2 = (String) objArr[1];
            boolean zBooleanValue = ((Boolean) objArr[2]).booleanValue();
            boolean zBooleanValue2 = ((Boolean) objArr[3]).booleanValue();
            Locale locale = Locale.US;
            Object[] objArr2 = new Object[4];
            objArr2[0] = str2;
            objArr2[1] = "`";
            objArr2[2] = Integer.valueOf(zBooleanValue ? 1 : 0);
            if (!zBooleanValue2) {
                i2 = 0;
            }
            objArr2[3] = Integer.valueOf(i2);
            return String.format(locale, "%s%s%d%d", objArr2);
        }
    }

    private static boolean a(List<String> list, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005d A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:7:0x000d, B:9:0x0013, B:11:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:32:0x005d, B:23:0x0047, B:26:0x004c, B:30:0x0057, B:27:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:52:0x009a, B:54:0x00a1, B:56:0x00a9, B:58:0x00af, B:60:0x00b3, B:61:0x00b8, B:63:0x00be, B:65:0x00c6, B:67:0x00cc, B:69:0x00d0, B:70:0x00d5, B:72:0x00db, B:79:0x00ed, B:81:0x00ef, B:83:0x00f3, B:85:0x00f9, B:87:0x0105, B:89:0x010b, B:91:0x0112, B:92:0x0117, B:94:0x011d, B:96:0x0123, B:97:0x0128, B:99:0x012e, B:101:0x0134, B:103:0x013c, B:104:0x0158, B:76:0x00e5, B:43:0x007c, B:46:0x0081, B:47:0x008b, B:50:0x0092), top: B:109:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009a A[Catch: all -> 0x015a, TryCatch #0 {, blocks: (B:7:0x000d, B:9:0x0013, B:11:0x0027, B:14:0x002b, B:16:0x0035, B:18:0x003b, B:32:0x005d, B:23:0x0047, B:26:0x004c, B:30:0x0057, B:27:0x0050, B:33:0x0063, B:35:0x006a, B:37:0x0070, B:52:0x009a, B:54:0x00a1, B:56:0x00a9, B:58:0x00af, B:60:0x00b3, B:61:0x00b8, B:63:0x00be, B:65:0x00c6, B:67:0x00cc, B:69:0x00d0, B:70:0x00d5, B:72:0x00db, B:79:0x00ed, B:81:0x00ef, B:83:0x00f3, B:85:0x00f9, B:87:0x0105, B:89:0x010b, B:91:0x0112, B:92:0x0117, B:94:0x011d, B:96:0x0123, B:97:0x0128, B:99:0x012e, B:101:0x0134, B:103:0x013c, B:104:0x0158, B:76:0x00e5, B:43:0x007c, B:46:0x0081, B:47:0x008b, B:50:0x0092), top: B:109:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(String str, int i2, Callable<String> callable, long j2, int i3) {
        int iRemoveType;
        int iIntValue;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (str == null) {
            return 0;
        }
        HashMap<String, Object[]> map = q;
        synchronized (map) {
            if (map.containsKey(str)) {
                iIntValue = ((Integer) map.get(str)[0]).intValue();
                iRemoveType = LogType.addType(iIntValue, i2);
                if (iIntValue == iRemoveType) {
                    return iIntValue;
                }
            } else {
                iRemoveType = i2;
                iIntValue = 0;
            }
            if (LogType.isForJava(iRemoveType) && !LogType.isForJava(iIntValue)) {
                int i4 = s;
                if (i4 < 8) {
                    if (j2 != 0) {
                        int i5 = w;
                        if (i5 < 6) {
                            w = i5 + 1;
                            s = i4 + 1;
                        }
                    } else {
                        z8 = i4 - w >= 6;
                        s = i4 + 1;
                    }
                    if (z8) {
                        iRemoveType = LogType.removeType(iRemoveType, 16);
                    }
                } else {
                    if (z8) {
                    }
                }
            }
            if (!LogType.isForNative(iRemoveType) || LogType.isForNative(iIntValue)) {
                z2 = false;
                z3 = false;
            } else {
                int i6 = t;
                if (i6 < 6) {
                    if (j2 != 0) {
                        int i7 = x;
                        if (i7 < 4) {
                            x = i7 + 1;
                            t = i6 + 1;
                            z7 = false;
                            z2 = true;
                            z3 = true;
                            if (z7) {
                                iRemoveType = LogType.removeType(iRemoveType, 1);
                            }
                        }
                    } else if (i6 - x < 4) {
                        t = i6 + 1;
                        z7 = false;
                        z2 = true;
                        z3 = false;
                        if (z7) {
                        }
                    }
                    z7 = true;
                    z2 = false;
                    z3 = false;
                    if (z7) {
                    }
                } else {
                    z7 = true;
                    z2 = false;
                    z3 = false;
                    if (z7) {
                    }
                }
            }
            if (!LogType.isForANR(iRemoveType) || LogType.isForANR(iIntValue)) {
                z4 = false;
            } else {
                int i8 = v;
                if (i8 >= 6) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                    z4 = false;
                } else {
                    v = i8 + 1;
                    z4 = true;
                }
            }
            if (!LogType.isForUnexp(iRemoveType) || LogType.isForUnexp(iIntValue)) {
                z5 = false;
            } else {
                int i9 = u;
                if (i9 >= 6) {
                    iRemoveType = LogType.removeType(iRemoveType, 256);
                    z5 = false;
                } else {
                    u = i9 + 1;
                    z5 = true;
                }
            }
            if ((1048849 & iRemoveType) == 0) {
                z6 = false;
            } else {
                if (iIntValue == 0) {
                    r.add(str);
                }
                z6 = true;
            }
            if (!z6) {
                return iRemoveType;
            }
            if (b.d && (1048833 & i2) != 0) {
                int iNativeAddCallbackInfo = JNIBridge.nativeAddCallbackInfo(str, i2, j2, i3);
                if (!LogType.isForNative(iNativeAddCallbackInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                    if (z2) {
                        t--;
                    }
                    if (z3) {
                        x--;
                    }
                }
                if (!LogType.isForANR(iNativeAddCallbackInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                    if (z4) {
                        v--;
                    }
                }
                if (!LogType.isForUnexp(iNativeAddCallbackInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 256);
                    if (z5) {
                        u--;
                    }
                }
            }
            map.put(str, new Object[]{Integer.valueOf(iRemoveType), callable, Long.valueOf(j2), Integer.valueOf(i3)});
            return iRemoveType;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:7|(2:50|8)|(3:57|10|(4:55|12|63|59)(4:54|16|(1:18)(1:19)|(1:24)(1:23)))(3:53|13|(4:56|15|60|59)(5:58|16|(0)(0)|(1:21)|24))|48|28|61|59|5) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a3, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a4, code lost:
    
        com.uc.crashsdk.e.a(r2, r10);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: all -> 0x008d, TryCatch #2 {all -> 0x008d, blocks: (B:8:0x0015, B:10:0x0028, B:16:0x0036, B:18:0x005d, B:21:0x0075, B:23:0x007b, B:24:0x0083, B:19:0x006b, B:13:0x002f), top: B:50:0x0015, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[Catch: all -> 0x008d, TryCatch #2 {all -> 0x008d, blocks: (B:8:0x0015, B:10:0x0028, B:16:0x0036, B:18:0x005d, B:21:0x0075, B:23:0x007b, B:24:0x0083, B:19:0x006b, B:13:0x002f), top: B:50:0x0015, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(OutputStream outputStream, String str, String str2, ArrayList<String> arrayList) {
        Object[] objArr;
        int iIntValue;
        long jLongValue;
        String string;
        synchronized (q) {
            for (String str3 : r) {
                try {
                    objArr = q.get(str3);
                    iIntValue = ((Integer) objArr[0]).intValue();
                } catch (Throwable th) {
                    e.a(th, outputStream);
                }
                if (arrayList == null) {
                    if (LogType.isForJava(iIntValue)) {
                        outputStream.write((str3 + "\n").getBytes(str));
                        jLongValue = ((Long) objArr[2]).longValue();
                        if (jLongValue == 0) {
                            string = JNIBridge.nativeGetCallbackInfo(str3, jLongValue, ((Integer) objArr[3]).intValue(), false);
                        } else {
                            string = b(str3, false).toString();
                        }
                        if (string == null && string.length() > 0) {
                            outputStream.write(string.getBytes(str));
                        } else {
                            outputStream.write("(data is null)\n".getBytes(str));
                        }
                    }
                } else if (a(arrayList, str3)) {
                    outputStream.write((str3 + "\n").getBytes(str));
                    jLongValue = ((Long) objArr[2]).longValue();
                    if (jLongValue == 0) {
                    }
                    if (string == null) {
                    }
                    outputStream.write("(data is null)\n".getBytes(str));
                }
                outputStream.write("\n".getBytes(str));
                outputStream.write(str2.getBytes(str));
            }
            if (arrayList != null && e.F()) {
                for (String str4 : arrayList) {
                    if (!a(r, str4)) {
                        e.a(outputStream, "CUSTOMCALLBACKINFO", str4);
                    }
                }
            }
        }
    }

    public static String a(String str, boolean z2) {
        String string;
        HashMap<String, Object[]> map = q;
        synchronized (map) {
            Object[] objArr = map.get(str);
            long jLongValue = ((Long) objArr[2]).longValue();
            if (jLongValue != 0) {
                string = JNIBridge.nativeGetCallbackInfo(str, jLongValue, ((Integer) objArr[3]).intValue(), z2);
            } else {
                string = b(str, z2).toString();
            }
        }
        return string;
    }

    private static boolean a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        SparseArray<Object[]> sparseArray = y;
        synchronized (sparseArray) {
            int id = (int) thread.getId();
            if (sparseArray.get(id) == null) {
                z.add(Integer.valueOf(id));
            }
            sparseArray.put(id, new Object[]{new WeakReference(thread), str});
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ca A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:34:0x00c3, B:36:0x00ca, B:37:0x00d3, B:39:0x00d8, B:41:0x00dc, B:42:0x00e5), top: B:55:0x00c3, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d8 A[Catch: all -> 0x0100, TryCatch #0 {all -> 0x0100, blocks: (B:34:0x00c3, B:36:0x00ca, B:37:0x00d3, B:39:0x00d8, B:41:0x00dc, B:42:0x00e5), top: B:55:0x00c3, outer: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(OutputStream outputStream, String str, String str2) {
        Thread thread;
        Throwable th;
        String str3;
        StackTraceElement[] stackTrace;
        int length;
        int i2;
        Object[] objArr;
        synchronized (y) {
            Thread threadCurrentThread = Thread.currentThread();
            Iterator<Integer> it = z.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                try {
                    objArr = y.get(iIntValue);
                } catch (Throwable th2) {
                    thread = null;
                    th = th2;
                    str3 = null;
                }
                if (objArr != null) {
                    thread = (Thread) ((WeakReference) objArr[0]).get();
                    try {
                        str3 = (String) objArr[1];
                    } catch (Throwable th3) {
                        str3 = null;
                        th = th3;
                    }
                    if (thread == null) {
                        try {
                            com.uc.crashsdk.a.a.b("Thread (" + str3 + ", " + iIntValue + ") has exited!");
                        } catch (Throwable th4) {
                            th = th4;
                            e.a(th, outputStream);
                            try {
                                Locale locale = Locale.US;
                                outputStream.write(String.format(locale, "Thread Name: '%s'\n", str3).getBytes(str));
                                outputStream.write(String.format(locale, "\"%s\"%s prio=%d tid=%d %s\n", thread.getName(), !thread.isDaemon() ? " daemon" : "", Integer.valueOf(thread.getPriority()), Integer.valueOf(iIntValue), thread.getState().toString()).getBytes(str));
                            } catch (Throwable th5) {
                                e.a(th5, outputStream);
                            }
                            try {
                                stackTrace = thread.getStackTrace();
                                if (stackTrace.length == 0) {
                                }
                                length = stackTrace.length;
                                i2 = 0;
                                boolean z2 = true;
                                while (i2 < length) {
                                }
                            } catch (Throwable th6) {
                                e.a(th6, outputStream);
                            }
                            try {
                                outputStream.write("\n".getBytes(str));
                                outputStream.write(str2.getBytes(str));
                            } catch (Throwable th7) {
                                e.a(th7, outputStream);
                            }
                        }
                    } else if (threadCurrentThread != thread) {
                        Locale locale2 = Locale.US;
                        outputStream.write(String.format(locale2, "Thread Name: '%s'\n", str3).getBytes(str));
                        outputStream.write(String.format(locale2, "\"%s\"%s prio=%d tid=%d %s\n", thread.getName(), !thread.isDaemon() ? " daemon" : "", Integer.valueOf(thread.getPriority()), Integer.valueOf(iIntValue), thread.getState().toString()).getBytes(str));
                        stackTrace = thread.getStackTrace();
                        if (stackTrace.length == 0) {
                            outputStream.write("  (no stack frames)".getBytes(str));
                        }
                        length = stackTrace.length;
                        i2 = 0;
                        boolean z22 = true;
                        while (i2 < length) {
                            StackTraceElement stackTraceElement = stackTrace[i2];
                            if (!z22) {
                                outputStream.write("\n".getBytes(str));
                            }
                            outputStream.write(String.format(Locale.US, "  at %s", stackTraceElement.toString()).getBytes(str));
                            i2++;
                            z22 = false;
                        }
                        outputStream.write("\n".getBytes(str));
                        outputStream.write(str2.getBytes(str));
                    }
                }
            }
        }
    }

    public static int a(String str, int i2, int i3) {
        int iRemoveType;
        int iIntValue;
        boolean z2;
        if (str == null || i2 <= 0) {
            return 0;
        }
        if (i2 > 1500) {
            com.uc.crashsdk.a.a.a("crashsdk", "createCachedInfo: capacity is too large!", null);
            return 0;
        }
        HashMap<String, Object[]> map = A;
        synchronized (map) {
            if (map.containsKey(str)) {
                iIntValue = ((Integer) map.get(str)[1]).intValue();
                iRemoveType = LogType.addType(iIntValue, i3);
            } else {
                iRemoveType = i3;
                iIntValue = 0;
            }
            if (LogType.isForJava(iRemoveType) && !LogType.isForJava(iIntValue)) {
                int i4 = C;
                if (i4 >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 16);
                } else {
                    C = i4 + 1;
                }
            }
            if (LogType.isForNative(iRemoveType) && !LogType.isForNative(iIntValue)) {
                int i5 = D;
                if (i5 >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                } else {
                    D = i5 + 1;
                }
            }
            if (LogType.isForANR(iRemoveType) && !LogType.isForANR(iIntValue)) {
                int i6 = E;
                if (i6 >= 8) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                } else {
                    E = i6 + 1;
                }
            }
            if ((1048849 & iRemoveType) == 0) {
                z2 = false;
            } else {
                if (iIntValue == 0) {
                    B.add(str);
                }
                z2 = true;
            }
            if (!z2) {
                return iRemoveType;
            }
            if (b.d && (i3 & 1048577) != 0) {
                int iNativeCreateCachedInfo = JNIBridge.nativeCreateCachedInfo(str, i2, iRemoveType);
                if (!LogType.isForNative(iNativeCreateCachedInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1);
                }
                if (!LogType.isForANR(iNativeCreateCachedInfo)) {
                    iRemoveType = LogType.removeType(iRemoveType, 1048576);
                }
            }
            map.put(str, new Object[]{Integer.valueOf(i2), Integer.valueOf(iRemoveType), new ArrayList()});
            return iRemoveType;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static int a(int i2, String str) {
        ?? r0;
        if (com.uc.crashsdk.a.g.a(str)) {
            str = Thread.currentThread().getName();
        }
        if (!LogType.isForNative(i2) && !LogType.isForANR(i2)) {
            r0 = 0;
        } else if (b.d) {
            synchronized (y) {
                JNIBridge.nativeCmd(4, i2, str, null);
            }
            boolean zIsForNative = LogType.isForNative(i2);
            r0 = zIsForNative;
            if (LogType.isForANR(i2)) {
                r0 = (zIsForNative ? 1 : 0) | 1048576;
            }
        } else {
            com.uc.crashsdk.a.a.a("crashsdk", "crashsdk so has not loaded!", null);
            r0 = 0;
        }
        if (!LogType.isForJava(i2)) {
            return r0;
        }
        a(str, Thread.currentThread());
        return r0 | 16;
    }

    public static boolean a(boolean z2) {
        int iH;
        if (!b.c) {
            com.uc.crashsdk.a.a.a("crashsdk", "Unexp log not enabled, skip update unexp info!");
            return false;
        }
        if (e.F() || b.L()) {
            return false;
        }
        if (z2) {
            com.uc.crashsdk.a.f.a(F);
            iH = 0;
        } else {
            if (!b.B()) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stop update unexp info in background!");
                return false;
            }
            if (g.H() <= 0) {
                return false;
            }
            if (com.uc.crashsdk.a.f.b(F)) {
                return true;
            }
            iH = g.H() * 1000;
        }
        com.uc.crashsdk.a.f.a(0, F, iH);
        return true;
    }

    public static void a(int i2) {
        if (i2 == 201) {
            com.uc.crashsdk.a.a.a("crashsdk", "Begin update info ...");
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (b.d && c) {
                JNIBridge.nativeCmd(11, g.H(), String.valueOf(g.I()), null);
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Update info took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
            a(false);
            return;
        }
        if (i2 != 202) {
            if (!d) {
                throw new AssertionError();
            }
            return;
        }
        p();
        Locale locale = Locale.US;
        String str = String.format(locale, "%s/%s/%s", g.U(), g.V(), g.W());
        g = m();
        if (b.d) {
            JNIBridge.set(128, g);
        }
        boolean z2 = !str.equals(g);
        if (z2) {
            com.uc.crashsdk.a.b.a(b.m(), str);
        }
        if (z2 && g.v()) {
            com.uc.crashsdk.a.a.a("crashsdk", String.format(locale, "Is new version ('%s' -> '%s'), deleting old stats data!", g, str));
            b.v();
        }
    }
}
