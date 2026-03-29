package com.amap.api.maps2d;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.col.p0002sl.ct;
import com.amap.api.interfaces.IProjection;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.RuntimeRemoteException;
import com.amap.api.maps2d.model.VisibleRegion;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class Projection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IProjection f3089a;

    public Projection(IProjection iProjection) {
        this.f3089a = iProjection;
    }

    public LatLng fromScreenLocation(Point point) {
        try {
            return this.f3089a.fromScreenLocation(point);
        } catch (RemoteException e) {
            ct.a(e, "Projection", "fromScreenLocation");
            throw new RuntimeRemoteException(e);
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            return this.f3089a.getVisibleRegion();
        } catch (RemoteException e) {
            ct.a(e, "Projection", "getVisibleRegion");
            throw new RuntimeRemoteException(e);
        }
    }

    public PointF toMapLocation(LatLng latLng) {
        try {
            return this.f3089a.toMapLocation(latLng);
        } catch (RemoteException e) {
            ct.a(e, "Projection", "toMapLocation");
            throw new RuntimeRemoteException(e);
        }
    }

    public Point toScreenLocation(LatLng latLng) {
        try {
            return this.f3089a.toScreenLocation(latLng);
        } catch (RemoteException e) {
            ct.a(e, "Projection", "toScreenLocation");
            throw new RuntimeRemoteException(e);
        }
    }
}
