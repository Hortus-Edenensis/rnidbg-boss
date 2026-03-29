package com.ss.android.ttvecamera.cameraalgorithm;

import androidx.annotation.Keep;
import com.ss.android.ttvecamera.cameraalgorithm.TECameraAlgorithmParam;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Keep
public class TERhythmicMotionParam extends TECameraAlgorithmParam {
    public float[] cropList = new float[3];
    public float maxAlpha;
    public float maxVelocity;

    public TERhythmicMotionParam() {
        this.type = TECameraAlgorithmParam.TECameraAlgorithmType.TE_CAMERA_ALGORITHM_TYPE_RHYTHMIC_MOTION;
    }
}
