package com.baidu.mapapi.map;

import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class BM3DModelOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3577a;
    private String b;
    private LatLng c;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private boolean l;
    private int q;
    private float d = 1.0f;
    private boolean e = false;
    private boolean m = true;
    public ModelYawAxis yawAxis = ModelYawAxis.Z;
    private BM3DModelType n = BM3DModelType.BM3DModelTypeObj;
    private boolean o = false;
    private int p = 0;
    private float r = 1.0f;

    /* JADX INFO: compiled from: SearchBox */
    public enum BM3DModelType {
        BM3DModelTypeObj(0),
        BM3DModelTypeglTF(2);

        private final int b;

        BM3DModelType(int i) {
            this.b = i;
        }

        public int getType() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum ModelYawAxis {
        Z,
        X,
        Y
    }

    public BM3DModelOptions animationIndex(int i) {
        this.q = i;
        return this;
    }

    public BM3DModelOptions animationRepeatCount(int i) {
        this.p = i;
        return this;
    }

    public BM3DModelOptions animationSpeed(float f) {
        this.r = f;
        return this;
    }

    public int getAnimationIndex() {
        return this.q;
    }

    public int getAnimationRepeatCount() {
        return this.p;
    }

    public float getAnimationSpeed() {
        return this.r;
    }

    public BM3DModelType getBM3DModelType() {
        return this.n;
    }

    public String getModelName() {
        return this.b;
    }

    public String getModelPath() {
        return this.f3577a;
    }

    public float getOffsetX() {
        return this.i;
    }

    public float getOffsetY() {
        return this.j;
    }

    public float getOffsetZ() {
        return this.k;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        BM3DModel bM3DModel = new BM3DModel();
        if (TextUtils.isEmpty(this.f3577a)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
        }
        bM3DModel.g = this.f3577a;
        if (TextUtils.isEmpty(this.b)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel mModelName can not be null");
        }
        bM3DModel.h = this.b;
        LatLng latLng = this.c;
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel mPosition can not be null");
        }
        bM3DModel.i = latLng;
        bM3DModel.j = this.d;
        bM3DModel.k = this.e;
        bM3DModel.l = this.f;
        bM3DModel.m = this.g;
        bM3DModel.n = this.h;
        bM3DModel.o = this.i;
        bM3DModel.p = this.j;
        bM3DModel.q = this.k;
        bM3DModel.d = this.m;
        bM3DModel.r = this.n;
        bM3DModel.u = this.q;
        bM3DModel.s = this.o;
        bM3DModel.t = this.p;
        bM3DModel.v = this.r;
        bM3DModel.y = this.l;
        return bM3DModel;
    }

    public LatLng getPosition() {
        return this.c;
    }

    public float getRotateX() {
        return this.f;
    }

    public float getRotateY() {
        return this.g;
    }

    public float getRotateZ() {
        return this.h;
    }

    public float getScale() {
        return this.d;
    }

    public int getYawAxis() {
        return this.yawAxis.ordinal();
    }

    public boolean isSkeletonAnimationEnable() {
        return this.o;
    }

    public boolean isVisible() {
        return this.m;
    }

    public boolean isZoomFixed() {
        return this.e;
    }

    public boolean ismAlwaysShow() {
        return this.l;
    }

    public BM3DModelOptions setAlwaysShow(boolean z) {
        this.l = z;
        return this;
    }

    public BM3DModelOptions setBM3DModelType(BM3DModelType bM3DModelType) {
        this.n = bM3DModelType;
        return this;
    }

    public BM3DModelOptions setModelName(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelName can not be null");
        }
        this.b = str;
        return this;
    }

    public BM3DModelOptions setModelPath(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
        }
        this.f3577a = str;
        return this;
    }

    public BM3DModelOptions setOffset(float f, float f2, float f3) {
        this.i = f;
        this.j = f2;
        this.k = f3;
        return this;
    }

    public BM3DModelOptions setPosition(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: BM3DModel position can not be null");
        }
        this.c = latLng;
        return this;
    }

    public BM3DModelOptions setRotate(float f, float f2, float f3) {
        this.f = f;
        this.g = f2;
        this.h = f3;
        return this;
    }

    public BM3DModelOptions setScale(float f) {
        this.d = f;
        return this;
    }

    public BM3DModelOptions setSkeletonAnimationEnable(boolean z) {
        this.o = z;
        return this;
    }

    public BM3DModelOptions setYawAxis(ModelYawAxis modelYawAxis) {
        this.yawAxis = modelYawAxis;
        return this;
    }

    public BM3DModelOptions setZoomFixed(boolean z) {
        this.e = z;
        return this;
    }

    public BM3DModelOptions visible(boolean z) {
        this.m = z;
        return this;
    }
}
