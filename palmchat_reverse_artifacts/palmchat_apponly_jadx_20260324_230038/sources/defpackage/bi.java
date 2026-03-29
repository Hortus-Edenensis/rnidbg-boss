package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class bi implements Runnable, wk4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bg4 f1721a = new bg4();
    public final an1 b;

    public bi(an1 an1Var) {
        this.b = an1Var;
    }

    @Override // defpackage.wk4
    public void a(an5 an5Var, Object obj) {
        this.f1721a.a(ag4.a(an5Var, obj));
        this.b.d().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        ag4 ag4VarB = this.f1721a.b();
        if (ag4VarB == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.b.g(ag4VarB);
    }
}
