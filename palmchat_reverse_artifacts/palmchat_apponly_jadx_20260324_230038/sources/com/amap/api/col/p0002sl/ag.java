package com.amap.api.col.p0002sl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class ag implements aj {
    private ah c;
    private BitmapDescriptor d;
    private LatLng e;
    private float f;
    private float g;
    private LatLngBounds h;
    private float i;
    private float j;
    private String o;
    private Bitmap p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f2617a = 0.01745329251994329d;
    private final double b = 6371000.79d;
    private boolean k = true;
    private float l = 0.0f;
    private float m = 0.5f;
    private float n = 0.5f;

    public ag(ah ahVar) {
        this.c = ahVar;
        try {
            this.o = getId();
        } catch (RemoteException e) {
            ct.a(e, "GroundOverlayDelegateImp", "GroundOverlayDelegateImp");
        }
    }

    private void b() throws RemoteException {
        if (this.e == null) {
            d();
        } else if (this.h == null) {
            c();
        }
    }

    private void c() {
        double dCos = ((double) this.f) / ((Math.cos(this.e.latitude * 0.01745329251994329d) * 6371000.79d) * 0.01745329251994329d);
        double d = ((double) this.g) / 111194.94043265979d;
        try {
            LatLng latLng = this.e;
            LatLng latLng2 = new LatLng(latLng.latitude - (((double) (1.0f - this.n)) * d), latLng.longitude - (((double) this.m) * dCos));
            LatLng latLng3 = this.e;
            this.h = new LatLngBounds(latLng2, new LatLng(latLng3.latitude + (((double) this.n) * d), latLng3.longitude + (((double) (1.0f - this.m)) * dCos)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void d() {
        LatLngBounds latLngBounds = this.h;
        LatLng latLng = latLngBounds.southwest;
        LatLng latLng2 = latLngBounds.northeast;
        double d = latLng.latitude;
        double d2 = d + (((double) (1.0f - this.n)) * (latLng2.latitude - d));
        double d3 = latLng.longitude;
        LatLng latLng3 = new LatLng(d2, d3 + (((double) this.m) * (latLng2.longitude - d3)));
        this.e = latLng3;
        this.f = (float) (Math.cos(latLng3.latitude * 0.01745329251994329d) * 6371000.79d * (latLng2.longitude - latLng.longitude) * 0.01745329251994329d);
        this.g = (float) ((latLng2.latitude - latLng.latitude) * 6371000.79d * 0.01745329251994329d);
    }

    @Override // com.amap.api.col.p0002sl.am
    public final boolean a() {
        if (this.h == null) {
            return false;
        }
        LatLngBounds mapBounds = this.c.getMapBounds();
        return mapBounds == null || mapBounds.contains(this.h) || this.h.intersects(mapBounds);
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void destroy() {
        Bitmap bitmap;
        try {
            remove();
            BitmapDescriptor bitmapDescriptor = this.d;
            if (bitmapDescriptor != null && (bitmap = bitmapDescriptor.getBitmap()) != null) {
                bitmap.recycle();
                this.d = null;
            }
            this.e = null;
            this.h = null;
        } catch (Exception e) {
            ct.a(e, "GroundOverlayDelegateImp", "destroy");
            Log.d("destroy erro", "GroundOverlayDelegateImp destroy");
        }
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public final float getBearing() throws RemoteException {
        return this.i;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public final LatLngBounds getBounds() throws RemoteException {
        return this.h;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public final float getHeight() throws RemoteException {
        return this.g;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final String getId() throws RemoteException {
        if (this.o == null) {
            this.o = ae.a("GroundOverlay");
        }
        return this.o;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public final LatLng getPosition() throws RemoteException {
        return this.e;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public final float getTransparency() throws RemoteException {
        return this.l;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public final float getWidth() throws RemoteException {
        return this.f;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final float getZIndex() throws RemoteException {
        return this.j;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final boolean isVisible() throws RemoteException {
        return this.k;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void remove() throws RemoteException {
        this.c.removeGLOverlay(getId());
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public final void setAnchor(float f, float f2) throws RemoteException {
        this.m = f;
        this.n = f2;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public final void setBearing(float f) throws RemoteException {
        float f2 = (((-f) % 360.0f) + 360.0f) % 360.0f;
        Double.doubleToLongBits(this.i);
        Double.doubleToLongBits(f2);
        this.i = f2;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public final void setDimensions(float f) throws RemoteException {
        if (f <= 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Width must be non-negative");
        }
        this.f = f;
        this.g = f;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public final void setImage(BitmapDescriptor bitmapDescriptor) throws RemoteException {
        this.d = bitmapDescriptor;
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public final void setPosition(LatLng latLng) throws RemoteException {
        LatLng latLng2 = this.e;
        if (latLng2 == null || latLng2.equals(latLng)) {
            this.e = latLng;
        } else {
            this.e = latLng;
            c();
        }
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public final void setPositionFromBounds(LatLngBounds latLngBounds) throws RemoteException {
        LatLngBounds latLngBounds2 = this.h;
        if (latLngBounds2 == null || latLngBounds2.equals(latLngBounds)) {
            this.h = latLngBounds;
        } else {
            this.h = latLngBounds;
            d();
        }
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public final void setTransparency(float f) throws RemoteException {
        if (f < 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Transparency must be in the range [0..1]");
        }
        this.l = f;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void setVisible(boolean z) throws RemoteException {
        this.k = z;
        this.c.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void setZIndex(float f) throws RemoteException {
        this.j = f;
        this.c.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IGroundOverlay
    public final void setDimensions(float f, float f2) throws RemoteException {
        if (f <= 0.0f || f2 <= 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Width and Height must be non-negative");
        }
        this.f = f;
        this.g = f2;
    }

    @Override // com.amap.api.col.p0002sl.am
    public final void a(Canvas canvas) throws RemoteException {
        if (this.k) {
            if ((this.e == null && this.h == null) || this.d == null) {
                return;
            }
            b();
            if (this.f == 0.0f && this.g == 0.0f) {
                return;
            }
            Bitmap bitmap = this.d.getBitmap();
            this.p = bitmap;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            LatLngBounds latLngBounds = this.h;
            LatLng latLng = latLngBounds.southwest;
            LatLng latLng2 = latLngBounds.northeast;
            LatLng latLng3 = this.e;
            af afVarA = a(latLng);
            af afVarA2 = a(latLng2);
            af afVarA3 = a(latLng3);
            Point point = new Point();
            Point point2 = new Point();
            Point point3 = new Point();
            this.c.c().a(afVarA, point);
            this.c.c().a(afVarA2, point2);
            this.c.c().a(afVarA3, point3);
            Paint paint = new Paint();
            RectF rectF = new RectF(point.x, point2.y, point2.x, point.y);
            paint.setAlpha((int) (255.0f - (this.l * 255.0f)));
            paint.setFilterBitmap(true);
            canvas.save();
            canvas.rotate(this.i, point3.x, point3.y);
            canvas.drawBitmap(this.p, (Rect) null, rectF, paint);
            canvas.restore();
        }
    }

    private static af a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new af((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
    }
}
