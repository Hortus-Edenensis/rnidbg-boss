package com.ss.bytertc.engine;

import com.bytedance.realx.base.CalledByNative;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.utils.IAudioFrame;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IAudioFrameObserver {
    @CalledByNative
    void onMixedAudioFrame(IAudioFrame iAudioFrame);

    @CalledByNative
    void onPlaybackAudioFrame(IAudioFrame iAudioFrame);

    @CalledByNative
    void onRecordAudioFrame(IAudioFrame iAudioFrame);

    @CalledByNative
    void onRemoteUserAudioFrame(RemoteStreamKey remoteStreamKey, IAudioFrame iAudioFrame);
}
