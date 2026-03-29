package com.bytedance.sdk.component.fx.u;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface pn extends bg, ReadableByteChannel {
    short a() throws IOException;

    @Deprecated
    fx fx();

    iz fx(long j) throws IOException;

    InputStream iz();

    int jk() throws IOException;

    int l() throws IOException;

    long mv() throws IOException;

    String my() throws IOException;

    byte n() throws IOException;

    void n(long j) throws IOException;

    byte[] o() throws IOException;

    String pn(long j) throws IOException;

    boolean pn() throws IOException;

    short t() throws IOException;

    long u(byte b) throws IOException;

    String u(Charset charset) throws IOException;

    void u(long j) throws IOException;

    void u(byte[] bArr) throws IOException;

    boolean u(long j, iz izVar) throws IOException;

    byte[] x(long j) throws IOException;
}
