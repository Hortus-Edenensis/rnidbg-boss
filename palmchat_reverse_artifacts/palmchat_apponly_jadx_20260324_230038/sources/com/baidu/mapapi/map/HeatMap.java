package com.baidu.mapapi.map;

import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseIntArray;
import androidx.collection.LongSparseArray;
import com.baidu.mapapi.map.HeatMapAnimation;
import com.baidu.mapapi.model.LatLng;
import com.baidu.platform.comapi.util.SysOSUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class HeatMap {
    public static final Gradient DEFAULT_GRADIENT;
    public static final int DEFAULT_MAX_HIGH = 0;
    public static final int DEFAULT_MAX_LEVEL = 22;
    public static final int DEFAULT_MIN_LEVEL = 4;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f3624a;
    private static final int[] b;
    private static final float[] c;
    private static int d;
    private ExecutorService A;
    private HashSet<String> B;
    BaiduMap C;
    private int D;
    private int e;
    private boolean f;
    private int g;
    private int h;
    private e<WeightedLatLng> i;
    private Collection<WeightedLatLng> j;
    private List<List<WeightedLatLng>> k;
    private float l;
    private float m;
    protected boolean mIsSetMaxIntensity;
    private HeatMapAnimation n;
    private HeatMapAnimation o;
    private int p;
    private int q;
    private Gradient r;
    private double s;
    private c t;
    private int[] u;
    private float[] v;
    private double[] w;
    private double[] x;
    private List<double[]> y;
    private HashMap<String, Tile> z;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Collection<WeightedLatLng> f3625a;
        private List<List<WeightedLatLng>> b;
        private int c = 12;
        private int d = 12;
        private Gradient e = HeatMap.DEFAULT_GRADIENT;
        private double f = 0.6d;
        private int g = 0;
        private boolean h = false;
        private int i = 22;
        private int j = 4;
        private float k = 1.0f;
        private float l = 0.0f;
        private boolean m = false;
        private HeatMapAnimation n;
        private HeatMapAnimation o;

        public Builder() {
            HeatMapAnimation.AnimationType animationType = HeatMapAnimation.AnimationType.Linear;
            this.n = new HeatMapAnimation(false, 100, animationType);
            this.o = new HeatMapAnimation(false, 100, animationType);
        }

        public HeatMap build() {
            if (this.f3625a == null && this.b == null) {
                throw new IllegalStateException("BDMapSDKException: No input data: you must use either .data or .weightedData before building");
            }
            return new HeatMap(this, null);
        }

        public Builder data(Collection<LatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            if (collection.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            return weightedData(HeatMap.d(collection));
        }

        public Builder datas(List<List<LatLng>> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input datas.");
            }
            if (list.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            return weightedDatas(HeatMap.b(list));
        }

        public Builder frameAnimation(HeatMapAnimation heatMapAnimation) {
            this.o = heatMapAnimation;
            return this;
        }

        public Builder gradient(Gradient gradient) {
            if (gradient == null) {
                throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
            }
            this.e = gradient;
            return this;
        }

        public Builder initAnimation(HeatMapAnimation heatMapAnimation) {
            this.n = heatMapAnimation;
            return this;
        }

        public Builder isRadiusMeter(boolean z) {
            this.h = z;
            return this;
        }

        public Builder maxHigh(int i) {
            if (i < 0) {
                return this;
            }
            if (i > 200) {
                this.g = 200;
                return this;
            }
            this.g = i;
            return this;
        }

        public Builder maxIntensity(float f) {
            if (f >= 0.0f && f > this.l) {
                this.k = f;
                this.m = true;
            }
            return this;
        }

        public Builder maxShowLevel(int i) {
            if (i < this.j) {
                return this;
            }
            if (i > 22) {
                this.i = 22;
            }
            this.i = i;
            return this;
        }

        public Builder minIntensity(float f) {
            if (f < 0.0f) {
                this.l = 0.0f;
                return this;
            }
            if (f >= this.k) {
                return this;
            }
            this.l = f;
            return this;
        }

        public Builder minShowLevel(int i) {
            if (i < 4) {
                this.j = 4;
                return this;
            }
            if (i > this.i) {
                return this;
            }
            this.j = i;
            return this;
        }

        public Builder opacity(double d) {
            if (d < 0.0d) {
                this.f = 0.0d;
                return this;
            }
            if (d > 1.0d) {
                this.f = 1.0d;
                return this;
            }
            this.f = d;
            return this;
        }

        public Builder radius(int i) {
            if (i < 10) {
                this.c = 10;
                return this;
            }
            if (i > 50) {
                this.c = 50;
                return this;
            }
            this.c = i;
            return this;
        }

        public Builder radiusMeter(int i) {
            if (i < 10) {
                this.d = 10;
                return this;
            }
            if (i > 50) {
                this.d = 50;
                return this;
            }
            this.d = i;
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            if (collection.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            this.f3625a = collection;
            return this;
        }

        public Builder weightedDatas(List<List<WeightedLatLng>> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            if (list.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            this.b = list;
            return this;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3624a = sparseIntArray;
        sparseIntArray.put(3, 8388608);
        sparseIntArray.put(4, 4194304);
        sparseIntArray.put(5, 2097152);
        sparseIntArray.put(6, 1048576);
        sparseIntArray.put(7, 524288);
        sparseIntArray.put(8, 262144);
        sparseIntArray.put(9, 131072);
        sparseIntArray.put(10, 65536);
        sparseIntArray.put(11, 32768);
        sparseIntArray.put(12, 16384);
        sparseIntArray.put(13, 8192);
        sparseIntArray.put(14, 4096);
        sparseIntArray.put(15, 2048);
        sparseIntArray.put(16, 1024);
        sparseIntArray.put(17, 512);
        sparseIntArray.put(18, 256);
        sparseIntArray.put(19, 128);
        sparseIntArray.put(20, 64);
        int[] iArr = {Color.rgb(0, 0, 200), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
        b = iArr;
        float[] fArr = {0.08f, 0.4f, 1.0f};
        c = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
        d = 0;
    }

    public /* synthetic */ HeatMap(Builder builder, d dVar) {
        this(builder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<List<WeightedLatLng>> b(List<List<LatLng>> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<List<LatLng>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((List) d(it.next()));
        }
        return arrayList;
    }

    private void c(Collection<WeightedLatLng> collection) {
        this.j = collection;
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }
        c cVarB = b(this.j);
        this.t = cVarB;
        this.i = new e<>(cVarB);
        Iterator<WeightedLatLng> it = this.j.iterator();
        while (it.hasNext()) {
            this.i.a(it.next());
        }
        this.x = a(this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> d(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new WeightedLatLng(it.next()));
        }
        return arrayList;
    }

    public HeatMapData getData(int i, int i2) {
        List<List<WeightedLatLng>> list;
        if (i2 > 23 || i2 < 4 || ((list = this.k) == null && this.j == null)) {
            return null;
        }
        if (list != null) {
            return a(i, i2);
        }
        if (this.j != null) {
            return b(i, i2);
        }
        return null;
    }

    public int getMaxHigh() {
        return this.e;
    }

    public boolean isFrameAnimation() {
        HeatMapAnimation heatMapAnimation = this.n;
        if (heatMapAnimation == null) {
            return false;
        }
        return heatMapAnimation.getIsAnimation();
    }

    public boolean isInitAnimation() {
        HeatMapAnimation heatMapAnimation = this.o;
        if (heatMapAnimation == null) {
            return false;
        }
        return heatMapAnimation.getIsAnimation();
    }

    public void removeHeatMap() {
        BaiduMap baiduMap = this.C;
        if (baiduMap != null) {
            baiduMap.a(this);
        }
        List<List<WeightedLatLng>> list = this.k;
        if (list != null) {
            list.clear();
        }
        Collection<WeightedLatLng> collection = this.j;
        if (collection != null) {
            collection.clear();
        }
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("grid_size", this.D);
        bundle.putFloat("point_size_meter", this.q * 2);
        bundle.putFloat("point_size", this.p * 2);
        bundle.putFloat("max_hight", this.e);
        bundle.putFloat("alpha", (float) this.s);
        List<List<WeightedLatLng>> list = this.k;
        if (list != null) {
            bundle.putInt("frame_count", list.size());
        } else if (this.j != null) {
            bundle.putInt("frame_count", 1);
        }
        bundle.putIntArray("color_array", this.u);
        bundle.putFloatArray("color_start_points", this.v);
        bundle.putBoolean("is_need_init_animation", this.o.getIsAnimation());
        bundle.putBoolean("is_need_frame_animation", this.n.getIsAnimation());
        bundle.putBoolean("point_size_is_meter", this.f);
        bundle.putInt("init_animation_duration", this.o.getDuration());
        bundle.putInt("init_animation_type", this.o.getAnimationType());
        bundle.putInt("frame_animation_duration", this.n.getDuration());
        bundle.putInt("frame_animation_type", this.n.getAnimationType());
        bundle.putFloat("max_intentity", this.l);
        bundle.putFloat("min_intentity", this.m);
        bundle.putFloat("max_show_level", this.g);
        bundle.putFloat("min_show_level", this.h);
        return bundle;
    }

    public void updateData(Collection<LatLng> collection) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }
        if (collection.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        }
        updateWeightedData(d(collection));
    }

    public void updateDatas(List<List<LatLng>> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: No input datas.");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        }
        updateWeightedDatas(b(list));
    }

    public void updateFrameAnimation(HeatMapAnimation heatMapAnimation) {
        this.n = heatMapAnimation;
    }

    public void updateGradient(Gradient gradient) {
        if (gradient == null) {
            throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
        }
        this.r = gradient;
        a(gradient);
    }

    public void updateIsRadiusMeter(boolean z) {
        this.f = z;
    }

    public void updateMaxHigh(int i) {
        if (i < 0) {
            return;
        }
        if (i > 200) {
            this.e = 200;
        } else {
            this.e = i;
        }
    }

    public void updateMaxIntensity(float f) {
        if (f < 0.0f || f <= this.m) {
            return;
        }
        this.l = f;
    }

    public void updateMaxShowLevel(int i) {
        if (i < this.h) {
            return;
        }
        if (i > 22) {
            this.g = 22;
        } else {
            this.g = i;
        }
    }

    public void updateMinIntensity(float f) {
        if (f < 0.0f) {
            this.m = 0.0f;
        } else {
            if (f >= this.l) {
                return;
            }
            this.m = f;
        }
    }

    public void updateMinShowLevel(int i) {
        if (i < 4) {
            this.h = 4;
        } else {
            if (i > this.g) {
                return;
            }
            this.h = i;
        }
    }

    public void updateOpacity(double d2) {
        if (d2 < 0.0d) {
            this.s = 0.0d;
        } else if (d2 > 1.0d) {
            this.s = 1.0d;
        } else {
            this.s = d2;
        }
    }

    public void updateRadius(int i) {
        if (i < 10) {
            this.p = 10;
        } else if (i > 50) {
            this.p = 50;
        } else {
            this.p = i;
        }
    }

    public void updateRadiusMeter(int i) {
        if (i < 10) {
            this.q = 10;
        } else if (i > 50) {
            this.q = 50;
        } else {
            this.q = i;
        }
    }

    public void updateWeightedData(Collection<WeightedLatLng> collection) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }
        if (collection.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        }
        this.j = collection;
    }

    public void updateWeightedDatas(List<List<WeightedLatLng>> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("BDMapSDKException: No input points.");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
        }
        this.k = list;
    }

    private HeatMap(Builder builder) {
        this.e = 200;
        this.f = false;
        this.g = 22;
        this.h = 4;
        this.D = SysOSUtil.getInstance().getScreenWidth() / 2;
        this.z = new HashMap<>();
        this.A = Executors.newFixedThreadPool(1);
        this.B = new HashSet<>();
        this.k = builder.b;
        this.p = builder.c;
        this.q = builder.d;
        this.f = builder.h;
        this.g = builder.i;
        this.h = builder.j;
        boolean z = builder.m;
        this.mIsSetMaxIntensity = z;
        if (!z && this.k != null) {
            this.y = new ArrayList();
            for (int i = 0; i < this.k.size(); i++) {
                List<WeightedLatLng> list = this.k.get(i);
                this.j = list;
                this.t = b(list);
                this.y.add(a(this.p));
            }
        }
        Collection<WeightedLatLng> collection = builder.f3625a;
        this.j = collection;
        if (!this.mIsSetMaxIntensity && collection != null) {
            c(collection);
        }
        this.o = builder.n;
        this.n = builder.o;
        this.e = builder.g;
        this.l = builder.k;
        this.m = builder.l;
        this.r = builder.e;
        this.s = builder.f;
        int i2 = this.p;
        this.w = a(i2, ((double) i2) / 3.0d);
        a(this.r);
    }

    private HeatMapData a(int i, int i2) {
        List<List<WeightedLatLng>> list = this.k;
        if (list == null || i >= list.size()) {
            return null;
        }
        List<WeightedLatLng> list2 = this.k.get(i);
        List<double[]> list3 = this.y;
        return new HeatMapData(list2, (list3 == null || list3.size() <= i) ? 0.0f : (float) this.y.get(i)[i2]);
    }

    private HeatMapData b(int i, int i2) {
        Collection<WeightedLatLng> collection = this.j;
        if (collection == null) {
            return null;
        }
        double[] dArr = this.x;
        return new HeatMapData(collection, dArr != null ? (float) dArr[i2] : 0.0f);
    }

    private synchronized void b() {
        this.z.clear();
    }

    public void c() {
        this.A.shutdownNow();
    }

    private static c b(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d2 = next.getPoint().x;
        double d3 = d2;
        double d4 = next.getPoint().x;
        double d5 = next.getPoint().y;
        double d6 = next.getPoint().y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d7 = next2.getPoint().x;
            double d8 = next2.getPoint().y;
            if (d7 < d3) {
                d3 = d7;
            }
            if (d7 > d4) {
                d4 = d7;
            }
            if (d8 < d5) {
                d5 = d8;
            }
            if (d8 > d6) {
                d6 = d8;
            }
        }
        return new c(d3, d4, d5, d6);
    }

    public void a() {
        b();
    }

    private void a(Gradient gradient) {
        this.r = gradient;
        this.u = gradient.a(this.s);
        this.v = gradient.b();
    }

    private double[] a(int i) {
        int i2;
        double[] dArr = new double[23];
        int i3 = 4;
        while (true) {
            if (i3 >= 11) {
                break;
            }
            dArr[i3] = a(this.j, this.t, i, (int) (Math.pow(2.0d, i3 - 3) * 1280.0d));
            if (i3 == 4) {
                for (int i4 = 0; i4 < i3; i4++) {
                    dArr[i4] = dArr[i3];
                }
            }
            i3++;
        }
        for (i2 = 11; i2 < 23; i2++) {
            dArr[i2] = dArr[10];
        }
        return dArr;
    }

    private static double[] a(int i, double d2) {
        double[] dArr = new double[(i * 2) + 1];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((double) ((-i2) * i2)) / ((2.0d * d2) * d2));
        }
        return dArr;
    }

    private static double a(Collection<WeightedLatLng> collection, c cVar, int i, int i2) {
        double d2 = cVar.f3728a;
        double d3 = cVar.c;
        double d4 = cVar.b;
        double d5 = d3 - d2;
        double d6 = cVar.d - d4;
        if (d5 <= d6) {
            d5 = d6;
        }
        double d7 = ((double) ((int) (((double) (i2 / (i * 2))) + 0.5d))) / d5;
        LongSparseArray longSparseArray = new LongSparseArray();
        double dDoubleValue = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            double d8 = weightedLatLng.getPoint().x;
            int i3 = (int) ((((double) weightedLatLng.getPoint().y) - d4) * d7);
            long j = (int) ((d8 - d2) * d7);
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.put(j, longSparseArray2);
            }
            long j2 = i3;
            Double dValueOf = (Double) longSparseArray2.get(j2);
            if (dValueOf == null) {
                dValueOf = Double.valueOf(0.0d);
            }
            LongSparseArray longSparseArray3 = longSparseArray;
            double d9 = d2;
            Double dValueOf2 = Double.valueOf(dValueOf.doubleValue() + weightedLatLng.intensity);
            longSparseArray2.put(j2, dValueOf2);
            if (dValueOf2.doubleValue() > dDoubleValue) {
                dDoubleValue = dValueOf2.doubleValue();
            }
            longSparseArray = longSparseArray3;
            d2 = d9;
        }
        return dDoubleValue;
    }
}
