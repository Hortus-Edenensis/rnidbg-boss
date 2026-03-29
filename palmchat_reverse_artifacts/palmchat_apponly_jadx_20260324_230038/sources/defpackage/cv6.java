package defpackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;
import com.wifi.adsdk.utils.LxAdEmuiDevice;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class cv6 {
    public static g07 a(Context context) {
        String str = Build.BRAND;
        xv6.c("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为")) {
            return new p07();
        }
        if (str.equalsIgnoreCase("xiaomi") || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new we7();
        }
        if (str.equalsIgnoreCase("vivo")) {
            return new je7();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new dc7();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new i47();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new fa7();
        }
        if (str.equalsIgnoreCase("samsung")) {
            return new fd7();
        }
        if (c()) {
            return new p07();
        }
        if (str.equalsIgnoreCase(AssistUtils.BRAND_MZ) || str.equalsIgnoreCase("mblu")) {
            return new f87();
        }
        return null;
    }

    public static String b(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean c() {
        return (TextUtils.isEmpty(b(LxAdEmuiDevice.PROP_VERSION)) && TextUtils.isEmpty(b("hw_sc.build.platform.version"))) ? false : true;
    }
}
