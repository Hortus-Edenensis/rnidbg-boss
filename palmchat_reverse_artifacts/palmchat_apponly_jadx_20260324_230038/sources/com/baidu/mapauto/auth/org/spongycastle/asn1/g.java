package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class g extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f3876a;

    public g(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.f3876a;
    }

    public g(String str, IllegalArgumentException illegalArgumentException) {
        super(str);
        this.f3876a = illegalArgumentException;
    }
}
