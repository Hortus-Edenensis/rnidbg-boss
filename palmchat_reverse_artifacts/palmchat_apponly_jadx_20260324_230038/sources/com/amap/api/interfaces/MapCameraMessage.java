package com.amap.api.interfaces;

import android.graphics.Point;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLngBounds;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class MapCameraMessage {
    public float amount;
    public LatLngBounds bounds;
    public CameraPosition cameraPosition;
    public int height;
    public int paddingBottom;
    public int paddingLeft;
    public int paddingRight;
    public int paddingTop;
    public int width;
    public float xPixel;
    public float yPixel;
    public float zoom;
    public Type nowType = Type.none;
    public boolean isChangeFinished = false;
    public Point focus = null;

    /* JADX INFO: compiled from: SearchBox */
    public enum Type {
        none,
        zoomIn,
        changeCenter,
        changeGeoCenterZoom,
        zoomOut,
        zoomTo,
        zoomBy,
        scrollBy,
        newCameraPosition,
        newLatLngBounds,
        newLatLngBoundsWithSize,
        changeGeoCenterZoomTiltBearing
    }
}
