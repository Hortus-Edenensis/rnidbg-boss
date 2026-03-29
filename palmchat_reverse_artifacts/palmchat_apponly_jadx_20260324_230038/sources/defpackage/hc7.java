package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.alipay.a;
import org.json.alipay.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class hc7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<lf7> f17929a;

    static {
        ArrayList arrayList = new ArrayList();
        f17929a = arrayList;
        arrayList.add(new kg7());
        f17929a.add(new x87());
        f17929a.add(new s47());
        f17929a.add(new ce7());
        f17929a.add(new a27());
        f17929a.add(new tw6());
        f17929a.add(new kd7());
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object objB = b(obj);
        if (dx6.b(objB.getClass())) {
            return b.c(objB.toString());
        }
        if (Collection.class.isAssignableFrom(objB.getClass())) {
            return new a((Collection) objB).toString();
        }
        if (Map.class.isAssignableFrom(objB.getClass())) {
            return new b((Map) objB).toString();
        }
        throw new IllegalArgumentException("Unsupported Class : " + objB.getClass());
    }

    public static Object b(Object obj) {
        Object objA;
        if (obj == null) {
            return null;
        }
        for (lf7 lf7Var : f17929a) {
            if (lf7Var.a(obj.getClass()) && (objA = lf7Var.a(obj)) != null) {
                return objA;
            }
        }
        throw new IllegalArgumentException("Unsupported Class : " + obj.getClass());
    }
}
