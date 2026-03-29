package com.ss.bytertc.engine.video;

import com.bytedance.realx.base.CalledByNative;
import com.bytedance.realx.base.JniCommon;
import com.ss.bytertc.engine.video.VideoStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class WrappedNativeStreamBuffer implements VideoStream.Buffer {
    private final ByteBuffer data;
    private final long nativeBuffer;
    private final int size;

    @CalledByNative
    public WrappedNativeStreamBuffer(int i, ByteBuffer byteBuffer, long j) {
        this.size = i;
        this.data = byteBuffer;
        this.nativeBuffer = j;
        retain();
    }

    @Override // com.ss.bytertc.engine.video.VideoStream.Buffer
    public ByteBuffer getData() {
        return this.data.slice();
    }

    @Override // com.ss.bytertc.engine.video.VideoStream.Buffer
    public int getDataSize() {
        return this.size;
    }

    @Override // com.ss.bytertc.engine.video.VideoStream.Buffer, com.bytedance.realx.base.RefCounted
    public void release() {
        JniCommon.nativeReleaseRef(this.nativeBuffer);
    }

    @Override // com.ss.bytertc.engine.video.VideoStream.Buffer, com.bytedance.realx.base.RefCounted
    public void retain() {
        JniCommon.nativeAddRef(this.nativeBuffer);
    }
}
