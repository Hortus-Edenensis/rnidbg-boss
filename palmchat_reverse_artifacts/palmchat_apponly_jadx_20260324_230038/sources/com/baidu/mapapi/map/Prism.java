package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmPrism;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class Prism extends Overlay {
    float g;
    String h;
    int i;
    List<LatLng> j;
    BmGeoElement k;
    int l = -16777216;
    int m = -16711936;
    BitmapDescriptor n;
    BmPrism o;

    /* JADX INFO: compiled from: SearchBox */
    public enum AnimateType {
        AnimateSlow,
        AnimateNormal,
        AnimateFast
    }

    public Prism() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.prism;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        Overlay.f(this.l, bundle);
        Overlay.e(this.m, bundle);
        BitmapDescriptor bitmapDescriptor = this.n;
        if (bitmapDescriptor != null) {
            bundle.putBundle("image_info", bitmapDescriptor.a());
        }
        List<LatLng> list = this.j;
        if (list != null) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(list.get(0));
            bundle.putDouble("location_x", geoPointLl2mc.getLongitudeE6());
            bundle.putDouble("location_y", geoPointLl2mc.getLatitudeE6());
            Overlay.c(this.j, bundle);
            bundle.putDouble("m_height", this.g);
        }
        return bundle;
    }

    public BitmapDescriptor getCustomSideImage() {
        return this.n;
    }

    public float getHeight() {
        return this.g;
    }

    public List<LatLng> getPoints() {
        return this.j;
    }

    public int getSideFaceColor() {
        return this.m;
    }

    public int getTopFaceColor() {
        return this.l;
    }

    public void setCustomSideImage(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        this.n = bitmapDescriptor;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.o == null || this.f == null) {
            return;
        }
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        bmSurfaceStyle.a(this.m);
        bmSurfaceStyle.a(new BmBitmapResource(this.n.getBitmap()));
        this.o.c(bmSurfaceStyle);
        this.f.b();
    }

    public void setHeight(float f) {
        this.g = f;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPrism bmPrism = this.o;
        if (bmPrism == null || this.f == null) {
            return;
        }
        bmPrism.c(this.g);
        this.f.b();
    }

    public void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() <= 3) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than four");
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
        this.j = list;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPrism bmPrism = this.o;
        if (bmPrism == null || this.f == null) {
            return;
        }
        bmPrism.c();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.j.size(); i4++) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.j.get(i4));
            arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        }
        this.k.a(arrayList);
        this.o.a(this.k);
        this.f.b();
    }

    public void setSideFaceColor(int i) {
        this.m = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.o == null || this.f == null) {
            return;
        }
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        bmSurfaceStyle.a(this.m);
        this.o.c(bmSurfaceStyle);
        this.f.b();
    }

    public void setTopFaceColor(int i) {
        this.l = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.o == null || this.f == null) {
            return;
        }
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        bmSurfaceStyle.a(this.l);
        this.o.d(bmSurfaceStyle);
        this.f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        if (this.o == null) {
            BmPrism bmPrism = new BmPrism();
            this.o = bmPrism;
            bmPrism.a(this);
            setDrawItem(this.o);
        }
        super.toDrawItem();
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        BmSurfaceStyle bmSurfaceStyle2 = new BmSurfaceStyle();
        bmSurfaceStyle.a(this.l);
        bmSurfaceStyle2.a(this.m);
        if (this.n != null) {
            bmSurfaceStyle2.a(new BmBitmapResource(this.n.getBitmap()));
        }
        this.k = new BmGeoElement();
        String str = this.h;
        if (str != null && str.length() > 0) {
            this.k.a(this.h);
            this.k.a(this.i);
        } else if (this.j != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.j.size(); i++) {
                GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.j.get(i));
                arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            }
            this.k.a(arrayList);
            this.o.a(this.k);
        }
        float f = this.g;
        if (f > 0.0f) {
            this.o.c(f);
        }
        this.o.d(bmSurfaceStyle);
        this.o.c(bmSurfaceStyle2);
        return this.o;
    }
}
