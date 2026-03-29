package defpackage;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class tk0<T> extends q94<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator<? super T>[] f21010a;

    public tk0(Comparator<? super T> comparator, Comparator<? super T> comparator2) {
        this.f21010a = new Comparator[]{comparator, comparator2};
    }

    @Override // defpackage.q94, java.util.Comparator
    public int compare(T t, T t2) {
        int i = 0;
        while (true) {
            Comparator<? super T>[] comparatorArr = this.f21010a;
            if (i >= comparatorArr.length) {
                return 0;
            }
            int iCompare = comparatorArr[i].compare(t, t2);
            if (iCompare != 0) {
                return iCompare;
            }
            i++;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof tk0) {
            return Arrays.equals(this.f21010a, ((tk0) obj).f21010a);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f21010a);
    }

    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.f21010a) + ")";
    }
}
