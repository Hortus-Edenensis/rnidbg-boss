package defpackage;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class mg4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f19213a;
    public final long b;
    public final List<c7> c;
    public final List<vn1> d;

    @Nullable
    public final ab1 e;

    public mg4(@Nullable String str, long j, List<c7> list, List<vn1> list2) {
        this(str, j, list, list2, null);
    }

    public int a(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.c.get(i2).b == i) {
                return i2;
            }
        }
        return -1;
    }

    public mg4(@Nullable String str, long j, List<c7> list, List<vn1> list2, @Nullable ab1 ab1Var) {
        this.f19213a = str;
        this.b = j;
        this.c = Collections.unmodifiableList(list);
        this.d = Collections.unmodifiableList(list2);
        this.e = ab1Var;
    }
}
