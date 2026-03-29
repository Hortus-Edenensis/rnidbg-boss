package com.opos.exoplayer.core.decoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.opos.exoplayer.core.util.y;
import defpackage.lr0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f8132a;
    public byte[] b;
    public int c;
    public int[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    private final MediaCodec.CryptoInfo i;
    private final C0685b j;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.decoder.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(24)
    public static final class C0685b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaCodec.CryptoInfo f8133a;
        private final MediaCodec.CryptoInfo.Pattern b;

        private C0685b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f8133a = cryptoInfo;
            this.b = lr0.a(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2) {
            this.b.set(i, i2);
            this.f8133a.setPattern(this.b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        int i = y.f8407a;
        Object[] objArr = 0;
        MediaCodec.CryptoInfo cryptoInfoB = i >= 16 ? b() : null;
        this.i = cryptoInfoB;
        this.j = i >= 24 ? new C0685b(cryptoInfoB) : null;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo b() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void c() {
        MediaCodec.CryptoInfo cryptoInfo = this.i;
        cryptoInfo.numSubSamples = this.f;
        cryptoInfo.numBytesOfClearData = this.d;
        cryptoInfo.numBytesOfEncryptedData = this.e;
        cryptoInfo.key = this.b;
        cryptoInfo.iv = this.f8132a;
        cryptoInfo.mode = this.c;
        if (y.f8407a >= 24) {
            this.j.a(this.g, this.h);
        }
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo a() {
        return this.i;
    }

    public void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.f = i;
        this.d = iArr;
        this.e = iArr2;
        this.b = bArr;
        this.f8132a = bArr2;
        this.c = i2;
        this.g = i3;
        this.h = i4;
        if (y.f8407a >= 16) {
            c();
        }
    }
}
