package com.amap.api.col.p0002sl;

import android.graphics.Canvas;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.GroundOverlayOptions;
import com.amap.api.maps2d.model.PolygonOptions;
import com.amap.api.maps2d.model.PolylineOptions;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class ae {
    private static int b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ah f2613a;
    private CopyOnWriteArrayList<am> c = new CopyOnWriteArrayList<>();
    private a d = new a(this, 0);
    private Handler e = new Handler();
    private Runnable f = new Runnable() { // from class: com.amap.api.col.2sl.ae.1
        @Override // java.lang.Runnable
        public final synchronized void run() {
            try {
                Object[] array = ae.this.c.toArray();
                Arrays.sort(array, ae.this.d);
                ae.this.c.clear();
                for (Object obj : array) {
                    ae.this.c.add((am) obj);
                }
            } catch (Throwable th) {
                hd.c(th, "MapOverlayImageView", "changeOverlayIndex");
            }
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Comparator<Object> {
        private a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            am amVar = (am) obj;
            am amVar2 = (am) obj2;
            if (amVar == null || amVar2 == null) {
                return 0;
            }
            try {
                if (amVar.getZIndex() > amVar2.getZIndex()) {
                    return 1;
                }
                return amVar.getZIndex() < amVar2.getZIndex() ? -1 : 0;
            } catch (Exception e) {
                ct.a(e, "GLOverlayLayer", "compare");
                return 0;
            }
        }

        public /* synthetic */ a(ae aeVar, byte b) {
            this();
        }
    }

    public ae(ah ahVar) {
        this.f2613a = ahVar;
    }

    private am c(String str) throws RemoteException {
        for (am amVar : this.c) {
            if (amVar != null && amVar.getId().equals(str)) {
                return amVar;
            }
        }
        return null;
    }

    public static synchronized String a(String str) {
        b++;
        return str + b;
    }

    public final void b() {
        try {
            Iterator<am> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            a();
        } catch (Exception e) {
            ct.a(e, "GLOverlayLayer", "destory");
            Log.d("amapApi", "GLOverlayLayer destory erro" + e.getMessage());
        }
    }

    private void c() {
        this.e.removeCallbacks(this.f);
        this.e.postDelayed(this.f, 10L);
    }

    public final void a() {
        Iterator<am> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        try {
            Iterator<am> it2 = this.c.iterator();
            while (it2.hasNext()) {
                it2.next().destroy();
            }
            this.c.clear();
        } catch (Exception e) {
            ct.a(e, "GLOverlayLayer", "clear");
            Log.d("amapApi", "GLOverlayLayer clear erro" + e.getMessage());
        }
    }

    public final boolean b(String str) throws RemoteException {
        try {
            am amVarC = c(str);
            if (amVarC != null) {
                return this.c.remove(amVarC);
            }
            return false;
        } catch (Throwable th) {
            ct.a(th, "GLOverlayLayer", "removeOverlay");
            return false;
        }
    }

    private void a(am amVar) throws RemoteException {
        try {
            b(amVar.getId());
            this.c.add(amVar);
            c();
        } catch (Throwable th) {
            ct.a(th, "GLOverlayLayer", "addOverlay");
        }
    }

    public final void a(Canvas canvas) {
        Object[] array = this.c.toArray();
        Arrays.sort(array, this.d);
        this.c.clear();
        for (Object obj : array) {
            try {
                this.c.add((am) obj);
            } catch (Throwable th) {
                ct.a(th, "GLOverlayLayer", MediationConstant.RIT_TYPE_DRAW);
            }
        }
        int size = this.c.size();
        for (am amVar : this.c) {
            try {
                if (amVar.isVisible()) {
                    if (size > 20) {
                        if (amVar.a()) {
                            amVar.a(canvas);
                        }
                    } else {
                        amVar.a(canvas);
                    }
                }
            } catch (RemoteException e) {
                ct.a(e, "GLOverlayLayer", MediationConstant.RIT_TYPE_DRAW);
            }
        }
    }

    public final synchronized ap a(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        bo boVar = new bo(this.f2613a);
        boVar.setColor(polylineOptions.getColor());
        boVar.setDottedLine(polylineOptions.isDottedLine());
        boVar.setGeodesic(polylineOptions.isGeodesic());
        boVar.setPoints(polylineOptions.getPoints());
        boVar.setVisible(polylineOptions.isVisible());
        boVar.setWidth(polylineOptions.getWidth());
        boVar.setZIndex(polylineOptions.getZIndex());
        a(boVar);
        return boVar;
    }

    public final synchronized ao a(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        bn bnVar = new bn(this.f2613a);
        bnVar.setFillColor(polygonOptions.getFillColor());
        bnVar.setPoints(polygonOptions.getPoints());
        bnVar.setVisible(polygonOptions.isVisible());
        bnVar.setStrokeWidth(polygonOptions.getStrokeWidth());
        bnVar.setZIndex(polygonOptions.getZIndex());
        bnVar.setStrokeColor(polygonOptions.getStrokeColor());
        a(bnVar);
        return bnVar;
    }

    public final synchronized ai a(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        x xVar = new x(this.f2613a);
        xVar.setFillColor(circleOptions.getFillColor());
        xVar.setCenter(circleOptions.getCenter());
        xVar.setVisible(circleOptions.isVisible());
        xVar.setStrokeWidth(circleOptions.getStrokeWidth());
        xVar.setZIndex(circleOptions.getZIndex());
        xVar.setStrokeColor(circleOptions.getStrokeColor());
        xVar.setRadius(circleOptions.getRadius());
        a(xVar);
        return xVar;
    }

    public final synchronized aj a(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        ag agVar = new ag(this.f2613a);
        agVar.setAnchor(groundOverlayOptions.getAnchorU(), groundOverlayOptions.getAnchorV());
        agVar.setDimensions(groundOverlayOptions.getWidth(), groundOverlayOptions.getHeight());
        agVar.setImage(groundOverlayOptions.getImage());
        agVar.setPosition(groundOverlayOptions.getLocation());
        agVar.setPositionFromBounds(groundOverlayOptions.getBounds());
        agVar.setBearing(groundOverlayOptions.getBearing());
        agVar.setTransparency(groundOverlayOptions.getTransparency());
        agVar.setVisible(groundOverlayOptions.isVisible());
        agVar.setZIndex(groundOverlayOptions.getZIndex());
        a(agVar);
        return agVar;
    }
}
