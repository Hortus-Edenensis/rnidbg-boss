package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public interface RgbMatrix extends GlEffect {
    float[] getMatrix(long j, boolean z);

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException;

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException;
}
