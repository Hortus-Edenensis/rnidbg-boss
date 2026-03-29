package com.opos.mobad.template.i;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Shader;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class g extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10124a;
    private int b;
    private int c;
    private int d;
    private LinearGradient e;
    private int[] f;
    private float[] g;
    private Paint h;
    private int i;
    private int j;
    private PointF k;
    private PointF l;
    private PointF m;
    private Paint n;
    private int o;
    private int p;
    private Paint q;

    public g(Context context, int i, int i2, int i3) {
        super(context);
        this.f10124a = i;
        this.b = i2;
        this.c = i3;
        this.d = ColorUtils.compositeColors(i2, i3);
        int alphaComponent = ColorUtils.setAlphaComponent(this.f10124a, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD);
        int i4 = this.c;
        this.f = new int[]{i4, i4, this.d, this.b, i4, i4};
        this.g = new float[]{0.01f, 0.18f, 0.38f, 0.7f, 0.92f, 0.1f};
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(alphaComponent);
        this.h.setStyle(Paint.Style.FILL);
        this.h.setAntiAlias(true);
        this.k = new PointF(0.0f, 0.0f);
        this.l = new PointF(0.0f, 0.0f);
        this.m = new PointF(0.0f, 0.0f);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 10.0f);
        Paint paint2 = new Paint();
        this.n = paint2;
        paint2.setAntiAlias(true);
        this.n.setStyle(Paint.Style.FILL);
        this.n.setStrokeWidth(iA);
        float[] fArr = {0.0f, 0.35f, 0.8f};
        ColorUtils.colorToHSL(this.f10124a, fArr);
        int iHSLToColor = ColorUtils.HSLToColor(fArr);
        Paint paint3 = new Paint();
        this.q = paint3;
        paint3.setAntiAlias(true);
        this.q.setStrokeWidth(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f));
        this.q.setColor(iHSLToColor);
        this.q.setStyle(Paint.Style.STROKE);
        this.j = com.opos.cmn.an.h.f.a.a(getContext(), 68.0f);
        this.o = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        this.p = com.opos.cmn.an.h.f.a.a(getContext(), 9.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LinearGradient linearGradient = new LinearGradient(0.0f, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), this.f, this.g, Shader.TileMode.REPEAT);
        this.e = linearGradient;
        this.n.setShader(linearGradient);
        Path path = new Path();
        PointF pointF = this.k;
        path.moveTo(pointF.x, pointF.y);
        PointF pointF2 = this.m;
        float f = pointF2.x;
        float f2 = pointF2.y;
        PointF pointF3 = this.l;
        path.quadTo(f, f2, pointF3.x, pointF3.y);
        path.lineTo(this.l.x, getMeasuredHeight());
        path.lineTo(0.0f, getMeasuredHeight());
        path.close();
        canvas.drawPath(path, this.h);
        Path path2 = new Path();
        PointF pointF4 = this.k;
        path2.moveTo(pointF4.x, pointF4.y);
        PointF pointF5 = this.m;
        float f3 = pointF5.x;
        float f4 = pointF5.y;
        PointF pointF6 = this.l;
        path2.quadTo(f3, f4, pointF6.x, pointF6.y);
        path2.lineTo(this.l.x, this.o - this.p);
        PointF pointF7 = this.m;
        float f5 = pointF7.x;
        float f6 = pointF7.y;
        int i = this.o;
        PointF pointF8 = this.k;
        path2.quadTo(f5, f6 + i, pointF8.x, (pointF8.y + i) - this.p);
        path2.close();
        canvas.drawPath(path2, this.n);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = i / 2;
        this.i = i5;
        PointF pointF = this.k;
        pointF.x = 0.0f;
        pointF.y = 0.0f;
        PointF pointF2 = this.l;
        pointF2.x = i;
        pointF2.y = 0.0f;
        PointF pointF3 = this.m;
        pointF3.x = i5;
        pointF3.y = this.j;
    }
}
