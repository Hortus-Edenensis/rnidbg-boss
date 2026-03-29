package com.baidu.platform.comapi.map.c0;

import android.view.MotionEvent;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.c0.e.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MapController f4190a;
    private com.baidu.platform.comapi.map.c0.e.b b;
    private com.baidu.platform.comapi.map.c0.e.a c;
    a.InterfaceC0105a d = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements a.InterfaceC0105a {
        public a() {
        }

        @Override // com.baidu.platform.comapi.map.c0.e.a.InterfaceC0105a
        public boolean a(com.baidu.platform.comapi.map.c0.e.a aVar) {
            if (!b.this.f4190a.isTwoTouchClickZoomEnabled()) {
                return false;
            }
            b.this.f4190a.setActingTwoClickZoom(true);
            b.this.f4190a.getGestureMonitor().b(b.this.f4190a.getZoomLevel() - 1.0f);
            b.this.f4190a.mapStatusChangeStart();
            b.this.f4190a.MapMsgProc(8193, 4, 0);
            if (b.this.f4190a.isNaviMode() && b.this.f4190a.getNaviMapViewListener() != null) {
                b.this.f4190a.getNaviMapViewListener().onAction(521, null);
            }
            return true;
        }
    }

    public b(MapController mapController) {
        this.f4190a = mapController;
        this.b = new com.baidu.platform.comapi.map.c0.e.b(new com.baidu.platform.comapi.map.c0.f.b(mapController));
        this.c = new com.baidu.platform.comapi.map.c0.e.a(this.d, mapController);
    }

    public void a(MotionEvent motionEvent) {
        this.b.b(motionEvent);
        this.c.b(motionEvent);
    }
}
