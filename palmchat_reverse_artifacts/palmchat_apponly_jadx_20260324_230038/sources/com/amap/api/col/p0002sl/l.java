package com.amap.api.col.p0002sl;

import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.interfaces.MapCameraMessage;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f2953a;
    private int b;

    public l(m mVar) {
        this.f2953a = mVar;
    }

    public final void a(MapCameraMessage mapCameraMessage) throws RemoteException {
        try {
            m mVar = this.f2953a;
            if (mVar != null && mVar.g() != null) {
                float zoomLevel = this.f2953a.getZoomLevel();
                MapCameraMessage.Type type = mapCameraMessage.nowType;
                if (type == MapCameraMessage.Type.scrollBy) {
                    az azVar = this.f2953a.b;
                    if (azVar != null) {
                        azVar.b((int) mapCameraMessage.xPixel, (int) mapCameraMessage.yPixel);
                    }
                    this.f2953a.postInvalidate();
                } else if (type == MapCameraMessage.Type.zoomIn) {
                    this.f2953a.g().a(true);
                } else if (type == MapCameraMessage.Type.zoomOut) {
                    this.f2953a.g().a(false);
                } else if (type == MapCameraMessage.Type.zoomTo) {
                    this.f2953a.g().a(mapCameraMessage.zoom);
                } else if (type == MapCameraMessage.Type.zoomBy) {
                    float fA = this.f2953a.a(mapCameraMessage.amount + zoomLevel);
                    Point point = mapCameraMessage.focus;
                    float f = fA - zoomLevel;
                    if (point != null) {
                        this.f2953a.a(f, point, false, 0L);
                    } else {
                        this.f2953a.g().a(fA);
                    }
                } else if (type == MapCameraMessage.Type.newCameraPosition) {
                    CameraPosition cameraPosition = mapCameraMessage.cameraPosition;
                    if (cameraPosition != null) {
                        LatLng latLng = cameraPosition.target;
                        this.f2953a.g().a(new af((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d)), cameraPosition.zoom);
                    }
                } else if (type == MapCameraMessage.Type.changeCenter) {
                    LatLng latLng2 = mapCameraMessage.cameraPosition.target;
                    this.f2953a.g().a(new af((int) (latLng2.latitude * 1000000.0d), (int) (latLng2.longitude * 1000000.0d)));
                } else if (type == MapCameraMessage.Type.newLatLngBounds || type == MapCameraMessage.Type.newLatLngBoundsWithSize) {
                    this.f2953a.a(mapCameraMessage, false, -1L);
                } else {
                    mapCameraMessage.isChangeFinished = true;
                }
                if (zoomLevel != this.b && this.f2953a.b().isScaleControlsEnabled()) {
                    this.f2953a.n();
                }
                u.a().b();
            }
        } catch (Exception e) {
            ct.a(e, "AMapCallback", "runCameraUpdate");
        }
    }
}
