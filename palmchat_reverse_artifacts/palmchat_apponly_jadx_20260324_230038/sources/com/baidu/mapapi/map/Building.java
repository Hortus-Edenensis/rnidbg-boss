package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.Prism;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.mapsdkplatform.comapi.map.t;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmPrism;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class Building extends Prism {
    BuildingInfo p;
    int s;
    BitmapDescriptor v;
    int x;
    boolean y;
    float q = 0.0f;
    float r = 0.0f;
    int t = 0;
    boolean u = false;
    Prism.AnimateType w = Prism.AnimateType.AnimateNormal;
    boolean z = false;
    float A = 5.0f;

    /* JADX INFO: compiled from: SearchBox */
    public enum AnimateType {
        AnimateSlow,
        AnimateNormal,
        AnimateFast
    }

    public Building() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.prism;
    }

    @Override // com.baidu.mapapi.map.Prism, com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        if (this.p != null) {
            bundle.putDouble("m_height", r0.getHeight());
            bundle.putString("encodedPoints", this.p.getGeom());
            bundle.putInt("encodePointType", EncodePointType.BUILDINGINFO.ordinal());
            bundle.putInt("m_showLevel", this.x);
            bundle.putInt("m_isAnimation", this.y ? 1 : 0);
            bundle.putInt("m_has_floor", this.u ? 1 : 0);
            bundle.putFloat("m_floor_height", this.q);
            bundle.putFloat("m_last_floor_height", this.r);
            Overlay.a(this.t, bundle);
            if (this.v != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("image_info", this.v.a());
                bundle.putBundle("m_floor_image", bundle2);
            }
            bundle.putInt("m_buildingFloorAnimateType", this.w.ordinal());
            bundle.putInt("m_isRoundedCorner", this.z ? 1 : 0);
            bundle.putFloat("m_roundedCornerRadius", this.A);
        }
        bundle.putInt("m_isBuilding", this.p != null ? 1 : 0);
        int iHashCode = hashCode();
        this.s = iHashCode;
        bundle.putInt("buildingId", iHashCode);
        return bundle;
    }

    public Prism.AnimateType getBuildingFloorAnimateType() {
        return this.w;
    }

    public int getBuildingId() {
        return this.s;
    }

    public BuildingInfo getBuildingInfo() {
        return this.p;
    }

    public int getFloorColor() {
        return this.t;
    }

    public float getFloorHeight() {
        return this.q;
    }

    public BitmapDescriptor getFloorSideTextureImage() {
        return this.v;
    }

    @Override // com.baidu.mapapi.map.Prism
    public float getHeight() {
        return this.g;
    }

    @Override // com.baidu.mapapi.map.Prism
    public List<LatLng> getPoints() {
        return this.j;
    }

    public float getRoundedCornerRadius() {
        return this.A;
    }

    public int getShowLevel() {
        return this.x;
    }

    @Override // com.baidu.mapapi.map.Prism
    public int getSideFaceColor() {
        return this.m;
    }

    @Override // com.baidu.mapapi.map.Prism
    public int getTopFaceColor() {
        return this.l;
    }

    public boolean isAnimation() {
        return this.y;
    }

    public boolean isRoundedCorner() {
        return this.z;
    }

    public void setAnimation(boolean z) {
        BmPrism bmPrism;
        this.y = z;
        if (!OverlayUtil.isOverlayUpgrade() || (bmPrism = this.o) == null || this.f == null) {
            return;
        }
        bmPrism.c(z);
        this.f.b();
    }

    public void setBuildingFloorAnimateType(Prism.AnimateType animateType) {
        this.w = animateType;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPrism bmPrism = this.o;
        if (bmPrism == null || this.f == null) {
            return;
        }
        bmPrism.f(this.w.ordinal());
        this.f.b();
    }

    public void setBuildingInfo(BuildingInfo buildingInfo) {
        if (buildingInfo == null) {
            return;
        }
        this.p = buildingInfo;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPrism bmPrism = this.o;
        if (bmPrism == null || this.f == null) {
            return;
        }
        bmPrism.c();
        float height = this.p.getHeight();
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = new t().d(this.p.getGeom()).iterator();
        while (it.hasNext()) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(it.next());
            arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
        }
        this.k.a(arrayList);
        this.o.a(this.k);
        this.o.c(height);
        this.f.b();
    }

    public void setFloorColor(int i) {
        this.u = true;
        this.t = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.o == null || this.f == null) {
            return;
        }
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        BmSurfaceStyle bmSurfaceStyle2 = new BmSurfaceStyle();
        bmSurfaceStyle.a(this.t);
        bmSurfaceStyle2.a(this.t);
        if (this.v != null) {
            bmSurfaceStyle.a(new BmBitmapResource(this.v.getBitmap()));
        }
        this.o.e(this.u);
        this.o.b(bmSurfaceStyle2);
        this.o.a(bmSurfaceStyle);
        this.f.b();
    }

    public void setFloorHeight(float f) {
        BuildingInfo buildingInfo = this.p;
        if (buildingInfo == null) {
            return;
        }
        if (f < 0.0f) {
            this.r = this.q;
            this.q = 0.0f;
            return;
        }
        if (f > buildingInfo.getHeight()) {
            this.r = this.q;
            this.q = this.p.getHeight();
            return;
        }
        this.r = this.q;
        this.q = f;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPrism bmPrism = this.o;
        if (bmPrism == null || this.f == null) {
            return;
        }
        bmPrism.b(this.q);
        this.o.d(this.r);
        this.f.b();
    }

    public void setFloorSideTextureImage(BitmapDescriptor bitmapDescriptor) {
        this.v = bitmapDescriptor;
        this.u = true;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        if (this.o == null || this.f == null) {
            return;
        }
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        bmSurfaceStyle.a(this.t);
        if (this.v != null) {
            bmSurfaceStyle.a(new BmBitmapResource(this.v.getBitmap()));
        }
        this.o.a(bmSurfaceStyle);
        this.o.e(this.u);
        this.f.b();
    }

    public void setRoundedCornerEnable(boolean z) {
        this.z = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPrism bmPrism = this.o;
        if (bmPrism == null || this.f == null) {
            return;
        }
        bmPrism.f(z);
        this.f.b();
    }

    public void setRoundedCornerRadius(float f) {
        this.A = f > 0.0f ? f : 0.0f;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
            return;
        }
        BmPrism bmPrism = this.o;
        if (bmPrism == null || this.f == null) {
            return;
        }
        bmPrism.e(f);
        this.f.b();
    }

    public void setShowLevel(int i) {
        this.x = i;
    }

    @Override // com.baidu.mapapi.map.Prism, com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        BmPrism bmPrism = new BmPrism();
        this.o = bmPrism;
        bmPrism.a(this);
        setDrawItem(this.o);
        super.toDrawItem();
        this.k = new BmGeoElement();
        BuildingInfo buildingInfo = this.p;
        if (buildingInfo != null) {
            this.o.c(buildingInfo.getHeight());
            this.o.d(true);
            this.o.c(this.y);
            this.o.b(this.x);
            BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
            BmSurfaceStyle bmSurfaceStyle2 = new BmSurfaceStyle();
            if (this.v != null) {
                bmSurfaceStyle.a(new BmBitmapResource(this.v.getBitmap()));
            }
            bmSurfaceStyle.a(this.t);
            bmSurfaceStyle2.a(this.t);
            this.o.e(this.u);
            this.o.d(this.r);
            this.o.a(bmSurfaceStyle);
            this.o.b(bmSurfaceStyle2);
            this.o.b(this.q);
            this.o.f(this.w.ordinal());
            this.o.e(1);
            ArrayList arrayList = new ArrayList();
            Iterator<LatLng> it = new t().d(this.p.getGeom()).iterator();
            while (it.hasNext()) {
                GeoPoint geoPointLl2mc = CoordUtil.ll2mc(it.next());
                arrayList.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            }
            this.k.a(arrayList);
            this.o.a(this.k);
            this.o.f(this.z);
            this.o.e(this.A);
        }
        int iHashCode = hashCode();
        this.s = iHashCode;
        this.o.a(String.valueOf(iHashCode));
        return this.o;
    }
}
