package com.baidu.mapapi.search.aoi;

import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class AoiSearchOption {
    public ArrayList<LatLng> mLatLngList;

    public ArrayList<LatLng> getLatLngList() {
        return this.mLatLngList;
    }

    public AoiSearchOption setLatLngList(ArrayList<LatLng> arrayList) {
        this.mLatLngList = arrayList;
        return this;
    }
}
