package com.bef.effectsdk.algorithm;

import defpackage.lk1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@lk1
public class RectDocDetResult {
    public static final int DETECT_FAIL = -1;
    public static final int DETECT_SUCCESS = 0;
    private RectDocDetRatio rectDocDetRatio;
    private RectDocDetTargetArea rectDocDetTargetArea;
    private int resultStatus = -1;

    @lk1
    public RectDocDetResult() {
    }

    public RectDocDetRatio getRectDocDetRatio() {
        return this.rectDocDetRatio;
    }

    public RectDocDetTargetArea getRectDocDetTargetArea() {
        return this.rectDocDetTargetArea;
    }

    public int getResultStatus() {
        return this.resultStatus;
    }

    @lk1
    public RectDocDetResult(RectDocDetTargetArea rectDocDetTargetArea, RectDocDetRatio rectDocDetRatio) {
        this.rectDocDetTargetArea = rectDocDetTargetArea;
        this.rectDocDetRatio = rectDocDetRatio;
    }
}
