package com.ss.android.socialbase.downloader.fx;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u {
    private static AbstractC0875u nr = null;
    private static int u = 4;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.fx.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static abstract class AbstractC0875u {
    }

    public static void b(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (u <= 5) {
            nr(str);
        }
        if (nr != null) {
            nr(str);
        }
    }

    public static void fx(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (u <= 4) {
            nr(str);
        }
        if (nr != null) {
            nr(str);
        }
    }

    public static String nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "DownloaderLogger";
        }
        return "Downloader-" + str;
    }

    public static void pn(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (u <= 6) {
            k.nr(nr(str), str2);
        }
        if (nr != null) {
            nr(str);
        }
    }

    public static void u(int i) {
        u = i;
    }

    public static boolean u() {
        return u <= 3;
    }

    public static void nr(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (u <= 3) {
            nr(str);
        }
        if (nr != null) {
            nr(str);
        }
    }

    public static void u(String str, String str2) {
        if (str2 == null || nr == null) {
            return;
        }
        nr(str);
    }

    public static void fx(String str) {
        b("DownloaderLogger", str);
    }

    public static void u(String str) {
        nr("DownloaderLogger", str);
    }

    public static void u(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (u <= 3) {
            nr(str);
        }
        if (nr != null) {
            nr(str);
        }
    }

    public static void nr(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (u <= 6) {
            k.u(nr(str), str2, th);
        }
        if (nr != null) {
            nr(str);
        }
    }
}
