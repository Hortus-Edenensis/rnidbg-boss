package defpackage;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.f;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class vz5 implements f {
    public static final vz5 d = new vz5(new qz5[0]);
    public static final String e = g86.w0(0);
    public static final f.a<vz5> f = new f.a() { // from class: rz5
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return vz5.d(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21565a;
    public final ImmutableList<qz5> b;
    public int c;

    public vz5(qz5... qz5VarArr) {
        this.b = ImmutableList.copyOf(qz5VarArr);
        this.f21565a = qz5VarArr.length;
        e();
    }

    public static /* synthetic */ vz5 d(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(e);
        return parcelableArrayList == null ? new vz5(new qz5[0]) : new vz5((qz5[]) hv.d(qz5.h, parcelableArrayList).toArray(new qz5[0]));
    }

    public qz5 b(int i) {
        return this.b.get(i);
    }

    public int c(qz5 qz5Var) {
        int iIndexOf = this.b.indexOf(qz5Var);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public final void e() {
        int i = 0;
        while (i < this.b.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.b.size(); i3++) {
                if (this.b.get(i).equals(this.b.get(i3))) {
                    y53.d("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || vz5.class != obj.getClass()) {
            return false;
        }
        vz5 vz5Var = (vz5) obj;
        return this.f21565a == vz5Var.f21565a && this.b.equals(vz5Var.b);
    }

    public int hashCode() {
        if (this.c == 0) {
            this.c = this.b.hashCode();
        }
        return this.c;
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(e, hv.i(this.b));
        return bundle;
    }
}
