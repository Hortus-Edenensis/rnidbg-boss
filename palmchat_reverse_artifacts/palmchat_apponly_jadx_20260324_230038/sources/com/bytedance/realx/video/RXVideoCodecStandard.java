package com.bytedance.realx.video;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
enum RXVideoCodecStandard {
    H264(0),
    ByteVC1(1),
    Unknown(2),
    VP8(8),
    VP9(9);

    private final int value;

    RXVideoCodecStandard(int i) {
        this.value = i;
    }

    public static RXVideoCodecStandard fromValue(int i) {
        return i != 0 ? i != 1 ? i != 8 ? H264 : VP8 : ByteVC1 : H264;
    }

    public String mimeType() {
        int i = this.value;
        return i != 1 ? i != 8 ? "video/avc" : "video/x-vnd.on2.vp8" : "video/hevc";
    }

    public int toInt() {
        return this.value;
    }
}
