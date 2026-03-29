package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p0002sl.ga;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fm implements IRouteSearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RouteSearch.OnRouteSearchListener f2767a;
    private RouteSearch.OnTruckRouteSearchListener b;
    private RouteSearch.OnRoutePlanSearchListener c;
    private Context d;
    private Handler e;

    public fm(Context context) throws AMapException {
        gb gbVarA = ga.a(context, dh.a(false));
        if (gbVarA.f2821a != ga.c.SuccessCode) {
            String str = gbVarA.b;
            throw new AMapException(str, 1, str, gbVarA.f2821a.a());
        }
        this.d = context.getApplicationContext();
        this.e = dt.a();
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            dr.a(this.d);
            if (busRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!a(busRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            RouteSearch.BusRouteQuery busRouteQueryClone = busRouteQuery.m27clone();
            BusRouteResult busRouteResultB = new db(this.d, busRouteQueryClone).b();
            if (busRouteResultB != null) {
                busRouteResultB.setBusQuery(busRouteQueryClone);
            }
            return busRouteResultB;
        } catch (AMapException e) {
            di.a(e, "RouteSearch", "calculateBusRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateBusRouteAsyn(final RouteSearch.BusRouteQuery busRouteQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fm.2
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.what = 100;
                    messageObtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    BusRouteResult busRouteResultCalculateBusRoute = null;
                    try {
                        try {
                            busRouteResultCalculateBusRoute = fm.this.calculateBusRoute(busRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        messageObtainMessage.obj = fm.this.f2767a;
                        bundle.putParcelable("result", busRouteResultCalculateBusRoute);
                        messageObtainMessage.setData(bundle);
                        fm.this.e.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            di.a(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRoutePlanResult calculateDrivePlan(RouteSearch.DrivePlanQuery drivePlanQuery) throws AMapException {
        try {
            dr.a(this.d);
            if (drivePlanQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!a(drivePlanQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            DriveRoutePlanResult driveRoutePlanResultB = new dl(this.d, drivePlanQuery.m28clone()).b();
            if (driveRoutePlanResultB != null) {
                driveRoutePlanResultB.setDrivePlanQuery(drivePlanQuery);
            }
            return driveRoutePlanResultB;
        } catch (AMapException e) {
            di.a(e, "RouteSearch", "calculateDrivePlan");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDrivePlanAsyn(final RouteSearch.DrivePlanQuery drivePlanQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fm.6
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.what = 105;
                    messageObtainMessage.arg1 = 18;
                    Bundle bundle = new Bundle();
                    DriveRoutePlanResult driveRoutePlanResultCalculateDrivePlan = null;
                    try {
                        try {
                            driveRoutePlanResultCalculateDrivePlan = fm.this.calculateDrivePlan(drivePlanQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        messageObtainMessage.obj = fm.this.c;
                        bundle.putParcelable("result", driveRoutePlanResultCalculateDrivePlan);
                        messageObtainMessage.setData(bundle);
                        fm.this.e.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            di.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            dr.a(this.d);
            if (driveRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!a(driveRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            ek.a().a(driveRouteQuery.getPassedByPoints());
            ek.a().c(driveRouteQuery.getAvoidpolygons());
            RouteSearch.DriveRouteQuery driveRouteQueryClone = driveRouteQuery.m29clone();
            DriveRouteResult driveRouteResultB = new dm(this.d, driveRouteQueryClone).b();
            if (driveRouteResultB != null) {
                driveRouteResultB.setDriveQuery(driveRouteQueryClone);
            }
            return driveRouteResultB;
        } catch (AMapException e) {
            di.a(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateDriveRouteAsyn(final RouteSearch.DriveRouteQuery driveRouteQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fm.3
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.what = 101;
                    messageObtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    DriveRouteResult driveRouteResultCalculateDriveRoute = null;
                    try {
                        try {
                            driveRouteResultCalculateDriveRoute = fm.this.calculateDriveRoute(driveRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        messageObtainMessage.obj = fm.this.f2767a;
                        bundle.putParcelable("result", driveRouteResultCalculateDriveRoute);
                        messageObtainMessage.setData(bundle);
                        fm.this.e.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            di.a(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            dr.a(this.d);
            if (rideRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!a(rideRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            ek.a().a(rideRouteQuery.getFromAndTo());
            RouteSearch.RideRouteQuery rideRouteQueryClone = rideRouteQuery.m31clone();
            RideRouteResult rideRouteResultB = new em(this.d, rideRouteQueryClone).b();
            if (rideRouteResultB != null) {
                rideRouteResultB.setRideQuery(rideRouteQueryClone);
            }
            return rideRouteResultB;
        } catch (AMapException e) {
            di.a(e, "RouteSearch", "calculaterideRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateRideRouteAsyn(final RouteSearch.RideRouteQuery rideRouteQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fm.4
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.what = 103;
                    messageObtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    RideRouteResult rideRouteResultCalculateRideRoute = null;
                    try {
                        try {
                            rideRouteResultCalculateRideRoute = fm.this.calculateRideRoute(rideRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        messageObtainMessage.obj = fm.this.f2767a;
                        bundle.putParcelable("result", rideRouteResultCalculateRideRoute);
                        messageObtainMessage.setData(bundle);
                        fm.this.e.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            di.a(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final TruckRouteRestult calculateTruckRoute(RouteSearch.TruckRouteQuery truckRouteQuery) throws AMapException {
        try {
            dr.a(this.d);
            if (truckRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!a(truckRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            ek.a().a(truckRouteQuery.getFromAndTo(), truckRouteQuery.getPassedByPoints());
            ek.a();
            ek.b(truckRouteQuery.getPassedByPoints());
            RouteSearch.TruckRouteQuery truckRouteQueryClone = truckRouteQuery.m32clone();
            TruckRouteRestult truckRouteRestultB = new et(this.d, truckRouteQueryClone).b();
            if (truckRouteRestultB != null) {
                truckRouteRestultB.setTruckQuery(truckRouteQueryClone);
            }
            return truckRouteRestultB;
        } catch (AMapException e) {
            di.a(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateTruckRouteAsyn(final RouteSearch.TruckRouteQuery truckRouteQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fm.5
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.what = 104;
                    messageObtainMessage.arg1 = 17;
                    Bundle bundle = new Bundle();
                    TruckRouteRestult truckRouteRestultCalculateTruckRoute = null;
                    try {
                        try {
                            truckRouteRestultCalculateTruckRoute = fm.this.calculateTruckRoute(truckRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        messageObtainMessage.obj = fm.this.b;
                        bundle.putParcelable("result", truckRouteRestultCalculateTruckRoute);
                        messageObtainMessage.setData(bundle);
                        fm.this.e.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            di.a(th, "RouteSearch", "calculateTruckRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            dr.a(this.d);
            if (walkRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!a(walkRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            ek.a().b(walkRouteQuery.getFromAndTo());
            RouteSearch.WalkRouteQuery walkRouteQueryClone = walkRouteQuery.m33clone();
            WalkRouteResult walkRouteResultB = new eu(this.d, walkRouteQueryClone).b();
            if (walkRouteResultB != null) {
                walkRouteResultB.setWalkQuery(walkRouteQueryClone);
            }
            return walkRouteResultB;
        } catch (AMapException e) {
            di.a(e, "RouteSearch", "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void calculateWalkRouteAsyn(final RouteSearch.WalkRouteQuery walkRouteQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fm.1
                @Override // java.lang.Runnable
                public final void run() {
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.what = 102;
                    messageObtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    WalkRouteResult walkRouteResultCalculateWalkRoute = null;
                    try {
                        try {
                            walkRouteResultCalculateWalkRoute = fm.this.calculateWalkRoute(walkRouteQuery);
                            bundle.putInt("errorCode", 1000);
                        } catch (AMapException e) {
                            bundle.putInt("errorCode", e.getErrorCode());
                        }
                    } finally {
                        messageObtainMessage.obj = fm.this.f2767a;
                        bundle.putParcelable("result", walkRouteResultCalculateWalkRoute);
                        messageObtainMessage.setData(bundle);
                        fm.this.e.sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            di.a(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnRoutePlanSearchListener(RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener) {
        this.c = onRoutePlanSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setOnTruckRouteSearchListener(RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener) {
        this.b = onTruckRouteSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IRouteSearch
    public final void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.f2767a = onRouteSearchListener;
    }

    private static boolean a(RouteSearch.FromAndTo fromAndTo) {
        return (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) ? false : true;
    }
}
