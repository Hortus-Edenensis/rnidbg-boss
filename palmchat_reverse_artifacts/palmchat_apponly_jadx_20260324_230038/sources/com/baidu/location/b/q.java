package com.baidu.location.b;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<c> f3449a = new CopyOnWriteArrayList();
    private LocationManager b = null;
    private b c = null;
    private boolean d = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static q f3450a = new q();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(Location location);
    }

    public static q a() {
        return a.f3450a;
    }

    public void b() {
        LocationManager locationManager;
        b bVar = this.c;
        if (bVar == null || (locationManager = this.b) == null) {
            return;
        }
        locationManager.removeUpdates(bVar);
        this.c = null;
    }

    public void a(Context context, Looper looper) {
        try {
            if (this.b == null) {
                this.b = (LocationManager) context.getSystemService("location");
            }
            if (this.c == null) {
                this.c = new b();
            }
            LocationManager locationManager = this.b;
            if (locationManager == null || !locationManager.isProviderEnabled("network")) {
                return;
            }
            this.b.requestLocationUpdates("network", 1000L, 0.0f, this.c, looper);
        } catch (Exception unused) {
        }
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f3449a.remove(cVar);
        if (this.f3449a.size() == 0 && this.d) {
            b();
            this.d = false;
        }
    }

    public void a(c cVar, Context context, Looper looper) {
        if (cVar == null) {
            return;
        }
        if (!this.f3449a.contains(cVar)) {
            this.f3449a.add(cVar);
        }
        if (this.f3449a.size() != 1 || this.d) {
            return;
        }
        a(context, looper);
        this.d = true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements LocationListener {
        private b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null) {
                return;
            }
            try {
                Iterator<c> it = q.this.f3449a.iterator();
                while (it.hasNext()) {
                    it.next().a(location);
                }
            } catch (Exception unused) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }
}
