package com.effectsar.labcv.effectsdk;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class FaceCluster {
    private volatile boolean mInited = false;
    private long mNativeClusterPtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    private native int nativeCheckLicense(Context context, String str, boolean z);

    private native int nativeCluster(float[] fArr, int i, int[] iArr);

    private native int nativeCreateHandle();

    private native void nativeRelease();

    private native int nativeSetParam(int i, int i2);

    public int[] cluster(float[][] fArr, int i) {
        int[] iArr = new int[i];
        int length = 0;
        for (float[] fArr2 : fArr) {
            length += fArr2.length;
        }
        float[] fArr3 = new float[length];
        int i2 = 0;
        for (float[] fArr4 : fArr) {
            int length2 = fArr4.length;
            int i3 = 0;
            while (i3 < length2) {
                fArr3[i2] = fArr4[i3];
                i3++;
                i2++;
            }
        }
        int iNativeCluster = nativeCluster(fArr3, i, iArr);
        if (iNativeCluster == 0) {
            return iArr;
        }
        Log.e(EffectsSDKEffectConstants.TAG, "nativeCluster return " + iNativeCluster);
        return null;
    }

    public int init(Context context, String str, boolean z) {
        int iNativeCreateHandle = nativeCreateHandle();
        if (iNativeCreateHandle != 0) {
            this.mInited = false;
            return iNativeCreateHandle;
        }
        int iNativeCheckLicense = nativeCheckLicense(context, str, z);
        if (iNativeCheckLicense != 0) {
            this.mInited = false;
            return iNativeCheckLicense;
        }
        this.mInited = true;
        return iNativeCheckLicense;
    }

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        this.mInited = false;
    }

    public int setDetectParam(int i, int i2) {
        return nativeSetParam(i, i2);
    }

    public int init(Context context, String str) {
        return init(context, str, false);
    }
}
