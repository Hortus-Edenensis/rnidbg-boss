package com.baidu.mapapi.search.route;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BikingRoutePlanOption {
    public PlanNode mFrom = null;
    public PlanNode mTo = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<PlanNode> f3796a = null;
    public String mRoadPrefer = "0";
    public int mRidingType = 0;

    public BikingRoutePlanOption from(PlanNode planNode) {
        this.mFrom = planNode;
        return this;
    }

    public List<PlanNode> getWayPoints() {
        return this.f3796a;
    }

    public BikingRoutePlanOption passBy(List<PlanNode> list) {
        this.f3796a = list;
        return this;
    }

    public BikingRoutePlanOption ridingType(int i) {
        this.mRidingType = i;
        return this;
    }

    public BikingRoutePlanOption roadPrefer(String str) {
        this.mRoadPrefer = str;
        return this;
    }

    public BikingRoutePlanOption to(PlanNode planNode) {
        this.mTo = planNode;
        return this;
    }
}
