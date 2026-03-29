package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.f;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmBaseLine;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmGradientLine;
import com.baidu.platform.comapi.bmsdk.BmPolyline;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.style.BmBitmapResource;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyleOption;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class Polyline extends Overlay {
    int C;
    int D;
    private BmBaseLine I;
    private BmLineStyle J;
    private BmGeoElement K;
    Animation N;
    int g;
    List<LatLng> h;
    int[] i;
    int[] j;
    List<Integer> k;
    BitmapDescriptor q;
    BmBitmapResource r;
    List<BitmapDescriptor> s;
    List<BmBitmapResource> t;
    int l = 5;
    boolean m = false;
    boolean n = false;
    boolean o = true;
    boolean p = true;
    int u = 0;
    boolean v = true;
    ThinAndSmoothAlgorithm w = ThinAndSmoothAlgorithm.DOUGLAS_PEUCKER;
    float x = 4.0f;
    ThinAndSmoothAlgorithm y = ThinAndSmoothAlgorithm.BEZIER_SMOOTH;
    float z = 16.0f;
    boolean A = false;
    boolean B = false;
    float E = 5.0f;
    int F = 1;
    boolean G = false;
    LineBloomDirection H = LineBloomDirection.BloomAround;
    private List<BmGeoElement> L = null;
    private List<BmLineStyle> M = null;
    PolylineOptions.LineCapType O = PolylineOptions.LineCapType.LineCapButt;
    PolylineOptions.LineJoinType P = PolylineOptions.LineJoinType.LineJoinRound;
    PolylineOptions.LineDirectionCross180 Q = PolylineOptions.LineDirectionCross180.NONE;
    PolylineOptions.LineBloomType R = PolylineOptions.LineBloomType.NONE;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3673a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[PolylineOptions.LineCapType.values().length];
            b = iArr;
            try {
                iArr[PolylineOptions.LineCapType.LineCapButt.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[PolylineOptions.LineCapType.LineCapRound.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[PolylineOptions.LineJoinType.values().length];
            f3673a = iArr2;
            try {
                iArr2[PolylineOptions.LineJoinType.LineJoinBevel.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3673a[PolylineOptions.LineJoinType.LineJoinMiter.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3673a[PolylineOptions.LineJoinType.LineJoinRound.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public Polyline() {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.polyline;
    }

    private static void a(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_array", iArr);
        bundle.putInt("total", 1);
    }

    private Bundle b(boolean z, String str) {
        if (z) {
            Bundle bundle = new Bundle();
            bundle.putInt("total", 1);
            int i = this.u;
            String str2 = i == 1 ? "CircleDashTexture.png" : i == 2 ? "lineDash_Rectangle.png" : "lineDashTexture.png";
            if (str == null) {
                str = str2;
            }
            BitmapDescriptor bitmapDescriptorFromAsset = BitmapDescriptorFactory.fromAsset(str);
            if (bitmapDescriptorFromAsset != null) {
                bundle.putBundle("texture_0", bitmapDescriptorFromAsset.a());
            }
            return bundle;
        }
        Bundle bundle2 = new Bundle();
        int i2 = 0;
        for (int i3 = 0; i3 < this.s.size(); i3++) {
            if (this.s.get(i3) != null) {
                bundle2.putBundle("texture_" + String.valueOf(i2), this.s.get(i3).a());
                i2++;
            }
        }
        bundle2.putInt("total", i2);
        return bundle2;
    }

    private static void c(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_indexs", iArr);
    }

    private static void d(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("traffic_array", iArr);
    }

    public void cancelAnimation() {
        if (this.N == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.N.bmAnimation.cancel();
        this.f.b();
    }

    public int getBloomAlpha() {
        return this.D;
    }

    public int getBloomBlurTimes() {
        return this.F;
    }

    public float getBloomGradientASpeed() {
        return this.E;
    }

    public int getBloomWidth() {
        int i = this.C;
        return i == 0 ? this.l * 2 : i;
    }

    public int getColor() {
        return this.g;
    }

    public int[] getColorList() {
        return this.j;
    }

    public int getDottedLineType() {
        return this.u;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem getDrawItem() {
        return this.I;
    }

    public PolylineOptions.LineBloomType getLineBloomType() {
        return this.R;
    }

    public PolylineOptions.LineCapType getLineCapType() {
        return this.O;
    }

    public PolylineOptions.LineDirectionCross180 getLineDirectionCross180() {
        return this.Q;
    }

    public PolylineOptions.LineJoinType getLineJoinType() {
        return this.P;
    }

    public List<LatLng> getPoints() {
        return this.h;
    }

    public BitmapDescriptor getTexture() {
        return this.q;
    }

    public int getWidth() {
        return this.l;
    }

    public boolean isClickable() {
        return this.p;
    }

    public boolean isDottedLine() {
        return this.m;
    }

    public boolean isFocus() {
        return this.n;
    }

    public boolean isGeodesic() {
        return this.A;
    }

    public boolean isGradient() {
        return this.B;
    }

    public boolean isIsKeepScale() {
        return this.o;
    }

    public boolean isThined() {
        return this.v;
    }

    public void pauseAnimation() {
        if (this.N == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.N.bmAnimation.pause();
        this.f.b();
    }

    public void resumeAnimation() {
        if (this.N == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.N.bmAnimation.resume();
        this.f.b();
    }

    public void setAnimation(Animation animation) {
        BmAnimation bmAnimation;
        if (animation == null) {
            return;
        }
        this.N = animation;
        if (!OverlayUtil.isOverlayUpgrade() || (bmAnimation = this.N.bmAnimation) == null) {
            return;
        }
        this.I.a(bmAnimation);
        this.f.b();
    }

    public void setBloomAlpha(int i) {
        if (i > 255 || i < 0) {
            i = 255;
        }
        this.D = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.I.b(i);
            this.f.b();
        }
    }

    public void setBloomBlurTimes(int i) {
        if (i > 10) {
            i = 10;
        }
        if (i < 1) {
            i = 1;
        }
        this.F = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.I.e(i);
            this.f.b();
        }
    }

    public void setBloomGradientASpeed(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (f > 10.0f) {
            f = 10.0f;
        }
        this.E = f;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.I.c(f);
            this.f.b();
        }
    }

    public void setBloomWidth(int i) {
        if (i < 0) {
            i = 0;
        }
        this.C = i;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.I.d(i);
            this.f.b();
        }
    }

    public void setClickable(boolean z) {
        this.p = z;
        this.listener.c(this);
    }

    public void setColor(int i) {
        this.g = i;
        this.listener.c(this);
    }

    public void setColorList(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: colorList can not empty");
        }
        this.j = iArr;
    }

    public void setDottedLine(boolean z) {
        this.m = z;
        this.listener.c(this);
    }

    public void setDottedLineType(PolylineDottedLineType polylineDottedLineType) {
        this.u = polylineDottedLineType.ordinal();
        this.listener.c(this);
    }

    public void setFocus(boolean z) {
        this.n = z;
        this.listener.c(this);
    }

    public void setGeodesic(boolean z) {
        this.A = z;
        this.listener.c(this);
    }

    public void setGradient(boolean z) {
        this.B = z;
        this.listener.c(this);
    }

    public void setIndexs(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: indexList can not empty");
        }
        this.i = iArr;
    }

    public void setIsKeepScale(boolean z) {
        this.o = z;
    }

    public void setLineBloomDirection(LineBloomDirection lineBloomDirection) {
        if (OverlayUtil.isOverlayUpgrade()) {
            this.H = lineBloomDirection;
            this.I.h(lineBloomDirection.ordinal());
            this.f.b();
        }
    }

    public void setLineBloomType(PolylineOptions.LineBloomType lineBloomType) {
        this.R = lineBloomType;
        if (!OverlayUtil.isOverlayUpgrade()) {
            this.listener.c(this);
        } else {
            this.I.i(lineBloomType.ordinal());
            this.f.b();
        }
    }

    public void setLineCapType(PolylineOptions.LineCapType lineCapType) {
        this.O = lineCapType;
        this.listener.c(this);
    }

    public void setLineDirectionCross180(PolylineOptions.LineDirectionCross180 lineDirectionCross180) {
        this.Q = lineDirectionCross180;
    }

    public void setLineJoinType(PolylineOptions.LineJoinType lineJoinType) {
        this.P = lineJoinType;
        this.listener.c(this);
    }

    public void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
        }
        if (list.size() < 2) {
            throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2 or more than 10000");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
        }
        this.h = list;
        this.listener.c(this);
    }

    public void setSmoothAlgorithm(ThinAndSmoothAlgorithm thinAndSmoothAlgorithm) {
        this.y = thinAndSmoothAlgorithm;
        if (OverlayUtil.isOverlayUpgrade()) {
            this.I.k(this.y.getValue());
            this.f.b();
        }
    }

    public void setSmoothFactor(float f) {
        if (f > 0.0f) {
            this.z = f;
        }
        if (OverlayUtil.isOverlayUpgrade()) {
            this.I.e(this.z);
            this.f.b();
        }
    }

    public void setTexture(BitmapDescriptor bitmapDescriptor) {
        this.q = bitmapDescriptor;
        if (OverlayUtil.isOverlayUpgrade()) {
            this.r = new BmBitmapResource(bitmapDescriptor.getBitmap());
        }
        this.listener.c(this);
    }

    public void setTextureList(List<BitmapDescriptor> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: textureList can not empty");
        }
        this.s = list;
        if (OverlayUtil.isOverlayUpgrade()) {
            for (int i = 0; i < this.s.size(); i++) {
                if (this.t == null) {
                    this.t = new ArrayList();
                }
                this.t.add(new BmBitmapResource(this.s.get(i).getBitmap()));
            }
        }
    }

    public void setThinAlgorithm(ThinAndSmoothAlgorithm thinAndSmoothAlgorithm) {
        this.w = thinAndSmoothAlgorithm;
        if (OverlayUtil.isOverlayUpgrade()) {
            this.I.m(this.w.getValue());
            this.f.b();
        }
    }

    public void setThinFactor(float f) {
        if (f > 0.0f) {
            this.x = f;
        }
        if (OverlayUtil.isOverlayUpgrade()) {
            this.I.f(this.x);
            this.f.b();
        }
    }

    public void setThined(boolean z) {
        this.v = z;
        this.listener.c(this);
    }

    public void setTrackBackwardStyle(LineStyle lineStyle) {
        if (lineStyle != null && OverlayUtil.isOverlayUpgrade()) {
            this.K.a(new BmLineStyleOption(256, lineStyle.f3636a));
            this.f.b();
        }
    }

    public void setTrackBackwardStyles(List<LineStyle> list) {
        if (list == null || list.isEmpty() || !OverlayUtil.isOverlayUpgrade() || this.L == null || list.size() != this.L.size()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            this.L.get(i).a(new BmLineStyleOption(256, list.get(i).f3636a));
        }
        this.f.b();
    }

    public void setTrackForwardStyle(LineStyle lineStyle) {
        if (lineStyle != null && OverlayUtil.isOverlayUpgrade()) {
            this.K.a(new BmLineStyleOption(128, lineStyle.f3636a));
            this.f.b();
        }
    }

    public void setTrackForwardStyles(List<LineStyle> list) {
        if (list == null || list.isEmpty() || !OverlayUtil.isOverlayUpgrade() || this.L == null || list.size() != this.L.size()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            this.L.get(i).a(new BmLineStyleOption(128, list.get(i).f3636a));
        }
        this.f.b();
    }

    public void setWidth(int i) {
        if (i > 0) {
            this.l = i;
            this.listener.c(this);
        }
    }

    public void startAnimation() {
        if (this.N == null || !OverlayUtil.isOverlayUpgrade()) {
            return;
        }
        this.N.bmAnimation.start();
        this.f.b();
    }

    @Override // com.baidu.mapapi.map.Overlay
    public BmDrawItem toDrawItem() {
        int[] iArr;
        if (this.B) {
            this.I = new BmGradientLine();
        } else {
            this.I = new BmPolyline();
        }
        this.I.a(this);
        setDrawItem(this.I);
        super.toDrawItem();
        List<LatLng> list = this.h;
        if (list == null || list.size() < 2) {
            throw new IllegalStateException("BDMapSDKException: when you add Polyline, you must at least supply 2 points");
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        List<LatLng> listB = (this.A && this.h.size() == 2) ? f.b(this.h.get(0), this.h.get(1)) : this.h;
        Bundle bundle = new Bundle();
        a(listB, this.Q, bundle);
        if (bundle.containsKey("x_array") && bundle.containsKey("y_array")) {
            double[] doubleArray = bundle.getDoubleArray("x_array");
            double[] doubleArray2 = bundle.getDoubleArray("y_array");
            for (int i2 = 0; i2 < doubleArray.length; i2++) {
                arrayList.add(new com.baidu.platform.comapi.bmsdk.b(doubleArray[i2], doubleArray2[i2]));
            }
        }
        BmGeoElement bmGeoElement = new BmGeoElement(0);
        this.K = bmGeoElement;
        bmGeoElement.a(arrayList);
        BmLineStyle bmLineStyle = new BmLineStyle();
        this.J = bmLineStyle;
        bmLineStyle.d(this.l);
        this.I.c(this.G);
        this.I.g(a(this.P));
        this.I.l(a(this.O));
        this.I.f(a(this.O));
        this.I.i(this.R.ordinal());
        this.I.d(this.C / 2.0f);
        this.I.h(this.H.ordinal());
        this.I.d(this.C / 2);
        this.I.b(this.D);
        this.I.e(this.F);
        this.I.c(this.E);
        this.I.j(this.Q.ordinal());
        this.I.a(this.p);
        this.k = new ArrayList();
        if (this.B && (iArr = this.j) != null && iArr.length > 0) {
            while (true) {
                int[] iArr2 = this.j;
                if (i >= iArr2.length) {
                    break;
                }
                this.k.add(Integer.valueOf(iArr2[i]));
                i++;
            }
            for (int size = this.k.size(); size < this.h.size(); size++) {
                List<Integer> list2 = this.k;
                list2.add(list2.get(list2.size() - 1));
            }
            this.K.a(1, this.k);
            this.K.a(this.J);
            this.I.a(this.K);
            return this.I;
        }
        if (this.A) {
            this.v = false;
            this.B = false;
        }
        if (this.v) {
            this.I.m(this.w.getValue());
            float f = this.x;
            if (f > 0.0f) {
                this.I.f(f);
            }
            if (this.R == PolylineOptions.LineBloomType.NONE) {
                this.I.k(this.y.getValue());
                this.I.e(this.z);
            }
        }
        if (this.m) {
            setDottedBitmapResource(this.J, this.u);
            this.J.c(5);
        } else {
            this.J.b(0);
        }
        List<BmBitmapResource> list3 = this.t;
        if (list3 != null && !list3.isEmpty()) {
            this.L = new ArrayList();
            this.M = new ArrayList();
            int[] iArr3 = this.i;
            if (iArr3 == null || iArr3.length == 0 || iArr3.length != this.h.size() - 1) {
                this.J.a(this.t.get(0));
                this.J.d(this.l);
                this.K.a(this.J);
                this.I.a(this.K);
            } else {
                int i3 = this.i[0];
                while (i < this.i.length) {
                    int i4 = i;
                    while (true) {
                        int[] iArr4 = this.i;
                        if (i4 >= iArr4.length || i3 != iArr4[i4]) {
                            break;
                        }
                        i4++;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = i; i5 <= i4; i5++) {
                        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.h.get(i5));
                        arrayList2.add(new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc.getLongitudeE6(), geoPointLl2mc.getLatitudeE6()));
                    }
                    BmGeoElement bmGeoElement2 = new BmGeoElement();
                    BmLineStyle bmLineStyle2 = new BmLineStyle();
                    bmLineStyle2.d(this.l);
                    bmLineStyle2.a(this.t.get(this.i[i]));
                    bmGeoElement2.a(bmLineStyle2);
                    bmGeoElement2.a(arrayList2);
                    this.L.add(bmGeoElement2);
                    this.I.a(bmGeoElement2);
                    this.M.add(bmLineStyle2);
                    int[] iArr5 = this.i;
                    if (i4 < iArr5.length) {
                        i3 = iArr5[i4];
                    }
                    i = i4;
                }
            }
        } else if (this.j != null) {
            int i6 = 0;
            while (true) {
                int[] iArr6 = this.j;
                if (i6 >= iArr6.length) {
                    break;
                }
                this.k.add(Integer.valueOf(iArr6[i6]));
                i6++;
            }
            for (int size2 = this.k.size(); size2 < this.h.size(); size2++) {
                List<Integer> list4 = this.k;
                list4.add(list4.get(list4.size() - 1));
            }
            ArrayList arrayList3 = new ArrayList();
            this.L = new ArrayList();
            this.M = new ArrayList();
            for (int i7 = 1; i7 < this.h.size(); i7++) {
                ArrayList arrayList4 = new ArrayList();
                GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.h.get(i7 - 1));
                GeoPoint geoPointLl2mc3 = CoordUtil.ll2mc(this.h.get(i7));
                com.baidu.platform.comapi.bmsdk.b bVar = new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc2.getLongitudeE6(), geoPointLl2mc2.getLatitudeE6());
                com.baidu.platform.comapi.bmsdk.b bVar2 = new com.baidu.platform.comapi.bmsdk.b(geoPointLl2mc3.getLongitudeE6(), geoPointLl2mc3.getLatitudeE6());
                arrayList4.add(bVar);
                arrayList4.add(bVar2);
                arrayList3.add(arrayList4);
            }
            while (i < arrayList3.size()) {
                BmGeoElement bmGeoElement3 = new BmGeoElement();
                BmLineStyle bmLineStyle3 = new BmLineStyle();
                bmLineStyle3.d(this.l);
                if (this.m) {
                    setDottedBitmapResource(bmLineStyle3, this.u);
                    bmLineStyle3.c(5);
                }
                bmLineStyle3.a(this.k.get(i).intValue());
                bmGeoElement3.a(bmLineStyle3);
                bmGeoElement3.a((List<com.baidu.platform.comapi.bmsdk.b>) arrayList3.get(i));
                this.L.add(bmGeoElement3);
                this.M.add(bmLineStyle3);
                this.I.a(bmGeoElement3);
                i++;
            }
        } else {
            if (this.q != null) {
                this.J.a(this.r);
            } else {
                this.J.d(this.l);
                this.J.a(this.g);
            }
            this.K.a(this.J);
            this.I.a(this.K);
        }
        return this.I;
    }

    private static int a(PolylineOptions.LineJoinType lineJoinType) {
        int i = a.f3673a[lineJoinType.ordinal()];
        if (i == 1) {
            return 2048;
        }
        if (i != 2) {
            return i != 3 ? 2048 : 4096;
        }
        return 8192;
    }

    private static int a(PolylineOptions.LineCapType lineCapType) {
        int i = a.b[lineCapType.ordinal()];
        return (i == 1 || i != 2) ? 2 : 4;
    }

    @Override // com.baidu.mapapi.map.Overlay
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        List<LatLng> list = this.h;
        if (list != null && list.size() >= 2) {
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.h.get(0));
            bundle.putDouble("location_x", geoPointLl2mc.getLongitudeE6());
            bundle.putDouble("location_y", geoPointLl2mc.getLatitudeE6());
            bundle.putInt("width", this.l);
            bundle.putInt("isClickable", this.p ? 1 : 0);
            bundle.putInt("lineBloomType", this.R.ordinal());
            bundle.putInt("lineBloomWidth", this.C);
            bundle.putInt("lineBloomAlpha", this.D);
            bundle.putFloat("lineBloomGradientASPeed", this.E);
            bundle.putInt("lineBloomBlurTimes", this.F);
            bundle.putInt("isHighPrecision", this.G ? 1 : 0);
            if (this.B) {
                return b(bundle);
            }
            if (this.A && this.h.size() == 2) {
                this.h = f.b(this.h.get(0), this.h.get(1));
            }
            a(this.h, this.Q, bundle);
            Overlay.d(this.g, bundle);
            d(this.i, bundle);
            a(this.j, bundle);
            int[] iArr = this.i;
            if (iArr != null && iArr.length > 0 && iArr.length > this.h.size() - 1) {
                Log.e("baidumapsdk", "the size of textureIndexs is larger than the size of points");
            }
            bundle.putInt("dotline", this.m ? 1 : 0);
            bundle.putInt("focus", this.n ? 1 : 0);
            if (this.A) {
                this.v = false;
                this.B = false;
            }
            bundle.putInt("isThined", this.v ? 1 : 0);
            bundle.putInt("isGradient", this.B ? 1 : 0);
            bundle.putInt("lineJoinType", this.P.ordinal());
            bundle.putInt("lineCapType", this.O.ordinal());
            bundle.putInt("lineDirectionCross180", this.Q.ordinal());
            try {
                String str = "line_texture.png";
                if (this.q != null) {
                    bundle.putInt(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, 1);
                    bundle.putBundle("image_info", a(false, (String) null));
                } else {
                    if (this.m) {
                        bundle.putBundle("image_info", a(true, (String) null));
                        bundle.putInt("dotted_line_type", this.u);
                    } else {
                        bundle.putBundle("image_info", a(true, "line_texture.png"));
                    }
                    bundle.putInt(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, 0);
                }
                if (this.s != null) {
                    bundle.putInt("customlist", 1);
                    bundle.putBundle("image_info_list", b(false, (String) null));
                    bundle.putInt("dotline", 0);
                } else {
                    if (this.m) {
                        str = null;
                    }
                    int[] iArr2 = this.j;
                    if (iArr2 != null && iArr2.length > 0) {
                        bundle.putBundle("image_info_list", b(true, str));
                    } else {
                        BitmapDescriptor bitmapDescriptor = this.q;
                        if (bitmapDescriptor != null) {
                            bundle.putBundle("image_info", bitmapDescriptor.a());
                            bundle.putInt("dotline", 0);
                        } else {
                            bundle.putBundle("image_info", a(true, str));
                        }
                    }
                    bundle.putInt("customlist", 0);
                }
                bundle.putInt("keep", this.o ? 1 : 0);
            } catch (Exception unused) {
                Log.e("baidumapsdk", "load texture resource failed!");
                bundle.putInt("dotline", 0);
            }
            return bundle;
        }
        throw new IllegalStateException("BDMapSDKException: when you add Polyline, you must at least supply 2 points");
    }

    private Bundle b(Bundle bundle) {
        int[] iArr = this.j;
        if (iArr != null) {
            if (iArr.length != 0) {
                b(iArr, bundle);
                a(this.h, this.Q, bundle);
                int length = this.j.length;
                int[] iArr2 = new int[length];
                for (int i = 0; i < length; i++) {
                    iArr2[i] = i;
                }
                if (this.h.size() == this.j.length) {
                    iArr2[r2.length - 1] = r2.length - 2;
                }
                c(iArr2, bundle);
                return bundle;
            }
            throw new IllegalStateException("BDMapSDKException: colors array size can not be Equal to zero");
        }
        throw new IllegalStateException("BDMapSDKException: colors array can not be null");
    }

    private static void b(int[] iArr, Bundle bundle) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        bundle.putIntArray("color_array", iArr);
    }

    private Bundle a(boolean z, String str) {
        if (z) {
            int i = this.u;
            String str2 = i == 1 ? "CircleDashTexture.png" : i == 2 ? "lineDash_Rectangle.png" : "lineDashTexture.png";
            if (str == null) {
                str = str2;
            }
            BitmapDescriptor bitmapDescriptorFromAsset = BitmapDescriptorFactory.fromAsset(str);
            if (bitmapDescriptorFromAsset != null) {
                return bitmapDescriptorFromAsset.a();
            }
        }
        return this.q.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(List<LatLng> list, PolylineOptions.LineDirectionCross180 lineDirectionCross180, Bundle bundle) {
        LatLng latLng;
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i = 0; i < size; i++) {
            LatLng latLng2 = list.get(i);
            if (lineDirectionCross180 == PolylineOptions.LineDirectionCross180.FROM_EAST_TO_WEST) {
                double d = latLng2.longitude;
                if (d < 0.0d) {
                    latLng = new LatLng(latLng2.latitude, d + 360.0d);
                } else if (lineDirectionCross180 == PolylineOptions.LineDirectionCross180.FROM_WEST_TO_EAST) {
                    double d2 = latLng2.longitude;
                    if (d2 > 0.0d) {
                        latLng = new LatLng(latLng2.latitude, d2 - 360.0d);
                    }
                }
                latLng2 = latLng;
            }
            GeoPoint geoPointLl2mc = CoordUtil.ll2mc(latLng2);
            dArr[i] = geoPointLl2mc.getLongitudeE6();
            dArr2[i] = geoPointLl2mc.getLatitudeE6();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
    }
}
