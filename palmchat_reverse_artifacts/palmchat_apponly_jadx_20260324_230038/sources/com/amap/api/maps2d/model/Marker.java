package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.col.p0002sl.ct;
import com.amap.api.interfaces.IMarker;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Marker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    IMarker f3101a;

    public Marker(MarkerOptions markerOptions) {
    }

    public final void destroy() {
        try {
            IMarker iMarker = this.f3101a;
            if (iMarker != null) {
                iMarker.destroy();
            }
        } catch (Exception e) {
            ct.a(e, "Marker", "destroy");
        }
    }

    public final boolean equals(Object obj) {
        IMarker iMarker;
        if ((obj instanceof Marker) && (iMarker = this.f3101a) != null) {
            return iMarker.equalsRemote(((Marker) obj).f3101a);
        }
        return false;
    }

    public final ArrayList<BitmapDescriptor> getIcons() {
        try {
            return this.f3101a.getIcons();
        } catch (RemoteException e) {
            ct.a(e, "Marker", "getIcons");
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getId() {
        IMarker iMarker = this.f3101a;
        if (iMarker == null) {
            return null;
        }
        return iMarker.getId();
    }

    public final Object getObject() {
        IMarker iMarker = this.f3101a;
        if (iMarker != null) {
            return iMarker.getObject();
        }
        return null;
    }

    public final int getPeriod() {
        try {
            return this.f3101a.getPeriod();
        } catch (RemoteException e) {
            ct.a(e, "Marker", "getPeriod");
            throw new RuntimeRemoteException(e);
        }
    }

    public final LatLng getPosition() {
        IMarker iMarker = this.f3101a;
        if (iMarker == null) {
            return null;
        }
        return iMarker.getPosition();
    }

    public final String getSnippet() {
        IMarker iMarker = this.f3101a;
        if (iMarker == null) {
            return null;
        }
        return iMarker.getSnippet();
    }

    public final String getTitle() {
        IMarker iMarker = this.f3101a;
        if (iMarker == null) {
            return null;
        }
        return iMarker.getTitle();
    }

    public final float getZIndex() {
        IMarker iMarker = this.f3101a;
        if (iMarker == null) {
            return 0.0f;
        }
        return iMarker.getZIndex();
    }

    public final int hashCode() {
        IMarker iMarker = this.f3101a;
        return iMarker == null ? super.hashCode() : iMarker.hashCodeRemote();
    }

    public final void hideInfoWindow() {
        IMarker iMarker = this.f3101a;
        if (iMarker != null) {
            iMarker.hideInfoWindow();
        }
    }

    public final boolean isDraggable() {
        IMarker iMarker = this.f3101a;
        if (iMarker == null) {
            return false;
        }
        return iMarker.isDraggable();
    }

    public final boolean isInfoWindowShown() {
        IMarker iMarker = this.f3101a;
        if (iMarker == null) {
            return false;
        }
        return iMarker.isInfoWindowShown();
    }

    public final boolean isVisible() {
        IMarker iMarker = this.f3101a;
        if (iMarker == null) {
            return false;
        }
        return iMarker.isVisible();
    }

    public final void remove() {
        try {
            IMarker iMarker = this.f3101a;
            if (iMarker != null) {
                iMarker.remove();
            }
        } catch (Exception e) {
            ct.a(e, "Marker", "remove");
        }
    }

    public final void setAnchor(float f, float f2) {
        IMarker iMarker = this.f3101a;
        if (iMarker != null) {
            iMarker.setAnchor(f, f2);
        }
    }

    public final void setDraggable(boolean z) {
        IMarker iMarker = this.f3101a;
        if (iMarker != null) {
            iMarker.setDraggable(z);
        }
    }

    public final void setIcon(BitmapDescriptor bitmapDescriptor) {
        IMarker iMarker = this.f3101a;
        if (iMarker == null || bitmapDescriptor == null) {
            return;
        }
        iMarker.setIcon(bitmapDescriptor);
    }

    public final void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        try {
            this.f3101a.setIcons(arrayList);
        } catch (RemoteException e) {
            ct.a(e, "Marker", "setIcons");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setObject(Object obj) {
        IMarker iMarker = this.f3101a;
        if (iMarker != null) {
            iMarker.setObject(obj);
        }
    }

    public final void setPeriod(int i) {
        try {
            IMarker iMarker = this.f3101a;
            if (iMarker != null) {
                iMarker.setPeriod(i);
            }
        } catch (RemoteException e) {
            ct.a(e, "Marker", "setPeriod");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setPosition(LatLng latLng) {
        IMarker iMarker = this.f3101a;
        if (iMarker != null) {
            iMarker.setPosition(latLng);
        }
    }

    public final void setPositionByPixels(int i, int i2) {
        try {
            IMarker iMarker = this.f3101a;
            if (iMarker != null) {
                iMarker.setPositionByPixels(i, i2);
            }
        } catch (RemoteException e) {
            ct.a(e, "Marker", "setPositionByPixels");
            e.printStackTrace();
        }
    }

    public final void setRotateAngle(float f) {
        try {
            this.f3101a.setRotateAngle(f);
        } catch (RemoteException e) {
            ct.a(e, "Marker", "setRotateAngle");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setSnippet(String str) {
        IMarker iMarker = this.f3101a;
        if (iMarker != null) {
            iMarker.setSnippet(str);
        }
    }

    public final void setTitle(String str) {
        IMarker iMarker = this.f3101a;
        if (iMarker != null) {
            iMarker.setTitle(str);
        }
    }

    public final void setVisible(boolean z) {
        IMarker iMarker = this.f3101a;
        if (iMarker != null) {
            iMarker.setVisible(z);
        }
    }

    public final void setZIndex(float f) {
        IMarker iMarker = this.f3101a;
        if (iMarker != null) {
            iMarker.setZIndex(f);
        }
    }

    public final void showInfoWindow() {
        IMarker iMarker = this.f3101a;
        if (iMarker != null) {
            iMarker.showInfoWindow();
        }
    }

    public Marker(IMarker iMarker) {
        this.f3101a = iMarker;
    }
}
