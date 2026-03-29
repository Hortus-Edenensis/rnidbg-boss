package com.baidu.platform.comapi.map.c0.f;

import android.graphics.Point;
import android.util.Pair;
import android.view.MotionEvent;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.c0.a;
import com.baidu.platform.comapi.map.v;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c extends a {
    private boolean b;
    private long c;
    private MapController d;

    public c(MapController mapController) {
        super(mapController);
        this.b = true;
        this.d = mapController;
    }

    @Override // com.baidu.platform.comapi.map.c0.f.a
    public void a(com.baidu.platform.comapi.map.c0.e.b bVar, MotionEvent motionEvent) {
        a.C0104a c0104a = bVar.b;
        a.C0104a c0104a2 = bVar.c;
        MapStatus mapStatus = this.d.getMapStatus();
        double d = c0104a2.f4186a.b - c0104a.f4186a.b;
        double d2 = c0104a2.b.b - c0104a.b.b;
        double d3 = d * d2;
        if (d3 > 0.0d) {
            a(d, mapStatus);
        } else if (d3 == 0.0d) {
            if (d != 0.0d) {
                a(d, mapStatus);
            } else if (d2 != 0.0d) {
                a(d2, mapStatus);
            }
        } else if (Math.abs(d) > Math.abs(d2)) {
            a(d, mapStatus);
        } else {
            a(d2, mapStatus);
        }
        float x = motionEvent.getX(1) - motionEvent.getX(0);
        float y = motionEvent.getY(1) - motionEvent.getY(0);
        Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        Point point2 = new Point((int) (motionEvent.getRawX() + x), (int) (motionEvent.getRawY() + y));
        List<v> listeners = this.d.getListeners();
        if (listeners != null) {
            s mapStatusInner = this.d.getMapStatusInner();
            for (int i = 0; i < listeners.size(); i++) {
                v vVar = listeners.get(i);
                if (vVar != null && vVar.b(point, point2, mapStatusInner)) {
                    return;
                }
            }
        }
        this.d.setMapStatus(mapStatus);
        if (this.b) {
            this.b = false;
            this.d.getGestureMonitor().b();
        }
    }

    @Override // com.baidu.platform.comapi.map.c0.f.a
    public void a(com.baidu.platform.comapi.map.c0.e.b bVar, Pair<a.d, a.d> pair) {
        MapStatus mapStatus = this.d.getMapStatus();
        if (mapStatus.bOverlookSpringback) {
            if (mapStatus.overlooking > 0.0d) {
                mapStatus.overlooking = 0.0d;
            } else {
                mapStatus.overlooking = mapStatus.minOverlooking;
            }
            this.d.setMapStatusWithAnimation(mapStatus, 200);
        }
    }

    private void a(double d, MapStatus mapStatus) {
        if (this.c == 0) {
            this.c = System.currentTimeMillis();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.c = jCurrentTimeMillis;
        if (jCurrentTimeMillis - jCurrentTimeMillis > 50 || Math.abs(d) < 4.0d) {
            return;
        }
        if (d > 0.0d) {
            mapStatus.overlooking -= 4.0d;
        } else {
            mapStatus.overlooking += 2.0d;
        }
    }
}
