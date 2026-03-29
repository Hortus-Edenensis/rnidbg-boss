package com.bytedance.sdk.component.fx.u;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface b extends sx, WritableByteChannel {
    b a(int i) throws IOException;

    b dw() throws IOException;

    @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Flushable
    void flush() throws IOException;

    b fx(byte[] bArr) throws IOException;

    b fx(byte[] bArr, int i, int i2) throws IOException;

    fx fx();

    b l(long j) throws IOException;

    b n(int i) throws IOException;

    b nr(iz izVar) throws IOException;

    b nr(String str) throws IOException;

    b t(long j) throws IOException;

    b x(int i) throws IOException;
}
