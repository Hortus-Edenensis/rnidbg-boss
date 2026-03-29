package defpackage;

import com.amap.api.maps2d.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class bv4<T> implements jd0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LatLng f1828a;
    public T b;

    public bv4(LatLng latLng, T t) {
        this.f1828a = latLng;
        this.b = t;
    }

    public T a() {
        return this.b;
    }

    @Override // defpackage.jd0
    public LatLng getPosition() {
        return this.f1828a;
    }
}
