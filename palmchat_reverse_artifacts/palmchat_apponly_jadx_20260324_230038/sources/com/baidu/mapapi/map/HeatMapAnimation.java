package com.baidu.mapapi.map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class HeatMapAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3626a;
    private AnimationType b;
    private boolean c;

    /* JADX INFO: compiled from: SearchBox */
    public enum AnimationType {
        Linear,
        InQuad,
        OutQuad,
        InOutQuad,
        OutInQuad,
        InCubic,
        OutCubic,
        InOutCubic,
        OutInCubic,
        InQuart,
        OutQuart,
        InOutQuart,
        OutInQuart,
        InQuint,
        OutQuint,
        InOutQuint,
        OutInQuint,
        InSine,
        OutSine,
        InOutSine,
        OutInSine,
        InExpo,
        OutExpo,
        InOutExpo,
        OutInExpo,
        InCirc,
        OutCirc,
        InOutCirc,
        OutInCirc,
        InElastic,
        OutElastic,
        InOutElastic,
        OutInElastic,
        InBack,
        OutBack,
        InOutBack,
        OutInBack,
        InBounce,
        OutBounce,
        InOutBounce,
        OutInBounce,
        InCurve,
        OutCurve,
        SineCurve,
        CosineCurve
    }

    public HeatMapAnimation(boolean z, int i, AnimationType animationType) {
        this.f3626a = 100;
        this.b = AnimationType.Linear;
        if (i >= 0) {
            this.f3626a = i;
        }
        this.b = animationType;
        this.c = z;
    }

    public int getAnimationType() {
        return this.b.ordinal();
    }

    public int getDuration() {
        return this.f3626a;
    }

    public boolean getIsAnimation() {
        return this.c;
    }

    public void setAnimation(boolean z) {
        this.c = z;
    }

    public void setAnimationType(AnimationType animationType) {
        this.b = animationType;
    }

    public void setDuration(int i) {
        this.f3626a = i;
    }
}
