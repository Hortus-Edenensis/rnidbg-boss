package cn.fly.verify;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import cn.fly.verify.fq;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import defpackage.ey6;
import defpackage.zx6;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2074a;
    private static Integer b;
    private static Integer d;
    private static List<Integer> f;
    private static String h;
    private static Object c = new Object();
    private static Object e = new Object();
    private static Object g = new Object();
    private static final char[] i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static int a(String str) {
        try {
            if (!"46000".equals(str) && !"46002".equals(str) && !"46004".equals(str) && !"46007".equals(str) && !"46008".equals(str)) {
                if (!"46001".equals(str) && !"46006".equals(str) && !"46009".equals(str)) {
                    if (!"46003".equals(str) && !"46005".equals(str)) {
                        if (!"46011".equals(str)) {
                            return 0;
                        }
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        } catch (Throwable th) {
            f.a().a(th, "[FlyVerify][%s][%s] ==>%s", "Util", "isMobileDataEnabled", "Check mobile data encountered exception");
            return 0;
        }
    }

    public static int b(boolean z) {
        int iIntValue;
        synchronized (c) {
            if (b == null || z) {
                try {
                    boolean z2 = Build.VERSION.SDK_INT >= 22 && fq.d.b(com.kuaishou.weapon.p0.g.c);
                    boolean z3 = ai.a().r() == 1;
                    if (!z3) {
                        f.a().a("not allowed slots");
                    }
                    if (z2 && z3) {
                        b = Integer.valueOf(SubscriptionManager.from(ax.g()).getActiveSubscriptionInfoCount());
                        f.a().a("==== getSimCount");
                    } else {
                        b = -1;
                    }
                } catch (Throwable th) {
                    f.a().a(th);
                    b = -1;
                }
                if (b.intValue() == 0 && a(ax.g())) {
                    b = -1;
                }
                iIntValue = b.intValue();
            } else {
                iIntValue = b.intValue();
            }
        }
        return iIntValue;
    }

    public static int c(Context context) {
        try {
            if (Build.VERSION.SDK_INT <= 22 || ((TelephonyManager) fq.d.a("phone")).getSimState() != 1) {
                return ((Boolean) fq.d.a(context.getSystemService("connectivity"), "getMobileDataEnabled", new Object[0])).booleanValue() ? 1 : 0;
            }
            f.a().a("NO SIM");
            return 0;
        } catch (Throwable th) {
            f.a().a(th);
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002b, code lost:
    
        r0 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d() {
        int i2;
        if (ai.a().p() == 0) {
            f.a().a("not allowed sid");
            return -1;
        }
        try {
            i2 = Build.VERSION.SDK_INT;
        } catch (Exception unused) {
        }
        int activeDataSubscriptionId = i2 >= 30 ? SubscriptionManager.getActiveDataSubscriptionId() : i2 >= 24 ? SubscriptionManager.getDefaultDataSubscriptionId() : -1;
        if (activeDataSubscriptionId == -1) {
            return activeDataSubscriptionId;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(activeDataSubscriptionId));
        List<Integer> listA = a(ax.g(), arrayList);
        return (listA == null || listA.isEmpty()) ? activeDataSubscriptionId : listA.get(0).intValue();
    }

    public static long e(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return Files.readAttributes(Paths.get(str, new String[0]), ey6.a(), new LinkOption[0]).lastAccessTime().toMillis();
            }
            return -1L;
        } catch (Throwable th) {
            f.a().a(th);
            return -1L;
        }
    }

    public static String f() {
        try {
        } catch (Throwable th) {
            f.a().a(th);
        }
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        String strA = aq.a();
        h = strA;
        if (TextUtils.isEmpty(strA)) {
            String strB = fr.b(UUID.randomUUID().toString() + SystemClock.elapsedRealtimeNanos());
            h = strB;
            aq.a(strB);
        }
        return h;
    }

    public static String g() throws Throwable {
        return al.b();
    }

    public static int h() {
        int iC = c(ax.g());
        String strJ = al.j();
        if (iC == 1 && "wifi".equalsIgnoreCase(strJ)) {
            return 1;
        }
        if (iC == 1 && !"none".equalsIgnoreCase(strJ)) {
            return 2;
        }
        if (iC == 1) {
            return 3;
        }
        if (iC == -1 && "wifi".equalsIgnoreCase(strJ)) {
            return 4;
        }
        if (iC == -1 && !"none".equalsIgnoreCase(strJ)) {
            return 5;
        }
        if (iC == -1) {
            return 6;
        }
        if (iC == 0 && "wifi".equalsIgnoreCase(strJ)) {
            return 7;
        }
        return (iC != 0 || "none".equalsIgnoreCase(strJ)) ? 9 : 8;
    }

    public static s a(s sVar, int i2, String str, String str2, int i3, Integer num, String str3, e eVar) {
        String str4;
        if (i3 == 1) {
            f.a().a("use multi operator");
            sVar = new t();
            sVar.a(str, str2, b(i2), eVar);
            sVar.b(i3);
        } else {
            if (i2 == 1) {
                if (sVar == null) {
                    sVar = new t();
                }
                str4 = "CMCC";
            } else if (i2 == 2) {
                if (sVar == null) {
                    sVar = new ae();
                }
                str4 = "CUCC";
            } else if (i2 == 4) {
                if (sVar == null) {
                    sVar = new ac();
                }
                str4 = "CTCC";
            }
            sVar.a(str, str2, str4, eVar);
        }
        sVar.a(num);
        sVar.a(str3);
        return sVar;
    }

    public static String b() {
        String strA = a();
        try {
            if (!"46000".equals(strA) && !"46002".equals(strA) && !"46004".equals(strA) && !"46007".equals(strA) && !"46008".equals(strA)) {
                if (!"46001".equals(strA) && !"46006".equals(strA) && !"46009".equals(strA)) {
                    if (!"46003".equals(strA) && !"46005".equals(strA)) {
                        if (!"46011".equals(strA)) {
                            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
                        }
                    }
                    return "CTCC";
                }
                return "CUCC";
            }
            return "CMCC";
        } catch (Throwable unused) {
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static int c(boolean z) {
        int iIntValue;
        synchronized (e) {
            if (d == null || z) {
                try {
                    boolean z2 = ai.a().r() == 1;
                    if (!z2) {
                        f.a().a("not allowed slots");
                    }
                    if (z2) {
                        d = 0;
                        try {
                            Class<?> clsLoadClass = ax.g().getClassLoader().loadClass("android.os.SystemProperties");
                            String str = ((String) clsLoadClass.getMethod("get", String.class).invoke(clsLoadClass, "gsm.sim.state")) + ((String) clsLoadClass.getMethod("get", String.class).invoke(clsLoadClass, "gsm.sim.state.2"));
                            if (!TextUtils.isEmpty(str)) {
                                String[] strArrSplit = str.split(",");
                                if (strArrSplit.length > 0) {
                                    for (String str2 : strArrSplit) {
                                        if (!TextUtils.isEmpty(str2) && !"ABSENT".equals(str2) && !"NOT_READY".equals(str2)) {
                                            d = Integer.valueOf(d.intValue() + 1);
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            f.a().a(th);
                        }
                    } else {
                        d = -1;
                    }
                } catch (Throwable th2) {
                    f.a().a(th2);
                    d = -1;
                }
                iIntValue = d.intValue();
            } else {
                iIntValue = d.intValue();
            }
        }
        return iIntValue;
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        byte[] bArrDecode = Base64.decode(str, 2);
        int length = bArrDecode.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) (bArrDecode[i2] - length);
        }
        try {
            return new String(bArr, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String e() {
        try {
            return fr.d(ax.g().getPackageManager().getPackageInfo(ax.g().getPackageName(), 64).signatures[0].toByteArray());
        } catch (Throwable th) {
            f.a().a(th);
            return null;
        }
    }

    public static String a() {
        return a(false);
    }

    private static String b(int i2) {
        return i2 == 1 ? "CMCC" : (i2 == 2 || i2 == 3) ? "CUCC" : i2 == 4 ? "CTCC" : GrsBaseInfo.CountryCodeSource.UNKNOWN;
    }

    public static boolean c() {
        String strJ = al.j();
        return "2g".equalsIgnoreCase(strJ) || "3g".equalsIgnoreCase(strJ) || "4g".equalsIgnoreCase(strJ) || NetworkUtil.NETWORK_CLASS_5G.equalsIgnoreCase(strJ) || "wifi".equalsIgnoreCase(strJ);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009f A[Catch: all -> 0x00b8, TryCatch #1 {, blocks: (B:4:0x0003, B:39:0x00b4, B:40:0x00b6, B:34:0x0097, B:36:0x009f, B:38:0x00ad, B:33:0x0089, B:7:0x0009, B:9:0x0011, B:13:0x001c, B:17:0x0029, B:20:0x0036, B:22:0x004d, B:24:0x0053, B:25:0x005e, B:27:0x0064, B:28:0x007a, B:29:0x007f, B:30:0x0082), top: B:46:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<Integer> d(boolean z) {
        boolean z2;
        boolean z3;
        ArrayList arrayList;
        List<Integer> list;
        synchronized (g) {
            if (f == null || z) {
                try {
                    z2 = Build.VERSION.SDK_INT >= 22 && fq.d.b(com.kuaishou.weapon.p0.g.c);
                    z3 = ai.a().q() == 1;
                    if (!z3) {
                        f.a().a("not allowed sids");
                    }
                } catch (Throwable th) {
                    f.a().a(th);
                    f = new ArrayList();
                }
                if (z2 && z3) {
                    List activeSubscriptionInfoList = SubscriptionManager.from(ax.g()).getActiveSubscriptionInfoList();
                    f.a().a("==== getSubIds");
                    if (activeSubscriptionInfoList == null || activeSubscriptionInfoList.isEmpty()) {
                        arrayList = new ArrayList();
                    } else {
                        f = new ArrayList();
                        Iterator it = activeSubscriptionInfoList.iterator();
                        while (it.hasNext()) {
                            f.add(Integer.valueOf(zx6.a(it.next()).getSubscriptionId()));
                        }
                        if (!f.isEmpty()) {
                            List<Integer> listA = a(ax.g(), f);
                            f = listA;
                            if (listA == null) {
                                f = new ArrayList();
                            }
                        }
                        list = f;
                    }
                } else {
                    arrayList = new ArrayList();
                }
                f = arrayList;
                if (!f.isEmpty()) {
                }
                list = f;
            } else {
                list = f;
            }
        }
        return list;
    }

    public static String a(int i2) {
        return i2 == 1 ? "CMCC" : i2 == 2 ? "CUCC" : i2 == 3 ? "CUXW" : i2 == 4 ? "CTCC" : GrsBaseInfo.CountryCodeSource.UNKNOWN;
    }

    public static String b(String str) {
        char[] charArray = str.toCharArray();
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((("0123456789ABCDEF".indexOf(charArray[i3]) * 16) + "0123456789ABCDEF".indexOf(charArray[i3 + 1])) & 255);
        }
        return new String(bArr);
    }

    public static byte[] c(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            int iDigit = Character.digit(charArray[i3 + 1], 16) | (Character.digit(charArray[i3], 16) << 4);
            if (iDigit > 127) {
                iDigit += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i2] = (byte) iDigit;
        }
        return bArr;
    }

    public static boolean d(Context context) {
        if (context == null) {
            return true;
        }
        return "wifi".equalsIgnoreCase(al.j());
    }

    public static String a(int i2, String str) {
        return str;
    }

    public static boolean b(Context context) {
        return c(context) == 1;
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        stringWriter.getBuffer().toString();
        return stringWriter.getBuffer().toString();
    }

    public static String a(boolean z) {
        String strD;
        try {
            strD = al.d();
        } catch (Throwable th) {
            f.a().a(th, "[FlyVerify][%s][%s] ==>%s", "Util", "getMNC", "Check mobile data encountered exception");
            strD = null;
        }
        if (!TextUtils.isEmpty(strD) && !"-1".equalsIgnoreCase(strD)) {
            return strD;
        }
        if (TextUtils.isEmpty(f2074a) || z) {
            f2074a = al.l();
        }
        return f2074a;
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            char[] cArr = i;
            sb.append(cArr[(bArr[i2] >> 4) & 15]);
            sb.append(cArr[bArr[i2] & 15]);
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00dc A[DONT_GENERATE, PHI: r3
      0x00dc: PHI (r3v2 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v3 android.database.Cursor) binds: [B:46:0x00da, B:42:0x00cf] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<Integer> a(Context context, List<Integer> list) {
        ArrayList arrayList;
        Cursor cursorQuery = null;
        if (list == null || list.isEmpty()) {
            arrayList = null;
        } else {
            for (Integer num : list) {
                if (num != null && (num.intValue() == 0 || num.intValue() == 1)) {
                    arrayList = new ArrayList();
                    break;
                }
            }
            arrayList = null;
        }
        if (arrayList == null) {
            return list;
        }
        if (("HUAWEI".equalsIgnoreCase(fq.d.l()) || "HONOR".equalsIgnoreCase(fq.d.l())) && Build.VERSION.SDK_INT <= 28) {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse("content://telephony/siminfo"), new String[]{"_id", "sim_id"}, "sim_id>=?", new String[]{"0"}, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        try {
                            int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("sim_id"));
                            int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                            int i4 = 0;
                            while (true) {
                                if (i4 >= list.size()) {
                                    break;
                                }
                                int iIntValue = list.get(i4).intValue();
                                if (iIntValue != -1 && iIntValue == i2) {
                                    list.set(i4, Integer.valueOf(i3));
                                    f.a().a("fixed = " + i3);
                                    break;
                                }
                                i4++;
                            }
                        } catch (Throwable th) {
                            f.a().a(th);
                        }
                    }
                }
            } catch (Throwable th2) {
                try {
                    f.a().a(th2);
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
            if (cursorQuery != null) {
            }
        }
        return list;
    }

    public static void a(ar arVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            arVar.b();
        } else {
            arVar.run();
        }
    }

    public static boolean a(Context context) {
        try {
            if (Build.VERSION.SDK_INT > 22 && ((TelephonyManager) context.getSystemService("phone")).getSimState() == 1) {
                f.a().b("[FlyVerify] ==>%s", "NO SIM");
                return false;
            }
        } catch (Throwable unused) {
        }
        return true;
    }
}
