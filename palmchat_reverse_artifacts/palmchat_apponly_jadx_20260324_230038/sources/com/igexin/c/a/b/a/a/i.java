package com.igexin.c.a.b.a.a;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final BufferedOutputStream f7040a;

    public i(OutputStream outputStream) throws IOException {
        this.f7040a = new BufferedOutputStream(outputStream);
    }

    private void a() throws IOException {
        this.f7040a.close();
    }

    private i(Socket socket) throws IOException {
        this.f7040a = new BufferedOutputStream(socket.getOutputStream());
    }

    private void a(byte[] bArr) throws IOException {
        this.f7040a.write(bArr, 0, bArr.length);
        this.f7040a.flush();
    }

    private void a(byte[] bArr, int i, int i2) throws IOException {
        this.f7040a.write(bArr, i, i2);
        this.f7040a.flush();
    }
}
