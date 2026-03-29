package com.oplus.tbl.exoplayer2.effect;

import android.opengl.Matrix;
import android.util.Pair;
import androidx.annotation.OptIn;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class OverlayMatrixProvider {
    protected static final int MATRIX_OFFSET = 0;
    private Size backgroundSize;
    private final float[] aspectRatioMatrix = GlUtil.create4x4IdentityMatrix();
    private final float[] backgroundFrameAnchorMatrix = GlUtil.create4x4IdentityMatrix();
    private final float[] overlayFrameAnchorMatrix = GlUtil.create4x4IdentityMatrix();
    private final float[] rotateMatrix = GlUtil.create4x4IdentityMatrix();
    private final float[] scaleMatrix = GlUtil.create4x4IdentityMatrix();
    private final float[] scaleMatrixInv = GlUtil.create4x4IdentityMatrix();
    private final float[] overlayAspectRatioMatrix = GlUtil.create4x4IdentityMatrix();
    private final float[] overlayAspectRatioMatrixInv = GlUtil.create4x4IdentityMatrix();
    private final float[] transformationMatrix = GlUtil.create4x4IdentityMatrix();

    @OptIn(markerClass = {UnstableApi.class})
    public OverlayMatrixProvider() {
    }

    @OptIn(markerClass = {UnstableApi.class})
    private void reset() {
        GlUtil.setToIdentity(this.aspectRatioMatrix);
        GlUtil.setToIdentity(this.backgroundFrameAnchorMatrix);
        GlUtil.setToIdentity(this.overlayFrameAnchorMatrix);
        GlUtil.setToIdentity(this.scaleMatrix);
        GlUtil.setToIdentity(this.scaleMatrixInv);
        GlUtil.setToIdentity(this.rotateMatrix);
        GlUtil.setToIdentity(this.overlayAspectRatioMatrix);
        GlUtil.setToIdentity(this.overlayAspectRatioMatrixInv);
        GlUtil.setToIdentity(this.transformationMatrix);
    }

    public void configure(Size size) {
        this.backgroundSize = size;
    }

    @OptIn(markerClass = {UnstableApi.class})
    public float[] getTransformationMatrix(Size size, OverlaySettings overlaySettings) {
        reset();
        Pair<Float, Float> pair = overlaySettings.backgroundFrameAnchor;
        Matrix.translateM(this.backgroundFrameAnchorMatrix, 0, ((Float) pair.first).floatValue(), ((Float) pair.second).floatValue(), 0.0f);
        Assertions.checkStateNotNull(this.backgroundSize);
        Matrix.scaleM(this.aspectRatioMatrix, 0, size.getWidth() / this.backgroundSize.getWidth(), size.getHeight() / this.backgroundSize.getHeight(), 1.0f);
        Pair<Float, Float> pair2 = overlaySettings.scale;
        Matrix.scaleM(this.scaleMatrix, 0, ((Float) pair2.first).floatValue(), ((Float) pair2.second).floatValue(), 1.0f);
        Matrix.invertM(this.scaleMatrixInv, 0, this.scaleMatrix, 0);
        Pair<Float, Float> pair3 = overlaySettings.overlayFrameAnchor;
        Matrix.translateM(this.overlayFrameAnchorMatrix, 0, ((Float) pair3.first).floatValue() * (-1.0f), ((Float) pair3.second).floatValue() * (-1.0f), 0.0f);
        Matrix.rotateM(this.rotateMatrix, 0, overlaySettings.rotationDegrees, 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(this.overlayAspectRatioMatrix, 0, size.getHeight() / size.getWidth(), 1.0f, 1.0f);
        Matrix.invertM(this.overlayAspectRatioMatrixInv, 0, this.overlayAspectRatioMatrix, 0);
        float[] fArr = this.transformationMatrix;
        Matrix.multiplyMM(fArr, 0, fArr, 0, this.backgroundFrameAnchorMatrix, 0);
        float[] fArr2 = this.transformationMatrix;
        Matrix.multiplyMM(fArr2, 0, fArr2, 0, this.aspectRatioMatrix, 0);
        float[] fArr3 = this.transformationMatrix;
        Matrix.multiplyMM(fArr3, 0, fArr3, 0, this.scaleMatrix, 0);
        float[] fArr4 = this.transformationMatrix;
        Matrix.multiplyMM(fArr4, 0, fArr4, 0, this.overlayFrameAnchorMatrix, 0);
        float[] fArr5 = this.transformationMatrix;
        Matrix.multiplyMM(fArr5, 0, fArr5, 0, this.scaleMatrixInv, 0);
        float[] fArr6 = this.transformationMatrix;
        Matrix.multiplyMM(fArr6, 0, fArr6, 0, this.overlayAspectRatioMatrix, 0);
        float[] fArr7 = this.transformationMatrix;
        Matrix.multiplyMM(fArr7, 0, fArr7, 0, this.rotateMatrix, 0);
        float[] fArr8 = this.transformationMatrix;
        Matrix.multiplyMM(fArr8, 0, fArr8, 0, this.overlayAspectRatioMatrixInv, 0);
        float[] fArr9 = this.transformationMatrix;
        Matrix.multiplyMM(fArr9, 0, fArr9, 0, this.scaleMatrix, 0);
        return this.transformationMatrix;
    }
}
