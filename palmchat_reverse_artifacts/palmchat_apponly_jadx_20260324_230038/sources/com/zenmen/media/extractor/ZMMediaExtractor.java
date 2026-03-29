package com.zenmen.media.extractor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ZMMediaExtractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11949a;
    public long b = 0;

    static {
        try {
            System.loadLibrary("ZMMediaExtractor");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public ZMMediaExtractor(String str) {
        this.f11949a = str;
    }

    private native void nativeClose(long j);

    private native long nativeGetDuration(long j);

    private native int nativeGetHeight(long j);

    private native int nativeGetVBitrate(long j);

    private native int nativeGetVideoCodecType(long j);

    private native int nativeGetWidth(long j);

    private native long nativeOpen(String str);

    public void a() {
        long j = this.b;
        if (j != 0) {
            nativeClose(j);
        }
    }

    public long b() {
        long j = this.b;
        if (j == 0) {
            return -1L;
        }
        return nativeGetDuration(j);
    }

    public int c() {
        long j = this.b;
        if (j == 0) {
            return -1;
        }
        return nativeGetHeight(j);
    }

    public int d() {
        long j = this.b;
        if (j == 0) {
            return -1;
        }
        return nativeGetVBitrate(j);
    }

    public int e() {
        long j = this.b;
        if (j == 0) {
            return -1;
        }
        return nativeGetVideoCodecType(j);
    }

    public int f() {
        long j = this.b;
        if (j == 0) {
            return -1;
        }
        return nativeGetWidth(j);
    }

    public int g() {
        long jNativeOpen = nativeOpen(this.f11949a);
        this.b = jNativeOpen;
        return jNativeOpen == 0 ? -1 : 0;
    }
}
