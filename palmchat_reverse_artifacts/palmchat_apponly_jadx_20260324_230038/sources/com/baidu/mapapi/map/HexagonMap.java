package com.baidu.mapapi.map;

import android.graphics.Color;
import android.os.Bundle;
import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class HexagonMap {
    public static final Gradient DEFAULT_GRADIENT;
    public static final int DEFAULT_MAX_HIGH = 0;
    public static final int DEFAULT_MAX_LEVEL = 22;
    public static final int DEFAULT_MIN_LEVEL = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f3629a;
    private static final float[] b;
    private Collection<WeightedLatLng> c;
    private float d;
    private float e;
    private HexagonType f;
    private float g;
    private float h;
    protected b hexagonMapLayerListener;
    private float i;
    private Gradient j;
    private int k;
    private int l;
    private int[] m;
    private float[] n;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Collection<WeightedLatLng> f3630a;
        private float b = 200.0f;
        private HexagonType c = HexagonType.VERTEX_UP;
        private float d = 5.0f;
        private Gradient e = HexagonMap.DEFAULT_GRADIENT;
        private float f = 1.0f;
        private int g = 0;
        private int h = 22;
        private int i = 4;
        private float j = 1.0f;
        private float k = 0.0f;

        public HexagonMap build() {
            if (this.f3630a != null) {
                return new HexagonMap(this);
            }
            throw new IllegalStateException("BDMapSDKException: No input data: you must use either .data or .weightedData before building");
        }

        public Builder data(Collection<LatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            if (collection.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            return weightedData(HexagonMap.b(collection));
        }

        public Builder gap(float f) {
            if (f < 0.0f) {
                this.d = 0.0f;
                return this;
            }
            this.d = f;
            return this;
        }

        public Builder gradient(Gradient gradient) {
            if (gradient == null) {
                throw new IllegalArgumentException("BDMapSDKException: gradient can not be null");
            }
            this.e = gradient;
            return this;
        }

        public Builder hexagonType(HexagonType hexagonType) {
            this.c = hexagonType;
            return this;
        }

        public Builder maxIntensity(float f) {
            if (f >= 0.0f && f > this.k) {
                this.j = f;
            }
            return this;
        }

        public Builder maxShowLevel(int i) {
            if (i < this.i) {
                return this;
            }
            if (i > 22) {
                this.h = 22;
            }
            this.h = i;
            return this;
        }

        public Builder minIntensity(float f) {
            if (f < 0.0f) {
                this.k = 0.0f;
                return this;
            }
            if (f >= this.j) {
                return this;
            }
            this.k = f;
            return this;
        }

        public Builder minShowLevel(int i) {
            if (i < 4) {
                this.i = 4;
                return this;
            }
            if (i > this.h) {
                return this;
            }
            this.i = i;
            return this;
        }

        public Builder opacity(float f) {
            if (f < 0.0f) {
                this.f = 0.0f;
                return this;
            }
            if (f > 1.0f) {
                this.f = 1.0f;
                return this;
            }
            this.f = f;
            return this;
        }

        public Builder radius(int i) {
            if (i < 0) {
                return this;
            }
            this.b = i;
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            if (collection == null || collection.isEmpty()) {
                throw new IllegalArgumentException("BDMapSDKException: No input points.");
            }
            if (collection.contains(null)) {
                throw new IllegalArgumentException("BDMapSDKException: input points can not contain null.");
            }
            this.f3630a = collection;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum HexagonType {
        VERTEX_UP,
        EDGE_UP
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(HexagonMap hexagonMap);

        void a(HexagonMap hexagonMap, boolean z);
    }

    static {
        int[] iArr = {Color.rgb(0, 0, 250), Color.rgb(0, 225, 0), Color.rgb(255, 0, 0)};
        f3629a = iArr;
        float[] fArr = {0.0f, 0.5f, 1.0f};
        b = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> b(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new WeightedLatLng(it.next()));
        }
        return arrayList;
    }

    public void remove() {
        Collection<WeightedLatLng> collection = this.c;
        if (collection != null) {
            collection.clear();
        }
        this.hexagonMapLayerListener.a(this);
    }

    public void setShow(boolean z) {
        this.hexagonMapLayerListener.a(this, z);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putFloat("radius", this.d);
        bundle.putFloat("gap", this.e);
        bundle.putFloat("alpha", this.g);
        new HexagonMapData(this.c, this.h).toBundle(bundle);
        bundle.putIntArray("color_array", this.m);
        bundle.putInt("hexagon_type", this.f.ordinal());
        bundle.putFloatArray("color_start_points", this.n);
        bundle.putFloat("max_intentity", this.h);
        bundle.putFloat("min_intentity", this.i);
        bundle.putFloat("max_show_level", this.k);
        bundle.putFloat("min_show_level", this.l);
        return bundle;
    }

    private HexagonMap(Builder builder) {
        this.c = builder.f3630a;
        this.d = builder.b;
        this.e = builder.d;
        this.f = builder.c;
        this.j = builder.e;
        this.k = builder.h;
        this.l = builder.i;
        this.h = builder.j;
        this.i = builder.k;
        this.g = builder.f;
        a(this.j);
    }

    private void a(Gradient gradient) {
        this.j = gradient;
        this.m = gradient.a(this.g);
        this.n = gradient.b();
    }
}
