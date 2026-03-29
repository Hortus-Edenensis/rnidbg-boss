package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.Date;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class sn2 {
    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        wm3.a(str);
    }

    public static boolean b(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isDirectory();
        }
        file.mkdirs();
        return true;
    }

    public static String c(String str) {
        return String.format("%s_%d", str, Long.valueOf(new Date().getTime()));
    }

    public static int d(String str) {
        int iLastIndexOf = str.lastIndexOf("_");
        int iLastIndexOf2 = str.lastIndexOf(".");
        if (iLastIndexOf < 0) {
            return 0;
        }
        return Integer.parseInt(str.substring(iLastIndexOf + 1, iLastIndexOf2));
    }

    public static String e() {
        b(pu1.f + "/edit/");
        return pu1.f + "/edit/";
    }

    public static String f(String str) {
        int iLastIndexOf = str.lastIndexOf("/");
        int iLastIndexOf2 = str.lastIndexOf(".");
        if (iLastIndexOf == -1 || iLastIndexOf2 == -1 || iLastIndexOf >= iLastIndexOf2) {
            return null;
        }
        return str.substring(iLastIndexOf + 1, iLastIndexOf2);
    }

    public static String g(String str) {
        String strF = f(str);
        int iLastIndexOf = strF.lastIndexOf("_");
        return iLastIndexOf < 0 ? strF : strF.substring(0, iLastIndexOf);
    }

    public static String h(String str, int i) {
        return String.format("%s_%d.jpeg", str, Integer.valueOf(i + 1));
    }

    public static String i(String str, int i, boolean z) {
        String strE = e();
        b(strE);
        if (z) {
            str = c(str);
        }
        return strE + h(str, i);
    }
}
