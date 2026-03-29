package com.baidu.mapapi.navi;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class WayPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<WayPointInfo> f3746a;

    public WayPoint(List<WayPointInfo> list) {
        if (list == null) {
            return;
        }
        this.f3746a = list;
    }

    public List<WayPointInfo> getViaPoints() {
        return this.f3746a;
    }
}
