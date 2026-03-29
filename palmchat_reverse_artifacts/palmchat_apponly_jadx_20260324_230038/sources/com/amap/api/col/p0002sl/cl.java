package com.amap.api.col.p0002sl;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class cl extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f2673a;
    private Bitmap b;
    private Bitmap c;
    private Bitmap d;
    private Paint e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private float q;
    private float r;
    private boolean s;

    public cl(Context context) {
        InputStream inputStream;
        super(context);
        this.e = new Paint();
        this.f = false;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 10;
        this.k = 0;
        this.l = 0;
        this.m = 10;
        this.n = 8;
        this.o = 0;
        this.p = false;
        this.q = 0.0f;
        this.r = 0.0f;
        this.s = true;
        AssetManager assets = context.getResources().getAssets();
        InputStream inputStreamOpen = null;
        try {
            InputStream inputStreamOpen2 = assets.open("ap2d.data");
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen2);
                this.c = bitmapDecodeStream;
                this.f2673a = ct.a(bitmapDecodeStream, z.f3056a);
                inputStreamOpen2.close();
                inputStreamOpen = assets.open("ap12d.data");
                Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(inputStreamOpen);
                this.d = bitmapDecodeStream2;
                this.b = ct.a(bitmapDecodeStream2, z.f3056a);
                inputStreamOpen.close();
                this.h = this.b.getWidth();
                this.g = this.b.getHeight();
                this.e.setAntiAlias(true);
                this.e.setColor(-16777216);
                this.e.setStyle(Paint.Style.STROKE);
                try {
                    inputStreamOpen2.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    inputStreamOpen.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = inputStreamOpen;
                inputStreamOpen = inputStreamOpen2;
                try {
                    hd.c(th, "WaterMarkerView", "create");
                    th.printStackTrace();
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                } finally {
                }
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
        }
    }

    private Bitmap e() {
        return this.f ? this.b : this.f2673a;
    }

    private void f() {
        int i = this.l;
        if (i == 0) {
            h();
        } else if (i == 2) {
            g();
        }
        this.j = this.m;
        int height = (getHeight() - this.n) - this.g;
        this.k = height;
        if (this.j < 0) {
            this.j = 0;
        }
        if (height < 0) {
            this.k = 0;
        }
    }

    private void g() {
        if (this.s) {
            this.m = (int) (getWidth() * this.q);
        } else {
            this.m = (int) ((getWidth() * this.q) - this.h);
        }
        this.n = (int) (getHeight() * this.r);
    }

    private void h() {
        int i = this.i;
        if (i == 1) {
            this.m = (getWidth() - this.h) / 2;
        } else if (i == 2) {
            this.m = (getWidth() - this.h) - 10;
        } else {
            this.m = 10;
        }
        this.n = 8;
    }

    public final int a() {
        return this.i;
    }

    public final void b() {
        try {
            Bitmap bitmap = this.f2673a;
            if (bitmap != null) {
                bitmap.recycle();
            }
            Bitmap bitmap2 = this.b;
            if (bitmap2 != null) {
                bitmap2.recycle();
            }
            this.f2673a = null;
            this.b = null;
            Bitmap bitmap3 = this.c;
            if (bitmap3 != null) {
                bitmap3.recycle();
                this.c = null;
            }
            Bitmap bitmap4 = this.d;
            if (bitmap4 != null) {
                bitmap4.recycle();
                this.d = null;
            }
            this.e = null;
        } catch (Throwable th) {
            hd.c(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    public final Point c() {
        return new Point(this.j, this.k - 2);
    }

    public final void d() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        f();
        postInvalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        try {
            if (getWidth() == 0 || getHeight() == 0 || this.b == null) {
                return;
            }
            if (!this.p) {
                f();
                this.p = true;
            }
            canvas.drawBitmap(e(), this.j, this.k, this.e);
        } catch (Throwable th) {
            hd.c(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }

    private void c(int i) {
        this.l = 1;
        this.m = i;
        d();
    }

    public final void a(boolean z) {
        try {
            this.f = z;
            if (z) {
                this.e.setColor(-1);
            } else {
                this.e.setColor(-16777216);
            }
            invalidate();
        } catch (Throwable th) {
            hd.c(th, "WaterMarkerView", "changeBitmap");
            th.printStackTrace();
        }
    }

    public final void a(int i) {
        this.l = 0;
        this.i = i;
        d();
    }

    public final void a(int i, int i2, int i3, int i4) {
        int i5 = this.h / 2;
        int i6 = this.g / 2;
        int i7 = i3 - i5;
        if (i > i7) {
            i = i7;
        }
        if (i < i5) {
            i = i5;
        }
        if (i2 < i6) {
            i2 = i6;
        }
        int i8 = i4 - i6;
        if (i2 > i8) {
            i2 = i8;
        }
        c(i - i5);
        b((i4 - i2) - i6);
    }

    private void b(int i) {
        this.l = 1;
        this.n = i;
        d();
    }
}
