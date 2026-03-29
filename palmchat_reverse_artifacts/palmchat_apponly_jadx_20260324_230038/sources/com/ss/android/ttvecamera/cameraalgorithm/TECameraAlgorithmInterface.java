package com.ss.android.ttvecamera.cameraalgorithm;

import androidx.annotation.Keep;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraFrame;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Keep
public class TECameraAlgorithmInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static class TECameraAlgoResult {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface TECameraAlgorithmErrorListener {
        void onError(int i, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface TECameraAlgorithmProcessListener {
        void onProcess(float f, boolean z);
    }

    public TECameraAlgorithmInterface(TECameraBase tECameraBase) {
    }

    public int addCameraAlgorithm(TECameraAlgorithmParam tECameraAlgorithmParam) {
        return 0;
    }

    public int destroy() {
        return 0;
    }

    public TECameraAlgorithmResult getResult() {
        return null;
    }

    public int init() {
        return 0;
    }

    public native int nativeAddCameraAlgorithm(long j, Object obj);

    public native int nativeAlgorithmDestroy(long j);

    public native Object nativeAlgorithmGetResult(long j);

    public native long nativeInit();

    public native TECameraAlgoResult nativeProcessAlgorithm(long j, Object obj);

    public native int nativeRemoveCameraAlgorithm(long j, int i);

    public native int nativeUpdateCameraAlgorithmParam(long j, Object obj);

    public TECameraFrame processAlgorithm(TECameraFrame tECameraFrame) {
        return null;
    }

    public int removeCameraAlgorithm(int i) {
        return 0;
    }

    public int updateCameraAlgorithmParam(TECameraAlgorithmParam tECameraAlgorithmParam) {
        return 0;
    }

    public void setErrorListener(TECameraAlgorithmErrorListener tECameraAlgorithmErrorListener) {
    }

    public void setProcessListener(TECameraAlgorithmProcessListener tECameraAlgorithmProcessListener) {
    }

    public void nativeCallback_onError(int i, String str) {
    }

    public void nativeCallback_onProcess(float f, boolean z) {
    }
}
