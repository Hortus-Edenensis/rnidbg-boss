package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0002sl.me;
import com.amap.api.col.p0002sl.mh;
import com.amap.api.col.p0002sl.mk;
import com.amap.api.col.p0002sl.mm;
import com.amap.api.services.geocoder.GeocodeSearch;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class CoordinateConverter {
    private static int b = 0;
    private static int c = 1;
    private static int d = 2;
    private static int e = 4;
    private static int f = 8;
    private static int g = 16;
    private static int h = 32;
    private static int i = 64;
    private Context j;
    private CoordType k = null;
    private DPoint l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    DPoint f3073a = null;

    /* JADX INFO: renamed from: com.amap.api.location.CoordinateConverter$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3074a;

        static {
            int[] iArr = new int[CoordType.values().length];
            f3074a = iArr;
            try {
                iArr[CoordType.BAIDU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3074a[CoordType.MAPBAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3074a[CoordType.MAPABC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3074a[CoordType.SOSOMAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3074a[CoordType.ALIYUN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3074a[CoordType.GOOGLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3074a[CoordType.GPS.ordinal()] = 7;
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

    public CoordinateConverter(Context context) {
        this.j = context;
    }

    public static float calculateLineDistance(DPoint dPoint, DPoint dPoint2) {
        try {
            return mm.a(dPoint, dPoint2);
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public static boolean isAMapDataAvailable(double d2, double d3) {
        return me.a(d2, d3);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized DPoint convert() throws Exception {
        if (this.k == null) {
            throw new IllegalArgumentException("转换坐标类型不能为空");
        }
        DPoint dPoint = this.l;
        if (dPoint == null) {
            throw new IllegalArgumentException("转换坐标源不能为空");
        }
        if (dPoint.getLongitude() > 180.0d || this.l.getLongitude() < -180.0d) {
            throw new IllegalArgumentException("请传入合理经度");
        }
        if (this.l.getLatitude() > 90.0d || this.l.getLatitude() < -90.0d) {
            throw new IllegalArgumentException("请传入合理纬度");
        }
        boolean z = true;
        String str = null;
        switch (AnonymousClass1.f3074a[this.k.ordinal()]) {
            case 1:
                this.f3073a = mh.a(this.l);
                int i2 = b;
                int i3 = c;
                if ((i2 & i3) != 0) {
                    z = false;
                } else {
                    str = "baidu";
                    b = i2 | i3;
                }
                break;
            case 2:
                this.f3073a = mh.b(this.j, this.l);
                int i4 = b;
                int i5 = d;
                if ((i4 & i5) == 0) {
                    str = "mapbar";
                    b = i4 | i5;
                    break;
                }
                break;
            case 3:
                int i6 = b;
                int i7 = e;
                if ((i6 & i7) == 0) {
                    str = "mapabc";
                    b = i6 | i7;
                } else {
                    z = false;
                }
                this.f3073a = this.l;
                break;
            case 4:
                int i8 = b;
                int i9 = f;
                if ((i8 & i9) == 0) {
                    str = "sosomap";
                    b = i8 | i9;
                } else {
                    z = false;
                }
                this.f3073a = this.l;
                break;
            case 5:
                int i10 = b;
                int i11 = g;
                if ((i10 & i11) == 0) {
                    str = "aliyun";
                    b = i10 | i11;
                } else {
                    z = false;
                }
                this.f3073a = this.l;
                break;
            case 6:
                int i12 = b;
                int i13 = h;
                if ((i12 & i13) == 0) {
                    str = "google";
                    b = i12 | i13;
                } else {
                    z = false;
                }
                this.f3073a = this.l;
                break;
            case 7:
                int i14 = b;
                int i15 = i;
                if ((i14 & i15) == 0) {
                    str = GeocodeSearch.GPS;
                    b = i14 | i15;
                } else {
                    z = false;
                }
                this.f3073a = mh.a(this.j, this.l);
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("amap_loc_coordinate", str);
            }
            mk.a(this.j, "O021", jSONObject);
        }
        return this.f3073a;
    }

    public synchronized CoordinateConverter coord(DPoint dPoint) throws Exception {
        try {
            if (dPoint == null) {
                throw new IllegalArgumentException("传入经纬度对象为空");
            }
            if (dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                throw new IllegalArgumentException("请传入合理经度");
            }
            if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d) {
                throw new IllegalArgumentException("请传入合理纬度");
            }
            this.l = dPoint;
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized CoordinateConverter from(CoordType coordType) {
        this.k = coordType;
        return this;
    }
}
