package com.ss.bytertc.ktv;

import androidx.annotation.NonNull;
import com.ss.bytertc.ktv.data.AudioPlayType;
import com.ss.bytertc.ktv.data.AudioTrackType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class IKTVPlayer {
    public abstract void pauseMusic(@NonNull String str);

    public abstract void playMusic(@NonNull String str, @NonNull AudioTrackType audioTrackType, @NonNull AudioPlayType audioPlayType);

    public abstract void resumeMusic(@NonNull String str);

    public abstract void seekMusic(@NonNull String str, int i);

    public abstract void setMusicPitch(@NonNull String str, int i);

    public abstract void setMusicVolume(@NonNull String str, int i);

    public abstract void setPlayerEventHandler(IKTVPlayerEventHandler iKTVPlayerEventHandler);

    public abstract void stopMusic(@NonNull String str);

    public abstract void switchAudioTrackType(@NonNull String str);
}
