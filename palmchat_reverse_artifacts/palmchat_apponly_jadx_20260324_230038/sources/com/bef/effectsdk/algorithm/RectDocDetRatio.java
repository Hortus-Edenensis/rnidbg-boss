package com.bef.effectsdk.algorithm;

import defpackage.lk1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@lk1
public class RectDocDetRatio {
    private int heightVal;
    private float ratio;
    private int widthVal;

    @lk1
    public RectDocDetRatio(float f, int i, int i2) {
        this.ratio = f;
        this.widthVal = i;
        this.heightVal = i2;
    }

    public int getHeightVal() {
        return this.heightVal;
    }

    public float getRatio() {
        return this.ratio;
    }

    public int getWidthVal() {
        return this.widthVal;
    }
}
