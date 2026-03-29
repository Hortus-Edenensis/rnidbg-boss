package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.IAudioEffectPlayerEventHandler;
import com.ss.bytertc.engine.data.AudioEffectPlayerConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class IAudioEffectPlayer {
    public abstract int getDuration(int i);

    public abstract int getPosition(int i);

    public abstract int getVolume(int i);

    public abstract int pause(int i);

    public abstract int pauseAll();

    public abstract int preload(int i, String str);

    public abstract int resume(int i);

    public abstract int resumeAll();

    public abstract int setEventHandler(IAudioEffectPlayerEventHandler iAudioEffectPlayerEventHandler);

    public abstract int setPosition(int i, int i2);

    public abstract int setVolume(int i, int i2);

    public abstract int setVolumeAll(int i);

    public abstract int start(int i, String str, AudioEffectPlayerConfig audioEffectPlayerConfig);

    public abstract int stop(int i);

    public abstract int stopAll();

    public abstract int unload(int i);

    public abstract int unloadAll();
}
