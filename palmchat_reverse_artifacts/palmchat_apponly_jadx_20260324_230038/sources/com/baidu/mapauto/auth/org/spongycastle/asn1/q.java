package com.baidu.mapauto.auth.org.spongycastle.asn1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class q extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f3895a;

    public q(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f3895a;
    }

    public q(String str, Exception exc) {
        super(str);
        this.f3895a = exc;
    }
}
