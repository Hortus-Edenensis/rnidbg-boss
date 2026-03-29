package com.effectsar.labcv.effectsdk;

import android.content.Context;
import android.util.Log;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class FaceDetect {
    private static final int MaxFaceNum = 10;
    private long mAttriNativePtr;
    private long mNativePtr;
    private volatile boolean mInited = false;
    private volatile boolean mInitedExtra = false;
    private volatile boolean mInitedAttri = false;
    private int mFaceDetectConfig = -1;
    private int mFaceAttriConfig = -1;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    private native int nativeCheckLicense(Context context, String str, boolean z);

    private native int nativeDetect(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, long j, BefFaceInfo befFaceInfo);

    private native int nativeGetFaceMask(long j, int i, BefFaceInfo befFaceInfo);

    private native int nativeInit(int i, String str);

    private native int nativeInitAttri(int i, String str, Context context, String str2, boolean z);

    private native int nativeInitExtra(int i, String str);

    private native void nativeRelease();

    private native void nativeReleaseAttri();

    private native int nativeSetParam(int i, int i2);

    public BefFaceInfo detectFace(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i, int i2, int i3, EffectsSDKEffectConstants.Rotation rotation) {
        if (!this.mInited) {
            return null;
        }
        if (this.mFaceDetectConfig == -1) {
            Log.e(EffectsSDKEffectConstants.TAG, "Need call setFaceDetectConfig before calling current function");
            return null;
        }
        BefFaceInfo befFaceInfo = new BefFaceInfo();
        int iNativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i, i2, i3, rotation.id, this.mFaceDetectConfig, befFaceInfo);
        if (iNativeDetect == 0) {
            return befFaceInfo;
        }
        Log.e(EffectsSDKEffectConstants.TAG, "nativeDetect return " + iNativeDetect);
        return null;
    }

    public int getFaceAttriConfig() {
        return this.mFaceAttriConfig;
    }

    public int getFaceDetectConfig() {
        return this.mFaceDetectConfig;
    }

    public void getFaceMask(BefFaceInfo befFaceInfo, int i) {
        int iNativeGetFaceMask;
        if (!this.mInited || befFaceInfo == null || (iNativeGetFaceMask = nativeGetFaceMask(this.mFaceDetectConfig, i, befFaceInfo)) == 0) {
            return;
        }
        Log.e(EffectsSDKEffectConstants.TAG, "nativeGetFaceMask return " + iNativeGetFaceMask);
    }

    public int init(Context context, String str, int i, String str2, boolean z) {
        int iNativeInit = nativeInit(i, str);
        if (iNativeInit != 0) {
            this.mInited = false;
            return iNativeInit;
        }
        if (iNativeInit != 0) {
            this.mInited = false;
        }
        int iNativeCheckLicense = nativeCheckLicense(context, str2, z);
        if (iNativeCheckLicense != 0) {
            this.mInited = false;
            return iNativeCheckLicense;
        }
        int detectParam = setDetectParam(2, 10);
        if (detectParam != 0) {
            this.mInited = false;
            return detectParam;
        }
        this.mInited = true;
        return detectParam;
    }

    public int initAttri(Context context, String str, String str2, boolean z) {
        int iNativeInitAttri = this.mInited ? 0 : -1;
        if (iNativeInitAttri == 0) {
            iNativeInitAttri = nativeInitAttri(0, str, context, str2, z);
        }
        this.mInitedAttri = true;
        return iNativeInitAttri;
    }

    public int initExtra(Context context, String str, int i) {
        int iNativeInitExtra = this.mInited ? 0 : -1;
        if (iNativeInitExtra == 0) {
            iNativeInitExtra = nativeInitExtra(i, str);
        }
        this.mInitedExtra = true;
        return iNativeInitExtra;
    }

    public boolean isInited() {
        return this.mInited;
    }

    public boolean isInitedAttri() {
        return this.mInitedAttri;
    }

    public boolean isInitedExtra() {
        return this.mInitedExtra;
    }

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        if (this.mInitedAttri) {
            nativeReleaseAttri();
        }
        this.mInited = false;
        this.mInitedExtra = false;
        this.mInitedAttri = false;
    }

    public void releaseAttri() {
        if (this.mInitedAttri) {
            nativeReleaseAttri();
        }
        this.mInitedAttri = false;
    }

    public void setAttriDetectConfig(int i) {
        this.mFaceAttriConfig = i;
    }

    public int setDetectParam(int i, int i2) {
        return nativeSetParam(i, i2);
    }

    public void setFaceDetectConfig(int i) {
        this.mFaceDetectConfig = i;
    }

    public int initAttri(Context context, String str, String str2) {
        return initAttri(context, str, str2, false);
    }

    public int init(Context context, String str, int i, String str2) {
        return init(context, str, i, str2, false);
    }
}
