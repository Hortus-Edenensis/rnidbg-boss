package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.MediaPlayerCustomSourceSeekWhence;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IMediaPlayerCustomSourceProvider {
    int onReadData(ByteBuffer byteBuffer, int i);

    long onSeek(long j, MediaPlayerCustomSourceSeekWhence mediaPlayerCustomSourceSeekWhence);
}
