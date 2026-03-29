package com.baidu.mapapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.BM3DModelOptions;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.Bm3DModel;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class BM3DModel extends Overlay {
    String g;
    String h;
    LatLng i;
    float l;
    float m;
    float n;
    float o;
    float p;
    float q;
    boolean s;
    int t;
    int u;
    float v;
    private Bm3DModel w;
    Animation x;
    boolean y;
    float j = 1.0f;
    boolean k = false;
    BM3DModelOptions.BM3DModelType r = BM3DModelOptions.BM3DModelType.BM3DModelTypeObj;

    public BM3DModel() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.BM3DModel;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (TextUtils.isEmpty(this.g)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
        }
        bundle.putString("modelPath", this.g);
        if (TextUtils.isEmpty(this.h)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel mModelName can not be null");
        }
        bundle.putString("modelName", this.h);
        LatLng latLng = this.i;
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel mPosition can not be null");
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
        bundle.putDouble("location_x", geoPointLl2mc.getLongitudeE6());
        bundle.putDouble("location_y", geoPointLl2mc.getLatitudeE6());
        bundle.putInt("modelType", this.r.ordinal());
        bundle.putFloat("scale", this.j);
        bundle.putInt("zoomFixed", this.k ? 1 : 0);
        bundle.putFloat("rotateX", this.l);
        bundle.putFloat("rotateY", this.m);
        bundle.putFloat("rotateZ", this.n);
        bundle.putFloat("offsetX", this.o);
        bundle.putFloat("offsetY", this.p);
        bundle.putFloat("offsetZ", this.q);
        bundle.putInt("animationIndex", this.u);
        bundle.putBoolean("animationIsEnable", this.s);
        bundle.putInt("animationRepeatCount", this.t);
        bundle.putFloat("animationSpeed", this.v);
        bundle.putBoolean("alwaysShowFront", this.y);
        return bundle;
    }

    public void cancelAnimation() {
        if (this.x == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.x.bmAnimation.cancel();
        this.f.b();
    }

    public int getAnimationIndex() {
        return this.u;
    }

    public int getAnimationRepeatCount() {
        return this.t;
    }

    public float getAnimationSpeed() {
        return this.v;
    }

    public BM3DModelOptions.BM3DModelType getBM3DModelType() {
        return this.r;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem getDrawItem() {
        return this.w;
    }

    public String getModelName() {
        return this.h;
    }

    public String getModelPath() {
        return this.g;
    }

    public float getOffsetX() {
        return this.o;
    }

    public float getOffsetY() {
        return this.p;
    }

    public float getOffsetZ() {
        return this.q;
    }

    public LatLng getPosition() {
        return this.i;
    }

    public float getRotateX() {
        return this.l;
    }

    public float getRotateY() {
        return this.m;
    }

    public float getRotateZ() {
        return this.n;
    }

    public float getScale() {
        return this.j;
    }

    public boolean isSkeletonAnimationEnable() {
        return this.s;
    }

    public boolean isZoomFixed() {
        return this.k;
    }

    public void pauseAnimation() {
        if (this.x == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.x.bmAnimation.pause();
        this.f.b();
    }

    public void resumeAnimation() {
        if (this.x == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.x.bmAnimation.resume();
        this.f.b();
    }

    public void setAnimation(Animation animation) {
        BmAnimation bmAnimation;
        if (animation == null) {
            return;
        }
        this.x = animation;
        if (!OverlayUtil.isOverlayUpgrade() || (bmAnimation = this.x.bmAnimation) == null) {
            return;
        }
        this.w.a(bmAnimation);
        this.f.b();
    }

    public void setAnimationIndex(int i) {
        this.u = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.w;
        if (bm3DModel == null || this.f == null) {
            return;
        }
        bm3DModel.e(i);
        this.f.b();
    }

    public void setAnimationRepeatCount(int i) {
        this.t = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.w;
        if (bm3DModel == null || this.f == null) {
            return;
        }
        bm3DModel.f(i);
        this.f.b();
    }

    public void setAnimationSpeed(float f) {
        this.v = f;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.w;
        if (bm3DModel == null || this.f == null) {
            return;
        }
        bm3DModel.b(f);
        this.f.b();
    }

    public void setBM3DModelType(BM3DModelOptions.BM3DModelType bM3DModelType) {
        this.r = bM3DModelType;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.w;
        if (bm3DModel == null || this.f == null) {
            return;
        }
        bm3DModel.a(this.g, this.h, this.r.getType());
        this.f.b();
    }

    public void setModelName(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelName can not be null");
        }
        this.h = str;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.w;
        if (bm3DModel == null || this.f == null) {
            return;
        }
        bm3DModel.a(this.g, this.h, this.r.getType());
        this.f.b();
    }

    public void setModelPath(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
        }
        this.g = str;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.w;
        if (bm3DModel == null || this.f == null) {
            return;
        }
        bm3DModel.a(this.g, this.h, this.r.getType());
        this.f.b();
    }

    public void setOffset(float f, float f2, float f3) {
        this.o = f;
        this.p = f2;
        this.q = f3;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.w;
        if (bm3DModel == null || this.f == null) {
            return;
        }
        bm3DModel.a(this.o, this.p, this.q);
        this.f.b();
    }

    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel position can not be null");
        }
        this.i = latLng;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.w == null || this.f == null) {
                return;
            }
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.i);
            this.w.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            this.f.b();
        }
    }

    public void setRotate(float f, float f2, float f3) {
        this.l = f;
        this.m = f2;
        this.n = f3;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.w;
        if (bm3DModel == null || this.f == null) {
            return;
        }
        bm3DModel.a(this.l, this.m, this.n);
        this.f.b();
    }

    public void setScale(float f) {
        this.j = f;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.w;
        if (bm3DModel == null || this.f == null) {
            return;
        }
        bm3DModel.c(this.j);
        this.f.b();
    }

    public void setSkeletonAnimationEnable(boolean z) {
        this.s = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.w;
        if (bm3DModel == null || this.f == null) {
            return;
        }
        bm3DModel.d(this.s);
        this.f.b();
    }

    public void setZoomFixed(boolean z) {
        this.k = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        Bm3DModel bm3DModel = this.w;
        if (bm3DModel == null || this.f == null) {
            return;
        }
        bm3DModel.e(!this.k);
        this.f.b();
    }

    public void startAnimation() {
        if (this.x == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.x.bmAnimation.start();
        this.f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        Bm3DModel bm3DModel = new Bm3DModel();
        this.w = bm3DModel;
        bm3DModel.a(this);
        setDrawItem(this.w);
        super.toDrawItem();
        this.w.a(this.g, this.h, this.r.getType());
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.i);
        this.w.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        this.w.e(!this.k);
        this.w.c(this.j);
        this.w.a(this.l, this.m, this.n);
        this.w.a(this.o, this.p, this.q);
        this.w.d(this.s);
        this.w.b(this.v);
        this.w.f(this.t);
        this.w.e(this.u);
        this.w.c(this.y);
        return this.w;
    }
}
