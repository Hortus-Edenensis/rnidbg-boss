package com.effectsar.labcv.effectsdk;

import android.graphics.PointF;
import com.effectsar.labcv.effectsdk.BefFaceInfo;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BefBachSkeletonInfo {
    private int skeletonNum;
    private Skeleton[] skeletons;

    /* JADX INFO: compiled from: SearchBox */
    public static class Skeleton {
        int id;
        SkeletonPoint[] keypoints;
        int orientation;
        BefFaceInfo.FaceRect skeletonRect;

        public int getId() {
            return this.id;
        }

        public SkeletonPoint[] getKeypoints() {
            SkeletonPoint[] skeletonPointArr = this.keypoints;
            return skeletonPointArr == null ? new SkeletonPoint[0] : skeletonPointArr;
        }

        public int getOrientation() {
            return this.orientation;
        }

        public BefFaceInfo.FaceRect getSkeletonRect() {
            return this.skeletonRect;
        }

        public String toString() {
            return "Skeleton{keypoints=" + Arrays.toString(this.keypoints) + ", skeletonRect=" + this.skeletonRect + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SkeletonPoint {
        boolean is_detect;
        float score;
        float x;
        float y;

        public SkeletonPoint(float f, float f2, boolean z, float f3) {
            this.x = f;
            this.y = f2;
            this.is_detect = z;
            this.score = f3;
        }

        public PointF asPoint() {
            return new PointF(this.x, this.y);
        }

        public float getScore() {
            return this.score;
        }

        public float getX() {
            return this.x;
        }

        public float getY() {
            return this.y;
        }

        public boolean isDetect() {
            return this.is_detect;
        }

        public void setIs_detect(boolean z) {
            this.is_detect = z;
        }

        public void setX(float f) {
            this.x = f;
        }

        public void setY(float f) {
            this.y = f;
        }

        public String toString() {
            return "FacePoint{x=" + this.x + ", y=" + this.y + ", isdetect=" + String.valueOf(this.is_detect) + '}';
        }
    }

    public int getSkeletonNum() {
        return this.skeletonNum;
    }

    public Skeleton[] getSkeletons() {
        Skeleton[] skeletonArr = this.skeletons;
        return skeletonArr == null ? new Skeleton[0] : skeletonArr;
    }

    public void setSkeletonNum(int i) {
        this.skeletonNum = i;
    }

    public String toString() {
        return "BefSkeletonInfo{skeletons=" + Arrays.toString(this.skeletons) + ", skeletonNum=" + this.skeletonNum + '}';
    }
}
