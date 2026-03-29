package com.oplus.tblplayer.processor;

import android.content.Context;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.GlEffect;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tblplayer.processor.HomoMatrixTransformation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@RequiresApi(26)
public final class HomoMatrixTransformationEffect implements GlEffect {
    private static final String TAG = "HomoMatrixEffect";
    public HomoMatrixTransformation mGlEffect;
    private MultiTextureMatrixProvider matrixProvider;

    public HomoMatrixTransformationEffect(MultiTextureMatrixProvider multiTextureMatrixProvider, boolean z, int i, float f) {
        this.matrixProvider = multiTextureMatrixProvider;
        this.mGlEffect = new HomoMatrixTransformation.Builder().setMatrixProvider(multiTextureMatrixProvider).setEnableEdgeBlur(true).setEdgeBlurAmount(f).setInverseMatrix(z).setMatrixRotationDegrees(i).build();
    }

    public static HomoMatrixTransformationEffect createHomoMatrixEffect(MultiTextureMatrixProvider multiTextureMatrixProvider, boolean z, int i) {
        return createHomoMatrixEffect(multiTextureMatrixProvider, z, i, 10.0f);
    }

    public synchronized long getEndTimeUs() {
        MultiTextureMatrixProvider multiTextureMatrixProvider = this.matrixProvider;
        if (multiTextureMatrixProvider == null) {
            return -9223372036854775807L;
        }
        return multiTextureMatrixProvider.getLastTimestamp();
    }

    public synchronized long getStartTimeUs() {
        MultiTextureMatrixProvider multiTextureMatrixProvider = this.matrixProvider;
        if (multiTextureMatrixProvider == null) {
            return -9223372036854775807L;
        }
        return multiTextureMatrixProvider.getFirstTimestamp();
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return this.mGlEffect.isNoOp(i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new HomoShaderProgram(context, z, this);
    }

    public static HomoMatrixTransformationEffect createHomoMatrixEffect(MultiTextureMatrixProvider multiTextureMatrixProvider, boolean z, int i, float f) {
        return new HomoMatrixTransformationEffect(multiTextureMatrixProvider, z, i, f);
    }
}
