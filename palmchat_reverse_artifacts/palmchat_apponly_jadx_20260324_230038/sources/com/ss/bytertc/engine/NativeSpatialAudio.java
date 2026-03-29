package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.ISpatialAudio;
import com.ss.bytertc.engine.data.HumanOrientation;
import com.ss.bytertc.engine.data.Orientation;
import com.ss.bytertc.engine.data.Position;
import com.ss.bytertc.engine.data.PositionInfo;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class NativeSpatialAudio implements ISpatialAudio {
    private static final String TAG = "NativeSpatialAudio";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private long mNaiveInstance;
    private final ReentrantReadWriteLock mReadWriteLock;

    public NativeSpatialAudio(long j) {
        this.mNaiveInstance = 0L;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mNaiveInstance = j;
    }

    public static native void nativeDisableRemoteOrientation(long j);

    public static native void nativeEnableSpatialAudio(long j, boolean z);

    public static native int nativeRemoveAllRemotePosition(long j);

    public static native int nativeRemoveRemotePosition(long j, String str);

    public static native int nativeUpdateListenerOrientation(long j, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9);

    public static native int nativeUpdateListenerPosition(long j, float f, float f2, float f3);

    public static native int nativeUpdatePosition(long j, float f, float f2, float f3);

    public static native int nativeUpdateRemotePosition(long j, String str, PositionInfo positionInfo);

    public static native int nativeUpdateSelfOrientation(long j, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9);

    public static native int nativeUpdateSelfPosition(long j, PositionInfo positionInfo);

    public void destroy() {
        this.mJniWriteLock.lock();
        try {
            this.mNaiveInstance = 0L;
        } finally {
            this.mJniWriteLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public void disableRemoteOrientation() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j == 0) {
                LogUtil.e(TAG, "native SpatialAudio is invalid, disableRemoteOrientation failed.");
            } else {
                nativeDisableRemoteOrientation(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public void enableSpatialAudio(boolean z) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j == 0) {
                LogUtil.e(TAG, "native SpatialAudio is invalid, enableSpatialAudio failed.");
            } else {
                nativeEnableSpatialAudio(j, z);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int removeAllRemotePosition() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j != 0) {
                return nativeRemoveAllRemotePosition(j);
            }
            LogUtil.e(TAG, "native SpatialAudio is invalid, updatePosition failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int removeRemotePosition(String str) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j != 0) {
                return nativeRemoveRemotePosition(j, str);
            }
            LogUtil.e(TAG, "native SpatialAudio is invalid, updatePosition failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int updateListenerOrientation(HumanOrientation humanOrientation) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j == 0) {
                LogUtil.e(TAG, "native SpatialAudio is invalid, updateListenerOrientation failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            Orientation orientation = humanOrientation.forward;
            float f = orientation.x;
            float f2 = orientation.y;
            float f3 = orientation.z;
            Orientation orientation2 = humanOrientation.right;
            float f4 = orientation2.x;
            float f5 = orientation2.y;
            float f6 = orientation2.z;
            Orientation orientation3 = humanOrientation.up;
            return nativeUpdateListenerOrientation(j, f, f2, f3, f4, f5, f6, orientation3.x, orientation3.y, orientation3.z);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int updateListenerPosition(Position position) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j != 0) {
                return nativeUpdateListenerPosition(j, position.x, position.y, position.z);
            }
            LogUtil.e(TAG, "native SpatialAudio is invalid, updateListenerPosition failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int updatePosition(Position position) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j != 0) {
                return nativeUpdatePosition(j, position.x, position.y, position.z);
            }
            LogUtil.e(TAG, "native SpatialAudio is invalid, updatePosition failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int updateRemotePosition(String str, PositionInfo positionInfo) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j != 0) {
                return nativeUpdateRemotePosition(j, str, positionInfo);
            }
            LogUtil.e(TAG, "native SpatialAudio is invalid, updatePosition failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int updateSelfOrientation(HumanOrientation humanOrientation) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j == 0) {
                LogUtil.e(TAG, "native SpatialAudio is invalid, updateSelfOrientation failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            Orientation orientation = humanOrientation.forward;
            float f = orientation.x;
            float f2 = orientation.y;
            float f3 = orientation.z;
            Orientation orientation2 = humanOrientation.right;
            float f4 = orientation2.x;
            float f5 = orientation2.y;
            float f6 = orientation2.z;
            Orientation orientation3 = humanOrientation.up;
            return nativeUpdateSelfOrientation(j, f, f2, f3, f4, f5, f6, orientation3.x, orientation3.y, orientation3.z);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int updateSelfPosition(PositionInfo positionInfo) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j != 0) {
                return nativeUpdateSelfPosition(j, positionInfo);
            }
            LogUtil.e(TAG, "native SpatialAudio is invalid, updatePosition failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }
}
