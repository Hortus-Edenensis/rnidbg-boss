package com.amap.api.col.p0002sl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class bt extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2659a;
    private int b;
    private m c;
    private Paint d;
    private Paint e;
    private Rect f;

    public bt(Context context, m mVar) {
        super(context);
        this.f2659a = "";
        this.b = 0;
        this.c = mVar;
        this.d = new Paint();
        this.f = new Rect();
        this.d.setAntiAlias(true);
        this.d.setColor(-16777216);
        this.d.setStrokeWidth(z.f3056a * 2.0f);
        this.d.setStyle(Paint.Style.STROKE);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setColor(-16777216);
        this.e.setTextSize(z.f3056a * 20.0f);
    }

    public final void a() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.f2659a = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        try {
            if (!this.c.b().isScaleControlsEnabled()) {
                return;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (this.f2659a.equals("") || (width = this.b) == 0) {
            return;
        }
        try {
            if (width > this.c.getWidth() / 5) {
                width = this.c.getWidth() / 5;
            }
        } catch (Exception e2) {
            ct.a(e2, "ScaleView", "onDraw");
        }
        Point pointE = this.c.e();
        Paint paint = this.e;
        String str = this.f2659a;
        paint.getTextBounds(str, 0, str.length(), this.f);
        int width2 = pointE.x + width > this.c.getWidth() + (-10) ? (this.c.getWidth() - 10) - ((this.f.width() + width) / 2) : pointE.x + ((width - this.f.width()) / 2);
        int iHeight = (pointE.y - this.f.height()) + 5;
        canvas.drawText(this.f2659a, width2, iHeight, this.e);
        int iWidth = width2 - ((width - this.f.width()) / 2);
        int iHeight2 = iHeight + (this.f.height() - 5);
        float f = iWidth;
        float f2 = iHeight2 - 2;
        float f3 = iHeight2 + 2;
        canvas.drawLine(f, f2, f, f3, this.d);
        float f4 = iHeight2;
        float f5 = iWidth + width;
        canvas.drawLine(f, f4, f5, f4, this.d);
        canvas.drawLine(f5, f2, f5, f3, this.d);
    }

    public final void a(String str) {
        this.f2659a = str;
    }

    public final void a(int i) {
        this.b = i;
    }
}
