package com.oplus.tbl.exoplayer2.effect;

import android.opengl.Matrix;
import androidx.annotation.OptIn;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class SamplerOverlayMatrixProvider extends OverlayMatrixProvider {
    private final float[] transformationMatrixInv = GlUtil.create4x4IdentityMatrix();

    @OptIn(markerClass = {UnstableApi.class})
    public SamplerOverlayMatrixProvider() {
    }

    @Override // com.oplus.tbl.exoplayer2.effect.OverlayMatrixProvider
    @OptIn(markerClass = {UnstableApi.class})
    public float[] getTransformationMatrix(Size size, OverlaySettings overlaySettings) {
        Matrix.invertM(this.transformationMatrixInv, 0, super.getTransformationMatrix(size, overlaySettings.buildUpon().setOverlayFrameAnchor(((Float) overlaySettings.overlayFrameAnchor.first).floatValue() * (-1.0f), ((Float) overlaySettings.overlayFrameAnchor.second).floatValue() * (-1.0f)).build()), 0);
        return this.transformationMatrixInv;
    }
}
