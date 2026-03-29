package defpackage;

import java.util.Comparator;
import java.util.SortedMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class x12<K, V> extends n12<K, V> implements SortedMap<K, V> {
    public static int a(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
    }
}
