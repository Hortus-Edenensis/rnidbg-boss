package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.m;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class qz5 implements f {
    public static final String f = g86.w0(0);
    public static final String g = g86.w0(1);
    public static final f.a<qz5> h = new f.a() { // from class: oz5
        @Override // com.google.android.exoplayer2.f.a
        public final f fromBundle(Bundle bundle) {
            return qz5.e(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20360a;
    public final String b;
    public final int c;
    public final m[] d;
    public int e;

    public qz5(m... mVarArr) {
        this("", mVarArr);
    }

    public static /* synthetic */ qz5 e(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f);
        return new qz5(bundle.getString(g, ""), (m[]) (parcelableArrayList == null ? ImmutableList.of() : hv.d(m.u0, parcelableArrayList)).toArray(new m[0]));
    }

    public static void f(String str, @Nullable String str2, @Nullable String str3, int i) {
        y53.d("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + ")"));
    }

    public static String g(@Nullable String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    public static int h(int i) {
        return i | 16384;
    }

    @CheckResult
    public qz5 b(String str) {
        return new qz5(str, this.d);
    }

    public m c(int i) {
        return this.d[i];
    }

    public int d(m mVar) {
        int i = 0;
        while (true) {
            m[] mVarArr = this.d;
            if (i >= mVarArr.length) {
                return -1;
            }
            if (mVar == mVarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || qz5.class != obj.getClass()) {
            return false;
        }
        qz5 qz5Var = (qz5) obj;
        return this.b.equals(qz5Var.b) && Arrays.equals(this.d, qz5Var.d);
    }

    public int hashCode() {
        if (this.e == 0) {
            this.e = ((527 + this.b.hashCode()) * 31) + Arrays.hashCode(this.d);
        }
        return this.e;
    }

    public final void i() {
        String strG = g(this.d[0].c);
        int iH = h(this.d[0].e);
        int i = 1;
        while (true) {
            m[] mVarArr = this.d;
            if (i >= mVarArr.length) {
                return;
            }
            if (!strG.equals(g(mVarArr[i].c))) {
                m[] mVarArr2 = this.d;
                f("languages", mVarArr2[0].c, mVarArr2[i].c, i);
                return;
            } else {
                if (iH != h(this.d[i].e)) {
                    f("role flags", Integer.toBinaryString(this.d[0].e), Integer.toBinaryString(this.d[i].e), i);
                    return;
                }
                i++;
            }
        }
    }

    @Override // com.google.android.exoplayer2.f
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.d.length);
        for (m mVar : this.d) {
            arrayList.add(mVar.i(true));
        }
        bundle.putParcelableArrayList(f, arrayList);
        bundle.putString(g, this.b);
        return bundle;
    }

    public qz5(String str, m... mVarArr) {
        vh.a(mVarArr.length > 0);
        this.b = str;
        this.d = mVarArr;
        this.f20360a = mVarArr.length;
        int iK = fp3.k(mVarArr[0].l);
        this.c = iK == -1 ? fp3.k(mVarArr[0].k) : iK;
        i();
    }
}
