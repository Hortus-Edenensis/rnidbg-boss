package com.oplus.tblplayer.processor.util;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MatrixUtils {
    private static final String TAG = "MatrixUtils";

    private MatrixUtils() {
    }

    public static Matrix inverseMatrix(@NonNull Matrix matrix) {
        Matrix matrix2 = new Matrix();
        matrix.invert(matrix2);
        return matrix2;
    }

    public static String matrixArrayToString(float[] fArr) {
        if (fArr == null || fArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fArr.length; i++) {
            sb.append(String.format(Locale.US, "%.8ff", Float.valueOf(fArr[i])));
            if (i < fArr.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static String matrixToString(Matrix matrix) {
        if (matrix == null) {
            return null;
        }
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return matrixArrayToString(fArr);
    }
}
