package com.amap.api.maps2d.model;

import com.amap.api.interfaces.ITileOverlay;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class TileOverlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ITileOverlay f3115a;

    public TileOverlay(ITileOverlay iTileOverlay) {
        this.f3115a = iTileOverlay;
    }

    public final void clearTileCache() {
        this.f3115a.clearTileCache();
    }

    public final boolean equals(Object obj) {
        ITileOverlay iTileOverlay = this.f3115a;
        return iTileOverlay.equalsRemote(iTileOverlay);
    }

    public final String getId() {
        return this.f3115a.getId();
    }

    public final float getZIndex() {
        return this.f3115a.getZIndex();
    }

    public final int hashCode() {
        return this.f3115a.hashCodeRemote();
    }

    public final boolean isVisible() {
        return this.f3115a.isVisible();
    }

    public final void remove() {
        this.f3115a.remove();
    }

    public final void setVisible(boolean z) {
        this.f3115a.setVisible(z);
    }

    public final void setZIndex(float f) {
        this.f3115a.setZIndex(f);
    }
}
