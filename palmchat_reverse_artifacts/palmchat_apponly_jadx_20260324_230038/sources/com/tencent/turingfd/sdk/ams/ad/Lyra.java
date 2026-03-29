package com.tencent.turingfd.sdk.ams.ad;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Lyra implements LocationListener {
    public static final Chestnut<Lyra> c = new Cdo();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cif[] f10717a = new Cif[3];
    public volatile int b = 0;

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Lyra$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class Cdo extends Chestnut<Lyra> {
        @Override // com.tencent.turingfd.sdk.ams.ad.Chestnut
        public Lyra a() {
            return new Lyra();
        }
    }

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Lyra$if, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class Cif {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f10718a;
        public String b;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f10717a) {
            int length = this.b;
            do {
                Cif cif = this.f10717a[this.b];
                if (cif == null) {
                    break;
                }
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(cif.f10718a);
                sb.append(":");
                sb.append(cif.b);
                length = (length + 1) % this.f10717a.length;
            } while (length != this.b);
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (location != null && location.isFromMockProvider()) {
            synchronized (this.f10717a) {
                Cif cif = this.f10717a[this.b];
                if (cif == null) {
                    cif = new Cif();
                    this.f10717a[this.b] = cif;
                }
                this.b = (this.b + 1) % this.f10717a.length;
                cif.f10718a = System.currentTimeMillis();
                cif.b = location.getProvider();
            }
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
