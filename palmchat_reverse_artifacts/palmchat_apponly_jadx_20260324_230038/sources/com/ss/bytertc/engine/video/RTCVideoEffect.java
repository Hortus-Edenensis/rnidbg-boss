package com.ss.bytertc.engine.video;

import com.ss.bytertc.engine.InternalExpressDetectConfig;
import com.ss.bytertc.engine.NativeRTCVideoFunctions;
import com.ss.bytertc.engine.data.VirtualBackgroundSource;
import com.ss.bytertc.engine.handler.RTCFaceDetectionObserver;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RTCVideoEffect extends IVideoEffect {
    private static final String TAG = "RTCVideoEffect";
    private IFaceDetectionObserver mFaceDetectionObserver;
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private long mNativeEngine;
    private RTCFaceDetectionObserver mRTCFaceDetectionObserver;
    private final ReentrantReadWriteLock mReadWriteLock;

    public RTCVideoEffect(long j) {
        this.mNativeEngine = 0L;
        this.mRTCFaceDetectionObserver = null;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mNativeEngine = j;
        this.mRTCFaceDetectionObserver = new RTCFaceDetectionObserver(this);
        LogUtil.i(TAG, "create rtc video effect");
    }

    private boolean engineInvalid() {
        return this.mNativeEngine == 0;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int appendEffectNodes(List<String> list) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.e(TAG, "invalid, appendEffectNodes failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            String[] strArr = new String[list.size()];
            list.toArray(strArr);
            return NativeRTCVideoFunctions.nativeAppendVideoEffectNodes(this.mNativeEngine, strArr);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int applyStickerEffect(String str) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                return NativeRTCVideoFunctions.nativeApplyStickerEffect(this.mNativeEngine, str);
            }
            LogUtil.e(TAG, "native engine is invalid, applyStickerEffect failed.");
            this.mJniReadLock.unlock();
            return -1006;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void destroy() {
        LogUtil.i(TAG, "dispose rtc video effect");
        this.mJniWriteLock.lock();
        try {
            this.mNativeEngine = 0L;
        } finally {
            this.mJniWriteLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int disableFaceDetection() {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                this.mFaceDetectionObserver = null;
                return NativeRTCVideoFunctions.nativeDisableFaceDetection(this.mNativeEngine);
            }
            LogUtil.e(TAG, "invalid, registerFaceDetectionObserver failed.");
            this.mJniReadLock.unlock();
            return -1006;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int disableVideoEffect() {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                return NativeRTCVideoFunctions.nativeDisableVideoEffect(this.mNativeEngine);
            }
            LogUtil.e(TAG, "invalid, disableVideoEffect failed.");
            this.mJniReadLock.unlock();
            return -1006;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int disableVirtualBackground() {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                return NativeRTCVideoFunctions.nativeDisableVirtualBackground(this.mNativeEngine);
            }
            LogUtil.e(TAG, "invalid, disableVirtualBackground failed.");
            this.mJniReadLock.unlock();
            return -1006;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int enableFaceDetection(IFaceDetectionObserver iFaceDetectionObserver, int i, String str) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                this.mFaceDetectionObserver = iFaceDetectionObserver;
                return NativeRTCVideoFunctions.nativeEnableFaceDetection(this.mNativeEngine, this.mRTCFaceDetectionObserver, i, str);
            }
            LogUtil.e(TAG, "invalid, registerFaceDetectionObserver failed.");
            this.mJniReadLock.unlock();
            return -1006;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int enableVideoEffect() {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                return NativeRTCVideoFunctions.nativeEnableVideoEffect2(this.mNativeEngine);
            }
            LogUtil.e(TAG, "invalid, enableVideoEffect failed.");
            this.mJniReadLock.unlock();
            return -1006;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int enableVirtualBackground(String str, VirtualBackgroundSource virtualBackgroundSource) {
        String str2;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                return NativeRTCVideoFunctions.nativeEnableVirtualBackground(this.mNativeEngine, str, virtualBackgroundSource.sourceType.ordinal(), virtualBackgroundSource.sourceColor, (virtualBackgroundSource == null || (str2 = virtualBackgroundSource.sourcePath) == null) ? "" : str2);
            }
            LogUtil.e(TAG, "invalid, enableVirtualBackground failed.");
            this.mJniReadLock.unlock();
            return -1006;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public IFaceDetectionObserver getFaceDetectionObserver() {
        return this.mFaceDetectionObserver;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public long getVideoEffectHandle() {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                return NativeRTCVideoFunctions.nativeGetVideoEffectHandle(this.mNativeEngine);
            }
            LogUtil.e(TAG, "native engine is invalid, getVideoEffectHandle failed.");
            this.mJniReadLock.unlock();
            return -1006L;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int initCVResource(String str, String str2) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                return NativeRTCVideoFunctions.nativeInitCVResource(this.mNativeEngine, str, str2);
            }
            LogUtil.e(TAG, "invalid, initCVResource failed.");
            this.mJniReadLock.unlock();
            return -1006;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int registerFaceDetectionObserver(IFaceDetectionObserver iFaceDetectionObserver, int i) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                this.mFaceDetectionObserver = iFaceDetectionObserver;
                return iFaceDetectionObserver == null ? NativeRTCVideoFunctions.nativeRegisterFaceDetectionObserver(this.mNativeEngine, null, i) : NativeRTCVideoFunctions.nativeRegisterFaceDetectionObserver(this.mNativeEngine, this.mRTCFaceDetectionObserver, i);
            }
            LogUtil.e(TAG, "invalid, registerFaceDetectionObserver failed.");
            this.mJniReadLock.unlock();
            return -1006;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int removeEffectNodes(List<String> list) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.e(TAG, "invalid, removeEffectNodes failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            String[] strArr = new String[list.size()];
            list.toArray(strArr);
            return NativeRTCVideoFunctions.nativeRemoveVideoEffectNodes(this.mNativeEngine, strArr);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setAlgoModelResourceFinder(long j, long j2) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                return NativeRTCVideoFunctions.nativeSetVideoEffectAlgoModelResourceFinder(this.mNativeEngine, j, j2);
            }
            LogUtil.e(TAG, "invalid, setAlgoModelResourceFinder failed.");
            this.mJniReadLock.unlock();
            return -1006;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setColorFilter(String str) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                return NativeRTCVideoFunctions.nativeSetVideoEffectColorFilter(this.mNativeEngine, str);
            }
            LogUtil.e(TAG, "invalid, setColorFilter failed.");
            this.mJniReadLock.unlock();
            return -1006;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setColorFilterIntensity(float f) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                return NativeRTCVideoFunctions.nativeSetVideoEffectColorFilterIntensity(this.mNativeEngine, f);
            }
            LogUtil.e(TAG, "invalid, setColorFilterIntensity failed.");
            this.mJniReadLock.unlock();
            return -1006;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setEffectNodes(List<String> list) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.e(TAG, "invalid, setEffectNodes failed.");
                this.mJniReadLock.unlock();
                return -1006;
            }
            String[] strArr = new String[list.size()];
            list.toArray(strArr);
            return NativeRTCVideoFunctions.nativeSetVideoEffectNodes(this.mNativeEngine, strArr);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setVideoEffectExpressionDetect(VideoEffectExpressionConfig videoEffectExpressionConfig) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                return NativeRTCVideoFunctions.nativeSetVideoEffectExpressionDetect(this.mNativeEngine, new InternalExpressDetectConfig(videoEffectExpressionConfig));
            }
            LogUtil.e(TAG, "invalid, setVideoEffectExpressionDetect failed.");
            this.mJniReadLock.unlock();
            return -1006;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int updateEffectNode(String str, String str2, float f) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                return NativeRTCVideoFunctions.nativeUpdateVideoEffectNode(this.mNativeEngine, str, str2, f);
            }
            LogUtil.e(TAG, "invalid, updateEffectNode failed.");
            this.mJniReadLock.unlock();
            return -1006;
        } finally {
            this.mJniReadLock.unlock();
        }
    }
}
