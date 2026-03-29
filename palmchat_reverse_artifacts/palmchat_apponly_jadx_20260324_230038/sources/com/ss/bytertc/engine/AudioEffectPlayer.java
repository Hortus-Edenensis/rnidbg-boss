package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.IAudioEffectPlayer;
import com.ss.bytertc.engine.data.AudioEffectPlayerConfig;
import com.ss.bytertc.engine.data.ReturnStatus;
import com.ss.bytertc.engine.handler.RTCAudioEffectPlayerEventHandler;
import com.ss.bytertc.engine.utils.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class AudioEffectPlayer extends IAudioEffectPlayer {
    private static final String TAG = "AudioEffectPlayer";
    private RTCAudioEffectPlayerEventHandler mAudioEffectPlayerEventHandler;
    private long mNativeAudioEffectPlayer;
    private long mNativeRTCEngine;

    public AudioEffectPlayer(long j) {
        this(j, 0L);
    }

    public synchronized void destroy() {
        this.mNativeAudioEffectPlayer = 0L;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int getDuration(int i) {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativeGetDuration(j, i);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, getDuration failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int getPosition(int i) {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativeGetPosition(j, i);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, getPosition failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int getVolume(int i) {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativeGetVolume(j, i);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, getVolume failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int pause(int i) {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativePause(j, i);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, pause failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int pauseAll() {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativePauseAll(j);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, pauseAll failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int preload(int i, String str) {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativePreload(j, i, str);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, preload failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int resume(int i) {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativeResume(j, i);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, resume failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int resumeAll() {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativeResumeAll(j);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, resumeAll failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int setEventHandler(IAudioEffectPlayerEventHandler iAudioEffectPlayerEventHandler) {
        if (this.mNativeAudioEffectPlayer != 0 && this.mNativeRTCEngine != 0) {
            this.mAudioEffectPlayerEventHandler.setAudioEffectPlayerEventHandler(iAudioEffectPlayerEventHandler);
            if (iAudioEffectPlayerEventHandler == null) {
                return NativeAudioEffectPlayerFunctions.nativeSetEventHandler(this.mNativeAudioEffectPlayer, this.mNativeRTCEngine, null);
            }
            return NativeAudioEffectPlayerFunctions.nativeSetEventHandler(this.mNativeAudioEffectPlayer, this.mNativeRTCEngine, this.mAudioEffectPlayerEventHandler);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid or nativeEngine is invalid, setEventHandler failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int setPosition(int i, int i2) {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativeSetPosition(j, i, i2);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, setPosition failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int setVolume(int i, int i2) {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativeSetVolume(j, i, i2);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, setVolume failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int setVolumeAll(int i) {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativeSetVolumeAll(j, i);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, setVolumeAll failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int start(int i, String str, AudioEffectPlayerConfig audioEffectPlayerConfig) {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativeStart(j, i, str, audioEffectPlayerConfig.type.value(), audioEffectPlayerConfig.playCount, audioEffectPlayerConfig.startPos, audioEffectPlayerConfig.pitch);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, start failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int stop(int i) {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativeStop(j, i);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, stop failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int stopAll() {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativeStopAll(j);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, stopAll failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int unload(int i) {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativeUnload(j, i);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, unload failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int unloadAll() {
        long j = this.mNativeAudioEffectPlayer;
        if (j != 0) {
            return NativeAudioEffectPlayerFunctions.nativeUnloadAll(j);
        }
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, unloadAll failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    public AudioEffectPlayer(long j, long j2) {
        this.mAudioEffectPlayerEventHandler = null;
        this.mNativeAudioEffectPlayer = j;
        this.mNativeRTCEngine = j2;
        this.mAudioEffectPlayerEventHandler = new RTCAudioEffectPlayerEventHandler();
    }
}
