package com.beizi.fusion.tool;

import android.os.Build;
import android.text.TextUtils;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import com.wifi.adsdk.utils.LxAdMiuiDevice;
import com.wifi.adsdk.utils.LxAdOSUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f4697a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static ac f4698a = new ac();
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        REALME("ColorOS", "ro.build.version.oplusrom"),
        OPPO("ColorOS", "ro.build.version.oplusrom"),
        MIUI(LxAdOSUtils.ROM_MIUI, "ro.miui.ui.version.name"),
        HYPER("HyperOS", "ro.mi.os.version.incremental"),
        REDMI(LxAdOSUtils.ROM_MIUI, "ro.miui.ui.version.name"),
        HARMONY("HarmonyOS", "hw_sc.build.platform.version"),
        MAGICUI("MagicUI", "ro.build.version.magic"),
        EMUI(LxAdOSUtils.ROM_EMUI, LxAdEmuiDevice.PROP_VERSION),
        MEIZU("Flyme", "ro.build.display.id"),
        ONEPLUS("HydrogenOS", "ro.rom.version"),
        VIVO("Funtouch", "ro.vivo.os.version"),
        NUBIA("ro.build.nubia.rom.name", "ro.build.nubia.rom.code");

        private final String m;
        private final String n;

        b(String str, String str2) {
            this.m = str;
            this.n = str2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4700a;
        private final String b;
        private final String c;

        private c(String str, String str2, String str3) {
            this.f4700a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    public static ac a() {
        return a.f4698a;
    }

    private void c(String str) {
        try {
            if (Integer.valueOf(com.beizi.ad.internal.e.o.a(LxAdMiuiDevice.PROP_VERSION, "0")).intValue() >= 816) {
                a(str, b.HYPER);
                return;
            }
        } catch (NumberFormatException unused) {
        }
        a(str, b.MIUI);
    }

    private String d(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll(" ", "").toUpperCase() : "";
    }

    private String e(String str) {
        return com.beizi.ad.internal.e.o.a(str, "");
    }

    public void b() {
        b bVarValueOf;
        if (this.f4697a != null) {
        }
        String strD = d(Build.BRAND);
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        try {
            bVarValueOf = b.valueOf(strD);
        } catch (Throwable unused) {
            bVarValueOf = null;
        }
        if (bVarValueOf != null) {
            a(strD, bVarValueOf);
            return;
        }
        strD.hashCode();
        switch (strD) {
            case "XIAOMI":
                c(strD);
                break;
            case "HONOR":
                b(strD);
                break;
            case "HUAWEI":
                a(strD);
                break;
        }
    }

    private ac() {
        if (a.f4698a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    private void a(String str, b bVar) {
        if (TextUtils.isEmpty(bVar.m)) {
            return;
        }
        this.f4697a = new c(str, bVar.m.contains(".") ? e(bVar.m) : bVar.m, e(bVar.n));
    }

    private boolean d() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Exception unused) {
            return false;
        }
    }

    public String c() {
        c cVar = this.f4697a;
        return cVar != null ? cVar.c : "";
    }

    private void a(String str) {
        if (d()) {
            a(str, b.HARMONY);
        } else {
            a(str, b.EMUI);
        }
    }

    private void b(String str) {
        if (d()) {
            a(str, b.HARMONY);
            return;
        }
        b bVar = b.MAGICUI;
        if (!TextUtils.isEmpty(e(bVar.n))) {
            a(str, bVar);
        } else {
            a(str, b.EMUI);
        }
    }
}
