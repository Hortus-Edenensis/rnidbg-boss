package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.bq;
import com.ss.android.download.api.config.c;
import com.ss.android.download.api.config.my;
import com.ss.android.download.api.config.o;
import com.ss.android.download.api.config.sx;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.model.u;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.ss.android.download.api.model.u f10587a;
    private static com.ss.android.download.api.config.fx b;
    private static o bg;
    private static com.ss.android.download.api.nr.u bq;
    private static bq c;
    private static sx dw;
    private static com.ss.android.download.api.config.x fx;
    private static com.ss.android.download.api.config.n iz;
    private static com.ss.android.download.api.config.nr jk;
    private static com.ss.android.download.api.config.l k;
    private static com.ss.android.download.api.config.b l;
    private static com.ss.android.download.api.config.pn mv;
    private static c my;
    private static com.ss.android.download.api.config.t n;
    private static Context nr;
    private static com.ss.android.download.api.config.k o;
    private static com.ss.android.download.api.config.mv pn;
    private static com.ss.android.download.api.config.jk q;
    private static my s;
    private static com.ss.android.download.api.config.s sx;
    private static com.ss.android.socialbase.appdownloader.fx.a t;
    public static final JSONObject u = new JSONObject();
    private static com.ss.android.download.api.config.a x;

    @NonNull
    public static JSONObject a() {
        com.ss.android.download.api.config.t tVar = n;
        return (tVar == null || tVar.u() == null) ? u : n.u();
    }

    public static com.ss.android.download.api.config.n b() {
        return iz;
    }

    public static c bg() {
        return my;
    }

    @NonNull
    public static com.ss.android.download.api.nr.u bq() {
        if (bq == null) {
            bq = new com.ss.android.download.api.nr.u() { // from class: com.ss.android.downloadlib.addownload.l.4
                @Override // com.ss.android.download.api.nr.u
                public void u(Throwable th, String str) {
                }
            };
        }
        return bq;
    }

    public static com.ss.android.download.api.config.jk c() {
        return q;
    }

    @NonNull
    public static bq dw() {
        if (c == null) {
            c = new bq() { // from class: com.ss.android.downloadlib.addownload.l.5
            };
        }
        return c;
    }

    @NonNull
    public static com.ss.android.download.api.config.mv fx() {
        if (pn == null) {
            pn = new com.ss.android.download.api.u.u();
        }
        return pn;
    }

    public static Context getContext() {
        Context context = nr;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static com.ss.android.socialbase.appdownloader.fx.a iz() {
        if (t == null) {
            t = new com.ss.android.socialbase.appdownloader.fx.a() { // from class: com.ss.android.downloadlib.addownload.l.2
                @Override // com.ss.android.socialbase.appdownloader.fx.a
                public void u(DownloadInfo downloadInfo, BaseException baseException, int i) {
                }
            };
        }
        return t;
    }

    @NonNull
    public static com.ss.android.download.api.model.u jk() {
        if (f10587a == null) {
            f10587a = new u.C0841u().u();
        }
        return f10587a;
    }

    public static com.ss.android.download.api.config.b k() {
        return l;
    }

    @Nullable
    public static com.ss.android.download.api.config.nr l() {
        return jk;
    }

    @Nullable
    public static com.ss.android.download.api.config.k mv() {
        return o;
    }

    public static com.ss.android.download.api.config.pn my() {
        return mv;
    }

    @NonNull
    public static o n() {
        if (bg == null) {
            bg = new o() { // from class: com.ss.android.downloadlib.addownload.l.3
            };
        }
        return bg;
    }

    public static void nr(Context context) {
        if (nr != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        nr = context.getApplicationContext();
    }

    public static com.ss.android.download.api.config.l o() {
        return k;
    }

    @NonNull
    public static com.ss.android.download.api.config.a pn() {
        if (x == null) {
            x = new com.ss.android.download.api.u.nr();
        }
        return x;
    }

    public static String q() {
        try {
            int i = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + a().optString("default_save_dir_name", BaseConstants.DOWNLOAD_DIR);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean qq() {
        return (fx == null || iz == null || n == null || jk == null || dw == null) ? false : true;
    }

    public static String s() {
        return "1.7.0";
    }

    @NonNull
    public static sx sx() {
        return dw;
    }

    public static com.ss.android.download.api.config.s t() {
        return sx;
    }

    public static void u(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        nr = context.getApplicationContext();
    }

    public static my x() {
        return s;
    }

    @NonNull
    public static com.ss.android.download.api.config.fx nr() {
        if (b == null) {
            b = new com.ss.android.download.api.config.fx() { // from class: com.ss.android.downloadlib.addownload.l.1
            };
        }
        return b;
    }

    public static void u(@NonNull com.ss.android.download.api.config.x xVar) {
        fx = xVar;
    }

    public static void u(@NonNull com.ss.android.download.api.config.mv mvVar) {
        pn = mvVar;
    }

    public static void u(@NonNull com.ss.android.download.api.config.n nVar) {
        iz = nVar;
    }

    public static void u(@NonNull com.ss.android.download.api.config.a aVar) {
        x = aVar;
    }

    public static void u(@NonNull com.ss.android.download.api.config.t tVar) {
        n = tVar;
    }

    public static void u(@NonNull com.ss.android.download.api.model.u uVar) {
        f10587a = uVar;
    }

    public static void u(@NonNull com.ss.android.download.api.config.nr nrVar) {
        jk = nrVar;
    }

    public static com.ss.android.download.api.config.x u() {
        return fx;
    }

    public static void u(String str) {
        com.ss.android.socialbase.appdownloader.b.t().u(str);
    }

    public static void u(com.ss.android.socialbase.appdownloader.fx.fx fxVar) {
        com.ss.android.socialbase.appdownloader.b.t().u(fxVar);
    }

    public static void u(sx sxVar) {
        dw = sxVar;
    }

    public static void u(com.ss.android.download.api.nr.u uVar) {
        bq = uVar;
    }

    public static void u(com.ss.android.download.api.config.jk jkVar) {
        q = jkVar;
    }
}
