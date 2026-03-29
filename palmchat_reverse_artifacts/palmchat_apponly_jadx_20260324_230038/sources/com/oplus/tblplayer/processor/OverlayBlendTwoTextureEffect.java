package com.oplus.tblplayer.processor;

import android.content.Context;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.BaseGlShaderProgram;
import com.oplus.tbl.exoplayer2.effect.GlEffect;
import com.oplus.tbl.exoplayer2.util.Assertions;
import defpackage.yb2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class OverlayBlendTwoTextureEffect implements GlEffect {
    private final float alphaScale;

    public OverlayBlendTwoTextureEffect(@FloatRange(from = 0.0d) float f) {
        Assertions.checkArgument(0.0f <= f, "Invalid input alpha-scale value: " + f);
        this.alphaScale = f;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public /* synthetic */ boolean isNoOp(int i, int i2) {
        return yb2.a(this, i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    @NonNull
    public BaseGlShaderProgram toGlShaderProgram(@NonNull Context context, boolean z) throws VideoFrameProcessingException {
        return new OverlayBlendTwoTextureShaderProgram(context, z, this.alphaScale, false);
    }
}
