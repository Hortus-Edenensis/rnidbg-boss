package com.baidu.platform.core.route;

import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface IRoutePlanSearch {
    boolean bikingSearch(BikingRoutePlanOption bikingRoutePlanOption);

    void destroy();

    boolean drivingSearch(DrivingRoutePlanOption drivingRoutePlanOption);

    boolean masstransitSearch(MassTransitRoutePlanOption massTransitRoutePlanOption);

    void setOnGetRoutePlanResultListener(OnGetRoutePlanResultListener onGetRoutePlanResultListener);

    boolean transitSearch(TransitRoutePlanOption transitRoutePlanOption);

    boolean walkingIndoorSearch(IndoorRoutePlanOption indoorRoutePlanOption);

    boolean walkingIntegralSearch(WalkingRoutePlanOption walkingRoutePlanOption);

    boolean walkingSearch(WalkingRoutePlanOption walkingRoutePlanOption);
}
