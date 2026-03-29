package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.IAudioFileFrameObserver;
import com.ss.bytertc.engine.data.AudioMixingConfig;
import com.ss.bytertc.engine.data.AudioMixingDualMonoMode;
import com.ss.bytertc.engine.data.AudioMixingType;
import com.ss.bytertc.engine.utils.AudioFrame;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class IAudioMixingManager {
    @Deprecated
    public abstract void disableAudioMixingFrame(int i);

    @Deprecated
    public abstract void enableAudioMixingFrame(int i, AudioMixingType audioMixingType);

    @Deprecated
    public abstract int getAudioMixingCurrentPosition(int i);

    @Deprecated
    public abstract int getAudioMixingDuration(int i);

    @Deprecated
    public abstract int getAudioMixingPlaybackDuration(int i);

    @Deprecated
    public abstract int getAudioTrackCount(int i);

    @Deprecated
    public abstract void pauseAllAudioMixing();

    @Deprecated
    public abstract void pauseAudioMixing(int i);

    @Deprecated
    public abstract void preloadAudioMixing(int i, String str);

    @Deprecated
    public abstract int pushAudioMixingFrame(int i, AudioFrame audioFrame);

    @Deprecated
    public abstract void registerAudioFileFrameObserver(IAudioFileFrameObserver iAudioFileFrameObserver);

    @Deprecated
    public abstract void resumeAllAudioMixing();

    @Deprecated
    public abstract void resumeAudioMixing(int i);

    @Deprecated
    public abstract void selectAudioTrack(int i, int i2);

    @Deprecated
    public abstract void setAllAudioMixingVolume(int i, AudioMixingType audioMixingType);

    @Deprecated
    public abstract void setAudioMixingDualMonoMode(int i, AudioMixingDualMonoMode audioMixingDualMonoMode);

    @Deprecated
    public abstract void setAudioMixingLoudness(int i, float f);

    @Deprecated
    public abstract void setAudioMixingPitch(int i, int i2);

    @Deprecated
    public abstract int setAudioMixingPlaybackSpeed(int i, int i2);

    @Deprecated
    public abstract void setAudioMixingPosition(int i, int i2);

    @Deprecated
    public abstract void setAudioMixingProgressInterval(int i, long j);

    @Deprecated
    public abstract void setAudioMixingVolume(int i, int i2, AudioMixingType audioMixingType);

    @Deprecated
    public abstract void startAudioMixing(int i, String str, AudioMixingConfig audioMixingConfig);

    @Deprecated
    public abstract void stopAllAudioMixing();

    @Deprecated
    public abstract void stopAudioMixing(int i);

    @Deprecated
    public abstract void unloadAudioMixing(int i);
}
