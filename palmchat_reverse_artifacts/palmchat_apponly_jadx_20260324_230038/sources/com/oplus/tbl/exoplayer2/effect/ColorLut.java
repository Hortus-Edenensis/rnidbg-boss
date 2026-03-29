package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public interface ColorLut extends GlEffect {
    int getLength(long j);

    int getLutTextureId(long j);

    void release() throws GlUtil.GlException;

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException;
}
