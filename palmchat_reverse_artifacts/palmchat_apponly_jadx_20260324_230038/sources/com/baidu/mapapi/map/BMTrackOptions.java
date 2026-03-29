package com.baidu.mapapi.map;

import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.model.LatLng;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BMTrackOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<LatLng> f3580a;
    private List<Integer> b;
    private int c;
    private int[] d;
    private int[] e;
    private BMTrackType f = BMTrackType.Surface;
    private int g = 3000;
    private boolean h = true;
    private BMTrackAnimateType i = BMTrackAnimateType.TraceOverlayAnimationEasingCurveLinear;
    private BitmapDescriptor j = BitmapDescriptorFactory.fromAsset("track_palette.png");
    private BitmapDescriptor k = BitmapDescriptorFactory.fromAsset("track_projection_palette.png");
    private int l = 5;
    float m = 1.0f;
    float n = 0.3f;
    private boolean o = false;
    private TraceAnimationListener p;

    /* JADX INFO: compiled from: SearchBox */
    public enum BMTrackAnimateType {
        TraceOverlayAnimationEasingCurveLinear,
        TraceOverlayAnimationEasingCurveEaseIn,
        TraceOverlayAnimationEasingCurveEaseOut,
        TraceOverlayAnimationEasingCurveEaseInOut
    }

    public BMTrackAnimateType getAnimateType() {
        return this.i;
    }

    public int getAnimationTime() {
        return this.g;
    }

    public int[] getColors() {
        return this.d;
    }

    public int[] getHeights() {
        return this.e;
    }

    public float getOpacity() {
        return this.m;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        BMTrackType bMTrackType;
        int[] iArr;
        List<LatLng> list = this.f3580a;
        if (list == null || list.size() <= 1 || (((bMTrackType = this.f) == BMTrackType.Default3D || bMTrackType == BMTrackType.Surface) && ((iArr = this.e) == null || iArr.length != this.f3580a.size()))) {
            return null;
        }
        Track track = new Track();
        int[] iArr2 = this.e;
        if (iArr2 == null || iArr2.length != this.f3580a.size()) {
            int[] iArr3 = new int[this.f3580a.size()];
            track.o = iArr3;
            Arrays.fill(iArr3, 1);
        } else {
            track.o = this.e;
        }
        track.v = this.c;
        track.p = this.d;
        track.w = this.m;
        track.x = this.n;
        track.setTrackMove(this.o);
        track.n = this.f3580a;
        track.m = this.b;
        track.u = this.l;
        track.A = this.j;
        track.B = this.k;
        track.r = this.g;
        track.s = this.i.ordinal();
        track.q = this.f.getType();
        track.d = this.h;
        track.C = this.p;
        return track;
    }

    public BitmapDescriptor getPalette() {
        return this.j;
    }

    public float getPaletteOpacity() {
        return this.n;
    }

    public List<LatLng> getPoints() {
        return this.f3580a;
    }

    public BitmapDescriptor getProjectionPaletteDescriptor() {
        return this.k;
    }

    public BMTrackType getTrackType() {
        return this.f;
    }

    public int getWidth() {
        return this.l;
    }

    public boolean isVisible() {
        return this.h;
    }

    public OverlayOptions setAnimateType(BMTrackAnimateType bMTrackAnimateType) {
        this.i = bMTrackAnimateType;
        return this;
    }

    public OverlayOptions setAnimationTime(int i) {
        this.g = i;
        return this;
    }

    public OverlayOptions setColor(int i) {
        this.c = i;
        return this;
    }

    public OverlayOptions setColors(int[] iArr) {
        this.d = iArr;
        return this;
    }

    public OverlayOptions setColorsArray(List<Integer> list) {
        this.b = list;
        return this;
    }

    public OverlayOptions setHeights(int[] iArr) {
        this.e = iArr;
        return this;
    }

    public void setOpacity(float f) {
        this.m = f;
    }

    public OverlayOptions setPalette(BitmapDescriptor bitmapDescriptor) {
        this.j = bitmapDescriptor;
        return this;
    }

    public void setPaletteOpacity(float f) {
        this.n = f;
    }

    public OverlayOptions setPoints(List<LatLng> list) {
        this.f3580a = list;
        return this;
    }

    public OverlayOptions setProjectionPalette(BitmapDescriptor bitmapDescriptor) {
        this.k = bitmapDescriptor;
        return this;
    }

    public OverlayOptions setTraceAnimationListener(TraceAnimationListener traceAnimationListener) {
        this.p = traceAnimationListener;
        return this;
    }

    public void setTrackMove(boolean z) {
        this.o = z;
    }

    public OverlayOptions setTrackType(BMTrackType bMTrackType) {
        this.f = bMTrackType;
        return this;
    }

    public OverlayOptions setVisible(boolean z) {
        this.h = z;
        return this;
    }

    public OverlayOptions setWidth(int i) {
        this.l = i;
        return this;
    }
}
