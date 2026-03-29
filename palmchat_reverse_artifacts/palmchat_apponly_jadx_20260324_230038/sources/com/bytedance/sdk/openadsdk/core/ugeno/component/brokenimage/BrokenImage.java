package com.bytedance.sdk.openadsdk.core.ugeno.component.brokenimage;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.bytedance.adsdk.ugeno.fx;
import com.bytedance.component.sdk.annotation.Keep;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BrokenImage extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5374a;
    private int b;
    private final Path fx;
    private Bitmap iz;
    private Rect jk;
    private float k;
    private Rect l;
    private int mv;
    private float my;
    private boolean n;
    private final Paint nr;
    private int pn;
    private final Random s;
    private Rect t;
    private fx u;
    private Point[][] x;

    public BrokenImage(Context context) {
        super(context);
        this.nr = new Paint();
        this.fx = new Path();
        this.n = false;
        this.f5374a = true;
        this.mv = 0;
        this.s = new SecureRandom();
    }

    private void nr(int i, int i2) {
        this.fx.reset();
        Path path = this.fx;
        Point point = this.x[i][i2];
        path.moveTo(point.x, point.y);
        Path path2 = this.fx;
        int i3 = i2 + 1;
        Point point2 = this.x[i][i3];
        path2.lineTo(point2.x, point2.y);
        Path path3 = this.fx;
        int i4 = i + 1;
        Point point3 = this.x[i4][i3];
        path3.lineTo(point3.x, point3.y);
        Path path4 = this.fx;
        Point point4 = this.x[i4][i2];
        path4.lineTo(point4.x, point4.y);
        this.fx.close();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.pn();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fx fxVar = this.u;
        if (fxVar != null) {
            fxVar.iz();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        super.onDraw(canvas);
        if (this.n) {
            for (int i = 0; i < this.pn; i++) {
                int i2 = 0;
                while (i2 < this.b) {
                    canvas.save();
                    int i3 = this.mv;
                    int i4 = i3 < 5 ? -i3 : i3 - 5;
                    Point[][] pointArr = this.x;
                    int i5 = i2 + 1;
                    int iMax = Math.max(pointArr[i][i5].x, pointArr[i + 1][i5].x);
                    Point[][] pointArr2 = this.x;
                    canvas.translate((((iMax + Math.min(pointArr2[i][i2].x, pointArr2[r7][i2].x)) / 2) - this.k) * 0.01f * this.mv * 0.05f, r7 * i4);
                    canvas.save();
                    nr(i, i2);
                    canvas.clipPath(this.fx);
                    canvas.drawBitmap(this.iz, this.t, this.l, this.nr);
                    canvas.restore();
                    canvas.restore();
                    i2 = i5;
                }
            }
        }
        if (!this.f5374a || this.jk == null || (rect = this.l) == null) {
            return;
        }
        canvas.drawBitmap(this.iz, this.t, rect, this.nr);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.l = new Rect(0, 0, i, i2);
        this.k = i / 2.0f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.k = motionEvent.getX();
            this.my = motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBitmap(Bitmap bitmap) {
        this.iz = bitmap;
        this.jk = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.t = new Rect(0, 0, this.iz.getWidth(), this.iz.getHeight());
        invalidate();
    }

    @Keep
    public void setBrokenProgress(int i) {
        this.mv = i;
        invalidate();
    }

    public void u(int i, int i2) {
        this.b = i;
        this.pn = i2;
        this.l = new Rect(0, 0, getWidth(), getHeight());
        int width = getWidth() / i;
        int height = getHeight() / i2;
        this.x = (Point[][]) Array.newInstance((Class<?>) Point.class, i2 + 1, i + 1);
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = i4 * width;
                int i6 = i3 * height;
                Rect rect = new Rect(i5, i6, i5 + width, i6 + height);
                if (i3 == 0 || i4 == 0) {
                    this.x[i3][i4] = new Point(rect.left, rect.top);
                }
                if (i3 == 0 || i4 == i - 1) {
                    this.x[i3][i4 + 1] = new Point(rect.right, rect.top);
                }
                int i7 = i2 - 1;
                if (i3 == i7 || i4 == 0) {
                    this.x[i3 + 1][i4] = new Point(rect.left, rect.bottom);
                }
                if (i3 == i7 || i4 == i - 1) {
                    this.x[i3 + 1][i4 + 1] = new Point(rect.right, rect.bottom);
                } else {
                    this.x[i3 + 1][i4 + 1] = new Point((int) (rect.right + ((this.s.nextFloat() - 0.5f) * width)), (int) (rect.bottom + ((this.s.nextFloat() - 0.5f) * height)));
                }
            }
        }
        this.n = true;
        invalidate();
    }

    public void u(int i) {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "brokenProgress", 0, getHeight());
        objectAnimatorOfInt.setInterpolator(new AccelerateInterpolator());
        objectAnimatorOfInt.setDuration(i <= 0 ? 600L : i);
        objectAnimatorOfInt.start();
        this.f5374a = false;
    }

    public void u(fx fxVar) {
        this.u = fxVar;
    }
}
