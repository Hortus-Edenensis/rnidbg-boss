package com.effectsar.labcv.effectsdk;

import android.graphics.PointF;
import android.graphics.Rect;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BefHandInfo {
    private int handCount = 0;
    private BefHand[] hands;

    /* JADX INFO: compiled from: SearchBox */
    public static class BefHand {
        private int action;
        private int id;
        private BefKeyPoint[] keyPoints;
        private BefKeyPoint[] keyPointsExt;
        private Rect rect;
        private float rotAngle;
        private float rotAngleBothhand;
        private float score;
        private int seqAction;

        public int getAction() {
            return this.action;
        }

        public int getId() {
            return this.id;
        }

        public BefKeyPoint[] getKeyPoints() {
            return this.keyPoints;
        }

        public BefKeyPoint[] getKeyPointsExt() {
            return this.keyPointsExt;
        }

        public Rect getRect() {
            return this.rect;
        }

        public float getRotAngle() {
            return this.rotAngle;
        }

        public float getRotAngleBothhand() {
            return this.rotAngleBothhand;
        }

        public float getScore() {
            return this.score;
        }

        public int getSeqAction() {
            return this.seqAction;
        }

        public String toString() {
            return "BefHand{id=" + this.id + ", rect=" + this.rect + ", action=" + this.action + ", rotAngle=" + this.rotAngle + ", score=" + this.score + ", rotAngleBothhand=" + this.rotAngleBothhand + ", keyPoints=" + Arrays.toString(this.keyPoints) + ", keyPointsExt=" + Arrays.toString(this.keyPointsExt) + ", seqAction=" + this.seqAction + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class BefKeyPoint {
        boolean is_detect;
        float x;
        float y;

        public BefKeyPoint(float f, float f2, boolean z) {
            this.x = f;
            this.y = f2;
            this.is_detect = z;
        }

        public PointF asPoint() {
            return new PointF(this.x, this.y);
        }

        public String toString() {
            return "BefKeyPoint { x =" + this.x + " y =" + this.y + " is_detect =" + this.is_detect + "}";
        }
    }

    public int getHandCount() {
        return this.handCount;
    }

    public BefHand[] getHands() {
        return this.hands;
    }

    public String toString() {
        return "BefHandInfo{hands=" + Arrays.toString(this.hands) + ", handCount=" + this.handCount + '}';
    }
}
