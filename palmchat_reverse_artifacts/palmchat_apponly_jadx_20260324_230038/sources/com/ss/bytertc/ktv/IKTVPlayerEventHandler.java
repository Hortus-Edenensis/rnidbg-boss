package com.ss.bytertc.ktv;

import androidx.annotation.NonNull;
import com.ss.bytertc.ktv.data.KTVPlayerErrorCode;
import com.ss.bytertc.ktv.data.PlayState;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class IKTVPlayerEventHandler {
    public abstract void onPlayProgress(@NonNull String str, long j);

    public abstract void onPlayStateChanged(@NonNull String str, @NonNull PlayState playState, KTVPlayerErrorCode kTVPlayerErrorCode);
}
