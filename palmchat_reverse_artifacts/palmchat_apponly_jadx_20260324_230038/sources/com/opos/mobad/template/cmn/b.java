package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.heytap.msp.mobad.api.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b extends View {
    private static int o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9365a;
    public final int b;
    private Paint c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private Bitmap l;
    private int m;
    private int n;
    private float p;
    private a q;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9366a;
        public final int b;
        public final int c;

        public a(int i, int i2, int i3) {
            this.f9366a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    public b(Context context, a aVar, int i) {
        super(context);
        this.n = 0;
        this.p = 1.0f;
        this.m = i;
        o = com.opos.cmn.an.h.f.a.a(context, aVar.b);
        this.q = aVar;
        this.b = aVar.f9366a;
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        int i2 = this.m;
        if (i2 == 1) {
            setBackgroundResource(R.color.opos_mobad_root_bg_color);
            this.n = com.opos.cmn.an.h.f.a.a(getContext(), 0.6f);
            this.c.setColor(context.getResources().getColor(R.color.opos_mobad_stroke_icon_color));
        } else {
            setBackgroundColor(-1);
            if (i2 != 2) {
                this.c.setStyle(Paint.Style.FILL);
                this.c.setColor(486539264);
                a(this.p, this.q);
            }
            this.n = com.opos.cmn.an.h.f.a.a(getContext(), 0.6f);
            this.c.setColor(436207616);
        }
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.n);
        a(this.p, this.q);
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2, int i3) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, i2, i3);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        float f = i;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap;
    }

    private Bitmap b(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = i / width;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width = getWidth() / o;
        if (this.p != width) {
            com.opos.cmn.an.f.a.a("cell icon", " mScale " + this.p + " scale " + width);
            a(width, this.q);
        }
        a(canvas);
        super.onDraw(canvas);
    }

    public static b a(Context context) {
        return new b(context, new a(121, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, 169), 0);
    }

    public static b b(Context context) {
        return new b(context, new a(128, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT), 0);
    }

    public static b a(Context context, int i) {
        return new b(context, new a(100, 256, 144), i);
    }

    private void a(float f, a aVar) {
        this.d = com.opos.cmn.an.h.f.a.a(getContext(), (aVar.b * f) / 2.0f);
        this.e = com.opos.cmn.an.h.f.a.a(getContext(), (aVar.c * f) / 2.0f);
        this.f9365a = com.opos.cmn.an.h.f.a.a(getContext(), this.b * f);
        this.f = (com.opos.cmn.an.h.f.a.a(getContext(), aVar.b * f) - this.f9365a) / 2;
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), aVar.c * f);
        int i = this.f9365a;
        int i2 = (iA - i) / 2;
        this.g = i2;
        this.h = this.f + i;
        this.i = i2 + i;
        this.j = i + com.opos.cmn.an.h.f.a.a(getContext(), f * 10.0f);
    }

    public void a(Bitmap bitmap, int i) {
        if (bitmap == null) {
            com.opos.cmn.an.f.a.b("", "null bitmap");
            return;
        }
        this.k = com.opos.cmn.an.h.f.a.a(getContext(), i);
        Bitmap bitmapB = b(bitmap, this.f9365a);
        int i2 = this.k;
        int i3 = this.f9365a;
        this.l = a(bitmapB, i2, i3, i3);
        invalidate();
    }

    private void a(Canvas canvas) {
        if (this.l == null) {
            com.opos.cmn.an.f.a.a("cell icon", "not set bitmap");
            return;
        }
        int iSave = canvas.save();
        canvas.rotate(-45.0f, this.d, this.e);
        Rect rect = new Rect(0, 0, this.l.getWidth(), this.l.getHeight());
        int i = this.f;
        int i2 = this.j;
        RectF rectF = new RectF(i - i2, this.g - i2, this.h - i2, this.i - i2);
        int i3 = this.k;
        canvas.drawRoundRect(rectF, i3, i3, this.c);
        a(canvas, this.l, rect, rectF);
        float f = this.f;
        int i4 = this.g;
        int i5 = this.j;
        RectF rectF2 = new RectF(f, i4 - i5, this.h, this.i - i5);
        int i6 = this.k;
        canvas.drawRoundRect(rectF2, i6, i6, this.c);
        a(canvas, this.l, rect, rectF2);
        int i7 = this.f;
        int i8 = this.j;
        RectF rectF3 = new RectF(i7 - i8, this.g, this.h - i8, this.i);
        int i9 = this.k;
        canvas.drawRoundRect(rectF3, i9, i9, this.c);
        a(canvas, this.l, rect, rectF3);
        RectF rectF4 = new RectF(this.f, this.g, this.h, this.i);
        int i10 = this.k;
        canvas.drawRoundRect(rectF4, i10, i10, this.c);
        a(canvas, this.l, rect, rectF4);
        int i11 = this.f;
        int i12 = this.j;
        RectF rectF5 = new RectF(i11 + i12, this.g, this.h + i12, this.i);
        int i13 = this.k;
        canvas.drawRoundRect(rectF5, i13, i13, this.c);
        a(canvas, this.l, rect, rectF5);
        float f2 = this.f;
        int i14 = this.g;
        int i15 = this.j;
        RectF rectF6 = new RectF(f2, i14 + i15, this.h, this.i + i15);
        int i16 = this.k;
        canvas.drawRoundRect(rectF6, i16, i16, this.c);
        a(canvas, this.l, rect, rectF6);
        int i17 = this.f;
        int i18 = this.j;
        RectF rectF7 = new RectF(i17 + i18, this.g + i18, this.h + i18, this.i + i18);
        int i19 = this.k;
        canvas.drawRoundRect(rectF7, i19, i19, this.c);
        a(canvas, this.l, rect, rectF7);
        canvas.restoreToCount(iSave);
    }

    private void a(Canvas canvas, Bitmap bitmap, Rect rect, RectF rectF) {
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, rect, rectF, (Paint) null);
        }
    }
}
