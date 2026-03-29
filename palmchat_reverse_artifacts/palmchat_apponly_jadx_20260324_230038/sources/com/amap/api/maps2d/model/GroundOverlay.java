package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.col.p0002sl.aj;
import com.amap.api.col.p0002sl.ct;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class GroundOverlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private aj f3096a;

    public GroundOverlay(aj ajVar) {
        this.f3096a = ajVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            throw new RemoteException();
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "equals");
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getBearing() {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return 0.0f;
            }
            return ajVar.getBearing();
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "getBearing");
            throw new RuntimeRemoteException(e);
        }
    }

    public final LatLngBounds getBounds() {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return null;
            }
            return ajVar.getBounds();
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "getBounds");
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getHeight() {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return 0.0f;
            }
            return ajVar.getHeight();
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "getHeight");
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getId() {
        try {
            aj ajVar = this.f3096a;
            return ajVar == null ? "" : ajVar.getId();
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "getId");
            throw new RuntimeRemoteException(e);
        }
    }

    public final LatLng getPosition() {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return null;
            }
            return ajVar.getPosition();
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "getPosition");
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getTransparency() {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return 0.0f;
            }
            return ajVar.getTransparency();
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "getTransparency");
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getWidth() {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return 0.0f;
            }
            return ajVar.getWidth();
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "getWidth");
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getZIndex() {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return 0.0f;
            }
            return ajVar.getZIndex();
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "getZIndex");
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        aj ajVar = this.f3096a;
        if (ajVar == null) {
            return 0;
        }
        return ajVar.hashCode();
    }

    public final boolean isVisible() {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return false;
            }
            return ajVar.isVisible();
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "isVisible");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void remove() {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return;
            }
            ajVar.remove();
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "remove");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBearing(float f) {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return;
            }
            ajVar.setBearing(f);
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "setBearing");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setDimensions(float f) {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return;
            }
            ajVar.setDimensions(f);
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "setDimensions");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setImage(BitmapDescriptor bitmapDescriptor) {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return;
            }
            ajVar.setImage(bitmapDescriptor);
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "setImage");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setPosition(LatLng latLng) {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return;
            }
            ajVar.setPosition(latLng);
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "setPosition");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setPositionFromBounds(LatLngBounds latLngBounds) {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return;
            }
            ajVar.setPositionFromBounds(latLngBounds);
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "setPositionFromBounds");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTransparency(float f) {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return;
            }
            ajVar.setTransparency(f);
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "setTransparency");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setVisible(boolean z) {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return;
            }
            ajVar.setVisible(z);
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "setVisible");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setZIndex(float f) {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return;
            }
            ajVar.setZIndex(f);
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "setZIndex");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setDimensions(float f, float f2) {
        try {
            aj ajVar = this.f3096a;
            if (ajVar == null) {
                return;
            }
            ajVar.setDimensions(f, f2);
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlay", "setDimensions");
            throw new RuntimeRemoteException(e);
        }
    }
}
