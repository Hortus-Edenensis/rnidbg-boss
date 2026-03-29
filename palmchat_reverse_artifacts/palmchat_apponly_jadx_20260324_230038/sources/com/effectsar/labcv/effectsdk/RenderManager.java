package com.effectsar.labcv.effectsdk;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.effectsar.labcv.effectsdk.BefPublicDefine;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class RenderManager {
    private volatile boolean mInited;
    private long mNativePtr;

    public static String formatErrorCode(int i) {
        return nativeFormatErrorCode(i);
    }

    public static void loadLib() throws UnsatisfiedLinkError {
        try {
            System.loadLibrary("effect");
            System.err.println("RenderManager_jni: library load!");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("WARNING: RenderManager_jni Could not load library!");
            System.err.print(e);
            throw e;
        }
    }

    private native int nativeAlgorithmBuffer(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, double d);

    private native int nativeAlgorithmTextureWithBuffer(int i, ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, int i6, double d);

    private native int nativeAppendComposerNodes(String[] strArr);

    private native int nativeCleanPipeline();

    private native int nativeDeviceConfig(boolean z, boolean z2, boolean z3, boolean z4);

    private static native String nativeFormatErrorCode(int i);

    private native int nativeGetAvailableFeatures(String[] strArr);

    private native int nativeGetCapturedImageWithKey(String str, ByteBuffer byteBuffer, BefPublicDefine.BefCapturedImageInfo befCapturedImageInfo);

    private native int nativeGetFaceDetectResult(BefFaceInfo befFaceInfo);

    private native int nativeGetFaceMaskResult(int i, BefFaceInfo befFaceInfo);

    private native int nativeGetHandDetectResult(BefHandInfo befHandInfo);

    private native String nativeGetSDKVersion();

    private native int nativeGetSkeletonDetectResult(BefSkeletonInfo befSkeletonInfo);

    private native int nativeInit(Context context, String str, String str2, String str3, boolean z, boolean z2, int i);

    private native int nativeInit(Context context, String str, String str2, boolean z);

    private native int nativeInit(Context context, String str, String str2, boolean z, boolean z2, int i);

    private native int nativeLoadWithTimeout(int i);

    private native int nativeOnAcceleratorChanged(double d, double d2, double d3, double d4);

    private native int nativeOnGravityChanged(double d, double d2, double d3, double d4);

    private native int nativeOnGyroscopeChanged(double d, double d2, double d3, double d4);

    private native int nativeOnOrientationChanged(double[] dArr, int i, double d);

    private native int nativeProcess(int i, int i2, int i3, int i4, int i5, double d);

    private native int nativeProcessBuffer(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, byte[] bArr, int i6, double d);

    private native int nativeProcessGesture(int i, float f, float f2, float f3, float f4, float f5);

    private native int nativeProcessTexture(int i, int i2, int i3, int i4, int i5, double d);

    private native int nativeProcessTouch(int i, float f, float f2, float f3, float f4, int i2, int i3);

    private native void nativeRelease();

    private native int nativeRemoveComposerNodes(String[] strArr);

    private native int nativeScaleSlam(float f);

    private native int nativeSendMessage(int i, long j, long j2, String str);

    private native int nativeSet3buffer(boolean z);

    private native int nativeSetAlgorithmForceDetect(boolean z);

    private native int nativeSetBeauty(String str);

    private native int nativeSetCameraPosition(boolean z);

    private native int nativeSetComposer(String str);

    private native int nativeSetComposerMode(int i, int i2);

    private native int nativeSetComposerNodes(String[] strArr, String[] strArr2);

    private native int nativeSetDeviceRotation(float[] fArr);

    private native int nativeSetFilter(String str);

    private native int nativeSetImageMode(boolean z);

    private native int nativeSetMakeUp(String str);

    private native int nativeSetPipeline(boolean z);

    private native int nativeSetRenderAPI(int i);

    private native int nativeSetRenderCacheTexture(String str, String str2);

    private native int nativeSetRenderCacheTexture(String str, ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5);

    private native int nativeSetReshape(String str);

    private native int nativeSetSticker(String str);

    private native int nativeUpdateComposer(String str, String str2, float f);

    private native int nativeUpdateIntensity(int i, float f);

    private native int nativeUpdateReshape(float f, float f2);

    private native int nativeUseBuiltinSensor(boolean z);

    public int SetFaceForceDetect(boolean z) {
        return nativeSetAlgorithmForceDetect(z);
    }

    public boolean algorithmBuffer(ByteBuffer byteBuffer, EffectsSDKEffectConstants.Rotation rotation, int i, int i2, int i3, int i4, long j) {
        return this.mInited && nativeAlgorithmBuffer(byteBuffer, rotation.id, i, i2, i3, i4, getSurfaceTimeStamp(j)) == 0;
    }

    public boolean algorithmTextureWithBuffer(int i, ByteBuffer byteBuffer, EffectsSDKEffectConstants.Rotation rotation, int i2, int i3, int i4, int i5, long j) {
        return this.mInited && nativeAlgorithmTextureWithBuffer(i, byteBuffer, rotation.id, i2, i3, i4, i5, getSurfaceTimeStamp(j)) == 0;
    }

    public int appendComposerNodes(String[] strArr) {
        return nativeAppendComposerNodes(strArr);
    }

    public boolean cleanPipeline() {
        return this.mInited && nativeCleanPipeline() == 0;
    }

    public int deviceConfig(boolean z, boolean z2, boolean z3, boolean z4) {
        return nativeDeviceConfig(z, z2, z3, z4);
    }

    public boolean getAvailableFeatures(String[] strArr) {
        return nativeGetAvailableFeatures(strArr) == 0;
    }

    public int getCapturedImageWithKey(String str, ByteBuffer byteBuffer, BefPublicDefine.BefCapturedImageInfo befCapturedImageInfo) {
        return nativeGetCapturedImageWithKey(str, byteBuffer, befCapturedImageInfo);
    }

    public BefFaceInfo getFaceDetectResult() {
        if (!this.mInited) {
            return null;
        }
        BefFaceInfo befFaceInfo = new BefFaceInfo();
        int iNativeGetFaceDetectResult = nativeGetFaceDetectResult(befFaceInfo);
        if (iNativeGetFaceDetectResult == 0) {
            return befFaceInfo;
        }
        Log.d(EffectsSDKEffectConstants.TAG, "nativeGetFaceDetectResult return " + iNativeGetFaceDetectResult);
        return null;
    }

    public void getFaceMaskResult(EffectsSDKEffectConstants.FaceMaskType faceMaskType, BefFaceInfo befFaceInfo) {
        int iNativeGetFaceMaskResult;
        if (!this.mInited || befFaceInfo == null || (iNativeGetFaceMaskResult = nativeGetFaceMaskResult(faceMaskType.getValue(), befFaceInfo)) == 0) {
            return;
        }
        Log.d(EffectsSDKEffectConstants.TAG, "getFaceMaskResult type:" + faceMaskType + " return " + iNativeGetFaceMaskResult);
    }

    public BefHandInfo getHandDetectResult() {
        if (!this.mInited) {
            return null;
        }
        BefHandInfo befHandInfo = new BefHandInfo();
        int iNativeGetHandDetectResult = nativeGetHandDetectResult(befHandInfo);
        if (iNativeGetHandDetectResult == 0) {
            return befHandInfo;
        }
        Log.d(EffectsSDKEffectConstants.TAG, "nativeGetHandDetectResult return " + iNativeGetHandDetectResult);
        return null;
    }

    public String getSDKVersion() {
        return nativeGetSDKVersion();
    }

    public BefSkeletonInfo getSkeletonDetectResult() {
        if (!this.mInited) {
            return null;
        }
        BefSkeletonInfo befSkeletonInfo = new BefSkeletonInfo();
        int iNativeGetSkeletonDetectResult = nativeGetSkeletonDetectResult(befSkeletonInfo);
        if (iNativeGetSkeletonDetectResult == 0) {
            return befSkeletonInfo;
        }
        Log.d(EffectsSDKEffectConstants.TAG, "nativeGetSkeletonDetectResult return " + iNativeGetSkeletonDetectResult);
        return null;
    }

    public double getSurfaceTimeStamp(long j) {
        long jAbs = Math.abs(System.nanoTime() - j);
        long jAbs2 = Math.abs(SystemClock.elapsedRealtimeNanos() - j);
        return (r0 - Math.min(Math.min(jAbs, jAbs2), Math.abs((SystemClock.uptimeMillis() * 1000000) - j))) / 1.0E9d;
    }

    public int init(Context context, String str, String str2) {
        return init(context, str, str2, true, 0);
    }

    public boolean isInited() {
        return this.mInited;
    }

    public boolean loadResourceWithTimeout(int i) {
        return this.mInited && nativeLoadWithTimeout(i) == 0;
    }

    public int onAcceleratorChanged(double d, double d2, double d3, double d4) {
        return nativeOnAcceleratorChanged(d, d2, d3, d4);
    }

    public int onGravityChanged(double d, double d2, double d3, double d4) {
        return nativeOnGravityChanged(d, d2, d3, d4);
    }

    public int onGyroscopeChanged(double d, double d2, double d3, double d4) {
        return nativeOnGyroscopeChanged(d, d2, d3, d4);
    }

    public int onOrientationChanged(double[] dArr, int i, double d) {
        return nativeOnOrientationChanged(dArr, i, d);
    }

    @Deprecated
    public boolean processBuffer(ByteBuffer byteBuffer, EffectsSDKEffectConstants.Rotation rotation, int i, int i2, int i3, int i4, byte[] bArr, int i5) {
        if (this.mInited) {
            return nativeProcessBuffer(byteBuffer, rotation.id, i, i2, i3, i4, bArr, i5, (double) System.nanoTime()) == 0;
        }
        return false;
    }

    public int processGesture(EffectsSDKEffectConstants.GestureEventCode gestureEventCode, float f, float f2, float f3, float f4, float f5) {
        return nativeProcessGesture(gestureEventCode.getCode(), f, f2, f3, f4, f5);
    }

    public boolean processTexture(int i, int i2, int i3, int i4, EffectsSDKEffectConstants.Rotation rotation, long j) {
        return this.mInited && nativeProcess(i, i2, i3, i4, rotation.id, getSurfaceTimeStamp(j)) == 0;
    }

    public boolean processTextureOnly(int i, int i2, int i3, int i4, EffectsSDKEffectConstants.Rotation rotation, long j) {
        return this.mInited && nativeProcessTexture(i, i2, i3, i4, rotation.id, getSurfaceTimeStamp(j)) == 0;
    }

    public int processTouch(EffectsSDKEffectConstants.TouchEventCode touchEventCode, float f, float f2, float f3, float f4, int i, int i2) {
        return nativeProcessTouch(touchEventCode.getCode(), f, f2, f3, f4, i, i2);
    }

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        this.mInited = false;
    }

    public int removeComposerNodes(String[] strArr) {
        return nativeRemoveComposerNodes(strArr);
    }

    public int scaleSlam(float f) {
        return nativeScaleSlam(f);
    }

    public void sendMessage(int i, long j, long j2, String str) {
        nativeSendMessage(i, j, j2, str);
    }

    public boolean set3Buffer(boolean z) {
        return this.mInited && nativeSet3buffer(z) == 0;
    }

    @Deprecated
    public boolean setBeauty(String str) {
        if (!this.mInited) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        return nativeSetBeauty(str) == 0;
    }

    public boolean setCameraPostion(boolean z) {
        return this.mInited && nativeSetCameraPosition(z) == 0;
    }

    public int setComposer(String str) {
        return nativeSetComposer(str);
    }

    public int setComposerMode(int i, int i2) {
        return nativeSetComposerMode(i, i2);
    }

    public int setComposerNodes(String[] strArr) {
        return nativeSetComposerNodes(strArr, null);
    }

    public int setComposerNodesWithTags(String[] strArr, String[] strArr2) {
        return nativeSetComposerNodes(strArr, strArr2);
    }

    public int setDeviceRotation(float[] fArr) {
        return nativeSetDeviceRotation(fArr);
    }

    public boolean setFilter(String str) {
        if (!this.mInited) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        return nativeSetFilter(str) == 0;
    }

    public boolean setImageMode(boolean z) {
        return this.mInited && nativeSetImageMode(z) == 0;
    }

    @Deprecated
    public boolean setMakeUp(String str) {
        if (!this.mInited) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        return nativeSetMakeUp(str) == 0;
    }

    public boolean setPipeline(boolean z) {
        return this.mInited && nativeSetPipeline(z) == 0;
    }

    public boolean setRenderAPI(int i) {
        return nativeSetRenderAPI(i) == 0;
    }

    public int setRenderCacheTexture(String str, String str2) {
        return nativeSetRenderCacheTexture(str, str2);
    }

    public int setRenderCacheTextureWithBuffer(String str, ByteBuffer byteBuffer, int i, int i2, int i3, EffectsSDKEffectConstants.PixlFormat pixlFormat, EffectsSDKEffectConstants.Rotation rotation) {
        return nativeSetRenderCacheTexture(str, byteBuffer, i, i2, i3, pixlFormat.getValue(), rotation.id);
    }

    @Deprecated
    public boolean setReshape(String str) {
        if (!this.mInited) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        return nativeSetReshape(str) == 0;
    }

    public boolean setSticker(String str) {
        if (!this.mInited) {
            return false;
        }
        if (str == null) {
            str = "";
        }
        return nativeSetSticker(str) == 0;
    }

    public int updateComposerNodes(String str, String str2, float f) {
        return nativeUpdateComposer(str, str2, f);
    }

    public boolean updateIntensity(int i, float f) {
        return nativeUpdateIntensity(i, f) == 0;
    }

    @Deprecated
    public boolean updateReshape(float f, float f2) {
        return nativeUpdateReshape(f, f2) == 0;
    }

    public int useBuiltinSensor(boolean z) {
        return nativeUseBuiltinSensor(z);
    }

    public int init(Context context, String str, String str2, boolean z, boolean z2, int i) {
        if (this.mInited) {
            return 0;
        }
        int iNativeInit = nativeInit(context, str, str2, z, z2, i);
        this.mInited = iNativeInit == 0;
        return iNativeInit;
    }

    public int init(Context context, String str, String str2, String str3, boolean z, boolean z2, int i) {
        if (this.mInited) {
            return 0;
        }
        int iNativeInit = nativeInit(context, str, str2, str3, z, z2, i);
        this.mInited = iNativeInit == 0;
        return iNativeInit;
    }

    public int init(Context context, String str, String str2, boolean z, int i) {
        return init(context, str, str2, z, false, i);
    }
}
