package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class PolygonHoleOptions extends HoleOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<LatLng> f3671a;

    public PolygonHoleOptions() {
        this.mHoleType = "polygon";
    }

    public PolygonHoleOptions addPoints(List<LatLng> list) {
        if (list == null || list.size() < 3) {
            Log.e("baidumapsdk", "PolygonHole's points can not be null or points's size can not be less than three");
            return this;
        }
        this.f3671a = list;
        return this;
    }

    public List<LatLng> getHolePoints() {
        return this.f3671a;
    }
}
