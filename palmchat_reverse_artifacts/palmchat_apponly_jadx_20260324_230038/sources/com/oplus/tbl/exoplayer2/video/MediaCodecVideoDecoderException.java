package com.oplus.tbl.exoplayer2.video;

import android.view.Surface;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MediaCodecVideoDecoderException extends MediaCodecDecoderException {
    public final boolean isSurfaceValid;
    public final int surfaceIdentityHashCode;

    public MediaCodecVideoDecoderException(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo, @Nullable Surface surface) {
        super(th, mediaCodecInfo);
        this.surfaceIdentityHashCode = System.identityHashCode(surface);
        this.isSurfaceValid = surface == null || surface.isValid();
    }
}
