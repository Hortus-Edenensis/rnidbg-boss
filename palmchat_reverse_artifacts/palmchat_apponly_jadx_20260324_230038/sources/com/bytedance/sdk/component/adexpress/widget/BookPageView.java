package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BookPageView extends View {
    Point b;
    Point fx;
    Point iz;
    Paint nr;
    Point pn;
    Paint u;
    Point x;

    public BookPageView(Context context) {
        super(context);
        this.u = new Paint();
        this.nr = new Paint();
        this.fx = new Point();
        this.b = new Point();
        this.pn = new Point();
        this.iz = new Point();
        this.x = new Point();
        this.u.setColor(-16711936);
        this.u.setTextSize(25.0f);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.BookPageView.1
            @Override // java.lang.Runnable
            public void run() {
                BookPageView.this.fx.x = r0.getWidth() - 10;
                BookPageView.this.fx.y = r0.getHeight() - 10;
                BookPageView.this.nr.setShader(new LinearGradient(0.0f, 0.0f, BookPageView.this.getWidth(), BookPageView.this.getHeight(), -7829368, -12303292, Shader.TileMode.MIRROR));
                BookPageView.this.nr.setStyle(Paint.Style.FILL_AND_STROKE);
                BookPageView.this.nr.setStrokeWidth(6.0f);
                BookPageView.this.nr.setShadowLayer(10.0f, 5.0f, 5.0f, -1);
            }
        });
    }

    public Path getFilterAreaPath() {
        Path path = new Path();
        Point point = this.b;
        path.moveTo(point.x, point.y);
        Point point2 = this.iz;
        path.lineTo(point2.x, point2.y);
        Point point3 = this.x;
        path.lineTo(point3.x, point3.y);
        path.close();
        return path;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        u();
        Path path = new Path();
        Point point = this.iz;
        path.moveTo(point.x, point.y);
        Point point2 = this.fx;
        path.lineTo(point2.x, point2.y);
        Point point3 = this.x;
        path.lineTo(point3.x, point3.y);
        path.close();
        canvas.drawPath(path, this.nr);
    }

    public void u(Point point) {
        Point point2 = this.fx;
        point2.x = point.x;
        point2.y = point.y;
        invalidate();
    }

    private void u() {
        this.b.x = getWidth();
        this.b.y = getHeight();
        Point point = this.pn;
        Point point2 = this.fx;
        int i = point2.x;
        Point point3 = this.b;
        int i2 = (i + point3.x) / 2;
        point.x = i2;
        int i3 = (point2.y + point3.y) / 2;
        point.y = i3;
        Point point4 = this.iz;
        int i4 = point3.y;
        point4.x = i2 - (((i4 - i3) * (i4 - i3)) / (point3.x - i2));
        point4.y = i4;
        Point point5 = this.x;
        point5.x = point3.x;
        int i5 = point.y;
        int i6 = point3.x;
        int i7 = point.x;
        point5.y = i5 - (((i6 - i7) * (i6 - i7)) / (point3.y - i5));
    }
}
