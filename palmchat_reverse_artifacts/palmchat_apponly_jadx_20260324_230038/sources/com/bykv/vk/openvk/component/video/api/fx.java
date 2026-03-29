package com.bykv.vk.openvk.component.video.api;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.nr.u.l;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx {
    private static boolean b = false;
    private static String fx = null;
    private static int iz = 1;
    private static Context nr = null;
    private static l pn = null;
    public static boolean u = false;

    public static boolean b() {
        return u;
    }

    public static l fx() {
        if (pn == null) {
            l.u uVar = new l.u("v_config");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            pn = uVar.u(10000L, timeUnit).nr(10000L, timeUnit).fx(10000L, timeUnit).u();
        }
        return pn;
    }

    public static Context getContext() {
        return nr;
    }

    public static boolean nr() {
        return b;
    }

    public static int pn() {
        return iz;
    }

    public static String u() {
        if (TextUtils.isEmpty(fx)) {
            try {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.nr.u(getContext()), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                fx = file.getAbsolutePath();
            } catch (Throwable unused) {
            }
        }
        return fx;
    }

    public static void u(Context context, String str) {
        nr = context;
        fx = str;
    }

    public static void u(boolean z) {
        b = z;
    }

    public static void u(l lVar) {
        pn = lVar;
    }
}
