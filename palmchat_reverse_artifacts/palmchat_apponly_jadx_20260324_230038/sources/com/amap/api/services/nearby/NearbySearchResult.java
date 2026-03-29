package com.amap.api.services.nearby;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class NearbySearchResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<NearbyInfo> f3169a = new ArrayList();
    private int b = 0;

    public List<NearbyInfo> getNearbyInfoList() {
        return this.f3169a;
    }

    public int getTotalNum() {
        return this.b;
    }

    public void setNearbyInfoList(List<NearbyInfo> list) {
        this.f3169a = list;
        this.b = list.size();
    }
}
