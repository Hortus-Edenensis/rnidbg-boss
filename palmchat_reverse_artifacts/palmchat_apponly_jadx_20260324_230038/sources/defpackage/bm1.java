package defpackage;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSetMultimap;
import java.util.Collection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bm1 extends ImmutableSetMultimap<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bm1 f1751a = new bm1();
    private static final long serialVersionUID = 0;

    public bm1() {
        super(ImmutableMap.of(), 0, null);
    }

    private Object readResolve() {
        return f1751a;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.d, defpackage.ps3
    public ImmutableMap<Object, Collection<Object>> asMap() {
        return super.asMap();
    }
}
