package com.oplus.tbl.exoplayer2.effect;

import android.graphics.Matrix;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public interface MatrixTransformation extends GlMatrixTransformation {
    @Override // com.oplus.tbl.exoplayer2.effect.GlMatrixTransformation
    float[] getGlMatrixArray(long j);

    Matrix getMatrix(long j);
}
