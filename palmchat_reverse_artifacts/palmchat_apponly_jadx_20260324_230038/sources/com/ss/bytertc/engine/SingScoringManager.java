package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.ISingScoringManager;
import com.ss.bytertc.engine.data.SingScoringConfig;
import com.ss.bytertc.engine.data.StandardPitchInfo;
import com.ss.bytertc.engine.handler.NativeSingScoringEventHandler;
import com.ss.bytertc.engine.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class SingScoringManager extends ISingScoringManager {
    private static final String TAG = "SingScoringManager";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    NativeSingScoringEventHandler mNativeHandler;
    private long mNativeRTCVideoEngine;
    private long mNativeSingScoringManager;
    private final ReentrantReadWriteLock mReadWriteLock;
    private WeakReference<ISingScoringEventHandler> mSingScoringEventHandler;

    public SingScoringManager(long j, long j2) {
        this.mNativeSingScoringManager = 0L;
        this.mNativeRTCVideoEngine = 0L;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mNativeRTCVideoEngine = j;
        this.mNativeSingScoringManager = j2;
        this.mNativeHandler = new NativeSingScoringEventHandler(this);
    }

    public void destroy() {
        this.mJniWriteLock.lock();
        try {
            this.mNativeSingScoringManager = 0L;
        } finally {
            this.mJniWriteLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int getAverageScore() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSingScoringManager;
            if (j != 0) {
                return NativeSingScoringManagerFunctions.nativeGetAverageScore(j);
            }
            LogUtil.e(TAG, "native SingScoringManager is invalid, getAverageScore failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int getLastSentenceScore() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSingScoringManager;
            if (j != 0) {
                return NativeSingScoringManagerFunctions.nativeGetLastSentenceScore(j);
            }
            LogUtil.e(TAG, "native SingScoringManager is invalid, getLastSentenceScore failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public ISingScoringEventHandler getSingScoringEventHandler() {
        return this.mSingScoringEventHandler.get();
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public List<StandardPitchInfo> getStandardPitchInfo(String str) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSingScoringManager;
            if (j != 0) {
                return Arrays.asList(NativeSingScoringManagerFunctions.nativeGetStandardPitchInfo(j, str));
            }
            LogUtil.e(TAG, "native SingScoringManager is invalid, getStandardPitchInfo failed.");
            this.mJniReadLock.unlock();
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int getTotalScore() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSingScoringManager;
            if (j != 0) {
                return NativeSingScoringManagerFunctions.nativeGetTotalScore(j);
            }
            LogUtil.e(TAG, "native SingScoringManager is invalid, getTotalScore failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int initSingScoring(String str, String str2, ISingScoringEventHandler iSingScoringEventHandler) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeSingScoringManager != 0) {
                this.mSingScoringEventHandler = new WeakReference<>(iSingScoringEventHandler);
                return iSingScoringEventHandler == null ? NativeSingScoringManagerFunctions.nativeInitSingScoring(this.mNativeRTCVideoEngine, this.mNativeSingScoringManager, str, str2, null) : NativeSingScoringManagerFunctions.nativeInitSingScoring(this.mNativeRTCVideoEngine, this.mNativeSingScoringManager, str, str2, this.mNativeHandler);
            }
            LogUtil.e(TAG, "native SingScoringManager is invalid, initSingScoring failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int setSingScoringConfig(SingScoringConfig singScoringConfig) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSingScoringManager;
            if (j != 0) {
                return NativeSingScoringManagerFunctions.nativeSetSingScoringConfig(j, singScoringConfig.sampleRate.value(), singScoringConfig.mode.value(), singScoringConfig.lyricsFilepath, singScoringConfig.midiFilepath);
            }
            LogUtil.e(TAG, "native SingScoringManager is invalid, setSingScoringConfig failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int startSingScoring(int i, int i2) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSingScoringManager;
            if (j != 0) {
                return NativeSingScoringManagerFunctions.nativeStartSingScoring(j, i, i2);
            }
            LogUtil.e(TAG, "native SingScoringManager is invalid, startSingScoring failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int stopSingScoring() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSingScoringManager;
            if (j != 0) {
                return NativeSingScoringManagerFunctions.nativeStopSingScoring(j);
            }
            LogUtil.e(TAG, "native SingScoringManager is invalid, stopSingScoring failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }
}
