package defpackage;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.f;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class g06 implements f {
    public static final String c = g86.w0(0);
    public static final String d = g86.w0(1);
    public static final f.a<g06> e = new f.a() { // from class: f06
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return g06.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qz5 f17630a;
    public final ImmutableList<Integer> b;

    public g06(qz5 qz5Var, List<Integer> list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= qz5Var.f20360a)) {
            throw new IndexOutOfBoundsException();
        }
        this.f17630a = qz5Var;
        this.b = ImmutableList.copyOf((Collection) list);
    }

    public static /* synthetic */ g06 c(Bundle bundle) {
        return new g06((qz5) qz5.h.fromBundle((Bundle) vh.e(bundle.getBundle(c))), ku2.c((int[]) vh.e(bundle.getIntArray(d))));
    }

    public int b() {
        return this.f17630a.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g06.class != obj.getClass()) {
            return false;
        }
        g06 g06Var = (g06) obj;
        return this.f17630a.equals(g06Var.f17630a) && this.b.equals(g06Var.b);
    }

    public int hashCode() {
        return this.f17630a.hashCode() + (this.b.hashCode() * 31);
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBundle(c, this.f17630a.toBundle());
        bundle.putIntArray(d, ku2.p(this.b));
        return bundle;
    }
}
