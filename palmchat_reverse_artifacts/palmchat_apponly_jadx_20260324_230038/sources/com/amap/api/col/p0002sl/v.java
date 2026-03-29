package com.amap.api.col.p0002sl;

import android.graphics.Point;
import com.amap.api.interfaces.MapCameraMessage;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class v extends MapCameraMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3050a;
    private float b;
    private an c;

    private v() {
    }

    public static v a() {
        return new v();
    }

    public static v b() {
        v vVarA = a();
        vVarA.nowType = MapCameraMessage.Type.zoomIn;
        return vVarA;
    }

    public static v c() {
        v vVarA = a();
        vVarA.nowType = MapCameraMessage.Type.zoomOut;
        return vVarA;
    }

    public static v a(float f, float f2) {
        v vVarA = a();
        vVarA.nowType = MapCameraMessage.Type.scrollBy;
        vVarA.xPixel = f;
        vVarA.yPixel = f2;
        return vVarA;
    }

    public static v b(float f) {
        return a(f, (Point) null);
    }

    public static v b(LatLng latLng) {
        return a(CameraPosition.builder().target(latLng).build());
    }

    public static v a(float f) {
        v vVarA = a();
        vVarA.nowType = MapCameraMessage.Type.zoomTo;
        vVarA.zoom = f;
        return vVarA;
    }

    public static v a(float f, Point point) {
        v vVarA = a();
        vVarA.nowType = MapCameraMessage.Type.zoomBy;
        vVarA.amount = f;
        vVarA.focus = point;
        return vVarA;
    }

    public static v a(CameraPosition cameraPosition) {
        v vVarA = a();
        vVarA.nowType = MapCameraMessage.Type.newCameraPosition;
        vVarA.cameraPosition = cameraPosition;
        return vVarA;
    }

    public static v a(LatLng latLng) {
        v vVarA = a();
        vVarA.nowType = MapCameraMessage.Type.changeCenter;
        vVarA.cameraPosition = new CameraPosition(latLng, 0.0f, 0.0f, 0.0f);
        return vVarA;
    }

    public static v a(LatLng latLng, float f) {
        return a(CameraPosition.builder().target(latLng).zoom(f).build());
    }

    public static v a(LatLng latLng, float f, float f2, float f3) {
        return a(CameraPosition.builder().target(latLng).zoom(f).bearing(f2).tilt(f3).build());
    }

    public static v a(an anVar, float f, float f2, float f3) {
        v vVarA = a();
        vVarA.nowType = MapCameraMessage.Type.changeGeoCenterZoomTiltBearing;
        vVarA.c = anVar;
        vVarA.zoom = f;
        vVarA.b = f2;
        vVarA.f3050a = f3;
        return vVarA;
    }

    public static v a(LatLngBounds latLngBounds, int i) {
        v vVarA = a();
        vVarA.nowType = MapCameraMessage.Type.newLatLngBounds;
        vVarA.bounds = latLngBounds;
        vVarA.paddingLeft = i;
        vVarA.paddingRight = i;
        vVarA.paddingTop = i;
        vVarA.paddingBottom = i;
        return vVarA;
    }

    public static v a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        v vVarA = a();
        vVarA.nowType = MapCameraMessage.Type.newLatLngBoundsWithSize;
        vVarA.bounds = latLngBounds;
        vVarA.paddingLeft = i3;
        vVarA.paddingRight = i3;
        vVarA.paddingTop = i3;
        vVarA.paddingBottom = i3;
        vVarA.width = i;
        vVarA.height = i2;
        return vVarA;
    }

    public static MapCameraMessage a(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        v vVarA = a();
        vVarA.nowType = MapCameraMessage.Type.newLatLngBounds;
        vVarA.bounds = latLngBounds;
        vVarA.paddingLeft = i;
        vVarA.paddingRight = i2;
        vVarA.paddingTop = i3;
        vVarA.paddingBottom = i4;
        return vVarA;
    }
}
