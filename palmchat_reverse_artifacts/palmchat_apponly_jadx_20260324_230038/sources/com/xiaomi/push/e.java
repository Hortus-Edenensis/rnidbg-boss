package com.xiaomi.push;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class e {
    public abstract int a();

    public abstract e a(b bVar);

    public abstract void a(c cVar);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m398a() {
        int iB = b();
        byte[] bArr = new byte[iB];
        m397a(bArr, 0, iB);
        return bArr;
    }

    public abstract int b();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m397a(byte[] bArr, int i, int i2) {
        try {
            c cVarA = c.a(bArr, i, i2);
            a(cVarA);
            cVarA.b();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public e a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public e a(byte[] bArr, int i, int i2) throws d {
        try {
            b bVarA = b.a(bArr, i, i2);
            a(bVarA);
            bVarA.m191a(0);
            return this;
        } catch (d e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public boolean a(b bVar, int i) {
        return bVar.m193a(i);
    }
}
