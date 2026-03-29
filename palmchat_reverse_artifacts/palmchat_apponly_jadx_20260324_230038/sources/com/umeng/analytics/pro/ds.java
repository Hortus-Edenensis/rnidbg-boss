package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ds extends du {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected InputStream f10936a;
    protected OutputStream b;

    public ds() {
        this.f10936a = null;
        this.b = null;
    }

    @Override // com.umeng.analytics.pro.du
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.du
    public void b() throws dv {
    }

    @Override // com.umeng.analytics.pro.du
    public void c() {
        InputStream inputStream = this.f10936a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f10936a = null;
        }
        OutputStream outputStream = this.b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.b = null;
        }
    }

    @Override // com.umeng.analytics.pro.du
    public void d() throws dv {
        OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new dv(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (IOException e) {
            throw new dv(0, e);
        }
    }

    @Override // com.umeng.analytics.pro.du
    public int a(byte[] bArr, int i, int i2) throws dv {
        InputStream inputStream = this.f10936a;
        if (inputStream == null) {
            throw new dv(1, "Cannot read from null inputStream");
        }
        try {
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 >= 0) {
                return i3;
            }
            throw new dv(4);
        } catch (IOException e) {
            throw new dv(0, e);
        }
    }

    @Override // com.umeng.analytics.pro.du
    public void b(byte[] bArr, int i, int i2) throws dv {
        OutputStream outputStream = this.b;
        if (outputStream == null) {
            throw new dv(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (IOException e) {
            throw new dv(0, e);
        }
    }

    public ds(InputStream inputStream) {
        this.b = null;
        this.f10936a = inputStream;
    }

    public ds(OutputStream outputStream) {
        this.f10936a = null;
        this.b = outputStream;
    }

    public ds(InputStream inputStream, OutputStream outputStream) {
        this.f10936a = inputStream;
        this.b = outputStream;
    }
}
