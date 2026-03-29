package defpackage;

import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import defpackage.jd0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class hd0<T extends jd0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LatLng f17931a;
    public List<T> b = new ArrayList();
    public Marker c;
    public T d;

    public hd0(LatLng latLng) {
        this.f17931a = latLng;
    }

    public void a(T t) {
        this.b.add(t);
    }

    public LatLng b() {
        return this.f17931a;
    }

    public List<T> c() {
        return this.b;
    }

    public Marker d() {
        return this.c;
    }

    public T e() {
        return this.d;
    }

    public void f(Marker marker) {
        this.c = marker;
    }

    public void g(T t) {
        this.d = t;
    }
}
