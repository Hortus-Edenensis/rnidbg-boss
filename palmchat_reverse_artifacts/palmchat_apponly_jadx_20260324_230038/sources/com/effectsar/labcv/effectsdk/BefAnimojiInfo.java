package com.effectsar.labcv.effectsdk;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BefAnimojiInfo {
    float[] affineMat;
    float[] alpha;
    float[] beta;
    int faceId;
    float[] landmarks;
    float[] mv;
    float[] mvp;
    float[] rot;
    int success;

    public float[] getAffineMat() {
        return this.affineMat;
    }

    public float[] getAlpha() {
        return this.alpha;
    }

    public float[] getBeta() {
        return this.beta;
    }

    public int getFaceId() {
        return this.faceId;
    }

    public float[] getLandmarks() {
        return this.landmarks;
    }

    public float[] getMv() {
        return this.mv;
    }

    public float[] getMvp() {
        return this.mvp;
    }

    public float[] getRot() {
        return this.rot;
    }

    public int isSuccess() {
        return this.success;
    }

    public String toString() {
        return "BefAnimojiInfo{success=" + this.success + ", faceId=" + this.faceId + ", affineMat=" + Arrays.toString(this.affineMat) + ", alpha=" + Arrays.toString(this.alpha) + ", beta=" + Arrays.toString(this.beta) + '}';
    }
}
