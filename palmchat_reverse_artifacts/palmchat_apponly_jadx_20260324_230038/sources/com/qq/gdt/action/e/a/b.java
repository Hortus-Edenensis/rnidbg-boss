package com.qq.gdt.action.e.a;

import android.os.Build;
import android.os.SystemClock;
import com.qq.gdt.action.j.o;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static List<String> f10479a = Arrays.asList("/", "/system", "/system/build.prop", "/system/etc", "/system/framework", "/system/fonts", "/system/usr", "/system/vendor", "/system/app", "/system/bin", "/system/lib", "/system/media", "/data", "/storage/emulated/0", "/storage/emulated");
    private static a b;

    public static a a(String str) {
        a aVar = b;
        return aVar == null ? b(str) : aVar;
    }

    private static long b() {
        long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        a("bootTime", jCurrentTimeMillis + "");
        return jCurrentTimeMillis;
    }

    private static String c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < f10479a.size(); i++) {
            try {
                String str = f10479a.get(i);
                try {
                    System.currentTimeMillis();
                    jSONObject.put(str, com.qq.gdt.action.e.a.a.b.a(f10479a.get(i)));
                } catch (Exception e) {
                    try {
                        jSONObject.put(str, "error");
                    } catch (Exception unused) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        String string = jSONObject.toString();
        a("nodeinfo cost  ", (System.currentTimeMillis() - jCurrentTimeMillis) + " nodeinfo = " + string);
        return string;
    }

    private static String a() {
        return com.qq.gdt.action.e.a.a.a.a("/proc/sys/kernel/random/boot_id");
    }

    private static a b(String str) {
        a aVar = b;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        try {
            aVar2.a(System.currentTimeMillis() + "");
            long jB = b();
            aVar2.b(jB + "");
            aVar2.c((jB / 10) + "");
            aVar2.d(a());
            String strC = c();
            aVar2.q(strC);
            aVar2.p(c(strC));
            a(aVar2, str);
            a(aVar2);
            a aVar3 = new a();
            aVar3.p(c(strC));
            a(aVar3, str);
            a(aVar3);
            aVar2.r(c(aVar3.toString()));
            b = aVar2;
            a("lastResult", aVar3.toString());
            a("aCaidInfo", aVar2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aVar2;
    }

    private static String c(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "hashfail";
        }
    }

    private static void a(a aVar) {
        try {
            aVar.o(Locale.getDefault().getLanguage());
            aVar.m(Locale.getDefault().getCountry());
            aVar.n(TimeZone.getDefault().getID());
        } catch (Exception e) {
            a("fillROMInfo", e.toString());
        }
    }

    private static void a(a aVar, String str) {
        try {
            aVar.e(Build.BOARD);
            aVar.f(Build.BRAND);
            aVar.g(Build.DEVICE);
            aVar.h(Build.TIME + "");
            aVar.i(str);
            aVar.j(Build.VERSION.INCREMENTAL);
            aVar.k(Build.VERSION.RELEASE);
            aVar.l(Build.MANUFACTURER);
        } catch (Exception e) {
            e.printStackTrace();
            a("fillROMInfo", e.toString());
        }
    }

    private static void a(String str, String str2) {
        o.a("tag AcidNode " + str + " value = " + str2, new Object[0]);
    }
}
