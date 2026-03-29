package defpackage;

import com.heytap.mcssdk.constant.a;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class kx2 {
    public Map<String, ux2> k;
    public List<String> o;
    public List<String> p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f18847a = true;
    public boolean b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean e = false;
    public int f = 5;
    public long g = 1800000;
    public boolean h = true;
    public boolean i = true;
    public int j = 0;
    public long l = 3600000;
    public long m = 3600000;
    public String n = "disable";
    public long q = 1800000;
    public long r = 1800000;
    public long s = a.n;
    public boolean t = false;
    public boolean u = false;
    public int v = 0;

    public String toString() {
        return "JWakeConfigInfo{wakeEnableByAppKey=" + this.f18847a + ", beWakeEnableByAppKey=" + this.b + ", wakeEnableByUId=" + this.c + ", beWakeEnableByUId=" + this.d + ", ignorLocal=" + this.e + ", maxWakeCount=" + this.f + ", wakeInterval=" + this.g + ", wakeTimeEnable=" + this.h + ", noWakeTimeConfig=" + this.i + ", apiType=" + this.j + ", wakeTypeInfoMap=" + this.k + ", wakeConfigInterval=" + this.l + ", wakeReportInterval=" + this.m + ", config='" + this.n + "', pkgList=" + this.o + ", blackPackageList=" + this.p + ", accountWakeInterval=" + this.q + ", dactivityWakeInterval=" + this.r + ", activityWakeInterval=" + this.s + ", wakeReportEnable=" + this.t + ", beWakeReportEnable=" + this.u + '}';
    }
}
