package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.wifi.ad.core.config.EventParams;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class f extends BDAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator f3952a = null;
    private long b = 0;
    private Interpolator c = null;
    private TypeEvaluator d = null;
    private Animation.AnimationListener e = null;
    private int f = 1;
    private int g = 0;
    private Object[] h;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (f.this.e != null) {
                f.this.e.onAnimationCancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (f.this.e != null) {
                f.this.e.onAnimationEnd();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (f.this.e != null) {
                f.this.e.onAnimationRepeat();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (f.this.e != null) {
                f.this.e.onAnimationStart();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(11)
    public class b implements TypeEvaluator {
        public b() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d = latLng.longitude;
            double d2 = f;
            double d3 = d + ((latLng2.longitude - d) * d2);
            double d4 = latLng.latitude;
            return new LatLng(d4 + (d2 * (latLng2.latitude - d4)), d3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(11)
    public class c implements TypeEvaluator {
        public c() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            Point point = (Point) obj;
            Point point2 = (Point) obj2;
            return new Point((int) (point.x + ((point2.x - r0) * f)), (int) (point.y + (f * (point2.y - r5))));
        }
    }

    public f(LatLng... latLngArr) {
        this.h = latLngArr;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void addAnimationListener(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new a());
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void cancelAnimation() {
        Animator animator = this.f3952a;
        if (animator != null) {
            animator.cancel();
            this.f3952a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void setAnimation(Marker marker, Animation animation) {
        ObjectAnimator objectAnimatorA = a(marker);
        this.f3952a = objectAnimatorA;
        addAnimationListener(objectAnimatorA);
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.e = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setDuration(long j) {
        if (j < 0) {
            j = 0;
        }
        this.b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setInterpolator(Interpolator interpolator) {
        this.c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatCount(int i) {
        if (i > 0 || i == -1) {
            this.g = i;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatMode(int i) {
        this.f = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setTypeEvaluator(TypeEvaluator typeEvaluator) {
        this.d = typeEvaluator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void startAnimation() {
        Animator animator = this.f3952a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    public int a() {
        return this.f;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator objectAnimatorOfObject;
        if (marker.isFixed()) {
            if (this.h[0] instanceof Point) {
                objectAnimatorOfObject = ObjectAnimator.ofObject(marker, "fixedScreenPosition", new c(), this.h);
            } else {
                throw new ClassCastException("BDMapSDKException: if the marker is fixed on screen, the parameters of Transformation must be android.graphics.Point");
            }
        } else {
            Object[] objArr = this.h;
            if (objArr[0] instanceof LatLng) {
                TypeEvaluator typeEvaluator = this.d;
                if (typeEvaluator != null) {
                    objectAnimatorOfObject = ObjectAnimator.ofObject(marker, EventParams.KEY_CT_SDK_POSITION, typeEvaluator, objArr);
                } else {
                    objectAnimatorOfObject = ObjectAnimator.ofObject(marker, EventParams.KEY_CT_SDK_POSITION, new b(), this.h);
                }
            } else {
                throw new ClassCastException("BDMapSDKException: if the marker isn't fixed on screen, the parameters of Transformation must be Latlng");
            }
        }
        if (objectAnimatorOfObject != null) {
            objectAnimatorOfObject.setRepeatCount(this.g);
            objectAnimatorOfObject.setRepeatMode(a());
            objectAnimatorOfObject.setDuration(this.b);
            Interpolator interpolator = this.c;
            if (interpolator != null) {
                objectAnimatorOfObject.setInterpolator(interpolator);
            }
        }
        return objectAnimatorOfObject;
    }

    public f(Point... pointArr) {
        this.h = pointArr;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimatorSetMode(int i) {
    }
}
