package com.ss.android.ttvecamera.cameraalgorithm;

import androidx.annotation.Keep;
import com.ss.android.ttvecamera.provider.TECameraProvider;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Keep
public class TECameraAlgorithmParam {
    public TECameraProvider.CaptureListener processListener;
    public int type = TECameraAlgorithmType.TE_CAMERA_ALGORITHM_TYPE_INVALID;

    /* JADX INFO: compiled from: SearchBox */
    public static class TECameraAlgorithmType {
        public static int TE_CAMERA_ALGORITHM_TYPE_FACE_DETECT = 2;
        public static int TE_CAMERA_ALGORITHM_TYPE_INVALID = 0;
        public static int TE_CAMERA_ALGORITHM_TYPE_LENS_SHARPEN = 4;
        public static int TE_CAMERA_ALGORITHM_TYPE_RHYTHMIC_MOTION = 8;
    }
}
