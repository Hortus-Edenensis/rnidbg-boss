package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ArcOptions extends OverlayOptions {
    private LatLng d;
    private LatLng e;
    private LatLng f;
    int g;
    Bundle i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3576a = -16777216;
    private int b = 5;
    private boolean c = false;
    boolean h = true;

    public ArcOptions color(int i) {
        this.f3576a = i;
        return this;
    }

    public ArcOptions extraInfo(Bundle bundle) {
        this.i = bundle;
        return this;
    }

    public int getColor() {
        return this.f3576a;
    }

    public LatLng getEndPoint() {
        return this.f;
    }

    public Bundle getExtraInfo() {
        return this.i;
    }

    public LatLng getMiddlePoint() {
        return this.e;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Arc arc = new Arc();
        arc.d = this.h;
        arc.c = this.g;
        arc.e = this.i;
        arc.g = this.f3576a;
        arc.h = this.b;
        arc.i = this.d;
        arc.j = this.e;
        arc.k = this.f;
        arc.l = this.c;
        return arc;
    }

    public LatLng getStartPoint() {
        return this.d;
    }

    public int getWidth() {
        return this.b;
    }

    public int getZIndex() {
        return this.g;
    }

    public boolean isVisible() {
        return this.h;
    }

    public ArcOptions points(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        if (latLng == null || latLng2 == null || latLng3 == null) {
            throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be null");
        }
        if (latLng == latLng2 || latLng == latLng3 || latLng2 == latLng3) {
            throw new IllegalArgumentException("BDMapSDKException: start and middle and end points can not be same");
        }
        this.d = latLng;
        this.e = latLng2;
        this.f = latLng3;
        return this;
    }

    public ArcOptions setClickable(boolean z) {
        this.c = z;
        return this;
    }

    public ArcOptions visible(boolean z) {
        this.h = z;
        return this;
    }

    public ArcOptions width(int i) {
        if (i > 0) {
            this.b = i;
        }
        return this;
    }

    public ArcOptions zIndex(int i) {
        this.g = i;
        return this;
    }
}
