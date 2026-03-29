package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class ag4 {
    public static final List<ag4> d = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f1226a;
    public an5 b;
    public ag4 c;

    public ag4(Object obj, an5 an5Var) {
        this.f1226a = obj;
        this.b = an5Var;
    }

    public static ag4 a(an5 an5Var, Object obj) {
        List<ag4> list = d;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new ag4(obj, an5Var);
            }
            ag4 ag4VarRemove = list.remove(size - 1);
            ag4VarRemove.f1226a = obj;
            ag4VarRemove.b = an5Var;
            ag4VarRemove.c = null;
            return ag4VarRemove;
        }
    }

    public static void b(ag4 ag4Var) {
        ag4Var.f1226a = null;
        ag4Var.b = null;
        ag4Var.c = null;
        List<ag4> list = d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(ag4Var);
            }
        }
    }
}
