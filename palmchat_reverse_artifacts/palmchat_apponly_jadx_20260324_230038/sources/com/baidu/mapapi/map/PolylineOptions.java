package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class PolylineOptions extends OverlayOptions {
    private int C;
    private int D;
    private boolean F;
    private List<LatLng> b;
    private List<Integer> c;
    private List<Integer> d;
    private BitmapDescriptor f;
    private List<BitmapDescriptor> g;
    int j;
    Bundle n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3675a = -16777216;
    private int e = 5;
    private boolean h = true;
    private boolean i = false;
    boolean k = true;
    private boolean l = false;
    private boolean m = true;
    private int o = 0;
    private LineJoinType p = LineJoinType.LineJoinRound;
    private LineCapType q = LineCapType.LineCapButt;
    private boolean r = true;
    private ThinAndSmoothAlgorithm s = ThinAndSmoothAlgorithm.DOUGLAS_PEUCKER;
    private float t = 4.0f;
    private ThinAndSmoothAlgorithm u = ThinAndSmoothAlgorithm.BEZIER_SMOOTH;
    private float v = 16.0f;
    private boolean w = false;
    private boolean x = false;
    private LineDirectionCross180 y = LineDirectionCross180.NONE;
    private LineBloomType z = LineBloomType.NONE;
    private float A = 5.0f;
    private int B = 1;
    private LineBloomDirection E = LineBloomDirection.BloomAround;

    /* JADX INFO: compiled from: SearchBox */
    public enum LineBloomType {
        NONE,
        GradientA,
        BLUR
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum LineCapType {
        LineCapButt,
        LineCapRound
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum LineDirectionCross180 {
        NONE,
        FROM_EAST_TO_WEST,
        FROM_WEST_TO_EAST
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum LineJoinType {
        LineJoinBevel,
        LineJoinMiter,
        LineJoinRound,
        LineJoinBerzier
    }

    private Polyline a(Polyline polyline) {
        polyline.d = this.k;
        polyline.Q = this.y;
        polyline.h = this.b;
        polyline.l = this.e;
        polyline.B = this.x;
        List<Integer> list = this.d;
        if (list == null || list.size() == 0) {
            throw new IllegalStateException("BDMapSDKException: colors array can not be null");
        }
        List<LatLng> list2 = this.b;
        if (list2 == null || list2.size() == 0) {
            throw new IllegalStateException("BDMapSDKException: mPoints array can not be null");
        }
        int[] iArr = new int[this.d.size()];
        Iterator<Integer> it = this.d.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        polyline.j = iArr;
        return polyline;
    }

    public PolylineOptions bloomAlpha(int i) {
        if (i > 255 || i < 0) {
            i = 255;
        }
        this.D = i;
        return this;
    }

    public PolylineOptions bloomType(LineBloomType lineBloomType) {
        this.z = lineBloomType;
        return this;
    }

    public PolylineOptions bloomWidth(int i) {
        if (i < 0) {
            i = 0;
        }
        this.C = i;
        return this;
    }

    public PolylineOptions clickable(boolean z) {
        this.m = z;
        return this;
    }

    public PolylineOptions color(int i) {
        this.f3675a = i;
        return this;
    }

    public PolylineOptions colorsValues(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
        }
        this.d = list;
        return this;
    }

    public PolylineOptions customTexture(BitmapDescriptor bitmapDescriptor) {
        this.f = bitmapDescriptor;
        return this;
    }

    public PolylineOptions customTextureList(List<BitmapDescriptor> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: customTexture list can not be null");
        }
        if (list.size() == 0) {
            Log.e("baidumapsdk", "custom texture list is empty,the texture will not work");
        }
        Iterator<BitmapDescriptor> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                Log.e("baidumapsdk", "the custom texture item is null,it will be discard");
            }
        }
        this.g = list;
        return this;
    }

    public PolylineOptions dottedLine(boolean z) {
        this.l = z;
        return this;
    }

    public PolylineOptions dottedLineType(PolylineDottedLineType polylineDottedLineType) {
        this.o = polylineDottedLineType.ordinal();
        return this;
    }

    public PolylineOptions extraInfo(Bundle bundle) {
        this.n = bundle;
        return this;
    }

    public PolylineOptions focus(boolean z) {
        this.h = z;
        return this;
    }

    public int getColor() {
        return this.f3675a;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.f;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.g;
    }

    public Bundle getExtraInfo() {
        return this.n;
    }

    public LineBloomDirection getLineBloomDirection() {
        return this.E;
    }

    @Override // com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        BitmapDescriptor bitmapDescriptor;
        Polyline polyline = new Polyline();
        List<LatLng> list = this.b;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add polyline, you must at least supply 2 points");
        }
        polyline.R = this.z;
        polyline.H = this.E;
        polyline.C = this.C;
        polyline.D = this.D;
        polyline.E = this.A;
        polyline.F = this.B;
        if (this.x) {
            polyline.type = com.baidu.mapsdkplatform.comapi.map.d.gradientLine;
            return a(polyline);
        }
        polyline.d = this.k;
        polyline.m = this.l;
        polyline.c = this.j;
        polyline.e = this.n;
        polyline.h = this.b;
        polyline.g = this.f3675a;
        polyline.l = this.e;
        polyline.q = this.f;
        if (OverlayUtil.isOverlayUpgrade() && (bitmapDescriptor = this.f) != null) {
            polyline.r = new BmBitmapResource(bitmapDescriptor.getBitmap());
        }
        polyline.s = this.g;
        int i = 0;
        if (OverlayUtil.isOverlayUpgrade() && this.g != null) {
            polyline.t = new ArrayList();
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                polyline.t.add(new BmBitmapResource(this.g.get(i2).getBitmap()));
            }
        }
        polyline.n = this.h;
        polyline.o = this.i;
        polyline.p = this.m;
        polyline.v = this.r;
        polyline.w = this.s;
        polyline.x = this.t;
        polyline.y = this.u;
        polyline.z = this.v;
        polyline.A = this.w;
        polyline.B = this.x;
        polyline.u = this.o;
        polyline.P = this.p;
        polyline.O = this.q;
        polyline.Q = this.y;
        List<Integer> list2 = this.c;
        if (list2 != null && list2.size() < this.b.size() - 1) {
            ArrayList arrayList = new ArrayList((this.b.size() - 1) - this.c.size());
            List<Integer> list3 = this.c;
            list3.addAll(list3.size(), arrayList);
        }
        List<Integer> list4 = this.c;
        if (list4 != null && list4.size() > 0) {
            int[] iArr = new int[this.c.size()];
            Iterator<Integer> it = this.c.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                iArr[i3] = it.next().intValue();
                i3++;
            }
            polyline.i = iArr;
        }
        List<Integer> list5 = this.d;
        if (list5 != null && list5.size() < this.b.size() - 1) {
            ArrayList arrayList2 = new ArrayList((this.b.size() - 1) - this.d.size());
            List<Integer> list6 = this.d;
            list6.addAll(list6.size(), arrayList2);
        }
        List<Integer> list7 = this.d;
        if (list7 != null && list7.size() > 0) {
            int[] iArr2 = new int[this.d.size()];
            Iterator<Integer> it2 = this.d.iterator();
            while (it2.hasNext()) {
                iArr2[i] = it2.next().intValue();
                i++;
            }
            polyline.j = iArr2;
        }
        polyline.G = this.F;
        return polyline;
    }

    public List<LatLng> getPoints() {
        return this.b;
    }

    public List<Integer> getTextureIndexs() {
        return this.c;
    }

    public int getWidth() {
        return this.e;
    }

    public int getZIndex() {
        return this.j;
    }

    public boolean isDottedLine() {
        return this.l;
    }

    public boolean isFocus() {
        return this.h;
    }

    public PolylineOptions isGeodesic(boolean z) {
        this.w = z;
        return this;
    }

    public PolylineOptions isGradient(boolean z) {
        this.x = z;
        return this;
    }

    public PolylineOptions isThined(boolean z) {
        this.r = z;
        return this;
    }

    public boolean isVisible() {
        return this.k;
    }

    public PolylineOptions keepScale(boolean z) {
        this.i = z;
        return this;
    }

    public PolylineOptions lineBloomDirection(LineBloomDirection lineBloomDirection) {
        this.E = lineBloomDirection;
        return this;
    }

    public PolylineOptions lineCapType(LineCapType lineCapType) {
        this.q = lineCapType;
        return this;
    }

    public PolylineOptions lineDirectionCross180(LineDirectionCross180 lineDirectionCross180) {
        this.y = lineDirectionCross180;
        return this;
    }

    public PolylineOptions lineJoinType(LineJoinType lineJoinType) {
        this.p = lineJoinType;
        return this;
    }

    public PolylineOptions points(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
        this.b = list;
        return this;
    }

    public PolylineOptions setBloomBlurTimes(int i) {
        if (i < 1) {
            i = 1;
        }
        if (i > 10) {
            i = 10;
        }
        this.B = i;
        return this;
    }

    public PolylineOptions setBloomGradientASpeed(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f > 10.0f) {
            f = 10.0f;
        }
        this.A = f;
        return this;
    }

    public PolylineOptions setHighPrecision(boolean z) {
        this.F = z;
        return this;
    }

    public PolylineOptions smoothAlgorithm(ThinAndSmoothAlgorithm thinAndSmoothAlgorithm) {
        this.u = thinAndSmoothAlgorithm;
        return this;
    }

    public PolylineOptions smoothFactor(float f) {
        if (f > 0.0f) {
            this.v = f;
        }
        return this;
    }

    public PolylineOptions textureIndex(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: index list can not contains null");
        }
        this.c = list;
        return this;
    }

    public PolylineOptions thinAlgorithm(ThinAndSmoothAlgorithm thinAndSmoothAlgorithm) {
        this.s = thinAndSmoothAlgorithm;
        return this;
    }

    public PolylineOptions thinFactor(float f) {
        if (f > 0.0f) {
            this.t = f;
        }
        return this;
    }

    public PolylineOptions visible(boolean z) {
        this.k = z;
        return this;
    }

    public PolylineOptions width(int i) {
        if (i > 0) {
            this.e = i;
        }
        return this;
    }

    public PolylineOptions zIndex(int i) {
        this.j = i;
        return this;
    }
}
