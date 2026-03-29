package com.opos.cmn.d;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {
    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        return b(context) + File.separator + ".material";
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return com.opos.cmn.an.e.b.a.a() ? context.getExternalFilesDir(".mob_ad").getAbsolutePath() : "";
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("", "getMobAdFolderPath", (Throwable) e);
            return "";
        }
    }

    public static String a(Context context, String str) {
        return (context == null || com.opos.cmn.an.d.b.a(str)) ? "" : b(context, a(str));
    }

    private static String b(Context context, String str) {
        if (context == null || com.opos.cmn.an.d.b.a(str)) {
            return "";
        }
        return a(context) + File.separator + str;
    }

    public static String a(String str) {
        return !com.opos.cmn.an.d.b.a(str) ? com.opos.cmn.an.b.c.a(str) : "";
    }
}
