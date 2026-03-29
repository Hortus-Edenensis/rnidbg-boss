package com.amap.api.col.p0002sl;

import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class mt {
    private static mt b;
    private mx c = null;
    private long d = 0;
    private long e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f3014a = 0;

    private mt() {
    }

    public static synchronized mt a() {
        if (b == null) {
            b = new mt();
        }
        return b;
    }

    public final mx a(mx mxVar) {
        if (np.b() - this.f3014a > 30000) {
            this.c = mxVar;
            this.f3014a = np.b();
            return this.c;
        }
        this.f3014a = np.b();
        if (!nb.a(this.c) || !nb.a(mxVar)) {
            this.d = np.b();
            this.c = mxVar;
            return mxVar;
        }
        if (mxVar.getTime() == this.c.getTime() && mxVar.getAccuracy() < 300.0f) {
            return mxVar;
        }
        if (mxVar.getProvider().equalsIgnoreCase(GeocodeSearch.GPS)) {
            this.d = np.b();
            this.c = mxVar;
            return mxVar;
        }
        if (mxVar.c() != this.c.c()) {
            this.d = np.b();
            this.c = mxVar;
            return mxVar;
        }
        if (!mxVar.getBuildingId().equals(this.c.getBuildingId()) && !TextUtils.isEmpty(mxVar.getBuildingId())) {
            this.d = np.b();
            this.c = mxVar;
            return mxVar;
        }
        float fA = np.a(new double[]{mxVar.getLatitude(), mxVar.getLongitude(), this.c.getLatitude(), this.c.getLongitude()});
        float accuracy = this.c.getAccuracy();
        float accuracy2 = mxVar.getAccuracy();
        float f = accuracy2 - accuracy;
        long jB = np.b();
        long j = jB - this.d;
        if ((accuracy < 101.0f && accuracy2 > 299.0f) || (accuracy > 299.0f && accuracy2 > 299.0f)) {
            long j2 = this.e;
            if (j2 == 0) {
                this.e = jB;
            } else if (jB - j2 > 30000) {
                this.d = jB;
                this.c = mxVar;
                this.e = 0L;
                return mxVar;
            }
            return this.c;
        }
        if (accuracy2 < 101.0f && accuracy > 299.0f) {
            this.d = jB;
            this.c = mxVar;
            this.e = 0L;
            return mxVar;
        }
        if (accuracy2 <= 299.0f) {
            this.e = 0L;
        }
        if (fA < 10.0f && fA > 0.1d && accuracy2 > 5.0f) {
            if (f < -300.0f && accuracy / accuracy2 >= 2.0f) {
                this.d = jB;
                this.c = mxVar;
                return mxVar;
            }
            return this.c;
        }
        if (f < 300.0f) {
            this.d = np.b();
            this.c = mxVar;
            return mxVar;
        }
        if (j < 30000) {
            return this.c;
        }
        this.d = np.b();
        this.c = mxVar;
        return mxVar;
    }
}
