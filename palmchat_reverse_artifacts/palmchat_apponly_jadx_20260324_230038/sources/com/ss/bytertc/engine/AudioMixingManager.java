package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.IAudioMixingManager;
import com.ss.bytertc.engine.data.AudioMixingConfig;
import com.ss.bytertc.engine.data.AudioMixingDualMonoMode;
import com.ss.bytertc.engine.data.AudioMixingType;
import com.ss.bytertc.engine.data.ReturnStatus;
import com.ss.bytertc.engine.handler.RTCAudioFileFrameObserver;
import com.ss.bytertc.engine.utils.AudioFrame;
import com.ss.bytertc.engine.utils.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AudioMixingManager extends IAudioMixingManager {
    private static final String TAG = "AudioMixingManager";
    private RTCAudioFileFrameObserver mAudioFileFrameObserver;
    private long mNativeAudioMixingManager;
    private long mNativeRTCEngine;

    public AudioMixingManager(long j) {
        this(j, 0L);
    }

    public synchronized void destroy() {
        this.mNativeAudioMixingManager = 0L;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void disableAudioMixingFrame(int i) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, DisableAudioMixingFrame failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeDisableAudioMixingFrame(j, i);
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void enableAudioMixingFrame(int i, AudioMixingType audioMixingType) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, EnableAudioMixingFrame failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeEnableAudioMixingFrame(j, i, audioMixingType.value());
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized int getAudioMixingCurrentPosition(int i) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, GetAudioMixingCurrentPosition failed.");
            return -1;
        }
        return NativeAudioMixingManagerFunctions.nativeGetAudioMixingCurrentPosition(j, i);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized int getAudioMixingDuration(int i) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, GetAudioMixingDuration failed.");
            return -1;
        }
        return NativeAudioMixingManagerFunctions.nativeGetAudioMixingDuration(j, i);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized int getAudioMixingPlaybackDuration(int i) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, getAudioMixingPlaybackDuration failed.");
            return -1;
        }
        return NativeAudioMixingManagerFunctions.nativeGetAudioMixingPlaybackDuration(j, i);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized int getAudioTrackCount(int i) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, GetAudioTrackCount failed.");
            return -1;
        }
        return NativeAudioMixingManagerFunctions.nativeGetAudioTrackCount(j, i);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void pauseAllAudioMixing() {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, PauseAllAudioMixing failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativePauseAllAudioMixing(j);
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void pauseAudioMixing(int i) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, PauseAudioMixing failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativePauseAudioMixing(j, i);
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void preloadAudioMixing(int i, String str) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, PreloadAudioMixing failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativePreloadAudioMixing(j, i, str);
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized int pushAudioMixingFrame(int i, AudioFrame audioFrame) {
        long j = this.mNativeAudioMixingManager;
        if (j != 0) {
            return NativeAudioMixingManagerFunctions.nativePushAudioMixingFrame(j, i, audioFrame.buffer, audioFrame.samples, audioFrame.sampleRate.value(), audioFrame.channel.value());
        }
        LogUtil.e(TAG, "native AudioMixingManager is invalid, PushAudioMixingFrame failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void registerAudioFileFrameObserver(IAudioFileFrameObserver iAudioFileFrameObserver) {
        long j = this.mNativeAudioMixingManager;
        if (j != 0 && this.mNativeRTCEngine != 0) {
            this.mAudioFileFrameObserver.setAudioFileFrameObserver(iAudioFileFrameObserver);
            if (iAudioFileFrameObserver == null) {
                NativeAudioMixingManagerFunctions.nativeSetAudioFileFrameObserver(this.mNativeAudioMixingManager, this.mNativeRTCEngine, null);
            } else {
                NativeAudioMixingManagerFunctions.nativeSetAudioFileFrameObserver(this.mNativeAudioMixingManager, this.mNativeRTCEngine, this.mAudioFileFrameObserver);
            }
            return;
        }
        LogUtil.e(TAG, String.format("native AudioMixingManager or nativeEngine is invalid, registerAudioFileFrameObserver failed. audiomixixngptr=%d, rtcengine=%d", Long.valueOf(j), Long.valueOf(this.mNativeRTCEngine)));
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void resumeAllAudioMixing() {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, ResumeAllAudioMixing failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeResumeAllAudioMixing(j);
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void resumeAudioMixing(int i) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, ResumeAudioMixing failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeResumeAudioMixing(j, i);
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void selectAudioTrack(int i, int i2) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, SelectAudioTrack failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeSelectAudioTrack(j, i, i2);
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public void setAllAudioMixingVolume(int i, AudioMixingType audioMixingType) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, SetAllAudioMixingVolume failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeSetAllAudioMixingVolume(j, i, audioMixingType.value());
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void setAudioMixingDualMonoMode(int i, AudioMixingDualMonoMode audioMixingDualMonoMode) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, setAudioMixingDualMonoMode failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeSetAudioMixingDualMonoMode(j, i, audioMixingDualMonoMode.value());
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void setAudioMixingLoudness(int i, float f) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, setAudioMixingLoudness failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeSetAudioMixingLoudness(j, i, f);
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void setAudioMixingPitch(int i, int i2) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, setAudioMixingPitch failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeSetAudioMixingPitch(j, i, i2);
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized int setAudioMixingPlaybackSpeed(int i, int i2) {
        long j = this.mNativeAudioMixingManager;
        if (j != 0) {
            return NativeAudioMixingManagerFunctions.nativeSetAudioMixingPlaybackSpeed(j, i, i2);
        }
        LogUtil.e(TAG, "native AudioMixingManager is invalid, setAudioMixingPlaybackSpeed failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void setAudioMixingPosition(int i, int i2) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, SetAudioMixingPosition failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeSetAudioMixingPosition(j, i, i2);
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void setAudioMixingProgressInterval(int i, long j) {
        long j2 = this.mNativeAudioMixingManager;
        if (j2 == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, setAudioMixingProgressInterval failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeSetAudioMixingProgressInterval(j2, i, j);
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void setAudioMixingVolume(int i, int i2, AudioMixingType audioMixingType) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, SetAudioMixingVolume failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeSetAudioMixingVolume(j, i, i2, audioMixingType.value());
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void startAudioMixing(int i, String str, AudioMixingConfig audioMixingConfig) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, StartAudioMixing failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeStartAudioMixing(j, i, str, audioMixingConfig.type.value(), audioMixingConfig.playCount, audioMixingConfig.position, audioMixingConfig.callbackOnProgressInterval, audioMixingConfig.syncProgressToRecordFrame);
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void stopAllAudioMixing() {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, StopAllAudioMixing failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeStopAllAudioMixing(j);
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void stopAudioMixing(int i) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, StopAudioMixing failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeStopAudioMixing(j, i);
        }
    }

    @Override // com.ss.bytertc.engine.audio.IAudioMixingManager
    public synchronized void unloadAudioMixing(int i) {
        long j = this.mNativeAudioMixingManager;
        if (j == 0) {
            LogUtil.e(TAG, "native AudioMixingManager is invalid, UnloadAudioMixing failed.");
        } else {
            NativeAudioMixingManagerFunctions.nativeUnloadAudioMixing(j, i);
        }
    }

    public AudioMixingManager(long j, long j2) {
        this.mAudioFileFrameObserver = null;
        this.mNativeAudioMixingManager = j;
        this.mNativeRTCEngine = j2;
        this.mAudioFileFrameObserver = new RTCAudioFileFrameObserver();
    }
}
