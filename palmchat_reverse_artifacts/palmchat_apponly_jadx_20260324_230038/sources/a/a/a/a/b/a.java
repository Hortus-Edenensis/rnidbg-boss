package a.a.a.a.b;

import a.a.a.a.a.a.g;
import a.a.a.a.a.a.h;
import a.a.a.a.a.a.i;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import com.bytedance.ad.common.interal.Nano;
import com.kuaishou.weapon.p0.t;
import com.zenmen.palmchat.ad.view.AdView;
import java.io.File;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f1064a = new b();

    /* JADX INFO: renamed from: a.a.a.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0000a implements a.a.a.a.a.a.j.a {
        @Override // a.a.a.a.a.a.j.a
        public void a(i uaidResult) {
            Intrinsics.checkNotNullParameter(uaidResult, "uaidResult");
            b bVar = a.f1064a;
            a.f1064a.a(uaidResult);
        }
    }

    public final b a(Context context, c config) {
        long totalBytes;
        String hostAddress;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        String str = null;
        try {
            NetworkInterface byName = NetworkInterface.getByName("wlan0");
            if (byName != null) {
                Enumeration<InetAddress> inetAddresses = byName.getInetAddresses();
                if (inetAddresses != null) {
                    String str2 = null;
                    while (inetAddresses.hasMoreElements()) {
                        try {
                            InetAddress inetAddressNextElement = inetAddresses.nextElement();
                            if ((inetAddressNextElement instanceof Inet6Address) && inetAddressNextElement.isLinkLocalAddress() && (hostAddress = inetAddressNextElement.getHostAddress()) != null && StringsKt__StringsJVMKt.startsWith$default(hostAddress, "fe80", false, 2, null)) {
                                str2 = hostAddress;
                            }
                        } catch (Exception e) {
                            e = e;
                            str = str2;
                            e.printStackTrace();
                        }
                    }
                    str = str2;
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        b bVar = f1064a;
        if (str == null) {
            str = "";
        }
        bVar.getClass();
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        bVar.f1065a = str;
        long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        b bVar2 = f1064a;
        String strValueOf = String.valueOf(jCurrentTimeMillis);
        bVar2.getClass();
        Intrinsics.checkNotNullParameter(strValueOf, "<set-?>");
        bVar2.d = strValueOf;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            Intrinsics.checkNotNullExpressionValue(externalStorageDirectory, "Environment.getExternalStorageDirectory()");
            totalBytes = new StatFs(externalStorageDirectory.getPath()).getTotalBytes();
        } catch (Exception unused) {
            totalBytes = -1;
        }
        b bVar3 = f1064a;
        String strValueOf2 = String.valueOf(totalBytes);
        bVar3.getClass();
        Intrinsics.checkNotNullParameter(strValueOf2, "<set-?>");
        bVar3.b = strValueOf2;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        Object systemService = context.getSystemService("activity");
        if (systemService instanceof ActivityManager) {
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        }
        b bVar4 = f1064a;
        String strValueOf3 = String.valueOf(memoryInfo.totalMem);
        bVar4.getClass();
        Intrinsics.checkNotNullParameter(strValueOf3, "<set-?>");
        bVar4.c = strValueOf3;
        JSONArray jSONArray = new JSONArray();
        try {
            HashMap map = new HashMap();
            map.put(AdView.DOUYIN, "a");
            map.put(AdView.DOUYIN_LITE, "al");
            map.put("com.dragon.read", t.k);
            map.put("com.ss.android.article.news", "n");
            map.put("com.ss.android.article.lite", "nl");
            PackageManager packageManager = context.getPackageManager();
            Set<Map.Entry> setEntrySet = map.entrySet();
            Intrinsics.checkNotNullExpressionValue(setEntrySet, "appPackageNameList.entries");
            for (Map.Entry entry : setEntrySet) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo((String) entry.getKey(), 0);
                    long j = packageInfo.firstInstallTime;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", entry.getValue());
                    jSONObject.put("i", j);
                    if (Intrinsics.areEqual((String) entry.getValue(), "a") || Intrinsics.areEqual((String) entry.getValue(), "n")) {
                        jSONObject.put("u", packageInfo.lastUpdateTime);
                    }
                    jSONArray.put(jSONObject);
                } catch (Throwable unused2) {
                }
            }
            b bVar5 = f1064a;
            bVar5.getClass();
            Intrinsics.checkNotNullParameter(jSONArray, "<set-?>");
            bVar5.e = jSONArray;
        } catch (Throwable unused3) {
        }
        if (config.b) {
            try {
                int[] iArrN = new Nano().n();
                b bVar6 = f1064a;
                bVar6.getClass();
                Intrinsics.checkNotNullParameter(iArrN, "<set-?>");
                bVar6.f = iArrN;
            } catch (Exception unused4) {
            }
        }
        f1064a = new b(f1064a);
        h.c.a(config.f1069a);
        if (config.f1069a.f1055a) {
            C0000a c0000a = new C0000a();
            Intrinsics.checkNotNullParameter(context, "context");
            new Thread(new g(context, c0000a)).start();
        }
        return f1064a;
    }
}
