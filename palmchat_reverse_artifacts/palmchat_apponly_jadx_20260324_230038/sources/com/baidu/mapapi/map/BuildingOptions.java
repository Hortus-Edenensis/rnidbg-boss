package com.baidu.mapapi.map;

import com.baidu.mapapi.map.Prism;
import com.baidu.mapapi.search.core.BuildingInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BuildingOptions extends PrismOptions {
    private int k;
    private BitmapDescriptor l;
    private BuildingInfo n;
    private float i = 0.0f;
    private boolean j = false;
    private Prism.AnimateType m = Prism.AnimateType.AnimateNormal;
    private boolean o = true;
    boolean p = true;
    private boolean q = false;
    private float r = 5.0f;

    public Prism.AnimateType getBuildingFloorAnimateType() {
        return this.m;
    }

    public BuildingInfo getBuildingInfo() {
        return this.n;
    }

    public int getFloorColor() {
        return this.k;
    }

    public float getFloorHeight() {
        return this.i;
    }

    public BitmapDescriptor getFloorSideTextureImage() {
        return this.l;
    }

    @Override // com.baidu.mapapi.map.PrismOptions, com.baidu.mapapi.map.OverlayOptions
    public Overlay getOverlay() {
        Building building = new Building();
        building.c = getZIndex();
        building.d = this.p;
        building.n = getCustomSideImage();
        building.g = getHeight();
        building.m = getSideFaceColor();
        building.l = getTopFaceColor();
        building.y = this.o;
        building.x = this.h;
        BuildingInfo buildingInfo = this.n;
        building.p = buildingInfo;
        if (buildingInfo != null) {
            building.h = buildingInfo.getGeom();
            building.i = EncodePointType.BUILDINGINFO.ordinal();
        }
        building.u = this.j;
        building.q = this.i;
        building.t = this.k;
        building.v = this.l;
        building.w = this.m;
        building.z = this.q;
        building.A = this.r;
        return building;
    }

    public float getRoundedCornerRadius() {
        return this.r;
    }

    public boolean isAnimation() {
        return this.o;
    }

    public boolean isRoundedCorner() {
        return this.q;
    }

    public BuildingOptions setAnimation(boolean z) {
        this.o = z;
        return this;
    }

    public BuildingOptions setBuildingFloorAnimateType(Prism.AnimateType animateType) {
        this.m = animateType;
        return this;
    }

    public BuildingOptions setBuildingInfo(BuildingInfo buildingInfo) {
        this.n = buildingInfo;
        return this;
    }

    public BuildingOptions setFloorColor(int i) {
        this.j = true;
        this.k = i;
        return this;
    }

    public BuildingOptions setFloorHeight(float f) {
        BuildingInfo buildingInfo = this.n;
        if (buildingInfo == null) {
            return this;
        }
        if (f < 0.0f) {
            this.i = 0.0f;
            return this;
        }
        if (f > buildingInfo.getHeight()) {
            this.i = this.n.getHeight();
            return this;
        }
        this.i = f;
        return this;
    }

    public BuildingOptions setFloorSideTextureImage(BitmapDescriptor bitmapDescriptor) {
        this.j = true;
        this.l = bitmapDescriptor;
        return this;
    }

    public BuildingOptions setRoundedCornerEnable(boolean z) {
        this.q = z;
        return this;
    }

    public BuildingOptions setRoundedCornerRadius(float f) {
        if (f <= 0.0f) {
            f = 0.0f;
        }
        this.r = f;
        return this;
    }
}
