package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class wb7 {
    public static final wb7 b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wb7 f21670a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends wb7 {
        public q37 c = null;

        @Override // defpackage.wb7
        public Object b(String str) {
            if (this.c == null) {
                this.c = q37.g(x97.m());
            }
            return this.c.s().opt(str);
        }
    }

    public wb7() {
        this(b);
    }

    public Object a(String str) {
        wb7 wb7Var = this.f21670a;
        if (wb7Var != null) {
            return wb7Var.a(str);
        }
        return null;
    }

    public Object b(String str) {
        wb7 wb7Var = this.f21670a;
        if (wb7Var != null) {
            return wb7Var.b(str);
        }
        return null;
    }

    public wb7(wb7 wb7Var) {
        this.f21670a = wb7Var;
    }
}
