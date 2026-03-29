package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class x {

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private String b;
        private Drawable fx;
        private int iz;
        private String nr;
        private String pn;
        private String u;
        private boolean x;

        public u(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            nr(str2);
            u(drawable);
            u(str);
            fx(str3);
            b(str4);
            u(i);
            u(z);
        }

        public String b() {
            return this.nr;
        }

        public String fx() {
            return this.u;
        }

        public int iz() {
            return this.iz;
        }

        public boolean nr() {
            return this.x;
        }

        public String pn() {
            return this.b;
        }

        public String toString() {
            return "{\n  pkg name: " + fx() + "\n  app icon: " + u() + "\n  app name: " + b() + "\n  app path: " + pn() + "\n  app v name: " + x() + "\n  app v code: " + iz() + "\n  is system: " + nr() + "}";
        }

        public Drawable u() {
            return this.fx;
        }

        public String x() {
            return this.pn;
        }

        public void b(String str) {
            this.pn = str;
        }

        public void fx(String str) {
            this.b = str;
        }

        public void nr(String str) {
            this.nr = str;
        }

        public void u(Drawable drawable) {
            this.fx = drawable;
        }

        public void u(boolean z) {
            this.x = z;
        }

        public void u(String str) {
            this.u = str;
        }

        public void u(int i) {
            this.iz = i;
        }
    }

    private static boolean fx(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static u nr(String str) {
        try {
            PackageManager packageManager = com.ss.android.socialbase.downloader.downloader.fx.oa().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return u(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            com.ss.android.socialbase.downloader.fx.u.pn("AppUtils", "getAppInfo:" + e.getMessage());
            return null;
        }
    }

    public static int u(String str) {
        if (fx(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = com.ss.android.socialbase.downloader.downloader.fx.oa().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            com.ss.android.socialbase.downloader.fx.u.pn("AppUtils", "getAppVersionCode:" + e.getMessage());
            return -1;
        }
    }

    private static u u(PackageManager packageManager, PackageInfo packageInfo) {
        Drawable drawableLoadIcon = null;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str = packageInfo.packageName;
        String string = (applicationInfo == null || applicationInfo.loadLabel(packageManager) == null) ? "" : applicationInfo.loadLabel(packageManager).toString();
        try {
            drawableLoadIcon = applicationInfo.loadIcon(packageManager);
        } catch (Exception unused) {
        }
        return new u(str, string, drawableLoadIcon, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }
}
