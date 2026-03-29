package defpackage;

import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ir0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public byte[] f18240a;

    @Nullable
    public byte[] b;
    public int c;

    @Nullable
    public int[] d;

    @Nullable
    public int[] e;
    public int f;
    public int g;
    public int h;
    public final MediaCodec.CryptoInfo i;

    @Nullable
    public final b j;

    /* JADX INFO: compiled from: SearchBox */
    @RequiresApi(24)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f18241a;
        public final MediaCodec.CryptoInfo.Pattern b;

        public final void b(int i, int i2) {
            this.b.set(i, i2);
            this.f18241a.setPattern(this.b);
        }

        public b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f18241a = cryptoInfo;
            this.b = lr0.a(0, 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ir0() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.i = cryptoInfo;
        this.j = g86.f17680a >= 24 ? new b(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.i;
    }

    public void b(int i) {
        if (i == 0) {
            return;
        }
        if (this.d == null) {
            int[] iArr = new int[1];
            this.d = iArr;
            this.i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.d;
        iArr2[0] = iArr2[0] + i;
    }

    public void c(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.f = i;
        this.d = iArr;
        this.e = iArr2;
        this.b = bArr;
        this.f18240a = bArr2;
        this.c = i2;
        this.g = i3;
        this.h = i4;
        MediaCodec.CryptoInfo cryptoInfo = this.i;
        cryptoInfo.numSubSamples = i;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i2;
        if (g86.f17680a >= 24) {
            ((b) vh.e(this.j)).b(i3, i4);
        }
    }
}
