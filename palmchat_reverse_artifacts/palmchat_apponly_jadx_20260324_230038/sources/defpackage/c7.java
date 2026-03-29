package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class c7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1901a;
    public final int b;
    public final List<ow4> c;
    public final List<ab1> d;
    public final List<ab1> e;
    public final List<ab1> f;

    public c7(long j, int i, List<ow4> list, List<ab1> list2, List<ab1> list3, List<ab1> list4) {
        this.f1901a = j;
        this.b = i;
        this.c = Collections.unmodifiableList(list);
        this.d = Collections.unmodifiableList(list2);
        this.e = Collections.unmodifiableList(list3);
        this.f = Collections.unmodifiableList(list4);
    }
}
