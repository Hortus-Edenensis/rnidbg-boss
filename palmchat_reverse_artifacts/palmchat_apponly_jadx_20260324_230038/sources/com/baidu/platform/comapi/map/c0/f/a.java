package com.baidu.platform.comapi.map.c0.f;

import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.c0.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected MapController f4198a;

    public a(MapController mapController) {
        this.f4198a = mapController;
    }

    public void a(com.baidu.platform.comapi.map.c0.e.b bVar) {
    }

    public abstract void a(com.baidu.platform.comapi.map.c0.e.b bVar, Pair<a.d, a.d> pair);

    public abstract void a(com.baidu.platform.comapi.map.c0.e.b bVar, MotionEvent motionEvent);
}
