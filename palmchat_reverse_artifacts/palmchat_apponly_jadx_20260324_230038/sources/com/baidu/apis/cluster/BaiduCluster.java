package com.baidu.apis.cluster;

import com.baidu.apis.cluster.BaiduClusterItem;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BaiduCluster<T extends BaiduClusterItem> {
    private List<T> mClusterItems = new ArrayList();
    private LatLng mLatLng;
    private Marker mMarker;
    private T targetItem;

    public BaiduCluster(LatLng latLng) {
        this.mLatLng = latLng;
    }

    public void addClusterItem(T t) {
        this.mClusterItems.add(t);
    }

    public LatLng getCenterLatLng() {
        return this.mLatLng;
    }

    public int getClusterCount() {
        return this.mClusterItems.size();
    }

    public List<T> getClusterItems() {
        return this.mClusterItems;
    }

    public Marker getMarker() {
        return this.mMarker;
    }

    public T getTargetItem() {
        return this.targetItem;
    }

    public void setMarker(Marker marker) {
        this.mMarker = marker;
    }

    public void setTargetItem(T t) {
        this.targetItem = t;
    }
}
