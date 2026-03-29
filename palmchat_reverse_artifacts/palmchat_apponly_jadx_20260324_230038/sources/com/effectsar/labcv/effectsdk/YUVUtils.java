package com.effectsar.labcv.effectsdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class YUVUtils {
    public static final int NV12 = 6;
    public static final int NV21 = 7;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 2;
    public static final int ORIENTATION_270 = 3;
    public static final int ORIENTATION_90 = 1;
    public static final int RGBA = 0;
    public static final int YUV420P = 5;

    public static native void RGBA2BGR(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native void RGBA2YUV(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native void YUV2RGBA(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, boolean z);

    public static native void YUVRESIZE(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5);
}
