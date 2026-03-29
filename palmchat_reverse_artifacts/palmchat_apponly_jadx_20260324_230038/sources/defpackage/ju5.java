package defpackage;

import junit.framework.Test;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ju5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Test f18508a;
    public Throwable b;

    public ju5(Test test, Throwable th) {
        this.f18508a = test;
        this.b = th;
    }

    public String toString() {
        return this.f18508a + ": " + this.b.getMessage();
    }
}
