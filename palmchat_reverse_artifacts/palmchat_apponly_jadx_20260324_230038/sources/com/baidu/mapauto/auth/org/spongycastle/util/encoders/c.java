package com.baidu.mapauto.auth.org.spongycastle.util.encoders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class c extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f3920a;

    public c(String str, Exception exc) {
        super(str);
        this.f3920a = exc;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f3920a;
    }
}
