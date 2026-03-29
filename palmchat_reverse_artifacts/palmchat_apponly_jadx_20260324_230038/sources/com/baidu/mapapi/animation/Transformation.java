package com.baidu.mapapi.animation;

import android.graphics.Point;
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
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.animation.f;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.animation.BmAccelerateDecelerateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmAccelerateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.animation.BmAnticipateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmAnticipateOvershootInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmBounceInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmCycleInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmDecelerateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmLinearInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmOvershootInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmTranslateAnimation;
import com.baidu.platform.comapi.bmsdk.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class Transformation extends Animation {
    private LatLng[] d;

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

    public Transformation(LatLng... latLngArr) {
        if (latLngArr == null || latLngArr.length == 0) {
            throw new NullPointerException("BDMapSDKException: the latlngs is null");
        }
        if (OverlayUtil.isOverlayUpgrade()) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLngArr[0]);
            GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(latLngArr[latLngArr.length - 1]);
            this.bmAnimation = new BmTranslateAnimation(new b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()), new b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6()));
        } else {
            this.bdAnimation = new f(latLngArr);
        }
        this.d = latLngArr;
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void cancel() {
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.bdAnimation.cancelAnimation();
            return;
        }
        BmAnimation bmAnimation = this.bmAnimation;
        if (bmAnimation == null) {
            return;
        }
        bmAnimation.cancel();
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

    public LatLng[] getValues() {
        return this.d;
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.bdAnimation.setAnimationListener(animationListener);
            return;
        }
        BmAnimation bmAnimation = this.bmAnimation;
        if (bmAnimation == null) {
            return;
        }
        bmAnimation.setAnimationListener(animationListener);
        this.bmAnimation.setAnimationListener(new a());
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setDuration(long j) {
        if (OverlayUtil.isOverlayUpgrade()) {
            BmAnimation bmAnimation = this.bmAnimation;
            if (bmAnimation == null) {
                return;
            } else {
                bmAnimation.setDuration(j);
            }
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
        if (this.bmAnimation == null) {
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
            BmAnimation bmAnimation = this.bmAnimation;
            if (bmAnimation == null) {
                return;
            } else {
                bmAnimation.setRepeatCount(i);
            }
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
            BmAnimation bmAnimation = this.bmAnimation;
            if (bmAnimation == null) {
                return;
            } else {
                bmAnimation.setRepeatMode(repeatMode.ordinal());
            }
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

    public Transformation(Point... pointArr) {
        if (pointArr != null && pointArr.length != 0) {
            if (OverlayUtil.isOverlayUpgrade()) {
                Point point = pointArr[0];
                this.bmAnimation = new BmTranslateAnimation(new b(point.x, point.y), new b(pointArr[pointArr.length - 1].x, pointArr[pointArr.length - 1].y));
                return;
            } else {
                this.bdAnimation = new f(pointArr);
                return;
            }
        }
        throw new NullPointerException("BDMapSDKException: the points is null");
    }
}
