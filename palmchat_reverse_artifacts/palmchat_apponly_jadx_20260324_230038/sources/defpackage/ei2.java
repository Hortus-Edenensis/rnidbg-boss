package defpackage;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class ei2 implements mv1<ei2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17306a;
    public final List<String> b;
    public final boolean c;

    public ei2(String str, List<String> list, boolean z) {
        this.f17306a = str;
        this.b = Collections.unmodifiableList(list);
        this.c = z;
    }
}
