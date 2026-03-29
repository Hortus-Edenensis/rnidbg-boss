package com.ss.bytertc.base.media.camera;

import com.bytedance.realx.video.VideoFrame;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.ss.bytertc.base.media.camera.CameraEnumerationAndroid;
import com.ss.bytertc.base.media.camera.CameraVideoCapturer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface CameraSession {

    /* JADX INFO: compiled from: SearchBox */
    public interface CreateSessionCallback {
        void onDone(CameraSession cameraSession);

        void onFailure(FailureType failureType, String str);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface Events {
        void onCameraClosed(CameraSession cameraSession);

        void onCameraConfig(int i, int i2, CameraEnumerationAndroid.CaptureFormat.FramerateRange framerateRange);

        void onCameraDisconnected(CameraSession cameraSession);

        void onCameraError(CameraSession cameraSession, String str);

        void onCameraOpening();

        void onFrameCaptured(CameraSession cameraSession, VideoFrame videoFrame);
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum FailureType {
        ERROR,
        DISCONNECTED
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum UIDeviceOrientation {
        Portrait(0),
        LandscapeLeft(90),
        PortraitUpsideDown(EffectConstants.ROTATION_DEGREES_180),
        LandscapeRight(270);

        private int value;

        UIDeviceOrientation(int i) {
            this.value = i;
        }

        public int value() {
            return this.value;
        }
    }

    int enableFollowGravity(boolean z);

    float getCameraZoomMaxRatio();

    int getDeviceOrientation();

    boolean isCameraTorchSupported();

    boolean isCameraZoomSupported();

    int setCameraZoomRatio(float f);

    void setOrientationMode(CameraVideoCapturer.ORIENTATION_MODE orientation_mode);

    void stop();

    void turnOffFlashLight();

    void turnOnFlashLight();
}
