package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class q extends f {
    private List<GeoPoint> x;

    public q(z zVar) {
        super(zVar);
        this.x = new ArrayList();
        this.v = 0;
        this.w = 2;
    }

    private boolean b() {
        synchronized (this.x) {
            if (this.x.size() < 2) {
                return false;
            }
            int size = this.x.size();
            this.p = new double[this.x.size() * 3];
            this.o = new double[(this.x.size() * 2) + 5];
            if (c()) {
                this.o[0] = this.r.getLongitude();
                this.o[1] = this.r.getLatitude();
                this.o[2] = this.s.getLongitude();
                this.o[3] = this.s.getLatitude();
            }
            this.o[4] = 2.0d;
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    this.o[5] = this.x.get(0).getLongitude();
                    this.o[6] = this.x.get(0).getLatitude();
                } else {
                    int i2 = (i * 2) + 5;
                    int i3 = i - 1;
                    this.o[i2] = this.x.get(i).getLongitude() - this.x.get(i3).getLongitude();
                    this.o[i2 + 1] = this.x.get(i).getLatitude() - this.x.get(i3).getLatitude();
                }
                int i4 = i * 3;
                this.p[i4] = this.x.get(i).getLongitude();
                this.p[i4 + 1] = this.x.get(i).getLatitude();
                this.p[i4 + 2] = 0.0d;
            }
            return true;
        }
    }

    private boolean c() {
        synchronized (this.x) {
            if (this.x.size() < 2) {
                return false;
            }
            this.r.setLatitude(this.x.get(0).getLatitude());
            this.r.setLongitude(this.x.get(0).getLongitude());
            this.s.setLatitude(this.x.get(0).getLatitude());
            this.s.setLongitude(this.x.get(0).getLongitude());
            for (GeoPoint geoPoint : this.x) {
                if (this.r.getLatitude() >= geoPoint.getLatitude()) {
                    this.r.setLatitude(geoPoint.getLatitude());
                }
                if (this.r.getLongitude() >= geoPoint.getLongitude()) {
                    this.r.setLongitude(geoPoint.getLongitude());
                }
                if (this.s.getLatitude() <= geoPoint.getLatitude()) {
                    this.s.setLatitude(geoPoint.getLatitude());
                }
                if (this.s.getLongitude() <= geoPoint.getLongitude()) {
                    this.s.setLongitude(geoPoint.getLongitude());
                }
            }
            return true;
        }
    }

    public void a(List<GeoPoint> list) {
        if (list == null) {
            throw new IllegalArgumentException("points list can not be null!");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("points count can not be less than two!");
        }
        synchronized (this.x) {
            this.x.clear();
            this.x.addAll(list);
            this.t = true;
        }
    }

    public void a(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        this.q = iArr;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void a(z zVar) {
        this.f4206a = zVar;
    }

    @Override // com.baidu.platform.comapi.map.f
    public String a() {
        String strA;
        synchronized (this.x) {
            if (this.t) {
                this.t = !b();
            }
            strA = a(this.v);
        }
        return strA;
    }
}
