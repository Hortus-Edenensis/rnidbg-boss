package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface jy {

    /* JADX INFO: compiled from: SearchBox */
    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f18531a;
        public boolean b;

        public a(boolean z, T t) {
            this.b = z;
            this.f18531a = t;
        }

        public String toString() {
            return "Result{result=" + this.f18531a + ", success=" + this.b + '}';
        }
    }

    void a(a aVar);
}
