package com.beizi.fusion.d.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.beizi.fusion.tool.aa;
import com.wifi.adsdk.utils.LxAdOSUtils;
import com.wifi.adsdk.utils.LxAdOppoDevice;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f4624a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(String str);
    }

    public b(a aVar) {
        this.f4624a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public boolean c() {
        String strA = a("ro.build.freeme.label");
        return !TextUtils.isEmpty(strA) && strA.equalsIgnoreCase("FREEMEOS");
    }

    public boolean d() {
        String strA = a("ro.ssui.product");
        return (TextUtils.isEmpty(strA) || strA.equalsIgnoreCase("unknown")) ? false : true;
    }

    public static boolean b() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                return false;
            }
        }
        return true;
    }

    public void a(Context context) {
        String strA;
        a aVar;
        try {
            aa.c("BeiZis", "init oaid " + e());
            if ("ASUS".equals(e().toUpperCase()) || b()) {
                b(context);
            } else if ("LENOVO".equals(e().toUpperCase()) || "MOTOLORA".equals(e().toUpperCase())) {
                new d(context).a(this.f4624a);
            } else {
                if (!"MEIZU".equals(e().toUpperCase())) {
                    if ("NUBIA".equals(e().toUpperCase())) {
                        strA = new f(context).a();
                    } else if (a() || "SAMSUNG".equals(e().toUpperCase())) {
                        b(context);
                    } else if (LxAdOSUtils.ROM_VIVO.equals(e().toUpperCase())) {
                        strA = new j(context).a();
                    } else if ("XIAOMI".equals(e().toUpperCase()) || "BLACKSHARK".equals(e().toUpperCase())) {
                        strA = new k(context).a();
                    } else if ("ONEPLUS".equals(e().toUpperCase()) || "ZTE".equals(e().toUpperCase()) || "FERRMEOS".equals(e().toUpperCase()) || c() || "SSUI".equals(e().toUpperCase()) || d()) {
                        b(context);
                    }
                    aVar = this.f4624a;
                    if (aVar != null || strA == null) {
                    }
                    aVar.a(strA);
                    return;
                }
                new e(context).a(this.f4624a);
            }
            strA = null;
            aVar = this.f4624a;
            if (aVar != null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(final Context context) {
        new Thread(new Runnable() { // from class: com.beizi.fusion.d.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (context == null) {
                    return;
                }
                try {
                    if ("ASUS".equals(b.this.e().toUpperCase())) {
                        new com.beizi.fusion.d.a.a(context).a(b.this.f4624a);
                    } else if (b.b()) {
                        new c(context).a(b.this.f4624a);
                    } else if (b.a()) {
                        new h(context).a(b.this.f4624a);
                    } else if ("ONEPLUS".equals(b.this.e().toUpperCase())) {
                        new g(context).a(b.this.f4624a);
                    } else if ("ZTE".equals(b.this.e().toUpperCase()) || "FERRMEOS".equals(b.this.e().toUpperCase()) || b.this.c() || "SSUI".equals(b.this.e().toUpperCase()) || b.this.d()) {
                        new l(context).a(b.this.f4624a);
                    } else if ("SAMSUNG".equals(b.this.e().toUpperCase())) {
                        new i(context).a(b.this.f4624a);
                    }
                } catch (Throwable unused) {
                    aa.c("BeiZis", "getIDFromNewThead exception");
                }
            }
        }).start();
    }

    public static boolean a() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("OPPO") && !str.equalsIgnoreCase("REALME") && TextUtils.isEmpty(a(LxAdOppoDevice.PROP_VERSION, ""))) {
                return false;
            }
        }
        return true;
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            aa.c("BeiZis", "System property invoke error: " + e);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception unused) {
            return null;
        }
    }
}
