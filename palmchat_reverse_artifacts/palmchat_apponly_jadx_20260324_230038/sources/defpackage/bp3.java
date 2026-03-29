package defpackage;

import java.lang.reflect.Method;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class bp3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<Method> f1795a = new a();
    public static final Comparator<Method> b = new b();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Comparator<Method> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Method method, Method method2) {
            int iHashCode = method.getName().hashCode();
            int iHashCode2 = method2.getName().hashCode();
            return iHashCode != iHashCode2 ? iHashCode < iHashCode2 ? -1 : 1 : bp3.b.compare(method, method2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Comparator<Method> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Method method, Method method2) {
            int iCompareTo = method.getName().compareTo(method2.getName());
            return iCompareTo != 0 ? iCompareTo : method.toString().compareTo(method2.toString());
        }
    }
}
