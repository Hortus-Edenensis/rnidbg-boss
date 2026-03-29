package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.col.p0002sl.ct;
import com.amap.api.interfaces.IPolyline;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class Polyline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IPolyline f3109a;

    public Polyline(IPolyline iPolyline) {
        this.f3109a = iPolyline;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            IPolyline iPolyline = this.f3109a;
            if (iPolyline == null) {
                return false;
            }
            return iPolyline.equalsRemote(((Polyline) obj).f3109a);
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "equals");
            throw new RuntimeRemoteException(e);
        }
    }

    public int getColor() {
        try {
            IPolyline iPolyline = this.f3109a;
            if (iPolyline == null) {
                return 0;
            }
            return iPolyline.getColor();
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "getColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            IPolyline iPolyline = this.f3109a;
            return iPolyline == null ? "" : iPolyline.getId();
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "getId");
            throw new RuntimeRemoteException(e);
        }
    }

    public List<LatLng> getPoints() {
        try {
            IPolyline iPolyline = this.f3109a;
            if (iPolyline == null) {
                return null;
            }
            return iPolyline.getPoints();
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "getPoints");
            throw new RuntimeRemoteException(e);
        }
    }

    public float getWidth() {
        try {
            IPolyline iPolyline = this.f3109a;
            if (iPolyline == null) {
                return 0.0f;
            }
            return iPolyline.getWidth();
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "getWidth");
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            IPolyline iPolyline = this.f3109a;
            if (iPolyline == null) {
                return 0.0f;
            }
            return iPolyline.getZIndex();
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "getZIndex");
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            IPolyline iPolyline = this.f3109a;
            if (iPolyline == null) {
                return 0;
            }
            return iPolyline.hashCodeRemote();
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "hashCode");
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isDottedLine() {
        IPolyline iPolyline = this.f3109a;
        if (iPolyline == null) {
            return false;
        }
        return iPolyline.isDottedLine();
    }

    public boolean isGeodesic() {
        IPolyline iPolyline = this.f3109a;
        if (iPolyline == null) {
            return false;
        }
        return iPolyline.isGeodesic();
    }

    public boolean isVisible() {
        try {
            IPolyline iPolyline = this.f3109a;
            if (iPolyline == null) {
                return false;
            }
            return iPolyline.isVisible();
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "isVisible");
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            IPolyline iPolyline = this.f3109a;
            if (iPolyline == null) {
                return;
            }
            iPolyline.remove();
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "remove");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setColor(int i) {
        try {
            IPolyline iPolyline = this.f3109a;
            if (iPolyline == null) {
                return;
            }
            iPolyline.setColor(i);
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "setColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setDottedLine(boolean z) {
        IPolyline iPolyline = this.f3109a;
        if (iPolyline == null) {
            return;
        }
        iPolyline.setDottedLine(z);
    }

    public void setGeodesic(boolean z) {
        try {
            IPolyline iPolyline = this.f3109a;
            if (iPolyline == null || iPolyline.isGeodesic() == z) {
                return;
            }
            List<LatLng> points = getPoints();
            this.f3109a.setGeodesic(z);
            setPoints(points);
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "setGeodesic");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            IPolyline iPolyline = this.f3109a;
            if (iPolyline == null) {
                return;
            }
            iPolyline.setPoints(list);
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "setPoints");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            IPolyline iPolyline = this.f3109a;
            if (iPolyline == null) {
                return;
            }
            iPolyline.setVisible(z);
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "setVisible");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setWidth(float f) {
        try {
            IPolyline iPolyline = this.f3109a;
            if (iPolyline == null) {
                return;
            }
            iPolyline.setWidth(f);
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "setWidth");
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            IPolyline iPolyline = this.f3109a;
            if (iPolyline == null) {
                return;
            }
            iPolyline.setZIndex(f);
        } catch (RemoteException e) {
            ct.a(e, "Polyline", "setZIndex");
            throw new RuntimeRemoteException(e);
        }
    }
}
