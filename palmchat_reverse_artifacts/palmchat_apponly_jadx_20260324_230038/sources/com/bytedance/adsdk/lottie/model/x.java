package com.bytedance.adsdk.lottie.model;

import android.util.Pair;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class x<T> {
    T nr;
    T u;

    private static boolean nr(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return nr(pair.first, this.u) && nr(pair.second, this.nr);
    }

    public int hashCode() {
        T t = this.u;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.nr;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.u + " " + this.nr + "}";
    }

    public void u(T t, T t2) {
        this.u = t;
        this.nr = t2;
    }
}
