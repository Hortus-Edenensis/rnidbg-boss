package com.effectsar.labcv.effectsdk;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BefSlamInfo {
    public SlamPose cameraPose;
    public Points[] featurePoints;
    public SlamCameraIntrinsic intrinsic;
    public boolean isClicked;
    public SlamPlane planeInfo;
    public SlamPose planePose;

    /* JADX INFO: compiled from: SearchBox */
    public static class Points {
        public float x;
        public float y;

        public Points(float f, float f2) {
            this.x = f;
            this.y = f2;
        }

        public float getX() {
            return this.x;
        }

        public float getY() {
            return this.y;
        }

        public void setX(float f) {
            this.x = f;
        }

        public void setY(float f) {
            this.y = f;
        }

        public String toString() {
            return "Points{x=" + this.x + ", y=" + this.y + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SlamCameraInfo {
        public SlamCameraIntrinsic cameraIntrinsic;
        public int color;
        public int disable_internal_time_delay;
        public int easyInit;
        public int enableFusion;
        public int height;
        public float horizontal_fov;
        public int isFront;
        public int isVideo;
        public int level;
        public boolean low_texture_enhanced;
        public int orienation;
        public int resolution;
        public int runGba;
        public int width;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SlamCameraIntrinsic {
        public float cx;
        public float cy;
        public float fx;
        public float fy;

        public SlamCameraIntrinsic(float f, float f2, float f3, float f4) {
            this.fx = f;
            this.fy = f2;
            this.cx = f3;
            this.cy = f4;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SlamClickFlag {
        public int isClicked;
        public float x;
        public float y;

        public int getIsClicked() {
            return this.isClicked;
        }

        public float getX() {
            return this.x;
        }

        public float getY() {
            return this.y;
        }

        public void setIsClicked(int i) {
            this.isClicked = i;
        }

        public void setX(float f) {
            this.x = f;
        }

        public void setY(float f) {
            this.y = f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SlamImuData {
        public double timeStamp;
        public double x;
        public double y;
        public double z;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SlamImuInfo {
        int hasAccelerometer;
        int hasGravity;
        int hasGyroscope;
        int hasOrientation;

        public void setHasAccelerometer(int i) {
            this.hasAccelerometer = i;
        }

        public void setHasGravity(int i) {
            this.hasGravity = i;
        }

        public void setHasGyroscope(int i) {
            this.hasGyroscope = i;
        }

        public void setHasOrientation(int i) {
            this.hasOrientation = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SlamPlane {
        public float[] boundary;
        public int hasPlane;
        public float[] normal;
        public float offset;
        public float[] origin;
        public float[] originWorld;
        public int[] planePointsIds;

        public SlamPlane(int i, float[] fArr, float f, float[] fArr2, float[] fArr3, float[] fArr4, int[] iArr) {
            this.hasPlane = i;
            this.normal = fArr;
            this.offset = f;
            this.originWorld = fArr2;
            this.origin = fArr3;
            this.boundary = fArr4;
            this.planePointsIds = iArr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SlamPose {
        float[] R;
        float[] T;
        int planeDetected;
        double timeStamp;
        int trackingState;

        public SlamPose(float[] fArr, float[] fArr2, int i, int i2, double d) {
            this.R = fArr;
            this.T = fArr2;
            this.planeDetected = i;
            this.timeStamp = d;
            this.trackingState = i2;
        }

        public int getPlaneDetected() {
            return this.planeDetected;
        }

        public float[] getR() {
            return this.R;
        }

        public float[] getT() {
            return this.T;
        }

        public double getTimeStamp() {
            return this.timeStamp;
        }

        public int getTrackingState() {
            return this.trackingState;
        }

        public String toString() {
            return "SlamPose{R=" + Arrays.toString(this.R) + ", T=" + Arrays.toString(this.T) + ", planeDetected=" + this.planeDetected + ", trackingState=" + this.trackingState + '}';
        }
    }
}
