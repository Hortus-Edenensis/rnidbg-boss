package com.igexin.assist.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.push.config.d;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.g.b;
import com.igexin.sdk.PushManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class AssistUtils {
    public static final String BRAND_HON = "honor";
    public static final String BRAND_HW = "huawei";
    public static final String BRAND_MZ = "meizu";
    public static final String BRAND_OPPO = "oppo";
    public static final String BRAND_STP = "stp";
    public static final String BRAND_VIVO = "vivo";
    public static final String BRAND_XIAOMI = "xiaomi";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f7006a = "";

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[PHI: r1
      0x002c: PHI (r1v5 java.lang.String) = 
      (r1v0 java.lang.String)
      (r1v1 java.lang.String)
      (r1v2 java.lang.String)
      (r1v3 java.lang.String)
      (r1v4 java.lang.String)
      (r1v6 java.lang.String)
     binds: [B:12:0x002a, B:15:0x003b, B:18:0x004a, B:21:0x0059, B:24:0x0068, B:9:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getDeviceBrand() {
        if (!TextUtils.isEmpty(f7006a)) {
            return f7006a;
        }
        if (d.U) {
            String str = "honor";
            if (b.a(ServiceManager.b.getApplicationContext(), "honor")) {
                f7006a = str;
            } else {
                str = "huawei";
                if (!b.a(ServiceManager.b.getApplicationContext(), "huawei")) {
                    str = "xiaomi";
                    if (!b.a(ServiceManager.b.getApplicationContext(), "xiaomi")) {
                        str = "oppo";
                        if (!b.a(ServiceManager.b.getApplicationContext(), "oppo")) {
                            Context applicationContext = ServiceManager.b.getApplicationContext();
                            str = BRAND_MZ;
                            if (!b.a(applicationContext, BRAND_MZ)) {
                                str = "vivo";
                                if (!b.a(ServiceManager.b.getApplicationContext(), "vivo")) {
                                    f7006a = b.a(ServiceManager.b) ? BRAND_STP : Build.BRAND;
                                }
                            }
                        }
                    }
                }
            }
        }
        return f7006a.toLowerCase();
    }

    public static void startGetuiService(Context context) {
        if (context != null) {
            try {
                PushManager.getInstance().initialize(context);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }
}
