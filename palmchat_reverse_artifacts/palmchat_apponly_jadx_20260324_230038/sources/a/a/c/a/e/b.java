package a.a.c.a.e;

import android.os.Build;
import android.text.TextUtils;
import com.wifi.adsdk.utils.LxAdEmuiDevice;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1121a = 0;

    static {
        new AtomicBoolean(false);
    }

    public static boolean a() {
        Class<?> cls;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (Exception e) {
            e.getMessage();
        }
        return !TextUtils.isEmpty((String) cls.getDeclaredMethod("get", String.class).invoke(cls, LxAdEmuiDevice.PROP_VERSION));
    }

    public static boolean b() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("honor")) {
            String str2 = Build.MANUFACTURER;
            if ((TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("honor")) && !"HONOR".equalsIgnoreCase(str2)) {
                return false;
            }
        }
        return true;
    }
}
