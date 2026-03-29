package com.ss.bytertc.engine.data;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class StreamSycnInfoConfig {
    public int repeatCount;
    public StreamIndex streamIndex;
    public SyncInfoStreamType streamType;

    /* JADX INFO: compiled from: SearchBox */
    public enum SyncInfoStreamType {
        SYNC_INFO_STREAM_TYPE_AUDIO
    }

    public StreamSycnInfoConfig(StreamIndex streamIndex, int i, SyncInfoStreamType syncInfoStreamType) {
        this.streamIndex = streamIndex;
        this.repeatCount = i;
        this.streamType = syncInfoStreamType;
    }

    public String toString() {
        return "StreamSycnInfoConfig{ streamIndex='" + this.streamIndex.toString() + "'repeatCount='" + this.repeatCount + "'streamType=Audio }";
    }
}
