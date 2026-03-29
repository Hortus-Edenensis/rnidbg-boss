package defpackage;

import com.google.common.collect.u;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class cj4 {
    public static <T> T[] a(Object[] objArr, int i, int i2, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i, i2, tArr.getClass());
    }

    public static <E extends Enum<E>> Class<E> b(E e) {
        return e.getDeclaringClass();
    }

    public static <T> T[] c(T[] tArr, int i) {
        if (tArr.length != 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 0);
        }
        return (T[]) Arrays.copyOf(tArr, i);
    }

    public static <K, V> Map<K, V> d(int i) {
        return bj0.H(i);
    }

    public static <E> Set<E> e(int i) {
        return cj0.r(i);
    }

    public static <K, V> Map<K, V> f(int i) {
        return ej0.s0(i);
    }

    public static <E> Set<E> g(int i) {
        return fj0.R(i);
    }

    public static <K, V> Map<K, V> h() {
        return bj0.A();
    }

    public static <K, V> Map<K, V> i(int i) {
        return u.s(i);
    }
}
