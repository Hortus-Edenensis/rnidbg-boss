package com.effectsar.labcv.effectsdk;

import android.util.Log;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class AnimojiDetect {
    private boolean mInited;
    private long mNativePtr;

    static {
        try {
            System.loadLibrary("effect");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    private native int nativeCreate(String str, boolean z);

    private native int nativeDetect(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, BefAnimojiInfo befAnimojiInfo);

    private native int nativeDetect(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, BefFaceInfo befFaceInfo, BefAnimojiInfo befAnimojiInfo);

    private native int nativeRelease();

    private native int nativeSetEscale(int i);

    private native int nativeSetModel(String str, int i, int i2);

    public BefAnimojiInfo detect(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i, int i2, int i3, EffectsSDKEffectConstants.Rotation rotation) {
        if (!this.mInited) {
            return null;
        }
        BefAnimojiInfo befAnimojiInfo = new BefAnimojiInfo();
        int iNativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i, i2, i3, rotation.id, befAnimojiInfo);
        if (iNativeDetect == 0) {
            return befAnimojiInfo;
        }
        Log.e(EffectsSDKEffectConstants.TAG, "native detect return " + iNativeDetect);
        return null;
    }

    public int init(String str, boolean z) {
        int iNativeCreate = nativeCreate(str, z);
        if (iNativeCreate != 0) {
            this.mInited = false;
            return iNativeCreate;
        }
        this.mInited = true;
        return iNativeCreate;
    }

    public boolean isInited() {
        return this.mInited;
    }

    public void release() {
        if (this.mInited) {
            nativeRelease();
        }
        this.mInited = false;
    }

    public int setEscale(int i) {
        return nativeSetEscale(i);
    }

    public int setModel(String str, int i, int i2) {
        return nativeSetModel(str, i, i2);
    }

    public int init(String str) {
        return init(str, false);
    }

    public BefAnimojiInfo detect(ByteBuffer byteBuffer, EffectsSDKEffectConstants.PixlFormat pixlFormat, int i, int i2, int i3, EffectsSDKEffectConstants.Rotation rotation, BefFaceInfo befFaceInfo) {
        if (!this.mInited) {
            return null;
        }
        BefAnimojiInfo befAnimojiInfo = new BefAnimojiInfo();
        int iNativeDetect = nativeDetect(byteBuffer, pixlFormat.getValue(), i, i2, i3, rotation.id, befFaceInfo, befAnimojiInfo);
        if (iNativeDetect == 0) {
            return befAnimojiInfo;
        }
        Log.e(EffectsSDKEffectConstants.TAG, "native detect return " + iNativeDetect);
        return null;
    }
}
