package com.baidu.mapapi.map;

import android.os.Bundle;
import java.util.Collection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class HexagonMapData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double[] f3632a;
    private double[] b;
    private double[] c;
    private float d;

    public HexagonMapData(Collection<WeightedLatLng> collection, float f) {
        int size = collection.size();
        this.f3632a = new double[size];
        this.b = new double[size];
        this.c = new double[size];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (WeightedLatLng weightedLatLng : collection) {
            this.f3632a[i] = weightedLatLng.getPoint().x;
            this.b[i2] = weightedLatLng.getPoint().y;
            this.c[i3] = weightedLatLng.getIntensity();
            i3++;
            i2++;
            i++;
        }
        this.d = f;
    }

    public void toBundle(Bundle bundle) {
        bundle.putDoubleArray("x_array", this.f3632a);
        bundle.putDoubleArray("y_array", this.b);
        bundle.putDoubleArray("z_array", this.c);
    }
}
