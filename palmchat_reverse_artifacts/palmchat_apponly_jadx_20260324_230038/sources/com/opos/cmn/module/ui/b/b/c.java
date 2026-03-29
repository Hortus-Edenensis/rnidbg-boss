package com.opos.cmn.module.ui.b.b;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {
    private static final float c = com.opos.cmn.module.ui.d.a.a(328.0f) * com.opos.cmn.module.ui.d.a.a(220.0f);
    private static final float d = com.opos.cmn.module.ui.d.a.a(50.0f) * com.opos.cmn.module.ui.d.a.a(50.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f8056a;
    private final float b;
    private final PathInterpolator e;
    private final PathInterpolator f;
    private final View g;
    private final int h;
    private ValueAnimator i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private long o;

    public c(View view) {
        this(view, 2);
    }

    public float a() {
        return -1.0f;
    }

    private c(View view, int i) {
        this.f8056a = 0.92f;
        this.b = 1.0f;
        this.e = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
        this.j = 1.0f;
        this.k = 1.0f;
        this.l = 0.0f;
        this.m = 0.92f;
        this.n = 0.0f;
        this.o = 340L;
        this.g = view;
        this.h = i;
    }

    private float a(int i, int i2) {
        float f = i * i2;
        float f2 = c;
        float f3 = d;
        float f4 = (((f - f2) * 0.04000002f) / (f2 - f3)) + 0.98f;
        if (f < f3) {
            return 1.0f;
        }
        if (f > f2) {
            return 0.98f;
        }
        return f4;
    }

    private void b() {
        ValueAnimator valueAnimator = this.i;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.i.cancel();
    }

    public void a(float f) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, View view) {
        if (f == view.getAlpha() || this.h == 1) {
            return;
        }
        view.setAlpha(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, View view, float f2) {
        float fMax = Math.max(f2, Math.min(1.0f, f));
        view.setScaleX(fMax);
        view.setScaleY(fMax);
        view.invalidate();
    }

    public void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            a(true);
        } else if (action == 1 || action == 3) {
            a(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0112 A[LOOP:0: B:74:0x0110->B:75:0x0112, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(final boolean z) {
        long j;
        long j2;
        boolean z2;
        float f;
        boolean z3;
        float f2;
        float f3;
        float fA;
        int size;
        int i = this.h;
        if (i != 0) {
            if (i == 1) {
                j = z ? 200L : this.o;
                if (z) {
                    this.n = 0.0f;
                }
                j2 = j;
                f3 = 1.0f;
                f2 = 0.05f;
                z3 = false;
                f = 0.0f;
            } else {
                if (i == 2) {
                    f3 = 0.8f;
                    j2 = z ? 200L : this.o;
                    f2 = 1.0f;
                    z3 = true;
                    f = 1.0f;
                    z2 = false;
                    fA = a();
                    if (fA >= 0.0f && fA <= 1.0f) {
                        this.m = fA;
                    }
                    b();
                    ArrayList arrayList = new ArrayList();
                    float[] fArr = new float[2];
                    fArr[0] = z ? 1.0f : this.j;
                    fArr[1] = z ? this.m : 1.0f;
                    arrayList.add(PropertyValuesHolder.ofFloat("scaleHolder", fArr));
                    if (z3) {
                        float[] fArr2 = new float[2];
                        fArr2[0] = z ? 1.0f : this.k;
                        fArr2[1] = z ? f3 : 1.0f;
                        arrayList.add(PropertyValuesHolder.ofFloat("brightnessHolder", fArr2));
                    }
                    if (z2) {
                        float[] fArr3 = new float[2];
                        fArr3[0] = z ? f : this.n;
                        if (!z) {
                            f2 = f;
                        }
                        fArr3[1] = f2;
                        arrayList.add(PropertyValuesHolder.ofFloat("alphaHolder", fArr3));
                    }
                    float[] fArr4 = new float[2];
                    fArr4[0] = z ? 0.0f : this.l;
                    fArr4[1] = z ? 0.12f : 0.0f;
                    arrayList.add(PropertyValuesHolder.ofFloat("blackAlphaHolder", fArr4));
                    size = arrayList.size();
                    PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        propertyValuesHolderArr[i2] = (PropertyValuesHolder) arrayList.get(i2);
                    }
                    ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderArr);
                    this.i = valueAnimatorOfPropertyValuesHolder;
                    valueAnimatorOfPropertyValuesHolder.setInterpolator(z ? this.e : this.f);
                    this.i.setDuration(j2);
                    this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.cmn.module.ui.b.b.c.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float animatedFraction = valueAnimator.getAnimatedFraction();
                            c.this.a(z, animatedFraction);
                            Object animatedValue = valueAnimator.getAnimatedValue("scaleHolder");
                            if (animatedValue instanceof Float) {
                                c.this.j = ((Float) animatedValue).floatValue();
                                c cVar = c.this;
                                cVar.a(cVar.j, c.this.g, c.this.m);
                            }
                            Object animatedValue2 = valueAnimator.getAnimatedValue("brightnessHolder");
                            if (animatedValue2 instanceof Float) {
                                c.this.k = ((Float) animatedValue2).floatValue();
                                c.this.a(animatedFraction);
                            }
                            Object animatedValue3 = valueAnimator.getAnimatedValue("alphaHolder");
                            if (animatedValue3 instanceof Float) {
                                c.this.n = ((Float) animatedValue3).floatValue();
                                c cVar2 = c.this;
                                cVar2.a(cVar2.n, c.this.g);
                            }
                            Object animatedValue4 = valueAnimator.getAnimatedValue("blackAlphaHolder");
                            if (animatedValue4 instanceof Float) {
                                c.this.l = ((Float) animatedValue4).floatValue();
                            }
                        }
                    });
                    this.i.start();
                }
                if (i != 3) {
                    j2 = 0;
                } else {
                    j = z ? 200L : this.o;
                    if (z) {
                        this.n = 1.0f;
                    }
                    this.m = a(this.g.getWidth(), this.g.getHeight());
                    j2 = j;
                    f3 = 1.0f;
                    f2 = 0.5f;
                    z3 = false;
                    f = 1.0f;
                }
            }
            z2 = true;
            fA = a();
            if (fA >= 0.0f) {
                this.m = fA;
            }
            b();
            ArrayList arrayList2 = new ArrayList();
            float[] fArr5 = new float[2];
            fArr5[0] = z ? 1.0f : this.j;
            fArr5[1] = z ? this.m : 1.0f;
            arrayList2.add(PropertyValuesHolder.ofFloat("scaleHolder", fArr5));
            if (z3) {
            }
            if (z2) {
            }
            float[] fArr42 = new float[2];
            fArr42[0] = z ? 0.0f : this.l;
            fArr42[1] = z ? 0.12f : 0.0f;
            arrayList2.add(PropertyValuesHolder.ofFloat("blackAlphaHolder", fArr42));
            size = arrayList2.size();
            PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[size];
            while (i2 < size) {
            }
            ValueAnimator valueAnimatorOfPropertyValuesHolder2 = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderArr2);
            this.i = valueAnimatorOfPropertyValuesHolder2;
            valueAnimatorOfPropertyValuesHolder2.setInterpolator(z ? this.e : this.f);
            this.i.setDuration(j2);
            this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.cmn.module.ui.b.b.c.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    c.this.a(z, animatedFraction);
                    Object animatedValue = valueAnimator.getAnimatedValue("scaleHolder");
                    if (animatedValue instanceof Float) {
                        c.this.j = ((Float) animatedValue).floatValue();
                        c cVar = c.this;
                        cVar.a(cVar.j, c.this.g, c.this.m);
                    }
                    Object animatedValue2 = valueAnimator.getAnimatedValue("brightnessHolder");
                    if (animatedValue2 instanceof Float) {
                        c.this.k = ((Float) animatedValue2).floatValue();
                        c.this.a(animatedFraction);
                    }
                    Object animatedValue3 = valueAnimator.getAnimatedValue("alphaHolder");
                    if (animatedValue3 instanceof Float) {
                        c.this.n = ((Float) animatedValue3).floatValue();
                        c cVar2 = c.this;
                        cVar2.a(cVar2.n, c.this.g);
                    }
                    Object animatedValue4 = valueAnimator.getAnimatedValue("blackAlphaHolder");
                    if (animatedValue4 instanceof Float) {
                        c.this.l = ((Float) animatedValue4).floatValue();
                    }
                }
            });
            this.i.start();
        }
        j = z ? 200L : this.o;
        this.m = a(this.g.getWidth(), this.g.getHeight());
        j2 = j;
        f3 = 1.0f;
        f2 = 1.0f;
        z3 = false;
        f = 1.0f;
        z2 = false;
        fA = a();
        if (fA >= 0.0f) {
        }
        b();
        ArrayList arrayList22 = new ArrayList();
        float[] fArr52 = new float[2];
        fArr52[0] = z ? 1.0f : this.j;
        fArr52[1] = z ? this.m : 1.0f;
        arrayList22.add(PropertyValuesHolder.ofFloat("scaleHolder", fArr52));
        if (z3) {
        }
        if (z2) {
        }
        float[] fArr422 = new float[2];
        fArr422[0] = z ? 0.0f : this.l;
        fArr422[1] = z ? 0.12f : 0.0f;
        arrayList22.add(PropertyValuesHolder.ofFloat("blackAlphaHolder", fArr422));
        size = arrayList22.size();
        PropertyValuesHolder[] propertyValuesHolderArr22 = new PropertyValuesHolder[size];
        while (i2 < size) {
        }
        ValueAnimator valueAnimatorOfPropertyValuesHolder22 = ValueAnimator.ofPropertyValuesHolder(propertyValuesHolderArr22);
        this.i = valueAnimatorOfPropertyValuesHolder22;
        valueAnimatorOfPropertyValuesHolder22.setInterpolator(z ? this.e : this.f);
        this.i.setDuration(j2);
        this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.opos.cmn.module.ui.b.b.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                c.this.a(z, animatedFraction);
                Object animatedValue = valueAnimator.getAnimatedValue("scaleHolder");
                if (animatedValue instanceof Float) {
                    c.this.j = ((Float) animatedValue).floatValue();
                    c cVar = c.this;
                    cVar.a(cVar.j, c.this.g, c.this.m);
                }
                Object animatedValue2 = valueAnimator.getAnimatedValue("brightnessHolder");
                if (animatedValue2 instanceof Float) {
                    c.this.k = ((Float) animatedValue2).floatValue();
                    c.this.a(animatedFraction);
                }
                Object animatedValue3 = valueAnimator.getAnimatedValue("alphaHolder");
                if (animatedValue3 instanceof Float) {
                    c.this.n = ((Float) animatedValue3).floatValue();
                    c cVar2 = c.this;
                    cVar2.a(cVar2.n, c.this.g);
                }
                Object animatedValue4 = valueAnimator.getAnimatedValue("blackAlphaHolder");
                if (animatedValue4 instanceof Float) {
                    c.this.l = ((Float) animatedValue4).floatValue();
                }
            }
        });
        this.i.start();
    }

    public void a(boolean z, float f) {
    }
}
