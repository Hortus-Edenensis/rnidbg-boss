package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class pq {

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements Runnable {
        private final String fx = Log.getStackTraceString(new RuntimeException("origin stacktrace"));
        private final String nr;
        private final Runnable u;

        public u(Runnable runnable, String str) {
            this.u = runnable;
            this.nr = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.u.run();
            } catch (Exception e) {
                ti.fx("Thread:" + this.nr + " exception\n" + this.fx, e);
            }
        }
    }

    public static boolean u(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 128) != null;
    }

    public static boolean u(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    public static void u(@Nullable String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TrackerDr";
        }
        new com.bytedance.sdk.component.jk.b.fx(new u(runnable, str), str).start();
    }
}
