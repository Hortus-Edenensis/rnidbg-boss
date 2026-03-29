package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmIconMarker;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class Overlay {
    protected static GeoPoint mcLocation;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f3666a = System.currentTimeMillis() + "_" + hashCode();
    EncodePointType b;
    int c;
    boolean d;
    Bundle e;
    BmLayer f;
    protected a listener;
    protected BmDrawItem mDrawItem;
    public com.baidu.mapsdkplatform.comapi.map.d type;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(Overlay overlay);

        boolean b(Overlay overlay);

        void c(Overlay overlay);

        LatLngBounds d(Overlay overlay);
    }

    public static void c(List<LatLng> list, Bundle bundle) {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i = 0; i < size; i++) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(list.get(i));
            dArr[i] = geoPointLl2mc.getLongitudeE6();
            dArr2[i] = geoPointLl2mc.getLatitudeE6();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
    }

    public static List<List<com.baidu.platform.comapi.bmsdk.b>> circleHoleInfo2BmGeo(List<CircleHoleOptions> list) {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            LatLng holeCenter = list.get(i).getHoleCenter();
            int holeRadius = list.get(i).getHoleRadius();
            if (holeCenter == null || holeRadius <= 0) {
                return null;
            }
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(holeCenter);
            dArr[i] = geoPointLl2mc.getLongitudeE6();
            dArr2[i] = geoPointLl2mc.getLatitudeE6();
            iArr[i] = holeRadius;
            iArr2[i] = i;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < size) {
            double d = dArr[i2];
            double d2 = dArr2[i2];
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            while (i3 < 360) {
                int i4 = i2;
                int i5 = size;
                double d3 = ((((double) i3) * 3.141592653589793d) * 2.0d) / ((double) 360);
                arrayList2.add(new com.baidu.platform.comapi.bmsdk.b((Math.cos(d3) * ((double) iArr[i4])) + (d - mcLocation.getLongitudeE6()) + mcLocation.getLongitudeE6(), (Math.sin(d3) * ((double) iArr[i4])) + (d2 - mcLocation.getLatitudeE6()) + mcLocation.getLatitudeE6()));
                i3++;
                i2 = i4;
                size = i5;
                dArr = dArr;
            }
            int i6 = size;
            int i7 = i2;
            int i8 = iArr2[i7];
            arrayList.add(arrayList2);
            i2 = i7 + 1;
            size = i6;
        }
        return arrayList;
    }

    public static void d(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat("red", ((i >> 16) & 255) / 255.0f);
        bundle2.putFloat("green", ((i >> 8) & 255) / 255.0f);
        bundle2.putFloat("blue", (i & 255) / 255.0f);
        bundle2.putFloat("alpha", (i >>> 24) / 255.0f);
        bundle.putBundle("color", bundle2);
    }

    public static void e(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat("red", ((i >> 16) & 255) / 255.0f);
        bundle2.putFloat("green", ((i >> 8) & 255) / 255.0f);
        bundle2.putFloat("blue", (i & 255) / 255.0f);
        bundle2.putFloat("alpha", (i >>> 24) / 255.0f);
        bundle.putBundle("m_sideFaceColor", bundle2);
    }

    public static void f(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat("red", ((i >> 16) & 255) / 255.0f);
        bundle2.putFloat("green", ((i >> 8) & 255) / 255.0f);
        bundle2.putFloat("blue", (i & 255) / 255.0f);
        bundle2.putFloat("alpha", (i >>> 24) / 255.0f);
        bundle.putBundle("m_topFaceColor", bundle2);
    }

    public static List<List<com.baidu.platform.comapi.bmsdk.b>> holeInfo2BmGeo(List<HoleOptions> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (HoleOptions holeOptions : list) {
            if (holeOptions instanceof CircleHoleOptions) {
                arrayList2.add((CircleHoleOptions) holeOptions);
            } else if (holeOptions instanceof PolygonHoleOptions) {
                arrayList3.add((PolygonHoleOptions) holeOptions);
            }
        }
        if (arrayList2.size() != 0) {
            arrayList.addAll(circleHoleInfo2BmGeo(arrayList2));
        }
        if (arrayList3.size() != 0) {
            arrayList.addAll(polygonHoleInfo2BmGeo(arrayList3));
        }
        return arrayList;
    }

    public static List<List<com.baidu.platform.comapi.bmsdk.b>> polygonHoleInfo2BmGeo(List<PolygonHoleOptions> list) {
        int size = list.size();
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < size; i++) {
            List<LatLng> holePoints = list.get(i).getHolePoints();
            if (holePoints == null) {
                return null;
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator<LatLng> it = holePoints.iterator();
            while (it.hasNext()) {
                GeoPoint geoPointLl2mc = CoordUtil.ll2mc(it.next());
                arrayList3.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
            }
            arrayList.addAll(holePoints);
            iArr[i] = holePoints.size();
            iArr2[i] = i;
            arrayList2.add(arrayList3);
        }
        return arrayList2;
    }

    public Bundle a(Bundle bundle) {
        bundle.putString("id", this.f3666a);
        bundle.putInt("type", this.type.ordinal());
        bundle.putInt(RemoteMessageConst.Notification.VISIBILITY, this.d ? 1 : 0);
        bundle.putInt("z_index", this.c);
        return bundle;
    }

    public BmDrawItem b() {
        BmDrawItem bmDrawItem = this.mDrawItem;
        if (bmDrawItem != null) {
            bmDrawItem.c(this.d ? 1 : 0);
            this.mDrawItem.d(this.c);
        }
        return this.mDrawItem;
    }

    public BmLayer getBmLayer() {
        return this.f;
    }

    public BmDrawItem getDrawItem() {
        return this.mDrawItem;
    }

    public Bundle getExtraInfo() {
        return this.e;
    }

    public String getName() {
        return this.f3666a;
    }

    public LatLngBounds getOverlayLatLngBounds() {
        return this.listener.d(this);
    }

    public int getZIndex() {
        return this.c;
    }

    public boolean isRemoved() {
        if (!OverlayUtil.isOverlayUpgrade()) {
            return this.listener.b(this);
        }
        BmLayer bmLayer = this.f;
        return bmLayer == null || bmLayer.a(getName()) == null;
    }

    public boolean isVisible() {
        return this.d;
    }

    public void remove() {
        BmDrawItem bmDrawItem;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.a(this);
            return;
        }
        BmLayer bmLayer = this.f;
        if (bmLayer == null || (bmDrawItem = this.mDrawItem) == null) {
            return;
        }
        bmLayer.a(bmDrawItem);
        this.f.b();
        BmDrawItem bmDrawItem2 = this.mDrawItem;
        if ((bmDrawItem2 instanceof BmIconMarker) && ((BmIconMarker) bmDrawItem2).d() != null) {
            try {
                ((BmIconMarker) this.mDrawItem).d().close();
            } catch (Exception unused) {
                Log.e("BmBitmapResource", "BmBitmapResource close failied");
            }
        }
        try {
            this.mDrawItem.close();
        } catch (Exception unused2) {
            Log.e("DrawItem", "DrawItem close failied");
        }
        this.mDrawItem = null;
    }

    public void setBmLayer(BmLayer bmLayer) {
        this.f = bmLayer;
    }

    public void setDottedBitmapResource(BmLineStyle bmLineStyle, int i) {
        String str;
        if (bmLineStyle == null) {
            return;
        }
        int i2 = 2;
        if (i == 1) {
            str = "CircleDashTexture.png";
        } else {
            str = i == 2 ? "lineDash_Rectangle.png" : "lineDashTexture.png";
            i2 = 1;
        }
        bmLineStyle.b(i2);
        BitmapDescriptor bitmapDescriptorFromAsset = BitmapDescriptorFactory.fromAsset(str);
        if (bitmapDescriptorFromAsset != null) {
            bmLineStyle.a(new BmBitmapResource(bitmapDescriptorFromAsset.getBitmap()));
        }
    }

    public void setDrawItem(BmDrawItem bmDrawItem) {
        this.mDrawItem = bmDrawItem;
    }

    public void setExtraInfo(Bundle bundle) {
        this.e = bundle;
    }

    public void setVisible(boolean z) {
        BmDrawItem bmDrawItem;
        this.d = z;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            if (this.f == null || (bmDrawItem = this.mDrawItem) == null) {
                return;
            }
            bmDrawItem.c(z ? 1 : 0);
            this.f.b();
        }
    }

    public void setZIndex(int i) {
        this.c = i;
        this.listener.c(this);
    }

    public BmDrawItem toDrawItem() {
        BmDrawItem bmDrawItem = this.mDrawItem;
        if (bmDrawItem == null) {
            return null;
        }
        bmDrawItem.setName(getName());
        this.mDrawItem.c(this.d ? 1 : 0);
        this.mDrawItem.d(this.c);
        return this.mDrawItem;
    }

    public static boolean b(List<HoleOptions> list, Bundle bundle) {
        boolean zA;
        boolean zD;
        if (list == null || list.size() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (HoleOptions holeOptions : list) {
            if (holeOptions instanceof CircleHoleOptions) {
                arrayList.add((CircleHoleOptions) holeOptions);
            } else if (holeOptions instanceof PolygonHoleOptions) {
                arrayList2.add((PolygonHoleOptions) holeOptions);
            }
        }
        if (arrayList.size() != 0) {
            zA = a(arrayList, bundle);
            bundle.putInt("has_circle_hole", zA ? 1 : 0);
        } else {
            bundle.putInt("has_circle_hole", 0);
            zA = false;
        }
        if (arrayList2.size() != 0) {
            zD = d(arrayList2, bundle);
            bundle.putInt("has_polygon_hole", zD ? 1 : 0);
        } else {
            bundle.putInt("has_polygon_hole", 0);
            zD = false;
        }
        return zA || zD;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("id", this.f3666a);
        bundle.putInt("type", this.type.ordinal());
        return bundle;
    }

    private static boolean d(List<PolygonHoleOptions> list, Bundle bundle) {
        int size = list.size();
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            List<LatLng> holePoints = list.get(i).getHolePoints();
            if (holePoints == null) {
                return false;
            }
            arrayList.addAll(holePoints);
            iArr[i] = holePoints.size();
            iArr2[i] = i;
        }
        int size2 = arrayList.size();
        if (size2 == 0) {
            return false;
        }
        bundle.putIntArray("polygon_hole_count_array", iArr);
        bundle.putIntArray("polygon_hole_index_array", iArr2);
        double[] dArr = new double[size2];
        double[] dArr2 = new double[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc((LatLng) arrayList.get(i2));
            dArr[i2] = geoPointLl2mc.getLongitudeE6();
            dArr2[i2] = geoPointLl2mc.getLatitudeE6();
        }
        bundle.putDoubleArray("polygon_hole_x_array", dArr);
        bundle.putDoubleArray("polygon_hole_y_array", dArr2);
        return true;
    }

    private static boolean a(List<CircleHoleOptions> list, Bundle bundle) {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            LatLng holeCenter = list.get(i).getHoleCenter();
            int holeRadius = list.get(i).getHoleRadius();
            if (holeCenter == null || holeRadius <= 0) {
                return false;
            }
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(holeCenter);
            dArr[i] = geoPointLl2mc.getLongitudeE6();
            dArr2[i] = geoPointLl2mc.getLatitudeE6();
            iArr[i] = holeRadius;
            iArr2[i] = i;
        }
        bundle.putDoubleArray("circle_hole_x_array", dArr);
        bundle.putDoubleArray("circle_hole_y_array", dArr2);
        bundle.putIntArray("circle_hole_radius_array", iArr);
        bundle.putIntArray("circle_hole_index_array", iArr2);
        return true;
    }

    public static void c(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat("red", ((i >> 16) & 255) / 255.0f);
        bundle2.putFloat("green", ((i >> 8) & 255) / 255.0f);
        bundle2.putFloat("blue", (i & 255) / 255.0f);
        bundle2.putFloat("alpha", (i >>> 24) / 255.0f);
        bundle.putBundle("m_side_color", bundle2);
    }

    public static void b(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat("red", ((i >> 16) & 255) / 255.0f);
        bundle2.putFloat("green", ((i >> 8) & 255) / 255.0f);
        bundle2.putFloat("blue", (i & 255) / 255.0f);
        bundle2.putFloat("alpha", (i >>> 24) / 255.0f);
        bundle.putBundle("m_center_color", bundle2);
    }

    public static void a(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putFloat("red", ((i >> 16) & 255) / 255.0f);
        bundle2.putFloat("green", ((i >> 8) & 255) / 255.0f);
        bundle2.putFloat("blue", (i & 255) / 255.0f);
        bundle2.putFloat("alpha", (i >>> 24) / 255.0f);
        bundle.putBundle("m_floorColor", bundle2);
    }
}
