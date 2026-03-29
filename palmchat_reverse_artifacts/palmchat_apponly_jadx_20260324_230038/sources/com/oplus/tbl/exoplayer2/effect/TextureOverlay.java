package com.oplus.tbl.exoplayer2.effect;

import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.OverlaySettings;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public abstract class TextureOverlay {
    private static final float[] IDENTITY_MATRIX = GlUtil.create4x4IdentityMatrix();

    public OverlaySettings getOverlaySettings(long j) {
        return new OverlaySettings.Builder().build();
    }

    public abstract int getTextureId(long j) throws VideoFrameProcessingException;

    public abstract Size getTextureSize(long j);

    public float[] getVertexTransformation(long j) {
        return IDENTITY_MATRIX;
    }

    public void release() throws VideoFrameProcessingException {
    }

    public void configure(Size size) {
    }
}
