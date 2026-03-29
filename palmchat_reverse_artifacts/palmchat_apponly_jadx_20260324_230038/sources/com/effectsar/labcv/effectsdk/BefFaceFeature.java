package com.effectsar.labcv.effectsdk;

import com.effectsar.labcv.effectsdk.BefFaceInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BefFaceFeature {
    private BefFaceInfo.Face106[] baseInfo;
    private float[][] features;
    private int validFaceNum;

    public BefFaceInfo.Face106[] getBaseInfo() {
        return this.baseInfo;
    }

    public float[][] getFeatures() {
        return this.features;
    }

    public int getValidFaceNum() {
        return this.validFaceNum;
    }

    public String toString() {
        return "BefFaceFeature{ validFaceNum =" + this.validFaceNum + " baseInfo = " + this.baseInfo.toString() + " features =" + this.features.toString();
    }
}
