package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class PrismOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3681a;
    private List<LatLng> b;
    private BitmapDescriptor e;
    int g;
    int h;
    private int c = -16777216;
    private int d = -16777216;
    boolean f = true;

    public PrismOptions customSideImage(BitmapDescriptor bitmapDescriptor) {
        this.e = bitmapDescriptor;
        return this;
    }

    public BitmapDescriptor getCustomSideImage() {
        return this.e;
    }

    public float getHeight() {
        return this.f3681a;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Prism prism = new Prism();
        prism.d = this.f;
        prism.c = this.g;
        prism.n = this.e;
        prism.g = this.f3681a;
        List<LatLng> list = this.b;
        if (list == null || list.size() <= 3) {
            throw new IllegalStateException("BDMapSDKException: when you add prism, you must at least supply 4 points");
        }
        prism.j = this.b;
        prism.m = this.d;
        prism.l = this.c;
        return prism;
    }

    public List<LatLng> getPoints() {
        return this.b;
    }

    public int getShowLevel() {
        return this.h;
    }

    public int getSideFaceColor() {
        return this.d;
    }

    public int getTopFaceColor() {
        return this.c;
    }

    public int getZIndex() {
        return this.g;
    }

    public boolean isVisible() {
        return this.f;
    }

    public PrismOptions setHeight(float f) {
        this.f3681a = f;
        return this;
    }

    public PrismOptions setPoints(List<LatLng> list) {
        this.b = list;
        return this;
    }

    public PrismOptions setShowLevel(int i) {
        this.h = i;
        return this;
    }

    public PrismOptions setSideFaceColor(int i) {
        this.d = i;
        return this;
    }

    public PrismOptions setTopFaceColor(int i) {
        this.c = i;
        return this;
    }

    public PrismOptions visible(boolean z) {
        this.f = z;
        return this;
    }

    public PrismOptions zIndex(int i) {
        this.g = i;
        return this;
    }
}
