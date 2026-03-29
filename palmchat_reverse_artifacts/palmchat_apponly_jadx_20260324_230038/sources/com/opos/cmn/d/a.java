package com.opos.cmn.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.kuaishou.weapon.p0.g;
import com.opos.cmn.i.j;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    public static String a() {
        return com.opos.cmn.an.e.b.a.b() + File.separator + "MobDownload";
    }

    public static String b(Context context) {
        return c(context);
    }

    public static String c(Context context) {
        return context.getExternalFilesDir("MobDownload").getAbsolutePath();
    }

    public static String a(Context context, String str) {
        return !com.opos.cmn.an.e.b.a.a() ? "" : b(context, str);
    }

    private static String b(Context context, String str) {
        if (com.opos.cmn.an.d.b.a(str)) {
            return "";
        }
        return context.getExternalFilesDir("MobDownload").getAbsolutePath() + File.separator + b.a(str);
    }

    public static boolean a(Context context) {
        if (j.a(context, new String[]{g.j})) {
            return Build.VERSION.SDK_INT < 29 || Environment.isExternalStorageLegacy();
        }
        return false;
    }
}
