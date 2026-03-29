package com.xiaomi.push;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class ik {
    public abstract int a(byte[] bArr, int i, int i2);

    public void a(int i) {
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo646a(byte[] bArr, int i, int i2);

    public int a_() {
        return 0;
    }

    public int b() {
        return -1;
    }

    public byte[] a() {
        return null;
    }

    public int b(byte[] bArr, int i, int i2) throws il {
        int i3 = 0;
        while (i3 < i2) {
            int iA = a(bArr, i + i3, i2 - i3);
            if (iA <= 0) {
                throw new il("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes.");
            }
            i3 += iA;
        }
        return i3;
    }
}
