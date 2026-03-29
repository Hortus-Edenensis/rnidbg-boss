package defpackage;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.igexin.push.core.b;
import com.kuaishou.weapon.p0.g;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class jw2 {
    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() < 14) {
            return null;
        }
        return str;
    }

    public static String b(Context context, String str) {
        return g(context, str);
    }

    public static ArrayList<mw2> c(Context context) {
        String strB = b(context, kw2.a(4, 1));
        String strB2 = b(context, kw2.a(4, 0));
        if (strB != null && !TextUtils.isEmpty(strB)) {
            strB2 = strB2 + "," + strB;
        }
        String[] strArrSplit = TextUtils.isEmpty(strB2) ? null : strB2.split(",");
        int length = strArrSplit == null ? 1 : strArrSplit.length;
        if (length == 0) {
            return null;
        }
        ArrayList<mw2> arrayList = new ArrayList<>();
        String strF = f(context, strArrSplit);
        if (length == 1) {
            mw2 mw2Var = new mw2();
            mw2Var.f19378a = a(null);
            if (!"ABSENT".equalsIgnoreCase(strB2)) {
                mw2Var.c = strF == null ? null : strF.trim().replace(",", "");
                mw2Var.b = null;
            }
            arrayList.add(mw2Var);
        } else {
            String[] strArrSplit2 = strF != null ? strF.split(",") : null;
            for (int i = 0; i < 2; i++) {
                mw2 mw2Var2 = new mw2();
                if (!"ABSENT".equalsIgnoreCase(strArrSplit[i]) && strArrSplit2 != null && i < strArrSplit2.length) {
                    mw2Var2.c = strArrSplit2[i];
                }
                arrayList.add(mw2Var2);
            }
        }
        return arrayList;
    }

    public static mw2 d(Context context) {
        if (rv2.x(context, false, "need get getDefaultApiSimInfo")) {
            return null;
        }
        mw2 mw2Var = new mw2();
        mw2Var.b = "";
        mw2Var.c = e(context, "");
        mw2Var.f19378a = "";
        return mw2Var;
    }

    public static String e(Context context, String str) {
        try {
            if (rv2.x(context, false, "do not getIccid")) {
                return "";
            }
            if (rv2.v(context, g.c)) {
                str = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            } else {
                p63.f("JIGUANG-JDeviceImeiHelper", "collect simSerialNumber failed because has no android.permission.READ_PHONE_STATE");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String f(Context context, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int length = strArr.length;
        String strB = b(context, kw2.a(3, 0));
        if (strB != null && !TextUtils.isEmpty(strB.trim().replace(",", ""))) {
            return strB.replace(b.m, "").replace("N/A", "");
        }
        String str = b(context, kw2.a(3, 1)) + "," + b(context, kw2.a(3, 2));
        if (str != null && !TextUtils.isEmpty(str.trim().replace(",", ""))) {
            return str.replace(b.m, "").replace("N/A", "");
        }
        String str2 = b(context, kw2.a(3, 4)) + "," + b(context, kw2.a(3, 5));
        if (str2 != null && !TextUtils.isEmpty(str2.trim().replace(",", ""))) {
            return str2.replace(b.m, "").replace("N/A", "");
        }
        String strB2 = b(context, kw2.a(3, 6));
        if (strB2 != null && !TextUtils.isEmpty(strB2.trim().replace(",", ""))) {
            return strB2.replace(b.m, "").replace("N/A", "");
        }
        String str3 = b(context, kw2.a(3, 7)) + "," + b(context, kw2.a(3, 8));
        if (str3 != null && !TextUtils.isEmpty(str3.trim().replace(",", ""))) {
            return str3.replace(b.m, "").replace("N/A", "");
        }
        String str4 = b(context, kw2.a(3, 9)) + "," + b(context, kw2.a(3, 10));
        if (str4 != null && !TextUtils.isEmpty(str4.trim().replace(",", ""))) {
            return str4.replace(b.m, "").replace("N/A", "");
        }
        String str5 = b(context, kw2.a(3, 12)) + "," + b(context, kw2.a(3, 12));
        if (str5 != null && !TextUtils.isEmpty(str5.trim().replace(",", ""))) {
            return str5.replace(b.m, "").replace("N/A", "");
        }
        String str6 = b(context, kw2.a(3, 13)) + "," + b(context, kw2.a(3, 14));
        if (str6 != null && !TextUtils.isEmpty(str6.trim().replace(",", ""))) {
            return str6.replace(b.m, "").replace("N/A", "");
        }
        String strB3 = b(context, kw2.a(3, 3));
        if (length == 1) {
            str6 = strB3;
        } else if ("ABSENT".equalsIgnoreCase(strArr[1]) && !"ABSENT".equalsIgnoreCase(strArr[0])) {
            str6 = strB3 + ",";
        } else if (!"ABSENT".equalsIgnoreCase(strArr[1])) {
            str6 = "," + strB3;
        }
        return (str6 == null || TextUtils.isEmpty(str6.trim().replace(",", ""))) ? str6 : str6.replace(b.m, "").replace("N/A", "");
    }

    public static String g(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) clsLoadClass.getMethod("get", String.class).invoke(clsLoadClass, new String(str));
        } catch (Throwable unused) {
            return "";
        }
    }
}
