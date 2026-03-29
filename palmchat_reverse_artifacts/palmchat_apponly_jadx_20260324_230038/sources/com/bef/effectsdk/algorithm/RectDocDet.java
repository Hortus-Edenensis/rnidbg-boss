package com.bef.effectsdk.algorithm;

import android.graphics.Bitmap;
import com.bef.effectsdk.ResourceFinder;
import defpackage.lk1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@lk1
public class RectDocDet {
    public static final int RectDocDetAngleThr = 3;
    public static final int RectDocDetIsVideoMode = 2;
    public static final int RectDocDetIsVideoTypeNo = 2;
    public static final int RectDocDetIsVideoTypeYes = 1;
    public static final int RectDocDetPreProcessMode = 1;
    public static final int RectDocDetPreprocessTypeCenterCut = 2;
    public static final int RectDocDetPreprocessTypeNN = 1;
    private ResourceFinder mFinder;
    private long mFinderHandle;
    private long mNativeHandle;

    private boolean isFinderHandleValid() {
        return 0 != this.mFinderHandle;
    }

    private boolean isNativeHandleValid() {
        return 0 != this.mNativeHandle;
    }

    @lk1
    private native long nativeCreate();

    @lk1
    private native int nativeDestroy(long j);

    @lk1
    private native int nativeInit(long j, long j2, int i);

    @lk1
    private native int nativeInitWithPath(long j, String str, int i);

    @lk1
    private native RectDocDetResult nativeProcess(long j, Bitmap bitmap, int i);

    @lk1
    private native int nativeSetParamF(long j, int i, float f);

    public boolean create() {
        this.mNativeHandle = nativeCreate();
        return isNativeHandleValid();
    }

    public void destroy() {
        if (isNativeHandleValid()) {
            nativeDestroy(this.mNativeHandle);
            this.mNativeHandle = 0L;
        }
        if (this.mFinder == null || !isFinderHandleValid()) {
            return;
        }
        this.mFinder.release(this.mFinderHandle);
        this.mFinderHandle = 0L;
    }

    public boolean init(ResourceFinder resourceFinder, int i) {
        if (resourceFinder == null || !isNativeHandleValid()) {
            return false;
        }
        this.mFinder = resourceFinder;
        this.mFinderHandle = resourceFinder.createNativeResourceFinder(this.mNativeHandle);
        if (isFinderHandleValid()) {
            return nativeInit(this.mNativeHandle, this.mFinderHandle, i) == 0;
        }
        destroy();
        return false;
    }

    public boolean initWithPath(String str, int i) {
        return str != null && str.length() != 0 && isNativeHandleValid() && nativeInitWithPath(this.mNativeHandle, str, i) == 0;
    }

    public RectDocDetResult process(Bitmap bitmap, int i) {
        return (!isNativeHandleValid() || bitmap == null) ? new RectDocDetResult() : nativeProcess(this.mNativeHandle, bitmap, i);
    }

    public boolean setParamF(int i, float f) {
        return isNativeHandleValid() && nativeSetParamF(this.mNativeHandle, i, f) == 0;
    }
}
