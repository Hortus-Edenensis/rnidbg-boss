package com.qq.gdt.action.f.b;

import java.io.BufferedOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class h {
    public static h a(f fVar, byte[] bArr) {
        return a(fVar, bArr, 0, bArr.length);
    }

    public abstract f a();

    public abstract void a(BufferedOutputStream bufferedOutputStream) throws IOException;

    public long b() throws IOException {
        return -1L;
    }

    public static h a(final f fVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        k.a(bArr.length, i, i2);
        return new h() { // from class: com.qq.gdt.action.f.b.h.1
            @Override // com.qq.gdt.action.f.b.h
            public f a() {
                return fVar;
            }

            @Override // com.qq.gdt.action.f.b.h
            public long b() {
                return i2;
            }

            @Override // com.qq.gdt.action.f.b.h
            public void a(BufferedOutputStream bufferedOutputStream) throws IOException {
                bufferedOutputStream.write(bArr, i, i2);
            }
        };
    }
}
