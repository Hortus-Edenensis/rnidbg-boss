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
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayUtil;
import com.baidu.mapapi.map.TrackAnimationUpdateListener;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
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
import com.baidu.platform.comapi.bmsdk.animation.BmTrackAnimation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class TrackAnimation extends Animation {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements BmTrackAnimation.a {
        public a() {
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmTrackAnimation.a
        public void a(com.baidu.platform.comapi.bmsdk.b bVar, float f, float f2) {
            if (((BmTrackAnimation) TrackAnimation.this.bmAnimation).trackAnimationUpdateListener != null) {
                ((BmTrackAnimation) TrackAnimation.this.bmAnimation).trackAnimationUpdateListener.onTrackUpdate(CoordUtil.mc2ll(new GeoPoint(bVar.b, bVar.f4118a)), f, f2);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements BmAnimation.a {
        public b() {
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

    public TrackAnimation(List<LatLng> list) {
        if (list == null || list.isEmpty()) {
            throw new NullPointerException("BDMapSDKException: the trackPath is null");
        }
        if (!OverlayUtil.isOverlayUpgrade()) {
            throw new NullPointerException("BDMapSDKException: TrackAnimation must be used in Overlay2.0");
        }
        this.bmAnimation = new BmTrackAnimation();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(list.get(i));
            arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        }
        BmGeoElement bmGeoElement = new BmGeoElement();
        bmGeoElement.a(arrayList);
        ((BmTrackAnimation) this.bmAnimation).setTrackPath(bmGeoElement);
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void cancel() {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.bmAnimation.cancel();
        }
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        BmAnimation bmAnimation;
        if (!OverlayUtil.isOverlayUpgrade() || (bmAnimation = this.bmAnimation) == null) {
            return;
        }
        bmAnimation.setAnimationListener(animationListener);
        this.bmAnimation.setAnimationListener(new b());
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setDuration(long j) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.bmAnimation.setDuration(j);
        }
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setInterpolator(Interpolator interpolator) {
        if (OverlayUtil.isOverlayUpgrade()) {
            com.baidu.platform.comapi.bmsdk.animation.a bmLinearInterpolator = interpolator instanceof LinearInterpolator ? new BmLinearInterpolator() : interpolator instanceof CycleInterpolator ? new BmCycleInterpolator() : interpolator instanceof BounceInterpolator ? new BmBounceInterpolator() : interpolator instanceof DecelerateInterpolator ? new BmDecelerateInterpolator() : interpolator instanceof OvershootInterpolator ? new BmOvershootInterpolator() : interpolator instanceof AccelerateInterpolator ? new BmAccelerateInterpolator() : interpolator instanceof AccelerateDecelerateInterpolator ? new BmAccelerateDecelerateInterpolator() : interpolator instanceof AnticipateInterpolator ? new BmAnticipateInterpolator() : interpolator instanceof AnticipateOvershootInterpolator ? new BmAnticipateOvershootInterpolator() : null;
            if (bmLinearInterpolator != null) {
                this.bmAnimation.setInterpolator(bmLinearInterpolator);
            }
        }
    }

    public void setRepeatDelay(long j) {
        BmAnimation bmAnimation;
        if (!OverlayUtil.isOverlayUpgrade() || (bmAnimation = this.bmAnimation) == null) {
            return;
        }
        bmAnimation.setRepeatDelay(j);
    }

    public void setStartDelay(long j) {
        BmAnimation bmAnimation;
        if (!OverlayUtil.isOverlayUpgrade() || (bmAnimation = this.bmAnimation) == null) {
            return;
        }
        bmAnimation.setStartDelay(j);
    }

    public void setTrackLine(Overlay overlay) {
        if (overlay != null && OverlayUtil.isOverlayUpgrade()) {
            ((BmTrackAnimation) this.bmAnimation).setTrackLine(overlay.getDrawItem());
        }
    }

    public void setTrackPath(List<LatLng> list) {
        if (!OverlayUtil.isOverlayUpgrade() || list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(list.get(i));
            arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        }
        BmGeoElement bmGeoElement = new BmGeoElement();
        bmGeoElement.a(arrayList);
        ((BmTrackAnimation) this.bmAnimation).setTrackPath(bmGeoElement);
    }

    public void setTrackPos(LatLng latLng, LatLng latLng2) {
        if (OverlayUtil.isOverlayUpgrade()) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
            GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(latLng2);
            ((BmTrackAnimation) this.bmAnimation).setTrackPos(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()), new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6()));
        }
    }

    public void setTrackPosRadio(float f, float f2) {
        if (OverlayUtil.isOverlayUpgrade()) {
            ((BmTrackAnimation) this.bmAnimation).setTrackPosRadio(f, f2);
        }
    }

    public void setTrackUpdateListener(TrackAnimationUpdateListener trackAnimationUpdateListener) {
        if (OverlayUtil.isOverlayUpgrade()) {
            ((BmTrackAnimation) this.bmAnimation).setTrackAnimationUpdateListener(trackAnimationUpdateListener);
            ((BmTrackAnimation) this.bmAnimation).setTrackUpdateListener(new a());
        }
    }

    public void setTrackPosRadio(float f) {
        if (OverlayUtil.isOverlayUpgrade()) {
            ((BmTrackAnimation) this.bmAnimation).setTrackPosRadio(f);
        }
    }

    public void setTrackPos(LatLng latLng) {
        if (OverlayUtil.isOverlayUpgrade()) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
            ((BmTrackAnimation) this.bmAnimation).setTrackPos(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        }
    }
}
