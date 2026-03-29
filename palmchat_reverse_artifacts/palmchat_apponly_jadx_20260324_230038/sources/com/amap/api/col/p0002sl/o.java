package com.amap.api.col.p0002sl;

import android.location.Location;
import com.amap.api.maps2d.LocationSource;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class o implements LocationSource.OnLocationChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Location f3040a;
    private ah b;

    public o(ah ahVar) {
        this.b = ahVar;
    }

    @Override // com.amap.api.maps2d.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        this.f3040a = location;
        try {
            if (this.b.isMyLocationEnabled()) {
                this.b.showMyLocationOverlay(location);
            }
        } catch (Throwable th) {
            ct.a(th, "AMapOnLocationChangedListener", "onLocationChanged");
        }
    }
}
