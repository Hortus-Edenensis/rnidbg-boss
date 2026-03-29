package defpackage;

import com.google.common.collect.Range;
import java.lang.Comparable;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface at4<C extends Comparable> {
    Set<Range<C>> asRanges();

    at4<C> complement();

    boolean encloses(Range<C> range);

    boolean isEmpty();

    void removeAll(at4<C> at4Var);

    at4<C> subRangeSet(Range<C> range);
}
