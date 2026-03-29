package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ParticleOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<BitmapDescriptor> f3669a;
    private LatLng b;

    public List<BitmapDescriptor> getParticleImgs() {
        return this.f3669a;
    }

    public LatLng getParticlePos() {
        return this.b;
    }

    public void setParticleImgs(List<BitmapDescriptor> list) {
        this.f3669a = list;
    }

    public void setParticlePos(LatLng latLng) {
        this.b = latLng;
    }
}
