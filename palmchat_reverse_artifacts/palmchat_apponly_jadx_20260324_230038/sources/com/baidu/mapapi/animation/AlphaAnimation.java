package com.baidu.mapapi.animation;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.OverlayUtil;
import com.baidu.platform.comapi.bmsdk.animation.BmAccelerateDecelerateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmAccelerateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmAlphaAnimation;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.animation.BmAnticipateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmAnticipateOvershootInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmBounceInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmCycleInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmDecelerateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmLinearInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmOvershootInterpolator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class AlphaAnimation extends Animation {
    private float[] d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements BmAnimation.a {
        public a() {
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void a(BmAnimation bmAnimation) {
            Animation.AnimationListener animationListener;
            if (bmAnimation == null || (animationListener = bmAnimation.animationListener) == null) {
                return;
            }
            animationListener.onAnimationStart();
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void b(BmAnimation bmAnimation) {
            Animation.AnimationListener animationListener;
            if (bmAnimation == null || (animationListener = bmAnimation.animationListener) == null) {
                return;
            }
            animationListener.onAnimationEnd();
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void c(BmAnimation bmAnimation) {
            Animation.AnimationListener animationListener;
            if (bmAnimation == null || (animationListener = bmAnimation.animationListener) == null) {
                return;
            }
            animationListener.onAnimationRepeat();
        }
    }

    public AlphaAnimation(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            throw new NullPointerException("BDMapSDKException: the alphas is null");
        }
        if (OverlayUtil.isOverlayUpgrade()) {
            this.bmAnimation = new BmAlphaAnimation(fArr[0], fArr[fArr.length - 1]);
        } else {
            this.bdAnimation = new com.baidu.mapsdkplatform.comapi.animation.a(fArr);
        }
        this.d = fArr;
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void cancel() {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.bmAnimation.cancel();
        } else {
            this.bdAnimation.cancelAnimation();
        }
    }

    public float[] getAlpha() {
        return this.d;
    }

    @Override // com.baidu.mapapi.animation.Animation
    public long getDuration() {
        return this.c;
    }

    @Override // com.baidu.mapapi.animation.Animation
    public int getRepeatCount() {
        return this.b;
    }

    @Override // com.baidu.mapapi.animation.Animation
    public Animation.RepeatMode getRepeatMode() {
        return this.f3557a;
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.bdAnimation.setAnimationListener(animationListener);
        } else {
            this.bmAnimation.setAnimationListener(animationListener);
            this.bmAnimation.setAnimationListener(new a());
        }
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setDuration(long j) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.bmAnimation.setDuration(j);
        } else {
            this.bdAnimation.setDuration(j);
        }
        this.c = j;
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setInterpolator(Interpolator interpolator) {
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.bdAnimation.setInterpolator(interpolator);
            return;
        }
        if (interpolator instanceof LinearInterpolator) {
            this.bmAnimation.setInterpolator(new BmLinearInterpolator());
            return;
        }
        if (interpolator instanceof CycleInterpolator) {
            this.bmAnimation.setInterpolator(new BmCycleInterpolator());
            return;
        }
        if (interpolator instanceof BounceInterpolator) {
            this.bmAnimation.setInterpolator(new BmBounceInterpolator());
            return;
        }
        if (interpolator instanceof DecelerateInterpolator) {
            this.bmAnimation.setInterpolator(new BmDecelerateInterpolator());
            return;
        }
        if (interpolator instanceof OvershootInterpolator) {
            this.bmAnimation.setInterpolator(new BmOvershootInterpolator());
            return;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            this.bmAnimation.setInterpolator(new BmAccelerateInterpolator());
            return;
        }
        if (interpolator instanceof AccelerateDecelerateInterpolator) {
            this.bmAnimation.setInterpolator(new BmAccelerateDecelerateInterpolator());
        } else if (interpolator instanceof AnticipateInterpolator) {
            this.bmAnimation.setInterpolator(new BmAnticipateInterpolator());
        } else if (interpolator instanceof AnticipateOvershootInterpolator) {
            this.bmAnimation.setInterpolator(new BmAnticipateOvershootInterpolator());
        }
    }

    public void setRepeatCount(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.bmAnimation.setRepeatCount(i);
        } else {
            this.bdAnimation.setRepeatCount(i);
        }
        this.b = i;
    }

    public void setRepeatDelay(long j) {
        BmAnimation bmAnimation;
        if (!OverlayUtil.isOverlayUpgrade() || (bmAnimation = this.bmAnimation) == null) {
            return;
        }
        bmAnimation.setRepeatDelay(j);
    }

    public void setRepeatMode(Animation.RepeatMode repeatMode) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.bmAnimation.setRepeatMode(repeatMode.ordinal());
        } else if (repeatMode == Animation.RepeatMode.RESTART) {
            this.bdAnimation.setRepeatMode(1);
        } else if (repeatMode == Animation.RepeatMode.REVERSE) {
            this.bdAnimation.setRepeatMode(2);
        }
        this.f3557a = repeatMode;
    }

    public void setStartDelay(long j) {
        BmAnimation bmAnimation;
        if (!OverlayUtil.isOverlayUpgrade() || (bmAnimation = this.bmAnimation) == null) {
            return;
        }
        bmAnimation.setStartDelay(j);
    }
}
