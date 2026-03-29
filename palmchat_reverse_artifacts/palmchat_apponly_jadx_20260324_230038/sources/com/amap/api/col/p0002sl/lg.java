package com.amap.api.col.p0002sl;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.services.geocoder.GeocodeSearch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class lg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    lh f2964a = null;
    long b = 0;
    long c = 0;
    private boolean h = true;
    int d = 0;
    long e = 0;
    AMapLocation f = null;
    long g = 0;

    private lh b(lh lhVar) {
        if (mm.a(lhVar)) {
            if (!this.h || !md.a(lhVar.getTime())) {
                lhVar.setLocationType(this.d);
            } else if (lhVar.getLocationType() == 5 || lhVar.getLocationType() == 6) {
                lhVar.setLocationType(4);
            }
        }
        return lhVar;
    }

    public final void a() {
        this.f2964a = null;
        this.b = 0L;
        this.c = 0L;
        this.f = null;
        this.g = 0L;
    }

    public final lh a(lh lhVar) {
        if (mm.b() - this.e > 30000) {
            this.f2964a = lhVar;
            this.e = mm.b();
            return this.f2964a;
        }
        this.e = mm.b();
        if (!mm.a(this.f2964a) || !mm.a(lhVar)) {
            this.b = mm.b();
            this.f2964a = lhVar;
            return lhVar;
        }
        if (lhVar.getTime() == this.f2964a.getTime() && lhVar.getAccuracy() < 300.0f) {
            return lhVar;
        }
        if (GeocodeSearch.GPS.equals(lhVar.getProvider())) {
            this.b = mm.b();
            this.f2964a = lhVar;
            return lhVar;
        }
        if (lhVar.c() != this.f2964a.c()) {
            this.b = mm.b();
            this.f2964a = lhVar;
            return lhVar;
        }
        if (lhVar.getBuildingId() != null && !lhVar.getBuildingId().equals(this.f2964a.getBuildingId()) && !TextUtils.isEmpty(lhVar.getBuildingId())) {
            this.b = mm.b();
            this.f2964a = lhVar;
            return lhVar;
        }
        this.d = lhVar.getLocationType();
        float fA = mm.a(lhVar, this.f2964a);
        float accuracy = this.f2964a.getAccuracy();
        float accuracy2 = lhVar.getAccuracy();
        float f = accuracy2 - accuracy;
        long jB = mm.b();
        long j = jB - this.b;
        boolean z = accuracy <= 100.0f && accuracy2 > 299.0f;
        boolean z2 = accuracy > 299.0f && accuracy2 > 299.0f;
        if (z || z2) {
            long j2 = this.c;
            if (j2 == 0) {
                this.c = jB;
            } else if (jB - j2 > 30000) {
                this.b = jB;
                this.f2964a = lhVar;
                this.c = 0L;
                return lhVar;
            }
            lh lhVarB = b(this.f2964a);
            this.f2964a = lhVarB;
            return lhVarB;
        }
        if (accuracy2 < 100.0f && accuracy > 299.0f) {
            this.b = jB;
            this.f2964a = lhVar;
            this.c = 0L;
            return lhVar;
        }
        if (accuracy2 <= 299.0f) {
            this.c = 0L;
        }
        if (fA >= 10.0f || fA <= 0.1d || accuracy2 <= 5.0f) {
            if (f < 300.0f) {
                this.b = mm.b();
                this.f2964a = lhVar;
                return lhVar;
            }
            if (j >= 30000) {
                this.b = mm.b();
                this.f2964a = lhVar;
                return lhVar;
            }
            lh lhVarB2 = b(this.f2964a);
            this.f2964a = lhVarB2;
            return lhVarB2;
        }
        if (f >= -300.0f) {
            lh lhVarB3 = b(this.f2964a);
            this.f2964a = lhVarB3;
            return lhVarB3;
        }
        if (accuracy / accuracy2 >= 2.0f) {
            this.b = jB;
            this.f2964a = lhVar;
            return lhVar;
        }
        lh lhVarB4 = b(this.f2964a);
        this.f2964a = lhVarB4;
        return lhVarB4;
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public final AMapLocation a(AMapLocation aMapLocation) {
        if (!mm.a(aMapLocation)) {
            return aMapLocation;
        }
        long jB = mm.b() - this.g;
        this.g = mm.b();
        if (jB > 5000) {
            return aMapLocation;
        }
        AMapLocation aMapLocation2 = this.f;
        if (aMapLocation2 == null) {
            this.f = aMapLocation;
            return aMapLocation;
        }
        if (1 != aMapLocation2.getLocationType() && !GeocodeSearch.GPS.equalsIgnoreCase(this.f.getProvider())) {
            this.f = aMapLocation;
            return aMapLocation;
        }
        if (this.f.getAltitude() == aMapLocation.getAltitude() && this.f.getLongitude() == aMapLocation.getLongitude()) {
            this.f = aMapLocation;
            return aMapLocation;
        }
        long jAbs = Math.abs(aMapLocation.getTime() - this.f.getTime());
        if (30000 < jAbs) {
            this.f = aMapLocation;
            return aMapLocation;
        }
        if (mm.a(aMapLocation, this.f) > (((this.f.getSpeed() + aMapLocation.getSpeed()) * jAbs) / 2000.0f) + ((this.f.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
            return this.f;
        }
        this.f = aMapLocation;
        return aMapLocation;
    }
}
