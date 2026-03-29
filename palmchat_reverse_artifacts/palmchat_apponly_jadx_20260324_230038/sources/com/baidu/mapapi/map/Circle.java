package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmCircle;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Circle extends Overlay {
    float B;
    float C;
    int D;
    float E;
    LatLng g;
    int h;
    int i;
    Stroke j;
    boolean k;
    List<HoleOptions> l;
    HoleOptions m;
    boolean n;
    int u;
    int v;
    private BmCircle y;
    boolean o = false;
    boolean p = false;
    int q = -1;
    int r = 1;
    int s = PolylineDottedLineType.DOTTED_LINE_SQUARE.ordinal();
    BmSurfaceStyle t = new BmSurfaceStyle();
    float w = 0.5f;
    float x = 0.2f;
    LineBloomType z = LineBloomType.NONE;
    LineBloomDirection A = LineBloomDirection.BloomAround;

    public Circle() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.circle;
    }

    private void b(Bundle bundle) {
        int i = this.s;
        BitmapDescriptor bitmapDescriptorFromAsset = BitmapDescriptorFactory.fromAsset(i == 1 ? "CircleDashTexture.png" : i == 2 ? "lineDash_Rectangle.png" : "lineDashTexture.png");
        if (bitmapDescriptorFromAsset != null) {
            bundle.putBundle("image_info", bitmapDescriptorFromAsset.a());
        }
    }

    private void c() {
        BmCircle bmCircle = this.y;
        if (bmCircle == null || this.f == null) {
            return;
        }
        bmCircle.c(this.n);
        if (this.n) {
            this.y.d();
            ArrayList arrayList = new ArrayList();
            this.y.e(this.x);
            this.y.f(this.w);
            arrayList.add(Integer.valueOf(this.u));
            arrayList.add(Integer.valueOf(this.v));
            this.y.a(this.r, arrayList);
        }
        this.f.b();
    }

    private void d() {
        if (this.y == null || this.f == null) {
            return;
        }
        List<HoleOptions> list = this.l;
        if (list != null && list.size() != 0) {
            this.y.c();
            List<List<com.baidu.platform.comapi.bmsdk.b>> listHoleInfo2BmGeo = Overlay.holeInfo2BmGeo(this.l);
            for (int i = 0; i < listHoleInfo2BmGeo.size(); i++) {
                BmGeoElement bmGeoElement = new BmGeoElement();
                bmGeoElement.a(listHoleInfo2BmGeo.get(i));
                this.y.a(bmGeoElement);
            }
        } else if (this.m != null) {
            this.y.c();
            BmGeoElement bmGeoElement2 = new BmGeoElement();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.m);
            bmGeoElement2.a(Overlay.holeInfo2BmGeo(arrayList).get(0));
            this.y.a(bmGeoElement2);
        }
        this.f.b();
    }

    private void e() {
        if (this.j != null) {
            BmLineStyle bmLineStyle = new BmLineStyle();
            bmLineStyle.d(this.j.strokeWidth);
            bmLineStyle.a(this.j.color);
            if (this.k) {
                setDottedBitmapResource(bmLineStyle, this.s);
                bmLineStyle.c(5);
            } else {
                bmLineStyle.b(0);
            }
            this.y.a(bmLineStyle);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.g);
        bundle.putDouble("location_x", geoPointLl2mc.getLongitudeE6());
        bundle.putDouble("location_y", geoPointLl2mc.getLatitudeE6());
        if (this.n) {
            bundle.putInt("m_isGradientCircle", 1);
            Overlay.b(this.u, bundle);
            Overlay.c(this.v, bundle);
            bundle.putFloat("m_color_weight", this.x);
            bundle.putFloat("m_radius_weight", this.w);
        } else {
            bundle.putInt("m_isGradientCircle", 0);
        }
        if (this.k) {
            bundle.putDouble("dotted_stroke_location_x", geoPointLl2mc.getLongitudeE6());
            bundle.putDouble("dotted_stroke_location_y", geoPointLl2mc.getLatitudeE6());
            bundle.putInt("has_dotted_stroke", 1);
            b(bundle);
        } else {
            bundle.putInt("has_dotted_stroke", 0);
        }
        bundle.putInt("radius", CoordUtil.getMCDistanceByOneLatLngAndRadius(this.g, this.i));
        Overlay.d(this.h, bundle);
        if (this.j == null) {
            bundle.putInt("has_stroke", 0);
        } else {
            bundle.putInt("has_stroke", 1);
            bundle.putBundle("stroke", this.j.a(new Bundle()));
        }
        List<HoleOptions> list = this.l;
        if (list != null && list.size() != 0) {
            e(this.l, bundle);
            bundle.putInt("holes_count", this.l.size());
        } else if (this.m != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.m);
            e(arrayList, bundle);
            bundle.putInt("holes_count", 1);
        } else {
            bundle.putInt("has_holes", 0);
        }
        bundle.putInt("isClickable", this.o ? 1 : 0);
        bundle.putInt("isHoleClickable", this.p ? 1 : 0);
        return bundle;
    }

    public LatLng getCenter() {
        return this.g;
    }

    public int getCenterColor() {
        return this.u;
    }

    public float getColorWeight() {
        return this.x;
    }

    public int getDottedStrokeType() {
        return this.s;
    }

    public int getFillColor() {
        return this.h;
    }

    public int getHoleClickedIndex() {
        return this.q;
    }

    public HoleOptions getHoleOption() {
        return this.m;
    }

    public List<HoleOptions> getHoleOptions() {
        return this.l;
    }

    public int getRadius() {
        return this.i;
    }

    public float getRadiusWeight() {
        return this.w;
    }

    public int getSideColor() {
        return this.v;
    }

    public Stroke getStroke() {
        return this.j;
    }

    public boolean isClickable() {
        return this.o;
    }

    public boolean isDottedStroke() {
        return this.k;
    }

    public boolean isIsGradientCircle() {
        return this.n;
    }

    public void setBloomAlpha(float f) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.B = f;
            this.y.b(f);
            this.f.b();
        }
    }

    public void setBloomBlurTimes(int i) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.D = i;
            this.y.e(i);
            this.f.b();
        }
    }

    public void setBloomGradientASpeed(float f) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.E = f;
            this.y.c(f);
            this.f.b();
        }
    }

    public void setBloomWidth(float f) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.C = f;
            this.y.d(f);
            this.f.b();
        }
    }

    public void setCenter(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("BDMapSDKException: circle center can not be null");
        }
        this.g = latLng;
        Overlay.mcLocation = CoordUtil.ll2mc(latLng);
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmCircle bmCircle = this.y;
        if (bmCircle == null || this.f == null) {
            return;
        }
        bmCircle.a(new com.baidu.platform.comapi.bmsdk.b(Overlay.mcLocation.getLongitudeE6(), Overlay.mcLocation.getLatitudeE6()));
        this.f.b();
    }

    public void setCenterColor(int i) {
        this.u = i;
        if (OverlayUtil.isOverlayUpgrade()) {
            c();
        } else {
            this.listener.c(this);
        }
    }

    public void setClickable(boolean z) {
        this.o = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmCircle bmCircle = this.y;
        if (bmCircle == null || this.f == null) {
            return;
        }
        bmCircle.a(z);
        this.f.b();
    }

    public void setColorWeight(float f) {
        if (f <= 0.0f || f >= 1.0f) {
            return;
        }
        this.x = f;
        if (OverlayUtil.isOverlayUpgrade()) {
            c();
        } else {
            this.listener.c(this);
        }
    }

    public void setDottedStroke(boolean z) {
        this.k = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.y == null || this.f == null || this.t == null) {
                return;
            }
            e();
            this.f.b();
        }
    }

    public void setDottedStrokeType(CircleDottedStrokeType circleDottedStrokeType) {
        this.s = circleDottedStrokeType.ordinal();
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.y == null || this.f == null || this.t == null) {
                return;
            }
            e();
            this.f.b();
        }
    }

    public void setFillColor(int i) {
        BmSurfaceStyle bmSurfaceStyle;
        this.h = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.y == null || this.f == null || (bmSurfaceStyle = this.t) == null) {
            return;
        }
        bmSurfaceStyle.a(this.h);
        this.y.a(this.t);
        this.f.b();
    }

    public void setHoleClickable(boolean z) {
        this.p = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmCircle bmCircle = this.y;
        if (bmCircle == null || this.f == null) {
            return;
        }
        bmCircle.b(z);
        this.f.b();
    }

    public void setHoleOption(HoleOptions holeOptions) {
        if (holeOptions == null) {
            return;
        }
        this.m = holeOptions;
        this.l = null;
        if (OverlayUtil.isOverlayUpgrade()) {
            d();
        } else {
            this.listener.c(this);
        }
    }

    public void setHoleOptions(List<HoleOptions> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.l = list;
        this.m = null;
        if (OverlayUtil.isOverlayUpgrade()) {
            d();
        } else {
            this.listener.c(this);
        }
    }

    public void setIsGradientCircle(boolean z) {
        this.n = z;
        if (OverlayUtil.isOverlayUpgrade()) {
            c();
        } else {
            this.listener.c(this);
        }
    }

    public void setLineBloomDirection(LineBloomDirection lineBloomDirection) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.A = lineBloomDirection;
            this.y.f(lineBloomDirection.ordinal());
            this.f.b();
        }
    }

    public void setLineBloomType(LineBloomType lineBloomType) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.z = lineBloomType;
            this.y.g(lineBloomType.ordinal());
            this.f.b();
        }
    }

    public void setRadius(int i) {
        this.i = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.y == null || this.f == null || this.t == null) {
            return;
        }
        this.y.a(CoordUtil.getMCDistanceByOneLatLngAndRadius(this.g, this.i));
        this.f.b();
    }

    public void setRadiusWeight(float f) {
        if (f <= 0.0f || f >= 1.0f) {
            return;
        }
        this.w = f;
        if (OverlayUtil.isOverlayUpgrade()) {
            c();
        } else {
            this.listener.c(this);
        }
    }

    public void setSideColor(int i) {
        this.v = i;
        if (OverlayUtil.isOverlayUpgrade()) {
            c();
        } else {
            this.listener.c(this);
        }
    }

    public void setStroke(Stroke stroke) {
        this.j = stroke;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.y == null || this.f == null || this.t == null) {
                return;
            }
            e();
            this.f.b();
        }
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmCircle bmCircle = new BmCircle();
        this.y = bmCircle;
        bmCircle.a(this);
        setDrawItem(this.y);
        super.toDrawItem();
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.g);
        Overlay.mcLocation = geoPointLl2mc;
        this.y.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), Overlay.mcLocation.getLatitudeE6()));
        this.y.a(CoordUtil.getMCDistanceByOneLatLngAndRadius(this.g, this.i));
        if (this.j != null) {
            BmLineStyle bmLineStyle = new BmLineStyle();
            bmLineStyle.d(this.j.strokeWidth);
            bmLineStyle.a(this.j.color);
            if (this.k) {
                setDottedBitmapResource(bmLineStyle, this.s);
                bmLineStyle.c(5);
            } else {
                bmLineStyle.b(0);
            }
            this.y.a(bmLineStyle);
            this.y.b(this.B);
            this.y.d(this.C);
            this.y.g(this.z.ordinal());
            this.y.c(this.E);
            this.y.f(this.A.ordinal());
        }
        this.t.a(this.h);
        this.y.a(this.t);
        List<HoleOptions> list = this.l;
        if (list != null && list.size() != 0) {
            List<List<com.baidu.platform.comapi.bmsdk.b>> listHoleInfo2BmGeo = Overlay.holeInfo2BmGeo(this.l);
            for (int i = 0; i < listHoleInfo2BmGeo.size(); i++) {
                BmGeoElement bmGeoElement = new BmGeoElement();
                bmGeoElement.a(listHoleInfo2BmGeo.get(i));
                this.y.a(bmGeoElement);
            }
        } else if (this.m != null) {
            BmGeoElement bmGeoElement2 = new BmGeoElement();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.m);
            bmGeoElement2.a(Overlay.holeInfo2BmGeo(arrayList).get(0));
            this.y.a(bmGeoElement2);
        }
        this.y.b(this.p);
        this.y.a(this.o);
        this.y.c(this.n);
        if (this.n) {
            ArrayList arrayList2 = new ArrayList();
            this.y.e(this.x);
            this.y.f(this.w);
            arrayList2.add(Integer.valueOf(this.u));
            arrayList2.add(Integer.valueOf(this.v));
            this.y.a(this.r, arrayList2);
        }
        return this.y;
    }

    private void e(List<HoleOptions> list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        boolean zB = Overlay.b(list, bundle2);
        bundle.putInt("has_holes", zB ? 1 : 0);
        if (zB) {
            bundle.putBundle("holes", bundle2);
        }
    }
}
