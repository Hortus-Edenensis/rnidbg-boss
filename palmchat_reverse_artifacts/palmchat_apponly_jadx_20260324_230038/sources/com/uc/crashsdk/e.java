package com.uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Debug;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import com.amap.api.services.core.AMapException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.utils.FileUtil;
import com.kwad.sdk.api.model.AdnName;
import com.oplus.tblplayer.Constants;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.bytertc.engine.utils.LogUtil;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.LogType;
import com.zm.fda.Z2500.Z200O.O022Z;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class e implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f10820a = true;
    private static long b;
    private static String i;
    private final List<FileInputStream> e = new ArrayList();
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static boolean d = false;
    private static long f = 0;
    private static long g = -1;
    private static boolean h = true;
    private static String j = "";
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static final Object n = new Object();
    private static final ConditionVariable o = new ConditionVariable();
    private static final Object p = new Object();
    private static final Object q = new Object();
    private static final Object r = new Object();
    private static final ArrayList<String> s = new ArrayList<>();
    private static int t = 0;
    private static String u = null;
    private static boolean v = false;
    private static String w = null;
    private static String x = null;
    private static final Object y = new Object();
    private static final Object z = new Object();
    private static Map<String, Integer> A = null;
    private static String B = null;
    private static int C = -1;
    private static int D = -1;
    private static int E = -1;
    private static int F = -1;
    private static int G = -1;
    private static int H = -1;
    private static int I = -1;
    private static String J = Constants.STRING_VALUE_UNSET;
    private static boolean K = false;
    private static boolean L = false;
    private static int M = 0;
    private static int N = 0;
    private static boolean O = false;
    private static com.uc.crashsdk.a.e P = new com.uc.crashsdk.a.e(405);
    private static c Q = new c(0);
    private static boolean R = false;
    private static final com.uc.crashsdk.a.e S = new com.uc.crashsdk.a.e(412);
    private static Thread.UncaughtExceptionHandler T = null;
    private static Throwable U = null;
    private static boolean V = false;
    private static boolean W = false;
    private static Runnable X = null;
    private static final Object Y = new Object();
    private static int Z = 101;
    private static Runnable aa = new com.uc.crashsdk.a.e(407);
    private static final Object ab = new Object();
    private static volatile boolean ac = false;
    private static Object ad = new Object();
    private static ParcelFileDescriptor ae = null;
    private static boolean af = false;
    private static boolean ag = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Comparator<File> {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            return file3.lastModified() < file4.lastModified() ? -1 : 0;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.intent.action.BATTERY_CHANGED".equals(action)) {
                if ("android.intent.action.BATTERY_LOW".equals(action) || "android.intent.action.BATTERY_OKAY".equals(action)) {
                    boolean unused = e.K = "android.intent.action.BATTERY_LOW".equals(action);
                    e.K();
                    return;
                } else {
                    if (O022Z.h.equals(action)) {
                        try {
                            e.d(context);
                            return;
                        } catch (Throwable th) {
                            com.uc.crashsdk.a.g.a(th);
                            return;
                        }
                    }
                    return;
                }
            }
            int unused2 = e.C = intent.getIntExtra("level", -1);
            int unused3 = e.D = intent.getIntExtra("scale", -1);
            int unused4 = e.E = intent.getIntExtra("voltage", -1);
            int unused5 = e.F = intent.getIntExtra("health", -1);
            int unused6 = e.G = intent.getIntExtra("plugged", -1);
            int unused7 = e.H = intent.getIntExtra("status", -1);
            int unused8 = e.I = intent.getIntExtra("temperature", -1);
            String unused9 = e.J = intent.getStringExtra("technology");
            if (e.J() >= 2) {
                e.K();
                e.L();
            }
        }

        public /* synthetic */ c(byte b) {
            this();
        }
    }

    public e() {
        try {
            M();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void A() {
        if (g.r()) {
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(403), 10000L);
        }
    }

    public static void B() {
        if (ac || com.uc.crashsdk.b.L()) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(408), 1000L);
    }

    public static void C() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(409), 7000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void D() {
        int iO = g.O();
        boolean z2 = false;
        boolean z3 = true;
        if (iO == 0 || iO == 3 || iO == 4) {
            if (Build.VERSION.SDK_INT <= 25) {
                boolean z4 = iO != 0;
                if (iO == 3) {
                    z4 = System.currentTimeMillis() % 10 == 0;
                }
                if (iO != 4) {
                    z3 = z4;
                } else if (System.currentTimeMillis() % 3 != 0) {
                    z3 = false;
                }
            }
        } else if (iO == 1) {
        }
        if (!z3) {
            com.uc.crashsdk.a.a.a("crashsdk", "SIG 3 is disabled by settings");
        }
        boolean zL = com.uc.crashsdk.b.L();
        if (Looper.getMainLooper() == Looper.myLooper() || !z3) {
            z2 = z3;
        } else {
            com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(413));
        }
        JNIBridge.nativeCmd(7, zL ? 1L : 0L, null, null);
        if (z2) {
            JNIBridge.cmd(8);
        }
    }

    public static ParcelFileDescriptor E() {
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        synchronized (ad) {
            ParcelFileDescriptor parcelFileDescriptor = ae;
            if (parcelFileDescriptor != null) {
                return parcelFileDescriptor;
            }
            int iCmd = (int) JNIBridge.cmd(14);
            if (iCmd == -1) {
                return null;
            }
            ParcelFileDescriptor parcelFileDescriptorAdoptFd = ParcelFileDescriptor.adoptFd(iCmd);
            ae = parcelFileDescriptorAdoptFd;
            af = true;
            return parcelFileDescriptorAdoptFd;
        }
    }

    public static boolean F() {
        return ag;
    }

    public static void G() {
        String strY = g.Y();
        File file = new File(strY);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                com.uc.crashsdk.a.a.b("Ucebu can not list folder: " + strY);
                return;
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isFile() && file2.getName().contains("ucebu")) {
                    a(false, false);
                    return;
                }
            }
        }
    }

    public static /* synthetic */ int J() {
        int i2 = M + 1;
        M = i2;
        return i2;
    }

    public static /* synthetic */ void K() {
        StringBuilder sbY;
        if (com.uc.crashsdk.b.d && (sbY = Y()) != null) {
            JNIBridge.set(125, sbY.toString());
        }
        L = true;
        Z();
    }

    public static /* synthetic */ int L() {
        M = 0;
        return 0;
    }

    private void M() {
        int iJ = g.J();
        for (int i2 = 0; i2 < iJ; i2++) {
            try {
                this.e.add(new FileInputStream("/dev/null"));
            } catch (Exception e) {
                com.uc.crashsdk.a.g.a(e);
                return;
            }
        }
    }

    private void N() {
        Iterator<FileInputStream> it = this.e.iterator();
        while (it.hasNext()) {
            com.uc.crashsdk.a.g.a(it.next());
        }
        this.e.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean O() {
        if (g.Q()) {
            return true;
        }
        return a();
    }

    private static String P() {
        return g.e() + "_";
    }

    private static String Q() {
        return com.uc.crashsdk.b.B() ? "fg" : OapsKey.KEY_BG;
    }

    private static byte[] R() {
        byte[] bArr = null;
        int i2 = 1024;
        while (bArr == null && i2 > 0) {
            try {
                bArr = new byte[i2];
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 16) {
                    return bArr;
                }
            }
        }
        return bArr;
    }

    private static String S() {
        return (!com.uc.crashsdk.b.F() || d) ? LogType.JAVA_TYPE : "ucebujava";
    }

    private static void T() {
        String strTrim;
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        String strTrim2 = "-";
        try {
            strTrim = Build.HARDWARE;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            strTrim = "-";
        }
        try {
            fileReader = new FileReader(new File("/proc/cpuinfo"));
            try {
                bufferedReader = new BufferedReader(fileReader, 512);
                int i2 = 0;
                do {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.startsWith("Hardware")) {
                            strTrim = line.substring(line.indexOf(":") + 1).trim();
                        } else if (line.startsWith("Processor")) {
                            strTrim2 = line.substring(line.indexOf(":") + 1).trim();
                        }
                        i2++;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            com.uc.crashsdk.a.g.a(th);
                            com.uc.crashsdk.a.g.a(fileReader);
                        } catch (Throwable th4) {
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            throw th4;
                        }
                    }
                } while (i2 < 2);
                com.uc.crashsdk.a.g.a(fileReader);
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } catch (Throwable th6) {
            bufferedReader = null;
            th = th6;
            fileReader = null;
        }
        com.uc.crashsdk.a.g.a(bufferedReader);
        k = strTrim;
        l = strTrim2;
    }

    private static String U() {
        return g.X() + "bytes";
    }

    private static boolean V() {
        return Build.VERSION.SDK_INT < 29;
    }

    private static void W() {
        if (O || com.uc.crashsdk.b.F() || com.uc.crashsdk.b.L()) {
            return;
        }
        JNIBridge.cmd(18);
    }

    private static void X() {
        com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(414), 1000L);
    }

    private static StringBuilder Y() {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ");
            sb.append(C);
            sb.append("\n");
            sb.append("scale: ");
            sb.append(D);
            sb.append("\n");
            switch (F) {
                case 1:
                    str = " (Unknown)";
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append("health: ");
            sb.append(F);
            sb.append(str);
            sb.append("\n");
            int i2 = G;
            String str2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 4 ? " (?)" : " (Wireless)" : " (USB port)" : " (AC charger)" : " (None)";
            sb.append("pluged: ");
            sb.append(G);
            sb.append(str2);
            sb.append("\n");
            int i3 = H;
            String str3 = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? " (?)" : " (Full)" : " (Not charging)" : " (Discharging)" : " (Charging)" : " (Unknown)";
            sb.append("status: ");
            sb.append(H);
            sb.append(str3);
            sb.append("\n");
            sb.append("voltage: ");
            sb.append(E);
            sb.append("\n");
            sb.append("temperature: ");
            sb.append(I);
            sb.append("\n");
            sb.append("technology: ");
            sb.append(J);
            sb.append("\n");
            sb.append("battery low: ");
            sb.append(K);
            sb.append("\n");
            return sb;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    private static void Z() {
        if (com.uc.crashsdk.b.c && L && com.uc.crashsdk.a.c) {
            L = false;
            if (com.uc.crashsdk.a.f.b(P)) {
                return;
            }
            com.uc.crashsdk.a.f.a(0, P, 2000L);
        }
    }

    public static boolean a() {
        if (f == 0) {
            f = 2L;
            if (h(com.uc.crashsdk.b.b(LogUtil.DIR_TAIL)) == 1) {
                f = 1L;
            }
        }
        return f == 1;
    }

    private static boolean aa() {
        return com.uc.crashsdk.b.d && JNIBridge.nativeIsCrashing();
    }

    private static void ab() {
        String strZ = g.Z();
        File file = new File(strZ);
        if (file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length > 150) {
                    Arrays.sort(fileArrListFiles, new b((byte) 0));
                    int length = fileArrListFiles.length - 150;
                    int i2 = length < 0 ? 0 : length;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (i3 < fileArrListFiles.length) {
                        File file2 = fileArrListFiles[i3];
                        boolean z2 = i3 < i2;
                        if (!z2 && jCurrentTimeMillis - file2.lastModified() >= 432000000) {
                            z2 = true;
                        }
                        if (!z2) {
                            break;
                        }
                        try {
                            file2.delete();
                            i4++;
                            i5 = 0;
                        } catch (Throwable th) {
                            i5++;
                            com.uc.crashsdk.a.g.a(th);
                        }
                        if (i5 >= 3) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    com.uc.crashsdk.a.a.a("Removed " + i4 + " logs in " + strZ);
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    public static long b() {
        if (g == -1) {
            g = h(com.uc.crashsdk.b.b("local"));
        }
        return g;
    }

    private static String j(String str) {
        if (str == null) {
            str = String.valueOf(System.currentTimeMillis()) + new Random().nextInt(65536);
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", P(), g.U(), g.W(), i(Build.MODEL), i(Build.VERSION.RELEASE), str);
    }

    private static String k(String str) {
        return String.format(Locale.US, "%s%s_%s_%s.log", d(), n(), Q(), str);
    }

    private static String l(String str) {
        if (!com.uc.crashsdk.a.g.b(str)) {
            return "";
        }
        int iIndexOf = str.indexOf(0);
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        return str.trim();
    }

    private static String m(String str) {
        String strA = com.uc.crashsdk.a.b.a(str, g.x(), g.w());
        if (!str.equals(strA)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return strA;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean[] n(String str) {
        boolean zW = g.w();
        boolean zY = g.y();
        if (zW || zY) {
            if (str.endsWith(".tmp") || str.contains(".ec")) {
                zW = false;
                zY = false;
            } else {
                int iLastIndexOf = str.lastIndexOf(File.separatorChar);
                if (iLastIndexOf < 0) {
                    iLastIndexOf = 0;
                }
                int i2 = 0;
                do {
                    iLastIndexOf = str.indexOf(95, iLastIndexOf);
                    if (iLastIndexOf >= 0) {
                        i2++;
                        iLastIndexOf++;
                    }
                } while (iLastIndexOf >= 0);
                if (i2 == 8) {
                    String strX = g.x();
                    if (str.endsWith(".log")) {
                        if (com.uc.crashsdk.a.g.a(strX) || str.indexOf(".log", str.lastIndexOf(95)) != str.lastIndexOf(".log")) {
                        }
                    } else if (com.uc.crashsdk.a.g.a(strX) || !str.endsWith(strX)) {
                    }
                    zW = false;
                }
            }
        }
        return new boolean[]{zW, zY};
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean o(String str) {
        boolean z2;
        boolean z3;
        FileWriter fileWriter;
        int i2;
        synchronized (r) {
            File file = new File(g.X() + "customlog");
            String strA = com.uc.crashsdk.a.g.a(file, 1024, false);
            long jCurrentTimeMillis = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            if (strA != null) {
                stringBuffer.append(strA);
                Matcher matcher = Pattern.compile("([^\\n\\r\\t\\s]+) (\\d+) (\\d+)").matcher(stringBuffer);
                for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
                    if (str.equals(matcher.group(1))) {
                        long j2 = Long.parseLong(matcher.group(2));
                        if (jCurrentTimeMillis - j2 < 86400000) {
                            try {
                                i2 = Integer.parseInt(matcher.group(3));
                            } catch (Exception e) {
                                com.uc.crashsdk.a.g.a(e);
                                i2 = 0;
                            }
                            int iG = g.G();
                            z3 = iG < 0 && i2 >= iG;
                            stringBuffer.replace(matcher.start(), matcher.end(), String.format(Locale.US, "%s %d %d", str, Long.valueOf(j2), Integer.valueOf(i2 + 1)));
                            z2 = true;
                        } else {
                            j2 = jCurrentTimeMillis;
                        }
                        i2 = 0;
                        int iG2 = g.G();
                        if (iG2 < 0) {
                            stringBuffer.replace(matcher.start(), matcher.end(), String.format(Locale.US, "%s %d %d", str, Long.valueOf(j2), Integer.valueOf(i2 + 1)));
                            z2 = true;
                        }
                    }
                }
                z2 = false;
                z3 = false;
            } else {
                z2 = false;
                z3 = false;
            }
            if (!z2) {
                stringBuffer.append(String.format(Locale.US, "%s %d 1\n", str, Long.valueOf(jCurrentTimeMillis)));
            }
            FileWriter fileWriter2 = null;
            try {
                try {
                    fileWriter = new FileWriter(file);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                String string = stringBuffer.toString();
                fileWriter.write(string, 0, string.length());
                com.uc.crashsdk.a.g.a(fileWriter);
            } catch (Exception e3) {
                e = e3;
                fileWriter2 = fileWriter;
                com.uc.crashsdk.a.g.a(e);
                com.uc.crashsdk.a.g.a(fileWriter2);
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                com.uc.crashsdk.a.g.a(fileWriter2);
                throw th;
            }
        }
        return z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ae A[Catch: all -> 0x0108, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x0018, B:9:0x0023, B:10:0x002d, B:38:0x00ae, B:50:0x00d4, B:57:0x00ef, B:53:0x00df, B:64:0x00fc, B:67:0x0106, B:11:0x0033, B:13:0x003b, B:14:0x0044, B:16:0x004c, B:18:0x0054, B:20:0x005c, B:26:0x006a, B:28:0x0074, B:30:0x0081, B:32:0x008b, B:33:0x0096, B:35:0x00a0), top: B:72:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean p(String str) {
        boolean z2;
        int iIntValue;
        Integer num;
        synchronized (z) {
            z2 = false;
            if (A == null) {
                A = q(com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.l(), "all:1", false));
            }
            if (A.containsKey("all")) {
                num = A.get("all");
            } else if (A.containsKey(str)) {
                num = A.get(str);
            } else {
                boolean z3 = LogType.JAVA_TYPE.equals(str) || LogType.NATIVE_TYPE.equals(str) || LogType.ANR_TYPE.equals(str) || LogType.UNEXP_TYPE.equals(str);
                if (z3 && A.containsKey("crash")) {
                    num = A.get("crash");
                } else if (!z3 && A.containsKey("nocrash")) {
                    num = A.get("nocrash");
                } else if (A.containsKey(AdnName.OTHER)) {
                    num = A.get(AdnName.OTHER);
                } else {
                    iIntValue = 1;
                    if (iIntValue != 0) {
                        long j2 = iIntValue;
                        if (j2 < 0) {
                            long j3 = j2 == -2 ? 7L : j2 == -3 ? 15L : j2 == -4 ? 60L : 30L;
                            long jB = com.uc.crashsdk.a.b();
                            long jCurrentTimeMillis = jB == 0 ? -1L : (System.currentTimeMillis() - jB) / 86400000;
                            j2 = jCurrentTimeMillis <= j3 ? 1L : jCurrentTimeMillis - j3;
                        }
                        if (j2 == 1 || j2 <= 0 || System.currentTimeMillis() % j2 == 0) {
                            z2 = true;
                        }
                    }
                }
            }
            iIntValue = num.intValue();
            if (iIntValue != 0) {
            }
        }
        return z2;
    }

    private static Map<String, Integer> q(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("\\|", 30)) {
            String[] strArrSplit = str2.split(":", 3);
            if (strArrSplit.length == 2) {
                String strTrim = strArrSplit[0].trim();
                if (!com.uc.crashsdk.a.g.a(strTrim)) {
                    int i2 = 1;
                    try {
                        i2 = Integer.parseInt(strArrSplit[1].trim(), 10);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                    map.put(strTrim, Integer.valueOf(i2));
                }
            }
        }
        return map;
    }

    private static void r(String str) {
        if (g.r()) {
            try {
                ab();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            if (str == null || "".equals(str)) {
                return;
            }
            try {
                File file = new File(g.Z());
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.uc.crashsdk.a.a.a("crashsdk", "copy log to: " + file);
                com.uc.crashsdk.a.g.a(new File(str), file);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    private static String s(String str) {
        return String.format("$^%s^$", str);
    }

    public static void t() {
        Thread.setDefaultUncaughtExceptionHandler(T);
    }

    public static boolean u() {
        return c.get() || aa();
    }

    public static Throwable v() {
        return U;
    }

    public static int w() {
        if (com.uc.crashsdk.b.I() == 5) {
            return Z;
        }
        return 100;
    }

    public static void x() {
        long jP = g.p();
        if (jP < 0) {
            return;
        }
        boolean z2 = com.uc.crashsdk.b.I() == 5;
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(401));
        if (z2) {
            com.uc.crashsdk.a.e eVar = new com.uc.crashsdk.a.e(402);
            X = eVar;
            com.uc.crashsdk.a.f.a(0, eVar, jP);
        }
    }

    public static void y() {
        if (com.uc.crashsdk.b.c && com.uc.crashsdk.a.c && !com.uc.crashsdk.a.f.b(aa)) {
            com.uc.crashsdk.a.f.a(0, aa, 1000L);
        }
    }

    public static boolean z() {
        synchronized (Y) {
            Runnable runnable = X;
            if (runnable == null || W) {
                return false;
            }
            com.uc.crashsdk.a.f.a(runnable);
            X = null;
            return true;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }

    public static String d() {
        String str = i;
        if (str != null) {
            return str;
        }
        String strJ = j(null);
        i = strJ;
        return strJ;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:6|69|7|(4:11|(3:13|(2:15|76)(1:77)|16)|75|17)|20|(8:63|22|67|23|27|(1:29)|30|(1:(1:33)(1:34)))|(2:73|35)|(11:37|65|38|46|71|47|(1:51)|52|(1:56)|60|61)(8:42|71|47|(2:49|51)|52|(2:54|56)|60|61)|45|46|71|47|(0)|52|(0)|60|61) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x013b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013c, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d8 A[Catch: all -> 0x013b, TryCatch #4 {all -> 0x013b, blocks: (B:47:0x00d2, B:49:0x00d8, B:51:0x00e0, B:52:0x0106, B:54:0x010c, B:56:0x0114), top: B:71:0x00d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010c A[Catch: all -> 0x013b, TryCatch #4 {all -> 0x013b, blocks: (B:47:0x00d2, B:49:0x00d8, B:51:0x00e0, B:52:0x0106, B:54:0x010c, B:56:0x0114), top: B:71:0x00d2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e() {
        String str;
        String str2;
        Method declaredMethod;
        String str3;
        String str4;
        if (!com.uc.crashsdk.a.g.a(j)) {
            return j;
        }
        String str5 = null;
        try {
            Field declaredField = Build.class.getDeclaredField("SUPPORTED_ABIS");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj != null && (obj instanceof String[])) {
                String[] strArr = (String[]) obj;
                StringBuilder sb = new StringBuilder();
                int length = strArr.length;
                int i2 = 0;
                boolean z2 = true;
                while (i2 < length) {
                    String str6 = strArr[i2];
                    if (!z2) {
                        sb.append(",");
                    }
                    sb.append(str6);
                    i2++;
                    z2 = false;
                }
                j = sb.toString();
            }
        } catch (Throwable unused) {
        }
        if (com.uc.crashsdk.a.g.a(j)) {
            try {
                str3 = Build.CPU_ABI;
            } catch (Throwable unused2) {
                str3 = null;
            }
            try {
                str4 = Build.CPU_ABI2;
            } catch (Throwable unused3) {
                str4 = null;
            }
            boolean z3 = !com.uc.crashsdk.a.g.a(str3);
            if (z3) {
                j = str3;
            }
            if (!com.uc.crashsdk.a.g.a(str4)) {
                if (z3) {
                    j += ",";
                    j += str4;
                } else {
                    j = str4;
                }
            }
        }
        try {
            declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
        } catch (Throwable th) {
            th = th;
            str = null;
        }
        if (declaredMethod == null) {
            str2 = null;
            if (!com.uc.crashsdk.a.g.a(str5)) {
                j += ",";
                j += str5;
            }
            if (!com.uc.crashsdk.a.g.a(str2)) {
                j += ",";
                j += str2;
            }
            return j;
        }
        declaredMethod.setAccessible(true);
        str = (String) declaredMethod.invoke(null, "ro.product.cpu.abi", null);
        try {
            str2 = (String) declaredMethod.invoke(null, "ro.product.cpu.abi2", null);
        } catch (Throwable th2) {
            th = th2;
            com.uc.crashsdk.a.g.a(th);
            str2 = null;
        }
        str5 = str;
        if (!com.uc.crashsdk.a.g.a(str5) && !j.contains(str5)) {
            j += ",";
            j += str5;
        }
        if (!com.uc.crashsdk.a.g.a(str2) && !j.contains(str2)) {
            j += ",";
            j += str2;
        }
        return j;
        com.uc.crashsdk.a.g.a(th);
        str2 = null;
        str5 = str;
        if (!com.uc.crashsdk.a.g.a(str5)) {
        }
        if (!com.uc.crashsdk.a.g.a(str2)) {
        }
        return j;
    }

    public static String f() {
        if (com.uc.crashsdk.a.g.a(k)) {
            T();
        }
        return k;
    }

    private static long h(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", String.class, Long.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Long) declaredMethod.invoke(null, str, 0L)).longValue();
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return 0L;
    }

    private static String i(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", "-");
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static void s() {
        T = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new e());
    }

    public static void c() {
        i = null;
    }

    public static boolean i() {
        return d;
    }

    public static boolean b(int i2, Object[] objArr) {
        if (i2 == 451) {
            if (f10820a || objArr != null) {
                return a((String) objArr[0], (d) objArr[1]);
            }
            throw new AssertionError();
        }
        if (i2 != 452) {
            if (f10820a) {
                return false;
            }
            throw new AssertionError();
        }
        if (!f10820a && objArr == null) {
            throw new AssertionError();
        }
        String str = (String) objArr[0];
        d dVar = (d) objArr[1];
        return com.uc.crashsdk.a.g.a(new File(str), String.format(Locale.US, "%d %d %d %d", Long.valueOf(dVar.f10822a), Long.valueOf(dVar.b), Integer.valueOf(dVar.c), Integer.valueOf(dVar.d)).getBytes());
    }

    private static void c(OutputStream outputStream) {
        int iK;
        if (com.uc.crashsdk.b.d) {
            String strO = com.uc.crashsdk.b.o();
            h = false;
            if (1 == JNIBridge.cmd(17, strO)) {
                File file = new File(strO);
                try {
                    byte[] bArrE = com.uc.crashsdk.a.g.e(file);
                    if (bArrE != null) {
                        outputStream.write(bArrE);
                    }
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                try {
                    file.delete();
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                h = true;
                a(outputStream);
            }
            h = true;
            return;
        }
        File[] fileArrListFiles = null;
        try {
            iK = g.K();
            try {
                fileArrListFiles = new File("/proc/self/fd").listFiles();
                if (fileArrListFiles != null) {
                    outputStream.write(String.format(Locale.US, "opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArrListFiles.length), Integer.valueOf(iK)).getBytes("UTF-8"));
                } else {
                    outputStream.write("[DEBUG] listFiles failed!\n".getBytes("UTF-8"));
                }
            } catch (Throwable th3) {
                th = th3;
                a(th, outputStream);
            }
        } catch (Throwable th4) {
            th = th4;
            iK = 900;
        }
        if (fileArrListFiles != null) {
            try {
                if (fileArrListFiles.length >= iK) {
                    outputStream.write("opened files:\n".getBytes("UTF-8"));
                    StringBuilder sb = new StringBuilder();
                    try {
                        for (File file2 : fileArrListFiles) {
                            sb.append(file2.getName());
                            sb.append(" -> ");
                            sb.append(file2.getCanonicalPath());
                            sb.append("\n");
                        }
                    } catch (Throwable th5) {
                        a(th5, outputStream);
                    }
                    outputStream.write(sb.toString().getBytes("UTF-8"));
                }
            } catch (Throwable th6) {
                a(th6, outputStream);
            }
        }
        a(outputStream);
    }

    public static String g() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024);
            sb.append(" kB\n");
            sb.append("JavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024);
            sb.append(" kB\n");
            sb.append("NativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024);
            sb.append(" kB\n");
            sb.append("NativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024);
            sb.append(" kB\n");
            try {
                ActivityManager activityManager = (ActivityManager) com.uc.crashsdk.a.g.a().getSystemService("activity");
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("availMem:   ");
                    sb.append(memoryInfo.availMem / 1024);
                    sb.append(" kB\n");
                    sb.append("threshold:  ");
                    sb.append(memoryInfo.threshold / 1024);
                    sb.append(" kB\n");
                    sb.append("lowMemory:  ");
                    sb.append(memoryInfo.lowMemory);
                    sb.append("\n");
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            return sb.toString();
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return "";
        }
    }

    private static void d(OutputStream outputStream) {
        int iL;
        int length;
        File[] fileArrListFiles = null;
        try {
            iL = g.L();
            try {
                fileArrListFiles = new File("/proc/self/task").listFiles();
                if (fileArrListFiles == null) {
                    return;
                }
                length = fileArrListFiles.length;
                if (length < iL) {
                    return;
                }
            } catch (Throwable th) {
                th = th;
                com.uc.crashsdk.a.g.a(th);
                length = 0;
            }
        } catch (Throwable th2) {
            th = th2;
            iL = 300;
        }
        if (fileArrListFiles == null) {
            return;
        }
        try {
            outputStream.write("threads info:\n".getBytes("UTF-8"));
            outputStream.write(String.format(Locale.US, "threads count: %d, dump limit: %d.\n", Integer.valueOf(length), Integer.valueOf(iL)).getBytes("UTF-8"));
            outputStream.write(" tid     name\n".getBytes("UTF-8"));
            for (File file : fileArrListFiles) {
                outputStream.write(String.format(Locale.US, "%5s %s\n", file.getName(), l(com.uc.crashsdk.a.g.a(new File(file.getPath(), "comm"), 128, false))).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    private static void f(OutputStream outputStream) {
        String strM;
        try {
            outputStream.write("recent status:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            if (ag) {
                strM = s("LASTVER");
            } else {
                strM = com.uc.crashsdk.a.m();
            }
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", strM).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            ArrayList<String> arrayList = s;
            synchronized (arrayList) {
                if (u != null) {
                    outputStream.write(String.format(Locale.US, "generating log: %s\n", u).getBytes("UTF-8"));
                }
                if (t > 0 || arrayList.size() > 0) {
                    outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(t)).getBytes("UTF-8"));
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        outputStream.write(String.format(Locale.US, "* %s\n", it.next()).getBytes("UTF-8"));
                    }
                }
            }
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "dumping all threads: %s\n", Boolean.valueOf(v)).getBytes("UTF-8"));
            String str = w;
            if (str != null) {
                outputStream.write(String.format(locale, "dumping threads: %s\n", str).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    public static String k() {
        String strA = x;
        if (com.uc.crashsdk.a.g.a(strA)) {
            synchronized (y) {
                strA = com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.i(), g.z(), true);
                x = strA;
            }
        }
        return strA;
    }

    public static void l() {
        synchronized (y) {
            x = null;
        }
    }

    public static void a(int i2, Object[] objArr) {
        int i3;
        switch (i2) {
            case 401:
                JNIBridge.nativeCmd(10, com.uc.crashsdk.b.I() == 5 ? 1L : 0L, null, null);
                com.uc.crashsdk.a.c = true;
                com.uc.crashsdk.a.a(false);
                L = true;
                Z();
                y();
                return;
            case 402:
                Object obj = Y;
                synchronized (obj) {
                    if (X == null) {
                        return;
                    }
                    W = true;
                    if (com.uc.crashsdk.b.q()) {
                        return;
                    }
                    if (!com.uc.crashsdk.a.d.e()) {
                        com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                        return;
                    }
                    if (!d(LogType.UNEXP_TYPE)) {
                        com.uc.crashsdk.a.a.d("DEBUG", "unexp sample miss");
                        return;
                    }
                    int iNativeGenerateUnexpLog = JNIBridge.nativeGenerateUnexpLog(g.p(), g.q());
                    if (iNativeGenerateUnexpLog != 0) {
                        f.a(11);
                        if ((iNativeGenerateUnexpLog & 4352) != 0) {
                            Z = 105;
                            i3 = 30;
                        } else if ((iNativeGenerateUnexpLog & LogType.UNEXP_EXIT) != 0) {
                            Z = 104;
                            i3 = 31;
                        } else if ((iNativeGenerateUnexpLog & LogType.UNEXP_RESTART) != 0) {
                            Z = 106;
                            i3 = 32;
                        } else {
                            if ((iNativeGenerateUnexpLog & 1280) != 0) {
                                Z = 103;
                                f.a(10);
                            } else if ((iNativeGenerateUnexpLog & 2304) != 0) {
                                Z = 107;
                                f.a(29);
                            } else {
                                Z = 102;
                            }
                            a(true);
                        }
                        f.a(i3);
                        a(true);
                    }
                    synchronized (obj) {
                        X = null;
                        break;
                    }
                    return;
                }
            case 403:
                ab();
                return;
            case 404:
            default:
                if (!f10820a) {
                    throw new AssertionError();
                }
                return;
            case 405:
                L = false;
                StringBuilder sbY = Y();
                String strG = com.uc.crashsdk.b.g();
                if (sbY != null) {
                    com.uc.crashsdk.a.g.a(new File(strG), sbY.toString());
                    return;
                }
                return;
            case 406:
                if (!f10820a && objArr == null) {
                    throw new AssertionError();
                }
                a((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue());
                return;
            case 407:
                try {
                    com.uc.crashsdk.a.d();
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case 408:
                synchronized (ab) {
                    if (!ac && g.R() && com.uc.crashsdk.b.z()) {
                        com.uc.crashsdk.b.s();
                        h.f();
                        f.c();
                        if (com.uc.crashsdk.b.F()) {
                            C();
                        }
                        if (g.R()) {
                            a(Calendar.getInstance());
                        }
                        ac = true;
                        return;
                    }
                    return;
                }
            case 409:
                d(false);
                return;
            case 410:
                a(false, true);
                return;
            case 411:
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.set(28, d(LogType.NATIVE_TYPE));
                    JNIBridge.set(29, d(LogType.ANR_TYPE));
                    return;
                }
                return;
            case 412:
                if (!R && com.uc.crashsdk.b.B() && g.N()) {
                    b(com.uc.crashsdk.a.g.a());
                    return;
                }
                if (R) {
                    if (com.uc.crashsdk.b.B() && g.N()) {
                        return;
                    }
                    try {
                        com.uc.crashsdk.a.g.a().unregisterReceiver(Q);
                        R = false;
                        return;
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                        return;
                    }
                }
                return;
            case 413:
                JNIBridge.cmd(8);
                return;
            case 414:
                try {
                    if (d(com.uc.crashsdk.a.g.a())) {
                        return;
                    }
                    int i4 = N + 1;
                    N = i4;
                    if (i4 < 10) {
                        X();
                        return;
                    } else {
                        if (com.uc.crashsdk.b.d) {
                            JNIBridge.set(130, "(get failed)");
                            return;
                        }
                        return;
                    }
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case 415:
                if (!f10820a && objArr == null) {
                    throw new AssertionError();
                }
                long jLongValue = ((Long) objArr[0]).longValue();
                Calendar calendar = Calendar.getInstance();
                if (calendar.getTimeInMillis() >= jLongValue) {
                    h.g();
                    f.a(100);
                    d(true);
                    f.a(true);
                    h.b();
                } else {
                    h.h();
                    h.i();
                    h.c();
                }
                a(calendar);
                break;
                break;
            case 416:
                break;
        }
        W();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f10821a;
        private final OutputStream b;
        private int c = 0;
        private int d = 0;
        private boolean e = false;

        public a(long j, OutputStream outputStream) {
            this.f10821a = j;
            this.b = outputStream;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int a(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            this.d += i2;
            if (this.e) {
                return 0;
            }
            int iB = g.B();
            if (iB > 0) {
                int i4 = this.c;
                i3 = i4 + i2 > iB ? iB - i4 : i2;
            }
            this.c += i3;
            if (this.f10821a != 0) {
                b(new String(bArr, i, i3));
            } else {
                this.b.write(bArr, i, i3);
            }
            if (i3 < i2) {
                this.e = true;
            }
            return i3;
        }

        private void b(String str) {
            if (com.uc.crashsdk.b.d) {
                JNIBridge.nativeClientWriteData(this.f10821a, str);
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i) throws IOException {
            if (e.h && e.O()) {
                com.uc.crashsdk.a.a.d("DEBUG", String.format(Locale.US, "%c", Integer.valueOf(i)));
            }
            if (this.f10821a != 0) {
                b(String.format(Locale.US, "%c", Integer.valueOf(i)));
            } else {
                this.b.write(i);
            }
            this.c++;
            this.d++;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (e.h && e.O()) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                if (i2 != 1 || bArr2[0] != 10) {
                    try {
                        com.uc.crashsdk.a.a.d("DEBUG", new String(bArr2));
                    } catch (Throwable unused) {
                    }
                }
            }
            a(bArr, i, i2);
        }

        public final void a() {
            try {
                if (this.d - this.c > 0) {
                    a("\n");
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(g.B()), Integer.valueOf(this.d - this.c)));
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) throws IOException {
            if (e.h && e.O() && (bArr.length != 1 || bArr[0] != 10)) {
                try {
                    com.uc.crashsdk.a.a.d("DEBUG", new String(bArr));
                } catch (Throwable unused) {
                }
            }
            a(bArr, 0, bArr.length);
        }

        public final void a(String str) throws IOException {
            if (e.h && e.O()) {
                com.uc.crashsdk.a.a.d("DEBUG", str);
            }
            if (this.f10821a != 0) {
                b(str);
            } else {
                this.b.write(str.getBytes("UTF-8"));
            }
        }
    }

    public static String h() {
        String str = m;
        if (str != null) {
            return str;
        }
        String strA = a(Process.myPid());
        m = strA;
        return strA;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f10822a;
        long b;
        int c;
        int d;
        boolean e;
        boolean f;
        boolean g;

        private d() {
            this.f10822a = 0L;
            this.b = 0L;
            this.c = 0;
            this.d = 0;
            this.e = false;
            this.f = false;
            this.g = false;
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    public static void j() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void m() {
        if (ag) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(411), 1000L);
    }

    public static void p() {
        String strA;
        Throwable th;
        File file;
        if (com.uc.crashsdk.a.g.a(B)) {
            String string = null;
            try {
                file = new File(g.X() + "unique");
            } catch (Throwable th2) {
                strA = string;
                th = th2;
            }
            if (file.exists()) {
                strA = com.uc.crashsdk.a.g.a(file, 48, false);
                try {
                    if (strA != null) {
                        try {
                            if (strA.length() == 36) {
                                string = strA.replaceAll("[^0-9a-zA-Z-]", "-");
                            }
                        } catch (Exception e) {
                            com.uc.crashsdk.a.g.a(e);
                            string = strA;
                        }
                    } else {
                        string = strA;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.uc.crashsdk.a.g.a(th);
                    string = strA;
                }
                B = string;
            }
            if (com.uc.crashsdk.a.g.a(string)) {
                com.uc.crashsdk.b.G();
                string = UUID.randomUUID().toString();
                if (!com.uc.crashsdk.a.g.a(string)) {
                    com.uc.crashsdk.a.g.a(file, string.getBytes());
                }
            }
            B = string;
        }
    }

    public static String q() {
        return B;
    }

    public static void r() {
        O = false;
        if (!com.uc.crashsdk.b.B()) {
            com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(416), 11000L);
        }
        if (V()) {
            return;
        }
        N = 0;
        X();
    }

    private static void b(OutputStream outputStream, String str, String str2) {
        String strS;
        String strNativeGet;
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), n()).getBytes("UTF-8"));
            Object[] objArr = new Object[3];
            objArr[0] = e();
            if (com.uc.crashsdk.a.g.a(l)) {
                T();
            }
            objArr[1] = l;
            objArr[2] = f();
            outputStream.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", objArr).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            Locale locale2 = Locale.US;
            outputStream.write(String.format(locale2, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)).getBytes("UTF-8"));
            outputStream.write(("Build fingerprint: '" + Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            Object[] objArr2 = new Object[4];
            objArr2[0] = a(new Date(b));
            objArr2[1] = Long.valueOf(Runtime.getRuntime().maxMemory());
            objArr2[2] = com.uc.crashsdk.a.g.d();
            objArr2[3] = com.uc.crashsdk.b.B() ? "fg" : OapsKey.KEY_BG;
            outputStream.write(String.format(locale2, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", objArr2).getBytes("UTF-8"));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            Locale locale3 = Locale.US;
            outputStream.write(String.format(locale3, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", g.U(), g.V(), g.W(), Integer.valueOf(com.uc.crashsdk.a.c())).getBytes("UTF-8"));
            String str3 = "0";
            String str4 = "";
            if (com.uc.crashsdk.b.d) {
                String strNativeGet2 = JNIBridge.nativeGet(1, 0L, null);
                strNativeGet = JNIBridge.nativeGet(2, 0L, null);
                str3 = strNativeGet2;
            } else {
                strNativeGet = "";
            }
            outputStream.write(String.format(locale3, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", "3.3.2.2", str3, "240515102041", strNativeGet, BaseConstants.CATEGORY_UMENG).getBytes("UTF-8"));
            if (str != null) {
                str4 = str;
            }
            outputStream.write(("Report Name: " + str4.substring(str4.lastIndexOf(47) + 1) + "\n").getBytes("UTF-8"));
        } catch (Throwable th4) {
            a(th4, outputStream);
        }
        try {
            if (ag) {
                strS = s("UUID");
            } else {
                strS = B;
            }
            outputStream.write(String.format("UUID: %s\n", strS).getBytes("UTF-8"));
            outputStream.write(("Log Type: " + str2 + "\n").getBytes("UTF-8"));
        } catch (Throwable th5) {
            a(th5, outputStream);
        }
        try {
            String strE = com.uc.crashsdk.b.E();
            if (com.uc.crashsdk.a.g.a(strE)) {
                strE = "(none)";
            }
            outputStream.write(("Activity: " + strE + "\n").getBytes("UTF-8"));
        } catch (Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
        try {
            com.uc.crashsdk.a.a(outputStream, "UTF-8");
            if (ag) {
                h = false;
                outputStream.write(s("HEADER").getBytes("UTF-8"));
                h = true;
            }
        } catch (Throwable th7) {
            a(th7, outputStream);
        }
        a(outputStream);
    }

    public static String n() {
        return a(new Date());
    }

    public static boolean d(String str) {
        if (ag) {
            return true;
        }
        try {
            return p(str);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(boolean z2) {
        File[] fileArrListFiles;
        try {
            if (com.uc.crashsdk.b.y() && (fileArrListFiles = new File(g.Y()).listFiles()) != null) {
                int iM = g.m();
                int iN = g.n();
                if (fileArrListFiles.length < Math.min(iM, iN)) {
                    return;
                }
                Object[] objArr = 0;
                int i2 = 0;
                int i3 = 0;
                for (File file : fileArrListFiles) {
                    if (b(file)) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                int i4 = (!z2 || i2 < iM) ? 0 : (i2 - iM) + 1;
                int i5 = (z2 || i3 < iN) ? 0 : (i3 - iN) + 1;
                if (i4 == 0 && i5 == 0) {
                    return;
                }
                Arrays.sort(fileArrListFiles, new b(objArr == true ? 1 : 0));
                int i6 = i4;
                int i7 = i5;
                for (File file2 : fileArrListFiles) {
                    boolean zB = b(file2);
                    if (zB && i6 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest crash log: " + file2.getPath());
                        file2.delete();
                        i6 += -1;
                    } else if (!zB && i7 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest custom log: " + file2.getPath());
                        file2.delete();
                        i7 += -1;
                    }
                    if (i6 == 0 && i7 == 0) {
                        break;
                    }
                }
                f.a(16, i4 + i5);
                if (i4 > 0) {
                    f.a(22, i4);
                }
                if (i5 > 0) {
                    f.a(23, i5);
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        boolean z2 = false;
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return false;
        }
        int iMyPid = Process.myPid();
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.ProcessErrorStateInfo next = it.next();
            if (next.pid == iMyPid) {
                O = true;
                if (O()) {
                    com.uc.crashsdk.a.a.d("crashsdk", "ANR occurred in process: " + next.processName);
                }
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.set(130, next.longMsg);
                }
                z2 = true;
            }
        }
        if (!z2 && com.uc.crashsdk.b.d) {
            W();
        }
        return true;
    }

    public static void o() {
        b = System.currentTimeMillis();
    }

    private static void e(OutputStream outputStream) {
        BufferedReader bufferedReader;
        int iIndexOf;
        if (com.uc.crashsdk.b.d) {
            try {
                outputStream.write("solib build id:\n".getBytes("UTF-8"));
            } catch (Throwable th) {
                a(th, outputStream);
            }
            FileReader fileReader = null;
            try {
                ArrayList arrayList = new ArrayList();
                FileReader fileReader2 = new FileReader(new File("/proc/self/maps"));
                try {
                    bufferedReader = new BufferedReader(fileReader2, 512);
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (line.endsWith(Constants.LIBRARY_SUFFIX) && (iIndexOf = line.indexOf(47)) != -1) {
                                String strSubstring = line.substring(iIndexOf);
                                if ((strSubstring.contains("/data/") || strSubstring.contains(com.uc.crashsdk.a.f10808a)) && !arrayList.contains(strSubstring)) {
                                    arrayList.add(strSubstring);
                                    if (ag) {
                                        try {
                                            outputStream.write((String.format("$^%s`%s^$", "SOBUILDID", strSubstring) + "\n").getBytes("UTF-8"));
                                        } catch (Throwable th2) {
                                            a(th2, outputStream);
                                        }
                                    } else {
                                        outputStream.write(String.format(Locale.US, "%s: %s\n", strSubstring, JNIBridge.nativeGet(3, 0L, strSubstring)).getBytes("UTF-8"));
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileReader = fileReader2;
                            try {
                                a(th, outputStream);
                                com.uc.crashsdk.a.g.a(fileReader);
                                com.uc.crashsdk.a.g.a(bufferedReader);
                                a(outputStream);
                            } catch (Throwable th4) {
                                com.uc.crashsdk.a.g.a(fileReader);
                                com.uc.crashsdk.a.g.a(bufferedReader);
                                throw th4;
                            }
                        }
                    }
                    com.uc.crashsdk.a.g.a(fileReader2);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = null;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
            com.uc.crashsdk.a.g.a(bufferedReader);
            a(outputStream);
        }
    }

    public static void c(String str) {
        synchronized (z) {
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.l(), str + "\n");
        }
    }

    public static void d(boolean z2) {
        f.d(false);
        if (z2) {
            f.a(com.uc.crashsdk.b.c(), false);
            h.i();
        } else {
            f.a();
            h.i();
        }
    }

    public static int f(boolean z2) {
        int iB;
        if (z2) {
            iB = f.a(com.uc.crashsdk.b.c()) ? 1 : 0;
        } else {
            iB = f.b();
        }
        int iB2 = f.b(z2);
        return iB2 > iB ? iB2 : iB;
    }

    public static void c(boolean z2) {
        boolean z3 = true;
        if (!R ? !z2 || !g.N() : z2 && g.N()) {
            z3 = false;
        }
        if (z3) {
            com.uc.crashsdk.a.e eVar = S;
            if (com.uc.crashsdk.a.f.b(eVar)) {
                com.uc.crashsdk.a.f.a(eVar);
            }
            com.uc.crashsdk.a.f.a(0, eVar, 3000L);
        }
    }

    public static StringBuilder f(String str) {
        return a(Thread.currentThread().getStackTrace(), str);
    }

    public static String a(String str, String str2) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(Build.VERSION.SDK_INT >= 26 ? new String[]{"ps", "-ef"} : new String[]{"ps"}).getInputStream()));
            boolean zB = com.uc.crashsdk.a.g.b(str);
            boolean zB2 = com.uc.crashsdk.a.g.b(str2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    if ((zB && line.contains(str)) || (zB2 && line.contains(str2)) || (line.indexOf(47) < 0 && line.indexOf(46) > 0)) {
                        byteArrayOutputStream.write(line.getBytes("UTF-8"));
                        byteArrayOutputStream.write("\n".getBytes("UTF-8"));
                    }
                } else {
                    return byteArrayOutputStream.toString("UTF-8");
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "exception exists.";
        }
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i2 = 8192;
        while (bufferedReader == null && i2 > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i2);
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 512) {
                    return bufferedReader;
                }
            }
        }
        return bufferedReader;
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    public static boolean e(String str) {
        try {
            if (!com.uc.crashsdk.a.g.b(str) || !str.startsWith(Constants.LIBRARY_PREFIX) || !str.endsWith(Constants.LIBRARY_SUFFIX)) {
                return false;
            }
            System.loadLibrary(str.substring(3, str.length() - 3));
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    private static String a(File file) {
        String canonicalPath;
        try {
            canonicalPath = file.getCanonicalPath();
        } catch (Throwable unused) {
            canonicalPath = null;
        }
        return com.uc.crashsdk.a.g.a(canonicalPath) ? file.getPath() : canonicalPath;
    }

    private static long a(StatFs statFs, String str, String str2) {
        try {
            Method declaredMethod = StatFs.class.getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(statFs, new Object[0]);
            if (objInvoke != null && (objInvoke instanceof Long)) {
                return ((Long) objInvoke).longValue();
            }
        } catch (Throwable unused) {
        }
        try {
            Method declaredMethod2 = StatFs.class.getDeclaredMethod(str2, new Class[0]);
            declaredMethod2.setAccessible(true);
            Object objInvoke2 = declaredMethod2.invoke(statFs, new Object[0]);
            if (objInvoke2 == null || !(objInvoke2 instanceof Integer)) {
                return 0L;
            }
            return ((Integer) objInvoke2).intValue();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return 0L;
        }
    }

    public static int e(boolean z2) {
        return f.a(z2);
    }

    private static void b(OutputStream outputStream) {
        BufferedReader bufferedReaderA = null;
        try {
            outputStream.write("logcat:\n".getBytes("UTF-8"));
        } finally {
        }
        try {
            if (g.o() <= 0) {
                try {
                    outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
                } catch (Throwable th) {
                    a(th, outputStream);
                }
                a(outputStream);
                return;
            }
            int iO = g.o();
            bufferedReaderA = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", com.umeng.analytics.pro.f.ax, "-b", "main", "-v", "threadtime", "-t", String.valueOf(iO)}).getInputStream()));
            if (bufferedReaderA == null) {
                try {
                    outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                a(outputStream);
                return;
            }
            h = false;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                String line = bufferedReaderA.readLine();
                if (line != null) {
                    i2++;
                    if (i3 < iO && !line.contains(" I auditd ") && !line.contains(" I liblog ")) {
                        outputStream.write(line.getBytes("UTF-8"));
                        outputStream.write("\n".getBytes("UTF-8"));
                        i3++;
                    }
                } else {
                    try {
                        break;
                    } catch (Throwable th3) {
                        a(th3, outputStream);
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)).getBytes("UTF-8"));
            h = true;
            com.uc.crashsdk.a.g.a(bufferedReaderA);
            a(outputStream);
            return;
            com.uc.crashsdk.a.g.a(bufferedReaderA);
            a(outputStream);
            return;
        } finally {
        }
    }

    private static void a(a aVar) {
        try {
            aVar.a(String.format(Locale.US, "log end: %s\n", n()));
        } catch (Throwable th) {
            a(th, aVar);
        }
    }

    public static int a(OutputStream outputStream, String str, int i2) {
        int i3 = 0;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            String strA = com.uc.crashsdk.a.b.a(str);
            if (strA == null) {
                strA = "file: '" + str + "' not found or decode failed!";
            }
            int length = strA.length();
            if (length <= i2 + 32) {
                i2 = length;
            }
            if (i2 > 0) {
                try {
                    outputStream.write(strA.getBytes("UTF-8"), 0, i2);
                    outputStream.write("\n".getBytes("UTF-8"));
                } catch (Throwable th) {
                    th = th;
                    i3 = i2;
                    a(th, outputStream);
                    i2 = i3;
                }
            }
            if (i2 < strA.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(strA.length() - i2)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i2;
    }

    public static String a(int i2) {
        try {
            String strA = com.uc.crashsdk.a.g.a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i2))), 128, false);
            return com.uc.crashsdk.a.g.b(strA) ? l(strA) : "unknown";
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "unknown";
        }
    }

    private static void b(a aVar) {
        h = false;
        try {
            aVar.write((s("LOG_END") + "\n").getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:0|2|(59:372|3|4|(2:374|6)|9|(2:11|12)(1:13)|366|14|327|15|(1:17)|21|(2:351|23)|360|28|306|32|325|33|(1:35)|39|(1:43)|318|47|339|51|55|355|56|370|61|(2:294|67)|72|321|73|77|288|78|337|82|86|353|87|92|(4:94|304|95|99)|312|100|105|329|106|347|111|320|115|(1:117)(2:118|(1:120))|124|341|125|129)|(4:131|290|132|136)(10:331|139|(0)(16:146|302|147|148|149|323|150|(17:152|153|314|154|300|155|156|296|157|158|292|159|181|368|182|186|(21:188|316|189|211|212|298|213|218|(4:220|335|221|225)|343|226|231|364|232|237|(4:239|308|240|244)|245|333|246|(1:252)|253)(25:362|194|(1:196)|197|(1:199)|200|(4:202|(1:204)(1:206)|205|207)|211|212|298|213|218|(0)|343|226|231|364|232|237|(0)|245|333|246|(0)|253))(7:174|138|181|368|182|186|(0)(0))|179|349|180|181|368|182|186|(0)(0))|269|(1:271)|345|272|(1:274)(1:275)|276|280)|137|138|181|368|182|186|(0)(0)|269|(0)|345|272|(0)(0)|276|280|(3:(0)|(1:350)|(1:311))) */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0357, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0358, code lost:
    
        a(r0, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x04cc, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x04cd, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:188:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x042f A[Catch: all -> 0x048e, TRY_LEAVE, TryCatch #31 {all -> 0x048e, blocks: (B:181:0x034a, B:186:0x035b, B:211:0x0416, B:218:0x042b, B:220:0x042f, B:225:0x0444, B:224:0x0441, B:237:0x045a, B:239:0x045e, B:244:0x0473, B:243:0x0470, B:245:0x0476, B:250:0x0482, B:236:0x0457, B:230:0x044d, B:217:0x0428, B:192:0x0375, B:185:0x0358, B:180:0x0347, B:213:0x0422, B:240:0x0461, B:246:0x047c, B:221:0x0432, B:226:0x0447, B:232:0x0451, B:182:0x034d), top: B:349:0x0347, inners: #5, #10, #23, #24, #28, #39, #41 }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x045e A[Catch: all -> 0x048e, TRY_LEAVE, TryCatch #31 {all -> 0x048e, blocks: (B:181:0x034a, B:186:0x035b, B:211:0x0416, B:218:0x042b, B:220:0x042f, B:225:0x0444, B:224:0x0441, B:237:0x045a, B:239:0x045e, B:244:0x0473, B:243:0x0470, B:245:0x0476, B:250:0x0482, B:236:0x0457, B:230:0x044d, B:217:0x0428, B:192:0x0375, B:185:0x0358, B:180:0x0347, B:213:0x0422, B:240:0x0461, B:246:0x047c, B:221:0x0432, B:226:0x0447, B:232:0x0451, B:182:0x034d), top: B:349:0x0347, inners: #5, #10, #23, #24, #28, #39, #41 }] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x04bb A[Catch: all -> 0x04cc, TryCatch #29 {all -> 0x04cc, blocks: (B:272:0x04b7, B:274:0x04bb, B:276:0x04c6), top: B:345:0x04b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x037a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Throwable th, String str, long j2, boolean z2) {
        FileOutputStream fileOutputStream;
        int i2;
        FileOutputStream fileOutputStream2;
        a aVar;
        String str2;
        int i3;
        String str3;
        HashSet hashSet;
        String strA;
        StatFs statFs;
        long jA;
        long jA2;
        a aVar2 = null;
        try {
            if (!com.uc.crashsdk.b.L()) {
                try {
                    g.a();
                    a(true);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    try {
                        a(th, aVar2);
                        if (j2 != 0) {
                        }
                        com.uc.crashsdk.a.g.a(aVar2);
                        com.uc.crashsdk.a.g.a(fileOutputStream);
                        if (!ag) {
                        }
                        b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
                        return str;
                    } catch (Throwable th3) {
                        if (j2 != 0) {
                            b(aVar2);
                        }
                        com.uc.crashsdk.a.g.a(aVar2);
                        com.uc.crashsdk.a.g.a(fileOutputStream);
                        throw th3;
                    }
                }
            }
            i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            fileOutputStream2 = i2 == 0 ? new FileOutputStream(str) : null;
            try {
                aVar = new a(j2, fileOutputStream2);
                try {
                    try {
                        if (com.uc.crashsdk.b.d) {
                            JNIBridge.set(126, str);
                        }
                    } catch (Throwable th4) {
                        com.uc.crashsdk.a.g.a(th4);
                    }
                    b(aVar, str, S());
                    if (z2) {
                        try {
                            aVar.flush();
                        } catch (Throwable th5) {
                            com.uc.crashsdk.a.g.a(th5);
                        }
                    }
                    try {
                        aVar.write(("Process Name: '" + h() + "'\n").getBytes("UTF-8"));
                        aVar.write(("Thread Name: '" + Thread.currentThread().getName() + "'\n").getBytes("UTF-8"));
                    } catch (Throwable th6) {
                        com.uc.crashsdk.a.g.a(th6);
                    }
                    try {
                        aVar.write("Back traces starts.\n".getBytes("UTF-8"));
                        try {
                            Field declaredField = Throwable.class.getDeclaredField("detailMessage");
                            declaredField.setAccessible(true);
                            Object obj = declaredField.get(th);
                            if (obj != null) {
                                declaredField.set(th, ((String) obj).replaceAll("\n\t", "\n->  "));
                            }
                        } catch (Throwable th7) {
                            com.uc.crashsdk.a.g.a(th7);
                        }
                        String message = th.getMessage();
                        if (message != null && !message.equals(th.getLocalizedMessage())) {
                            aVar.write(("Message: " + message + "\n").getBytes("UTF-8"));
                        }
                    } catch (Throwable th8) {
                        com.uc.crashsdk.a.g.a(th8);
                    }
                    try {
                        th.printStackTrace(new PrintStream(aVar));
                    } catch (Throwable th9) {
                        com.uc.crashsdk.a.g.a(th9);
                    }
                    try {
                        aVar.write("Back traces ends.\n".getBytes("UTF-8"));
                    } catch (Throwable th10) {
                        com.uc.crashsdk.a.g.a(th10);
                    }
                    a((OutputStream) aVar);
                    try {
                        aVar.flush();
                    } catch (Throwable th11) {
                        com.uc.crashsdk.a.g.a(th11);
                    }
                    try {
                        com.uc.crashsdk.a.a(aVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                    } catch (Throwable th12) {
                        com.uc.crashsdk.a.g.a(th12);
                    }
                    if (z2) {
                        try {
                            aVar.flush();
                        } catch (Throwable th13) {
                            com.uc.crashsdk.a.g.a(th13);
                        }
                    }
                    try {
                        aVar.write("meminfo:\n".getBytes("UTF-8"));
                        b(aVar, "/proc/meminfo", 10240);
                    } catch (Throwable th14) {
                        a(th14, aVar);
                    }
                    try {
                        String str4 = String.format(Locale.US, "/proc/%d/status", Integer.valueOf(Process.myPid()));
                        aVar.write("status:\n".getBytes("UTF-8"));
                        b(aVar, str4, 10240);
                    } catch (Throwable th15) {
                        a(th15, aVar);
                    }
                    try {
                        aVar.write(("memory info:\n" + g()).getBytes("UTF-8"));
                    } catch (Throwable th16) {
                        a(th16, aVar);
                    }
                    a((OutputStream) aVar);
                    f(aVar);
                    try {
                        com.uc.crashsdk.a.a(aVar, "UTF-8", (ArrayList<String>) null);
                    } catch (Throwable th17) {
                        a(th17, aVar);
                    }
                    if (ag) {
                        h = false;
                        try {
                            aVar.write(s("JAVADUMPFILES").getBytes("UTF-8"));
                        } catch (Throwable th18) {
                            a(th18, aVar);
                        }
                        h = true;
                    }
                    try {
                        aVar.flush();
                    } catch (Throwable th19) {
                        com.uc.crashsdk.a.g.a(th19);
                    }
                    b((OutputStream) aVar);
                    try {
                        aVar.flush();
                    } catch (Throwable th20) {
                        com.uc.crashsdk.a.g.a(th20);
                    }
                    try {
                        aVar.write("battery info:\n".getBytes("UTF-8"));
                    } catch (Throwable th21) {
                        a(th21, aVar);
                    }
                    try {
                        if (ag) {
                            h = false;
                            aVar.write(s("BATTERYINFO").getBytes("UTF-8"));
                            h = true;
                        } else {
                            StringBuilder sbY = Y();
                            if (sbY != null) {
                                aVar.write(sbY.toString().getBytes("UTF-8"));
                            }
                        }
                    } catch (Throwable th22) {
                        a(th22, aVar);
                    }
                    a((OutputStream) aVar);
                    try {
                        aVar.write("disk info:\n".getBytes("UTF-8"));
                    } catch (Throwable th23) {
                        a(th23, aVar);
                    }
                } catch (Throwable th24) {
                    th = th24;
                    fileOutputStream = fileOutputStream2;
                    aVar2 = aVar;
                    a(th, aVar2);
                    if (j2 != 0) {
                    }
                    com.uc.crashsdk.a.g.a(aVar2);
                    com.uc.crashsdk.a.g.a(fileOutputStream);
                    if (!ag) {
                    }
                    b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
                    return str;
                }
            } catch (Throwable th25) {
                th = th25;
                fileOutputStream = fileOutputStream2;
            }
        } catch (Throwable th26) {
            th = th26;
        }
        if (!ag) {
            try {
                hashSet = new HashSet();
                strA = a(new File(com.uc.crashsdk.a.g.b()));
            } catch (Throwable th27) {
                th = th27;
                str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                i3 = i2;
            }
            if (!com.uc.crashsdk.a.g.a(strA) && !hashSet.contains(strA) && !strA.equals("/storage/emulated")) {
                hashSet.add(strA);
                try {
                    statFs = new StatFs(strA);
                    jA = a(statFs, "getBlockCountLong", "getBlockCount");
                    i3 = i2;
                    try {
                        jA2 = a(statFs, "getBlockSizeLong", "getBlockSize");
                    } catch (Throwable th28) {
                        th = th28;
                        str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                    }
                } catch (Throwable unused) {
                    str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                    i3 = i2;
                }
                try {
                    if ((jA / 1024) * jA2 >= FileUtil.LOCAL_REPORT_FILE_MAX_SIZE) {
                        long jA3 = a(statFs, "getAvailableBlocksLong", "getAvailableBlocks");
                        try {
                            long jA4 = a(statFs, "getFreeBlocksLong", "getFreeBlocks");
                            try {
                                Locale locale = Locale.US;
                                str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                                fileOutputStream = fileOutputStream2;
                                try {
                                    aVar.write(String.format(locale, "%s:\n", strA).getBytes("UTF-8"));
                                    Object[] objArr = new Object[1];
                                    str3 = "\n";
                                    double d2 = jA2;
                                    try {
                                        objArr[0] = Long.valueOf((long) (((jA * 1.0d) * d2) / 1024.0d));
                                        aVar.write(String.format(locale, "  total:      %d kB\n", objArr).getBytes("UTF-8"));
                                        aVar.write(String.format(locale, "  available:  %d kB\n", Long.valueOf((long) (((jA3 * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                                        aVar.write(String.format(locale, "  free:       %d kB\n", Long.valueOf((long) (((jA4 * 1.0d) * d2) / 1024.0d))).getBytes("UTF-8"));
                                        aVar.write(String.format(locale, "  block size: %d B\n\n", Long.valueOf(jA2)).getBytes("UTF-8"));
                                    } catch (Throwable th29) {
                                        th = th29;
                                        try {
                                            a(th, aVar);
                                        } catch (Throwable th30) {
                                            th = th30;
                                            a(th, aVar);
                                        }
                                    }
                                } catch (Throwable th31) {
                                    th = th31;
                                    str3 = "\n";
                                    a(th, aVar);
                                    a((OutputStream) aVar);
                                    aVar.write("device status:\n".getBytes("UTF-8"));
                                    if (ag) {
                                    }
                                    com.uc.crashsdk.a.g.a(fileOutputStream);
                                    if (!ag) {
                                    }
                                    b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
                                    return str;
                                }
                            } catch (Throwable th32) {
                                th = th32;
                                str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                                fileOutputStream = fileOutputStream2;
                            }
                        } catch (Throwable th33) {
                            th = th33;
                            str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                            fileOutputStream = fileOutputStream2;
                            str3 = "\n";
                        }
                        a((OutputStream) aVar);
                        aVar.write("device status:\n".getBytes("UTF-8"));
                        if (ag) {
                            try {
                                h = false;
                                aVar.write(s("DEVICESTATUS").getBytes("UTF-8"));
                                h = true;
                            } catch (Throwable th34) {
                                th = th34;
                                a(th, aVar);
                            }
                            a((OutputStream) aVar);
                            c(aVar);
                            d(aVar);
                            String str5 = str2;
                            try {
                                com.uc.crashsdk.a.b(aVar, "UTF-8", str5, null);
                            } catch (Throwable th35) {
                                a(th35, aVar);
                            }
                            if (ag) {
                                h = false;
                                try {
                                    aVar.write(s("JAVACACHEDINFOS").getBytes("UTF-8"));
                                } catch (Throwable th36) {
                                    a(th36, aVar);
                                }
                                h = true;
                            }
                            try {
                                aVar.flush();
                            } catch (Throwable th37) {
                                com.uc.crashsdk.a.g.a(th37);
                            }
                            try {
                                com.uc.crashsdk.a.a(aVar, "UTF-8", str5, null);
                            } catch (Throwable th38) {
                                a(th38, aVar);
                            }
                            if (ag) {
                                h = false;
                                try {
                                    aVar.write(s("JAVACALLBACKINFOS").getBytes("UTF-8"));
                                } catch (Throwable th39) {
                                    a(th39, aVar);
                                }
                                h = true;
                            }
                            aVar.a();
                            a(aVar);
                            try {
                                aVar.flush();
                            } catch (Throwable th40) {
                                com.uc.crashsdk.a.g.a(th40);
                            }
                            if (i3 != 0) {
                                b(aVar);
                            }
                            com.uc.crashsdk.a.g.a(aVar);
                        } else {
                            try {
                                Locale locale2 = Locale.US;
                                aVar.write(String.format(locale2, "has root: %s\n", Boolean.valueOf(com.uc.crashsdk.a.g.e())).getBytes("UTF-8"));
                                String str6 = Build.TAGS;
                                String str7 = str6 != null ? str6 : "";
                                StringBuilder sb = new StringBuilder();
                                sb.append("build tags: ");
                                sb.append(str7);
                                if (com.uc.crashsdk.a.g.f()) {
                                    sb.append(" (default root)");
                                }
                                sb.append(str3);
                                aVar.write(sb.toString().getBytes("UTF-8"));
                                String strH = com.uc.crashsdk.a.g.h();
                                if (com.uc.crashsdk.a.g.b(strH)) {
                                    aVar.write(String.format(locale2, "su binary: %s\n", strH).getBytes("UTF-8"));
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("su permission: ");
                                    sb2.append(com.uc.crashsdk.a.g.g() ? "valid (" : "invalid (");
                                    sb2.append(com.uc.crashsdk.a.g.i());
                                    sb2.append(")\n");
                                    aVar.write(sb2.toString().getBytes("UTF-8"));
                                }
                            } catch (Throwable th41) {
                                th = th41;
                                a(th, aVar);
                            }
                            a((OutputStream) aVar);
                            c(aVar);
                            d(aVar);
                            String str52 = str2;
                            com.uc.crashsdk.a.b(aVar, "UTF-8", str52, null);
                            if (ag) {
                            }
                            aVar.flush();
                            com.uc.crashsdk.a.a(aVar, "UTF-8", str52, null);
                            if (ag) {
                            }
                            aVar.a();
                            a(aVar);
                            aVar.flush();
                            if (i3 != 0) {
                            }
                            com.uc.crashsdk.a.g.a(aVar);
                        }
                    } else {
                        str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
                        fileOutputStream = fileOutputStream2;
                        str3 = "\n";
                        a((OutputStream) aVar);
                        aVar.write("device status:\n".getBytes("UTF-8"));
                        if (ag) {
                        }
                    }
                    a(th, aVar);
                    a((OutputStream) aVar);
                    aVar.write("device status:\n".getBytes("UTF-8"));
                    if (ag) {
                    }
                } catch (Throwable th42) {
                    th = th42;
                    aVar2 = aVar;
                    a(th, aVar2);
                    if (j2 != 0) {
                        b(aVar2);
                    }
                    com.uc.crashsdk.a.g.a(aVar2);
                }
                fileOutputStream = fileOutputStream2;
                str3 = "\n";
            }
            com.uc.crashsdk.a.g.a(fileOutputStream);
            if (!ag) {
                r(str);
            }
            b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
            return str;
        }
        h = false;
        try {
            aVar.write(s("FSSTAT").getBytes("UTF-8"));
        } catch (Throwable th43) {
            a(th43, aVar);
        }
        h = true;
        str2 = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
        i3 = i2;
        fileOutputStream = fileOutputStream2;
        str3 = "\n";
        a((OutputStream) aVar);
        aVar.write("device status:\n".getBytes("UTF-8"));
        if (ag) {
        }
        com.uc.crashsdk.a.g.a(fileOutputStream);
        if (!ag) {
        }
        b(!ag ? a(m(str)) : str, LogType.JAVA_TYPE);
        return str;
    }

    public static int b(OutputStream outputStream, String str, int i2) {
        int i3;
        DataInputStream dataInputStream;
        int i4;
        DataInputStream dataInputStream2 = null;
        int i5 = 0;
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] bArrR = R();
                if (bArrR == null) {
                    outputStream.write("(alloc buffer failed!)\n".getBytes("UTF-8"));
                    return 0;
                }
                dataInputStream = new DataInputStream(new FileInputStream(file));
                i4 = 0;
                i3 = 0;
                loop0: while (true) {
                    boolean z2 = false;
                    while (true) {
                        try {
                            int i6 = dataInputStream.read(bArrR);
                            if (i6 == -1) {
                                break loop0;
                            }
                            i4 += i6;
                            int i7 = i2 - i3;
                            if (i6 <= i7 + 32) {
                                i7 = i6;
                            }
                            if (i7 > 0 && !z2) {
                                outputStream.write(bArrR, 0, i7);
                                i3 += i7;
                            }
                            if (!z2) {
                                if (i7 < i6 || i3 >= i2) {
                                    z2 = true;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            i5 = i3;
                            dataInputStream2 = dataInputStream;
                            try {
                                a(th, outputStream);
                                com.uc.crashsdk.a.g.a(dataInputStream2);
                                i3 = i5;
                            } finally {
                                com.uc.crashsdk.a.g.a(dataInputStream2);
                            }
                        }
                    }
                }
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
                dataInputStream = null;
                i4 = 0;
                i3 = 0;
            }
            if (i3 > 0) {
                outputStream.write("\n".getBytes("UTF-8"));
            }
            if (i3 < i4) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(i4 - i3)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i3;
    }

    public static void b(boolean z2) {
        try {
            boolean zT = g.s() && com.uc.crashsdk.b.F() && !d;
            if (!zT) {
                zT = g.t();
            }
            if (zT) {
                if (z2) {
                    String strK = k();
                    if (com.uc.crashsdk.a.g.a(strK)) {
                        return;
                    }
                    j();
                    a(strK, false, false);
                    return;
                }
                a(true, false);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    private static boolean b(File file) {
        int iIndexOf;
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(95);
        if (iLastIndexOf <= 0 || (iIndexOf = name.indexOf(46, iLastIndexOf)) <= 0) {
            return false;
        }
        String strSubstring = name.substring(iLastIndexOf + 1, iIndexOf);
        return LogType.JAVA_TYPE.equals(strSubstring) || "ucebujava".equals(strSubstring) || LogType.NATIVE_TYPE.equals(strSubstring) || "ucebujni".equals(strSubstring) || LogType.UNEXP_TYPE.equals(strSubstring) || LogType.ANR_TYPE.equals(strSubstring);
    }

    private static String b(String str, boolean z2, boolean z3) {
        if (z2) {
            try {
                str = m(str);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (!z3) {
            return str;
        }
        try {
            return a(str);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return str;
        }
    }

    public static void b(String str, String str2, boolean z2) {
        h.a(str, str2, false, z2);
    }

    public static void b(String str) {
        synchronized (y) {
            x = str;
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.i(), str + "\n");
        }
    }

    private static void b(String str, String str2) {
        try {
            com.uc.crashsdk.d.a(str, h(), str2);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void b(Context context) {
        if (g.N()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                context.registerReceiver(Q, intentFilter, null, com.uc.crashsdk.a.f.a(1));
                R = true;
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
    }

    public static void b(int i2) {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(410), i2 * 1000);
    }

    public static String a(String str) {
        int iLastIndexOf;
        int iIndexOf;
        int i2;
        int iIndexOf2;
        File file;
        byte[] bArrE;
        byte[] bArrB;
        if (!g.y() || (iLastIndexOf = str.lastIndexOf(47)) <= 0 || (iIndexOf = str.indexOf(95, iLastIndexOf)) <= iLastIndexOf || (iIndexOf2 = str.indexOf(95, (i2 = iIndexOf + 1))) <= iIndexOf) {
            return str;
        }
        String strD = com.uc.crashsdk.a.g.d("CrashSDK" + str.substring(iLastIndexOf + 1, iIndexOf) + str.substring(i2, iIndexOf2));
        if (strD == null || (bArrE = com.uc.crashsdk.a.g.e((file = new File(str)))) == null || bArrE.length <= 0) {
            return str;
        }
        try {
            bArrB = com.uc.crashsdk.a.c.b(bArrE, strD.substring(0, 16).getBytes());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            bArrB = null;
        }
        if (bArrB == null) {
            return str;
        }
        String str2 = str + ".ec";
        File file2 = new File(str2 + ".tmp");
        if (!com.uc.crashsdk.a.g.a(file2, bArrB)) {
            return str;
        }
        if (!file2.renameTo(new File(str2))) {
            file2.delete();
            return str;
        }
        file.delete();
        return str2;
    }

    public static void a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        com.uc.crashsdk.a.g.a(th);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02fc A[Catch: all -> 0x0441, TryCatch #1 {all -> 0x0441, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:9:0x0034, B:11:0x003a, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:147:0x03cc, B:18:0x006d, B:20:0x007d, B:22:0x008f, B:25:0x00b0, B:27:0x00c0, B:31:0x00cd, B:42:0x00f9, B:38:0x00eb, B:62:0x01c6, B:64:0x01da, B:66:0x01de, B:67:0x01e0, B:69:0x01e5, B:70:0x01e7, B:71:0x01ec, B:81:0x0210, B:82:0x0226, B:84:0x022c, B:86:0x0235, B:88:0x0242, B:90:0x0261, B:91:0x0274, B:93:0x0286, B:95:0x0296, B:96:0x02a7, B:110:0x02eb, B:113:0x02fc, B:116:0x030a, B:119:0x031b, B:121:0x0329, B:123:0x0336, B:126:0x033d, B:130:0x034a, B:132:0x0356, B:134:0x036f, B:135:0x0374, B:137:0x0383, B:139:0x0390, B:145:0x03ba, B:150:0x03e0, B:152:0x03e7, B:154:0x03ee, B:156:0x03f5, B:158:0x03fc, B:160:0x0403, B:166:0x0415, B:168:0x041c, B:170:0x0423, B:172:0x042a, B:164:0x040e, B:138:0x038a, B:140:0x03ad, B:142:0x03b2, B:98:0x02af, B:100:0x02b5, B:103:0x02bd, B:105:0x02c1, B:107:0x02d5, B:109:0x02d9, B:75:0x01f7, B:77:0x0205, B:79:0x020b, B:61:0x01c3, B:173:0x0432), top: B:195:0x000a, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(String str, boolean z2, boolean z3) {
        ConditionVariable conditionVariable;
        int i2;
        boolean z4;
        boolean z5;
        File[] fileArr;
        int i3;
        int i4;
        int i5;
        String str2;
        int i6;
        File file;
        com.uc.crashsdk.a.a.a("crashsdk", "crashsdk uploading logs");
        synchronized (n) {
            try {
                try {
                } catch (Throwable th) {
                    try {
                        com.uc.crashsdk.a.g.a(th);
                        if (z3) {
                            conditionVariable = o;
                        }
                    } finally {
                    }
                }
                if (com.uc.crashsdk.a.g.b(str)) {
                    String strY = g.Y();
                    File file2 = new File(strY);
                    if (file2.exists()) {
                        File[] fileArrListFiles = file2.listFiles();
                        if (fileArrListFiles == null) {
                            com.uc.crashsdk.a.a.b("List folder failed: " + strY);
                        } else {
                            int length = fileArrListFiles.length;
                            int i7 = 0;
                            int i8 = 0;
                            int i9 = 0;
                            int i10 = 0;
                            int i11 = 0;
                            int i12 = 0;
                            int i13 = 0;
                            int i14 = 0;
                            int i15 = 0;
                            boolean z6 = false;
                            boolean z7 = false;
                            boolean z8 = false;
                            while (true) {
                                if (i7 >= length) {
                                    i2 = i10;
                                    z4 = z6;
                                    z5 = z7;
                                    break;
                                }
                                File file3 = fileArrListFiles[i7];
                                if (file3.isFile()) {
                                    String name = file3.getName();
                                    fileArr = fileArrListFiles;
                                    if (name.endsWith(".tmp")) {
                                        if ((System.currentTimeMillis() - file3.lastModified()) / 1000 > 30) {
                                            i3 = length;
                                            com.uc.crashsdk.a.a.b("delete legacy tmp file: " + name);
                                            i9++;
                                            com.uc.crashsdk.a.g.a(file3);
                                        }
                                        i4 = i13;
                                        z4 = z6;
                                        i7++;
                                        fileArrListFiles = fileArr;
                                        i13 = i4;
                                        length = i3;
                                        z6 = z4;
                                    } else {
                                        i3 = length;
                                        z4 = z6;
                                        z5 = z7;
                                        if (file3.length() == 0) {
                                            i8++;
                                            com.uc.crashsdk.a.g.a(file3);
                                        } else {
                                            if (z2) {
                                                long jCurrentTimeMillis = (System.currentTimeMillis() - file3.lastModified()) / 1000;
                                                boolean z9 = jCurrentTimeMillis < 0 || (jCurrentTimeMillis >= 2 && (jCurrentTimeMillis >= 5 || !file3.getName().endsWith(".log")));
                                                com.uc.crashsdk.a.a.a(String.format(Locale.US, "file: %s, modify interval: %d s, safe upload: %s", file3.getName(), Long.valueOf(jCurrentTimeMillis), Boolean.valueOf(z9)));
                                                if (!z9) {
                                                    i10++;
                                                }
                                            }
                                            try {
                                            } catch (Throwable th2) {
                                                th = th2;
                                                i2 = i10;
                                            }
                                            if (g.l()) {
                                                Matcher matcher = Pattern.compile("([^_]+)_([^_]+)_([^_]+)\\.crashsdk").matcher(file3.getName());
                                                if (matcher.matches()) {
                                                    i2 = i10;
                                                    try {
                                                        file = new File(g.Y() + String.format(Locale.US, "%s%s_%s_%s.%s", j(matcher.group(2)), n(), Q(), matcher.group(1), matcher.group(3)));
                                                        com.uc.crashsdk.a.a.a("crashsdk", "File " + file3.getPath() + " matches, rename to " + file.getPath());
                                                        file3.renameTo(file);
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        com.uc.crashsdk.a.g.a(th);
                                                    }
                                                } else {
                                                    i2 = i10;
                                                    file = file3;
                                                }
                                                if (file != file3) {
                                                    i14++;
                                                }
                                                file3 = file;
                                                String path = file3.getPath();
                                                boolean[] zArrN = n(path);
                                                String strB = b(path, zArrN[0], zArrN[1]);
                                                if (path != strB) {
                                                    if (zArrN[0]) {
                                                        i13++;
                                                    }
                                                    if (zArrN[1]) {
                                                        i11++;
                                                    }
                                                    file3 = new File(strB);
                                                }
                                                File fileA = com.uc.crashsdk.d.a(file3);
                                                if (fileA == null) {
                                                    fileA = null;
                                                } else if (file3 != fileA && !file3.getName().equals(fileA.getName()) && file3.exists()) {
                                                    file3.delete();
                                                }
                                                if (fileA == null) {
                                                    com.uc.crashsdk.a.a.b("onBeforeUploadLog return null, skip upload: " + file3.getAbsolutePath());
                                                } else {
                                                    int iC = g.C();
                                                    if (iC <= 0 || fileA.length() < iC) {
                                                        d dVar = new d((byte) 0);
                                                        dVar.b = 0L;
                                                        dVar.f10822a = System.currentTimeMillis();
                                                        String strU = U();
                                                        if (new File(strU).exists()) {
                                                            a(strU, new com.uc.crashsdk.a.e(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, new Object[]{strU, dVar}));
                                                        }
                                                        long jD = g.D();
                                                        int iE = g.E();
                                                        int iF = g.F();
                                                        if (jD >= 0) {
                                                            i4 = i13;
                                                            i5 = i14;
                                                            if (dVar.b + fileA.length() > jD) {
                                                                dVar.e = true;
                                                                str2 = "Reach max upload bytes: " + jD;
                                                            }
                                                            com.uc.crashsdk.a.a.b(str2);
                                                            if (!dVar.e) {
                                                                i14 = i5;
                                                                z7 = z5;
                                                                i10 = i2;
                                                                z4 = true;
                                                            } else if (dVar.g) {
                                                                i14 = i5;
                                                                i10 = i2;
                                                                z7 = true;
                                                            } else if (dVar.f) {
                                                                i14 = i5;
                                                                z7 = z5;
                                                                i10 = i2;
                                                                z8 = true;
                                                            } else {
                                                                String name2 = fileA.getName();
                                                                if (name2.startsWith(P())) {
                                                                    String[] strArrSplit = name2.split("_", 10);
                                                                    String str3 = strArrSplit.length == 9 ? strArrSplit[1] : null;
                                                                    boolean z10 = str3 != null && str3.equals(g.U());
                                                                    if (com.uc.crashsdk.a.c.a(fileA, fileA.getName(), str)) {
                                                                        com.uc.crashsdk.a.a.a("crashsdk", "Uploaded log: " + fileA.getName(), null);
                                                                        if (z10) {
                                                                            f.a(13);
                                                                        }
                                                                        dVar.b += fileA.length();
                                                                        if (b(fileA)) {
                                                                            dVar.c++;
                                                                        } else {
                                                                            dVar.d++;
                                                                        }
                                                                        String strU2 = U();
                                                                        a(strU2, new com.uc.crashsdk.a.e(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_CONNECT_TIME, new Object[]{strU2, dVar}));
                                                                        fileA.delete();
                                                                        i6 = 3;
                                                                        i15 = 0;
                                                                    } else {
                                                                        i15++;
                                                                        if (z10) {
                                                                            f.a(14);
                                                                        }
                                                                        i6 = 3;
                                                                    }
                                                                    if (i15 >= i6) {
                                                                        com.uc.crashsdk.a.a.a("crashsdk", "Upload failed 3 times continuously, abort upload!", null);
                                                                        i14 = i5;
                                                                        i13 = i4;
                                                                        break;
                                                                    } else {
                                                                        i14 = i5;
                                                                        z7 = z5;
                                                                        i10 = i2;
                                                                    }
                                                                }
                                                            }
                                                            i7++;
                                                            fileArrListFiles = fileArr;
                                                            i13 = i4;
                                                            length = i3;
                                                            z6 = z4;
                                                        } else {
                                                            i4 = i13;
                                                            i5 = i14;
                                                        }
                                                        if (!g.f()) {
                                                            if (b(fileA)) {
                                                                if (iE >= 0 && dVar.c >= iE) {
                                                                    dVar.g = true;
                                                                    str2 = "Reach max upload builtin log count: " + iE;
                                                                    com.uc.crashsdk.a.a.b(str2);
                                                                }
                                                            } else if (iF >= 0 && dVar.d >= iF) {
                                                                dVar.f = true;
                                                                str2 = "Reach max upload custom log count: " + iF;
                                                                com.uc.crashsdk.a.a.b(str2);
                                                            }
                                                        }
                                                        if (!dVar.e) {
                                                        }
                                                        i7++;
                                                        fileArrListFiles = fileArr;
                                                        i13 = i4;
                                                        length = i3;
                                                        z6 = z4;
                                                    } else {
                                                        i12++;
                                                        com.uc.crashsdk.a.g.a(fileA);
                                                    }
                                                }
                                                i4 = i13;
                                                z7 = z5;
                                                i10 = i2;
                                                i7++;
                                                fileArrListFiles = fileArr;
                                                i13 = i4;
                                                length = i3;
                                                z6 = z4;
                                            }
                                        }
                                        i4 = i13;
                                        z7 = z5;
                                        i7++;
                                        fileArrListFiles = fileArr;
                                        i13 = i4;
                                        length = i3;
                                        z6 = z4;
                                    }
                                } else {
                                    com.uc.crashsdk.a.g.a(file3);
                                    fileArr = fileArrListFiles;
                                }
                                i3 = length;
                                i4 = i13;
                                z4 = z6;
                                i7++;
                                fileArrListFiles = fileArr;
                                i13 = i4;
                                length = i3;
                                z6 = z4;
                            }
                            if (i9 > 0) {
                                f.a(200, i9);
                            }
                            if (i8 > 0) {
                                f.a(15, i8);
                            }
                            if (i12 > 0) {
                                f.a(17, i12);
                            }
                            if (z4) {
                                f.a(19);
                            }
                            if (z5) {
                                f.a(20);
                            }
                            if (z8) {
                                f.a(21);
                            }
                            if (z4 || z5 || z8) {
                                f.a(18);
                            }
                            if (i13 > 0) {
                                f.a(24, i13);
                            }
                            if (i11 > 0) {
                                f.a(201, i11);
                            }
                            if (i14 > 0) {
                                f.a(25, i14);
                            }
                            if (i2 > 0) {
                                f.a(26, i2);
                            }
                        }
                    } else {
                        com.uc.crashsdk.a.a.a("crashsdk", "Folder not exist: " + strY);
                    }
                } else {
                    com.uc.crashsdk.a.a.a("crashsdk", "upload url is empty!");
                }
                if (z3) {
                    conditionVariable = o;
                    conditionVariable.open();
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    public static boolean a(boolean z2, boolean z3) {
        if (!d) {
            if (com.uc.crashsdk.b.d) {
                JNIBridge.set(1, true);
            }
            d = true;
        }
        try {
            String strK = k();
            if (com.uc.crashsdk.a.g.a(strK)) {
                com.uc.crashsdk.a.a.a("crashsdk", "CrashHandler url is empty!");
                return false;
            }
            if (com.uc.crashsdk.a.f.a(z2 ? 1 : 0, new com.uc.crashsdk.a.e(406, new Object[]{strK, Boolean.valueOf(z3), Boolean.valueOf(z2)})) && z2) {
                o.close();
                if (!r6.block(3000L)) {
                    com.uc.crashsdk.a.a.a("crashsdk", "timeout to wait for uploading");
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        boolean zA;
        FileChannel channel;
        Exception e;
        synchronized (p) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    com.uc.crashsdk.a.g.a(e2);
                }
            }
            ?? r5 = 0;
            fileLockLock = null;
            FileLock fileLockLock = null;
            zA = false;
            try {
                try {
                    try {
                        channel = new RandomAccessFile(file, "rw").getChannel();
                    } catch (Throwable th) {
                        th = th;
                        r5 = file;
                        com.uc.crashsdk.a.g.a((Closeable) r5);
                        throw th;
                    }
                } catch (Exception e3) {
                    try {
                        com.uc.crashsdk.a.g.a(e3);
                        channel = null;
                    } catch (Exception e4) {
                        channel = null;
                        e = e4;
                        com.uc.crashsdk.a.g.a(e);
                        com.uc.crashsdk.a.g.a(channel);
                        return zA;
                    }
                }
                if (channel != null) {
                    try {
                        fileLockLock = channel.lock();
                    } catch (Exception e5) {
                        try {
                            com.uc.crashsdk.a.g.a(e5);
                        } catch (Exception e6) {
                            e = e6;
                            com.uc.crashsdk.a.g.a(e);
                        }
                    }
                }
                try {
                    zA = eVar.a();
                    com.uc.crashsdk.a.g.a(channel);
                } finally {
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (Exception e7) {
                            com.uc.crashsdk.a.g.a(e7);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return zA;
    }

    private static boolean a(String str, d dVar) {
        String strA = com.uc.crashsdk.a.g.a(new File(str), 64, false);
        if (strA == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(strA);
            if (matcher.find()) {
                long j2 = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - j2 < 86400000) {
                    dVar.b = Long.parseLong(matcher.group(2));
                    dVar.c = Integer.parseInt(matcher.group(3));
                    dVar.d = Integer.parseInt(matcher.group(4));
                    dVar.f10822a = j2;
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v3 */
    public static boolean a(StringBuffer stringBuffer, String str, long j2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        long j3;
        boolean z2;
        boolean zA;
        if (c.get()) {
            com.uc.crashsdk.a.a.b("Processing java crash, skip generate custom log: " + str);
            return false;
        }
        boolean z3 = ag || com.uc.crashsdk.b.L();
        if (!z3 && !com.uc.crashsdk.a.d.e()) {
            com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
            return false;
        }
        if (!d(str)) {
            com.uc.crashsdk.a.a.d("DEBUG", "custom log sample miss: " + str);
            return false;
        }
        if (aa()) {
            com.uc.crashsdk.a.a.b("Processing native crash, skip generate custom log: " + str);
            return false;
        }
        if (stringBuffer == null || str == null) {
            return false;
        }
        String strA = g.Y() + k(str);
        ?? r11 = (j2 & 32) != 0 ? 1 : 0;
        if (z3) {
            long jNativeClientCreateConnection = com.uc.crashsdk.b.d ? JNIBridge.nativeClientCreateConnection(strA, MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, str, r11) : 0L;
            if (jNativeClientCreateConnection == 0) {
                com.uc.crashsdk.a.a.d("DEBUG", "skip custom log: " + str);
                return false;
            }
            j3 = jNativeClientCreateConnection;
        } else {
            if (a(h(), str, (boolean) r11)) {
                return false;
            }
            g.a();
            a(false);
            j3 = 0;
        }
        synchronized (q) {
            z2 = r11;
            zA = a(strA, j3, stringBuffer, str, j2, arrayList, arrayList2, arrayList3, str2);
        }
        if (zA && !z3) {
            b(h(), str, z2);
        }
        if (j3 != 0) {
            JNIBridge.nativeClientCloseConnection(j3);
        }
        if (!zA) {
            return false;
        }
        if (!z3) {
            r(strA);
        }
        if (!z3) {
            strA = a(m(strA));
        }
        b(strA, str);
        if (z2 == 0 || z3) {
            return true;
        }
        try {
            a(true, false);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    public static boolean a(String str, String str2, boolean z2) {
        if (!o(str2)) {
            return false;
        }
        h.a(str, str2, true, z2);
        com.uc.crashsdk.a.a.b(String.format(Locale.US, "Custom log '%s' has reach max count!", str2));
        return true;
    }

    private static void a(a aVar, String str, long j2) {
        String strNativeDumpThreads;
        String str2 = null;
        if (com.uc.crashsdk.b.d) {
            try {
                aVar.flush();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            strNativeDumpThreads = JNIBridge.nativeDumpThreads(str, j2);
            if (ag || strNativeDumpThreads == null || strNativeDumpThreads.length() >= 512 || !strNativeDumpThreads.startsWith("/") || strNativeDumpThreads.indexOf(10) >= 0) {
                str2 = strNativeDumpThreads;
            } else {
                if (!new File(strNativeDumpThreads).exists()) {
                    str2 = "Can not found " + strNativeDumpThreads;
                }
                String str3 = str2;
                str2 = strNativeDumpThreads;
                strNativeDumpThreads = str3;
            }
        } else {
            strNativeDumpThreads = "Native not initialized, skip dump!";
        }
        if (strNativeDumpThreads != null) {
            try {
                aVar.write(strNativeDumpThreads.getBytes("UTF-8"));
                aVar.write("\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            a((OutputStream) aVar);
        } else if (str2 != null && !ag) {
            b(aVar, str2, 1048576);
            File file = new File(str2);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            aVar.flush();
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0043 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(String str, long j2, StringBuffer stringBuffer, String str2, long j3, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str3) {
        FileOutputStream fileOutputStream;
        a aVar;
        if (j2 == 0) {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                aVar = null;
                com.uc.crashsdk.a.g.a(th);
                if (aVar != null) {
                }
            }
        } else {
            fileOutputStream = null;
        }
        try {
            aVar = new a(j2, fileOutputStream);
            try {
                synchronized (s) {
                    u = str;
                    if (com.uc.crashsdk.b.d) {
                        JNIBridge.set(126, u);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.uc.crashsdk.a.g.a(th);
            }
        } catch (Throwable th3) {
            th = th3;
            aVar = null;
        }
        if (aVar != null) {
            return false;
        }
        if ((j3 & 1) != 0) {
            try {
                b(aVar, str, str2);
            } finally {
                try {
                } finally {
                }
            }
        }
        try {
            aVar.write(stringBuffer.toString().getBytes());
            aVar.write("\n".getBytes("UTF-8"));
            aVar.flush();
        } catch (Throwable th4) {
            a(th4, aVar);
        }
        a((OutputStream) aVar);
        if ((j3 & 4) != 0) {
            b((OutputStream) aVar);
            try {
                aVar.flush();
            } catch (Throwable th5) {
                com.uc.crashsdk.a.g.a(th5);
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            com.uc.crashsdk.a.a(aVar, "UTF-8", arrayList);
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            com.uc.crashsdk.a.a(aVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList2);
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            com.uc.crashsdk.a.b(aVar, "UTF-8", "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n", arrayList3);
        }
        if (str3 != null) {
            try {
                aVar.flush();
            } catch (Throwable th6) {
                a(th6, aVar);
            }
            try {
                aVar.write("threads dump:\n".getBytes("UTF-8"));
            } catch (Throwable th7) {
                a(th7, aVar);
            }
            h = false;
            w = str3;
            try {
                a(aVar, str3, j2);
            } catch (Throwable th8) {
                a(th8, aVar);
            }
            w = null;
            h = true;
        }
        if ((j3 & 8) != 0 && j2 == 0) {
            try {
                aVar.flush();
            } catch (Throwable th9) {
                a(th9, aVar);
            }
            try {
                aVar.write("all threads dump:\n".getBytes("UTF-8"));
            } catch (Throwable th10) {
                a(th10, aVar);
            }
            v = true;
            try {
                a(aVar, "all", 0L);
            } catch (Throwable th11) {
                a(th11, aVar);
            }
            v = false;
        }
        if ((j3 & 16) != 0) {
            e(aVar);
        }
        if ((j3 & 2) != 0) {
            aVar.a();
            a(aVar);
        }
        if (j2 != 0) {
            b(aVar);
        }
        try {
            ArrayList<String> arrayList4 = s;
            synchronized (arrayList4) {
                t++;
                String str4 = u;
                if (str4 != null) {
                    arrayList4.add(str4);
                    if (arrayList4.size() > 3) {
                        arrayList4.remove(0);
                    }
                    if (com.uc.crashsdk.b.d) {
                        JNIBridge.set(127, u);
                    }
                    u = null;
                }
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.set(25, t);
                }
            }
        } catch (Throwable th12) {
            com.uc.crashsdk.a.g.a(th12);
        }
        return true;
    }

    private static String a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", Integer.valueOf(date.getYear() + AMapException.CODE_AMAP_CLIENT_UNKNOWN_ERROR), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    public static void a(OutputStream outputStream, String str, String str2, int i2, boolean z2, boolean z3) {
        h = false;
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(z2 ? 1 : 0);
            objArr[4] = Integer.valueOf(z3 ? 1 : 0);
            outputStream.write(String.format(locale, "$^%s`%s`%d`%d,%d^$", objArr).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
        a(outputStream);
    }

    public static void a(OutputStream outputStream, String str, String str2) {
        h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", str, str2).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    public static void a(Context context) {
        try {
            if (V()) {
                context.registerReceiver(new c((byte) 0), new IntentFilter(O022Z.h), null, com.uc.crashsdk.a.f.a(3));
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:169:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0635 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:486:0x0650 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:501:0x0686 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:615:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fa  */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6, types: [long] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:148:0x0218 -> B:521:0x0220). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:151:0x021d -> B:521:0x0220). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Thread thread, Throwable th, boolean z2) {
        boolean z3;
        ?? r12;
        Throwable th2;
        boolean z4;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        boolean zU;
        String str;
        boolean z5;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2;
        boolean z6;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler3;
        Throwable th3;
        boolean z7;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler4;
        boolean z8;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler5;
        boolean z9;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler6;
        boolean z10;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler7;
        boolean z11;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler8;
        boolean z12 = (ag && com.uc.crashsdk.b.d) || com.uc.crashsdk.b.L();
        try {
            r12 = 4;
            if (c.getAndSet(true) && Process.myPid() > 0) {
                com.uc.crashsdk.a.a.d("DEBUG", "another thread is generating java report!");
                com.uc.crashsdk.a.a.d("DEBUG", "current thread exception is:");
                a(th);
                if (g.j()) {
                    int i2 = 0;
                    while (!V) {
                        try {
                            Thread.sleep(1000L);
                        } catch (Throwable th4) {
                            com.uc.crashsdk.a.g.a(th4);
                        }
                        i2++;
                        if (i2 >= 4) {
                            break;
                        }
                    }
                    Process.killProcess(Process.myPid());
                }
                if (z2) {
                    try {
                        if (!g.s() || z12) {
                            z11 = false;
                        } else {
                            try {
                                a(true, false);
                                z11 = true;
                            } catch (Throwable th5) {
                                th = th5;
                                z11 = true;
                                com.uc.crashsdk.a.g.a(th);
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        z11 = false;
                    }
                }
                if (!z11 && !z12) {
                    b(false);
                }
                try {
                    f.c(false);
                } catch (Throwable th7) {
                    com.uc.crashsdk.a.g.a(th7);
                }
                try {
                    boolean zI = g.i();
                    if (!com.uc.crashsdk.a.d.e()) {
                        zI = true;
                    }
                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI);
                    if (zI && (uncaughtExceptionHandler8 = T) != null) {
                        uncaughtExceptionHandler8.uncaughtException(thread, th);
                    }
                    if (com.uc.crashsdk.b.B() && !z12) {
                        com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                    }
                } catch (Throwable th8) {
                    com.uc.crashsdk.a.g.a(th8);
                }
                V = true;
                if (Process.myPid() <= 0 || !g.j()) {
                    return;
                }
                Process.killProcess(Process.myPid());
                return;
            }
            U = th;
            if (!z12 && !com.uc.crashsdk.a.d.e()) {
                com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                if (z2) {
                    try {
                        if (!g.s() || z12) {
                            z10 = false;
                        } else {
                            try {
                                a(true, false);
                                z10 = true;
                            } catch (Throwable th9) {
                                th = th9;
                                z10 = true;
                                com.uc.crashsdk.a.g.a(th);
                            }
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        z10 = false;
                    }
                }
                if (!z10 && !z12) {
                    b(false);
                }
                try {
                    f.c(false);
                } catch (Throwable th11) {
                    com.uc.crashsdk.a.g.a(th11);
                }
                try {
                    boolean zI2 = g.i();
                    if (!com.uc.crashsdk.a.d.e()) {
                        zI2 = true;
                    }
                    com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI2);
                    if (zI2 && (uncaughtExceptionHandler7 = T) != null) {
                        uncaughtExceptionHandler7.uncaughtException(thread, th);
                    }
                    if (com.uc.crashsdk.b.B() && !z12) {
                        com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                    }
                } catch (Throwable th12) {
                    com.uc.crashsdk.a.g.a(th12);
                }
                V = true;
                if (Process.myPid() <= 0 || !g.j()) {
                    return;
                }
                Process.killProcess(Process.myPid());
                return;
            }
            com.uc.crashsdk.a.a.d("DEBUG", "encryptLog: " + g.y() + ", zipCrashLog: " + g.y());
            if (g.f10825a != null) {
                com.uc.crashsdk.a.a.d("DEBUG", "the set zip log to false stack is:");
                g.f10825a.printStackTrace();
            }
            if (g.b != null) {
                com.uc.crashsdk.a.a.d("DEBUG", "the set encrypt to true stack is:");
                g.b.printStackTrace();
            }
            com.uc.crashsdk.a.a.d("DEBUG", "begin to generate java report");
            try {
                N();
            } catch (Throwable th13) {
                com.uc.crashsdk.a.g.a(th13);
            }
            try {
                zU = g.u();
                try {
                    String strG = g.g();
                    if (strG == null || strG.equals("")) {
                        strG = k(S());
                    }
                    str = g.Y() + strG;
                    z3 = false;
                } catch (Throwable th14) {
                    th = th14;
                    com.uc.crashsdk.a.a.d("DEBUG", "get java log name failed: " + th);
                    a(th);
                    com.uc.crashsdk.a.a.d("DEBUG", "original exception is: " + th);
                    a(th);
                    str = null;
                    z3 = true;
                }
            } catch (Throwable th15) {
                th = th15;
                zU = false;
            }
            try {
                try {
                    if (!z12) {
                        try {
                            g.a();
                            try {
                                if (com.uc.crashsdk.b.B()) {
                                    f.a(3);
                                } else {
                                    f.a(4);
                                }
                            } catch (Throwable th16) {
                                com.uc.crashsdk.a.g.a(th16);
                            }
                        } catch (Throwable th17) {
                            com.uc.crashsdk.a.g.a(th17);
                        }
                        try {
                            new File(com.uc.crashsdk.b.b()).createNewFile();
                        } catch (Throwable th18) {
                            com.uc.crashsdk.a.g.a(th18);
                        }
                        if (zU) {
                            com.uc.crashsdk.a.a.d("DEBUG", "omit java crash");
                            if (z2) {
                                try {
                                    if (!g.s() || z12) {
                                        z6 = false;
                                    } else {
                                        try {
                                            a(true, false);
                                            z6 = true;
                                        } catch (Throwable th19) {
                                            th = th19;
                                            z6 = true;
                                            com.uc.crashsdk.a.g.a(th);
                                        }
                                    }
                                } catch (Throwable th20) {
                                    th = th20;
                                    z6 = false;
                                }
                            }
                            if (!z6 && !z12) {
                                b(false);
                            }
                            try {
                                f.c(false);
                            } catch (Throwable th21) {
                                com.uc.crashsdk.a.g.a(th21);
                            }
                            try {
                                boolean zI3 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    zI3 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI3);
                                if (zI3 && (uncaughtExceptionHandler3 = T) != null) {
                                    uncaughtExceptionHandler3.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z12) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                            } catch (Throwable th22) {
                                com.uc.crashsdk.a.g.a(th22);
                            }
                            V = true;
                            if (Process.myPid() <= 0 || !g.j()) {
                                return;
                            }
                            Process.killProcess(Process.myPid());
                            return;
                        }
                        if (!d(LogType.JAVA_TYPE)) {
                            com.uc.crashsdk.a.a.d("DEBUG", "java log sample miss");
                            if (z2) {
                                try {
                                    if (!g.s() || z12) {
                                        z5 = false;
                                    } else {
                                        try {
                                            a(true, false);
                                            z5 = true;
                                        } catch (Throwable th23) {
                                            th = th23;
                                            z5 = true;
                                            com.uc.crashsdk.a.g.a(th);
                                        }
                                    }
                                } catch (Throwable th24) {
                                    th = th24;
                                    z5 = false;
                                }
                            }
                            if (!z5 && !z12) {
                                b(false);
                            }
                            try {
                                f.c(false);
                            } catch (Throwable th25) {
                                com.uc.crashsdk.a.g.a(th25);
                            }
                            try {
                                boolean zI4 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    zI4 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI4);
                                if (zI4 && (uncaughtExceptionHandler2 = T) != null) {
                                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z12) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                            } catch (Throwable th26) {
                                com.uc.crashsdk.a.g.a(th26);
                            }
                            V = true;
                            if (Process.myPid() <= 0 || !g.j()) {
                                return;
                            }
                            Process.killProcess(Process.myPid());
                            return;
                        }
                        r12 = 0;
                    } else {
                        if (zU) {
                            str = "omit";
                            com.uc.crashsdk.a.a.d("DEBUG", "omit java crash");
                        }
                        long jNativeClientCreateConnection = com.uc.crashsdk.b.d ? JNIBridge.nativeClientCreateConnection(str, LogType.JAVA_TYPE, null, 0) : 0L;
                        r12 = jNativeClientCreateConnection;
                        if (jNativeClientCreateConnection == 0) {
                            com.uc.crashsdk.a.a.d("DEBUG", "skip java crash:");
                            a(th);
                            if (jNativeClientCreateConnection != 0 && com.uc.crashsdk.b.d) {
                                JNIBridge.nativeClientCloseConnection(jNativeClientCreateConnection);
                            }
                            if (z2) {
                                try {
                                    if (!g.s() || z12) {
                                        z9 = false;
                                    } else {
                                        try {
                                            a(true, false);
                                            z9 = true;
                                        } catch (Throwable th27) {
                                            th = th27;
                                            z9 = true;
                                            com.uc.crashsdk.a.g.a(th);
                                        }
                                    }
                                } catch (Throwable th28) {
                                    th = th28;
                                    z9 = false;
                                }
                            }
                            if (!z9 && !z12) {
                                b(false);
                            }
                            try {
                                f.c(false);
                            } catch (Throwable th29) {
                                com.uc.crashsdk.a.g.a(th29);
                            }
                            try {
                                boolean zI5 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    zI5 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI5);
                                if (zI5 && (uncaughtExceptionHandler6 = T) != null) {
                                    uncaughtExceptionHandler6.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z12) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                            } catch (Throwable th30) {
                                com.uc.crashsdk.a.g.a(th30);
                            }
                            V = true;
                            if (Process.myPid() <= 0 || !g.j()) {
                                return;
                            }
                            Process.killProcess(Process.myPid());
                            return;
                        }
                        if (zU) {
                            if (jNativeClientCreateConnection != 0 && com.uc.crashsdk.b.d) {
                                JNIBridge.nativeClientCloseConnection(jNativeClientCreateConnection);
                            }
                            if (z2) {
                                try {
                                    if (!g.s() || z12) {
                                        z8 = false;
                                    } else {
                                        try {
                                            a(true, false);
                                            z8 = true;
                                        } catch (Throwable th31) {
                                            th = th31;
                                            z8 = true;
                                            com.uc.crashsdk.a.g.a(th);
                                        }
                                    }
                                } catch (Throwable th32) {
                                    th = th32;
                                    z8 = false;
                                }
                            }
                            if (!z8 && !z12) {
                                b(false);
                            }
                            try {
                                f.c(false);
                            } catch (Throwable th33) {
                                com.uc.crashsdk.a.g.a(th33);
                            }
                            try {
                                boolean zI6 = g.i();
                                if (!com.uc.crashsdk.a.d.e()) {
                                    zI6 = true;
                                }
                                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI6);
                                if (zI6 && (uncaughtExceptionHandler5 = T) != null) {
                                    uncaughtExceptionHandler5.uncaughtException(thread, th);
                                }
                                if (com.uc.crashsdk.b.B() && !z12) {
                                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                                }
                            } catch (Throwable th34) {
                                com.uc.crashsdk.a.g.a(th34);
                            }
                            V = true;
                            if (Process.myPid() <= 0 || !g.j()) {
                                return;
                            }
                            Process.killProcess(Process.myPid());
                            return;
                        }
                    }
                    boolean z13 = th instanceof OutOfMemoryError;
                    a(th, str, r12, z13);
                    com.uc.crashsdk.a.a.d("DEBUG", "generate java report finished");
                    if (!com.uc.crashsdk.b.L() && z13 && g.k()) {
                        String name = new File(str).getName();
                        String strZ = g.Z();
                        File file = new File(strZ);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String str2 = String.format(Locale.US, "%s%s.hprof", strZ, name);
                        com.uc.crashsdk.a.a.d("DEBUG", "begin dump hprof: " + str2);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        try {
                            Debug.dumpHprofData(str2);
                        } catch (Throwable th35) {
                            com.uc.crashsdk.a.g.a(th35);
                        }
                        com.uc.crashsdk.a.a.d("DEBUG", "end dump hprof, use " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
                    }
                    if (r12 != 0 && com.uc.crashsdk.b.d) {
                        JNIBridge.nativeClientCloseConnection(r12);
                    }
                    if (z2) {
                        try {
                            if (!g.s() || z12) {
                                z7 = false;
                            } else {
                                try {
                                    a(true, false);
                                    z7 = true;
                                } catch (Throwable th36) {
                                    th3 = th36;
                                    z7 = true;
                                    com.uc.crashsdk.a.g.a(th3);
                                }
                            }
                        } catch (Throwable th37) {
                            th3 = th37;
                            z7 = false;
                        }
                    }
                    if (!z7 && !z12) {
                        b(false);
                    }
                    try {
                        f.c(false);
                    } catch (Throwable th38) {
                        com.uc.crashsdk.a.g.a(th38);
                    }
                    try {
                        boolean zI7 = g.i();
                        if (!com.uc.crashsdk.a.d.e()) {
                            zI7 = true;
                        }
                        com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI7);
                        if (zI7 && (uncaughtExceptionHandler4 = T) != null) {
                            uncaughtExceptionHandler4.uncaughtException(thread, th);
                        }
                        if (com.uc.crashsdk.b.B() && !z12) {
                            com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                        }
                    } catch (Throwable th39) {
                        com.uc.crashsdk.a.g.a(th39);
                    }
                    V = true;
                    if (Process.myPid() <= 0 || !g.j()) {
                        return;
                    }
                    Process.killProcess(Process.myPid());
                    return;
                } catch (Throwable th40) {
                    th = th40;
                }
            } catch (Throwable th41) {
                th = th41;
            }
        } catch (Throwable th42) {
            th = th42;
            z3 = false;
        }
        th = th42;
        z3 = false;
        r12 = 0;
        try {
            com.uc.crashsdk.a.a.d("DEBUG", "exception occurs while java log: " + th);
            a(th);
            if (!z3) {
                com.uc.crashsdk.a.a.d("DEBUG", "original exception is: " + th);
                a(th);
            }
            if (r12 != 0 && com.uc.crashsdk.b.d) {
                JNIBridge.nativeClientCloseConnection(r12);
            }
            if (z2) {
                try {
                    if (!g.s() || z12) {
                        z4 = false;
                    } else {
                        try {
                            a(true, false);
                            z4 = true;
                        } catch (Throwable th43) {
                            th2 = th43;
                            z4 = true;
                            com.uc.crashsdk.a.g.a(th2);
                        }
                    }
                } catch (Throwable th44) {
                    th2 = th44;
                    z4 = false;
                }
            }
            if (!z4 && !z12) {
                b(false);
            }
            try {
                f.c(false);
            } catch (Throwable th45) {
                com.uc.crashsdk.a.g.a(th45);
            }
            try {
                boolean zI8 = g.i();
                if (!com.uc.crashsdk.a.d.e()) {
                    zI8 = true;
                }
                com.uc.crashsdk.a.a.a("crashsdk", "Call java default handler: " + zI8);
                if (zI8 && (uncaughtExceptionHandler = T) != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
                if (com.uc.crashsdk.b.B() && !z12) {
                    com.uc.crashsdk.b.b(com.uc.crashsdk.a.g.a());
                }
            } catch (Throwable th46) {
                com.uc.crashsdk.a.g.a(th46);
            }
            V = true;
            if (Process.myPid() <= 0 || !g.j()) {
                return;
            }
            Process.killProcess(Process.myPid());
        } finally {
        }
    }

    private static void a(Throwable th) {
        try {
            com.uc.crashsdk.a.a.d("DEBUG", a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable unused) {
        }
    }

    private static void a(Calendar calendar) {
        if (g.T()) {
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            long j2 = timeInMillis2 - timeInMillis;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(415, new Object[]{Long.valueOf(timeInMillis2)}), j2 <= 3600000 ? 1000 + j2 : 3600000L);
        }
    }

    public static StringBuilder a(StackTraceElement[] stackTraceElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            boolean z2 = str == null;
            int i3 = 0;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                i3++;
                sb.append("  at ");
                sb.append(stackTraceElement.toString());
                sb.append("\n");
                if (!z2 && stackTraceElement.getMethodName().contains(str)) {
                    sb.delete(0, sb.length());
                    z2 = true;
                    i3 = 0;
                }
            }
            i2 = i3;
        }
        if (i2 == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    public static boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        if (af) {
            com.uc.crashsdk.a.a.d("crashsdk", "Can not call setHostFd and getHostFd in the same process!");
            return false;
        }
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return false;
        }
        if (ae != null) {
            com.uc.crashsdk.a.a.c("crashsdk", "Has already set host fd!");
        }
        ae = parcelFileDescriptor;
        int fd = parcelFileDescriptor.getFd();
        int iNativeCmd = (int) JNIBridge.nativeCmd(13, fd, null, null);
        ag = iNativeCmd != -1;
        return fd == -1 || iNativeCmd != -1;
    }
}
