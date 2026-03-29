package androidx.media3.effect;

import android.graphics.Matrix;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface MatrixTransformation extends GlMatrixTransformation {
    @Override // androidx.media3.effect.GlMatrixTransformation
    float[] getGlMatrixArray(long j);

    Matrix getMatrix(long j);
}
