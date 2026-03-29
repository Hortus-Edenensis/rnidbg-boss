package com.amap.api.maps2d;

import android.graphics.Point;
import com.amap.api.col.p0002sl.v;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class CameraUpdateFactory {
    public static CameraUpdate changeLatLng(LatLng latLng) {
        return new CameraUpdate(v.a(latLng));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        return new CameraUpdate(v.a(cameraPosition));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        return new CameraUpdate(v.b(latLng));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        return new CameraUpdate(v.a(latLngBounds, i));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        return new CameraUpdate(v.a(latLng, f));
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        return new CameraUpdate(v.a(f, f2));
    }

    public static CameraUpdate zoomBy(float f) {
        return new CameraUpdate(v.b(f));
    }

    public static CameraUpdate zoomIn() {
        return new CameraUpdate(v.b());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(v.c());
    }

    public static CameraUpdate zoomTo(float f) {
        return new CameraUpdate(v.a(f));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        return new CameraUpdate(v.a(latLngBounds, i, i2, i3, i4));
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        return new CameraUpdate(v.a(f, point));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        return new CameraUpdate(v.a(latLngBounds, i, i2, i3));
    }
}
