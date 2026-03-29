package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class wp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f21767a;
    public int b = 0;

    public wp(int i) {
        this.f21767a = new byte[i];
    }

    public void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.b;
            this.b = i3 + 1;
            c(i3, z);
        }
    }

    public byte[] b(int i) {
        int length = this.f21767a.length * i;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.f21767a[i2 / i];
        }
        return bArr;
    }

    public void c(int i, boolean z) {
        this.f21767a[i] = z ? (byte) 1 : (byte) 0;
    }
}
