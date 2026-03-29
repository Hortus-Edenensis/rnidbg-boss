package com.amap.api.maps2d;

import android.os.RemoteException;
import com.amap.api.col.p0002sl.ct;
import com.amap.api.interfaces.IUiSettings;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class UiSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IUiSettings f3091a;

    public UiSettings(IUiSettings iUiSettings) {
        this.f3091a = iUiSettings;
    }

    public final int getLogoPosition() {
        try {
            return this.f3091a.getLogoPosition();
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "getLogoPosition");
            e.printStackTrace();
            return 0;
        }
    }

    public final int getZoomPosition() {
        try {
            return this.f3091a.getZoomPosition();
        } catch (Throwable th) {
            ct.a(th, "UiSettings", "getZoomPosition");
            th.printStackTrace();
            return 0;
        }
    }

    public final boolean isCompassEnabled() {
        try {
            return this.f3091a.isCompassEnabled();
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "isCompassEnabled");
            e.printStackTrace();
            return false;
        }
    }

    public final boolean isMyLocationButtonEnabled() {
        try {
            return this.f3091a.isMyLocationButtonEnabled();
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "isMyLocationButtonEnabled");
            e.printStackTrace();
            return false;
        }
    }

    public final boolean isScaleControlsEnabled() {
        try {
            return this.f3091a.isScaleControlsEnabled();
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "isScaleControlsEnabled");
            e.printStackTrace();
            return false;
        }
    }

    public final boolean isScrollGesturesEnabled() {
        try {
            return this.f3091a.isScrollGesturesEnabled();
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "isScrollGestureEnabled");
            e.printStackTrace();
            return false;
        }
    }

    public final boolean isZoomControlsEnabled() {
        try {
            return this.f3091a.isZoomControlsEnabled();
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "isZoomControlsEnabled");
            e.printStackTrace();
            return false;
        }
    }

    public final boolean isZoomGesturesEnabled() {
        try {
            return this.f3091a.isZoomGesturesEnabled();
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "isZoomGesturesEnabled");
            e.printStackTrace();
            return false;
        }
    }

    public final void setAllGesturesEnabled(boolean z) {
        try {
            this.f3091a.setAllGesturesEnabled(z);
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "setAllGesturesEnabled");
            e.printStackTrace();
        }
    }

    public final void setCompassEnabled(boolean z) {
        try {
            this.f3091a.setCompassEnabled(z);
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "setCompassEnabled");
            e.printStackTrace();
        }
    }

    public final void setLogoCenter(int i, int i2) {
        try {
            this.f3091a.setLogoCenter(i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLogoPosition(int i) {
        try {
            this.f3091a.setLogoPosition(i);
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "setLogoPosition");
            e.printStackTrace();
        }
    }

    public final void setMyLocationButtonEnabled(boolean z) {
        try {
            this.f3091a.setMyLocationButtonEnabled(z);
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "setMyLocationButtonEnabled");
            e.printStackTrace();
        }
    }

    public final void setScaleControlsEnabled(boolean z) {
        try {
            this.f3091a.setScaleControlsEnabled(z);
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "setScaleControlsEnabled");
            e.printStackTrace();
        }
    }

    public final void setScrollGesturesEnabled(boolean z) {
        try {
            this.f3091a.setScrollGesturesEnabled(z);
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "setScrollGesturesEnabled");
            e.printStackTrace();
        }
    }

    public final void setZoomControlsEnabled(boolean z) {
        try {
            this.f3091a.setZoomControlsEnabled(z);
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "setZoomControlsEnabled");
            e.printStackTrace();
        }
    }

    public final void setZoomGesturesEnabled(boolean z) {
        try {
            this.f3091a.setZoomGesturesEnabled(z);
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "setZoomGesturesEnabled");
            e.printStackTrace();
        }
    }

    public final void setZoomInByScreenCenter(boolean z) {
        try {
            this.f3091a.setZoomInByScreenCenter(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZoomPosition(int i) {
        try {
            this.f3091a.setZoomPosition(i);
        } catch (RemoteException e) {
            ct.a(e, "UiSettings", "setZoomPosition");
            e.printStackTrace();
        }
    }
}
