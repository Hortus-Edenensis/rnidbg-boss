package com.baidu.apis.cluster.demo;

import com.baidu.apis.cluster.BaiduClusterItem;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BaiduRegionItem<T> implements BaiduClusterItem {
    private T ext;
    private LatLng mLatLng;

    public BaiduRegionItem(LatLng latLng, T t) {
        this.mLatLng = latLng;
        this.ext = t;
    }

    public T getExtObject() {
        return this.ext;
    }

    @Override // com.baidu.apis.cluster.BaiduClusterItem
    public LatLng getPosition() {
        return this.mLatLng;
    }

    public void setExtObject(T t) {
        this.ext = t;
    }
}
