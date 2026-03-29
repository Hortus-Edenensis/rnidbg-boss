package defpackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.kuaishou.weapon.p0.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class i36 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<String> f18097a;

    static {
        ArrayList arrayList = new ArrayList();
        f18097a = arrayList;
        arrayList.add("358673013795895");
        f18097a.add("004999010640000");
        f18097a.add("00000000000000");
        f18097a.add("000000000000000");
    }

    public static String a(Context context) {
        zz2<String> zz2VarZ = zz2.Z();
        String str = (String) lg5.f(context, zz2VarZ);
        if (str != null) {
            return str;
        }
        String string = UUID.randomUUID().toString();
        lg5.h(context, zz2VarZ.a0(string));
        return string;
    }

    public static String b(Context context) {
        k63.a("UDIDUtils", "Action:getSavedUuid");
        String str = (String) lg5.f(context, zz2.Z());
        if (!nl5.i(str)) {
            return str;
        }
        if (!ad.y()) {
            return a(context);
        }
        String str2 = (String) lg5.c(context, zz2.g());
        return TextUtils.isEmpty(str2) ? Build.VERSION.SDK_INT < 23 ? c(context) : (ad.s(context, g.j) && ad.s(context, g.i)) ? c(context) : a(context) : str2;
    }

    public static String c(Context context) {
        String strG = g();
        File file = !nl5.i(strG) ? new File(strG) : null;
        String strI = hv1.i(file);
        if (!TextUtils.isEmpty(strI)) {
            lg5.h(context, zz2.g().a0(strI));
            k63.g("UDIDUtils", "Got sdcard file saved udid - " + strI);
            return strI;
        }
        String strQ = nl5.q(UUID.nameUUIDFromBytes((System.currentTimeMillis() + "").getBytes()).toString());
        lg5.h(context, zz2.g().a0(strQ));
        hv1.j(file, strQ);
        return strQ;
    }

    public static String d(Context context) {
        String str = (String) lg5.c(context, zz2.f());
        if (!TextUtils.isEmpty(str)) {
            str = new String(Base64.decode(str, 2));
        }
        if (h(str)) {
            return str;
        }
        String strE = e(context);
        if (!TextUtils.isEmpty(strE)) {
            lg5.h(context, zz2.f().a0(Base64.encodeToString(strE.getBytes(), 2)));
        }
        return strE;
    }

    public static String e(Context context) {
        try {
            String str = vb1.a(context).p;
            if (h(str)) {
                return str;
            }
            String str2 = vb1.a(context).j;
            if (h(str2) && !"9774d56d682e549c".equals(str2.toLowerCase(Locale.getDefault()))) {
                return str2;
            }
            String strF = f(context);
            return h(strF) ? strF : "";
        } catch (Exception e) {
            k63.d("UDIDUtils", "", e);
            String strB = b(context);
            return h(strB) ? strB : "";
        }
    }

    public static String f(Context context) {
        String strB = b(context);
        return strB == null ? " " : strB;
    }

    public static String g() {
        String strJ = ad.j();
        if (strJ == null) {
            return null;
        }
        return strJ + ".push_udid";
    }

    public static boolean h(String str) {
        if (!nl5.k(str) || str.length() < 10) {
            return false;
        }
        Iterator<String> it = f18097a.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return false;
            }
        }
        return true;
    }
}
