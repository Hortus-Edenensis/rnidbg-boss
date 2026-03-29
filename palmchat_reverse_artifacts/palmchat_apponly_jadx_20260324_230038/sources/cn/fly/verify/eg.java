package cn.fly.verify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import cn.fly.verify.fq;
import cn.fly.verify.fy;
import com.oplus.tblplayer.Constants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class eg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f2226a;
    private static final byte[] b = new byte[0];

    /* JADX INFO: renamed from: cn.fly.verify.eg$4, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2229a;

        static {
            int[] iArr = new int[bb.values().length];
            f2229a = iArr;
            try {
                iArr[bb.JP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2229a[bb.US.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Context a() {
        try {
            Object objB = b();
            if (objB != null) {
                return (Context) fy.a(objB, ed.a("014Yee%fi(elWjjgHdi]cdiMdied(e"), new Object[0]);
            }
            return null;
        } catch (Throwable th) {
            en.a().b(th);
            return null;
        }
    }

    public static Object b() {
        final fy.a<Void, Object> aVar = new fy.a<Void, Object>() { // from class: cn.fly.verify.eg.1
            @Override // cn.fly.verify.fy.a
            public Object a(Void r4) {
                return fy.a(fy.a(ed.a("026deLdcdjeddidcfd>djjXfdelFci_didddi5i^dkek(h+djTfdVdc"), (String) null), ed.a("021c'dgdjdj0feiWelBciNdidddi<iZdkek?hWdjMfd%dc"), (Object) null, new Object[0]);
            }
        };
        int i = (Thread.currentThread().getId() > Looper.getMainLooper().getThread().getId() ? 1 : (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 0 : -1));
        Object objA = aVar.a(null);
        if (objA != null) {
            return objA;
        }
        final Object obj = new Object();
        final Object[] objArr = new Object[1];
        synchronized (obj) {
            gc.a(0, new Handler.Callback() { // from class: cn.fly.verify.eg.2
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    Object obj2;
                    synchronized (obj) {
                        try {
                            objArr[0] = aVar.a(null);
                            obj2 = obj;
                        } catch (Throwable th) {
                            try {
                                en.a().b(th);
                                obj2 = obj;
                            } catch (Throwable th2) {
                                obj.notify();
                                throw th2;
                            }
                        }
                        obj2.notify();
                    }
                    return false;
                }
            });
            try {
                obj.wait();
            } catch (Throwable th) {
                en.a().b(th);
            }
        }
        return objArr[0];
    }

    public static Object c(String str) throws Throwable {
        return fy.a(fy.a(fy.a(ed.a("017:hg*dGdd8d7fdAgdeReefdgidgAeiKdidfCf")), ed.a("010.eeVfi.gidgAei%didfVf"), new Object[0]), ed.a("004fKec5fc"), new Object[]{str}, (Class<?>[]) new Class[]{String.class});
    }

    public static Object d(String str) {
        try {
            return ax.g().getSystemService(str);
        } catch (Throwable th) {
            en.a().b(th);
            return null;
        }
    }

    public static Intent a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return (Intent) (Build.VERSION.SDK_INT < 33 ? fy.a(ax.g(), ed.a("016Fdj:f%eedifh<ifEdjgi?fcfOdidd,fQdj"), new Object[]{broadcastReceiver, intentFilter}, (Class<?>[]) new Class[]{BroadcastReceiver.class, IntentFilter.class}, (Object) null) : fy.a(ax.g(), ed.a("016Fdj*f1eedifh)if0djgi>fcfXdidd;f2dj"), new Object[]{broadcastReceiver, intentFilter, 4}, (Class<?>[]) new Class[]{BroadcastReceiver.class, IntentFilter.class, Integer.TYPE}, (Object) null));
    }

    public static String b(String str) {
        Uri uri;
        String scheme;
        String str2;
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            boolean zB = ax.b();
            if (zB || (Build.VERSION.SDK_INT >= 23 && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted())) {
                str = str.trim();
                if (str.startsWith(ed.a("007hiijkll")) && (uri = Uri.parse(str.trim())) != null && (scheme = uri.getScheme()) != null && scheme.equals(ed.a("004hiij"))) {
                    String host = uri.getHost();
                    String path = uri.getPath();
                    String query = uri.getQuery();
                    String str3 = "";
                    if (host != null) {
                        int port = uri.getPort();
                        StringBuilder sb = new StringBuilder();
                        sb.append(host);
                        if (port <= 0 || port == 80) {
                            str2 = "";
                        } else {
                            str2 = ":" + port;
                        }
                        sb.append(str2);
                        host = sb.toString();
                        if (!zB && Build.VERSION.SDK_INT >= 24 && ((Boolean) fy.a((Object) NetworkSecurityPolicy.getInstance(), ed.a("027Wdifhgk9gfdXdj-ifTec^iAekdj$dOefefdiXc6gl[fRdjdfdiTiif'dc"), host)).booleanValue()) {
                            return str;
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("https://");
                    sb2.append(host);
                    if (path == null) {
                        path = "";
                    }
                    sb2.append(path);
                    if (query != null) {
                        str3 = Constants.STRING_VALUE_UNSET + query;
                    }
                    sb2.append(str3);
                    return sb2.toString();
                }
            }
        } catch (Throwable th) {
            en.a().a(th);
        }
        return str;
    }

    public static byte[] c() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        Throwable th;
        try {
            SecureRandom secureRandom = new SecureRandom();
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeLong(secureRandom.nextLong());
                    dataOutputStream.writeLong(secureRandom.nextLong());
                    dataOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(dataOutputStream, byteArrayOutputStream);
                    return byteArray;
                } catch (Throwable th2) {
                    th = th2;
                    a(dataOutputStream, byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = null;
                th = th;
                a(dataOutputStream, byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            dataOutputStream = null;
        }
    }

    public static String d() {
        if (TextUtils.isEmpty(f2226a)) {
            synchronized (b) {
                try {
                    if (TextUtils.isEmpty(f2226a)) {
                        f2226a = new gd(ax.g()).a();
                    }
                } finally {
                }
            }
        }
        return f2226a;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        StringBuilder sb;
        String strA;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strA2 = "";
        if (str.startsWith(ed.a("007hiijkll"))) {
            str = str.replace(ed.a("007hiijkll"), "");
        }
        if (str.startsWith("https://")) {
            str = str.replace("https://", "");
        }
        if (!ax.c()) {
            int i = AnonymousClass4.f2229a[ax.a().ordinal()];
            if (i != 1) {
                str2 = i == 2 ? "002Kdgfh" : "002Zddhh";
            } else {
                strA2 = "jp";
            }
            if (TextUtils.isEmpty(strA2)) {
                if (!str.startsWith(strA2 + ".")) {
                    sb = new StringBuilder();
                    sb.append(ed.a("007hiijkll"));
                    sb.append(strA2);
                    strA = "-";
                    sb.append(strA);
                    sb.append(str);
                    return b(sb.toString());
                }
                sb = new StringBuilder();
            } else {
                sb = new StringBuilder();
            }
            strA = ed.a("007hiijkll");
            sb.append(strA);
            sb.append(str);
            return b(sb.toString());
        }
        strA2 = ed.a(str2);
        if (TextUtils.isEmpty(strA2)) {
        }
        strA = ed.a("007hiijkll");
        sb.append(strA);
        sb.append(str);
        return b(sb.toString());
    }

    private static void b(File file) {
        fy.a(file, ed.a("006RdcNfgfif"), (Object[]) null, (Class<?>[]) null, (Object) null);
    }

    public static String a(String str, int i) {
        int i2 = 0;
        int i3 = 3;
        int i4 = Integer.parseInt(str.startsWith("00") ? str.substring(2, 3) : str.startsWith("0") ? str.substring(1, 3) : str.substring(0, 3));
        char[] charArray = str.toCharArray();
        int[] iArr = new int[i4];
        boolean z = true;
        while (i3 < charArray.length) {
            char c = charArray[i3];
            if (c < 'a') {
                z = !z;
            } else {
                int i5 = c - i;
                if (z) {
                    iArr[i2] = i5;
                } else {
                    int i6 = i5 * 10;
                    iArr[i2] = i6;
                    i3++;
                    iArr[i2] = i6 + (charArray[i3] - i);
                }
                int i7 = iArr[i2];
                i2++;
            }
            i3++;
        }
        return cn.a(iArr);
    }

    public static void a(BroadcastReceiver broadcastReceiver) {
        fy.a(ax.g(), ed.a("018Ddg eLdjXfLeedifhKifKdjgiSfcfGdiddSfNdj"), new Object[]{broadcastReceiver}, (Class<?>[]) new Class[]{BroadcastReceiver.class}, (Object) null);
    }

    public static void a(final ge<ArrayList<HashMap<String, Object>>> geVar) {
        fq.a(ax.g()).H().J().a(new fq.a() { // from class: cn.fly.verify.eg.3
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                ArrayList arrayList = new ArrayList();
                try {
                    ArrayList<HashMap<String, Object>> arrayListG = bVar.G();
                    if (arrayListG != null && !arrayListG.isEmpty()) {
                        ArrayList<String> arrayListG2 = by.g();
                        if (arrayListG2 != null && !arrayListG2.isEmpty()) {
                            String strI = bVar.I();
                            for (HashMap<String, Object> map : arrayListG) {
                                Object obj = map.get(ed.a("005Mfiejejeifk"));
                                if (obj != null && String.valueOf(obj).equals(strI)) {
                                    map.put(ed.a("010HdhdhdhMcOdgdjgkedTee"), Boolean.TRUE);
                                    strI = null;
                                }
                                HashMap map2 = new HashMap();
                                for (String str : arrayListG2) {
                                    Object obj2 = map.get(str);
                                    if (obj2 != null) {
                                        map2.put(str, obj2);
                                    }
                                }
                                arrayList.add(map2);
                            }
                        }
                        geVar.a(null);
                        return;
                    }
                } catch (Throwable th) {
                    en.a().b(th);
                }
                ge geVar2 = geVar;
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
                geVar2.a(arrayList);
            }
        });
    }

    public static void a(File file) throws Throwable {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            b(file);
            return;
        }
        String[] list = file.list();
        if (list == null || list.length == 0) {
            b(file);
            return;
        }
        for (String str : list) {
            File file2 = new File(file, str);
            if (file2.isDirectory()) {
                a(file2);
            } else {
                b(file2);
            }
        }
        b(file);
    }

    public static void a(Closeable... closeableArr) {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    en.a().a(th);
                }
            }
        }
    }

    public static boolean a(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return false;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(new Date(j)).equals(simpleDateFormat.format(new Date(j2)));
        } catch (Throwable th) {
            en.a().a(th);
            return false;
        }
    }
}
