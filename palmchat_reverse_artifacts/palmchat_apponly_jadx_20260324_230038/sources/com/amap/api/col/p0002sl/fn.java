package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0002sl.ga;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.BusRouteResultV2;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResultV2;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.WalkRouteResultV2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fn implements IRouteSearchV2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RouteSearchV2.OnRouteSearchListener f2774a;
    private Context b;
    private Handler c;

    public fn(Context context) throws AMapException {
        gb gbVarA = ga.a(context, dh.a(false));
        if (gbVarA.f2821a != ga.c.SuccessCode) {
            String str = gbVarA.b;
            throw new AMapException(str, 1, str, gbVarA.f2821a.a());
        }
        this.b = context.getApplicationContext();
        this.c = dt.a();
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final BusRouteResultV2 calculateBusRoute(RouteSearchV2.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            dr.a(this.b);
            if (busRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!a(busRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            RouteSearchV2.BusRouteQuery busRouteQueryClone = busRouteQuery.m34clone();
            BusRouteResultV2 busRouteResultV2B = new dc(this.b, busRouteQueryClone).b();
            if (busRouteResultV2B != null) {
                busRouteResultV2B.setBusQuery(busRouteQueryClone);
            }
            return busRouteResultV2B;
        } catch (AMapException e) {
            di.a(e, "RouteSearch", "calculateBusRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateBusRouteAsyn(final RouteSearchV2.BusRouteQuery busRouteQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fn.4
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.what = 100;
                    messageObtainMessage.arg1 = 101;
                    Bundle bundle = new Bundle();
                    BusRouteResultV2 busRouteResultV2CalculateBusRoute = null;
                    try {
                        try {
                            busRouteResultV2CalculateBusRoute = fn.this.calculateBusRoute(busRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        messageObtainMessage.obj = fn.this.f2774a;
                        bundle.putParcelable("result", busRouteResultV2CalculateBusRoute);
                        messageObtainMessage.setData(bundle);
                        fn.this.c.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            di.a(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final DriveRouteResultV2 calculateDriveRoute(RouteSearchV2.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            dr.a(this.b);
            if (driveRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!a(driveRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            ek.a();
            ek.b(driveRouteQuery.getPassedByPoints());
            ek.a().c(driveRouteQuery.getAvoidpolygons());
            RouteSearchV2.DriveRouteQuery driveRouteQueryClone = driveRouteQuery.m35clone();
            DriveRouteResultV2 driveRouteResultV2B = new dn(this.b, driveRouteQueryClone).b();
            if (driveRouteResultV2B != null) {
                driveRouteResultV2B.setDriveQuery(driveRouteQueryClone);
            }
            return driveRouteResultV2B;
        } catch (AMapException e) {
            di.a(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateDriveRouteAsyn(final RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fn.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.what = 101;
                    messageObtainMessage.arg1 = 101;
                    Bundle bundle = new Bundle();
                    DriveRouteResultV2 driveRouteResultV2CalculateDriveRoute = null;
                    try {
                        try {
                            driveRouteResultV2CalculateDriveRoute = fn.this.calculateDriveRoute(driveRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        messageObtainMessage.obj = fn.this.f2774a;
                        bundle.putParcelable("result", driveRouteResultV2CalculateDriveRoute);
                        messageObtainMessage.setData(bundle);
                        fn.this.c.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            di.a(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final RideRouteResultV2 calculateRideRoute(RouteSearchV2.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            dr.a(this.b);
            if (rideRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!a(rideRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            ek.a().a(rideRouteQuery.getFromAndTo());
            RouteSearchV2.RideRouteQuery rideRouteQueryClone = rideRouteQuery.m37clone();
            RideRouteResultV2 rideRouteResultV2B = new en(this.b, rideRouteQueryClone).b();
            if (rideRouteResultV2B != null) {
                rideRouteResultV2B.setRideQuery(rideRouteQueryClone);
            }
            return rideRouteResultV2B;
        } catch (AMapException e) {
            di.a(e, "RouteSearch", "calculaterideRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateRideRouteAsyn(final RouteSearchV2.RideRouteQuery rideRouteQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fn.3
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.what = 103;
                    messageObtainMessage.arg1 = 101;
                    Bundle bundle = new Bundle();
                    RideRouteResultV2 rideRouteResultV2CalculateRideRoute = null;
                    try {
                        try {
                            rideRouteResultV2CalculateRideRoute = fn.this.calculateRideRoute(rideRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        messageObtainMessage.obj = fn.this.f2774a;
                        bundle.putParcelable("result", rideRouteResultV2CalculateRideRoute);
                        messageObtainMessage.setData(bundle);
                        fn.this.c.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            di.a(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final WalkRouteResultV2 calculateWalkRoute(RouteSearchV2.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            dr.a(this.b);
            if (walkRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!a(walkRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            ek.a().b(walkRouteQuery.getFromAndTo());
            RouteSearchV2.WalkRouteQuery walkRouteQueryClone = walkRouteQuery.m38clone();
            WalkRouteResultV2 walkRouteResultV2B = new ev(this.b, walkRouteQueryClone).b();
            if (walkRouteResultV2B != null) {
                walkRouteResultV2B.setWalkQuery(walkRouteQueryClone);
            }
            return walkRouteResultV2B;
        } catch (AMapException e) {
            di.a(e, "RouteSearch", "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void calculateWalkRouteAsyn(final RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fn.2
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.what = 102;
                    messageObtainMessage.arg1 = 101;
                    Bundle bundle = new Bundle();
                    WalkRouteResultV2 walkRouteResultV2CalculateWalkRoute = null;
                    try {
                        try {
                            walkRouteResultV2CalculateWalkRoute = fn.this.calculateWalkRoute(walkRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        messageObtainMessage.obj = fn.this.f2774a;
                        bundle.putParcelable("result", walkRouteResultV2CalculateWalkRoute);
                        messageObtainMessage.setData(bundle);
                        fn.this.c.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            di.a(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearchV2
    public final void setRouteSearchListener(RouteSearchV2.OnRouteSearchListener onRouteSearchListener) {
        this.f2774a = onRouteSearchListener;
    }

    private static boolean a(RouteSearchV2.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }
}
