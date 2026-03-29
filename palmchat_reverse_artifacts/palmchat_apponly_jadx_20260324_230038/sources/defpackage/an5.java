package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class an5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1262a;
    public final wm5 b;
    public volatile boolean c = true;

    public an5(Object obj, wm5 wm5Var) {
        this.f1262a = obj;
        this.b = wm5Var;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof an5)) {
            return false;
        }
        an5 an5Var = (an5) obj;
        return this.f1262a == an5Var.f1262a && this.b.equals(an5Var.b);
    }

    public int hashCode() {
        return this.f1262a.hashCode() + this.b.f.hashCode();
    }
}
