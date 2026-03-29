package com.effectsar.labcv.effectsdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BefPublicDefine {

    /* JADX INFO: compiled from: SearchBox */
    public static class BefCapturedImageInfo {
        public int format;
        public int height;
        public int rotate;
        public int stride;
        public int width;

        public String toString() {
            return "BefCapturedImageInfo{width=" + this.width + ", height=" + this.height + ", stride=" + this.stride + ", format=" + this.format + ", rotate=" + this.rotate;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class BefKeyPoint {
        private boolean isDetect;
        private float x;
        private float y;

        public BefKeyPoint(float f, float f2, boolean z) {
            this.x = f;
            this.y = f2;
            this.isDetect = z;
        }

        public float getX() {
            return this.x;
        }

        public float getY() {
            return this.y;
        }

        public boolean isDetect() {
            return this.isDetect;
        }

        public void setDetect(boolean z) {
            this.isDetect = z;
        }

        public void setX(float f) {
            this.x = f;
        }

        public void setY(float f) {
            this.y = f;
        }

        public String toString() {
            return "BefKeyPoint{x=" + this.x + ", y=" + this.y + ", isDetected=" + this.isDetect + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class BefPointF {
        private float x;
        private float y;

        public BefPointF(float f, float f2) {
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
            return "BefPointF{x=" + this.x + ", y=" + this.y;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class BefRect {
        private int bottom;
        private int left;
        private int right;
        private int top;

        public BefRect(int i, int i2, int i3, int i4) {
            this.left = i;
            this.top = i2;
            this.right = i3;
            this.bottom = i4;
        }

        public int getBottom() {
            return this.bottom;
        }

        public int getLeft() {
            return this.left;
        }

        public int getRight() {
            return this.right;
        }

        public int getTop() {
            return this.top;
        }

        public String toString() {
            return "BefRect{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
        }
    }
}
