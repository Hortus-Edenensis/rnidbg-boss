package com.amap.api.col.p0002sl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class bc extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    m f2630a;
    a b;
    private ArrayList<as> c;
    private ArrayList<ak> d;
    private volatile int e;
    private Handler f;
    private Runnable g;
    private an h;
    private ak i;
    private ak j;
    private float k;
    private CopyOnWriteArrayList<Integer> l;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Serializable, Comparator<al> {
        private static int a(al alVar, al alVar2) {
            if (alVar == null || alVar2 == null) {
                return 0;
            }
            try {
                if (alVar.getZIndex() > alVar2.getZIndex()) {
                    return 1;
                }
                return alVar.getZIndex() < alVar2.getZIndex() ? -1 : 0;
            } catch (Throwable th) {
                ct.a(th, "MapOverlayImageView", "compare");
                return 0;
            }
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(al alVar, al alVar2) {
            return a(alVar, alVar2);
        }
    }

    public bc(Context context, m mVar) {
        super(context, null);
        this.c = new ArrayList<>(8);
        this.d = new ArrayList<>(8);
        this.e = 0;
        this.b = new a();
        this.f = new Handler();
        this.g = new Runnable() { // from class: com.amap.api.col.2sl.bc.1
            @Override // java.lang.Runnable
            public final synchronized void run() {
                try {
                    Collections.sort(bc.this.d, bc.this.b);
                    Collections.sort(bc.this.c, bc.this.b);
                    bc.this.postInvalidate();
                } catch (Throwable th) {
                    hd.c(th, "MapOverlayImageView", "changeOverlayIndex");
                }
            }
        };
        this.j = null;
        this.k = 0.0f;
        this.l = new CopyOnWriteArrayList<>();
        this.f2630a = mVar;
    }

    private int h() {
        int i = this.e;
        this.e = i + 1;
        return i;
    }

    private void i() {
        ak akVar;
        for (ak akVar2 : this.d) {
            if (akVar2 != null && (akVar = this.i) != null && akVar.getId().equals(akVar2.getId())) {
                try {
                    if (this.i.isViewMode()) {
                        return;
                    }
                } catch (RemoteException e) {
                    ct.a(e, "MapOverlayImageView", "redrawInfoWindow");
                }
                Rect rectA = akVar2.a();
                this.h = new an(rectA.left + (akVar2.getWidth() / 2), rectA.top);
                this.f2630a.redrawInfoWindow();
            }
        }
    }

    public final synchronized void c() {
        try {
            ArrayList<ak> arrayList = this.d;
            if (arrayList != null) {
                Iterator<ak> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().destroy();
                }
                this.d.clear();
            }
            ArrayList<as> arrayList2 = this.c;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            this.f2630a.postInvalidate();
        } catch (Throwable th) {
            ct.a(th, "MapOverlayImageView", "clear");
        }
    }

    public final void d() {
        this.f.removeCallbacks(this.g);
        this.f.postDelayed(this.g, 5L);
    }

    public final void e(ak akVar) {
        if (f(akVar)) {
            this.f2630a.d();
        }
    }

    public final boolean f(ak akVar) {
        return this.f2630a.b(akVar);
    }

    public final synchronized List<Marker> g() {
        ArrayList arrayList;
        ak next;
        LatLng realPosition;
        arrayList = new ArrayList();
        Rect rect = new Rect(0, 0, this.f2630a.getMapWidth(), this.f2630a.getMapHeight());
        an anVar = new an();
        Iterator<ak> it = this.d.iterator();
        while (it.hasNext() && (realPosition = (next = it.next()).getRealPosition()) != null) {
            this.f2630a.b(realPosition.latitude, realPosition.longitude, anVar);
            if (a(rect, anVar.f2618a, anVar.b)) {
                arrayList.add(new Marker(next));
            }
        }
        return arrayList;
    }

    public final m a() {
        return this.f2630a;
    }

    public final int b() {
        return this.d.size();
    }

    public final void f() {
        try {
            Handler handler = this.f;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            c();
        } catch (Exception e) {
            ct.a(e, "MapOverlayImageView", "destory");
            Log.d("amapApi", "MapOverlayImageView clear erro" + e.getMessage());
        }
    }

    public final synchronized ak a(String str) throws RemoteException {
        for (ak akVar : this.d) {
            if (akVar != null && akVar.getId().equals(str)) {
                return akVar;
            }
        }
        return null;
    }

    public final synchronized void b(as asVar) {
        this.c.remove(asVar);
        postInvalidate();
    }

    public final void d(ak akVar) {
        if (this.h == null) {
            this.h = new an();
        }
        Rect rectA = akVar.a();
        this.h = new an(rectA.left + (akVar.getWidth() / 2), rectA.top);
        this.i = akVar;
        try {
            this.f2630a.getMainHandler().post(new Runnable() { // from class: com.amap.api.col.2sl.bc.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        bc bcVar = bc.this;
                        bcVar.f2630a.a(bcVar.e());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            ct.a(th, "MapOverlayImageView", "showInfoWindow");
        }
    }

    public final ak e() {
        return this.i;
    }

    public final synchronized boolean b(ak akVar) {
        boolean zRemove;
        e(akVar);
        zRemove = this.d.remove(akVar);
        postInvalidate();
        this.f2630a.postInvalidate();
        return zRemove;
    }

    public final synchronized void a(ak akVar) {
        try {
            e(akVar);
            akVar.setAddIndex(h());
            this.d.remove(akVar);
            this.d.add(akVar);
            Collections.sort(this.d, this.b);
        } catch (Throwable th) {
            ct.a(th, "MapOverlayImageView", "addMarker");
        }
    }

    private ak b(Iterator<ak> it, Rect rect, an anVar) {
        while (it.hasNext()) {
            ak next = it.next();
            LatLng realPosition = next.getRealPosition();
            if (realPosition != null) {
                this.f2630a.b(realPosition.latitude, realPosition.longitude, anVar);
                if (a(rect, anVar.f2618a, anVar.b)) {
                    return next;
                }
            }
        }
        return null;
    }

    public final synchronized void c(ak akVar) {
        if (akVar != null) {
            ak akVar2 = this.j;
            if (akVar2 != akVar) {
                if (akVar2 != null && akVar2.getZIndex() == 2.1474836E9f) {
                    this.j.setZIndex(this.k);
                }
                this.k = akVar.getZIndex();
                this.j = akVar;
                akVar.setZIndex(2.1474836E9f);
                d();
            }
        }
    }

    public final synchronized void a(as asVar) throws RemoteException {
        this.c.remove(asVar);
        asVar.setAddIndex(h());
        this.c.add(asVar);
        Collections.sort(this.c, this.b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        r5.h = new com.amap.api.col.p0002sl.an(r2.left + (r1.getWidth() / 2), r2.top);
        r5.i = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean b(MotionEvent motionEvent) {
        boolean zA;
        int size = this.d.size() - 1;
        while (true) {
            if (size >= 0) {
                ak akVar = this.d.get(size);
                if (akVar != null && (zA = a((r2 = akVar.a()), (int) motionEvent.getX(), (int) motionEvent.getY()))) {
                    break;
                }
                size--;
            } else {
                zA = false;
                break;
            }
        }
        return zA;
    }

    public final synchronized void a(Canvas canvas) {
        i();
        Rect rect = new Rect(0, 0, this.f2630a.getMapWidth(), this.f2630a.getMapHeight());
        an anVar = new an();
        Iterator<ak> it = this.d.iterator();
        Iterator<as> it2 = this.c.iterator();
        ak akVarB = b(it, rect, anVar);
        as asVarA = a(it2, rect, anVar);
        while (true) {
            if (akVarB != null || asVarA != null) {
                if (akVarB == null) {
                    asVarA.draw(canvas);
                    asVarA = a(it2, rect, anVar);
                } else if (asVarA == null) {
                    akVarB.a(canvas);
                    akVarB = b(it, rect, anVar);
                } else {
                    if (akVarB.getZIndex() >= asVarA.getZIndex() && (akVarB.getZIndex() != asVarA.getZIndex() || akVarB.getAddIndex() >= asVarA.getAddIndex())) {
                        asVarA.draw(canvas);
                        asVarA = a(it2, rect, anVar);
                    }
                    akVarB.a(canvas);
                    akVarB = b(it, rect, anVar);
                }
            }
        }
    }

    private as a(Iterator<as> it, Rect rect, an anVar) {
        while (it.hasNext()) {
            as next = it.next();
            LatLng position = next.getPosition();
            if (position != null) {
                this.f2630a.b(position.latitude, position.longitude, anVar);
                if (a(rect, anVar.f2618a, anVar.b)) {
                    return next;
                }
            }
        }
        return null;
    }

    public final synchronized ak a(MotionEvent motionEvent) {
        for (int size = this.d.size() - 1; size >= 0; size--) {
            ak akVar = this.d.get(size);
            if (akVar != null && a(akVar.a(), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                return akVar;
            }
        }
        return null;
    }

    public static boolean a(Rect rect, int i, int i2) {
        return rect.contains(i, i2);
    }
}
