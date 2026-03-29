package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class CoordinateConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f3833a;
    private CoordType b;

    /* JADX INFO: compiled from: SearchBox */
    public enum CoordType {
        GPS,
        COMMON,
        BD09LL,
        BD09MC
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3834a;

        static {
            int[] iArr = new int[CoordType.values().length];
            f3834a = iArr;
            try {
                iArr[CoordType.COMMON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3834a[CoordType.GPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3834a[CoordType.BD09LL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3834a[CoordType.BD09MC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static LatLng a(LatLng latLng, String str) {
        if (latLng == null) {
            return null;
        }
        return CoordUtil.Coordinate_encryptEx((float) latLng.longitude, (float) latLng.latitude, str);
    }

    private static LatLng b(LatLng latLng) {
        return a(latLng, "bd09mc");
    }

    private static LatLng c(LatLng latLng) {
        return a(latLng, "gcj02");
    }

    private static LatLng d(LatLng latLng) {
        return a(latLng, "wgs84");
    }

    public LatLng convert() {
        if (this.f3833a == null) {
            return null;
        }
        if (this.b == null) {
            this.b = CoordType.GPS;
        }
        int i = a.f3834a[this.b.ordinal()];
        if (i == 1) {
            return c(this.f3833a);
        }
        if (i == 2) {
            return d(this.f3833a);
        }
        if (i == 3) {
            return a(this.f3833a);
        }
        if (i != 4) {
            return null;
        }
        return b(this.f3833a);
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.f3833a = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.b = coordType;
        return this;
    }

    private static LatLng a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return CoordTrans.baiduToGcj(latLng);
    }
}
