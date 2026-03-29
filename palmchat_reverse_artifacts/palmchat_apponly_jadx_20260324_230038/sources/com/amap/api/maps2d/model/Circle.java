package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.col.p0002sl.ct;
import com.amap.api.interfaces.ICircle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Circle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ICircle f3094a;

    public Circle(ICircle iCircle) {
        this.f3094a = iCircle;
    }

    public final boolean contains(LatLng latLng) {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle != null && latLng != null) {
                return iCircle.contains(latLng);
            }
            return false;
        } catch (RemoteException e) {
            ct.a(e, "Circle", "contains");
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return false;
            }
            return iCircle.equalsRemote(((Circle) obj).f3094a);
        } catch (RemoteException e) {
            ct.a(e, "Circle", "equals");
            throw new RuntimeRemoteException(e);
        }
    }

    public final LatLng getCenter() {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return null;
            }
            return iCircle.getCenter();
        } catch (RemoteException e) {
            ct.a(e, "Circle", "getCenter");
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getFillColor() {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return 0;
            }
            return iCircle.getFillColor();
        } catch (RemoteException e) {
            ct.a(e, "Circle", "getFillColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getId() {
        try {
            ICircle iCircle = this.f3094a;
            return iCircle == null ? "" : iCircle.getId();
        } catch (RemoteException e) {
            ct.a(e, "Circle", "getId");
            throw new RuntimeRemoteException(e);
        }
    }

    public final double getRadius() {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return 0.0d;
            }
            return iCircle.getRadius();
        } catch (RemoteException e) {
            ct.a(e, "Circle", "getRadius");
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getStrokeColor() {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return 0;
            }
            return iCircle.getStrokeColor();
        } catch (RemoteException e) {
            ct.a(e, "Circle", "getStrokeColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getStrokeWidth() {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return 0.0f;
            }
            return iCircle.getStrokeWidth();
        } catch (RemoteException e) {
            ct.a(e, "Circle", "getStrokeWidth");
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getZIndex() {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return 0.0f;
            }
            return iCircle.getZIndex();
        } catch (RemoteException e) {
            ct.a(e, "Circle", "getZIndex");
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return 0;
            }
            return iCircle.hashCodeRemote();
        } catch (RemoteException e) {
            ct.a(e, "Circle", "hashCode");
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isVisible() {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return false;
            }
            return iCircle.isVisible();
        } catch (RemoteException e) {
            ct.a(e, "Circle", "isVisible");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void remove() {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return;
            }
            iCircle.remove();
        } catch (RemoteException e) {
            ct.a(e, "Circle", "remove");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setCenter(LatLng latLng) {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return;
            }
            iCircle.setCenter(latLng);
        } catch (RemoteException e) {
            ct.a(e, "Circle", "setCenter");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setFillColor(int i) {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return;
            }
            iCircle.setFillColor(i);
        } catch (RemoteException e) {
            ct.a(e, "Circle", "setFillColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setRadius(double d) {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return;
            }
            iCircle.setRadius(d);
        } catch (RemoteException e) {
            ct.a(e, "Circle", "setRadius");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setStrokeColor(int i) {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return;
            }
            iCircle.setStrokeColor(i);
        } catch (RemoteException e) {
            ct.a(e, "Circle", "setStrokeColor");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setStrokeWidth(float f) {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return;
            }
            iCircle.setStrokeWidth(f);
        } catch (RemoteException e) {
            ct.a(e, "Circle", "setStrokeWidth");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setVisible(boolean z) {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return;
            }
            iCircle.setVisible(z);
        } catch (RemoteException e) {
            ct.a(e, "Circle", "setVisible");
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setZIndex(float f) {
        try {
            ICircle iCircle = this.f3094a;
            if (iCircle == null) {
                return;
            }
            iCircle.setZIndex(f);
        } catch (RemoteException e) {
            ct.a(e, "Circle", "setZIndex");
            throw new RuntimeRemoteException(e);
        }
    }
}
