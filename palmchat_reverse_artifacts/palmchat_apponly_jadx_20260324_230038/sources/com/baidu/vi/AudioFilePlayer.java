package com.baidu.vi;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class AudioFilePlayer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediaPlayer f4289a = new MediaPlayer();

    private AudioFilePlayer() {
    }

    private native boolean onErrorOccured(long j, int i);

    private native void onPlayCompleted(long j);
}
