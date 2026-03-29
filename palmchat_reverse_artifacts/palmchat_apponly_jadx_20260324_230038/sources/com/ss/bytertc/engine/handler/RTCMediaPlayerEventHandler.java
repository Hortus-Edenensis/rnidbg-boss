package com.ss.bytertc.engine.handler;

import com.bytedance.realx.base.CalledByNative;
import com.ss.bytertc.engine.IMediaPlayerEventHandler;
import com.ss.bytertc.engine.data.PlayerError;
import com.ss.bytertc.engine.data.PlayerState;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RTCMediaPlayerEventHandler {
    private IMediaPlayerEventHandler mMediaPlayerHandler;

    @CalledByNative
    public void onMediaPlayerPlayingProgress(int i, long j) {
        IMediaPlayerEventHandler iMediaPlayerEventHandler = this.mMediaPlayerHandler;
        if (iMediaPlayerEventHandler != null) {
            iMediaPlayerEventHandler.onMediaPlayerPlayingProgress(i, j);
        }
    }

    @CalledByNative
    public void onMediaPlayerStateChanged(int i, PlayerState playerState, PlayerError playerError) {
        IMediaPlayerEventHandler iMediaPlayerEventHandler = this.mMediaPlayerHandler;
        if (iMediaPlayerEventHandler != null) {
            iMediaPlayerEventHandler.onMediaPlayerStateChanged(i, playerState, playerError);
        }
    }

    public void setMediaPlayerEventHandler(IMediaPlayerEventHandler iMediaPlayerEventHandler) {
        this.mMediaPlayerHandler = iMediaPlayerEventHandler;
    }
}
