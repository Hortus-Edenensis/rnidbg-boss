package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ce5<T> implements zm5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bn5 f1966a = new bn5();

    public final void a(zm5 zm5Var) {
        this.f1966a.a(zm5Var);
    }

    public abstract void b(Throwable th);

    public abstract void c(T t);

    @Override // defpackage.zm5
    public final boolean isUnsubscribed() {
        return this.f1966a.isUnsubscribed();
    }

    @Override // defpackage.zm5
    public final void unsubscribe() {
        this.f1966a.unsubscribe();
    }
}
