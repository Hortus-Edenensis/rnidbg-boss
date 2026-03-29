package com.xiaomi.push;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ih extends ik {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected InputStream f11649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected OutputStream f843a;

    public ih() {
        this.f11649a = null;
        this.f843a = null;
    }

    @Override // com.xiaomi.push.ik
    public int a(byte[] bArr, int i, int i2) throws il {
        InputStream inputStream = this.f11649a;
        if (inputStream == null) {
            throw new il(1, "Cannot read from null inputStream");
        }
        try {
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 >= 0) {
                return i3;
            }
            throw new il(4);
        } catch (IOException e) {
            throw new il(0, e);
        }
    }

    public ih(OutputStream outputStream) {
        this.f11649a = null;
        this.f843a = outputStream;
    }

    @Override // com.xiaomi.push.ik
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo646a(byte[] bArr, int i, int i2) throws il {
        OutputStream outputStream = this.f843a;
        if (outputStream != null) {
            try {
                outputStream.write(bArr, i, i2);
                return;
            } catch (IOException e) {
                throw new il(0, e);
            }
        }
        throw new il(1, "Cannot write to null outputStream");
    }
}
