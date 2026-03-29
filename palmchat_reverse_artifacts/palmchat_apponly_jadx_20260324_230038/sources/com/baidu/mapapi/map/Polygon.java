package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.t;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmPolygon;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Polygon extends Overlay {
    BmPolygon A;
    float D;
    float E;
    int F;
    float G;
    Stroke g;
    BmGeoElement i;
    String j;
    BmSurfaceStyle k;
    BmLineStyle l;
    BmGeoElement n;
    int p;
    List<LatLng> q;
    List<HoleOptions> r;
    HoleOptions s;
    boolean t;
    boolean x;
    ThinAndSmoothAlgorithm y;
    float z;
    boolean h = false;
    int m = PolylineDottedLineType.DOTTED_LINE_SQUARE.ordinal();
    List<BmGeoElement> o = new ArrayList();
    boolean u = false;
    boolean v = false;
    int w = -1;
    LineBloomType B = LineBloomType.NONE;
    LineBloomDirection C = LineBloomDirection.BloomAround;

    public Polygon() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.polygon;
    }

    private void b(Bundle bundle) {
        int i = this.m;
        BitmapDescriptor bitmapDescriptorFromAsset = BitmapDescriptorFactory.fromAsset(i == 1 ? "CircleDashTexture.png" : i == 2 ? "lineDash_Rectangle.png" : "lineDashTexture.png");
        if (bitmapDescriptorFromAsset != null) {
            bundle.putBundle("image_info", bitmapDescriptorFromAsset.a());
        }
    }

    private void e(List<HoleOptions> list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        boolean zB = Overlay.b(list, bundle2);
        bundle.putInt("has_holes", zB ? 1 : 0);
        if (zB) {
            bundle.putBundle("holes", bundle2);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (this.t) {
            bundle.putInt("has_dotted_stroke", 1);
            b(bundle);
        } else {
            bundle.putInt("has_dotted_stroke", 0);
        }
        String str = this.j;
        if (str == null || str.length() <= 0 || this.b == null) {
            List<LatLng> list = this.q;
            if (list != null) {
                GeoPoint geoPointLl2mc = CoordUtil.ll2mc(list.get(0));
                bundle.putDouble("location_x", geoPointLl2mc.getLongitudeE6());
                bundle.putDouble("location_y", geoPointLl2mc.getLatitudeE6());
                Overlay.c(this.q, bundle);
                if (this.t) {
                    bundle.putDouble("dotted_stroke_location_x", geoPointLl2mc.getLongitudeE6());
                    bundle.putDouble("dotted_stroke_location_y", geoPointLl2mc.getLatitudeE6());
                }
            }
        } else {
            bundle.putString("encodedPoints", this.j);
            bundle.putInt("encodePointType", this.b.ordinal());
        }
        Overlay.d(this.p, bundle);
        if (this.g == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.g.a(new Bundle()));
        }
        List<HoleOptions> list2 = this.r;
        if (list2 != null && list2.size() != 0) {
            e(this.r, bundle);
            bundle.putInt("holes_count", this.r.size());
        } else if (this.s != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.s);
            e(arrayList, bundle);
            bundle.putInt("holes_count", 1);
        } else {
            bundle.putInt("has_holes", 0);
        }
        bundle.putInt("isClickable", this.u ? 1 : 0);
        bundle.putInt("isHoleClickable", this.v ? 1 : 0);
        bundle.putInt("isThined", this.x ? 1 : 0);
        return bundle;
    }

    public String getEncodedPoint() {
        return this.j;
    }

    public int getFillColor() {
        return this.p;
    }

    public int getHoleClickedIndex() {
        return this.w;
    }

    public HoleOptions getHoleOption() {
        return this.s;
    }

    public List<HoleOptions> getHoleOptions() {
        return this.r;
    }

    public EncodePointType getPointType() {
        return this.b;
    }

    public List<LatLng> getPoints() {
        return this.q;
    }

    public Stroke getStroke() {
        return this.g;
    }

    public boolean isClickable() {
        return this.u;
    }

    public boolean isThined() {
        return this.x;
    }

    public void setBloomAlpha(float f) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.D = f;
            this.A.b(f);
            this.f.b();
        }
    }

    public void setBloomBlurTimes(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.F = i;
            this.A.e(i);
            this.f.b();
        }
    }

    public void setBloomGradientASpeed(float f) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.G = f;
            this.A.c(f);
            this.f.b();
        }
    }

    public void setBloomWidth(float f) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.E = f;
            this.A.d(f);
            this.f.b();
        }
    }

    public void setClickable(boolean z) {
        this.u = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPolygon bmPolygon = this.A;
        if (bmPolygon == null || this.f == null) {
            return;
        }
        bmPolygon.a(z);
        this.f.b();
    }

    public void setEncodeInfo(String str, EncodePointType encodePointType) {
        if (str == null || str.length() <= 0) {
            return;
        }
        this.j = str;
        this.b = encodePointType;
        if (OverlayUtil.isOverlayUpgrade()) {
            b();
        } else {
            this.listener.c(this);
        }
    }

    public void setFillColor(int i) {
        this.p = i;
        if (OverlayUtil.isOverlayUpgrade()) {
            b();
        } else {
            this.listener.c(this);
        }
    }

    public void setHoleClickable(boolean z) {
        this.v = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPolygon bmPolygon = this.A;
        if (bmPolygon == null || this.f == null) {
            return;
        }
        bmPolygon.b(z);
        this.f.b();
    }

    public void setHoleOption(HoleOptions holeOptions) {
        if (holeOptions == null) {
            return;
        }
        this.s = holeOptions;
        this.r = null;
        if (OverlayUtil.isOverlayUpgrade()) {
            b();
        } else {
            this.listener.c(this);
        }
    }

    public void setHoleOptions(List<HoleOptions> list) {
        this.r = list;
        this.s = null;
        if (OverlayUtil.isOverlayUpgrade()) {
            b();
        } else {
            this.listener.c(this);
        }
    }

    public void setLineBloomDirection(LineBloomDirection lineBloomDirection) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.C = lineBloomDirection;
            this.A.g(lineBloomDirection.ordinal());
            this.f.b();
        }
    }

    public void setLineBloomType(LineBloomType lineBloomType) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.B = lineBloomType;
            this.A.h(lineBloomType.ordinal());
            this.f.b();
        }
    }

    public void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() <= 2) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than three");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
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
        this.q = list;
        if (OverlayUtil.isOverlayUpgrade()) {
            b();
        } else {
            this.listener.c(this);
        }
    }

    public void setStroke(Stroke stroke) {
        this.g = stroke;
        this.h = true;
        if (OverlayUtil.isOverlayUpgrade()) {
            b();
        } else {
            this.listener.c(this);
        }
    }

    public void setThinAlgorithm(ThinAndSmoothAlgorithm thinAndSmoothAlgorithm) {
        this.y = thinAndSmoothAlgorithm;
        if (OverlayUtil.isOverlayUpgrade()) {
            this.A.i(this.y.getValue());
            this.f.b();
        }
    }

    public void setThinFactor(float f) {
        if (f > 0.0f) {
            this.z = f;
        }
        if (OverlayUtil.isOverlayUpgrade()) {
            this.A.e(this.z);
            this.f.b();
        }
    }

    public void setThined(boolean z) {
        this.x = z;
        this.listener.c(this);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmPolygon bmPolygon = new BmPolygon();
        this.A = bmPolygon;
        bmPolygon.a(this);
        setDrawItem(this.A);
        super.toDrawItem();
        this.i = new BmGeoElement();
        BmLineStyle bmLineStyle = new BmLineStyle();
        this.l = bmLineStyle;
        Stroke stroke = this.g;
        if (stroke != null) {
            bmLineStyle.d(stroke.strokeWidth);
            this.l.a(this.g.color);
            if (this.t) {
                setDottedBitmapResource(this.l, this.m);
                this.l.c(5);
            } else {
                this.l.b(0);
            }
            this.A.h(this.B.ordinal());
            this.A.g(this.C.ordinal());
            this.A.b(this.D);
            this.A.d(this.E);
            this.A.c(this.G);
            this.A.e(this.F);
        }
        this.i.a(this.l);
        ArrayList arrayList = new ArrayList();
        String str = this.j;
        if (str == null || str.length() <= 0 || this.b == null) {
            List<LatLng> list = this.q;
            if (list != null) {
                Overlay.mcLocation = CoordUtil.ll2mc(list.get(0));
                Iterator<LatLng> it = this.q.iterator();
                while (it.hasNext()) {
                    GeoPoint geoPointLl2mc = CoordUtil.ll2mc(it.next());
                    arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
                }
                this.i.a(arrayList);
            }
        } else {
            Iterator<LatLng> it2 = new t().d(this.j).iterator();
            while (it2.hasNext()) {
                GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(it2.next());
                arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6()));
            }
            this.i.a(arrayList);
        }
        this.A.a(this.i);
        List<HoleOptions> list2 = this.r;
        if (list2 != null && list2.size() != 0) {
            List<List<com.baidu.platform.comapi.bmsdk.b>> listHoleInfo2BmGeo = Overlay.holeInfo2BmGeo(this.r);
            for (int i = 0; i < listHoleInfo2BmGeo.size(); i++) {
                BmGeoElement bmGeoElement = new BmGeoElement();
                bmGeoElement.a(listHoleInfo2BmGeo.get(i));
                this.o.add(bmGeoElement);
                this.A.b(bmGeoElement);
            }
        } else if (this.s != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.s);
            List<com.baidu.platform.comapi.bmsdk.b> list3 = Overlay.holeInfo2BmGeo(arrayList2).get(0);
            BmGeoElement bmGeoElement2 = new BmGeoElement();
            this.n = bmGeoElement2;
            bmGeoElement2.a(list3);
            this.A.b(this.n);
        }
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        this.k = bmSurfaceStyle;
        bmSurfaceStyle.a(this.p);
        this.A.a(this.k);
        this.A.f(4096);
        this.A.a(this.u);
        this.A.b(this.v);
        if (this.x) {
            this.A.i(this.y.getValue());
            float f = this.z;
            if (f > 0.0f) {
                this.A.e(f);
            }
        }
        return this.A;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem b() {
        BmLineStyle bmLineStyle;
        if (this.i != null && this.A != null) {
            super.b();
            this.A.c();
            Stroke stroke = this.g;
            if (stroke != null && (bmLineStyle = this.l) != null) {
                bmLineStyle.d(stroke.strokeWidth);
                this.l.a(this.g.color);
                if (this.t) {
                    setDottedBitmapResource(this.l, this.m);
                    this.l.c(5);
                } else {
                    this.l.b(0);
                }
                this.i.a(this.l);
            }
            ArrayList arrayList = new ArrayList();
            String str = this.j;
            if (str != null && str.length() > 0 && this.b != null) {
                Iterator<LatLng> it = new t().d(this.j).iterator();
                while (it.hasNext()) {
                    GeoPoint geoPointLl2mc = CoordUtil.ll2mc(it.next());
                    arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
                }
                this.i.a(arrayList);
            } else {
                List<LatLng> list = this.q;
                if (list != null) {
                    Overlay.mcLocation = CoordUtil.ll2mc(list.get(0));
                    Iterator<LatLng> it2 = this.q.iterator();
                    while (it2.hasNext()) {
                        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(it2.next());
                        arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6()));
                    }
                    this.i.a(arrayList);
                }
            }
            this.A.a(this.i);
            List<HoleOptions> list2 = this.r;
            if (list2 != null && list2.size() != 0) {
                List<List<com.baidu.platform.comapi.bmsdk.b>> listHoleInfo2BmGeo = Overlay.holeInfo2BmGeo(this.r);
                for (int i = 0; i < listHoleInfo2BmGeo.size(); i++) {
                    BmGeoElement bmGeoElement = new BmGeoElement();
                    bmGeoElement.a(listHoleInfo2BmGeo.get(i));
                    this.o.add(bmGeoElement);
                    this.A.b(bmGeoElement);
                }
            } else if (this.s != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.s);
                List<com.baidu.platform.comapi.bmsdk.b> list3 = Overlay.holeInfo2BmGeo(arrayList2).get(0);
                BmGeoElement bmGeoElement2 = new BmGeoElement();
                this.n = bmGeoElement2;
                bmGeoElement2.a(list3);
                this.A.b(this.n);
            }
            BmSurfaceStyle bmSurfaceStyle = this.k;
            if (bmSurfaceStyle != null) {
                bmSurfaceStyle.a(this.p);
                this.A.a(this.k);
            }
            this.A.f(4096);
            this.A.a(this.u);
            this.A.b(this.v);
            this.f.b();
            return this.A;
        }
        return this.A;
    }
}
