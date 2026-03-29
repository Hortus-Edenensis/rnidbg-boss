package com.effectsar.labcv.effectsdk;

import com.effectsar.labcv.effectsdk.BefPublicDefine;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BefDynamicActionInfo {
    private int personCount;
    private DynamicActionInfo[] persons;
    private DynamicSkInfo[] skInfos;

    /* JADX INFO: compiled from: SearchBox */
    public static class DynamicActionInfo {
        private int action;
        private int actionDuration;
        private float actionScore;
        private int id;
        private int personId;
        private BefPublicDefine.BefRect rect;
        private BefPublicDefine.BefRect rectStl;

        public int getAction() {
            return this.action;
        }

        public int getActionDuration() {
            return this.actionDuration;
        }

        public float getActionScore() {
            return this.actionScore;
        }

        public int getId() {
            return this.id;
        }

        public int getPersonId() {
            return this.personId;
        }

        public BefPublicDefine.BefRect getRect() {
            return this.rect;
        }

        public BefPublicDefine.BefRect getRectStl() {
            return this.rectStl;
        }

        public String toString() {
            return "DynamicActionInfo{id=" + this.id + ", personId=" + this.personId + ", rect=" + this.rect + ", rectStl=" + this.rectStl + ", action=" + this.action + ", actionDuration=" + this.actionDuration + ", actionScore=" + this.actionScore + '}';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class DynamicSkInfo {
        private int id;
        private BefPublicDefine.BefKeyPoint[] keyPoints;
        private BefPublicDefine.BefRect rect;

        public int getId() {
            return this.id;
        }

        public BefPublicDefine.BefKeyPoint[] getKeyPoints() {
            return this.keyPoints;
        }

        public BefPublicDefine.BefRect getRect() {
            return this.rect;
        }

        public void setId(int i) {
            this.id = i;
        }

        public void setKeyPoints(BefPublicDefine.BefKeyPoint[] befKeyPointArr) {
            this.keyPoints = befKeyPointArr;
        }

        public void setRect(BefPublicDefine.BefRect befRect) {
            this.rect = befRect;
        }

        public String toString() {
            return "DynamicSkInfo{id=" + this.id + ", rect=" + this.rect + ", keyPoints=" + Arrays.toString(this.keyPoints) + '}';
        }
    }

    public int getPersonCount() {
        return this.personCount;
    }

    public DynamicActionInfo[] getPersons() {
        return this.persons;
    }

    public DynamicSkInfo[] getSkInfos() {
        return this.skInfos;
    }
}
