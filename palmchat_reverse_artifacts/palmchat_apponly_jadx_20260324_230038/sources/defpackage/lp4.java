package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class lp4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f19050a;

    public lp4(boolean z) {
        this.f19050a = z;
    }

    public void a(sx4[] sx4VarArr) {
        if (!this.f19050a || sx4VarArr == null || sx4VarArr.length < 3) {
            return;
        }
        sx4 sx4Var = sx4VarArr[0];
        sx4VarArr[0] = sx4VarArr[2];
        sx4VarArr[2] = sx4Var;
    }
}
