package com.baidu.mapapi.map.track;

import com.baidu.mapapi.map.BM3DModelOptions;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class TraceOptions {
    private List<LatLng> c;
    private int[] d;
    private boolean g;
    private int h;
    private BitmapDescriptor m;
    private BM3DModelOptions p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3735a = -15794282;
    private int b = 14;
    private int e = 300;
    private boolean f = false;
    private int i = TraceAnimateType.TraceOverlayAnimationEasingCurveLinear.ordinal();
    private boolean j = false;
    private boolean k = true;
    private boolean l = false;
    private boolean n = true;
    private boolean o = true;
    private boolean q = false;
    private float r = 5.0f;

    /* JADX INFO: compiled from: SearchBox */
    public enum TraceAnimateType {
        TraceOverlayAnimationEasingCurveLinear,
        TraceOverlayAnimationEasingCurveEaseIn,
        TraceOverlayAnimationEasingCurveEaseOut,
        TraceOverlayAnimationEasingCurveEaseInOut
    }

    public TraceOptions animate(boolean z) {
        this.f = z;
        return this;
    }

    public TraceOptions animationDuration(int i) {
        this.h = i;
        return this;
    }

    public TraceOptions animationTime(int i) {
        if (i < 300) {
            throw new IllegalArgumentException("BDMapSDKException: Not less than 300 milliseconds");
        }
        this.e = i;
        return this;
    }

    public TraceOptions animationType(TraceAnimateType traceAnimateType) {
        if (traceAnimateType == null) {
            traceAnimateType = TraceAnimateType.TraceOverlayAnimationEasingCurveLinear;
        }
        this.i = traceAnimateType.ordinal();
        return this;
    }

    public TraceOptions color(int i) {
        this.f3735a = i;
        return this;
    }

    public TraceOptions colors(int[] iArr) {
        this.d = iArr;
        return this;
    }

    public TraceAnimateType getAnimateType() {
        int i = this.i;
        return i != 1 ? i != 2 ? i != 3 ? TraceAnimateType.TraceOverlayAnimationEasingCurveLinear : TraceAnimateType.TraceOverlayAnimationEasingCurveEaseInOut : TraceAnimateType.TraceOverlayAnimationEasingCurveEaseOut : TraceAnimateType.TraceOverlayAnimationEasingCurveEaseIn;
    }

    public int getAnimationDuration() {
        return this.h;
    }

    public int getAnimationTime() {
        return this.e;
    }

    public float getBloomSpeed() {
        return this.r;
    }

    public int getColor() {
        return this.f3735a;
    }

    public int[] getColors() {
        return this.d;
    }

    public BitmapDescriptor getIcon() {
        return this.m;
    }

    public TraceOverlay getOverlay() {
        TraceOverlay traceOverlay = new TraceOverlay();
        traceOverlay.f3737a = this.f3735a;
        traceOverlay.b = this.b;
        traceOverlay.c = this.c;
        traceOverlay.e = this.e;
        traceOverlay.h = this.f;
        boolean z = this.g;
        traceOverlay.g = z;
        if (z) {
            traceOverlay.d = this.d;
        }
        traceOverlay.f = this.h;
        traceOverlay.i = this.i;
        traceOverlay.j = this.j;
        traceOverlay.k = this.k;
        traceOverlay.l = this.l;
        traceOverlay.o = this.m;
        traceOverlay.m = this.n;
        traceOverlay.n = this.o;
        traceOverlay.p = this.p;
        boolean z2 = this.q;
        traceOverlay.q = z2;
        if (z2) {
            traceOverlay.r = this.r;
        }
        return traceOverlay;
    }

    public List<LatLng> getPoints() {
        return this.c;
    }

    public int getWidth() {
        return this.b;
    }

    public TraceOptions icon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: trace's icon can not be null");
        }
        this.m = bitmapDescriptor;
        return this;
    }

    public TraceOptions icon3D(BM3DModelOptions bM3DModelOptions) {
        this.p = bM3DModelOptions;
        return this;
    }

    public boolean isAnimation() {
        return this.f;
    }

    public boolean isPointMove() {
        return this.l;
    }

    public boolean isRotateWhenTrack() {
        return this.k;
    }

    public boolean isTrackMove() {
        return this.j;
    }

    public boolean isUseColorarray() {
        return this.g;
    }

    public TraceOptions points(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
        this.c = list;
        return this;
    }

    public TraceOptions setBloomSpeed(float f) {
        this.r = f;
        return this;
    }

    public TraceOptions setDataReduction(boolean z) {
        this.n = z;
        return this;
    }

    public TraceOptions setDataSmooth(boolean z) {
        this.o = z;
        return this;
    }

    public TraceOptions setPointMove(boolean z) {
        this.l = z;
        return this;
    }

    public TraceOptions setRotateWhenTrack(boolean z) {
        this.k = z;
        return this;
    }

    public TraceOptions setTrackBloom(boolean z) {
        this.q = z;
        return this;
    }

    public TraceOptions setTrackMove(boolean z) {
        this.j = z;
        return this;
    }

    public TraceOptions useColorArray(boolean z) {
        this.g = z;
        return this;
    }

    public TraceOptions width(int i) {
        this.b = i;
        return this;
    }
}
