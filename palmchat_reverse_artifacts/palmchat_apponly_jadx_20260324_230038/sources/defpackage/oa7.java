package defpackage;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.alipay.a;
import org.json.alipay.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class oa7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<oe7> f19729a;

    static {
        ArrayList arrayList = new ArrayList();
        f19729a = arrayList;
        arrayList.add(new kg7());
        f19729a.add(new x87());
        f19729a.add(new s47());
        f19729a.add(new ce7());
        f19729a.add(new bg7());
        f19729a.add(new a27());
        f19729a.add(new tw6());
        f19729a.add(new kd7());
    }

    public static final <T> T a(Object obj, Type type) {
        T t;
        for (oe7 oe7Var : f19729a) {
            if (oe7Var.a(dx6.a(type)) && (t = (T) oe7Var.b(obj, type)) != null) {
                return t;
            }
        }
        return null;
    }

    public static final Object b(String str, Type type) {
        Object bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("[") && strTrim.endsWith("]")) {
            bVar = new a(strTrim);
        } else {
            if (!strTrim.startsWith("{") || !strTrim.endsWith("}")) {
                return a(strTrim, type);
            }
            bVar = new b(strTrim);
        }
        return a(bVar, type);
    }
}
