package com.amap.api.col.p0002sl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.interfaces.IOverlay;
import com.amap.api.maps2d.AMapUtils;
import com.amap.api.maps2d.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class x implements ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f3052a = null;
    private double b = 0.0d;
    private float c = 10.0f;
    private int d = -16777216;
    private int e = 0;
    private float f = 0.0f;
    private boolean g = true;
    private String h;
    private ah i;

    public x(ah ahVar) {
        this.i = ahVar;
        try {
            this.h = getId();
        } catch (RemoteException e) {
            ct.a(e, "CircleDelegateImp", "CircleDelegateIme");
        }
    }

    @Override // com.amap.api.col.p0002sl.am
    public final boolean a() {
        return true;
    }

    @Override // com.amap.api.interfaces.ICircle
    public final boolean contains(LatLng latLng) throws RemoteException {
        return this.b >= ((double) AMapUtils.calculateLineDistance(this.f3052a, latLng));
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void destroy() {
        this.f3052a = null;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.amap.api.interfaces.ICircle
    public final LatLng getCenter() throws RemoteException {
        return this.f3052a;
    }

    @Override // com.amap.api.interfaces.ICircle
    public final int getFillColor() throws RemoteException {
        return this.e;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final String getId() throws RemoteException {
        if (this.h == null) {
            this.h = ae.a("Circle");
        }
        return this.h;
    }

    @Override // com.amap.api.interfaces.ICircle
    public final double getRadius() throws RemoteException {
        return this.b;
    }

    @Override // com.amap.api.interfaces.ICircle
    public final int getStrokeColor() throws RemoteException {
        return this.d;
    }

    @Override // com.amap.api.interfaces.ICircle
    public final float getStrokeWidth() throws RemoteException {
        return this.c;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final float getZIndex() throws RemoteException {
        return this.f;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final int hashCodeRemote() throws RemoteException {
        return 0;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final boolean isVisible() throws RemoteException {
        return this.g;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void remove() throws RemoteException {
        this.i.removeGLOverlay(getId());
        this.i.postInvalidate();
    }

    @Override // com.amap.api.interfaces.ICircle
    public final void setCenter(LatLng latLng) throws RemoteException {
        this.f3052a = latLng;
    }

    @Override // com.amap.api.interfaces.ICircle
    public final void setFillColor(int i) throws RemoteException {
        this.e = i;
    }

    @Override // com.amap.api.interfaces.ICircle
    public final void setRadius(double d) throws RemoteException {
        this.b = d;
    }

    @Override // com.amap.api.interfaces.ICircle
    public final void setStrokeColor(int i) throws RemoteException {
        this.d = i;
    }

    @Override // com.amap.api.interfaces.ICircle
    public final void setStrokeWidth(float f) throws RemoteException {
        this.c = f;
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void setVisible(boolean z) throws RemoteException {
        this.g = z;
        this.i.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IOverlay
    public final void setZIndex(float f) throws RemoteException {
        this.f = f;
        this.i.postInvalidate();
    }

    @Override // com.amap.api.col.p0002sl.am
    public final void a(Canvas canvas) throws RemoteException {
        if (getCenter() == null || this.b <= 0.0d || !isVisible()) {
            return;
        }
        float fA = this.i.a().b.a((float) getRadius());
        LatLng latLng = this.f3052a;
        this.i.c().a(new af((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d)), new Point());
        Paint paint = new Paint();
        paint.setColor(getFillColor());
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(r2.x, r2.y, fA, paint);
        paint.setColor(getStrokeColor());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(getStrokeWidth());
        canvas.drawCircle(r2.x, r2.y, fA, paint);
    }
}
