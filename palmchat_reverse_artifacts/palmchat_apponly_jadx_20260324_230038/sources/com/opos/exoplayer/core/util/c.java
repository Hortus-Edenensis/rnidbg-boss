package com.opos.exoplayer.core.util;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class c extends IOException {
    public c() {
    }

    public c(String str) {
        super(str);
    }

    public abstract String a();

    public c(String str, Throwable th) {
        super(str, th);
    }

    public c(Throwable th) {
        super(th);
    }
}
