package com.ss.bytertc.engine.video;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class RTCWatermarkConfig {
    public ByteWatermark positionInLandscapeMode;
    public ByteWatermark positionInPortraitMode;
    public boolean visibleInPreview;

    public RTCWatermarkConfig() {
        this.visibleInPreview = true;
    }

    public RTCWatermarkConfig(boolean z, ByteWatermark byteWatermark, ByteWatermark byteWatermark2) {
        this.visibleInPreview = z;
        this.positionInLandscapeMode = byteWatermark;
        this.positionInPortraitMode = byteWatermark2;
    }
}
