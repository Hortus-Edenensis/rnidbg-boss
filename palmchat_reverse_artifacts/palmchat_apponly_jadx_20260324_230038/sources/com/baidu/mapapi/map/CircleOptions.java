package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class CircleOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f3615a;
    private int c;
    private Stroke d;
    private List<HoleOptions> g;
    private HoleOptions h;
    private int k;
    private int l;
    private int r;
    private int s;
    int u;
    Bundle w;
    private int b = -16777216;
    private boolean e = false;
    private int f = 0;
    private boolean i = false;
    private boolean j = false;
    private float m = 0.5f;
    private float n = 0.2f;
    private LineBloomType o = LineBloomType.NONE;
    private float p = 5.0f;
    private int q = 1;
    private LineBloomDirection t = LineBloomDirection.BloomAround;
    boolean v = true;

    public CircleOptions addHoleOption(HoleOptions holeOptions) {
        this.h = holeOptions;
        return this;
    }

    public CircleOptions addHoleOptions(List<HoleOptions> list) {
        this.g = list;
        return this;
    }

    public CircleOptions bloomAlpha(int i) {
        if (i > 255 || i < 0) {
            i = 255;
        }
        this.s = i;
        return this;
    }

    public CircleOptions bloomType(LineBloomType lineBloomType) {
        this.o = lineBloomType;
        return this;
    }

    public CircleOptions bloomWidth(int i) {
        if (i < 0) {
            i = 0;
        }
        this.r = i;
        return this;
    }

    public CircleOptions center(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
        }
        this.f3615a = latLng;
        return this;
    }

    public CircleOptions dottedStroke(boolean z) {
        this.e = z;
        return this;
    }

    public CircleOptions dottedStrokeType(CircleDottedStrokeType circleDottedStrokeType) {
        this.f = circleDottedStrokeType.ordinal();
        return this;
    }

    public CircleOptions extraInfo(Bundle bundle) {
        this.w = bundle;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.b = i;
        return this;
    }

    public LatLng getCenter() {
        return this.f3615a;
    }

    public int getCenterColor() {
        return this.k;
    }

    public float getColorWeight() {
        return this.n;
    }

    public Bundle getExtraInfo() {
        return this.w;
    }

    public int getFillColor() {
        return this.b;
    }

    public LineBloomDirection getLineBloomDirection() {
        return this.t;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Circle circle = new Circle();
        circle.d = this.v;
        circle.c = this.u;
        circle.e = this.w;
        circle.h = this.b;
        circle.g = this.f3615a;
        circle.i = this.c;
        circle.j = this.d;
        circle.k = this.e;
        circle.s = this.f;
        circle.l = this.g;
        circle.m = this.h;
        circle.n = this.i;
        circle.u = this.k;
        circle.v = this.l;
        circle.w = this.m;
        circle.x = this.n;
        circle.o = this.j;
        circle.z = this.o;
        circle.A = this.t;
        circle.C = this.r;
        circle.B = this.s;
        circle.E = this.p;
        circle.D = this.q;
        return circle;
    }

    public int getRadius() {
        return this.c;
    }

    public float getRadiusWeight() {
        return this.m;
    }

    public int getSideColor() {
        return this.l;
    }

    public Stroke getStroke() {
        return this.d;
    }

    public int getZIndex() {
        return this.u;
    }

    public boolean isIsGradientCircle() {
        return this.i;
    }

    public boolean isVisible() {
        return this.v;
    }

    public CircleOptions lineBloomDirection(LineBloomDirection lineBloomDirection) {
        this.t = lineBloomDirection;
        return this;
    }

    public CircleOptions radius(int i) {
        this.c = i;
        return this;
    }

    public CircleOptions setBloomBlurTimes(int i) {
        if (i < 1) {
            i = 1;
        }
        if (i > 10) {
            i = 10;
        }
        this.q = i;
        return this;
    }

    public CircleOptions setBloomGradientASpeed(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f > 10.0f) {
            f = 10.0f;
        }
        this.p = f;
        return this;
    }

    public CircleOptions setCenterColor(int i) {
        this.k = i;
        return this;
    }

    public CircleOptions setClickable(boolean z) {
        this.j = z;
        return this;
    }

    public CircleOptions setColorWeight(float f) {
        if (f > 0.0f && f < 1.0f) {
            this.n = f;
        }
        return this;
    }

    public CircleOptions setIsGradientCircle(boolean z) {
        this.i = z;
        return this;
    }

    public CircleOptions setRadiusWeight(float f) {
        if (f > 0.0f && f < 1.0f) {
            this.m = f;
        }
        return this;
    }

    public CircleOptions setSideColor(int i) {
        this.l = i;
        return this;
    }

    public CircleOptions stroke(Stroke stroke) {
        this.d = stroke;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.v = z;
        return this;
    }

    public CircleOptions zIndex(int i) {
        this.u = i;
        return this;
    }
}
