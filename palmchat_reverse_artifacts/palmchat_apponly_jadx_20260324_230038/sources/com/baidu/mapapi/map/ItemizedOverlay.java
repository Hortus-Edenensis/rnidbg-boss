package com.baidu.mapapi.map;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ItemizedOverlay extends Overlay {
    MapView g;

    public ItemizedOverlay(Drawable drawable, MapView mapView) {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.marker;
        this.g = mapView;
    }

    public void addItem(OverlayOptions overlayOptions) {
        if (overlayOptions != null) {
            this.g.getMap().addOverlay(overlayOptions);
        }
    }

    public void removeAll() {
        this.g.getMap().clear();
    }

    public void reAddAll() {
    }
}
