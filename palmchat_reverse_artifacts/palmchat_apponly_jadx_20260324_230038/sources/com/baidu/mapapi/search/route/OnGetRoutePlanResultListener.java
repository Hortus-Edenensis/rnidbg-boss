package com.baidu.mapapi.search.route;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface OnGetRoutePlanResultListener {
    void onGetBikingRouteResult(BikingRouteResult bikingRouteResult);

    void onGetDrivingRouteResult(DrivingRouteResult drivingRouteResult);

    void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult);

    void onGetIntegralRouteResult(IntegralRouteResult integralRouteResult);

    void onGetMassTransitRouteResult(MassTransitRouteResult massTransitRouteResult);

    void onGetTransitRouteResult(TransitRouteResult transitRouteResult);

    void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult);
}
