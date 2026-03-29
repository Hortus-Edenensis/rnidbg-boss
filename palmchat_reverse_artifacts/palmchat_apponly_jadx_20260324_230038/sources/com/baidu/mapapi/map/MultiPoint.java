package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmMultiPoint;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class MultiPoint extends Overlay {
    List<MultiPointItem> g;
    BitmapDescriptor h;
    int i;
    int j;
    float k;
    float l;
    boolean m = true;
    private BmMultiPoint n;

    public MultiPoint() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.multiPoint;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        List<MultiPointItem> list = this.g;
        if (list != null && list.size() > 0) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.g.get(0).getPoint());
            bundle.putDouble("location_x", geoPointLl2mc.getLongitudeE6());
            bundle.putDouble("location_y", geoPointLl2mc.getLatitudeE6());
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.g.size(); i++) {
                MultiPointItem multiPointItem = this.g.get(i);
                if (multiPointItem != null) {
                    arrayList.add(multiPointItem.getPoint());
                }
            }
            Overlay.c(arrayList, bundle);
        }
        BitmapDescriptor bitmapDescriptor = this.h;
        if (bitmapDescriptor != null) {
            bundle.putBundle("image_info", bitmapDescriptor.a());
        }
        bundle.putInt("isClickable", this.m ? 1 : 0);
        bundle.putFloat("anchor_x", this.k);
        bundle.putFloat("anchor_y", this.l);
        bundle.putFloat("pointsize_x", this.i);
        bundle.putFloat("pointsize_y", this.j);
        return bundle;
    }

    public void anchor(float f, float f2) {
        if (f < 0.0f || f > 1.0f || f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        this.k = f;
        this.l = f2;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmMultiPoint bmMultiPoint = this.n;
        if (bmMultiPoint == null || this.f == null) {
            return;
        }
        bmMultiPoint.b(this.k);
        this.n.c(this.l);
        this.f.b();
    }

    public float getAnchorX() {
        return this.k;
    }

    public float getAnchorY() {
        return this.l;
    }

    public BitmapDescriptor getIcon() {
        return this.h;
    }

    public MultiPointItem getMultiPointItem(int i) {
        List<MultiPointItem> list = this.g;
        if (list == null || i >= list.size()) {
            return null;
        }
        return this.g.get(i);
    }

    public List<MultiPointItem> getMultiPointItems() {
        return this.g;
    }

    public int getPointSizeHeight() {
        return this.j;
    }

    public int getPointSizeWidth() {
        return this.i;
    }

    public boolean isClickable() {
        return this.m;
    }

    public void setClickable(boolean z) {
        this.m = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmMultiPoint bmMultiPoint = this.n;
        if (bmMultiPoint == null || this.f == null) {
            return;
        }
        bmMultiPoint.a(z);
        this.f.b();
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
        }
        this.h = bitmapDescriptor;
        if (this.i == 0) {
            this.i = bitmapDescriptor.getBitmap().getWidth();
        }
        if (this.j == 0) {
            this.j = bitmapDescriptor.getBitmap().getHeight();
        }
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.n == null || this.f == null) {
                return;
            }
            this.n.a(new BmBitmapResource(this.h.getBitmap()));
            this.f.b();
        }
    }

    public void setMultiPointItems(List<MultiPointItem> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not be null");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: multiPointItems list can not contains null");
        }
        this.g = list;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmMultiPoint bmMultiPoint = this.n;
        if (bmMultiPoint == null || this.f == null) {
            return;
        }
        bmMultiPoint.c();
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.g.get(0).getPoint());
        this.n.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        BmGeoElement bmGeoElement = new BmGeoElement();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.g.size(); i++) {
            MultiPointItem multiPointItem = this.g.get(i);
            if (multiPointItem != null) {
                GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(multiPointItem.getPoint());
                arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6()));
            }
        }
        bmGeoElement.a(arrayList);
        this.n.a(bmGeoElement);
        this.f.b();
    }

    public void setPointSize(int i, int i2) {
        if (this.i <= 0 || this.j <= 0) {
            throw new IllegalArgumentException("BDMapSDKException: MultiPoint setPointSize can not be 0 Or can't less than 0");
        }
        this.i = i;
        this.j = i2;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmMultiPoint bmMultiPoint = this.n;
        if (bmMultiPoint == null || this.f == null) {
            return;
        }
        bmMultiPoint.b(this.i);
        this.n.a(this.j);
        this.f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmMultiPoint bmMultiPoint = new BmMultiPoint();
        this.n = bmMultiPoint;
        bmMultiPoint.a(this);
        setDrawItem(this.n);
        super.getDrawItem();
        this.n.b(this.k);
        this.n.c(this.l);
        this.n.b(this.i);
        this.n.a(this.j);
        this.n.a(this.m);
        List<MultiPointItem> list = this.g;
        if (list != null && list.size() > 0) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.g.get(0).getPoint());
            this.n.a(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            BmGeoElement bmGeoElement = new BmGeoElement();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.g.size(); i++) {
                MultiPointItem multiPointItem = this.g.get(i);
                if (multiPointItem != null) {
                    GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(multiPointItem.getPoint());
                    arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6()));
                }
            }
            bmGeoElement.a(arrayList);
            this.n.a(bmGeoElement);
        }
        if (this.h != null) {
            this.n.a(new BmBitmapResource(this.h.getBitmap()));
        }
        return this.n;
    }
}
