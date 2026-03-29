package com.amap.api.col.p0002sl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class in extends it {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ByteArrayOutputStream f2912a;

    public in() {
        this.f2912a = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.p0002sl.it
    public final byte[] a(byte[] bArr) {
        byte[] byteArray = this.f2912a.toByteArray();
        try {
            this.f2912a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f2912a = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.p0002sl.it
    public final void b(byte[] bArr) {
        try {
            this.f2912a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public in(it itVar) {
        super(itVar);
        this.f2912a = new ByteArrayOutputStream();
    }
}
