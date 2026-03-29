package androidx.media3.muxer;

import androidx.media3.common.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class BufferInfo {
    public final int flags;
    public final long presentationTimeUs;
    public final int size;

    public BufferInfo(long j, int i, int i2) {
        this.presentationTimeUs = j;
        this.size = i;
        this.flags = i2;
    }
}
