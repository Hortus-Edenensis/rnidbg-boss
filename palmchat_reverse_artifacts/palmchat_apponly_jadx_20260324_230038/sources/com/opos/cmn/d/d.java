package com.opos.cmn.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.kuaishou.weapon.p0.g;
import com.opos.cmn.i.j;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {
    public static String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(com.opos.cmn.an.e.b.a.b());
        String str = File.separator;
        sb.append(str);
        sb.append(".mob_ad");
        sb.append(str);
        sb.append(".material");
        sb.append(str);
        sb.append(".video");
        return sb.toString();
    }

    public static String b(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getExternalFilesDir(".mob_ad").getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append(".material");
        sb.append(str);
        sb.append(".video");
        return sb.toString();
    }

    private static String c(Context context, String str) {
        if (com.opos.cmn.an.d.b.a(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getExternalFilesDir(".mob_ad").getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(".material");
        sb.append(str2);
        sb.append(".video");
        sb.append(str2);
        sb.append(b.a(str));
        return sb.toString();
    }

    public static String a(Context context, String str) {
        if (!com.opos.cmn.an.e.b.a.a()) {
            return "";
        }
        if (a(context)) {
            String strA = a(str);
            if (com.opos.cmn.an.e.b.a.a(strA)) {
                return strA;
            }
        }
        String strC = c(context, str);
        return com.opos.cmn.an.e.b.a.a(strC) ? strC : "";
    }

    @TargetApi(29)
    public static String b(Context context, String str) {
        return (!com.opos.cmn.an.e.b.a.a() || com.opos.cmn.an.d.b.a(str)) ? "" : c(context, str);
    }

    public static String a(Context context, String str, String str2) {
        if (!com.opos.cmn.an.e.b.a.a()) {
            return "";
        }
        if (a(context)) {
            String strA = a(str);
            if (b.a(strA, str2)) {
                return strA;
            }
        }
        String strC = c(context, str);
        return b.a(strC, str2) ? strC : "";
    }

    private static String a(String str) {
        if (com.opos.cmn.an.d.b.a(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(com.opos.cmn.an.e.b.a.b());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(".mob_ad");
        sb.append(str2);
        sb.append(".material");
        sb.append(str2);
        sb.append(".video");
        sb.append(str2);
        sb.append(b.a(str));
        return sb.toString();
    }

    public static boolean a(Context context) {
        int i;
        return j.a(context, new String[]{g.j}) && (i = Build.VERSION.SDK_INT) < 33 && (i < 29 || Environment.isExternalStorageLegacy());
    }
}
