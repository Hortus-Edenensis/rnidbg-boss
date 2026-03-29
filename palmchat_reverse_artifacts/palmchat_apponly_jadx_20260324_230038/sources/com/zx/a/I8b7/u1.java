package com.zx.a.I8b7;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class u1 implements Closeable {

    /* JADX INFO: compiled from: SearchBox */
    public class a extends u1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x0 f16869a;
        public final /* synthetic */ long b;
        public final /* synthetic */ InputStream c;

        public a(x0 x0Var, long j, InputStream inputStream) {
            this.f16869a = x0Var;
            this.b = j;
            this.c = inputStream;
        }
    }

    public static u1 a(x0 x0Var, long j, InputStream inputStream) {
        if (inputStream != null) {
            return new a(x0Var, j, inputStream);
        }
        throw new NullPointerException("byte stream is null");
    }

    public final String b() throws IOException {
        return new String(a(), StandardCharsets.UTF_8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c2.a(((a) this).c);
    }

    public final byte[] a() throws IOException {
        a aVar = (a) this;
        long j = aVar.b;
        if (j <= 2147483647L) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream inputStream = aVar.c;
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (Throwable th) {
                    c2.a(inputStream);
                    throw th;
                }
            }
            c2.a(inputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (j == -1 || j == byteArray.length) {
                return byteArray;
            }
            throw new IOException("Content-Length (" + j + ") and stream length (" + byteArray.length + ") disagree");
        }
        throw new IOException("Cannot buffer entire body for content length: " + j);
    }
}
