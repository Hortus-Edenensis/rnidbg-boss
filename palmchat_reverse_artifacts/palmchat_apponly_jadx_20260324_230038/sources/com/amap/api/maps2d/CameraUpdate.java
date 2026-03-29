package com.amap.api.maps2d;

import com.amap.api.interfaces.MapCameraMessage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class CameraUpdate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MapCameraMessage f3082a;

    public CameraUpdate(MapCameraMessage mapCameraMessage) {
        this.f3082a = mapCameraMessage;
    }

    public final MapCameraMessage getCameraUpdateFactoryDelegate() {
        return this.f3082a;
    }
}
