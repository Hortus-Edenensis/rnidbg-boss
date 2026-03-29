package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class PolygonOptions extends OverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Stroke f3672a;
    private List<LatLng> c;
    private List<HoleOptions> d;
    private HoleOptions e;
    private String g;
    private EncodePointType h;
    private int n;
    private int o;
    int t;
    Bundle v;
    private int b = -16777216;
    private boolean f = false;
    private int i = 0;
    private boolean j = false;
    private LineBloomType k = LineBloomType.NONE;
    private float l = 5.0f;
    private int m = 1;
    private LineBloomDirection p = LineBloomDirection.BloomAround;
    private boolean q = true;
    private ThinAndSmoothAlgorithm r = ThinAndSmoothAlgorithm.DOUGLAS_PEUCKER;
    private float s = 4.0f;
    boolean u = true;

    public PolygonOptions addHoleOption(HoleOptions holeOptions) {
        this.e = holeOptions;
        return this;
    }

    public PolygonOptions addHoleOptions(List<HoleOptions> list) {
        this.d = list;
        return this;
    }

    public PolygonOptions bloomAlpha(int i) {
        if (i > 255 || i < 0) {
            i = 255;
        }
        this.o = i;
        return this;
    }

    public PolygonOptions bloomType(LineBloomType lineBloomType) {
        this.k = lineBloomType;
        return this;
    }

    public PolygonOptions bloomWidth(int i) {
        if (i < 0) {
            i = 0;
        }
        this.n = i;
        return this;
    }

    public PolygonOptions dottedStroke(boolean z) {
        this.f = z;
        return this;
    }

    public PolygonOptions dottedStrokeType(PolylineDottedLineType polylineDottedLineType) {
        this.i = polylineDottedLineType.ordinal();
        return this;
    }

    public PolygonOptions extraInfo(Bundle bundle) {
        this.v = bundle;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.b = i;
        return this;
    }

    public Bundle getExtraInfo() {
        return this.v;
    }

    public int getFillColor() {
        return this.b;
    }

    public LineBloomDirection getLineBloomDirection() {
        return this.p;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Polygon polygon = new Polygon();
        polygon.d = this.u;
        polygon.c = this.t;
        polygon.e = this.v;
        List<LatLng> list = this.c;
        if (list == null || list.size() < 2) {
            String str = this.g;
            if (str == null || str.length() <= 0) {
                throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
            }
            polygon.j = this.g;
            polygon.b = this.h;
        }
        polygon.q = this.c;
        polygon.p = this.b;
        polygon.g = this.f3672a;
        polygon.r = this.d;
        polygon.s = this.e;
        polygon.t = this.f;
        polygon.m = this.i;
        polygon.u = this.j;
        polygon.B = this.k;
        polygon.C = this.p;
        polygon.E = this.n;
        polygon.D = this.o;
        polygon.G = this.l;
        polygon.F = this.m;
        polygon.x = this.q;
        polygon.y = this.r;
        polygon.z = this.s;
        return polygon;
    }

    public List<LatLng> getPoints() {
        return this.c;
    }

    public Stroke getStroke() {
        return this.f3672a;
    }

    public int getZIndex() {
        return this.t;
    }

    public PolygonOptions isThined(boolean z) {
        this.q = z;
        return this;
    }

    public boolean isVisible() {
        return this.u;
    }

    public PolygonOptions lineBloomDirection(LineBloomDirection lineBloomDirection) {
        this.p = lineBloomDirection;
        return this;
    }

    public PolygonOptions points(String str, EncodePointType encodePointType) {
        this.g = str;
        this.h = encodePointType;
        return this;
    }

    public PolygonOptions setBloomBlurTimes(int i) {
        if (i < 1) {
            i = 1;
        }
        if (i > 10) {
            i = 10;
        }
        this.m = i;
        return this;
    }

    public PolygonOptions setBloomGradientASpeed(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f > 10.0f) {
            f = 10.0f;
        }
        this.l = f;
        return this;
    }

    public PolygonOptions setClickable(boolean z) {
        this.j = z;
        return this;
    }

    public PolygonOptions stroke(Stroke stroke) {
        this.f3672a = stroke;
        return this;
    }

    public PolygonOptions thinAlgorithm(ThinAndSmoothAlgorithm thinAndSmoothAlgorithm) {
        this.r = thinAndSmoothAlgorithm;
        return this;
    }

    public PolygonOptions thinFactor(float f) {
        if (f > 0.0f) {
            this.s = f;
        }
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.u = z;
        return this;
    }

    public PolygonOptions zIndex(int i) {
        this.t = i;
        return this;
    }

    public PolygonOptions points(List<LatLng> list) {
        if (list != null) {
            if (list.size() > 2) {
                if (!list.contains(null)) {
                    int i = 0;
                    while (i < list.size()) {
                        int i2 = i + 1;
                        for (int i3 = i2; i3 < list.size(); i3++) {
                            if (list.get(i) == list.get(i3)) {
                                throw new IllegalArgumentException("BDMapSDKException: points list can not has same points");
                            }
                        }
                        i = i2;
                    }
                    this.c = list;
                    return this;
                }
                throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
            }
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
    }
}
