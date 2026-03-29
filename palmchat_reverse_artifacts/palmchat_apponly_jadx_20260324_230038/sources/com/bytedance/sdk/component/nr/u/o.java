package com.bytedance.sdk.component.nr.u;

import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class o implements Closeable {
    public abstract byte[] b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract InputStream fx();

    public abstract String nr();

    public abstract jk pn();

    public abstract long u();
}
