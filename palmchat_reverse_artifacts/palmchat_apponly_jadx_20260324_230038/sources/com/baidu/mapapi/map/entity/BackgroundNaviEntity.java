package com.baidu.mapapi.map.entity;

import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BackgroundNaviEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<LatLng> f3730a;

    public ArrayList<LatLng> getRouteShapePoints() {
        return this.f3730a;
    }

    public void setRouteShapePoints(ArrayList<LatLng> arrayList) {
        this.f3730a = arrayList;
    }
}
