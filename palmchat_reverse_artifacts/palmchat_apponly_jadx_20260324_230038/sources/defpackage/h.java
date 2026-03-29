package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class h {
    public static final h b = new h(0);
    public static final h c = new h(1);
    public static final h d = new h(2);
    public static final h e = new h(3);
    public static final h f = new h(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17841a;

    public h(int i) {
        this.f17841a = i;
    }

    public final int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && h.class == obj.getClass() && this.f17841a == ((h) obj).f17841a;
    }

    public int hashCode() {
        return a(Integer.valueOf(this.f17841a));
    }
}
