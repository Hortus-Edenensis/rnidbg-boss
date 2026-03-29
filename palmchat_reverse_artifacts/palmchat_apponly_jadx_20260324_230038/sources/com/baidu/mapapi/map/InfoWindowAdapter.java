package com.baidu.mapapi.map;

import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface InfoWindowAdapter {
    InfoWindow getInfoWindow(Marker marker);

    View getInfoWindowView(Marker marker);

    int getInfoWindowViewYOffset();
}
