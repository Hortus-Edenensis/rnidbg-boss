package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import com.bytedance.sdk.component.utils.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class FlowLightView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f5107a;
    private int b;
    private int fx;
    private int iz;
    private Bitmap jk;
    private final List<u> k;
    private Xfermode l;
    private PorterDuff.Mode mv;
    private int n;
    Rect nr;
    private int pn;
    private LinearGradient s;
    private Paint t;
    Rect u;
    private int x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private int nr = 0;
        private final int u;

        public u(int i) {
            this.u = i;
        }

        public void u() {
            this.nr += this.u;
        }
    }

    public FlowLightView(Context context) {
        super(context);
        this.mv = PorterDuff.Mode.DST_IN;
        this.k = new ArrayList();
        u();
    }

    private void u() {
        this.fx = q.pn(getContext(), "tt_splash_unlock_image_arrow");
        this.b = Color.parseColor("#00ffffff");
        this.pn = Color.parseColor("#ffffffff");
        int color = Color.parseColor("#00ffffff");
        this.iz = color;
        this.x = 10;
        this.n = 40;
        this.f5107a = new int[]{this.b, this.pn, color};
        setLayerType(1, null);
        this.t = new Paint(1);
        this.jk = BitmapFactory.decodeResource(getResources(), this.fx);
        this.l = new PorterDuffXfermode(this.mv);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.jk, this.u, this.nr, this.t);
        canvas.save();
        Iterator<u> it = this.k.iterator();
        while (it.hasNext()) {
            u next = it.next();
            this.s = new LinearGradient(next.nr, 0.0f, next.nr + this.n, this.x, this.f5107a, (float[]) null, Shader.TileMode.CLAMP);
            this.t.setColor(-1);
            this.t.setShader(this.s);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.t);
            this.t.setShader(null);
            next.u();
            if (next.nr > getWidth()) {
                it.remove();
            }
        }
        this.t.setXfermode(this.l);
        canvas.drawBitmap(this.jk, this.u, this.nr, this.t);
        this.t.setXfermode(null);
        canvas.restore();
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.jk == null) {
            return;
        }
        this.u = new Rect(0, 0, this.jk.getWidth(), this.jk.getHeight());
        this.nr = new Rect(0, 0, getWidth(), getHeight());
    }

    public void u(int i) {
        this.k.add(new u(i));
        postInvalidate();
    }
}
