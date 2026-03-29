package com.oplus.tbl.exoplayer2.extractor.wav;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class WavHeader {
    public final int averageBytesPerSecond;
    public final int bitsPerSample;
    public final int blockSize;
    public final byte[] extraData;
    public final int formatType;
    public final int frameRateHz;
    public final int numChannels;

    public WavHeader(int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr) {
        this.formatType = i;
        this.numChannels = i2;
        this.frameRateHz = i3;
        this.averageBytesPerSecond = i4;
        this.blockSize = i5;
        this.bitsPerSample = i6;
        this.extraData = bArr;
    }
}
