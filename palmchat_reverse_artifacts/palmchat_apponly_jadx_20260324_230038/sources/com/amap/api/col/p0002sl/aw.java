package com.amap.api.col.p0002sl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.amap.api.maps2d.model.TileProvider;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class aw extends ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    be f2620a;
    private String r = "LayerPropertys";
    public String b = "";
    public int c = 19;
    public int d = 3;
    public boolean e = true;
    private boolean s = false;
    public boolean f = false;
    public boolean g = false;
    public boolean h = true;
    public long i = 0;
    public cj j = null;
    TileProvider k = null;
    public int l = -1;
    public String m = "";
    bj n = null;
    ad o = null;
    bw<cb> p = null;

    public aw(be beVar) {
        this.f2620a = beVar;
    }

    public final void a(boolean z) {
        this.s = z;
        if (z) {
            this.q.d();
        } else {
            this.n.a();
            this.q.c();
        }
    }

    @Override // com.amap.api.col.p0002sl.ax
    public final void b() {
        this.q.e();
        this.o.a((bj) null);
        this.n.a();
        this.p.clear();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof aw) {
            return this.b.equals(((aw) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.l;
    }

    public final String toString() {
        return this.b;
    }

    public final boolean a() {
        return this.s;
    }

    @Override // com.amap.api.col.p0002sl.ax
    public final void a(Canvas canvas) {
        int i;
        try {
            bw<cb> bwVar = this.p;
            if (bwVar == null) {
                return;
            }
            for (cb cbVar : bwVar) {
                if (cbVar != null && (i = cbVar.h) >= 0) {
                    Bitmap bitmapA = this.n.a(i);
                    PointF pointFA = this.f2620a.a(cbVar.b, cbVar.c);
                    if (bitmapA != null && pointFA != null) {
                        float f = pointFA.x;
                        int i2 = this.f2620a.f2635a;
                        canvas.drawBitmap(bitmapA, (Rect) null, new RectF(pointFA.x, pointFA.y, f + i2, pointFA.y + i2), (Paint) null);
                    }
                }
            }
        } catch (Throwable th) {
            ct.a(th, this.r, "drawLayer");
        }
    }
}
