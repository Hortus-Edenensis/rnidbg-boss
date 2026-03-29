package com.amap.api.col.p0002sl;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class ci implements au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ah f2671a;
    private boolean b = true;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;
    private boolean f = true;
    private boolean g = false;
    private int h = 0;
    private int i = 0;
    private final Handler j = new Handler() { // from class: com.amap.api.col.2sl.ci.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message == null || ci.this.f2671a == null) {
                return;
            }
            try {
                int i = message.what;
                if (i == 0) {
                    ci.this.f2671a.showZoomControlsEnabled(ci.this.e);
                    return;
                }
                if (i == 1) {
                    ci.this.f2671a.showScaleEnabled(ci.this.g);
                } else if (i == 2) {
                    ci.this.f2671a.showCompassEnabled(ci.this.f);
                } else {
                    if (i != 3) {
                        return;
                    }
                    ci.this.f2671a.showMyLocationButtonEnabled(ci.this.c);
                }
            } catch (Throwable th) {
                ct.a(th, "UiSettingsDelegateImp", "handle_handleMessage");
            }
        }
    };
    private boolean k;

    public ci(ah ahVar) {
        this.f2671a = ahVar;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final int getLogoPosition() throws RemoteException {
        return this.h;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final int getZoomPosition() throws RemoteException {
        return this.i;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final boolean isCompassEnabled() throws RemoteException {
        return this.f;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final boolean isMyLocationButtonEnabled() throws RemoteException {
        return this.c;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final boolean isScaleControlsEnabled() throws RemoteException {
        return this.g;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final boolean isScrollGesturesEnabled() throws RemoteException {
        return this.b;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final boolean isZoomControlsEnabled() throws RemoteException {
        return this.e;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final boolean isZoomGesturesEnabled() throws RemoteException {
        return this.d;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final boolean isZoomInByScreenCenter() {
        return this.k;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final void setAllGesturesEnabled(boolean z) throws RemoteException {
        setZoomGesturesEnabled(z);
        setScrollGesturesEnabled(z);
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final void setCompassEnabled(boolean z) throws RemoteException {
        this.f = z;
        this.j.obtainMessage(2).sendToTarget();
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final void setLogoCenter(int i, int i2) {
        ah ahVar = this.f2671a;
        if (ahVar != null) {
            ahVar.a(i, i2);
        }
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final void setLogoPosition(int i) throws RemoteException {
        this.h = i;
        this.f2671a.setLogoPosition(i);
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final void setMyLocationButtonEnabled(boolean z) throws RemoteException {
        this.c = z;
        this.j.obtainMessage(3).sendToTarget();
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final void setScaleControlsEnabled(boolean z) throws RemoteException {
        this.g = z;
        this.j.obtainMessage(1).sendToTarget();
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final void setScrollGesturesEnabled(boolean z) throws RemoteException {
        this.b = z;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final void setZoomControlsEnabled(boolean z) throws RemoteException {
        this.e = z;
        this.j.obtainMessage(0).sendToTarget();
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final void setZoomGesturesEnabled(boolean z) throws RemoteException {
        this.d = z;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final void setZoomInByScreenCenter(boolean z) {
        this.k = z;
    }

    @Override // com.amap.api.interfaces.IUiSettings
    public final void setZoomPosition(int i) throws RemoteException {
        this.i = i;
        this.f2671a.setZoomPosition(i);
    }
}
