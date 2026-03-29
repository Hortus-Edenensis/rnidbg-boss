package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import defpackage.yb2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@RequiresApi(26)
@UnstableApi
public abstract class SeparableConvolution implements GlEffect {
    private final float scaleHeight;
    private final float scaleWidth;

    public SeparableConvolution() {
        this(1.0f, 1.0f);
    }

    public abstract ConvolutionFunction1D getConvolution(long j);

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public /* synthetic */ boolean isNoOp(int i, int i2) {
        return yb2.a(this, i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new SeparableConvolutionShaderProgram(context, z, this, this.scaleWidth, this.scaleHeight);
    }

    public SeparableConvolution(float f, float f2) {
        this.scaleWidth = f;
        this.scaleHeight = f2;
    }
}
