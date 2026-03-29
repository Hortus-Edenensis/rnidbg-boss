package com.baidu.vi;

import android.annotation.SuppressLint;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class VGps {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f4296a = 3;

    @SuppressLint({"HandlerLeak"})
    private static Handler b = new c();
    private GpsStatus.Listener c = new a();
    private LocationListener d = new b();
    private LocationManager e = null;
    private GpsStatus f = null;
    private int g = 0;
    private int h = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements GpsStatus.Listener {
        public a() {
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            if (i == 2) {
                VGps.this.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                return;
            }
            if (i != 4) {
                return;
            }
            if (VGps.this.e != null) {
                if (VGps.this.f == null) {
                    VGps vGps = VGps.this;
                    vGps.f = vGps.e.getGpsStatus(null);
                } else {
                    VGps.this.e.getGpsStatus(VGps.this.f);
                }
            }
            Iterator<GpsSatellite> it = VGps.this.f.getSatellites().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (it.next().usedInFix()) {
                    i2++;
                }
            }
            if (i2 < VGps.f4296a && VGps.this.g >= VGps.f4296a) {
                VGps.this.b();
            }
            VGps.this.g = i2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VGps vGps = (VGps) message.obj;
            if (vGps == null) {
                return;
            }
            int i = message.what;
            if (i == 1) {
                if (vGps.g < VGps.f4296a) {
                    vGps.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                }
            } else {
                if (i == 2) {
                    if (VIContext.getContext() != null) {
                        vGps.e = (LocationManager) VIContext.getContext().getSystemService("location");
                        vGps.e.addGpsStatusListener(vGps.c);
                        return;
                    }
                    return;
                }
                if (i == 3 && vGps.e != null) {
                    vGps.e.removeGpsStatusListener(vGps.c);
                    vGps.e.removeUpdates(vGps.d);
                }
            }
        }
    }

    public int getGpsSatellitesNum() {
        return this.g;
    }

    public boolean init() {
        b.removeMessages(2);
        Handler handler = b;
        handler.sendMessage(handler.obtainMessage(2, this));
        return true;
    }

    public boolean unInit() {
        b.removeMessages(1);
        b.removeMessages(3);
        Handler handler = b;
        handler.sendMessage(handler.obtainMessage(3, this));
        return true;
    }

    public native void updateGps(double d, double d2, float f, float f2, float f3, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        if (!b.hasMessages(1)) {
            b.sendMessageDelayed(b.obtainMessage(1, this), 3000L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements LocationListener {
        public b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null) {
                float accuracy = location.hasAccuracy() ? location.getAccuracy() : 0.0f;
                if (VGps.this.g >= VGps.f4296a) {
                    VGps.this.updateGps(location.getLongitude(), location.getLatitude(), (float) (((double) location.getSpeed()) * 3.6d), location.getBearing(), accuracy, VGps.this.g);
                } else {
                    VGps.this.b();
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            VGps.this.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0 || i == 1) {
                VGps.this.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }
    }
}
