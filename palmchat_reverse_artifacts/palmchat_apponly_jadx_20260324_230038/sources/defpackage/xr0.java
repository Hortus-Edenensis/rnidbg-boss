package defpackage;

import android.os.Bundle;
import com.google.android.exoplayer2.f;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class xr0 implements f {
    public static final xr0 c = new xr0(ImmutableList.of(), 0);
    public static final String d = g86.w0(0);
    public static final String e = g86.w0(1);
    public static final f.a<xr0> f = new f.a() { // from class: tr0
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return xr0.c(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<pr0> f22036a;
    public final long b;

    public xr0(List<pr0> list, long j) {
        this.f22036a = ImmutableList.copyOf((Collection) list);
        this.b = j;
    }

    public static ImmutableList<pr0> b(List<pr0> list) {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).d == null) {
                aVarBuilder.a(list.get(i));
            }
        }
        return aVarBuilder.e();
    }

    public static final xr0 c(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(d);
        return new xr0(parcelableArrayList == null ? ImmutableList.of() : hv.d(pr0.K, parcelableArrayList), bundle.getLong(e));
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(d, hv.i(b(this.f22036a)));
        bundle.putLong(e, this.b);
        return bundle;
    }
}
