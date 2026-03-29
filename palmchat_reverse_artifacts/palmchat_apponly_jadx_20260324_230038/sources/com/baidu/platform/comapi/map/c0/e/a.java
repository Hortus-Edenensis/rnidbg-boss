package com.baidu.platform.comapi.map.c0.e;

import android.graphics.Point;
import android.view.MotionEvent;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.c0.a;
import com.baidu.platform.comapi.map.v;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4196a = 0;
    private boolean b = false;
    private a.C0104a c;
    private MapController d;
    private InterfaceC0105a e;

    /* JADX INFO: renamed from: com.baidu.platform.comapi.map.c0.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0105a {
        boolean a(a aVar);
    }

    public a(InterfaceC0105a interfaceC0105a, MapController mapController) {
        this.e = interfaceC0105a;
        this.d = mapController;
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2 || this.c == null) {
            return;
        }
        a.C0104a c0104aA = a.C0104a.a(motionEvent);
        boolean z = Math.abs(new a.C0104a(this.c.f4186a, c0104aA.f4186a).b()) < 20.0d && Math.abs(new a.C0104a(this.c.b, c0104aA.b).b()) < 20.0d;
        boolean z2 = System.currentTimeMillis() - this.f4196a < 200;
        if (this.d != null) {
            float x = motionEvent.getX(1) - motionEvent.getX(0);
            float y = motionEvent.getY(1) - motionEvent.getY();
            Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            Point point2 = new Point((int) (motionEvent.getRawX() + x), (int) (motionEvent.getRawY() + y));
            this.d.getMapView();
            if (z && z2 && this.b) {
                List<v> listeners = this.d.getListeners();
                s mapStatusInner = this.d.getMapStatusInner();
                if (listeners != null) {
                    for (int i = 0; i < listeners.size(); i++) {
                        v vVar = listeners.get(i);
                        if (vVar != null && vVar.a(point, point2, mapStatusInner)) {
                            return;
                        }
                    }
                }
                this.e.a(this);
            }
        }
    }

    private void c(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 2) {
            return;
        }
        this.c = a.C0104a.a(motionEvent);
        this.b = true;
    }

    public void b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f4196a = System.currentTimeMillis();
            return;
        }
        if (action != 5) {
            if (action != 6) {
                if (action != 261) {
                    if (action != 262) {
                        return;
                    }
                }
            }
            a(motionEvent);
            a();
            return;
        }
        c(motionEvent);
    }

    private void a() {
        this.b = false;
        this.c = null;
        this.f4196a = 0L;
    }
}
