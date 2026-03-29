package com.amap.api.maps2d;

import com.amap.api.col.p0002sl.co;
import com.amap.api.col.p0002sl.cq;
import com.amap.api.col.p0002sl.cr;
import com.amap.api.col.p0002sl.cs;
import com.amap.api.maps2d.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class CoordinateConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CoordType f3083a = null;
    private LatLng b = null;

    /* JADX INFO: renamed from: com.amap.api.maps2d.CoordinateConverter$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3084a;

        static {
            int[] iArr = new int[CoordType.values().length];
            f3084a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3084a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3084a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3084a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3084a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3084a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3084a[CoordType.GPS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum CoordType {
        BAIDU,
        MAPBAR,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE,
        GPS
    }

    public static boolean isAMapDataAvailable(double d, double d2) {
        return cs.a(d, d2);
    }

    public LatLng convert() {
        CoordType coordType = this.f3083a;
        LatLng latLngA = null;
        if (coordType == null || this.b == null) {
            return null;
        }
        try {
            switch (AnonymousClass1.f3084a[coordType.ordinal()]) {
                case 1:
                    return co.a(this.b);
                case 2:
                    return cq.a(this.b);
                case 3:
                case 4:
                case 5:
                case 6:
                    return this.b;
                case 7:
                    latLngA = cr.a(this.b);
                    break;
            }
            return latLngA;
        } catch (Throwable th) {
            th.printStackTrace();
            return this.b;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.f3083a = coordType;
        return this;
    }
}
