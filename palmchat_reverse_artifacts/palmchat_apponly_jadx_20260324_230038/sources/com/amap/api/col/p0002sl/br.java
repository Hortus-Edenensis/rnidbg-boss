package com.amap.api.col.p0002sl;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.VisibleRegion;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class br implements aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2657a = "ProjectionDelegateImp";
    private ah b;

    public br(ah ahVar) {
        this.b = ahVar;
    }

    @Override // com.amap.api.interfaces.IProjection
    public final LatLng fromScreenLocation(Point point) throws RemoteException {
        ab abVar = new ab();
        this.b.a(point.x, point.y, abVar);
        return new LatLng(abVar.b, abVar.f2610a);
    }

    @Override // com.amap.api.interfaces.IProjection
    public final VisibleRegion getVisibleRegion() throws RemoteException {
        LatLng latLngFromScreenLocation;
        LatLng latLngFromScreenLocation2;
        LatLng latLngFromScreenLocation3;
        LatLng latLngFromScreenLocation4;
        LatLngBounds latLngBoundsBuild = null;
        try {
            int mapWidth = this.b.getMapWidth();
            int mapHeight = this.b.getMapHeight();
            latLngFromScreenLocation2 = fromScreenLocation(new Point(0, 0));
            try {
                latLngFromScreenLocation4 = fromScreenLocation(new Point(mapWidth, 0));
                try {
                    latLngFromScreenLocation3 = fromScreenLocation(new Point(0, mapHeight));
                    try {
                        latLngFromScreenLocation = fromScreenLocation(new Point(mapWidth, mapHeight));
                        try {
                            latLngBoundsBuild = LatLngBounds.builder().include(latLngFromScreenLocation3).include(latLngFromScreenLocation).include(latLngFromScreenLocation2).include(latLngFromScreenLocation4).build();
                        } catch (Throwable th) {
                            th = th;
                            ct.a(th, this.f2657a, "getVisibleRegion");
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        latLngFromScreenLocation = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    latLngFromScreenLocation = null;
                    latLngFromScreenLocation3 = null;
                }
            } catch (Throwable th4) {
                th = th4;
                latLngFromScreenLocation = null;
                latLngFromScreenLocation3 = null;
                latLngFromScreenLocation4 = latLngFromScreenLocation3;
                ct.a(th, this.f2657a, "getVisibleRegion");
                return new VisibleRegion(latLngFromScreenLocation3, latLngFromScreenLocation, latLngFromScreenLocation2, latLngFromScreenLocation4, latLngBoundsBuild);
            }
        } catch (Throwable th5) {
            th = th5;
            latLngFromScreenLocation = null;
            latLngFromScreenLocation2 = null;
            latLngFromScreenLocation3 = null;
        }
        return new VisibleRegion(latLngFromScreenLocation3, latLngFromScreenLocation, latLngFromScreenLocation2, latLngFromScreenLocation4, latLngBoundsBuild);
    }

    @Override // com.amap.api.interfaces.IProjection
    public final PointF toMapLocation(LatLng latLng) throws RemoteException {
        ab abVar = new ab();
        this.b.a(latLng.latitude, latLng.longitude, abVar);
        return new PointF((float) abVar.f2610a, (float) abVar.b);
    }

    @Override // com.amap.api.interfaces.IProjection
    public final Point toScreenLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        an anVar = new an();
        this.b.b(latLng.latitude, latLng.longitude, anVar);
        return new Point(anVar.f2618a, anVar.b);
    }
}
