package com.amap.api.col.p0002sl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.interfaces.IMarker;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MarkerOptions;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class bh implements ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f2638a;
    private int e;
    private String f;
    private LatLng g;
    private LatLng h;
    private String i;
    private String j;
    private float k;
    private float l;
    private boolean m;
    private boolean n;
    private bc o;
    private Object p;
    private boolean q;
    private a r;
    private int t;
    private int u;
    private float v;
    private int w;
    private int b = 0;
    private float c = 0.0f;
    private CopyOnWriteArrayList<BitmapDescriptor> d = null;
    private boolean s = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Thread {
        private a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                setName("MarkerThread");
                while (!Thread.currentThread().isInterrupted() && bh.this.d != null && bh.this.d.size() > 1) {
                    if (bh.this.b == bh.this.d.size() - 1) {
                        bh.c(bh.this);
                    } else {
                        bh.d(bh.this);
                    }
                    bh.this.o.a().postInvalidate();
                    try {
                        Thread.sleep(bh.this.e * 250);
                    } catch (InterruptedException e) {
                        ct.a(e, "MarkerDelegateImp", "run");
                    }
                    if (bh.this.d == null) {
                        Thread.currentThread().interrupt();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public /* synthetic */ a(bh bhVar, byte b) {
            this();
        }
    }

    public bh(MarkerOptions markerOptions, bc bcVar) {
        this.e = 20;
        this.k = 0.5f;
        this.l = 1.0f;
        this.m = false;
        this.n = true;
        this.q = false;
        this.o = bcVar;
        this.q = markerOptions.isGps();
        this.v = markerOptions.getZIndex();
        if (markerOptions.getPosition() != null) {
            if (this.q) {
                try {
                    double[] dArrA = mn.a(markerOptions.getPosition().longitude, markerOptions.getPosition().latitude);
                    this.h = new LatLng(dArrA[1], dArrA[0]);
                } catch (Exception e) {
                    ct.a(e, "MarkerDelegateImp", "MarkerDelegateImp");
                    this.h = markerOptions.getPosition();
                }
            }
            this.g = markerOptions.getPosition();
        }
        this.k = markerOptions.getAnchorU();
        this.l = markerOptions.getAnchorV();
        this.n = markerOptions.isVisible();
        this.j = markerOptions.getSnippet();
        this.i = markerOptions.getTitle();
        this.m = markerOptions.isDraggable();
        this.e = markerOptions.getPeriod();
        this.f = getId();
        a(markerOptions.getIcons());
        CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() != 0) {
            return;
        }
        a(markerOptions.getIcon());
    }

    public static /* synthetic */ int c(bh bhVar) {
        bhVar.b = 0;
        return 0;
    }

    public static /* synthetic */ int d(bh bhVar) {
        int i = bhVar.b;
        bhVar.b = i + 1;
        return i;
    }

    private float g() {
        return this.k;
    }

    private float h() {
        return this.l;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void destroy() {
        m mVar;
        CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList;
        Bitmap bitmap;
        try {
            copyOnWriteArrayList = this.d;
        } catch (Exception e) {
            ct.a(e, "MarkerDelegateImp", "destroy");
            Log.d("destroy erro", "MarkerDelegateImp destroy");
        }
        if (copyOnWriteArrayList == null) {
            this.g = null;
            this.p = null;
            this.r = null;
            return;
        }
        for (BitmapDescriptor bitmapDescriptor : copyOnWriteArrayList) {
            if (bitmapDescriptor != null && (bitmap = bitmapDescriptor.getBitmap()) != null) {
                bitmap.recycle();
            }
        }
        this.d = null;
        this.g = null;
        this.p = null;
        this.r = null;
        bc bcVar = this.o;
        if (bcVar == null || (mVar = bcVar.f2630a) == null) {
            return;
        }
        mVar.postInvalidate();
    }

    @Override // com.amap.api.interfaces.IMarker
    public final boolean equalsRemote(IMarker iMarker) {
        return equals(iMarker) || iMarker.getId().equals(getId());
    }

    @Override // com.amap.api.col.p0002sl.al
    public final int getAddIndex() {
        return this.w;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final int getHeight() {
        if (f() != null) {
            return f().getHeight();
        }
        return 0;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final ArrayList<BitmapDescriptor> getIcons() {
        CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return null;
        }
        ArrayList<BitmapDescriptor> arrayList = new ArrayList<>();
        for (BitmapDescriptor bitmapDescriptor : this.d) {
            if (bitmapDescriptor != null) {
                arrayList.add(bitmapDescriptor);
            }
        }
        return arrayList;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final String getId() {
        if (this.f == null) {
            this.f = a("Marker");
        }
        return this.f;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final Object getObject() {
        return this.p;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final int getPeriod() throws RemoteException {
        return this.e;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final LatLng getPosition() {
        if (!this.s) {
            return this.g;
        }
        ab abVar = new ab();
        this.o.f2630a.a(this.t, this.u, abVar);
        return new LatLng(abVar.b, abVar.f2610a);
    }

    @Override // com.amap.api.interfaces.IMarker
    public final LatLng getRealPosition() {
        if (!this.s) {
            return this.q ? this.h : this.g;
        }
        ab abVar = new ab();
        this.o.f2630a.a(this.t, this.u, abVar);
        return new LatLng(abVar.b, abVar.f2610a);
    }

    @Override // com.amap.api.interfaces.IMarker
    public final String getSnippet() {
        return this.j;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final String getTitle() {
        return this.i;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final int getWidth() {
        if (f() != null) {
            return f().getWidth();
        }
        return 0;
    }

    @Override // com.amap.api.col.p0002sl.al, com.amap.api.interfaces.IMarker
    public final float getZIndex() {
        return this.v;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void hideInfoWindow() {
        if (isInfoWindowShown()) {
            this.o.e(this);
        }
    }

    @Override // com.amap.api.interfaces.IMarker
    public final boolean isDraggable() {
        return this.m;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final boolean isInfoWindowShown() {
        return this.o.f(this);
    }

    @Override // com.amap.api.interfaces.IMarker
    public final boolean isViewMode() {
        return this.s;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final boolean isVisible() {
        return this.n;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final boolean remove() {
        return this.o.b(this);
    }

    @Override // com.amap.api.col.p0002sl.al
    public final void setAddIndex(int i) {
        this.w = i;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void setAnchor(float f, float f2) {
        if (this.k == f && this.l == f2) {
            return;
        }
        this.k = f;
        this.l = f2;
        if (isInfoWindowShown()) {
            this.o.e(this);
            this.o.d(this);
        }
        this.o.a().postInvalidate();
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void setDraggable(boolean z) {
        this.m = z;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
                if (copyOnWriteArrayList == null) {
                    return;
                }
                copyOnWriteArrayList.clear();
                this.d.add(bitmapDescriptor);
                if (isInfoWindowShown()) {
                    this.o.e(this);
                    this.o.d(this);
                }
                this.o.a().postInvalidate();
            } catch (Throwable th) {
                ct.a(th, "MarkerDelegateImp", "setIcon");
            }
        }
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void setIcons(ArrayList<BitmapDescriptor> arrayList) throws RemoteException {
        if (arrayList == null) {
            return;
        }
        a(arrayList);
        if (this.r == null) {
            a aVar = new a(this, (byte) 0);
            this.r = aVar;
            aVar.start();
        }
        if (isInfoWindowShown()) {
            this.o.e(this);
            this.o.d(this);
        }
        this.o.a().postInvalidate();
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void setObject(Object obj) {
        this.p = obj;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void setPeriod(int i) throws RemoteException {
        if (i <= 1) {
            this.e = 1;
        } else {
            this.e = i;
        }
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void setPosition(LatLng latLng) {
        if (latLng == null) {
            return;
        }
        if (this.q) {
            try {
                double[] dArrA = mn.a(latLng.longitude, latLng.latitude);
                this.h = new LatLng(dArrA[1], dArrA[0]);
            } catch (Exception e) {
                ct.a(e, "MarkerDelegateImp", "setPosition");
                this.h = latLng;
            }
        }
        this.s = false;
        this.g = latLng;
        this.o.a().postInvalidate();
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void setPositionByPixels(int i, int i2) {
        this.t = i;
        this.u = i2;
        this.s = true;
        if (isInfoWindowShown()) {
            showInfoWindow();
        }
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void setRotateAngle(float f) {
        this.c = (((-f) % 360.0f) + 360.0f) % 360.0f;
        if (isInfoWindowShown()) {
            this.o.e(this);
            this.o.d(this);
        }
        this.o.a().postInvalidate();
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void setSnippet(String str) {
        this.j = str;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void setTitle(String str) {
        this.i = str;
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void setVisible(boolean z) {
        this.n = z;
        if (!z && isInfoWindowShown()) {
            this.o.e(this);
        }
        this.o.a().postInvalidate();
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void setZIndex(float f) {
        this.v = f;
        this.o.d();
    }

    @Override // com.amap.api.interfaces.IMarker
    public final void showInfoWindow() {
        if (isVisible()) {
            this.o.d(this);
        }
    }

    private static String a(String str) {
        f2638a++;
        return str + f2638a;
    }

    private void c() {
        CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null) {
            this.d = new CopyOnWriteArrayList<>();
        } else {
            copyOnWriteArrayList.clear();
        }
    }

    private an d() {
        if (getPosition() == null) {
            return null;
        }
        an anVar = new an();
        try {
            af afVar = this.q ? new af((int) (getRealPosition().latitude * 1000000.0d), (int) (getRealPosition().longitude * 1000000.0d)) : new af((int) (getPosition().latitude * 1000000.0d), (int) (getPosition().longitude * 1000000.0d));
            Point point = new Point();
            this.o.a().c().a(afVar, point);
            anVar.f2618a = point.x;
            anVar.b = point.y;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return anVar;
    }

    private an e() {
        an anVarD = d();
        if (anVarD == null) {
            return null;
        }
        return anVarD;
    }

    private BitmapDescriptor f() {
        CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        if (copyOnWriteArrayList.size() == 0) {
            c();
            this.d.add(BitmapDescriptorFactory.defaultMarker());
        } else if (this.d.get(0) == null) {
            this.d.clear();
            return f();
        }
        return this.d.get(0);
    }

    @Override // com.amap.api.col.p0002sl.ak
    public final ab b() {
        ab abVar = new ab();
        CopyOnWriteArrayList<BitmapDescriptor> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            abVar.f2610a = getWidth() * this.k;
            abVar.b = getHeight() * this.l;
        }
        return abVar;
    }

    private void a(ArrayList<BitmapDescriptor> arrayList) {
        try {
            c();
            if (arrayList != null) {
                for (BitmapDescriptor bitmapDescriptor : arrayList) {
                    if (bitmapDescriptor != null) {
                        this.d.add(bitmapDescriptor.m13clone());
                    }
                }
                if (arrayList.size() > 1 && this.r == null) {
                    a aVar = new a(this, (byte) 0);
                    this.r = aVar;
                    aVar.start();
                }
            }
            this.o.a().postInvalidate();
        } catch (Throwable th) {
            ct.a(th, "MarkerDelegateImp", "setBitmapDescriptor");
        }
    }

    private void a(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            c();
            this.d.add(bitmapDescriptor.m13clone());
        }
        this.o.a().postInvalidate();
    }

    @Override // com.amap.api.col.p0002sl.ak
    public final Rect a() {
        an anVarE = e();
        if (anVarE == null) {
            return new Rect(0, 0, 0, 0);
        }
        try {
            int width = getWidth();
            int height = getHeight();
            Rect rect = new Rect();
            if (this.c == 0.0f) {
                int i = anVarE.b;
                float f = height;
                float f2 = this.l;
                rect.top = (int) (i - (f * f2));
                int i2 = anVarE.f2618a;
                float f3 = this.k;
                float f4 = width;
                rect.left = (int) (i2 - (f3 * f4));
                rect.bottom = (int) (i + (f * (1.0f - f2)));
                rect.right = (int) (i2 + ((1.0f - f3) * f4));
            } else {
                float f5 = width;
                float f6 = height;
                an anVarA = a((-this.k) * f5, (this.l - 1.0f) * f6);
                an anVarA2 = a((-this.k) * f5, this.l * f6);
                an anVarA3 = a((1.0f - this.k) * f5, this.l * f6);
                an anVarA4 = a((1.0f - this.k) * f5, (this.l - 1.0f) * f6);
                rect.top = anVarE.b - Math.max(anVarA.b, Math.max(anVarA2.b, Math.max(anVarA3.b, anVarA4.b)));
                rect.left = anVarE.f2618a + Math.min(anVarA.f2618a, Math.min(anVarA2.f2618a, Math.min(anVarA3.f2618a, anVarA4.f2618a)));
                rect.bottom = anVarE.b - Math.min(anVarA.b, Math.min(anVarA2.b, Math.min(anVarA3.b, anVarA4.b)));
                rect.right = anVarE.f2618a + Math.max(anVarA.f2618a, Math.max(anVarA2.f2618a, Math.max(anVarA3.f2618a, anVarA4.f2618a)));
            }
            return rect;
        } catch (Throwable th) {
            ct.a(th, "MarkerDelegateImp", "getRect");
            return new Rect(0, 0, 0, 0);
        }
    }

    private an a(float f, float f2) {
        float f3 = (float) ((((double) this.c) * 3.141592653589793d) / 180.0d);
        an anVar = new an();
        double d = f;
        double d2 = f3;
        double d3 = f2;
        anVar.f2618a = (int) ((Math.cos(d2) * d) + (Math.sin(d2) * d3));
        anVar.b = (int) ((d3 * Math.cos(d2)) - (d * Math.sin(d2)));
        return anVar;
    }

    @Override // com.amap.api.col.p0002sl.ak
    public final void a(LatLng latLng) {
        if (this.q) {
            this.h = latLng;
        } else {
            this.g = latLng;
        }
        try {
            Point screenLocation = this.o.a().getAMapProjection().toScreenLocation(latLng);
            this.t = screenLocation.x;
            this.u = screenLocation.y;
        } catch (Throwable th) {
            ct.a(th, "MarkerDelegateImp", "setOffSetPosition");
        }
    }

    @Override // com.amap.api.col.p0002sl.ak
    public final void a(Canvas canvas) {
        an anVarE;
        Bitmap bitmap;
        if (!this.n || getPosition() == null || f() == null) {
            return;
        }
        if (isViewMode()) {
            anVarE = new an(this.t, this.u);
        } else {
            anVarE = e();
        }
        ArrayList<BitmapDescriptor> icons = getIcons();
        if (icons == null) {
            return;
        }
        if (icons.size() > 1) {
            bitmap = icons.get(this.b).getBitmap();
        } else {
            bitmap = icons.size() == 1 ? icons.get(0).getBitmap() : null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.save();
        canvas.rotate(this.c, anVarE.f2618a, anVarE.b);
        canvas.drawBitmap(bitmap, anVarE.f2618a - (g() * bitmap.getWidth()), anVarE.b - (h() * bitmap.getHeight()), (Paint) null);
        canvas.restore();
    }
}
