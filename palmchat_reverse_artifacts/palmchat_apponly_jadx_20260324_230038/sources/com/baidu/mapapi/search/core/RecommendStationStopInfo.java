package com.baidu.mapapi.search.core;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class RecommendStationStopInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3761a;
    private List<RecommendStopInfo> b;

    public List<RecommendStopInfo> getRecommendStopInfoList() {
        return this.b;
    }

    public String getStationName() {
        return this.f3761a;
    }

    public void setRecommendStopInfoList(List<RecommendStopInfo> list) {
        this.b = list;
    }

    public void setStationName(String str) {
        this.f3761a = str;
    }
}
