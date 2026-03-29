package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.col.p0002sl.ao;
import com.amap.api.col.p0002sl.ct;
import com.amap.api.interfaces.IPolygon;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Polygon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IPolygon f3107a;

    public Polygon(ao aoVar) {
        this.f3107a = aoVar;
    }

    public final boolean contains(LatLng latLng) {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return false;
            }
            return iPolygon.contains(latLng);
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "contains");
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Polygon)) {
            return false;
        }
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return false;
            }
            return iPolygon.equalsRemote(((Polygon) obj).f3107a);
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "equeals");
            return false;
        }
    }

    public final int getFillColor() {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return 0;
            }
            return iPolygon.getFillColor();
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "getFillColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getId() {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return null;
            }
            return iPolygon.getId();
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "getId");
            throw new RuntimeRemoteException(e);
        }
    }

    public final List<LatLng> getPoints() {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return null;
            }
            return iPolygon.getPoints();
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "getPoints");
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getStrokeColor() {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return 0;
            }
            return iPolygon.getStrokeColor();
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "getStrokeColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getStrokeWidth() {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return 0.0f;
            }
            return iPolygon.getStrokeWidth();
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "getStrokeWidth");
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getZIndex() {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return 0.0f;
            }
            return iPolygon.getZIndex();
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "getZIndex");
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return 0;
            }
            return iPolygon.hashCodeRemote();
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "hashCode");
            return super.hashCode();
        }
    }

    public final boolean isVisible() {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return true;
            }
            return iPolygon.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void remove() {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return;
            }
            iPolygon.remove();
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "remove");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setFillColor(int i) {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return;
            }
            iPolygon.setFillColor(i);
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "setFillColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setPoints(List<LatLng> list) {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return;
            }
            iPolygon.setPoints(list);
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "setPoints");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setStrokeColor(int i) {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return;
            }
            iPolygon.setStrokeColor(i);
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "setStrokeColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setStrokeWidth(float f) {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return;
            }
            iPolygon.setStrokeWidth(f);
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "setStrokeWidth");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setVisible(boolean z) {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return;
            }
            iPolygon.setVisible(z);
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "setVisible");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setZIndex(float f) {
        try {
            IPolygon iPolygon = this.f3107a;
            if (iPolygon == null) {
                return;
            }
            iPolygon.setZIndex(f);
        } catch (RemoteException e) {
            ct.a(e, "Polygon", "setZIndex");
            throw new RuntimeRemoteException(e);
        }
    }
}
