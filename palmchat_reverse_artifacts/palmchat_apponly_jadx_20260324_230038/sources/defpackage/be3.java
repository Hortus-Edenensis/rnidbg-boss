package defpackage;

import com.oplus.tbl.exoplayer2.effect.MatrixTransformation;
import com.oplus.tbl.exoplayer2.effect.MatrixUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class be3 {
    public static float[] a(MatrixTransformation matrixTransformation, long j) {
        return MatrixUtils.getGlMatrixArray(matrixTransformation.getMatrix(j));
    }
}
