package com.baidu.platform.comapi.map;

import android.graphics.Point;
import android.view.MotionEvent;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface v {
    void a();

    void a(MotionEvent motionEvent);

    void a(com.baidu.mapsdkplatform.comapi.map.s sVar);

    void a(GeoPoint geoPoint);

    void a(GL10 gl10, com.baidu.mapsdkplatform.comapi.map.s sVar);

    void a(boolean z);

    void a(boolean z, int i);

    boolean a(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.s sVar);

    boolean a(Point point, com.baidu.mapsdkplatform.comapi.map.s sVar);

    boolean a(MotionEvent motionEvent, float f, float f2, com.baidu.mapsdkplatform.comapi.map.s sVar);

    boolean a(BmDrawItem bmDrawItem);

    boolean a(String str);

    void b();

    void b(com.baidu.mapsdkplatform.comapi.map.s sVar);

    void b(GeoPoint geoPoint);

    void b(String str);

    boolean b(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.s sVar);

    void c();

    void c(com.baidu.mapsdkplatform.comapi.map.s sVar);

    void c(GeoPoint geoPoint);

    boolean c(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.s sVar);

    void d();

    void d(GeoPoint geoPoint);

    boolean d(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.s sVar);

    void e(GeoPoint geoPoint);

    void f(GeoPoint geoPoint);

    void g(GeoPoint geoPoint);

    void onFirstMapTileLoaded();
}
