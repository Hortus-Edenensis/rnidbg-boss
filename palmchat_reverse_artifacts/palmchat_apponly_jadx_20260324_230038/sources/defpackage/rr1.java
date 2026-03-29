package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class rr1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<qr1> f20555a;
    public final int b;
    public final boolean c;

    public rr1(List<qr1> list, int i, boolean z) {
        this.f20555a = new ArrayList(list);
        this.b = i;
        this.c = z;
    }

    public List<qr1> a() {
        return this.f20555a;
    }

    public int b() {
        return this.b;
    }

    public boolean c(List<qr1> list) {
        return this.f20555a.equals(list);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof rr1)) {
            return false;
        }
        rr1 rr1Var = (rr1) obj;
        return this.f20555a.equals(rr1Var.a()) && this.c == rr1Var.c;
    }

    public int hashCode() {
        return this.f20555a.hashCode() ^ Boolean.valueOf(this.c).hashCode();
    }

    public String toString() {
        return "{ " + this.f20555a + " }";
    }
}
