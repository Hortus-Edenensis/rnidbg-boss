package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public interface GlMatrixTransformation extends GlEffect {
    Size configure(int i, int i2);

    float[] getGlMatrixArray(long j);

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException;

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    /* bridge */ /* synthetic */ GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException;
}
