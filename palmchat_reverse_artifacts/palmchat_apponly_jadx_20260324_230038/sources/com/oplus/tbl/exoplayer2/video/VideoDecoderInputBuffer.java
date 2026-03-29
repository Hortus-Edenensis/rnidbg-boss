package com.oplus.tbl.exoplayer2.video;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class VideoDecoderInputBuffer extends DecoderInputBuffer {

    @Nullable
    public Format format;

    public VideoDecoderInputBuffer(int i) {
        super(i);
    }

    public VideoDecoderInputBuffer(int i, int i2) {
        super(i, i2);
    }
}
