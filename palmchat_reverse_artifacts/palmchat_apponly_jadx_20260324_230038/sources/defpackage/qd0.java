package defpackage;

import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class qd0 {
    @Nullable
    public static String b(or1 or1Var) {
        vh.a(or1Var != null);
        int iK = fp3.k(or1Var.getSelectedFormat().l);
        if (iK == -1) {
            iK = fp3.k(or1Var.getSelectedFormat().k);
        }
        if (iK == 1) {
            return "a";
        }
        if (iK == 2) {
            return "v";
        }
        return null;
    }

    public ImmutableMap<String, String> a() {
        throw null;
    }

    public qd0 c(long j) {
        throw null;
    }

    public qd0 d(@Nullable String str) {
        throw null;
    }
}
