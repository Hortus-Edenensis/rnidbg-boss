package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class BDAnimation {
    public abstract void addAnimationListener(Animator animator);

    public abstract void cancelAnimation();

    public abstract void setAnimation(Marker marker, Animation animation);

    public abstract void setAnimationListener(Animation.AnimationListener animationListener);

    public abstract void setAnimatorSetMode(int i);

    public abstract void setDuration(long j);

    public abstract void setInterpolator(Interpolator interpolator);

    public abstract void setRepeatCount(int i);

    public abstract void setRepeatMode(int i);

    public abstract void setTypeEvaluator(TypeEvaluator typeEvaluator);

    public abstract void startAnimation();
}
