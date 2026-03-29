package cn.fly.verify;

import android.content.pm.PackageInfo;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.ServiceState;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class az {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static az f2087a;
    private aw b;
    private a c = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a {
        private boolean b = false;

        public a() {
        }

        public boolean a() {
            return false;
        }
    }

    private az() {
    }

    public static az a() {
        if (f2087a == null) {
            synchronized (az.class) {
                if (f2087a == null) {
                    f2087a = new az();
                }
            }
        }
        return f2087a;
    }

    public a b() {
        return this.c;
    }

    public boolean c() {
        return true;
    }

    public boolean d() {
        return true;
    }

    public boolean e() {
        return true;
    }

    public boolean f() {
        return true;
    }

    public boolean g() {
        return true;
    }

    public boolean h() {
        return true;
    }

    public boolean i() {
        return true;
    }

    public Location j() {
        return null;
    }

    public String k() {
        return null;
    }

    public WifiInfo l() {
        return null;
    }

    public List<ScanResult> m() {
        return null;
    }

    public CellLocation n() {
        return null;
    }

    public List<NeighboringCellInfo> o() {
        return null;
    }

    public List<PackageInfo> p() {
        return null;
    }

    public String q() {
        return null;
    }

    public String r() {
        return null;
    }

    public String s() {
        return null;
    }

    public int t() {
        return -1;
    }

    public ServiceState u() {
        return null;
    }

    public void a(aw awVar) {
        this.b = awVar;
    }
}
