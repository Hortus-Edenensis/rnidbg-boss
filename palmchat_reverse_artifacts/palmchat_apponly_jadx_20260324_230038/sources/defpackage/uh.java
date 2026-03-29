package defpackage;

import com.igexin.push.core.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class uh {
    public static String a(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null && !str.equals("")) {
            str2 = str + " ";
        }
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(obj2);
        if (strValueOf.equals(strValueOf2)) {
            return str2 + "expected: " + b(obj, strValueOf) + " but was: " + b(obj2, strValueOf2);
        }
        return str2 + "expected:<" + strValueOf + "> but was:<" + strValueOf2 + ">";
    }

    public static String b(Object obj, String str) {
        return (obj == null ? b.m : obj.getClass().getName()) + "<" + str + ">";
    }
}
