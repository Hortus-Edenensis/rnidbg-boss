package com.qq.gdt.action.f.b;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class j implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10512a;
    private final long b;
    private BufferedInputStream c;
    private HttpURLConnection d;

    public j(String str, long j, BufferedInputStream bufferedInputStream, HttpURLConnection httpURLConnection) {
        this.f10512a = str;
        this.b = j;
        this.c = bufferedInputStream;
        this.d = httpURLConnection;
    }

    public byte[] a() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = this.c.read(bArr);
                if (-1 == i) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } finally {
            k.a(byteArrayOutputStream);
            k.a(this);
        }
    }

    public final String b() throws IOException {
        return new String(a(), k.f10513a);
    }

    public final String c() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = this.c.read(bArr);
                if (-1 == i) {
                    this.c = new BufferedInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                    return new String(byteArrayOutputStream.toByteArray(), k.f10513a);
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } finally {
            k.a(byteArrayOutputStream);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        k.a(this.c);
        this.d.disconnect();
        this.d = null;
    }
}
