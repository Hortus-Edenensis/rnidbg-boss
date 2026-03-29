package com.bytedance.sdk.component.fx.u;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface bg extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long u(fx fxVar, long j) throws IOException;

    bq u();
}
