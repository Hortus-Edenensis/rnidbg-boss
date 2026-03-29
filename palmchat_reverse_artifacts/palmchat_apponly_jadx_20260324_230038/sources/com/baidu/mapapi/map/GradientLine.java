package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.GradientLineOptions;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class GradientLine extends Overlay {
    List<LatLng> g;
    int[] h;
    int[] i;
    int j = 5;
    GradientLineOptions.LineDirectionCross180 k = GradientLineOptions.LineDirectionCross180.NONE;

    public GradientLine() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.gradientLine;
    }

    private static void b(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_array", iArr);
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        List<LatLng> list = this.g;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add GradientLine, you must at least supply 2 points");
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.g.get(0));
        bundle.putDouble("location_x", geoPointLl2mc.getLongitudeE6());
        bundle.putDouble("location_y", geoPointLl2mc.getLatitudeE6());
        bundle.putInt("width", this.j);
        int[] iArr = this.h;
        if (iArr == null) {
            throw new IllegalStateException("BDMapSDKException: Indexs array can not be null");
        }
        if (iArr.length == 0) {
            throw new IllegalStateException("BDMapSDKException: Indexs array size can not be Equal to zero");
        }
        a(this.g, this.k, bundle);
        a(this.h, bundle);
        int[] iArr2 = this.i;
        if (iArr2 == null) {
            throw new IllegalStateException("BDMapSDKException: colors array can not be null");
        }
        if (iArr2.length == 0) {
            throw new IllegalStateException("BDMapSDKException: colors array size can not be Equal to zero");
        }
        b(iArr2, bundle);
        return bundle;
    }

    public int[] getColors() {
        return this.i;
    }

    public int[] getIndexs() {
        return this.h;
    }

    public GradientLineOptions.LineDirectionCross180 getLineDirectionCross180() {
        return this.k;
    }

    public List<LatLng> getPoints() {
        return this.g;
    }

    public float getWidth() {
        return this.j;
    }

    public void lineDirectionCross180(GradientLineOptions.LineDirectionCross180 lineDirectionCross180) {
        this.k = lineDirectionCross180;
    }

    public void setColorIndex(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
        }
        this.h = iArr;
        this.listener.c(this);
    }

    public void setColorList(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
        }
        this.i = iArr;
        this.listener.c(this);
    }

    public void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
        this.g = list;
        this.listener.c(this);
    }

    public void setWidth(int i) {
        if (i > 0) {
            this.j = i;
            this.listener.c(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(List<LatLng> list, GradientLineOptions.LineDirectionCross180 lineDirectionCross180, Bundle bundle) {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i = 0; i < size; i++) {
            LatLng latLng = list.get(i);
            GradientLineOptions.LineDirectionCross180 lineDirectionCross1802 = GradientLineOptions.LineDirectionCross180.FROM_EAST_TO_WEST;
            if (lineDirectionCross180 == lineDirectionCross1802) {
                double d = latLng.longitude;
                if (d < 0.0d) {
                    LatLng latLng2 = new LatLng(latLng.latitude, d + 360.0d);
                    bundle.putInt("lineDirectionCross180", lineDirectionCross1802.ordinal());
                    latLng = latLng2;
                } else {
                    GradientLineOptions.LineDirectionCross180 lineDirectionCross1803 = GradientLineOptions.LineDirectionCross180.FROM_WEST_TO_EAST;
                    if (lineDirectionCross180 == lineDirectionCross1803) {
                        double d2 = latLng.longitude;
                        if (d2 > 0.0d) {
                            LatLng latLng3 = new LatLng(latLng.latitude, d2 - 360.0d);
                            bundle.putInt("lineDirectionCross180", lineDirectionCross1803.ordinal());
                            latLng = latLng3;
                        } else {
                            bundle.putInt("lineDirectionCross180", GradientLineOptions.LineDirectionCross180.NONE.ordinal());
                        }
                    }
                }
            }
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng);
            dArr[i] = geoPointLl2mc.getLongitudeE6();
            dArr2[i] = geoPointLl2mc.getLatitudeE6();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
    }

    private static void a(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_indexs", iArr);
    }
}
