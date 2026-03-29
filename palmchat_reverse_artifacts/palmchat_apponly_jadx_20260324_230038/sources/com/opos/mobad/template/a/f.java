package com.opos.mobad.template.a;

import android.animation.FloatEvaluator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class f implements TypeEvaluator<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TimeInterpolator f9288a;
    private FloatEvaluator b = new FloatEvaluator();
    private float c;
    private float d;

    public f(TimeInterpolator timeInterpolator, float f, float f2) {
        this.f9288a = timeInterpolator;
        this.c = f;
        this.d = f2;
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float evaluate(float f, Float f2, Float f3) {
        return this.b.evaluate(this.f9288a.getInterpolation(f), (Number) Float.valueOf(this.c), (Number) Float.valueOf(this.d));
    }
}
